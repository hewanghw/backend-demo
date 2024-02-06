package com.hw.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class applyPatentDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\kgout\\invest\\applyPatent.csv");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
        CSVFormat csvFormat = CSVFormat.EXCEL.withHeader("i_id", "p_id");
        CSVPrinter printer = csvFormat.print(writer);

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("E:\\知识图谱数据集\\创新投资领域知识图谱\\invest-on-invent-kg.json\\invest-on-invent-KG.json");
        JsonNode jsonNode = mapper.readValue(file, JsonNode.class);
        ArrayNode graph = (ArrayNode)jsonNode.get("@graph");
        int size = graph.size();
        List<Map<String, String>> applyPatents = new ArrayList<>();
        for (int i = 0; i < size; i++){
            JsonNode node = graph.get(i);
            if("company".equals(node.get("@type").asText())){
                // applyPatent表
                String cId = node.get("@id").asText();
                ArrayNode arrayNode = (ArrayNode)node.get("relationship").get("applyPatent");
                if(arrayNode.size() > 0){
                    for(JsonNode applyPatentNode : arrayNode){
                        Map<String, String> applyPatent = new HashMap<>();
                        applyPatent.put("c_id", cId);
                        applyPatent.put("p_id", applyPatentNode.get("@id").asText());;
                        applyPatents.add(applyPatent);
                    }
                }
            }
        }
        for (Map<String, String> applyPatent : applyPatents) {
            printer.printRecord(applyPatent.get("c_id"), applyPatent.get("p_id"));
        }
        printer.flush();
        printer.close();

    }



}
