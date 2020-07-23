# day10_课后练习

# 代码阅读题

## 第1题

案例：判断运行结果

```java
package com.atguigu.test01;

class HelloA{
	public HelloA(){
		System.out.println("HelloA");
	}
	{
		System.out.println("I'm A Class");
	}
}

class HelloB extends HelloA{
	public HelloB(){
		System.out.println("HelloB");
	}
	{
		System.out.println("I'm B Class");
	}
}
public class Test01{
	public static void main(String[] args) {
		new HelloB();
	}
}

```

```java
/*
 * 创建对象是通过执行实例初始化方法来完成的。
 * 如果new后面跟无参构造，就说明调用无参的实例初始化方法<init>()，
 * 如果new后面跟有参构造，就说明调用有参的实例初始化方法<init>(形参列表)。
 * 编译器编译后类中没有构造器，而是编译为一个个的实例初始化方法。
 * 实例初始化由：
 * （1）非静态成员变量的显式赋值代码
 * （2）非静态代码块代码
 * （3）构造器代码
 * 其中（1）（2）按编写顺序，（3）在最后
 * 在子类实例初始化首行会有super()或super(实参列表)表示调用父类的实例初始化方法，
 * 如果没写super()或super(实参列表)，那么默认就是super()，因此：
 * （1）先执行父类实例初始化
 * <init>(){
 * 		System.out.println("I'm A Class");
 * 		System.out.println("HelloA");
 * }
 * （2）再执行子类实例初始化
 * <init>(){
 * 		System.out.println("I'm B Class");
 * 		System.out.println("HelloB");
 * }
 */
```



## 第2题

案例：判断运行结果

```java
package com.atguigu.test02;

public class Test02 {
	public static void main(String[] args) {
		new Child("mike");
	}
}

class People {
	private String name;

	public People() {
		System.out.print("1");
	}

	public People(String name) {
		System.out.print("2");
		this.name = name;
	}
}

class Child extends People {
	People father;

	public Child(String name) {
		System.out.print("3");
		father = new People(name + " F");
	}

	public Child() {
		System.out.print("4");
	}
}

```

```java
/*
 * 创建对象是通过执行实例初始化方法来完成的。
 * 如果new后面跟无参构造，就说明调用无参的实例初始化方法<init>()，
 * 如果new后面跟有参构造，就说明调用有参的实例初始化方法<init>(形参列表)。
 * 编译器编译后类中没有构造器，而是编译为一个个的实例初始化方法。
 * 实例初始化由：
 * （1）非静态成员变量的显式赋值代码
 * （2）非静态代码块代码
 * （3）构造器代码
 * 在子类实例初始化首行会有super()或super(实参列表)表示调用父类的实例初始化方法，
 * 如果没写super()或super(实参列表)，那么默认就是super()，因此：
 * (1)先执行父类的实例初始化
 * <init>(){
 * 		System.out.print("1");
 * }
 * (2)再执行子类的实例初始化	
 * <init>(String name){
 * 		System.out.print("3");
 * 		father = new People(name + " F");//创建了一个父类的对象
 * 			即调用父类的<init>(String name){
 * 					System.out.print("2");
 * 			}
 * }
 */
```



## 第3题

案例：分析运行结果

```java
package com.atguigu.test03;

public class Test03 {
	public static void main(String[] args) {
		Father f = new Father();
		Child c = new Child();
	}
}
class Father {
	public Father(){
		System.out.println("father create");
	}
}
class Child extends Father{
	public Child(){
		System.out.println("child create");
	}
}
```

```java
/*
 * 1、Father f = new Father();
 * 执行父类的实例初始化方法
 * <init>(){
 * 		System.out.println("father create");
 * }
 * 
 * 2、Child c = new Child();
 * （1）先执行父类的实例初始化方法
 * <init>(){
 * 		System.out.println("father create");
 * }
 * （2）再执行子类的实例初始化方法
 * <init>(){
 * 		System.out.println("child create");
 * }
 */
```



