/*
	switch语句
	
	格式：
		switch(表达式) {
			case 值1：
			语句体1;
			break;
			case 值2：
			语句体2;
			break;
			…
			default：	
			语句体n+1;
			[break;]
		}

	格式说明：
		表达式：取值为byte、short、int、char，JDK5以后可以是枚举，JDK7以后可以是String。
		case：后面跟的是要和表达式进行比较的值。
		break：表示中断，结束的意思，用来结束switch语句。
		default：表示所有情况都不匹配的时候，就执行该处的内容，和if语句的else相似。

	执行流程：
		首先计算表达式的值。
		依次和case后面的值进行比较，如果有对应的值，就会执行相应的语句，在执行的过程中，遇到break就会结束。
		如果所有的case后面的值和表达式的值都不匹配，就会执行default里面的语句体，然后程序结束掉。
*/	

import java.util.Scanner;

public class SwitchDemo {
	public static void main(String[] args) {
		System.out.println("开始");
		
		//需求：键盘录入一个星期数(1,2,...7)，输出对应的星期一，星期二，...星期日
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一个星期数(1-7)：");
		int week = sc.nextInt();
		
		switch(week) {
			case 1:
				System.out.println("星期一");
				break;
			case 2:
				System.out.println("星期二");
				break;
			case 3:
				System.out.println("星期三");
				break;
			case 4:
				System.out.println("星期四");
				break;
			case 5:
				System.out.println("星期五");
				break;
			case 6:
				System.out.println("星期六");
				break;
			case 7:
				System.out.println("星期日");
				break;
			default:
				System.out.println("你输入的星期数有误");
				break;
		}
		
		System.out.println("结束");
	}
}