package test;

import com.itheima.SentinelApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot和Sentinel整合测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SentinelApplication.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("test", "redis");
        String test = redisTemplate.opsForValue().get("test");
        System.out.println(test);
    }
}
