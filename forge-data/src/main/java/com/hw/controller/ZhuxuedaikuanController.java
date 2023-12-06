package com.hw.controller;

import com.hw.entity.Zhuxuedaikuan;
import com.hw.mapper.ZhuxuedaikuanMapper;
import com.hw.util.BankUtil;
import com.hw.util.DateUtil;
import com.hw.util.PersonUtil;
import com.hw.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
public class ZhuxuedaikuanController {

    @Autowired
    private ZhuxuedaikuanMapper zhuxuedaikuanMapper;

    @GetMapping("/zhuxuedaikuan")
    public boolean zhuxuedaikuan() throws ParseException {

        Set<String> stuNumSet = new HashSet<>();
        Zhuxuedaikuan zhuxuedaikuan = new Zhuxuedaikuan();
        for(int i = 1; i < 100; i++){
            zhuxuedaikuan.setXingming(PersonUtil.randomChineseName());
            zhuxuedaikuan.setXingbie(PersonUtil.randomGender());
            boolean b = true;
            while (b){
                String stuNum = StudentUtil.randomStudentNumber("S");
                if(!stuNumSet.contains(stuNum)){
                    zhuxuedaikuan.setXuehao(stuNum);
                    stuNumSet.add(stuNum);
                    b = false;
                }
            }
            zhuxuedaikuan.setDaikuannianxian(4);
            zhuxuedaikuan.setDaikuanjine(8000);
//            String s = DateUtil.randomYMDDate(2, 2020);
//            Date yyyy = new SimpleDateFormat("yyyyMMdd").parse(s);
//            String yyyy1 = new SimpleDateFormat("yyyy").format(yyyy);

            zhuxuedaikuan.setDaikuanshenqingshijian(DateUtil.randomDate("2022-07-21", "2022-07-21"));
            zhuxuedaikuan.setDaikuanyihang(BankUtil.randomBanks());
            zhuxuedaikuan.setHuankuanfangshi(BankUtil.randomHuanKuanFangShi());
            zhuxuedaikuan.setNianlilv(0.475F);
            zhuxuedaikuan.setQianyueshiqi(DateUtil.randomDate("2022-08-21", "2022-08-21"));
            zhuxuedaikuanMapper.insert(zhuxuedaikuan);
        }
        return true;

    }
}
