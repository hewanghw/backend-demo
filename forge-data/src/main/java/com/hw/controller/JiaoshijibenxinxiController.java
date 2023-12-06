package com.hw.controller;

import com.hw.entity.Jiaoshijibenxinxi;
import com.hw.mapper.JiaoshijibenxinxiMapper;
import com.hw.util.DateUtil;
import com.hw.util.PersonUtil;
import com.hw.util.SchoolUtil;
import com.hw.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

@RestController
public class JiaoshijibenxinxiController {
    @Autowired
    private JiaoshijibenxinxiMapper jiaoshijibenxinxiMapper;

    @GetMapping("/jiaoshijibenxinxi")
    public boolean jiaoshijibenxinxi() throws ParseException {


        Set<String> jobNumSet = new HashSet<>();
        Set<String> IdSet = new HashSet<>();

        Jiaoshijibenxinxi jiaoshijibenxinxi = new Jiaoshijibenxinxi();
        for(int i = 0; i < 60; i++){
            jiaoshijibenxinxi.setXingming(PersonUtil.randomChineseName());
            jiaoshijibenxinxi.setXingbie(PersonUtil.randomGender());
            jiaoshijibenxinxi.setMinzu("汉族");
            boolean b = true;
            while (b){
                String jiguanTwoChar = PersonUtil.randomJiguan();
                String jiguan = PersonUtil.JIGUAN.get(jiguanTwoChar);
                String id = PersonUtil.randomID(jiguanTwoChar);
                if(!IdSet.contains(id)){
                    jiaoshijibenxinxi.setShenfenzhenghao(id);
                    jiaoshijibenxinxi.setJiguan(jiguan);
                    IdSet.add(id);
                    b = false;
                }
            }
            jiaoshijibenxinxi.setShenfenzhengjianleixing("身份证");
            boolean b1 = true;
            while (b1){
                String jobNum = StudentUtil.randomStudentNumber("T");
                if(!jobNumSet.contains(jobNum)){
                    jiaoshijibenxinxi.setGonghao(jobNum);
                    jobNumSet.add(jobNum);
                    b1 = false;
                }
            }
            jiaoshijibenxinxi.setShoujihao(PersonUtil.randomMobile());
            jiaoshijibenxinxi.setChushengdi(jiaoshijibenxinxi.getJiguan());
            jiaoshijibenxinxi.setChushengriqi(DateUtil.randomDate("1970-01-01", "1990-06-01"));
            jiaoshijibenxinxi.setHunyinzhuangkuang(PersonUtil.randomHunyin());
            jiaoshijibenxinxi.setZuigaoxuewei(PersonUtil.randomXueWei());
            jiaoshijibenxinxi.setBiyexuexiao(SchoolUtil.randomSchool());
            jiaoshijibenxinxi.setZhuanye(SchoolUtil.randomZhuanye());
            jiaoshijibenxinxi.setBiyeriqi(DateUtil.randomYMDDate(25, 1990));
            jiaoshijibenxinxi.setZhengzhimianmao(PersonUtil.randowMianmao());
            jiaoshijibenxinxiMapper.insert(jiaoshijibenxinxi);
        }
        return true;
    }
}
