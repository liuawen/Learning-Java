package com.atguigu.test;

import java.sql.Connection;

import org.junit.Test;

import com.atguigu.util.JDBCUtils;


public class JDBCUtilTest {

	@Test
	public void testGetConnection() {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(conn);
		JDBCUtils.closeConnection(conn);
	}
	
}
