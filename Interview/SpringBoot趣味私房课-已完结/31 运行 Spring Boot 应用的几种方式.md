**31 运行 Spring Boot 应用的几种方式**

31 运行 Spring Boot 应用的几种方式

更新时间：2020-06-01 09:44:00

![img](http://img3.sycdn.imooc.com/5ebe62cd0001e0b122501500.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

青年是学习智慧的时期，中年是付诸实践的时期。

—— 卢梭



# 1. 前言

恭喜你！掌握了前面章节讲解的知识，你已经具备了独立开发一个中小型系统的能力。开不开心？先别急，我们还差最后一步，才能让我们开发的应用投入使用 —— 那就是部署。

在 Spring Boot 出现之前，部署通常是将打好的 War 包放到 Tomcat（或其他 Web 容器）的 WebApps 目录下，然后启动 Tomcat。你可能还记得在《万事开头难？Spring Boot 表示不服！》中，我们选择的打包类型是 Jar 而不是 War。那 Jar 格式的工程如何启动呢？接下来我们来揭开谜底，并对比 War 和 Jar 的异同点。



# 2. War 与 Jar

Spring Boot 推荐我们使用 Jar 的方式打包和运行我们的工程（也是默认方式）。通过这段时间对于 Spring Boot 的了解，我们已经发现了一个规律 —— 采用 Spring Boot 推荐的方式（约定优于配置）通常都非常简单（基本上不需要额外的工作）。当然 Spring Boot 也会给我们自定义的自由，需要做一点额外的配置而已。



## 2.1 Jar

采用 Jar 的方式打包应用，我们不需要做任何额外的事情，按部就班的通过 Maven 打包就行了。执行完打包命令，在 target 目录就会生成一个 Jar 文件，如：helloworld-0.0.1-SNAPSHOT.jar。然后使用 `java -jar` 命令来启动就可以了。

打开系统命令行工具，将路径切换到 Jar 文件所在的目录，然后执行：

```shell
java -jar helloworld-0.0.1-SNAPSHOT.jar
```

接下来就可以看到熟悉的启动日志了，等应用启动完成以后，就可以访问我们写的接口了，很简单。



## 2.2 War

Spring Boot 让人喜爱的地方除了它为我们做了 N 多自动配置，还有另外一个可爱之处，就是能够非常方便的使用自定义配置。完美的兼顾了方便与灵活，Spring Boot 具有这样既贴心又开放的 “性格”，不由得你不喜欢。

下面我们就通过自定义配置，将 Spring Boot 工程以传统的 War 方式进行打包。我们只需要修改两个文件即可 ——SpringbootApplication（项目主类）和 pom 文件。



### 修改主类

修改项目主类：

```java
@SpringBootApplication
public class SpringbootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootApplication.class);
    }
}
```

主类需要继承 SpringBootServletInitializer，然后重写 configure () 方法，这样主类就修改完了。



### 修改 pom 文件

pom 文件中需要修改三个地方：

1. 修改打包方式
2. 修改依赖项
3. 设置 War 文件名

具体代码如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    ......
    <!-- 修改成 war -->
    <packaging>war</packaging>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <!-- 移除内置 Tomcat -->
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <!-- 添加 Tomcat 依赖，用于在 IDE 中运行项目 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>
        ......
    </dependencies>

    <build>
        <!-- 设置 war 文件名 -->
        <finalName>springboot</finalName>
    	......
    </build>

</project>
```

接下来使用 Maven 进行打包，打包完成后将 War 文件复制到 Tomcat 的 Webapps 目录下，然后运行 startup 脚本（Tomcat 的启动脚本在 bin 目录下）搞定。



# 3. DevTools

DevTools 是 Spring Boot 1.3 版本引入的一组开发者工具，目的是为了提高开发效率。其中一个很重要的功能就是，当代码修改后会自动帮我们重启应用。就这个？比我自己重启也强不到哪去呀！如果只是将原来的手动变成了自动，那真的就没啥好说的了。

**自动重启优势所在**

为了提升重启的速度，Spring Boot 将资源分成了两类：一类是不变对象（例如项目依赖的 Jar 包）；另一类是可变对象（也就是我们应用中的类或者资源文件）。然后用基础类加载器来加载不变对象，用重启类加载器来加载可变对象。

那么重启的时候就可以只加载可变对象了。这样一来，启动速度势必会比加载所有资源的方式更快。理论上，项目依赖的第三方资源越多（项目越大），这种机制的优势也就越明显。



## 3.1 添加依赖

引入 DevTools 依赖：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```



## 3.2 设置 IDE

想要使用 Spring Boot 的自动重启功能，需要对 IDE 进行一些设置。我们以 IDEA 为例，需要开启自动构建和自动编译。



### 开启自动构建

file -> Settings（Mac：IntelliJ IDEA -> Preferences） -> Compiler -> Build Project automatically

快捷键（打开设置对话框）：

- Win：Ctrl + Alt + S
- Mac：Command + ,

![图片描述](http://img1.sycdn.imooc.com/5ed0e3b50001570809820722.png)

Build Project automatically 选项后面有一行小字 ——only works while not running/debugging，勾选了自动构建以后，告诉我只能在非运行（调试）的情况下起作用。IDEA 你是在逗我吗？我们要的就是运行时起作用呀！所以，我们还得再做一个设置。



### 开启自动编译

Help -> Find Action -> Registry…

快捷键：

- Win：Ctrl + Alt + Shift + /
- Mac：Command + Option + Shift + /

![图片描述](http://img1.sycdn.imooc.com/5ed0e3a600015fc208560424.png)
勾选 compiler.autoMake.allow.when.app.running

![图片描述](http://img1.sycdn.imooc.com/5ed0e3950001f86d08670683.png)

可以看到这一项是允许应用在运行期进行自动编译的。

经过以上步骤后，在修改完类或者 application.yml 文件，应用就可以自动重启了。



## 3.3 自定义规则

如果你想要定制自动重启的策略，可以通过以下配置项来实现：

```properties
# 是否启用自动重启，默认值 true
spring.devtools.restart.enabled

# 不在监控范围的目录，默认值去 DevToolsProperties 类中查看
spring.devtools.restart.exclude

# 用来设置不需要监控的路径（会与 spring.devtools.restart.exclude 叠加）
spring.devtools.restart.additional-exclude

# 用来设置 classpath 以外的监控路径
spring.devtools.restart.additional-paths

# 监控 classpath 下文件修改的时间间隔，单位毫秒，默认值 1000
spring.devtools.restart.poll-interval

# classpath 下文件无更新的等待时间（超过这个时间没有任何更新就开始进行重启），单位毫秒，默认值 400
spring.devtools.restart.quiet-period

# 设置一个用于触发重启的文件，如果不设置，那么 classpath 只要有更改就可以触发重启
spring.devtools.restart.trigger-file
```



# 4. 类加载机制

我们都知道，Java 程序需要被 JVM 将编译后的字节码加载到内存，之后才能够运行和使用。JVM 将字节码加载进内存再到形成 JVM 可用的 Java 类型，这一过程就是 Java 的类加载。DevTools 的自动重启正是借助了这种灵活的加载机制才得以实现。



## 4.1 加载过程

类加载的过程中，JVM 做了很多工作，这些工作可以分为五个阶段：

![图片描述](http://img1.sycdn.imooc.com/5ed0e37f00012f2604040523.png)
如上图所示，整个类加载的过程包含加载、验证、准备、解析、初始化。下面我们分别看看这五个阶段都做了什么。



### 加载

加载是「类加载」的第一个阶段（注意，不要混淆 `加载` 和 `类加载` 这两个概念）。在这一阶段，JVM 做了三件事：

1. 通过类的全限定名（如：java.lang.String）获取类的二进制字节流
2. 将类的字节流转化成方法区（JVM 内存模型中的一个分区）的运行时数据结构
3. 在内存中生成一个对应的 java.lang.Class 对象（就是 foo.getClass () 方法获得的那个类类型对象）

> 二进制字节流不仅可以来自文件系统（class 文件），还可以来自网络或者运行时动态生成。



### 验证

验证阶段理解起来比较简单，就是验证所加载的内容是否符合 Java 类的规范。比如：

- 是否以 `CAFEBABE` 开头
- 版本号是否在当前虚拟机的处理范围
- 常量池符合规范
- 是否有父类以及父类是否允许被继承
- 语法验证
- …

目的就是为了保证 JVM 的安全，不能什么东西都直接往 JVM 内存里放。就好比我们坐火车、飞机之前都要安检是一个道理。



### 准备

准备阶段做的事情比较简单，就是为类变量分配内存，并为类变量设置初始值。这里有两个需要注意的地方，一是，类变量指的是 static 修饰的静态变量；二是，设置初始值指的是如有代码：public static int num = 100，在准备阶段会将 num 的值设置为 0，而不是 100（将 num 设置为 100 是初始化阶段要做的事情）。

> 但如果是 public static **final** int num = 100，那么 num 在准备阶段会被设置成 100



### 解析

在解析阶段，JVM 会将常量池中的符号引用替换成直接引用。Java 虚拟机规范中并没有严格规定解析阶段的执行时机，只是要求在在执行 16 个特定的指令之前执行。

> 这 16 个特定的指令是：anewarray、checkcast、getfield、getstatic、instanceof、invokedynamic、invokeinterface、invokespecial、invokestatic、invokevirtual、ldc、lde_w、multianewarray、new、putfield、putstatic

解析主要针对：类、接口、字段、类中的方法、接口中的方法、方法类型、方法句柄和调用点限定符，这 7 类符号引用进行。最后，要说明一点，就是这一段不需要懂，了解一下就行，哈哈哈！



### 初始化

初始化是类加载的最后一步。在这一阶段 JVM 会为静态变量赋值、执行静态代码块。在讲准备阶段时，示例中的 num 将被赋值为 100。

这里有个知识点需要掌握：只有在父类初始化完成以后，才会初始化子类。也就是说，在为父类初始化完静态资源以后，才会处理子类的静态资源。

```java
public class Father {
    public static int a = 1;

    static {
        a++;
    }
}

public class Son extends Father {
    public static int b = a;

    public static void main(String[] args) {
        System.out.println(b);
    }
}
```

上面代码输出 b 的值是 2，而不是 1。这一点经常会在笔试题中遇到。



# 5. 总结

OK，在这一节，我们学习了 Spring Boot 的两种打包方式（Jar 和 War）；还学习了使用 DevTools 设置应用自动重启；最后又简要分析了类的加载机制和每个阶段分别作了什么。又是一次理论与实践的结合。

关于类加载这部分内容，对于新手来说理解起来会有点小困难。不用担心，这是正常的，你也不需要一下就弄得特别明白，先了解一下整体，随着不断的积累与实战，你的理解会越来越透彻，这就是学习的一个过程。这一节的内容就到这里，我们下一节不见不散。

[30 掰开揉碎刨铣自动配置的原理](http://www.imooc.com/read/75/article/1826)[32 送你一双千里眼，一对顺风耳——Actuator](http://www.imooc.com/read/75/article/1828)

精选留言 1

欢迎在这里发表留言，作者筛选后可公开显示

- [慕慕童鞋](http://www.imooc.com/u/8954842/articles)

  DevTools 的功能都很实用。

   0

  回复

  2020-06-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕慕童鞋](http://www.imooc.com/u/8954842/articles)

    是的，方便开发人员。

    回复

    2020-06-28 20:23:10

 

千学不如一看，千看不如一练