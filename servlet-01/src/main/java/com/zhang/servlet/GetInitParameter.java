package com.zhang.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取初始化参数
 * servlet : GetInitParameter
 * url-pattern : /getp
 */
public class GetInitParameter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得对象
        ServletContext context = this.getServletContext();
        //获得参数
        String url = context.getInitParameter("url");
        //输出到浏览器
        resp.getWriter().println(url);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
