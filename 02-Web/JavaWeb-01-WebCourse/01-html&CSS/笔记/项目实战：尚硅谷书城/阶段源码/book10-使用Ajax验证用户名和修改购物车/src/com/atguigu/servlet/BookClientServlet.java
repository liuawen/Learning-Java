package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.util.Utils;

/**
 * Servlet implementation class BookClientServlet
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bookService;

	public BookClientServlet() {
		 bookService = new BookServiceImpl();
	}

	protected void pageByPrice(HttpServletRequest request, HttpServletResponse response)
			throws Exception, IOException {
		// 获取参数
		long pageNo = Utils.parseLong(request.getParameter("pageNo"), 1);
		long pageSize = Utils.parseLong(request.getParameter("pageSize"), Page.PAGE_SIZE);
		String minStr = request.getParameter("min");
		String maxStr = request.getParameter("max");
		double min = Utils.parseDouble(minStr, 0);
		double max = Utils.parseDouble(maxStr, Double.MAX_VALUE);
		
		// 查询分页信息
		Page<Book> bookPage = bookService.pageByPrice(pageNo, pageSize,min,max);
		
		String url = "client/bookServlet?action=pageByPrice";
		if (minStr != null && !"".equals(minStr)) {
			url += "&min=" + minStr;
		}
		if (maxStr != null && !"".equals(maxStr)) {
			url += "&max=" + maxStr;
		}
		
		bookPage.setUrl(url);
		// 存放到域对象中
		request.setAttribute("page", bookPage);
//		System.out.println(bookPage);
		// 转发到某个页面显示数据
		request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
	}

}
