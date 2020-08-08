package com.atguigu.bookstore.test;

public class ThreadLocalTest implements Runnable{

	String name = null;
	int i = 0;
	
	@Override
	public void run() {
		for(;i < 10; i++){
			//synchronized (this) {
			name = Thread.currentThread().getName();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
			
			System.out.println(Thread.currentThread().getName() + ": " + name);				
			//}
		}
	}
	
	public static void main(String[] args) {
		
		ThreadLocalTest tlt = new ThreadLocalTest();
		
		new Thread(tlt, "AAA").start();
		new Thread(tlt, "BBB").start();
		
	}

}
