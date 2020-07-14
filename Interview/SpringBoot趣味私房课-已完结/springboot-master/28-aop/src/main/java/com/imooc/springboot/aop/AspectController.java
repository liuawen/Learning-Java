package com.imooc.springboot.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : 刘水镜
 * @Description :
 * @Date Create in 2020/1/31 11:43
 */
@Slf4j
@RestController
@RequestMapping("/aspect")
public class AspectController {

    @GetMapping
    public Result aspect(String message) {
        log.info("aspect controller");
        return Result.sucess(message);
    }

    @GetMapping("/exception")
    public Result exception() {
        throw new RuntimeException("runtime exception");
    }

    @GetMapping("/sleep/{time}")
    public Result sleep(@PathVariable("time") long time) {
        log.info("sleep");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.error("error",e);
        }
        if (time == 1000) {
            throw new RuntimeException("runtime exception");
        }
        return Result.sucess("wake up");
    }
}
