package com.example;

import com.example.controller.DeptController;
import com.example.pojo.Emp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Untitled7ApplicationTests {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {

        System.out.println(LocalDateTime.now());
    }

    @Test
    void genjwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "lihua");
        String jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, "happywang")
                .setExpiration(new Date(System.currentTimeMillis() + 12*3600*1000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("happywang")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzM4MTc2MjQ2LCJ1c2VybmFtZSI6ImxpaHVhIn0.CzsLHGgBeHGRc2gxR15O1x4GNcLFrdjl8H4hA_EO5bA")
                .getBody();
        System.out.println(claims);
    }

    @Test
    void testGetBean(){
        SAXReader saxReader = (SAXReader) applicationContext.getBean("saxReader");
        SAXReader saxReader1 = (SAXReader) applicationContext.getBean("saxReader");
        System.out.println(saxReader);
        System.out.println(saxReader1);
    }

}
