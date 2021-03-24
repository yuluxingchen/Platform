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

    //查询所有
    @Override
    public List<Article> findAll() {
        String sql = "select * from post";
        List<Article> articlelist = null;
        try {
            articlelist = runner.query(sql, new BeanListHandler<>(Article.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return articlelist;
    }

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
        String sql = "insert into post(tID,uID,uName,tTitle,tContents,tTime) values(?,?,?,?,?,?)";
        try {
            runner.update(sql, article.gettID(), article.getuID(), article.getuName(), article.gettTitle(), article.gettContents(), DateUtil.DatetoString(article.gettTime()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //修改文章
    @Override
    public void modify(Article article) {
        String sql = "update post set tContents = ? where tTitle = ? and uName = ? ";
        try {
            runner.update(sql, article.gettContents(), article.gettTitle(), article.getuName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //删除文章
    @Override
    public void delete(Article article) {
        String sql = "delete from post where tTitle = ? and uName = ? ";
        try {
            runner.update(sql, article.gettTitle(), article.getuName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
