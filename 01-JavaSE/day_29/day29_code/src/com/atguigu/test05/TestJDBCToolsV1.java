package com.atguigu.test05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class TestJDBCToolsV1 {
	@Test
	public void test01() throws SQLException{
		//添加一个部门到test库的t_department
		String sql = "INSERT INTO `t_department` VALUES(NULL,?,?) ";
		int len = JDBCToolsV1.update(sql, "测试部门1" ,"测试部门简介1");
		System.out.println(len>0?"success":"fail");
	}
	
	@Test
	public void test02() throws SQLException{
		String sql1 = "UPDATE t_department SET description = 'xx' WHERE did = 5183";
		String sql2 = "UPDATE t_department SET description = 'yy' did = 5";//这个sql是故意写错的
		//希望它俩是构成一个事务的
		//直接用这个，没法处理事务
		JDBCToolsV1.update(sql1);
		JDBCToolsV1.update(sql2);
	}
	
	@Test
	public void test03() throws SQLException{
		String sql1 = "UPDATE t_department SET description = 'xx' WHERE did = 5183";
		String sql2 = "UPDATE t_department SET description = 'yy' where did = 5";//这个sql是故意写错的
		
		//希望它俩是构成一个事务的
		Connection conn = JDBCToolsV1.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pst1 = conn.prepareStatement(sql1);
		PreparedStatement pst2 = conn.prepareStatement(sql2);
		try {
			int len1 = pst1.executeUpdate();
			int len2 = pst2.executeUpdate();
			
			if(len1>0 && len2>0){
				conn.commit();
			}else{
				conn.rollback();
			}
		} catch (Exception e) {
			conn.rollback();
		}
		
		pst1.close();
		pst2.close();
		conn.setAutoCommit(true);
		JDBCToolsV1.free(conn);
	}
	
	@Test
	public void test04()throws Exception{
		String sql1 = "UPDATE t_department SET description = 'xx' WHERE did = 5183";
		String sql2 = "UPDATE t_department SET description = 'yy' where did = 5";//这个sql是故意写错的
		
		//希望它俩是构成一个事务的
		Connection conn = JDBCToolsV1.getConnection();
		conn.setAutoCommit(false);
		
		try {
			int len1 = JDBCToolsV1.update(conn, sql1);
			int len2 = JDBCToolsV1.update(conn, sql2);
			if(len1 > 0 && len2>0){
				conn.commit();
			}else{
				conn.rollback();
			}
		} catch (Exception e) {
			conn.rollback();
		}
		
		conn.setAutoCommit(true);
		JDBCToolsV1.free(conn);
	}

	@Test
	public void test05()throws Exception{
		String sql1 = "UPDATE t_department SET description = 'xx' WHERE did = 5183";
		String sql2 = "UPDATE t_department SET description = 'yy' did = 5";//这个sql是故意写错的
		
//		JDBCToolsV1.update2(sql1);
//		JDBCToolsV1.update2(sql2);
	}
}
