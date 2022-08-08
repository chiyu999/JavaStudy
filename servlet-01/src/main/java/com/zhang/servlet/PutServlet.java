package com.zhang.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * ServletContext 数据共享 ，存放数据
 * servlet : PutServlet
 * url-pattern : /put
 */
public class PutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this.getInitParameter()  初始化参数
        //this.getServletContext()  获得Servlet上下文对象
        //this.getServletConfig()   获得Servlet配置
        //要存放的数据
        String name = "张三";
        //获得ServletContext对象
        ServletContext context = this.getServletContext();
        //将数据存放到ServletContext中
        context.setAttribute("name",name);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
