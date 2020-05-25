# Java复习笔记



[TOC]









# 第一章 Java概述

## 1.1 Java历史

Java诞生于SUN（Stanford University Network），09年SUN被Oracle（甲骨文）收购。

Java之父是詹姆斯.高斯林(James Gosling)。

1996年发布JDK1.0版。

目前最新的版本是Java12。我们学习的Java8。

2020年-3月

JDK14来了

## 1.2 Java语言最主要的特点

* 特点一：面向对象

两个基本概念：类、对象

三大特性：封装、继承、多态

* 特点二：健壮性

吸收了C/C++语言的优点，但去掉了其影响程序健壮性的部分（如指针、内存的申请与释放等），提供了一个相对安全的内存管理和访问机制

* 特点三：跨平台性

跨平台性：通过Java语言编写的应用程序在不同的系统平台上都可以运行。“Write once , Run Anywhere”一次编写，处处运行。

原理：只要在需要运行 java 应用程序的操作系统上，先安装一个Java虚拟机 (JVM Java Virtual Machine) 即可。由JVM来负责Java程序在该系统中的运行。因为有了JVM，同一个Java 程序在三个不同的操作系统中都可以执行。这样就实现了Java 程序的跨平台性。

![1557828366412](imgs/1557828366412.png)

## 1.3 Java环境搭建

### 1.3.1 JDK、JRE、JVM

Java开发人员需要安装JDK。如果仅仅是运行Java程序，那么只需要按照JRE。

JDK（Java Development kits）：Java开发工具包。

JRE（Java Runtime Environment）：Java运行环境。

JVM（Java Virtual Machine）：Java虚拟机。

JDK = JRE + 开发工具（javac.exe,java.exe,javadoc.exe等）

JRE = JVM + 核心类库（常用类：String、日期时间、数学、集合、IO、网络、多线程等）

![](imgs/1553593811117.png)

### 1.3.2  Java环境搭建

1、安装JDK

![](imgs/1553644600381.png)

2、配置JDK的开发工具目录到path环境变量中

​	例如：D:\ProgramFiles\Java\jdk1.8.0_51\bin;

​	注意：这个安装目录以你自己的安装目录为准

![1553644724825](imgs/1553644724825.png)

（1）为什么配置path？

​	希望在命令行使用javac.exe等工具时，任意目录下都可以找到这个工具所在的目录。

（2）如何配置环境变量？

​	【计算机】右键【属性】，选择【高级系统设置】，选择【高级】，选择【环境变量】，选择【系统环境变量】，编辑path，在【**path原有值**】的前面加入D:\ProgramFiles\Java\jdk1.8.0_51\bin;

## 1.4 第一个Java应用程序

```java
class HelloWorld{
    public static void main(String[] args){
        System.out.print("Hello Java!");
    }
}
```

### 1.4.1 Java程序的开发步骤

三步：

1、编辑/编写源代码

要求：源文件必须是.java文件

2、编译

目的：把源文件编译为.class字节码文件（因为JVM只认识字节码）

工具：javac.exe

格式：

```cmd
javac 源文件名.java
```



3、运行

工具：java.exe

格式：

```cmd
java 类名
java 字节码文件名
```

要求：可以被运行的类，必须包含main方法



### 1.4.2 Java程序的结构与格式

结构：

```java
类{
    方法{
        语句;
    }
}
```

格式：

（1）每一级缩进一个Tab键

（2）{}的左半部分在行尾，右半部分单独一行，与和它成对的"{"的行首对齐



### 1.4.3 Java程序的入口

Java程序的入口是main方法

```java
public static void main(String[] args){
    
}
```



### 1.4.4 Java注释

1、单行注释

```java
//注释内容
```

2、多行注释

```java
/*
注释内容
*/
```

3、文档注释

```java
/**
文档注释（后面注解部分讲解）
*/
```



## 1.5 编写Java程序时应该注意的问题

1、字符编码问题

当cmd命令行窗口的字符编码与.java源文件的字符编码不一致，如何解决？

![1557881223916](imgs/1557881223916.png)

解决方案一：

​	在Notepad++等编辑器中，修改源文件的字符编码

![1557881271819](imgs/1557881271819.png)

解决方案二：

​	在使用javac命令式，可以指定源文件的字符编码

```cmd
javac -encoding utf-8 Review01.java
```



2、大小写问题

（1）源文件名：

​	不区分大小写，我们建议大家还是区分

（2）字节码文件名与类名

​	区分大小写

（3）代码中

​	区分大小写



3、源文件名与类名一致问题？

（1）源文件名是否必须与类名一致？public呢？

如果这个类不是public，那么源文件名可以和类名不一致。

如果这个类是public，那么要求源文件名必须与类名一致。

我们建议大家，不管是否是public，都与源文件名保持一致，而且一个源文件尽量只写一个类，目的是为了好维护。



（2）一个源文件中是否可以有多个类？public呢？

一个源文件中可以有多个类，编译后会生成多个.class字节码文件。

但是一个源文件只能有一个public的类。



（3）main必须在public的类中吗？

不是。

但是后面写代码时，基本上main习惯上都在public类中。



# 第二章 Java的基础语法

## 2.1 标识符

简单的说，凡是程序员自己命名的部分都可以称为标识符。

即给类、变量、方法、包等命名的字符序列，称为标识符。



1、标识符的命名规则

（1）Java的标识符只能使用26个英文字母大小写，0-9的数字，下划线_，美元符号$

（2）不能使用Java的关键字（包含保留字）和特殊值

（3）数字不能开头

（4）不能包含空格

（5）严格区分大小写



2、标识符的命名规范

（1）见名知意

（2）类名、接口名等：每个单词的首字母都大写，形式：XxxYyyZzz，

例如：HelloWorld，String，System等

（3）变量、方法名等：从第二个单词开始首字母大写，其余字母小写，形式：xxxYyyZzz，

例如：age,name,bookName,main

（4）包名等：每一个单词都小写，单词之间使用点.分割，形式：xxx.yyy.zzz，

例如：java.lang

（5）常量名等：每一个单词都大写，单词之间使用下划线_分割，形式：XXX_YYY_ZZZ，

例如：MAX_VALUE,PI



## 2.2 变量

### 2.2.1 变量的概念

变量的作用：用来存储数据，代表内存的一块存储区域，变量中的值是可以改变的。

### 2.2.2 变量的三要素

1、数据类型

2、变量名

3、值

### 2.2.3 变量的使用应该注意什么？

1、先声明后使用

> 如果没有声明，会报“找不到符号”错误

2、在使用之前必须初始化

> 如果没有初始化，会报“未初始化”错误

3、变量有作用域

> 如果超过作用域，也会报“找不到符号”错误

4、在同一个作用域中不能重名



### 2.2.4 变量的声明和赋值、使用的语法格式？

1、变量的声明的语法格式：

```java
数据类型  变量名;
例如：
int age;
String name;
double weight;
char gender;
boolean isMarry;
```

2、变量的赋值的语法格式：

```java
变量名 = 值;
例如：
age = 18;
name = "柴林燕"; //字符串的值必须用""
weight = 44.4;
gender = '女';//单字符的值必须使用''
isMarry = true;
```

3、变量的使用的语法格式：

```java
通过变量名直接引用

例如：
(1)输出变量的值
System.out.print(name);
System.out.print("姓名：" + name);//""中的内容会原样显示
System.out.print("name = " + name);
(2)计算
age = age + 1;
```

# 2.3 数据类型

### 2.3.1 Java数据类型的分类

1、基本数据类型

​	8种：整型系列（byte,short,int,long）、浮点型(float,double)、单字符型（char）、布尔型（boolean）

2、引用数据类型

​	类、接口、数组、枚举.....

### 2.3.2 Java的基本数据类型

1、整型系列

（1）byte：字节类型

占内存：1个字节

存储范围：-128~127

（2）short：短整型类型

占内存：2个字节

存储范围：-32768~32767

（3）int：整型

占内存：4个字节

存储范围：-2的31次方 ~ 2的31次方-1

（4）long：整型

占内存：8个字节

存储范围：-2的63次方 ~ 2的63次方-1

> 注意：如果要表示某个常量数字它是long类型，那么需要在数字后面加L



2、浮点型系列（小数）

（1）float：单精度浮点型

占内存：4个字节

精度：科学记数法的小数点后6~7位

> 注意：如果要表示某个常量数字是float类型，那么需要在数字后面加F或f

（2）double：双精度浮点型

占内存：8个字节

精度：科学记数法的小数点后15~16位



3、单字符类型

char：字符类型

占内存：2个字节

Java中使用的字符集：Unicode编码集

字符的三种表示方式：

（1）'一个字符'

例如：'A'，'0'，'尚'

（2）转义字符

```
\n：换行
\r：回车
\t：Tab键
\\：\
\"：”
\'：
\b：删除键Backspace
```

（3）\u字符的Unicode编码值的十六进制型

例如：\u5c1a代表'尚'



4、布尔类型

boolean：只能存储true或false

### 2.3.3 进制（了解，可以暂时忽略）

1、进制的分类：

（1）十进制

​	数字组成：0-9

​	进位规则：逢十进一

（2）二进制

​	数字组成：0-1

​	进位规则：逢二进一

（3）八进制

​	数字组成：0-7

​	进位规则：逢八进一

（4）十六进制

​	数字组成：0-9，a~f（或A~F）

​	进位规则：逢十六进一



2、请分别用四种类型的进制来表示10，并输出它的结果：（了解）

（1）十进制：正常表示

System.out.println(10);

（2）二进制：0b或0B开头

System.out.println(0B10);

（3）八进制：0开头

System.out.println(010);

（4）十六进制：0x或0X开头

System.out.println(0X10);



3、为什么byte是-128~127？（理解）

1个字节：8位

0000 0001  ~  0111 111 ==> 1~127

1000 0001 ~ 1111 1111 ==> -127 ~ -1

0000 0000 ==>0

1000 0000 ==> -128（特殊规定）

> *解释：*计算机数据的存储（了解）
>
> *计算机数据的存储使用二进制补码形式存储，并且最高位是符号位，1是负数，0是正数。*
>
> *规定：正数的补码与反码、原码一样，称为三码合一；*
>
> ​	    *负数的补码与反码、原码不一样：*
>
> ​	   *负数的原码：把十进制转为二进制，然后最高位设置为1*
>
> ​	   *负数的反码：在原码的基础上，最高位不变，其余位取反（0变1,1变0）*
>
> ​	   *负数的补码：反码+1*
>
> *例如：byte类型（1个字节，8位）*
>
> *25 ==> 原码  0001 1001 ==> 反码  0001 1001 -->补码  0001 1001*
>
> *-25 ==>原码  1001 1001 ==> 反码1110 0110 ==>补码 1110 0111*
>
> 底层是用加法代替减法：-128==》-127-1==》-127+(-1)
>
> ​				       -127- -1 ==> -127 + 1



4、学生疑惑解答？

（1）为什么float（4个字节）比long（8个字节）的存储范围大？

（2）为什么double（8个字节）比float（4个字节）精度范围大？

因为float、double底层也是二进制，先把小数转为二进制，然后把二进制表示为科学记数法，然后只保存：

（1）符号位（2）指数位（3）尾数位

> *详见《float型和double型数据的存储方式.docx》*

### 2.3.4 基本数据类型的转换

1、自动类型转换

（1）当把存储范围小的值（常量值、变量的值、表达式计算的结果值）赋值给了存储范围大的变量时，

byte->short->int->long->float->double

​            char->

```java
int i = 'A';//char自动升级为int
double d = 10;//int自动升级为double
```



（2）当存储范围小的数据类型与存储范围大的数据类型一起混合运算时，会按照其中最大的类型运算

```java
int i = 1;
byte b = 1;
double d = 1.0;

double sum = i + b + d;//混合运算，升级为double
```

（3）当byte,short,char数据类型进行算术运算时，按照int类型处理

```java
byte b1 = 1;
byte b2 = 2;
byte b3 = (byte)(b1 + b2);//b1 + b2自动升级为int

char c1 = '0';
char c2 = 'A';
System.out.println(c1 + c2);//113 
```

（4）boolean类型不参与



2、强制类型转换

（1）当把存储范围大的值（常量值、变量的值、表达式计算的结果值）赋值给了存储范围小的变量时，需要强制类型转换

double->float->long->int->short->byte

​					   ->char

提示：有风险，可能会损失精度或溢出

```java
double d = 1.2;
int num = (int)d;//损失精度

int i = 200;
byte b = (byte)i;//溢出
```

（2）boolean类型不参与

（3）当某个值想要提升数据类型时，也可以使用强制类型转换

```java
int i = 1;
int j = 2;
double shang = (double)i/j;
```

提示：这个情况的强制类型转换是没有风险的。



### 2.3.5 特殊的数据类型转换

1、任意数据类型的数据与String类型进行“+”运算时，结果一定是String类型

```java
System.out.println("" + 1 + 2);//12
```



2、但是String类型不能通过强制类型()转换，转为其他的类型

```java
String str = "123";
int num = (int)str;//错误的
```



## 2.4 运算符

1、按照操作数个数的分类：

（1）一元运算符：操作数只有一个

例如：正号（+），负号（-），自增（++），自减（--），逻辑非（！），按位取反（~）

（2）二元运算符：操作数有两个

例如：加（+），减（-），乘（*），除（/），模（%）

​          大于（>），小于（<），大于等于（>=），小于等于（<=），等于（==），不等于（!=）

​	赋值（=，+=，-=，*=，/=，%=，>>=，<<=。。。）

​	 逻辑与（&），逻辑或（|），逻辑异或（^），短路与（&&），短路或（||）

​	左移（<<），右移（>>），无符号右移（>>>），按位与（&），按位或（|），按位异或（^）

（3）三元运算符：操作数三个

例如： ？ ：



2、Java基本数据类型的运算符：

（1）算术运算符

（2）赋值运算符

（3）比较运算符

（4）逻辑运算符

（5）条件运算符

（6）位运算符（难）

### 2.4.1 算术运算符

加法：+

减法：-

乘法：*

除法：/

> *注意：整数与整数相除，只保留整数部分*

取模：%   取余

> 注意：取模结果的正负号只看被模数

正号：+

负号：-

自增：++

自减：--

> **原则：自增与自减**
>
> **++/--在前的，就先自增/自减，后取值**
>
> **++/--在后的，就先取值，后自增/自减**
>
> 整个表达式的扫描，是从左往右扫描，如果后面的先计算的，那么前面的就暂时先放到“操作数栈”中

代码示例：

```java
int i = 1;
i++;//i=2

int j = 1;
++j;//j=2

int a = 1;
int b = a++;//(1)先取a的值“1”放操作数栈(2)a再自增,a=2(3)再把操作数栈中的"1"赋值给b,b=1

int m = 1;
int n = ++m;//(1)m先自增,m=2(2)再取m的值“2”放操作数栈(3)再把操作数栈中的"2"赋值给n,n=1

int i = 1;
int j = i++ + ++i * i++;
/*
从左往右加载
(1)先算i++
①取i的值“1”放操作数栈
②i再自增 i=2
（2）再算++i
①i先自增 i=3
②再取i的值“3”放操作数栈
（3）再算i++
①取i的值“3”放操作数栈
②i再自增 i=4
（4）先算乘法
用操作数栈中3 * 3 = 9，并把9压会操作数栈
（5）再算求和
用操作数栈中的 1 + 9 = 10
（6）最后算赋值
j = 10
*/
```



### 2.4.2 赋值运算符

基本赋值运算符：=

扩展赋值运算符：+=，-=，*=，/=，%=...

> 注意：所有的赋值运算符的=左边一定是一个变量
>
> 扩展赋值运算符=右边的计算结果的类型如果比左边的大的话会强制类型转换，所以结果可能有风险。
>
> 扩展赋值运算符的计算：（1）赋值最后算（2）加载数据的顺序是把左边的变量的值先加载，再去与右边的表达式进行计算

```java
int i = 1;
int j = 5;
j *= i++ + j++;//j = j *(i++ + j++);
/*
(1)先加载j的值“5”
(2)在计算i++
①先加载i的值“1”
②再i自增，i=2
(3)再计算j++
①先加载j的值"5"
②再j自增，j=6
(4)算  加法
i + 5 = 6
(5)算乘法
5 * 6 = 30
(6)赋值
j = 30
*/
```



### 2.4.3 比较运算符

大于：>

小于：<

大于等于：>=

小于等于：<=

等于：==		注意区分赋值运算符的=

不等于：!=

> 注意：比较表达式的运算结果一定只有true/false
>
> 比较表达式可以作为（1）条件（2）逻辑运算符的操作数



### 2.4.4 逻辑运算符

> 逻辑运算符的操作数必须是布尔值，结果也是布尔值

逻辑与：&
	运算规则：只有左右两边都为true，结果才为true。
	例如：true & true 结果为true
		   false & true 结果为false
		    true & false 结果为false
		    false & false 结果为false
逻辑或：|
	运算规则：只要左右两边有一个为true，结果就为true。
	例如：true | true 结果为true
		   false | true 结果为true
		   true | false 结果为true
		    false | false 结果为false	
逻辑异或：^
	运算规则：只有左右两边不同，结果才为true。
	例如：true ^ true 结果为false
		    false ^ true 结果为true
		    true ^ false 结果为true
		    false ^ false 结果为false			

逻辑非：!
	运算规则：布尔值取反
	例如：!true 为false
		    !false 为true

短路与：&&
	运算规则：只有左右两边都为true，结果才为true。
	例如：true & true 结果为true
		    true & false 结果为false
		    false & ?  结果就为false
	它和逻辑与不同的是当&&左边为false时，右边就不看了。
	
短路或：||	
	运算规则：只要左右两边有一个为true，结果就为true。
	例如：true | ? 结果为treu
		   false | true 结果为true
		    false | false 结果为false	
	它和逻辑或不同的是当||左边为true时，右边就不看了。

> 开发中一般用短路与和短路或比较多

面试题：&& 和 &的区别？

> &&当左边为false，右边不计算
>
> &不管左边是true还是false，右边都要计算

### 2.4.5 条件运算符

 ? : 

语法格式：

```java
条件表达式 ? 结果表达式1 : 结果表达式2
```

运算规则：

整个表达式的结果：当条件表达式为true时，就取结果表达式1的值，否则就取结果表达式2的值

代码示例：

```java
（1）boolean类型
boolean marry = true;
System.out.println(marry? "已婚" : "未婚");

（2）求最值
int i = 3;
int j = 5;
int max = i>=j ? i : j;
//当i>=j时，max就赋值为i的值，否则就赋值为j的值
```



### 2.4.6 位运算符

左移：<<

​	运算规则：左移几位就相当于乘以2的几次方

右移：>>

​	运算规则：右移几位就相当于除以2的几次方

无符号右移：>>>

​	运算规则：往右移动后，左边空出来的位直接补0，不看符号位

按位与：&

​	运算规则：

​		1 & 1 结果为1

​		1 & 0 结果为0

​		0 & 1 结果为0

​		0 & 0 结果为0

按位或：|

​	运算规则：

​		1 | 1 结果为1

​		1 | 0 结果为1

​		0 | 1 结果为1

​		0 & 0 结果为0

按位异或：^

​	运算规则：

​		1 ^ 1 结果为0

​		1 ^ 0 结果为1

​		0 ^ 1 结果为1

​		0 ^ 0 结果为0

按位取反：~

​	 运算规则：~0就是1  

​			   ~1就是0

> 如何区分&,|,^是逻辑运算符还是位运算符？
>
> 如果操作数是boolean类型，就是逻辑运算符，如果操作数是整数，那么就位运算符。



### 2.4.7 运算符优先级

![1553858424335](imgs/1553858424335.png)

提示说明：

（1）表达式不要太复杂

（2）先算的使用()



### 2.4.8 运算符操作数类型说明

1、算术运算符

数字和单个字符可以使用算术运算符。

其中+，当用于字符串时，表示拼接。



2、赋值运算符

右边的常量值、表达式的值、变量的值的类型必须与左边的变量一致或兼容（可以实现自动类型转换）或使用强制类型转换可以成功。



3、比较运算符

其他的比较运算符都是只能用于8种基本数据类型。

其中的==和!=可以用于引用数据类型的比较，用于比较对象的地址。（后面讲）

```java
int i = 10;
int j = 10;
System.out.println(i==j);//true

char c1 = '帅';
char c2 = '帅';
System.out.println(c1 == c2);//true
```



4、逻辑运算符

逻辑运算符的操作数必须是boolean值



5、条件运算符

?前面必须是条件，必须是boolean值

结果表达式1和结果表达式2要保持类型一致或兼容



6、位运算符

一般用于整数系列



> 以上运算符都是针对基本数据类型设计的。
>
> 能够用于引用数据类型只有基本的赋值运算符=，和比较运算符中的==和!=。其他运算符都不能用于引用数据类型。
>
> 其中字符串类型还有一个+，表示拼接。

# 第三章 流程控制语句结构

流程控制语句结构分为：

1、顺序结构：从上到下依次执行

2、分支结构：多个分支选择其中一个分支执行

3、循环结构：重复执行某些代码

## 3.1 顺序结构

执行过程：从上到下顺序执行

### 3.1.1 输出语句

1、System.out.print(输出内容); #输出内容后不换行

2、System.out.println(输出内容);  #输出内容后换行

```java
#输出常量
System.out.print(1);
System.out.print('尚');
System.out.print(44.4);
System.out.print(true);
System.out.print("尚硅谷");

#输出变量
int a = 1;
char c = '尚';
double d = 44.4;
boolean b = true;
String school = "尚硅谷";
System.out.print(a);
System.out.print(c);
System.out.print(d);
System.out.print(b);
System.out.print(school);

#输出拼接结果
System.out.print("a = " + a);
System.out.print("c = " + c);
System.out.print("d = " + d);
System.out.print("b = " + b);
System.out.print("school = " + school);
```

### 3.1.2 输入语句

键盘输入代码的三个步骤：

1、准备Scanner类型的变量

2、提示输入xx

3、接收输入内容

示例代码：

```java
//1、准备Scanner类型的变量
java.util.Scanner input = new java.util.Scanner(System.in);//System.in默认代表键盘输入

//2、提示输入xx
System.out.print("请输入一个整数：");

//3、接收输入内容
int num = input.nextInt();

//列出各种数据类型的输入
int num = input.nextInt();
long bigNum = input.nextLong();
double d = input.nextDouble();
boolean b = input.nextBoolean();
String s = input.next();
char c = input.next().charAt(0);//先按照字符串接收，然后再取字符串的第一个字符（下标为0）

```

## 3.2 分支结构

分支结构：根据条件选择性的执行某些代码

分为：

1、条件判断：if...else系列

2、选择结构：switch...case系列

### 3.2.1 条件判断

#### 1、单分支结构

语法格式：

```java
if(条件表达式){
    当条件表达式成立(true)时需要执行的语句块;
}
```

执行过程：

​	条件成立，就执行{}其中的语句块，不成立就不执行。

> 注意：
>
> （1）if(条件表达式)中的条件表达式的结果必须是boolean类型
>
> （2）当{}中的语句只有一个语句（简单的语句，也可以是一个复合语句）时，可以省略{}，但是我们不建议省略

```java
		//省略{}的情况
		if(score<0 || score>100)
			System.out.println("输入有误！");//简单的语句
		else
			//复合语句
			if(score==100){
				System.out.println("满分");
			}else if(score>=80){
				System.out.println("优秀");
			}else if(score>=60){
				System.out.println("及格");
			}else{
				System.out.println("不及格");
			}
```



示例代码：

```java
int year = 2019;
int days = 28;
if(year%4==0 && year%100!=0 || year%400==0){
    days= 29;
}
```



#### 2、双分支结构

语法格式：

```java
if(条件表达式){
    当条件表达式成立(true)时需要执行的语句块1;
}else{
    当条件表达式不成立(false)时需要执行的语句块2;
}
```

执行过程：

​	当条件表达式成立(true)时执行语句块1，否则执行语句块2

> 注意：
>
> （1）if(条件表达式)中的条件表达式的结果必须是boolean类型
>
> （2）当{}中的语句只有一个语句（简单的语句，也可以是一个复合语句）时，可以省略{}，但是我们不建议



示例代码：

```java
int num = 10;
if(num%2==0){
    System.out.println(num + "是偶数")；
}else{
     System.out.println(num + "是奇数")；
}
```



#### 3、多分支结构

语法格式：

```java
if(条件表达式1){
    当条件表达式1成立的时候，执行的语句块1；
}else if(条件表达式2){
    当条件表达式1不成立，
      条件表达式2成立的时候，执行的语句块2；
}else if(条件表达式3){
    当条件表达式1不成立，
       条件表达式2也不成立，
      条件表达式3成立的时候，执行的语句块3；
}
。。。
【else{
	当以上所有的条件表达式都不成立，需要执行的语句块n+1;
}】
```

执行过程：

（1）多个条件顺序往下判断，如果上面有一个条件成立了，下面的条件就不看了

（2）多个分支也只会执行其中的一个

> 注意：
>
> （1）每一个条件表达式都必须是boolean值
>
> （2）当{}中只有一个语句时，也可以省略{}，但不建议省略
>
> （3）当多个条件是“互斥”关系（没有重叠部分），顺序可以随意；
>
> ​          当多个条件是“包含”关系（有重叠部分），顺序不能随意，小的在上，大的在下面



示例代码：

```java
			int score = 78;
			if(score==100){
				System.out.println("满分");
			}else if(score>=80){
				System.out.println("优秀");
			}else if(score>=60){
				System.out.println("及格");
			}else{
				System.out.println("不及格");
			}
```



#### 4、嵌套

执行过程：

​	当嵌套在if中，就是当外面的if成立时，才会看里面的条件判断；

​	当嵌套在else中，就当外面的else满足时，才会看里面的条件判断；



### 3.2.2 选择结构

语法格式：

```java
switch(表达式){
    case 常量值1:
        语句块1;
        【break;】
    case 常量值2:
        语句块2;
        【break;】   
    。。。
   【default:
        语句块n+1;
        【break;】
     】
}
```

执行过程：

（1）入口

①当switch(表达式)的值与case后面的某个常量值匹配，就从这个case进入；

②当switch(表达式)的值与case后面的所有常量值都不匹配，寻找default分支进入;

（2）一旦从“入口”进入switch，就会顺序往下执行，直到遇到“出口”

（3）出口

①自然出口：遇到了switch的结束}

②中断出口：遇到了break等



> 注意：
>
> （1）switch(表达式)的值的类型，只能是：4种基本数据类型（byte,short,int,char），两种引用数据类型（枚举、String）
>
> （2）case后面必须是常量值，而且不能重复



示例代码：

```java
int month = 4;
switch(month){
    case 3:
    case 4:
    case 5:
        System.out.println("春季");
        break;
    case 6:
    case 7:
    case 8:
        System.out.println("夏季");
        break;
    case 9:
    case 10:
    case 11:
        System.out.println("秋季");
        break;
    case 12:
    case 1:
    case 2:
        System.out.println("冬季");
        break;
    default:
        System.out.println("输入有误！");
}
```

## 3.3 循环结构

循环结构：

​	“重复”执行某些代码

循环结构的分类：

1、for循环

2、while循环

3、do...while循环

### 3.3.1 for循环

语法格式：

```java
for(;;){
    循环体语句块；
    if(条件表达式){
    	break;
    }
}
for(初始化表达式; 循环条件; 迭代表达式){
    循环体语句块；（需要重复执行的代码）
}
```

执行过程：

（1）初始化表达式;

（2）判断循环条件;

（3）如果循环条件成立，先执行循环体语句块；然后执行迭代表达式，再回到（2）...

（4）如果循环条件不成立，会结束for；

​         或者在当前循环中遇到break语句，也会结束当前for循环;

> 注意：
>
> （1）for(;;)中的两个；是不能多也不能少
>
> （2）循环条件必须是boolean类型



示例代码：

```java
//遍历1-100之间的偶数
for(int i=1; i<=100; i++){//每次循环的步幅是1
    if(i%2==0){
        System.out.println(i);
    }
}

//遍历1-100之间的偶数
for(int i=2; i<=100; i+=2){//每次循环的步幅是2
    System.out.println(i);
}
```



### 3.3.2 while循环

语法格式：

```java
while(循环条件){
    循环体语句块;
}

经典的形式：
while(true){
	循环体语句块;
    if(条件表达式){
    	break;
    }
}
```

执行过程：

（1）先判断循环条件

（2）如果循环条件成立，就执行循环体语句块；然后回到（1）

（3）如果循环条件不成立，就结束while循环；

​	 如果在循环体语句块中，遇到break，也会结束while循环；

> 注意：
>
> （1）while(循环条件)中循环条件必须是boolean类型



示例代码：

```java
//遍历1-100之间的偶数
int num = 2;
while(num<=100){
    System.out.println(num);
    num+=2;
}
```



### 3.3.3 do...while循环

语法格式：

```java
do{
    循环体语句块;
}while(循环条件);
```

执行过程：

（1）先执行一次循环体语句块；

（2）判断循环条件

（3）如果循环条件成立，再次执行循环体语句块；然后回到（2）...

（4）如果循环条件不成立，就结束do...while循环；

​         如果在循环体语句块中，遇到break，也会结束do...while循环；

> 注意：
>
> （1）while(循环条件)中循环条件必须是boolean类型
>
> （2）do{}while();最后有一个分号
>
> （3）do...while结构的循环体语句是至少会执行一次，这个和for和while是不一样的



示例代码：

```java
//从键盘输入整数，统计正数、负数的个数，输入0结束
java.util.Scanner input = new java.util.Scanner(System.in);

int num;
int positive = 0;
int negative = 0;
do{
    System.out.print("请输入整数（0结束）：");
    num = input.nextInt();
    
    if(num > 0){
        positive++;
    }else if(num < 0){
        negatvie++;
    }
}while(num!=0);

System.out.println("正数的个数：" + positive);
System.out.println("负数的个数：" + negatvie);
```

### 3.3.4 三种循环的选择

原则：三种循环之间是可以互相转换的，都能实现循环的功能

建议（习惯上）：当我们次数比较明显的时候，或者说从几循环到几的时候，一般先考虑for；

​				当循环体语句块至少要执行一次的时候，一般先考虑do...while；

​			        当循环条件比较明显，但是次数不明显，循环体语句块也不是至少执行一次，那么可以考虑while结构；



三种循环结构都具有四要素：

（1）循环变量的初始化表达式

（2）循环条件

（3）循环变量的修改的迭代表达式

（4）循环体语句块



### 3.3.5 跳转语句

1、break

用于：

（1）switch结构

作用：结束switch结构

（2）循环结构

作用：结束**当前**循环

2、continue 

用于：

只能用于循环结构

作用：提前结束本次循环，继续下一次循环

3、return（后面讲）



# 第四章 数组

## 4.1 数组的相关概念和名词（了解）

1、数组(array)：

​	一组具有相同数据类型的数据的按照一定顺序排列的集合。

​       把有限的几个相同类型的变量使用一个名称来进行统一管理。

2、数组名：

​	（1）这个数组名，代表的是一组数

​	（2）这个数组名中存储的整个数组的“首地址”

3、下标(index)：

​	我们使用编号、索引、下标来区别表示一组数当中某一个。

​	范围：[0,数组长度-1]     

​	例如：for(int i = 0;  i<arr.length; i++){}

4、元素(element)：

​	这一组中的的每一个数据都是元素。

​	如何表示数组元素？  数组名[下标]

5、数组的长度(length)

​	数组中元素的总个数。

​	如何获取数组长度？  数组名.length

> 注意：名称是为了沟通的方便，概念不用一字不落背下来

## 4.2 数组的相关语法

### 4.2.1 数组的声明

语法格式：

```java
 //推荐
元素的数据类型[] 数组名;

 //也对，但是不推荐
元素的数据类型  数组名[];
```

示例：

```java
//要存储一组整数
int[] array;

//要存储一组单字符
char[] array;

//要存储一组字符串
String[] array;
```

### 4.2.2 数组的初始化

初始化的目的：（1）确定数组的长度（2）为元素赋值

两种初始化方式：

1、动态初始化

语法格式：

```java
//指定数组长度
数组名 = new 元素的数据类型[长度];

//为元素赋值
数组名[下标] = 值; //这个值可以是个常量值，也可以是个表达式的计算结果，也可以是键盘输入的

//如果每个元素的赋值比较有规律，通常使用for循环赋值
for(int i=0; i<长度; i++){
    数组名[下标] = 值;
}
```

> 问：如果只指定数组长度，没有为元素手动赋值，那么元素有值吗？
>
> 有默认值
>
> （1）基本数据类型
>
> ​	byte,short,int,long：0
>
> ​	float,double：0.0
>
> ​	char：\u0000
>
> ​	boolean：false
>
> （2）引用数据类型
>
> ​	统统都是null



2、静态初始化

语法格式：

```java
数组名 = new 元素的数据类型[]{值列表};

//int[] arr = new int[5]{1,2,3,4,5};//错误的

//更简洁
//当声明与静态初始化一起完成时，可以简化
元素的数据类型[] 数组名 = {值列表};
```

适用场合：

​	当数组的元素是已知的有限个时，可以使用静态初始化。

示例代码：

```java
String[] weeks = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};

int[] daysOfMonths = {31,28,31,30,31,30,31,31,30,31,30,31};

char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
```



### 4.2.3 数组的遍历

for循环遍历数组：

```java
for(int i=0; i<数组名.lenght; i++){
    //或赋值
    数组名[i] = 值;
    //或显示
    System.out.println(数组名[i])；
    //或其他操作
    //例如：判断是否是偶数
    if(数组名[i]%2==0){
          //...
    }
}
```



### 4.2.4 数组的内存分析

元素是基本数据类型的一维数组内存分析：

```
int[] arr = {1,2,3,4,5};
```

![1558400311779](imgs/1558400311779.png)

```java
int[] arr = new int[5];
for(int i=0; i<arr.length; i++){
    arr[i] = i+1;
}
```

![1558400323314](imgs/1558400323314.png)



## 4.3 数组的相关算法

数组的算法：
1、找最值
2、找最值及其下标
3、统计：累加和、平均值等
4、反转
5、复制
6、查找：在数组中，查找某个值是否存在，或者查找某个值的下标
（1）数组中的元素是无序的(顺序查找)
（2）数组中的元素是有序的(二分查找)

复习下数组的

```java
public class Test01_Review{
    public static void main(String[] args){
        //推荐
        int[] arr1;//在Java中int[]是一种引用数据类型，是数组类型
        //也对，但是不推荐
        int arr2[];
        //最早的时候，C语言不提对象的概念，所以没有把int[]看成一种数据类型，
        //只是强调一组数，而最重要的是这组数据的类型是int类型

        //int[] arr = new int[5]{1,2,3,4,5};//错误的

        int[] arr = new int[5];
        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(System.identityHashCode(arr));

        int[] arr3 = new int[5];
//        arr3 = new int[5]{1, 2, 3, 4, 5};//错误的
        arr3 = new int[]{1, 2, 3, 4, 5};
        System.out.println(System.identityHashCode(arr3));

        int[] arr4 = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr4.length ; i++) {
            System.out.println(arr4[i]);
        }
    }
}
```



### 4.3.1 数组找最值

1、数组中找最值

思路：

（1）先假设第一个元素最大/最小

（2）然后用max/min与后面的元素一一比较

数组中找最值  

先假设第一个元素最大/最小

然后用max/min与后面的元素一一比较

eg 示例代码：

```java
int[] arr = {1, 2, 3, 4, 5};
//找最大值
int max = arr[0];
//遍历 比较  max
for(int i=1; i<arr.length; i++){
    if(arr[i] > max){
        max = arr[i];
    }
}
```

2、数组中找最值及其下标

情况一：找最值及其第一次出现的下标

思路：

（1）先假设第一个元素最大/最小

（2）然后用max/min与后面的元素一一比较

找最值及其第一次出现的下标

示例代码：

```java
int[] arr = {1, 2, 3, 4, 5};
//找最大值
int max = arr[0];
int index = 0;
//遍历 比较 max
for(int i=1; i<arr.length; i++){
    if(arr[i] > max){
        max = arr[i];
        index = i;
    }
}
```

或

```java
int[] arr = {1, 2, 3, 4, 5};
//找最大值
int maxIndex = 0;
for(int i=1; i<arr.length; i++){
    if(arr[i] > arr[maxIndex]){
        maxIndex = i;
    }
}
System.out.println("最大值：" + arr[maxIndex]);
```

找最大值的数组索引，数组索引下标获取最大值。

情况二：找最值及其所有最值的下标（即可能最大值重复）

可能重复  我可以这样 先找到最大值   再去遍历一遍数组看是否有与最大值相等的值拿出来

思路：

（1）先找最大值

①假设第一个元素最大

②用max与后面的元素一一比较

（2）遍历数组，看哪些元素和最大值是一样的

示例代码：

```java
int[] arr = {4,5,6,1,9};
//找最大值
int max = arr[0];
for(int i=1; i<arr.length; i++){
    if(arr[i] > max){
        max = arr[i];
    }
}

//遍历数组，看哪些元素和最大值是一样的
for(int i=0; i<arr.length; i++){
    if(max == arr[i]){
        System.out.print(i+"\t");
    }
}
```



### 4.3.2 数组统计：求总和、均值、统计偶数个数等

数组统计 求总和 均值 统计偶数个数

思路：遍历数组，挨个的累加，判断每一个元素

示例代码：求总和、均值

```java
int[] arr = {4,5,6,1,9};
//求总和、均值
int sum = 0;//因为0加上任何数都不影响结果，默认为0一波
for(int i=0; i<arr.length; i++){
    sum += arr[i];
}
double avg = (double)sum/arr.length;
```

示例代码2：

数组的元素累积  

```java
int[] arr = {4,5,6,1,9};

//求总乘积
long result = 1;//因为1乘以任何数都不影响结果
for(int i=0; i<arr.length; i++){
    result *= arr[i];
}
```

累积    阶乘

```java
int n = 5;
 
//求总乘积
long result = 1;//因为1乘以任何数都不影响结果
for(int i=1; i <= n; i++){
     result *= n;
}
//result 为n的阶乘
```



示例代码3：求偶数个数

```java
int[] arr = {4,5,6,1,9};
//统计偶数个数
int even = 0;
for(int i=0; i<arr.length; i++){
    if(arr[i]%2==0){
        even++;
    }
}
```



### 4.3.3 反转

方法有两种：

1、借助一个新数组

2、首尾对应位置交换

第一种方式示例代码：借助一个新的数组  反转

```java
int[] arr = {1,2,3,4,5,6,7,8,9};

//(1)先创建一个新数组
int[] newArr = new int[arr.length];

//(2)复制元素
int len = arr.length;
for(int i=0; i<newArr.length; i++){
    newArr[i] = arr[len -1 - i];//-1 数组的下标
}

//(3)舍弃旧的，让arr指向新数组
arr = newArr;//这里把新数组的首地址赋值给了arr

//(4)遍历显示
for(int i=0; i<arr.length; i++){
    System.out.println(arr[i]);
}
```

第二种方式示例代码：首尾对应位置交换

```java
int[] arr = {1,2,3,4,5,6,7,8,9};

//(1)计算要交换的次数：  次数 = arr.length/2
//(2)首尾交换
for(int i=0; i<arr.length/2; i++){//循环的次数就是交换的次数
    //首  与  尾交换
    int temp = arr[i];
    arr[i] = arr[arr.length-1-i];
	arr[arr.length-1-i] = temp;
}

//（3）遍历显示
for(int i=0; i<arr.length; i++){
    System.out.println(arr[i]);
}
```

