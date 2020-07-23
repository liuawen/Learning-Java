package com.atguigu.test03.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.junit.Test;

/*
 * 
 */
public class TestPreparedStatement {
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
图片太大：
（1）表结构修改  把blob修改为mediumblob
mysql> desc t_userinfo;
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| id       | int(11)     | NO   | PRI | NULL    | auto_increment |
| username | varchar(20) | NO   |     | NULL    |                |
| password | varchar(20) | NO   |     | NULL    |                |
| photo    | mediumblob  | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
4 rows in set (0.01 sec)
（2）修改my.ini
增加一个参数
max_allowed_packet=16m
在修改my.ini之前，关闭服务，修改之后重新启动服务
	 */
	@Test
	public void test04()throws Exception{
		//往test库的t_userinfo标准添加一条记录
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		
		//3、编写sql
//		String sql = "insert into t_userinfo values(null,'chai','1234', )";//无法处理blob
		String sql = "insert into t_userinfo values(null,?,?,?)";//避免了拼接blob
		
		//4、创建PreparedStatement
		PreparedStatement pst = conn.prepareStatement(sql);
		
		//5、设置？
		pst.setString(1, "chailinyan");
		pst.setString(2, "123456");
		pst.setObject(3, new FileInputStream("D:/QMDownload/img/美女/15.jpg"));
//	方法有问题 抽象方法什么的	pst.setBlob(3,new FileInputStream());

		//6、执行sql
		int len = pst.executeUpdate();
		System.out.println(len>0?"添加成功":"添加失败");
		
		//6、关闭
		pst.close();
		conn.close();
	}
	
	@Test
	public void test02()throws Exception{
		//员工自己查询自己的信息：从键盘输入员工的姓名，查询自己的信息
		Scanner input = new Scanner(System.in);
		
		System.out.print("请输入员工的姓名：");
		String ename = input.nextLine();//输入：孙红雷' or '1'='1
		
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		
		//3、编写sql
//		String sql = "select * from t_employee where ename = '" + ename + "'";
		String sql = "select * from t_employee where ename = ?";
		
		//4、创建Statement
//		Statement st = conn.createStatement();
		PreparedStatement pst = conn.prepareStatement(sql);
		
		//插入一步，设置？
		pst.setString(1, ename);
		
		//5、执行sql
//		ResultSet rs = st.executeQuery(sql);
		ResultSet rs = pst.executeQuery();
		
		//6、遍历结果集
		while(rs.next()){
			for (int i = 1; i <= 14; i++) {
				System.out.print(rs.getObject(i) + "\t");
			}
			System.out.println();
		}
		//啥也不输出
		//7、关闭
		rs.close();
//		st.close();
		pst.close();
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
//		String sql = "insert into t_department values(null,'" + dname + "','" + desc +"')";
		String sql = "insert into t_department values(null,?,?)";
		
		//4、创建PreparedStatement
//		Statement st = conn.createStatement();
		PreparedStatement pst = conn.prepareStatement(sql);//此时的sql带?的
		
		//加入一步，设置?的值
		pst.setString(1, dname);//1表示第1个?
		pst.setString(2, desc);//2表示第2个?
		
		//5、执行sql
//		int len = st.executeUpdate(sql);
		int len = pst.executeUpdate();//这里没有sql
		System.out.println(len>0?"添加成功":"添加失败");
		
		//6、关闭
//		st.close();
		pst.close();
		conn.close();
		input.close();
	}
}
