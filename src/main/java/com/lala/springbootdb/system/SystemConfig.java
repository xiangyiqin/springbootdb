package com.lala.springbootdb.system;

import com.lala.springbootdb.common.interceptor.JWTinterceptor;
import com.lala.springbootdb.common.interceptor.JWTinterceptorCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class SystemConfig implements WebMvcConfigurer  {
   @Autowired
    private JWTinterceptorCookie jwTinterceptorCookie;
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        *//*registry.addInterceptor(jwTinterceptor).addPathPatterns("/**")
                .excludePathPatterns("/doLogin").excludePathPatterns("/templates/pages/login.html");*//*
    }*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwTinterceptorCookie).addPathPatterns("/**")
                .excludePathPatterns("/doLogin","/bower_components/**","/build/**","/dist/**","/plugins/**");

    }
    /**
     *
     * 注册添加拦截器
     */
   /* @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("========== 进入自定义拦截器 ==========");
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(jwTinterceptor).addPathPatterns("/**")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/doLogin")
        ;
    }
*/

    /**
     * 添加默认主页，访问域名或者端口跳转
     */


    /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwTinterceptor).addPathPatterns("/**").excludePathPatterns("/doLogin").excludePathPatterns("/static/**");
    }*/
}
