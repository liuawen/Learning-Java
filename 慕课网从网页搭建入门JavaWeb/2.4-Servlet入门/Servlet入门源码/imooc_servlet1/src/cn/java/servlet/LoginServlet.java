package cn.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取表单提交过来的数据
        // getParameter()方法可以获取请求的参数信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 打印获取到的参数信息
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        // 如果usename=admin，password=123则跳转到success.jsp，否则跳转到fail.jsp
        // 1、通过转发实现跳转
        
        
        //  admin    123  
        if ("admin".equals(username) && "123".equals(password)) {
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            // request.getRequestDispatcher("/fail.jsp").forward(request,
            // response);
            response.sendRedirect("/imooc_servlet1/fail.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
