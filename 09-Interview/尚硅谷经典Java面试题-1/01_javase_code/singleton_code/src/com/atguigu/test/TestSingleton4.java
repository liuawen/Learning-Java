package com.atguigu.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.atguigu.single.Singleton4;

public class TestSingleton4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
/*		Singleton4 s1 = Singleton4.getInstance();
		Singleton4 s2 = Singleton4.getInstance();
	
		System.out.println(s1 == s2);
		System.out.println(s1);
		System.out.println(s2);*/
		
		Callable<Singleton4> c = new Callable<Singleton4>() {

			@Override
			public Singleton4 call() throws Exception {
				return Singleton4.getInstance();
			}
		};
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<Singleton4> f1 = es.submit(c);
		Future<Singleton4> f2 = es.submit(c);
		
		Singleton4 s1 = f1.get();
		Singleton4 s2 = f2.get();
		
		System.out.println(s1 == s2);
		System.out.println(s1);
		System.out.println(s2);
		
		es.shutdown();
		
	}

}
