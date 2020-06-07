package cn.mldn.mldnboot.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.mldnboot.SpringBootStartApplication;

@SpringBootTest(classes = SpringBootStartApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestRedisTemplate {
	@Resource(name="redisOne")
	private RedisTemplate<String,String> redisOne ;	
	@Resource(name="redisTwo")
	private RedisTemplate<String,String> redisTwo ; 
	@Test
	public void testSet() {
		this.redisOne.opsForValue().set("mldnjava", "hello");	// 保存数据
		this.redisTwo.opsForValue().set("jixianit", "hello");	// 保存数据
	}
}
