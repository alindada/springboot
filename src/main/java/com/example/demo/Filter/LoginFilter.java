package com.example.demo.Filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = {"/api/*"}, filterName = "loginFilter")
public class LoginFilter implements Filter {


    //容器加载的时候调用
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    //请求被拦截的时候进行调用
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤中");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String username = req.getParameter("key1");

        if ("xiaoming".equals(username)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.sendRedirect("/index.html");
            return;
        }


    }


    //容器被销毁的时候被调用
    @Override
    public void destroy() {
        System.out.println("销毁过滤");
    }
}
