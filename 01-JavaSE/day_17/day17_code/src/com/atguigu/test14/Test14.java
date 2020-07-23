package com.atguigu.test14;

/*
 * 线程通信是用来解决生产者与消费者问题。
 * 
 * 生产者与消费者问题：
 * 	  有两个或者多个线程。
 * 	 其中一个/一部分线程，生产“数据”，称为生产者线程；
 * 	另一个/一部分线程，消耗“数据”，称为消费者线程。
 * 	这些数据放在一个“共享”区域。
 *  那么就会出现：
 *    当“共享”区域中的数据空了，消费者线程必须"停/等待"，等待到产者线程生产了新数据后，继续进行。
 *    当“共享”区域中的数据满了，生产者线程必须"停下/等待"，等到消费者线程消耗了数据后，继续进行。
 *    
 *  生产者与消费者问题：
 *  （1）共享数据：    就会有线程安全问题，就需要同步
 *  （2）共享区域大小固定，有限的：就需要用到“协作”，线程通信。
 *  
 *  Object类中有：
 *  （1）wait()：必须由锁对象（线程的监视器对象）来调用。
 *  （2）notify()：必须由锁对象（线程的监视器对象）来调用。
 *  notify()作用就是唤醒一个正在等待的线程。唤醒的是同一个锁对象监视的等待线程。
 */
public class Test14 {
	public static void main(String[] args) {
		Workbench tai = new Workbench();
		
		Cook c = new Cook("崔志恒", tai);
		Waiter w = new Waiter("翠花", tai);
		
		c.start();
		w.start();
	}
}
class Workbench{
	//假设工作台上最多能够放10盘
	private static final int MAX = 10;
	private int count;
	
	//同步方法，非静态方法来说，锁对象就是this
	public synchronized void put(){//往工作台上放一盘菜
		if(count >= MAX){
			try {
				//生产者停下来，等待
				wait();//默认是this.wait()
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count++;
		
		System.out.println(Thread.currentThread().getName() + "放了一盘菜，剩余：" + count);
		this.notify();
	}
	
	public synchronized void take(){//从工作台上取走一盘菜
		if(count<=0){
			try {
				//工作台没有菜，消费者应该停下来
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count--;
		System.out.println(Thread.currentThread().getName() + "取走一盘菜，剩余：" + count);
		this.notify();
	}
}
class Cook extends Thread{
	private Workbench tai;

	public Cook(String name, Workbench tai) {
		super(name);
		this.tai = tai;
	}

	public void run(){
		while(true){
			tai.put();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Waiter extends Thread{
	private Workbench tai;
	
	public Waiter(String name, Workbench tai) {
		super(name);
		this.tai = tai;
	}

	public void run(){
		while(true){
			tai.take();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}