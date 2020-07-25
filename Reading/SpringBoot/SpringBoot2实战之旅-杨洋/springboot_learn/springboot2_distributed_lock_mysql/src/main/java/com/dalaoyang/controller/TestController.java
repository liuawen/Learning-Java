package com.dalaoyang.controller;

import com.dalaoyang.service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private LockService lockService;

    @GetMapping("/tryLock")
    public Boolean tryLock(String tag, Integer expiredSeconds) {
        return lockService.tryLock(tag, expiredSeconds);
    }

    @GetMapping("/unlock")
    public Boolean unlock(String tag) {
        lockService.unlock(tag);
        return true;
    }

    @GetMapping("/test")
    public String test(String tag, Integer expiredSeconds) {
        if (lockService.tryLock(tag, expiredSeconds)) {
            try {
                //do something
                //这里使用睡眠两秒，方便观察获取不到锁的情况
                Thread.sleep(2000);
            } catch (Exception e) {

            } finally {
                lockService.unlock(tag);
            }
            return "获取锁成功，tag是：" + tag;
        }
        return "当前tag：" + tag + "已经存在锁，请稍后重试！";
    }
}
