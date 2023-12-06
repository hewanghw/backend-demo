package com.hw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hw.mapper")
@SpringBootApplication
public class ForgeDataDemo {
    public static void main(String[] args) {
        SpringApplication.run(ForgeDataDemo.class, args);
    }
}
