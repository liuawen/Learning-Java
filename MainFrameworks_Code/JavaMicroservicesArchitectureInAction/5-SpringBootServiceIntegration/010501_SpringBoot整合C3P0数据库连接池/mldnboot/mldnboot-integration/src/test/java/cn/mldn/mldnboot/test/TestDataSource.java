package cn.mldn.mldnboot.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.mldnboot.SpringBootStartApplication;

@SpringBootTest(classes = SpringBootStartApplication.class)		// 定义要测试的SpringBoot类
@RunWith(SpringJUnit4ClassRunner.class)							// 使用Junit进行测试
@WebAppConfiguration											// 进行Web应用配置
public class TestDataSource {
	@Autowired
	private DataSource dataSource ;								// 注入DataSource对象
	@Test
	public void testConnection() throws Exception {
		System.out.println(this.dataSource.getConnection());	// 获取连接
	}
}
