package com.hw.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.hw.domain.SysUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToJsonDemo {
    public static void main(String[] args) {
        List<SysUser> userList = new ArrayList<>();
        Map<String,Object> userMap= new HashMap<>();
        for (int i = 0; i < 3; i++) {
            SysUser user = new SysUser();
            user.setId(1);
            user.setRoleId(2);
            user.setUserPhone("phone" + (i + 1));
            userList.add(user);
        }
        //Map对象转成JSON对象
        userMap.put("userList",userList);
        JSONObject userObj = JSONObject.parseObject(JSONObject.toJSONString(userMap));
        JSONArray userListMap = userObj.getJSONArray("userList");
        String userListMapStr = userListMap.toString();
        System.out.println("Map对象转换后的字符串=" + userListMapStr);

        //List对象转成JSON对象
        JSONArray userArray = JSONArray.parseArray(JSONObject.toJSONString(userList));
        String array = userArray.toString();
        System.out.println("List对象转换后的字符串=" + array );

        //json字符串 转化成List对象
        ArrayList<SysUser> userObjArray = JSON.parseObject(array ,new TypeReference<ArrayList<SysUser>>(){});
        System.out.println("JSONObject 转化成List对象: \n" + userObjArray.toString());


    }
}
