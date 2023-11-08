package com.hw.controller;

import com.hw.entity.Qinkongzhuxue;
import com.hw.mapper.QinkongzhuxueMapper;
import com.hw.util.DateUtil;
import com.hw.util.PersonUtil;
import com.hw.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RestController
public class QinkongzhuxueController {

    @Autowired
    private QinkongzhuxueMapper qinkongzhuxueMapper;

    @GetMapping("/qinkongzhuxue")
    public boolean qinkongzhuxue() throws ParseException {
        Set<String> stuNumSet = new HashSet<>();
        Qinkongzhuxue qinkongzhuxue = new Qinkongzhuxue();
        for(int i = 0; i < 100; i++){
            qinkongzhuxue.setXingming(PersonUtil.randomChineseName());
            boolean b = true;
            while (b){
                String stuNum = StudentUtil.randomStudentNumber("S");
                if(!stuNumSet.contains(stuNum)){
                    qinkongzhuxue.setXuehao(stuNum);
                    stuNumSet.add(stuNum);
                    b = false;
                }
            }
            qinkongzhuxue.setQingongzhuxuegangwei(StudentUtil.randomZhuXueGangWei());
            int gongshi = new Random().nextInt(10) + 30;
            int jine = gongshi * 15;
            qinkongzhuxue.setYuegongzuoshijian(gongshi);
            qinkongzhuxue.setYuefafangjine(jine);
            qinkongzhuxue.setFafangriqi(DateUtil.randomDate("2022-10-25", "2022-10-26"));
            qinkongzhuxueMapper.insert(qinkongzhuxue);
        }
        return true;
    }
}
