package com.lala.springbootdb.service;

import com.lala.springbootdb.common.vo.PageObject;
import com.lala.springbootdb.pojo.SysLog;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

public interface LogListService {

    PageObject<SysLog> selectByPage(Integer pageCurrent,String username);
    int deleteByids(Integer...ids);
}
