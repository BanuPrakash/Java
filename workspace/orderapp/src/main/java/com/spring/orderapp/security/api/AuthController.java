package com.spring.orderapp.security.api;

import com.spring.orderapp.security.SignUpRequest;
import com.spring.orderapp.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("register")
    public String register(@RequestBody SignUpRequest request) {
        System.out.println("Called " + request);
        return service.register(request);
    }
}
