package com.fenghen.dao.impl;

import com.fenghen.dao.UserDao;
import com.fenghen.pojo.User;
import com.fenghen.utils.DateUtil;
import com.fenghen.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    //访问数据库使用QueryRunner对象来完成
    QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

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
    public void add(User user) {
        String sql = "insert into user(username, emailname, password, register_time) values(?,?,?,?)";
        try {
            runner.update(sql,user.getUsername(),user.getEmailname(),user.getPassword(),DateUtil.DatetoString(user.getRegister_time()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
