package com.fenghen.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fenghen.common.Result;
import com.fenghen.dao.UserDao;
import com.fenghen.dao.impl.UserDaoImpl;
import com.fenghen.pojo.Article;
import com.fenghen.service.ArticleService;
import com.fenghen.service.impl.ArticleServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/article/*")
public class ArticleServlet extends BaseServlet {
    ArticleService articleService = new ArticleServiceImpl();
    public void makepost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        //获取前端传回的值
        Map<String,String[]> parameterMap = request.getParameterMap();

        Article article = new Article();

        //将传回的值赋给指定对象
        try {
            BeanUtils.populate(article,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //设置文章的发布时间
        article.setDate(new Date());

        //调用业务层完成添加的任务
        boolean flag = articleService.Add(article);

        //根据注册结果返回对应消息
        Result result = new Result();
        if(flag){
            result.setFlag(true);
            result.setMsg("添加成功");
        }else{
            result.setFlag(false);
            result.setMsg("文章名重复");
        }

        ObjectMapper mapper = new ObjectMapper();
        String resultJson = mapper.writeValueAsString(result);
        out.print(resultJson);
    }

    public void searchpost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        //如果前台的数据很多时，可使用BeanUtils.Populate()方法快速获取表中数据
        //封装到实体对象中，前提要保存表单数据的名字和实体对象属性名一致
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        //获取前端传回的值
        Map<String,String[]> parameterMap = request.getParameterMap();

        for(Map.Entry<String, String[]> entry : parameterMap.entrySet()){
            String mapKey = entry.getKey();
            String[] mapValue = entry.getValue();
            System.out.println(mapKey+":"+ Arrays.toString(mapValue));
        }

        Article article = new Article();

        //将传回的值赋给指定对象
        try {
            BeanUtils.populate(article,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用业务层完成添加的任务
        List<Article> data = articleService.QueryByTitle(article.getTitle());
        //根据查询结果返回对应消息
        Result result = new Result();
        if(data != null){
            result.setFlag(true);
            result.setData(data);
        }else{
            result.setFlag(false);
            result.setMsg("文章不存在");
        }

        ObjectMapper mapper = new ObjectMapper();
        String resultJson = mapper.writeValueAsString(result);
        out.print(resultJson);
    }
}
