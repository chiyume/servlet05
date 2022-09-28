package com.chiyume.filter;

import com.chiyume.pojo.User;
import com.chiyume.service.UserService;
import com.chiyume.service.impl.ImplUserService;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object activeUser = request.getSession().getAttribute("activeUser");
        String requestURI = request.getRequestURI();
//        如果访问login页面直接放行
        if(requestURI.contains("login")){
            if(activeUser!=null){
                System.out.println("存在已经登录用户1");
//                存在登录用户放行
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }else{
                filterChain.doFilter(request, response);
            }
        }else if(requestURI.equals("/servlet05_war_exploded/")){
            if(activeUser!=null){
                System.out.println("存在已经登录用户1");
//                存在登录用户放行
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }else{
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }else {
            if(activeUser!=null){
                System.out.println("存在已经登录用户2");
//                存在登录用户放行
                filterChain.doFilter(request, response);
            }else{
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
