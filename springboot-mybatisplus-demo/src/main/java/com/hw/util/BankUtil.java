package com.hw.util;

import java.util.Random;

public class BankUtil {

    public static String[] HUANKUANFANGSHIS = {"到期一次性付清", "到期后等额本息"};
    public static String[] BANKS = {"中国工商银行", "中国农业银行","中国建设银行"};

    public static String randomHuanKuanFangShi(){
        int length = HUANKUANFANGSHIS.length;
        int index = randomNumber(0, length - 1);
        return index < 0 || index >= length ? HUANKUANFANGSHIS[0] : HUANKUANFANGSHIS[index];
    }

    public static String randomBanks(){
        int length = BANKS.length;
        int index = randomNumber(0, length - 1);
        return index < 0 || index >= length ? BANKS[0] : BANKS[index];
    }

//    public static int randomNumber(int distance, long max) {
//        Random random = new Random();
//        return random.nextInt(max - min + 1) + min;
//    }

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
