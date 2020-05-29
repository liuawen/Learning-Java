package com.atguigu.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

/*
 * 在使用PreparedStatement添加数据时，获取自增长的键值。
 * 例如：
 * 	 购物时，结算时，会产生新订单，会返回新的订单，而一般订单编号都是自增长或随机生成的，保证这个订单编号的唯一。
 * 
 * 举例：
 *   在添加一个部门后，立刻返回这个部门的新的编号，而这个编号是自增长的。
 *   
 * 如何让PreparedStatement执行完insert的sql后，带回自增长的键值？
 * （1）在创建这个PreparedStatement对象时，就要指明需要返回自增长的键值，否则mysql服务器不会给你返回这个
 * PreparedStatement pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
 * 
 * （2）通过拿到结果集来获取自增长的键值
 * 但是方法不要调用getResultSet()来获取结果集，而是通过getGeneratedKeys()来获取结果集
 * ResultSet rs = pst.getGeneratedKeys();
 */
public class TestGenerateKey {
	public static void main(String[] args) throws Exception{
		//1、注册驱动
		/*
		 * （1）加入jar
		 * （2）添加到Build path中
		 * （3）加载到内存
		 */
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		
		//3、编写sql
		String sql = "INSERT INTO t_department VALUES(NULL,?,?)";
		
		//4、创建PreparedStatement对象
		//在Statement这个接口中，声明了几个常量，其中一个是Statement.RETURN_GENERATED_KEYS，表示返回自增长的键值
		PreparedStatement pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
		//5、设置？的值
		pst.setObject(1, "花钱部门2");
		pst.setObject(2, "yyy2");
		
		//6、执行sql
		int len = pst.executeUpdate();
		System.out.println(len > 0 ? "添加成功" : "添加失败");
		
		ResultSet rs = pst.getGeneratedKeys();//mysql服务器通过结果集把自增长的键值返回回来
		if(rs.next()){
			System.out.println("新的部门的编号：" + rs.getObject(1));
		}
		
		//7、关闭
		rs.close();
		pst.close();
		conn.close();
	}
}
