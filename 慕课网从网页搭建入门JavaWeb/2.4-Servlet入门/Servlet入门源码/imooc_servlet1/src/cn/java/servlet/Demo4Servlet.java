package cn.java.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Demo4Servlet")
public class Demo4Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 转发带数据给某个jsp页面
        // request.setAttribute("username", "王二麻子 ");
        // request.getRequestDispatcher("/demo.jsp").forward(request, response);

        // 通过重定向带数据过去
        ServletContext sc = request.getServletContext();
        sc.setAttribute("goods", "娃娃");
        response.sendRedirect("/imooc_servlet1/demo.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
