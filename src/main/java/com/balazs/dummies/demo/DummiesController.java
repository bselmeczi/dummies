package com.balazs.dummies.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummiesController {

    @Value("${greeting.message.from.env}")
    private String greetingMessage;

    @GetMapping("/hello")
    public String hello() {
        return greetingMessage;
    }

}