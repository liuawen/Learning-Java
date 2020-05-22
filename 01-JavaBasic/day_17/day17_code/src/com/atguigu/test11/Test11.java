package com.atguigu.test11;

/*
 * 同步方法的语法格式：
 * 【修饰符】 synchronized 返回值类型  方法名(【形参列表】)throws 异常列表{
 * }
 * 
 * synchronized 【修饰符】  返回值类型  方法名(【形参列表】)throws 异常列表{
 * }
 * 
 * 同步方法的锁对象，程序员无法选择：
 * （1）非静态方法：this
 * （2）静态方法：当前类的Class对象
 */
public class Test11 {
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
	private static int total = 10;
	
	public Ticket(String name) {
		super(name);
	}

	public void run(){
		while(total>0){//程序停止的条件
			saleOneTicket();
		}
	}
	
	public synchronized static void saleOneTicket(){
		if(total > 0){//线程安全问题的条件
			System.out.println(Thread.currentThread().getName() + "卖出一张票");
			total--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("剩余：" + total);
		}
	}
	
	//同步方法，锁的是方法的一次调用过程
	//非静态方法的锁对象是this，这里使用this，不是合格的锁对象
	/*public synchronized void saleOneTicket(){
		if(total > 0){//线程安全问题的条件
			System.out.println(getName() + "卖出一张票");
			total--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("剩余：" + total);
		}
	}*/
}