package cn.liuawen.thread;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-28
 */
/*
 * 3.定义一个测试类。
 */
public class RunnableDemo {
    public static void main(String[] args) {
        // 4.在main方法中打印主线程的名称。
        System.out.println("RunnableDemo:" + Thread.currentThread().getName());
        // 5.在main方法中创建一个子任务对象。
        SubRunnable r = new SubRunnable();
        // 6.在main方法中创建一个Thread类的对象，并把子任务对象传递给Thread类的                         构造方法。
        Thread t = new Thread(r);
        // 7.调用Thread类对象的start方法开启子线程。
        t.start();
        //RunnableDemo:main
        //SubRunnable:Thread-0
    }
}
