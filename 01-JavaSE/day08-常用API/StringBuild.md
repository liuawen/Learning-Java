## StringBuilder类

[TOC]



### StringBuilder类概述

​	StringBuilder 是一个可变的字符串类，这里的可变指的是 StringBuilder 对象中的内容是可变的,。

如果字符串修改操作比较频繁，应该采用StringBuilder和StringBuffer类，这两个类的方法基本是完全一样的，它们的实现代码也几乎一样，唯一的不同就在于StringBuffer类是线程安全的，而StringBuilder类不是。



### StringBuilder类、StringBuffer、String类的区别

1、可变性。String不可变，StringBuilder与StringBuffer是可变的。

- String类中使用只读字符数组保存字符串，private final char value[]，所以是不可变的（Java 9 中底层把 char 数组换成了 byte 数组，占用更少的空间)。
- StringBuilder与StringBuffer都继承自AbstractStringBuilder类，在AbstractStringBuilder中也是使用字符数组保存字符串，char[]value，这两种对象都是可变的。

2、线程安全性。String和StrinbBuffer是线程安全的，StringBuilder是非线程安全的。

- String线程安全是因为其对象是不可变的，StringBuffer线程安全是因为对方法加了同步锁或者对调用的方法加了同步锁。
- StringBuilder并没有对方法进行加同步锁，所以是非线程安全的。

3、性能。

- String的性能较差，因为每次对String 类型进行改变的时候，都会生成一个新的String对象，然后将指针指向新的String 对象。
- 而StringBuffer/StringBuilder性能更高，是因为每次都是对对象本身进行操作，而不是生成新的对象并改变对象引用。一般情况下StringBuilder 相比StringBuffer 可获得10%~15% 左右的性能提升。

### StringBuilder类的构造方法

- 常用的构造方法

  | 方法名                             | 说明                                       |
  | ---------------------------------- | ------------------------------------------ |
  | public StringBuilder()             | 创建一个空白可变字符串对象，不含有任何内容 |
  | public StringBuilder(String   str) | 根据字符串的内容，来创建可变字符串对象     |

- 示例代码

```java
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        //public StringBuilder()：创建一个空白可变字符串对象，不含有任何内容
        StringBuilder sb = new StringBuilder();
        System.out.println("sb:" + sb);//sb
        System.out.println("sb.length():" + sb.length());//sb.length():0

        //public StringBuilder(String str)：根据字符串的内容，来创建可变字符串对象
        StringBuilder sb2 = new StringBuilder("hello");//sb2:hello
        System.out.println("sb2:" + sb2);
        System.out.println("sb2.length():" + sb2.length());//sb2.length():5
    }
}
```

### StringBuilder类添加和反转方法

添加 append

反转 reverse

- 添加和反转方法

  | 方法名                                  | 说明                     |
  | --------------------------------------- | ------------------------ |
  | public StringBuilder   append(任意类型) | 添加数据，并返回对象本身 |
  | public StringBuilder   reverse()        | 返回相反的字符序列       |

- 示例代码

```java
/*
    StringBuilder 的添加和反转方法
        public StringBuilder append(任意类型)：添加数据，并返回对象本身
        append 添加
        public StringBuilder reverse()：返回相反的字符序列
        reverse 反转
 */
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        //创建对象
        StringBuilder sb = new StringBuilder();
        System.out.println("sb:" + sb );//sb:
//        public StringBuilder append(任意类型)：添加数据，并返回对象本身
        StringBuilder sb2 = sb.append("hello");

        System.out.println("sb:" + sb);//sb:hello
        System.out.println("sb2:" + sb2);//sb2:hello
        System.out.println(sb == sb2);//true

        sb.append("hello");
        sb.append("world");
        sb.append("java");
        sb.append(100);

        //链式编程
//        sb.append("hello").append("world").append("java").append(100);

        System.out.println("sb:" + sb);//sb:hellohelloworldjava100

        //public StringBuilder reverse()：返回相反的字符序列
        sb.reverse();
        System.out.println("sb:" + sb);//sb:001avajdlrowolleholleh
    }
}

```

### StringBuilder和String相互转换

StringBuilder -》 String toString()

String -》 StringBuilder 构造方法

- StringBuilder转换为String

  ​        public String toString()：通过 toString() 就可以实现把 StringBuilder 转换为 String

- String转换为StringBuilder

  ​        public StringBuilder(String s)：通过构造方法就可以实现把 String 转换为 StringBuilder

- 示例代码

