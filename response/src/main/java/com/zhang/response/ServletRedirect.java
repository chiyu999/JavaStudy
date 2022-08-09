package com.zhang.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现重定向
 * 请求转发跟重定向的区别：
 * 相同点 ： 页面都会实现跳转
 * 不同点 ：请求转发的时候，url不会产生变化
 *        重定向时候，url地址栏会发生变化；
 * void sendRedirect(String var1) throws IOException;
 */
public class ServletRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/r/si");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
