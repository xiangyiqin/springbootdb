package com.lala.springbootdb.service;

import com.lala.springbootdb.pojo.Users;

public interface UsersService {
    public Users findByUserName(String username);
}
