package com.zhang.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 下载文件
 * resources 目录下的头像图片，打开网址会自动询问是否下载图片
 */
public class ServletDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. 要获取下载文件的路径
        String realPath = "E:\\JavaWeb\\java-01-maven\\response\\src\\main\\resources\\image\\头像.jpg";
//        2. 下载的文件名是啥？
        String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
//        3. 设置想办法让浏览器能够支持(Content-Disposition)下载我们需要的东西,中文文件名URLEncoder.encode编码，否则有可能乱码
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
//        4. 获取下载文件的输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);
//        5. 创建缓冲区
        int len = 0 ;
        byte[] buffer = new byte[1024];
//        6. 获取OutputStream对象
        ServletOutputStream outputStream = resp.getOutputStream();
//        7. 将FileOutputStream流写入到buffer缓冲区,使用OutputStream将缓冲区中的数据输出到客户端！
        while ((len=fileInputStream.read(buffer)) !=-1){
            outputStream.write(buffer,0,len);
        }
//        8. 关闭流
        outputStream.close();
        fileInputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
