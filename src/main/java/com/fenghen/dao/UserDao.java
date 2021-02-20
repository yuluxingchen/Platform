package com.fenghen.dao;

import com.fenghen.pojo.User;

public interface UserDao {

    public User findByEmailAndPwd(String emailname, String pwd);

    public User findByEmail(String emailname);

    public void add(User user);
}
