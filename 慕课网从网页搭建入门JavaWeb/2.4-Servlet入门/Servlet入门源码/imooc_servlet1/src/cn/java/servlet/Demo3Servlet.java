package cn.java.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ServletConfig
public class Demo3Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 首先需要获取ServletConfig对象
        ServletConfig sc = this.getServletConfig();
        // 获取sc这个对象中封装的参数信息
        String encoding = sc.getInitParameter("encoding");
        System.out.println("encoding=" + encoding);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
