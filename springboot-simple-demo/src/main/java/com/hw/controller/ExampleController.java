package com.hw.controller;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RestController
public class ExampleController {
    @GetMapping("/example")
    public String example(HttpServletRequest request) {
        String agent = request.getHeader("User-Agent");
        String userAgent = "";
        if(agent != null){
            userAgent = agent.toLowerCase();
        }

        System.out.println(userAgent);
        if (userAgent.contains("mobile") || userAgent.contains("android") || userAgent.contains("phone") || userAgent.contains("ipad")) {
            // 移动端访问
            return "mobile";
        } else {
            // PC端或其他设备访问
            return "pc";
        }

        String remoteUser = request.getRemoteUser();
        AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
    }
}