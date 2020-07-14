package com.imooc.springboot.ioc;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author : 刘水镜
 * @Description :
 * @Date Create in 2019/12/30 21:55
 */
@Slf4j
public class Bike implements Driveable {
    @Override
    public void drive() {
        log.info("骑着自行车出去浪~");
    }
}
