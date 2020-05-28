package com.atguigu.thread;

public class TestThread {
	public static void main(String[] args) {
		Ticket t1 = new Ticket("窗口一");
		Ticket t2 = new Ticket("窗口二");
		
		t1.start();
		t2.start();
	}
}
class Ticket extends Thread{
	private static int count = 10;//共享数据
	
	public Ticket() {
		super();
	}

	public Ticket(String name) {
		super(name);
	}

	public void run(){
		while(count>0){
			synchronized (Ticket.class) {
				if(count>0){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count--;
					System.out.println(getName() + "卖出一张票，剩余：" + count);
				}
			}
			
		}
	}
}