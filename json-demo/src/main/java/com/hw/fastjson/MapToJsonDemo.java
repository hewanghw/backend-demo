package com.hw.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

public class MapToJsonDemo {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("age", 20);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(map);
        System.out.println(jsonObject);
        String jsonString = JSONObject.toJSONString(map);
        JSONObject jsonObject1 = JSONObject.parseObject(jsonString);
        System.out.println(jsonObject1);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "jack");
        map1.put("age", null);
        String jsonString1 = JSON.toJSONString(map1, SerializerFeature.WriteMapNullValue);

        JSONObject jsonObject2 = JSONObject.parseObject(jsonString1);
        System.out.println(JSON.toJSONString(jsonObject2, SerializerFeature.WriteMapNullValue));

        String jsonString2 = JSON.toJSONString(map1, SerializerFeature.WriteMapNullValue);
        JSONObject jsonObject3= JSON.parseObject(jsonString2);
        System.out.println(jsonObject3);
    }
}
