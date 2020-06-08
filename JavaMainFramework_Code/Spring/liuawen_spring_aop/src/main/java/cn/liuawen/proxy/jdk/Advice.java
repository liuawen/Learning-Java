package cn.liuawen.proxy.jdk;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-08
 */
public class Advice {
    public void before(){
        System.out.println("前置增强...");
    }
    public void afterReturning(){
        System.out.println("后置增强...");
    }
}