### 4.3.4 复制

应用场景：

1、扩容

2、备份

3、截取

示例代码：扩容

```java
int[] arr = {1,2,3,4,5,6,7,8,9};

//如果要把arr数组扩容，增加1个位置
//(1)先创建一个新数组，它的长度 = 旧数组的长度+1
int[] newArr = new int[arr.length + 1];

//(2)复制元素
//注意：i<arr.length   因位arr比newArr短，避免下标越界
for(int i=0; i<arr.length; i++){
    newArr[i] = arr[i];
}

//(3)把新元素添加到newArr的最后
newArr[newArr.length-1] = 新值;

//(4)如果下面继续使用arr，可以让arr指向新数组
arr = newArr;

//(4)遍历显示
for(int i=0; i<arr.length; i++){
    System.out.println(arr[i]);
}
```

示例代码：备份

备份一个数组 创建一个新的数组进行复制就可以了 

扩容

```java
int[] arr = {1,2,3,4,5,6,7,8,9};

//1、创建一个长度和原来的数组一样的新数组
int[] newArr = new int[arr.length];

//2、复制元素
for(int i=0; i<arr.length; i++){
    newArr[i] = arr[i];
}

//3、遍历显示
for(int i=0; i<arr.length; i++){
    System.out.println(arr[i]);
}
```

示例代码：截取

截取是拿一部分   截取 

```java
int[] arr = {1,2,3,4,5,6,7,8,9};

int start = 2;
int end = 5;

//1、创建一个新数组，新数组的长度 = end-start + 1;
int[] newArr = new int[end-start+1];

//2、赋值元素
for(int i=0; i<newArr.length; i++){
    newArr[i] = arr[start + i];
}

//3、遍历显示
for(int i=0; i<newArr.length; i++){
    System.out.println(newArr[i]);
}
```

### 4.3.5 查找

查找 顺序查找 二分查找

查找分为两种：

1、顺序查找：挨个看

​	对数组没要求

2、二分查找：对折对折再对折  

​	对数组有要求，元素必须有大小顺序的

查找 顺序查找 对数据没有要求 二分查找 对数组有要求 元素必须有大小顺序的

 

顺序查找示例代码：

```java
int[] arr = {4,5,6,1,9};
int value = 1;
int index = -1;

for(int i=0; i<arr.length; i++){
    if(arr[i] == value){
        index = i;
        break;
    }
}

if(index==-1){
    System.out.println(value + "不存在");
}else{
    System.out.println(value + "的下标是" + index);
}
```

二分查找示例代码：

```java
/*
2、编写代码，使用二分查找法在数组中查找 int value = 2;是否存在，如果存在显示下标，不存在显示不存在。
已知数组：int[] arr = {1,2,3,4,5,6,7,8,9,10};
*/
class Exam2{
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9,10};//数组是有序的
		int value = 2;
		
        int index = -1;
		int left = 0;
        int right = arr.length - 1;
        int mid = (left + right)/2;
        while(left<=right){
            //找到结束
            if(value == arr[mid]){
                index = mid;
                break;
            }//没找到
            else if(value > arr[mid]){//往右继续查找
                //移动左边界，使得mid往右移动
                left = mid + 1;
            }else if(value < arr[mid]){//往左边继续查找
                right = mid - 1;
            }
            
            mid = (left + right)/2;
        }
        
        if(index==-1){
    		System.out.println(value + "不存在");
		}else{
    		System.out.println(value + "的下标是" + index);
		}
        
	}
}
```

使用for

```java
class Exam2{
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9};//数组是有序的
		int value = 2;
		
        int index = -1;
        
        for(int left=0,right=arr.length-1,mid = (left+right)/2; left<=right; mid = (left + right)/2){
             //找到结束
            if(value == arr[mid]){
                index = mid;
                break;
            }//没找到
            else if(value > arr[mid]){//往右继续查找
                //移动左边界，使得mid往右移动
                left = mid + 1;
            }else if(value < arr[mid]){//往左边继续查找
                right = mid - 1;
            }
        }
        
		
        
        if(index==-1){
    		System.out.println(value + "不存在");
		}else{
    		System.out.println(value + "的下标是" + index);
		}
        
	}
}
```



### 4.3.6 排序





foundation 基础

数组的排序算法有千万种，我这里先写个两种：

1、冒泡排序

2、简单的直接排序

示例代码：冒泡：从小到大，从左到右两两比较

从小到大 从左到右两两比较

```java
int[] arr = {5,4,6,3,1};
for(int i=1; i<arr.length; i++){//外循环的次数 = 轮数 = 数组的长度-1
    /*
    第1轮，i=1,从左到右两两比较，arr[0]与arr[1]。。。。。arr[3]与arr[4]
    第2轮，i=2,从左到右两两比较，arr[0]与arr[1]。。。。。arr[2]与arr[3]
    ...
    				arr[j]与arr[j+1]比较
    找两个关键点：（1）j的起始值：0（2）找j的终止值，依次是3,2,1,0，得出j<arr.length-i
    */
    for(int j=0; j<arr.length-i; j++){
        //两两比较
        //从小到大，说明前面的比后面的大，就交换
        if(arr[j] > arr[j+1]){
            int temp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = temp;
        }
    }
}
```

示例代码：从大到小，从右到左

```java
char[] arr = {'h','e','l','l','o','j','a','v','a'};
for(int i=1; i<arr.length; i++){//外循环的次数 = 轮数 = 数组的长度-1
    /*
    第1轮，i=1，从右到左两两比较，arr[8]与arr[7]，arr[7]与arr[6]....arr[1]与arr[0]
    第2轮，i=2，从右到左两两比较，arr[8]与arr[7]，arr[7]与arr[6]....arr[2]与arr[1]
    ...
    第8轮，i=8，从右到左两两比较，arr[8]与arr[7]
    		   arr[j]与arr[j-1]
    找两个关键点：（1）j的起始值：8（2）找j的终止值，依次是1,2,3,。。。8，得出j>=i
    */
    for(int j=8; j>=i; j--){
        //从大到小，后面的元素 > 前面的元素，就交换
        if(arr[j]>arr[j-1]){
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
        }
    }
}	
		
```

示例代码：简单的直接选择排序

```java
int[] arr = {3,2,6,1,8};

for(int i=1; i<arr.length; i++){//外循环的次数 = 轮数 = 数组的长度-1
    //（1）找出本轮未排序元素中的最值
    /*
    未排序元素：
    第1轮：i=1,未排序，[0,4]
    第2轮：i=2,未排序，[1,4]
    ...
    
    每一轮未排序元素的起始下标：0,1,2,3，正好是i-1的
    未排序的后面的元素依次：
    第1轮：[1,4]  j=1,2,3,4
    第2轮：[2,4]  j=2,3,4
    第3轮：[3,4]  j=3,4
    第4轮：[4,4]  j=4
    j的起点是i，终点都是4
    */
    int max = arr[i-1];
    int index = i-1;
    for(int j=i; j<arr.length; j++){
        if(arr[j] > max){
            max = arr[j];
            index = j;
        }
    }
    
    //（2）如果这个最值没有在它应该在的位置，就与这个位置的元素交换
    /*
    第1轮，最大值应该在[0]
    第2轮，最大值应该在[1]
    第3轮，最大值应该在[2]
    第4轮，最大值应该在[3]
    正好是i-1的值
    */
    if(index != i-1){
        //交换arr[i-1]与arr[index]
        int temp = arr[i-1];
        arr[i-1] = arr[index];
        arr[index] = temp;
    }
}



//显示结果
for(int i=0; i<arr.length; i++){
	System.out.print(arr[i]);
}
```

n-1躺  搞定最大 两两交换

## 4.4 二维数组

二维数组的标记：\[\]\[\]

### 4.4.1 相关的表示方式

（1）二维数组的长度/行数： 

​	二维数组名.length

（2）二维数组的其中一行：

​	二维数组名[行下标]

​	行下标的范围：[0, 二维数组名.length-1]

（3）每一行的列数：

​	二维数组名[行下标].length

​       因为二维数组的每一行是一个一维数组

（4）每一个元素

​	二维数组名\[行下标\]\[列下标\]

### 4.4.2 二维数组的声明和初始化

1、二维数组的声明

```java
  //推荐
  元素的数据类型[][] 二维数组的名称;

 //不推荐
 元素的数据类型  二维数组名[][];
 //不推荐
  元素的数据类型[]  二维数组名[];
```

面试：

```
int[] x, y[];
//x是一维数组，y是二维数组
```



2、二维数组的初始化

（1）静态初始化

```java
二维数组名 = new 元素的数据类型[][]{
			{第一行的值列表}, 
			{第二行的值列表},
			...
			{第n行的值列表}
		};
		
//如果声明与静态初始化一起完成
元素的数据类型[][] 二维数组的名称 = {
			{第一行的值列表}, 
			{第二行的值列表},
			...
			{第n行的值列表}
		};
```

（2）动态初始化（不规则：每一行的列数可能不一样）

```java
//（1）先确定总行数
二维数组名 = new 元素的数据类型[总行数][];

//（2）再确定每一行的列数
二维数组名[行下标] = new 元素的数据类型[该行的总列数];

//(3)再为元素赋值
二维数组名[行下标][列下标] = 值;
```

（3）动态初始化（规则：每一行的列数是相同的）

```java
//（1）确定行数和列数
二维数组名 = new 元素的数据类型[总行数][每一行的列数];

//（2）再为元素赋值
二维数组名[行下标][列下标] = 值;
```



### 4.4.3 二维数组的遍历

```
for(int i=0; i<二维数组名.length; i++){
    for(int j=0; j<二维数组名[i].length; j++){
        System.out.print(二维数组名[i][j]);
    }
    System.out.println();
}
```

# 第五章 面向对象基础



![image-20200516093207357](assets/image-20200516093207357.png)

比较吃力的



IO 线程 网络 反射 类加载

![image-20200516093831505](assets/image-20200516093831505.png)

static 静态的   静止的

字段是谁的  属于 本质 

【修饰符】 class 类名{
    成员列表：属性、方法、构造器、代码块、内部类

}

类变量  被static修饰的成员变量 比如Static String Home

类方法 



##5.1 类与对象

1、类：一类具有相同特性的事物的抽象描述。

​      对象：类的一个个体，实例，具体的存在。

​	  类是对象的设计模板。

类与对象

类：类是某一种事物的抽象，是一类具有相同特性的事物的抽象描述，是构造对象的模板或蓝图。

对象：对象是某个事物的一个具体的个体。

类是抽象的，对象(实例)是具体的。

2、如何声明类？

```java
【修饰符】 class 类名{
    成员列表：属性、方法、构造器、代码块、内部类
}
```

* 1、使用 class 关键字可以声明一个类 ，比如 public class Person
 * 2、一个类可以表示一类事物，在类中可以定义该类事物或其个体所具有的特征、行为 
 * 3、字段(field) 表示该类事物或其个体特征的变量
 * 4、方法(method) 表示该类事物或其个体可以完成动作、行为
 * 5、构造方法( constructor ) 是类中与类名同名但没有返回类型的方法

```java
public class Person{
    
}
```

Field 字段是我有什么 、Method方法是我能干什么

什么是字段 什么是方法 什么是构造 

3、如何创建对象？

```java
new 类名();  //匿名对象

类名 对象名 = new 类名(); //有名对象
```

匿名对象  有对象名的对象

匿名对象 有对象名的对象

## 5.2 类的成员之一：属性

1、如何声明属性？

```java
【修饰符】 class 类名{
    【修饰符】 数据类型  属性名;    //属性有默认值
    【修饰符】 数据类型  属性名 = 值; //属性有初始值
}
```

> 说明：属性的类型可以是Java的任意类型，包括基本数据类型、引用数据类型（类、接口、数组等）

对象中的数据称为实例域（instance field），操纵数据的过程称为方法（method）。

字段的类型 基础数据类型、引用数据类型（类、接口、数组等）

总结：Java的数据类型

（1）基本数据类型

byte,short,int,long,float,double,char,boolean布尔

byte short int long float double，char,boolean

（2）引用数据类型

①类：

​	例如：String、Student、Circle、System、Scanner、Math...

②接口：interface 

③数组：

​	例如：int[]，String[]，char[]，int\[\]\[\]

```java
int[] arr = new int[5];
这里把int[]看成数组类型，是一种引用数据类型，右边赋值的是一个数组的对象

元素的数据类型：int
数组的数据类型：int[]
```

元素的数据类型  数组的数据类型int[]



2、如何为属性赋值？

（1）在声明属性时显式赋值

```java
【修饰符】 class 类名{
    【修饰符】 数据类型  属性名 = 值; //属性有初始值
}
```

代码示例：

```java
class Student{
    String name;
    char gender = '男';//显式赋值
}

class TestStudent{
    public static void main(String[] args){
        Student s1 = new Student();
        System.out.println("姓名：" + s1.name);//null
        System.out.println("性别：" + s1.gender);//男
        
        s1.name = "小菜";//修改属性的默认值
        s1.gender = '女';//修改属性的初始值
        System.out.println("姓名：" + s1.name);//小菜
        System.out.println("性别：" + s1.gender);//女
        
        Student s2 = new Student();
        System.out.println("姓名：" + s2.name);//null
        System.out.println("性别：" + s2.gender);//男
    }
}
```

（2）创建对象之后赋值

```java
【修饰符】 class 类名{
    【修饰符】 数据类型  属性名; //属性有默认值
}

//创建对象
类名 对象名 = new  类名();

//为对象的属性赋值
对象名.属性名 = 值;
```

3、如何访问属性的值？

（1）在本类的方法中访问

示例代码：

```java
class Circle{
    double radius;
    
    double getArea(){
        return 3.14 * radius * radius;//直接访问
    }
}
```



（2）在其他类的方法中访问

```java
class Circle{
    double radius;
}

class TestCircle{
    public static void main(String[] args){
        Circle c1 = new Circle();
        double area = 3.14 * c1.radius * c1.radius;//对象名.属性名
    }
}
```

在其他类中访问不是本类数据的 

对象名.属性名  

4、属性的特点

（1）属性有默认值

基本数据类型：

​	byte,short,int,long：0

​	float，double：0.0

​	char：\u0000

​	boolean：false

引用数据类型：

​	null

是null呀

（2）每一个对象的属性是独立，互不干扰

每一个对象的属性是独立的，互不干扰的。你是你的

5、对象属性的内存图

```java
class Student{
    String name;
    char gender = '男';//显式赋值
}

class TestStudent{
    public static void main(String[] args){
        Student s1 = new Student();
        System.out.println("姓名：" + s1.name);//null
        System.out.println("性别：" + s1.gender);//男
        
        s1.name = "小菜";
        s1.gender = '女';
        System.out.println("姓名：" + s1.name);//小菜
        System.out.println("性别：" + s1.gender);//女
        
        Student s2 = new Student();
        System.out.println("姓名：" + s2.name);//null
        System.out.println("性别：" + s2.gender);//男
    }
}
```

![1558659534754](imgs/1558659534754.png)







## 5.4 类的成员之二：方法

类的成员-方法 

方法的概念 

方法的重载Overload

方法的参数传递机制

### 5.4.1 方法的概念

方法（method）：代表一个独立的可复用的功能

目的/好处：

（1）复用

（2）简化代码

方法代表一个独立的可复用的功能

目的/好处：复用、简化代码



### 5.4.2 方法的语法

方法在类中 

1、方法的声明格式：

```java
【修饰符】 class 类名{
    【修饰符】 返回值类型  方法名(【形参列表】){
        方法体：实现功能的代码
    }
}
```

说明：

（1）【修饰符】public、private等

（2）返回值类型：

①void：表示无返回值

②非void：所有的Java数据类型都可以

void 表示无返回值  非void所有的Java数据类型都可以

（3）方法名：能很好的体现方法的功能

方法名 能很好的体现方法的功能

命名的规范：①见名知意②从第二个单词开始首字母大写  aaaBbbCcc

看到名字知道意思 从二个单词开始收字母大写 xxxYyyZzz

（4）【形参列表】：

​	在完成这个方法的功能时，需要一些数据，这些数据要由“调用者”来决定，那我们就可以设计形参。

形参列表 传递一些数据 辅助功能的完成

​	语法格式：

​		()：无参，空参

​		(数据类型  形参名)：一个形参

​		(数据类型1  形参名1,  ......,   数据类型n  形参名n)：n个形参

（5）方法体：实现方法的功能，最好一个方法就完成一个独立的功能。

方法体 实现方法的功能 最好一个方法能完成一个独立的功能。

2、方法的调用格式：

```java
//本类同级别方法调用：直接调用
【变量 = 】 方法名(【实参列表】);
```

```java
//在其他类的方法中调用
【变量 = 】 对象名.方法名(【实参列表】);
```

（1）是否传实参

看被调用的方法是否有形参

（2）是否接收返回值

看被调用的方法是否是void，如果是void，就不需要也不能接收，如果不是void，就可以接收。

接不接受

3、方法的声明与调用的代码示例

（1）无参无返回值方法

```java
//本类
class Circle{
    double radius;
    void printInfo(){
        System.out.println("半径：" + radius);
    }
    
    void test(){
        printInfo();//本类中调用无参无返回值方法
    }
}
```

```java
//其他类
class Circle{
    double radius;
    void printInfo(){
        System.out.println("半径：" + radius);
    }

}
class TestCircle{
    public static void main(String[] args){
        Circle c1 = new Circle();
        c1.printInfo(); //其他类中调用无参无返回值方法
    }
}
```



（2）无参有返回值方法

```java
//本类
class Circle{
    double radius;
    
    double getArea(){
        return 3.14 * radius * radius();
    }
    
    void printInfo(){
      //  System.out.println("半径：" + radius + "，面积：" + getArea());//本类中调用无参有返回值
       	double area = getArea();//本类中调用无参有返回值
        System.out.println("半径：" + radius + "，面积：" + area);
    }
}
```

```java
//其他类
class Circle{
    double radius;
    
    double getArea(){
        return 3.14 * radius * radius();
    }
}
class TestCircle{
    public static void main(String[] args){
        Circle c1 = new Circle();
        double area = c1.getArea();
        System.out.println("面积：" + area);
        //或
        System.out.println("面积：" + c1.getArea());
    }
}
```



（3）有参无返回值方法

```java
//本类
class GraphicTools{
    void printRectange(int line, int column, char sign){
        for(int i=1; i<=line; i++){
            for(int j=1; j<=column; j++){
                Sytem.out.print(sign);
            }
            System.out.println();
        }
    }
    
    void test(){
        printRectange(5,10,'%');//本类中调用有参无返回值方法
    }
}
```

```java
//其他类
class GraphicTools{
    void printRectange(int line, int column, char sign){
        for(int i=1; i<=line; i++){
            for(int j=1; j<=column; j++){
                Sytem.out.print(sign);
            }
            System.out.println();
        }
    }
}
class Test{
    public static void main(String[] args){
        GraphicTools tools = new GraphicTools();
        tools.printRectange(5,10,'%');
    }
}
```



（4）有参有返回值方法

```java
//本类
class MyMath{
    int sum(int a,int b){
        return a+b;
    }
    
    void print(){
        int x = 4;
        int y = 7;
        System.out.println(x + "+" + y + "=" + sum(x,y);//本类中调用有参有返回值的方法
    }
}
```

```java
//其他类
class MyMath{
    int sum(int a,int b){
        return a+b;
    }
}
class Test{
    public static void main(String[] args){
        MyMath my = new MyMath();
        int x = 4;
        int y = 7;
        
        System.out.println(x + "+" + y + "=" + my.sum(x,y));
    }
}
```



4、方法声明与调用的原则

（1）方法必须先声明后调用

> 如果调用方法时，如果方法名写错或调用一个不存在的方法，编译会报错

方法先声明后调用

（2）方法声明的位置必须在类中方法外

正确示例：

```java
类{
    方法1(){
        
    }
    方法2(){
        
    }
}
```

错误示例：

```java
类{
    方法1(){
        方法2(){  //错误
        
   		}
    }
}
```

（3）方法的调用的位置有要求

正确示例：

```java
类{
    方法1(){
        调用方法
    }
}
```

错误示例：

```java
类{
    方法1(){
        
    }
    
    调用方法  //错误位置
}
```

方法里面调用

（4）方法的调用格式要与方法的声明格式对应

①是否要加“对象.”：看是否在本类中，还是其他类中

②是否要接收返回值：看被调用方法是否是void

③是否要传实参：看被调用方法是有形参列表

### 5.4.3 方法的重载Overload

概念：在同一个类中，出现了两个或多个的方法，它们的方法名称相同，形参列表不同，这样的形式称为方法的重载。和返回值类型无关。

方法的重载是方法名称相同，但形参列表不同，这样的形式称为方法的重载，和返回值类型无关。



示例代码：

```java
	//求两个整数的最大值
public int max(int a,int b){
    return a>b?a:b;
}
	
	//求三个整数的最大值
public int max(int a, int b, int c){
    return max(max(a,b),c);
}
	
	//求两个小数的最大值
public double max(double a, double b){
    return a>b?a:b;
}

```

max(int a, int b)

max(int a,int b, int c)

### 5.4.4 方法的参数传递机制

Java中方法的参数传递机制：值传递

（1）形参是基本数据类型时，实参给形参传递数据值，是copy的形式，形参对值的修改不影响实参。
（2）形参是引用数据类型时，实参给形参传递地址值，形参对对象的属性的修改，会影响实参对象的属性值，因为此时形参和实参就是指向同一个对象

基础数据类型 不影响实参

引用数据类型 传递地址值

示例代码：

```java
class Test{
    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
	}

	public static void main（String[] args){
        int x = 1;
        int y = 2;
        swap(x,y);//调用完之后，x与y的值不变
    }
}

```

示例代码：

```java
class Test{
    public static void change(MyData my){
        my.num *= 2;
    }
    
    public static void main(String[] args){
        MyData m = new MyData();
        m.num = 1;
        
        change(m);//调用完之后，m对象的num属性值就变为2
    }
}

class MyData{
    int num;
}
```

陷阱1：

```java
/*
陷阱1：在方法中，形参 = 新new对象，那么就和实参无关了
*/
class Test{
    public static void change(MyData my){
        my = new MyData();//形参指向了新对象
        my.num *= 2;
    }
    
    public static void main(String[] args){
        MyData m = new MyData();
        m.num = 1;
        
        change(m);//调用完之后，m对象的num属性值仍然为1
    }
}

class MyData{
    int num;
}
```

陷阱2：见字符串和包装类部分

字符串  包装类 



## 5.3 对象数组

一维数组：

1、元素是基本数据类型

2、元素是引用数据类型，也称为对象数组，即数组的元素是对象

> 注意：对象数组，首先要创建数组对象本身，即确定数组的长度，然后再创建每一个元素对象，如果不创建，数组的元素的默认值就是null，所以很容易出现空指针异常NullPointerException。

示例代码：

```java
class MyDate{
	int year;
	int month;
	int day;
}
class Test{
    public static void main(String[] args){
        MyDate[] arr = new MyDate[3];//创建数组对象本身，指定数组的长度
        
        for(int i=0; i<arr.length; i++){
            arr[i] = new MyDate();//每一个元素要创建对象
            arr[i].year = 1990 + i;
            arr[i].month = 1 + i;
            arr[i].day = 1 + i;
        }
    }
}

```

对象数组的内存图：

![1558745138315](imgs/1558745138315.png)

# 第六章 面向对象的基本特征

面向对象的基本特征：

1、封装

2、继承

3、多态

抽象  封装 继承  多态 

## 6.1 封装

啥是封装

封装指的是将对象的状态信息隐藏在对象内部，不允许外部程序直接访问对象内部信息，而是通过该类所提供的方法来实现对内部信息的操作和访问。

1、好处：

（1）隐藏实现细节，方便使用者使用

（2）安全，可以控制可见范围

隐藏实现细节 方便使用者使用

安全 可以控制可见范围

2、如何实现封装？

通过权限修饰符

public default 缺省的  protected public 

> 面试题：请按照可见范围从小到大（从大到小）列出权限修饰符？

| 修饰符    | 本类 | 本包 | 其他包的子类 | 任意位置 |
| --------- | ---- | ---- | ------------ | -------- |
| private   | √    | ×    | ×            | ×        |
| 缺省      | √    | √    | ×            | ×        |
| protected | √    | √    | √            | ×        |
| public    | √    | √    | √            | √        |

缺省的  package-private（包私有的） 包内部可以访问的

权限修饰符可以修饰什么？

类（类、接口等）、属性、方法、构造器、内部类

类 接口 属性 方法 构造器 内部类

类（外部类）：public和缺省

类（外部类）可以用权限修饰符 public 缺省（不写的）来修饰

属性、方法、构造器、内部类 可以用private、缺省、protected、public来修饰的

属性：4种

方法：4种

构造器：4种

内部类：4种



3、通常属性的封装是什么样的？

当然属性的权限修饰符可以是private、缺省、protected、public。但是我们大多数时候，见到的都是private，然后给它们配上get/set方法。

private来修饰属性 

示例代码：标准Javabean的写法

```java
public class Student{
    //属性私有化
    private String name;
    private int age;
    private boolean marry;
    
    //公共的get/set
    public void setName(String n){
        name = n;//这里因为还没有学习this等，可能还会优化
        //this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int a){
        age = a;
    }
    public int getAge(){
        return age;
    }
    public void setMarry(boolean m){
        marry = m;
    }
    public boolean isMarry(){//boolean类型的属性的get方法，习惯使用把get换成is
        return marry;
    }
}
```

## 6.2 构造器

构造方法

构造器最大的用处就是在创建对象时执行初始化。当创建一个对象时，系统为这个对象的实例变量进行默认初始化，这种默认的初始化把所有基本类型的实例变量设为0（对数值型实例变量）浮点型 0.0或false（对布尔型实例变量），把所有引用类型的实例变量设为null。如果想改变这种默认的初始化，想让系统创建对象时就为该对象的实例变量显式指定初始值，就可以通过构造器来实现。默认值 初始值 

构造器  创建对象时执行初始化 

显示指定初始值 

1、构造器的作用：
（1）和new一起使用创建对象

```java
//调用无参构造创建对象
类名 对象名 = new 类名();

//调用有参构造创建对象
类名 对象名 = new 类名(实参列表);
```

（2）可以在创建对象的同时为属性赋值

```java
public class Circle{
    private double radius;
    
    public Circle(){
        
    }
    public Circle(double r){
        radius = r;//为radius赋值
    }
}
```



2、声明构造器的语法格式：

```java
【修饰符】 class 类名{
    【修饰符】 类名(){//无参构造
        
    }
    【修饰符】 类名(形参列表){//有参构造
        
    }
}
```



3、构造器的特点：

（1）所有的类都有构造器

（2）如果一个类没有显式/明确的声明一个构造器，那么编译器将会自动添加一个默认的无参构造

有一个默认的无参构造

（3）如果一个类显式/明确的声明了构造器，那么编译器将不再自动添加默认的无参构造，如果需要，那么就需要手动添加

有，不会添加默认的无参构造，需要，可以手动添加。

（4）构造器的名称必须与类名相同

（5）构造器没有返回值类型

（6）构造器可以重载



示例代码：

```java
public class Circle{
    private double radius;
    
    public Circle(){
        
    }
    public Circle(double r){
        radius = r;//为radius赋值
    }
}
```



## 6.3 关键字this



Java提供了一个this关键字，this关键字总是指向调用该方法的对象。

1、this关键字：

意思：当前对象

（1）如果出现在构造器中：表示正在创建的对象

（2）如果出现在成员方法中：表示正在调用这个方法的对象



2、this的用法：

（1）this.属性

当局部变量与成员变量同名时，那么可以在成员变量的而前面加“this.”用于区别

（2）this.方法

调用当前对象的成员方法，完全可以省略“this.”

（3）this()或this(实参列表)

this()表示调用本类的无参构造

this(实参列表)表示调用本类的有参构造

> this()或this(实参列表)要么没有，要么必须出现在构造器的首行

示例代码：

```java
public class Student{
    private String name;
    private int score;
    
    public Student(){
        
    }
    public Student(String name){
        this.name = name;
    }
    public Student(String name, int score){
        this(name);
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }
}
```



3、成员变量与局部变量的区别？

这里只讨论实例变量（关于类变量见static部分）

（1）声明的位置不同

成员变量：类中方法外

局部变量：方法中或代码中

​	①方法的形参列表

​	②方法体中局部变量

​	③代码块中的局部变量

（2）运行时在内存中的存储位置不同

成员变量：堆

局部变量：栈

> 基本数据类型的变量在栈中，引用数据类型的变量在堆中：不准确

（3）修饰符

成员变量：有很多修饰符，例如：权限修饰符

局部变量：不能加权限修饰符，唯一的能加的是final

（4）初始化

成员变量：有默认值

局部变量：没有默认值，必须手动初始化

（5）生命周期

成员变量：随着对象的创建而创建，随着对象被回收而消亡，即与对象同生共死。每一个对象都是独立的。

局部变量：方法调用时才分配，方法运行结束就没有了。每一次方法调用，都是独立的

## 6.4 包

1、包的作用：

（1）可以避免类重名

有了包之后，类的全名称就变为：包.类名

（2）分类组织管理众多的类

例如：java.lang包，java.util包，java.io包.....

（3）可以控制某些类型或成员的可见范围

如果某个类型或者成员的权限修饰缺省的话，那么就仅限于本包使用

本包使用

2、声明包的语法格式：

```java
package 包名;
```

> 注意：
>
> (1)必须在源文件的代码首行
>
> (2)一个源文件只能有一个



3、包的命名规范和习惯：
（1）所有单词都小写，每一个单词之间使用.分割
（2）习惯用公司的域名倒置

例如：com.awen.xxx;

top.liuawen.xxx

> 建议大家取包名时不要使用“java.xx"包



4、使用其他包的类：

前提：被使用的类或成员的权限修饰符是>缺省的

（1）使用类型的全名称

例如：java.util.Scanner input = new java.util.Scanner(System.in);

（2）使用import 语句之后，代码中使用简名称



5、import语句

```java
import 包.类名;
import 包.*;
```

> 注意：当使用两个不同包的同名类时，例如：java.util.Date和java.sql.Date。
>
> 一个使用全名称，一个使用简名称



示例代码：

```java
package com.awen.test;

import java.util.Scanner;

public class Test{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
    }
}
```



## 6.5 eclipse的使用

1、eclipse管理项目和代码的结构

workspace --> project --> 包-->类...

一个工作空间可以有多个项目。



2、快捷键

常规快捷键：

Ctrl + S：保存

Ctrl + C：复制

Ctrl + V：粘贴

Ctrl + X：剪切

Ctrl + Y：反撤销

Ctrl + Z：撤销

Ctrl + A：全选



eclipse中默认的快捷键：

Ctrl + 1：快速修复

Alt + /：代码提示

Alt + ?：  Alt + Shift + /   方法的形参列表提示

Ctrl + D：删除选中行

Ctrl + Alt + ↓：向下复制行

Ctrl + Alt + ↑：向上复制行

Alt + ↓：与下面的行交换位置

Alt + ↑：与下面的行交换位置

Ctrl + Shift + F：快速格式

Ctrl + /：单行注释，再按一次取消

Ctrl + Shift + /：多行注释

Ctrl + Shift +\：取消多行注释

Shift + 回车：在光标下一行插入新航开始编辑

Ctrl + Shift + 回车：在光标上一行插入新航开始编辑

Alt + Shift + A：多行编辑     再按一次退出多行编辑模式

Alt + Shift + S：弹出自动生成代码的菜单选择，包括自动生成构造器、get/set、equals......

Ctrl + Shift + O：快速导包

Ctrl + Shift + T：打开某个类的源文件

Ctrl + O：打开某个类型的摘要outline



3、快速开发的代码模板

代码模板 + Alt + /

（1）main

public static void main(String[] args){

}

（2）sysout

System.out.println();



（3）for

for(int i=0; i<数组名.lenght; i++){

}



其他详细使用见《JavaSE_柴林燕_相关工具.docx》

## 6.6 面向对象的基本特征之二：继承

继承是面向对象的三大特征之一，也是实现软件复用的重要手段。Java的继承具有单继承的特点，每个子类只有一个直接父类。

软件复用 Java的继承具有单继承的特点 每个子类只有一个直接父类

1、为什么要继承？继承的好处？

（1）代码的复用

（2）代码的扩展

继承  复用、扩展



2、如何实现继承？

语法格式：

```java
【修饰符】 class 子类  extends 父类{
    
}
```

extends

3、继承的特点

Java的继承通过extends关键字来实现，实现继承的类被称为子类，被继承的类被称为父类，有的也称其为基类、超类。父类和子类的关系，是一种一般和特殊的关系。

（1）子类会继承父类的所有特征（属性、方法）

但是，私有的在子类中是不能直接使用的

（2）**子类不会继承父类的构造器**

因为，父类的构造器是用于创建父类的对象的

（3）子类的构造器中又必须去调用父类的构造器

在创建子类对象的同时，为从父类继承的属性进行初始化用，可以借助父类的构造器中的代码为属性赋值。

（4）Java只支持单继承：一个子类只能有一个“直接”父类

（5）Java又支持多层继承：父类还可以有父类，特征会代代相传

（6）一个父类可以同时拥有很多个子类

注意：子类只能从被扩展的父类获得成员变量、方法和内部类（包括内部接口、枚举），不能获得构造器和初始化块。

## 6.7 关键字super

如果需要在子类方法中调用父类被覆盖的实例方法，则可使用super限定来调用父类被覆盖的实例方法。

super关键字：引用父类的，找父类的xx

用法：

（1）super.属性

当子类声明了和父类同名的成员变量时，那么如果要表示某个成员变量是父类的，那么可以加“super.”

（2）super.方法

当子类重写了父类的方法，又需要在子类中调用父类被重写的方法，可以使用"super."

（3）super()或super(实参列表)

super()：表示调用父类的无参构造

super(实参列表)：表示调用父类的有参构造

> 注意：
>
> （1）如果要写super()或super(实参列表)，必须写在子类构造器的首行
>
> （2）如果子类的构造器中没有写：super()或super(实参列表)，那么默认会有 super()
>
> （3）如果父类没有无参构造，那么在子类的构造器的首行“必须”写super(实参列表)

## 6.8 方法的重写

1、方法的重写（Override）

大部分时候，子类总是以父类为基础，额外增加新的成员变量和方法。但当子类继承了父类的方法时，又觉得父类的方法体的实现不适合于子类，那么子类可以选择进行重写。



2、方法的重写的要求

（1）方法名：必须相同

（2）形参列表：必须相同

（3）修饰符

​	权限修饰符： >=

（4）返回值类型

​	如果是基本数据类型和void：必须相同

​	如果是引用数据类型：<=

​	在Java中我们认为，在概念范围上：子类 <父类

方法的重写要遵循“两同两小一大”规则，“两同”即方法名相同、形参列表相同；“两小”指的是子类方法返回值类型应比父类方法返回值类型更小或相等，子类方法声明抛出的异常类应比父类方法声明抛出的异常类更小或相等；“一大”指的是子类方法的访问权限应比父类方法的访问权限更大或相等。尤其需要指出的是，覆盖方法和被覆盖方法要么都是类方法，要么都是实例方法，不能一个是类方法，一个是实例方法。

3、重载（Overload）与重写（Override）的区别

​	重载（Overload）：在同一个类中，方法名相同，形参列表不同，和返回值类型无关的两个或多个方法。

​	重写（Override）：在父子类之间。对方法签名的要求见上面。

因为重载主要发生在同一个类的多个同名方法之间，而重写发生在子类和父类的同名方法之间。它们之间的联系很少，除二者都是发生在方法之间，并要求方法名相同之外，没有太大的相似之处。当然，父类方法和子类方法之间也可能发生重载，因为子类会获得父类方法，如果子类定义了一个与父类方法有相同的方法名，但参数列表不同的方法，就会形成父类方法和子类方法的重载。

特殊的重载：

```java
public class TestOverload {
	public static void main(String[] args) {
		B b = new B();
		//b对象可以调用几个a方法
		b.a();
		b.a("");//从b对象同时拥有两个方法名相同，形参不同的角度来说，算是重载
	}
}
class A{
	public void a(){
		//...
	}
}
class B extends A{
	public void a(String str){
		
	}
}
```

## 6.9 非静态代码块

1、语法格式

```java
【修饰符】 class 类名{
    {
        非静态代码块
    }
}
```

2、作用

目的：在创建的过程中，为对象属性赋值，协助完成实例初始化的过程



3、什么时候执行？

（1）每次创建对象时都会执行

（2）优先于构造器执行



## 6.10 实例初始化过程

1、概念描述

* 实例初始化过程：实例对象创建的过程

* 实例初始化方法：实例对象创建时要执行的方法

* 实例初始化方法的由来：它是有编译器编译生成的

* 实例初始化方法的形式：<init>()或<init>(形参列表)

* 实例初始化方法的构成：

  ①属性的显式赋值代码

  ②非静态代码块的代码

  ③构造器的代码

  > 其中
  >
  > ①和②按顺序执行，从上往下
  >
  > ③在①和②的后面

因此一个类有几个构造器，就有几个实例初始化方法。

2、单个类实例初始化方法

示例代码：

```java
class Demo{
	{
		System.out.println("非静态代码块1");
	}
	
	private String str = assign();//调用方法，来为str进行显式赋值
	
	public Demo(){
		System.out.println("无参构造");
	}
	public Demo(String str){
		this.str = str;
		System.out.println("有参构造");
	}
	
	{
		System.out.println("非静态代码块2");
	}
	
	public String assign(){
		System.out.println("assign方法");
		return "hello";
	}
}
```

图解：

![1558960549421](imgs/1558960549421.png)

3、父子类的实例初始化

注意：

（1）原先super()和super(实参列表)说是调用父类的构造器，现在就要纠正为调用父类的实例初始化方法了

（2）原先super()和super(实参列表)说是必须在子类构造器的首行，现在要纠正为必须在子类实例初始化方法的首行

结论：

（1）执行顺序是先父类实例初始化方法，再子类实例初始化方法

（2）如果子类重写了方法，通过子类对象调用，一定是执行重写过的方法

示例代码：

```java
class Ba{
	private String str = assign();
	{
		System.out.println("(1)父类的非静态代码块");
	}
	public Ba(){
		System.out.println("(2)父类的无参构造");
	}
	public String assign(){
		System.out.println("(3)父类的assign()");
		return "ba";
	}
}
class Er extends Ba{
	private String str = assign();
	{
		System.out.println("(4)子类的非静态代码块");
	}
	public Er(){
		//super()  ==>调用父类的实例初始化方法，而且它在子类实例初始化方法的首行
		System.out.println("(5)子类的无参构造");
	}
	
	public String assign(){
		System.out.println("(6)子类的assign()");
		return "er";
	}
}
class Test{
    public static void main(String[] args){
        new Er();//612645
    }
}
```

图解：

![1558961723911](imgs/1558961723911.png)

## 6.11 面向对象的基本特征之三：多态

Java引用变量有两个类型：一个是编译时类型，一个是运行时类型。编译时类型由声明该变量时使用的类型决定，运行时类型由实际赋给该变量的对象决定。如果编译时类型和运行时类型不一致，就可能出现所谓的多态（Polymorphism）。


1、多态：

语法格式：

```java
父类 引用/变量 = 子类的对象;
```

2、前提：

（1）继承

