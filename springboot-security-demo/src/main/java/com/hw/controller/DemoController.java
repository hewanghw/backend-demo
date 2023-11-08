package com.hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.*;

@RequestMapping("/secure")
@RestController
public class DemoController {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @GetMapping("/save")
    public void save() {
        // 创建Authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                "wanghe", "1234");

        Map<String, String> requestParameters = new HashMap<>();
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority admin = new SimpleGrantedAuthority("platform");
        authorities.add(admin);
        Set<String> scope = new HashSet<>();
        scope.add("");
        Set<String> resourceIds = new HashSet<>();
        resourceIds.add("dd");
        String redirectUri = "";
        Set<String> responseTypes = new HashSet<>();
        Map<String, Serializable> extensionProperties = new HashMap<>();
        // 创建OAuth2Request
        OAuth2Request oAuth2Request = new OAuth2Request(
                requestParameters, "myApp", authorities, true, scope,
                resourceIds, redirectUri, responseTypes, extensionProperties);

        // 生成OAuth2Authentication
        OAuth2Authentication auth2Authentication = new OAuth2Authentication(
                oAuth2Request, authentication);

        TokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore);

        OAuth2AccessToken accessToken = defaultTokenServices.createAccessToken(auth2Authentication);


    }

}
