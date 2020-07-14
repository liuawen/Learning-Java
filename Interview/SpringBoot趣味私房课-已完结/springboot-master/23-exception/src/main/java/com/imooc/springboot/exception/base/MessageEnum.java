package com.imooc.springboot.exception.base;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/11/30
 */
public enum MessageEnum {
    UNKNOW_ERROR(-1, "未知错误！"),
    ERROR(500, "系统错误"),
    SUCCESS(0, "操作成功！"),
    ;
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    MessageEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