（2）方法的重写

（3）多态引用



3、现象：

​	编译时看左边/"父类"，运行时看右边/"子类"。

​	编译时，因为按父类编译，那么只能父类有的方法，子类扩展的方法是无法调用的；	

​	执行时一定是运行子类重写的过的方法体。

示例代码：

```java
class Person{
	public void eat(){
		System.out.println("吃饭");
	}
	public void walk(){
		System.out.println("走路");
	}
}
class Woman extends Person{
	public void eat(){
		System.out.println("细嚼慢咽的吃饭");
	}
	public void walk(){
		System.out.println("婀娜多姿走路");
	}
	public void shop(){
		System.out.println("买买买...");
	}
}
class Man extends Person{
	public void eat(){
		System.out.println("狼吞虎咽的吃饭");
	}
	public void walk(){
		System.out.println("大摇大摆的走路");
	}
	public void smoke(){
		System.out.println("吞云吐雾");
	}
}
class Test{
    public static void main(String[] args){
        Person p = new Woman();//多态引用
        p.eat();//执行子类重写
        p.walk();//执行子类重写
        //p.shop();//无法调用
    }
}
```



4、应用：

（1）多态参数：形参是父类，实参是子类对象

（2）多态数组：数组元素类型是父类，元素存储的是子类对象

示例代码：多态参数

```java
class Test{
    public static void main(String[] args){
        test(new Woman());//实参是子类对象
        test(new Man());//实参是子类对象
    }
    public static void test(Person p){//形参是父类类型
        p.eat();
        p.walk();
    }
}
```

示例代码：多态数组

```java
class Test{
    public static void main(String[] args){
        Person[] arr = new Person[2];//多态数组
        arr[0] = new Woman();
        arr[1] = new Man();
        
        for(int i=0; i<arr.length; i++){
            all[i].eat();
            all[i].walk();
        }
    }
}
```



5、向上转型与向下转型：父子类之间的转换

（1）向上转型：自动类型转换

​	当把子类的对象赋值给父类的变量时（即多态引用时），在编译时，这个对象就向上转型为父类。此时就看不见子类“特有、扩展”的方法。

（2）向下转型：强制转换。有风险，可能会报ClassCastException异常。

​	当需要把父类的变量赋值给一个子类的变量时，就需要向下转型。

​	**要想转型成功，必须保证该变量中保存的对象的运行时类型是<=强转的类型**

示例代码：

```java
class Person{
	//方法代码省略...
}
class Woman extends Person{
    //方法代码省略...
}
class ChineseWoman extends Woman{
	//方法代码省略...
}
```

```java
 public class Test{
     public static void main(String[] args){
		//向上转型
		Person p1 = new Woman();
		//向下转型
		Woman m = (Woman)p1; 
		//p1变量中实际存储的对象就是Woman类型，和强转的Woman类型一样

		//向上转型
		Person p2 = new ChineseWoman();
		//向下转型
		Woman w2 = (Woman) p2; 
		//p2变量中实际存储的对象是ChineseWoman类型，强制的类型是Woman，ChineseWoman<Woman类型     
     }
 }
```

6、instanceof

表达式语法格式：

```java
对象/变量  instanceof  类型
```

运算结果：true 或 false

作用：

用来判断这个对象是否属于这个类型，或者说，是否是这个类型的对象或这个类型子类的对象



示例代码：

```java
class Person{
	//方法代码省略...
}
class Woman extends Person{
    //方法代码省略...
}
class ChineseWoman extends Woman{
	//方法代码省略...
}
```

```java
 public class Test{
     public static void main(String[] args){
         Person p = new Person();
         Woman w = new Woman();
         ChineseWoman c = new ChineseWoman();
         
         if(p instanceof Woman){//false
             
         }
         if(w instanceof Woman){//true
             
         }
         if(c instanceof Woman){//true
             
         }
     }
 }
```



# 第七章 面向对象的高级特性

提交要有格式来提交的  OOP-高级特性

修饰符的学习围绕三个问题：

（1）单词的意思

（2）可以修饰什么？

（3）用它修饰后有什么不同？

单词的意思

可以修饰什么

用它修饰后有什么不同？



## 7.1 关键字：final

final：最终的

用法：

（1）修饰类（包括外部类、内部类类）

表示这个类不能被继承，没有子类

修饰类 外部类 内部类 

表示这个类不能被继承，没有子类

（2）修饰方法

表示这个方法不能被重写

方法不能被重写

（3）修饰变量（成员变量（类变量、实例变量），局部变量）

表示这个变量的值不能被修改

值不能被修改 

注意：如果某个成员变量用final修饰后，也得手动赋值，而且这个值一旦赋完，就不能修改了，即没有set方法

我们手动赋值 赋值完了就不能修改了 没有set方法 修改

我们可以获取这个值 

## 7.2 关键字：native

native：本地的，原生的
用法：

​	只能修饰方法

​	表示这个方法的方法体代码不是用Java语言实现的。

​	但是对于Java程序员来说，可以当做Java的方法一样去正常调用它，或者子类重写它。

只能修饰方法 表示这个方法的方法体代码不是用Java语言实现

JVM内存的管理：

![image-20200518152504785](assets/image-20200518152504785.png)





![](imgs/1555119319865.png)

方法区：类的信息、常量、静态变量、动态编译生成的字节码信息

虚拟机栈：Java语言实现的方法的局部变量

本地方法栈：非Java语言实现的方法的局部变量，即native方法执行时的内存区域

堆：new出来的对象

程序计数器：记录每一个线程目前执行到哪一句指令

方法区 虚拟机栈 本地方法栈 堆 程序计数器 

## 7.3 关键字：static

static：静态的

用法：

1、成员方法：我们一般称为静态方法或类方法

（1）不能被重写

（2）被使用

本类中：其他方法中可以直接使用它

其他类中：可以使用“类名.方法"进行调用，也可以使用"对象名.方法"，推荐使用“类名.方法"

（3）在静态方法中，我们不能出现：this，super，非静态的成员

类方法 不能被重写 

2、成员变量：我们一般称为静态变量或类变量

（1）静态变量的值是该类所有对象共享的

（2）静态变量存储在方法区

（3）静态变量对应的get/set也是静态的

（4）静态变量与局部变量同名时，就可以使用“类名.静态变量"进行区分

修饰static 成员变量    静态变量或类变量

静态变量的值该类所有对象共享的 

静态变量存储在方法区



3、内部类：之后再写 

4、代码块：静态代码块

5、静态导入（JDK1.5引入）

没有静态导入

```java
package com.awen.utils;

public class Utils{
    public static final int MAX_VALUE = 1000;
    public static void test(){
        //...
    }
}


```

```java
package com.awen.test;

import com.awen.utils;

public class Test{
    public static void main(String[] args){
        System.out.println(Utils.MAX_VALUE);
        Utils.test();
    }
}
```

使用静态导入

```java
package com.awen.utils;

public class Utils{
    public static final int MAX_VALUE = 1000;
    public static void test(){
        //...
    }
}
```

```java
package com.awen.test;

import static com.awen.utils.Utils.*;

public class Test{
    public static void main(String[] args){
        System.out.println(MAX_VALUE);
        test();
    }
}
```



## 7.4 静态代码块

1、语法格式：

```java
【修饰符】 class 类名{
    static{
        静态代码块;
    }
}
```

2、作用：

协助完成类初始化，可以为类变量赋值。



3、类初始化<clinit>()

类的初始化有：

①静态变量的显式赋值代码

②静态代码块中代码

其中①和②按顺序执行

注意：类初始化方法，一个类只有一个



4、类的初始化的执行特点：

（1）每一个类的<clinit>()只执行一次

（2）如果一个子类在初始化时，发现父类也没有初始化，会先初始化父类

（3）如果既要类初始化又要实例化初始化，那么一定是先完成类初始化的



## 7.5  变量的分类与区别

1、变量按照数据类型分：

（1）基本数据类型的变量，里面存储数据值

（2）引用数据类型的变量，里面存储对象的地址值

基本数据类型的变量 里面存储数据值的

引用数据类型的变量 里面存储对象的地址值



```java
int a = 10;//a中存储的是数据值

Student stu = new Student();//stu存储的是对象的地址值
int[] arr = new int[5];//arr存储的是数组对象的地址值
String str = "hello";//str存储的是"hello"对象的地址值

```



2、变量按照声明的位置不同：

（1）成员变量

（2）局部变量



3、成员变量与局部变量的区别

（1）声明的位置不同

成员变量：类中方法外

局部变量：（1）方法的()中，即形参（2）方法体的{}的局部变量（3）代码块{}中

（2）存储的位置不同

成员变量：

​	如果是静态变量（类变量），在方法区中

​	如果是非静态的变量（实例变量），在堆中

 局部变量：栈

方法区 静态变量（类变量）
堆 非静态的变量（实例变量）
局部变量：栈

（3）修饰符不同

成员变量：4种权限修饰符、static、final。。。。

局部变量：只有final



（4）生命周期

成员变量：

​	如果是静态变量（类变量），和类相同

​	如果是非静态的变量（实例变量），和所属的对象相同，每一个对象是独立

局部变量：每次执行都是新的

生命周期   类、对象、执行

（5）作用域

成员变量：

​	如果是静态变量（类变量），在本类中随便用，在其他类中使用“类名.静态变量" 类名.静态变量  

​	如果是非静态的变量（实例变量），在本类中只能在非静态成员中使用，在其他类中使用“对象名.非静态的变量" 对象名.静态变量

局部变量：有作用域   局部变量作用域看情况吧

## 7.7  根父类 java.lang.Object

根父类java.lang.Object

Object类是所有Java类的根父类

根父类

```java
如果在类的声明中未使用extends关键字指明其父类，则默认父类为Object类
public class Person {
	...
}
	等价于：
public class Person extends Object {
...
}

```

根父类

根据继承的特点

（1）父类中所有的属性和方法都会继承到子类中，或者说所有对象都具有Object类的方法，包括数组对象
（2）所有的子类都会调用它的构造器，super()

根据多态的特性

（1）Object类型的引用变量可以接收任何类型的对象
Object obj=new Person();
Object obj = “hello”;

...

（2）Object类型的形参可以接收任何类型的实参
例如：void method(Object obj){}
调用：method(new Person());
      method(new Computer());
      method("hello");
      method(null);

（3）数组的多态性：当数组的元素类型是Object时，表示这个数组可以存放任意类型的对象

Object[] object = new Object[5];

1、java.lang.Object类是类层次结构的根父类。包括数组对象。

（1）Object类中声明的所有的方法都会被继承到子类中，那么即所有的对象，都拥有Object类中的方法

（2）每一个对象的创建，最终都会调用到Object实例初始化方法<init>()

（3）Object类型变量、形参、数组，可以存储任意类型的对象



2、Object类的常用方法

![image-20200518211211679](assets/image-20200518211211679.png)

（1）public String toString()：

①默认情况下，返回的是“对象的运行时类型 @ 对象的hashCode值的十六进制形式"

②通常是建议重写，如果在eclipse中，可以用Alt +Shift + S-->Generate toString()

③如果我们直接System.out.println(对象)，默认会自动调用这个对象的toString()

（2）public final Class<?> getClass()：获取对象的运行时类型

（3）protected void finalize()：当对象被GC确定为要被回收的垃圾，在回收之前由GC帮你调用这个方法。而且这个方法只会被调用一次。子类可以选择重写。

（4）public int hashCode()：返回每个对象的hash值。

规定：①如果两个对象的hash值是不同的，那么这两个对象一定不相等；

​	②如果两个对象的hash值是相同的，那么这两个对象不一定相等。

主要用于后面当对象存储到哈希表等容中时，为了提高性能用的。

（5）public boolean equals(Object obj)：用于判断当前对象this与指定对象obj是否“相等”

①默认情况下，equals方法的实现等价于与“==”，比较的是对象的地址值

②我们可以选择重写，重写有些要求：

A：如果重写equals，那么一定要一起重写hashCode()方法，因为规定：

​	a：如果两个对象调用equals返回true，那么要求这两个对象的hashCode值一定是相等的；

​	b：如果两个对象的hashCode值不同的，那么要求这个两个对象调用equals方法一定是false；

​	c：如果两个对象的hashCode值相同的，那么这个两个对象调用equals可能是true，也可能是false

B：如果重写equals，那么一定要遵循如下几个原则：

​	a：自反性：x.equals(x)返回true

​	b：传递性：x.equals(y)为true, y.equals(z)为true，然后x.equals(z)也应该为true

​	c：一致性：只要参与equals比较的属性值没有修改，那么无论何时调用结果应该一致

​	d：对称性：x.equals(y)与y.equals(x)结果应该一样

​	e：非空对象与null的equals一定是false

