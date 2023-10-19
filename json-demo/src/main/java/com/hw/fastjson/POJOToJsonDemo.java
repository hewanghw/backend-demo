package com.hw.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hw.domain.Car;

import java.util.HashMap;

public class POJOToJsonDemo {
    public static void main(String[] args) {
        Car bmw = new Car("bmw", 20);

        String s = JSON.toJSONString(bmw);
        System.out.println(s);

        HashMap<String, Object> map = new HashMap<>();
        map.put("brand", "dd");
        map.put("price", 23);
        String s1 = JSON.toJSONString(map);
        System.out.println(s1);
    }
}