## 第4题

```java
package com.atguigu.test04;

public class Test04 extends Father{
	private String name = "test";
	
	public static void main(String[] args) {
		Test04 test = new Test04();
		System.out.println(test.getName());
	}
}
class Father {
	private String name = "father";

	public String getName() {
		return name;
	}
}
```

```java
/*
 * 当父类与子类有同名的属性时：
 * 通过子类对象调用getName()访问的是父类的name还是子类的name，
 * 那么要看子类是否重写，如果没有重写，就是父类的，重写了就是子类的。
 */
```



## 第5题

案例：分析运行结果

```
package com.atguigu.test05;

public class Test05 {
	public static void main(String[] args) {
		Other o = new Other();
		new Test05().addOne(o);
		System.out.println(o.i);
	}
	
	public void addOne(Other o){
		o.i++;
	}
}
class Other{
	public int i;
}
```

```java
/*
 * 方法的参数传递机制：
 * 形参是基本数据类型，那么实参给形参的是数据值的副本，形参的修改不影响实参；
 * 形参是引用数据类型，那么实参给形参的是地址值的副本，形参对象修改属性相当于实参对象修改属性
 */
```



## 第6题

案例：分析运行结果

```java
package com.atguigu.test06;

public class Test06 {
	public static void main(String[] args) {
		int i = 0;
		change(i);
		i = i++;
		System.out.println("i = " + i);
	}
	public static void change(int i){
		i++;
	}
}

```

```java
/*
 * 1、方法的参数传递机制：
 * 形参是基本数据类型，那么实参给形参的是数据值的副本，形参的修改不影响实参；
 * 形参是引用数据类型，那么实参给形参的是地址值的副本，形参对象修改属性相当于实参对象修改属性
 * 
 * 2、自增运算符
 * ++在后，先加载值后自增；
 * ++在前，先自增后加载值
 * 
 * i = i++;
 * ①先加载i的值"0"，②i自增,i=1，③最后算赋值，把刚才的“0”赋值给i
 */
```



## 第7题

案例：分析运行结果

```java
package com.atguigu.test07;

public class Test07 {

	public static void main(String[] args) {
		new A(new B());
	}
}

class A {
	public A() {
		System.out.println("A");
	}

	public A(B b) {
		this();
		System.out.println("AB");
	}
}

class B {
	public B() {
		System.out.println("B");
	}
}

```

```java
/*
 * 1、先算new B()
 * 执行B类的实例初始化方法：
 * <init>(){
 * 		System.out.println("B");
 * }
 * 2、再算new A(B对象)
 * 执行A类的实例初始化方法：
 * <init>(B b){
 * 		this();
 * 			即调用本类的无参构造，或者说无参实参初始化方法
 * 			<init>(){
 * 				System.out.println("A");
 * 			}
 *		System.out.println("AB");
 * }
 */
```



## 第8题

案例：分析运行结果

```java
package com.atguigu.test08;

public class Test08 {
	public static void main(String[] args) {
		Sub s = new Sub();
	}
}
class Base{
	Base(){
		method(100);
	}
	{
		System.out.println("base");
	}
	public void method(int i){
		System.out.println("base : " + i);
	}
}
class Sub extends Base{
	Sub(){
		super.method(70);
	}
	{
		System.out.println("sub");
	}
	public void method(int j){
		System.out.println("sub : " + j);
	}
}
```

