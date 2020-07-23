package com.atguigu.test05.homework03.copy;

/*
 * 案例：创建和启动2个子线程，一个打印奇数，一个打印偶数，

（1）要求实现交替打印。

（2）每个数打印间隔1秒
 */
public class Test03 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		
		t1.start();
		t2.start();
	}
}
class PrintNumber{
	private static int num = 1;
	
	public static synchronized void print(){
		try {
			PrintNumber.class.notify();
			System.out.println(Thread.currentThread().getName() + ":" + num);
			num++;
			PrintNumber.class.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class MyThread extends Thread{

	public void run(){
		while(true){
			PrintNumber.print();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}