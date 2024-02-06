package com.hw.demo;

import com.hw.util.PersonUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DemoA {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\kgout\\person.csv");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
        CSVFormat csvFormat = CSVFormat.EXCEL.withHeader( "name", "gender");
        CSVPrinter printer = csvFormat.print(writer);
        List<Map<String, String>> persons = new ArrayList<>();
        String[] gen = {"男", "女"};
        Random random = new Random();
        for(int i = 0; i< 10000; i++){
            String gender = gen[random.nextInt(gen.length)];
            String name = PersonUtil.randomChineseName(gender);
            Map<String, String> person = new HashMap<>();
            person.put("name", name);
            person.put("gender", gender);
            persons.add(person);

        }
        for (Map<String, String> person : persons) {
            printer.printRecord(person.get("name"), person.get("gender"));
        }

        printer.flush();
        printer.close();
    }
}
