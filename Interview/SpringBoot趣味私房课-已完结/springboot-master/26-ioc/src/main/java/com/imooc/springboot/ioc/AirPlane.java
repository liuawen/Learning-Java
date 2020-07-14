package com.imooc.springboot.ioc;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author : 刘水镜
 * @Description :
 * @Date Create in 2019/12/30 22:40
 */
@Slf4j
public class AirPlane implements Driveable {
    @Override
    public void drive() {
        log.info("坐灰机出去浪~");
    }
}
