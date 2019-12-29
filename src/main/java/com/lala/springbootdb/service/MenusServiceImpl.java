package com.lala.springbootdb.service;

import com.lala.springbootdb.common.vo.Node;
import com.lala.springbootdb.dao.MenusDao;
import com.lala.springbootdb.pojo.Menus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenusServiceImpl implements MenusService{
    @Autowired
    private MenusDao menusDao;
    @Override
    public List<Menus> selectAll() {
        List<Menus> menus = menusDao.selectAll();
        return menus;
    }

    @Override
    public int selectParent(Integer id) {
        int row=menusDao.selectParentId(id);
        return row;
    }

    @Override
    public int deleteObject(Integer id) {
        int row=menusDao.deleteObject(id);
        return row;
    }

    @Override
    public int insertObject(Menus menus) {
        int row=menusDao.insertObject(menus);
        return row;
    }

    @Override
    public List<Node> doFindZtreeMenuNodes() {
        List<Node> nodes=menusDao.doFindZtreeMenuNodes();
        return nodes;
    }
}