参考资料
[搞定Java核心技术](https://www.bilibili.com/video/BV1R5411t7Ze)



#### ==与equals()方法

基础数据类型

引用数据类型

1、==运算符

（1）基本数据类型比较值:只要两个变量的值相等，即为true

>  注意：当基本数据类型使用“==”进行比较时，符号两边的数据必须类型兼容（类型相同或可自动类型转换），否则编译出错；

 

```java
public class TestDemo {
    public static void main(String[] args) {
        double d = 2.0;
        int i = 2;
        int j = 2;
        String str = "2";
        System.out.println(i == j);//true
        System.out.println(i == d);//true

        //编译出错  编译都过不了
//        System.out.println(str == i);//Operator '==' cannot be applied to 'java.lang.String', 'int'
//        System.out.println(str == d);//Operator '==' cannot be applied to 'java.lang.String', 'double'
    }
}
```



（2）引用类型比较引用：比较两个对象的地址值，两个引用变量指向同一个对象的堆空间时，才为true

Person p1=new Person();  

Person p2=new Person();

if(p1==p2)  //false

p1=p2;//如果有这样的赋值语句后 if(p1==p2)  //true

 ```java
public class Person {
    private String name;
    private int age;

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1 == p2);//false
        p1 = p2;
        System.out.println(p1 == p2);//true
    }
}

 ```



注意：当引用类型使用“==”进行比较时，符号两边的数据类型必须兼容（类型相同或有父子类关系），否则编译出错；

Person p=new Person();

String str="hello";

if(p==str)//错误，p和String类型不兼容，Person和String类型无父子类关系

 ```java
public class Person {
    private String name;
    private int age;

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1 == p2);//false
        p1 = p2;
        System.out.println(p1 == p2);//true

        Person p = new Person();
        String str = "hello";
//        System.out.println(p == str);//错误，p和String类型不兼容，Person和String类型无父子类关系
    }
}

 ```





Student stu = new Student();//Student extends Person

if(p==stu)//编译通过

 ```java
public class Student  extends Person{
    public static void main(String[] args) {
        Person person = new Person();
        Student student = new Student();//Student extends Person
        
        //编译通过
        System.out.println(person == student);//false
    }
}
 ```



2、equals方法

格式:obj1.equals(obj2)

（1）equals()：所有类都继承了Object，也就获得了equals()方法。

（2）自定义类可以重写equals方法

注意：如果一个类型没有重写过equals方法，那么调用equals等价于==

说明：当用equals()方法进行比较时，对类File、String、Date及包装类（Wrapper Class）来说，是比较类型及内容；原因是在这些类中重写了Object类的equals()方法。

重写equals()方法的原则：

l 对称性：如果x.equals(y)返回是“true”，那么y.equals(x)也应该返回是“true”。

l 自反性：x.equals(x)必须返回是“true”。

l 类推性：如果x.equals(y)返回是“true”，而且y.equals(z)返回是“true”，那么z.equals(x)也应该返回是“true”。

l 一致性：如果x.equals(y)返回是“true”，只要x和y内容一直不变，不管你重复x.equals(y)多少次，返回都是“true”。

l 任何情况下，x.equals(null)，永远返回是“false”；x.equals(和x不同类型的对象)永远返回是“false”。

 ```java
public class Student  extends Person{
    public static void main(String[] args) {
        Person person = new Person();
        Student student = new Student();//Student extends Person

        //编译通过
        System.out.println(person == student);//false
        System.out.println(person.equals(student));//false

        System.out.println("-----------");
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str1.equals(str2));//true
        System.out.println(str1.equals(str3));//true

        System.out.println("------------");
        String str4 = "java";
        System.out.println(str4 == "java");//true
        System.out.println(str4.equals("java"));//true
        System.out.println("java".equals(str4));//true
        System.out.println(str4.equals(str4));//true
        System.out.println(str4.equals(null));//false
        System.out.println("j".equals('j'));//false


    }
}

 ```



#### 2、hashcode方法

l 如果两个对象的hashCode值不相等，那么这两个对象一定不相等，即调用==和equals返回true

l 如果两个对象的hashCode值相等，那么这两个对象可能相等，可能不相等，即调用==和equals方法可能返回true，可能false

l 如果两个对象调用==或equals相等，那么这两个对象的hashCode值一定相等。



```java
public class TestHashCode {
    public static void main(String[] args) {
        String s1 = "Aa";
        String s2 = "BB";
        System.out.println(s1.hashCode());//2112
        System.out.println(s2.hashCode());//2112
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(System.identityHashCode(s1));//460141958
        System.out.println(System.identityHashCode(s2));//1163157884

        String s3 = "java";
        String s4 = "java";
        String s5 = new String("java");

        System.out.println(s3 == s4);//true
        System.out.println(s3.equals(s4));//true
        System.out.println(s3 == s5);//false
        System.out.println(s5.equals(s3));//true
        System.out.println(s3.hashCode());//3254818
        System.out.println(s4.hashCode());//3254818
        System.out.println(s5.hashCode());//3254818
        System.out.println(System.identityHashCode(s3));//1956725890
        System.out.println(System.identityHashCode(s4));//1956725890
        System.out.println(System.identityHashCode(s5));//356573597
    }
}
```

根父类java.lang.Object

Object类是所有Java类的根父类 

Object类的常用方法

Object类中声明的所有的方法都会被继承到子类中，那么即所有的对象，都拥有Object类中的方法

![image-20200518211211679](assets/image-20200518211211679.png)

 public int hashCode()：返回每个对象的hash值。

规定：①如果两个对象的hash值是不同的，那么这两个对象一定不相等；

​	②如果两个对象的hash值是相同的，那么这两个对象不一定相等。

主要用于后面当对象存储到哈希表等容中时，为了提高性能用的。

#### 3、toString()方法

1、默认从Object类继承的toString()方法返回的是

getClass().getName() + '@' + Integer.toHexString(hashCode())

即该对象的类名称@该对象hashcode哈希码的无符号十六进制表示

 

2、在进行String与其它类型数据的连接操作时，自动调用toString()方法

​    Date now=new Date();

​    System.out.println(“now=”+now); 相当于

 System.out.println(“now=”+now.toString()); 

 

3、可以根据需要在用户自定义类型中重写toString()方法

如String 类重写了toString()方法，返回字符串的值。

​    s1=“hello”;

​    System.out.println(s1);//相当于System.out.println(s1.toString());

 

4、基本类型数据转换为String类型时，调用了对应包装类的toString()方法

int a=10;  System.out.println(“a=”+a);

#### 4、finalize()方法

A：这个方法不是程序员手动调用的，而是垃圾回收器调用，当该对象被垃圾回收器回收之前调用（留临终遗言）

B：每一个对象的finalize方法只能被调用一次

  因为如果某个对象重写的finalize()中有一个变量再次引用了this当前对象，那么当前对象就复活了，垃圾回收器这次就不能将其回收。

  但是当它下次再变成垃圾后，垃圾回收器再碰到它，就直接回收，不再调用它的finalize()方法。

C：一般情况下不需要重写，只有这个类是表示某种连接资源时，例如FileInputStream或FileOutputStream，可能需要重写，使得会被回收之前，以配置系统资源或执行其他清除。

![image-20200518212944606](assets/image-20200518212944606.png)

## 7.8 关键字：abstract
面向对象的基本特性 封装、继承、多态
面向对象的特征：封装、继承、多态、抽象

1、什么时候会用到抽象方法和抽象类？

当声明父类的时候，在父类中某些方法的方法体的实现不能确定，只能由子类决定。但是父类中又要体现子类的共同的特征，即它要包含这个方法，为了统一管理各种子类的对象，即为了多态的应用。

那么此时，就可以选择把这样的方法声明为抽象方法。如果一个类包含了抽象方法，那么这个类就必须是个抽象类。



2、抽象类的语法格式

```java
【权限修饰符】 abstract class 类名{
    
}
【权限修饰符】 abstract class 类名 extends 父类{
    
}
```

3、抽象方法的语法格式

```java
【其他修饰符】 abstract 返回值类型  方法名(【形参列表】);
```

抽象方法没有方法体



4、抽象类的特点

（1）抽象类不能直接实例化，即不能直接new对象
抽象类不能直接实例化 即不能直接new对象
（2）抽象类就是用来被继承的，那么子类继承了抽象类后，必须重写所有的抽象方法，否则这个子类也得是抽象类
抽象类就是用来被继承的，那么子类继承了抽象类后，必须重写所有的抽象方法，否则这个子类也得是抽象类
（3）抽象类也有构造器，这个构造的作用不是创建抽象类自己的对象用的，给子类在实例化过程中调用；
抽象类也有构造器 这个构造的作用不是创建抽象类自己的对象用的 给子类在实例化过程中调用
（4）抽象类也可以没有抽象方法，那么目的是不让你创建对象，让你创建它子类的对象
抽象类也可以没有抽象方法，那么目的是不让你创建对象，让你创建它子类的对象
（5）抽象类的变量与它子类的对象也构成多态引用
抽象类的变量与它子类的对象也构成多态引用

5、不能和abstract一起使用的修饰符？

（1）final：和final不能一起修饰方法和类

（2）static：和static不能一起修饰方法

（3）native：和native不能一起修饰方法

（4）private：和private不能一起修饰方法



## 7.9 接口



1、接口的概念

接口是一种标准。注意关注行为标准（即方法）。
接口是一种标准 注意关注行为标准（即方法）
面向对象的开发原则中有一条：面向接口编程

面向接口编程

共有的特性 

2、接口的声明格式

```java
【修饰符】 interface 接口名{
    接口的成员列表;
}
```

3、类实现接口的格式

```java
【修饰符】 class 实现类  implements 父接口们{
    
}

【修饰符】 class 实现类 extends 父类 implements 父接口们{
    
}
```

4、接口继承接口的格式

```java
【修饰符】 interface 接口名 extends 父接口们{
    接口的成员列表;
}
```
接口继承接口 interface extends 
5、接口的特点

（1）接口不能直接实例化，即不能直接new对象

（2）只能创建接的实现类对象，那么接口与它的实现类对象之间可以构成多态引用。

（3）实现类在实现接口时，必须重写所有抽象的方法，否则这个实现类也得是抽象类。

（4）Java规定类与类之间，只能是单继承，但是Java的类与接口之间是多实现的关系，即一个类可以同时实现多个接口

（5）Java还支持接口与接口之间的多继承。



6、接口的成员

JDK1.8之前：

（1）全局的静态的常量：public static final，这些修饰符可以省略

（2）公共的抽象方法：public abstract，这些修饰符也可以省略

JDK1.8之后：

（3）公共的静态的方法：public static ,这个就不能省略了

（4）公共的默认的方法：public default，这个就不能省略了



7、默认方法冲突问题

（1） 当一个实现类同时实现了两个或多个接口，这个多个接口的默认方法的签名相同。

解决方案：

方案一：选择保留其中一个

```java
接口名.super.方法名(【实参列表】);
```

方案二：完全重写



（2）当一个实现类同时继承父类，又实现接口，父类中有一个方法与接口的默认方法签名相同

解决方案：

方案一：默认方案，保留父类的

方案二：选择保留接口的

```java
接口名.super.方法名(【实参列表】);
```

方案三：完全重写



8、示例代码

```java
public interface Flyable{
	long MAX_SPEED = 7900000;
    void fly();
}
```

```java
public class Bird implements Flyable{
    public void fly(){
        //....
    }
}
```

9、常用的接口

（1）java.lang.Comparable接口：自然排序

​	抽象方法：int compareTo(Object obj)

（2）java.util.Comparator接口：定制排序

​	抽象方法：int compare(Object obj1 ,Object obj2)

（3）示例代码

如果员工类型，默认顺序，自然顺序是按照编号升序排列，那么就实现Comparable接口

```java
class Employee implements Comparable{
    private int id;
    private String name;
    private double salary;
    
    //省略了构造器，get/set,toString
    
    @Override
    public int compareTo(Object obj){
        return id - ((Employee)obj).id;
    }
}
```

如果在后面又发现有新的需求，想要按照薪资排序，那么只能选择用定制排序，实现Comparator接口

```java
class SalaryComparator implements Comparator{
    public int compare(Object o1, Object o2){
        Employee e1 = (Employee)o1;
        Employee e2 = (Employee)o2;
        if(e1.getSalary() > e2.getSalary()){
            return 1;
        }else if(e1.getSalary() < e2.getSalary()){
            return -1;
        }
        return 0;
    }
}
```



## 7.10 内部类

1、内部类的概念

声明在另外一个类里面的类就是内部类。



2、内部类的4种形式

（1）静态内部类

（2）非静态成员内部类

（3）有名字的局部内部类

（4）匿名内部类



### 7.10.1 匿名内部类

1、语法格式：

```java
//在匿名子类中调用父类的无参构造
new 父类(){
    内部类的成员列表
}

//在匿名子类中调用父类的有参构造
new 父类(实参列表){
    内部类的成员列表
}

//接口没有构造器，那么这里表示匿名子类调用自己的无参构造，调用默认父类Object的无参构造
new 父接口名(){
    
}
```

2、匿名内部类、匿名对象的区别？

```java
System.out.println(new Student("张三"));//匿名对象

Student stu = new Student("张三");//这个对象有名字，stu

//既有匿名内部类，又是一个匿名的对象
new Object(){
    public void test(){
        .....
    }
}.test();

//这个匿名内部类的对象，使用obj这个名字引用它，既对象有名字，但是这个Object的子类没有名字
Object obj = new Object(){
    public void test(){
        .....
    }
};
```

3、使用的形式

（1）示例代码：继承式

```java
abstract class Father{
    public abstract void test();
}
class Test{
    public static void main(String[] args){
        //用父类与匿名内部类的对象构成多态引用
        Father f = new Father(){
            public void test(){
                System.out.println("用匿名内部类继承了Father这个抽象类，重写了test抽象方法")
            }
        };
        f.test();
    }
}
```

（2）示例代码：实现式

```java
interface Flyable{
    void fly();
}
class Test{
    public static void main(String[] args){
        //用父接口与匿名内部类的对象构成了多态引用
        Flyable f = new Flyable(){
            public void fly(){
                System.out.println("用匿名内部类实现了Flyable这个接口，重写了抽象方法");
            }
        };
        f.fly();
    }
}
```

（3）示例代码：用匿名内部类的匿名对象直接调用方法

```java
new Object(){
    public void test(){
        System.out.println("用匿名内部类的匿名对象直接调用方法")
    }
}.test();
```

（4）示例代码：用匿名内部类的匿名对象直接作为实参

```java
Student[] all = new Student[3];
all[0] = new Student("张三",23);
all[1] = new Student("李四",22);
all[2] = new Student("王五",20);

//用匿名内部类的匿名对象直接作为实参
//这个匿名内部类实现了Comparator接口
//这个匿名内部类的对象，是定制比较器的对象
Arrays.sort(all, new Comparator(){
    public int compare(Obeject o1, Object o2){
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;
        return s1.getAge() - s2.getAge();
    }
});
```

### 7.10.2  静态内部类

1、语法格式

```java
【修饰符】 class 外部类名  【extends 外部类的父类】 【implements 外部类的父接口们】{
	【其他修饰符】 static class  静态内部类 【extends 静态内部类自己的父类】 【implements 静态内部类的父接口们】{
        静态内部类的成员列表;
	}
	
	外部类的其他成员列表;
}
```



2、 使用注意事项

（1）包含成员是否有要求：

​		可以包含类的所有成员

（2）修饰符要求：

* ​		权限修饰符：4种
* ​		其他修饰符：abstract、final

（3）使用外部类的成员上是否有要求

* ​		只能使用外部类的静态成员

（4）在外部类中使用静态内部类是否有要求

* ​		正常使用

（5）在外部类的外面使用静态内部类是否有要求

```java
（1）如果使用的是静态内部类的静态成员
		外部类名.静态内部类名.静态成员
（2）如果使用的是静态内部类的非静态成员
		①先创建静态内部类的对象
		外部类名.静态内部类名 对象名 = new 外部类名.静态内部类名(【实参列表】);
		②通过对象调用非静态成员
		对象名.xxx
```

（6）字节码文件形式：外部类名$静态内部类名.class



3、示例代码

```java
class Outer{
    private static int i = 10;
    static class Inner{
        public void method(){
            //...
            System.out.println(i);//可以
        }
        public static void test(){
            //...
            System.out.println(i);//可以
        }
    }
    
    public void outMethod(){
        Inner in = new Inner();
        in.method();
    }
    public static void outTest(){
        Inner in = new Inner();
        in.method();
    }
}
class Test{
    public static void main(String[] args){
        Outer.Inner.test();
        
        Outer.Inner in = new Outer.Inner();
        in.method();
    }
}
```



### 7.10.3  非静态内部类

1、语法格式

```java
【修饰符】 class 外部类名  【extends 外部类的父类】 【implements 外部类的父接口们】{
	【修饰符】 class  非静态内部类 【extends 非静态内部类自己的父类】 【implements 非静态内部类的父接口们】{
        非静态内部类的成员列表;
	}
	
	外部类的其他成员列表;
}
```



2、 使用注意事项

（1）包含成员是否有要求：

​	不允许出现静态的成员

（2）修饰符要求

​	权限修饰符：4种

​	其他修饰符：abstract，final

（3）使用外部类的成员上是否有要求

​	都可以使用

（4）在外部类中使用非静态内部类是否有要求

​	在外部类的静态成员中不能使用非静态内部类

（5）在外部类的外面使用非静态内部类是否有要求

```java
//使用非静态内部类的非静态成员
//(1)创建外部类的对象
外部类名  对象名1 = new  外部类名(【实参列表】);

//(2)通过外部类的对象去创建或获取非静态内部类的对象
//创建
外部类名.非静态内部类名  对象名2 = 对象名1.new 非静态内部类名(【实参列表】);

//获取
外部类名.非静态内部类名  对象名2 = 对象名1.get非静态内部类对象的方法(【实参列表】);

//（3）通过非静态内部类调用它的非静态成员
对象名2.xxx
```

（6）字节码文件形式：外部类名$非静态内部类名.class



3、示例代码

```java
class Outer{
    private static int i = 10;
    private int j = 20;
    class Inner{
        public void method(){
            //...
            System.out.println(i);//可以
            System.out.println(j);//可以
        }
    }
    
    public void outMethod(){
        Inner in = new Inner();
        in.method();
    }
    public static void outTest(){
       // Inner in = new Inner();//不可以
    }
    
    public Inner getInner(){
        return new Inner();
    }
}
class Test{
    public static void main(String[] args){
        Outer out = new Outer();
        
        Outer.Inner in1 = out.new Inner();     //创建   	
        in1.method();
        
        Outer.Inner in2 = out.getInner();	//获取
        in2.method();
    }
}
```



### 7.10.4  局部内部类

1、语法格式

```java
【修饰符】 class 外部类名  【extends 外部类的父类】 【implements 外部类的父接口们】{
	【修饰符】 返回值类型  方法名(【形参列表】){
        【修饰符】 class  局部内部类 【extends 局部内部类自己的父类】 【implements 局部内部类的父接口们】{
        	局部内部类的成员列表;
		}
	}	
	外部类的其他成员列表;
}
```



2、 使用注意事项

（1）包含成员是否有要求

​	不允许出现静态的成员

（2）修饰符要求

​	权限修饰符：不能

​	其他修饰符：abstract、final

（3）使用外部类的成员等上是否有要求

​	①使用外部类的静态成员：随便用

​	②使用外部类的非静态成员：能不能用要看所在的方法是否是静态的

​	③使用所在方法的局部变量：必须 final修饰的

（4）在外部类中使用局部内部类是否有要求

​	有作用域

（5）在外部类的外面使用局部内部类是否有要求

​	没法使用

（6）字节码文件形式：外部类名$编号局部内部类名.class



3、示例代码

```java
class Outer{
    private static int i = 10;
    private int j = 20;

    
    public void outMethod(){
        class Inner{
            public void method(){
                //...
                System.out.println(i);//可以
                System.out.println(j);//可以
            }
   		}
        Inner in = new Inner();
        in.method();
    }
    public static void outTest(){
        final int k = 30;
       class Inner{
            public void method(){
                //...
                System.out.println(i);//可以
                System.out.println(j);//不可以
                System.out.println(k);//可以
            }
   		}
        Inner in = new Inner();
        in.method();
    }
}
```



# 第八章  枚举与注解

## 8.1 枚举

1、枚举（JDK1.5引入的）
类似：列举，穷举，一一罗列。

Java枚举：把某个类型的对象，全部列出来

当什么情况下会用到枚举类型？

 * 当某个类型的对象是固定的，有限的几个，那么就可以选择使用枚举。
 * 在整个系统的运行期间，有且只有这几个对象。

枚举类型的对象是有限、固定的几个常量对象。
例如：
 星期  Week，它的对象只有7个：Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
 季节 Season，它的对象只有4个：Spring,Summer,Fall,Winter

讨论：JDK1.5之前，如果想要实现枚举的这种效果

（1）构造器私有化：目的：在这个类的外面，无法随意的创建对象

（2）在这个类中，提前创建好几个对象，供别人使用

```java
public class TestEnum {
    public static void main(String[] args) {
//		Gender g1 = new Gender();

        Gender nan1 = Gender.NAN;////com.awen.test07.Gender@1b6d3586
        Gender nan2 = Gender.NAN;////com.awen.test07.Gender@1b6d3586
        System.out.println(nan1 == nan2);//true
    }
}
class Gender{
    //public：使得外面可以直接访问
    //static：使得可以使用“类名.”访问
    //final：前调这个对象是不可变
    public static final Gender NAN = new Gender("男");
    public static final Gender NV = new Gender("女");
    public static final Gender YAO = new Gender("妖");

    private String description;

    private Gender(String description){
        this.description = description;
    }
}
```

枚举是一种类，是一种特殊的类，特殊在它的对象是有限的几个常量对象。

JDK1.5之后，就优化了枚举的语法： 可以枚举了

2、语法格式

```java

//形式一：枚举类型中只有常量对象列表
【修饰符】 enum 枚举类型名{
    常量对象列表
}

//形式二：枚举类型中只有常量对象列表
【修饰符】 enum 枚举类型名{
    常量对象列表;
    
    其他成员列表；
}
```

说明：常量对象列表必须在枚举类型的首行

> 说明：如果常量对象列表后面还有其他的成员，那么需要在常量对象列表后面加;进行分割

回忆：首行

（1）super()或super(实参列表)：必须在子类构造器的首行

（2）this()或this(实参列表)：必须在本类构造器的首行

（3）package 包; 声明包的语句必须在源文件.java的代码首行

（4）枚举常量对象列表必须在枚举类型的首行



3、在其他类中如何获取枚举的常量对象

```
 * 3、API中没有的方法，是编译器帮我们生成的方法
 * （1）枚举类型[] values()
 * （2）枚举类型   valueOf(String name)

```



```java
//获取一个常量对象
枚举类型名.常量对象名

//获取一个常量对象
枚举类型名.valueOf("常量对象名")
    
//获取所有常量对象
枚举类型名[] all = 枚举类型名.values();
```



4、枚举类型的特点

（1）枚举类型有一个公共的基本的父类，是java.lang.Enum类型，所以不能再继承别的类型

（2）枚举类型的构造器必须是私有的

（3）枚举类型可以实现接口

```java
interface MyRunnable{
    void run();
}
enum Gender implements MyRunnable{
    NAN,NV;
    public void run(){
        //...
    }
}
//或
enum Gender implements MyRunnable{
    NAN{
        public void run(){
       	 //...
    	}
    },NV{
        public void run(){
        //...
   		}
    };
    
}
```



```java
/*
 * 补充：枚举类型实现接口
 * 枚举类型实现接口
 */
public class TestEnum3 {
    public static void main(String[] args) {
        MyEnum a = MyEnum.A;
        a.test();//aaa

        MyEnum b = MyEnum.B;
        b.test();//bbb
    }
}
interface MyInter{
    void test();
}
enum MyEnum implements MyInter{
    //想A,B对象实现的不一样
    A{
        @Override
        public void test() {
            System.out.println("aaa");
        }
    },B{
        @Override
        public void test() {
            System.out.println("bbb");
        }
    }
}
/*enum MyEnum implements MyInter{
	A,B;

	@Override
	public void test() {
		System.out.println("test");
	}
}*/
```



5、父类java.lang.Enum类型

枚举类型不能继承其他类型，因为枚举类型有一个隐含的父类

java.lang.Enum

即Enum是所有 Java 语言枚举类型的公共基本类。

```
* （1）Enum类中有一个唯一的构造器
 * protected  Enum(String name, int ordinal)
 * 这个构造器不是程序员手动调用的，是编译器自动调用，在所有枚举类型的构造器的首行，
 * 帮我们自动调用，并且自动传入name和ordinal的值。
 *
 * name：就是常量对象名称
 * ordinal：就是常量对象的序号，其中初始常量序数为零
 *
 * （2）String name()
 * 		int ordinal()
 * （3）String toString()
 * 	在Enum类中重写了Object类的toString方法，返回常量对象名
 *
 * 自定义的枚举类型，在eclipse工具类中，不能自动生成toString方法。手动重写。
 * 因为eclipse认为，父类重写的toString方法的实现已经很完美了，就是返回常量对象名，已经能代表一切。
 *
```



（1）构造器

protected Enum(String name, int ordinal)：由编译器自动调用

（2）String name()：常量对象名

（3）int ordinal()：返回常量对象的序号，第一个的序号是0

（4）String toString()：返回常量对象名，如果子类想重写，需要手动

（5）int compareTo(Object obj)：按照常量对象的顺序比较



```java
public class TestEnum2 {
    public static void main(String[] args) {
        Season s = Season.SPRING;
        //重写了toString
        System.out.println(s);//自动调用toString
        //SPRING:春暖花开

        System.out.println(s.name());//SPRING
        System.out.println(s.ordinal());//0
        System.out.println("-----------------");

        Season[] all = Season.values();
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }
        //SPRING:春暖花开
        //SUMMER:null
        //FALL:null
        //WINTER:null

        System.out.println("-----------------");
        Season spring = Season.valueOf("SPRING");
        System.out.println(spring);
        //SPRING:春暖花开
    }
}
enum Season{
    //常量对象后面没有(值)就是调用无参构造
    //常量对象后面有(值)就是调用有参构造
    SPRING("春暖花开"),SUMMER,FALL,WINTER;

    private String description;

    //私有的
    private Season() {

    }

    private Season(String description) {
        this.description = description;
    }

    public String toString(){
        return name() + ":" + description;
    }

}
```



## 8.2 注解

1、注解

它是代码级别的注释



2、标记符号：@



3、系统预定义的三个最基本的注解：

（1）@Override：表示某个方法是重写的方法

它只能用在方法上面，会让编译器对这个方法进行格式检查，是否满足重写的要求

（2）@SuppressWarnings(xx)：抑制警告

（3）@Deprecated：表示xx已过时



4、和文档注释相关的注解

（1）文档注释

```java
/**
文档注释
*/
```

（2）常见的文档注释

@author：作者

@since：从xx版本加入的

@see：另请参考

@param：形参

@return：返回值

@throws或@exception：异常



5、JUnit相关的几个注解

（1）@Test：表示它是一个单元测试方法

这个方法需要是：public void xxx(){}

（2）@Before：表示在每一个单元测试方法之前执行

这个方法需要是：public void xxx(){}

（3）@After：表示在每一个单元测试方法之后执行

这个方法需要是：public void xxx(){}

（4）@BeforeClass：表示在类初始化阶段执行，而且只执行一次

这个方法需要是：public static void xxx(){}

（3）@AfterClass：表示在类的“卸载”阶段执行，而且只执行一次

这个方法需要是：public static void xxx(){}



6、元注解

（1）@Target(xx)：用它标记的注解能够用在xx位置

(xx)：由ElementType枚举类型的10个常量对象指定，例如：TYPE，METHOD，FIELD等

例如：

```java
@Target(ElementType.TYPE)

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
```

```java
import static java.lang.annotation.ElementType.*;


@Target({TYPE,METHOD,FIELD})
```



（2）@Retention（xx）：用它标记的注解可以滞留到xx阶段

(xx)：由RetentionPolicy枚举类型的3个常量对象指定，分别是：SOURCE，CLASS，RUNTIME

唯有RUNTIME阶段的注解才能被反射读取到

例如：

```java
@Retention(RetentionPolicy.RUNTIME)
```



（3）@Documentd：用它标记的注解可以读取到API中

（4）@Inherited：用它标记的注解可以被子类继承



7、自定义注解

```java
@元注解
【修饰符】 @interface 注解名{
    
}

@元注解
【修饰符】 @interface 注解名{
    配置参数列表
}
```

配置参数的语法格式：

```java
数据类型  配置参数名();

或

数据类型  配置参数名() default 默认值;
```

关于配置参数：

（1）配置参数的类型有要求：

八种基本数据类型、String、枚举、Class类型、注解、它们的数组。

（2）如果自定义注解声明了配置参数，那么在使用这个注解时必须为配置参数赋值，除非它有默认值

```java
@自定义注解名(配置参数名1=值，配置参数名2=值。。。)

//如果配置参数类型是数组，那么赋值时，可以用{}表示数组
@自定义注解名(配置参数名1={值}，配置参数名2=值。。。)
```

（3）如果配置参数只有一个，并且名称是value，那么赋值时可以省略value=

（4）如果读取这个注解时，要获取配置参数的值的话，可以当成方法一样来访问

```
自定义注解对象.配置参数();
```



静态导入



# 第九章 异常

## 9.1 异常的类型的体系结构

1、异常系列的超父类：java.lang.Throwable

（1）只有它或它子类的对象，才能被JVM或throw语句“抛”出

（2）也只有它或它子类的对象，才能被catch“捕获”



2、Throwable分为两大派别

（1）Error：严重的错误，需要停下来重新设计、升级解决这个问题

（2）Exception： 一般的异常，可以通过判断、检验进行避免，或者使用try...catch进行处理



3、Exception又分为两大类

（1）运行时异常：

​	它是RuntimeException或它子类的对象。

​	这种类型的异常，编译器不会提醒你，要进行throws或try...catch进行处理，但是运行时可能导致崩溃。

（2）编译时异常：

​	异常除了运行时异常以外的都是编译时异常。

​	这种类型的异常，编译器是强制要求你，throws或try...catch进行处理，否则编译不通过。



4、列出常见的异常类型

（1）运行时异常

RuntimeException、NullPointerException（空指针异常），ClassCastException（类型转换异常），ArithmeticException（算术异常），NubmerFormatException（数字格式化异常），IndexOutOfBoundsException（下标越界异常）（ArrayIndexOutOfBoundsException（数组下标越界异常）、StringIndexOutOfBoundsException（字符串下标越界异常））、InputMisMatchException（输入类型不匹配异常）。。。。



（2）编译时异常

FileNotFoundException（文件找不到异常）、IOException（输入输出异常）、SQLException（数据库sql语句执行异常）。。。



## 9.2 异常的处理

1、在当前方法中处理：try...catch...finally

```java
//形式一：try...catch
try{
    可能发生异常的代码
}catch(异常类型  异常名e){
    处理异常的代码（一般都是打印异常的信息的语句）
}catch(异常类型  异常名e){
    处理异常的代码（一般都是打印异常的信息的语句）
}。。。


//形式二：try...finally
try{
    可能发生异常的代码
}finally{
    无论try中是否有异常，也不管是不是有return，都要执行的部分
}

//形式三：try..catch..finally
try{
    可能发生异常的代码
}catch(异常类型  异常名e){
    处理异常的代码（一般都是打印异常的信息的语句）
}catch(异常类型  异常名e){
    处理异常的代码（一般都是打印异常的信息的语句）
}。。。
finally{
    无论try中是否有异常，也不管catch是否可以捕获异常，也不管try和catch中是不是有return，都要执行的部分
}
```

执行特点：

（1）如果try中的代码没有异常，那么try中的代码会正常执行，catch部分就不执行，finally中会执行

（2）如果try中的代码有异常，那么try中发生异常的代码的后面就不执行了，找对应的匹配的catch分支执行，finally中会执行

![1559610439025](imgs/1559610439025.png)



2、finally与return混合使用时

（1）如果finally中有return，一定从finally中的return返回。

此时try和catch中的return语句，执行了一半，执行了第一个动作。所以，finally中的return语句会覆盖刚刚的返回值



return 返回值; 语句有两个动作：（1）把返回值放到“操作数栈”中，等当前方法结束后，这个“操作数栈”中的值会返回给调用处（2）结束当前方法的执行



（2）如果finally中没有return，finally中的语句会执行，但是不影响最终的返回值

即try和catch中的return语句两步拆开来走，先把（1）把返回值放到“操作数栈”中，（2）然后走finally中的语句（3）再执行return后半个动作，结束当前方法



3、在当前方法中不处理异常，明确要抛给调用者处理，使用throws

语法格式：

```java
【修饰符】 返回值类型  方法名(【形参列表】) throws 异常列表{
    
}
```

此时调用者，就知道需要处理哪些异常。



方法的重写的要求：

（1）方法名：相同

（2）形参列表：相同

（3）返回值类型：

​	基本数据类型和void：相同

​	引用数据类型：<=

（4）修饰符：

​	权限修饰符：>=

​	其他修饰符：static，final，private不能被重写

（5）throws：<=



方法的重载：

（1）方法名：相同

（2）形参列表：必须不同

（3）返回值类型：无关

（4）修饰符：无关

（5）throws：无关



## 9.3 手动抛出异常：throw

```java
throw 异常对象;

//例如：
throw new AccountException("xxx");
```

throw抛出来的异常对象，和JVM抛出来的异常对象一样，也要用try..catch处理或者throws。

如果是运行时异常，编译器不会强制要求你处理，如果是编译时异常，那么编译器会强制要求你处理。



## 9.4  自定义异常

1、必须继承Throwable或它的子类

我们见到比较多的是继承RuntimeException和Exception.

如果你继承RuntimeException或它的子类，那么你自定义的这个异常就是运行时异常。编译器就不会提醒你处理。

如果你继承Exception，那么它属于编译时异常，编译器会强制你处理。

2、建议大家保留两个构造器

```java
//无参构造
public 自定义异常名(){
    
}

//有参构造
public 自定义异常名(String message){
    super(message);
}
```

3、自定义异常对象，必须手动抛出，用throw抛出



## 9.5 关于异常的几个方法

（1）e.printStackTrace()：打印异常对象的详细信息，包括异常类型，message，堆栈跟踪信息。这个对于调试，或者日志跟踪是非常有用的

（2）e.getMessage()：只是获取异常的message信息



关于异常信息的打印：

用System.err打印和用e.printStackTrace()都是会标记红色的突出。

用System.out打印，当成普通信息打印。

这两个打印是两个独立的线程，顺序是不能精确控制的。



# 第十章  多线程

## 10.1 相关的概念

1、程序（Program）

​	为了实现一个功能，完成一个任务而选择一种编程语言编写的一组指令的集合。

程序 为了实现一个功能 完成一个任务而选择一种编程语言编写的一组指令的集合。

2、进程（Process）

​	程序的一次运行。操作系统会给这个进程分配资源（内存）。

​	进程是操作系统分配资源的最小单位。

​	进程与进程之间的内存是独立，无法直接共享。

​	最早的DOS操作系统是单任务的，同一时间只能运行一个进程。后来现在的操作系统都是支持多任务的，可以同时运行多个进程。进程之间来回切换。成本比较高。

3、线程（Thread）

​	线程是进程中的其中一条执行路径。一个进程中至少有一个线程，也可以有多个线程。有的时候也把线程称为轻量级的进程。

​	同一个进程的多个线程之间有些内存是可以共享的（方法区、堆），也有些内存是独立的（栈（包括虚拟机栈和本地方法栈）、程序计数器）。

​	线程之间的切换相对进程来说成本比较低。

4、并行： 多个处理器同时可以执行多条执行路径。

5、并发：多个任务同时执行，但是可能存在先后关系。



## 10.2  两种实现多线程的方式

1、继承Thread类

 步骤：

（1）编写线程类，去继承Thread类

（2）重写public void run(){}

（3）创建线程对象

（4）调用start()

```java
class MyThread extends Thread {
    public void run(){
        //...
    }
}
class Test{
    public static void main(String[] args){
        MyThread my = new MyThread();
        my.start();//有名字的线程对象启动
        
        new MyThread().start();//匿名线程对象启动
        
        //匿名内部类的匿名对象启动
        new Thread(){
            public void run(){
                //...
            }
        }.start();
        
        //匿名内部类，但是通过父类的变量多态引用，启动线程
        Thread t =  new Thread(){
            public void run(){
                //...
            }
        };
        t.start();
    }
}
```



2、实现Runnable接口

步骤：

（1）编写线程类，实现Runnable接口

（2）重写public void run(){}

（3）创建线程对象

（4）借助Thread类的对象启动线程

```java
class MyRunnable implements Runnable{
    public void run(){
        //...
    }
}
class Test {
    public static void main(String[] args){
        MyRunnable my = new MyRunnable();
        Thread t1 = new Thread(my);
        Thread t2 = new Thread(my);
        t1.start();
        t2.start();
        
        //两个匿名对象
        new Thread(new MyRunnable()).start();
        
        //匿名内部类的匿名对象作为实参直接传给Thread的构造器
        new Thread(new Runnable(){
            public void run(){
                //...
            }
        }).start();
            
    }
}
```





## 10.3 线程的生命周期

![1559782705811](imgs/1559782705811.png)

## 10.4 Thread的相关API

1、构造器

* Thread()
* Thread(String name)
* Thread(Runnable target)
* Thread(Runnable target, String name)

2、其他方法

（1）public void run()

（2）public void start()

（3）获取当前线程对象：Thread.currentThread()

（4）获取当前线程的名称：getName()

（5）设置或获取线程的优先级：set/getPriority()

优先级的范围：[1,10]，Thread类中有三个常量：MAX_PRIORITY(10)，MIN_PRIORITY(1)，NORM_PRIORITY(5)

优先级只是影响概率。

（6）线程休眠：Thread.sleep(毫秒)

（7）打断线程：interrupt()

（8）暂停当前线程：Thread.yield()

（9）线程要加塞：join()

> xx.join()这句代码写在哪个线程体中，哪个线程被加塞，和其他线程无关。

（10）判断线程是否已启动但未终止：isAlive()



## 10.5 关键字：volatile

volatile：易变，不稳定，不一定什么时候会变

修饰：成员变量

作用：当多个线程同时去访问的某个成员变量时，而且是频繁的访问，再多次访问时，发现它的值没有修改，Java执行引擎就会对这个成员变量的值进行缓存。一旦缓存之后，这个时候如果有一个线程把这个成员变量的值修改了，Jav执行引擎还是从缓存中读取，导致这个值不是最新的。如果不希望Java执行引擎把这个成员变的值缓存起来，那么就可以在成员变量的前面加volatile，每次用到这个成员变量时，都是从主存中读取。

## 10.6  关键字：synchronized（同步）

1、什么情况下会发生线程安全问题？

（1）多个线程

（2）共享数据

（3）多个线程的线程体中，多条语句再操作这个共享数据时

2、如何解决线程安全问题？同步锁

形式一：同步代码块

形式二：同步方法



3、同步代码块

```java
synchronized(锁对象){
    //一次任务代码，这其中的代码，在执行过程中，不希望其他线程插一脚
}
```

锁对象：

（1）任意类型的对象

（2）确保使用共享数据的这几个线程，使用同一个锁对象

4、同步方法

```java
synchronized 【修饰符】 返回值类型  方法名(【形参列表】)throws 异常列表{
    //同一时间，只能有一个线程能进来运行
}
```

锁对象：

（1）非静态方法：this（谨慎）

（2）静态方法：当前类的Class对象

## 10.7 线程通信

1、为了解决“生产者与消费者问题”。

当一些线程负责往“数据缓冲区”放数据，另一个线程负责从“数据缓冲区”取数据。

问题1：生产者线程与消费者线程使用同一个数据缓冲区，就是共享数据，那么要考虑同步

问题2：当数据缓冲区满的时候，生产者线程需要wait()， 当消费者消费了数据后，需要notify或notifyAll

​		当数据缓冲区空的时候，消费者线程需要wait()， 当生产者生产了数据后，需要notify或notifyAll

2、java.lang.Object类中声明了：

（1）wait()：必须由“同步锁”对象调用

（2）notfiy()和notifyAll()：必须由“同步锁”对象调用



3、面试题：sleep()和wait的区别

（1）sleep()不释放锁，wait()释放锁

（2）sleep()在Thread类中声明的，wait()在Object类中声明

（3）sleep()是静态方法，是Thread.sleep()

​        wait()是非静态方法，必须由“同步锁”对象调用

（4）sleep()方法导致当前线程进入阻塞状态后，当时间到或interrupt()醒来

​	 wait()方法导致当前线程进入阻塞状态后，由notify或notifyAll()



4、哪些操作会释放锁？

（1）同步代码块或同步方法正常执行完一次自动释放锁

（2）同步代码块或同步方法遇到return等提前结束

（3）wait()



5、不释放锁

（1）sleep()

（2）yield()

（3）suspend()





# 第十一章 常用类

## 11.1 包装类

箱  对象 

从Hello到goodbye

Wrapper包装类



# Wrapper包装类





# 1、为什么要有包装类

为什么要有包装类？

因为Java是面向对象的编程语言，但是Java发明时，是C语言盛行的时候，而且C语言确实很好用。特别是其中的8种基本数据类型，不管在存储还是运算都很强大，那么，Java就延续使用了C语言的8种基本数据类型。



Java语言是一个面向对象的语言，但是Java中的基本数据类型却是不面向对象的。基本数据类型有它的优势：性能（效率高，节省空间）。
但是我们在实际使用中经常需要将基本数据类型转化成对象，便于操作。比如：

（1）集合的操作，

（2）使用Object类型接收任意类型的数据等，

（3）泛型实参，

Java后面在设计很多的API、新的特性（泛型等），这些都不支持基本数据类型，只支持对象。这时，我们就需要将基本数据类型数据转化为对象，为这8种基本数据类型配上包装类。



8种基本数据类型不属于对象。

需要经常将基本数据类型转化为对象，便于操作。

为对象而设计包装类。

# 2、包装类

当要使用只针对对象设计的API或新特性（例如泛型），那么基本数据类型的数据就需要用包装类来包装。

| 序号 | 基本数据类型 | 包装类    |
| ---- | ------------ | --------- |
| 1    | byte         | Byte      |
| 2    | short        | Short     |
| 3    | int          | Integer   |
| 4    | long         | Long      |
| 5    | float        | Float     |
| 6    | double       | Double    |
| 7    | char         | Character |
| 8    | boolean      | Boolean   |
| 9    | void         | Void      |

基本数据类型 		  包装类(java.lang)

# 3、  装箱与拆箱

  JDK让程序员更简洁的去操作包装类，在JDK1.5引入了自动装箱与自动拆箱。在这个之前需要手动装箱与拆箱。



装箱：把基本数据类型的数据  包装  称为包装类的对象

基本数据类型 -->包装类的对象

把基本数据类型转为包装类对象。

> 转为包装类的对象，是为了使用专门为对象设计的API和特性

拆箱：把包装类的对象  拆解  称为基本数据类型的数据

包装类的对象 -->基本数据类型

把包装类对象拆为基本数据类型。

> 转为基本数据类型，一般是因为需要运算，Java中的大多数运算符是为基本数据类型设计的。比较、算术等

手动装箱

```java
 @Test
    public void test1(){
        //装箱操作
        int a = 10;//a是基本数据类型
        Integer aObj = new Integer(a);//把a中的数据，包装成一个对象

        System.out.println(a);
        System.out.println(aObj);//自动调用toString(),Integer重写了Object的toString，打印的是包装的值

        System.out.println(aObj.getClass());//运行时类型
        System.out.println(aObj.hashCode());
        //Result
        //10
        //10
        //class java.lang.Integer
        //10
    }
```



自动装箱：当把基本数据类型的值，赋值给包装类的变量时，就会自动装箱。

（auto_boxing）

自动拆箱：把包装类的对象赋值给对应的基本数据类型的变量时，就会自动拆箱（unboxing）

自动装箱

```java
 @Test
    public void test2(){
        //装箱操作
        int a = 10;//a是基本数据类型
        Integer aObj = a;//左边是包装类型，右边是int类型    自动装箱
        System.out.println(aObj.getClass());
    }
```



>  注意：只能与自己对应的类型之间才能实现自动装箱与拆箱。

```java
Integer i = 1;
Double d = 1;//错误的，1是int类型
```



```java
@Test
    public void test3(){
        int a = 10;
//		Double d = a;//因为Double不是int的包装类，
//		Double d = 10;//因为Double不是int的包装类，
        Double d = 10.0;//Double包装类只能与double类型的数据自动装与拆
    }

```



```java
 @Test
    public void test4(){
        Integer i = new Integer(10);

        int a = i.intValue();//手动拆箱
        int b = i;//自动拆箱
    }
```



```java
 @Test
    public void test5(){
        Integer i = new Integer(1);
        int j = 1;

        System.out.println(i == j);//（1）先把i拆箱为int值（2）然后int与int比较
        //true
    }
```



```java
 @Test
    public void test6(){
        Integer i = new Integer(1);
        double j = 1.0;

        System.out.println(i == j);//（1）先把i拆箱为int值（2）然后把i自动类型转换为double（3）然后比较
        //一旦变为基本数据类型，那么就要考虑基本数据类型的自动类型转换或强制类型转换的问题了。
        //自动类型转换 包装类拆箱
    }
```



总结：对象（引用数据类型）能用的运算符有哪些？

（1）instanceof

（2）=：赋值运算符

（3）==和!=：用于比较地址，但是要求左右两边对象的类型一致或者是有父子类继承关系。

（4）对于字符串这一种特殊的对象，支持“+”，表示拼接。

# 4、 包装类的一些API



1、基本数据类型和字符串之间的转换

（1）把基本数据类型转为字符串

```java
int a = 10;
//String str = a;//错误的
//方式一：
String str = a + "";
//方式二：
String str = String.valueOf(a);
```



（2）把字符串转为基本数据类型

通过包装类的parseXxx(String s)静态方法

```java
int a = Integer.parseInt("整数的字符串");
double a = Double.parseDouble("小数的字符串");
boolean b = Boolean.parseBoolean("true或false");
```



```java
@Test
    public void test17(){
        int a = Integer.parseInt("1314");
        System.out.println(a);//1314
        double d = Double.parseDouble("123.456");
        System.out.println(d);//123.456
        boolean b = Boolean.parseBoolean("true");
        System.out.println(b);//true
    }
```



```java
@Test
    public void test7(){
        //Integer
        int num1 = Integer.parseInt("123");//把字符串类型的"123"转为int类型
        System.out.println(num1);//123

//		int num2 = Integer.parseInt("123.05");//错误，报NumberFormatException
//		System.out.println(num2);
        //Double
        double num2 = Double.parseDouble("123.05");
        System.out.println(num2);//123.05
    }
```

先转成Integer对象，后拆箱为int

```java
 @Test
    public void test8(){
        int num1 = Integer.valueOf("123");//两边，先转成Integer对象，后拆箱为int

        double d = Double.valueOf("125.05");
    }
```



2、数据类型的最大最小值

MIN_VALUE、MAX_VALUE
Float和Double中还有正无穷大POSITIVE_INFINITY、负无穷大NEGATIVE_INFINITY，还NaN，是Not a Number的缩写。NaN 用于处理计算中出现的错误情况，比如 0.0 除以 0.0 或者求负数的平方根。
程序员可以利用这种定制的 NaN 值中的特定位模式来表达某些诊断信息。



常量值

```java
Integer.MAX_VALUE和Integer.MIN_VALUE
Long.MAX_VALUE和Long.MIN_VALUE
Double.MAX_VALUE和Double.MIN_VALUE
```



```java
 @Test
    public void test10(){
        System.out.println(Byte.MAX_VALUE);//127
        System.out.println(Byte.MIN_VALUE);//-128

        System.out.println(Integer.MAX_VALUE);//2147483647
        System.out.println(Integer.MIN_VALUE);//-2147483648

        System.out.println(Long.MAX_VALUE);//9223372036854775807
        System.out.println(Long.MIN_VALUE);//-9223372036854775808

        System.out.println(Double.MAX_VALUE);//1.7976931348623157E308
        System.out.println(Double.MIN_VALUE);//4.9E-324

    }
```



3、转大小写

转大小写：Character

```java
Character.toUpperCase('x');
Character.toLowerCase('X');
```



```java
 @Test
    public void test11(){
        System.out.println(Character.toUpperCase('a'));//A
        System.out.println(Character.toLowerCase('T'));//t
    }

```



4、转进制

```java
Integer.toBinaryString(int i) 
Integer.toHexString(int i)
Integer.toOctalString(int i)
```



```java
@Test
    public void test9(){
        System.out.println(Integer.toBinaryString(10));//转为二进制
        //1010
        System.out.println(Integer.toOctalString(10));//转为八进制
        //12
        System.out.println(Integer.toHexString(10));//转为十六进制
        //a
    }
```



# 5、 包装类对象的缓存问题

我们在编程时大量需要值在-128到127范围之间的Integer对象。如果只能通过new来创建，需要在堆中开辟大量值一样的Integer对象。这是相当不划算的，IntegerCache.cache很好的起到了缓存的作用。

包装类对象的缓存问题

自动装箱这种情况。

Byte，Short，Integer，Long：都有缓存对象   -128~127

Float，Double没有缓存对象

Character：0~127   最早的ASCII码表的128个字符

 Boolean：false,true

| 包装类    | 缓存对象    |
| --------- | ----------- |
| Byte      | -128~127    |
| Short     | -128~127    |
| Integer   | -128~127    |
| Long      | -128~127    |
| Float     | 没有        |
| Double    | 没有        |
| Character | 0~127       |
| Boolean   | true和false |

```java
Integer i = 1;
Integer j = 1;
System.out.println(i == j);//true

Integer i = 128;
Integer j = 128;
System.out.println(i == j);//false

Integer i = new Integer(1);//新new的在堆中
Integer j = 1;//这个用的是缓冲的常量对象，在方法区
System.out.println(i == j);//false

Integer i = new Integer(1);//新new的在堆中
Integer j = new Integer(1);//另一个新new的在堆中
System.out.println(i == j);//false

Integer i = new Integer(1);
int j = 1;
System.out.println(i == j);//true，凡是和基本数据类型比较，都会先拆箱，按照基本数据类型的规则比较
```



```java
@Test
    public void test13(){
        //自动装箱
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b);//true    a == b比较的也是地址值     a和b指向的是同一个缓存的常量对象


        Integer c = 130;
        Integer d = 130;
        System.out.println(c == d);//false  c == d比较的也是地址值    c和d都是在堆中新建的Integer对象
    }
```



```java
   @Test
    public void test14(){
        Integer a = 1;
        Double b = 1.0;
        Long c = 1L;
        long d = 1L;

//		System.out.println(a == b);//无法比较，因为对象比较地址，必须是同一种类型或有父子类关系
//		System.out.println(a == c);//无法比较，因为对象比较地址，必须是同一种类型或有父子类关系

        System.out.println(a == d);//true //因为d是基本数据类型，a才会自动拆箱
    }
```



```java
 @Test
    public void test15(){
        Double d1 = 1.0;
        Double d2 = 1.0;
        System.out.println(d1 == d2);//false
    }
```



```java
@Test
    public void test16(){
        Character c1 = '0';//ASCII码，Unicode码：48
        Character c2 = '0';
        System.out.println(c1 == c2);//true

        //Character：0~127   最早的ASCII码表的128个字符
        Character c3 = '菜';
        Character c4 = '菜';
        System.out.println(c3 == c4);//false
    }

```

# 6、参考资料

记录 - [搞定Java核心技术](https://www.bilibili.com/video/BV1R5411t7Ze)

### 11.1.1 包装类

当要使用只针对对象设计的API或新特性（例如泛型），那么基本数据类型的数据就需要用包装类来包装。

| 序号 | 基本数据类型 | 包装类    |
| ---- | ------------ | --------- |
| 1    | byte         | Byte      |
| 2    | short        | Short     |
| 3    | int          | Integer   |
| 4    | long         | Long      |
| 5    | float        | Float     |
| 6    | double       | Double    |
| 7    | char         | Character |
| 8    | boolean      | Boolean   |
| 9    | void         | Void      |

### 11.1.2  装箱与拆箱

JDK1.5之后，可以自动装箱与拆箱。

注意：只能与自己对应的类型之间才能实现自动装箱与拆箱。

```java
Integer i = 1;
Double d = 1;//错误的，1是int类型
```

 装箱：把基本数据类型转为包装类对象。

> 转为包装类的对象，是为了使用专门为对象设计的API和特性

拆箱：把包装类对象拆为基本数据类型。

> 转为基本数据类型，一般是因为需要运算，Java中的大多数运算符是为基本数据类型设计的。比较、算术等



总结：对象（引用数据类型）能用的运算符有哪些？

（1）instanceof

（2）=：赋值运算符

（3）==和!=：用于比较地址，但是要求左右两边对象的类型一致或者是有父子类继承关系。

（4）对于字符串这一种特殊的对象，支持“+”，表示拼接。

### 11.1.3 包装类的一些API

1、基本数据类型和字符串之间的转换

（1）把基本数据类型转为字符串

```java
int a = 10;
//String str = a;//错误的
//方式一：
String str = a + "";
//方式二：
String str = String.valueOf(a);
```

（2）把字符串转为基本数据类型

```java
int a = Integer.parseInt("整数的字符串");
double a = Double.parseDouble("小数的字符串");
boolean b = Boolean.parseBoolean("true或false");
```

2、数据类型的最大最小值

```java
Integer.MAX_VALUE和Integer.MIN_VALUE
Long.MAX_VALUE和Long.MIN_VALUE
Double.MAX_VALUE和Double.MIN_VALUE
```

3、转大小写

```java
Character.toUpperCase('x');
Character.toLowerCase('X');
```

4、转进制

```java
Integer.toBinaryString(int i) 
Integer.toHexString(int i)
Integer.toOctalString(int i)
```

### 11.1.4 包装类对象的缓存问题

| 包装类    | 缓存对象    |
| --------- | ----------- |
| Byte      | -128~127    |
| Short     | -128~127    |
| Integer   | -128~127    |
| Long      | -128~127    |
| Float     | 没有        |
| Double    | 没有        |
| Character | 0~127       |
| Boolean   | true和false |

```java
Integer i = 1;
Integer j = 1;
System.out.println(i == j);//true

Integer i = 128;
Integer j = 128;
System.out.println(i == j);//false

Integer i = new Integer(1);//新new的在堆中
Integer j = 1;//这个用的是缓冲的常量对象，在方法区
System.out.println(i == j);//false

Integer i = new Integer(1);//新new的在堆中
Integer j = new Integer(1);//另一个新new的在堆中
System.out.println(i == j);//false

Integer i = new Integer(1);
int j = 1;
System.out.println(i == j);//true，凡是和基本数据类型比较，都会先拆箱，按照基本数据类型的规则比较
```

## 11.2 字符串

### 11.2.1 字符串的特点

1、字符串String类型本身是final声明的，意味着我们不能继承String。

2、字符串的对象也是不可变对象，意味着一旦进行修改，就会产生新对象

> 我们修改了字符串后，如果想要获得新的内容，必须重新接受。
>
> 如果程序中涉及到大量的字符串的修改操作，那么此时的时空消耗比较高。可能需要考虑使用StringBuilder或StringBuffer。

3、String对象内部是用字符数组进行保存的

> JDK1.9之前有一个char[] value数组，JDK1.9之后byte[]数组

4、String类中这个char[] values数组也是final修饰的，意味着这个数组不可变，然后它是private修饰，外部不能直接操作它，String类型提供的所有的方法都是用新对象来表示修改后内容的，所以保证了String对象的不可变。

5、就因为字符串对象设计为不可变，那么所以字符串有常量池来保存很多常量对象

常量池在方法区。

如果细致的划分：

（1）JDK1.6及其之前：方法区

（2）JDK1.7：堆

（3）JDK1.8：元空间

字符数组  

### 11.2.2  字符串对象的比较

1、==：比较是对象的地址

> 只有两个字符串变量都是指向字符串的常量对象时，才会返回true

```java
String str1 = "hello";
String str2 = "hello";
str1 == str2//true
```

2、equals：比较是对象的内容，因为String类型重写equals，区分大小写

只要两个字符串的字符内容相同，就会返回true

```java
String str1 = new String("hello");
String str2 = new String("hello");
str1.equals(strs) //true
```

3、equalsIgnoreCase：比较的是对象的内容，不区分大小写

```java
String str1 = new String("hello");
String str2 = new String("HELLO");
str1.equalsIgnoreCase(strs) //true
```

4、compareTo：String类型重写了Comparable接口的抽象方法，自然排序，按照字符的Unicode编码值进行比较大小的，严格区分大小写

```java
String str1 = "hello";
String str2 = "world";
str1.compareTo(str2) //小于0的值
```

5、compareToIgnoreCase：不区分大小写，其他按照字符的Unicode编码值进行比较大小

```java
String str1 = new String("hello");
String str2 = new String("HELLO");
str1.compareToIgnoreCase(str2)  //等于0
```



### 11.2.3 空字符的比较

1、哪些是空字符串

```java
String str1 = "";
String str2 = new String();
String str3 = new String("");
```

空字符串：长度为0

2、如何判断某个字符串是否是空字符串

```java
if("".equals(str))

if(str!=null  && str.isEmpty())

if(str!=null && str.equals(""))

if(str!=null && str.length()==0)
```



### 11.2.4 字符串的对象的个数

1、字符串常量对象

```java
String str1 = "hello";//1个，在常量池中
```

2、字符串的普通对象

```java
String str2 = new String();
String str22 = new String("");
//两个对象，一个是常量池中的空字符串对象，一个是堆中的空字符串对象
```

3、字符串的普通对象和常量对象一起

```java
String str3 = new String("hello");
//str3首先指向堆中的一个字符串对象，然后堆中字符串的value数组指向常量池中常量对象的value数组
```

### 11.2.5 字符串拼接结果

原则：

（1）常量+常量：结果是常量池

（2）常量与变量 或 变量与变量：结果是堆

（3）拼接后调用intern方法：结果在常量池

```java
	@Test
	public void test06(){
		String s1 = "hello";
		String s2 = "world";
		String s3 = "helloworld";
		
		String s4 = (s1 + "world").intern();//把拼接的结果放到常量池中
		String s5 = (s1 + s2).intern();
		
		System.out.println(s3 == s4);//true
		System.out.println(s3 == s5);//true
	}
	
	@Test
	public void test05(){
		final String s1 = "hello";
		final String s2 = "world";
		String s3 = "helloworld";
		
		String s4 = s1 + "world";//s4字符串内容也helloworld，s1是常量，"world"常量，常量+ 常量 结果在常量池中
		String s5 = s1 + s2;//s5字符串内容也helloworld，s1和s2都是常量，常量+ 常量 结果在常量池中
		String s6 = "hello" + "world";//常量+ 常量 结果在常量池中，因为编译期间就可以确定结果
		
		System.out.println(s3 == s4);//true
		System.out.println(s3 == s5);//true
		System.out.println(s3 == s6);//true
	}
	
	@Test
	public void test04(){
		String s1 = "hello";
		String s2 = "world";
		String s3 = "helloworld";
		
		String s4 = s1 + "world";//s4字符串内容也helloworld，s1是变量，"world"常量，变量 + 常量的结果在堆中
		String s5 = s1 + s2;//s5字符串内容也helloworld，s1和s2都是变量，变量 + 变量的结果在堆中
		String s6 = "hello" + "world";//常量+ 常量 结果在常量池中，因为编译期间就可以确定结果
		
		System.out.println(s3 == s4);//false
		System.out.println(s3 == s5);//false
		System.out.println(s3 == s6);//true
	}
```



### 11.2.6 字符串的API

（1）boolean isEmpty()

（2）int length()

（3）String concat(xx)：拼接，等价于+

（4）boolean contanis(xx)

（5）int indexOf()：从前往后找，要是没有返回-1

（6）int lastIndexOf()：从后往前找，要是没有返回-1

（7）char charAt(index)

（8）new String(char[] ) 或new String(char[] ,int, int)

（9）char[] toCharArray()

（10）byte[] getBytes()：编码，把字符串变为字节数组，按照平台默认的字符编码进行编码

​	byte[] getBytes(字符编码方式)：按照指定的编码方式进行编码

（11）new String(byte[] ) 或 new String(byte[], int, int)：解码，按照平台默认的字符编码进行解码

​           new String(byte[]，字符编码方式 ) 或 new String(byte[], int, int，字符编码方式)：解码，按照指定的编码方式进行解码

（12）String subString(int begin)：从[begin]开始到最后

String subString(int begin,int end)：从[begin, end)

（13）boolean matchs(正则表达式)

（14）String replace(xx,xx)：不支持正则

String replaceFirst(正则，value)：替换第一个匹配部分

String repalceAll(正则， value)：替换所有匹配部分

（15）String[] split(正则)：按照某种规则进行拆分

（16）boolean startsWith(xx)：是否以xx开头

boolean endsWith(xx)：是否以xx结尾

（17）String trim()：去掉前后空白符，字符串中间的空白符不会去掉

（18）String toUpperCase()：转大写

（19）String  toLowerCase()：转小写

面试题：字符串的length和数组的length有什么不同？

字符串的length()，数组的length属性

## 11.3 可变字符序列

1、可变字符序列：StringBuilder和StringBuffer

StringBuffer：老的，线程安全的（因为它的方法有synchronized修饰）

StringBuilder：线程不安全的



2、面试题：String和StringBuilder、StringBuffer的区别？

String：不可变对象，不可变字符序列

StringBuilder、StringBuffer： 可变字符序列



3、常用的API，StringBuilder、StringBuffer的API是完全一致的

（1）append(xx)：拼接，追加

（2）insert(int index, xx)：插入

（3）delete(int start, int end)

deleteCharAt(int index)

（4）set(int index, xx)

（5）reverse()：反转

....  替换、截取、查找...



## 11.4 和数学相关的

1、java.lang.Math类

（1）sqrt()：求平方根

（2）pow(x,y)：求x的y次方

（3）random()：返回[0,1)范围的小数

（4）max(x,y)：找x,y最大值

​	  min(x,y)：找最小值

（5）round(x)：四舍五入

​         ceil(x)：进一

​         floor(x)：退一

.....



2、java.math包

BigInteger：大整数

BigDecimal：大小数

运算通过方法完成：add(),subtract(),multiply(),divide()....



## 11.5 日期时间API

### 11.5.1 JDK1.8之前

1、java.util.Date

new  Date()：当前系统时间

long  getTime()：返回该日期时间对象距离1970-1-1 0.0.0 0毫秒之间的毫秒值

new Date(long 毫秒)：把该毫秒值换算成日期时间对象

2、java.util.Calendar：

（1）getInstance()：得到Calendar的镀锡

（2）get(常量)

3、java.text.SimpleDateFormat：日期时间的格式化

y：表示年

M：月

d：天

H： 小时，24小时制

h：小时，12小时制

m：分

s：秒

S：毫秒

E：星期

D：年当中的天数

```java
	@Test
	public void test10() throws ParseException{
		String str = "2019年06月06日 16时03分14秒 545毫秒  星期四 +0800";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒  E Z");
		Date d = sf.parse(str);
		System.out.println(d);
	}
	
	@Test
	public void test9(){
		Date d = new Date();

		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒  E Z");
		//把Date日期转成字符串，按照指定的格式转
		String str = sf.format(d);
		System.out.println(str);
	}
	
	@Test
	public void test8(){
		String[] all = TimeZone.getAvailableIDs();
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
	}
	
	@Test
	public void test7(){
		TimeZone t = TimeZone.getTimeZone("America/Los_Angeles");
		
		//getInstance(TimeZone zone)
		Calendar c = Calendar.getInstance(t);
		System.out.println(c);
	}
	
	@Test
	public void test6(){
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = c.get(Calendar.MONTH)+1;
		System.out.println(month);
		
		//...
	}
	
	@Test
	public void test5(){
		long time = Long.MAX_VALUE;
		Date d = new Date(time);
		System.out.println(d);
	}
	
	@Test
	public void test4(){
		long time = 1559807047979L;
		Date d = new Date(time);
		System.out.println(d);
	}
	@Test
	public void test3(){
		Date d = new Date();
		long time = d.getTime();
		System.out.println(time);//1559807047979
	}
	
	@Test
	public void test2(){
		long time = System.currentTimeMillis();
		System.out.println(time);//1559806982971
		//当前系统时间距离1970-1-1 0:0:0 0毫秒的时间差，毫秒为单位
	}
	
	@Test
	public void test1(){
		Date d = new Date();
		System.out.println(d);
	}
```



### 11.5.2 JDK1.8之后

java.time及其子包中。

1、LocalDate、LocalTime、LocalDateTime

（1）now()：获取系统日期或时间

（2）of(xxx)：或者指定的日期或时间

（3）运算：运算后得到新对象，需要重新接受

plusXxx()：在当前日期或时间对象上加xx

minusXxx() ：在当前日期或时间对象上减xx

| 方法                                                         | **描述**                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| now() / now(ZoneId zone)                                     | 静态方法，根据当前时间创建对象/指定时区的对象                |
| of()                                                         | 静态方法，根据指定日期/时间创建对象                          |
| getDayOfMonth()/getDayOfYear()                               | 获得月份天数(1-31) /获得年份天数(1-366)                      |
| getDayOfWeek()                                               | 获得星期几(返回一个 DayOfWeek 枚举值)                        |
| getMonth()                                                   | 获得月份, 返回一个 Month 枚举值                              |
| getMonthValue() / getYear()                                  | 获得月份(1-12) /获得年份                                     |
| getHours()/getMinute()/getSecond()                           | 获得当前对象对应的小时、分钟、秒                             |
| withDayOfMonth()/withDayOfYear()/withMonth()/withYear()      | 将月份天数、年份天数、月份、年份修改为指定的值并返回新的对象 |
| with(TemporalAdjuster  t)                                    | 将当前日期时间设置为校对器指定的日期时间                     |
| plusDays(), plusWeeks(), plusMonths(), plusYears(),plusHours() | 向当前对象添加几天、几周、几个月、几年、几小时               |
| minusMonths() / minusWeeks()/minusDays()/minusYears()/minusHours() | 从当前对象减去几月、几周、几天、几年、几小时                 |
| plus(TemporalAmount t)/minus(TemporalAmount t)               | 添加或减少一个 Duration 或 Period                            |
| isBefore()/isAfter()                                         | 比较两个 LocalDate                                           |
| isLeapYear()                                                 | 判断是否是闰年（在LocalDate类中声明）                        |
| format(DateTimeFormatter  t)                                 | 格式化本地日期、时间，返回一个字符串                         |
| parse(Charsequence text)                                     | 将指定格式的字符串解析为日期、时间                           |

2、DateTimeFormatter：日期时间格式化

该类提供了三种格式化方法：

预定义的标准格式。如：ISO_DATE_TIME;ISO_DATE

本地化相关的格式。如：ofLocalizedDate(FormatStyle.MEDIUM)

自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)

```java
	@Test
	public void test10(){
		LocalDateTime now = LocalDateTime.now();
		
//		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);//2019年6月6日 下午04时40分03秒
		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);//19-6-6 下午4:40
		String str = df.format(now);
		System.out.println(str);
	}
	@Test
	public void test9(){
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter df = DateTimeFormatter.ISO_DATE_TIME;//2019-06-06T16:38:23.756
		String str = df.format(now);
		System.out.println(str);
	}
	
	@Test
	public void test8(){
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒  SSS毫秒  E 是这一年的D天");
		String str = df.format(now);
		System.out.println(str);
	}
	
	@Test
	public void test7(){
		LocalDate now = LocalDate.now();
		LocalDate before = now.minusDays(100);
		System.out.println(before);//2019-02-26
	}
	
	@Test
	public void test06(){
		LocalDate lai = LocalDate.of(2019, 5, 13);
		LocalDate go = lai.plusDays(160);
		System.out.println(go);//2019-10-20
	}
	
	@Test
	public void test05(){
		LocalDate lai = LocalDate.of(2019, 5, 13);
		System.out.println(lai.getDayOfYear());
	}
	
	
	@Test
	public void test04(){
		LocalDate lai = LocalDate.of(2019, 5, 13);
		System.out.println(lai);
	}
	
	@Test
	public void test03(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
	}
	
	@Test
	public void test02(){
		LocalTime now = LocalTime.now();
		System.out.println(now);
	}
	
	@Test
	public void test01(){
		LocalDate now = LocalDate.now();
		System.out.println(now);
	}
```

# 第十二章 集合

## 12.1 概念

数据结构：存储数据的某种结构

（1）底层的物理结构

①数组：开辟连续的存储空间，每一个元素使用[下标]进行区别

②链式：不需要开辟连续的存储空间，但是需要“结点”来包装要存储的数据，结点包含两部分内容：

​	A、数据

​	B、记录其他结点的地址，例如：next，pre，left，right，parent等

（2）表现出来的逻辑结构：动态数组、单向链表、双向链表、队列、栈、二叉树、哈希表、图等

## 12.2 手动实现一些逻辑结构

1、动态数组

包含：

（1）内部使用一个数组，用来存储数据

（2）内部使用一个total，记录实际存储的元素的个数

```java
public class MyArrayList {
	//为什么使用Object，因为只是说这个容器是用来装对象的，但是不知道用来装什么对象。
	private Object[] data;
	private int total;
	
	public MyArrayList(){
		data = new Object[5];
	}
	
	//添加一个元素
	public void add(Object obj){
		//检查是否需要扩容
		checkCapacity();
		data[total++] = obj;
	}

	private void checkCapacity() {
		//如果data满了，就扩容为原来的2倍
		if(total >= data.length){
			data = Arrays.copyOf(data, data.length*2);
		}
	}
	
	//返回实际元素的个数
	public int size(){
		return total;
	}
	
	//返回数组的实际容量
	public int capacity(){
		return data.length;
	}
	
	//获取[index]位置的元素
	public Object get(int index){
		//校验index的合理性范围
		checkIndex(index);
		return data[index];
	}

	private void checkIndex(int index) {
		if(index<0 || index>=total){
			throw new RuntimeException(index+"对应位置的元素不存在");
//			throw new IndexOutOfBoundsException(index+"越界");
		}
	}
	
	//替换[index]位置的元素
	public void set(int index, Object value){
		//校验index的合理性范围
		checkIndex(index);
		
		data[index] = value;
	}
	
	//在[index]位置插入一个元素value
	public void insert(int index, Object value){
		/*
		 * (1)考虑下标的合理性
		 * (2)总长度是否够
		 * (3)[index]以及后面的元素往后移动，把[index]位置腾出来
		 * (4)data[index]=value  放入新元素
		 * (5)total++  有效元素的个数增加
		 */
		
		//(1)考虑下标的合理性：校验index的合理性范围
		checkIndex(index);
		
		//(2)总长度是否够：检查是否需要扩容
		checkCapacity();
		
		//(3)[index]以及后面的元素往后移动，把[index]位置腾出来
		/*
		 * 假设total = 5, data.length= 10, index= 1
		 * 有效元素的下标[0,4]
		 * 移动：[1]->[2],[2]->[3],[3]->[4],[4]->[5]
		 * 移动元素的个数：total-index
		 */
		System.arraycopy(data, index, data, index+1, total-index);
		
		//(4)data[index]=value  放入新元素
		data[index] = value;
		
		//(5)total++  有效元素的个数增加
		total++;
	}
	
	//返回所有实际存储的元素
	public Object[] getAll(){
		//返回total个
		return Arrays.copyOf(data, total);
	}
	
	//删除[index]位置的元素
	public void remove(int index){
		/*
		 * (1)校验index的合理性范围
		 * (2)移动元素，把[index+1]以及后面的元素往前移动
		 * (3)把data[total-1]=null  让垃圾回收器尽快回收
		 * (4)总元素个数减少 total--
		 */
		
		//(1)考虑下标的合理性：校验index的合理性范围
		checkIndex(index);
		
		//(2)移动元素，把[index+1]以及后面的元素往前移动
		/*
		 * 假设total=8, data.length=10, index = 3
		 * 有效元素的范围[0,7]
		 * 移动：[4]->[3],[5]->[4],[6]->[5],[7]->[6]
		 * 移动了4个：total-index-1
		 */
		System.arraycopy(data, index+1, data, index, total-index-1);
		
		//(3)把data[total-1]=null  让垃圾回收器尽快回收
		data[total-1] = null;
		
//		(4)总元素个数减少 total--
		total--;
	}
	
	//查询某个元素的下标
	public int indexOf(Object obj){
		if(obj == null){
			for (int i = 0; i < total; i++) {
				if(data[i] == null){//等价于 if(data[i] == obj)
					return i;
				}
			}
		}else{
			for (int i = 0; i < data.length; i++) {
				if(obj.equals(data[i])){
					return i;
				}
			}
		}
		return -1;
	}
	
	//删除数组中的某个元素
	//如果有重复的，只删除第一个
	public void remove(Object obj){
		/*
		 * (1)先查询obj的[index]
		 * (2)如果存在，就调用remove(index)删除就可以
		 */
		
		//(1)先查询obj的[index]
		int index = indexOf(obj);
		
		if(index != -1){
			remove(index);
		}
		//不存在，可以什么也不做
		//不存在，也可以抛异常
		//throw new RuntimeException(obj + "不存在");
	}
	
	public void set(Object old, Object value){
		/*
		 * (1)查询old的[index]
		 * (2)如果存在，就调用set(index, value)
		 */
		
//		(1)查询old的[index]
		int index = indexOf(old);
		if(index!=-1){
			set(index, value);
		}
		
		//不存在，可以什么也不做
	}
}
```



2、单向链表

包含：

（1）包含一个Node类型的成员变量first：用来记录第一个结点的地址

如果这个链表是空的，还没有任何结点，那么first是null。

最后一个结点的特征：就是它的next是null

（2）内部使用一个total，记录实际存储的元素的个数

（3）使用了一个内部类Node

```java
private class Node{
    Object data;
    Node next;
}
```

```java
public class SingleLinkedList {
	//这里不需要数组，不需要其他的复杂的结构，我只要记录单向链表的“头”结点
	private Node first;//first中记录的是第一个结点的地址
	private int total;//这里我记录total是为了后面处理的方便，例如：当用户获取链表有效元素的个数时，不用现数，而是直接返回total等
	
	/*
	 * 内部类，因为这种Node结点的类型，在别的地方没有用，只在单向链表中，用于存储和表示它的结点关系。
	 * 因为我这里涉及为内部类型。
	 */
	private class Node{
		Object data;//因为数据可以是任意类型的对象，所以设计为Object
		Node next;//因为next中记录的下一个结点的地址，因此类型是结点类型
		//这里data,next没有私有化，是希望在外部类中可以不需要get/set，而是直接“结点对象.data","结点对象.next"使用
		Node(Object data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public void add(Object obj){
		/*
		 * (1)把obj的数据，包装成一个Node类型结点对象
		 * (2)把新结点“链接”当前链表的最后
		 * ①当前新结点是第一个结点
		 * 如何判断是否是第一个   if(first==null)说明暂时还没有第一个
		 * ②先找到目前的最后一个，把新结点链接到它的next中
		 * 如何判断是否是最后一个   if(某个结点.next == null)说明这个结点是最后一个
		 */
//		(1)把obj的数据，包装成一个Node类型结点对象
		//这里新结点的next赋值为null，表示新结点是最后一个结点
		Node newNode = new Node(obj, null);
		
		//①当前新结点是第一个结点
		if(first == null){
			//说明newNode是第一个
			first = newNode;
		}else{
			//②先找到目前的最后一个，把新结点链接到它的next中
			Node node = first;
			while(node.next != null){
				node = node.next;
			}
			//退出循环时node指向最后一个结点
			
			//把新结点链接到它的next中
			node.next = newNode;
		}
		
		total++;
	}
	
	public int size(){
		return total;
	}
	
	public Object[] getAll(){
		//(1)创建一个数组，长度为total
		Object[] all = new Object[total];
		
		//(2)把单向链表的每一个结点中的data，拿过来放到all数组中
		Node node = first;
		for (int i = 0; i < total; i++) {
//			all[i] = 结点.data;
			all[i] = node.data;
			//然后node指向下一个
			node = node.next;
		}
		
		//(3)返回数组
		return all;
	}
	
	public void remove(Object obj){
		if(obj == null){
			//(1)先考虑是否是第一个
			if(first!=null){//链表非空
				
				//要删除的结点正好是第一个结点
				if(first.data == null){
					//让第一个结点指向它的下一个
					first = first.next;
					total--;
					return;
				}
				
				//要删除的不是第一个结点
				Node node = first.next;//第二个结点
				Node last = first;
				while(node.next!=null){//这里不包括最后一个，因为node.next==null，不进入循环，而node.next==null是最后一个
					if(node.data == null){
						last.next = node.next;
						total--;
						return;
					}
					last = node;
					node = node.next;
				}
				
				//单独判断最后一个是否是要删除的结点
				if(node.data == null){
					//要删除的是最后一个结点
					last.next = null;
					total--;
					return;
				}
			}
		}else{
			//(1)先考虑是否是第一个
			if(first!=null){//链表非空
				
				//要删除的结点正好是第一个结点
				if(obj.equals(first.data)){
					//让第一个结点指向它的下一个
					first = first.next;
					total--;
					return;
				}
				
				//要删除的不是第一个结点
				Node node = first.next;//第二个结点
				Node last = first;
				while(node.next!=null){//这里不包括最后一个，因为node.next==null，不进入循环，而node.next==null是最后一个
					if(obj.equals(node.data)){
						last.next = node.next;
						total--;
						return;
					}
					last = node;
					node = node.next;
				}
				
				//单独判断最后一个是否是要删除的结点
				if(obj.equals(node.data)){
					//要删除的是最后一个结点
					last.next = null;
					total--;
					return;
				}
			}
		}
	}

	public int indexOf(Object obj){
		if(obj == null){
			Node node = first;
			for (int i = 0; i < total; i++) {
				if(node.data == null){
					return i;
				}
				node = node.next;
			}
		}else{
			Node node = first;
			for (int i = 0; i < total; i++) {
				if(obj.equals(node.data)){
					return i;
				}
				node = node.next;
			}
		}
		return -1;
	}
}

```



## 12.3  Collection

数据结构，容器：

用来装对象....，等各种管理对象的容器。

容器有相同的操作标准：

(1)增

(2)删

(3)改

(4)查

...



因为集合的类型很多，那么我们把它们称为集合框架。



Java给这些集合抽取两大接口：
 * 1、Collection：
 * 		规范单值集合的接口，obj   单个
 * 2、Map
 * 		规范对值集合的接口，(key,value)  两个
 * Collection Map

也就是把集合框架分为两个家族：Collection（一组对象）和Map（一组映射关系、一组键值对）

Collection  Map

一组对象   一组映射关系、一组键值对

Colleciton Map

### 12.3.1 Collection

1、Collection：接口
 （1）它是根接口
 （2）它没有直接的实现类，有更具体的子接口：List和Set...
 （3）有一些的元素是可以重复的，有些集合的元素是不能重复，有些集合的元素是有序的，有些集合的元素是无序的


Collection是代表一种对象的集合。它是Collection系列的根接口。

它们虽然：有些可能是有序的，有些可能是无序的，有些可能可以重复的，有些不能重复的，但是它们有共同的操作规范，因此这些操作的规范就抽象为了Collection接口。

常用方法：

（1）boolean add(Object obj)：添加一个

（2）boolean addAll（Collection c）：添加多个

（3）boolean remove(Object obj)：删除一个

（4）boolean removeAll(Collection c )： 删除多个

（5）boolean contains(Object c)：是否包含某个

（6）boolean containsAll(Collection c)： 是否包含所有

（7）boolean isEmpty()：是否为空

（8）int size()：获取元素个数

（9）void clear()：清空集合

（10）Object[] toArray()：获取所有元素

（11）Iterator iterator()： 获取遍历当前集合的迭代器对象

（12）retainAll(Collection c)：求当前集合与c集合的交集

2、API
（1）添加
 add(Object obj)：添加一个元素
 addAll(Collection c)：添加多个元素

 （2）获取有效元素的个数
  int size()

```java
@SuppressWarnings("all")
    @Test
    public void test1() {
        /*
         * 我这里左边写Collection，目的是只关注Collection
         * 因为多态引用时，c编译期间只能访问Collection的方法
         */
        Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已

        c.add("张三");
        c.add("李四");
        c.add("王五");
        c.add("柳六在");

        Collection c2 = new ArrayList();
        c2.add("柳七七");
        c2.add("柳八八");
        c2.add("柳九九");
        System.out.println("获取有效元素的个数：" + c2.size()); //获取有效元素的个数：3
        c.addAll(c2);
        System.out.println("获取有效元素的个数：" + c.size());//获取有效元素的个数：7
        System.out.println(c);//[张三, 李四, 王五, 柳六在, 柳七七, 柳八八, 柳九九]
    }
```



demo

```java

    @SuppressWarnings("all")
    @Test
    public void test2() {
        /*
         * 我这里左边写Collection，目的是只关注Collection
         * 因为多态引用时，c编译期间只能访问Collection的方法
         */
        Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c.add(1);
        c.add(2);
        c.add(3);

        Collection c2 = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c2.add("张三");
        c2.add("李四");
        c2.add("王五");

        c.addAll(c2);//把c2中的所有元素都添加到c集合中
//		c.add(c2);

        System.out.println("获取有效元素的个数：" + c.size());//获取有效元素的个数：6
        System.out.println(c);//[1, 2, 3, 张三, 李四, 王五]
    }
```



 （3）是否包含
 contains(Object o) ：判断o是否在当前的集合中
  containsAll(Collection c) ：判断c是否是当前集合的子集

```java
 @SuppressWarnings("all")
    @Test
    public void test3() {
        Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c.add("张三");
        c.add("李四");
        c.add("王五");
        System.out.println(c.contains("张三"));//true
        System.out.println(c.contains("李大炮"));//false
    }

```



containsAll

```java

    @SuppressWarnings("all")
    @Test
    public void test4() {
        Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c.add("张三");
        c.add("李四");
        c.add("王五");

        Collection c2 = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c2.add("张三");
        c2.add("李四");

        Collection c3 = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c3.add("张三");
        c3.add("李大炮");

        System.out.println(c.containsAll(c2));//true c2是c的子集
        System.out.println(c.containsAll(c3));//false c3不是c的子集
    }

```



 （4）boolean isEmpty()  ：判断当前集合是否为空
  等价于   集合对象.size()==0

```java

```



  （5）remove(Object o)：删除一个
  removeAll(Collection c)：删除多个      this = this - this ∩ c
  clear()：清空所有

remove

```java
    @SuppressWarnings("all")
    @Test
    public void test5() {
        Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c.add("张三");
        c.add("李四");
        c.add("王五");
        ////说明下ArrayList重写了toString的
        System.out.println(c);//[张三, 李四, 王五]
        c.remove("张三");//删除一个
        System.out.println(c);//[李四, 王五]
        c.remove("六小子");//删除个不存在的  不影响
        System.out.println(c);//[李四, 王五]
    }
```

removeAll   this = this - this ∩ c

```java

    @SuppressWarnings("all")
    @Test
    public void test6() {
        Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c.add("张三");
        c.add("李四");
        c.add("王五");
        System.out.println(c);//[张三, 李四, 王五]
        Collection c2 = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c2.add("张三");
        c2.add("李四");
        c2.add("柳小子");
        System.out.println(c2);//[张三, 李四, 柳小子]
        c.removeAll(c2);
        System.out.println(c);//说明ArrayList重写了toString
        //[王五]
    }

```

  clear()

```java
  @SuppressWarnings("all")
    @Test
    public void test7() {
        Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c.add("张三");
        c.add("李四");
        c.add("王五");

        Collection c2 = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c2.add("张三");
        c2.add("柳可爱");
        c.addAll(c2);//直接加 重复的也加
        ////说明ArrayList重写了toString
        System.out.println(c);//[张三, 李四, 王五, 张三, 柳可爱]
        c.removeAll(c2);
        System.out.println(c);//[李四, 王五]
        System.out.println(c.size());//2
        c.clear();
        System.out.println(c.isEmpty());//true
        System.out.println(c.size());//0
    }

```



  （6）retainAll(Collection<?> c) ：保留交集   this = this ∩ c

```java
    @SuppressWarnings("all")
    @Test
    public void test8() {
        Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c.add("张三");
        c.add("李四");
        c.add("王五");


        Collection c2 = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c2.add("张三");
        c2.add("杨三宝");
        c.retainAll(c2);
        System.out.println(c);//[张三]
        System.out.println(c2);//[张三, 杨三宝]
        c.addAll(c2);
        System.out.println(c);//[张三, 张三, 杨三宝]
        c.addAll(c);
        System.out.println(c);//[张三, 张三, 杨三宝, 张三, 张三, 杨三宝]
        System.out.println(c2);//[张三, 杨三宝]
        //retainAll(Collection<?> c) ：保留交集   this = this ∩ c
        c.retainAll(c2);
        System.out.println(c);//[张三, 张三, 杨三宝, 张三, 张三, 杨三宝]
    }

```



  （7）Object[] toArray()  ：把集合中的元素用一个数组返回

```java
 @SuppressWarnings("all")
    @Test
    public void test9() {
        Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c.add("张三");
        c.add("李四");
        c.add("王五");
        System.out.println(c);//[张三, 李四, 王五]
        Object[] all = c.toArray();
        System.out.println(all);//[Ljava.lang.Object;@4f2410ac
        System.out.println(all.length);//3
        System.out.println(Arrays.toString(all));//[张三, 李四, 王五]
    }
```



### 12.3.2  Collection系列的集合的遍历

集合的遍历  挨个访问集合的元素

（1）Object[] toArray()：先返回数组，然后遍历数组

```java
@SuppressWarnings("all")
    @Test
    public void test9() {
        Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
        c.add("张三");
        c.add("李四");
        c.add("王五");
        System.out.println(c);//[张三, 李四, 王五]
        Object[] all = c.toArray();
        System.out.println(all);//[Ljava.lang.Object;@4f2410ac
        System.out.println(all.length);//3
        System.out.println(Arrays.toString(all));//[张三, 李四, 王五]

        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }
        //Result
        //张三
        //李四
        //王五
    }
```



（2）迭代器设计模式 明确使用Iterator迭代器
每一个Collection系列的集合，内部都自带一个迭代器
java.util.Iterator：接口
它是所有迭代器的标准接口。

Iterator 接口的方法：

（1）boolean hasNext()

（2）Object next()

（3）void remove()

（1）判断是否还有下一个元素：hasNext()
（2）访问它的下一个元素：next()
（3）移除下一个元素：remove()



java.util.Iterator：迭代器接口，这个接口的实现类在每一种集合类中，例如：ArrayList内部有一个内部类实现了Iterator接口
  这里声明为内部类有两个原因：
   （1）每一种集合的内部实现（物理结构不同），意味着对迭代器的实现是不同的，每一种集合都要单独定制迭代器。
  （2）内部类可以直接访问外部类的私有的属性，成员，迭代器就可以直接访问集合的私有的元素。

```java
Collection c = ....;

Iterator iter = c.iterator();
while(iter.hashNext()){
    Object obj = iter.next();
    //...
}
```

demo

```java
@SuppressWarnings("all")
	@Test
	public void test1(){
		Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		//返回这个集合自带的迭代器对象
		//让这个迭代器对象去挨个的访问元素
		Iterator iterator = c.iterator();
		while(iterator.hasNext()){
			Object obj = iterator.next();
			System.out.println(obj);
		}
		//Result
		//张三
		//李四
		//王五
	}
```



```java
@SuppressWarnings("all")
	@Test
	public void test2(){
		Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		//返回这个集合自带的迭代器对象
		//让迭代器去挨个的访问元素
		Iterator iterator = c.iterator();
		while(iterator.hasNext()){
			String obj = (String) iterator.next();
			//要姓“王”走人
			if(obj.startsWith("王")){
				iterator.remove();
			}
		}
		
		System.out.println(c);//[张三, 李四]
	}
```



```java

```



2、foreach:增强for循环

   foreach循环可以用于遍历数组、Collection系列的集合等容器。
   语法结构：
   ```java
   for(元素的类型  元素临时名称  :  数组和集合名){
   
   }
   ```
 不同于普通for循环。

```java
 for(int i=0; i<5; i++){
   }
```

  什么样集合或容器类型可以使用foreach循环？

（1）数组：

（2）实现了java.lang.Iterable接口

这个接口有一个抽象方法：Iterator iterator()

Iterator也是一个接口，它的实现类，通常在集合（容器）类中用内部类实现。并在iterator()的方法中创建它的对象。

   凡是实现了java.lang.Iterable接口（可迭代）的集合或容器都支持foreach循环

   foreach底层还是调用Iterator迭代器来遍历集合。

```
Collection c = ....;

for(Object  obj :  c){
    //...
}
```

Demo

```java
@SuppressWarnings("all")
	@Test
	public void test3(){
		Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		//Object：元素的数据类型
		//obj：临时的元素名称
		//c:要遍历的集合的名称
		for (Object obj : c) {
			System.out.println(obj);
		}
		//Result
		//张三
		//李四
		//王五
	}
```



```java
public class MyArrayList implements Iterable{
	//为什么使用Object，因为只是说这个容器是用来装对象的，但是不知道用来装什么对象。
	private Object[] data;
	private int total;
	
	//其他代码省略....

	@Override
	public Iterator iterator() {
		return new MyItr();
	}
	
	private class MyItr implements Iterator{
		private int cursor;//游标

		@Override
		public boolean hasNext() {
			return cursor!=total;
		}

		@Override
		public Object next() {
			return data[cursor++];
		}
	}
}
```

MyArrayList.java

```java
import java.util.Arrays;
import java.util.Iterator;

/*
 * MyArrayList我们自己设计的一种数据结构，一种逻辑结构，当别人用我这个MyArrayList的对象时，就是一个容器对象，
 * 可以用来装对象。
 */
public class MyArrayList implements Iterable{
	//为什么使用Object，因为只是说这个容器是用来装对象的，但是不知道用来装什么对象。
	private Object[] data;
	private int total;
	
	public MyArrayList(){
		data = new Object[5];
	}
	
	//添加一个元素
	public void add(Object obj){
		//检查是否需要扩容
		checkCapacity();
		data[total++] = obj;
	}

	private void checkCapacity() {
		//如果data满了，就扩容为原来的2倍
		if(total >= data.length){
			data = Arrays.copyOf(data, data.length*2);
		}
	}
	
	//返回实际元素的个数
	public int size(){
		return total;
	}
	
	//返回数组的实际容量
	public int capacity(){
		return data.length;
	}
	
	//获取[index]位置的元素
	public Object get(int index){
		//校验index的合理性范围
		checkIndex(index);
		return data[index];
	}

	private void checkIndex(int index) {
		if(index<0 || index>=total){
			throw new RuntimeException(index+"对应位置的元素不存在");
//			throw new IndexOutOfBoundsException(index+"越界");
		}
	}
	
	//替换[index]位置的元素
	public void set(int index, Object value){
		//校验index的合理性范围
		checkIndex(index);
		
		data[index] = value;
	}
	
	//在[index]位置插入一个元素value
	public void insert(int index, Object value){
		/*
		 * (1)考虑下标的合理性
		 * (2)总长度是否够
		 * (3)[index]以及后面的元素往后移动，把[index]位置腾出来
		 * (4)data[index]=value  放入新元素
		 * (5)total++  有效元素的个数增加
		 */
		
		//(1)考虑下标的合理性：校验index的合理性范围
		checkIndex(index);
		
		//(2)总长度是否够：检查是否需要扩容
		checkCapacity();
		
		//(3)[index]以及后面的元素往后移动，把[index]位置腾出来
		/*
		 * 假设total = 5, data.length= 10, index= 1
		 * 有效元素的下标[0,4]
		 * 移动：[1]->[2],[2]->[3],[3]->[4],[4]->[5]
		 * 移动元素的个数：total-index
		 */
		System.arraycopy(data, index, data, index+1, total-index);
		
		//(4)data[index]=value  放入新元素
		data[index] = value;
		
		//(5)total++  有效元素的个数增加
		total++;
	}
	
	//返回所有实际存储的元素
	public Object[] getAll(){
		//返回total个
		return Arrays.copyOf(data, total);
	}
	
	//删除[index]位置的元素
	public void remove(int index){
		/*
		 * (1)校验index的合理性范围
		 * (2)移动元素，把[index+1]以及后面的元素往前移动
		 * (3)把data[total-1]=null  让垃圾回收器尽快回收
		 * (4)总元素个数减少 total--
		 */
		
		//(1)考虑下标的合理性：校验index的合理性范围
		checkIndex(index);
		
		//(2)移动元素，把[index+1]以及后面的元素往前移动
		/*
		 * 假设total=8, data.length=10, index = 3
		 * 有效元素的范围[0,7]
		 * 移动：[4]->[3],[5]->[4],[6]->[5],[7]->[6]
		 * 移动了4个：total-index-1
		 */
		System.arraycopy(data, index+1, data, index, total-index-1);
		
		//(3)把data[total-1]=null  让垃圾回收器尽快回收
		data[total-1] = null;
		
//		(4)总元素个数减少 total--
		total--;
	}
	
	//查询某个元素的下标
/*	public int indexOf(Object obj){
		for (int i = 0; i < total; i++) {
		//这两种写法都有风险
			if(obj.equals(data[i])){
				//if(data[i].equals(obj)){
				return i;//找到，返回第一个找到的
			}
		}
		return -1;//没找到返回-1
	}*/
	
	//查询某个元素的下标
	public int indexOf(Object obj){
		if(obj == null){
			for (int i = 0; i < total; i++) {
				if(data[i] == null){//等价于 if(data[i] == obj)
					return i;
				}
			}
		}else{
			for (int i = 0; i < data.length; i++) {
				if(obj.equals(data[i])){
					return i;
				}
			}
		}
		return -1;
	}
	
	//删除数组中的某个元素
	//如果有重复的，只删除第一个
	public void remove(Object obj){
		/*
		 * (1)先查询obj的[index]
		 * (2)如果存在，就调用remove(index)删除就可以
		 */
		
		//(1)先查询obj的[index]
		int index = indexOf(obj);
		
		if(index != -1){
			remove(index);
		}
		//不存在，可以什么也不做
		//不存在，也可以抛异常
		//throw new RuntimeException(obj + "不存在");
	}
	
	public void set(Object old, Object value){
		/*
		 * (1)查询old的[index]
		 * (2)如果存在，就调用set(index, value)
		 */
		
//		(1)查询old的[index]
		int index = indexOf(old);
		if(index!=-1){
			set(index, value);
		}
		
		//不存在，可以什么也不做
		//不存在，也可以抛异常
		//throw new RuntimeException(old + "不存在");
	}

	@Override
	public Iterator iterator() {
		return new MyItr();
	}
	
	private class MyItr implements Iterator{
		private int cursor;//游标

		@Override
		public boolean hasNext() {
			System.out.println("还有下一个");
			return cursor!=total;
		}

		@Override
		public Object next() {
			System.out.println("拿到下一个");
			return data[cursor++];
		}
		
	}
}

```



```java
 @SuppressWarnings("all")
    @Test
    public void test5() {
        //我自己写的动态数组
        MyArrayList list = new MyArrayList();
        list.add("张三");
        list.add("李四");
        list.add("王五");

        for (Object obj : list) {
            System.out.println(obj);
        }
        //Result
		//还有下一个
		//拿到下一个
		//张三
		//还有下一个
		//拿到下一个
		//李四
		//还有下一个
		//拿到下一个
		//王五
		//还有下一个
    }
```



思考：如果遍历数组，什么情况下选用foreach，什么情况下选用for循环？

当如果你的操作中涉及到[下标]操作时，用for最好。

当你只是查看元素的内容，那么选foreach更简洁一些。



思考：如果遍历Collection系列集合，什么情况下选用foreach，是否能选用for循环？

首先考虑使用foreach，如果该集合也有索引信息的话，也可以通过for来操作，如果没有下标的信息，就不要用for。即，如果该集合的物理结构是数组的，那么可以用for，如果物理结构是链式，那么使用下标操作效率很低。



思考：如果遍历Collection系列集合，什么情况下选用foreach，什么情况下使用Iterator？

如果只是查看集合的元素，使用foreach，代码会更简洁。

但是如果要涉及到在遍历集合的同时根据某种条件要删除元素等操作，那么选用Iterator。

## 12.4 List

### 12.4.1 List概述

List：是Collection的子接口。

List系列的集合：有序的、可重复的

List系列的常用集合：ArrayList、Vector、LinkedList、Stack

Stack

ArrayList

Vector

Stack

### 12.4.2 List的API

常用方法：

（1）boolean add(Object obj)：添加一个

（2）boolean addAll（Collection c）：添加多个

（3）void add(int index, Object obj)：添加一个，指定位置添加

（4）void addAll(int index, Collection c）：添加多个

（5）boolean remove(Object obj)：删除一个

（6）Object remove(int index)：删除指定位置的元素，并返回刚刚删除的元素

（7）boolean removeAll(Collection c )： 删除多个

（8）boolean contains(Object c)：是否包含某个

（9）boolean containsAll(Collection c)： 是否包含所有

（10）boolean isEmpty()：是否为空

（11）int size()：获取元素个数

（12）void clear()：清空集合

（13）Object[] toArray()：获取所有元素

（14）Iterator iterator()： 获取遍历当前集合的迭代器对象

（15）retainAll(Collection c)：求当前集合与c集合的交集

（16）ListIterator listIterator()：获取遍历当前集合的迭代器对象，这个迭代器可以往前、往后遍历

（17）ListIterator listIterator(int index)：从[index]位置开始，往前或往后遍历

（18）Object get(int index)：返回index位置的元素

（19）List  subList(int start, int end)：截取[start,end)部分的子列表



### 12.4.3 ListIterator 接口

Iterator 接口的方法：

（1）boolean hasNext()

（2）Object next()

（3）void remove()

ListIterator 是 Iterator子接口：增加了如下方法

（4）void add(Object obj)

（5）void set(Object obj)

（6）boolean hasPrevious()

（7）Object previous()

（8）int nextIndex()

（9）int previousIndex()



### 12.4.4 List的实现类们的区别

ArrayList、Vector、LinkedList、Stack

（1）ArrayList、Vector：都是动态数组

Vector是最早版本的动态数组，线程安全的，默认扩容机制是2倍，支持旧版的迭代器Enumeration

ArrayList是后增的动态数组，线程不安全的，默认扩容机制是1.5倍

Vector

ArrayList 动态数组 

（2）动态数组与LinkedList的区别

动态数组：底层物理结构是数组

​	优点：根据[下标]访问的速度很快

​	缺点：需要开辟连续的存储空间，而且需要扩容，移动元素等操作

LinkedList：底层物理结构是双向链表

​	优点：在增加、删除元素时，不需要移动元素，只需要修改前后元素的引用关系

​	缺点：我们查找元素时，只能从first或last开始查找

（3）Stack：栈

是Vector的子类。比Vector多了几个方法，能够表现出“先进后出或后进先出”的特点。

①Object peek()：访问栈顶元素

②Object pop()：弹出栈顶元素

③push()：把元素压入栈顶

（4）LinkedList可以作为很多种数据结构使用

单链表：只关注next就可以

队列：先进先出，找对应的方法

双端队列(JDK1.6加入)：两头都可以进出，找对应的方法

栈：先进后出，找对应的方法

建议：虽然LinkedList是支持对索引进行操作，因为它实现List接口的所有方法，但是我们不太建议调用类似这样的方法，因为效率比较低。



### 12.4.5 源码分析

#### （1）Vector

```java
    public Vector() {
        this(10);//指定初始容量initialCapacity为10
    }
	public Vector(int initialCapacity) {
        this(initialCapacity, 0);//指定capacityIncrement增量为0
    }
    public Vector(int initialCapacity, int capacityIncrement增量为0) {
        super();
        //判断了形参初始容量initialCapacity的合法性
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        //创建了一个Object[]类型的数组
        this.elementData = new Object[initialCapacity];//默认是10
        //增量，默认是0，如果是0，后面就按照2倍增加，如果不是0，后面就按照你指定的增量进行增量
        this.capacityIncrement = capacityIncrement;
    }
```

```java
//synchronized意味着线程安全的   
	public synchronized boolean add(E e) {
        modCount++;
    	//看是否需要扩容
        ensureCapacityHelper(elementCount + 1);
    	//把新的元素存入[elementCount]，存入后，elementCount元素的个数增1
        elementData[elementCount++] = e;
        return true;
    }

    private void ensureCapacityHelper(int minCapacity) {
        // overflow-conscious code
        //看是否超过了当前数组的容量
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);//扩容
    }
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;//获取目前数组的长度
        //如果capacityIncrement增量是0，新容量 = oldCapacity的2倍
        //如果capacityIncrement增量是不是0，新容量 = oldCapacity + capacityIncrement增量;
        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                         capacityIncrement : oldCapacity);
        
        //如果按照上面计算的新容量还不够，就按照你指定的需要的最小容量来扩容minCapacity
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        
        //如果新容量超过了最大数组限制，那么单独处理
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        
        //把旧数组中的数据复制到新数组中，新数组的长度为newCapacity
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```

```java
    public boolean remove(Object o) {
        return removeElement(o);
    }
    public synchronized boolean removeElement(Object obj) {
        modCount++;
        //查找obj在当前Vector中的下标
        int i = indexOf(obj);
        //如果i>=0，说明存在，删除[i]位置的元素
        if (i >= 0) {
            removeElementAt(i);
            return true;
        }
        return false;
    }
    public int indexOf(Object o) {
        return indexOf(o, 0);
    }
    public synchronized int indexOf(Object o, int index) {
        if (o == null) {//要查找的元素是null值
            for (int i = index ; i < elementCount ; i++)
                if (elementData[i]==null)//如果是null值，用==null判断
                    return i;
        } else {//要查找的元素是非null值
            for (int i = index ; i < elementCount ; i++)
                if (o.equals(elementData[i]))//如果是非null值，用equals判断
                    return i;
        }
        return -1;
    }
    public synchronized void removeElementAt(int index) {
        modCount++;
        //判断下标的合法性
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                                                     elementCount);
        }
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        
        //j是要移动的元素的个数
        int j = elementCount - index - 1;
        //如果需要移动元素，就调用System.arraycopy进行移动
        if (j > 0) {
            //把index+1位置以及后面的元素往前移动
            //index+1的位置的元素移动到index位置，依次类推
            //一共移动j个
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        //元素的总个数减少
        elementCount--;
        //将elementData[elementCount]这个位置置空，用来添加新元素，位置的元素等着被GC回收
        elementData[elementCount] = null; /* to let gc do its work */
    }
```

#### （2）ArrayList源码分析

JDK1.6：

```java
    public ArrayList() {
		this(10);//指定初始容量为10
    }
    public ArrayList(int initialCapacity) {
		super();
        //检查初始容量的合法性
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        //数组初始化为长度为initialCapacity的数组
		this.elementData = new Object[initialCapacity];
    }
```

JDK1.7

```java
    private static final int DEFAULT_CAPACITY = 10;//默认初始容量10
	private static final Object[] EMPTY_ELEMENTDATA = {};
	public ArrayList() {
        super();
        this.elementData = EMPTY_ELEMENTDATA;//数组初始化为一个空数组
    }
    public boolean add(E e) {
        //查看当前数组是否够多存一个元素
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == EMPTY_ELEMENTDATA) {//如果当前数组还是空数组
            //minCapacity按照 默认初始容量和minCapacity中的的最大值处理
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
		//看是否需要扩容处理
        ensureExplicitCapacity(minCapacity);
    }
	//...
```

JDK1.8

```java
private static final int DEFAULT_CAPACITY = 10;
private static final Object[] EMPTY_ELEMENTDATA = {};
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;//初始化为空数组
    }
    public boolean add(E e) {
        //查看当前数组是否够多存一个元素
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        
        //存入新元素到[size]位置，然后size自增1
        elementData[size++] = e;
        return true;
    }
    private void ensureCapacityInternal(int minCapacity) {
        //如果当前数组还是空数组
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            //那么minCapacity取DEFAULT_CAPACITY与minCapacity的最大值
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
		//查看是否需要扩容
        ensureExplicitCapacity(minCapacity);
    }
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;//修改次数加1

        // 如果需要的最小容量  比  当前数组的长度  大，即当前数组不够存，就扩容
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;//当前数组容量
        int newCapacity = oldCapacity + (oldCapacity >> 1);//新数组容量是旧数组容量的1.5倍
        //看旧数组的1.5倍是否够
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        //看旧数组的1.5倍是否超过最大数组限制
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        
        //复制一个新数组
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```

```java
    public boolean remove(Object o) {
        //先找到o在当前ArrayList的数组中的下标
        //分o是否为空两种情况讨论
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {//null值用==比较
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {//非null值用equals比较
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }
    private void fastRemove(int index) {
        modCount++;//修改次数加1
        //需要移动的元素个数
        int numMoved = size - index - 1;
        
        //如果需要移动元素，就用System.arraycopy移动元素
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        
        //将elementData[size-1]位置置空，让GC回收空间，元素个数减少
        elementData[--size] = null; // clear to let GC do its work
    }
```

```java
    public E remove(int index) {
        rangeCheck(index);//检验index是否合法

        modCount++;//修改次数加1
        
        //取出[index]位置的元素，[index]位置的元素就是要被删除的元素，用于最后返回被删除的元素
        E oldValue = elementData(index);
        
		//需要移动的元素个数
        int numMoved = size - index - 1;
        
        //如果需要移动元素，就用System.arraycopy移动元素
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        //将elementData[size-1]位置置空，让GC回收空间，元素个数减少
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }
```

```java
    public E set(int index, E element) {
        rangeCheck(index);//检验index是否合法

        //取出[index]位置的元素，[index]位置的元素就是要被替换的元素，用于最后返回被替换的元素
        E oldValue = elementData(index);
        //用element替换[index]位置的元素
        elementData[index] = element;
        return oldValue;
    }
    public E get(int index) {
        rangeCheck(index);//检验index是否合法

        return elementData(index);//返回[index]位置的元素
    }
```

```java
    public int indexOf(Object o) {
        //分为o是否为空两种情况
        if (o == null) {
            //从前往后找
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
    public int lastIndexOf(Object o) {
         //分为o是否为空两种情况
        if (o == null) {
            //从后往前找
            for (int i = size-1; i >= 0; i--)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
```

#### （3）LinkedList源码分析

```java
int size = 0;
Node<E> first;//记录第一个结点的位置
Node<E> last;//记录最后一个结点的位置

    private static class Node<E> {
        E item;//元素数据
        Node<E> next;//下一个结点
        Node<E> prev;//前一个结点

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
```

```java
    public boolean add(E e) {
        linkLast(e);//默认把新元素链接到链表尾部
        return true;
    }
    void linkLast(E e) {
        final Node<E> l = last;//用l 记录原来的最后一个结点
        
        //创建新结点
        final Node<E> newNode = new Node<>(l, e, null);
        //现在的新结点是最后一个结点了
        last = newNode;
        
        //如果l==null，说明原来的链表是空的
        if (l == null)
            //那么新结点同时也是第一个结点
            first = newNode;
        else
            //否则把新结点链接到原来的最后一个结点的next中
            l.next = newNode;
        //元素个数增加
        size++;
        //修改次数增加
        modCount++;
    }
```

```java
    public boolean remove(Object o) {
        //分o是否为空两种情况
        if (o == null) {
            //找到o对应的结点x
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);//删除x结点
                    return true;
                }
            }
        } else {
            //找到o对应的结点x
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);//删除x结点
                    return true;
                }
            }
        }
        return false;
    }
    E unlink(Node<E> x) {//x是要被删除的结点
        // assert x != null;
        final E element = x.item;//被删除结点的数据
        final Node<E> next = x.next;//被删除结点的下一个结点
        final Node<E> prev = x.prev;//被删除结点的上一个结点

        //如果被删除结点的前面没有结点，说明被删除结点是第一个结点
        if (prev == null) {
            //那么被删除结点的下一个结点变为第一个结点
            first = next;
        } else {//被删除结点不是第一个结点
            //被删除结点的上一个结点的next指向被删除结点的下一个结点
            prev.next = next;
            //断开被删除结点与上一个结点的链接
            x.prev = null;//使得GC回收
        }

        //如果被删除结点的后面没有结点，说明被删除结点是最后一个结点
        if (next == null) {
            //那么被删除结点的上一个结点变为最后一个结点
            last = prev;
        } else {//被删除结点不是最后一个结点
            //被删除结点的下一个结点的prev执行被删除结点的上一个结点
            next.prev = prev;
            //断开被删除结点与下一个结点的连接
            x.next = null;//使得GC回收
        }
		//把被删除结点的数据也置空，使得GC回收
        x.item = null;
        //元素个数减少
        size--;
        //修改次数增加
        modCount++;
        //返回被删除结点的数据
        return element;
    }
```



## 12.5 Set

### 12.5.1 Set概述

Set系列的集合：不可重复的

Set系列的集合，有有序的也有无序的。HashSet无序的，TreeSet按照元素的大小顺序遍历，LinkedHashSet按照元素的添加顺序遍历。

List、Set 概述 

### 12.5.2 实现类的特点

（1）HashSet：

​	底层是HashMap实现。添加到HashSet的元素是作为HashMap的key，value是一个Object类型的常量对象PRESENT。

​	依赖于元素的hashCode()和equals()保证元素的不可重复，存储位置和hashCode()值有关，根据hashCode()来算出它在底层table数组中的[index]

（2）TreeSet

​	底层是TreeMap实现。添加到TreeSet的元素是作为TreeMap的key，value是一个Object类型的常量对象PRESENT。

​	依赖于元素的大小，要么是java.lang.Comparable接口compareTo(Object obj)，要么是java.util.Comparator接口的compare(Object o1, Object o2)来比较元素的大小。认为大小相等的两个元素就是重复元素。

（3）LinkedHashSet

​	底层是LinkedHashMap。添加到LinkedHashSet的元素是作为LinkedHashMap的key，value是一个Object类型的常量对象PRESENT。

​	LinkedHashSet是HashSet的子类，比父类多维护了元素的添加顺序。

​	当且仅当，你既想要元素不可重复，又要保证元素的添加顺序时，再使用它。

​	

## 12.6 Map

### 12.6.1 Map概述

用来存储键值对，映射关系的集合。所有的Map的key都不能重复。

键值对、映射关系的类型：Entry类型

```
Entry接口是Map接口的内部接口。所有的Map的键值对的类型都实现了这个接口。
HashMap中的映射关系，是有一个内部类来实现Entry的接口，JDK1.7是一个叫做Entry的内部类实现Entry接口。
JDK1.8是一个叫做Node的内部类实现Entry接口。
TreeMap中的映射关系，是有一个内部类Entry来实现Entry的接口
```

Map概述

用来存储键值对 映射关系的集合



### 12.6.2 API

（1）put(Object key, Object value)：添加一对映射关系

（2）putAll(Map m)：添加多对映射关系

（3）clear()：清空map

（4）remove(Object key)：根据key删除一对

（5）int size()：获取有效元素的对数

（6）containsKey(Object key)：是否包含某个key

（7）containsValue(Object value)：是否包含某个value

（8）Object  get(Object key)：根据key获取value

（9）遍历相关的几个方法

Collection  values()：获取所有的value进行遍历

Set keySet()：获取所有key进行遍历

Set entrySet()：获取所有映射关系进行遍历

### 12.6.3 Map的实现类们的区别

（1）HashMap：

​	依据key的hashCode()和equals()来保证key是否重复。

​	key如果重复，新的value会替换旧的value。

​	hashCode()决定了映射关系在table数组中的存储的位置，index = hash(key.hashCode()) & table.length-1 

​	HashMap的底层实现：JDK1.7是数组+链表；JDK1.8是数组+链表/红黑树

（2）TreeMap

​	依据key的大小来保证key是否重复。key如果重复，新的value会替换旧的value。

​	key的大小依赖于，java.lang.Comparable或java.util.Comparator。

（3）LinkedHashMap

​	依据key的hashCode()和equals()来保证key是否重复。key如果重复，新的value会替换旧的value。

​	LinkedHashMap是HashMap的子类，比HashMap多了添加顺序

### 12.6.4 HashMap源码分析

#### JDK1.6源码：

```java
    public HashMap() {
        //this.loadFactor加载因子，影响扩容的频率
        //DEFAULT_LOAD_FACTOR：默认加载因子0.75
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        //threshold阈值 = 容量 * 加载因子
        //threshold阈值，当size达到threhold时，考虑扩容
        //扩容需要两个条件同时满足：（1）size >= threhold （2）table[index]！=null，即新映射关系要存入的位置非空
        threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        //table是数组，
        //DEFAULT_INITIAL_CAPACITY：默认是16
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
        init();
    }
```

#### JDK1.7源码：

你对工作地点有什么要求？都可以去吗？

你有了解设计模式吗？

你有应用过设计模式吗？

你能解释单例模式和工厂模式以及具体的应用吗？

你能给我讲讲Java虚拟机吗？

能说说数据库的优化？

开发工具的熟练度？IDEA、VsCode

前端JS、Vue的熟练程度？

Java的基本数据类型和引用类型？

你了解集合吗？讲讲集合Colleciton，Map？ArrayList和LinkedList的区别？

讲讲Map？ HashMap底层实现？List、Map说一个线程安全、线程不安全？

能接受加班的吗？

你有什么问题问我？



```java
    public HashMap() {
    	//DEFAULT_INITIAL_CAPACITY：默认初始容量16
    	//DEFAULT_LOAD_FACTOR：默认加载因子0.75
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }
    public HashMap(int initialCapacity, float loadFactor) {
        //校验initialCapacity合法性
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
        //校验initialCapacity合法性                                       initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        //校验loadFactor合法性
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
		//加载因子，初始化为0.75
        this.loadFactor = loadFactor;
        // threshold 初始为初始容量                                  
        threshold = initialCapacity;
        init();
    }
```

```java
public V put(K key, V value) {
        //如果table数组是空的，那么先创建数组
        if (table == EMPTY_TABLE) {
            //threshold一开始是初始容量的值
            inflateTable(threshold);
        }
        //如果key是null，单独处理
        if (key == null)
            return putForNullKey(value);
        
        //对key的hashCode进行干扰，算出一个hash值
        int hash = hash(key);
        
        //计算新的映射关系应该存到table[i]位置，
        //i = hash & table.length-1，可以保证i在[0,table.length-1]范围内
        int i = indexFor(hash, table.length);
        
        //检查table[i]下面有没有key与我新的映射关系的key重复，如果重复替换value
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }

        modCount++;
        //添加新的映射关系
        addEntry(hash, key, value, i);
        return null;
    }
    private void inflateTable(int toSize) {
        // Find a power of 2 >= toSize
        int capacity = roundUpToPowerOf2(toSize);//容量是等于toSize值的最接近的2的n次方
		//计算阈值 = 容量 * 加载因子
        threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
        //创建Entry[]数组，长度为capacity
        table = new Entry[capacity];
        initHashSeedAsNeeded(capacity);
    }
	//如果key是null，直接存入[0]的位置
    private V putForNullKey(V value) {
        //判断是否有重复的key，如果有重复的，就替换value
        for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;
        //把新的映射关系存入[0]的位置，而且key的hash值用0表示
        addEntry(0, null, value, 0);
        return null;
    }
    void addEntry(int hash, K key, V value, int bucketIndex) {
        //判断是否需要库容
        //扩容：（1）size达到阈值（2）table[i]正好非空
        if ((size >= threshold) && (null != table[bucketIndex])) {
            //table扩容为原来的2倍，并且扩容后，会重新调整所有映射关系的存储位置
            resize(2 * table.length);
            //新的映射关系的hash和index也会重新计算
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
		//存入table中
        createEntry(hash, key, value, bucketIndex);
    }
    void createEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K,V> e = table[bucketIndex];
        //原来table[i]下面的映射关系作为新的映射关系next
        table[bucketIndex] = new Entry<>(hash, key, value, e);
        size++;//个数增加
    }
```

1、put(key,value)

（1）当第一次添加映射关系时，数组初始化为一个长度为**16**的**HashMap$Entry**的数组，这个HashMap$Entry类型是实现了java.util.**Map.Entry**接口

（2）特殊考虑：如果key为null，index直接是[0]

（3）在计算index之前，会对key的hashCode()值，做一个hash(key)再次哈希的运算，这样可以使得Entry对象更加散列的存储到table中

（4）计算index = table.length-1 & hash;

（5）如果table[index]下面，已经有映射关系的key与我要添加的新的映射关系的key相同了，会用新的value替换旧的value。

（6）如果没有相同的，会把新的映射关系添加到链表的头，原来table[index]下面的Entry对象连接到新的映射关系的next中。

（7）添加之前先判断if(size >= threshold  &&  table[index]!=null)如果该条件为true，会扩容

​	if(size >= threshold  &&  table[index]!=null){

​		①会扩容

​		②会重新计算key的hash

​		③会重新计算index

​	}

2、get(key)

（1）计算key的hash值，用这个方法hash(key)

（2）找index = table.length-1 & hash;

（3）如果table[index]不为空，那么就挨个比较哪个Entry的key与它相同，就返回它的value

3、remove(key)

（1）计算key的hash值，用这个方法hash(key)

（2）找index = table.length-1 & hash;

（3）如果table[index]不为空，那么就挨个比较哪个Entry的key与它相同，就删除它，把它前面的Entry的next的值修改为被删除Entry的next

#### JDK1.8源码

```java
几个常量和变量：
（1）DEFAULT_INITIAL_CAPACITY：默认的初始容量 16
（2）MAXIMUM_CAPACITY：最大容量  1 << 30
（3）DEFAULT_LOAD_FACTOR：默认加载因子 0.75
（4）TREEIFY_THRESHOLD：默认树化阈值8，当链表的长度达到这个值后，要考虑树化
（5）UNTREEIFY_THRESHOLD：默认反树化阈值6，当树中的结点的个数达到这个阈值后，要考虑变为链表
（6）MIN_TREEIFY_CAPACITY：最小树化容量64
		当单个的链表的结点个数达到8，并且table的长度达到64，才会树化。
		当单个的链表的结点个数达到8，但是table的长度未达到64，会先扩容
（7）Node<K,V>[] table：数组
（8）size：记录有效映射关系的对数，也是Entry对象的个数
（9）int threshold：阈值，当size达到阈值时，考虑扩容
（10）double loadFactor：加载因子，影响扩容的频率
```

```java
    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; 
        // all other fields defaulted，其他字段都是默认值
    }
```

```java
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
	//目的：干扰hashCode值
    static final int hash(Object key) {
        int h;
		//如果key是null，hash是0
		//如果key非null，用key的hashCode值 与 key的hashCode值高16进行异或
		//		即就是用key的hashCode值高16位与低16位进行了异或的干扰运算
		
		/*
		index = hash & table.length-1
		如果用key的原始的hashCode值  与 table.length-1 进行按位与，那么基本上高16没机会用上。
		这样就会增加冲突的概率，为了降低冲突的概率，把高16位加入到hash信息中。
		*/
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K,V>[] tab; //数组
		Node<K,V> p; //一个结点
		int n, i;//n是数组的长度   i是下标
		
		//tab和table等价
		//如果table是空的
        if ((tab = table) == null || (n = tab.length) == 0){
            n = (tab = resize()).length;
            /*
			tab = resize();
			n = tab.length;*/
			/*
			如果table是空的，resize()完成了①创建了一个长度为16的数组②threshold = 12
			n = 16
			*/
        }
		//i = (n - 1) & hash ，下标 = 数组长度-1 & hash
		//p = tab[i] 第1个结点
		//if(p==null) 条件满足的话说明 table[i]还没有元素
		if ((p = tab[i = (n - 1) & hash]) == null){
			//把新的映射关系直接放入table[i]
            tab[i] = newNode(hash, key, value, null);
			//newNode（）方法就创建了一个Node类型的新结点，新结点的next是null
        }else {
            Node<K,V> e; 
			K k;
			//p是table[i]中第一个结点
			//if(table[i]的第一个结点与新的映射关系的key重复)
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k)))){
                e = p;//用e记录这个table[i]的第一个结点
			}else if (p instanceof TreeNode){//如果table[i]第一个结点是一个树结点
                //单独处理树结点
                //如果树结点中，有key重复的，就返回那个重复的结点用e接收，即e!=null
                //如果树结点中，没有key重复的，就把新结点放到树中，并且返回null，即e=null
				e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            }else {
				//table[i]的第一个结点不是树结点，也与新的映射关系的key不重复
				//binCount记录了table[i]下面的结点的个数
                for (int binCount = 0; ; ++binCount) {
					//如果p的下一个结点是空的，说明当前的p是最后一个结点
                    if ((e = p.next) == null) {
						//把新的结点连接到table[i]的最后
                        p.next = newNode(hash, key, value, null);
						
						//如果binCount>=8-1，达到7个时
                        if (binCount >= TREEIFY_THRESHOLD - 1){ // -1 for 1st
                            //要么扩容，要么树化
							treeifyBin(tab, hash);
						}
                        break;
                    }
					//如果key重复了，就跳出for循环，此时e结点记录的就是那个key重复的结点
            if (e.hash == hash &&((k = e.key) == key || (key != null && key.equals(k)))){
                        break;
					}
                    p = e;//下一次循环，e=p.next，就类似于e=e.next，往链表下移动
                }
            }
			//如果这个e不是null，说明有key重复，就考虑替换原来的value
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null){
                    e.value = value;
				}
                afterNodeAccess(e);//什么也没干
                return oldValue;
            }
        }
        ++modCount;
		
		//元素个数增加
		//size达到阈值
        if (++size > threshold){
            resize();//一旦扩容，重新调整所有映射关系的位置
		}
        afterNodeInsertion(evict);//什么也没干
        return null;
    }	
	
   final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;//oldTab原来的table
		//oldCap：原来数组的长度
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
		
		//oldThr：原来的阈值
        int oldThr = threshold;//最开始threshold是0
		
		//newCap，新容量
		//newThr：新阈值
        int newCap, newThr = 0;
        if (oldCap > 0) {//说明原来不是空数组
            if (oldCap >= MAXIMUM_CAPACITY) {//是否达到数组最大限制
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY){
				//newCap = 旧的容量*2 ，新容量<最大数组容量限制
				//新容量：32,64，...
				//oldCap >= 初始容量16
				//新阈值重新算 = 24，48 ....
                newThr = oldThr << 1; // double threshold
			}
        }else if (oldThr > 0){ // initial capacity was placed in threshold
            newCap = oldThr;
        }else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;//新容量是默认初始化容量16
			//新阈值= 默认的加载因子 * 默认的初始化容量 = 0.75*16 = 12
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;//阈值赋值为新阈值12，24.。。。
		
		//创建了一个新数组，长度为newCap，16，32,64.。。
        @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
		
		
        if (oldTab != null) {//原来不是空数组
			//把原来的table中映射关系，倒腾到新的table中
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {//e是table下面的结点
                    oldTab[j] = null;//把旧的table[j]位置清空
                    if (e.next == null)//如果是最后一个结点
                        newTab[e.hash & (newCap - 1)] = e;//重新计算e的在新table中的存储位置，然后放入
                    else if (e instanceof TreeNode)//如果e是树结点
						//把原来的树拆解，放到新的table
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
						/*
						把原来table[i]下面的整个链表，重新挪到了新的table中
						*/
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }	
	
    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
		//创建一个新结点
	   return new Node<>(hash, key, value, next);
    }

    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; 
		Node<K,V> e;
		//MIN_TREEIFY_CAPACITY：最小树化容量64
		//如果table是空的，或者  table的长度没有达到64
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();//先扩容
        else if ((e = tab[index = (n - 1) & hash]) != null) {
			//用e记录table[index]的结点的地址
            TreeNode<K,V> hd = null, tl = null;
			/*
			do...while，把table[index]链表的Node结点变为TreeNode类型的结点
			*/
            do {
                TreeNode<K,V> p = replacementTreeNode(e, null);
                if (tl == null)
                    hd = p;//hd记录根结点
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
			
            //如果table[index]下面不是空
            if ((tab[index] = hd) != null)
                hd.treeify(tab);//将table[index]下面的链表进行树化
        }
    }	
```

1、添加过程

（1）当第一次添加映射关系时，数组初始化为一个长度为**16**的**HashMap$Node**的数组，这个HashMap$Node类型是实现了java.util.**Map.Entry**接口

（2）在计算index之前，会对key的hashCode()值，做一个hash(key)再次哈希的运算，这样可以使得Entry对象更加散列的存储到table中

> JDK1.8关于hash(key)方法的实现比JDK1.7要简洁。 key.hashCode() ^ key.Code()>>>16;

（3）计算index = table.length-1 & hash;

（4）如果table[index]下面，已经有映射关系的key与我要添加的新的映射关系的key相同了，会用新的value替换旧的value。

（5）如果没有相同的，

①table[index]链表的长度没有达到8个，会把新的映射关系添加到链表的尾

②table[index]链表的长度达到8个，但是table.length没有达到64，会先对table进行扩容，然后再添加

③table[index]链表的长度达到8个，并且table.length达到64，会先把该分支进行树化，结点的类型变为TreeNode，然后把链表转为一棵红黑树

④table[index]本来就已经是红黑树了，那么直接连接到树中，可能还会考虑考虑左旋右旋以保证树的平衡问题

（6）添加完成后判断if(size > threshold ){

​		①会扩容

​		②会重新计算key的hash

​		③会重新计算index

​	}



2、remove(key)

（1）计算key的hash值，用这个方法hash(key)

（2）找index = table.length-1 & hash;

（3）如果table[index]不为空，那么就挨个比较哪个Entry的key与它相同，就删除它，把它前面的Entry的next的值修改为被删除Entry的next

（4）如果table[index]下面原来是红黑树，结点删除后，个数小于等于6，会把红黑树变为链表

### 12.6.5 关于HashMap的面试问题

1、HashMap的底层实现

> 答：JDK1.7是数组+链表，JDK1.8是数组+链表/红黑树

2、HashMap的数组的元素类型

> 答：java.util.Map$Entry接口类型。
>
> JDK1.7的HashMap中有内部类Entry实现Entry接口
>
> JDK1.8的HashMap中有内部类Node和TreeNode类型实现Entry接口

3、为什么要使用数组？

>  答：因为数组的访问的效率高

4、为什么数组还需要链表？或问如何解决hash或[index]冲突问题？

>  答：为了解决hash和[index]冲突问题
>
>  （1）两个不相同的key的hashCode值本身可能相同
>
>  （2）两个hashCode不相同的key，通过hash(key)以及 hash & table.length-1运算得到的[index]可能相同
>
>  那么意味着table[index]下可能需要存储多个Entry的映射关系对象，所以需要链表

5、HashMap的数组的初始化长度

> 答：默认的初始容量值是16

6、HashMap的映射关系的存储索引index如何计算

> 答：hash & table.length-1

7、为什么要使用hashCode()? 空间换时间

> 答：因为hashCode()是一个整数值，可以用来直接计算index，效率比较高，用数组这种结构虽然会浪费一些空间，但是可以提高查询效率。

8、hash()函数的作用是什么

>  答：在计算index之前，会对key的hashCode()值，做一个hash(key)再次哈希的运算，这样可以使得Entry对象更加散列的存储到table中
>
>  JDK1.8关于hash(key)方法的实现比JDK1.7要简洁。 key.hashCode() ^ key.Code()>>>16; 因为这样可以使得hashCode的高16位信息也能参与到运算中来

9、HashMap的数组长度为什么一定要是2的幂次方

> 答：因为2的n次方-1的二进制值是前面都0，后面几位都是1，这样的话，与hash进行&运算的结果就能保证在[0,table.length-1]范围内，而且是均匀的。

10、HashMap 为什么使用 &按位与运算代替%模运算？

> 答：因为&效率高

11、HashMap的数组什么时候扩容？

> 答：JDK1.7版：当要添加新Entry对象时发现（1）size达到threshold（2）table[index]!=null时，两个条件同时满足会扩容
>
> JDK1.8版：当要添加新Entry对象时发现（1）size达到threshold（2）当table[index]下的结点个数达到8个但是table.length又没有达到64。两种情况满足其一都会导致数组扩容
>
> 而且数组一旦扩容，不管哪个版本，都会导致所有映射关系重新调整存储位置。

12、如何计算扩容阈值(临界值)？

> 答：threshold = capacity * loadfactor

13、loadFactor为什么是0.75，如果是1或者0.1呢有什么不同？

> 答：1的话，会导致某个table[index]下面的结点个数可能很长
>
> 0.1的话，会导致数组扩容的频率太高

14、JDK1.8的HashMap什么时候树化？

> 答：当table[index]下的结点个数达到8个但是table.length已经达到64

15、JDK1.8的HashMap什么时候反树化？

> 答：当table[index]下的树结点个数少于6个

16、JDK1.8的HashMap为什么要树化？

> 答：因为当table[index]下的结点个数超过8个后，查询效率就低下了，修改为红黑树的话，可以提高查询效率

17、JDK1.8的HashMap为什么要反树化？

> 答：因为因为当table[index]下树的结点个数少于6个后，使用红黑树反而过于复杂了，此时使用链表既简洁又效率也不错

18、作为HashMap的key类型重写equals和hashCode方法有什么要求

​	（1）equals与hashCode一起重写

​	（2）重写equals()方法，但是有一些注意事项；

* 自反性：x.equals(x)必须返回true。
  对称性：x.equals(y)与y.equals(x)的返回值必须相等。
  传递性：x.equals(y)为true，y.equals(z)也为true，那么x.equals(z)必须为true。
  一致性：如果对象x和y在equals()中使用的信息都没有改变，那么x.equals(y)值始终不变。
  非null：x不是null，y为null，则x.equals(y)必须为false。

​	（3）重写hashCode（）的注意事项

* 如果equals返回true的两个对象，那么hashCode值一定相同，并且只要参与equals判断属性没有修改，hashCode值也不能修改；
  如果equals返回false的两个对象，那么hashCode值可以相同也可以不同；
  如果hashCode值不同的，equals一定要返回false；
  hashCode不宜过简单，太简单会导致冲突严重，hashCode也不宜过于复杂，会导致性能低下；

19、为什么大部分 hashcode 方法使用 31？

>  答：因为31是一个不大不小的素数

20、请问已经存储到HashMap中的key的对象属性是否可以修改？为什么？

> 答：如果该属性参与hashCode的计算，那么不要修改。因为一旦修改hashCode()已经不是原来的值。
> 而存储到HashMap中时，key的hashCode()-->hash()-->hash已经确定了，不会重新计算。用新的hashCode值再查询get(key)/删除remove(key)时，算的hash值与原来不一样就不找不到原来的映射关系了。

21、所以为什么，我们实际开发中，key的类型一般用String和Integer

> 答：因为他们不可变。

22、为什么HashMap中的Node或Entry类型的hash变量与key变量加final声明？

>  答：因为不希望你修改hash和key值

23、为什么HashMap中的Node或Entry类型要单独存储hash？

>  答：为了在添加、删除、查找过程中，比较hash效率更高，不用每次重新计算key的hash值

24、请问已经存储到HashMap中的value的对象属性是否可以修改？为什么？

> 答：可以。因为我们存储、删除等都是根据key，和value无关。

25、如果key是null是如何存储的？

> 答：会存在table[0]中

## 12.7 集合框架图

![1560348912361](imgs/1560348912361.png)

# 第13章 泛型

## 13.1 泛型的概述

泛型：参数化类型

类型形参：<T>，<E>，<K>，<V>，<U>，<R>。。。。

类型实参：必须是引用数据类型，不能是基本数据类型

​	<String>，<Integer>，<Student>，<ArrayList<String>>。。。



## 13.2 形式一：泛型类与泛型接口

1、声明语法格式：

```
【修饰符】 class 类名/接口<类型形参列表>{
    
}

【修饰符】 class 类名/接口<类型形参1 extends 父类上限>{
    
}
【修饰符】 class 类名/接口<类型形参1 extends 父类上限 & 父接口上限>{
    
}
```

> 在类名或接口名后面声明的泛型形参类型，可以在当前类或接口中使用，用作声明成员变量、方法的形参、方法的返回值。
>
> 但是不能用于**静态成员**上

2、使用语法格式

在（1）创建泛型类、泛型接口的对象时，为泛型形参指定具体类型

​	（2）在继承泛型类或实现泛型接口时，为泛型形参指定具体类型

示例代码

```java
ArrayList<String> list = new ArrayList<String>();

ArrayList<String> list = new ArrayList<>();//JDK1.7之后可以省略

class MyStringArrayList extends ArrayList<String>{
    
}

class Employee implements Comparable<Employee>{
    public int compareTo(Employee e){
        
    }
}

Arrays.sort(数组,  new  Comparator<泛型实参>(){
    public int compare(泛型实参类型  o1, 泛型实参类型  o2){
        
    }
});
```

3、泛型如果没有指定，会被擦除，按照最左边的上限处理，如果没有指定上限，按照Object处理



## 13.3 形式二：泛型方法

1、声明的语法格式

```
【修饰符】 <泛型形参列表>  返回值类型  方法名(【数据形参列表】)【throws 异常列表】{}
【修饰符】 <泛型形参 extends 父类上限 & 父接口上限>  返回值类型  方法名(【数据形参列表】)【throws 异常列表】{}
```

> （1）在方法返回值类型前面声明的泛型形参类型，只能在当前方法中使用，用于表示形参的类型或返回值类型，或方法局部变量的类型，和别的方法无关。
>
> （2）泛型方法可以是静态方法，也可以是非静态方法

2、 使用

当调用方法，会根据具体的数据的实参的类型，来确定泛型实参的类型。



## 13.4 通配符？

（1）?：代表任意引用数据类型

（2）?  extends 上限：代表上限本身或它的子类

（3）? super 下限：代表下限本身或它的父类

例如：

ArrayList<?>：表示可以接受任意类型

```java
ArrayList<?> list = new ArrayList<String>();
ArrayList<?> list = new ArrayList<Integer>();
ArrayList<?> list = new ArrayList<Animal>();
```

ArrayList<? extends 上限>：

```
ArrayList<? extends Person> list = new ArrayList<Person>();
ArrayList<? extends Person> list = new ArrayList<Animal>();//Animal不行，因为Animal是父类
ArrayList<? extends Person> list = new ArrayList<Student>();
ArrayList<? extends Person> list = new ArrayList<Dog>();//Dog也不行
```

ArrayList<? super 下限>：

```java
ArrayList<? super Person> list = new ArrayList<Person>();
ArrayList<? super Person> list = new ArrayList<Animal>();
ArrayList<? super Person> list = new ArrayList<Student>();//Student，因为Student是子类
ArrayList<? super Person> list = new ArrayList<Dog>();//Dog也不行
```

> ArrayList<?>：不能添加元素，除了null
>
> ArrayList<? extends 上限>：不能添加元素，除了null
>
> ArrayList<? super 下限>：可以添加下限或下限子类的对象

## 13.5 Collections工具类

java.util.Collections：工具类，操作集合

（1）public static <T> boolean addAll(Collection<? super T> c, T... elements)

添加elements的几个对象到c集合中。T是elements对象的类型，要求Collection集合的元素类型必须是T或T的父类

（2）public static <T> int binarySearch(List<? extends Comparable<? super T>> list,T key)  

在list集合中用二分查找key的下标，如果存在返回的是合理的下标，如果不存在返回的是一个负数下标   

T是元素的类型，

<? extends Comparable<? super T>>，要求集合的元素必须实现Comparable接口

<? super T>，在实现Comparable接口，可以指定Comparable<类型实参>为T或T的父类。

（3）public static boolean disjoint(Collection<?> c1, Collection<?> c2)

判断c1和c2没有交集就为true

（4）public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)

求coll集合中最大元素

<T extends Object & Comparable<? super T>>：要求T或T的父类实现Comparable接口

因为找最大值需要比较大小

（5）public static <T extends Comparable<? super T>> void sort(List<T> list) 给list集合排序   

<T extends Comparable<? super T>>：要求T或T的父类实现Comparable接口

（6）public static <T> Collection<T> synchronizedCollection(Collection<T> c)

以synchronizedXX开头的方法，表示把某种非线程安全集合转为一个线程安全的集合。

（7）public static <T> List<T> unmodifiableList(List<? extends T> list)

以unmodifiableXx开头的方法，表示返回一个“只读”的集合。

# 第14章 IO流

## 14.1 java.io.File类

它是文件和目录路径名的抽象描述。

API：

（1）getName()：获取文件或目录的名称

（2）getPath()：获取文件或目录的路径

（3）getAbsolutePath()：获取文件或目录的绝对路径

（4） getCanonicalPath()：获取文件或目录的规范路径

（5）long length()：获取文件的长度，单位字节

（6）long lastModified()：最后修改时间，单位毫秒

（7）String getParent()：获取上级或父目录

​          File getParentFile()：获取上级或父目录

（8）isFile()：判断是否是文件，当且仅当是文件并且是存在的，才会true

（9）isDirectory()：判断是否是目录，当且仅当是目录并且存在的，才会true

（10）exists()：是否存在

（11）isHidden()：是否隐藏

（12）canWrite()：是否可写

（13）canRead()：是否可读

（14）String[] list()：获取下一级

​	    File[]  listFiles()：获取下一级

​             File[] listFiles(FileFilter f)：获取下一级，但是会过滤掉一下文件和目录

（15）createNewFile()：创建文件

​            createTempFile(String prefix, String suffix)

（16）mkdir()：创建一级目录，如果父目录不存在，就失败，但是不报异常

​            mkdirs()：创建多级目录

（17）delete()：删除文件或空目录

（18）renameTo(File f)：重命名文件或目录



## 14.2 IO流的四大抽象基类

1、四大超类

（1）InputStream：字节输入流

（2）OutputStream：字节输出流

（3）Reader：字符输入流

（4）Writer：字符输出流



2、分类

（1）按照方向分：输入流和输出流

（2）按照处理的方式不同：字节流和字符流

字符流只能处理纯文本的数据（使用范围很窄）

（3）按照角色不同：节点流和处理流

处理流是建立在节点流的基础上的，处理流需要包装一个节点流的对象。

处理流也可以包装另外一个处理流。

> 其实JDK中IO体系是用到了一个装饰者设计模式



3、API

（1）InputStream：

int read()：一次读取一个字节，返回的是本次读取的字节的值，如果流末尾返回-1

int read(byte[] data)：一次读取多个字节，读取的数据存储到data字节数组中，最多读取data.length个字节，返回的是实际本次读取的字节的个数，如果流末尾返回-1。从data[0]开始存储。

int read(byte[] data,int offset, int len)：一次读取多个字节，读取的数据存储到data字节数组中，最多读取len个字节，返回的是实际本次读取的字节的个数，如果流末尾返回-1。从data[offset]开始存储。

void close()：关闭



（2）OutputStream：

void write(int data)：一次写一个字节

void write(byte[] data)：一次写整个字节数组

void write(byte[] data, int offset, int len)：一次字节数组的一部分，从[offset]开始，一共len个

void close()：关闭

void flush()：刷新



（3）Reader：

int read()：一次读取一个字符，返回的是本次读取的字符的Unicode值，如果流末尾返回-1

int read(char[] data)：一次读取多个字符，读取的数据存储到data字符数组中，最多读取data.length个字符，返回的是实际本次读取的字符的个数，如果流末尾返回-1。从data[0]开始存储。

int read(char[] data,int offset, int len)：一次读取多个字符，读取的数据存储到data字符数组中，最多读取len个字符，返回的是实际本次读取的字符的个数，如果流末尾返回-1。从data[offset]开始存储。

void close()：关闭



（4）Writer

void write(int data)：一次写一个字符

void write(char[] data)：一次写整个字符数组

void write(char[] data, int offset, int len)：一次字符数组的一部分，从[offset]开始，一共len个

void write(String str)：一次写整个字符串

void write(String str, int offset, int count)：一次写字符串的一部分，从[offset]开始，一共count个

void close()：关闭

void flush()：刷新



## 14.3 文件IO流

1、类型

FileInputStream：文件字节输入流，可以读取任意类型的文件

FileOutputStream：文件字节输出流，可以把字节数据输出到任意类型的文件

FileReader：文件字符输入流，只能读取纯文本的文件。按照平台默认的字符编码进行解码。

FileWriter：文件字符输出流，只能把字符数据输出到纯文本文件。按照平台默认的字符编码进行编码。



2、读写文件的代码

示例代码：

```java
public void copy(File src, File dest)throws IOException{
    //选择IO流
    FileInputStream fis = new FileInputStream(src);
    FileOutputStream fos = new FileOutputStream(dest);
    
    //读写
    byte[] data = new byte[1024];
    while(true){
        int len = fis.read(data);
        if(len==-1){
            break;
        }
        fos.write(data,0,len);
    }
    
    //关闭
     fis.close();
    fos.close();
}
```

## 14.4 缓冲IO流

1、分为

BufferedInputStream：字节输入缓冲流，给InputStream系列IO流增加缓冲效果
BufferedOutputStream：字节输出缓冲流，给OutputStream系列IO流增加缓冲效果
BufferedReader：字符输入缓冲流，给Reader系列IO流增加缓冲效果

> String readLine()：按行读取

BufferedWriter：字符输出缓冲流，给Writer系列IO流增加缓冲效果

> void newLine()：输出换行符



2、默认的缓冲区的大小是8192 = 1024 * 8（字节/字符）

3、可以给读写的过程提高效率

> 不仅仅是可以给文件IO流增加缓冲效果，可以给任意符合对应类型的IO流增加缓冲效果。

示例代码：

```java
	public void copyBuffer(File src, File dest)throws IOException{
	    //选择IO流
	    FileInputStream fis = new FileInputStream(src);
	    FileOutputStream fos = new FileOutputStream(dest);
	    
	    //BufferedInputStream只能给FileInputStream增加缓冲效果，读的过程加快了
	    BufferedInputStream bis = new BufferedInputStream(fis);//fis在里面，bis在外面，fis比喻成内衣，bis比喻成外套
	    
	    //BufferedOutputStream只能FileOutputStream增加缓冲效果，写的过程加快了
	    BufferedOutputStream bos = new BufferedOutputStream(fos);
	    
	    //数据流向：src-->fis-->bis（从fis先缓冲到bis）-->data-->bos（从data缓冲到bos中）-->fos-->dest
	    
	    //读写
	    byte[] data = new byte[1024];
	    while(true){
	        int len = bis.read(data);
	        if(len==-1){
	            break;
	        }
	        bos.write(data,0,len);
	    }
	    
	    //关闭
	    //关闭比喻成脱衣服
	    bos.close();
        fos.close();
        
	    bis.close();//先脱外套，再脱内衣
	    fis.close();	    
	}
```

## 14.5  编码与解码的IO流（转换流）

1、编码：OutputStreamWriter

​	可以把字符流转为字节流输出，并且在转换的过程中，可以指定字符编码。

2、解码：InputStreamReader

​	可以把字节输入流转为字符输入流，并且在转换的过程中，可以指定字符编码。

3、示例代码：解码（文件是GBK，当前平台是UTF-8）

```java
	@Test
	public void test4()throws IOException{
		//因为这里想要用在程序中按照“指定”的编码方式进行解码，而不是按照平台“默认的”编码方式进行解码
		//所以，我这里仍然用FileInputStream字节流，把文件编码后的数据，原样读取
		//从文件到FileInputStream fis内存的过程中，先不解码
		//因为如果选择FileReader，从文件到FileReader的过程中，就已经按照平台“默认的”编码方式解码好了，我们无法控制
		
		FileInputStream fis = new FileInputStream("d:/File类概述.txt");
		//我要使用InputStreamReader，把FileInputStream转为字符流
//		InputStreamReader isr = new InputStreamReader(fis);//如果没有指定，还是按照默认的编码方式
		InputStreamReader isr = new InputStreamReader(fis,"GBK");//如果指定，就按照指定的编码方式解码
		
		//文件-->fis（字节流）-->解码-->isr（字符流）-->br ->读取的是字符
		//字符流，要么按照char[]读取，要么可以用BufferedReader包装按行读取
		BufferedReader br = new BufferedReader(isr);
		String line;
		while((line = br.readLine()) !=null){
			System.out.println(line);
		}
		
		br.close();
		isr.close();
		fis.close();
	}
```

4、示例代码：编码（文件是GBK，当前平台是UTF-8）

```java
	@Test
	public void test3()throws IOException{
		String hua = "File类可以使用文件路径字符串来创建File实例";
		
		//因为想要用在程序中进行编码，所以这里选用FileOutputStream
		FileOutputStream fos = new FileOutputStream("d:/File类概述.txt",true);
		
		//这里xx，想要直接操作字符串，那么必须是字符流，而fos是字节流，无法直接操作字符串
//		xx.write("\r\n");
//		xx.write(hua);
		
		//数据流向：内存 --> osw （字符流）-->在写入fos过程中进行编码-->fos（字节流）-->文件
		
		OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
		osw.write("\r\n");
		osw.write(hua);
		
		osw.close();
		fos.close();
	}
```

## 14.6 数据IO流

1、类型

DataInputStream：允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型。
DataOutputStream：允许应用程序以适当方式将基本 Java 数据类型写入输出流中。

> 它俩必须配对使用
>
> 读的顺序要与写的顺序一致



2、API

| DataOutputStream                   | DataInputStream       |
| ---------------------------------- | --------------------- |
| writeInt(xx)：输出int类型整数      | int readInt()         |
| writeDouble(xx)：输出double类型    | double readDouble()   |
| writeBoolean(xx)                   | boolean readBoolean() |
| writeLong(xx)                      | long readLong()       |
| writeChar(xx)                      | char readChar()       |
| writeByte(xx)                      | byte readByte()       |
| writeShort(xx)                     | short readShort()     |
| writeFloat(xx)                     | float readFloat()     |
| writeUTF(String str)：输出字符串的 | String readUTF()      |

## 14.7 对象IO流

1、类型

ObjectOutputStream：对象序列化，输出对象，把对象转为字节序列输出

ObjectInputStream：对象反序列化，读取对象，把字节序列重构成Java对象

2、API

ObjectOutputStream：writeObject(对象)

ObjectInputStream：Object  readObject()

3、序列化需要注意哪些内容？

（1）所有要序列化的对象的类型都必须实现java.io.Serializable接口

> 如果对象的属性类型也是引用数据类型，那么也要实现java.io.Serializable接口

（2）希望类的修改对象反序列化不产生影响，那么我们最后能够增加一个序列化版本ID

> private static final long serialVersionUID = 1L;

（3）如果有些属性不想要序列化，可以加transient

（4）如果某个属性前面有static修饰，也不参与序列化

4、除了Serializable接口之外，还可以实现java.io.Externalizable接口，但是要求重写：

void readExternal(ObjectInput in) 
void writeExternal(ObjectOutput out)

  关于哪些属性序列化和反序列化，由程序员自己定。

## 14.8 其他的IO流相关内容

1、如果要实现按行读取，可选择什么类型？

BufferedReader：String readLine()

Scanner：String nextLine()

2、如果要按行输出，可以选择什么类型？

（1）自己处理\r\n

（2）BufferedWriter：newLine()

（3）PrintStream和PrintWriter：println()



## 14.9 JDK1.7之后引入新try..catch

语法格式：

```java
try(需要关闭的资源对象的声明){
    业务逻辑代码
}catch(异常类型 e){
    处理异常代码
}catch(异常类型 e){
    处理异常代码
}
....
```

它没有finally，也不需要程序员去关闭资源对象，无论是否发生异常，都会关闭资源对象

示例代码：

```java
	@Test
	public void test03() {
		//从d:/1.txt(GBK)文件中，读取内容，写到项目根目录下1.txt(UTF-8)文件中
		try(
			FileInputStream fis = new FileInputStream("d:/1.txt");
			InputStreamReader isr = new InputStreamReader(fis,"GBK");
			BufferedReader br = new BufferedReader(isr);
			
			FileOutputStream fos = new FileOutputStream("1.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
		){
			String str;
			while((str = br.readLine()) != null){
				bw.write(str);
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```

#  第十五章 网络编程（了解）

学习它为了更好的理解：web（服务器端和客户端的通信）、数据库（服务器端和客户端的数据传输）等原理。

## 15.1 主机IP

在程序中表示：

（1）值的表示

IPV4：32位整数，8位一组，用.分割，例如：192.168.11.45

​	每个8位的范围[0,255]

IPV6：128位整数表示，16位一组，用:分割，例如：X:X:X:X:X:X:X:X

​	每个16位用十六进制值表示

 

（2）对象表示：InetAddress

此类表示互联网协议 (IP) 地址，它有两个子类Inet4Address和Inet6Address，分别对应IPV4和IPV6。InetAddress类没有提供公共的构造器，而是提供了如下几个静态方法来获取InetAddress实例。

* public static InetAddress getLocalHost()
* public static InetAddress getByAddress(byte[] addr)
* public static InetAddress getByName(String host)

InetAddress提供了如下几个常用的方法：

* public String getHostAddress()：返回 IP 地址字符串（以文本表现形式）。
* public String getHostName()：获取此 IP 地址的主机名
* public String getCanonicalHostName()：获取此 IP 地址的完全限定域名
* public boolean isReachable(int timeout)：测试是否可以达到该地址。

## 15.2 端口号

范围：[0,65535]

常见的端口号：

​	tomcat/JBoss：8080

​	http：80

​	mysql：3306

​	oracle：1521

​	sql server：1433



## 15.3 网络协议

![1560731383474](imgs/1560731383474.png)

* 应用层：网络服务与最终用户的一个接口。协议有：HTTP、FTP、SMTP、DNS、TELNET、HTTPS、POP3等等。
* 表示层：数据的表示、安全、压缩。格式有：JPEG、ASCll、DECOIC、加密格式等。
* 会话层：建立、管理、终止会话。对应主机进程，指本地主机与远程主机正在进行的会话
* 传输层：定义传输数据的协议端口号，以及流控和差错校验。协议有：TCP、UDP。
* 网络层：进行逻辑地址寻址，实现不同网络之间的路径选择。协议有：ICMP、IGMP、IP（IPV4 IPV6）、ARP、RARP。
* 数据链路层：建立逻辑连接、进行硬件地址寻址、差错校验等功能。将比特组合成字节进而组合成帧，用MAC地址访问介质，错误发现但不能纠正。
* 物理层：建立、维护、断开物理连接。

而IP协议是一种非常重要的协议。IP（internet protocal）又称为互联网协议。IP的责任就是把数据从源传送到目的地。它在源地址和目的地址之间传送一种称之为数据包的东西，它还提供对数据大小的重新组装功能，以适应不同网络对包大小的要求。经常与IP协议放在一起的还有TCP（Transmission Control Protocol）协议，即传输控制协议，是一种面向连接的、可靠的、基于字节流的传输层通信协议。而通常我们说的TCP/IP协议，其实是指TCP/IP协议族，因为该协议家族的两个最核心协议：TCP（传输控制协议）和IP（网际协议），为该家族中最早通过的标准，所以简称为TCP/IP协议。

TCP：Transmission Control Protocol 传输控制协议
	（1）面向连接的：连接之前有三次握手，断开时四次挥手
	（2）可靠的
	（3）基于字节流
	（4）可以传输大量数据的
UDP：User Datagram Protocol 用户数据报协议
	（1）非面向连接的
	（2）不可靠的
	（3）基于数据报的
	（4）数据量大小有限制的64K



## 15.4 Socket编程

Socket：套接字，代表网络通信的一端，负责和网卡驱动程序沟通的对象。

![1560731601718](imgs/1560731601718.png)

分为：
（1）流套接字：ServerSocket和Socket
（2）数据报套接字：DatagramSocket

ServerSocket的常用构造方法和其他方法：

* ServerSocket(int port) ：指定在某个端口号监听客户端的连接和通信
* Socket accept()  ：监听和接收客户端的连接
* void close() ：关闭

Socket类的常用构造方法：

* public Socket(InetAddress address,int port)：创建一个流套接字并将其连接到指定 IP 地址的指定端口号。
* public Socket(String host,int port)：创建一个流套接字并将其连接到指定主机上的指定端口号。

Socket类的常用方法：

* public InputStream getInputStream()：返回此套接字的输入流，可以用于接收消息

* public OutputStream getOutputStream()：返回此套接字的输出流，可以用于发送消息

* public InetAddress getInetAddress()：此套接字连接到的远程 IP 地址；如果套接字是未连接的，则返回 null。

* public void close()：关闭此套接字。套接字被关闭后，便不可在以后的网络连接中使用（即无法重新连接或重新绑定）。需要创建新的套接字对象。 关闭此套接字也将会关闭该套接字的 InputStream 和 OutputStream。 

* public void shutdownInput()：如果在套接字上调用 shutdownInput() 后从套接字输入流读取内容，则流将返回 EOF（文件结束符）。 即不能在从此套接字的输入流中接收任何数据。

* public void shutdownOutput()：禁用此套接字的输出流。对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列。 如果在套接字上调用 shutdownOutput() 后写入套接字输出流，则该流将抛出 IOException。 即不能通过此套接字的输出流发送任何数据。

注意：先后调用Socket的shutdownInput()和shutdownOutput()方法，仅仅关闭了输入流和输出流，并不等于调用Socket的close()方法。在通信结束后，仍然要调用Scoket的close()方法，因为只有该方法才会释放Socket占用的资源，比如占用的本地端口号等。

DatagramSocket：

* DatagramPacket(byte[] buf, int length)
* DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port)

