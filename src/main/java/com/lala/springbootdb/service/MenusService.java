package com.lala.springbootdb.service;

import com.lala.springbootdb.common.vo.Node;
import com.lala.springbootdb.pojo.Menus;

import java.util.List;

public interface MenusService {
    public List<Menus> selectAll();
    int selectParent(Integer id);
    int deleteObject(Integer id);
    int insertObject(Menus menus);

    List<Node> doFindZtreeMenuNodes();
}
