package com.fenghen.service;

import com.fenghen.pojo.Article;
import com.fenghen.pojo.User;

import java.util.List;

public interface ArticleService {

    //查询全部文章
    List<Article> QueryAll();

    //通过文章名和作者进行查询
    Article QueryByTitleAndAuthor(String title, String username);

    //通过文章名查询
    List<Article> QueryByTitle(String title);

    //通过作者查询
    List<Article> QueryByUsername(String username);

    //添加文章
    boolean Add(Article article);

    //修改文章
    boolean Modify(Article article);

    //删除文章
    boolean Delete(Article article);
}
