package com.hw;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;

public class DemoA {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://qdzwfw.sd.gov.cn/qd/api-v2/qd.app.icity.QdBusinessResultCmd/getBusinessResultjg?s=e982801699968955671&t=8422_e51899_1699968814000&o=899999");
        httpPost.setHeader("content-type", "application/json");
        httpPost.setHeader("Referer", "http://qdzwfw.sd.gov.cn/qd/icity/resultQd");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36");
        String str = "{\"region_code\":\"370200000000\",\"org_code\":\"\",\"start\":1,\"result_mark\":\"lc\",\"startTime\":\"\",\"endTime\":\"\",\"limit\":8}";
        StringEntity entity = new StringEntity(str,"UTF-8");
        httpPost.setEntity(entity);
        CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
        HttpEntity httpEntity  = httpResponse.getEntity();
        String string = EntityUtils.toString(httpEntity, "UTF-8");
        System.out.println(string);
        httpResponse.close();
        httpclient.close();
    }



}
