package com.lala.springbootdb.common.vo;

import java.io.Serializable;
import java.util.List;

public class PageObject<T> implements Serializable {

    //总页数
    private Integer pageCount=0;
    //当前页
    private Integer pageCurrent=1;
    //页面大小
    private Integer pageSize;
    //总行数
    private Integer rowCount=0;
    //当前页记录
    private List<T> records;
    public PageObject(){}
    public PageObject(Integer pageCount,Integer pageCurrent,Integer pageSize,Integer pageRow,Integer rowCount){
        this.pageCount=pageCount;
        this.pageCurrent=pageCurrent;
        this.rowCount=pageRow;
        this.pageSize=pageSize;

    }


    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
