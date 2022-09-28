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

public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String id = req.getParameter("id");
        if (id==null || id.equals("")){

            req.setAttribute("deleteMessage", "请输入id");
            req.getRequestDispatcher("deleteUser.jsp").forward(req, resp);
        }
        int deleteId = Integer.parseInt(id);
        UserService userService = new ImplUserService();
        int i = userService.deleteById(deleteId);
        if(i>0){
            req.setAttribute("deleteMessage", "删除成功！");
            req.getRequestDispatcher("deleteUser.jsp").forward(req, resp);
        }else {
            req.setAttribute("deleteMessage", "删除失败！");
            req.getRequestDispatcher("deleteUser.jsp").forward(req, resp);
        }
    }
}
