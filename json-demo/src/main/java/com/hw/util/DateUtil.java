package com.hw.util;

import java.time.LocalDate;
import java.util.Random;

public class DateUtil {
    private static final Random random = new Random();

    /**
     * 随机生成某个范围的年月日
     * @param startYear
     * @param endYear
     * @param startMonth
     * @param endMonth
     * @param startDay
     * @param endDay
     * @return
     */
    public static LocalDate randomDateBetween(int startYear, int endYear, int startMonth, int endMonth, int startDay, int endDay){
        int year = startYear + random.nextInt(endYear - startYear);
        int month = startMonth + random.nextInt(endMonth - startMonth);
        int day = startDay + random.nextInt(endDay - startDay);
        return LocalDate.of(year, month, day);
    }
}
