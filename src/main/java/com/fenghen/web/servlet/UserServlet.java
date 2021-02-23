package com.fenghen.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fenghen.common.Result;
import com.fenghen.pojo.User;
import com.fenghen.service.UserService;
import com.fenghen.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();
    public void login(HttpServletRequest request, HttpServletResponse response)throws IOException {
        //如果前台的数据很多时，可使用BeanUtils.Populate()方法快速获取表中数据
        //封装到实体对象中，前提要保存表单数据的名字和实体对象属性名一致
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        //1、接收用户传来的用户名和密码
        String emailname = request.getParameter("emailname");
        String pwd = request.getParameter("pwd");

        //2、验证部分
        User user = userService.login(emailname, pwd);

        //3、创建一个结果对象
        Result result = new Result();

        //4、对User类进行判断，若为null则不存在
        if (user == null) {
            result.setFlag(false);
            result.setMsg("邮箱地址或密码错误");
        }else {
            result.setFlag(true);
            result.setMsg("登陆成功");
            //登陆成功后将用户的信息保存到session中
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
        //将对象转换为json
        ObjectMapper mapper = new ObjectMapper();
        String resultJson = mapper.writeValueAsString(result);
        out.print(resultJson);
    }

    public void register(HttpServletRequest request, HttpServletResponse response)throws IOException {
        //如果前台的数据很多时，可使用BeanUtils.Populate()方法快速获取表中数据
        //封装到实体对象中，前提要保存表单数据的名字和实体对象属性名一致
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        Map<String,String[]> parameterMap = request.getParameterMap();

        for(Map.Entry<String, String[]> entry : parameterMap.entrySet()){
            String mapKey = entry.getKey();
            String[] mapValue = entry.getValue();
            System.out.println(mapKey + ":" + Arrays.toString(mapValue));
        }

        User user = new User();

        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //设置用户的注册时间
        user.setRegister_time(new Date());

        //调用业务层完成添加的任务
        String flag = userService.regist(user);

        //根据注册结果返回对应消息
        Result result = new Result();
        if(flag == "Success"){
            result.setFlag(true);
            result.setMsg("注册成功");
        }else if(flag == "EmailNotNull"){
            result.setFlag(false);
            result.setMsg("邮箱地址重复");
        }else if(flag == "UsernameNotNull"){
            result.setFlag(false);
            result.setMsg("用户名重复");
        }

        //将对象转换为json
        ObjectMapper mapper = new ObjectMapper();
        String resultJson = mapper.writeValueAsString(result);
        out.print(resultJson);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        session.invalidate();

        Result result = new Result();
        result.setFlag(true);

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(result);

        response.getWriter().print(s);
    }

    public void findUserNickName(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        response.setContentType("application/json");
        //无则创建，有则获取
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        ObjectMapper mapper = new ObjectMapper();
        //返回的结果对象
        Result result = new Result();
        result.setFlag(true);
        result.setData(user);

        String s = mapper.writeValueAsString(result);
        response.getWriter().print(s);
    }
}
