package com.awen.test04;
import org.junit.Test;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-22
 * @describe :
 */


/*
 * java.lang.Thread类的API：
 * （1）public void run()：子类必须重写，它的方法体也称为线程体，即线程的任务代码
 * （2）public void start()：线程启动必须用它
 * （3）public static void sleep(毫秒)：休眠
 * （4）public String getName()：线程的名称
 * 		主线程的名称：main
 * 		其他线程：默认是Thread-编号
 * （5）public static Thread currentThread()
 * （6）线程优先级
 * getPriority()
 * setPriority()
 * 		优先级的范围：MIN_PRIORITY - MAX_PRIORITY ，[1,10]
 * 		普通优先级：NORM_PRIORITY
 * 		一共10个等级。
 * 优先级高：被CPU调度的概率增加，不表示低的没有机会。
 * 所以：不能依赖于优先级来解决先后的任务问题。
 * 业务逻辑   可能性   API 控制
 *
 *  中断线程  interrupt()
 * （7）public void interrupt()
 * （8）public void join()：加塞
 * （9）public static void yield() ：暂停当前线程，让出本次的CPU资源，加入下一次CPU的抢夺中
 */
public class TestMethod {
    @Test
    public void testJoin() {
        MyRunnable my = new MyRunnable();
        Thread t = new Thread(my);
        t.start();

        MyRunnable my2 = new MyRunnable();
        Thread t2 = new Thread(my2);
        t2.start();


        for (int i = 1; i <= 10; i++) {
            System.out.println("main:" + i);
            if(i==3){
                try {
                    t.join();//当main线程打印到3后，被t线程加塞，main线程就不能继续，main被阻塞了，main要等到t线程结束才能继续了
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//				Thread.yield();
            }
        }
    }

    @Test
    public void testInterrupt(){
        MyThread my1= new MyThread();
        my1.start();

        //主线程休眠3秒后，中断MyThread线程
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        my1.interrupt();
    }

    @Test
    public void testPriority(){
        Thread t = Thread.currentThread();
        System.out.println(t.getPriority());//5

        MyThread my1= new MyThread();
        System.out.println(my1.getPriority());//5

        System.out.println("最高优先级：" + Thread.MAX_PRIORITY);//最高优先级：10
        System.out.println("最低优先级：" +Thread.MIN_PRIORITY);//最低优先级：1
        System.out.println("普通优先级：" + Thread.NORM_PRIORITY);//通优先级：5
    }

    @Test
    public void testName2(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName());//main

        MyThread my1= new MyThread();
        System.out.println(my1.getName());//Thread-0

        MyThread my2 = new MyThread();
        System.out.println(my2.getName());//Thread-1

        MyThread my3 = new MyThread("线程3");
        System.out.println(my3.getName());
    }

    @Test
    public void testName(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
    }

    @Test
    public void testSleep2(){
        //获取明天的当前时间
        try {
            Thread.sleep(24*60*60*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testSleep(){
        for (int i = 10; i>=1; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);//毫秒   1000毫秒= 1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyThread extends Thread{

    public MyThread() {
        super();
    }

    public MyThread(String name) {
        super(name);
    }

    public void run(){
        System.out.println("自定义线程");
        try {
            Thread.sleep(10000);//休眠10秒
        } catch (InterruptedException e) {
            System.out.println("自定义线程被打断");
            e.printStackTrace();
        }
        System.out.println("自定义线程休眠结束");
    }
}

class MyRunnable implements Runnable{
    public void run(){
        for (int i = 10; i>=1; i--) {
            System.out.println(Thread.currentThread().getName() + "run:" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}