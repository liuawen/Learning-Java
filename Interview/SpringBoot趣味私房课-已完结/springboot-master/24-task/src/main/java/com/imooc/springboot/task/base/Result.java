package com.imooc.springboot.task.base;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/11/30
 */
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static Result sucess() {
        return sucess(null);
    }

    public static Result sucess(Object data) {
        Result result = new Result();
        result.setMessage(MessageEnum.SUCCESS.getMessage());
        result.setCode(MessageEnum.SUCCESS.getCode());
        result.setData(data);
        return result;
    }

    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setCode(code);
        return result;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
