package com.atguigu.test03.homework02;

/*
 * 案例：创建和启动2个子线程，一个打印1-10之间奇数，一个打印1-10之间偶数，
（1）要求每个线程要么不打印，要么就连续打印5个数，每个数打印间隔500毫秒
（2）但两个线程不要求交替打印。
 */
public class Test02 {
	public static void main(String[] args) {
		Odd o = new Odd();
		Even e = new Even();
		
		o.start();
		e.start();
	}
}
class Odd extends Thread{
	private int num = 1;
	public void run(){
		while(true){
			synchronized (Thread.class) {
				for (int i = 1; i <=5; i++) {
					System.out.println("奇数线程，第"  + i + "个：" + num);
					num += 2;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
}
class Even extends Thread{
	private int num = 0;
	public void run(){
		while(true){
			synchronized (Thread.class) {
				for (int i = 1; i<=5; i++) {
					System.out.println("偶数线程，第"  + i + "个：" + num);
					num += 2;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}