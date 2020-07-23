package com.atguigu.test13;
/*
 * 死锁：
 *   两个线程，互相持有，占有对方想要的锁，不放手。
 */
public class TestDeadLock {
	public static void main(String[] args) {
		Object g = new Object();
		Object m = new Object();
		
		Boy b = new Boy(g,m);
		Bang bang = new Bang(g,m);
		
		b.start();
		bang.start();
	}
}
//男朋友
class Boy extends Thread{
	private Object girl;
	private Object money;
	
	public Boy(Object girl, Object money) {
		super();
		this.girl = girl;
		this.money = money;
	}

	public void run(){
		synchronized (money) {
			System.out.println("你放了我女朋友，我给你500万");
			synchronized (girl) {
				System.out.println("给了对方500万");
			}
		}
	}
}
//绑匪
class Bang extends Thread{
	
	private Object girl;
	private Object money;
	
	public Bang(Object girl, Object money) {
		super();
		this.girl = girl;
		this.money = money;
	}

	public void run(){
		synchronized (girl) {
			System.out.println("你给我500万，我放了你女朋友");
			synchronized (money) {
				System.out.println("放人");
			}
		}
	}
}