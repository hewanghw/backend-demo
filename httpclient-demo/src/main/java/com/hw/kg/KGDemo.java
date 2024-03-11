package com.hw.kg;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hw.util.HttpClientService;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class KGDemo {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("C:\\Users\\wanghe02\\Downloads\\resLevel6.json");
        JsonNode jsonNode = mapper.readValue(file, JsonNode.class);
        JsonNode data = jsonNode.get("data");
        ArrayNode arrayNode = (ArrayNode) data.get("entities");
        List<Entity> entityList = new ArrayList<>();
        for(int i = 0; i < arrayNode.size(); i++){
            Entity entity = new Entity();
            entity.setSearchId(arrayNode.get(i).get("searchId").asText());
            entity.setEntityId(arrayNode.get(i).get("entityId").asText());
//            entity.setName(arrayNode.get(i).get("name").asText());
            entityList.add(entity);
        }
//        System.out.println(entityList.size());
//        System.out.println(entityList.get(0));
//        System.out.println(entityList.get(580));
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            numbers.add(random.nextInt(entityList.size()));
        }
        System.out.println(numbers);
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("level", 0);
        objectNode.put("direction", "OUTBOUND");
        objectNode.put("graphId", "1754439311702429697");
        objectNode.put("limit", 500);
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("Authorization", "Bearer 2f905ccd-97d9-4b7c-93c7-cce43232f22b");
        String url = "http://10.110.55.15/iss-gate/knowledge/application/relationDeduction/shortPath";
        long startT = System.currentTimeMillis();
        for(int i = 0; i < numbers.size(); i++){
            for(int j = 0; j < numbers.size(); j++){
                ArrayNode nodes = mapper.createArrayNode();
                ObjectNode nodeFrom = mapper.createObjectNode();
                ObjectNode nodeTo = mapper.createObjectNode();
                nodeFrom.put("dataId", entityList.get(i).getSearchId());
                nodeFrom.put("entityId", entityList.get(i).getEntityId());
                nodeTo.put("dataId", entityList.get(j).getSearchId());
                nodeTo.put("entityId", entityList.get(j).getEntityId());
                nodes.add(nodeFrom);
                nodes.add(nodeTo);
                objectNode.set("nodes", nodes);
                String str = mapper.writeValueAsString(objectNode);
                String res = HttpClientService.sendPostByJson(url, headers, str);
                System.out.println(res);
            }
        }
        long endT = System.currentTimeMillis();
        System.out.println("总耗时: " + (endT - startT) / 1000 + " s");
//        System.out.println("平均耗时: " + (endT - startT) / 900f + " ms");

    }

}
