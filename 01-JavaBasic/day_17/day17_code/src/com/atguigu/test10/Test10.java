package com.atguigu.test10;

/*
 * 步骤：
 * （1）编写线程类，实现Runnable
 * （2）重写run
 * （3）创建线程对象
 * （4）启动线程
 */
public class Test10 {
	public static void main(String[] args) {
		Ticket t = new Ticket();
		
		Thread t1 = new Thread(t,"窗口一");
		Thread t2 = new Thread(t,"窗口二");
		Thread t3 = new Thread(t,"窗口三");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
class Ticket implements Runnable{
	private int total = 10;

	@Override
	public void run() {
		while(true){
			synchronized (this) {//选择this当锁，可以，因为只有一个Ticket的对象
				if(total>0){
					System.out.println(Thread.currentThread().getName() +"卖出一张票");
					total--;
					System.out.println("剩余：" + total);
				}else{
					break;
				}
			}
		}
	}
	
}