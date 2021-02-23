package com.fenghen.service.impl;

import com.fenghen.dao.ArticleDao;
import com.fenghen.dao.impl.ArticleDaoImpl;
import com.fenghen.pojo.Article;
import com.fenghen.pojo.User;
import com.fenghen.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    ArticleDao articleDao = new ArticleDaoImpl();

    @Override
    public Article QueryByTitleAndAuthor(String title, String author) {
        Article article = articleDao.findByTitleAndAuthor(title, author);
        return article;
    }

    @Override
    public List<Article> QueryByTitle(String title) {
        List<Article> articleList = articleDao.findByTitle(title);
        return articleList;
    }

    @Override
    public List<Article> QueryByUsername(String username) {
        List<Article> articleList = articleDao.findByAuthor(username);
        return  articleList;
    }

    @Override
    public boolean Add(Article article) {
        //判断标题是否存在
        Article title = articleDao.findByTitleAndAuthor(article.getTitle(), article.getAuthor());
        if(title != null){      //如果存在返回false表示不为空
            return false;
        }

        articleDao.add(article);
        return true;
    }

    @Override
    public boolean Modify(Article article) {
        //判断标题是否存在
        Article title = articleDao.findByTitleAndAuthor(article.getTitle(), article.getAuthor());
        if(title != null){      //如果存在返回false表示不为空
            return false;
        }

        articleDao.modify(article);
        return true;
    }

    @Override
    public boolean Delete(Article article) {
        //判断标题是否存在
        Article title = articleDao.findByTitleAndAuthor(article.getTitle(), article.getAuthor());
        if(title != null){      //如果存在返回false表示不为空
            return false;
        }

        articleDao.delete(article);
        return true;
    }
}
