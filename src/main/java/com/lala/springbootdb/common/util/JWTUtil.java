package com.lala.springbootdb.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@ConfigurationProperties("jwt.config")
public class JWTUtil {
    private String key;
    private Long ttl;

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String creatJwt(String id, String name, Map<String,Object> map){
        long now = System.currentTimeMillis();
        long exp=now+ttl;
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setIssuedAt(new Date()).setSubject(name).signWith(SignatureAlgorithm.HS256, key);
        /*for(Map.Entry<String,Object> entry:map.entrySet()){
            jwtBuilder.claim(entry.getKey(),entry.getValue());
        }*/
        jwtBuilder.setExpiration(new Date(exp));
        String token = jwtBuilder.compact();

        return token;
    }
    public Claims parseJwt(String token){
        Claims body = Jwts.parser().setSigningKey(key)
                .parseClaimsJws(token).getBody();
        return body;
    }

}
