package com.atguigu.test02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

/*
 * 步骤：
 * 1、注册驱动
 * 三部曲：（1）把jar复制到libs（2）把jar添加到Build path中（3）加载驱动类
 * 2、建立连接
 * 	获取Connection对象
 * 
 * 3、执行sql
 * (1)编写sql
 * (2)创建Statement
 * (3)执行sql
 * 
 * 增删改：int len = Statement对象.executeUpdate(sql)
 * 查询：ResultSet rs = Statement对象.executeQuery(sql)
 * 
 * 4、遍历结果集
 * 
 * 5、关闭资源
 */
public class TestJDBC2 {
	@Test
	public void test5()throws Exception{
		//1、加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
//		Class.forName("org.gjt.mm.Driver");
		
		//2、建立连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url,"root","123456");
		
		//3、执行sql
		String sql = "select sid,sname from t_stu";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		//4、遍历结果集
		/*
		 * rs.next()：还有没有下一行
		 * rs.getXxx(字段名)
		 */
		while(rs.next()){
			System.out.println(rs.getObject(1) + "\t" + rs.getObject(2));
		}
		
		//5、关闭
		rs.close();
		st.close();
		conn.close();
	}
	
	@Test
	public void test4()throws Exception{
		//1、加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
//		Class.forName("org.gjt.mm.Driver");
		
		//2、建立连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url,"root","123456");
		
		//3、执行sql
		String sql = "select sid,sname from t_stu";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		//4、遍历结果集
		/*
		 * rs.next()：还有没有下一行
		 * rs.getXxx(字段名)
		 */
		while(rs.next()){
			int sid = rs.getInt(1);//查询结果中的第一个字段
			String sname = rs.getString(2);//查询结果中的第一个字段
			System.out.println(sid+"\t" +sname);
		}
		
		//5、关闭
		rs.close();
		st.close();
		conn.close();
	}
	
	@Test
	public void test3()throws Exception{
		//1、加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
//		Class.forName("org.gjt.mm.Driver");
		
		//2、建立连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url,"root","123456");
		
		//3、执行sql
		String sql = "select sid,sname from t_stu";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		//4、遍历结果集
		/*
		 * rs.next()：还有没有下一行
		 * rs.getXxx(字段名)
		 */
		while(rs.next()){
			int sid = rs.getInt("sid");
			String sname = rs.getString("sname");
			System.out.println(sid+"\t" +sname);
		}
		
		//5、关闭
		rs.close();
		st.close();
		conn.close();
	}
	
	
	@Test
	public void test2()throws Exception{
		//1、加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
//		Class.forName("org.gjt.mm.Driver");
		
		//2、建立连接
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url,"root","123456");
		
		//3、执行sql
		String sql = "select * from t_stu";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		//4、遍历结果集
		/*
		 * rs.next()：还有没有下一行
		 * rs.getXxx(字段名)
		 */
		while(rs.next()){
			int sid = rs.getInt("sid");
			String sname = rs.getString("sname");
			System.out.println(sid+"\t" +sname);
		}
		
		//5、关闭
		rs.close();
		st.close();
		conn.close();
	}
}
