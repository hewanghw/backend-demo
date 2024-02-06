package com.hw.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    protected static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);
    private static final int SUCCESS_CODE = 200;

    public static String sendGet(String url, Map<String, String> headers)
            throws Exception {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        String result = null;
        try {
            client = HttpClients.createDefault();

            URIBuilder uriBuilder = new URIBuilder(url);

            HttpGet httpGet = new HttpGet(uriBuilder.build());

            for (String key : headers.keySet()) {
                httpGet.addHeader(key, headers.get(key));
            }
            response = client.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();
            if (200 == statusCode) {
                HttpEntity entity = response.getEntity();
                try {
                    result = EntityUtils.toString(entity, "UTF-8");
                    return result;
                } catch (Exception e) {

                    return null;
                }
            } else {
                HttpEntity entity = response.getEntity();
                try {
                    result = EntityUtils.toString(entity, "UTF-8");
                    return result;
                } catch (Exception e) {
                    return null;
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            assert response != null;
            response.close();
            client.close();
        }
        return null;
    }


    public static String sendPost(String url, Map<String, String> headers, List<NameValuePair> nameValuePairList)
            throws Exception {

        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse response = null;
            try {
                httpclient = HttpClients.createDefault();

                HttpPost post = new HttpPost(url);

                StringEntity entity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");

                post.setEntity(entity);
                for (String key : headers.keySet()) {
                    post.addHeader(key, headers.get(key));
                }
                response = httpclient.execute(post);
                // 不论是否是200，都要将结果返回，不返回结果返回一个null不知道错误地方
                return EntityUtils.toString(response.getEntity(), "UTF-8");
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (response != null) {
                    response.close();
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }


    public static String sendPostByJson(String url, Map<String, String> headers, String obj) {
        String response = null;

        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                for (String key : headers.keySet()) {
                    httppost.addHeader(key, headers.get(key));
                }
                StringEntity stringentity = new StringEntity(obj, ContentType.create("text/json", "UTF-8"));
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
            log.error(e.getMessage());
        }
        return response;
    }
    public static String sendPostByJson(String url, Map<String, String> headers, JSONObject obj) {
        String response = null;

        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                for (String key : headers.keySet()) {
                    httppost.addHeader(key, headers.get(key));
                }
                StringEntity stringentity = new StringEntity(obj.toJSONString(), ContentType.create("text/json", "UTF-8"));
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
            log.error(e.getMessage());
        }
        return response;
    }
}

