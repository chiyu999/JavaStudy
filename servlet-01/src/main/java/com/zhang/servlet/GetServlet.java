package com.zhang.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext 数据共享 ，获取数据
 * servlet : GetServlet
 * url-pattern : /get
 */
public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得Context对象
        ServletContext context = this.getServletContext();
        //获得存放的字符串
        String  name = (String) context.getAttribute("name");
        //设置浏览器的相应格式
        resp.setContentType("text/html");
        //设置相应的编码格式
        resp.setCharacterEncoding("utf-8");
        //将相应信息打印
        resp.getWriter().println("名字："+name);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
