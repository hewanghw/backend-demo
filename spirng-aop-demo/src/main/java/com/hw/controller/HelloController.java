package com.hw.controller;

import com.hw.customInterface.LogPrinting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        return "hello " + name;
    }
    @LogPrinting
    @GetMapping("/log")
    public String log(){
        return "log printing";
    }
}
