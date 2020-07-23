package com.itheima.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	 // 连接数据库的URL
	  private static final String URL = "jdbc:mysql://localhost:3306/mydb";
	  // 数据库用户名
	  private static final String USER = "root";
	  // 数据库密码
	  private static final String PASSWORD = "123456";
	  // 驱动程序类
	  private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	  /**
	   * 只注册驱动程序一次就可以(静态代码块中)
	   */
	  static {
	    try {
	      // 注册驱动
	      Class.forName(DRIVER_CLASS);
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	  }

	  /**
	   * 获取连接方法
	   * 
	   * @return
	   */
	public static Connection getConnection() {
		try {
			// 获取连接
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭资源方法（先关闭ResultSet，再关闭Statement，最后关闭Connection）
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
	  try {
	    if (rs != null) {
	      rs.close();
	    }
	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  try {
	    if (stmt != null) {
	      stmt.close();
	    }
	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  try {
	    if (conn != null) {
	      conn.close();
	    }
	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	}

	  /**
	   * 关闭只有2个对象的方法
	   */
	  public static void close(Connection conn, Statement stmt) {
	    close(conn, stmt, null);
	  }
}
