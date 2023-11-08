package com.hw.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class StudentUtil {
    public static Map<String, Integer> SCHOLARSHIP_MAP = new HashMap<String, Integer>()
    {{
        put("国家奖学金", 8000);
        put("国家励志奖学金", 5000);
        put("校长奖学金", 10000);
        put("学业奖学金", 2000);
        put("特长奖学金", 1000);
    }};

    public static String[] ZHUXUEGANGWEIS = {"机房管理", "校园卫生", "图书管理", "实训室管理"};

    public static String randomZhuXueGangWei(){
        int length = ZHUXUEGANGWEIS.length;
        int index = randomNumber(0, length - 1);
        return index < 0 || index >= length ? ZHUXUEGANGWEIS[0] : ZHUXUEGANGWEIS[index];
    }

    /**
     * 随机生成奖学金类型
     * @return 奖学金类型
     */
    public static String randomScholarshipKey(){
        Set<String> keySet = SCHOLARSHIP_MAP.keySet();
        String[] strings = keySet.toArray(new String[0]);
        int length = SCHOLARSHIP_MAP.size();
        int index = randomNumber(0, length - 1 );
        return index < 0 || index >= length ? strings[0] : strings[index];
    }

    /**
     * 获取奖学金金额
     * @param key
     * @return 奖学金金额
     */
    public static Integer getScholarshipValue(String key){
        return SCHOLARSHIP_MAP.get(key);
    }

    /**
     * 随机生成学号
     * @param schoolCode
     * @return 学号
     */
    public static String randomStudentNumber(String schoolCode){
        Random random = new Random();
        String year = randomNumber(0, 3) + 2019 + "";
        String serialNumber = String.format("%04d", randomNumber(0, 1999));
        return schoolCode + year + serialNumber;
    }
    /**
     * 随机生成指定范围整数
     *
     * @param min 最小值
     * @param max 最大值
     * @return 随机值
     */
    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}
