package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.util.Utils;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService;

	public BookServlet() {
		bookService = new BookServiceImpl();
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception,
			IOException {

		List<Book> books = bookService.queryAllBook();

		request.setAttribute("books", books);

		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws Exception,
			IOException {
		Book book = new Book();
		Utils.copyMap2Bean(request.getParameterMap(), book);
		bookService.save(book);
		response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo="
				+ request.getParameter("pageNo"));
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws Exception, IOException {

		Book book = new Book();
		Utils.copyMap2Bean(request.getParameterMap(), book);

		bookService.update(book);

		response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo="
				+ request.getParameter("pageNo"));
	}

	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws Exception, IOException {
		int id = Utils.parseInt(request.getParameter("id"), 0);
		Book book = bookService.findBookById(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception, IOException {
		String idStr = request.getParameter("id");
		int id = Utils.parseInt(idStr, 0);
		bookService.deleteById(id);
		response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo="
				+ request.getParameter("pageNo"));
	}

	protected void page(HttpServletRequest request, HttpServletResponse response) throws Exception,
			IOException {
		// 获取参数
		long pageNo = Utils.parseLong(request.getParameter("pageNo"), 1);
		long pageSize = Utils.parseLong(request.getParameter("pageSize"), Page.PAGE_SIZE);
		// 查询分页信息
		Page<Book> bookPage = bookService.page(pageNo, pageSize);
		bookPage.setUrl("manager/bookServlet?action=page");
		// 存放到域对象中
		request.setAttribute("page", bookPage);
		// System.out.println(bookPage);
		// 转发到某个页面显示数据
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

}
