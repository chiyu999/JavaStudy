package com.zhang.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码功能，后端实现一个简易的自动刷新的验证码
 */
public class ServletImage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //让浏览器5秒自动刷新一次
        resp.setHeader("refresh","3");
        //在内存中创建一个图片,执行后会是一个什么都没有的矩形
        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        //得到图片，需要画笔画我们想要的东西上去
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        //设置画笔颜色
        graphics.setColor(Color.white);
        //填充背景颜色
        graphics.fillRect(0,0,100,50);
        //给图片写数据，这里生成一个随机的6位数字的验证码写上去
        graphics.setColor(Color.pink);
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(getVeri(),0,50);
        //告诉浏览器，这个请求用图片的形式打开
        resp.setContentType("image/png");
        //网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        //把图片写给浏览器
        ImageIO.write(image,"png",resp.getOutputStream());

    }
    //获得验证码 get verification code
    private String getVeri(){
        Random random = new Random();
        String num = random.nextInt(999999)+"";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6-num.length(); i++) {
            stringBuffer.append(0);
        }
        //保证每次生成的都会是6位数
        num = stringBuffer.toString()+num;
        return num;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
