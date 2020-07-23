package com.atguigu.test17;

import org.junit.Test;

/*
 * 单例设计模式：
 * 
 * 单例：某个类只能有唯一的一个实例对象。
 * 
 * 如何实现单例？
 * 1、饿/恶汉式
 * 不管我们使用者是否需要这个对象，它都上来先给你创建好这个唯一的对象。
 * （1）枚举类型
 * （2）形式二
 * ①构造器私有化
 * ②用一个全局的静态的常量，来保存这个唯一的实例对象
 * （3）形式三
 * ①构造器私有化
 * ②用一个私有的静态的常量，来保存这个唯一的实例对象
 * ③提供一个静态方法，来返回这个常量对象
 * 
 * 2、懒汉式
 * 延迟创建对象。当使用者来或者这个对象，要用到对象时，我再创建。
 * （1）形式一：
 * 见下面，考虑线程安全问题和性能问题
 * （2）形式二：内部类形式
 * 
 */
public class Test17 {
	@Test
	public void test1(){
		SingleEnum s1 = SingleEnum.INSTANCE;
		SingleEnum s2 = SingleEnum.INSTANCE;
		System.out.println(s1 == s2);
	}
	
	@Test
	public void test2(){
//		SingleEnum.test();//此时我并没有需要用到这个对象，但是它也创建出来了
	}
	
	@Test
	public void test3(){
		SingleClass s1 = SingleClass.INSTANCE;
		SingleClass s2 = SingleClass.INSTANCE;
		System.out.println(s1==s2);
	}
	
	@Test
	public void test4(){
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		System.out.println(s1 == s2);
	}
	
	@Test
	public void test5(){
		LazyClass s1 = LazyClass.getInstance();
		LazyClass s2 = LazyClass.getInstance();
		System.out.println(s2 == s1);
	}
	
	LazyClass s1;
	LazyClass s2;
	@Test
	public void test6(){
		//匿名的内部类，继承Thread类
		Thread t1 = new Thread(){
			public void run(){
				s1 = LazyClass.getInstance();
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				s2 = LazyClass.getInstance();
			}
		};
		
		t1.start();
		t2.start();
		
		try {
			//这里用join的目的是，为了两个子线程都执行完，再执行主线程的System.out.println(s1);
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
	
}
enum SingleEnum{
	INSTANCE;
//	public static void test(){
//		//..
//	}
}
class SingleClass{
	public static final SingleClass INSTANCE = new SingleClass();
	private SingleClass(){
		
	}
}
class Single{
	private static final Single INSTANCE = new Single();
	private Single(){
		
	}
	public static Single getInstance(){
		return INSTANCE;
	}
}

class LazyClass{
	private static LazyClass instance;
	private LazyClass(){
		
	}
	
	public static LazyClass getInstance(){
		if(instance == null){//提高效率
			synchronized(LazyClass.class){//当前类的Class对象
				if(instance == null){//安全判断
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new LazyClass();
				}
			}
		}
		return instance;
	}
	
	//安全没问题，但是认为不是最优的
/*	public synchronized static LazyClass getInstance(){
		if(instance == null){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new LazyClass();
		}
		return instance;
	}*/
	
	//有安全问题
/*	public static LazyClass getInstance(){
//		return new LazyClass();//错误的
		if(instance == null){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new LazyClass();
		}
		return instance;
	}*/
}

class Lazy{
	private Lazy(){
		
	}
	
	private static class Inner{
		public static final Lazy INSTANCE = new Lazy();//在内部类中，创建外部类的唯一对象
	}
	
	public static Lazy getInstance(){
		return Inner.INSTANCE;
	}
}