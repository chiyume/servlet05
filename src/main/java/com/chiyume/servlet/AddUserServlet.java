package com.chiyume.servlet;

import com.chiyume.pojo.User;
import com.chiyume.service.UserService;
import com.chiyume.service.impl.ImplUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String roleId = req.getParameter("roleId");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String trueName = req.getParameter("trueName");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String identity = req.getParameter("identity");
        String status = req.getParameter("status");
//        判断数据是否输入完整
        if(id==null || roleId==null || userName == null || status==null|| trueName==null || password==null || gender==null||phone==null|| address==null||identity==null){
            req.setAttribute("addMessage", "请输入完整数据提交添加");
            req.getRequestDispatcher("addUser.jsp").forward(req, resp);
            return;
        }
//        number ，int不能为空
        if(id.equals("") || roleId.equals("") || status.equals("")){
            req.setAttribute("addMessage", "请输入完整数据提交添加");
            req.getRequestDispatcher("addUser.jsp").forward(req, resp);
            return;
        }

        User user = new User();
        user.setAddress(address);
        user.setGender(gender);
        user.setId(Integer.parseInt(id));
        user.setRoleId(Integer.parseInt(roleId));
        user.setUserName(userName);
        user.setIdentity(identity);
        user.setPassword(password);
        user.setStatus(Integer.parseInt(status));
        user.setPhone(phone);
        user.setTrueName(trueName);

        UserService userService = new ImplUserService();
        int i = userService.addUser(user);
        if(i>0){
            req.setAttribute("addMessage", "数据添加成功！");
        }else {
            req.setAttribute("addMessage", "数据添加失败！");
        }
        req.getRequestDispatcher("addUser.jsp").forward(req, resp);
    }
}