## 15.5 代码示例

###   15.5.1 TCP协议编程示例一

一个客户端连接服务器，连接成功后，服务器给客户端发送“欢迎你登录"

```java
package com.atguigu.test10;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCP：面向连接，可靠的，基于字节流的
 * 		服务器：等待被连接的过程
 * 
 * ServerSocket：只负责接受和建立连接，不负责数据的传输
 * Socket：负责数据的传输
 * 
 * 步骤：
 * 1、开启服务器
 * 	  指定服务器监听的端口号
 * 2、等待客户端并接受客户端的连接
 * 
 * 3、接受/发送数据
 * 发送方：输出流
 * 接受方：输入流
 * 
 * 4、断开连接
 * 
 * 5、关闭服务器
 */
public class TestServer {
	public static void main(String[] args) throws IOException {
		//1、开启服务器：网卡驱动就监听9999端口号的数据
		ServerSocket server = new ServerSocket(9999);
		
		//2、等待客户端并接受客户端的连接
		Socket socket = server.accept();//这句代码执行一次，就接受一个客户端连接
		System.out.println("一个客户端连接成功!");
		//3、例如：发送数据
		//发送：欢迎你登录
		//字节流，输出流  OutputStream
		//(1)获取输出流
		OutputStream out = socket.getOutputStream();
		//(2)发送数据
		out.write("欢迎你登录".getBytes());
		
		//4、断开连接
		socket.close();
		
		//5、关闭服务器
		server.close();
	}
}

```

