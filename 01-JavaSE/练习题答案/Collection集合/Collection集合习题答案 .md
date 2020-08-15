# Collection集合习题

[TOC]

### 练习一：集合框架概念

一、请简述集合框架。

集合框架按照其存储结构可以分为两大类：Collection（一组对象）单列集合java.util.Collection和Map（一组映射关系、一组键值对）双列集合java.util.Map

Collection：接口
（1）它是根接口
（2）它没有直接的实现类，有更具体的子接口：List和Set…
（3）有一些的元素是可以重复的，有些集合的元素是不能重复，有些集合的元素是有序的，有些集合的元素是无序的

Collection是代表一种对象的集合，它是Collection系列的根接口。

它们虽然：有些可能是有序的，有些可能是无序的，有些可能可以重复的，有些不能重复的，但是它们有共同的操作规范，因此这些操作的规范就抽象为了Collection接口。

Collection：单列集合类的根接口，用于存储一系列符合某种规则的元素，它有两个重要的子接口，分别是java.util.List和java.util.Set。其中，List的特点是元素有序、元素可重复。Set的特点是元素无序，而且不可重复。List接口的主要实现类有java.util.ArrayList和java.util.LinkedList，Set接口的主要实现类有java.util.HashSet和java.util.TreeSet。

Map概述

用来存储键值对，映射关系的集合。所有的Map的key都不能重复。

键值对、映射关系的类型：Entry类型

```
Entry接口是Map接口的内部接口。所有的Map的键值对的类型都实现了这个接口。
HashMap中的映射关系，是有一个内部类来实现Entry的接口，JDK1.7是一个叫做Entry的内部类实现Entry接口。
JDK1.8是一个叫做Node的内部类实现Entry接口。
TreeMap中的映射关系，是有一个内部类Entry来实现Entry的接口
```

Map概述

用来存储键值对 映射关系的集合。

### 问：为何Collection不从Cloneable和Serializable接口继承？

**参考答案：**

克隆(cloning)或者是序列化(serialization)的语义和含义是跟具体的实现相关的。因此，应该由集合类的具体实现来决定如何被克隆或者是序列化。

集合类的具体实现来决定如何被克隆或者是序列化。



### 问：Collections类是什么？

**参考答案：**

Java.util.Collections是一个工具类仅包含静态方法，它们操作或返回集合。它包含操作集合的多态算法，返回一个由指定集合支持的新集合和其它一些内容。这个类包含集合框架算法的方法，比如折半搜索、排序、混编和逆序等。

### 问：与Java集合框架相关的有哪些最好的实践？

**参考答案：**

（1）根据需要选择正确的集合类型。比如，如果指定了大小，我们会选用Array而非ArrayList。如果我们想根据插入顺序遍历一个Map，我们需要使用TreeMap。如果我们不想重复，我们应该使用Set。

指定了大小  选择Array数组

不知道大小 动态数据ArrayList

插入顺序遍历一个Map，使用TreeMap 

不想重复 使用Set

（2）一些集合类允许指定初始容量，所以如果我们能够估计到存储元素的数量，我们可以使用它，就避免了重新哈希或大小调整。

指定初始化容量

（3）基于接口编程，而非基于实现编程，它允许我们后来轻易地改变实现。

面向接口编程    易于扩展   容易改变

（4）总是使用类型安全的泛型，避免在运行时出现ClassCastException。

类转换异常

使用类型安全的泛型

（5）使用JDK提供的不可变类作为Map的key，可以避免自己实现hashCode()和equals()。

（6）尽可能使用Collections工具类，或者获取只读、同步或空的集合，而非编写自己的实现。它将会提供代码重用性，它有着更好的稳定性和可维护性。

有，就用。  代码重用性  更好的稳定性和可维护性。

### 问：Java集合框架是什么？说出一些集合框架的优点？

数据结构，容器：

用来装对象…，等各种管理对象的容器。

容器有相同的操作标准：

(1)增

(2)删

(3)改

(4)查

…

因为集合的类型很多，那么我们把它们称为集合框架。

**参考答案：**

每种编程语言中都有集合。集合框架的部分优点如下：
（1）使用核心集合类降低开发成本，而非实现我们自己的集合类。

使用核心集合类

（2）随着使用经过严格测试的集合框架类，代码质量会得到提高。

使用高质量的集合框架类  代码质量提高

（3）通过使用JDK附带的集合类，可以降低代码维护成本。

使用JDK的集合类  降低代码维护成本

（4）复用性和可操作性。

复用性 可操作性

### 问：集合框架中的泛型有什么优点？

**参考答案：**

Java1.5引入了泛型，所有的集合接口和实现都大量地使用它。

泛型允许我们为集合提供一个可以容纳的对象类型，因此，如果你添加其它类型的任何元素，它会在编译时报错。这避免了在运行时出现ClassCastException，因为你将会在编译时得到报错信息。泛型也使得代码整洁，我们不需要使用显式转换和instanceOf操作符。它也给运行时带来好处，因为不会产生类型检查的字节码指令。

Java1.5引入了泛型 所有的集合接口和实现都大量使用它

泛型

### 练习二：Collection集合统计元素出现次数

一、给定以下代码，请定义方法listTest()统计集合中指定元素出现的次数，如"a": 2,"b": 2,"c" :1, "xxx":0。

统计集合中指定元素出现的次数 

```
 Collection<String> list = new ArrayList<>();

​           list.add("a");

​           list.add("a");

​           list.add("b");

​           list.add("b");

​           list.add("c");

​           System.out.println("a:"+listTest(list, "a")); 

​           System.out.println("b:"+listTest(list, "b")); 

​           System.out.println("c:"+listTest(list, "c"));

​           System.out.println("xxx:"+listTest(list, "xxx")); 
```



