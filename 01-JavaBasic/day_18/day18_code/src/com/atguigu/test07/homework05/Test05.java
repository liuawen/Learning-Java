package com.atguigu.test07.homework05;

/*
 * 案例：请按要求编写多线程应用程序，模拟多个人通过一个山洞：

​	1、这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒；

​	2、随机生成10个人，同时准备过此山洞

​	3、定义一个变量用于记录通过隧道的人数

​	4、显示每次通过山洞人的姓名，和通过顺序；
 */
public class Test05 {
	public static void main(String[] args) {
		Tunnel t = new Tunnel();
		
		for (int i = 1; i <= 10; i++) {
			Thread th = new Thread(t, "p" + i);
			th.start();
		}
	}
}
class Tunnel implements Runnable{
	private int num;
	
	public void run(){
		cross();
	}
	
	//每次只能由一个线程执行，相当于是一个人通过
	public synchronized void cross(){
		System.out.println(Thread.currentThread().getName() + "准备开始通过...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		num++;
		System.out.println(Thread.currentThread().getName()+"通过了隧道，TA是第" + num);
	}
}