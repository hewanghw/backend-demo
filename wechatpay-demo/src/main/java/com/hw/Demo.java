//package com.hw;
//
//
//import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
//import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
//import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
//import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
//import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
//import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
//
//import java.io.ByteArrayInputStream;
//import java.security.PrivateKey;
//
//public class Demo {
//    public static void main(String[] args) {
//        // 加载商户私钥（privateKey：私钥字符串）
//        PrivateKey merchantPrivateKey = PemUtil
//                .loadPrivateKey(new ByteArrayInputStream(privateKey.getBytes("utf-8")));
//
//        // 加载平台证书（mchId：商户号,mchSerialNo：商户证书序列号,apiV3Key：V3密钥）
//        AutoUpdateCertificatesVerifier verifier = new AutoUpdateCertificatesVerifier(
//                new WechatPay2Credentials(mchId, new PrivateKeySigner(mchSerialNo, merchantPrivateKey)),apiV3Key.getBytes("utf-8"));
//
//        // 初始化httpClient
//        httpClient = WechatPayHttpClientBuilder.create()
//                .withMerchant(mchId, mchSerialNo, merchantPrivateKey)
//                .withValidator(new WechatPay2Validator(verifier)).build();
//    }
//
//}
