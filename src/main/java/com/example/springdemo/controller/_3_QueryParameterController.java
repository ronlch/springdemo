package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/QueryParam")
public class _3_QueryParameterController {
    
    // Test URL: http://localhost:8080/QueryParam?input1=a&input2=b
    // Both input must be entered
    // @RequestParam

    @RequestMapping()
    public String test(@RequestParam String input1, @RequestParam String input2) {
        return String.format("Input1= %s and Input2= %s", input1, input2);
    }

}
