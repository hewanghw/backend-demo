package com.hw;

import com.alibaba.fastjson.JSON;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {
//        String s = ExcelUtil.readByUserguid("C:\\Users\\wanghe02\\Desktop\\映射信息.xlsx", "afb98173-b394-4952-b056-92cffca6aeaa");
//        System.out.println(s);

        Map<String, String> map = ExcelUtil.readRoles("C:\\Users\\wanghe02\\Desktop\\userIdMap.xlsx");
        String s = JSON.toJSONString(map);
        System.out.println(s);

    }
}
