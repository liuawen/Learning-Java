package com.itheima_04;

/*
    void setDaemon​(boolean on)：将此线程标记为守护线程，当运行的线程都是守护线程时，Java虚拟机将退出
 */
public class ThreadDaemonDemo {
    public static void main(String[] args) {
        ThreadDaemon td1 = new ThreadDaemon();
        ThreadDaemon td2 = new ThreadDaemon();

        td1.setName("关羽");
        td2.setName("张飞");

        td1.start();
        td2.start();
    }
}
