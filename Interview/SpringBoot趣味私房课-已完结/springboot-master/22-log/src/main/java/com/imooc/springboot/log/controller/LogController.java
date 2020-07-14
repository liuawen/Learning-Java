package com.imooc.springboot.log.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/11/17
 */
@Api
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @GetMapping("/debug")
    public void debug() {
        log.debug("log level debug");
    }

    @GetMapping("/info")
    public void info() {
        Exception e = new Exception();
        log.info("log level info");
        log.error("xxx错误：{}", e.getMessage());
        log.error("xxx错误：{}", e.getMessage(), e);
        e.printStackTrace();
    }

    @GetMapping("/warn")
    public void warn() {
        log.warn("log level warn");
    }

    @GetMapping("/error")
    public void error() {
        log.error("log level error");
    }
}
