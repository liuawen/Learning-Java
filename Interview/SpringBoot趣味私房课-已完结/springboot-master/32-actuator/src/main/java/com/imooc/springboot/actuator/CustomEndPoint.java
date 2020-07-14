package com.imooc.springboot.actuator;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : 刘水镜
 * @Description :
 * @Date Create in 2020/4/6 19:42
 */
@Component
@Endpoint(id = "customEndPoint")
public class CustomEndPoint {

    @ReadOperation
    public Map<String,String> read() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "自定义端点");
        return map;
    }

    @WriteOperation
    public Map<String,String> write(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("message", name + " 已被修改");
        return map;
    }

    @DeleteOperation
    public Map<String,String> delete(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("message", name + " 已被删除");
        return map;
    }

}
