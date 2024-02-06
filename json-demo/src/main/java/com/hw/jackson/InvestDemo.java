package com.hw.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class InvestDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\kgout\\invest\\investor.csv");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
        CSVFormat csvFormat = CSVFormat.EXCEL.withHeader("i_id", "name");
        CSVPrinter printer = csvFormat.print(writer);

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("E:\\知识图谱数据集\\创新投资领域知识图谱\\invest-on-invent-kg.json\\invest-on-invent-KG.json");
        JsonNode jsonNode = mapper.readValue(file, JsonNode.class);
        ArrayNode graph = (ArrayNode)jsonNode.get("@graph");
        int size = graph.size();
        List<Map<String, String>> investors = new ArrayList<>();
        for (int i = 0; i < size; i++){
            JsonNode node = graph.get(i);
            if("investor".equals(node.get("@type").asText())){
                // invest表
                Map<String, String> investor = new HashMap<>();
                investor.put("i_id", node.get("@id").asText());
                investor.put("name", node.get("name").asText());
                investors.add(investor);
            }
        }
        for (Map<String, String> investor : investors) {
            printer.printRecord(investor.get("i_id"), investor.get("name"));
        }

        printer.flush();
        printer.close();

    }



}
