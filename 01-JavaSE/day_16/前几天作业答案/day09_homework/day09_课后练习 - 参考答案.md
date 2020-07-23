# day09_课后练习

## 第一题：概念辨析

1. 一个类与它的对象之间是什么关系？
2. 如何定义一个类，由哪些部分组成，各个部分的作用是什么？
3. 如何创建一个对象，如何使用该对象？
4. 局部变量和成员变量的区别？
5. 构造方法和成员方法的区别？

## 第二题：语法练习

* 语法与技能：
  * 包、类（属性、构造器、方法）、对象、this
  * eclipse使用
* 在com.atguigu.test02.bean包中定义一个圆形Circle类。
  * 属性：私有化
    * r：半径
  * 构造方法：
    * 无参构造方法
    * 满参构造方法
  * 成员方法：
    * get/set方法
    * showArea方法：打印圆形面积
    * showPerimeter方法：打印圆形周长
* 在com.atguigu.test02.test包中定义测试类TestCircle：创建Circle对象，并测试。

* 开发提示： 

  > 面向周长公式：2 * 3.14*  半径
  >
  > 圆形面积公式：3.14* 半径^2

```java
package com.atguigu.test02.bean;

public class Circle {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle() {
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void showArea(){
		System.out.println("半径为：" + radius + "，面积：" + 3.14 * radius * radius);
	}
	
	public void showPerimeter(){
		System.out.println("半径为：" + radius + "，周长：" + 2 * 3.14 * radius);
	}
}

```

```java
package com.atguigu.test02.test;

import com.atguigu.test02.bean.Circle;

public class Test02 {
	public static void main(String[] args) {
		Circle c1 = new Circle(1.2);
		c1.showArea();
		c1.showPerimeter();
	}
}

```



## 第三题：语法练习

* 语法与技能：
  * 包、类（属性、构造器、方法）、对象、this
  * eclipse使用
* 在com.atguigu.test03.bean包中定义一个日期MyDate类。
  * 属性：
    * year：年
    * month：月
    * day：日
  * 构造方法：
    * 满参构造方法
  * 成员方法：
    * get/set方法
    * void showDate方法：打印日期。
    * boolean isLeapYear()方法：判断当前日期是否是闰年
* 在com.atguigu.test03.test包中定义测试类：创建MyDate对象，并测试。

* 代码实现，效果如图所示：

  ![1558694854071](imgs/1558694854071.png)

* 开发提示： 

  * 闰年：
    * 普通年（不能被100整除的年份）能被4整除的为闰年。（如2004年就是闰年,1999年不是闰年）；
    * 世纪年（能被100整除的年份）能被400整除的是闰年。(如2000年是闰年，1900年不是闰年)；

```java
package com.atguigu.test03.bean;

public class MyDate {
	private int year;
	private int month;
	private int day;

	public MyDate() {
	}

	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void showDate() {
		System.out.println("日期" + year + "年" + month + "月" + day + "日");
	}

	public boolean isLeapYear() {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}

```

```java
package com.atguigu.test03.test;

import com.atguigu.test03.bean.MyDate;

public class Test03 {
	public static void main(String[] args) {
		MyDate my = new MyDate(2019,5,13);
		my.showDate();
		boolean flag = my.isLeapYear();
		System.out.println(my.getYear()+ (flag?"是闰年":"不是闰年"));
	}
}

```



## 第四题：语法练习

* 语法与技能：
  * 包、类（属性、构造器、方法）、对象、this
  * eclipse使用
* 在com.atguigu.test04.bean包中定义一个扑克Card类。
  * 属性：
    * 花色
    * 点数
  * 构造方法：
    * 满参构造方法
  * 成员方法：
    * showCard方法：打印牌面信息
* 在com.atguigu.test04.test包中定义测试类，创建Card对象，调用showCard方法。

* 代码实现，效果如图所示：

  ![1558694880093](imgs/1558694880093.png)

```java
package com.atguigu.test04.bean;

public class Card {
	private String hua;
	private String dian;

	public Card(String hua, String dian) {
		this.hua = hua;
		this.dian = dian;
	}

	public Card() {
	}

	public String getHua() {
		return hua;
	}

	public void setHua(String hua) {
		this.hua = hua;
	}

	public String getDian() {
		return dian;
	}

	public void setDian(String dian) {
		this.dian = dian;
	}

	public void showCard() {
		System.out.println(hua + dian);
	}
}

```

```java
package com.atguigu.test04.test;

import com.atguigu.test03.bean.Card;

public class Test03 {
	public static void main(String[] args) {
		Card c = new Card("黑桃", "A");
		c.showCard();
	}
}

```



## 第五题：语法练习

* 语法与技能：
  * 包、类（属性、构造器、方法）、对象、this
  * eclipse使用

