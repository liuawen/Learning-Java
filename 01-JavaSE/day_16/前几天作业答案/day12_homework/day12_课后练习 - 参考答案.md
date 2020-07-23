# day12_课后练习

# 阅读代码题

## 第1题

考核知识点：多态、重载、重写

```java
public class Test01 {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();
		System.out.println("(1)" + a1.show(b));
		System.out.println("(2)" + a2.show(d));
		System.out.println("(3)" + b.show(c));
		System.out.println("(4)" + b.show(d));
	}
}
class A{
	public String show(D obj){
		return ("A and D");
	}
	public String show(A obj){
		return "A and A";
	}
}
class B extends A{
	public String show(B obj){
		return "B and B";
	}
	public String show(A obj){
		return "B and A";
	}
}
class C extends B{
	
}
class D extends B{
	
}
```

```java
/*
 * 1、分析每个类的方法列表和继承关系
 * A类：
 * 	public String show(D obj) 
 * 	public String show(A obj)
 * B类：
 * 	public String show(D obj)继承的
 * 	public String show(A obj)重写
 * 	public String show(B obj)自定义的
 * C->B->A
 * D->B->A
 * 
 * 2、方法重载：找最合适的形参类型
 * 3、方法重写：如果子类重写，就执行重写的
 * 4、分析执行结果
 * a1.show(b)：a1没有多态引用，直接找A类的方法，b是B类对象，只能选择public String show(A obj)   A and A
 * a2.show(d)：a2多态引用，执行子类的方法，d是D类对象，选最合适的public String show(D obj)   A and D
 * b.show(c)：b没有多态引用，直接找B类的方法，c是C类的对象，选择最合适的public String show(B obj) B and B
 * b.show(d)：b没有多态引用，直接找B类的方法，d是D类对象，选最合适的public String show(D obj)   A and D
 */
```

## 第2题

考核知识点：多态、重载、重写

```java
public class Test02 {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();
		System.out.println("(1)" + a1.show(b));
		System.out.println("(2)" + a2.show(d));
		System.out.println("(3)" + b.show(c));
		System.out.println("(4)" + b.show(d));
	}
}

class A {
	public String show(C obj) {
		return ("A and C");
	}

	public String show(A obj) {
		return "A and A";
	}
}

class B extends A {
	public String show(B obj) {
		return "B and B";
	}

	public String show(A obj) {
		return "B and A";
	}
}

class C extends B {

}

class D extends B {

}
```

```java
/*
 * 1、分析方法列表和继承关系
 * A类：
 * 	public String show(C obj) 
 * 	public String show(A obj)
 * B类：
 * 	public String show(C obj)继承的
 * 	public String show(A obj)重写
 * 	public String show(B obj)自定义的
 * C->B->A
 * D->B->A
 * 
 * 2、方法重载：找最合适的形参类型
 * 3、方法重写：如果子类重写，就执行重写的
 * 4、如果特殊的重载，那么多态时，编译时先从父类中查找最合适的形参类型，然后如果子类如果有重写，执行子类重写的，如果没有重写，执行父类的。
 * 5、分析执行结果
 * a1.show(b)：a1没有多态引用，直接找A类的方法，b是B类对象，只能选择public String show(A obj)   A and A
 * a2.show(d)：a2多态引用，执行子类的方法，d是D类对象，但是因为此时编译时按A类编译，所以在编译期间先确定是调用
 * 		public String show(A obj)，而后执行子类重写的public String show(A obj)       B and A
 * 		而不是直接选最合适的public String show(B obj)
 * b.show(c)：b没有多态引用，直接找B类的方法，c是C类的对象，选择最合适的public String show(C obj) A and C
 * b.show(d)：b没有多态引用，直接找B类的方法，d是D类对象，选最合适的public String show(B obj)   B and B
 */
```



## 第3题

考核知识点：属性与多态无关

```java
public class Test03 {
	public static void main(String[] args) {
		Base b = new Sub();
		System.out.println(b.x);
	}
}
class Base{
	int x = 1;
}
class Sub extends Base{
	int x = 2;
}
```

```java
/*
 * 属性没有多态性，只看编译时类型
 */
```

## 第4题

考核知识点：权限修饰符

如下代码是否可以编译通过，如果能，结果是什么，如果不能，为什么？

```java
public class Father{
	private String name = "atguigu";
	int age = 0;
}
public class Child extends Father{
	public String grade;
	
	public static void main(String[] args){
		Father f = new Child();
		System.out.println(f.name);
	}
}
```

```java
public class Child extends Father{
	public String grade;
	
	public static void main(String[] args){
		Father f = new Child();
//		System.out.println(f.name);//编译错误，因为name私有化
	}
}

```

## 第5题

考核知识点：继承，super，static

如下代码是否可以编译通过，如果能，结果是什么，如果不能，为什么？

```java
public class Person{
	public Person(){
		System.out.println("this is a Person.");
	}
}
public class Teacher extends Person{
	private String name = "tom";
	public Teacher(){
		System.out.println("this is a teacher.");
		super();
	}
	public static void main(String[] args){
		Teacher tea = new Teacher();
		System.out.println(this.name);
	}
}
```

```java
public class Teacher extends Person{
	private String name = "tom";
	public Teacher(){
		System.out.println("this is a teacher.");
//		super();//错误，super()必须在构造器首行
	}
	public static void main(String[] args){
		Teacher tea = new Teacher();
//		System.out.println(this.name);//错误，static方法中不能使用this
	}
}

```



