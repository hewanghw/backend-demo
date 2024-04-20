package com.hw.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hw.domain.Car;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class StringListDemo {
    public static void main(String[] args) throws JsonProcessingException {
//        String[] a = {"nihao", "shijie"};
//
//        List<String> list = Arrays.asList(a);
//        ObjectMapper mapper = new ObjectMapper();
//        String s = mapper.writeValueAsString(list);
////        System.out.println(s);
////        Car benchi = new Car("benchi", 1000.00);
////        System.out.println(mapper.writeValueAsString(benchi));
//
//        Set<String> list1 = mapper.readValue(s, new TypeReference<Set<String>>() {});
//        System.out.println(list1);
//        boolean nihao = list.contains("nihao");
//        System.out.println(nihao);

        // 定义JWT的头部信息
        Map<String, Object> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");
        String userId = "5f8da5c96d954f1dbe8d3d009bbcc0dc";
        Map<String, Object> claims = new HashMap<>(5);
        claims.put("userId", userId);
        claims.put("dept", "");
        claims.put("idType", "");
//        long iat = new Date().getTime() / 1000;
        long iat = 1713332181;
        long exp = 1713360981;
//        long exp = iat + 8 * 60 *60;
        claims.put(Claims.ISSUED_AT, iat);
        claims.put(Claims.EXPIRATION, exp);
        String  jwtSecret =  "yun+gbjq8pwla0v5o1zc123456a?MSE0P-ZrWe9AGroYW0WR9ED4hkVy8F4EMPgX771eF_ibPiJP7eltev1knV82TSke";
        String s = Base64.getEncoder().encodeToString(jwtSecret.getBytes(StandardCharsets.UTF_8));
        String compact = Jwts.builder().setHeader(headers).setClaims(claims).signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
        System.out.println(compact);

        String compact1 = Jwts.builder().setHeader(headers).setClaims(claims).signWith(SignatureAlgorithm.HS256, s).compact();
        System.out.println(compact1);

    }
}
