/**
 * @author Liu Awen
 * @create 2018-05-08 11:39
 */
/*
二、分支结构
1、条件判断：if..else
2、选择结构：switch...case

（一）条件判断
1、单分支条件判断
2、双分支条件判断
3、多分支条件判断
语法格式：
if(条件表达式1){
	当条件表达式1成立时，要执行的语句块1;
}else if(条件表达式2){
	当条件表达式1不成立，
	当条件表达式2成立时，要执行的语句块2;
}else if(条件表达式3){
	当条件表达式1不成立，
	当条件表达式2不成立，
	当条件表达式3成立时，要执行的语句块3;
}。。。
【
else{
	当以上所有的条件都不成立时，要执行的语句块n+1；
}
】

说明：
（1）所有条件表达式必须是boolean值
（2）当{}中的语句只有一句时，可以省略{}
不建议省略{}


执行特点：
（1）不管有几个分支，最终只会执行其中的一个
（2）这么多条件表达式是顺序往下判断的，
如果上面有条件成立了，下面的就不看了；
如果上面的条件不成立，才会去看下面条件。
当多个条件的范围是“互斥”（没有重叠部分），顺序可以随意；
当多个条件的范围是“包含”（有重叠部分），顺序不能随意，小的在上，大的在下

*/
class Test06_IfElseIf{
    public static void main(String[] args){
		/*从键盘输入成绩：假设成绩输入[0,100]的合法成绩，这里先不讨论不合法的情况
		成绩分为：
			100分，输出满分
			90-99，输出优秀
			70-89，输出良好
			60-69，输出及格
			60以下，输出不及格
			平常我是直接一个个的
			score == 100
			score >= 90 && score <=99
			我可以这样
			score == 100
			score >=90
			score >=70
		*/
        //1、从键盘输入成绩：
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("请输入成绩：");
        int score = input.nextInt();

        //2、判断

        if(score == 100){
            System.out.println("满分");
        }else if(score>=90 && score<=99){
            System.out.println("优秀");
        }else if(score>=70 && score<=89){
            System.out.println("良好");
        }else if(score>=60 && score<=69){
            System.out.println("及格");
        }else{
            System.out.println("不及格");
        }

		/*
		if(score == 100){
			System.out.println("满分");
		}else if(score>=90){
			System.out.println("优秀");
		}else if(score>=70){
			System.out.println("良好");
		}else if(score>=60){
			System.out.println("及格");
		}else{
			System.out.println("不及格");
		}
		*/
    }
}