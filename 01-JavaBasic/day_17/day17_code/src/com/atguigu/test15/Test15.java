package com.atguigu.test15;

/*
 * 什么情况下会释放锁？
 * （1）同步代码块或同步方法中的代码运行完了。
 * （2）wait()
 * （3）遇到异常，但是没有处理，这个线程死了，会释放锁
 * 
 * 什么情况下不会释放锁？
 * （1）sleep()
 * （2）yield()
 * （3）suspend()
 * 
 * 举例：
 * wait()释放锁
 * sleep()不释放
 * 
 * 面试题：
 * wait()和sleep()的区别？
 * （1）wait()释放锁和sleep()不释放
 * （2）wait()是Object类中声明
 *    sleep()是Thread类中声明的
 * （3）   wait()必须有“锁，监视器”对象来调用，如果由别的对象调用会报IllegleMoniterStateException
 * 	   sleep()是静态方法，Thread类名调用就可以
 * （4）wait()使得当前线程进入阻塞状态后，由notify唤醒
 *    sleep()使得当前线程进入阻塞状态后，时间到或被interrupt()醒来。
 * 
 */
public class Test15 {

}
