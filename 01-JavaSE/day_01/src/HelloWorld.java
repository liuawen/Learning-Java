/**
 * @author Liu Awen
 * @create 2018-05-06 20:48
 */
/*
注释：写一下解释的文字，给程序员看的
三种形式：
（1）单行注释  //注释内容
（2）多行注释  斜杠* 注释内容 *斜杠
（3）文档注释  比较特殊，我们在后面注解部分讲解
//

Java的代码结构：
类{
	方法/函数{
		语句;
	}
}

class：类，声明类，定义类
class代表类、声明类、定义类了吗

 Write Once，Run AnyWhere... 编写一次 到处运行
 编译  编写    dotjava  .java
Java程序的开发步骤：
（1）编写代码
要求：保存为.java的源代码文件
（2）编译代码
目的：把.java源文件编译为.class的字节码文件（因为JVM只认识字节码）
字节码文件 JVM只认识字节码  javac.exe javac HelloWorld.java
编译工具：javac.exe
如何使用编译工具：
	格式：javac 源文件名.java
	例如：javac HelloWorld.java
（3）运行字节码文件
运行工具：java.exe
如何使用运行工具：
	格式：java 字节码文件名或说是类名
	例如：java HelloWorld
javac.exe java.exe
编译 运行    编写重要 思路 步骤 source code 源代码
保存快捷键：Ctrl + S
*/
class HelloWorld{
    /*
        Java程序的主方法，是Java程序运行的入口
    */
    public static void main(String[] args){
		/*
			输出语句：""中的内容，表示需要原样输出的内容
		*/
        System.out.println("Hello Java!");
        System.out.println("Hello Hello!");
        System.out.println("入了编程世界的坑呢  爱了爱了爱了 喜欢上了怎么办呢 我爱这个生态计算");
        char c = '0';
        System.out.println((int)c);//48
        c = '9';
        System.out.println((int)c);//57
    }
}