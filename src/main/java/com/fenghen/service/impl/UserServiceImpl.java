package com.fenghen.service.impl;

import com.fenghen.dao.UserDao;
import com.fenghen.dao.impl.UserDaoImpl;
import com.fenghen.pojo.User;
import com.fenghen.service.UserService;

public class UserServiceImpl implements UserService {

    //创建数据库访问对象
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String emailname, String pwd) {
        return userDao.findByEmailAndPwd(emailname, pwd);
    }

    @Override
    public String regist(User user) {
        //判断邮箱是否存在
        User email = userDao.findByEmail(user.getEmailname());
        if(email != null){      //如果存在返回false表示不为空
            return "EmailNotNull";
        }

        User name = userDao.findByUsername(user.getUsername());
        if(name != null){
            return "UsernameNotNull";
        }

        //如果不存在则添加一个
        userDao.add(user);
        return "Success";
    }
}