```java
/*
    StringBuilder 转换为 String
        public String toString()：通过 toString() 就可以实现把 StringBuilder 转换为 String

    String 转换为 StringBuilder
        public StringBuilder(String s)：通过构造方法就可以实现把 String 转换为 StringBuilder
 */
public class StringBuilderDemo02 {
    public static void main(String[] args) {
        //StringBuilder 转换为 String
        StringBuilder sb = new StringBuilder();
        sb.append("hello");

//        String s = sb; //这个是错误的做法

        //public String toString()：通过 toString() 就可以实现把 StringBuilder 转换为 String
        String s = sb.toString();
        System.out.println(s);//hello

        //String 转换为 StringBuilder
        String s2 = "hello";

//        StringBuilder sb = s2; //这个是错误的做法

        //public StringBuilder(String s2)：通过构造方法就可以实现把 String 转换为 StringBuilder
        StringBuilder sb2 = new StringBuilder(s2);

        System.out.println(sb2);//hello
    }
}

```

### 字符串拼接升级版案例

#### 案例需求

​	定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，

​	并在控制台输出结果。例如，数组为int[] arr = {1,2,3}; ，执行方法后的输出结果为：[1, 2, 3]

int数组   按照指定的格式拼接一个字符串返回 调用该方法 并在控制台输出结果 

#### 代码实现

```java
/*
    需求：
        定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，并在控制台输出结果。
        例如，数组为int[] arr = {1,2,3}; ，执行方法后的输出结果为：[1, 2, 3]

    思路：
        1:定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        2:定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回。
          返回值类型 String，参数列表 int[] arr
        3:在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
        4:调用方法，用一个变量接收结果
        5:输出结果
 */
public class StringBuilderTest01 {
    public static void main(String[] args) {
        //定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        int[] arr = {1, 2, 3};

        //调用方法，用一个变量接收结果
        String s = arrayToString(arr);

        //输出结果
        System.out.println("s:" + s);//s:[1, 2, 3]

    }

    //定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回
    /*
        两个明确：
            返回值类型：String
            参数：int[] arr
     */
    public static String arrayToString(int[] arr) {
        //在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i=0; i<arr.length; i++) {
            if(i == arr.length-1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(", ");
            }
        }

        sb.append("]");

        String s = sb.toString();

        return  s;
    }

}
```

### 字符串反转升级版案例

#### 案例需求

​	定义一个方法，实现字符串反转。键盘录入一个字符串，调用该方法后，在控制台输出结果

​	例如，键盘录入abc，输出结果 cba

实现字符串反转 

#### 代码实现

```java
/*
    需求：
        定义一个方法，实现字符串反转。键盘录入一个字符串，调用该方法后，在控制台输出结果
        例如，键盘录入abc，输出结果 cba

    思路：
        1:键盘录入一个字符串，用 Scanner 实现
        2:定义一个方法，实现字符串反转。返回值类型 String，参数 String s
        3:在方法中用StringBuilder实现字符串的反转，并把结果转成String返回
        4:调用方法，用一个变量接收结果
        5:输出结果
 */
public class StringBuilderTest02 {
    public static void main(String[] args) {
        //键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        //调用方法，用一个变量接收结果
        String s = myReverse(line);

        //输出结果
        System.out.println("s:" + s);
        //eg:
        //输入一个字符串：
        //柳小子
        //s:子小柳
        //
        //Process finished with exit code 0
    }

    //定义一个方法，实现字符串反转。返回值类型 String，参数 String s
    /*
        两个明确：
            返回值类型：String
            参数：String s
     */
    public static String myReverse(String s) {
        //在方法中用StringBuilder实现字符串的反转，并把结果转成String返回
        //String --- StringBuilder --- reverse() --- String
//        StringBuilder sb = new StringBuilder(s);
//        sb.reverse();
//        String ss = sb.toString();
//        return ss;

       return new StringBuilder(s).reverse().toString();
    }
}
```

### 帮助文档查看StringBuilder常用方法

append  添加

reverse 反转

toString  StringBuilder  String   转换

length()    StringBuilder 长度 

| 方法名                                   | 说明                                                |
| ---------------------------------------- | --------------------------------------------------- |
| public   StringBuilder append (任意类型) | 添加数据，并返回对象本身                            |
| public   StringBuilder reverse()         | 返回相反的字符序列                                  |
| public   int   length()                  | 返回长度，实际存储值                                |
| public   String toString()               | 通过toString()就可以实现把StringBuilder转换为String |



我一直都这么水  我不怎么写博客了吧

