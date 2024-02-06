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

public class PatentDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\kgout\\invest\\patent.csv");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
        CSVFormat csvFormat = CSVFormat.EXCEL.withHeader("p_id", "name", "patentType");
        CSVPrinter printer = csvFormat.print(writer);

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("E:\\知识图谱数据集\\创新投资领域知识图谱\\invest-on-invent-kg.json\\invest-on-invent-KG.json");
        JsonNode jsonNode = mapper.readValue(file, JsonNode.class);
        ArrayNode graph = (ArrayNode)jsonNode.get("@graph");
        int size = graph.size();
        List<Map<String, String>> patents = new ArrayList<>();
        for (int i = 0; i < size; i++){
            JsonNode node = graph.get(i);
            if("patent".equals(node.get("@type").asText())){
                // patent表
                Map<String, String> patent = new HashMap<>();
                patent.put("p_id", node.get("@id").asText());
                patent.put("name", node.get("name").asText());;
                patent.put("patentType", node.get("patentType").asText());
                patents.add(patent);
            }
        }
        for (Map<String, String> patent : patents) {
            printer.printRecord(patent.get("p_id"), patent.get("name"), patent.get("patentType"));
        }

        printer.flush();
        printer.close();

    }



}
