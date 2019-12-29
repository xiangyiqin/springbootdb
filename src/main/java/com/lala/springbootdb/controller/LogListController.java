package com.lala.springbootdb.controller;

import com.lala.springbootdb.common.vo.JsonResult;
import com.lala.springbootdb.common.vo.PageObject;
import com.lala.springbootdb.pojo.SysLog;
import com.lala.springbootdb.service.LogListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/log")
public class LogListController {
    @Autowired
    private LogListService logListService;
    @RequestMapping("log_list")
    public String doLogList(){
        return "sys/log_list";
    }
    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindObjects(Integer pageCurrent,String username){
        PageObject<SysLog> pageObject = logListService.selectByPage(pageCurrent,username);
        System.out.println(pageObject);
        return new JsonResult(pageObject);
    }
    @RequestMapping("doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(Integer... ids){
        int row = logListService.deleteByids(ids);

        System.out.println(row);
        return new JsonResult("delete OK");
    }

}
