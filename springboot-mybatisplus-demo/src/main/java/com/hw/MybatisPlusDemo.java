package com.hw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hw.mapper")
@SpringBootApplication
public class MybatisPlusDemo {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusDemo.class, args);
    }
}