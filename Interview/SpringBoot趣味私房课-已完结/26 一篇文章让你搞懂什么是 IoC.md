**26 一篇文章让你搞懂什么是 IoC**

26 一篇文章让你搞懂什么是 IoC

更新时间：2020-05-28 13:50:13

![img](http://img3.sycdn.imooc.com/5ebe624e0001f6df06400426.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

读书而不思考，等于吃饭而不消化。

——波尔克



# 1. 什么是 IoC

了解 Spring 的人肯定都听说过 IoC，那么究竟什么是 IoC 呢？我们先来看一下 IoC 的概念。

> IoC（全称 Inversion of Control，中文意思为控制反转），是面向对象编程中的一种设计原则，可以降低代码的耦合性。例如在对象 A 被创建时，通过控制反转，由对象 A 所属的外界实体将 A 所依赖的其他对象的引用传递给 A。

这并不是什么官方的定义，是我根据维基百科中的描述，尽可能的将其概括的容易理解的样子。控制反转是一种编程思想，最常见的实现方式叫做依赖注入（Dependency Injection，简称 DI ），还有一种方式叫 “依赖查找”（Dependency Lookup，简称 DL）。



# 2. 缘起

2001 年，那是一个春天，有一位老人，啊呸！有一位小伙（没错，那时候还是小伙，头发还很茂盛）使控制反转实现方式之一的依赖注入（DI）一词得到普及。而后，又在 2004 年他又对 “究竟是对哪些方面的控制进行了反转” 的问题进行了进一步的总结。最后得出结论 —— 依赖对象的获得被反转了。

这位小伙就是马丁・福勒（Martin Fowler），那么他是何许人也呢？不用过多的言语来介绍他，你只需要知道他曾经写过一本书叫《Refactoring》就行了，这本书翻译过来叫《重构》，OK，可以开始膜拜了。



# 3. 改变

我们都知道，Class A 代表 A 是一个类，而 `A a = new A()` 代表创建一个 A 类型的对象 a。在没有控制反转的时候，在类 A 中使用类 B 的对象 b 时，需要在 A 中 new 一个 b 对象。如果我们使用控制反转的话，只需要在类 A 中声明一个私有的 b 对象，即 `private B b`。然后创建（new）b 对象的工作交由容器来完成，容器根据注解或者配置文件将 b 注入到 A 的实例中即可。这样带来的好处是巨大的，大大降低了代码的耦合度，如果通过以上描述你不能很清晰的感觉到这种变化（事实上很难通过单纯的文字描述感受到），那么继续看我们接下来的代码实例。



# 4. 实现方式

在开头介绍什么是 IoC 的时候，我们就提到了，它的实现方式主要有两种，一种是依赖查找，另一种是依赖注入。两者的主要区别在于查找是主动行为，而注入则是被动行为。依赖查找会主动寻找对象所需的依赖，获取依赖对象的时机也是可以自行控制的；依赖注入则是被动的等待容器为其注入依赖对象，容器通过类型或者名称将被依赖对象注入到相应的对象中去。



## 4.1 依赖查找

依赖查找是主动获取，在需要的时候通过调用框架提供的方法来获取对象，获取时需要提供相关的配置文件路径、key 等信息来确定获取对象的状态。当年显赫一时的 EJB 就是使用依赖查找实现的控制反转。建立在 JavaEE 的 JNDI 规范之上，但随着 EJB 的衰落，依赖查找的实现方式也慢慢无人问津，如果感兴趣可以看看多年前写的一篇文章《[菜鸟学 EJB—— 第一个实例](https://liushuijinger.blog.csdn.net/article/details/23306991)》。



## 4.2 依赖注入

依赖注入是控制反转最常见的实现方式，这在很大程度上得益于 Spring 在 Java 领域的垄断地位。在 Spring 中使用依赖注入可以通过如下四种方式：

1. 基于接口
2. 基于 Set 方法
3. 基于构造函数
4. 基于注解

由于注解的方便好用，目前几乎所有系统都会使用注解的方式来完成依赖注入。其实使用注解的依赖注入方式我们已经很熟悉了，在之前的小节中我们已经用过 N 多次了。使用 @Controller、@Service、@Component 等注解将类标记为可依赖，然后使用 @Autowire 注解来注入依赖对象。



# 5. 上代码

Talk is cheap，show me the code. 上面说了那么多，要想真真切切的感受一下控制反转思想相对于传统方式有哪些不同，还得通过实实在在的代码才行。走起！

故事的主人公叫小明，他有一个技能叫做 —— 出去浪。下面我们用代码来实现一下。



## 5.1 传统方式

创建一个 Person 类，它有一个方法 hangOut ()，再创建一个 Bike 类作为交通工具。

```java
public class Person {
    public void hangOut() {
        Bike bike = new Bike();
        bike.drive();
    }
}

@Slf4j
public class Bike {
    public void drive() {
        log.info("骑着自行车出去浪~");
    }
}

@Test
public void test() {
    Person xiaoming = new Person();
    xiaoming.hangOut();
}
```

小明刚刚大学毕业，一穷二白，虽然很喜欢出去玩，但是只能骑个共享单车，不过倒也悠哉。

经过不断的学习和努力，几年后小明收入越来越高，终于有了一辆属于自己的车，于是以后出去浪就可以开车了。

```java
public class Person {
    public void hangOut() {
//        Bike bike = new Bike();
//        bike.drive();
        Car car = new Car();
        car.drive();
    }
}
```

小明终于可以开车来一场说走就走的自驾游啦，快哉！

再后来，小明不满足可以自驾游的短途旅行，喜欢上了诗和远方，于是小明出游的交通工具变成了火车。

```java
public class Person {
    public void hangOut() {
//        Bike bike = new Bike();
//        bike.drive();
//        Car car = new Car();
//        car.drive();
        Train train = new Train();
        train.drive();
    }
}
```

买张火车票就可以游历祖国的大好河山，美哉！

没过多久，小明游遍了国内的美景，开始向往异国风情，于是开启了飞行之旅。

```java
public class Person {
    public void hangOut() {
//        Bike bike = new Bike();
//        bike.drive();
//        Car car = new Car();
//        car.drive();
//        Train train = new Train();
//        train.drive();
        AirPlane airPlane = new AirPlane();
        airPlane.drive();
    }
}
```

感受异域文化，体味不同的风土人情，妙哉！

你知道的，没过多久，小明又厌倦了陆地，于是他的心又飘向了海洋。

```java
public class Person {
    public void hangOut() {
//        Bike bike = new Bike();
//        bike.drive();
//        Car car = new Car();
//        car.drive();
//        Train train = new Train();
//        train.drive();
//        AirPlane airPlane = new AirPlane();
//        airPlane.drive();
		Ship ship = new Ship();
        ship.drive();
	}
}
```

乘风破浪，感受无边的海洋，壮哉！

虽然出去玩可以悠哉、快哉、美哉、妙哉甚至壮哉。但是我们发现，每换一个交通工具，就需要对 Person 类进行修改，实在是麻烦，而且非常不友好，接下来我们看看使用控制反转会发生什么。



## 5.2 控制反转

改造 Person 类：

```java
@AllArgsConstructor
public class Person {

    private Driveable driveable;

    public void hangOut() {
        driveable.drive();
    }
}
```

我们将交通工具从 hangOut 方法中提取出来变成 Person 的私有成员变量，并且将其抽象为一个 Driveable 接口。然后让所有的交通工具都实现这个接口。

然后当小明出去浪的时候，再指定乘坐哪种交通工具：

```java
// Bean 容器
private Map<String, Object> container = new HashMap<>();

/**
 * 模拟 Spring 容器初始化
 */
@Before
public void init() {
    Driveable bike = new Bike();
    container.put("bike", bike);

    Driveable car = new Car();
    container.put("car", car);

    Driveable train = new Train();
    container.put("train", train);

    Driveable airPlane = new AirPlane();
    container.put("airPlane", airPlane);

    Driveable ship = new Ship();
    container.put("ship", ship);
}

/**
 * 获取 Bean
 * @param name
 * @return
 */
public Object getBean(String name) {
    return container.get(name);
}

@Test
public void test() {
    Driveable bike = (Driveable) container.get("bike");
    Person xiaoming = new Person(bike);
    xiaoming.hangOut();

    Driveable car = (Driveable) container.get("car");
    xiaoming = new Person(car);
    xiaoming.hangOut();

    Driveable train = (Driveable) container.get("train");
    xiaoming = new Person(train);
    xiaoming.hangOut();

    Driveable airPlane = (Driveable) container.get("airPlane");
    xiaoming = new Person(airPlane);
    xiaoming.hangOut();

    Driveable ship = (Driveable) container.get("ship");
    xiaoming = new Person(ship);
    xiaoming.hangOut();
}
```

由上面代码可以看出，小明可以在不同交通工具之间随意切换，而无需再修改 Person 类，只需要在出去浪之前指定相应的交通工具即可。小明只需要关心 “要不要出去浪” 这一点即可，不需要操心到底是怎么去。这一点，采用传统方式根本无法做到。



# 6. 总结

OK，我们今天学习了控制反转的概念以及它的好处，还分别了解了它的两种实现方式 —— 依赖查找和依赖注入。后面又通过一个实例进行了更加形象的展示。通过理论与实践相结合的方式，我们对于控制反转已经有了非常深刻的理解了。恭喜你已经掌握了 Spring 的一大核心特性！接下来我们会学习 Spring 另外一个非常有用的特性 ——AOP。

小节的最后分享一篇多年前写的模拟 Spring IoC 的简单实现《[Spring 容器 IOC 解析及简单实现](https://liushuijinger.blog.csdn.net/article/details/35978965)》，希望对你有帮助。

[25 彻底搞定秒杀系统](http://www.imooc.com/read/75/article/1821)[27 程序世界的无人超市——AOP](http://www.imooc.com/read/75/article/1823)

精选留言 3

欢迎在这里发表留言，作者筛选后可公开显示

- [慕粉2193681](http://www.imooc.com/u/6432185/articles)

  Driveable抽象类怎么没有贴出来啊，还有我也觉得只是向上转型了。只不过Person类上多了个注释，也不知道去掉行不行。还有每个new Person里为啥有参数。这点也没看懂，是要固定这么写吗。

   0

  回复

  2020-05-28

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕粉2193681](http://www.imooc.com/u/6432185/articles)

    Driveable 类的源码：https://github.com/liushuijinger/springboot/tree/master/26-ioc/src/main/java/com/imooc/springboot/ioc；Person 类上的注解用于声明一个带参数的构造方法，可以不用注解自己手动声明；new Person 的时候传入一个参数是在模拟 Spring IoC 的构造方法注入。不知道这样能不能解答你的疑惑？欢迎留言交流哦~

    回复

    2020-05-29 21:48:24

- [qq_庞庞_0](http://www.imooc.com/u/6173405/articles)

  感觉这不是控制反转，只是实现了接口，通过类型的向上转换来实现，控制反转的话对象的创建是不是都应该交给控制方呢，如果我在drive方法把父类穿进去和这个效果一模一样，而且你改变交通工具你还是改变了外面的代码，每次都改，和原来的区别只是改的地方不一样了。新手，也不太懂，希望能给解释一下。

   1

  回复

  2020-05-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_庞庞_0](http://www.imooc.com/u/6173405/articles)

    的确，这篇文章中的代码更多的是为了说明控制反转带来的好处。多年前写的这篇文章中的代码更能体现容器的作用：https://liushuijinger.blog.csdn.net/article/details/35978965 希望对你有帮助。

    回复

    2020-05-26 22:22:00

- [慕娘9599159](http://www.imooc.com/u/6282595/articles)

  这个Ioc的介绍，单独从这一节，理解的不是很透彻，好像就没有介绍IOC具体的概述和意思

   0

  回复

  2020-05-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕娘9599159](http://www.imooc.com/u/6282595/articles)

    IOC 的概念其实非常简单，就是将「创建对象」这件事由调用方转移到了容器。

    回复

    2020-05-26 22:20:02

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕娘9599159](http://www.imooc.com/u/6282595/articles)

    更新了一下最后的那段代码，明天让慕课网的编辑更新一下，到时候看看能不能帮助你理解。

    回复

    2020-05-26 22:51:30

 

千学不如一看，千看不如一练