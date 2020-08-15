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
		
		
	}
}