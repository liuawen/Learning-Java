/**
 * @author Liu Awen
 * @create 2018-05-08 11:38
 */
/*
二、分支结构
1、条件判断：if..else
2、选择结构：switch...case

（一）条件判断
1、单分支条件判断
2、双分支条件判断
if(条件表达式){
	当条件表达式成立时，要执行的语句块;
}else{
	当条件表达式不成立时，要执行的语句块;
}

说明：
（1）条件表达式必须是boolean值
（2）当{}中的语句只有一句时，可以省略{}
不建议省略{}
*/
class Test04_IfElse{
    public static void main(String[] args){
		/*
		从键盘输入一个整数，判断是偶数还是奇数
		*/
        //1、键盘输入
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = input.nextInt();

        //2、判断
		/*
		if(num%2==0){
			System.out.println(num + "是偶数");
		}else{
			System.out.println(num + "是奇数");
		}
		*/

        if(num%2==0)
            System.out.println(num + "是偶数");
        else
            System.out.println(num + "是奇数");

    }
}