```java
/*
 * 创建对象是通过执行实例初始化方法来完成的。
 * 如果new后面跟无参构造，就说明调用无参的实例初始化方法<init>()，
 * 如果new后面跟有参构造，就说明调用有参的实例初始化方法<init>(形参列表)。
 * 编译器编译后类中没有构造器，而是编译为一个个的实例初始化方法。
 * 实例初始化由：
 * （1）非静态成员变量的显式赋值代码
 * （2）非静态代码块代码
 * （3）构造器代码
 * 其中（1）（2）按编写顺序，（3）在最后
 * 在子类实例初始化首行会有super()或super(实参列表)表示调用父类的实例初始化方法，
 * 如果没写super()或super(实参列表)，那么默认就是super()，因此：
 * 1、执行父类的实例初始化方法
 * <ini>(){
 * 		System.out.println("base");
 * 		method(100); //因为此时在创建子类的对象过程中，所以这个method(100)方法是
 * 						子类对象再调用，那么又因为子类重写了method(int)方法，
 * 						所以执行子类的method(int)
 * 					即System.out.println("sub : " + j);
 * }
 * 
 * 2、执行子类的实例初始化方法
 * <init>(){
 * 		System.out.println("sub");
 * 		super.method(70);//因为这里用super.，那么一定是调用父类的method(int)
 * 					即System.out.println("base : " + i);
 * }
 */
```



# 代码编程题

## 第9题

案例：

​	1、在com.atguigu.test09.bean包中声明员工类、程序员类、设计师类、架构师类，

![1558933215448](imgs/1558933215448.png)

* 员工类属性：编号、姓名、年龄、薪资

* 程序员类属性：编程语言，默认都是"java"

* 设计师类属性：奖金

