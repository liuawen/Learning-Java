package com.dalaoyang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="测试接口",tags={"测试接口"})
public class TestController {

    @ApiOperation(value="测试api", notes="测试api")
    @GetMapping(value="/test")
    public String test(){
        return "success";
    }
}
