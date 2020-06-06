package day16作业_Test2_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Student {
	@MyTest
	public void show1(){
		System.out.println("我是show1");
	}
	
	@MyBefore
	public void show23(){
		System.out.println("我是show23");
	}
	@MyBefore
	public void show25(){
		System.out.println("我是show25");
	}
	@MyAfter
	public void show3(){
		System.out.println("我是show3");
	}
}
