package com.spring.orderapp.security.service;

import com.spring.orderapp.security.SignUpRequest;
import com.spring.orderapp.security.dao.UserDao;
import com.spring.orderapp.security.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// username/pwd --> AuthenticationController --> AuthenticationService
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

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
}
