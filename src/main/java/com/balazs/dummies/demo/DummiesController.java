package com.balazs.dummies.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummiesController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Docker! Istvan loves shiny things!!!";
    }
}