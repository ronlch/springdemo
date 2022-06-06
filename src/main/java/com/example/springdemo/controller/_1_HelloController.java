package com.example.springdemo.controller;

//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMethod;

@RestController //Annotation
public class _1_HelloController {

    // Test URL: http://localhost:8080/helloworld
    
    //@GetMapping("/helloworld") > equivalent, similar PostMapping, PutMapping, DeleteMapping
    //@RequestMapping(value="/helloworld", method=RequestMethod.GET) > equivalent
    @RequestMapping("/helloworld") //Default is GET
    public String helloworld() {
        return "Hellow World!";
    }

    // Test URL: http://localhost:8080/hi
    @RequestMapping("/hi")
    public String hi() {
        return "Hi World!";
    }

    // Test URL: http://localhost:8080/hihi
    @RequestMapping("hihi")
    public String hihi() {
        return "Hihi World!";
    }
}
