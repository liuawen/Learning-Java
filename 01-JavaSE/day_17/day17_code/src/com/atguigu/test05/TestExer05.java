package com.atguigu.test05;

/*
 * 案例：编写龟兔赛跑多线程程序，设赛跑长度为30米
兔子的速度是10米每秒，兔子每跑完10米休眠的时间10秒
乌龟的速度是1米每秒，乌龟每跑完10米的休眠时间是1秒
要求，每跑1米，显示一下结果：xxx跑了几米，
	  休息时，显示一下：xxx在休息...
 */
public class TestExer05 {
	public static void main(String[] args) {
		TuZi t = new TuZi();
		WuGui w = new WuGui();
		
		t.start();
		w.start();
	}
}
class TuZi extends Thread{
	public void run(){
		for (int i = 1; i <= 30; i++) {
			try {
				//兔子的速度是10米每秒
				Thread.sleep(100);//模拟跑1米的时间
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("兔子跑了" + i + "米");
			
			if(i== 10 || i == 20){
				System.out.println("兔子在休息....");
				try {
					Thread.sleep(10000);//休息10秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
class WuGui extends Thread{
	public void run(){
		for (int i = 1; i <= 30; i++) {
			try {
				//乌龟的速度是1米每秒
				Thread.sleep(1000);//模拟跑1米的时间
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("乌龟跑了" + i + "米");
			
			if(i== 10 || i == 20){
				System.out.println("乌龟在休息....");
				try {
					Thread.sleep(1000);//休息1秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}