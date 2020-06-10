**第2章 Java基础技术——基础面试题**

**05 JDK基础面试题**

# 05 JDK基础面试题

更新时间：2020-02-17 09:24:55

![img](assets/5e378de2000138ee06400359.jpg)

![img](assets/bg-l-1583305618833.png)![img](assets/bg-r-1583305618911.png)

书籍乃世人积累智慧之长明灯。

——寇第斯

书籍  积累 智慧 思想 技术

JD  工件描述 (job description)  京东...JD



来看看某招聘网站上的常见的java工程师的JD（见下图），绝大部分职位都会要求**Java基础扎实**。

Java基础扎实 何谓Java基础扎实呢？ 

高级Java研发工程师 技术专家

jd:

1、扎实的Java编程技术，精通Java EE ，对各种开源框架如Spring等深入的了解      开发过框架  重构

2、大型数据库Oracle使用经验，大规模高并发访问的We应用系统设计和开发经验

3、熟练掌握Linux操作系统 对常用命令运用娴熟  能够根据实际需要快速编写shell脚本 

4、具备良好的识别和设计通用框架及模块的能力

5、较强的表达和沟通能力  工作认真 严谨 敬业 对系统质量有近乎苛刻的要求意识

6、大型系统   研发经验优先

![图片描述](assets/5e281ca50001522316000923.jpg)

Java编程基础、精通JavaEE 

Java基础能力  集合类  JVM Java虚拟机 多线程和并发 IO和队列 

Java基础能力  JDK相关的基础能力  面向对象基础能力  Java基础的进阶能力  高级用法的了解 反射等

何为java基础扎实？广义地讲，包括**Java基础能力、集合类、JVM、多线程和并发、IO和队列**等，即对应专栏的第二个模块**Java基础技术**；而狭义地讲，则对应其中的第一个主题**Java基础能力** ，又可分为三部分：

**第一部分是JDK相关的基础能力**，主要体现在对java基础类库的了解；

**第二部分是面向对象基础能力**，主要体现对java编程语言和面向对象思想的了解；

**第三部分是java基础的进阶能力**，主要体现对java语言的高阶用法的了解（如反射等）。

这三部分将分三个章节讲述。

Java基础扎实

Java基础能力、集合类、JVM、多线程和并发、IO和队列

Java基础能力

JDK、面向对象、Java基础

Java基础类库

Java编程语言和面向对象思想

Java语言的高阶用法



## 1. JDK基础知识结构及面试题目分析



### 1.1 JDK基础知识结构

JDK1.8中java包下面的一级包有14个，其中需要我们熟练掌握的有四个（下图中标红部分）。

熟练掌握  集合框架 

java.util  包含集合框架、旧集合类、事件模型，日期和时间设施 国际化和其他实用程序类

字符串tokenizer分词器；编译器  随机数生成器和位数组 

java.lang  编程基础类

java.io 通过数据流，序列化和文件系统提供系统输入和输出

java.nio 定义缓冲区，它们是数据容器，并提供其他NIO包的概述

![图片描述](assets/5e281cb30001494316000794.jpg)



### 2.2 面试考察点

Java基础部分主要考察的是候选人对java基础知识的掌握能力。

对新人而言，面试官需要考察其基础是否扎实，考察兼具深度与广度；对一定经验的人而言，面试官需要考察其是否已远离一线编程，重点在深度，回答时更要全面。

候选人对Java基础知识的掌握能力

对新人而言 面试官需要考察其基础是否扎实     深度与广度 

深度回答时更要全面

所以尽管都是些基础性的问题，但是难度却并不一定小，需要仔细分析。一旦回答错误较多，那面试考察项中的“基础不牢”怕是跑不掉了。

> 基础部分的面试题考察方向基本一致，所以后面两章节不再对此进行展开说明。

基础不牢   仔细分析  

## 2. 典型面试例题及思路分析

**问题1："你常用的JDK类有哪些？请说出5个。"**

String  ArrayList HashMap  Obejct  Integer 

Map 键 值   键盘 按一下一个符号显示   一个变量代表一个值吗？  一个key 一个value  

**参考答案：**

String、StringBuffer、Integer、ArrayList、HashMap、Date、Object（选择其中候选人熟悉的5个）

String  Array List  HashMap Object Integer StringBuffer

**点评：**

这是一道典型的开放题，通常具有如下作用：

（1) 题目开放简单，营造融洽的面试氛围，引导候选人进入状态；

（2) 每个人的答案不一样，便于下一步个性化的考察。

个性化的考察 每个人的答案不一样 便于下一步个性化的考察  

营造融洽的面试氛围 

注意第2点，这也是这道题虽然开放简单却万不可掉以轻心的原因。因为很可能下一个问题就会基于你的答案进一步发问，所以题干虽然问的是你常用的JDK类，但也不可随口乱说，而一定要从精心准备的几个熟悉的类中挑选，一般5个类可以由以下几个展开：String(确实最常用）、ArrayList和HashMap（集合类、几乎必问）、其他可用的类（比如说类似Integer之类）。

String确实最常用 集合类 ArrayList和HashMap集合类   Integer Object

> 题目变种及小Tips：
>
> 如果题干中换种问法：“你常用的java类有哪些？”，那么除了JDK中的类，还可以选一些流行框架中的类，比如说fastjson中的JSONObject，apache中的BeanUtils等等。选择的标准有两个：一是自己确实熟悉，二是方便展开，"吸引"面试官继续发问。

你常用的Java类有哪些？ JDK中的类 、流行框架中的类、 fastjson BeanUtils



**问题2："String、StringBuilder、StringBuffer的区别是什么？"**

**参考答案：**

1、可变性。String不可变，StringBuilder与StringBuffer是可变的。

- String类中使用只读字符数组保存字符串，private final char value[]，所以是不可变的（Java 9 中底层把 char 数组换成了 byte 数组，占用更少的空间)。
- StringBuilder与StringBuffer都继承自AbstractStringBuilder类，在AbstractStringBuilder中也是使用字符数组保存字符串，char[]value，这两种对象都是可变的。

可变性 String不可变 StringBuilder与StringBuffer是可变的

String类中使用只读字符数组保持字符串 private final char value[]  Java9中底层把char数组换成了byte数组 占用更少的空间



2、线程安全性。String和StrinbBuffer是线程安全的，StringBuilder是非线程安全的。

- String线程安全是因为其对象是不可变的，StringBuffer线程安全是因为对方法加了同步锁或者对调用的方法加了同步锁。
- StringBuilder并没有对方法进行加同步锁，所以是非线程安全的。

对方法加了同步锁  或者对调用的方法加了同步锁 

StringBuilder并没有对方法进行加同步锁 所以是非线程安全的  

线程安全性 String和StringBuffer是线程安全的 StringBuilder是非线程安全的

不可变   线程安全 

3、性能。

- String的性能较差，因为每次对String 类型进行改变的时候，都会生成一个新的String对象，然后将指针指向新的String 对象。
- 而StringBuffer/StringBuilder性能更高，是因为每次都是对对象本身进行操作，而不是生成新的对象并改变对象引用。一般情况下StringBuilder 相比StringBuffer 可获得10%~15% 左右的性能提升。

性能 

每次都是对象本身进行操作 而不是生成新的对象并改变对象的引用 

一般情况下StringBuilder相比StringBuffer可或得10%-15%左右得性能提升

如果要操作少量的数据用String

单线程操作字符串缓冲区下操作大量数据StringBuilder

多线程操作字符串缓冲区下操作大量数组StringBuffer

**点评：**

一般候选人的答案是可变性与线程安全性的差别，但其实性能也是很重要的一个点。回答到这个点上，说明你对性能比较敏感，有承担大型网站架构的高可用、高性能方面的潜力。

- 如果要操作少量的数据用String；
- 单线程操作字符串缓冲区下操作大量数据StringBuilder；
- 多线程操作字符串缓冲区下操作大量数据StringBuffer；

**问题3："int和Integer的区别?"**

**参考答案：**

int是java内置的8种基本数据类型之一，而Integer是Java为int对应引入的对应的包装类型（wrapper class）。从Java 5开始引入了自动装箱/拆箱机制，使得二者可以相互转换。

int Integer

int是Java内置的8种基本数据类型之一 而integer是Java为int基本数据类型 引入的对应的包装类型 wrapper class，从Java 5开始引入了自动装箱 拆箱机制 使得二者可以相互转换。

**点评：**

Java是一个近乎纯洁的面向对象编程语言，但是为了编程的方便还是引入了基本数据类型，而为了能够将这些基本数据类型当成对象操作，Java为每一个基本数据类型都引入了对应的包装类型（wrapper class），int的包装类就是Integer，从Java 5开始引入了自动装箱/拆箱机制，使得二者可以相互转换。

为什么  为了能够将这些基本数据类型当成对象操作  Java为每一个基本数据类型都引入了对应的包装类型 wrapper class int的包装类型就是Integer  从Java5开始引入了自动装箱 拆箱机制 使得二者可以相互转换 

Java 为每个原始类型提供了包装类型：

| 原始类型 | boolean | char      | byte | short | int     | long | float | double |
| :------- | :------ | :-------- | :--- | :---- | :------ | :--- | :---- | :----- |
| 包装类型 | Boolean | Character | Byte | Short | Integer | Long | Float | Double |

> 题目变种：
>
> 这个题目的变种通常考察Integer的源码实现及自动装箱/拆箱机制
>
> 变种1：给出各==运算符的逻辑结果值
>
> ```java
> public static void main(String[] args) {
>  Integer a = new Integer(3);
>  Integer d = new Integer(3);   // 通过new来创建的两个Integer对象
>  Integer b = 3;                  // 将3自动装箱成Integer类型    int c = 3;
>  int     c = 3;                  // 基本数据类型3
>  System.out.println(a == b);     // false 两个引用没有引用同一对象
>  System.out.println(a == d);     // false 两个通过new创建的Integer对象也不是同一个引用
>  System.out.println(c == b);     // true b自动拆箱成int类型再和c比较
> }
> ```
>
>  当两边都是Integer对象时，是**引用比较**；当其中一个是int基本数据类型时，另一个Integer对象也会自动拆箱变成int类型再进行**值比较**。
>
> 变种2：给出各==运算符的逻辑结果值
>
> ```java
> public static void main(String[] args) {
>  Integer f1 = 100;
>  Integer f2 = 100;
>  Integer f3 = 150;
>  Integer f4 = 150;
> 	System.out.println(f1 == f2);   // true，当int在[-128,127]内时，结果会缓存起来
> 		System.out.println(f3 == f4);   // false，属于两个对象
> }
> ```
>
> 这时很容易认为两个输出要么都是true要么都是false。首先需要注意的是f1、f2、f3、f4四个变量都是Integer对象引用，所以下面的==运算比较的不是值而是引用。装箱的本质是什么呢？当我们给一个Integer对象赋一个int值的时候，会调用Integer类的静态方法valueOf，关键代码如下：
>
> ```java
> public static Integer valueOf(int i) {
> if (i >= IntegerCache.low && i <= IntegerCache.high)
>  return IntegerCache.cache[i + (-IntegerCache.low)];
> returnnew Integer(i);
> }
> ```
>
> IntegerCache是Integer的内部类。简单的说，如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，所以上面的面试题中f1f2的结果是true，而f3f4的结果是false。



integerCache 是integer 的内部类 



**问题4：“两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这样说对不对？"**

**参考答案：**

不对。如果两个对象x和y满足x.equals(y) == true，它们的hash code应当相同。

Java对于eqauls方法和hashCode方法是这样规定的：(1)如果两个对象相同（equals方法返回true），那么它们的hashCode值一定要相同；(2)如果两个对象的hashCode相同，它们并不一定相同。

当然，你未必要按照要求去做，但是如果你违背了上述原则就会发现在使用容器时，相同的对象可以出现在Set/Map集合中，同时增加新元素的效率会大大下降（对于使用哈希存储的系统，如果哈希码频繁的冲突将会造成存取性能急剧下降）。

**点评：**

这个题目有很多种问法，比如说**equals、==和hashCode的区别是什么**等等。但这种问法比较干，不如本题中引入场景来进行发问，当然考察的核心其实一样。

关于equals和hashCode方法，很多人也就是仅仅知道而已，在Joshua Bloch的大作《Effective Java》中是这样介绍equals方法的，需要满足：

- 自反性（x.equals(x)必须返回true）；
- 对称性（x.equals(y)返回true时，y.equals(x)也必须返回true）；
- 传递性（x.equals(y)和y.equals(z)都返回true时，x.equals(z)也必须返回true）；
- 一致性（当x和y引用的对象信息没有被修改时，多次调用x.equals(y)应该得到同样的返回值），而且对于任何非null值的引用x，x.equals(null)必须返回false。

**问题5：“如果你的Serializable类中包含一个不可序列化的成员，会发生什么？如何解决呢？"**

**参考答案**：

任何序列化该类的尝试都会因NotSerializableException而失败，但这可以通过在 Java中给属性设置瞬态(transient)变量来轻松解决。adj. 短暂的；路过的 transient

adj. 可串行化的  serializable

**点评：**

