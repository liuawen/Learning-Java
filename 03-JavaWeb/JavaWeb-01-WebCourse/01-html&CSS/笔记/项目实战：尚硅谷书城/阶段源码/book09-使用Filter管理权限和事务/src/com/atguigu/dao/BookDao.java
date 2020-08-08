package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Book;

/**
 * @author wzg
 *
 */
public interface BookDao {

	// 增
	public int save(Book book) throws Exception;

	// 删
	public int deleteById(int id) throws Exception;

	// 改
	public int update(Book book) throws Exception;

	// 查
	public List<Book> queryAllBook() throws Exception;

	// 根据id查找
	public Book findBookById(int id) throws Exception;

	public List<Book> queryForPageItems(long begin, long size) throws Exception;

	public long queryForPageTotalCount() throws Exception;

	public long queryForPageTotalCount(double min, double max) throws Exception;

	public List<Book> queryForPageItems(long begin, long size, double min, double max) throws Exception;
}
