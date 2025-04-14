package com.yls.service;

import com.yls.pojo.User;

public interface UserService {
    //根据用户名查询用户
    User findByUserName(String username);

    //注册
    void register(String username, String password);

    //更新
    void update(User user);

    //上传图片
    void updateAvatar(String avatarUrl);
}
