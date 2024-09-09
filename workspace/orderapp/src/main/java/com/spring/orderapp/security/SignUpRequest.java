package com.spring.orderapp.security;

import com.spring.orderapp.security.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String email;
    private String username;
    private  String password;
    private Set<Role> roles;
}
