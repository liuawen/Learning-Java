package com.imooc.springboot.redislock.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/11/03
 */

@Slf4j
@Component
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean lock(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public boolean lockV2(String key, String value,Long timeOut) {
        return redisTemplate.opsForValue().setIfAbsent(key, value,timeOut, TimeUnit.MILLISECONDS);
    }

    public boolean lockV3(String key, String value) {
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }

        String oldValue = redisTemplate.opsForValue().get(key);

        if (Objects.nonNull(oldValue) && System.currentTimeMillis() > Long.parseLong(oldValue)) {
            String valueByGetAndSet = redisTemplate.opsForValue().getAndSet(key, value);
            if (Objects.isNull(valueByGetAndSet) || valueByGetAndSet.equals(oldValue)) {
                return true;
            }
        }

        return false;
    }

    public void unLock(String key) {
        redisTemplate.delete(key);
    }

    public void unLockV2(String key, String value) {
        String oldValue = redisTemplate.opsForValue().get(key);
        if (Objects.nonNull(oldValue) && oldValue.equals(value)) {
            try {
                redisTemplate.delete(key);
            } catch (Exception e) {
                log.error("解锁失败：{}",e);
            }
        }
    }
}
