package com.hw.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hw.domain.SDTOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping("/redis")
@RestController
public class DemoController {
    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/get")
    public SDTOrg get(){

        Map<Object, Object> usersByRole = null;
        usersByRole = redisTemplate.opsForHash().entries("sdtAdminIds");
        JSONArray jsonArray = new JSONArray();
        for(Object key : usersByRole.keySet()){
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("id", key);
            jsonObj.put("account", key);
            jsonObj.put("name", usersByRole.get(key));
            jsonObj.put("orgCode", "");
            jsonObj.put("orgName", "");
            jsonObj.put("regionCode", "");
            jsonObj.put("regionName", "");
            jsonArray.add(jsonObj);
        }
        System.out.println(jsonArray);


//        Boolean sdtAdminIds = redisTemplate.opsForHash().hasKey("sdtAdminIds", "f8fbbd4d-ac96-497b-828f-9df0c51b5946");
//        System.out.println(sdtAdminIds);

//        String idsStr = (String)redisTemplate.opsForHash().get("sdtChildrenOrgIds", "14");
//        List<String> list = JSON.parseObject(idsStr, List.class);
//        System.out.println(list);

//        Map<Object, Object> sdtOrgTree = redisTemplate.opsForHash().entries("sdtOrgTree");
//        System.out.println(sdtOrgTree);
//        Boolean b1 = redisTemplate.opsForHash().hasKey("sdtOrgTree", "14");
//        System.out.println(b1);
//
//        System.out.println(redisTemplate.opsForHash().hasKey("sdtOrgTree", "1"));
//
//        String s = (String)redisTemplate.opsForHash().get("sdtOrgTree", "7");
//        System.out.println("=========");
//        System.out.println(s);
//        System.out.println("=========");
//
        String sdtOrgStr = (String)redisTemplate.opsForHash().get("sdtOrgTree", "14");
        SDTOrg sdtOrg = JSON.parseObject(sdtOrgStr, SDTOrg.class);

        System.out.println(sdtOrg.getOrgName());
        return sdtOrg;
    }

    @GetMapping("/add")
    public boolean add(){
        Map<String, SDTOrg> orgMap = new HashMap<>();

        SDTOrg sdtOrg = new SDTOrg();
        sdtOrg.setOrgName("浪潮");
        sdtOrg.setOrgOrder(2147483645);
        sdtOrg.setOrgParentId("6");
        sdtOrg.setOrgType(0);
        orgMap.put("14", sdtOrg);

        SDTOrg sdtOrg1 = new SDTOrg();
        sdtOrg1.setOrgName("腾讯");
        sdtOrg1.setOrgOrder(2147483045);
        sdtOrg1.setOrgParentId("6");
        sdtOrg1.setOrgType(0);
        orgMap.put("17", sdtOrg1);

        SDTOrg sdtOrg2 = new SDTOrg();
        sdtOrg2.setOrgName("阿里");
        sdtOrg2.setOrgOrder(214793045);
        sdtOrg2.setOrgParentId("6");
        sdtOrg2.setOrgType(0);
        orgMap.put("12", sdtOrg2);
        Set<String> orgIdKey = orgMap.keySet();
        for(String key : orgIdKey){
            SDTOrg sdtOrgValue = orgMap.get(key);
            redisTemplate.opsForHash().put("sdtOrgTree", key, JSON.toJSONString(sdtOrgValue));
        }
        return true;

    }
    @GetMapping("/addC")
    public boolean addC(){
        Map<String, List<String>> childrenMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("141");
        list.add("142");
        list.add("143");
        childrenMap.put("14", list);
        List<String> list1 = new ArrayList<>();
        list1.add("181");
        list1.add("182");
        list1.add("183");
        childrenMap.put("18", list1);
        Set<String> childrenIdsKey = childrenMap.keySet();
        for(String key : childrenIdsKey){
            List<String> sdtChildrenOrgIds = childrenMap.get(key);
            redisTemplate.opsForHash().put("sdtChildrenOrgIds", key, JSON.toJSONString(sdtChildrenOrgIds));
        }
        return true;
    }

    @GetMapping("/addRole")
    public boolean addRole(){
        Map<String, String> adminMap = new HashMap<>();

        adminMap.put("f8fbbd4d-ac96-497b-828f-9df0c51b5946", "孟奇");
        adminMap.put("cff8ec4e-4240-4e69-9ba5-f4551ae465bd", "袁浩森");

        Set<String> childrenIdsKey = adminMap.keySet();
        for(String key : childrenIdsKey){
            String userIds = adminMap.get(key);
            redisTemplate.opsForHash().put("sdtAdminIds", key, JSON.toJSONString(userIds));
        }
        return true;
    }


}
