package com.yls.service.impl;

import com.yls.pojo.User;
import com.yls.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findByUserName(String username) {
        return null;
    }

    @Override
    public void register(String username, String password) {

    }
}
