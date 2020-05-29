package com.atguigu.test05;

import java.util.Random;

public class TestTools{
	public static void main(String[] args) {
		MyThread m1 = new MyThread();
		m1.start();
		
		MyThread m2 = new MyThread();
		m2.start();
	}
}
class Tools {
	private static Random rand = new Random();//产生随机数的工具类
	private static ThreadLocal<Integer> th = new ThreadLocal<Integer>();
	
	public static void setNumber(){
		th.set(rand.nextInt(100));//这里设置的就是当前线程保存的共享变量，这个共享变量不是我们之前说的多个线程之间共享，是说的是同一个线程在整个生命周期中，使用的共享变量
	}
	
	public static int getNumber(){
		return th.get();
	}
}
class MyThread extends Thread{
	public void run(){
		Tools.setNumber();
		
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int number = Tools.getNumber();
			System.out.println(Thread.currentThread().getName() +":"+ number);
		}
	}
}
