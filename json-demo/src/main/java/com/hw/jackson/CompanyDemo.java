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

public class CompanyDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\kgout\\invest\\company.csv");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
        CSVFormat csvFormat = CSVFormat.EXCEL.withHeader("c_id", "name", "alterNames", "establishDate", "address");
        CSVPrinter printer = csvFormat.print(writer);

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("E:\\知识图谱数据集\\创新投资领域知识图谱\\invest-on-invent-kg.json\\invest-on-invent-KG.json");
        JsonNode jsonNode = mapper.readValue(file, JsonNode.class);
        ArrayNode graph = (ArrayNode)jsonNode.get("@graph");
        int size = graph.size();
        List<Map<String, String>> companys = new ArrayList<>();
        for (int i = 0; i < size; i++){
            JsonNode node = graph.get(i);
            if("company".equals(node.get("@type").asText())){
                // company表
                Map<String, String> company = new HashMap<>();
                company.put("c_id", node.get("@id").asText());
                company.put("name", node.get("name").asText());
                ArrayNode arrayNode = (ArrayNode) node.get("alterNames");
                String alterNames = "";
                if(arrayNode.size() > 0){
                    StringBuilder sb = new StringBuilder();
                    for(JsonNode alterName : arrayNode){
                        sb.append(alterName.asText()).append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    alterNames = sb.toString();
                }

                company.put("alterNames", alterNames);
                company.put("establishDate", node.get("establishDate").asText());
                company.put("address", node.get("address").asText());
                companys.add(company);
            }
        }
        for (Map<String, String> company : companys) {
            printer.printRecord(company.get("c_id"), company.get("name"), company.get("alterNames"),
                    company.get("establishDate"), company.get("address"));
        }

        printer.flush();
        printer.close();

    }



}
