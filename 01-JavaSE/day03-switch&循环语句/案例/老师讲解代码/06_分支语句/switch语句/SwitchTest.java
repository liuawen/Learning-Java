/*
	春夏秋冬

	需求：
		一年有12个月，分属于春夏秋冬4个季节，键盘录入一个月份，请用程序实现判断该月份属于哪个季节，并输出。

	春：3、4、5
	夏：6、7、8
	秋：9、10、11
	冬：1、2、12
*/

import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {
		//键盘录入月份数据，使用变量接收
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一个月份：");
		int month = sc.nextInt();
		
		//多情况判断，这里采用switch语句实现
		//在每种情况中，完成输出对应的季节
		/*
		switch(month) {
			case 1:
				System.out.println("冬季");
				break;
			case 2:
				System.out.println("冬季");
				//break;
			case 3:
				System.out.println("春季");
				break;
			case 4:
				System.out.println("春季");
				break;
			case 5:
				System.out.println("春季");
				break;
			case 6:
				System.out.println("夏季");
				break;
			case 7:
				System.out.println("夏季");
				break;
			case 8:
				System.out.println("夏季");
				break;
			case 9:
				System.out.println("秋季");
				break;
			case 10:
				System.out.println("秋季");
				break;
			case 11:
				System.out.println("秋季");
				break;
			case 12:
				System.out.println("冬季");
				break;
			default:
				System.out.println("你输入的月份有误");
				//break;
		}
		*/
		
		//case穿透
		switch(month) {
			case 1:
			case 2:
			case 12:
				System.out.println("冬季");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("春季");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("夏季");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("秋季");
				break;
			default:
				System.out.println("你输入的月份有误");
		}		
	}
}