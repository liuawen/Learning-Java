练习一：异常的体系
问题：
1.	请描述异常的继承体系
2.	请描述你对错误(Error)的理解
3.	请描述你对异常(Expection的理解)
4.	请描述你对运行时异常(RuntimeException)的理解

答：

1.	异常继承体系为：异常的根类是 java.lang.Throwable，其下有两个子类：
java.lang.Error 与 java.util.Exception 。而Exception又分为编译时期异常：checked异常，与运行时期异常：runtime异常。 
2.	Error:表示不可修复的恶性的错误，只能通过修改代码规避错误的产生，通常是系统级别的，所以很严重。
3.	Exception:表示可修复的良性（相对于错误）的异常，异常产生后程序员可以并且应该通过代码的方式纠正，使程序继续运行，是必须要处理的。
4.	运行时期异常:runtime异常。在运行时期,检查异常.在编译时期,运行异常不会编译器检测(不报错)。

练习二：throw与throws的区别
问题：
1. 请描述throw的使用位置,作用是什么?
2. 请描述throws的使用位置,作用是什么?

答：
1.	throw关键字通常用在方法体中，并且抛出一个异常对象。程序在执行到throw语句时立即停止，它后面的语句都不执行。
2.	throws关键字通常被应用在声明方法时，用来指定可能抛出的异常。多个异常可以使用逗号隔开。当在主函数中调用该方法时，如果发生异常，就会将异常对象抛给方法调用处。

练习三：异常的处理方式
问题：
      1. 异常处理方式有几种,分别是什么?
      2. 详细阐述每种方式对异常是如何处理的
答：
1.	异常的处理方式有两种,分别是使用throws和try...catch...finally
2.	throws用在方法的声明上后接异常类名,是把异常抛给调用者进行处理
3.	try...catch...finally是捕获异常,自己处理,处理完毕后面的程序可以继续运行
a)	try代码块中是可能出现异常的代码
b)	catch代码块,是遇到异常,对异常进行处理的代码
c)	finally代码块是无论是否发生异常,都必须执行的代码,用于释放资源.


练习四：常见异常，及产生原因
问题：请列举常见异常，并说明产生原因。

答：
NullPointerException:空指针异常。
	当应用试图在要求使用对象的地方使用了null时，抛出该异常。譬如：调用null对象的实例方法、访问null对象的属性、计算null对象的长度等等。
ArrayIndexOutOfBoundsException:数组索引越界异常。
当对数组的索引值为负数或大于等于数组大小时抛出此异常。
ArithmeticException:算术运算异常。
	程序中出现了除以零这样的运算就会出这样的异常，对这种异常，大家就要好好检查一下自己程序中涉及到数学运算的地方，公式是不是有不妥了。
NumberFormatException:数字格式异常。
	当试图将一个String转换为指定的数字类型，而该字符串确不满足数字类型要求的格式时，抛出该异常。

注意：答案不唯一，合理即可。


练习五：看代码，分析结果
问题：根据给出的相应代码，分析可能产生的结果。

1.举例：
public static void main(String[]args){

 String str=null;
System.out.println(str.length());

}

答：变量str的值为null，调用方法时，报空指针异常NullPointerException



2.举例：
public static void main(String[]args){
int arr[]={1,2};
System.out.println(arr[2]);
}

答：索引值2大于等于数组arr的长度时，报数组索引越界异常ArrayIndexOutOfBoundsException



3.举例：
public static void main(String[]args){

System.out.println(1/0);
}

答：整数0做了分母，报算术运算异常ArithmeticException:/by zero



4.举例：
public static void main(String[]args){

System.out.println(Integer.parseInt("itcast"));

}

答：
把字符串“itcast”转换为Integer类型时，当然会报数字格式化异常啦NumberFormatException


5.举例：
public static void main(String[] args) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
    
    try {
        Date date = format.parse("2018-04-03");
        System.out.println("程序正常");
        
    } catch (ParseException e) {
        System.out.println("程序异常");
    }
}


答：
	打印结果“程序正常”.try代码块中并没有产生异常，catch代码块中的代码不会执行。date为2018年1月3日00点04分00秒。



练习六：自定义异常类
问题：
请使用代码实现
每一个学生(Student)都有学号,姓名和分数,分数永远不能为负数
如果老师给学生赋值一个负数,抛出一个自定异常

答：
/*
 1.定义异常类NoScoreException,继承RuntimeException
a)提供空参和有参构造方法
 */

public class NoScoreException extends RuntimeException {
//  空参构造
public NoScoreException() {
super();
 }
// 有参构造
public NoScoreException(String message) {
super(message);
 }
}

/*
  2.定义学生类(Student)
 a)属性:name,score
 b)提供空参构造
 c)提供有参构造;
  i.使用setXxx方法给名称和score赋值
 d)提供setter和getter方法
  i.在setScore(int score)方法中
   1.首先判断,如果score为负数,就抛出NoScoreException,异常信息为:分数不能为负数:xxx.
   2.然后在给成员score赋值.
 */

public class Student {
private String name;
private int score;
// 空参构造
public Student() {
super();
 }
// c)提供有参构造;
// i.使用setXxx方法给名称和score赋值
public Student(String name,int score){
  setName(name);
  setScore(score);
 }
// d)提供setter和getter方法

public String getName() {
return name;
 }

public void setName(String name) {
this.name = name;
 }

public int getScore() {
return score;
 }
// i.在setScore(int score)方法中
public void setScore(int score) {
// 1.首先判断,如果score为负数,就抛出NoScoreException,异常信息为:分数不能为负数:xxx.
if(score <0){
throw new NoScoreException(":分数不能为负数:"+score);
  }
// 2.然后在给成员score赋值.
this.score = score;
 }
}


/*
3.定义测试类Test9
 a)提供main方法,在main方法中
  i.使用满参构造方法创建Student对象,分数传入一个负数,运行程序
  ii.由于一旦遇到异常,后面的代码的将不在执行,所以需要注释掉上面的代码
  iii.使用空参构造创建Student对象
  iv.调用setScore(int score)方法,传入一个正数,运行程序
  v.调用setScore(int score)方法,传入一个负数,运行程序
 */

public class Test9 {
public static void main(String[] args) {
//  i.使用满参构造方法创建Student对象,分数传入一个负数,运行程序
//  Student s = new Student("景甜", -10);
//  ii.由于一旦遇到异常,后面的代码的将不在执行,所以需要注释掉上面的代码

//  iii.使用空参构造创建Student对象
Student s = new Student();
//  iv.调用setScore(int score)方法,传入一个正数,运行程序
s.setScore(100);
//  v.调用setScore(int score)方法,传入一个负数,运行程序
s.setScore(-5);
 }
}
