package com.lala.springbootdb.service;

import com.lala.springbootdb.pojo.Users;

public interface LoginService {
    public Users selectByname(String username,String password,Boolean isRememberMe);
}
