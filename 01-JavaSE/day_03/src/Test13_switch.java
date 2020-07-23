/**
 * @author Liu Awen
 * @create 2018-05-08 12:55
 */
/*
二、分支结构
1、条件判断：if..else
2、选择结构：switch...case

（一）条件判断
1、单分支条件判断
2、双分支条件判断
3、多分支条件判断
4、嵌套条件判断

（二）选择结构
语法结构：
switch(表达式){
	case 常量值1:
		语句块1;
		【break;】
	case 常量值2:
		语句块2;
		【break;】
	...
	【default:
		语句块n+1;
		【break;】
	】
}
要求：
（1）case后面必须是常量值
（2）case后面的常量值不能重复
（3）switch()中的表达式的类型有要求：
	允许4种基本数据类型：byte,short,int,char
	允许2种引用数据类型：枚举（JDK1.5之后）、String（JDK1.7之后）
表达式的类型是由要求的   char short int char
枚举1.5 String 1.7
执行特点：
（1）入口
①当switch()中的表达式的值与某一个case后面的常量值“相等”，就会从这个case进入
②当switch()中的表达式的值与所有的case后面的常量值都“不相等”，就会寻找default进入
（2）出口
①自然出口：switch的结束}
②中断出口：break    （或后面要讲的return等）
（3）一旦找到“入口”就会顺序往下执行，直到遇到“出口”
（4）default的位置不一定在最后，习惯上我们写在最后

switch：开关
一档二档三档等等
*/
class Test13_switch{
    public static void main(String[] args){
		/*
		请输入星期的数字，输出对应的英语单词
		*/
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("请输入星期（1-7）：");
        int week = input.nextInt();
        //要break结束的 都不等于 才default
        //int a = 1;
        switch(week){
            default:
                System.out.println("输入有误");
                break;
            //case a:// a不是常量
            //常量表达式
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
//            default:
//                System.out.println("输入有误");
//                break;

        }
    }
}
