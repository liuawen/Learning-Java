package com.atguigu.test02.homework01;

/*
 * 案例：在子线程中输出1-100之间的偶数，主线程输出1-100之间的奇数。
 */
public class Test01 {
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				for (int i = 0; i <= 100; i+=2) {
					System.out.println("子线程：" + i);
				}
			}
		}.start();
		
		for (int i = 1; i <= 100; i+=2) {
			System.out.println("主线程：" + i);
		}
	}
}
