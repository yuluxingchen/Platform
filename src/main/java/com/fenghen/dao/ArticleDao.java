package com.fenghen.dao;

import com.fenghen.pojo.Article;

import java.util.List;

public interface ArticleDao {

    List<Article> findAll();

    Article findByTitleAndAuthor(String title, String author);

    List<Article> findByTitle(String title);

    List<Article> findByAuthor(String author);

    void add(Article article);

    void modify(Article article);

    void delete(Article article);
}
