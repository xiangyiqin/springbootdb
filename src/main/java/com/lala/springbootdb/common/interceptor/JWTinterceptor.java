package com.lala.springbootdb.common.interceptor;


import com.lala.springbootdb.common.util.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class JWTinterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JWTUtil jwtUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        String authorization = request.getHeader("Authorization");
        if(authorization!=null&&authorization.startsWith("Bearer")){
            String token = authorization.replace("Bearer ", "");
            Claims claims = jwtUtil.parseJwt(token);
            if(claims!=null){
                request.setAttribute("user_claims",claims);
                return true;
            }
        }else {

            response.sendRedirect(request.getContextPath()+"/doLogin");//拦截后跳转的方法

            return false;
        }

        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //controller方法处理完毕后，调用此方法
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //页面渲染完毕后调用此方法
    }
}
