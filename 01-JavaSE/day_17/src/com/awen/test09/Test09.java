package com.awen.test09;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-22
 * @describe :
 */

/*
 * 举例：卖票
 * 假设，有10张票，分三个窗口同时卖
 *
 * 1、线程安全问题：
 2 * 	当一个线程修改了“共享数据”，是会影响其他线程。
 *
 * 2、如何解决？
 * 	加锁
 *
 * 形式一：同步代码块
 * 形式二：同步方法
 *
 * 3、同步代码块
 * 语法格式：
 * synchronized(锁对象){
 * 		需要加锁的代码
 * }
 *
 * 锁对象，又称为监视器对象，同一时刻，某一段代码，只允许一个线程运行，这个锁就记录谁现在在运行，其他线程进不来。
 *
 * 锁对象的选择：
 * （1）可以是任意类型的对象
 * （2）必须是这几天线程要使用同一个锁对象
 *
 * 锁的代码的范围的选择：
 * （1）太大了：不行
 * （2）太小了：不行
 * 锁一次任务
 */
public class Test09 {
    public static void main(String[] args) {
        Ticket t1 = new Ticket("窗口一");
        Ticket t2 = new Ticket("窗口二");
        Ticket t3 = new Ticket("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Ticket extends Thread{
    private static int total = 1000;
    private static Object lock = new Object();//锁的选择之一，单独造一个锁对象

    public Ticket(String name) {
        super(name);
    }

    public void run(){
        //	synchronized (this) {//这里使用this不行，因为这个this，对于三个线程来说不是同一个
        while(true){
            synchronized (lock) {
                if(total > 0){
                    System.out.println(getName() + "卖出一张票");
                    total--;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("剩余：" + total);
                }else{
                    break;
                }
            }
        }
    }
}