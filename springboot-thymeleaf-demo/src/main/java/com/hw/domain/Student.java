package com.hw.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private String id;
    private String name;
    private int age;
    private String grade;
}
