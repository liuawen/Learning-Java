package com.atguigu.test12;

public class Test12 {
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
		while(total>0){
			saleOneTicket();
		}
	}
	//当前同步方法的锁对象是this，可以的，因为只有一个Ticket
	public synchronized void saleOneTicket(){
		if(total>0){
			System.out.println(Thread.currentThread().getName() +"卖出一张票");
			total--;
			System.out.println("剩余：" + total);
		}
	}
}