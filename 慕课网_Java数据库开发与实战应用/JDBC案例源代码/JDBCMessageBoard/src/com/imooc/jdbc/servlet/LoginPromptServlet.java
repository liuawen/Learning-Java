package com.imooc.jdbc.servlet;

import com.imooc.jdbc.bean.User;
import com.imooc.jdbc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跳转到登录页面的Servlet
 *
 * @version 1.0
 */
public class LoginPromptServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(request, response);
    }

}
