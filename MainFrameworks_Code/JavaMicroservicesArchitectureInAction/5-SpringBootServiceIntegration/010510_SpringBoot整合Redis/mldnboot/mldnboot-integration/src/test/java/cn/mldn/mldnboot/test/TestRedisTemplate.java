package cn.mldn.mldnboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.mldnboot.SpringBootStartApplication;

@SpringBootTest(classes = SpringBootStartApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestRedisTemplate {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;					// 引入RedisTemplate
	@Test
	public void testSet() {
		this.redisTemplate.opsForValue().set("mldn", "java");				// 设置字符串信息
		System.out.println(this.redisTemplate.opsForValue().get("mldn"));	// 根据key获取value
	}
}
