/**
 * @author Liu Awen
 * @create 2020-05-06 21:25
 */
/*
练习1：打印个人信息

（1）数据类型
"xxx" -->字符串
10-->整数，整型
'x'-->字符，单个字符
true-->布尔值，逻辑值，它只有两种情况，true和false
70.5-->小数类型
（2）常量
字符串的常量必须用""（双引号）
单字符的常量，必须用''（单引号）
其他整数、小数、布尔等不需要加符号。

System.out.println(xx);  输出xx之后换行，ln==line
System.out.print(xx);输出xx之后不换行，下面的输出内容就会接着输出
*/
class TestExer1{
    public static void main(String[] args){
        System.out.println("菜鸡文");
        System.out.println(18);
        System.out.println('拿');
        System.out.println(false);
        System.out.println(70);
        System.out.println("--------------------------------");

        System.out.print("姓名：");
        System.out.print("菜鸡文");
        //菜鸡文
        //18
        //拿
        //false
        //70
        //--------------------------------
        //姓名：菜鸡文
        //Process finished with exit code 0
    }
}
