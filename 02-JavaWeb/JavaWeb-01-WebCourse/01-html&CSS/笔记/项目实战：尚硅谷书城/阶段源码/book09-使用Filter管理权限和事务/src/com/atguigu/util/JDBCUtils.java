package com.atguigu.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 获取数据库连接的工具类
 * 
 * @author wzg
 *
 */
public class JDBCUtils {

	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("book_devoloper");
	/**
	 * 使用ThreadLocal保存Connection对象
	 */
	private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

	private JDBCUtils() {
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return 如果获取连接成功，返回数据的连接对象。<br/>
	 *         如果获取数据库连接失败，则返回null
	 */
	public static Connection getConnection() {
		// 先从ThreadLocal中获取
		Connection connection = connectionThreadLocal.get();
		try {
			if (connection == null) {
				// 从c3p0中获取数据库连接
				connection = dataSource.getConnection();
				// 设置事务为手动提交
				connection.setAutoCommit(false);
				connectionThreadLocal.set(connection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 释放数据库连接
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 释放数据库连接
	 */
	public static void closeConnection() {
		// 从线程ThreadLocal中获取
		Connection conn = connectionThreadLocal.get();
		if (conn != null) {
			try {
				// 事务提交
				conn.commit();
				// 事务关闭
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 移除
		connectionThreadLocal.remove();
	}

	public static void rollback() {
		// 从线程ThreadLocal中获取
		Connection conn = connectionThreadLocal.get();
		if (conn != null) {
			try {
				// 事务回滚
				conn.rollback();
				// 关闭连接
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 移除
		connectionThreadLocal.remove();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getConnection());
		}
	}
}
