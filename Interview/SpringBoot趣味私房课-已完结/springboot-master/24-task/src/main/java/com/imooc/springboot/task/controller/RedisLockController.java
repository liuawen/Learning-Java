package com.imooc.springboot.task.controller;

import com.imooc.springboot.task.util.RedisLock;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/11/02
 */
@Api
@Slf4j
@RestController
@RequestMapping("/redislock")
public class RedisLockController {

    private final long TIME_OUT = 50 * 1000;

    private final String REDIS_LOCK = "REDIS_LOCK";

    @Autowired
    private RedisLock redisLock;


    @GetMapping("/lock")
    public void lock() {

        // 加锁
        long currentTime = System.currentTimeMillis();
        boolean isLock = redisLock.lockV3(REDIS_LOCK, String.valueOf(currentTime + TIME_OUT));
        if (!isLock) {
            throw new RuntimeException("资源已被抢占，换个姿势再试试吧！");
        }

        // do something

        // 解锁
        redisLock.unLockV2(REDIS_LOCK, String.valueOf(currentTime + TIME_OUT));

    }
}
