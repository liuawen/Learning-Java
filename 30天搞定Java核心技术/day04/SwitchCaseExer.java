/*
从键盘分别输入年、月、日，判断这一天是当年的第几天
 
   注：判断一年是否是闰年的标准：
       1）可以被4整除，但不可被100整除
	或
       2）可以被400整除


说明：
1. 凡是可以使用switch-case的结构，都可以转换为if-else。反之，不成立。
2. 我们写分支结构时，当发现既可以使用switch-case,（同时，switch中表达式的取值情况不太多），
  又可以使用if-else时，我们优先选择使用switch-case。原因：switch-case执行效率稍高。

*/
import java.util.Scanner;
class SwitchCaseExer {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入year：");
		int year = scan.nextInt();
		System.out.println("请输入month：");
		int month = scan.nextInt();
		System.out.println("请输入day：");
		int day = scan.nextInt();


		//定义一个变量来保存总天数
		int sumDays = 0;

		switch(month){
		case 12:
			sumDays += 30;
		case 11:
			sumDays += 31;
		case 10:
			sumDays += 30;
		case 9:
			sumDays += 31;
		case 8:
			sumDays += 31;
		case 7:
			sumDays += 30;
		case 6:
			sumDays += 31;
		case 5:
			sumDays += 30;
		case 4:
			sumDays += 31;
		case 3:
			//sumDays += 28;
			//判断year是否是闰年
			if((year % 4 == 0 && year % 100 != 0 ) || year % 400 == 0){
				sumDays += 29;
			}else{
				sumDays += 28;
			}

		case 2:
			sumDays += 31;
		case 1:
			sumDays += day;
		}

		System.out.println(year + "年" + month + "月" + day + "日是当年的第" + sumDays + "天");
	}
}
