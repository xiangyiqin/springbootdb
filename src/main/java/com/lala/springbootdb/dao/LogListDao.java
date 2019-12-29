package com.lala.springbootdb.dao;

import com.lala.springbootdb.pojo.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface LogListDao {

    public int getRow(@Param("username") String username);

    public List<SysLog> selectByUsername(@Param("startIndex") Integer startIndex,@Param("pageSize1") Integer pageSize1,@Param("username") String username);
    public int deleteOne(@Param("ids") Integer... ids);
}