# 代码编程题

## 第6题

* 知识点：抽象类

* 语法点：继承，抽象类
* 按步骤编写代码，效果如图所示：

![1559049252810](imgs/1559049252810.png)

编写步骤：

1. 定义抽象类A，抽象类B继承A，普通类C继承B
2. A类中，定义成员变量numa，赋值为10，抽象showA方法。
3. B类中，定义成员变量numb，赋值为20，抽象showB方法。
4. C类中，定义成员变量numc，赋值为30，重写showA方法，打印numa，重写showB方法，打印numb，定义showC方法，打印numc。
5. 测试类Test06中，创建C对象，调用showA方法，showB方法，showC方法。

```java
package com.atguigu.test06;

public class Test06 {
	public static void main(String[] args) {
		C c = new C();
		c.showA();
		c.showB();
		c.showC();
	}
}
abstract class A{
	protected int numa = 10;
	public abstract void showA();
}
abstract class B extends A{
	protected int numb = 20;
	public abstract void showB();
}
class C extends B{
	private int numc = 30;

	@Override
	public void showB() {
		System.out.println("B类中numb:" + numb);
	}

	@Override
	public void showA() {
		System.out.println("A类中numa:" + numa);
	}
	
	public void showC(){
		System.out.println("C类中numc:" + numc);
	}
}
```



## 第7题

知识点：抽象类

案例：

​	1、声明抽象父类Person，包含抽象方法public abstract void pee();

​	2、声明子类Woman，重写抽象方法，打印女人坐着尿

​	3、声明子类Man，重写抽象方法，打印男人站着上尿

​	4、声明测试类Test07，创建Person数组，存放Woman和Man对象，并遍历数组，调用pee()方法

```java
package com.atguigu.test07;

public abstract class Person {
	public abstract void pee();
}

```

```java
package com.atguigu.test07;

public class Woman extends Person{

	@Override
	public void pee() {
		System.out.println("女人坐着尿");
	}

}
```

```java
package com.atguigu.test07;

public class Man extends Person{

	@Override
	public void pee() {
		System.out.println("男人站着尿");
	}

}
```

```java
package com.atguigu.test07;

public class Test07 {
	public static void main(String[] args) {
		Person[] all = new Person[2];
		all[0] = new Woman();
		all[1] = new Man();
		
		for (int i = 0; i < all.length; i++) {
			all[i].pee();
		}
	}
}
```



## 第8题

知识点：抽象类

案例：

​	1、声明抽象父类Person，包含抽象方法public abstract void eat();

​	2、声明子类中国人Chinese，重写抽象方法，打印用筷子吃饭

​	3、声明子类美国人American，重写抽象方法，打印用刀叉吃饭

​	4、声明子类印度人Indian，重写抽象方法，打印用手抓饭

​	5、声明测试类Test08，创建Person数组，存储各国人对象，并遍历数组，调用eat()方法

```java
package com.atguigu.test08;

public class Test08 {

	public static void main(String[] args) {
		Person[] all = new Person[3];
		all[0] = new Chinese();
		all[1] = new American();
		all[2] = new Indian();
		
		for (int i = 0; i < all.length; i++) {
			all[i].eat();
		}
	}

}
abstract class Person{
	public abstract void eat();
}
class Chinese extends Person{

	@Override
	public void eat() {
		System.out.println("中国人用筷子吃饭");
	}
	
}
class American extends Person{

	@Override
	public void eat() {
		System.out.println("美国人用刀叉吃饭");
	}
	
}
class Indian extends Person{

	@Override
	public void eat() {
		System.out.println("印度人用手抓饭");
	}
	
}
```



## 第9题

知识点：Object类的方法

案例：

​	1、声明三角形类，包含a,b,c三边

​	（1）属性私有化，提供无参，有参构造，提供get/set

​	（2）重写：toString()

​	（3）重写：hashCode和equals方法

​	（4）编写  public double getArea()：求面积方法

​	（5）编写 public double getPiremeter()：求周长方法

​	2、声明测试类Test09，在测试类中创建两个三角形对象，调用以上方法进行测试

```java
package com.atguigu.test09;

public class Test09 {
	public static void main(String[] args) {
		Triangle t1 = new Triangle(3,4,5);
		Triangle t2 = new Triangle(3,3,3);
		
		System.out.println(t1);
		System.out.println(t2);
		
		System.out.println("t1的面积：" + t1.getArea());
		System.out.println("t1的周长：" + t1.getPiremeter());
		System.out.println("t2的面积：" + t2.getArea());
		System.out.println("t2的面积：" + t2.getPiremeter());
		
		System.out.println("t1和t2是否相同：" + t1.equals(t2));
	}
}
class Triangle{
	private double a;
	private double b;
	private double c;
	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Triangle() {
		super();
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
	public String toString() {
		return "三角形的三条边：a=" + a + ", b=" + b + ", c=" + c;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(a);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(b);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(c);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
			return false;
		if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
			return false;
		if (Double.doubleToLongBits(c) != Double.doubleToLongBits(other.c))
			return false;
		return true;
	}
	public double getArea(){
		double p = (a + b + c)/2;
		return Math.sqrt(p * (p-a) * (p-b) * (p-c));
	}
	public double getPiremeter(){
		return a + b + c;
	}
}
```

