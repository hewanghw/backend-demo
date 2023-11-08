package com.hw.util;

import java.util.Random;

public class SchoolUtil {
    public static String[] SCHOOLS = ("中央音乐学院,中国音乐学院,北京师范大学," +
            "浙江音乐学院,华东师范大学,首都师范大学,东北师范大学").split(",");
    public static String[] ZHUANYES = ("音乐表演,音乐学,音乐教育," +
            "作曲与作曲技术理论,流行音乐,音乐治疗").split(",");
    /**
     * 随机生成指定范围数字
     *
     * @param min 最小值
     * @param max 最大值
     * @return 随机值
     */
    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static String randomSchool(){
        int length = SCHOOLS.length;
        int index = randomNumber(0, length - 1);
        return index < 0 || index >= length ? SCHOOLS[0] : SCHOOLS[index];
    }

    public static String randomZhuanye(){
        int length = ZHUANYES.length;
        int index = randomNumber(0, length - 1);
        return index < 0 || index >= length ? ZHUANYES[0] : ZHUANYES[index];
    }

}
