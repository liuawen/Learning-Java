package com.imooc.springboot.ioc;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author : 刘水镜
 * @Description :
 * @Date Create in 2019/12/30 22:38
 */
@Slf4j
public class Train implements Driveable {
    @Override
    public void drive() {
        log.info("坐火车出去浪~");
    }
}
