package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

public interface BookService {

	// 增
	public boolean save(Book book);

	// 删
	public boolean deleteById(int id);

	// 改
	public boolean update(Book book);

	// 查
	public List<Book> queryAllBook();

	public Book findBookById(int id);

	public Page<Book> page(long pageNo,long pageSize);

	public Page<Book> pageByPrice(long pageNo, long pageSize, double min, double max);

}
