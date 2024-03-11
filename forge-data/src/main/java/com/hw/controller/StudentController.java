package com.hw.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hw.entity.Jiangjinfafang;
import com.hw.entity.StudentScores;
import com.hw.mapper.StudentScoresMapper;
import com.hw.service.IStudentScoresService;
import com.hw.util.DateUtil;
import com.hw.util.PersonUtil;
import com.hw.util.StudentUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class StudentController {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private StudentScoresMapper studentScoresMapper;
    @Autowired
    private IStudentScoresService studentScoresService;
    @GetMapping("/student")
    public boolean banjian() {
        Random random = new Random();
        List<StudentScores> studentScoresList = new ArrayList<>();
        for (int i = 0; i < 300000; i++) {
            StudentScores studentScores = new StudentScores();
            studentScores.setClass_name(1 + random.nextInt(10));
            studentScores.setName(PersonUtil.randomChineseName());
            studentScores.setEnglish( 1 + random.nextInt(100));
            studentScores.setChinese(1 + random.nextInt(100));
            studentScores.setMath(1 + random.nextInt(100));
            studentScoresList.add(studentScores);
        }
        studentScoresService.saveBatch(studentScoresList);
        return true;
    }
}
