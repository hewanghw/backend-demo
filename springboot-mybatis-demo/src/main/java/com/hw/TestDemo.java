package com.hw;

import com.hw.util.PinyinUtil;

public class TestDemo {
    public static void main(String[] args) {
//        String str = "地膜公斤数（11.2公斤/卷）";
//        String str = "民生_兴胜镇养老机构";

/*    String str = "镇域_兴胜镇政府各机构职能";
    System.out.println(PinyinUtil.getPinyinSimple(str));
    String s = str.replaceAll("（.*）", "");
    System.out.println(PinyinUtil.ToFirstChar(s))*/;
    String str ="学校学生统计信息\n" +
            "中职学生家庭成员信息\n" +
            "学前学生基本信息查询\n" +
            "基础教育教育区域数据统计\n" +
            "中小学学生家庭成员信息\n" +
            "学校办学条件\n" +
            "学校教师统计信息\n" +
            "UC库数据\n" +
            "中职学生基本信息\n" +
            "教师画像\n" +
            "综评数据统计信息\n" +
            "基础教育名师信息\n" +
            "中职学籍查询\n" +
            "中小学学生基本信息\n" +
            "中小学学生心理测评信息\n" +
            "基础教育教师任职信息\n" +
            "中小学学生体测信息\n" +
            "中小学困难学生资助信息\n" +
            "学生画像\n" +
            "心理用户数据同步\n" +
            "学校基本信息\n" +
            "学前学生家庭成员信息\n" +
            "基础教育教育区域热点数据统计\n" +
            "基础教育教师荣誉证书信息\n" +
            "基础教育教师基本信息";

        String[] split = str.split("\n");
        for(String s : split){
            System.out.println(s);
            String pinyinSimple = PinyinUtil.getPinyinSimple(s);
            System.out.println("/" + pinyinSimple);
            System.out.println("====================");
        }

    }



}
