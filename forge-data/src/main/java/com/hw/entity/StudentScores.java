package com.hw.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("student_scores")
@Data
public class StudentScores {
    @TableField("class")
    private int class_name;
    private String name;
    private int english;
    private int chinese;
    private int math;
}
