package com.spring.orderapp.security.service;

import com.spring.orderapp.security.SignUpRequest;
import com.spring.orderapp.security.dao.UserDao;
import com.spring.orderapp.security.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

// username/pwd --> AuthenticationController --> AuthenticationService
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // on register sending token --> optional
    public String register(SignUpRequest request) {
        User user = User.builder().
                username(request.getUsername()).
                email(request.getEmail()).
                password(passwordEncoder.encode(request.getPassword())).
                roles(request.getRoles()).build();
        userDao.save(user);
        return jwtService.generateToken(user);
    }

    public String login( String email,  String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        User user = userDao.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Invalid email/password"));
        System.out.println(user);
        return  jwtService.generateToken(user);
    }
}
