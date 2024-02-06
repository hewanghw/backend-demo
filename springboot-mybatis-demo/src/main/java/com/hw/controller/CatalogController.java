package com.hw.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hw.mapper.CatalogMapper;
import com.hw.util.HttpClientUtil;
import com.hw.util.PinyinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CatalogController {
    @Autowired
    private CatalogMapper catalogMapper;

    @GetMapping("/selectCatalog")
    boolean selectCatalog(){
        List<Map<String, String>> mapList  =
                catalogMapper.selectCatalog();
        for(Map<String, String> map : mapList){
            JSONObject json = new JSONObject();
            String cataName = map.get("cataName");
            json.put("resName", cataName);
            json.put("cataId", map.get("cataId"));
            json.put("tableDbId", map.get("tableDbId"));
            json.put("resUpdateCycle", map.get("resUpdateCycle"));
            json.put("tableNameEn", PinyinUtil.ToFirstChar(cataName));
            String itemNames = map.get("itemNames");
            String[] split = itemNames.split(",");
            JSONArray jsonArray = new JSONArray();
            for(String str : split){
                JSONObject resTableColumn = new JSONObject();
//                String pinyinSimple = PinyinUtil.getPinyinSimple(str);
                String pinyinSimple = PinyinUtil.ToFirstChar(str);
                resTableColumn.put("columnNameEn", pinyinSimple);
                resTableColumn.put("columnNameCn", str);
                resTableColumn.put("columnFormat", "varchar");
                resTableColumn.put("columnLength", 255);
                resTableColumn.put("columnIsPk", 0);
                resTableColumn.put("columnIsNull", 1);
                jsonArray.add(resTableColumn);
            }
            json.put("resTableColumnList", jsonArray);
            System.out.println(json);
            Map<String, String> heads = new HashMap<>();
            heads.put("Authorization", "Bearer 80cdeaa6-268f-4778-b291-5ec0805907be");
            heads.put("Content-Type", "application/json");

            String s = HttpClientUtil.sendPostByJson("http://10.110.145.36/iss-gate/resource/table/resToTable", heads, json);
            JSONObject jsonObject = JSON.parseObject(s);
            if(jsonObject.getIntValue("code") != 200){
                System.out.println(cataName);
                System.out.println(map.get("cataId"));
                break;
            }

        }

        return true;
    }
}
