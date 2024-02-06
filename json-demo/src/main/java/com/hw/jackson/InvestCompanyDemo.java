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

public class InvestCompanyDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\kgout\\invest\\investCompany.csv");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
        CSVFormat csvFormat = CSVFormat.EXCEL.withHeader("i_id", "c_id", "round", "date");
        CSVPrinter printer = csvFormat.print(writer);

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("E:\\知识图谱数据集\\创新投资领域知识图谱\\invest-on-invent-kg.json\\invest-on-invent-KG.json");
        JsonNode jsonNode = mapper.readValue(file, JsonNode.class);
        ArrayNode graph = (ArrayNode)jsonNode.get("@graph");
        int size = graph.size();
        List<Map<String, String>> investCompanys = new ArrayList<>();
        for (int i = 0; i < size; i++){
            JsonNode node = graph.get(i);
            if("investor".equals(node.get("@type").asText())){
                // investCompany表
                String iId = node.get("@id").asText();
                ArrayNode arrayNode = (ArrayNode)node.get("relationship").get("investCompany");
                if(arrayNode.size() > 0){
                    for(JsonNode companyNode : arrayNode){
                        Map<String, String> investCompany = new HashMap<>();
                        investCompany.put("i_id", iId);
                        investCompany.put("com_id", companyNode.get("@id").asText());
                        investCompany.put("round", companyNode.get("round").asText());
                        investCompany.put("date", companyNode.get("date").asText());
                        investCompanys.add(investCompany);
                    }
                }
            }
        }
        for (Map<String, String> investCompany : investCompanys) {
            printer.printRecord(investCompany.get("i_id"), investCompany.get("com_id"),
                    investCompany.get("round"), investCompany.get("date"));
        }
        printer.flush();
        printer.close();

    }



}
