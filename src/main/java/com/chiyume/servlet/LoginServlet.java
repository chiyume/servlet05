package com.chiyume.servlet;

import com.chiyume.pojo.User;
import com.chiyume.service.UserService;
import com.chiyume.service.impl.ImplUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username!=null && password!=null){
            System.out.println(username+"--"+password);
            UserService userService = new ImplUserService();
            User userByName = userService.getUserByName(username);
            if (userByName.getPassword().equals(password)){
                req.getSession().setAttribute("activeUser", userByName);

                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }else {
            System.out.println("重定向回到login页面");
//            重定向，服务器下的绝对路径
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }

    }
}
