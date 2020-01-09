package com.lala.springbootdb.dao;

import com.lala.springbootdb.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UsersDao {
    public Users findByUserName(@Param("username") String username);
}
