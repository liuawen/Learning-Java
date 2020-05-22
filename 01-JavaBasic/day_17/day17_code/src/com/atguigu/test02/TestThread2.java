package com.atguigu.test02;

/*
 * 1、Java中如何去实现多线程？
 * （1）Java的程序入口是main，其实也是main线程，主线程。
 * 线程是进程的其中一条执行路径，即一个进程至少有一个线程。那么main线程就是Java程序进程的第一个线程了。
 * （2）如何开启main线程以外的其他线程呢？
 * 这里讲解JavaSE阶段2种，后面会发现还有其他方式。
 * 方式有两种：①继承Thread类②实现Runnable接口
 * 
 * 2、继承Thread类
 * 步骤：
 * （1）编写线程类去继承java.lang.Thread类
 * （2）必须重写父类的public void run(){}
 * 在run()中需要编写，你这个线程需要完成的任务。
 * （3）创建线程类对象
 * （4）启动线程：start()
 * 
 * 
 * 3、实现Runnable 接口
 * 步骤：
 * （1）编写线程类去实现java.lang.Runnable接口
 * （2）必须实现接口的抽象方法：public void run()
 * 在run()中需要编写，你这个线程需要完成的任务。
 * （3）创建线程类对象
 * （4）启动线程：start()
 * 这个start()方法只有Thread类中才有，说明我们要借用Thread类的对象。
 */
public class TestThread2 {
	public static void main(String[] args) {
		System.out.println("hello thread");
		
		MyThread my = new MyThread();
//		my.run();//这么调用，就不是开启多线程，而是普通对象调用方法
		my.start();//从父类Thread中继承的
		
		for (int i = 1; i <=100; i++) {
			System.out.println("main:" + i);
		}
	}
	
}
class MyThread extends Thread{

	@Override
	public void run() {
		//例如：这个线程要完成的任务是，打印1-100之间的数字
		for (int i = 1; i <= 100; i++) {
			System.out.println("自定义线程：" + i);
		}
	}
	
}