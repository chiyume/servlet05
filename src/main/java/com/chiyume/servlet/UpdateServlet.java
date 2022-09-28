package com.chiyume.servlet;

import com.chiyume.pojo.User;
import com.chiyume.service.UserService;
import com.chiyume.service.impl.ImplUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
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

        if(id != null && roleId == null){
            UserService userService = new ImplUserService();
            User userById = userService.getUserById(Integer.parseInt(id));
            req.getSession().setAttribute("userById", userById);
            req.getSession().setAttribute("userId", id);
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            return;
        }
//        判断数据是否输入完整
        if(id==null || roleId==null || userName == null || status==null|| trueName==null || password==null || gender==null||phone==null|| address==null||identity==null){
            req.setAttribute("updateMessage", "请输入完整数据提交修改");
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            return;
        }
//        number ，int不能为空
        if(id.equals("") || roleId.equals("") || status.equals("")){
            req.setAttribute("updateMessage", "请输入完整数据提交修改");
            req.getRequestDispatcher("update.jsp").forward(req, resp);
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
        int i = userService.updateById(Integer.parseInt(id), user);
        if(i>0){
            req.setAttribute("updateMessage", "修改成功");
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        }else {
            req.setAttribute("updateMessage", "修改失败");
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        }
    }
}
