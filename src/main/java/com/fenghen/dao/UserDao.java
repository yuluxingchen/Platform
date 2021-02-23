package com.fenghen.dao;

import com.fenghen.pojo.User;

public interface UserDao {

    //通过邮箱和密码查找
    User findByEmailAndPwd(String emailname, String pwd);

    //通过邮箱查找
    User findByEmail(String emailname);

    //通过用户名和密码查找
    User findByUsernameAndPwd(String username, String pwd);

    //通过用户名查找
    User findByUsername(String username);

    //添加用户
    void add(User user);
}
