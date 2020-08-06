package com.atguigu.exer1;

public class TriAngleTest {
	public static void main(String[] args) {
		
		TriAngle t1 = new TriAngle();
		t1.setBase(2.0);
		t1.setHeight(2.4);
//		t1.base = 2.5;//The field TriAngle.base is not visible
//		t1.height = 4.3;
		System.out.println("base : " + t1.getBase() + ",height : " + t1.getHeight());
		
		TriAngle t2 = new TriAngle(5.1,5.6);
		System.out.println("base : " + t2.getBase() + ",height : " + t2.getHeight());
	}
}
