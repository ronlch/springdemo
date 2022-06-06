package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base") //RequestMapping at class level
public class _2_PathController {

    // Test URL: http://localhost:8080/base
    // Test URL: http://localhost:8080/base/sub
    
    @RequestMapping()
    public String base() {
        return "Base path!";
    }

    // @RequestMapping(path="sub") > equivalent
    @RequestMapping("sub") //RequestMapping at method level
    public String sub() {
        return "Sub-path!";
    }
}