* 架构师类属性：持有股票数量

  要求：属性私有化，无参有参构造，get/set，getInfo方法（考虑重写）

  

  2、在com.atguigu.test10.bean包中声明Test09测试类

  （1）在main中有一些变量和一个二维数组

  ```
  int EMPLOYEE = 10;//表示普通员工
  int PROGRAMMER = 11;//表示程序员
  int DESIGNER = 12;//表示设计师
  int ARCHITECT = 13;//表示架构师
      
  String[][] EMPLOYEES = {
          {"10", "1", "段誉", "22", "3000"},
          {"13", "2", "令狐冲", "32", "18000", "15000", "2000"},
          {"11", "3", "任我行", "23", "7000"},
          {"11", "4", "张三丰", "24", "7300"},
          {"12", "5", "周芷若", "28", "10000", "5000"},
          {"11", "6", "赵敏", "22", "6800"},
          {"12", "7", "张无忌", "29", "10800","5200"},
          {"13", "8", "韦小宝", "30", "19800", "15000", "2500"},
          {"12", "9", "杨过", "26", "9800", "5500"},
          {"11", "10", "小龙女", "21", "6600"},
          {"11", "11", "郭靖", "25", "7100"},
          {"12", "12", "黄蓉", "27", "9600", "4800"}
      };
  ```

  （2）创建一个员工数组

  （3）根据以上数据，初始化员工数组

  提示：把字符串转为int和double类型的值，可以使用如下方式：

  ```java
  String idStr = "1";
  int id = Integer.parseInt(idStr);
  
  String salaryStr = "7300";
  double salary = Double.parseDouble(salaryStr);
  ```

  （4）遍历数组，使用如下格式

  ```
  编号	姓名	年龄	薪资	语言	奖金	股票
  .....
  ```

  ```java
  package com.atguigu.test09.bean;
  
  public class Employee {
  	private int id;
  	private String name;
  	private int age;
  	private double salary;
  	
  	public Employee() {
  		super();
  	}
  
  	public Employee(int id, String name, int age, double salary) {
  		super();
  		this.id = id;
  		this.name = name;
  		this.age = age;
  		this.salary = salary;
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
  
  	public double getSalary() {
  		return salary;
  	}
  
  	public void setSalary(double salary) {
  		this.salary = salary;
  	}
  	
  	public String getInfo(){
  		return id + "\t" + name + "\t" + age + "\t" + salary;
  	}
  }
  ```

  ```java
  package com.atguigu.test09.bean;
  
  public class Programmer extends Employee{
  	private String language = "java";
  
  	public Programmer() {
  		super();
  	}
  
  	public Programmer(int id, String name, int age, double salary) {
  		super(id, name, age, salary);
  	}
  
  	public Programmer(int id, String name, int age, double salary, String language) {
  		super(id, name, age, salary);
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
  		return super.getInfo() + "\t" + language;
  	}
  	
  }
  
  ```

  ```java
  package com.atguigu.test09.bean;
  
  public class Designer extends Programmer {
  	private double bonus;
  
  	public Designer() {
  		super();
  	}
  
  	public Designer(int id, String name, int age, double salary, double bonus) {
  		super(id, name, age, salary);
  		this.bonus = bonus;
  	}
  
  	public Designer(int id, String name, int age, double salary, String language, double bonus) {
  		super(id, name, age, salary, language);
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
  		return super.getInfo()+ "\t" + bonus;
  	}
  	
  }
  ```

  ```java
  package com.atguigu.test09.bean;
  
  public class Architect extends Designer {
  	private int stock;
  
  	public Architect() {
  		super();
  	}
  
  	public Architect(int id, String name, int age, double salary, double bonus, int stock) {
  		super(id, name, age, salary, bonus);
  		this.stock = stock;
  	}
  
  	public Architect(int id, String name, int age, double salary, String language, double bonus, int stock) {
  		super(id, name, age, salary, language, bonus);
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
  		return super.getInfo() + "\t" + stock;
  	}
  	
  }
  ```

  ```java
  package com.atguigu.test09.test;
  
  import com.atguigu.test09.bean.Architect;
  import com.atguigu.test09.bean.Designer;
  import com.atguigu.test09.bean.Employee;
  import com.atguigu.test09.bean.Programmer;
  
  public class Test09 {
  
  	public static void main(String[] args) {
  		int EMPLOYEE = 10;//表示普通员工
  		int PROGRAMMER = 11;//表示程序员
  		int DESIGNER = 12;//表示设计师
  		int ARCHITECT = 13;//表示架构师
  		    
  		String[][] EMPLOYEES = {
  		        {"10", "1", "段誉", "22", "3000"},
  		        {"13", "2", "令狐冲", "32", "18000", "15000", "2000"},
  		        {"11", "3", "任我行", "23", "7000"},
  		        {"11", "4", "张三丰", "24", "7300"},
  		        {"12", "5", "周芷若", "28", "10000", "5000"},
  		        {"11", "6", "赵敏", "22", "6800"},
  		        {"12", "7", "张无忌", "29", "10800","5200"},
  		        {"13", "8", "韦小宝", "30", "19800", "15000", "2500"},
  		        {"12", "9", "杨过", "26", "9800", "5500"},
  		        {"11", "10", "小龙女", "21", "6600"},
  		        {"11", "11", "郭靖", "25", "7100"},
  		        {"12", "12", "黄蓉", "27", "9600", "4800"}
  		    };
  		
  		Employee[] all = new Employee[EMPLOYEES.length];
  		for (int i = 0; i < all.length; i++) {
  			int type = Integer.parseInt(EMPLOYEES[i][0]);
  			int id = Integer.parseInt(EMPLOYEES[i][1]);
  			String name = EMPLOYEES[i][2];
  			int age = Integer.parseInt(EMPLOYEES[i][3]);
  			double salary = Double.parseDouble(EMPLOYEES[i][4]);
  			
  			if(type == EMPLOYEE){
  				all[i] = new Employee(id, name, age, salary);
  			}else if(type == PROGRAMMER){
  				all[i] = new Programmer(id, name, age, salary);
  			}else if(type == DESIGNER){
  				double bonus = Integer.parseInt(EMPLOYEES[i][5]);
  				all[i] = new Designer(id, name, age, salary, bonus);
  			}else if(type == ARCHITECT){
  				double bonus = Double.parseDouble(EMPLOYEES[i][5]);
  				int stock = Integer.parseInt(EMPLOYEES[i][6]);
  				all[i] = new Architect(id, name, age, salary, bonus, stock);
  			}
  		}
  		
  		System.out.println("编号\t姓名\t年龄\t薪资\t语言\t奖金\t股票");
  		for (int i = 0; i < all.length; i++) {
  			System.out.println(all[i].getInfo());
  		}
  	}
  
  }
  ```

  

