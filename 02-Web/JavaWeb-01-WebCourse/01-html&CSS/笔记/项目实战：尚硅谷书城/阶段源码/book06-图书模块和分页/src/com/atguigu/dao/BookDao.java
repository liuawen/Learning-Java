package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Book;

/**
 * @author wzg
 *
 */
public interface BookDao {

	// 增
	public int save(Book book);

	// 删
	public int deleteById(int id);

	// 改
	public int update(Book book);

	// 查
	public List<Book> queryAllBook();

	// 根据id查找
	public Book findBookById(int id);

	public List<Book> queryForPageItems(long begin, long size);

	public long queryForPageTotalCount();

	public long queryForPageTotalCount(double min, double max);

	public List<Book> queryForPageItems(long begin, long size, double min, double max);
}
