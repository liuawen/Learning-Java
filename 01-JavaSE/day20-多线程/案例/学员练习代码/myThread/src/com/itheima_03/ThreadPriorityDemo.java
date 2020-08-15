package com.itheima_03;

/*
    Thread类中设置和获取线程优先级的方法
        public final void setPriority(int newPriority)：更改此线程的优先级
        public final int getPriority()：返回此线程的优先级
 */
public class ThreadPriorityDemo {
    public static void main(String[] args) {
        ThreadPriority tp1 = new ThreadPriority();
        ThreadPriority tp2 = new ThreadPriority();
        ThreadPriority tp3 = new ThreadPriority();

        tp1.setName("高铁");
        tp2.setName("飞机");
        tp3.setName("汽车");

        tp1.start();
        tp2.start();
        tp3.start();
    }
}
