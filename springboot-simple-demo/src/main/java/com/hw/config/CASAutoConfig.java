//package com.hw.config;
//
//import org.jasig.cas.client.authentication.AuthenticationFilter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class CASAutoConfig {
//    @Value("${cas.server-url-prefix}")
//    private String serverUrlPrefix;
//    @Value("${cas.server-login-url}")
//    private String serverLoginUrl;
//    @Value("${cas.client-host-url}")
//    private String clientHostUrl;
//
//    /**
//     * cas授权过滤器
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean filterAuthenticationRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new AuthenticationFilter());
//        // 设定匹配的路径 需要过滤的 请求
//        registration.addUrlPatterns("/login");
//        Map<String,String> initParameters = new HashMap<String, String>();
//        initParameters.put("casServerLoginUrl",serverLoginUrl);
//        initParameters.put("serverName", clientHostUrl);
//        //忽略的url，"|"分隔多个url
//        initParameters.put("ignorePattern", "/logout|/success|/index");
//        registration.setInitParameters(initParameters);
//        // 设定加载的顺序
//        registration.setOrder(1);
//        return registration;
//    }
//}
