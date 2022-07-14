package com.example.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Use @Controller instead of @RestController for Thymeleaf
// Use @GetMapping instead of @RequestMapping for Thymeleaf
@Controller
public class _6_LoginController {
    
    // Test URL: http://localhost:8080/login
    // @GetMapping("login")
    @RequestMapping("login")
    public String login() {
        return "index";
    }
}
