package com.itheima.test;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.itheima.po.Customer;
import com.itheima.po.User;
import com.itheima.utils.MybatisUtils;
/**
 * 入门程序测试类
 */
public class MybatisTest {
	/**
	 * 1.根据客户编号查询客户信息
	 */
	@Test
	public void findCustomerByIdTest() {
		// 获取SqlSession
		SqlSession sqlSession = MybatisUtils.getSession();
		// SqlSession执行映射文件中定义的SQL，并返回映射结果
		Customer customer = sqlSession.selectOne("com.itheima.mapper" 
		                 + ".CustomerMapper.findCustomerById", 1);
		// 打印输出结果
		System.out.println(customer.toString());
		// 关闭SqlSession
		sqlSession.close();
	}
	/**
	 * 2.根据用户名称来模糊查询用户信息列表
	 */
	@Test
	public void findCustomerByNameTest() {		
		// 获取SqlSession
		SqlSession sqlSession = MybatisUtils.getSession();
		// SqlSession执行映射文件中定义的SQL，并返回映射结果
		List<Customer> customers = sqlSession.selectList("com.itheima.mapper"
				+ ".CustomerMapper.findCustomerByName", "j");
		for (Customer customer : customers) {
			//打印输出结果集
			System.out.println(customer);					
		}
		// 关闭SqlSession
		sqlSession.close();
	}
	/**
	 * 3.添加客户
	 */
	@Test
	public void addCustomerTest(){
		// 获取SqlSession
		SqlSession sqlSession = MybatisUtils.getSession();
		Customer customer = new Customer();
		customer.setUsername("rose");
		customer.setJobs("student");
		customer.setPhone("13333533092");
		// 使用主键自助增长的添加方法
//		int rows = sqlSession.insert("com.itheima.mapper."
//				+ "CustomerMapper.addCustomer", customer);
		// 使用自定义主键值的添加方法
		int rows = sqlSession.insert("com.itheima.mapper."
				+ "CustomerMapper.insertCustomer", customer);
		// 输出插入数据的主键id值
		System.out.println(customer.getId());		
		if(rows > 0){
			System.out.println("您成功插入了"+rows+"条数据！");
		}else{
			System.out.println("执行插入操作失败！！！");
		}
		sqlSession.commit();
		sqlSession.close();
	}
	/**
	 * 4.更新客户
	 */
	@Test
	public void updateCustomerTest() throws Exception{		
		// 获取SqlSession
		SqlSession sqlSession = MybatisUtils.getSession();
		// SqlSession执行更新操作
		// 创建Customer对象，并向对象中添加数据
		Customer customer = new Customer();
		customer.setId(4);
		customer.setUsername("rose");
		customer.setJobs("programmer");
		customer.setPhone("13311111111");
		// 执行sqlSession的更新方法，返回的是SQL语句影响的行数
		int rows = sqlSession.update("com.itheima.mapper"
				+ ".CustomerMapper.updateCustomer", customer);
		// 通过返回结果判断更新操作是否执行成功
		if(rows > 0){
			System.out.println("您成功修改了"+rows+"条数据！");
		}else{
			System.out.println("执行修改操作失败！！！");
		}
		// 提交事务
		sqlSession.commit();
		// 关闭SqlSession
		sqlSession.close();
	}
	/**
	 * 5.删除客户
	 */
	@Test
	public void deleteCustomerTest() {		
		// 获取SqlSession
		SqlSession sqlSession = MybatisUtils.getSession();
		// SqlSession执行删除操作
		// 执行SqlSession的删除方法，返回的是SQL语句影响的行数
		int rows = sqlSession.delete("com.itheima.mapper"
				+ ".CustomerMapper.deleteCustomer", 4);
		// 通过返回结果判断删除操作是否执行成功
		if(rows > 0){
			System.out.println("您成功删除了"+rows+"条数据！");
		}else{
			System.out.println("执行删除操作失败！！！");
		}
		// 提交事务
		sqlSession.commit();
		// 关闭SqlSession
		sqlSession.close();
	}
	
	@Test
	public void findAllUserTest() {
		// 获取SqlSession
		SqlSession sqlSession = MybatisUtils.getSession();
		// SqlSession执行映射文件中定义的SQL，并返回映射结果
		List<User> list = sqlSession.selectList("com.itheima.mapper.UserMapper.findAllUser");
		for (User user : list) {
			System.out.println(user);
		}
		// 关闭SqlSession
		sqlSession.close();
	}
}