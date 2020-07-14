**04 从Spring Boot的工程结构体会其设计哲学**

04 从Spring Boot的工程结构体会其设计哲学

SB工程结构体会其设计哲学

zhe xue 哲学 

更新时间：2020-05-26 11:07:08

![img](http://img1.sycdn.imooc.com/5e9cfefe0001e10106400359.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

生活的理想，就是为了理想的生活。

——张闻天

书接上回，上一个小节我们做了一个基于 Spring Boot 的 Hello World 程序。最后还留了一个小作业给你，现在要检查作业了，有没有完成呢？哈哈，仿佛又回到了小学时代，每天被老师追着检查作业。

回到今天的主题，今天我们一起来学习一下 Spring Boot 工程的宏观设计结构 —— Spring Boot 工程的标准结构。



## 1. 结构概览

上一个小节我们创建的工程结构如下图所示：

![图片描述](http://img1.sycdn.imooc.com/5e9abb2a0001b4a706380760.png)
如果你之前接触过 Maven ，那么你对这个结构应该会很熟悉，没错，这就是一个标准的 Maven 工程。Maven 和 Spring Boot 的出发点是一致的，都是为了简化项目的开发。只不过它们所解决的具体问题不同而已，Maven 主要帮我们解决了 Jar 包的依赖管理和项目的构建打包。



简化项目的开发   jar包的依赖管理和项目的构建打包 

结构详解 

## 2. 结构详解

下面我们看一看每个文件 / 文件夹（目录）都是用来做什么的：

```
springboot //应用根目录
|--target //应用编译打包输出目录
|--gitignore //Git 版本控制忽略清单文件
|--pom.xml  //Maven的依赖管理文件，通常称pom文件
`--src
   |--main //项目主目录
   |  |-–java //java源代码文件目录
   |  |  `--com
   |  |     `--imooc
   |  |        `--springboot
   |  |           |--dao
   |  |           |--service
   |  |           |--controller
   |  |           |--config
   |  |           |--....
   |  |           `--SpringbootApplication.java //Spring Boot主类
   |  |
   |  `-–resources //资源文件目录
   |     |-–static //静态资源文件：JS、CSS等
   |     |-–templates //页面模板文件：Thymeleaf、FreeMarker等
   |     `--application.properties //配置文件
   |
   `–-test //单元测试目录
      |–-java //单元测试 java 源代码文件目录
      |  |--com
      |     `--imooc
      |        `--springboot
      |           |--dao
      |           |--service
      |           |--controller
      |           |--config
      |           |--....      
      |           `--SpringbootApplicationTests.java //测试主类
      |
      `-–resources //单元测试资源文件目录
```

> 纯手工绘制，感受到我对你们的爱了吗？

从上面的结构中，我们可以看出，工程根目录下一共由四部分组成 —— `target`（目录）、`gitignore`（文件）、`pom.xml`（文件）和 `src`（目录）。

我们知道 `target` 是目标的意思，使用 Maven 打包后会将编译后的 .class 文件，和依赖的 jar 包以及一些资源文件放到这个目录下；

`gitignore` 文件用来配置那些不需要 Git 帮我们做版本控制的文件或目录，例如 IDEA 产生的配置文件或者本地开发用的 application-local.yml 文件等；

`pom.xml` 文件用来配置我们所依赖的 Jar 包，帮我们做 Jar 包管理的，我们会经常跟它打交道；

最后的 `src` 目录存放着所有我们编写的 Java 源代码、程序配置、资源等文件，是我们开发用到的主目录。

OK，到此我们对于 Maven 或者说 Spring Boot 的工程结构已经有了一个非常清晰的认识了。但对于我们这种好学之人（不许笑），到这里是远远不够的。我们还想要了解为什么要设计成这个样子。既要知其然，还要知其所以然。



### 2.1 结构分类

首先，像 `target` 、 `.gitignore` 和 `pom.xml` 都是偏工具属性的，它们主要是给 Maven 、Git 用的，与我们开发人员关系没有那么紧密。真正跟我们息息相关的是 `src` 目录下的内容。平时我们操作最多的内容也是该目录下的内容。

#### 业务目录

我们可以清晰的看到，src 目录有两个分支 —— `main` 和 `test` 。这两个目录的用途很好理解，main 用来放我们的业务逻辑主代码，而 test 则用来放我们的测试代码。而且我们很容易发现它们两个内部的结构及其相似。因为 test 就是为 main 服务的，理论上 main 中的每一个 Java 类在 test 都要有一个测试类，可以理解成 main 中的每个类都有一个贴身侍卫，保其周全。

再往下看，又分为： `dao` 、 `service` 、 `controller` 等目录，这是我们软件开发中最基本的分层思想，相信你再熟悉不过了就不过多占用笔墨了。



## 3. 设计哲学

不管是 Spring Boot 还是 Maven 亦或是其他的框架，虽然她们功能各异特点不同，但是却都有一个共同的设计哲学 —— 约定优于配置。怎么理解呢？举个例子说明吧。

还记得上一小节中主类 `SpringbootApplication` 上的那个注解吗？没错，就是 `@SpringBootApplication` 注解，不记得了？没关系，代码重现一次：

```java
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
```

那么这个注解是干嘛用的呢？关于这个注解本节不过多讲解，后面会详细讲，在这里只介绍它的众多功能中的一个 —— 开启注解扫描。但我们发现并没有配置要扫描的路径鸭！这是咋回事呢？这正是「约定优于配置」设计思路了，只要加上这个注解（在不添加任何额外配置的情况下），就约定俗成的去扫描当前目录及其子目录了。这就是约定优于配置的设计哲学。

假如我们不这样去设计，那么我们上面的代码则需要写成如下的样子，才能完成上一节的 Hello World 实例了：

```java
@SpringBootApplication(scanBasePackages = "com.imooc.springboot")
public class SpringbootApplication {
	......
}
```

我们需要手动指定需要扫描的路径，这么做除了烦人以外别无用处。做个类比就更能说明问题了，假设你跟一个人面对面聊天时，要求你们在说话之前都叫一遍对方的名字，然后才能说你们想要说的话，你什么感觉？（恰好你聊天的对象有俄罗斯血统呢？哈哈）。

除了这一点以外，还有很多地方都体现了这一思想。例如，我们并没有指定 Web 容器，但是却可以 “直接” 运行，很显然是 Spring Boot 帮我们集成了 Tomcat ；我们并没有配置日志框架，但依然可以看到有良好的日志格式输出。

这种约定优于配置的思想，类似于我们现实生活中的风俗习惯。比如，我们中国人春节都会吃饺子、帖春联、放鞭炮（当然不要在禁放区内燃放）。西方国家感恩节吃火鸡、平安夜互送苹果。这些都是一定范围内形成的默契，大家不需要提前商量，到特定的日子就都默契的去做相同的事情。

我们学习 Spring Boot 的习俗，其实就相当于入乡随俗了。这很重要。有多重要呢？举个例子，假如一个人来到了傣族人民生活的地方，又恰逢泼水节，然而他对于这个节日一无所知，那么当人们向他泼水，来表示对他的欢迎与喜爱的话，你猜他会有什么样的反应？毫无疑问，他不但感觉不到人们的热情，反而会错愕、慌张、甚至愤怒，总之不会开心就对了。又假如他知道，泼水节要互相泼水以表达感情，但是他觉得感情的强烈程度应该跟水的温度成正比，那么后果不堪设想… 所以我们不但要学习这种习俗，还要把它学好。



## 4. 总结

OK，沉迷于学习的时间总是过得这么快！不知不觉又到了小节的尾声，是不是有点意犹未尽？没关系，我们一起学习探讨的日子还长着呢。先回顾一下本小节的主要内容吧。

在这一个小节我们通过 Spring Boot 的工程结构聊到了它的设计哲学 —— 约定优于配置。后面又通过一个例子进一步说明了什么是约定优于配置，以及学习这些约定的意义所在。

相信通过这小节你已经对于 `规范` 的意义有了更深的认识。后面的章节我还会跟你一起继续更深入的探讨这个主题，到时候不止让你对于这个哲学有更深入的理解，还会让你对于如何学习又更进一步的认识，让我们一起沉迷于学习无法自拔！

[03 万事开头难？Spring Boot表示不服！](http://www.imooc.com/read/75/article/1799)[05 YAML与Spring Boot更配哦~](http://www.imooc.com/read/75/article/1801)

精选留言 3

欢迎在这里发表留言，作者筛选后可公开显示

- [慕仔7214391](http://www.imooc.com/u/7485583/articles)

  老师启动springboot项目要配置阿里的镜像吗？我不配置，启动不了！

   0

  回复

  2020-05-07

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕仔7214391](http://www.imooc.com/u/7485583/articles)

    配上以后能启动吗？ 把你报错的详细信息贴一下。 这里有源码，你也可以参考一下。 https://github.com/liushuijinger/springboot

    回复

    2020-05-08 18:56:11

  - [qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    回复[慕仔7214391](http://www.imooc.com/u/7485583/articles)

    有时候网络不好就是无法创建，用阿里的创建就可以了https://start.aliyun.com/

    回复

    2020-06-20 08:37:50

- [qq_庞庞_0](http://www.imooc.com/u/6173405/articles)

  无法自拔了，感觉像看小说！！

   1

  回复

  2020-04-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_庞庞_0](http://www.imooc.com/u/6173405/articles)

    感谢支持，羞愧难当...

    回复

    2020-04-26 20:39:30

  - [amilu](http://www.imooc.com/u/192706/articles)

    回复[qq_庞庞_0](http://www.imooc.com/u/6173405/articles)

    确实，沉迷了。以后要催更了，哈哈

    回复

    2020-04-28 08:45:17

- [慕用4018787](http://www.imooc.com/u/8134873/articles)

  哈哈，尼古拉斯赵四和卡布奇诺列宁斯基的对话。

   1

  回复

  2020-04-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕用4018787](http://www.imooc.com/u/8134873/articles)

    感谢支持！脑洞不是一般的大呀！

    回复

    2020-04-26 20:40:01

 

千学不如一看，千看不如一练