package com.hw.controller;

import com.hw.entity.Jiangjinfafang;
import com.hw.entity.Xueshengjibenxinxi;
import com.hw.mapper.JiangjinfafangMapper;
import com.hw.mapper.XueshengjibenxinxiMapper;
import com.hw.util.BankUtil;
import com.hw.util.DateUtil;
import com.hw.util.PersonUtil;
import com.hw.util.StudentUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/generate")
@RestController
public class DemoController {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private JiangjinfafangMapper jiangjinfafangMapper;

    @Autowired
    private XueshengjibenxinxiMapper xueshengjibenxinxiMapper;

    @GetMapping("/jiangjinfafang")
    public boolean jiangjinfafang() throws ParseException {

        Set<String> stuNumSet = new HashSet<>();
        Set<String> accountSet = new HashSet<>();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        for(int i = 0; i < 100; i++){
            Jiangjinfafang jiangjinfafang = new Jiangjinfafang();
            jiangjinfafang.setXingming(PersonUtil.randomChineseName());
            boolean b = true;
            while (b){
                String stuNum = StudentUtil.randomStudentNumber("S");
                if(!stuNumSet.contains(stuNum)){
                    jiangjinfafang.setXuehao(stuNum);
                    stuNumSet.add(stuNum);
                    b = false;
                }
            }
            String scholarshipKey = StudentUtil.randomScholarshipKey();
            jiangjinfafang.setJiangxuejinleixing(scholarshipKey);
            jiangjinfafang.setFafangjine(StudentUtil.SCHOLARSHIP_MAP.get(scholarshipKey));
            jiangjinfafang.setFafangriqi(DateUtil.randomDate("2023-06-12", "2023-06-15"));
//            boolean b1 = true;
//            while (b1){
//                String account = BankUtil.randomNumber(2000000000, 6212250200000001301L);
//                if(!accountSet.contains(account)){
//                    jiangjinfafang.setFangfangzhanghao(account);
//                    accountSet.add(account);
//                    b1 = false;
//                }
//            }
            jiangjinfafangMapper.insert(jiangjinfafang);
        }

        // 一次性提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
        return true;
    }

    @GetMapping("/xueshengjibenxinxi")
    public boolean xueshengjibenxinxi() throws ParseException{
        Set<String> stuNumSet = new HashSet<>();
        Set<String> IdSet = new HashSet<>();
        try(SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
            Xueshengjibenxinxi xueshengjibenxinxi = new Xueshengjibenxinxi();
            for(int i = 0; i < 1500; i++){
                xueshengjibenxinxi.setXingming(PersonUtil.randomChineseName());
                xueshengjibenxinxi.setXingbie(PersonUtil.randomGender());
                xueshengjibenxinxi.setChushengriqi(DateUtil.randomDate("2000-01-01", "2003-12-12"));
                xueshengjibenxinxi.setGuoji("中国");
                boolean b = true;
                while (b){
                    String jiguanTwoChar = PersonUtil.randomJiguan();
                    String jiguan = PersonUtil.JIGUAN.get(jiguanTwoChar);
                    String id = PersonUtil.randomID(jiguanTwoChar);
                    if(!IdSet.contains(id)){
                        xueshengjibenxinxi.setShenfenzhenghao(id);
                        xueshengjibenxinxi.setJiguan(jiguan);
                        IdSet.add(id);
                        b = false;
                    }
                }
                xueshengjibenxinxi.setShoujihao(PersonUtil.randomMobile());
                xueshengjibenxinxi.setHunyinzhuangkuang("未婚");
                xueshengjibenxinxi.setMinzu("汉族");
                boolean b1 = true;
                while (b1){
                    String stuNum = StudentUtil.randomStudentNumber("S");
                    if(!stuNumSet.contains(stuNum)){
                        xueshengjibenxinxi.setXuehao(stuNum);
                        stuNumSet.add(stuNum);
                        b1 = false;
                    }
                }

                xueshengjibenxinxi.setXuexing(PersonUtil.randomXueXing());
                xueshengjibenxinxi.setZhengzhimianmao(PersonUtil.randowMianmao());
                xueshengjibenxinxiMapper.insert(xueshengjibenxinxi);
            }
            sqlSession.commit();
        }
        return true;
    }


}
