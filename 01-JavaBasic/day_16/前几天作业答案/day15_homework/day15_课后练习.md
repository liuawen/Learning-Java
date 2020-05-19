# day15_课后练习

# 代码阅读题

## 第1题

```java
	public static void main(String[] args) {
		int test = test(3,5);
		System.out.println(test);
	}

	public static int test(int x, int y){
		int result = x;
		try{
			if(x<0 || y<0){
				return 0;
			}
			result = x + y;
			return result;
		}finally{
			result = x - y;
		}
	}
```

## 第2题

```java
public class Test02 {
	public static void main(String[] args) {
		try{
			return;
		}finally{
			System.out.println("finally");
		}
	}
}
```

## 第3题

```java
public class Test03 {
	{
		System.out.println("a");
	}
	static{
		System.out.println("b");
	}
	Test03(){
		System.out.println("c");
	}
	public static String getOut(){
		try{
			return "1";
		}catch(Exception e){
			return "2";
		}finally{
			return "3";
		}
	}
	public static void main(String[] args) {
		System.out.println(getOut());
	}
}
```

## 第4题

```java
public class Test04 {
	static int i = 0;
	public static void main(String[] args) {
		System.out.println(test());
	}

	public static int test(){
		try{
			return ++i;
		}finally{
			return ++i;
		}
	}
}
```

## 第5题

```java
import java.io.IOException;

public class Test05 {
	public static void main(String[] args) {
		int a = -1;
		try{
			if(a>0){
				throw new RuntimeException("");
			}else if(a<0){
				throw new IOException("");
			}else{
				return ;
			}
		}catch(IOException ioe){
			System.out.println("IOException");
		}catch(Throwable e){
			System.out.println("Throwable");
		}finally{
			System.out.println("finally");
		}
	}
}
```

## 第6题

```java
public class Test06 {
	public static int fun(){
		int result = 5;
		try{
			result = result / 0;
			return result;
		}catch(Exception e){
			System.out.println("Exception");
			result = -1;
			return result;
		}finally{
			result = 10;
			System.out.println("I am in finally.");
		}
	}
	public static void main(String[] args) {
		int x = fun();
		System.out.println(x);
	}
}

```

## 第7题

```java
	public static int aMethod(int i)throws Exception{
		try{
			return i / 10;
		}catch(Exception ex){
			throw new Exception("exception in aMethod");
		}finally{
			System.out.println("finally");
		}
	}
	public static void main(String[] args) {
		try {
			aMethod(0);
		} catch (Exception e) {
			System.out.println("exception in main");
		}
	}
```



# 代码编程题

## 第8题

案例：

​	在一款角色扮演游戏中,每一个人都会有名字和生命值，角色的生命值不能为负数。

​	要求：当一个人物的生命值为负数的时候需要抛出自定的异常

操作步骤描述：

（1）自定义异常类NoLifeValueException继承RuntimeException

①提供空参和有参构造

②在有参构造中，需要调用父类的有参构造，把异常信息传入

（2）定义Person类

①属性：名称(name)和生命值(lifeValue)

②提供空参构造

③提供有参构造：使用setXxx方法给name和lifeValue赋值

④提供setter和getter方法：

​	在setLifeValue(int lifeValue)方法中，首先判断，如果 lifeValue为负数,就抛出NoLifeValueException，异常信息为：生命值不能为负数：xx；

​	然后在给成员lifeValue赋值。

（3）定义测试类Test08

①使用满参构造方法创建Person对象，生命值传入一个负数

由于一旦遇到异常,后面的代码的将不在执行,所以需要注释掉上面的代码

②使用空参构造创建Person对象

调用setLifeValue(int lifeValue)方法,传入一个正数,运行程序

调用setLifeValue(int lifeValue)方法,传入一个负数,运行程序

③分别对①和②处理异常和不处理异常进行运行看效果

## 第9题

请编写代码演示OOM错误

# 选择题

## 第10题

![1559476465486](imgs/1559476465486.png)

## 第11题

![1559476526966](imgs/1559476526966.png)

# 简答题

问题：

1. 请描述异常的继承体系
2. 请描述你对错误(Error)的理解
3. 请描述你对异常(Expection的理解)
4. 请描述你对运行时异常(RuntimeException)的理解
5. throw与throws的区别
6. 异常处理方式有几种,分别是什么?详细阐述每种方式对异常是如何处理的
7. 请列举常见异常，并说明产生原因。

