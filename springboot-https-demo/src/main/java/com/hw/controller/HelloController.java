package com.hw.controller;


import org.springframework.web.bind.annotation.*;

import java.util.Date;

//@CrossOrigin(origins = {"http://localhost:80/"})
@RequestMapping("/hello")
@RestController
public class HelloController {

    @GetMapping("/world")
    public String world()  {

        return "hello world!";
    }
}
