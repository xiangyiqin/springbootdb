package com.lala.springbootdb.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleDao {
    public List<Integer> findRoleIdByUserId( Integer id);
}
