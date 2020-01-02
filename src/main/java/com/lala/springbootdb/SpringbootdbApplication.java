package com.lala.springbootdb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableCaching
@Configuration
@MapperScan("com.lala.springbootdb.dao")
public class SpringbootdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdbApplication.class, args);
    }

}
