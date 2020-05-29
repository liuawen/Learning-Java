package com.atguigu.test03.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

/*
 * Statement问题：
 * 1、SQL拼接：太麻烦
 * 2、SQL注入
 * 3、无法处理blob等二进制类型的数据
 * 
 * 如何解决这些问题，使用Statement的子接口PreparedStatement
 */
public class TestStatementProblem {
	/*
	 * t_userinfo表
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| id       | int(11)     | NO   | PRI | NULL    | auto_increment |
| username | varchar(20) | NO   |     | NULL    |                |
| password | varchar(20) | NO   |     | NULL    |                |
| photo    | blob        | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
	 */
	@Test
	public void test04()throws Exception{
		//往test库的t_userinfo标准添加一条记录
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		
		//3、编写sql
		String sql = "insert into t_userinfo values(null,'chai','1234', )";//无法处理blob
		//blob 二进制文件
		//怎么拼接都是字符串
	}
	
	
	@Test
	public void test03()throws Exception{
		Scanner input = new Scanner(System.in);
		
		System.out.print("请输入员工的姓名：");
		String ename = input.nextLine();
		System.out.println(ename);
		
	}
	
	@Test
	public void test02()throws Exception{
		//员工自己查询自己的信息：从键盘输入员工的姓名，查询自己的信息
		Scanner input = new Scanner(System.in);
		
		System.out.print("请输入员工的姓名：");
		String ename = input.nextLine();//输入：孙红雷' or '1'='1
//		String ename = input.next();//输入：孙红雷' or '1'='1

		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		
		//3、编写sql
		String sql = "select * from t_employee where ename = '" + ename + "'";
		System.out.println(sql);//select * from t_employee where ename = '孙红雷' or '1'='1'
		
		//4、创建Statement
		Statement st = conn.createStatement();
		
		//5、执行sql
		ResultSet rs = st.executeQuery(sql);
		
		//6、遍历结果集
		while(rs.next()){
			for (int i = 1; i <= 14; i++) {
				System.out.print(rs.getObject(i) + "\t");
			}
			System.out.println();
		}
		
		//7、关闭
		rs.close();
		st.close();
		conn.close();
		input.close();
	}
	
	@Test
	public void test01()throws Exception{
		//从键盘输入部门的信息，添加到test库的t_department表中
		Scanner input = new Scanner(System.in);
		
		System.out.print("请输入部门的名称：");
		String dname = input.next();
		
		System.out.print("请输入部门的简介：");
		String desc = input.next();
		
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		
		//3、编写sql
//		String sql = "insert into t_department values('" + dname + "','" + desc +"')";
		String sql = "insert into t_department values(null,'" + dname + "','" + desc +"')";
		//SQL 拼接问题
		//4、创建Statement
		Statement st = conn.createStatement();
		
		//5、执行sql
		int len = st.executeUpdate(sql);
		System.out.println(len>0?"添加成功":"添加失败");
		
		//6、关闭
		st.close();
		conn.close();
		input.close();
	}
}
