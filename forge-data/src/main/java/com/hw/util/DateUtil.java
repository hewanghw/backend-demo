package com.hw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateUtil {

    /**
     * 随机生成年月日
     * @return
     */
    public static String randomYMDDate(int bound, int yearBase) {
        Random random = new Random();
        int year = random.nextInt(bound) + yearBase;
        int month = random.nextInt(2) + 7;
        int day = random.nextInt(28) + 1;
        return String.format("%04d%02d%02d", year, month, day);
    }

    /**
     * 随机生成指定范围的时间 yyyy-MM-dd
     * @param beginDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static Date randomDate(String beginDate, String endDate) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //解析时间
        Date d1 = sdf.parse(beginDate);
        long before = d1.getTime();
        //默认获取当前时间
        Date d2 = new Date();
        if(endDate != null){
            d2 = sdf.parse(endDate);
        }
        long after = d2.getTime();
        Random r = new Random();
        long randomDate = (long) (before + (r.nextFloat() * (after - before + 1)));
        return new Date(randomDate);
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
