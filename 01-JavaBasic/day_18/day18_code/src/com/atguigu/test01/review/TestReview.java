package com.atguigu.test01.review;

public class TestReview {
	public static void main(String[] args) {
		MyThread my = new MyThread();
		
		my.start();
		my.start();
	}
}
class MyThread extends Thread{
	public void run(){
		//...
	}
}
