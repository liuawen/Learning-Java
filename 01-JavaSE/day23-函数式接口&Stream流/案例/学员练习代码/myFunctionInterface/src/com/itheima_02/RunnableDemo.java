package com.itheima_02;

/*
    定义一个类(RunnableDemo)，在类中提供两个方法
        一个方法是：startThread(Runnable r)   方法参数Runnable是一个函数式接口
        一个方法是主方法，在主方法中调用startThread方法
 */
public class RunnableDemo {
    public static void main(String[] args) {
        //在主方法中调用startThread方法

        //匿名内部类的方式
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程启动了");
            }
        });

        startThread(() -> System.out.println(Thread.currentThread().getName() + "线程启动了"));

    }

    private static void startThread(Runnable r) {
//        Thread t = new Thread(r);
//        t.start();
        new Thread(r).start();
    }
}
