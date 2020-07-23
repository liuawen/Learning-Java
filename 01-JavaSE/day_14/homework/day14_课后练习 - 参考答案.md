# day14_课后练习

# 枚举编程题

## 第1题

案例：

​	1、声明颜色枚举类：

​		7个常量对象：赤、橙、黄、绿、青、蓝、紫。

​	2、在测试类中，使用枚举类，获取绿色对象，并打印对象。

```java
package com.atguigu.test01;

public class Test01 {
	public static void main(String[] args) {
		Color c = Color.GREEN;
		System.out.println(c);
	}
}
enum Color{
	RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE
}
```



## 第2题

案例：

​	1、声明月份枚举类Month：

​	（1）创建：1-12月常量对象

​	（2）声明两个属性：value（月份值，例如：JANUARY的value为1），

​						description（描述，例如：JANUARY的description为1月份是一年的开始）。

​	（3）声明一个有参构造，创建12个对象

​	（4） 声明一个方法：public static Month getByValue(int value)

​	（5）重写toString()：返回对象信息，例如：1->JANUARY->1月份是一年的开始。

​	2、在测试类中，从键盘输入1个1-12的月份值，获取对应的月份对象，并打印对象

```java
package com.atguigu.test02;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入月份值（1-12）：");
		int m = input.nextInt();
		
		Month month = Month.getByValue(m);
		System.out.println(month);
		
		input.close();
	}
}
enum Month{
	JANUARY(1,"1月份是一年的开始"),
	FEBRUARY(2,"2月份是一年中最短的一个月"),
	MARCH(3,"3月春暖花开"),
	APRIL(4,"4月阳光明媚"),
	MAY(5,"5月清凉初夏"),
	JUNE(6,"6月骄阳似火"),
	JULY(7,"7月下半年的第一个月"),
	AUGUST(8,"8月人已晒干"),
	SEPTEMBER(9,"秋风送爽"),
	OCTOBER(10,"10月全国同欢"),
	NOVEMBER(11,"11月寻找秋裤"),
	DECMEBER(12,"12月冰天雪地");
	
	private int value;
	private String description;
	
	private Month(int value,String description){
		this.value = value;
		this.description = description;
	}
	
	public static Month getByValue(int value){
		return Month.values()[value-1];
	}
	
	public String toString(){
		return value + "->" + name() + "->" + description;
	}
}
```



## 第3题

案例：

​	1、声明可支付接口Payable：

​		包含抽象方法：void pay();

​	2、声明支付枚举类Payment：

​	（1）创建常量对象：支付宝（ALIPAY），微信（WECHAT），信用卡（CREDIT_CARD），储蓄卡（DEPOSIT_CARD）

​	（2）枚举类Payment实现接口Payable

​	①支付宝/微信：对接口的实现是打印“扫码支付”

​	②信用卡/储蓄卡：对接口的实现是打印“输入卡号支付”

​	3、在测试类中，获取所有支付对象，并调用它们的pay()



# 注解编程题

## 第4题

案例：

​	1、编写图形工具类：ShapTools

​	（1）声明方法1：public static void printRectangle()，打印5行5列*组成的矩形图形

​	（2）声明方法2：public static void printRectangle(int line, int column, String sign)，打印line行column列由sign组成的矩形图形

​	（3）给这个类加上文档注释：包含@author，@param等

​	（4）给方法1标记已过时注解

​	2、编写测试类Test04

​	在测试类中调用上面的两个方法测试，并在main方法上抑制警告



## 第5题

案例：

​	1、声明自定义注解@Table

​	（1）加上String类型的配置参数value

​	（2）并限定@Table的使用位置为类上

​	（3）并指定生命周期为“运行时”

​	2、声明自定义注解@Column

​	（1）加上String类型的配置参数name，表示表格的列名

​	（2）加上String类型的配置参数type，表示表格的列数据类型

​	（3）并限定@Column的使用位置在属性上

​	（4）并指定生命周期为“运行时”

​	3、声明User类，

​	（1）属性：id, username, password, email

​	（2）在User类上，标记@Table注解，并为value赋值为"t_user"

​	（3）在User类的每一个属性上标记@Column，并为name和type赋值，例如：

​		id：name赋值为no，type赋值为int

​		username：name赋值为username，type赋值为varchar(20)

​		password：name赋值为pwd，type赋值为char(6)

​		email：name赋值为email，type赋值为varchar(50)

# 内部类编程题

## 第6题

案例：

​	1、声明一个接口：Selector，包含抽象方法：

​	（1）boolean hasNext()

​	（2）Object next()

​	2、声明一个接口：Touchable，包含抽象方法：

​	（1）Selector select()

​	3、声明一个MyArrayList类，当做容器类使用，模拟动态数组数据结构的容器

​	（1）包含属性：

​	①Object[] all；用于保存对象，初始化长度为2

​	②int total；记录实际存储的对象个数

​	（2）包含方法：

​	①public void add(Object element)：用于添加一个元素到当前容器中，如果数组all已满，就扩容为原来的2倍

​	②public void remove(int index)：如果index<0或index>=total就打印“没有这个元素”并返回，否则删除index位置的元素

​	③public void set(int index, Object value)：如果index<0或index>=total就打印“没有这个元素”并返回，否则就替换index位置的元素为value

​	④public Object get(int index)：如果index<0或index>=total就打印“没有这个元素”并返回null，否则返回index位置的元素

​	⑤让类MyArrayList实现Touchable接口，并重写Selector select()方法

​	⑥在类MyArrayList中声明private的内部类MySelector，

​	A：在内部类MySelector声明一个属性：int cursor（游标）

​	B：MySelector实现Selector接口，并重写两个抽象方法，其中

* ​		boolean hasNext()实现为：return cursor != total
* ​		Object next()实现为：return all[cursor++]


4、在测试类中，

（1）创建MyArrayList的对象list

（2）调用list的add方法，添加3个对象

（3）调用list的remove方法，删除[1]的对象

（4）调用list的set方法，替换[1]的对象

（5）调用list的get方法，获取[1]的对象

（6）调用list的select方法，获取Selector的对象，并调用hasNext()和next()遍历容器中所有的对象