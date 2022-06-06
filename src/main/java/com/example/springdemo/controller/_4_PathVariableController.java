package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PathVar")
public class _4_PathVariableController {
    
    // Test URL: http://localhost:8080/PathVar/1
    // @PathVariable

    // @GetMapping(path="/{input1}") > equivalent
    @GetMapping("/{input1}")
    public String test(@PathVariable String input1) {
        return String.format("Input1= %s", input1);
    }

    // Test URL: http://localhost:8080/PathVar/level2/1

    @GetMapping("/level2/{input2}")
    public String test2(@PathVariable String input2) {
        return String.format("Input2= %s", input2);
    }
}
