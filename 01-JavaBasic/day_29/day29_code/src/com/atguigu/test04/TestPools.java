package com.atguigu.test04;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * 1、原始的数据库的连接的问题
 * 	 相当于TCP/IP协议编程的Socket，每一个客户端，每一次连接都有一个独立的Socket。
 *   TCP协议：可靠的，面向连接的....
 *      在连接之前有三次握手，断开连接时四次挥手等操作。
 *      
 *  每一次获取连接和释放连接是一次高成本的操作。
 *  （1）如果我们每次为了执行sql时，都是问数据库服务器要新的连接，用完之后直接释放掉，那么成本很高。
 *  （2）如果每一个客户端每次为了执行sql时，都是问数据库服务器要新的连接，如果同时在线人数很多，并发操作很多时，
 *  会导致数据库服务器的压力很大。因为对于服务器来说，每一个连接都有一个Socket，都有一个线程，数据库服务器很可能挂了。
 *  
 * 2、 如何解决这个问题？
 *    可以设计一个数据库连接池。
 *    这个数据库连接池先提前准备好一些连接，那么等用户需要用到连接时，不用创建新的，从这个池中直接拿一个现成的。
 *    当用户用完后，放回池中，给下一个人继续使用。
 *    
 *    这个数据库连接池有几个参数：
 *    （1）初始化连接数：即一开始准备的连接数量，例如：10个
 *    （2）最大连接数：即数据库服务器最多能承受多少个，例如：100个
 *    （3）每次增量：如果10个不够了，会增加多少，直到达到100个
 *    （4）等待时间：
 *    	如果到达100个，怎么办？
 *       ①让用户无限制等待
 *       ②等待xx时间后，返回异常，告知客户端，连接超时。
 *    
 *  一个项目，连接池创建一个，但是池中的连接可以很多个。
 *  数据库连接池又称为数据源。DataSource
 *  
 *  市面上有很多数据库连接池技术：
 *  （1）DBCP ：Apache提供的数据库连接池，速度相对c3p0较快，但是有一些BUG
 *  （2）c3p0 ：是一个开源组织提供的一个数据库连接池，速度相对较慢，稳定性还可以
 *  （3）Proxool ：是sourceforge下的一个开源项目数据库连接池，有监控连接池状态的功能，稳定性较c3p0差一点
 *  （4）BoneCP ：一个开源组织提供的数据库连接池，速度快
 *  （5）Druid（德鲁伊） :是阿里提供的数据库连接池，据说是集DBCP 、C3P0 、Proxool 优点于一身的数据库连接池，但是速度不知道是否有BoneCP快
 *  ....
 *  
 * 目的： 
 * （1）连接资源重用
 * （2）对于用户来说，系统的响应速度更快
 * （3）新的资源分配手段
 *   原来是从数据库服务器直接获取连接
 *   现在是从连接池中拿连接
 * （4）避免数据库服务器挂掉  
 *  
 * 3、 如何使用Druid（德鲁伊）数据库连接池？
 * 步骤：
 * （1）引入jar
 * 放到libs中，并且添加到build path中
 * （2）创建连接池对象对象
 * 方式一
 * （1）手动创建数据库连接池对象，在代码中硬编码配置参数
 * 方式二：
 * （1）在配置文件中写配置参数
 * （2）在代码中用配置文件创建连接池对象对象
 * 
 * 参数：  参数名是固定，必备参数
 * url：和原来一样
 * username：用户名
 * password：密码
 * driverClassName；驱动类名
 * initialSize：初始化连接数
 * maxActive：最大连接数
 * maxWait：当池中的连接都被占用了，新用户的等待时间，如果超过时间，就异常返回

 * 可选参数：
 * maxIdle：
 * minIdle：
 * 		得保证池中释放掉一些连接后，最少需要保留几个，以备不时之需
 * ...
 * （3）获取连接对象
 *  数据库连接池对象.getConnection()
 *  
 *  获取到连接后，增删改查不变
 *  
 * （4）用完后，close()还回去
 * 
 * 
 * 有了数据库连接池，无非改变的是获取连接的方式而已。其他的不变。
 */
public class TestPools {
	@Test
	public void test04()throws Exception{
		Properties pro = new Properties();
		//TestPools.class：得到当前类的Class对象
		//xx.getClassLoader()：获取类加载器对象
		//类加载器对象.getResourceAsStream()：加载资源文件，并且把配置文件中的数据封装到Properties对象
		//这个资源文件格式：key=value
		pro.load(TestPools.class.getClassLoader().getResourceAsStream("druid.properties"));
		DataSource ds = DruidDataSourceFactory.createDataSource(pro);
		
		//从数据库连接池中拿连接
		for (int i = 1; i <=30; i++) {
			new Thread(i+""){
				public void run(){
					try {
						Connection conn = ds.getConnection();
						System.out.println("第" + getName() +"个连接：" + conn);
						
						Thread.sleep(500);
						
						conn.close();//还给它了
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}.start();
		}
		
		Thread.sleep(100000);
	}
	
	
	@Test
	public void test03()throws Exception{
		Properties pro = new Properties();
		//TestPools.class：得到当前类的Class对象
		//xx.getClassLoader()：获取类加载器对象
		//类加载器对象.getResourceAsStream()：加载资源文件，并且把配置文件中的数据封装到Properties对象
		//这个资源文件格式：key=value
		pro.load(TestPools.class.getClassLoader().getResourceAsStream("druid.properties"));
		DataSource ds = DruidDataSourceFactory.createDataSource(pro);
		
		//从数据库连接池中拿连接
		for (int i = 1; i <=30; i++) {
			Connection conn = ds.getConnection();
			System.out.println("第" + i +"个连接：" + conn);
			
			conn.close();//还给它了
		}
	}
	
	@Test
	public void test02() throws Exception{
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("1234");
		System.out.println(ds);
	}
	
	@Test
	public void test01() throws Exception{
		Properties pro = new Properties();//特点：key和value都是String
		
		//硬编码
		pro.setProperty("url", "jdbc:mysql://localhost:3306/test");
		pro.setProperty("username", "root");
		pro.setProperty("password", "1234");
		
		DataSource ds = DruidDataSourceFactory.createDataSource(pro);
		System.out.println(ds.getClass());//com.alibaba.druid.pool.DruidDataSource
	}
}
