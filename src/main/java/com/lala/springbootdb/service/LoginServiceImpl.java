package com.lala.springbootdb.service;

import com.lala.springbootdb.dao.LoginDao;
import com.lala.springbootdb.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import sun.security.provider.MD5;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public Users selectByname(String username, String password, Boolean isRememberMe) {
        Users users = loginDao.selectByname(username);
        if(users.getPassword().equals(password)) {
            return users;
        }else {
            return null;
        }
    }
}
