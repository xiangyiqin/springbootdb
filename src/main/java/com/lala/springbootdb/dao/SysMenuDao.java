package com.lala.springbootdb.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuDao {
    List<String> findPermissions(@Param("menuIds") Integer...menuIds);
}
