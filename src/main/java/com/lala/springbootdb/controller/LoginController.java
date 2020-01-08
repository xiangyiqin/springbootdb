package com.lala.springbootdb.controller;

import com.lala.springbootdb.common.util.JWTUtil;
import com.lala.springbootdb.common.vo.JsonResult;
import com.lala.springbootdb.pojo.Users;
import com.lala.springbootdb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping("/doLogout")
    public String doLogOut(){
        return "login";
    }
    @RequestMapping("/doLogin")
    public String doLogin(){
        return "login";
    }
   /* @RequestMapping("/user/doLogin")
    public ModelAndView doLogin1(String username, String password, Boolean isRememberMe){
        ModelAndView modelAndView=new ModelAndView();
        Users users = loginService.selectByname(username, password, isRememberMe);

        String token = jwtUtil.creatJwt(users.getId().toString(), users.getUsername());
        modelAndView.addObject("token",token);
        System.out.println(users+"conrtoller");
        if(users!=null){
            modelAndView.setViewName("starter");
            System.out.println(modelAndView);
            return modelAndView;
        }else {
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }*/
   @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
   public ModelAndView doLogin1(String username, String password, Boolean isRememberMe, ModelAndView modelAndView, HttpServletResponse response){

       Users users = loginService.selectByname(username, password, isRememberMe);
       if(users!=null){
           String token = jwtUtil.creatJwt(users.getId().toString(), users.getUsername());
           Cookie cookie = new Cookie("token", token);
           cookie.setMaxAge(3600);
           cookie.setDomain("localhost");
           cookie.setPath("/");
           response.addCookie(cookie);
           modelAndView.addObject("token",token);
           modelAndView.setViewName("/starter");
           return modelAndView;
       }else {
           modelAndView.setViewName("login");
           return modelAndView;
       }
   }


}
