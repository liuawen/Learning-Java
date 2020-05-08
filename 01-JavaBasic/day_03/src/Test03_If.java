/**
 * @author Liu Awen
 * @create 2018-05-08 11:30
 */
/*
二、分支结构
1、条件判断：if..else
2、选择结构：switch...case

（一）条件判断
1、单分支条件判断
语法格式：
if(条件表达式){
	当该条件表达式成立时，需要执行的语句
}

说明：
（1）if()中表达式必须是boolean类型的结果
①本身就是boolean类型的值
②比较表达式
③逻辑表达式
（2）当{}中的语句只有一句时，可以省略{}
但是我们不建议省略{}

提醒：
学习流程控制语句结构：
（1）语法格式
（2）执行特点
*/
class Test03_If{
    public static void main(String[] args){
        //1、从键盘输入一个年份
        //(1)准备Scanner扫描仪对象
        java.util.Scanner input = new java.util.Scanner(System.in);
        //(2)提示输入年份
        System.out.print("请输入年份：");
        //(3)输入并接收一个整数作为年份
        int year = input.nextInt();

        //2、需求：判断这个年份是否是闰年，然后显示它的2月份的总天数
        /*闰年的条件：（1）被4整除但不能被100整除或（2）被400整除
         */
        int days = 28;//平年

        //如果是闰年，days 修改为29
		/*
		if(year%4==0 && year%100!=0 || year%400==0){
			days = 29;
		}
		*/
        if(year%4==0 && year%100!=0 || year%400==0)
            days = 29;

        System.out.println(year+"的2月份的总天数有：" + days);
    }
}








