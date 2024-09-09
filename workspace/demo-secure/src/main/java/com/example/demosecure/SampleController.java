package com.example.demosecure;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @RequestMapping()
    @GetMapping
    public String general() {
        return  "Spring Security";
    }
    @RequestMapping("/hello")
    @GetMapping()
    public String sayHello(){
        return  "Hello World!!!";
    }

    @RequestMapping("/admin")
    @GetMapping()
    public String sayHelloAdmin(){
        return  "Hello Admin!!!";
    }
}
