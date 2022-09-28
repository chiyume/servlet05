package com.chiyume.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取新的文件名
        String fileName = request.getParameter("fileName");
//        获取上传文件
        Part uploadFile = request.getPart("file");
//        上传文件存放路径
        String realPath = request.getServletContext().getRealPath(request.getContextPath());
        System.out.println(realPath);

    }
}
