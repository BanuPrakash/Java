package com.example.demosecure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

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
