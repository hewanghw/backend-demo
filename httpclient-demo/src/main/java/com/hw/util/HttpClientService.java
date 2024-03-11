package com.hw.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.Map;

public class HttpClientService {

    public static String sendPostByJson(String url, Map<String, String> headers, String obj) {
        String response = null;

        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient= HttpsClientUtil.httpClientTrustingAllSSLCerts();
                HttpPost httppost = new HttpPost(url);
                for (String key : headers.keySet()) {
                    httppost.addHeader(key, headers.get(key));
                }
                StringEntity stringentity = new StringEntity(obj, ContentType.create("application/json", "UTF-8"));
                httppost.setEntity(stringentity);
                httpresponse = httpclient.execute(httppost);
                response = EntityUtils.toString(httpresponse.getEntity());
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (httpresponse != null) {
                    httpresponse.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }
}
