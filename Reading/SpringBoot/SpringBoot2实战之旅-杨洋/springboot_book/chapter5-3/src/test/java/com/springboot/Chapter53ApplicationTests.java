package com.springboot;

import com.springboot.config.MemcachedConfig;
import net.spy.memcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter53ApplicationTests {

	@Resource
	private MemcachedConfig memcachedRunner;

	@Test
	public void contextLoads() {
		MemcachedClient memcachedClient = memcachedRunner.getClient();
		memcachedClient.set("testkey",1000,"666666");
		System.out.println("***********  "+memcachedClient.get("testkey").toString());
	}

}