## 第10题

案例：

​	1、在com.atguigu.test10.bean包中声明图形Graphic、圆Circle、矩形Rectangle类、三角形Triangle类

​	2、图形Graphic类中有：

​		①public double getArea()方法：返回面积

​		②public double getPerimeter()方法：返回周长

​		③public String getInfo()方法：返回图形信息

​	3、圆类和矩形类重写这两个方法

​	4、在com.atguigu.test10.test包中声明测试类Test10_1

​	(1)请设计一个方法，可以用于比较两个图形的面积是否相等

​	(2)请设计一个方法，可以用于找出两个图形中面积大的那个

​	(3)public static void main(String[] args){}

​	在主方法中，创建1个圆、1个矩形、1个三角形对象，并分别调用(1)、(2)方法进行测试。

​	5、在com.atguigu.test10.test包中测试类Test10_2

​	(1)请设计一个方法，可以用于遍历一个图形数组

​	(2)请设计一个方法，可以用于给一个图形数组进行按照面积从小到大排序

​	(3)public static void main(String[] args){}

​	在主方法中，创建1个圆、1个矩形、1个三角形对象，放到数组中，遍历显示，然后排序后再遍历显示。

```java
package com.atguigu.test10.bean;

public class Graphic {
	public double getArea(){
		return 0.0;
	}
	public double getPerimeter(){
		return 0.0;
	}
	public String getInfo(){
		return "面积：" + getArea() + "，周长：" + getPerimeter();
	}
}

```

```java
package com.atguigu.test10.bean;

public class Circle extends Graphic{
	private double radius;

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return 3.14 * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * 3.14 * radius;
	}

	@Override
	public String getInfo() {
		return "半径：" + radius + "," + super.getInfo();
	}
	
}

```

```java
package com.atguigu.test10.bean;

public class Rectangle extends Graphic{
	private double length;
	private double width;
	public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}
	public Rectangle() {
		super();
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	@Override
	public double getArea() {
		return length * width;
	}
	@Override
	public double getPerimeter() {
		return 2 * (length + width);
	}
	@Override
	public String getInfo() {
		return "长：" + length + "，宽：" + width + "," + super.getInfo();
	}
	
}

```

```java
package com.atguigu.test10.bean;

public class Triangle extends Graphic{
	private double a;
	private double b;
	private double c;
	public Triangle() {
		super();
	}
	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	@Override
	public double getArea() {
		double p = (a + b + c)/2;
		return Math.sqrt(p * (p-a) * (p-b) * (p-c));
	}
	@Override
	public double getPerimeter() {
		return a+b+c;
	}
	@Override
	public String getInfo() {
		return "边长为：" + a + "," + b +"," + c+"," + super.getInfo();
	}
	
}

```

```java
package com.atguigu.test10.test;

import com.atguigu.test10.bean.Circle;
import com.atguigu.test10.bean.Graphic;
import com.atguigu.test10.bean.Rectangle;
import com.atguigu.test10.bean.Triangle;

public class Test10_01 {
	public static void main(String[] args) {
		Circle c1 = new Circle(2);
		Rectangle r1 = new Rectangle(2, 3);
		Triangle t1 = new Triangle(3, 4, 5);
		System.out.println("c1的面积：" + c1.getArea());
		System.out.println("r1的面积：" + r1.getArea());
		System.out.println("t1的面积：" + t1.getArea());
		
		System.out.println("c1和r1的面积是否相等：" + equal(c1, r1));
		System.out.println("c1和t1的面积是否相等：" + equal(c1, t1));
		System.out.println("r1和t1的面积是否相等：" + equal(r1, t1));
		
		Graphic max1 = getMax(c1, r1);
		System.out.println("c1和r1中面积大的是：" + max1.getArea());
		Graphic max2 = getMax(c1, t1);
		System.out.println("c1和t1中面积大的是：" + max2.getArea());
		Graphic max3 = getMax(r1, t1);
		System.out.println("r1和t1中面积大的是：" + max3.getArea());
	}
	
	public static boolean equal(Graphic g1, Graphic g2){
		return g1.getArea() == g2.getArea();
	}
	
	public static Graphic getMax(Graphic g1, Graphic g2){
		return g1.getArea() > g2.getArea() ? g1 : g2;
	}
}

```

