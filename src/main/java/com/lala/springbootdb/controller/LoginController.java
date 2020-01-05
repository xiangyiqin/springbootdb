package com.lala.springbootdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/doLogout")
    public String doLogOut(){
        return "login";
    }
    @RequestMapping("/doLogin")
    public String doLogin(){
        return "login";
    }

}
