/**
 * @author Liu Awen
 * @create 2018-05-06 21:24
 */
/*
问题4：源文件名和类名的问题
1、源文件名和类名一致
javac 源文件名.java
java 类名

例如：
javac Problem4.java
java Problem4

2、源文件名和类名不一致
javac 源文件名.java
java 类名

例如：
javac Problem4.java
java Other

在cmd命令行，如何重新运行之前执行过的命令？
按↑，查找之前的命令
按↓，查找某个之后的命令

3、如果某个类是public，那么这个类必须与源文件名一致
换句话说，一个源文件只能有一个public类
一个源文件只能有一个public类
4、一个源文件可以编写多个类吗？如果可以，编译后会怎么样呢？
如果一个源文件有多个类，那么编译后会产生多个.class文件。
字节码文件名就是类名。
执行和源文件名一样的类名

平时开发中，一个.java文件，只写一个类，除非有内部类。
而且源文件名和类名一致。（因为后期好维护）
*/
public class Problem4{
    public static void main(String[] args){
        System.out.println("源文件名和类名一致");
    }
}
//直接运行执行 Other类 错误: 找不到或无法加载主类 Other
class Other{
    public static void main(String[] args){
        System.out.println("源文件中有另一个类");
    }
}

class Three{

}