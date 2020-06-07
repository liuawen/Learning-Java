package cn.mldn.mldnboot.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.mldnboot.SpringBootStartApplication;
import cn.mldn.mldnboot.vo.Member;

@SpringBootTest(classes = SpringBootStartApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestRedisTemplate {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;	// 引入RedisTemplate
	@Test 
	public void testGet() {									// 根据key取得数据
		System.out.println(this.redisTemplate.opsForValue().get("mldn"));
	}
	@Test
	public void testSet() {
		Member vo = new Member() ;							// 实例化VO对象
		vo.setMid("mldnjava");
		vo.setName("李兴华");
		vo.setAge(19);
		this.redisTemplate.opsForValue().set("mldn", vo);	// 保存数据
	}
}
