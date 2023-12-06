package com.hw;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoA {
    public static void main(String[] args) throws IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost("http://qdzwfw.sd.gov.cn/qd/api-v2/qd.app.icity.QdBusinessResultCmd/getBusinessResultjg?s=e982801699968955671&t=8422_e51899_1699968814000&o=899999");
//        httpPost.setHeader("content-type", "application/json");
//        httpPost.setHeader("Referer", "http://qdzwfw.sd.gov.cn/qd/icity/resultQd");
//        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36");
//        String str = "{\"region_code\":\"370200000000\",\"org_code\":\"\",\"start\":1,\"result_mark\":\"lc\",\"startTime\":\"\",\"endTime\":\"\",\"limit\":8}";
//        StringEntity entity = new StringEntity(str,"UTF-8");
//        httpPost.setEntity(entity);
//        CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
//        HttpEntity httpEntity  = httpResponse.getEntity();
//        String string = EntityUtils.toString(httpEntity, "UTF-8");
//        System.out.println(string);
//        httpResponse.close();
//        httpclient.close();
//        Document document = Jsoup.parse( new File( "E:\\Temp\\html\\1.html" ) , "utf-8" );
//        Element roll_list1 = document.getElementById("roll_list1");
//        Elements trs = roll_list1.getElementsByTag("tbody").get(0).getElementsByTag("tr");
//        for(Element tr : trs){
//            Elements tds = tr.getElementsByTag("td");
//            Element td = tds.get(1);
//            Elements link = td.select("a[href]");
//            String url =  "http://qdzwfw.sd.gov.cn" +  link.attr("href");
//            System.out.println(url);
//            HttpGet httpGet = new HttpGet(url);
//            httpGet.setHeader("Referer", "http://qdzwfw.sd.gov.cn/qd/icity/resultQd");
//            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36");
//            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
//            HttpEntity httpEntity  = httpResponse.getEntity();
//            String string = EntityUtils.toString(httpEntity, "UTF-8");
//            System.out.println(string);
//            httpResponse.close();
//            break;
//        }
//        httpClient.close();

//        Document document = Jsoup.parse( new File( "E:\\Temp\\html\\2.html" ) , "utf-8" );
//        Element element = document.getElementsByTag("section").get(0);
//        Elements tds = element.getElementsByTag("td");
//        for(Element td : tds){
//            System.out.println(td.text());
//        }


        File htmlDir = new File("E:\\Temp\\html");
        File[] files = htmlDir.listFiles();
        List<BanJian> banJianList = new ArrayList<>();
        for(File file: files){
            Document document = Jsoup.parse( file, "utf-8" );
            Element element = document.getElementsByTag("section").get(0);
            Elements tds = element.getElementsByTag("td");
            BanJian banJian = new BanJian();
            banJian.setUNION_CODE(tds.get(0).text());
            banJian.setITEMNAME(tds.get(1).text());
            banJian.setPROJECTNAME(tds.get(2).text());
            banJian.setAPPLICANT(tds.get(3).text());
            banJian.setACCEPTDEPTNAME(tds.get(4).text());
            banJian.setACCEPTUSERNAME(tds.get(5).text());
            banJian.setACCEPTTIME(tds.get(6).text());
            banJian.setAPPROVALTYPE(tds.get(7).text());
            banJian.setFINISHTIME(tds.get(8).text());
            banJian.setACCEPSTATE(tds.get(9).text());
            banJianList.add(banJian);
        }

        try {
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream("E:\\Temp\\banjian.csv"), StandardCharsets.UTF_8));
//            CSVFormat csvFormat = CSVFormat.EXCEL.withHeader("申报号", "事项名称", "办件名称", "申请人/申请单位",
//                    "受理单位", "受理经办人", "受理时间", "办件类型", "办结时间", "办件结果");

            CSVFormat csvFormat = CSVFormat.EXCEL.withHeader("UNION_CODE", "ITEMNAME", "PROJECTNAME", "APPLICANT",
                    "ACCEPTDEPTNAME", "ACCEPTUSERNAME", "ACCEPTTIME", "APPROVALTYPE", "FINISHTIME", "ACCEPSTATE");
            CSVPrinter printer = csvFormat.print(writer);
            for (int i = 0; i < banJianList.size(); i++) {
                BanJian banJian = banJianList.get(i);
                printer.printRecord(banJian.getUNION_CODE(), banJian.getITEMNAME(), banJian.getPROJECTNAME(),
                        banJian.getAPPLICANT(), banJian.getACCEPTDEPTNAME(), banJian.getACCEPTUSERNAME(),
                        banJian.getACCEPTTIME(), banJian.getAPPROVALTYPE(), banJian.getFINISHTIME(),
                        banJian.getACCEPSTATE());
            }
            printer.flush();
            printer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