序列化一般和输入输出有关，如读取本地文件，读取远程数据等，典型的如RPC调用等。主要考察广度。

RPC是远程过程调用（Remote Procedure Call）的缩写形式。

你的题目是RPC框架，首先了解什么叫RPC，为什么要RPC，RPC是指远程过程调用，也就是说两台服务器A，B，一个应用部署在A服务器上，想要调用B服务器上应用提供的函数/方法，由于不在一个内存空间，不能直接调用，需要通过网络来表达调用的语义和传达调用的数据。

## 3. 总结

JDK基础部分重点是熟练掌握以下几个包的源码：java.lang.* ，java.util.* , [java.io](http://java.io/).* ,java.nio.*，我们后续很多子主题都会对其中的内容作专题讲解，比如说集合部分、并发部分等。正所谓万变不离其宗，对这部分面试题的应对策略就是：

1. 多看源码，多多理解；
2. 职场新人，广度优先，兼顾深度；有经验的候选人，深度优先，兼顾广度。

广度优先 兼顾深度  

## 4. 扩展阅读及思考题



### 4.1 扩展阅读

- [一篇文章教会你，如何做到招聘要求中的“要有扎实的Java基础”](http://www.zuoxiaolong.com/html/article_232.html)
- [java jdk基础包说明](https://blog.csdn.net/ZYC88888/article/details/90246526)
- [Java核心技术卷I基础知识+卷II高级特性（第10版）](https://item.jd.com/22690417364.html)
- [扩展面试题目_JDK基础面试题](https://github.com/jiehao2019/imooc_java_interview_questions/blob/master/Java基础技术/JDK基础面试题.md)

## 万能的林萧说：一篇文章教会你，如何做到招聘要求中的“要有扎实的Java基础”。

- 　本文来自于一次和群里猿友的交流，具体的情况且听LZ慢慢道来。

- 　　一日，LZ在群里发话，“招人啦。”

- 　　然某群友曰，“群主，俺想去。”

- 　　LZ回之，“你年几何？”

- 　　群友曰，“两年也。”

- 　　LZ憾言之，“惜了，三至五为佳。然如汝有扎实之基础，且附一技之长，倒也并非不可呀。”

- 　　群友惑，问之，“何为一技之长？”

- 　　LZ抚须答曰，“皆可，吾之一技即为写。”

- 　　群友又问之，“何为基础扎实？”

- 　　LZ抚**答曰，“玩好JDK！”

- 　　

- ### 引言

- 　　

- 　　好了，LZ终于特么可以说人话了，请原谅LZ的文言文不好，这逼装的好累。其实很多人对于公司的招聘要求中写的，要有“扎实的Java基础”，都很迷茫。

- 　　这特么到底啥意思？什么东西算作Java基础？学到什么程度才算扎实？

- 　　这些问题的答案，LZ已经用文言文告诉你了，咳咳，答案就是玩好JDK就可以了。

- 　　不过JDK这东西包含的东西实在太多，群里的猿友还是拎不清到底应该学哪个，所以，LZ就专门写一篇文章，来讲一讲JDK应该怎么玩。

- 　　或许有的猿友会问，“林萧是谁？”

- 　　恩，问得好！林萧就是某程序员小说的主角啦，传言无所不知，看看你就知道咯。

- 　　

- ### 玩好JDK

- 　　

- 　　在详细讲解JDK之前，LZ首先要强调下，本文的内容，都是LZ个人的主观判断。因此，各位猿友务必结合自己的判断之后，再决定是否要学习，以及学习到什么程度。

- 　　此外，本文只是告诉你学什么，学到什么程度，本文不会包含太多具体的技术细节讲解。

- 　　JDK其实就是Java SE Development Kit的缩写，要玩好这东西可不简单。JDK主要包含了三部分，第一部分就是**Java运行时环境**，这其实就是JVM。此外，第二部分就是**Java的基础类库**，这个类库的数量还是非常可观的。最后，第三部分就是**Java的开发工具**，它们都是辅助你更好的使用Java的利器。

- 　　那么很显然，要玩好JDK，就是要玩好JDK的这三部分。接下来，咱们就逐个的来说一下，每一个部分要学什么，学到什么程度。

-  

- 　　**第一部分：Java运行时环境**

- 　　这一部分其实就是常说的jre，而它的核心其实就一个东西，就是JVM。

- 　　JVM这个东西，它的重要性LZ不想再强调了，在之前的那篇[《回答阿里社招面试如何准备，顺便谈谈对于Java程序猿学习当中各个阶段的建议》](http://www.cnblogs.com/zuoxiaolong/p/life51.html)中，LZ就说过，JVM那本书甚至比《Thinking in java》还重要，这已经足见LZ多么看重JVM了。

- 　　当然了，只是LZ看重，当然没什么卵用，但只要Java稍微高级一点点的职位，这部分基本上都是面试必问内容，这更加说明了JVM的重要性。

- 　　**所以，对于JVM，没什么可说的，就是往死里学，往死里研究，能有多深就多深！**

-  

- 　　**第二部分：Java的基础类库**

- 　　Java的基础类库从你刚开始学Java就开始接触了，但是，直到你结束整个Java生涯，你都不一定能把所有的类都见一遍。

- 　　这说明了什么？是不是说明了Java基础类库的庞大？

- 　　错！大错特错！这其实真正说明的是，有很多类你完全不必要care它们，因为它们从你接触Java到放弃，都不一定能接触到。

- 　　**所以，搞清楚哪些类重要，哪些类不重要，就非常有必要了。这可以让你以最短的时间，做最有价值的事。**

- 　　首先我们来看看，Java基础类库的包都有哪些，为了使得本文更有代表性，我们取JDK6的包列表。

- ![img](http://www.zuoxiaolong.com/image/201801/07155950660.gif)

- ```
  java.applet 
  java.awt 
  java.awt.color 
  java.awt.datatransfer 
  java.awt.dnd 
  java.awt.event 
  java.awt.font 
  java.awt.geom 
  java.awt.im 
  java.awt.im.spi 
  java.awt.image 
  java.awt.image.renderable 
  java.awt.print 
  java.beans 
  java.beans.beancontext 
  java.io 
  java.lang 
  java.lang.annotation 
  java.lang.instrument 
  java.lang.management 
  java.lang.ref 
  java.lang.reflect 
  java.math 
  java.net 
  java.nio 
  java.nio.channels 
  java.nio.channels.spi 
  java.nio.charset 
  java.nio.charset.spi 
  java.rmi 
  java.rmi.activation 
  java.rmi.dgc 
  java.rmi.registry 
  java.rmi.server 
  java.security 
  java.security.acl 
  java.security.cert 
  java.security.interfaces 
  java.security.spec 
  java.sql 
  java.text 
  java.text.spi 
  java.util 
  java.util.concurrent 
  java.util.concurrent.atomic 
  java.util.concurrent.locks 
  java.util.jar 
  java.util.logging 
  java.util.prefs 
  java.util.regex 
  java.util.spi 
  java.util.zip 
  javax.accessibility 
  javax.activation 
  javax.activity 
  javax.annotation 
  javax.annotation.processing 
  javax.crypto 
  javax.crypto.interfaces 
  javax.crypto.spec 
  javax.imageio 
  javax.imageio.event 
  javax.imageio.metadata 
  javax.imageio.plugins.bmp 
  javax.imageio.plugins.jpeg 
  javax.imageio.spi 
  javax.imageio.stream 
  javax.jws 
  javax.jws.soap 
  javax.lang.model 
  javax.lang.model.element 
  javax.lang.model.type 
  javax.lang.model.util 
  javax.management 
  javax.management.loading 
  javax.management.modelmbean 
  javax.management.monitor 
  javax.management.openmbean 
  javax.management.relation 
  javax.management.remote 
  javax.management.remote.rmi 
  javax.management.timer 
  javax.naming 
  javax.naming.directory 
  javax.naming.event 
  javax.naming.ldap 
  javax.naming.spi 
  javax.net 
  javax.net.ssl 
  javax.print 
  javax.print.attribute 
  javax.print.attribute.standard 
  javax.print.event 
  javax.rmi 
  javax.rmi.CORBA 
  javax.rmi.ssl 
  javax.script 
  javax.security.auth 
  javax.security.auth.callback 
  javax.security.auth.kerberos 
  javax.security.auth.login 
  javax.security.auth.spi 
  javax.security.auth.x500 
  javax.security.cert 
  javax.security.sasl 
  javax.sound.midi 
  javax.sound.midi.spi 
  javax.sound.sampled 
  javax.sound.sampled.spi 
  javax.sql 
  javax.sql.rowset 
  javax.sql.rowset.serial 
  javax.sql.rowset.spi 
  javax.swing 
  javax.swing.border 
  javax.swing.colorchooser 
  javax.swing.event 
  javax.swing.filechooser 
  javax.swing.plaf 
  javax.swing.plaf.basic 
  javax.swing.plaf.metal 
  javax.swing.plaf.multi 
  javax.swing.plaf.synth 
  javax.swing.table 
  javax.swing.text 
  javax.swing.text.html 
  javax.swing.text.html.parser 
  javax.swing.text.rtf 
  javax.swing.tree 
  javax.swing.undo 
  javax.tools 
  javax.transaction 
  javax.transaction.xa 
  javax.xml 
  javax.xml.bind 
  javax.xml.bind.annotation 
  javax.xml.bind.annotation.adapters 
  javax.xml.bind.attachment 
  javax.xml.bind.helpers 
  javax.xml.bind.util 
  javax.xml.crypto 
  javax.xml.crypto.dom 
  javax.xml.crypto.dsig 
  javax.xml.crypto.dsig.dom 
  javax.xml.crypto.dsig.keyinfo 
  javax.xml.crypto.dsig.spec 
  javax.xml.datatype 
  javax.xml.namespace 
  javax.xml.parsers 
  javax.xml.soap 
  javax.xml.stream 
  javax.xml.stream.events 
  javax.xml.stream.util 
  javax.xml.transform 
  javax.xml.transform.dom 
  javax.xml.transform.sax 
  javax.xml.transform.stax 
  javax.xml.transform.stream 
  javax.xml.validation 
  javax.xml.ws 
  javax.xml.ws.handler 
  javax.xml.ws.handler.soap 
  javax.xml.ws.http 
  javax.xml.ws.soap 
  javax.xml.ws.spi 
  javax.xml.ws.wsaddressing 
  javax.xml.xpath 
  org.ietf.jgss 
  org.omg.CORBA 
  org.omg.CORBA_2_3 
  org.omg.CORBA_2_3.portable 
  org.omg.CORBA.DynAnyPackage 
  org.omg.CORBA.ORBPackage 
  org.omg.CORBA.portable 
  org.omg.CORBA.TypeCodePackage 
  org.omg.CosNaming 
  org.omg.CosNaming.NamingContextExtPackage 
  org.omg.CosNaming.NamingContextPackage 
  org.omg.Dynamic 
  org.omg.DynamicAny 
  org.omg.DynamicAny.DynAnyFactoryPackage 
  org.omg.DynamicAny.DynAnyPackage 
  org.omg.IOP 
  org.omg.IOP.CodecFactoryPackage 
  org.omg.IOP.CodecPackage 
  org.omg.Messaging 
  org.omg.PortableInterceptor 
  org.omg.PortableInterceptor.ORBInitInfoPackage 
  org.omg.PortableServer 
  org.omg.PortableServer.CurrentPackage 
  org.omg.PortableServer.POAManagerPackage 
  org.omg.PortableServer.POAPackage 
  org.omg.PortableServer.portable 
  org.omg.PortableServer.ServantLocatorPackage 
  org.omg.SendingContext 
  org.omg.stub.java.rmi 
  org.w3c.dom 
  org.w3c.dom.bootstrap 
  org.w3c.dom.events 
  org.w3c.dom.ls 
  org.xml.sax 
  org.xml.sax.ext 
  org.xml.sax.helpers
  ```

- View Code

- 　　怎么样？是不是被吓到了？这么多包，而且还这么多陌生的包名，有的连见都没见过，这特么怎么玩？

- 　　不要着急，LZ先带你把这些包给分下级别，LZ将这些包一共分为四个级别。

-  

- 　　**第一级别：精读源码**

- 　　该级别包含的包如下：

- ![img](http://www.zuoxiaolong.com/image/201801/07155950660.gif)

- ```
  java.io
  java.lang
  java.util
  ```

- View Code

- 　　精读源码，这是要求最高的级别。但是，要求你精读源码并不意味着，这些类就是最重要的。而是因为，LZ觉得这些类比较常用，而且比较简单，看看它们的源码有助于锻炼你看源码的感觉，也了解一下大神们写代码的风格。

- 　　看这些源码的目的，更多是为了增加你的阅读代码能力。而且，LZ这里必须要强调一下，像Exception和Error这一类的，就不用读源码了，亲。

- 　　其实上面三个包都有一个共同点，那就是这三个包，基本上都是你最常用的了。lang包不用说了，你随便写点啥都得用到，io包和util包也是你平时读写文件和使用数据结构必不可少的。

- 　　看源码从这些常用的包下手找手感，LZ个人觉得再合适不过。

- 　

- 　　**第二级别：深刻理解**

- 　　该级别包含的包如下：

- ![img](http://www.zuoxiaolong.com/image/201801/07155950660.gif)

- ```
  java.lang.reflect
  java.net
  javax.net.*
  java.nio.*
  java.util.concurrent.*
  ```

- View Code

- 　　深刻理解，这个看似比精读源码要求低的级别，其实恰恰是最重要的。这个级别要求的类，全都是一些进阶到高级所必须了解的。

- 　　当然了，这里要强调一点的是，LZ说这些类要深刻理解，而没说要看它们源码，并不是说这些类的源码不能看，或者看了没用。而是这些类的源码往往非常复杂，要了解清楚细节花费的时间是非常多的，因此，花费巨量的时间去研究这么复杂的代码其实没必要的。

- 　　不过，如果你在使用这些类的过程中，遇到了问题，这个时候如果看它们源码可以解决的话，那就不要再矜持了，果断看看源码解决你的问题吧，这是最适合的看源码的契机了。

- 　　小小的透露一下，LZ看过的JDK源码，基本上全是这么看过来的。遇到了问题不要百度和谷歌，看源码能解决你90%的问题。

- 　　此外，看到这四个包的名字，不难看出它们各自代表了什么。reflect代表了反射，net代表了网络IO，nio代表了非阻塞io，concurrent代表了并发。

- 　　这四个家伙可以说每一个都够面试官问上半天的，而且，这四个包的内容，如果你要深刻理解的话，其实还牵扯了很多其它的知识。

- 　　举个例子，反射你要了解清楚的话，你是不是要搞明白JVM的类加载机制？网络IO要搞清楚的话，你是不是要清楚TCP/IP和HTTP、HTTPS？包括并发包，如果你要搞清楚的话，是不是要了解并发的相关知识？

- 　　因此，这四个包要彻底搞清楚，还是需要花费一定时间和精力的。

- 　　但是，请相信LZ，这绝对是值得的，甚至可以说，这四个包用的够不够叼，基本决定了一个Java程序员所处的档次。

- 　　

- 　　**第三级别：会用即可**

- 　　该级别包含的包如下：

- ![img](http://www.zuoxiaolong.com/image/201801/07155950660.gif)

- ```
  java.lang.annotation
  javax.annotation.*
  java.lang.ref
  java.math
  java.rmi.*
  javax.rmi.*
  java.security.*
  javax.security.*
  java.sql
  javax.sql.*
  javax.transaction.*
  java.text
  javax.xml.*
  org.w3c.dom.*
  org.xml.sax.*
  javax.crypto.*
  javax.imageio.*
  javax.jws.*
  java.util.jar
  java.util.logging
  java.util.prefs
  java.util.regex
  java.util.zip
  ```

- View Code

- 　　会用即可，这个级别的要求很显然了，就是会用就可以了。这些包大部分都是在特定的情况下会用到，但却不会时刻用到。

- 　　就像sql包和transaction包，就是操作数据库时用到的。而xml、dom和sax这些，都是操作xml时用到的。其它的包也都是类似的，有使用注解时用的，有远程方法调用时用的，也有涉及到加密时用到的等等。

- 　　这些包在面试时一般不会问到，所以它们的重要性自然要低很多，而且也不太需要刻意的去学，用到了研究一下，会用即可。

- 　　

- 　　**第四级别：请无视它**

- 　　该级别包含了所有以上没有提到的包。

- 　　这个级别就更不用解释了，到现在还没提到的包，基本上可以忽略，因为你基本上不太可能用到它们，比如swing、awt这些玩意儿。

- 　　什么？你说你经常用它们？

- 　　如果真的是这样的话，那么LZ只能遗憾的告诉你，赶紧跳槽吧，你待在这公司没啥前途的，0-0。

- 　　

- 　　**第三部分：Java的开发工具**

- 　　这些开发工具主要就是辅助你开发的了，javac应该是最常用的一个了，虽然你几乎不用手动执行它。

- 　　此外，其实还有一些比较实用的工具，可以帮助你排查问题。而且有的面试官，也会问你这类问题，比如问你平时都用什么工具排查问题。

- 　　LZ觉得比较实用的几个工具主要有jmap、jconsole、jstack、jvisualvm，至于这几个工具有什么作用，LZ这里就不提了，如果你要了解这些命令的详细内容，可以去谷歌或者官网上找，还是非常好找的。

- 　　当然，如果你有兴趣的话，也可以自己去JDK的bin目录下找找，看有没有什么更好玩的工具。

- 　　

- ### 小结

- 　　

- 　　好了，到这里基本上就把“玩好JDK”这件事说完了。

- 　　总的来说，第一级别和第二级别是最重要的。

- 　　**更简单的说，可以把第一级别的那些包称作基础，第二级别的那些包称为进阶**。至于第三级别和第四级别的那些包，就没什么可说的了。

- 　　当然了，最重要的还是那万年不变的JVM，请记住了，**JVM才是你Java根基的根本**，就是再牛逼的类，没了JVM它也就是一个无用的class文件而已。

- 　　如果你想拥有扎实的Java基础，那就抓紧玩好JDK吧。玩好JDK以后，不要忘了学个一技之长，就可以来LZ的公司面试咯。

- 　　嗯，这波招聘广告插入的，很隐晦，没毛病，0-0。

- 　　下期咱们屌程见了，各位！

-  

- 版权声明：本文版权归作者（左潇龙）所有，欢迎转载。但未经作者同意必须保留此段声明，且在文章页面明显位置给出原文连接，否则保留追究法律责任的权利。



感谢分享，博主辛苦了，1点多了博主还在写文章，都这么牛了，还这么拼啊，实在令人生畏啊

总结的不错，楼主的进阶速度是读jdk源码读出来的。

还是先坚持把设计模式学完写完总结在来看源码的事吧，本来也是这么打算的，接下来又有事干了

总结的很到位啊，收益匪浅！！学习方法很重要，不能一味的抱着面向对象的书看啊！！



### 4.2 思考题

## String类型为什么设计成final且不可变的？

String类设计成final的原因： 将方法或类声明为final主要目的是：确保它们不会再子类中改变语义。String类是final类，这意味着不允许任何人定义String的子类。换言之，如果有一个String的引用，它引用的一定是一个String对象，而不可能是其他类的对象。——《Java核心技术 卷I》 不可变的话，可能是为了支持线程安全和字符串常量池



不会再子类中改变语义  

不允许任何入定义String的子类 

[04面试常见的非技术性问题](https://www.imooc.com/read/67/article/1492)[06 Java面向对象面试题](https://www.imooc.com/read/67/article/1494)

精选留言 0

欢迎在这里发表留言，作者筛选后可公开显示



目前暂无任何讨论

 

千学不如一看，千看不如一练

# **精选留言**

build一般不用，为了那点性能引起线程安全问题，得不偿失

不能这么说，代码中还是非限制安全的多。不设计线程安全的就应该用StringBuild

JDK1.8 IntegerCache只在Interger.valueOf里调用判断了，建议修改样例

这和样例不冲突。样例“变种2：给出各==运算符的逻辑结果值”中自动装箱方法默认调用的就是Integer.valueOf()方法。

[
岁月长ch](https://www.imooc.com/u/3850639/articles)

String类设计成final的原因： 将方法或类声明为final主要目的是：确保它们不会再子类中改变语义。String类是final类，这意味着不允许任何人定义String的子类。换言之，如果有一个String的引用，它引用的一定是一个String对象，而不可能是其他类的对象。——《Java核心技术 卷I》 不可变的话，可能是为了支持线程安全和字符串常量池

[jiehao](https://www.imooc.com/u/8443354/articles)

回复[岁月长ch](https://www.imooc.com/u/3850639/articles)

说得不错~

回复

举报

05 JDK基础面试题，问题3的第一个例子。笔者应该是笔误了。a自动拆箱应为b自动拆箱。

是的，我更正一下。

[
哈珀朋友](https://www.imooc.com/u/6646053/articles)

有点茴香豆的感觉了，太细节了

专栏的内容也是一个妥协和平衡的过程

# JDK基础面试题

#### 问：String是最基本的数据类型吗?

**参考答案：**
　　不是，Java基本数据类型只有8种，byte、int、char、long、float、double、boolean和short。

byte short int long float double boolean char 

#### 问：Collection 和 Collections的区别？

**参考答案：**

 Collection是集合类的上级接口，继承与他的接口主要有Set 和List.
　 Collections是针对集合类的一个帮助类，他提供一系列静态方法实现对各种集合的搜索、排序、线程安全化等操作。

提供一系列静态方法实现对各种集合的搜索、排序、线程安全化等操作

Collection是集合类的上级接口 继承与他的接口主要有Set和List

Collections是集合类的一个帮助类  提供一系列静态方法实现对各种集合的搜索 排序 线程安全话等操作

#### 问：String对象的intern()是指什么?

**参考答案：**
intern()方法会首先从常量池中查找是否存在该常量值,如果常量池中不存在则现在常量池中创建,如果已经存在则直接返回. 

比如 String s1="aa"; String s2=s1.intern(); System.out.print(s1==s2);//返回true

intern intern

 n. 实习生，实习医师

vt. 拘留，软禁

intern()方法会首先从常量池中查找是否存在改常量值 如果常量池中不存在则在常量池中创建 如果已经存在则直接返回

#### 问：final、finally、finalize的区别是什么？

**参考答案：**
　 final 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。
finally是异常处理语句结构的一部分，表示总是执行。
finalize是Object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收，例如关闭文件等。

final用于声明属性 方法和类 分别表示属性不可变 方法不可覆盖 类不能继承

finally是异常处理语句结构的有部分 表示总是被执行

finalize是Object类的一种方法 在垃圾收集器执行的时候会调用被回收对象的此方法 可以覆盖此方法提供垃圾收集时的其他资源回收 例如关闭文件等 

#### 问：error和exception有什么区别?

**参考答案：**
　　error通常表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出、不可能指望程序能处理这样的情况；
exception通常表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况；

error通常表示恢复很困难的情况下的一种严重问题  内存溢出 不可能指望程序能处理这样的情况

exception表示一种设计或实现问题 

链接：https://www.nowcoder.com/questionTerminal/d0639e74f46049eebf1cb2811932c9fd?orderByHotValue=1&page=1&onlyReference=false
来源：牛客网

首先Exception和Error都是继承于Throwable 类，在 Java 中只有 Throwable 类型的实例才可以被抛出（throw）或者捕获（catch），它是异常处理机制的基本组成类型。

 Exception和Error体现了JAVA这门语言对于异常处理的两种方式。

 Exception是java程序运行中可预料的异常情况，咱们可以获取到这种异常，并且对这种异常进行业务外的处理。

 Error是java程序运行中不可预料的异常情况，这种异常发生以后，会直接导致JVM不可处理或者不可恢复的情况。所以这种异常不可能抓取到，比如OutOfMemoryError、NoClassDefFoundError等。

 其中的Exception又分为检查性异常和非检查性异常。两个根本的区别在于，检查性异常 必须在编写代码时，使用try catch捕获（比如：IOException异常）。非检查性异常 在代码编写使，可以忽略捕获操作（比如：ArrayIndexOutOfBoundsException），这种异常是在代码编写或者使用过程中通过规范可以避免发生的。



#### 问：运行时异常与受检异常有何异同？

**参考答案：**
运行时异常表示虚拟机的通常操作中可能遇到的异常，是一种常见运行错误，只要程序设计得没有问题通常就不会发生；
受检异常跟程序运行的上下文环境有关，即使程序设计无误，仍然可能因使用的问题而引发。Java编译器要求方法必须声明抛出可能发生的受检异常，但是并不要求必须声明抛出未被捕获的运行时异常。

#### 问：列出一些你常见的运行时异常？

**参考答案：**

- ArithmeticException（算术异常）
- ClassCastException （类转换异常）
- IllegalArgumentException （非法参数异常）
- IndexOutOfBoundsException （下标越界异常）
- NullPointerException （空指针异常）
- SecurityException （安全异常）

#### 问：static都有哪些用法?

**参考答案：**

- 静态变量
- 静态方法
- 静态块，多用于初始化
- 静态内部类.
- 静态导向，即import static.import static是在JDK 1.5之后引入的新特性,可以用来指定导入某个类中的静态资源,并且不需要使用类名.资源名,可以直接使用资源名,比如:

import static java.lang.Math.sin;
public class Test{
public static void main(String[] args){
//System.out.println(Math.sin(20));传统做法
System.out.println(sin(20)); // 静态导包
}
}

静态变量 

静态方法

静态块

静态内部类

静态导向

#### 问：final有哪些用法

**参考答案：**

1. 被final修饰的类不可以被继承
2. 被final修饰的方法不可以被重写
3. 被final修饰的变量不可以被改变.如果修饰引用,那么表示引用不可变,引用指向的内容可变.
4. 被final修饰的方法,JVM会尝试将其内联,以提高运行效率
5. 被final修饰的常量,在编译阶段会存入常量池中.

类   类不能被继承

方法 方法不能被重写

变量 变量不能被改变

方法 JVM会尝试将其内联 以提高运行效率

常量 编译阶段存入常量池中

## 万能的林萧说：一篇文章教会你，如何做到招聘要求中的“要有扎实的Java基础”。

- 　本文来自于一次和群里猿友的交流，具体的情况且听LZ慢慢道来。

- 　　一日，LZ在群里发话，“招人啦。”

- 　　然某群友曰，“群主，俺想去。”

- 　　LZ回之，“你年几何？”

- 　　群友曰，“两年也。”

- 　　LZ憾言之，“惜了，三至五为佳。然如汝有扎实之基础，且附一技之长，倒也并非不可呀。”

- 　　群友惑，问之，“何为一技之长？”

- 　　LZ抚须答曰，“皆可，吾之一技即为写。”

- 　　群友又问之，“何为基础扎实？”

- 　　LZ抚**答曰，“玩好JDK！”

- 　　

- ### 引言

- 　　

- 　　好了，LZ终于特么可以说人话了，请原谅LZ的文言文不好，这逼装的好累。其实很多人对于公司的招聘要求中写的，要有“扎实的Java基础”，都很迷茫。

- 　　这特么到底啥意思？什么东西算作Java基础？学到什么程度才算扎实？

- 　　这些问题的答案，LZ已经用文言文告诉你了，咳咳，答案就是玩好JDK就可以了。

- 　　不过JDK这东西包含的东西实在太多，群里的猿友还是拎不清到底应该学哪个，所以，LZ就专门写一篇文章，来讲一讲JDK应该怎么玩。

- 　　或许有的猿友会问，“林萧是谁？”

- 　　恩，问得好！林萧就是某程序员小说的主角啦，传言无所不知，看看你就知道咯。

- 　　

- ### 玩好JDK

- 　　

- 　　在详细讲解JDK之前，LZ首先要强调下，本文的内容，都是LZ个人的主观判断。因此，各位猿友务必结合自己的判断之后，再决定是否要学习，以及学习到什么程度。

- 　　此外，本文只是告诉你学什么，学到什么程度，本文不会包含太多具体的技术细节讲解。

- 　　JDK其实就是Java SE Development Kit的缩写，要玩好这东西可不简单。JDK主要包含了三部分，第一部分就是**Java运行时环境**，这其实就是JVM。此外，第二部分就是**Java的基础类库**，这个类库的数量还是非常可观的。最后，第三部分就是**Java的开发工具**，它们都是辅助你更好的使用Java的利器。

- 　　那么很显然，要玩好JDK，就是要玩好JDK的这三部分。接下来，咱们就逐个的来说一下，每一个部分要学什么，学到什么程度。

-  

- 　　**第一部分：Java运行时环境**

- 　　这一部分其实就是常说的jre，而它的核心其实就一个东西，就是JVM。

- 　　JVM这个东西，它的重要性LZ不想再强调了，在之前的那篇[《回答阿里社招面试如何准备，顺便谈谈对于Java程序猿学习当中各个阶段的建议》](http://www.cnblogs.com/zuoxiaolong/p/life51.html)中，LZ就说过，JVM那本书甚至比《Thinking in java》还重要，这已经足见LZ多么看重JVM了。

- 　　当然了，只是LZ看重，当然没什么卵用，但只要Java稍微高级一点点的职位，这部分基本上都是面试必问内容，这更加说明了JVM的重要性。

- 　　**所以，对于JVM，没什么可说的，就是往死里学，往死里研究，能有多深就多深！**

-  

- 　　**第二部分：Java的基础类库**

- 　　Java的基础类库从你刚开始学Java就开始接触了，但是，直到你结束整个Java生涯，你都不一定能把所有的类都见一遍。

- 　　这说明了什么？是不是说明了Java基础类库的庞大？

- 　　错！大错特错！这其实真正说明的是，有很多类你完全不必要care它们，因为它们从你接触Java到放弃，都不一定能接触到。

- 　　**所以，搞清楚哪些类重要，哪些类不重要，就非常有必要了。这可以让你以最短的时间，做最有价值的事。**

- 　　首先我们来看看，Java基础类库的包都有哪些，为了使得本文更有代表性，我们取JDK6的包列表。

- ![img](http://www.zuoxiaolong.com/image/201801/07155950660.gif)

- ```
  java.applet 
  java.awt 
  java.awt.color 
  java.awt.datatransfer 
  java.awt.dnd 
  java.awt.event 
  java.awt.font 
  java.awt.geom 
  java.awt.im 
  java.awt.im.spi 
  java.awt.image 
  java.awt.image.renderable 
  java.awt.print 
  java.beans 
  java.beans.beancontext 
  java.io 
  java.lang 
  java.lang.annotation 
  java.lang.instrument 
  java.lang.management 
  java.lang.ref 
  java.lang.reflect 
  java.math 
  java.net 
  java.nio 
  java.nio.channels 
  java.nio.channels.spi 
  java.nio.charset 
  java.nio.charset.spi 
  java.rmi 
  java.rmi.activation 
  java.rmi.dgc 
  java.rmi.registry 
  java.rmi.server 
  java.security 
  java.security.acl 
  java.security.cert 
  java.security.interfaces 
  java.security.spec 
  java.sql 
  java.text 
  java.text.spi 
  java.util 
  java.util.concurrent 
  java.util.concurrent.atomic 
  java.util.concurrent.locks 
  java.util.jar 
  java.util.logging 
  java.util.prefs 
  java.util.regex 
  java.util.spi 
  java.util.zip 
  javax.accessibility 
  javax.activation 
  javax.activity 
  javax.annotation 
  javax.annotation.processing 
  javax.crypto 
  javax.crypto.interfaces 
  javax.crypto.spec 
  javax.imageio 
  javax.imageio.event 
  javax.imageio.metadata 
  javax.imageio.plugins.bmp 
  javax.imageio.plugins.jpeg 
  javax.imageio.spi 
  javax.imageio.stream 
  javax.jws 
  javax.jws.soap 
  javax.lang.model 
  javax.lang.model.element 
  javax.lang.model.type 
  javax.lang.model.util 
  javax.management 
  javax.management.loading 
  javax.management.modelmbean 
  javax.management.monitor 
  javax.management.openmbean 
  javax.management.relation 
  javax.management.remote 
  javax.management.remote.rmi 
  javax.management.timer 
  javax.naming 
  javax.naming.directory 
  javax.naming.event 
  javax.naming.ldap 
  javax.naming.spi 
  javax.net 
  javax.net.ssl 
  javax.print 
  javax.print.attribute 
  javax.print.attribute.standard 
  javax.print.event 
  javax.rmi 
  javax.rmi.CORBA 
  javax.rmi.ssl 
  javax.script 
  javax.security.auth 
  javax.security.auth.callback 
  javax.security.auth.kerberos 
  javax.security.auth.login 
  javax.security.auth.spi 
  javax.security.auth.x500 
  javax.security.cert 
  javax.security.sasl 
  javax.sound.midi 
  javax.sound.midi.spi 
  javax.sound.sampled 
  javax.sound.sampled.spi 
  javax.sql 
  javax.sql.rowset 
  javax.sql.rowset.serial 
  javax.sql.rowset.spi 
  javax.swing 
  javax.swing.border 
  javax.swing.colorchooser 
  javax.swing.event 
  javax.swing.filechooser 
  javax.swing.plaf 
  javax.swing.plaf.basic 
  javax.swing.plaf.metal 
  javax.swing.plaf.multi 
  javax.swing.plaf.synth 
  javax.swing.table 
  javax.swing.text 
  javax.swing.text.html 
  javax.swing.text.html.parser 
  javax.swing.text.rtf 
  javax.swing.tree 
  javax.swing.undo 
  javax.tools 
  javax.transaction 
  javax.transaction.xa 
  javax.xml 
  javax.xml.bind 
  javax.xml.bind.annotation 
  javax.xml.bind.annotation.adapters 
  javax.xml.bind.attachment 
  javax.xml.bind.helpers 
  javax.xml.bind.util 
  javax.xml.crypto 
  javax.xml.crypto.dom 
  javax.xml.crypto.dsig 
  javax.xml.crypto.dsig.dom 
  javax.xml.crypto.dsig.keyinfo 
  javax.xml.crypto.dsig.spec 
  javax.xml.datatype 
  javax.xml.namespace 
  javax.xml.parsers 
  javax.xml.soap 
  javax.xml.stream 
  javax.xml.stream.events 
  javax.xml.stream.util 
  javax.xml.transform 
  javax.xml.transform.dom 
  javax.xml.transform.sax 
  javax.xml.transform.stax 
  javax.xml.transform.stream 
  javax.xml.validation 
  javax.xml.ws 
  javax.xml.ws.handler 
  javax.xml.ws.handler.soap 
  javax.xml.ws.http 
  javax.xml.ws.soap 
  javax.xml.ws.spi 
  javax.xml.ws.wsaddressing 
  javax.xml.xpath 
  org.ietf.jgss 
  org.omg.CORBA 
  org.omg.CORBA_2_3 
  org.omg.CORBA_2_3.portable 
  org.omg.CORBA.DynAnyPackage 
  org.omg.CORBA.ORBPackage 
  org.omg.CORBA.portable 
  org.omg.CORBA.TypeCodePackage 
  org.omg.CosNaming 
  org.omg.CosNaming.NamingContextExtPackage 
  org.omg.CosNaming.NamingContextPackage 
  org.omg.Dynamic 
  org.omg.DynamicAny 
  org.omg.DynamicAny.DynAnyFactoryPackage 
  org.omg.DynamicAny.DynAnyPackage 
  org.omg.IOP 
  org.omg.IOP.CodecFactoryPackage 
  org.omg.IOP.CodecPackage 
  org.omg.Messaging 
  org.omg.PortableInterceptor 
  org.omg.PortableInterceptor.ORBInitInfoPackage 
  org.omg.PortableServer 
  org.omg.PortableServer.CurrentPackage 
  org.omg.PortableServer.POAManagerPackage 
  org.omg.PortableServer.POAPackage 
  org.omg.PortableServer.portable 
  org.omg.PortableServer.ServantLocatorPackage 
  org.omg.SendingContext 
  org.omg.stub.java.rmi 
  org.w3c.dom 
  org.w3c.dom.bootstrap 
  org.w3c.dom.events 
  org.w3c.dom.ls 
  org.xml.sax 
  org.xml.sax.ext 
  org.xml.sax.helpers
  ```

- View Code

- 　　怎么样？是不是被吓到了？这么多包，而且还这么多陌生的包名，有的连见都没见过，这特么怎么玩？

- 　　不要着急，LZ先带你把这些包给分下级别，LZ将这些包一共分为四个级别。

-  

- 　　**第一级别：精读源码**

- 　　该级别包含的包如下：

- ![img](http://www.zuoxiaolong.com/image/201801/07155950660.gif)

- ```
  java.io
  java.lang
  java.util
  ```

- View Code

- 　　精读源码，这是要求最高的级别。但是，要求你精读源码并不意味着，这些类就是最重要的。而是因为，LZ觉得这些类比较常用，而且比较简单，看看它们的源码有助于锻炼你看源码的感觉，也了解一下大神们写代码的风格。

- 　　看这些源码的目的，更多是为了增加你的阅读代码能力。而且，LZ这里必须要强调一下，像Exception和Error这一类的，就不用读源码了，亲。

- 　　其实上面三个包都有一个共同点，那就是这三个包，基本上都是你最常用的了。lang包不用说了，你随便写点啥都得用到，io包和util包也是你平时读写文件和使用数据结构必不可少的。

- 　　看源码从这些常用的包下手找手感，LZ个人觉得再合适不过。

- 　

- 　　**第二级别：深刻理解**

- 　　该级别包含的包如下：

- ![img](http://www.zuoxiaolong.com/image/201801/07155950660.gif)

- ```
  java.lang.reflect
  java.net
  javax.net.*
  java.nio.*
  java.util.concurrent.*
  ```

- View Code

- 　　深刻理解，这个看似比精读源码要求低的级别，其实恰恰是最重要的。这个级别要求的类，全都是一些进阶到高级所必须了解的。

- 　　当然了，这里要强调一点的是，LZ说这些类要深刻理解，而没说要看它们源码，并不是说这些类的源码不能看，或者看了没用。而是这些类的源码往往非常复杂，要了解清楚细节花费的时间是非常多的，因此，花费巨量的时间去研究这么复杂的代码其实没必要的。

- 　　不过，如果你在使用这些类的过程中，遇到了问题，这个时候如果看它们源码可以解决的话，那就不要再矜持了，果断看看源码解决你的问题吧，这是最适合的看源码的契机了。

- 　　小小的透露一下，LZ看过的JDK源码，基本上全是这么看过来的。遇到了问题不要百度和谷歌，看源码能解决你90%的问题。

- 　　此外，看到这四个包的名字，不难看出它们各自代表了什么。reflect代表了反射，net代表了网络IO，nio代表了非阻塞io，concurrent代表了并发。

- 　　这四个家伙可以说每一个都够面试官问上半天的，而且，这四个包的内容，如果你要深刻理解的话，其实还牵扯了很多其它的知识。

- 　　举个例子，反射你要了解清楚的话，你是不是要搞明白JVM的类加载机制？网络IO要搞清楚的话，你是不是要清楚TCP/IP和HTTP、HTTPS？包括并发包，如果你要搞清楚的话，是不是要了解并发的相关知识？

- 　　因此，这四个包要彻底搞清楚，还是需要花费一定时间和精力的。

- 　　但是，请相信LZ，这绝对是值得的，甚至可以说，这四个包用的够不够叼，基本决定了一个Java程序员所处的档次。

- 　　

- 　　**第三级别：会用即可**

- 　　该级别包含的包如下：

- ![img](http://www.zuoxiaolong.com/image/201801/07155950660.gif)

- ```
  java.lang.annotation
  javax.annotation.*
  java.lang.ref
  java.math
  java.rmi.*
  javax.rmi.*
  java.security.*
  javax.security.*
  java.sql
  javax.sql.*
  javax.transaction.*
  java.text
  javax.xml.*
  org.w3c.dom.*
  org.xml.sax.*
  javax.crypto.*
  javax.imageio.*
  javax.jws.*
  java.util.jar
  java.util.logging
  java.util.prefs
  java.util.regex
  java.util.zip
  ```

- View Code

- 　　会用即可，这个级别的要求很显然了，就是会用就可以了。这些包大部分都是在特定的情况下会用到，但却不会时刻用到。

- 　　就像sql包和transaction包，就是操作数据库时用到的。而xml、dom和sax这些，都是操作xml时用到的。其它的包也都是类似的，有使用注解时用的，有远程方法调用时用的，也有涉及到加密时用到的等等。

- 　　这些包在面试时一般不会问到，所以它们的重要性自然要低很多，而且也不太需要刻意的去学，用到了研究一下，会用即可。

- 　　

- 　　**第四级别：请无视它**

- 　　该级别包含了所有以上没有提到的包。

- 　　这个级别就更不用解释了，到现在还没提到的包，基本上可以忽略，因为你基本上不太可能用到它们，比如swing、awt这些玩意儿。

- 　　什么？你说你经常用它们？

- 　　如果真的是这样的话，那么LZ只能遗憾的告诉你，赶紧跳槽吧，你待在这公司没啥前途的，0-0。

- 　　

- 　　**第三部分：Java的开发工具**

- 　　这些开发工具主要就是辅助你开发的了，javac应该是最常用的一个了，虽然你几乎不用手动执行它。

- 　　此外，其实还有一些比较实用的工具，可以帮助你排查问题。而且有的面试官，也会问你这类问题，比如问你平时都用什么工具排查问题。

- 　　LZ觉得比较实用的几个工具主要有jmap、jconsole、jstack、jvisualvm，至于这几个工具有什么作用，LZ这里就不提了，如果你要了解这些命令的详细内容，可以去谷歌或者官网上找，还是非常好找的。

- 　　当然，如果你有兴趣的话，也可以自己去JDK的bin目录下找找，看有没有什么更好玩的工具。

- 　　

- ### 小结

- 　　

- 　　好了，到这里基本上就把“玩好JDK”这件事说完了。

- 　　总的来说，第一级别和第二级别是最重要的。

- 　　**更简单的说，可以把第一级别的那些包称作基础，第二级别的那些包称为进阶**。至于第三级别和第四级别的那些包，就没什么可说的了。

- 　　当然了，最重要的还是那万年不变的JVM，请记住了，**JVM才是你Java根基的根本**，就是再牛逼的类，没了JVM它也就是一个无用的class文件而已。

- 　　如果你想拥有扎实的Java基础，那就抓紧玩好JDK吧。玩好JDK以后，不要忘了学个一技之长，就可以来LZ的公司面试咯。

- 　　嗯，这波招聘广告插入的，很隐晦，没毛病，0-0。

- 　　下期咱们屌程见了，各位！




不错不错，最近正在看一些常用的工具类...
支持(0) 反对(0)
回复 引用
#2楼     时间：2016-10-20 08:36:00      来源：aehyok
刚开始学java，mark一下，。
支持(0) 反对(0)
回复 引用
#3楼     时间：2016-10-20 08:37:00      来源：悠扬的牧笛
不错，这倒是提醒了我，同样的在.Net中应该玩好哪些程序集，赞一个咯。
支持(0) 反对(0)
回复 引用
#4楼     时间：2016-10-20 08:43:00      来源：troy.cui
举一反三，.net，PHP的基础呢？
支持(0) 反对(0)
回复 引用
#5楼     时间：2016-10-20 08:59:00      来源：幻天芒
实在！
支持(0) 反对(0)
回复 引用
#6楼     时间：2016-10-20 09:04:00      来源：Weiseditor
不错不错，赞一下;
支持(0) 反对(0)
回复 引用
#7楼     时间：2016-10-20 09:24:00      来源：六月的余晖
厉害呢
支持(0) 反对(0)
回复 引用
#8楼     时间：2016-10-20 09:30:00      来源：凌柒
不错
支持(0) 反对(0)
回复 引用
#9楼     时间：2016-10-20 09:31:00      来源：醉心
看得出博主是求贤若渴啊
支持(0) 反对(0)
回复 引用
#10楼     时间：2016-10-20 09:34:00      来源：NoGameNoLife
躺枪。。我们公司还真经常用Swing和awt。。。。。。
支持(1) 反对(0)
回复 引用
#11楼     时间：2016-10-20 09:42:00      来源：amonker
@ NoGameNoLife
引用
躺。。我们公司还真经常用Swing和awt。。。。。。

做桌面应用程序？
支持(0) 反对(0)
回复 引用
#12楼     时间：2016-10-20 09:44:00      来源：醉心
感谢分享，博主辛苦了，1点多了博主还在写文章，都这么牛了，还这么拼啊，实在令人生畏啊
支持(0) 反对(0)
回复 引用
#13楼     时间：2016-10-20 09:45:00      来源：hasbug
龙哥好样的，支持你！
-- 上海-土鳖
支持(0) 反对(0)
回复 引用
#14楼     时间：2016-10-20 09:48:00      来源：微笑_loser
mdk
支持(0) 反对(0)
回复 引用
#15楼     时间：2016-10-20 10:00:00      来源：NoGameNoLife
@ amonker
是的
支持(0) 反对(0)
回复 引用
#16楼     时间：2016-10-20 10:10:00      来源：Edwin05
写得好，大赞。
支持(0) 反对(0)
回复 引用
#17楼     时间：2016-10-20 10:11:00      来源：风清扬001
总结的不错，楼主的进阶速度是读jdk源码读出来的。
支持(0) 反对(0)
回复 引用
#18楼     时间：2016-10-20 10:17:00      来源：欲戴王冠.必承其重
支持一下！
支持(0) 反对(0)
回复 引用
#19楼     时间：2016-10-20 10:27:00      来源：小j的梦
恩恩，收藏了
支持(0) 反对(0)
回复 引用
#20楼     时间：2016-10-20 10:34:00      来源：uranusyo
持续学习进阶是硬道理
支持(0) 反对(0)
回复 引用
#21楼     时间：2016-10-20 11:41:00      来源：即可
支持龙哥
支持(0) 反对(0)
回复 引用
#22楼     时间：2016-10-20 11:50:00      来源：花样作死大赛
很好好强大
支持(0) 反对(0)
回复 引用
#23楼     时间：2016-10-20 13:13:00      来源：树琦
感觉写的很不错
支持(0) 反对(0)
回复 引用
#24楼     时间：2016-10-20 14:49:00      来源：李爱戴
还是先坚持把设计模式学完写完总结在来看源码的事吧，本来也是这么打算的，接下来又有事干了
支持(0) 反对(1)
回复 引用
#25楼     时间：2016-10-20 15:36:00      来源：JackieZheng
看完LZ的文章后，发现要走的路还很长
支持(0) 反对(0)
回复 引用
#26楼     时间：2016-10-20 17:11:00      来源：程序诗人
不错不错，有了方向了。
支持(0) 反对(0)
回复 引用
#27楼     时间：2016-10-20 17:33:00      来源：紫寻落
闲得蛋疼
支持(0) 反对(0)
回复 引用
#28楼     时间：2016-10-20 17:41:17      来源：重庆市网友
coolcoolcoolcoolcoolcoolcoolcoolcoolcoolcool11111

支持(0) 反对(0)
回复 引用
#29楼     时间：2016-10-20 19:08:00      来源：悠然自得
为什么没有反对，感觉人生都是不公平的
支持(0) 反对(0)
回复 引用
#30楼     时间：2016-10-20 19:38:00      来源：听卡农的码农
收藏
支持(0) 反对(0)
回复 引用
#31楼     时间：2016-10-21 09:22:00      来源：xyzyyj
说得挺有道理的样子
支持(0) 反对(0)
回复 引用
#32楼     时间：2016-10-21 09:39:00      来源：荆棘人
这文章，读了好爽！
支持(0) 反对(0)
回复 引用
#33楼     时间：2016-10-21 09:41:00      来源：荆棘人
楼主你的 【点赞功能】js好像坏掉了，点不了了！
支持(1) 反对(0)
回复 引用
#34楼     时间：2016-10-23 15:02:00      来源：五月的仓颉
兄弟重开博客了？记得之前不是关了吗
支持(0) 反对(0)
回复 引用
#35楼     时间：2016-10-24 21:16:44      来源：深圳市网友
cool哈哈

支持(0) 反对(0)
回复 引用
#36楼     时间：2016-10-26 13:23:00      来源：异常处理者
总结的很到位啊，收益匪浅！！学习方法很重要，不能一味的抱着面向对象的书看啊！！
支持(0) 反对(0)
回复 引用
#37楼     时间：2016-10-27 18:27:00      来源：木宛城主
楼主，阿里社招现在难进吗，对学历要求高不高
支持(0) 反对(0)
回复 引用
#38楼     时间：2016-10-28 14:32:15      来源：深圳市网友
啊实打实的

支持(0) 反对(0)
回复 引用
#39楼     时间：2016-12-08 15:08:00      来源：强仔Johnny
@ 木宛城主
是的，比较难进，社招学历要求并非那么严格，进阶 + 一技之长 + 独立思考的本事基本就ok。
支持(0) 反对(0)
回复 引用
#40楼     时间：2016-12-15 17:37:00      来源：_xiamu
领教了
支持(0) 反对(0)
回复 引用
#41楼     时间：2017-02-08 23:50:08      来源：杭州市网友
很强，扎实的Java基础

支持(0) 反对(0)
回复 引用
#42楼     时间：2017-02-20 18:28:02      来源：南京市网友
@xingoo
不错不错，最近正在看一些常用的工具类...



# [回答阿里社招面试如何准备，顺便谈谈对于Java程序猿学习当中各个阶段的建议](https://www.cnblogs.com/zuoxiaolong/p/life51.html)

### 引言

　　

　　其实本来真的没打算写这篇文章，主要是LZ得记忆力不是很好，不像一些记忆力强的人，面试完以后，几乎能把自己和面试官的对话都给记下来。LZ自己当初面试完以后，除了记住一些聊过的知识点以外，具体的内容基本上忘得一干二净，所以写这篇文章其实是很有难度的。

　　但是，最近问LZ的人实在是太多了，为了避免重复回答，给自己省点力气，干脆就在这里统一回复了。

　　其实之前LZ写过一篇文章，但是那篇文章更多的是在讨论“面试前该不该刷题”这个话题，而这篇文章将会更加聚焦在面试前如何准备，以及工作当中如何学习这个话题上，而且会尽量写出一些干货。

　　

### 第一个问题：阿里面试都问什么？

　　

　　这个是让LZ最头疼的一个问题，也是群里的猿友们问的最多的一个问题。

　　说实话，LZ只能隐约想起并发、JVM、分布式、TCP/IP协议这些个关键字，具体的问题真的是几乎都没记住。而且就算LZ记住了，也告诉你了，你也背会了，但LZ觉得，在面试中，你被问到一模一样问题的可能性依然很小。

　　甚至，就算你运气好被问到了，你也照着背下来了，也不一定就能对你的面试起到正面的作用，因为面试官万一多问一句，你可能就露馅了，那还不如干脆点说不会更好。

　　LZ参加的是阿里的社招面试，而社招不同于校招，问题的范围其实是很随机的。因为能参加一些比较知名的互联网公司社招的人，70%以上都会有个3-5年的经验。这倒不是说一两年经验的同学没有机会进这些公司，而是因为这种公司，大部分情况下只招一些比较资深的开发和应届生，而不招那些处于中间阶段的人。而1-2年经验的同学，往往就刚好处于这个尴尬的阶段。

　　对于能有3-5年经验的这部分人中，每个人的经历又都不同，所擅长的点也不一样，因此这就会导致每个人的问题和范围都不太一样。

　　很少说有哪个知名的互联网公司，比如BAT、京东、360、搜狐、网易等这些公司，其社招面试还有固定的问题和模式，让你可以像应届生面试一样，在面试前靠临时抱佛脚度过这一关。

　　大部分公司在社招的时候，不光是阿里，其它公司也都一样（因为LZ在一年多前也参加过很多其它知名互联网公司的面试，详情见《[记录2015年年初跳槽的经历！](http://www.cnblogs.com/zuoxiaolong/p/life41.html)》），基本上都分为两个阶段的提问。

　　**第一个阶段是主语言本身以及它的高级特性，第二个阶段是讲述自己的项目，并在中间穿插着问题。**

　　所以，LZ不妨就这两个阶段，谈谈社招面试的准备，而不是去把阿里面试的过程背一遍。说实话，LZ也确实记不住，所以不要再问LZ阿里面试都会问哪些问题了，你看看上面那个连接里的文章，也会发现，LZ里面也基本上没有写具体的问题，原因是一样的，真的记不住啊。（就是因为记忆力的问题，导致LZ从小偏科，文科成绩一直堪忧，-_-）

　　

### 社招面试如何准备

　　

　　LZ会分为四个部分来谈论这个问题，由于LZ本身是Java出身，因此关于主语言的问题，都是与Java相关，其它语言的同学可以选择性忽略。此外，面试的时候一般面试官的问题都是环环相扣，逐渐深入的，这点在下面大家可以更明显的感受出来。

 

　　**1、主语言本身以及它的高级特性。**

　　**主语言当然就是你平日里拿来赚钱的家伙。不要告诉LZ你没有主语言，你会N多种语言，或者是你精通N多种语言，你要非这么说的话，你可以来杭州试试，LZ保证不打死你，最多打残。**

　　LZ的主语言很显然是Java，那么对于Java来说，它的语言本身以及它的高级特性，都有哪些比较容易在面试中问到呢？

　　一般情况下，主要有以下知识点很容易被问到。（PS：以下所列举的，都是一些Java相对而言比较高级一点的知识点，因为这里谈的是社招，而不是校招）

　　**1）Java的数据结构相关的类实现原理，比如LinkedList，ArrayList，HashMap，TreeMap这一类的。以下简单模拟一个数据结构的连环炮。**

　　比如，面试官先问你HashMap是不是有序的？

　　你肯定回答说，不是有序的。那面试官就会继续问你，有没有有顺序的Map实现类？

　　你如果这个时候说不知道的话，那这个问题就到此结束了。如果你说有TreeMap和LinkedHashMap。

　　那么面试官接下来就可能会问你，TreeMap和LinkedHashMap是如何保证它的顺序的？

　　如果你回答不上来，那么到此为止。如果你依然回答上来了，那么面试官还会继续问你，你觉得它们两个哪个的有序实现比较好？

　　如果你依然可以回答的话，那么面试官会继续问你，你觉得还有没有比它更好或者更高效的实现方式？

　　如果你还能说出来的话，那么就你所说的实现方式肯定依然可以问你很多问题。

　　**以上就是一个面试官一步一步提问的例子。所以，如果你了解的不多，千万不要敷衍，因为可能下一个问题你就暴露了，还不如直接说不会，把这个问题结束掉，赶紧切换到你熟悉的领域。**

 

　　**2）Java并发包当中的类，它们都有哪些作用，以及它们的实现原理，这些类就是java.concurrent包下面的。与上面一样，咱们也简单的模拟一个并发包的连环炮。**

　　比如面试官可能会先问你，如果想实现所有的线程一起等待某个事件的发生，当某个事件发生时，所有线程一起开始往下执行的话，有什么好的办法吗？

　　这个时候你可能会说可以用栅栏（Java的并发包中的CyclicBarrier），那么面试官就会继续问你，你知道它的实现原理吗？

　　如果你继续回答的话，面试官可能会继续问你，你还知道其它的实现方式吗？

　　如果你还能说出很多种实现方式的话，那么继续问你，你觉得这些方式里哪个方式更好？

　　如果你说出来某一个方式比较好的话，面试官依然可以继续问你，那如果让你来写的话，你觉得还有比它更好的实现方式吗？

　　如果你这个时候依然可以说出来你自己更好的实现方式，那么面试官肯定还会揪着这个继续问你。

　　**为什么说面试的时候要引导面试官，原因就在这了。因为面试官的提问很多时候都是有迹可循的，你如果抓住了他的轨迹，能够猜到他下面很可能会问什么，那你在回答的时候就可以往你想要谈的方向去说。这样面试时就会显得更加从容，更加的游刃有余。**

　　

　　**3）IO包和NIO包中的内容。这部分里面NIO会是重点，IO包大部分都会比较熟悉，因此可能会直接略过，直接问你NIO的内容。**

　　IO包和NIO包的内容相对来说不是很多，首先NIO模型要熟悉，特别是其中的selector一定要非常清楚它的职责和实现原理。其实NIO的核心是IO线程池，一定要记住这个关键点。有的时候，面试官可能也会问你IO包的设计模式（装饰器模式），为什么要这样设计？

　　有的面试官还会问你有没有更好的设计，这个时候如果你不知道请果断说自己现在的水平有限，想不出来更好的设计，千万不要信口开河，随意YY。

　　

　　**4）Java的虚拟机的内容。这部分主要包括三部分，GC、类加载机制，以及内存。**

　　一个**GC部分简单的连环炮。**

　　面试官可以先问你什么时候一个对象会被GC？

　　接着继续问你为什么要在这种时候对象才会被GC？

　　接着继续问你GC策略都有哪些分类？

　　你如果说出来了，继续问你这些策略分别都有什么优劣势？都适用于什么场景？

　　你继续说出来了以后，给你举个实际的场景，让你选择一个GC策略？

　　你如果选出来了，继续问你，为什么要选择这个策略？

　　**下面是关于类加载机制的简单连环炮。**

　　首先肯定是先问你Java的类加载器都有哪些？

　　回答了这些以后，可能会问你每个类加载器都加载哪些类？

　　说完以后，可能会问你这些类加载之间的父子关系是怎样的？

　　你在回答的时候可能会提到双亲委派模型，那么可以继续问你什么是双亲委派模型？

　　你解释完了以后，可能会继续问你，为什么Java的类加载器要使用双亲委派模型？

　　你回答完以后，可能会继续问你如何自定义自己的类加载器，自己的类加载器和Java自带的类加载器关系如何处理？

　　**再来一个关于内存的连环炮。**

　　首先肯定就是问你内存分为哪几部分，这些部分分别都存储哪些数据？

　　然后继续问你一个对象从创建到销毁都是怎么在这些部分里存活和转移的？

　　接着可能会问你，内存的哪些部分会参与GC的回收？

　　完事以后，可能还会问你Java的内存模型是怎么设计的？

　　你回答了以后，还会继续问你为什么要这么设计？

　　问完以后，还可能会让你结合内存模型的设计谈谈volatile关键字的作用？

　　你在谈的时候，肯定会提到可见性，那么接着可见性这三个字，还可以继续问你并发的内容。

　　

　　**基本上Java语言本身以及语言稍微高级点的内容就是以上部分，如果你能把以上四部分了解的非常透彻，那基本上Java这部分就没啥问题了，因为光以上的内容就够你跟面试官聊很久了。你聊这些聊得久了，自然问你其它问题的时间就会短点。**

　　**你从LZ写这些问题的过程也应该能感受出来，很多时候，面试官都是顺着一条线一路问下去的，如果你觉得这条线你不熟悉的话，就要及时拐弯，引导面试官去问其它方面的问题。千万不要一直往下深入，直到自己跳不出来为止，那就尴了个尬了。**

　　

　　**2、\**讲述自己的项目，并在中间穿插着问题\****

　　这一部分是面试过程中必问，也是聊得最久的一个阶段。除非你前面的语言部分非常扎实，扎实到面试官问了一两个小时，依旧没有探出你对语言本身的了解到底有多深。否则的话，你一定逃不过自己的项目这一关，而且一般情况下聊得时间不会太短。

　　**这一部分内容，一般的模式就是你自己去讲你做过的项目，然后面试官会冷不丁的让你去解释其中某一部分，比如让你解释当时为什么要这么做，或者问你现在觉得有没有更好的办法。而这些穿插的问题，大部分与你的项目所用到的技术有关。而你需要做的，就是充分、再充分的去总结自己做过的项目（尤其是最近的一两个项目），挖掘出一个甚至N个亮点，以备于到时候可以让面试官产生眼前一亮的感觉。如果你能达到这种效果的话，基本上离你成功就不远了。**

　　这部分内容由于和每个人自己的经历息息相关，因此这里也没法列举可能问到的问题。这篇文章《[程序员面经：面试前到底该不该刷题以及面试前该如何准备](http://www.cnblogs.com/zuoxiaolong/p/life48.html)》是LZ之前写的，里面大概讨论了下如何在面试前总结，有兴趣的可以去了解一下。

　　

　　**3、额外的加分项**

　　上面两个阶段基本上是必问的，还有一些加分项。这些加分项中，有些内容面试官也会问你（比如TCP/IP协议、算法），但更多的是会先问你了解不了解，你了解的话再继续聊，不了解的话就直接略过了，不至于因为这种问题而直接把你打入地狱。

　　下面LZ列举一下这些加分项，如果可以的话，这些加分项还是要争取一下的。

　　**1、计算机系统原理。**

　　**2、网络通信协议（TCP/IP，HTTP等）。**

　　**3、数据结构与算法。**

　　**4、著名开源项目的源码。**

　　**5、你自己有很棒的开源项目。**

　　**6、你的个人博客。**

　　**7、待评论区补充。**

　　这几项当中，对于前1-3项，如果你之前就比较了解，只是由于时间问题忘记了的话，还是可以临时抱佛脚一下的。至于后面4-6项，就需要你日常的积累了，不是一时半会儿能做到的。如果你平日里没有积累，那么后面这三个加分项只能抛弃了。

　　

　　**4、与你职位相关的内容**

　　其实这最后一项是对前面三项的补充，你应该尽量去主攻和你面试的职位相关的内容。比如你面试一个实时计算的职位，那么你的算法最好要厉害，对于著名的实时计算开源项目要熟悉，最好阅读过源码，而且还要对分布式系统有一定的见解。

　　因此，这个第4部分没有具体的内容，只是提醒你，如果你很明确自己的面试职位，最好在面试前准备的时候，尽量朝职位的需求方向靠拢，这样成功的可能性更大。

　　

### 对于Java程序猿学习的建议

　　

　　这一部分其实也算是今天的重点，这一部分用来回答很多群里的朋友所问过的问题，那就是LZ你是如何学习Java的，能不能给点建议？

　　今天LZ是打算来点干货，因此咱们就不说一些学习方法和技巧了，直接来谈每个阶段要学习的内容甚至是一些书籍。这一部分的内容，同样适用于一些希望转行到Java的同学。

　　在大家看之前，LZ要先声明两点。

　　1、由于LZ本人是Java后端开发出身，因此所推荐的学习内容是Java Web和Java后端开发的路线，非Java Web和Java后端开发的同学请适当参考其学习思想即可，切勿照搬。

　　2、下面对于【第一部分】的推荐内容，目的是让你尽快成为一个可以参加工作的Java开发者，更适用于处于待业状态，准备转行Java的同学。如果你是在校学生，务必要在学好基础（比如计算机系统、算法、编译原理等等）的前提下，再考虑去进行下面的学习。

　　

　　**第一部分：对于尚未做过Java工作的同学，包括一些在校生以及刚准备转行Java的同学。**

　　**一、Java基础**

　　首先去找一个Java的基础教程学一下，这里可以推荐一个地址，或者你也可以参照这个地址上去找相应的视频，地址为http://www.runoob.com/java/java-tutorial.html。

　　学习Java基础的时候，应该尽量多动手，很多时候，你想当然的事情，等你写出来运行一下，你就会发现不是这么回事儿，不信你就试试。

　　学完以上内容以后，你应该对Java有一个基本的了解了，你可以用Java语言写出一些简单的程序，并且你用的是最简单的编辑器，比如记事本。

　　这个时候，不要急于进入下一部分，留下几天好好写一些程序，尽可能熟悉这些基础内容。

　　**二、Web开发**

　　等你写上几天程序以后，你往往会比较迷茫，因为你写的东西似乎看起来毫无用处，比如实现一个简单的计算器，读取一个文件等。这个时候你就应该去学着写一些让你觉得有意思的东西了，所以你应该学习更多的知识。

　　这些内容主要是Web开发相关的内容，包括HTML/CSS/JS（前端页面）、Servlet/JSP（J2EE）以及Mysql（数据库）相关的知识。

　　它们的学习顺序应该是从前到后，因此最先学习的应该是HTML/CSS/JS（前端页面），这部分内容你可以去上面的那个runoob网站上找。你可以试着自己写一些页面，当然，你可以尽你最大的努力让它变得最漂亮。这部分内容对于后端Java来说，理论上不是特别重要，但至少要达到可以自己写出一些简单页面的水平。

　　接下来，你需要学习的是Servlet/JSP（J2EE）部分，这部分是Java后端开发必须非常精通的部分，因此这部分是这三部分中最需要花精力的，而且这个时候，你要学会使用开发工具，而不能再使用记事本了，可以选择eclipse。

　　当你下载安装好eclipse以后，请视频中的教程一步一步去学习，一定要多动手。关于Servlet/Jsp部分视频的选择，业界比较认可马士兵的视频，因此推荐给大家。当然了，LZ本人并没有看过他的视频，所以不好说的太绝对，如果大家自己有更好的选择，可以坚持自己的，不要被LZ干扰。

　　原本LZ也是打算出教学视频的，但是由于时间问题，还是决定放弃了。但是如果你看视频的过程中遇到了问题，欢迎来LZ的交流群提问，或者去斗鱼观看LZ的直播提出你的问题，直播地址和群号都在LZ的个人博客左侧。

　　最后一步，你需要学会使用数据库，mysql是个不错的入门选择，而且Java领域里主流的关系型数据库就是mysql。这部分一般在你学习Servlet/Jsp的时候，就会接触到的，其中的JDBC部分就是数据库相关的部分。你不仅要学会使用JDBC操作数据库，还要学会使用数据库客户端工具，比如navicat，sqlyog，二选一即可。

　　**三、开发框架**

　　当你学会以上内容以后，这个时候你还不足以参加工作，你还需要继续深造。公司里为了提高开发的效率，会使用一些Java Web框架，因此你还需要学习一些开发框架。

　　目前比较主流的是SSM框架，即spring、springmvc、mybatis。你需要学会这三个框架的搭建，并用它们做出一个简单的增删改查的Web项目。你可以不理解那些配置都是什么含义，以及为什么要这么做，这些留着后面你去了解。但你一定要可以快速的利用它们三个搭建出一个Web框架，你可以记录下你第一次搭建的过程，相信我，你一定会用到的。

　　还要提一句的是，你在搭建SSM的过程中，可能会经常接触到一个叫maven的工具。这个工具也是你以后工作当中几乎是必须要使用的工具，所以你在搭建SSM的过程中，也可以顺便了解一下maven的知识。在你目前这个阶段，你只需要在网络上了解一下maven基本的使用方法即可，一些高端的用法随着你工作经验的增加，会逐渐接触到的。

　　关于学习SSM框架的地址给大家推荐一个，这里面有视频，大家可以去观看，地址是http://edu.51cto.com/lesson/id-76468.html。**
**

　　**四、找工作**

　　当你完成开发框架的学习以后，你就该找工作了，在校的找实习，毕业的找全职。与此同时，在找工作的同时，你不应该停下你的学习，准确的说，是你在以后都不能停下学习。

　　上面这些内容你只是囫囵吞枣的学会了使用，你可以逐步尝试着去了解更多的东西，网络是你最重要的老师。

　　

　　**第二部分：对于参加工作一年以内的同学。**

　　恭喜你，这个时候，你已经拥有了一份Java的工作。这个阶段是你成长极快的阶段，而且你可能会经常加班。

　　但是加班不代表你就可以松懈了，永远记得LZ说的那句话，从你入行那一刻起，你就要不停的学习。在这一年里，你至少需要看完《Java编程思想》这本书。这本书的内容是帮助你对于Java有一个更加深入的了解，是Java基础的升级版。

　　这本书很厚，当初看这本书，LZ花了整整三个月。正常速度的话，应该可以在半年左右看完。LZ这里不要求过高，只要你在一年以内把这本书看完即可。当然了，LZ所说的看完，是充分吸收，而不是读一遍就完事了，因此有些内容你可能会看不止一遍。

　　总而言之，这个阶段的核心学习思想就是，在工作中实践，并且更加深入的了解Java基础。

　　

　　**第三部分：对于参加工作1年到2年的同学。**

　　这部分时间段的同学，已经对Java有了一个更加深入的了解。但是对于面向对象的体会可能还不够深刻，编程的时候还停留在完成功能的层次，很少会去考虑设计的问题。

　　于是这个时候，设计模式就来了。LZ当时看的是《大话设计模式》这本书，并且写了完整版的设计模式博客。因此，LZ要求大家，最多在你工作一年的时候，必须开始写博客，而设计模式就是你博客的开端。

　　请记住，LZ所提的基本都是最低要求，因此不要有任何松懈的心理，否则五年后，你不要去羡慕别人高于你的工资，也不要去羡慕别人进入了某公司。

　　这一年，你必须对于设计模式了如指掌，《大话设计模式》可以作为你的开端。当然了，你也可以去看LZ的个人博客去学习，地址是http://www.cnblogs.com/zuoxiaolong/p/pattern26.html。

　　此外，设计模式并不是你这一年唯一的任务，你还需要看一些关于代码编写优化的书。比如《重构 改善既有代码的设计》，《effective java》。

　　总而言之，这个阶段，你的核心任务就是提高你的代码能力，要能写出一手优雅的代码。

　　

　　**第四部分：对于参加工作2年到3年的同学**

　　有的同学在这个时候觉得自己已经很牛逼了，于是忍不住开始慢慢松懈。请记住，你还嫩的多。

　　这个阶段，有一本书是你必须看的，它叫做《深入理解Java虚拟机》。这本书绝对是Java开发者最重要的书，没有之一。在LZ眼里，这本书的重要性还要高于《Java编程思想》。

　　这本书的内容是帮助你全面的了解Java虚拟机，在这个阶段，你一定已经知道Java是运行在JVM之上的。所以，对于JVM，你没有任何理由不了解它。LZ之前有写过JVM系列的知识，可以去看一下，地址是http://www.cnblogs.com/zuoxiaolong/category/508918.html。

　　另外，在过去2年的工作当中，你肯定或多或少接触过并发。这个时候，你应该去更加深入的了解并发相关的知识，而这部分内容，LZ比较推荐《Java并发编程实战》这本书。只要你把这本书啃下来了，并发的部分基本已经了解了十之六七。

　　与此同时，这个阶段你要做的事情还远不止如此。这个时候，你应该对于你所使用的框架应该有了更深入的了解，对于Java的类库也有了更深入的了解。因此，你需要去看一些JDK中的类的源码，也包括你所使用的框架的源码。

　　这些源码能看懂的前提是，你必须对设计模式非常了解。否则的话，你看源码的过程中，永远会有这样那样的疑问，这段代码为什么要这么写？为什么要定义这个接口，它看起来好像很多余？

　　由此也可以看出，这些学习的过程是环环相扣的，如果你任何一个阶段拉下来了，那么你就真的跟不上了，或者说是一步慢步步慢。而且LZ很负责的告诉你，LZ在这个阶段的时候，所学习的东西远多于这里所罗列出来的。因此千万不要觉得你已经学的很多了，LZ所说的这些都只是最低要求，不光是LZ，很多人在这个时间段所学习的内容都远超本文的范围。

　　如果你不能跟上节奏的话，若干年后，如果不是程序猿市场还不错的话，你很可能不仅仅是工资比别人低，公司没别人好，而是根本就找不到工作。

　　总而言之，这个阶段，你需要做的是深入了解Java底层和Java类库（比如并发那本书就是Java并发包java.concurrent的内容），也就是JVM和JDK的相关内容。而且还要更深入的去了解你所使用的框架，方式比较推荐看源码或者看官方文档。

　　另外，还有一种学习的方式，在2年这个阶段，也应该启用了，那就是造轮子。

　　不要听信那套“不要重复造轮子”的论调，那是公司为了节省时间成本编造出来的。重复造轮子或许对别人没有价值，因为你造的轮子可能早就有了，而且一般情况下你造出来的轮子还没有现存的好。但是对别人没有价值，不代表对你自己没有价值。

　　一个造轮子的过程，是一个从无到有的过程。这个过程可以对你进行系统的锻炼，它不仅考察你的编码能力，还考察你的框架设计能力，你需要让你的轮子拥有足够好的扩展性、健壮性。

　　而且在造轮子的过程中，你会遇到各种各样的难题，这些难题往往又是你学习的契机。当你把轮子造好的时候，你一定会发现，其实你自己收获了很多。

　　所以，这个阶段，除了上面提到的了解JVM、JDK和框架源码以外，也请你根据别人优秀的源码，去造一个任何你能够想象出来的轮子。

　　

　　**第五部分：参加工作3年到4年的同学**

　　这个阶段的同学，提升已经是很难了，而且这个阶段的学习往往会比较多样化。

　　因为在前3年的过程中，你肯定或多或少接触过一些其它的技术，比如大数据、分布式缓存、分布式消息服务、分布式计算、软负载均衡等等。这些技术，你能精通任何一项，都将是你未来面试时巨大的优势，因此如果你对某一项技术感兴趣的话，这个时候可以深入去研究一下。这项技术不一定是你工作所用到的，但一定是相关的。

　　而且在研究一门新技术时，切忌朝三暮四。有的同学今天去整整大数据，搞搞Hadoop、hbase一类的东西。过不了一段时间，就觉得没意思，又去研究分布式缓存，比如redis。然后又过不了一段时间，又去研究分布式计算，比如整整Mapreduce或者storm。

　　结果到最后，搞得自己好像什么都会一样，在简历上大言不惭的写上大数据、分布式缓存、分布式计算都了解，其实任何一个都只是浮于表面。到时候面试官随便一问，就把你给识破了。

　　一定要记住，作为一个程序猿，平日里所接触的技术可能会很多，但是想要让一门技术成为你的优势，那么一定是你对这门技术的了解强过绝大多数人才行。

　　因此在这个阶段，你就不能再简单的去学习前3年的内容了，虽然前面的学习如果还不够深入的话依旧要继续，但这个时候你应该更多的考虑建立你的优势，也可以称为差异性。

　　差异性相信不难理解，就是让你自己变得与众不同。你前面三年的学习足够你成为一名基本合格的Java开发者，但你离成为一名优秀的Java开发者还有很大的距离。

　　所谓优秀，即能别人所不能。而你前三年所学习的内容，是很多做过几年的Java开发都能够掌握的。那么为了让自己有差异性，你就需要另辟蹊径，找一个方向深入研究下去，以期在将来，你能够成为这个领域的专家，比如分布式计算领域的专家，大数据领域的专家，并发领域的专家等等。

　　此外，你除了建立你的差异性之外，还要去弥补你基础上的不足，直到现在，LZ都没有提及基础知识。原因是基础是很枯燥无味的，学的太早不仅容易懵逼，而且懵逼的同时还容易产生心理阴影，以至于以后再不想去研究这些基础。但基础又是你深入研究一些领域时所必须掌握的，比如你去研究分布式计算，你不懂算法你玩个毛毛？比如你去做分布式缓存，你对计算机系统的内存不了解，你如何去做缓存？

　　如果你的基础本来就非常强，那么恭喜你，相信你在之前的工作中已经充分体会到了这些基础对你的帮助。但LZ相信大部分人的基础都很薄弱，哪怕是科班毕业的人，很多人也不敢说自己当初的基础学的多么强大，比如算法、计算机系统原理、编译原理这些。

　　但是每个人时间都是有限的，而且这些基础的书籍每一本读下来，没个一年半载的，还真拿不下来，因此还是要有所抉择的。虽然艺多不压身，但问题是艺多是有代价的，是需要你付出时间和精力的，而LZ个人更赞成在同等代价的情况下获取最大的收获。

　　首先，LZ比较推崇的基础书籍有三本，分别是《深入理解计算机系统》，《tcp/ip详解 卷一、二、三》，《数据结构与算法》。其中TCP/IP有三本书，但我们这里把这三本看成是一本大书。

　　这三本分别适合三种人，《深入理解计算机系统》比较适合一直从事Java Web开发和APP后端开发工作的人群。《tcp/ip详解 卷一、二、三》比较适合做网络编程的人群，比如你使用netty去开发的话，那么就要对TCP/IP有更深入的了解。而《数据结构与算法》这本书，则比较适合做计算研究工作的人，比如刚才提到的分布式计算。

　　另外，LZ要强调的是，这里所说的适合，并不是其它两本对你就没有用。比如你做Java Web和APP后端开发，《tcp/ip详解 卷一、二、三》这本书对你的作用也是很大的。这里只是分出个主次关系而已，你要是时间足够的话，能把三本都精读那当然最好不过了。但如果时间有限的话，那么就先挑对你帮助最大的书去读。

　　理论上来讲，这一年你能把这三本其中一本精读下来，就已经非常厉害了。有了基础，有了前面的工作经验，你就可以去开拓属于你的领域了。

　　在这一年里，一定要规划好自己的领域，建立好自己的优势，制造出差异性。如果你对自己的领域不够清晰的话，随着你工作的时间日益增多，你接触的技术会越来越多，这个时候，你很容易被淹死在技术的海洋里，看似接触的技术越来越多，会用的也越来越多，但你毫无优势。

　　有的同学可能会问，“LZ，我也不知道我的领域是什么啊？怎么办呢？”

　　对于这种人，LZ只想说，“卧槽，这还问我？要不干脆我替你学习得了，好不好？”

　　

　　**第六部分：参加工作4年到5年的同学**

　　经过前面一年的历练，相信你在自己所钻研的领域已经有了自己一定的见解，这个时候，技术上你应该已经遇到瓶颈了。

　　这个时候不要着急提高自己的技术，已经是时候提高你的影响力了，你可以尝试去一些知名的公司去提高你的背景，你可以发表一些文章去影响更多的人。当然，你也可以去Github创建一个属于你的开源项目，去打造自己的产品。这次的开源项目不同于之前的造轮子，你这个时候是真的要去尽量尝试造出来真正对别人有价值的轮子。

　　技术学到这个阶段，很容易遇到瓶颈，而且往往达到一定程度后，你再深入下去的收效就真的微乎其微了，除非你是专门搞学术研究的。然而很可惜，大部分程序猿做不到这一步，那是科学家做的事情。

　　这个时候提高影响力不仅仅是因为技术上容易遇到瓶颈，更多的是影响力可以给你创造更多的机会。程序猿在某种程度上和明星很像，一个好的电视剧和电影就可以成就一批明星，程序猿有的时候也是，一个好的项目就可以成就一群程序猿。

　　比如国内几个脍炙人口的项目，像淘宝、支付宝、QQ、百度、微信等等。这每一个项目，都成就了一批程序猿。LZ敢说，这里面任何一个项目，如果你是它的核心开发，光是这样一个Title，就已经是你非常大的优势。更何况还不止如此，Title说到底也是个名头，更重要的是，这种项目在做的时候，对你的历练一定也是非常给力的。

　　而你如果想要参与这样的项目，除了靠运气之外，影响力也是很重要的一个手段。比如你在分布式计算领域有一定的影响力，那么如果有什么好的关于分布式计算的项目，对方就很可能会邀请你。就算人家不邀请你，你自己主动去面试的时候，对方如果知道你在这个领域的影响力，也肯定会起到很大的作用，而这个作用，甚至可能会超过你现在的技术能力。

　　所以，在这个阶段，你最大的任务是提高自己的影响力，为自己未来的十年工作生涯那一天做准备。如果你能够靠你的影响力和以前积累的技术，参与到一个伟大的项目当中，那么你后面的五年也就有着落了。

　　当然了，LZ现在满打满算，做程序猿也就4年半不到，因此关于4年到5年这一部分，LZ的见解不一定是对的，就算是对的，也不一定是适合任何人的。所以，希望大家自己有的判断力，去决定到底该如何度过这一年。

　　

### 结语

　　

　　本文到此就基本结束了，整篇文章很长，但其实主要就说了两部分内容，一个是社招面试的准备，一个是Java生涯的学习。

　　关于这两部分，LZ已经给出了自己的见解，但是还是那句话，每个人吸收知识的时候，都要有抽取精华，去除糟粕的能力。LZ所说的，可能有些是对的，有些是错的，有些是适合你的，有些是不太适合你的，你要自己能够判断。

　　其实你在生活和工作当中也是一样的，你身边的人形形色色，有的人你喜欢，有的人你很讨厌。但其实你喜欢的人也有缺点，你讨厌的人也有优点。你要学会从你讨厌的人身上学会他的优点，千万不要一棒子打死，这只会让你失去很多学习成长的机会。

　　好了，说了这么多了，就到此为止吧，希望本文可以帮助到作为程序猿或即将成为程序猿的你。



版权声明



------

作者：zuoxiaolong（左潇龙）

出处：[博客园左潇龙的技术博客--http://www.cnblogs.com/zuoxiaolong](http://www.cnblogs.com/zuoxiaolong)

您的支持是对博主最大的鼓励，感谢您的认真阅读。

本文版权归作者所有，欢迎转载，但未经作者同意必须保留此段声明，且在文章页面明显位置给出原文连接，否则保留追究法律责任的权利。



# [程序员面经：面试前到底该不该刷题以及面试前该如何准备](https://www.cnblogs.com/zuoxiaolong/p/life48.html)

### 引言

　　

　　首先要说声抱歉，LZ前段时间刚入职，这几天一直在参加新人培训，每天到家都是晚上10点多，因此有关Java教程的文章和视频，只写了篇开头，没有按照计划进行后续Java教程相关的文章撰写和视频录制。不过4月2日晚8点，LZ会在斗鱼直播spring IOC源码解析，感兴趣的朋友可以来参加。

　　跳回正题，写这篇文章的原因依然是来自于群里的一次讨论，在LZ的交流群里，有一个妹子最近正在准备面试，她在群里问了很多技术问题。很明显，这些问题都是一些面试题上面的题目，通俗的说，她是在面试前刷题。

　　在LZ看来，面试前刷题这件事真的是很愚蠢的一件事，因此LZ就想写一篇文章来提醒一下大家，面试前千万不要去刷题，百害而无一利。当然，应届生不在本文的讨论范围内，因为应届生在面试之前，大部分都有笔试，刷题还是很有必要的。

　　因此，本文中如无特殊说明的话，指的都是非应届生的程序员，换句话说，本文所讨论的内容主要针对有至少一年以上工作经验的人。

　　

### 面试前到底该不该刷题

　　

　　在讨论该不该刷题这个问题之前，首先咱们来看看，到底为什么会有那么多人在面试前会去刷题。

　　这个问题的答案其实很简单，大部分情况下，都是因为面试者在面试前心里没底，因此有不少人会选择去刷刷题，来提高自己的自信。而且，基本上所有刷题的人，内心多多少少都有侥幸心理，以期在面试的时候，可以刚好被问到刷过的题，然后获得入职的资格。

　　不可否认的是，确实有那么一些人，是真的依靠刷题而获得了入职的机会。世界这么大，总会有幸运的人的。但是，LZ想说的是，面试并不是你大学时的考试，考前临时抱佛脚一下，说不定就混过去了。

　　面试和你大学时的考试，有一个最本质的区别，那就是大学时的考试，你混及格了，也就过去了。但是面试不一样，面试混过去了，你还是要去上班的，这件事情还远远没有结束。虽说只要面试混过去了，试用期被Fire的可能性很小，但是，如果你入职以后没有达到面试时你的水平的话，你的Leader通常情况下会觉得招你进来是一件很失败的事情。**面试时最好只表现你80%的能力，剩下的20%是留着到了公司以后给大家惊喜用的。**

　　现在网上有非常多的面试题目，从应届生到N年工作经验的面试题都有，而且只要稍微知名点的公司，在网上基本上也都能找到一大堆的面试题。很多人刷题，就是把这些文章上面的题目一道一道都过一遍，期待在面试中被问到。

　　但是LZ刚才说了，面试前刷题是一件很愚蠢的事情，最好给自己留有余地。面试和高考不同，高考时你发挥120%的潜力多考了几十分是很好的，但是面试时你要是发挥了120%的潜力，很可能只能高兴一时，等进了公司以后，你就可能会处在一个尴尬的境地，因为你很可能会成为那个被招错的人。　　

　　LZ相信，大家很多人身边都出现过这种人，招进来以后才发现，这个人真的很烂。这种人就算能过了试用期，最终的下场，一般都是会被公司慢慢抛弃的。可能并不是这些人不够优秀，而是他通过一些手段，得到了一个高于他原本能力的职位或薪水，因此才显得会很烂。

　　更可怕的是，当你只是记住和理解了这些题的答案之后，当面试官顺着这道题稍微深入的探究你的时候，你很可能会答不上来。这样就会让面试官觉得，你对于很多问题的研究不够深入，反而会烙下不好的印象。至少对于程序员来说，大部分公司的面试官，尤其是大公司的面试官，宁可选择一个在某个小问题上，比自己研究得还深入的人，也不会选择只会答一些面试题，但随便一深入问下去就回答不上来的人。

　　因此，还是那句话，不建议大家在面试前刷题。请记住，面试不是考试。

　　

### 面试前如何准备

　　

　　既然LZ不建议大家在面试前刷题，那么肯定会有小伙伴儿要问，难道面试前就应该什么都不做吗？

　　当然不是！

　　以LZ个人的经验来看，在面试前，通常只需要做一件事，而且LZ也一直都是这么做的。**那就是在一个适合思考的时刻，去思考和总结自己所经历的过去以及所掌握的技术，要总结到精髓，并且挖掘出自己至少一个亮点。**

　　这个所谓适合思考的时刻，可以是你回家坐公车的时候，也可以是走去吃饭的路上，也可以是大便的时候，也可以是洗澡的时候等等。

　　一个人经历过一年，甚至更久的工作之后，总会经历大大小小的事情。每一次面试之前的总结，不光是为了面试，更是为了让你在跳槽之前认清自己，并且清楚自己所需要的提升到底在哪，这才是跳槽真正的意义所在。

　　很多人跳槽都是盲目的，并且每次跳槽之后都感觉不是很满意。其实有一个很重要的原因，就是你没有在面试之前认真的总结自己，你不了解自己现在到底优势在哪，劣势在哪，你需要弥补哪方面的空缺。以至于在跳槽时，除了薪资待遇以外，很少考虑到自己的职业发展问题。就算考虑了，但是由于没有好好总结自己的经历和技术，也很可能会选择了一个自认为正确但实际上却是错误的方向。

　　然而，趁着面试，这绝对是你总结自己的最好时机。

　　在面试当中，要适当的把面试官带进你熟悉的世界，然后在你不熟悉的世界果断的告诉面试官“不好意思，我不会”。而你要做的，就是把你熟悉的世界好好总结，让面试官更加清晰的感受这个世界。这样不仅可以帮助你在面试过程当中顺利的通过，展现自己的亮点，而且还可以帮助你更加清晰自己的职业发展。

　　而且，事实上在你总结自己的时候，你通常会碰到一些长时间被遗忘掉了的问题，这些问题，是可以临时抱佛脚去复习一下的。而那些与你的经历和技术体系关系不大的面试题，临时去刷其实毫无意义，还不如一句“不好意思，我不会”更加实在。

　　可能有的小伙伴儿会说，“总结我的经历和技术倒是可以，但是我做的项目和我会的技术都很平庸，实在找不到亮点怎么办？”

　　那LZ只想告诉你，这样就更好办了。既然你都知道了你没有亮点，也就是知道了你自己欠缺什么，那么下次跳槽就努力给自己制造亮点，弥补自己的欠缺就行了。

　　例如，你可以找一个大数据的工作，这样你以后就多了一个大数据的技术标签，这算是你的亮点。或者你也可以找一个有高并发的项目去做，这样你以后就有了高并发项目的经历，这也算是你的亮点。

　　总而言之，在每次跳槽和面试的时候，不断总结自己，深度挖掘自己的亮点，比你去刷那些无聊的面试题，要有价值的多。这样不仅可以帮助你的现在，还可以帮助你的未来。

　　

### 结语

　　

　　最后，LZ再提醒大家一句，亮点是靠自己挖掘的，不要觉得自己做着平庸的项目，就认为自己的项目没有任何亮点可以挖掘。

　　永远记住，没有平庸的项目，只有平庸的人。



版权声明



------

作者：zuoxiaolong（左潇龙）

出处：[博客园左潇龙的技术博客--http://www.cnblogs.com/zuoxiaolong](http://www.cnblogs.com/zuoxiaolong)

您的支持是对博主最大的鼓励，感谢您的认真阅读。

本文版权归作者所有，欢迎转载，但未经作者同意必须保留此段声明，且在文章页面明显位置给出原文连接，否则保留追究法律责任的权利。

就像我在之前的博文中所讲的
"面试的成功与否，在于平时的积累，临时抱抱佛脚，看两道面试题是没有用的，只要平时足够努力，成功是水到渠成的事情，平时不怎么研究技术的，那也就是个听天由命的事情，只要充分地展示平时自己的所学就可以了"

面试不是考试，考试一个大题错一小点就规定给你扣几分，面试讲求的是面试官对你的一个整体印象，对每个面试官问你的问题能把握好大方向即可，小细节答得好自然好，答不好也没多大关系。

不是太赞同，如果不刷题的话，很多很小的问题你有可能就顾及不到，会显的很菜，至于入职后会不会变成那个被放弃的人，就看自己的努力了！你能迎头赶上肯定还会一个受欢迎的人



其实你大可不必担心，会纠结那些小问题的面试官，这种公司真心没必要去。况且，总结自己熟悉的领域，说好这部分会掩盖掉那些小问题的。这真的不是事儿。



不认同这个观点,刷题可以查漏补缺,不仅面试前要刷题,平时没事的时候也看看,还可以去招聘网站看看最近职位要求,所谓面试驱动研究。大部分人都是做业务开发的，基本属于搜索引擎开发型。对于很多细节不太关注。举个栗子，了解Hashmap 和TreeMap的细节真的很重要么，但是那些面试官真的会这么问。



坐着平庸的项目， 抱怨中 也在努力； 正在补自己的缺 调好方向 争取下次找个和规划比较符合的位置

楼主你这篇文章建议删了，我感觉有点误导人。我就是干活厉害，刷题刷不过人家。我身边有干活没我厉害的能进大厂，我却进不了。面试不刷题去小厂或许可以，只要把项目中遇到的技术点说通就可以了。你去大厂的话，考你技术深度，你不刷题，你会时时刻刻记住TCP三次握手每次握手的状态？你会记住每一个源码的具体细节？当然，如果你时时刻刻在为面试而准备的话，那确实不用刷题。还有这一句我也持有保留意见：“面试时最好只表现你80%的能力，剩下的20%是留着到了公司以后给大家惊喜用的“。抱歉，表现80%的能力你或许一面都过不了。面试就要拼尽全力，进去以后也不用当心活干不好，都知道大厂是面试造火箭，进去拧螺丝。刷题也是对自己所掌握知识点的查漏补缺以及记忆唤醒。