package com.hw.controller;

import com.hw.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @GetMapping("/getInfo")
    public User getInfo(){
        Logger logger = LoggerFactory.getLogger(UserController.class);
        User user = new User("123456", "Tom", 18);
        user.setAge(20);
        logger.info(user.toString());
        return user;
    }
}
