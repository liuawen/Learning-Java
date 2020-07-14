package com.imooc.springboot.task.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/11/30
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handle(Exception e) {
        Result result = new Result();
        result.setCode(MessageEnum.UNKNOW_ERROR.getCode());
        result.setMessage(e.getMessage() == null ? MessageEnum.UNKNOW_ERROR.getMessage() : e.getMessage());
        log.error(e.getMessage(),e);
        return result;
    }

    @ExceptionHandler(ApiException.class)
    public Result handle(ApiException e) {
        Result result = new Result();
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        log.error(e.getMessage(),e);
        return result;
    }
}
