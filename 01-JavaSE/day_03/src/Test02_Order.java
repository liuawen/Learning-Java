import java.util.Scanner;

/**
 * @author Liu Awen
 * @create 2018-05-08 11:06
 */
/*
一、顺序结构
整个程序总体来说都是顺序执行的，从main()主方法开始，顺序往下走

比较有代表性：输入和输出

1、输出语句
System.out.println(xx); //输出xx之后换行
System.out.print(xx);//输出xx之后不换行

2、输入语句
步骤：
（1）准备一个数据的扫描仪（对象），指定数据的来源
java.util.Scanner input = new java.util.Scanner(System.in);


回忆：
	数据类型 变量名 = 值;
*/
class Test02_Order{
    public static void main(String[] args){
		/*
		（1）java.util.Scanner：是一个扫描仪的类型，是引用数据类型，首字母是大写
		其中java.util是包
		（2）input是一个变量名，它代表这个扫描仪
		（3）new java.util.Scanner(System.in)是给input赋值的，它是一个新的对象
		（4）(System.in)是指定了数据的来源，System.in默认代表键盘输入
		（5）整个语句中，唯一可以自己修改的就是input这个变量名
			如果你把input修改为其他了，那么下面的代码，凡是input的地方就修改为你自己命名的变量名
		*/
        java.util.Scanner input = new java.util.Scanner(System.in);
//        Scanner s = new Scanner(System.in);
        System.out.print("请输入年龄：");//这个语句在输入之前执行
		/*
		nextInt()是input这个对象的方法，所以Int的I是大写，因为方法名和变量名一样，从第二个单词开始首字母大写
		因为它是方法，所以()不能省略
		*/
        int age = input.nextInt();//从扫描仪中获取一个int的值，赋值给age这个变量
        System.out.println("age = " + age);//输出age变量的值

        System.out.print("请输入姓名：");
        String name = input.next();//因为String输入太常用了，所以方法名简化了，没有用nextString
//        String password = input.nextString();
        //Error:(49, 32) java: 找不到符号
        //  符号:   方法 nextString()
        //  位置: 类型为java.util.Scanner的变量 input
        System.out.print("请输入体重：");
        double weight = input.nextDouble();

        System.out.print("请输入是否漂亮：");
        boolean beautiful = input.nextBoolean();

        System.out.print("请输入性别：");
        char gender = input.next().charAt(0);//因为输入单个char太少用了，Scanner中没有提供输入单个char的方法，那么我们只能变通，先按字符串接收，然后取第一个字符

        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
        System.out.println("体重：" + weight);
        System.out.println("性别：" + gender);
        System.out.println("是否漂亮：" + beautiful);
        //请输入年龄：22
        //age = 22
        //请输入姓名：牛菜文
        //请输入体重：75
        //请输入是否漂亮：true
        //请输入性别：女
        //姓名：牛菜文
        //年龄：22
        //体重：75.0
        //性别：女
        //是否漂亮：true
        //
        //Process finished with exit code 0
    }
}
