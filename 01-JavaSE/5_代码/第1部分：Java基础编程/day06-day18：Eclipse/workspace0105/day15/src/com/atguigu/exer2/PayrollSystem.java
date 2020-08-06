package com.atguigu.exer2;

import java.util.Calendar;
import java.util.Scanner;

/*
 * 定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
 * 利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday。
 * 当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。

 */
public class PayrollSystem {
	public static void main(String[] args) {
		//方式一：
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入当月的月份：");
//		int month = scanner.nextInt();
		
		//方式二：
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);//获取当前的月份
//		System.out.println(month);//一月份：0
		
		
		Employee[] emps = new Employee[2];
		
		emps[0] = new SalariedEmployee("马森", 1002,new MyDate(1992, 2, 28),10000);
		emps[1] = new HourlyEmployee("潘雨生", 2001, new MyDate(1991, 1, 6),60,240);
		
		for(int i = 0;i < emps.length;i++){
			System.out.println(emps[i]);
			double salary = emps[i].earnings();
			System.out.println("月工资为：" + salary);
			
			if((month+1) == emps[i].getBirthday().getMonth()){
				System.out.println("生日快乐！奖励100元");
			}
			
		}
	}
}
