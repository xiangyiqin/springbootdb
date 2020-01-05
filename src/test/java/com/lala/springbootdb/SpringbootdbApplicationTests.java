package com.lala.springbootdb;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpringbootdbApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test

    public void test1(){

        JwtBuilder jwtBuilder = Jwts.builder().setId("1").setSubject("aa").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "lala");
        String token=jwtBuilder.compact();
        System.out.println(token);
        Claims lala = Jwts.parser().setSigningKey("lala").parseClaimsJws(token).getBody();
        System.out.println(lala.getId());
        System.out.println(lala.getSubject());
        System.out.println(lala.getIssuedAt());

    }

}
