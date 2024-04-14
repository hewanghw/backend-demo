package com.hw.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/test")
    public ResponseEntity<Map<String, Object>> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "FAIL");
        map.put("message", "失败!");
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/ok")
    public boolean ok(HttpServletRequest request) {
        String header = request.getHeader("Cookie");
        Enumeration<String> cookie = request.getHeaders("Cookie");
        System.out.println(header);
        System.out.println("=================");
        while(cookie.hasMoreElements()){
            //遍历枚举中存储的每一个元素
            String value = cookie.nextElement();
            System.out.println(value);//将值输出
        }


        System.out.println("!!!!!!!!!!!!!!!!!");
        String h = request.getHeader("Accept-Encoding");
        Enumeration<String> a = request.getHeaders("Accept-Encoding");
        System.out.println(h);
        System.out.println("=================");
        while(a.hasMoreElements()){
            //遍历枚举中存储的每一个元素
            String value = a.nextElement();
            System.out.println(value);//将值输出
        }

        return true;




    }
}
