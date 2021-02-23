package com.fenghen.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求中的地址
        StringBuffer requestURL = request.getRequestURL();
        //获取地址中最后一根斜线的内容以及获取方法的名称
        String methodName = requestURL.substring(requestURL.lastIndexOf("/") + 1);
        //获取对应的方法对象
        //1、获取子类的对象信息
        Class<?> clz = this.getClass();
        //2、获取子类中对应的方法
        try {
            Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
