package com.lala.springbootdb.dao;

import com.lala.springbootdb.common.vo.Node;
import com.lala.springbootdb.pojo.Menus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Mapper
public interface MenusDao {
    public int getRow();
    public List<Menus> selectAll();

    int deleteObject(@Param("id") Integer id);
    int selectParentId(@Param("id") Integer id);
    int insertObject(@Param("menus") Menus menus);

    List<Node> doFindZtreeMenuNodes();
}
