package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.atguigu.mybatis.entities.Employee;
import com.atguigu.mybatis.mapper.EmployeeMapper;

class MyBatisTest {

	//1.MyBatis中当实体类中的属性名和表中的字段名不一样 ，怎么办 ？
	/*
	 * 解决方案：
	 * 	1.写sql语句时起别名
	 * 	2.在MyBatis的全局配置文件中开启驼峰命名规则
	 *  3.在Mapper映射文件中使用resultMap来自定义映射规则
	 */
	
	@Test
	void testGetEmployee() throws IOException {
		//1.创建SqlSessionFactory对象
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//2.获取sqlSession，sqlSession就相当于JDBC中的connection
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
		  //3.获取Mapper对象
		  EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		  //4.调用EmployeeMapper中获取Employee的方法
		  Employee employee = mapper.getEmployeeById(1);
		  System.out.println(employee);
		} finally {
		  //5.关闭sqlSession
		  sqlSession.close();
		}
	}

}
