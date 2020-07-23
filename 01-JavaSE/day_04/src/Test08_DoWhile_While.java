/**
 * @author Liu Awen
 * @create 2018-05-08 15:53
 */
/*
循环结构：
1、for
for(初始化; 循环条件; 迭代语句){
	循环体语句块;
}
2、while
while(循环条件){
	循环体语句块;
}
3、do...while

语法结构：
do{
	循环体语句块：需要重复的代码
}while(循环条件);

说明：
（1）do{}while(循环体条件);后面的;要注意

执行过程：
（1）先执行一次循环体语句块
（2）然后再判断条件，看是否继续下一次
（3）如果条件成立，再次执行循环体语句块；然后回到（2）
     如果条件不成立，直接结束do...while

do...while循环与for和while的最大区别：它的循环体语句块是至少执行一次。
*/
class Test08_DoWhile_While{
    public static void main(String[] args){
		/*
		3、从键盘输入整数，输入0结束，统计输入的正数、负数的个数。
		*/
        //从键盘输入整数=>java.util.Scanner
        java.util.Scanner input = new java.util.Scanner(System.in);
        int positive = 0;//统计正数的个数
        int negative = 0;//统计负数的个数

        //num初始化为1的目的，就是为了第一次可以进入循环
        int num = 1;
        while(num!=0){
            //因为从键盘输入整数是重复做，所以放到循环体中
            System.out.print("请输入整数（0表示结束）：");
            num = input.nextInt();//可以作为迭代语句，修改num的值

            //统计输入的正数、负数的个数
            if(num>0){
                positive++;
            }else if(num<0){
                negative++;
            }
        }
        //循环条件 想：条件满足，继续执行循环体语句，条件不满足，结束循环
        //此时循环条件，num!=0

        System.out.println("正数的个数：" + positive);
        System.out.println("负数的个数：" + negative);
    }
}