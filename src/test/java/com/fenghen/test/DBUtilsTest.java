package com.fenghen.test;

import com.fenghen.dao.UserDao;
import com.fenghen.dao.impl.UserDaoImpl;
import com.fenghen.pojo.User;
import com.fenghen.utils.DateUtil;
import com.fenghen.utils.IDUtil;
import com.fenghen.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

public class DBUtilsTest {
    @Test
    public void test1() {
        //创建一个Runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //调用runner对象的update（）方法进行增、删、改
        String sql = "insert into user(username, emailname, password, register_time) values(?,?,?,?)";
        Date date = new Date();
        try {
            runner.update(sql, "admin1", "admin1@qq.com", "admin1", DateUtil.DatetoString(date));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Test
    public void test2() {
        //创建一个Runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //调用runner对象的update（）方法进行增、删、改
        String sql = "delete from user where emailname=?";
        try {
            runner.update(sql, "admin1@qq.com");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void test3() {
        //创建一个Runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //调用runner对象的update（）方法进行增、删、改
        String sql = "update user set password=? where emailname=?";
        try {
            runner.update(sql, "admin2", "admin1@qq.com");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void test4() {
        //创建一个Runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //查询操作
        String sql = "select * from user where emailname=?";
        try {
            User user = runner.query(sql, new BeanHandler<>(User.class), "admin@qq.com");
            System.out.println(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void test5() {
        //创建一个Runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //查询操作
        String sql = "select count(*) from user";
        try {
            Long count = runner.query(sql, new ScalarHandler<>());
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void test6() {
        //创建一个Runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //插入操作
        String sql = "insert into post(tID,uid,uName,tTitle,tContents,tTime) values(?,?,?,?,?,?)";
        String tid = "A" + IDUtil.MakeID();
        Date date = new Date();
        try {
            runner.update(sql, tid, "1", "qianhuan", "1", "123", DateUtil.DatetoString(date));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void test7() {
        //创建一个Runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //修改操作
        String sql = "update post set tContents = ? where tTitle = ? and uName = ? ";
        try {
            runner.update(sql, "456", "1", "qianhuan");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void test8() {
        //创建一个Runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //修改操作
        String sql = "delete from post where tTitle = ? and uName = ? ";
        try {
            runner.update(sql,  "1", "qianhuan");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
