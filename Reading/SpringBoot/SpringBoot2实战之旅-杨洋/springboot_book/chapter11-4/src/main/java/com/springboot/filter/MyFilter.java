package com.springboot.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter被调用");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
        //只有符合条件的可以直接请求，不符合的跳转到/online请求去
        String requestUri = httpServletRequest.getRequestURI();
        System.out.println("请求地址是："+requestUri);
        if (requestUri.indexOf("/addSession") != -1
                || requestUri.indexOf("/removeSession") != -1
                || requestUri.indexOf("/online") != -1
                || requestUri.indexOf("/favicon.ico") != -1) {
            chain.doFilter(request, response);
        } else {
            wrapper.sendRedirect("/online");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //在服务启动时初始化
        System.out.println("初始化拦截器");
    }

    @Override
    public void destroy() {
        //在服务关闭是销毁
        System.out.println("销毁拦截器");
    }
}
