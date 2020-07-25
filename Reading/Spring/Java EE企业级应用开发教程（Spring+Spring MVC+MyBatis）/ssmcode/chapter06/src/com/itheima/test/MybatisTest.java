package com.itheima.test;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.itheima.po.Customer;
/**
 * 入门程序测试类
 */
public class MybatisTest {
	/**
	 * 根据客户编号查询客户信息
	 */
	@Test
	public void findCustomerByIdTest() throws Exception {
		// 1、读取配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = 
                     Resources.getResourceAsStream(resource);
		// 2、根据配置文件构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = 
                     new SqlSessionFactoryBuilder().build(inputStream);
		// 3、通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 4、SqlSession执行映射文件中定义的SQL，并返回映射结果
		Customer customer = sqlSession.selectOne("com.itheima.mapper"
				  + ".CustomerMapper.findCustomerById", 1);
		// 打印输出结果
		System.out.println(customer.toString());
		// 5、关闭SqlSession
		sqlSession.close();
	}
	
	/**
	 * 根据用户名称来模糊查询用户信息列表
	 */
	@Test
	public void findCustomerByNameTest() throws Exception{	
	    // 1、读取配置文件
	    String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    // 2、根据配置文件构建SqlSessionFactory
	    SqlSessionFactory sqlSessionFactory = 
	new SqlSessionFactoryBuilder().build(inputStream);
	    // 3、通过SqlSessionFactory创建SqlSession
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    // 4、SqlSession执行映射文件中定义的SQL，并返回映射结果
	    List<Customer> customers = sqlSession.selectList("com.itheima.mapper"
					+ ".CustomerMapper.findCustomerByName", "j");
	    for (Customer customer : customers) {
	        //打印输出结果集
	        System.out.println(customer);
	    }
	    // 5、关闭SqlSession
	    sqlSession.close();
	}
	
	/**
	 * 添加客户
	 */
	@Test
	public void addCustomerTest() throws Exception{		
	    // 1、读取配置文件
	    String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    // 2、根据配置文件构建SqlSessionFactory
	    SqlSessionFactory sqlSessionFactory = 
	    		new SqlSessionFactoryBuilder().build(inputStream);
	    // 3、通过SqlSessionFactory创建SqlSession
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    // 4、SqlSession执行添加操作
	    // 4.1创建Customer对象，并向对象中添加数据
	    Customer customer = new Customer();
	    customer.setUsername("rose");
	    customer.setJobs("student");
	    customer.setPhone("13333533092");
	    // 4.2执行SqlSession的插入方法，返回的是SQL语句影响的行数
		int rows = sqlSession.insert("com.itheima.mapper"
					+ ".CustomerMapper.addCustomer", customer);
	    // 4.3通过返回结果判断插入操作是否执行成功
	    if(rows > 0){
	        System.out.println("您成功插入了"+rows+"条数据！");
	    }else{
	        System.out.println("执行插入操作失败！！！");
	    }
	    // 4.4提交事务
	    sqlSession.commit();
	    // 5、关闭SqlSession
	    sqlSession.close();
	}

	/**
	 * 更新客户
	 */
	@Test
	public void updateCustomerTest() throws Exception{		
	    // 1、读取配置文件
	    String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    // 2、根据配置文件构建SqlSessionFactory
	    SqlSessionFactory sqlSessionFactory = 
	    		new SqlSessionFactoryBuilder().build(inputStream);
	    // 3、通过SqlSessionFactory创建SqlSession
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    // 4、SqlSession执行更新操作
	    // 4.1创建Customer对象，对对象中的数据进行模拟更新
	    Customer customer = new Customer();
	    customer.setId(4);
	    customer.setUsername("rose");
	    customer.setJobs("programmer");
	    customer.setPhone("13311111111");
	    // 4.2执行SqlSession的更新方法，返回的是SQL语句影响的行数
	    int rows = sqlSession.update("com.itheima.mapper"
	            + ".CustomerMapper.updateCustomer", customer);
	    // 4.3通过返回结果判断更新操作是否执行成功
	    if(rows > 0){
	        System.out.println("您成功修改了"+rows+"条数据！");
	    }else{
	        System.out.println("执行修改操作失败！！！");
	    }
	    // 4.4提交事务
	    sqlSession.commit();
	    // 5、关闭SqlSession
	    sqlSession.close();
	}

	/**
	 * 删除客户
	 */
	@Test
	public void deleteCustomerTest() throws Exception{		
	    // 1、读取配置文件
	    String resource = "mybatis-config.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    // 2、根据配置文件构建SqlSessionFactory
	    SqlSessionFactory sqlSessionFactory = 
	            new SqlSessionFactoryBuilder().build(inputStream);
	    // 3、通过SqlSessionFactory创建SqlSession
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    // 4、SqlSession执行删除操作
	    // 4.1执行SqlSession的删除方法，返回的是SQL语句影响的行数
	    int rows = sqlSession.delete("com.itheima.mapper"
	            + ".CustomerMapper.deleteCustomer", 4);
	    // 4.2通过返回结果判断删除操作是否执行成功
	    if(rows > 0){
	        System.out.println("您成功删除了"+rows+"条数据！");
	    }else{
	        System.out.println("执行删除操作失败！！！");
	    }
	    // 4.3提交事务
	    sqlSession.commit();
	    // 5、关闭SqlSession
	    sqlSession.close();
	}

}
