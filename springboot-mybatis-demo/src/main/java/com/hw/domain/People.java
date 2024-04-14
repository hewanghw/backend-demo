package com.hw.domain;

import lombok.Data;

import java.util.Date;

@Data
public class People {
    private Integer id;
    private String name;
    private Date createTime;
    private Date updateTime;
}
