package cn.liuawen.thread;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-28
 */
/*
 * 1.定义一个子线程的类，继承Thread类；
 */
public class SubThread extends Thread {
    /*
     *2.在子线程类中重写run方法，在run方法中打印子线程的名称；
     */
    public void run() {
        // 打印子线程的名称
        System.out.println("subThread:" + Thread.currentThread().getName());
    }
}
