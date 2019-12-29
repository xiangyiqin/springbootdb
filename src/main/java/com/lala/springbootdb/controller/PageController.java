package com.lala.springbootdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("doIndexUI")
    public String doIndexUI(){
        return "starter";
    }
    @RequestMapping("/doPageUI")
    public String doPage(){
        return "common/page";
    }
}
