package com.junit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Demo {
	Connection conn=null;
	public static void main(String[] args){
		//运行之前需要创建数据库和表格，参考test1.sql文件
		Demo d=new Demo();
		Map param=new HashMap();
		param.put("id",5);
		param.put("name","amy");
		param.put("password","123456");
		d.insert(param);
		d.getAll();
		d.close();
	}
	public void createDb(){
		String url="jdbc:mysql://localhost:3306/test1";
		String name="com.mysql.jdbc.Driver";
		String user="root";
		String password="root";
		try {
			Class.forName(name);//指定连接类型
			 conn = DriverManager.getConnection(url, user,password);
		     //pst=conn.prepareStatement(sql);//准备执行语句
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public int insert(Map param){
		this.createDb();
		int i=0;
		String sql="INSERT INTO user(id,username,password) VALUES(?,?,?)";
		PreparedStatement pstmt;
		try{
			pstmt=this.conn.prepareStatement(sql);
			pstmt.setString(1,(String)param.get("id"));
			pstmt.setString(2,(String)param.get("name"));
			pstmt.setString(3,(String)param.get("password"));
			i=pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return i;
	}
	public void getAll(){
		String sql="select * from user";
		PreparedStatement pstmt=null;
		try{
			pstmt=this.conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			int col=rs.getMetaData().getColumnCount();
			System.out.println("=========================");
			while(rs.next()){
				for(int i=1;i<=col;i++){
					System.out.print(rs.getString(i)+"\t");
					if((i==2)&&(rs.getString(i).length()<8)){
						System.out.print("\t");
					}
				}
				System.out.println("");
			}
			System.out.println("=========================");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void close(){
	}
}