统计集合中指定元素出现的次数  

遍历集合每一个元素是否等于指定元素 count++       

code

```java
public class CollectionTest01 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        System.out.println("a:" + listTest(list, "a"));
        System.out.println("b:" + listTest(list, "b"));
        System.out.println("c:" + listTest(list, "c"));
        System.out.println("xxx:" + listTest(list, "xxx"));
        //a:2
        //b:2
        //c:1
        //xxx:0
    }

    //定义方法统计集合中指定元素出现的次数
    public static int listTest(Collection<String> list, String s) {
        //定义计数器，初始化为0
        int count = 0;
        //增强for遍历集合
        for (String string : list) {
            //判断传入方法的字符与遍历集合的是否一致
            if (s.equals(string)) {
                //如果一致，加1
                count++;
            }
        }
        return count;
    }
}
```





### 练习三：Collection集合数组转集合

一、定义一个方法，要求此方法把int数组转成存有相同元素的集合(集合里面的元素是Integer)，并返回。()

定义个集合  遍历数组元素add到集合中  返回打印

```java
public class CollectionTest02 {
    public static void main(String[] args) {
        //定义int数组
        int[] arr = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = listTest(arr);
        System.out.println(list);//[1, 2, 3, 4, 5]
    }

    public static ArrayList<Integer> listTest(int[] arr) {
        //定义集合
        ArrayList<Integer> list = new ArrayList<Integer>();
        //遍历数组，把元素依次添加到集合当中
        for (int a : arr) {
            list.add(a);
        }
        return list;
    }
}
```



### 练习四：Collection集合转数组

定义一个集合，并把集合(集合里面的元素是Integer)转成存有相同元素的数组，并将结果输出在控制台。（可以使用Object[]数组类型接收转换的数组）

toArray()

```java
public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }


```



```java
public class CollectionTest03 {
    public static void main(String[] args) {
        //定义集合,添加数据
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(200);
        list.add(300);
        //Object[] toArray()转换成一个Object数组
        Object[] obj =  list.toArray();
        // 遍历数组
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }
        //Result
        //100
        //200
        //300
    }
}

```



### 练习五：Collection集合contains()方法使用

定义一个方法listTest(ArrayList<String> al, String s),要求使用contains()方法判断al集合里面是否包含s。

```java
public class CollectionTest04 {
    public static void main(String[] args) {
        //定义集合，添加数据
        ArrayList<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(listTest(list, "java"));
    }

    public static boolean listTest(ArrayList<String> al, String s) {
        //判断s是否在集合中存在,存在返回true，不存在返回false
        if (al.contains(s)) {
            return true;
        }
        return false;
    }
}

```



### 练习六：Collection集合isEmpty()方法的使用

一、定义一个方法listTest(ArrayList<String> al), 要求使用isEmpty()判断al里面是否有元素。

```java
public class CollectionTest05 {
    public static void main(String[] args) {
        //定义集合，添加数据
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.remove(0);
        System.out.println(listTest(list));//true
    }

    public static boolean listTest(ArrayList<String> al) {
        //判断al集合是否为空,为空返回true，不为空返回false
        if (al.isEmpty()) {
            return true;
        }
        return false;
    }
}

```



### 练习七：简述迭代器的实现原理

一、请简述迭代器的实现原理

当遍历集合时，首先通过调用集合的iterator()方法获得迭代器对象，然后使用hashNext()方法判断集合中是否存在下一个元素，如果存在，则调用next()方法将元素取出，否则说明已到达了集合末尾，停止遍历元素。

Iterator迭代器对象在遍历集合时，内部采用指针的方式来跟踪集合中的元素，在调用Iterator的next()方法之前，迭代器的索引位于第一个元素之前，不指向任何元素，当第一次调用迭代器的next方法后，迭代器的索引会向后移动一位，指向第一个元素并将该元素返回，当再次调用next方法时，迭代器的索引会指向第二个元素并将该元素返回，依此类推，直到hasNext方法返回false，表示到达了集合的末尾，终止对元素的遍历。

### 问：Iterator是什么？

**参考答案：**

Iterator接口提供遍历任何Collection的接口。我们可以从一个Collection中使用迭代器方法来获取迭代器实例。迭代器取代了Java集合框架中的Enumeration。迭代器允许调用者在迭代过程中移除元素。

### 问：迭代器的优点

**参考答案：**

如果用的是for循环，就用集合自带的remove(),而这样就改变了集合的Size（）循环的时候会出错。但如果把集合放入迭代器，既iterator迭代可以遍历并选择集合中的每个对象而不改变集合的结构，而把集合放入迭代器，用迭代器的remove（）就不会出现问题

### 练习八：Collection集合返回首次出现索引

一、定义一个方法listTest(ArrayList<Integer> al, Integer s)，要求返回s在al里面第一次出现的索引，如果s没出现过返回-1。

```java
public class CollectionTest06 {
    public static void main(String[] args) {
        //定义集合，添加数据
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(listTest(list, 5));//4
    }

    public static int listTest(ArrayList<Integer> al, Integer s) {
        //遍历集合，获取元素，判断元素是否与s相等，相等返回索引
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
```

# 2、参考资料

记录

记录 - [搞定Java核心技术](https://www.bilibili.com/video/BV1R5411t7Ze)
[高薪之路--Java面试题精选集](https://www.imooc.com/read/67)

[【Java】Java->JavaWeb->Spring全家桶->社区、教育、电商项目等等 ](https://www.bilibili.com/video/BV1Re411p7Vx)

从Hello到goodbye