```java
package com.atguigu.test10;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * TCP：
 * 	 客户端，主动连接服务器
 * 
 * Socket(InetAddress address, int port) 
 * Socket(String host, int port)
 * 
 * 步骤：
 * 1、连接服务器
 * Socket socket = new Socket("192.168.30.142",9999);
 * 
 * 2、发送或接受数据
 * 
 * 3、断开连接
 */
public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
//		1、连接服务器
		Socket socket = new Socket("192.168.30.142",9999);
		
		//2、例如：接受数据
		//字节流，输入流，InputStream
		InputStream in = socket.getInputStream();
		byte[] data = new byte[1024];
		int len;
		while((len = in.read(data)) != -1){
			System.out.println(new String(data,0,len));
		}
		
		//3、断开
		socket.close();
	}
}

```



### 15.5.2 TCP协议编程示例二

一个客户端连接服务器，连接成功后，客户端给服务器先传一个“你好”，服务器给客户端返回“欢迎你登录"

```java
package com.atguigu.test11;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	public static void main(String[] args) throws IOException {
		//1、开启服务器：网卡驱动就监听9999端口号的数据
		ServerSocket server = new ServerSocket(9999);
		
		//2、等待客户端并接受客户端的连接
		Socket socket = server.accept();//这句代码执行一次，就接受一个客户端连接
		System.out.println("一个客户端连接成功!");
		
		//3、接受数据
		InputStream in = socket.getInputStream();
		byte[] data = new byte[1024];
		int len;
		System.out.println("服务器收到：");
		while((len = in.read(data)) != -1){
			System.out.println(new String(data,0,len));
		}
		
		//4、例如：发送数据
		//发送：欢迎你登录
		//字节流，输出流  OutputStream
		//(1)获取输出流
		OutputStream out = socket.getOutputStream();
		//(2)发送数据
		out.write("欢迎你登录".getBytes());
		
		//4、断开连接
		socket.close();
		
		//5、关闭服务器
		server.close();
	}
}

```

