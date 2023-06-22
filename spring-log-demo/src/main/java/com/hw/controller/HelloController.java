package com.hw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        if(name.substring(1).equals("om"))
            return "*om";
        return "hello " + name;
    }
}