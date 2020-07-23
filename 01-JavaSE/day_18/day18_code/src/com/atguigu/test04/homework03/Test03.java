package com.atguigu.test04.homework03;

/*
 * 案例：创建和启动2个子线程，一个打印奇数，一个打印偶数，

（1）要求实现交替打印。

（2）每个数打印间隔1秒
 */
public class Test03 {
	public static void main(String[] args) {
		PrintNumber  p = new PrintNumber();
		
		MyThread t1 = new MyThread(p);
		MyThread t2 = new MyThread(p);
		
		t1.start();
		t2.start();
	}
}
class PrintNumber{
	private int num = 1;
	
	public synchronized void print(){
		try {
			this.notify();
			System.out.println(Thread.currentThread().getName() + ":" + num);
			num++;
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class MyThread extends Thread{
	private PrintNumber p;
	
	public MyThread(PrintNumber p) {
		super();
		this.p = p;
	}

	public void run(){
		while(true){
			p.print();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}