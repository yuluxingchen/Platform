package com.fenghen.dao.impl;

import com.fenghen.dao.UserDao;
import com.fenghen.pojo.User;
import com.fenghen.utils.DateUtil;
import com.fenghen.utils.IDUtil;
import com.fenghen.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    //访问数据库使用QueryRunner对象来完成
    QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

    //通过邮箱名和密码查找
    @Override
    public User findByEmailAndPwd(String emailname, String pwd) {
        String sql = "select * from user where emailname=? and password=?";
        User user = null;
        try {
            user = runner.query(sql, new BeanHandler<>(User.class), emailname, pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    //通过邮箱查找
    @Override
    public User findByEmail(String emailname) {
        String sql = "select * from user where emailname = ?";
        User user = null;
        try {
            user = runner.query(sql,new BeanHandler<>(User.class),emailname);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByUsernameAndPwd(String username, String pwd) {
        String sql = "select * from user where username = ? and password = ?";
        User user = null;
        try {
            user = runner.query(sql,new BeanHandler<>(User.class), username, pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        String sql = "select * from user where username = ?";
        User user = null;
        try {
            user = runner.query(sql,new BeanHandler<>(User.class), username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    //增添用户信息
    @Override
    public void add(User user) {
        String sql = "insert into user(id,username, emailname, password, register_time) values(?,?,?,?,?)";
        String id = "U" + IDUtil.MakeID();
        try {
            runner.update(sql,id,user.getUsername(),user.getEmailname(),user.getPassword(),DateUtil.DatetoString(user.getRegister_time()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
