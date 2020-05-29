package com.atguigu.test05;

import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBCTools2 {

	public static void main(String[] args) throws SQLException {
		String sql1 = "UPDATE t_department SET description = 'xx' WHERE did = 5183";
		String sql2 = "UPDATE t_department SET description = 'yy' where did = 5";//这个sql是故意写错的
		
		Connection conn = JDBCToolsV2.getConnection();
		conn.setAutoCommit(false);
		
		try {
			JDBCToolsV2.update(sql1);
			JDBCToolsV2.update(sql2);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}
		
		conn.setAutoCommit(true);
		JDBCToolsV2.free(conn);
	}

}