```java
package com.atguigu.test11;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
//		1、连接服务器
		Socket socket = new Socket("192.168.30.142",9999);
		
		//2、例如：发送你好
		OutputStream out = socket.getOutputStream();
		out.write("你好".getBytes());
//		out.close();//错误的，如果调用out.close()会导致socket的close()
		//如果仅仅表示不发送了，还要接收，那么选择半关闭，只关闭输出通道
		socket.shutdownOutput();
		
		//3、例如：接受数据
		//字节流，输入流，InputStream
		System.out.println("客户端收到：");
		InputStream in = socket.getInputStream();
		byte[] data = new byte[1024];
		int len;
		while((len = in.read(data)) != -1){
			System.out.println(new String(data,0,len));
		}
		
		//3、断开
		socket.close();
	}
}
```

### 15.5.3 TCP协议编程示例三

一个客户端连接服务器，连接成功后：

（1）客户端从键盘输入词语，给服务器发送，直到bye为止；

（2）服务器每次手动词语，反转词语 ，然后返回给客户端，直到接收到bye为止

```java
package com.atguigu.test12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 服务器端：
 * 	(1)接收客户端的连接
 *  (2)接收客户端的词语
 *  (3)把词语“反转”返回给客户端
 *  (2)(3)多次，直到客户端发送"bye"为止
 */
public class TestServer {
	public static void main(String[] args) throws IOException {
		//1、开启服务器
		ServerSocket server = new ServerSocket(8989);
		
		//2、接收一个客户端的连接
		Socket socket = server.accept();
		
		//3、先获取输入流和输出流
		InputStream in = socket.getInputStream();
		/*
		 * 因为是接收一个词语，反转一个，返回一个
		 * 那么如果仅仅使用字节流，不好区分词语
		 * 需要用到字符流
		 * 那么就意味着需要把字节流转为字符流
		 */
		InputStreamReader isr = new InputStreamReader(in);//这里不涉及编码问题，仅仅为了转换流的类型
		/*
		 * 字符流中几个字符是一个词语
		 * 那么我们这里选择“换行符”来作为词语的分割
		 * 意味着我们可以按行读取Scanner或BufferedReader
		 */
		BufferedReader br = new BufferedReader(isr);
		
		OutputStream out = socket.getOutputStream();
		/*
		 * 客户端收到字节，同样不方便处理几个字节是一个词语，仍然要把字节输出流转为字符流
		 * 而且字符之间也不好区分，那么也选择“换行符”进行区别词语
		 * 我们现在需要把OutputStream转为一个可以按行写的字符流或其他的处理流
		 * 
		 * 可以按行写的：BufferedWriter(newLine())
		 * 		   PrintStream(println())
		 */
		PrintStream ps = new PrintStream(out);
		
		//从客户端接收词语
		String word;
		while((word = br.readLine()) != null){
			if("bye".equals(word)){
				break;
			}
			
			//如果不是bye，要反转，并且返回
			StringBuilder sb = new StringBuilder(word);
			sb.reverse();
			
			//返回给客户端
			ps.println(sb.toString());
		}
		
		//4、断开
		socket.close();
		
		//5、关闭服务器
		server.close();
	}
}

```

```java
package com.atguigu.test12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * 客户端：
 * （1）从键盘输入词语
 * （2）发送给服务器
 * （3）接收服务器返回的结果
 * （1）（2）（3）多次进行，直到键盘输入bye并发送给发服务器之后就结束
 */
public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、连接服务器
		Socket socket = new Socket("192.168.30.142",8989);
		
		/*
		 *  * （1）从键盘输入词语
		 * （2）发送给服务器
		 * （3）接收服务器返回的结果
		 * （1）（2）（3）多次进行，直到键盘输入bye并发送给发服务器之后就结束
		 */
		Scanner input = new Scanner(System.in);
		/*
		 * 同样考虑到发送词语，以及词语之间分割问题，那我们选择PrintStream和BufferedReader
		 */
		PrintStream ps = new PrintStream(socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		while(true){
			//从键盘输入词语
			System.out.print("请输入词语：");
			String word = input.next();
			
			//发送给服务器端
			ps.println(word);
			
			if("bye".equals(word)){
				break;
			}
			
			//接收服务器返回的结果
			String result = br.readLine();
			System.out.println("服务器返回的反转后的结果：" + result);
		}
		
		input.close();
		socket.close();
	}
}

```

### 15.5.4 TCP协议编程示例四

**多个客户端**同时连接服务器，连接成功后：

（1）客户端从键盘输入词语，给服务器发送，直到bye为止；

（2）服务器每次手动词语，反转词语 ，然后返回给客户端，直到接收到bye为止

```java
package com.atguigu.test13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 服务器端：
 * 	(1)接收客户端的连接
 *  (2)接收客户端的词语
 *  (3)把词语“反转”返回给客户端
 *  (2)(3)多次，直到客户端发送"bye"为止
 *  
 *  加一个条件，服务器端可以同时接收n个客户端连接
 *  服务器端得加多线程
 */
public class TestServer {
	public static void main(String[] args) throws IOException {
		//1、开启服务器
		ServerSocket server = new ServerSocket(8989);
		
		boolean flag = true;
		while(flag){
			//2、接收一个客户端的连接
			Socket socket = server.accept();//每个客户端的socket是独立的
			
			//为没一个客户端开启一个独立的线程维护它的通信
			MessageHandler mh = new MessageHandler(socket);
			mh.start();
		}
			
		//5、关闭服务器
		server.close();
	}
}
class MessageHandler extends Thread{
	private Socket socket;
	
	public MessageHandler(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run(){
		try {
			//3、先获取输入流和输出流
			InputStream in = socket.getInputStream();
			/*
			 * 因为是接收一个词语，反转一个，返回一个
			 * 那么如果仅仅使用字节流，不好区分词语
			 * 需要用到字符流
			 * 那么就意味着需要把字节流转为字符流
			 */
			InputStreamReader isr = new InputStreamReader(in);//这里不涉及编码问题，仅仅为了转换流的类型
			/*
			 * 字符流中几个字符是一个词语
			 * 那么我们这里选择“换行符”来作为词语的分割
			 * 意味着我们可以按行读取Scanner或BufferedReader
			 */
			BufferedReader br = new BufferedReader(isr);
			
			OutputStream out = socket.getOutputStream();
			/*
			 * 客户端收到字节，同样不方便处理几个字节是一个词语，仍然要把字节输出流转为字符流
			 * 而且字符之间也不好区分，那么也选择“换行符”进行区别词语
			 * 我们现在需要把OutputStream转为一个可以按行写的字符流或其他的处理流
			 * 
			 * 可以按行写的：BufferedWriter(newLine())
			 * 		   PrintStream(println())
			 */
			PrintStream ps = new PrintStream(out);
			
			//从客户端接收词语
			String word;
			while((word = br.readLine()) != null){
				if("bye".equals(word)){
					break;
				}
				
				//如果不是bye，要反转，并且返回
				StringBuilder sb = new StringBuilder(word);
				sb.reverse();
				
				//返回给客户端
				ps.println(sb.toString());
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//4、断开
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
```

```java
package com.atguigu.test13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * 客户端：
 * （1）从键盘输入词语
 * （2）发送给服务器
 * （3）接收服务器返回的结果
 * （1）（2）（3）多次进行，直到键盘输入bye并发送给发服务器之后就结束
 * 
 * 加一个条件，服务器端可以同时接收n个客户端连接
 * 客户端代码不用修改
 */
public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、连接服务器
		Socket socket = new Socket("192.168.30.142",8989);
		
		/*
		 *  * （1）从键盘输入词语
		 * （2）发送给服务器
		 * （3）接收服务器返回的结果
		 * （1）（2）（3）多次进行，直到键盘输入bye并发送给发服务器之后就结束
		 */
		Scanner input = new Scanner(System.in);
		/*
		 * 同样考虑到发送词语，以及词语之间分割问题，那我们选择PrintStream和BufferedReader
		 */
		PrintStream ps = new PrintStream(socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		while(true){
			//从键盘输入词语
			System.out.print("请输入词语：");
			String word = input.next();
			
			//发送给服务器端
			ps.println(word);
			
			if("bye".equals(word)){
				break;
			}
			
			//接收服务器返回的结果
			String result = br.readLine();
			System.out.println("服务器返回的反转后的结果：" + result);
		}
		
		input.close();
		socket.close();
	}
}

```

### 15.5.5 TCP协议编程示例五

一个客户端连接服务器，连接成功后，给服务器上传一个文件，服务器接收到文件后存到upload的文件夹中。

```java
package com.atguigu.test14;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 从客户端发送文件到服务器端
 * (1)接收客户端的连接
 * (2)接收文件名.后缀名
 * 思考：
 * 	 存哪里   ①在当前项目中找一个位置存储，例如：upload文件夹
 *  ②如何解决文件名重名的问题         文件名需要处理，加入时间戳或其他的唯一编码的UUID等值
 *  ③.后缀名需要保留，因为它代表文件的类型
 * (3)接收文件内容
 * (4)反馈结果
 * 
 * 思考：
 * 		这里既要接收文件名.后缀名，又要接收文件内容。
 * 		这里既有  文本信息“文件名.后缀名”，又有其他类型的数据“文件内容”，只能选择字节流。
 * 
 * 		如何区别，文件名.后缀名   与  文件内容呢
 * 		想哪种字节输入流，可以处理字符串，和字节类型的数据。
 * 
 * 		FileInputStream
 * 		BufferedInputStream
 * 		DataInputStream
 * 		ObjectInputStream
 * 
 * 		这些里面：DataInputStream：readUTF() 和  read(byte[])
 * 				ObjectInputStream也可以，但是麻烦，我这里选择DataInputStream
 * 
 */
public class TestServer {
	public static void main(String[] args) throws IOException {
		//1、开启服务器
		ServerSocket server = new ServerSocket(9999);
		
		//2、接收客户端的连接
		Socket socket = server.accept();
		
		//3、获取输入流
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		//接收文件名.后缀名
		String fileName = dis.readUTF();
		
		//处理文件名
		/*
		 * 希望我要在服务器存储的文件名：   原来的文件名 + 时间戳
		 */
		long timestamp = System.currentTimeMillis();
		//.的下标
		int index = fileName.lastIndexOf(".");
		//后缀名
		String ext = fileName.substring(index);
		// 原来的文件名
		String name = fileName.substring(0, index);
		//新文件名
		String newFileName = "upload/" + name + timestamp + ext;
		
		//创建文件输出流，把接收到的文件内容，写入新文件
		FileOutputStream fos = new FileOutputStream(newFileName);
		
		//接收文件内容
		byte[] data = new byte[1024];
		int len;
		while((len = dis.read(data))!=-1){
			fos.write(data, 0, len);
		}
		
		//还可以给客户端反馈：文件接收完毕
		OutputStream out = socket.getOutputStream();
		PrintStream ps = new PrintStream(out);
		ps.println("文件接收完毕!");
		
		//断开
		fos.close();
		socket.close();
		server.close();
	}
}

```

```java
package com.atguigu.test14;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * 从客户端发送文件到服务器端
 * 
 * 
 * 客户端：
 * （1）从键盘输入文件的路径名，即选择要发送的文件
 * （2）给服务器先把“文件名.后缀名"
 * （3）发送文件内容
 * （4）接收服务器的反馈结果
 * 
 * 这里同样因为既要发送“文件名.后缀名"，又要发送“文件内容”，选择字节流，选择DataOutputStream
 * 
 */
public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、连接服务器
		Socket socket = new Socket("192.168.30.142",9999);
		
		//2、从键盘输入文件的路径名，即选择要发送的文件
		Scanner input = new Scanner(System.in);
		System.out.print("请选择你要发送的文件（例如：D:/尚硅谷_190513班_柴林燕_JavaSE/开学典礼所发资料.rar）：");
		String fileName = input.nextLine();
		File file = new File(fileName);
		
		//3、给服务器发送“文件名.后缀名"
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		//发送“文件名.后缀名"
		dos.writeUTF(file.getName());
		
		//4、发送文件内容
		//先从file文件读取内容
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[1024];
		int len;
		while((len = fis.read(data)) != -1){
			//一边读，一边给服务器发送
			dos.write(data,0,len);
		}
		socket.shutdownOutput();//表示发送完毕了
		
		//5、接收反馈
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		String result = br.readLine();
		System.out.println("结果：" + result);
		
		//6、关闭
		socket.close();
		fis.close();
	}
}

```

### 15.5.6 TCP协议编程示例六

多个客户端连接服务器，连接成功后，给服务器上传一个文件，服务器接收到文件后存到upload的文件夹中。

```java
package com.atguigu.test15;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	public static void main(String[] args) throws IOException {
		//1、开启服务器
		ServerSocket server = new ServerSocket(9999);
		
		while(true){
			//2、接收客户端的连接
			Socket socket = server.accept();
			
			FileUploadThread ft = new FileUploadThread(socket);
			ft.start();
		
		}
//		server.close();//不关闭服务器
	}
}
class FileUploadThread extends Thread{
	private Socket socket;
	
	public FileUploadThread(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run(){
		try {
			//3、获取输入流
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			//接收文件名.后缀名
			String fileName = dis.readUTF();
			
			//处理文件名
			/*
			 * 希望我要在服务器存储的文件名：   原来的文件名 + 时间戳
			 */
			long timestamp = System.currentTimeMillis();
			//.的下标
			int index = fileName.lastIndexOf(".");
			//后缀名
			String ext = fileName.substring(index);
			// 原来的文件名
			String name = fileName.substring(0, index);
			//新文件名
			String newFileName = "upload/" + name + timestamp + ext;
			
			//创建文件输出流，把接收到的文件内容，写入新文件
			FileOutputStream fos = new FileOutputStream(newFileName);
			
			//接收文件内容
			byte[] data = new byte[1024];
			int len;
			while((len = dis.read(data))!=-1){
				fos.write(data, 0, len);
			}
			
			//还可以给客户端反馈：文件接收完毕
			OutputStream out = socket.getOutputStream();
			PrintStream ps = new PrintStream(out);
			ps.println("文件接收完毕!");
			
			//断开
			fos.close();
			socket.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

```java
package com.atguigu.test15;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、连接服务器
		Socket socket = new Socket("192.168.30.142",9999);
		
		//2、从键盘输入文件的路径名，即选择要发送的文件
		Scanner input = new Scanner(System.in);
		System.out.print("请选择你要发送的文件（例如：D:/尚硅谷_190513班_柴林燕_JavaSE/开学典礼所发资料.rar）：");
		String fileName = input.nextLine();
		File file = new File(fileName);
		
		//3、给服务器发送“文件名.后缀名"
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		//发送“文件名.后缀名"
		dos.writeUTF(file.getName());
		
		//4、发送文件内容
		//先从file文件读取内容
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[1024];
		int len;
		while((len = fis.read(data)) != -1){
			//一边读，一边给服务器发送
			dos.write(data,0,len);
		}
		socket.shutdownOutput();//表示发送完毕了
		
		//5、接收反馈
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		String result = br.readLine();
		System.out.println("结果：" + result);
		
		//6、关闭
		socket.close();
		fis.close();
		input.close();
	}
}

```

### 15.5.7 TCP协议编程示例七

群聊

```java
package com.atguigu.test16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * 
 */
public class TestServer {
	private static ArrayList<Socket> online = new ArrayList<Socket>();
	
	public static void main(String[] args) throws IOException {
		//1、开启服务器
		ServerSocket server = new ServerSocket(9999);
		
		while(true){
			//2、接收客户端的连接
			Socket socket = server.accept();
			
			//把这个客户端加入到online中
			online.add(socket);
			
			//每一个客户端独立的线程
			MessageHandler mh = new MessageHandler(socket);
			mh.start();
		}
	}

	//私有的静态的内部类
	//这里用内部类的原因，是为了用上面的online集合
	private static class MessageHandler extends Thread{
		private Socket socket;
		private String ip;
		
		public MessageHandler(Socket socket) {
			super();
			this.socket = socket;
			this.ip = socket.getInetAddress().getHostAddress();
		}

		public void run(){
			//这个客户端的一连接成功，线程一启动，就可以告诉其他人我上线了
			sendToOthers(ip+"上线了");
			
			/*
			 * （1）接收当前的客户端发送的消息
			 * （2）给其他在线的客户端转发
			 */
			//（1）接收当前的客户端发送的消息
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				
				String content;
				while((content = br.readLine()) !=null){
					if("bye".equals(content)){
						//给自己发一句bye
						OutputStream out = socket.getOutputStream();
						PrintStream ps = new PrintStream(out);
						ps.println("bye");
						
						break;
					}
					
					//收到一句，转发一句
					sendToOthers(ip+"说:" + content);
				}
				
				sendToOthers(ip+"下线了");
			} catch (IOException e) {
				sendToOthers(ip+"掉线了");
			}
		}
		
		//因为转发的代码也很长，独立为一个方法
		public void sendToOthers(String str){
			//遍历所有online的客户端
			Iterator<Socket> iterator = online.iterator();
			while(iterator.hasNext()){
				Socket on = iterator.next();
				if(!on.equals(socket)){//只给其他客户端转发
					try {
						OutputStream out = on.getOutputStream();
						PrintStream ps = new PrintStream(out);
						
						ps.println(str);
					} catch (IOException e) {
						//说明on这个客户端要么下线了，要么掉线了
						iterator.remove();
					}
				}
			}
		}
	}
	
	
}

```

```java
package com.atguigu.test16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * 群聊
 */
public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、连接服务器
		Socket socket = new Socket("192.168.30.142",9999);
		
		//2、开启两个线程，一个收消息，一个发消息
		SendThread st = new SendThread(socket);
		ReceiveThread rt = new ReceiveThread(socket);
		
		st.start();
		rt.start();
		
		//等发送线程停下来再往下走
		try {
			st.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//让接收数据的线程停下
		rt.setFlag(false);
		
		//等接收线程停下来，再往下走，断开连接
		try {
			rt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		socket.close();
	}
}
class SendThread extends Thread{
	private Socket socket;
	
