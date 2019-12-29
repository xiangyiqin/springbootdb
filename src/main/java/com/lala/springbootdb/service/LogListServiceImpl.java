package com.lala.springbootdb.service;

import com.lala.springbootdb.common.vo.PageObject;
import com.lala.springbootdb.dao.LogListDao;
import com.lala.springbootdb.pojo.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class LogListServiceImpl implements LogListService {
    @Autowired
    private LogListDao logListDao;


    @Override
    public PageObject<SysLog> selectByPage(Integer pageCurrent,String username) {
        int row = logListDao.getRow(username);
        int zongyeshu=0;
        int size=3;
        System.out.println(row/size);
        if(row%size==0){
            zongyeshu=row/size;
        }else {
            zongyeshu=row/size+1;
        }
        List<SysLog> sysLogs = logListDao.selectByUsername(size * (pageCurrent - 1), size,username);
        PageObject<SysLog> pageObject=new PageObject<SysLog>();
        pageObject.setPageCount(zongyeshu);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(size);
        pageObject.setRowCount(row);
        pageObject.setRecords(sysLogs);


        return pageObject;
    }

    @Override
    public int deleteByids(Integer... ids) {


            int row = logListDao.deleteOne(ids);
        System.out.println(row+"aaaaaaaaaaaaaaaaaa");

        return row;
    }
}
