package com.hw.controller;

import com.hw.domian.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/A")
@RestController
public class AController {

    @GetMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setUsername("xiaoming");
        return user;
    }

    @GetMapping("/selectUser")
    public void selectUser(HttpServletResponse response) throws IOException {
//        response.setHeader("Location", "/B/selectUser");
        response.sendRedirect("/B/selectUser");
//        response.setStatus(301);

    }

}
