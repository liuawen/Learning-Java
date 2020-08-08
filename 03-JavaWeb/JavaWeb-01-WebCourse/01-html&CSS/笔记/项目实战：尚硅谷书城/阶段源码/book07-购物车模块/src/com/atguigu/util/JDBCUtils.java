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

	private static ComboPooledDataSource dataSource = new ComboPooledDataSource(
			"book_devoloper");

	private JDBCUtils() {
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return 如果获取连接成功，返回数据的连接对象。<br/>
	 *         如果获取数据库连接失败，则返回null
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			// 从c3p0中获取数据库连接
			connection = dataSource.getConnection();
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

	public static void main(String[] args) {
		getConnection();
	}
}
