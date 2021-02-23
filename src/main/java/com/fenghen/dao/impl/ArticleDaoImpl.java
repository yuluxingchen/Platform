package com.fenghen.dao.impl;

import com.fenghen.dao.ArticleDao;
import com.fenghen.dao.UserDao;
import com.fenghen.pojo.Article;
import com.fenghen.pojo.User;
import com.fenghen.utils.DateUtil;
import com.fenghen.utils.IDUtil;
import com.fenghen.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {
    //访问数据库使用QueryRunner对象来完成
    QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

    //通过标题和用户名查找
    @Override
    public Article findByTitleAndAuthor(String title, String author) {
        String sql = "select * from post where tTitle = ? and uName = ?";
        Article article = null;
        try {
            article = runner.query(sql, new BeanHandler<>(Article.class),title,author);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return article;
    }

    //通过标题查找
    @Override
    public List<Article> findByTitle(String title){
        String sql = "select * from post where tTitle = ?";
        List<Article> articlelist = null;
        try {
            articlelist = runner.query(sql, new BeanListHandler<>(Article.class),title);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return articlelist;
    }

    //通过作者查找
    @Override
    public List<Article> findByAuthor(String username){
        String sql = "select * from post where uName = ?";
        List<Article> articlelist = null;
        try {
            articlelist = runner.query(sql, new BeanListHandler<>(Article.class),username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return articlelist;
    }

    //添加文章
    @Override
    public void add(Article article){
        String sql = "insert into post(tID,uid,uName,tTitle,tContents,tTime) values(?,?,?,?,?,?)";
        String tid = "A" + IDUtil.MakeID();
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findByUsername(article.getAuthor());
        try {
            runner.update(sql, tid, user.getId(), user.getUsername(), article.getTitle(), article.getContent(), DateUtil.DatetoString(article.getDate()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //修改文章
    @Override
    public void modify(Article article) {
        String sql = "update post set tContents = ? where tTitle = ? and uName = ? ";
        try {
            runner.update(sql, article.getContent(), article.getTitle(), article.getAuthor());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //删除文章
    @Override
    public void delete(Article article) {
        String sql = "delete from post where tTitle = ? and uName = ? ";
        try {
            runner.update(sql, article.getTitle(), article.getAuthor());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
