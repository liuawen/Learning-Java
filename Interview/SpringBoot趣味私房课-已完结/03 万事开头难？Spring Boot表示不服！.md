**03 万事开头难？Spring Boot表示不服！**



03 万事开头难？Spring Boot表示不服！

更新时间：2020-06-01 09:57:44

![img](http://img1.sycdn.imooc.com/5e9cfeea0001823506400359.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

世界上最快乐的事，莫过于为理想而奋斗。

——苏格拉底

项目代码：https://github.com/liushuijinger/springboot



# 1. 扯两句

上回书说到，Java Web 一路从 Servlet 到 SSH 再到 SSM ，每一次除了功能的增强，同时也一直在致力于简化我们的开发工作。曾经以为注解加上 properties 配置文件已经做到了极致，直到后来遇到 Spring Boot ，才知道什么叫山外有青山，楼外有青楼。不对，是楼外有高楼！



# 2. Spring Boot 有多火

不废话，让数据说话：

![图片描述](http://img1.sycdn.imooc.com/5e9abaa700014bcb11530396.png)
`Google Trends 上 Spring Boot 从发布至今的搜索指数`

以上数据来自 Google Trends ，是 Spring Boot 自 2014 年发布至今的搜索指数。6 年来有增无减，劲头十足。再看看 Spring 官网，不论是首页还是 Projects 列表，Spring Boot 都是排在第一个，妥妥的 C 位、一哥！有图有真相：

![图片描述](http://img1.sycdn.imooc.com/5e9aba990001b6dc11740685.png)
`官网首页`

![图片描述](http://img1.sycdn.imooc.com/5e9aba6900018de211180739.png)
`Projects 列表`

一般的技术官方网站都很简洁，而首页更是用来放置那些及其重要，最迫切想要传达给别人的信息。由此可见， Spring Boot 的地位非同一般呐！

OK，到现在已经快把 Spring Boot 吹爆了，那么接下来我们赶快体验一下 Spring Boot 令人发指的方便、快捷和高效吧！

> PS：目前 Spring 官网改版了，以上截图是它 2019 年时候的样子



# 3. 软件环境

本专栏的基础软件环境如下，后续章节不再赘述，如增加新的软件会给出说明。除系统与 IDE 外其他软件版尽量与专栏保持一致。

- **系统：** Mac OS
- **JDK：** 1.8
- **IDEA：** IDEA 2019
- **构建工具：** Maven 3.6.0
- **Spring Boot：** 2.2.5



# 4. 动手

俗话说，万事开头难。这句话在遇到 Spring Boot 之前一直是无比正确的。Spring Boot 出现之前，想要做一个小小的演示 Demo ，需要经历 N 多步繁杂的配置与操作，然而，可能你只是想写一个 Hello World 。但如今情况不同了，Spring Boot 的出现，彻底扭转了这一局面。而那句万事开头难的俗语恐怕要改成：万事开头难，除了 Spring Boot ！不信？往下看！



## 4.1 创建项目

本专栏使用的 IDE 是 IntelliJ IDEA ，Eclipse 党可以去下载 [STS（Spring Tool Suite）](https://spring.io/tools3/sts/all/)。我们打开 IDEA 选择 `Create New Project` ：

![图片描述](http://img1.sycdn.imooc.com/5e9aba420001f7ce15540964.png)

我们除了可以在 IDEA 中创建 Spring Boot 的工程，还可以用 Spring 官网为我们提供的 [Spring Boot 初始化工具](https://start.spring.io/)。两种方式很类似，后面我们会做简单演示。我们先演示一下在 IDEA 中如何创建一个 Spring Boot 工程。



## 4.2 选择项目类型

接着在左侧选择 `Spring Initializr` ，SDK 选择 1.8，然后 Next：

![图片描述](http://img1.sycdn.imooc.com/5e9ab9f80001053c15541134.png)



## 4.3 填写项目信息

选择 `Maven Project` ，然后来填写 Maven 坐标：

- Group：com.imooc
- Artifact：Springboot

Maven坐标 Group Artifact 

Type（项目类型）选择 `Maven Project`；Language（开发语言）不用说，当然是 `Java`；Packaging（打包类型）选择 `Jar`，使用 Spring Boot 开发 Web 项目不需要像我们之前那样打成 War 包，因为 Spring Boot 会默认嵌入一个 Tomcat 容器。Java Version 我们选择 `8`。其他项不需要做调整，接下来点击 Next：

![图片描述](http://img1.sycdn.imooc.com/5e9ab9e7000105a815541134.png)



## 4.4 选择依赖

下面我们来选择项目所需要依赖的 Jar 包，回想一下，以前我们要使用 Java 开发一个 Web 项目，最少需要依赖哪些 Jar 包呢？OK ，我知道你根本想不起来了（或者说想不全），但这并不是你的错，因为 Jar 实在是太多，太琐碎了。好消息是，我们今天用 Spring Boot 开发一个 Web 项目，你根本不需要记住需要依赖哪些 Jar。你只需要知道你要的是一个 Web 工程就好了。 在 IDEA 的依赖选择对话框中，你只需要勾选 `Web`，然后点击 Next 即可：

![图片描述](http://img1.sycdn.imooc.com/5e9ab9d50001a41616941134.png)



## 4.5 选择项目路径

接下来，需要选择一下项目的保存位置，这里根据自己的习惯与喜好自行设置就好。Finish：

![图片描述](http://img1.sycdn.imooc.com/5e9ab9ae00011eac16941134.png)
![图片描述](http://img1.sycdn.imooc.com/5e9ab99d0001f6cf08240300.png)
提示目录不存在，点击 `OK` 创建即可。



## 4.6 项目结构概览

经过上面的操作，我们就已经完成了一个基于 Spring Boot 的 Web 项目了，效果如下图；

![图片描述](http://img1.sycdn.imooc.com/5e9ab98b00019d8720000643.png)

不知道你刚刚有没有意识到，使用 Spring Boot 创建一个 Web 项目，我们仅仅用了五个步骤就完成了！我们没有配置（甚至都没有见到）Web.xml；没有配置启用注解；没有配置包扫描路径；没有配置视图解析；没有配置 Tomcat…

貌似以前创建一个 Java Web 项目需要进行的所有配置，我们都没有做。难道现在技术进步了，不需要这些配置了吗？当然不是，当你觉得轻松的时候，一定是有人替你负重前行。（这碗鸡汤放在这里很合适。）没错，一切繁杂而又与业务无关的配置，都是 Spring Boot 帮我们默默的完成了。

还是要做的  只是封装了 集成了  简化了 

## 4.7 创建 Controller

下面我们创建一个 Controller 来实现我们今天的核心代码（呸！就那么一句，也好意思说核心。罪过罪过，原谅老夫又装 x 了）：

![图片描述](http://img1.sycdn.imooc.com/5e9ab9790001092506980264.png)

> 在 `com.imooc.springboot` 包下创建 `HelloController`





## 4.8 编写代码

在我们刚刚创建的 Controller 中添加一个方法和两个注解，我们的就完成了今天的所有工作。

```java
@RestController
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello Spring Boot";
    }
}
```



## 4.9 效果展示

OK，接下来在 IDEA 中点击运行或者使用 `Control + R` 来启动我们的工程。然后在浏览器输入 [localhost:8080](http://www.imooc.com/read/75/article/1799)。如果看到浏览器中显示 `Hello Spring Boot` 字样，那么恭喜，你已经学会 Spring Boot 的基本使用了。没错！就是这么简单！

![图片描述](http://img1.sycdn.imooc.com/5e9ab95c0001e7cb06360310.png)



# 5. 创建 Spring Boot 工程的另一种姿势

上面是使用 IDEA 创建 Spring Boot 工程的方式，下面我们换个姿势，看看如何通过 Spring 官网提供的初始化工具来创建一个 Spring Boot 工程。我们在浏览器中打开官方的初始化页面：[https://start.spring.io](https://start.spring.io/) 。然后我们会看到如下页面：

![图片描述](http://img1.sycdn.imooc.com/5e9ab9460001113821381410.png)

我们可以看到左侧一共有五项内容：

1. Project
2. Language
3. Spring Boot
4. Project Metadata
5. Dependencies

Project 代表我们工程的构建类型，有两种选择 —— Maven 和 Gradle；Language 与 IDEA 中相同，支持 Java、Kotlin 和 Groovy；接下来 Spring Boot 这一项指的是 Spring Boot 的版本（IDEA 中没有这个选项，只能用默认的最新 Release 版本）。不带后缀的是目前的稳定版本，带 M + 数字的是里程碑版本，相对稳定，带 SNAPSHOT 的是快照版本，不稳定，bug 较多；再后面是 Project Metadata，这里是用来配置工程的构建信息的，是给 Maven 或者 Gradle 做配置的（和 IDEA 中的配置大同小异）；最后一项是 Dependencies，通过名字我们就能知道，它是用来添加工程所依赖 Jar 包的。

细心的同学可能已经发现了，在 Project Metadata 这一项的右侧详情中，最下面有一个折叠项 —— Options，展开以后会看到如下内容：

![图片描述](http://img1.sycdn.imooc.com/5e9ab9360001fe2c11740862.png)
里面是对于工程的详细配置，包括工程名、描述、包名以及打包类型和 Java 的版本。

在添加依赖的时候，可以直接搜索我们需要的 Jar 包，也可以点击放大镜右侧的三道横杠来按照分类进行筛选：

![图片描述](http://img1.sycdn.imooc.com/5e9ab9220001f47022380918.png)

当一切配置完成后，可以点击下方左侧的 Generate the project 进行下载，也可以点击右边的按钮 Explore the project 进行预览。点击预览会看到如下内容：

![图片描述](http://img1.sycdn.imooc.com/5e9ab90b0001853626241100.png)

可以看到，在 Spring 官网创建的工程与我们在 IDEA 中创建的工程是一样的，确认无误后下载到本地，下载后会得到一个压缩包，解压后导入到 IDE 中就可以了。



# 6. 总结

今天我们借助搜索引擎的大数据了解了一下 Spring Boot 的趋势，我们了解到 Spring Boot 如今发展势头很强劲，犹如框架中的小鲜肉，十分招人待见。

后面动手实践了一把，创建了一个基于 Spring Boot 的 Web 工程。真真切切的体验了一下 Spring Boot 的简洁与高效。实例非常的简单，相信你可以轻松搞定。

今天算是对 Spring Boot 的牛刀小试，对于 Spring Boot 有一个初步的认识，体验一下它的特点。如果你之前没有用过 SSM 或者 SSH 的话，推荐你自己动手搭一个 SSM 的整合实例，通过这样的对比，相信会让你有更加深刻的体会与感受，千万不要偷懒哦。

SSM  配置地狱啦

SB SpringBoot 预定大于配置 

精选留言 13

欢迎在这里发表留言，作者筛选后可公开显示

- [乃好](http://www.imooc.com/u/7249708/articles)

  老师您好，请问您怎么看待最新版的sb采用了gradle作为构建工具？

   0

  回复

  2020-06-30

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[乃好](http://www.imooc.com/u/7249708/articles)

    从哪个版本开始的？看了一下 Spring initializr，也就是这里 https://start.spring.io/ 默认还是 Maven 工程呀 Spring Boot 2.3.1

    回复

    2020-07-02 19:11:07

  - [乃好](http://www.imooc.com/u/7249708/articles)

    回复

    [刘水镜](http://www.imooc.com/u/8840839/articles)

    https://spring.io/blog/2020/06/08/migrating-spring-boot-s-build-to-gradle

    回复

    2020-07-02 19:16:51

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[乃好](http://www.imooc.com/u/7249708/articles)

    看了一下这篇文章，说的是将 Spring Boot 源码的构建工具换成了 Gradle。刚刚我理解成了，我们用新版本的 Spring Boot 创建项目的时候，默认构建工具换成了 Gradle，哈哈。 文章中说的很明确，他们之所以换主要是因为 Gradle 具有更快的构建速度，节省时间。 文中也提到 Spring Framework 在 2012 年就已经在用 Gradle 来构建了，所以这次 Spring Boot 切换到 Gradle 也是出于长期考量做的决定吧。 对我们普通开发者来说，没有任何影响。

    回复

    2020-07-02 20:21:53

- [qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

  非常详细，优秀

   0

  回复

  2020-06-18

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    感谢支持！

    回复

    2020-06-19 19:43:26

- [MarchGoGo](http://www.imooc.com/u/9029620/articles)

  没学过 SSH 和 SSM 直接学习Spring boot可以？现在已经进入公司，刚刚学完web准备学习框架时候就收到公司offer，现在已经工作一周了，公司的项目使用SSM框架和dubbo框架，感觉进了公司以后就觉得自己技能水平远远不够

   1

  回复

  # 用 Spring Boot 做项目， 其实本质上还是用的 SSM。技术的东西是没有什么捷径的，出来混迟早是.... 对吧。所以需要了解 SSM 最基本的使用（幸运的是，这并不难）。

  

  2020-05-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[MarchGoGo](http://www.imooc.com/u/9029620/articles)

    用 Spring Boot 做项目， 其实本质上还是用的 SSM。技术的东西是没有什么捷径的，出来混迟早是.... 对吧。所以需要了解 SSM 最基本的使用（幸运的是，这并不难）。

    回复

    2020-05-25 18:17:23

  - [MarchGoGo](http://www.imooc.com/u/9029620/articles)

    回复

    [刘水镜](http://www.imooc.com/u/8840839/articles)

    好的，感谢老师

    回复

    2020-05-25 23:31:47

- [江海豪](http://www.imooc.com/u/5637918/articles)

  你好 . 个人希望作者写详细一点, 比如在xx文件夹下,创建xxxController. 很多新人 很不理解的. 图文教程. 就要详细点咯. 跟着就能做出来的项目(demo), 才是好的图文教程.. 可以参考laravel社区人家的图文教程, 真的跟着做就能完成一个项目的.. 虽然我看得懂, 但是看了评论还是很多新人的

   0

  回复

  2020-05-21

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[江海豪](http://www.imooc.com/u/5637918/articles)

    好哒，感谢江同学宝贵的建议。

    回复

    2020-05-22 21:28:04

  - [江海豪](http://www.imooc.com/u/5637918/articles)

    回复[江海豪](http://www.imooc.com/u/5637918/articles)

    加油(ง •̀_•́)ง，更新，我还要看你的作品学习呢。

    回复

    2020-05-22 22:47:14

- [小熊二喵](http://www.imooc.com/u/7913832/articles)

  弄好了，第一次运行在windows10下有几个问题要补充一下：问题一，新手刚下载的idea，新建好项目时是不能创建class的。解决办法：file->project struct->modules->选中项目的java文件夹，右键点resource，设为源文件；问题二，直接照着写class是不会自动导包的， 解决方法：要么打开idea得自动导包功能，要么看老师的源文件，手动导入一下；问题三，这时候导入的包也是没有的，需要更新maven的插件，解决方法：file->setting->build，execution,deployment->build tools->maven中的maven home directory改为idea下的maven（或者自己百度maven配置）,然后点击idea编辑区右边栏的maven第一个update，更新完后就可以import了。 之后就可以运行并访问8080了

   1

  回复

  2020-05-18

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[小熊二喵](http://www.imooc.com/u/7913832/articles)

    厉害！！！遇到问题是成长的最好机会，恭喜 get 一个技能！

    回复

    2020-05-19 21:26:34

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[小熊二喵](http://www.imooc.com/u/7913832/articles)

    补充一下 问题二 的解决方案：定位到需要导包的类（报红的地方）使用 Alt + Enter 可以导包

    回复

    2020-05-22 22:09:41

- [小熊二喵](http://www.imooc.com/u/7913832/articles)

  还有，运行键是灰色，ctrl+r在windows是replace,shift+f10也运行不了

   0

  回复

  2020-05-18

- [小熊二喵](http://www.imooc.com/u/7913832/articles)

  设置完modules所有文件都报错了

   0

  回复

  2020-05-18

- [小熊二喵](http://www.imooc.com/u/7913832/articles)

  弄好了，说是要idea设置modules,才能创建class,但是设置完又报错了，不会设置

   0

  回复

  2020-05-18

- [小熊二喵](http://www.imooc.com/u/7913832/articles)

  我一模一样的操作，但是看源码里多了个helloworld文件夹，文章里没有啊，哪来的呢，而且idea提示is not allowed as identify in strict mode

   0

  回复

  2020-05-18

- [小熊二喵](http://www.imooc.com/u/7913832/articles)

  controller在哪创建的啊，为啥我照着写报错，

   0

  回复

  2020-05-18

- [MochaCat](http://www.imooc.com/u/2566305/articles)

  镜哥，“没有配置试图解析”应该是“视图解析”吧？

   0

  回复

  2020-05-13

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[MochaCat](http://www.imooc.com/u/2566305/articles)

    对对对，这输入法，哈哈

    回复

    2020-05-13 21:06:28

- [amilu](http://www.imooc.com/u/192706/articles)

  “当你觉得轻松的时候，一定是有人替你负重前行。（这碗鸡汤放在这里很合适。）”
  看过一个段子说什么30女人如虎，然后有人评论说我不觉得啊，然后就又有人评论说哪有什么岁月静好，只不过有人替你负重前行。

   0

  回复

  2020-04-28

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[amilu](http://www.imooc.com/u/192706/articles)

    前方学校，禁止飙车

    回复

    2020-05-12 13:58:56

- [刘水镜](http://www.imooc.com/u/8840839/articles)

  源码地址：https://github.com/liushuijinger/springboot 点 “Star”用不迷路。

   0

  回复

  2020-04-26

 

千学不如一看，千看不如一练

 