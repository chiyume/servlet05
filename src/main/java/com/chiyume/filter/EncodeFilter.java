package com.chiyume.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodeFilter implements Filter {
    private String encode = "utf-8";
    private String contentType = "text/html";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Encode Filter init …………");
        String encode = filterConfig.getInitParameter("encode");
        String contentType = filterConfig.getInitParameter("contentType");
        if (encode != null && !encode.equals("")){
            this.encode = encode;
        }
        if (contentType != null && !contentType.equals("")){
            this.contentType = contentType;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Encode Filter Running ………………");
        servletRequest.setCharacterEncoding(encode);
        servletResponse.setCharacterEncoding(encode);
        servletResponse.setContentType(contentType);
//
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Encode Filter Destroy ………………");
    }
}