* 在com.atguigu.test05.bean包中创建一个Book类，属性私有化，提供有参和无参构造，get/set

  ![1558693775564](imgs/1558693775564.png)

* 在com.atguigu.test05.test包中，创建TestBook类，并创建Book数组，创建多个Book对象，存储到数组中，并遍历显示他们的信息，并按照销量从高到低排序


```java
package com.atguigu.test05.bean;

public class Book {
	private Integer id;
	private String title;
	private String author;
	private double price;
	private Integer sales;
	private Integer stock;
	private String imgPath = "static/img/default.jpg";
	public Book() {
	}
	public Book(Integer id, String title, String author, double price, Integer sales, Integer stock) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
	}
	public Book(Integer id, String title, String author, double price, Integer sales, Integer stock, String imgPath) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
		this.imgPath = imgPath;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getInfo(){
		return id + "\t" + title + "\t" + author + "\t" + price + "\t" + sales + "\t" + stock + "\t" + imgPath;
	}
}

```

```java
package com.atguigu.test05.test;

import com.atguigu.test05.bean.Book;

public class Test05 {
	public static void main(String[] args) {
		Book[] all = new Book[5];
		
		all[0] = new Book(1, "《从入门到精通》", "张三", 88, 100, 1000,"static/img/1.jpg");
		all[1] = new Book(2, "《从入门到放弃》", "李四", 89, 200, 800);
		all[2] = new Book(3, "《从入门到脱发》", "王五", 56, 10, 500);
		all[3] = new Book(4, "《从入门到吃药》", "赵六", 100, 180, 900);
		all[4] = new Book(5, "《从入门到升仙》", "钱七", 99, 0, 1000);

		System.out.println("排序前：");
		System.out.println("编号\t书名\t\t作者\t价格\t销量\t库存\t图片");
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i].getInfo());
		}
		
		//排序
		for (int i = 1; i < all.length; i++) {
			for (int j = 0; j < all.length-i; j++) {
				if(all[j].getSales() < all[j+1].getSales()){
					Book temp = all[j];
					all[j] = all[j+1];
					all[j+1] = temp;
				}
			}
		}
		System.out.println("排序后：");
		System.out.println("编号\t书名\t\t作者\t价格\t销量\t库存\t图片");
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i].getInfo());
		}
	}
}

```



## 第六题：语法练习

案例：

​	1、在com.atguigu.test06.bean包中声明员工类、程序员类、设计师类、架构师类

![1558775319342](imgs/1558775319342.png)

* 员工类属性：编号、姓名、年龄、手机号码

* 程序员类属性：编程语言

* 设计师类属性：奖金

* 架构师类属性：持有股票数量




​	要求：属性私有化，无参有参构造，get/set，getInfo方法（考虑重写）

2、在com.atguigu.test06.test包中声明测试类Test06

创建各种类的对象，并测试

```java
package com.atguigu.test06.bean;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String tel;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, int age, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getInfo(){
		return "编号：" + name + "，姓名：" + name + "，年龄：" + age + "，电话：" + tel;
	}
}

```

```java
package com.atguigu.test06.bean;

public class Programmer extends Employee{
	private String language;

	public Programmer() {
		super();
	}

	public Programmer(int id, String name, int age, String tel, String language) {
		super(id, name, age, tel);
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String getInfo() {
		return super.getInfo() + "，编程语言：" + language;
	}
	
}

```

```java
package com.atguigu.test06.bean;

public class Designer extends Programmer {
	private double bonus;

	public Designer() {
		super();
	}

	public Designer(int id, String name, int age, String tel, String language, double bonus) {
		super(id, name, age, tel, language);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String getInfo() {
		return super.getInfo() + "，奖金：" + bonus;
	}
	
}

```

```java
package com.atguigu.test06.bean;

public class Architect extends Designer {
	private int stock;

	public Architect() {
		super();
	}

	public Architect(int id, String name, int age, String tel, String language, double bonus, int stock) {
		super(id, name, age, tel, language, bonus);
		this.stock = stock;
	}


	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String getInfo() {
		return super.getInfo() + "，持有股票数：" + stock;
	}
	
}

```

```java
package com.atguigu.test06.test;

import com.atguigu.test06.bean.Architect;
import com.atguigu.test06.bean.Designer;
import com.atguigu.test06.bean.Employee;
import com.atguigu.test06.bean.Programmer;

public class Test06 {
	public static void main(String[] args) {
		Employee emp = new Employee(1, "张三", 23, "10086");
		Programmer pro = new Programmer(2, "李四", 24, "10010", "java");
		Designer de = new Designer(3, "王五", 25, "114", "python", 2000);
		Architect a = new Architect(4, "赵六", 26, "110", "java", 3000, 100);
		
		System.out.println(emp.getInfo());
		System.out.println(pro.getInfo());
		System.out.println(de.getInfo());
		System.out.println(a.getInfo());
	}
}

```

