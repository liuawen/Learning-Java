package com.atguigu.test05;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.atguigu.test04.TestPools;

/*
 * 
 */
public class JDBCToolsV1 {
	private static DataSource ds;
	static{
		try {
			//静态代码块
			Properties pro = new Properties();
			pro.load(TestPools.class.getClassLoader().getResourceAsStream("druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(pro);
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
		return ds.getConnection();
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
	
	//这个方法只能用于不需要处理事务的情况
	//增、修改、删除
	public static int update(String sql,Object... args) throws SQLException{
		//获取连接
		Connection conn = getConnection();
		
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//设置？
		if(args!=null && args.length>0){
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
		}
		
		//执行sql
		int len = ps.executeUpdate();
		
		ps.close();
		free(conn);
		
		return len;
	}
	
/*	public static int update2(String sql,Object... args) throws SQLException{
		//获取连接
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//设置？
		if(args!=null && args.length>0){
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
		}
		
		//执行sql
		int len = 0;
		try {
			len = ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		}
		
		ps.close();
		conn.setAutoCommit(true);
		free(conn);
		
		return len;
	}*/
	
	public static int update(Connection conn, String sql, Object... args) throws SQLException{
		PreparedStatement ps = conn.prepareStatement(sql);
		//设置？
		if(args!=null && args.length>0){
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
		}
		//执行sql
		int len = ps.executeUpdate();
		ps.close();
		return len;
	}
}
