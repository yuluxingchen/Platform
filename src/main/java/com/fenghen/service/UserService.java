package com.fenghen.service;

import com.fenghen.pojo.User;

public interface UserService {

    User login(String emailname, String pwd);

    boolean regist(User user);
}
