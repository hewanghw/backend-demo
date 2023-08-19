package com.hw.controller;


import org.springframework.web.bind.annotation.*;

import java.util.Date;

//@CrossOrigin(origins = {"http://localhost:80/"})
@RequestMapping("/hello")
@RestController
public class HelloController {

    @GetMapping("/world/{a}")
    public String world(@PathVariable("a") String a) throws InterruptedException {
        System.out.println("当前请求 " + a +  " , 使用线程: " + Thread.currentThread().getName()
        + "，当前时间是: " + new Date() );
        Thread.sleep(5000);
        return "hello world!";
    }
}
