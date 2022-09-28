package com.chiyume.servlet;

import com.chiyume.pojo.User;
import com.chiyume.service.UserService;
import com.chiyume.service.impl.ImplUserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取所有user信息
        UserService userService = new ImplUserService();
        List<User> allUser = userService.getAllUser();
//        存入application
        ServletContext application = req.getSession().getServletContext();
        application.setAttribute("allUser", allUser);

//        跳转到userList.jsp
        req.getRequestDispatcher("userList.jsp").forward(req, resp);

    }
}