```java
package com.atguigu.test10.test;

import com.atguigu.test10.bean.Circle;
import com.atguigu.test10.bean.Graphic;
import com.atguigu.test10.bean.Rectangle;
import com.atguigu.test10.bean.Triangle;

public class Test10_02 {
	public static void main(String[] args) {
		Graphic[] all = new Graphic[3];
		all[0] = new Circle(2);
		all[1] = new Rectangle(2, 3);
		all[2] = new Triangle(3, 4, 5);
		
		System.out.println("排序前：");
		print(all);
		
		sort(all);
		
		System.out.println("排序后：");
		print(all);
		
	}
	public static void print(Graphic[] all){
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i].getInfo());
		}
	}
	
	public static void sort(Graphic[] all){
		for (int i = 1; i < all.length; i++) {
			for (int j = 0; j < all.length-i; j++) {
				if(all[j].getArea() > all[j+1].getArea()){
					Graphic temp = all[j];
					all[j] = all[j+1];
					all[j+1] = temp;
				}
			}
		}
	}
}

```



## 第11题

案例：

​	1、在com.atguigu.test11.bean包中声明人Person、男人Man、女人Woman类

​	（1）在Person类中，包含

​		①public void eat()：打印吃饭

​		②public void toilet()：打印上洗手间

​	（2）在Man类中，包含

​		①重写上面的方法

​		②增加  public void smoke()：打印抽烟

​	（3）在Woman类中，包含

​		①重写上面的方法

​		②增加 public void makeup()：打印化妆

​	2、在com.atguigu.test11.test包中声明测试类Test11

​	（1）public static void meeting(Person...  ps)

​		在该方法中，每一个人先吃饭，然后上洗手间，然后如果是男人，随后抽根烟，如果是女人，随后化个妆

​	（2）public static void main(String[] args)

​		在主方法中，创建多个男人和女人对象，并调用meeting()方法进行测试

```java
package com.atguigu.test11.bean;

public class Person {
	public void eat(){
		System.out.println("吃饭");
	}
	public void toilet(){
		System.out.println("上洗手间");
	}
}

```

```java
package com.atguigu.test11.bean;

public class Man extends Person{

	@Override
	public void eat() {
		System.out.println("细嚼慢咽吃饭");
	}

	@Override
	public void toilet() {
		System.out.println("坐着上洗手间");
	}
	public void smoke(){
		System.out.println("抽烟爽爽");
	}
}

```

```java
package com.atguigu.test11.bean;

public class Woman extends Person{

	@Override
	public void eat() {
		System.out.println("狼吞虎咽吃饭");
	}

	@Override
	public void toilet() {
		System.out.println("站着上洗手间");
	}
	
	public void makeup(){
		System.out.println("化妆美美");
	}

}

```

```java
package com.atguigu.test11.test;

import com.atguigu.test11.bean.Man;
import com.atguigu.test11.bean.Person;
import com.atguigu.test11.bean.Woman;

public class Test11 {
	public static void main(String[] args) {
		meeting(new Woman(),new Man(), new Woman(), new Man());
	}
	
	public static void meeting(Person... ps){
		for (int i = 0; i < ps.length; i++) {
			ps[i].eat();
			ps[i].toilet();
			if(ps[i] instanceof Woman){
				((Woman)ps[i]).makeup();
			}else if(ps[i] instanceof Man){
				((Man)ps[i]).smoke();
			}
		}
	}
}

```

