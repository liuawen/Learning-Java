package com.atguigu.service.impl;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	public BookServiceImpl() {
		bookDao = new BookDaoImpl();
	}

	@Override
	public boolean save(Book book) throws Exception {
		int updateCount = bookDao.save(book);
		return updateCount > 0 ? true : false;
	}

	@Override
	public boolean deleteById(int id) throws Exception {
		int updateCount = bookDao.deleteById(id);
		return updateCount > 0 ? true : false;
	}

	@Override
	public boolean update(Book book) throws Exception {
		int updateCount = bookDao.update(book);
		return updateCount > 0 ? true : false;
	}

	@Override
	public List<Book> queryAllBook() throws Exception {
		return bookDao.queryAllBook();
	}

	@Override
	public Book findBookById(int id) throws Exception {
		return bookDao.findBookById(id);
	}

	@Override
	public Page<Book> page(long pageNo,long pageSize) throws Exception {
		Page<Book> bookPage = new Page<Book>();
		
		// 设置一页显示记录数
		bookPage.setPageSize(pageSize);
		
		// 总的记录数 select count(*) from t_book;
		long totalCount = bookDao.queryForPageTotalCount();
		bookPage.setTotalCount(totalCount);
		// 总的页数。公式： 总记录数 / 每页显示记录数 
		long pageTotal = totalCount / bookPage.getPageSize();
		/**
		 * 假设，我有8条记录。每页显示4条， 一共有2页 8 / 4
		 * 假设，我有9条记录。每页显示4条，一共有  1,2,3,4,   5,6,7,8,     9  
		 */
		if (totalCount % pageSize != 0) {
			pageTotal += 1;
		}
		bookPage.setPageTotal(pageTotal);
		
		// 设置分页，的当前页码
		bookPage.setPageNo(pageNo);
		
		long begin = ( bookPage.getPageNo() - 1 ) * bookPage.getPageSize();
		long size = bookPage.getPageSize();
		
		// 执行select * from t_book limit begin , size;
		List<Book> items = bookDao.queryForPageItems(begin , size);
		// 设置当页显示的数据集合
		bookPage.setItems(items);
		
		return bookPage;
	}

	@Override
	public Page<Book> pageByPrice(long pageNo, long pageSize, double min, double max) throws Exception {
		Page<Book> bookPage = new Page<Book>();
		
		// 设置一页显示记录数
		bookPage.setPageSize(pageSize);
		
		// 总的记录数 select count(*) from t_book;
		long totalCount = bookDao.queryForPageTotalCount(min,max);
		bookPage.setTotalCount(totalCount);
		// 总的页数。公式： 总记录数 / 每页显示记录数 
		long pageTotal = totalCount / bookPage.getPageSize();
		/**
		 * 假设，我有8条记录。每页显示4条， 一共有2页 8 / 4
		 * 假设，我有9条记录。每页显示4条，一共有  1,2,3,4,   5,6,7,8,     9  
		 */
		if (totalCount % pageSize != 0) {
			pageTotal += 1;
		}
		bookPage.setPageTotal(pageTotal);
		
		// 设置分页，的当前页码
		bookPage.setPageNo(pageNo);
		
		long begin = ( bookPage.getPageNo() - 1 ) * bookPage.getPageSize();
		long size = bookPage.getPageSize();
		
		// 执行select * from t_book wher price between min and max limit begin , size;
		List<Book> items = bookDao.queryForPageItems(begin , size , min , max);
		// 设置当页显示的数据集合
		bookPage.setItems(items);
		
		return bookPage;
	}

}
