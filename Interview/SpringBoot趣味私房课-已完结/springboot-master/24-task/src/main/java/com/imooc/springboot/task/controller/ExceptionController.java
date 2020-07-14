package com.imooc.springboot.task.controller;

import com.imooc.springboot.task.base.ApiException;
import com.imooc.springboot.task.base.MessageEnum;
import com.imooc.springboot.task.base.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/11/30
 */
@Api
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/apiexception")
    public Result apiException() {
        throw new ApiException(MessageEnum.ERROR);
    }

    @GetMapping("/runtimeexception")
    public Result runtimeException() {






        throw new RuntimeException();
    }
}
