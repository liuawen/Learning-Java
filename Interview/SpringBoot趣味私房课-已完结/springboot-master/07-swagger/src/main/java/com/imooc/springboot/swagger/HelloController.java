package com.imooc.springboot.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/06/02
 */
@Api
@RestController
public class HelloController {

    @ApiOperation(value = "Hello Spring Boot 方法")
    @GetMapping(value = "/hello",headers = "version=2")
    public String hello(@RequestParam(required = false) @ApiParam("名字") String name) {
        if (name == null || "".equals(name)) {
            name = "Spring Boot";
        }
        return "Hello "+name;
    }
}
