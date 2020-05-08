/**
 * @author Liu Awen
 * @create 2018-05-08 11:40
 */
/*
3、编写程序：由键盘输入三个整数分别存入变量num1、num2、num3，
对它们进行排序(使用 if-else if-else),并且从小到大输出。
*/
class Test08_Exer3{
    public static void main(String[] args){
        //1、键盘输入三个整数
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("请输入num1：");
        int num1 = input.nextInt();

        System.out.print("请输入num2：");
        int num2 = input.nextInt();

        System.out.print("请输入num3：");
        int num3 = input.nextInt();

        //2、判断
		/*
		利用这样排序  3 2 1 6种情况来判断下    4 3 2 1 24
		三个数排序，6种情况
		num1 <= num2 <= num3
		num1 <= num3 <= num2

		num2 <= num1 <= num3
		num2 <= num3 <= num1

		num3 <= num2 <= num1
		num3 <= num1 <= num2
		*/
        if(num1<=num2 && num2<=num3){
            System.out.println(num1 + "<=" +  num2 + "<=" +  num3);
        }else if(num1<=num3 && num3<=num2){
            System.out.println(num1 + "<=" +  num3 + "<=" +  num2);
        }else if(num2<=num1 && num1<=num3){
            System.out.println(num2 + "<=" +  num1 + "<=" +  num3);
        }else if(num2<=num3 && num3<=num1){
            System.out.println(num2 + "<=" +  num3 + "<=" +  num1);
        }else if(num3<=num2 && num2<=num1){
            System.out.println(num3 + "<=" +  num2 + "<=" +  num1);
        }else{
            System.out.println(num3 + "<=" +  num1 + "<=" +  num2);
        }

    }
}