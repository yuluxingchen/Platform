package com.fenghen.dao.impl;

import java.util.Date;
import com.fenghen.dao.UserDao;
import com.fenghen.pojo.Article;
import com.fenghen.pojo.User;
import com.fenghen.utils.DateUtil;
import com.fenghen.utils.IDUtil;
import com.fenghen.utils.JDBCUtils;
import junit.framework.TestCase;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ArticleDaoImplTest extends TestCase {

    public void testFindByTitle() {
        //创建一个Runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //查询操作
        String sql = "select * from post where tTitle = ? ";
        try {
            Article article = runner.query(sql, new BeanHandler<>(Article.class), "123");
            System.out.println(article);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void testAdd() {
        //创建一个Runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        //查询操作
        String sql = "insert into post(tID,uID,uName,tTitle,tContents,tTime) values(?,?,?,?,?,?)";
        try {
            runner.update(sql, "3", "2", "千幻", "4", "5", DateUtil.DatetoString(new Date()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}