package com.atguigu.exer3;

public class ComparableCircleTest {
	public static void main(String[] args) {
		
		
		ComparableCircle c1 = new ComparableCircle(3.4);
		ComparableCircle c2 = new ComparableCircle(3.6);
		
		int compareValue = c1.compareTo(c2);
		if(compareValue > 0){
			System.out.println("c1对象大");
		}else if(compareValue < 0){
			System.out.println("c2对象大");
		}else{
			System.out.println("c1与c2一样大");
		}
		
		
		int compareValue1 = c1.compareTo(new String("AA"));
		System.out.println(compareValue1);
	}
}
