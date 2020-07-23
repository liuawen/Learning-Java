package com.atguigu.test06;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.atguigu.test04.TestPools;

public class JDBCToolsV3 {
	private static DataSource ds;
	private static ThreadLocal<Connection> th;
	
	static{
		try {
			//静态代码块
			Properties pro = new Properties();
			pro.load(TestPools.class.getClassLoader().getResourceAsStream("druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(pro);
			th = new ThreadLocal<Connection>();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//抛出编译时异常
	public static Connection getConnection() throws SQLException{
		//方式一：DriverManager.getConnection()
		//方式二：连接池对象.getConnection()
		Connection conn = th.get();//获取当前线程中的共享的连接对象
		if(conn == null){//当前线程没有拿过连接，第一个获取连接
			conn = ds.getConnection();//从连接池中拿一个新的
			th.set(conn);//放到当前线程共享变量中
		}
		return conn;
	}
	
	//把编译时异常转为运行时异常
	public static void free(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
