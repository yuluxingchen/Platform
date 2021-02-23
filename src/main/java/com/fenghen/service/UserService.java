package com.fenghen.service;

import com.fenghen.pojo.User;

public interface UserService {

    //登陆操作
    User login(String emailname, String pwd);

    //注册操作
    String regist(User user);
}
