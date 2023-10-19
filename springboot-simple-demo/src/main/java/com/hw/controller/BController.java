package com.hw.controller;

import com.hw.domian.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/B")
@RestController
public class BController {
    @GetMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setUsername("lihua");
        return user;
    }

    @GetMapping("/selectUser")
    public User selectUser(){
        User user = new User();
        user.setUsername("redirectResult");
        return user;
    }

}
