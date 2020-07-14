**33 君子善假于物——IDEA值得用心假一假**

33 君子善假于物——IDEA值得用心假一假

更新时间：2020-06-03 10:16:37

![img](http://img2.sycdn.imooc.com/5ebe63070001e69b06400426.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

衡量一个人的真正品格，是看他在知道没人看见的时候干些什么。

——孟德斯鸠



# 1 前言

> 登高而招，臂非加长也，而见者远；顺风而呼，声非加疾也，而闻者彰。假舆马者，非利足也，而致千里；假舟楫者，非能水也，而绝江河。君子生非异也，善假于物也。

荀子的《劝学》我们都很熟悉了（毕竟是要求背诵全文的），荀子老人家通过上面这段文字，想告诉我们的就是要善于利用各种工具（或其它资源）。每一种工具都是人类能力的一种延伸。交通工具是脚的延伸；通讯工具是眼耳口的延伸；计算机是人脑的延伸等。

同样的，IDE 就是我们编程能力的一种延伸。选择 + 打造一款好的（符合你编程习惯）的 IDE，可以让你的编程效率显著提升。什么「磨刀不误砍柴工」、「欲善其事先利其器」这些道理我们已经非常熟悉了，不需要过多的阐述了。

我们为什么要选择 IntelliJ IDEA 作为我们的开发工具呢？先看一下数据吧：

![图片描述](http://img1.sycdn.imooc.com/5ed707fa00018cc510000815.png)

> JVM 生态 IDE 市场份额，来自《2020 年 JVM 生态报告》

嗯，只有数据也许不能完全说明问题，接下来我们一起看看 IDEA 究竟有什么本领，可以得到如此广泛的青睐。



# 2 基本设置

作为一款优秀的软件，除了人性化的默认设置以外，还需要具备充分的自定义空间（此刻，你心里想起了谁）。默认设置是照顾大多数情况，自定义是满足个性化需求。

IDEA 的设置项非常全面，基本上你想要的它都有，这里我介绍一些我的个人设置偏好，仅供参考。

> PS：本节内容基于 Windows 环境，IDEA 2019.3

`Ctrl + Alt + S` 打开设置面板。



## 2-1 字体

由于个人视力不太好，所以调整字体是我的一个刚需。IDEA 的字体设置分为两种，一种是软件本身（界面、菜单等）的字体；另一种是编辑区（代码、控制台等）文字的字体。



### 界面字体

Appearance & Behavior -> Appearance：

![图片描述](http://img1.sycdn.imooc.com/5ed707eb0001246f09940710.png)

选择你喜欢的字体以及字号，还可以修改主题风格。



### 编辑区字体

Editor -> Font：

![图片描述](http://img1.sycdn.imooc.com/5ed707dd000189e309940710.png)

强推一下 JetBrains 的 Mono 字体，专为编程研发的一款等宽字体（开源的），支持多种主流编程语言，了解更多戳[这里](https://www.jetbrains.com/lp/mono/)。



## 2-2 智能 Import

Editor -> Auto Import：

![图片描述](http://img1.sycdn.imooc.com/5ed707ce0001a21b09940710.png)

勾选上面两个选项，当没有二义性时，会自动导入包引用。当包引用不再被使用时，会自动移除，代码洁癖必备。

**效果：**

![图片描述](http://img1.sycdn.imooc.com/5ed707b30001cb7200020019.gif)



## 2-3 行号与方法分隔符

Editor -> General -> Appearance：

![图片描述](http://img1.sycdn.imooc.com/5ed7079e0001314c09940710.png)

显示行号和方法分隔符，类中的代码越多好处越明显。

**效果：**

![图片描述](http://img1.sycdn.imooc.com/5ed7079000011b3a08250554.png)



## 2-4 代码提示忽略大小写

Editor -> General -> Code Completion：

![图片描述](http://img1.sycdn.imooc.com/5ed707750001d4ed09940710.png)

这一点比起 Eclipse 来，优雅了很多。



## 2-5 Tap 布局以及排序

Editor -> General -> Editor Tabs：

![图片描述](http://img1.sycdn.imooc.com/5ed7075c000100dd09940710.png)

你是否层因为打开多个标签后，找不到自己想要切换的标签而痛苦？将标签放到左侧，然后按字母排序也许能解决你的问题。

**效果：**

![图片描述](http://img1.sycdn.imooc.com/5ed707460001df8009570446.png)



## 2-6 高亮显示修改文件

Version Control：

![图片描述](http://img1.sycdn.imooc.com/5ed7072200014b7509940708.png)

修改了哪些文件一目了然（集成版本管理后生效）。

**效果：**

![图片描述](http://img1.sycdn.imooc.com/5ed706f3000155cf04900153.gif)

> 当找不到某个设置的时候，可以在设置面板左上角的输入框输入关键字，可以快速定位到你要的内容。



# 3 使用技巧

IDEA 有很多非常实用的骚操作，掌握这些技巧可以让你事半功倍。



## 3-1 历史剪切板

快捷键：Ctrl + Shift + V

![图片描述](http://img1.sycdn.imooc.com/5ed706b10001153a00020019.gif)

不用过多介绍，用过之后再也回不去系列。



## 3-2 移动代码

快捷键：Ctrl + SHift + Up/Down（上 / 下移动代码块）；Alt + Shift + Up/Down（上 / 下移动一行）

![图片描述](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC)

移动一行和移动代码块稍有区别，试一下就明白了。



## 3-3 我要找到你

在 IDEA 中，你可以非常方便的找到一切你想要找的内容。



### 最近打开（修改）文件

快捷键：Ctrl + E

![图片描述](http://img1.sycdn.imooc.com/5ed7065800010ce406050542.png)

鼠标勾选 Show changed only 或再次按 Ctrl + E，显示最近修改过的文件。



### 全局查找 / 替换

快捷键：Ctrl + Shift + F

![图片描述](http://img1.sycdn.imooc.com/5ed706420001a76f09450720.png)

可以搜索一切文本内容，速度快，非常实用。还可以指定搜索范围。

快捷键：Ctrl + Shift + H

![图片描述](http://img1.sycdn.imooc.com/5ed7062f000171ff09450720.png)

全局批量替换，用过都说好。



### 随时随地搜

快捷键：双击 Shift

![图片描述](http://img1.sycdn.imooc.com/5ed7061c000120a606770680.png)

非常强大的搜索，可以搜文件、类、变量、方法、设置等。连项目以外的（第三方 Jar）都可以搜索（再次双击 Shift）。



## 3-4 Surround With

快捷键： Ctrl + Alt + T，看效果：

![图片描述](http://img1.sycdn.imooc.com/5ed705f90001c65a00020019.gif)
快速生成常用的样板代码，如 if、if else、for、try catch 等。



## 3-5 问题狙击手



### 锁定目标

快捷键：F2

遇到有编译错误（文件报红）的情况，只需按一下 F2 就能迅速定位的有问题的地方。



### 一击即中

快捷键：Alt + Enter

F2 定位到问题以后，使用 Alt + Enter 快速修复。

![图片描述](http://img1.sycdn.imooc.com/5ed705d90001ba5300020019.gif)



## 3-6 Debug

Debug 是程序员的日常，掌握一些技巧可以帮助你快速定位与解决问题。IDEA 的调试功能很丰富，演示一个条件断点感受一下：

一般情况下，普通断点可以满足我们的需要，但如果你需要调试一个循环中的代码，而且这个循环数又很大，例如下面的代码：

```java
public static void main(String[] args) {
    Random random = new Random();
    for (int i = 0; i < 10000; i++) {
        int value = random.nextInt(100);
        System.out.println("value：" + value);
    }
}
```

需要调试 value 值为 50 的情况，我们肯定不能一遍一遍的傻调，这时候就需要用到条件断点了。用法很简单，只需要在普通断点上面右击一下，就会弹出条件输入框，然后输入 value == 50 即可。看动图感受一下：

![图片描述](http://img1.sycdn.imooc.com/5ed705c20001e73c01260078.gif)

其他技巧，像运行到光标处、执行到指定行号、执行表达式等功能，自己多尝试一下，附上一张 Debug 相关的快捷键对应表：

| 快捷键            | 介绍                                                         |
| :---------------- | :----------------------------------------------------------- |
| F7                | 下一步，如果当前行断点是一个方法，则进入当前方法体内         |
| F8                | 下一步，不进入当前方法体内                                   |
| F9                | 恢复程序运行，但是如果该断点后面的代码还有断点则停在下一个断点上 |
| Alt + F8          | 选中对象，弹出可输入计算表达式调试框，查看该输入内容的调试结果 |
| Alt + F9          | 运行到光标处                                                 |
| Ctrl + F8         | 设置光标当前行为断点，如果当前已经是断点则去掉断点           |
| Shift + F7        | 智能步入。断点所在行上有多个方法调用，会弹出进入哪个方法     |
| Shift + F8        | 跳出，表现出来的效果跟 F9 一样                               |
| Ctrl + Shift + F8 | 设置断点的执行条件                                           |

> IDEA 的快捷键非常强大，查看更多戳 [IDEA 快捷键对照表 Windows + Mac](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf?_ga=2.176463781.1076568985.1586589826-1615813281.1565018435)



## 3-7 偷懒神器

任何语言都会有样板代码，敲样板代码对于编程人员来说没有任何意义（除了可以练习打字以外），然而它对于编译器来说又是不可或缺的。为了解决这个不可调和的矛盾，IDEA 为我们提供了两个功能 ——Live Template 和 PostFix。



### Live Template

不多废话，直接看效果吧：

![图片描述](http://img1.sycdn.imooc.com/5ed705aa0001899d00020019.gif)

简单来讲，就是可以让你敲几下键盘出来一堆代码。更多 IDEA 内置的 Live Template 可以去 Settings -> Editor -> Live Template 中查看：

![图片描述](http://img1.sycdn.imooc.com/5ed705950001d36609940786.png)



### PostFix

还是直接看效果吧：

![图片描述](http://img1.sycdn.imooc.com/5ed705750001c20500020019.gif)

跟 Live Template 有点像，不一样的地方是 PostFix 是有所属对象的。更多内置的 PostFix 可以到 Settings - General -> PostFix Completion 中查看：

![图片描述](http://img1.sycdn.imooc.com/5ed7056600015a4309940786.png)

> PS：LIve Template 和 PostFix 都可以自定义，可以根据自己的喜好设置，非常方便。



## 3-8 重构

IDEA 的重构功能也很强大，这里不展开讲了，当作一个课下作业吧。列一下我常用的重构快捷键：

- Shift + F6 重命名
- Ctrl + Alt + V 抽取变量
- Ctrl + Alt + F 抽取字段
- Ctrl + Alt + P 抽取参数
- Ctrl + Alt + C 抽取常量
- Ctrl + Alt + M 抽取方法



# 4 插件

尽管 IDEA 的功能已经非常强大，但仍然有着非常开放的心态，支持通过第三方插件的方式来增强它的功能。下面简单列一下我必装的插件。



## 4-1 Alibaba Java Coding Guidelines

按照《阿里巴巴 Java 开发手册》中的编码规范检查代码并给出修改建议。



## 4-2 Codota

去官网看一下简介，你会回来感谢我的。



## 4-3 Lombok

省去烦人的 Getter/Setter，当然功能远不止于此。



## 4-4 Maven Helper

Maven 好帮手，解决依赖冲突的利器。



## 4-5 MyBatis Log Plugin

可以打印出可执行的（自动将？替换成具体的参数） SQL 语句，非常好用。



## 4-6 MybatisX

可以直接通过 Java 代码跳转到 MyBatis 的 Mapper.xml 中对应的 SQL。也可以使用 Free Mybatis plugin



## 4-7 Rainbow Brackets

这个还是直接看图吧：

![图片描述](http://img1.sycdn.imooc.com/5ed70539000165bf11510210.png)



# 5 总结

OK，今天我们学习了 IDEA 的基本设置、使用技巧和一些插件。都是一些需要动手操作的内容，所以一定要动手呀！能动手尽量不 BB 哈。

这些内容都不需要刻意去记，只需要多用，慢慢就潜移默化到你脑子里了。另外，分享一个个人习惯。每当我接触到一个新软件的时候，都会把它的所有设置项都翻一遍，试一遍。这样做有什么好处呢？很明显，这样过一遍以后，虽然不能把所有设置项都记住，但它们却都在你脑子里留下了痕迹。当你有需要的时候它们就会蹦出来，告诉你：我有这样一个功能哦～。这时候你可能想不起来在哪，但是我们有搜索引擎呀！软件名 + 你要的功能，基本上都可以搞定。

最后，还是需要多动手实践，不要忘记自己实践一下 IDEA 的「重构」呦！

[32 送你一双千里眼，一对顺风耳——Actuator](http://www.imooc.com/read/75/article/1828)[34 这些经典的业务场景你不能不知道](http://www.imooc.com/read/75/article/1830)

精选留言 1

欢迎在这里发表留言，作者筛选后可公开显示

- [慕慕童鞋](http://www.imooc.com/u/8954842/articles)

  不错，非常实用

   0

  回复

  2020-06-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕慕童鞋](http://www.imooc.com/u/8954842/articles)

    感谢支持。

    回复

    举报

    2020-06-28 20:25:35

 

千学不如一看，千看不如一练