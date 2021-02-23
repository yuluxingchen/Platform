package com.fenghen.dao.impl;

import com.fenghen.pojo.User;
import com.fenghen.utils.JDBCUtils;
import junit.framework.TestCase;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImplTest extends TestCase {

    public void testFindByEmail() {
        //创建一个Runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "select * from user where emailname = ?";
        User user = null;
        try {
            user = runner.query(sql,new BeanHandler<>(User.class),"hello@qq.com");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}