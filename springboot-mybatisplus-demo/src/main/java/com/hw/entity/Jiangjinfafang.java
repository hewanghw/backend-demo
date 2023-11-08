package com.hw.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@TableName("jiangjinfafang")
@Data
public class Jiangjinfafang {
    private  String xingming;
    private String  xuehao;
    private String jiangxuejinleixing;
    private Integer fafangjine;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date fafangriqi;
    private String fangfangzhanghao;
}
