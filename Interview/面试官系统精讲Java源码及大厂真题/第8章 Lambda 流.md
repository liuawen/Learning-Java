**第8章 Lambda 流**第8章 Lambda 流

- 41 突破难点：如何看 Lambda 源码
- 42 常用的 Lambda 表达式使用场景解析和应用

第8章 Lambda 流

# 41 突破难点：如何看 Lambda 源码

41 突破难点：如何看 Lambda 源码

更新时间：2019-11-25 10:00:14

![img](https://img2.mukewang.com/5ddb3518000154d406400359.jpg)

![img](https://www.imooc.com/static/img/column/bg-l.png)![img](https://www.imooc.com/static/img/column/bg-r.png)

耐心和恒心总会得到报酬的。

——爱因斯坦



## 引导语

大家都知道 Java8 中新增了 Lambda 表达式，使用 Lambda 表达式可以对代码进行大量的优化，用几行代码就可以做很多事情，本章以 Lambda 为例，第一小节说明一下其底层的执行原理，第二小节说明一下 Lambda 流在工作中常用的姿势。



## 1 Demo

首先我们来看一个 Lambda 表达式的 Demo，如下图：
![图片描述](https://img.mukewang.com/5dd5fe830001211007440492.png)

代码比较简单，就是新起一个线程打印一句话，但对于图中 () -> System.out.println ( “ lambda is run “ ) 这种代码，估计很多同学都感觉到很困惑，Java 是怎么识别这种代码的？

如果我们修改成匿名内部类的写法，就很清楚，大家都能看懂，如下图：
![图片描述](https://img.mukewang.com/5dd5fe980001358906980558.png)

那是不是说 () -> System.out.println ( “ lambda is run “ ) 这种形式的代码，其实就是建立了内部类呢？其实这就是最简单 Lambda 表达式，我们是无法通过 IDEA 看到源码和其底层结构的，下面我们就来介绍几种可看到其底层实现的方式。



## 2 异常判断法

我们可以在代码执行中主动抛出异常，打印出堆栈，堆栈会说明其运行轨迹，一般这种方法简单高效，基本上可以看到很多情况下的隐藏代码，我们来试一下，如下图：
![图片描述](https://img.mukewang.com/5dd5fea9000187c107670699.png)

从异常的堆栈中，我们可以看到 JVM 自动给当前类建立了内部类（错误堆栈中出现多次的 $ 表示有内部类），内部类的代码在执行过程中，抛出了异常，但这里显示的代码是 Unknown Source，所以我们也无法 debug 进去，一般情况下，异常都能暴露出代码执行的路径，我们可以打好断点后再次运行，但对于 Lambda 表达式而言，通过异常判断法我们只清楚有内部类，但无法看到内部类中的源码。



## 3 javap 命令法

javap 是 Java 自带的可以查看 class 字节码文件的工具，安装过 Java 基础环境的电脑都可以直接执行 javap 命令，如下图：
![图片描述](https://img.mukewang.com/5dd5fec0000181d909200570.png)

命令选项中，我们主要是用-v -verbose 这个命令，可以完整输出字节码文件的内容。

接下来我们使用 javap 命令查看下 Lambda.class 文件，在讲解的过程中，我们会带上一些关于 class 文件的知识。

我们在命令窗口中找到 Lambda.class 所在的位置，执行命令：javap -verbose Lambda.class，然后你会看到一长串的东西，这些叫做汇编指令，接下来我们来一一讲解下（ 所有的参考资料来自 [Java 虚拟机规范](https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4)，不再一一引用说明）：

汇编指令中我们很容易找到 Constant pool 打头的一长串类型，我们叫做常量池，官方英文叫做 Run-Time Constant Pool，我们简单理解成一个装满常量的 table ，table 中包含编译时明确的数字和文字，类、方法和字段的类型信息等等。table 中的每个元素叫做 cp*info，cp*info 由唯一标识 ( tag ) + 名称组成，目前 tag 的类型一共有：
![图片描述](https://img.mukewang.com/5dd5fedc00012eb605020734.png)

贴出我们解析出来的部分图：
![图片描述](https://img.mukewang.com/5dd5fee90001bf8118760941.png)

1. 图中 Constant pool 字样代表当前信息是常量池；
2. 每行都是一个 `cp_info` ，第一列的 #1 代表是在常量池下标为 1 的位置 ；
3. 每行的第二列，是 `cp_info` 的唯一标识 ( tag ) ，比如 Methodref 对应着上表中的 CONSTANT_Methodref（上上图中表格中 value 对应 10 的 tag），代表当前行是表示方法的描述信息的，比如说方法的名称，入参类型，出参数类型等，具体的含义在 Java 虚拟机规范中都可以查询到，Methodref 的截图如下：
   ![图片描述](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC)
4. 每行的第三列，如果是具体的值的话，直接显示具体的值，如果是复杂的值的话，会显示 `cp_info` 的引用，比如说图中标红 2 处，引用两个 13 和 14 位置的 `cp_info`，13 表示方法名字是 init，14 表示方法无返回值，结合起来表示方法的名称和返回类型，就是一个无参构造器；
5. 每行的第四列，就是具体的值了。

对于比较重要的 cp_info 类型我们说明下其含义：

1. InvokeDynamic 表示动态的调用方法，后面我们会详细说明；
2. Fieldref 表示字段的描述信息，如字段的名称、类型；
3. NameAndType 是对字段和方法类型的描述；
4. MethodHandle 方法句柄，动态调用方法的统称，在编译时我们不知道具体是那个方法，但运行时肯定会知道调用的是那个方法；
5. MethodType 动态方法类型，只有在动态运行时才会知道其方法类型是什么。

我们从上上图中标红的 3 处，发现 Ljava/lang/invoke/MethodHandles$Lookup，java/lang/invoke/LambdaMetafactory.metafactory 类似这样的代码，MethodHandles 和 LambdaMetafactory 都是 java.lang.invoke 包下面的重要方法，invoke 包主要实现了动态语言的功能，我们知道 java 语言属于静态编译语言，在编译的时候，类、方法、字段等等的类型都已经确定了，而 invoke 实现的是一种动态语言，也就是说编译的时候并不知道类、方法、字段是什么类型，只有到运行的时候才知道。

比如这行代码：Runnable runnable = () -> System.out.println(“lambda is run”); 在编译器编译的时候 () 这个括号编译器并不知道是干什么的，只有在运行的时候，才会知道原来这代表着的是 Runnable.run() 方法。invoke 包里面很多类，都是为了代表这些 () 的，我们称作为方法句柄（ MethodHandler ），在编译的时候，编译器只知道这里是个方法句柄，并不知道实际上执行什么方法，只有在执行的时候才知道，那么问题来了，JVM 执行的时候，是如何知道 () 这个方法句柄，实际上是执行 Runnable.run() 方法的呢？

首先我们看下 simple 方法的汇编指令：
![图片描述](https://img.mukewang.com/5dd5ff170001644407650528.png)

从上图中就可以看出 simple 方法中的 () -> System.out.println(“lambda is run”) 代码中的 ()，实际上就是 Runnable.run 方法。

我们追溯到 # 2 常量池，也就是上上图中标红 1 处，InvokeDynamic 表示这里是个动态调用，调用的是两个常量池的 cp_info，位置是 #0:#37 ，我们往下找 #37 代表着是 // run:()Ljava/lang/Runnable，这里表明了在 JVM 真正执行的时候，需要动态调用 Runnable.run() 方法，从汇编指令上我们可以看出 () 实际上就是 Runnable.run()，下面我们 debug 来证明一下。

我们在上上图中 3 处发现了 LambdaMetafactory.metafactory 的字样，通过查询官方文档，得知该方法正是执行时， 链接到真正代码的关键，于是我们在 metafactory 方法中打个断点 debug 一下，如下图：
![图片描述](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC)

metafactory 方法入参 caller 代表实际发生动态调用的位置，invokedName 表示调用方法名称，invokedType 表示调用的多个入参和出参，samMethodType 表示具体的实现者的参数，implMethod 表示实际上的实现者，instantiatedMethodType 等同于 implMethod。

以上内容总结一下：

1：从汇编指令的 simple 方法中，我们可以看到会执行 Runnable.run 方法；

2：在实际的运行时，JVM 碰到 simple 方法的 invokedynamic 指令，会动态调用 LambdaMetafactory.metafactory 方法，执行具体的 Runnable.run 方法。

所以可以把 Lambda 表达值的具体执行归功于 invokedynamic JVM 指令，正是因为这个指令，才可以做到虽然编译时不知道要干啥，但动态运行时却能找到具体要执行的代码。

接着我们看一下在汇编指令输出的最后，我们发现了异常判断法中发现的内部类，如下图：
![图片描述](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC)

上图中箭头很多，一层一层的表达清楚了当前内部类的所有信息。



## 4 总结

我们总结一下，Lambda 表达式执行主要是依靠 invokedynamic 的 JVM 指令来实现，咱们演示的类的全路径为：demo.eight.Lambda 感兴趣的同学可以自己尝试一下。

[40 打动面试官：线程池流程编排中的运用实战](https://www.imooc.com/read/47/article/882)[42 常用的 Lambda 表达式使用场景解析和应用](https://www.imooc.com/read/47/article/884)

精选留言 1

欢迎在这里发表留言，作者筛选后可公开显示

- [胖子胖](https://www.imooc.com/u/7734905/articles)

  开篇的例子描述不对吧，直接新建一个Runnable对象，调用run方法不会新启一个线程的

   1

  回复

  2019-12-16

  - [慕才子](https://www.imooc.com/u/6946410/articles)

    回复[胖子胖](https://www.imooc.com/u/7734905/articles)

    有道理， 得用Thread

    回复

    2小时前

  - [muggleLee](https://www.imooc.com/u/7623386/articles)

    回复[慕才子](https://www.imooc.com/u/6946410/articles)

    用Runnable对象没问题，而是应该调用start方法吧

    回复

    1小时前

 

千学不如一看，千看不如一练

 

# 42 常用的 Lambda 表达式使用场景解析和应用

42 常用的 Lambda 表达式使用场景解析和应用

更新时间：2019-11-27 10:56:25

![img](https://img1.mukewang.com/5ddde5d5000138f106400359.jpg)

![img](https://www.imooc.com/static/img/column/bg-l.png)![img](https://www.imooc.com/static/img/column/bg-r.png)

耐心和恒心总会得到报酬的。

——爱因斯坦



## 引导语

我们日常工作中，Lambda 使用比较多的场景，就是 List 或 Map 下的 Lambda 流操作，往往几行代码可以帮助我们实现多层 for 循环嵌套的复杂代码，接下来我们把 Lambda 流的常用方法用案列讲解一下。



## 1 数据准备

本文演示的所有代码都在 demo.eight.LambdaExpressionDemo 中，首先我们需要准备一些测试的数据，如下：

```java
@Data
// 学生数据结构
class StudentDTO implements Serializable {

  private static final long serialVersionUID = -7716352032236707189L;

  public StudentDTO() {
  }

  public StudentDTO(Long id, String code, String name, String sex, Double scope,
                    List<Course> learningCources) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.sex = sex;
    this.scope = scope;
    this.learningCources = learningCources;
  }

  /**
   * id
   */
  private Long id;
  /**
   * 学号 唯一标识
   */
  private String code;
  /**
   * 学生名字
   */
  private String name;

  /**
   * 性别
   */
  private String sex;

  /**
   * 分数
   */
  private Double scope;

  /**
   * 要学习的课程
   */
  private List<Course> learningCources;
}

@Data
// 课程数据结构
class Course implements Serializable {

  private static final long serialVersionUID = 2896201730223729591L;

  /**
   * 课程 ID
   */
  private Long id;

  /**
   * 课程 name
   */
  private String name;

  public Course(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
// 初始化数据
private final List<StudentDTO> students = new ArrayList<StudentDTO>(){
  {
    // 添加学生数据
    add(new StudentDTO(1L,"W199","小美","WM",100D,new ArrayList<Course>(){
      {
        // 添加学生学习的课程
        add(new Course(300L,"语文"));
        add(new Course(301L,"数学"));
        add(new Course(302L,"英语"));
      }
    }));
    add(new StudentDTO(2L,"W25","小美","WM",100D,Lists.newArrayList()));
    add(new StudentDTO(3L,"W3","小名","M",90D,new ArrayList<Course>(){
      {
        add(new Course(300L,"语文"));
        add(new Course(304L,"体育"));
      }
    }));
    add(new StudentDTO(4L,"W1","小蓝","M",10D,new ArrayList<Course>(){
      {
        add(new Course(301L,"数学"));
        add(new Course(305L,"美术"));
      }
    }));
  }
};
```

请大家稍微看下数据结构，不然看下面案例跑出来的结果会有些吃力。



## 2 常用方法



### 2.1 Filter

Filter 为过滤的意思，只要满足 Filter 表达式的数据就可以留下来，不满足的数据被过滤掉，源码如下图：
![图片描述](https://img.mukewang.com/5dd6009100012e5d20500742.png)

我们写了一个 demo，如下：

```java
public void testFilter() {
  // list 在下图中进行了初始化
  List<String> newList = list.stream()
      // 过滤掉我们希望留下来的值
      // StringUtils.equals(str,"hello") 表示我们希望字符串是 hello 能留下来
      // 其他的过滤掉
      .filter(str -> StringUtils.equals(str, "hello"))
      // Collectors.toList() 帮助我们构造最后的返回结果
      .collect(Collectors.toList());
  log.info("TestFilter result is {}", JSON.toJSONString(newList));
}
```

运行结果如下：
![图片描述](https://img.mukewang.com/5dd6007d0001804022520840.png)



### 2.2 map

map 方法可以让我们进行一些流的转化，比如原来流中的元素是 A，通过 map 操作，可以使返回的流中的元素是 B，源码如下图：
![图片描述](https://img.mukewang.com/5dd6006b00015baf20920956.png)

我们写了一个 demo，如下：

```java
public void testMap() {
  // 得到所有学生的学号
  // 这里 students.stream() 中的元素是 StudentDTO，通过 map 方法转化成 String 的流
  List<String> codes = students.stream()
      //StudentDTO::getCode 是 s->s.getCode() 的简写
      .map(StudentDTO::getCode)
      .collect(Collectors.toList());
  log.info("TestMap 所有学生的学号为 {}", JSON.toJSONString(codes));
}
// 运行结果为：TestMap 所有学生的学号为 ["W199","W25","W3","W1"]
```



### 2.3 mapToInt

mapToInt 方法的功能和 map 方法一样，只不过 mapToInt 返回的结果已经没有泛型，已经明确是 int 类型的流了，源码如下：
![图片描述](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC)

我们写了一个 demo，如下：

```java
public void testMapToInt() {
  List<Integer> ids = students.stream()
      .mapToInt(s->Integer.valueOf(s.getId()+""))
      // 一定要有 mapToObj，因为 mapToInt 返回的是 IntStream，因为已经确定是 int 类型了
      // 所有没有泛型的，而 Collectors.toList() 强制要求有泛型的流，所以需要使用 mapToObj
      // 方法返回有泛型的流
      .mapToObj(s->s)
      .collect(Collectors.toList());
  log.info("TestMapToInt result is {}", JSON.toJSONString(ids));

  // 计算学生总分
  Double sumScope = students.stream()
      .mapToDouble(s->s.getScope())
      // DoubleStream/IntStream 有许多 sum（求和）、min（求最小值）、max（求最大值）、average（求平均值）等方法
      .sum();
  log.info("TestMapToInt 学生总分为： is {}", sumScope);
}
```

运行结果如下：

TestMapToInt result is [1,2,3,4]
TestMapToInt 学生总分为： is 300.0



### 2.4 flatMap

flatMap 方法也是可以做一些流的转化，和 map 方法不同的是，其明确了 Function 函数的返回值的泛型是流，源码如下：
![图片描述](https://img.mukewang.com/5dd6002d0001f35415580441.png)

写了一个 demo，如下：

```java
public void testFlatMap(){
  // 计算学生所有的学习课程，flatMap 返回 List<课程> 格式
  List<Course> courses = students.stream().flatMap(s->s.getLearningCources().stream())
      .collect(Collectors.toList());
  log.info("TestMapToInt flatMap 计算学生的所有学习课程如下 {}", JSON.toJSONString(courses));

  // 计算学生所有的学习课程，map 返回两层课程嵌套格式
  List<List<Course>> courses2 = students.stream().map(s->s.getLearningCources())
      .collect(Collectors.toList());
  log.info("TestMapToInt map 计算学生的所有学习课程如下 {}", JSON.toJSONString(courses2));

  List<Stream<Course>> courses3 = students.stream().map(s->s.getLearningCources().stream())
      .collect(Collectors.toList());
  log.info("TestMapToInt map 计算学生的所有学习课程如下  {}", JSON.toJSONString(courses3));
}
```

运行结果如下：
![图片描述](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC)



### 2.5 distinct

distinct 方法有去重的功能，我们写了一个 demo，如下：

```java
public void testDistinct(){
  // 得到学生所有的名字，要求是去重过的
  List<String> beforeNames = students.stream().map(StudentDTO::getName).collect(Collectors.toList());
  log.info("TestDistinct 没有去重前的学生名单 {}",JSON.toJSONString(beforeNames));

  List<String> distinctNames = beforeNames.stream().distinct().collect(Collectors.toList());
  log.info("TestDistinct 去重后的学生名单 {}",JSON.toJSONString(distinctNames));

  // 连起来写
  List<String> names = students.stream()
      .map(StudentDTO::getName)
      .distinct()
      .collect(Collectors.toList());
  log.info("TestDistinct 去重后的学生名单 {}",JSON.toJSONString(names));
}
```

运行结果如下：
![图片描述](https://img.mukewang.com/5dd5fff000012e9a14840706.png)



### 2.6 Sorted

Sorted 方法提供了排序的功能，并且允许我们自定义排序，demo 如下：

```java
public void testSorted(){
  // 学生按照学号排序
  List<String> beforeCodes = students.stream().map(StudentDTO::getCode).collect(Collectors.toList());
  log.info("TestSorted 按照学号排序之前 {}",JSON.toJSONString(beforeCodes));

  List<String> sortedCodes = beforeCodes.stream().sorted().collect(Collectors.toList());
  log.info("TestSorted 按照学号排序之后 is {}",JSON.toJSONString(sortedCodes));

  // 直接连起来写
  List<String> codes = students.stream()
      .map(StudentDTO::getCode)
      // 等同于 .sorted(Comparator.naturalOrder()) 自然排序
      .sorted()
      .collect(Collectors.toList());
  log.info("TestSorted 自然排序 is {}",JSON.toJSONString(codes));

  // 自定义排序器
  List<String> codes2 = students.stream()
      .map(StudentDTO::getCode)
      // 反自然排序
      .sorted(Comparator.reverseOrder())
      .collect(Collectors.toList());
  log.info("TestSorted 反自然排序 is {}",JSON.toJSONString(codes2));
}
```

运行结果如下：
![图片描述](https://img.mukewang.com/5dd5ffd300010f9711840242.png)



### 2.7 peek

peek 方法很简单，我们在 peek 方法里面做任意没有返回值的事情，比如打印日志，如下：

```java
students.stream().map(StudentDTO::getCode)
    .peek(s -> log.info("当前循环的学号是{}",s))
    .collect(Collectors.toList());
```



### 2.8 limit

limit 方法会限制输出值个数，入参是限制的个数大小，demo 如下：

```java
public void testLimit(){
  List<String> beforeCodes = students.stream().map(StudentDTO::getCode).collect(Collectors.toList());
  log.info("TestLimit 限制之前学生的学号为 {}",JSON.toJSONString(beforeCodes));

  List<String> limitCodes = beforeCodes.stream()
      .limit(2L)
      .collect(Collectors.toList());
  log.info("TestLimit 限制最大限制 2 个学生的学号 {}",JSON.toJSONString(limitCodes));

  // 直接连起来写
  List<String> codes = students.stream()
      .map(StudentDTO::getCode)
      .limit(2L)
      .collect(Collectors.toList());
  log.info("TestLimit 限制最大限制 2 个学生的学号 {}",JSON.toJSONString(codes));
}
```

输出结果如下：
![图片描述](https://img.mukewang.com/5dd5ffc00001238213120222.png)



### 2.9 reduce

reduce 方法允许我们在循环里面叠加计算值，我们写了 demo 如下：

```java
public void testReduce(){
  // 计算一下学生的总分数
  Double sum = students.stream()
      .map(StudentDTO::getScope)
      // scope1 和 scope2 表示循环中的前后两个数
      .reduce((scope1,scope2) -> scope1+scope2)
      .orElse(0D);
  log.info("总成绩为 {}",sum);

  Double sum1 = students.stream()
      .map(StudentDTO::getScope)
      // 第一个参数表示成绩的基数，会从 100 开始加
      .reduce(100D,(scope1,scope2) -> scope1+scope2);
  log.info("总成绩为 {}",sum1);
}
```

运行结果如下：
![图片描述](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC)

第二个计算出来的总成绩多了 100，是因为第二个例子中 reduce 是从基数 100 开始累加的。



### 2.10 findFirst

findFirst 表示匹配到第一个满足条件的值就返回，demo 如下：

```java
// 找到第一个叫小美同学的 ID
@Test
public void testFindFirst(){
  Long id = students.stream()
      .filter(s->StringUtils.equals(s.getName(),"小美"))
       // 同学中有两个叫小美的，这里匹配到第一个就返回
      .findFirst()
      .get().getId();
  
  log.info("testFindFirst 小美同学的 ID {}",id);

  // 防止空指针
  Long id2 = students.stream()
      .filter(s->StringUtils.equals(s.getName(),"小天"))
      .findFirst()
      // orElse 表示如果 findFirst 返回 null 的话，就返回 orElse 里的内容
      .orElse(new StudentDTO()).getId();
  log.info("testFindFirst 小天同学的 ID {}",id2);

  Optional<StudentDTO> student= students.stream()
      .filter(s->StringUtils.equals(s.getName(),"小天"))
      .findFirst();
  // isPresent 为 true 的话，表示 value != null，即 student.get() != null
  if(student.isPresent()){
    log.info("testFindFirst 小天同学的 ID {}",student.get().getId());
    return;
  }
  log.info("testFindFirst 找不到名为小天的同学");
}
```

运行结果如下：
![图片描述](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC)



### 2.11 groupingBy && toMap

groupingBy 是能够根据字段进行分组，toMap 是把 List 的数据格式转化成 Map 的格式，我们写了一个 demo，如下：

```java
@Test
public void testListToMap(){
  // 学生根据名字进行分类
  Map<String, List<StudentDTO>> map1 = students.stream()
      .collect(Collectors.groupingBy(StudentDTO::getName));
  log.info("testListToMap groupingBy 学生根据名字进行分类 result is Map<String,List<StudentDTO>> {}",
           JSON.toJSONString(map1));

  // 统计姓名重名的学生有哪些
  Map<String, Set<String>> map2 = students.stream()
      .collect(Collectors.groupingBy(StudentDTO::getName,
                                  Collectors.mapping(StudentDTO::getCode,Collectors.toSet())));
  log.info("testListToMap groupingBy 统计姓名重名结果 is {}",
           JSON.toJSONString(map2));

  // 学生转化成学号为 key 的 map
  Map<String, StudentDTO> map3 = students.stream()
       //第一个入参表示 map 中 key 的取值
       //第二个入参表示 map 中 value 的取值
       //第三个入参表示，如果前后的 key 是相同的，是覆盖还是不覆盖，(s1,s2)->s1 表示不覆盖，(s1,s2)->s2 表示覆盖
      .collect(Collectors.toMap(s->s.getCode(),s->s,(s1,s2)->s1));
  log.info("testListToMap groupingBy 学生转化成学号为 key 的 map result is{}",
           JSON.toJSONString(map3));

}
```

运行结果如下：
![图片描述](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC)



## 3 总结

本文我们介绍了 12 种 Lambda 表达式常用的方法，大家可以找到 LambdaExpressionDemo 类，自己 debug 下，这样你在工作中遇到复杂数据结构转化时，肯定会得心应手了。

[41 突破难点：如何看 Lambda 源码](https://www.imooc.com/read/47/article/883)[43 ThreadLocal 源码解析](https://www.imooc.com/read/47/article/885)

精选留言 1

欢迎在这里发表留言，作者筛选后可公开显示

- [weibo_可否争番一囗气_0](https://www.imooc.com/u/1188200/articles)

  不错，讲得比较详细，希望讲讲lambda的方法引用，一直不是很理解哪些方法或者场景可以用方法引用。

   1

  回复

  2019-12-04

  - [文贺](https://www.imooc.com/u/8062574/articles)

    回复[weibo_可否争番一囗气_0](https://www.imooc.com/u/1188200/articles)

    最常用方法引用的地方就是递归，我们写递归代码时，常常担心递归太深，造成栈溢出，或是不小心代码有漏洞，使本来预计只需递归几次的，递归了很多次，导致超出栈的深度，内存溢出，这时候就可以把需要递归的代码使用 Lambda 封装一下，这样不管递归多少层，内存都不会溢出。 不推荐使用方法引用的地方就是远程 rpc 调用，我们常用的 dubbo 框架在处理入参和出参是方法引用时会丢失类型和值。

    回复

    2019-12-08 13:48:37

 

千学不如一看，千看不如一练