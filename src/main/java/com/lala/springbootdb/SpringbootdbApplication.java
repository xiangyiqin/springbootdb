package com.lala.springbootdb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableCaching
@Configuration
@MapperScan("com.lala.springbootdb.dao")
@ServletComponentScan(basePackages = "com.lala.springbootdb.fileter")

public class SpringbootdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdbApplication.class, args);
    }

}