	public SendThread(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run(){
		try {
			//键盘输入
			Scanner input = new Scanner(System.in);
			OutputStream out = socket.getOutputStream();
			PrintStream ps = new PrintStream(out);
			while(true){
				//从键盘输入
				System.out.print("请输入要发送的消息：");
				String content = input.nextLine();
				System.out.println("content:" + content);
				
				//给服务器发送
				ps.println(content);
				
				//如果bye，就结束发送
				if("bye".equals(content)){
					break;
				}
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class ReceiveThread extends Thread{
	private Socket socket;
	private boolean flag = true;
	
	public ReceiveThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void run(){
		try {
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			while(flag){
				String line = br.readLine();
				System.out.println(line);
				if("bye".equals(line)){
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
```

### 15.5.8 UDP协议编程示例

```java
package com.atguigu.test17;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestSend {
	public static void main(String[] args) throws IOException {
		//1、发送方，建立一个Socket
		//发送方的端口号和IP地址，自动获取
		DatagramSocket ds = new DatagramSocket();
		
		//2、准备把要发送的数据打包
		String str = "马上下课了";
		byte[] bytes = str.getBytes();
		InetAddress ip = InetAddress.getByName("192.168.30.142");
		DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length, ip, 9999);
		
		//3、发送，通过socket发送
		ds.send(dp);
		System.out.println("发送完毕");
		
		//4、关闭
		ds.close();
		
	}
}

```

```java
package com.atguigu.test17;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * 接收方：
 * 	DatagramPacket(byte[] buf, int length) 
 * 	参数一：用来装数据的字节数组
 *  参数二：数组的长度
 */
public class TestReceive {
	public static void main(String[] args) throws IOException {
		//1、接收方也要socket
		//接收方的端口号，指定，IP自动获取
		DatagramSocket ds = new DatagramSocket(9999);
		
		//2、准备一个数据报，接收数据
		byte[] data = new byte[1024];
		DatagramPacket dp = new DatagramPacket(data,data.length);
		
		//3、接收数据
		ds.receive(dp);
		
		//4、把数据拆解出来
		byte[] bs = dp.getData();//接收的数据
		int len = dp.getLength();//接收的数据的实际长度
		System.out.println(new String(bs,0,len));
		
		//5、断开
		ds.close();
	}
}

```

# 第十六章 反射（难点）

## 16.1 类加载

1、类在内存中的生命周期：加载-->使用-->卸载

2、类的加载又分为三个阶段：

（1）加载：load

（2）连接：link

①验证：校验合法性

②准备：准备对应的内存（方法区），创建Class对象，为类变量赋默认值，为静态常量赋初始值。

③解析：把字节码中的符号引用替换为对应的直接地址引用

（3）初始化：initialize（类初始化），大多数情况下，类的加载就完成了类的初始化，有些情况下，会延迟类的初始化。

![1560767438339](imgs/1560767438339.png)

3、哪些会导致类的初始化？

（1）主方法所在的类，要先初始化

（2）第一次使用某个类型就是在new它的对象，此时这个类没有初始化的话，先完成类初始化再做实例初始化

（3）调用某个类的静态成员（类变量和类方法），此时这个类没有初始化的话，先完成类初始化

（4）子类初始化时，发现它的父类还没有初始化的话，那么先初始化父类

（5）通过反射操作某个类时，如果这个类没有初始化，也会导致该类先初始化

> 类初始化执行的是<clinit>()，该方法由（1）类变量的显式赋值代码（2）静态代码块中的代码构成

```java
class Father{
	static{
		System.out.println("main方法所在的类的父类(1)");//初始化子类时，会初始化父类
	}
}

public class TestClinit1 extends Father{
	static{
		System.out.println("main方法所在的类(2)");//主方法所在的类会初始化
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		new A();//第一次使用A就是创建它的对象，会初始化A类
		
		B.test();//直接使用B类的静态成员会初始化B类
		
		Class clazz = Class.forName("com.atguigu.test02.C");//通过反射操作C类，会初始化C类
	}
}
class A{
	static{
		System.out.println("A类初始化");
	}
}
class B{
	static{
		System.out.println("B类初始化");
	}
	public static void test(){
		System.out.println("B类的静态方法");
	}
}
class C{
	static{
		System.out.println("C类初始化");
	}
}
```



4、哪些使用类，但是不会导致类的初始化？

（1）使用某个类的静态的常量（static  final）

（2）通过子类调用父类的静态变量，静态方法，只会导致父类初始化，不会导致子类初始化，即只有声明静态成员的类才会初始化

（3）用某个类型声明数组并创建数组对象时，不会导致这个类初始化

```java
public class TestClinit2 {
	public static void main(String[] args) {
		System.out.println(D.NUM);//D类不会初始化，因为NUM是final的
		
		System.out.println(F.num);
		F.test();//F类不会初始化，E类会初始化，因为num和test()是在E类中声明的
		
		//G类不会初始化，此时还没有正式用的G类
		G[] arr = new G[5];//没有创建G的对象，创建的是准备用来装G对象的数组对象
        //G[]是一种新的类型，是数组类想，动态编译生成的一种新的类型
        //G[].class
	}
}
class D{
	public static final int NUM = 10;
	static{
		System.out.println("D类的初始化");
	}
}
class E{
	static int num = 10;
	static{
		System.out.println("E父类的初始化");
	}
	public static void test(){
		System.out.println("父类的静态方法");
	}
}
class F extends E{
	static{
		System.out.println("F子类的初始化");
	}
}

class G{
	static{
		System.out.println("G类的初始化");
	}
}
```



5、类加载需要类加载器

（1）引导类加载器

​	它负责加载jre/rt.jar核心库

​	它本身不是Java代码实现的，也不是ClassLoader的子类，获取它的对象时往往返回null

（2）扩展类加载器

​	它负责加载jre/lib/ext扩展库

​	它是ClassLoader的子类

（3）应用程序类加载器

​	它负责加载项目的classpath路径下的类

​	它是ClassLoader的子类

（4）自定义类加载器

​	当你的程序需要加载“特定”目录下的类，可以自定义类加载器；

​	当你的程序的字节码文件需要加密时，那么往往会提供一个自定义类加载器对其进行解码

​	后面会见到的自定义类加载器：tomcat中



6、Java系统类加载器的双亲委托模式

简单描述：

​	下一级的类加载器，如果接到任务时，会先搜索是否加载过，如果没有，会先把任务往上传，如果都没有加载过，一直到根加载器，如果根加载器在它负责的路径下没有找到，会往回传，如果一路回传到最后一级都没有找到，那么会报ClassNotFoundException或NoClassDefError，如果在某一级找到了，就直接返回Class对象。

应用程序类加载器  把  扩展类加载器视为父加载器，

扩展类加载器 把 引导类加载器视为父加载器。

不是继承关系，是组合的方式实现的。

## 16.2  javalang.Class类

相关API（1）java.lang.Class（2）java.lang.reflect.*;

1、Class对象是反射的根源。

2、哪些类型可以获取Class对象，可以用代码示例

```java
//（1）基本数据类型和void
例如：int.class
	 void.class
//（2）类和接口
例如：String.class
	Comparable.class
//（3）枚举
例如：ElementType.class
//（4）注解
例如：Override.class
//（5）数组
例如：int[].class
```

3、获取Class对象的四种方式
（1）类型名.class

要求编译期间已知类型

（2）对象.getClass()

只能获取已经存在的对象的运行时类型

（3）Class.forName(类型全名称)

 可以获取编译期间未知的类型

（4）ClassLoader的类加载器对象.loadClass(类型全名称)

可以用自定义加载器对象加载指定路径下的类型

```java
public class TestClass {
	@Test
	public void test05() throws ClassNotFoundException{
		Class c = TestClass.class;
		ClassLoader loader = c.getClassLoader();
		
		Class c2 = loader.loadClass("com.atguigu.test05.Employee");
		Class c3 = Employee.class;
		System.out.println(c2 == c3);
	}
	
	@Test
	public void test03() throws ClassNotFoundException{
		Class c2 = String.class;
		Class c1 = "".getClass();
		Class c3 = Class.forName("java.lang.String");
		
		System.out.println(c1 == c2);
		System.out.println(c1 == c3);
	}
}
```



## 16.3 反射的应用

### 16.3.1 获取类型的详细信息

可以获取：包、修饰符、类型名、父类（包括泛型父类）、父接口（包括泛型父接口）、成员（属性、构造器、方法）、注解（类上的、方法上的、属性上的）

示例代码获取常规信息：

```java
public class TestClassInfo {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		//1、先得到某个类型的Class对象
		Class clazz = String.class;
		//比喻clazz好比是镜子中的影子
		
		//2、获取类信息
		//（1）获取包对象，即所有java的包，都是Package的对象
		Package pkg = clazz.getPackage();
		System.out.println("包名：" + pkg.getName());
		
		//（2）获取修饰符
		//其实修饰符是Modifier，里面有很多常量值
		/*
		 * 0x是十六进制
		 * PUBLIC           = 0x00000001;  1    1
		 * PRIVATE          = 0x00000002;  2	10
		 * PROTECTED        = 0x00000004;  4	100
		 * STATIC           = 0x00000008;  8	1000
		 * FINAL            = 0x00000010;  16	10000
		 * ...
		 * 
		 * 设计的理念，就是用二进制的某一位是1，来代表一种修饰符，整个二进制中只有一位是1，其余都是0
		 * 
		 * mod = 17          0x00000011
		 * if ((mod & PUBLIC) != 0)  说明修饰符中有public
		 * if ((mod & FINAL) != 0)   说明修饰符中有final
		 */
		int mod = clazz.getModifiers();
		System.out.println(Modifier.toString(mod));
		
		//（3）类型名
		String name = clazz.getName();
		System.out.println(name);
		
		//（4）父类，父类也有父类对应的Class对象
		Class superclass = clazz.getSuperclass();
		System.out.println(superclass);
		
		//（5）父接口们
		Class[] interfaces = clazz.getInterfaces();
		for (Class class1 : interfaces) {
			System.out.println(class1);
		}
		
		//（6）类的属性，  你声明的一个属性，它是Field的对象
/*		Field clazz.getField(name)  根据属性名获取一个属性对象，但是只能得到公共的
		Field[] clazz.getFields();  获取所有公共的属性
		Field clazz.getDeclaredField(name)  根据属性名获取一个属性对象，可以获取已声明的
		Field[] clazz.getDeclaredFields()	获取所有已声明的属性
		*/
		Field valueField = clazz.getDeclaredField("value");
//		System.out.println("valueField = " +valueField);
		
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			//修饰符、数据类型、属性名    
			int modifiers = field.getModifiers();
			System.out.println("属性的修饰符：" + Modifier.toString(modifiers));
			
			String name2 = field.getName();
			System.out.println("属性名：" + name2);
			
			Class<?> type = field.getType();
			System.out.println("属性的数据类型：" + type);
		}
		System.out.println("-------------------------");
		//（7）构造器们
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			//修饰符、构造器名称、构造器形参列表  、抛出异常列表
			int modifiers = constructor.getModifiers();
			System.out.println("构造器的修饰符：" + Modifier.toString(modifiers));
			
			String name2 = constructor.getName();
			System.out.println("构造器名：" + name2);
			
			//形参列表
			System.out.println("形参列表：");
			Class[] parameterTypes = constructor.getParameterTypes();
			for (Class class1 : parameterTypes) {
				System.out.println(class1);
			}
		}
		System.out.println("=--------------------------------");
		//(8)方法们
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			//修饰符、返回值类型、方法名、形参列表 、异常列表 
			int modifiers = method.getModifiers();
			System.out.println("方法的修饰符：" + Modifier.toString(modifiers));
			
			Class<?> returnType = method.getReturnType();
			System.out.println("返回值类型:" + returnType);
			
			String name2 = method.getName();
			System.out.println("方法名：" + name2);
			
			//形参列表
			System.out.println("形参列表：");
			Class[] parameterTypes = method.getParameterTypes();
			for (Class class1 : parameterTypes) {
				System.out.println(class1);
			}
			
			//异常列表
			System.out.println("异常列表：");
			Class<?>[] exceptionTypes = method.getExceptionTypes();
			for (Class<?> class1 : exceptionTypes) {
				System.out.println(class1);
			}
		}
		
	}
}

```



### 16.3.2  创建任意引用类型的对象

两种方式：

1、直接通过Class对象来实例化（要求必须有无参构造）

2、通过获取构造器对象来进行实例化



方式一的步骤：

（1）获取该类型的Class对象（2）创建对象

方式二的步骤：

（1）获取该类型的Class对象（2）获取构造器对象（3）创建对象

> 如果构造器的权限修饰符修饰的范围不可见，也可以调用setAccessible(true)

示例代码：

```java
public class TestNewInstance {
	@Test
	public void test3()throws Exception{
		//(1)获取Class对象
		Class<?> clazz = Class.forName("com.atguigu.test.Student");
		/*
		 * 获取Student类型中的有参构造
		 * 如果构造器有多个，我们通常是根据形参【类型】列表来获取指定的一个构造器的
		 * 例如：public Student(int id, String name) 
		 */
		//(2)获取构造器对象
		Constructor<?> constructor = clazz.getDeclaredConstructor(int.class,String.class);
		
		//(3)创建实例对象
		// T newInstance(Object... initargs)  这个Object...是在创建对象时，给有参构造的实参列表
		Object obj = constructor.newInstance(2,"张三");
		System.out.println(obj);
	}
	
	@Test
	public void test2()throws Exception{
		Class<?> clazz = Class.forName("com.atguigu.test.Student");
		//Caused by: java.lang.NoSuchMethodException: com.atguigu.test.Student.<init>()
		//即说明Student没有无参构造，就没有无参实例初始化方法<init>
		Object stu = clazz.newInstance();
		System.out.println(stu);
	}
	
	@Test
	public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
//		AtGuigu obj = new AtGuigu();//编译期间无法创建
		
		Class<?> clazz = Class.forName("com.atguigu.test.AtGuigu");
		//clazz代表com.atguigu.test.AtGuigu类型
		//clazz.newInstance()创建的就是AtGuigu的对象
		Object obj = clazz.newInstance();
		System.out.println(obj);
	}
}
```



### 16.3.3 操作任意类型的属性

（1）获取该类型的Class对象
Class clazz = Class.forName("com.atguigu.bean.User");
（2）获取属性对象
Field field = clazz.getDeclaredField("username");
（3）创建实例对象
Object obj = clazz.newInstance();

（4）设置属性可访问

field.setAccessible(true);

（4）设置属性

field.set(obj,"chai");
（5）获取属性值
Object value = field.get(obj);

> 如果操作静态变量，那么实例对象可以省略，用null表示

示例代码：

```java
public class TestField {
	public static void main(String[] args)throws Exception {
		//1、获取Student的Class对象
		Class clazz = Class.forName("com.atguigu.test.Student");
		
		//2、获取属性对象，例如：id属性
		Field idField = clazz.getDeclaredField("id");
		
		//3、创建实例对象，即，创建Student对象
		Object stu = clazz.newInstance();
		
		//如果id是私有的等在当前类中不可访问access的，我们需要做如下操作
		idField.setAccessible(true);
		
		//4、获取属性值
		/*
		 * 以前：int 变量= 学生对象.getId()
		 * 现在：Object id属性对象.get(学生对象)
		 */
		Object value = idField.get(stu);
		System.out.println("id = "+ value);
		
		//5、设置属性值
		/*
		 * 以前：学生对象.setId(值)
		 * 现在：id属性对象.set(学生对象,值)
		 */
		idField.set(stu, 2);
		
		value = idField.get(stu);
		System.out.println("id = "+ value);
	}
}
```



### 16.3.4 调用任意类型的方法

（1）获取该类型的Class对象
Class clazz = Class.forName("com.atguigu.service.UserService");
（2）获取方法对象
Method method = clazz.getDeclaredMethod("login",String.class,String.class);
（3）创建实例对象
Object obj = clazz.newInstance();
（4）调用方法
Object result = method.invoke(obj,"chai","123);

> 如果方法的权限修饰符修饰的范围不可见，也可以调用setAccessible(true)
>
> 如果方法是静态方法，实例对象也可以省略，用null代替

示例代码：

```java
public class TestMethod {
	@Test
	public void test()throws Exception {
		// 1、获取Student的Class对象
		Class<?> clazz = Class.forName("com.atguigu.test.Student");
		
		//2、获取方法对象
		/*
		 * 在一个类中，唯一定位到一个方法，需要：（1）方法名（2）形参列表，因为方法可能重载
		 * 
		 * 例如：void setName(String name)
		 */
		Method method = clazz.getDeclaredMethod("setName", String.class);
		
		//3、创建实例对象
		Object stu = clazz.newInstance();
		
		//4、调用方法
		/*
		 * 以前：学生对象.setName(值)
		 * 现在：方法对象.invoke(学生对象，值)
		 */
		method.invoke(stu, "张三");
		
		System.out.println(stu);
	}
}
```

### 16.3.5 获取泛型父类信息

示例代码获取泛型父类信息：

```java
/* Type：
 * （1）Class
 * （2）ParameterizedType   
 * 		例如：Father<String,Integer>
 * 			ArrayList<String>
 * （3）TypeVariable
 * 		例如：T，U,E,K,V
 * （4）WildcardType
 * 		例如：
 * 		ArrayList<?>
 * 		ArrayList<? super 下限>
 * 		ArrayList<? extends 上限>
 * （5）GenericArrayType
 * 		例如：T[]
 * 	
 */
public class TestGeneric {
	public static void main(String[] args) {
		//需求：在运行时，获取Son类型的泛型父类的泛型实参<String,Integer>
		
		//（1）还是先获取Class对象
		Class clazz = Son.class;//四种形式任意一种都可以
		
		//（2）获取泛型父类
//		Class sc = clazz.getSuperclass();
//		System.out.println(sc);
		/*
		 * getSuperclass()只能得到父类名，无法得到父类的泛型实参列表
		 */
		Type type = clazz.getGenericSuperclass();
		
		// Father<String,Integer>属于ParameterizedType
		ParameterizedType pt = (ParameterizedType) type;
		
		//（3）获取泛型父类的泛型实参列表
		Type[] typeArray = pt.getActualTypeArguments();
		for (Type type2 : typeArray) {
			System.out.println(type2);
		}
	}
}
//泛型形参：<T,U>
class Father<T,U>{
	
}
//泛型实参：<String,Integer>
class Son extends Father<String,Integer>{
	
}
```

### 16.3.6 读取注解信息

示例代码读取注解信息：

```java
public class TestAnnotation {
	public static void main(String[] args) {
		//需求：可以获取MyClass类型上面配置的注解@MyAnnotation的value值
		
		//读取注解
//		（1）获取Class对象
		Class<MyClass> clazz = MyClass.class;
		
		//（2）获取注解对象
		//获取指定注解对象
		MyAnnotation my = clazz.getAnnotation(MyAnnotation.class);
		
		//（3）获取配置参数值
		String value = my.value();
		System.out.println(value);
	}
}
//声明
@Retention(RetentionPolicy.RUNTIME)  //说明这个注解可以保留到运行时
@Target(ElementType.TYPE) //说明这个注解只能用在类型上面，包括类，接口，枚举等
@interface MyAnnotation{
	//配置参数，如果只有一个配置参数，并且名称是value，在赋值时可以省略value=
	String value();
}

//使用注解
@MyAnnotation("/login")
class MyClass{
	
}
```



# 第十七章 Java8

## 17.1 Lambda表达式与函数式接口

Lambda写的好可以极大的减少代码冗余，同时可读性也好过冗长的匿名内部类。

### 17.1.1 函数式接口

lambda表达式其实就是实现SAM接口的语法糖，所谓SAM接口就是Single Abstract Method，即该接口中只有一个抽象方法需要实现，当然该接口可以包含其他非抽象方法。

其实只要满足“SAM”特征的接口都可以称为函数式接口，但是如果要更明确一点，最好在声明接口时，加上@FunctionalInterface。

之前学过的接口中，是函数式接口的有：Runnable，Comparator，FileFilter

#### **1、消费型接口**

这类接口的抽象方法特点：有形参，但是返回值类型是void

| 接口名               | 抽象方法                       | 描述                       |
| -------------------- | ------------------------------ | -------------------------- |
| Consumer<T>          | void accept(T t)               | 接收一个对象用于完成功能   |
| BiConsumer<T,U>      | void accept(T t, U u)          | 接收两个对象用于完成功能   |
| DoubleConsumer       | void accept(double value)      | 接收一个double值           |
| IntConsumer          | void accept(int value)         | 接收一个int值              |
| LongConsumer         | void accept(long value)        | 接收一个long值             |
| ObjDoubleConsumer<T> | void accept(T t, double value) | 接收一个对象和一个double值 |
| ObjIntConsumer<T>    | void accept(T t, int value)    | 接收一个对象和一个int值    |
| ObjLongConsumer<T>   | void accept(T t, long value)   | 接收一个对象和一个long值   |

#### **2、供给型接口**

这类接口的抽象方法特点：无参，但是无返回值

| 接口名          | 抽象方法               | 描述              |
| --------------- | ---------------------- | ----------------- |
| Supplier<T>     | T get()                | 返回一个对象      |
| BooleanSupplier | boolean getAsBoolean() | 返回一个boolean值 |
| DoubleSupplier  | double getAsDouble()   | 返回一个double值  |
| IntSupplier     | int getAsInt()         | 返回一个int值     |
| LongSupplier    | long getAsLong()       | 返回一个long值    |

#### **3、判断型接口**

这里接口的抽象方法特点：有参，但是返回值类型是boolean结果。

| 接口名           | 抽象方法                   | 描述             |
| ---------------- | -------------------------- | ---------------- |
| Predicate<T>     | boolean test(T t)          | 接收一个对象     |
| BiPredicate<T,U> | boolean test(T t, U u)     | 接收两个对象     |
| DoublePredicate  | boolean test(double value) | 接收一个double值 |
| IntPredicate     | boolean test(int value)    | 接收一个int值    |
| LongPredicate    | boolean test(long value)   | 接收一个long值   |

#### **4、功能型接口**

这类接口的抽象方法特点：既有参数又有返回值

| 接口名                  | 抽象方法                                        | 描述                                                |
| ----------------------- | ----------------------------------------------- | --------------------------------------------------- |
| Function<T,R>           | R apply(T t)                                    | 接收一个T类型对象，返回一个R类型对象结果            |
| UnaryOperator<T>        | T apply(T t)                                    | 接收一个T类型对象，返回一个T类型对象结果            |
| DoubleFunction<R>       | R apply(double value)                           | 接收一个double值，返回一个R类型对象                 |
| IntFunction<R>          | R apply(int value)                              | 接收一个int值，返回一个R类型对象                    |
| LongFunction<R>         | R apply(long value)                             | 接收一个long值，返回一个R类型对象                   |
| ToDoubleFunction<T>     | double applyAsDouble(T value)                   | 接收一个T类型对象，返回一个double                   |
| ToIntFunction<T>        | int applyAsInt(T value)                         | 接收一个T类型对象，返回一个int                      |
| ToLongFunction<T>       | long applyAsLong(T value)                       | 接收一个T类型对象，返回一个long                     |
| DoubleToIntFunction     | int applyAsInt(double value)                    | 接收一个double值，返回一个int结果                   |
| DoubleToLongFunction    | long applyAsLong(double value)                  | 接收一个double值，返回一个long结果                  |
| IntToDoubleFunction     | double applyAsDouble(int value)                 | 接收一个int值，返回一个double结果                   |
| IntToLongFunction       | long applyAsLong(int value)                     | 接收一个int值，返回一个long结果                     |
| LongToDoubleFunction    | double applyAsDouble(long value)                | 接收一个long值，返回一个double结果                  |
| LongToIntFunction       | int applyAsInt(long value)                      | 接收一个long值，返回一个int结果                     |
| DoubleUnaryOperator     | double applyAsDouble(double operand)            | 接收一个double值，返回一个double                    |
| IntUnaryOperator        | int applyAsInt(int operand)                     | 接收一个int值，返回一个int结果                      |
| LongUnaryOperator       | long applyAsLong(long operand)                  | 接收一个long值，返回一个long结果                    |
|                         |                                                 |                                                     |
| BiFunction<T,U,R>       | R apply(T t, U u)                               | 接收一个T类型和一个U类型对象，返回一个R类型对象结果 |
| BinaryOperator<T>       | T apply(T t, T u)                               | 接收两个T类型对象，返回一个T类型对象结果            |
| ToDoubleBiFunction<T,U> | double applyAsDouble(T t, U u)                  | 接收一个T类型和一个U类型对象，返回一个double        |
| ToIntBiFunction<T,U>    | int applyAsInt(T t, U u)                        | 接收一个T类型和一个U类型对象，返回一个int           |
| ToLongBiFunction<T,U>   | long applyAsLong(T t, U u)                      | 接收一个T类型和一个U类型对象，返回一个long          |
| DoubleBinaryOperator    | double applyAsDouble(double left, double right) | 接收两个double值，返回一个double结果                |
| IntBinaryOperator       | int applyAsInt(int left, int right)             | 接收两个int值，返回一个int结果                      |
| LongBinaryOperator      | long applyAsLong(long left, long right)         | 接收两个long值，返回一个long结果                    |

### 17.1.2 Lambda表达式语法

Lambda表达式是用来给【函数式接口】的变量或形参赋值用的。

其实本质上，Lambda表达式是用于实现【函数式接口】的“抽象方法”

Lambda表达式语法格式

```java
(形参列表) -> {Lambda体}
```

说明：

* (形参列表)它就是你要赋值的函数式接口的抽象方法的(形参列表)，照抄
* {Lambda体}就是实现这个抽象方法的方法体
* ->称为Lambda操作符（减号和大于号中间不能有空格，而且必须是英文状态下半角输入方式）

习得电脑安装的手艺，码得一手代码。业余时间，更是热衷于帮女同学修电脑。

优化：Lambda表达式可以精简

* 当{Lambda体}中只有一句语句时，可以省略{}和{;}
* 当{Lambda体}中只有一句语句时，并且这个语句还是一个return语句，那么return也可以省略，但是如果{;}没有省略的话，return是不能省略的
* 当(形参列表)的类型是已知的，那么形参的类型可以省略
* 当(形参列表)的类型是已知的，并且形参个数只有一个，那么可以把数据类型和()一起省略，但是形参名不能省略
* 当(形参列表)是空参时，()不能省略

示例代码：

```java
public class TestLambdaGrammer {
	@Test
	public void test1(){
		//用Lambda表达式给Runnable接口的形参或变量赋值
		/*
		 * 确定两件事，才能写好lambda表达式
		 * （1）这个接口的抽象方法长什么样：
		 * 		public void run()
		 * （2）这个抽象方法的实现要干什么事
		 * 		例如：我要打印“hello lambda"
		 */
		Runnable r = () -> {System.out.println("hello lambda");};
	}
	
	@Test
	public void test2(){
		//lambda体省略了{;}
		Runnable r = () -> System.out.println("hello lambda");
	}
	
	@Test
	public void test3(){
		String[] arr = {"hello","Hello","java","chai"};
		
		//为arr数组排序，但是，想要不区分大小写
		/*
		 * public static <T> void sort(T[] a,Comparator<? super T> c)
		 * 这里要用Lambda表达式为Comparator类型的形参赋值
		 * 
		 * 两件事：
		 * （1）这个接口的抽象方法：  int compare(T o1, T o2)
		 * （2）这个抽象方法要做什么事？
		 * 		例如：这里要对String类型的元素，不区分大小写的比较大小
		 */
//		Arrays.sort(arr, (String o1, String o2) -> {return o1.compareToIgnoreCase(o2);});
		
		//省略了{return ;}
//		Arrays.sort(arr, (String o1, String o2) ->  o1.compareToIgnoreCase(o2));
		
		//省略了两个String
		Arrays.sort(arr, (o1, o2) ->  o1.compareToIgnoreCase(o2));
		
		for (String string : arr) {
			System.out.println(string);
		}
	}
	
	@Test
	public void test4(){
		ArrayList<String> list = new ArrayList<>();
		list.add("hello");
		list.add("java");
		list.add("world");
		
		/*
		 * JDK1.8给Collection系列的集合，准确的讲是在Iterable接口中，增加了一个默认方法
		 * 		default void forEach(Consumer<? super T> action) 
		 * 这个方法是用来遍历集合等的。代替原来的foreach循环的。
		 * 
		 * 这个方法的形参是Consumer接口类型，它是函数式接口中消费型接口的代表
		 * 我现在调用这个方法，想要用Lambda表达式为Consumer接口类型形参赋值
		 * 
		 * 两件事：
		 * （1）它的抽象方法：  void  accept(T t)
		 * （2）抽象方法的实现要完成的事是什么
		 * 		例如：这里要打印这个t
		 */
//		list.forEach((String t) -> {System.out.println(t);});
		
		//省略{;}
//		list.forEach((String t) -> System.out.println(t));
		
		//省略String
//		list.forEach((t) -> System.out.println(t));
		
		//可以省略形参()
		list.forEach(t -> System.out.println(t));
	}
}

```



### 17.1.3 方法引用与构造器引用

Lambda表达式是可以简化函数式接口的变量与形参赋值的语法。而方法引用和构造器引用是为了简化Lambda表达式的。

1、当Lambda表达式满足一些特殊的情况时，还可以再简化：

（1）Lambda体只有一句语句，并且是通过调用一个对象的/类现有的方法来完成的

例如：System.out对象，调用println()方法来完成Lambda体

​          Math类，调用random()静态方法来完成Lambda体

（2）并且Lambda表达式的形参正好是给该方法的实参

例如：t->System.out.println(t)

​        () -> Math.random() 都是无参



2、方法引用的语法格式：

（1）实例对象名::实例方法		

（2）类名::静态方法

（3）类名::实例方法



说明：

* ::称为方法引用操作符（两个:中间不能有空格，而且必须英文状态下半角输入）

* Lambda表达式的形参列表，全部在Lambda体中使用上了，要么是作为调用方法的对象，要么是作为方法的实参。

* 在整个Lambda体中没有额外的数据。



3、构造器引用

（1）当Lambda表达式是创建一个对象，并且满足Lambda表达式形参，正好是给创建这个对象的构造器的实参列表。

（2）  当Lambda表达式是创建一个数组对象，并且满足Lambda表达式形参，正好是给创建这个数组对象的长度



4、构造器引用的语法格式：

* 类名::new

* 数组类型名::new

示例代码：

```java
public class TestMethodReference {
	
	//这个方法是模仿HashMap中，把你指定的数组的长度纠正为2的n次方的代码
	//createArray()的作用是，创建一个长度为2的n次方的数组
	public <R> R[] createArray(Function<Integer,R[]> fun,int length){
		int n = length - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        length = n < 0 ? 1 : n + 1;
		return fun.apply(length);
	}
	
	@Test
	public void test6(){
		/*
		 * Function是一个函数式接口，可以用Lambda表达式赋值
		 * Function<T,R>的抽象方法   R apply(T t)
		 * 
		 * createArray这个方法中用的是Function<Integer,R[]> fun。说明T类型已经指定为Integer
		 * 说明
		 */
//		Function<Integer,String[]> f = (Integer len) -> new String[len];
		
		//因为Lambda体是在创建一个数组对象完成的，而且Lambda表达式的形参正好是创建数组用的长度
		//通过构造器引用省略
		Function<Integer,String[]> f = String[]::new;
		String[] array = createArray(f, 10);
		
		System.out.println(array.length);//16
	}
	
	@Test
	public void test5(){
//		Supplier<String> s = () -> new String();//通过供给型接口，提供一个空字符串对象
		
		//构造器引用
		Supplier<String> s = String::new;//通过供给型接口，提供一个空字符串对象
	}
	
	@Test
	public void test4(){
//		Runnable r = () -> System.out.println("hello lambda");
		Runnable r = System.out::println;//打印空行
		
		//不能简化方法引用，因为"hello lambda"这个无法省略
	}
	
	@Test
	public void test3(){
		String[] arr = {"Hello","java","chai"};
//		Arrays.sort(arr, (s1,s2) -> s1.compareToIgnoreCase(s2));
		
		//用方法引用简化
		/*
		 * Lambda表达式的形参，第一个（例如：s1），正好是调用方法的对象，剩下的形参(例如:s2)正好是给这个方法的实参
		 */
		Arrays.sort(arr, String::compareToIgnoreCase);
	}
	
	@Test
	public void test2(){
//		Stream<Double> stream = Stream.generate(() -> Math.random());
		
		//用方法引用简化
		Stream<Double> stream = Stream.generate(Math::random);
	}
	
	@Test
	public void test1(){
		List<Integer> list = Arrays.asList(1,3,4,8,9);
		
		//list.forEach(t -> System.out.println(t));
		
		//用方法再简化
		list.forEach(System.out::println);
	}
}

```

## 17.2 StreamAPI

Java8中有两大最为重要的改变。第一个是 Lambda 表达式；另外一个则是 Stream API。

Stream API ( java.util.stream) 把真正的函数式编程风格引入到Java中。这是目前为止对Java类库最好的补充，因为Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。

Stream 是 Java8 中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作。 使用Stream API 对集合数据进行操作，就类似于使用 SQL 执行的数据库查询。也可以使用 Stream API 来并行执行操作。简言之，Stream API 提供了一种高效且易于使用的处理数据的方式。

Stream是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。“集合讲的是数据，负责存储数据，Stream流讲的是计算，负责处理数据！”

注意：

①Stream 自己不会存储元素。

②Stream 不会改变源对象。每次处理都会返回一个持有结果的新Stream。

③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。

Stream 的操作三个步骤：

1- 创建 Stream：通过一个数据源（如：集合、数组），获取一个流

2- 中间操作：中间操作是个操作链，对数据源的数据进行n次处理，但是在终结操作前，并不会真正执行。

3- 终止操作：一旦执行终止操作，就执行中间操作链，最终产生结果并结束Stream。



![1560769396655](imgs/1560769396655.png)

### 17.2.1 创建Stream

**1、创建 Stream方式一：通过集合**

Java8 中的 Collection 接口被扩展，提供了两个获取流的方法：

* public default Stream<E> stream() : 返回一个顺序流


* public default Stream<E> parallelStream() : 返回一个并行流


**2、创建 Stream方式二：通过数组**

Java8 中的 Arrays 的静态方法 stream() 可以获取数组流：

* public static <T> Stream<T> stream(T[] array): 返回一个流




重载形式，能够处理对应基本类型的数组：

* public static IntStream stream(int[] array)：返回一个整型数据流

* public static LongStream stream(long[] array)：返回一个长整型数据流

* public static DoubleStream stream(double[] array)：返回一个浮点型数据流


**3、创建 Stream方式三：通过Stream的of()**

可以调用Stream类静态方法 of(), 通过显示值创建一个流。它可以接收任意数量的参数。

* public static<T> Stream<T> of(T... values) : 返回一个顺序流


**4、创建 Stream方式四：创建无限流**

可以使用静态方法 Stream.iterate() 和 Stream.generate(), 创建无限流。

* public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f):返回一个无限流

* public static<T> Stream<T> generate(Supplier<T> s) ：返回一个无限流




### 17.2.2  中间操作

多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！而在终止操作时一次性全部处理，称为“惰性求值”。

| **方  法**                          | **描  述**                                                   |
| ----------------------------------- | ------------------------------------------------------------ |
| **filter(Predicate p)**             | 接收 Lambda ， 从流中排除某些元素                            |
| **distinct()**                      | 筛选，通过流所生成元素的equals() 去除重复元素                |
| **limit(long maxSize)**             | 截断流，使其元素不超过给定数量                               |
| **skip(long n)**                    | 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补 |
| **peek(Consumer** **action)**       | 接收Lambda，对流中的每个数据执行Lambda体操作                 |
| **sorted()**                        | 产生一个新流，其中按自然顺序排序                             |
| **sorted(Comparator com)**          | 产生一个新流，其中按比较器顺序排序                           |
| **map(Function f)**                 | 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。 |
| **mapToDouble(ToDoubleFunction f)** | 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。 |
| **mapToInt(ToIntFunction f)**       | 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。 |
| **mapToLong(ToLongFunction f)**     | 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。 |
| **flatMap(Function f)**             | 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流 |

### 17.2.3  终结操作

终端操作会从流的流水线生成结果。其结果可以是任何不是流的值，例如：List、Integer，甚至是 void。流进行了终止操作后，不能再次使用。

| **方法**                                   | **描述**                                                     |
| ------------------------------------------ | ------------------------------------------------------------ |
| **boolean** **allMatch(Predicate p)**      | 检查是否匹配所有元素                                         |
| **boolean** **anyMatch**(**Predicate p**)  | 检查是否至少匹配一个元素                                     |
| **boolean** **noneMatch(Predicate  p)**    | 检查是否没有匹配所有元素                                     |
| **Optional<T>** **findFirst()**            | 返回第一个元素                                               |
| **Optional<T>** **findAny()**              | 返回当前流中的任意元素                                       |
| **long** **count()**                       | 返回流中元素总数                                             |
| **Optional<T>** **max(Comparator c)**      | 返回流中最大值                                               |
| **Optional<T>** **min(Comparator c)**      | 返回流中最小值                                               |
| **void** **forEach(Consumer c)**           | 迭代                                                         |
| **T** **reduce(T iden, BinaryOperator b)** | 可以将流中元素反复结合起来，得到一个值。返回 T               |
| **U** **reduce(BinaryOperator b)**         | 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>     |
| **R** **collect(Collector c)**             | 将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法 |

Collector 接口中方法的实现决定了如何对流执行收集的操作(如收集到 List、Set、Map)。另外， Collectors 实用类提供了很多静态方法，可以方便地创建常见收集器实例。



## 17.3 Optional类

到目前为止，臭名昭著的空指针异常是导致Java应用程序失败的最常见原因。以前，为了解决空指针异常，Google公司著名的Guava项目引入了Optional类，Guava通过使用检查空值的方式来防止代码污染，它鼓励程序员写更干净的代码。受到Google Guava的启发，Optional类已经成为Java 8类库的一部分。

   Optional实际上是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。

它的API：

1、如何创建Optional对象？或者说如何用Optional来装值对象或null值

（1）static <T> Optional<T> empty() ：用来创建一个空的Optional

（2）static <T> Optional<T> of(T value) ：用来创建一个非空的Optional

（3）static <T> Optional<T> ofNullable(T value) ：用来创建一个可能是空，也可能非空的Optional



2、如何从Optional容器中取出所包装的对象呢？

（1）T get()  ：要求Optional容器必须非空

T get()与of(T value)使用是安全的



（2）T orElse(T other)  ：

orElse(T other) 与ofNullable(T value)配合使用，

如果Optional容器中非空，就返回所包装值，如果为空，就用orElse(T other)other指定的默认值（备胎）代替



（3）T orElseGet(Supplier<? extends T> other)  ：

如果Optional容器中非空，就返回所包装值，如果为空，就用Supplier接口的Lambda表达式提供的值代替



（4）<X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) 

如果Optional容器中非空，就返回所包装值，如果为空，就抛出你指定的异常类型代替原来的NoSuchElementException



3、其他方法

（1）boolean isPresent()  ：判断Optional容器中的值是否存在

（2）void ifPresent(Consumer<? super T> consumer) ：

判断Optional容器中的值是否存在，如果存在，就对它进行Consumer指定的操作，如果不存在就不做

（3）<U> Optional<U> map(Function<? super T,? extends U> mapper)  

判断Optional容器中的值是否存在，如果存在，就对它进行Function接口指定的操作，如果不存在就不做



# 第十八章 设计模式

## 18.1 模板设计模式（了解）

1、当解决某个问题，或者完成某个功能时，主体的算法结构（步骤）是确定的，只是其中的一个或者几个小的步骤不确定，要有使用者（子类）来确定时，就可以使用模板设计模式

2、示例代码：计算任意一段代码的运行时间

```java
//模板类
public abstract class CalTime{
    public long getTime(){
        //1、获取开始时间
        long start =  System.currentTimeMills();
        
        //2、运行xx代码：这个是不确定的
        doWork();
        
        //3、获取结束时间
        long end =  System.currentTimeMills();
        
        //4、计算时间差
        return end - start;
    }
    
    protected abstract void doWork();
}
```

使用模板类：

```java
public class MyCalTime extends CalTime{
    protected void doWork(){
        //....需要计算运行时间的代码
    }
}
```

测试类

```java
public class Test{
    public static void main(String[] args){
        MyCalTime my = new MyCalTime();
        System.out.println("运行时间：" + my.getTime());
    }
}
```

## 18.2 单例设计模式

单例：整个系统中，某个类型的对象只有一个。

1、饿汉式

（1）枚举式

```java
public enum Single{
    INSTANCE
}
```

（2）形式二

```java
public class Single{
    public static final Single INSTANCE = new Single();
    private Single(){
        
    }
}
```

（3）形式三

```java
public class Single{
    private static final Single INSTANCE = new Single();
    private Single(){
        
    }
    public static Single getInstance(){
        return INSTANCE;
    }
}
```

2、懒汉式

（1）内部类形式

```java
public class Single{
    private Single(){}
    
    private static class Inner{
        static final Single INSTANCE = new Single();
    }
    
    public static Single getInstance(){
        return Inner.INSTANCE;
    }
    
}
```

（2）形式二

```java
public class Single{
    private static Single instance;
    private Single(){}
    
    public static Single getInstance(){
        if(instance == null){
            synchronized(Single.class){
                if(instance == null){
                    instance = new Single();
                }
            }
        }
        return instance;
    }
}
```

## 18.3 工厂设计模式

解决的问题：把对象的创建者与对象的使用者分离，把对象的创建统一到一个地方（工厂）

### 18.3.1 简单工厂模式

示例代码：

```java
interface Car{
	void run();
}

class BMW implements Car{

	@Override
	public void run() {
		System.out.println("让你在宝马车里哭");
	}
	
}
class Benz implements Car{
	@Override
	public void run() {
		System.out.println("奔驰让你坐在引擎盖上哭");
	}
}

class SimpleFactory{
	public static Car getCar(String type){
		switch(type){
		case "宝马":
			return new BMW();
		case "奔驰":
			return new Benz();
		}
		return null;
	}
}
```

如果有反射：简单工厂模式的工厂类可以优化：

```java
class SimpleFactoryPlus{
	/*
	 * type：类型的全名称
	 */
	public static Car getCar(String type) throws Exception{
		//获取Car的实现类的Class对象
		Class clazz = Class.forName(type);
		//创建Car的实现类的实例对象
		Object obj = clazz.newInstance();
		//强转类并返回车的实例对象
		return (Car)obj;
	}
}
```



### 18.3.2 工厂方法模式

示例代码：

```java
interface Car{
	void run();
}

class BMW implements Car{

	@Override
	public void run() {
		System.out.println("让你在宝马车里哭");
	}
	
}
class Benz implements Car{
	@Override
	public void run() {
		System.out.println("奔驰让你坐在引擎盖上哭");
	}
}

//工厂的公共接口
interface Factory{
	Car getCar();
}
class BMWFactory implements Factory{

	@Override
	public BMW getCar() {
		return new BMW();
	}
	
}
class BenzFactory implements Factory{

	@Override
	public Benz getCar() {
		return new Benz();
	}
	
}
```

## 18.4 静态代理模式

静态代理类只能替一个主题接口进行代理工作。

如果主题接口不同，代理工作相同，也需要编写两个代理类。

示例代码：

```java
public class TestProxy {
	@Test
	public void test1(){
		TimeProxy tp = new TimeProxy(new GoodsDAO());
		tp.add();
	}
	@Test
	public void test2(){
		TimeProxy tp = new TimeProxy(new UserDAO());
		tp.add();
	}
}
//主题接口
interface DAO{
	void add();
}
//被代理类
class GoodsDAO implements DAO{
	public void add(){
		System.out.println("商品的添加");
	}
}
class UserDAO implements DAO{
	public void add(){
		System.out.println("用户的添加");
	}
}
//代理类
class TimeProxy implements DAO{
	private DAO target;//target表示被代理者对象

	public TimeProxy(DAO target) {
		super();
		this.target = target;
	}

	@Override
	public void add() {
		long start = System.currentTimeMillis();
		target.add();//核心业务逻辑交还给被代理者
		long end = System.currentTimeMillis();
		System.out.println("时间差：" +(end-start));
	}
	
}
```

## 18.5 动态代理

步骤：

（1）主题接口

（2）被代理类

（3）动态代理的代理工作处理器

要求必须实现：java.lang.reflect.InvocationHandler接口，重写

Object invoke(Object proxy, Method method,Object[] args)

（4）创建代理类对象

java.lang.reflect.Proxy类型的静态方法

newProxyInstance(ClassLoader loader, Class[] interfaces，InvocationHandler h )

（5）调用对用的方法

示例代码：

```java
 /* 步骤：
 * 1、编写主题接口（和静态代理一样）
 * 2、编写被代理类（和静态代理一样）
 * 3、编写代理工作处理器：即代理类要替被代理类做什么事情
 * 要求：必须实现InvocationHandler，重写
 *   Object invoke(Object proxy, Method method, Object[] args)
 *   第一个参数：代理类对象
 *   第二个参数：被代理类和代理类   要执行的方法
 *   第三个参数：要执行方法的实参列表
 *   
 *   这个invoke方法不是程序员调用，当代理类对象执行对应的代理方法时，自动调用的
 *   
 * 4、创建代理类及其对象
 *   需要：Proxy：提供用于创建动态代理类和实例的静态方法，它还是由这些方法创建的所有动态代理类的超类。
 *   
 *    static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) 
 *    第一个参数：被代理类的类加载器，我们希望被代理和代理类使用同一个类加载器
 *    第二个参数：被代理类实现的接口们
 *    第三个参数：代理工作处理器对象
 *    
 * 5、调用被代理的方法   
 */
public class TestProxy2 {
	@Test
	public void test2(){
		//被代理对象
		YongHuDAO sd = new YongHuDAO();
		
		ClassLoader loader = sd.getClass().getClassLoader();//被代理者的类加载器对象
		Class<?>[] interfaces = sd.getClass().getInterfaces();//被代理者实现的接口们
		TimeInvocationHandler h = new TimeInvocationHandler(sd);//代理工作处理器对象
		
		//创建代理类及其对象
		//proxy是代理类的对象，代理类是编译器自动编译生成的一个类
		Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
		
		//这里强转的目的是为了调用增、删、改、查的方法
		//为什么这里强转可以成功了，因为代理类与被代理类实现了相同的主题接口
		DBDAO d = (DBDAO) proxy;
		d.add();
		d.update();
		d.delete();
		d.select();
	}
	
	@Test
	public void test1(){
		//被代理对象
		ShangPinDAO sd = new ShangPinDAO();
		
		ClassLoader loader = sd.getClass().getClassLoader();
		Class<?>[] interfaces = sd.getClass().getInterfaces();
		TimeInvocationHandler h = new TimeInvocationHandler(sd);
		
		//创建代理类及其对象
		//proxy是代理类的对象，代理类是编译器自动编译生成的一个类
		Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
		
		//这里强转的目的是为了调用增、删、改、查的方法
		//为什么这里强转可以成功了，因为代理类与被代理类实现了相同的主题接口
		DBDAO d = (DBDAO) proxy;
		d.add();
		d.update();
		d.delete();
		d.select();
	}
}
//代理工作处理器
class TimeInvocationHandler implements InvocationHandler{
	private Object target;//被代理对象

	public TimeInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start = System.currentTimeMillis();
		
		//被代理对象的xx方法被调用
		/*
		 * 没有反射：  被代理对象.xx方法(args实参列表)
		 * 有了反射：  方法对象.invoke(被代理对象，args实参列表)
		 */
		Object returnValue = method.invoke(target, args);
		
		long end = System.currentTimeMillis();
		System.out.println(method.getName() + "方法运行时间：" + (end-start));
		
		return returnValue;
	}
	
}


//主题接口
interface DBDAO{
	void add();
	void update();
	void delete();
	void select();
}
//被代理类1
class ShangPinDAO implements DBDAO{
	public void add(){
		System.out.println("添加商品");
	}

	@Override
	public void update() {
		System.out.println("修改商品");
	}

	@Override
	public void delete() {
		System.out.println("删除商品");
	}

	@Override
	public void select() {
		System.out.println("查询商品");
	}
}
//被代理类2
class YongHuDAO implements DBDAO{
	public void add(){
		System.out.println("添加用户");
	}

	@Override
	public void update() {
		System.out.println("修改用户");
	}

	@Override
	public void delete() {
		System.out.println("删除用户");
	}

	@Override
	public void select() {
		System.out.println("查询用户");
	}
}
```



