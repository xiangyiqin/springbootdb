package com.lala.springbootdb.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMenuDao {
    List<Integer> findMenuIdsByRoleIds(@Param("roleIds") Integer...roleIds);
}
