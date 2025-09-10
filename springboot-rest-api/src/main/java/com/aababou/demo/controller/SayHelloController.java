package com.aababou.demo.controller;

/*
author otman
    */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {

    //HTTP GET REQUEST
    // http://localhost:8080/hello-world

    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello World!";
    }
}
