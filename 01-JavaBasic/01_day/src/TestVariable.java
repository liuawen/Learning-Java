/**
 * @author Liu Awen
 * @create 2020-05-06 21:26
 */
/*
环境变量：path
环境变量是给操作系统找xx命令的路径。
path  value

变量：
1、作用：用来存储值（数据）
在Java中，变量本质上，就是代表一块内存区域。
变量中的数据是存储在JVM内存中。
内存区域 什么的内存呢  OS内存  JVM占OS内存一部分的  小块
2、变量有三个要素：
数据类型 变量名  值  String name = "菜鸡文";
（1）数据类型
是用来存储：字符串、小数、整数、单个字符、布尔值、对象....
String  double float byte short int long char boolean
（2）变量名
在程序中，通过变量名来进行访问这块内存及其里面的数据
变量名   访问  内存里面的数据
（3）值
变量中存的具体的值
变量中的值是可以变的
你的值放到你那里  但可以被覆盖了  重新指向什么 还是删除了再指向  垃圾回收 重新指向了
*/
class TestVariable{
    public static void main(String[] args){
        //想要用一个变量，来存储年龄
        //int就是数据类型
        //age就是变量名
        //18就是变量的值
        int age = 18;
        System.out.println(age);

        age = age + 1;

        System.out.println(age);
    }
}