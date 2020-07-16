# 13 为互联网而生的持久化框架-Mybatis（一）

更新时间：2020-05-26 11:47:58

![img](http://img4.sycdn.imooc.com/5e9d004c0001af9a06400359.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

受苦的人，没有悲观的权利。

——尼采

为互联网而生的持久化框架 Mybatis

abatis

abattoir
 [abatwa:r] 
屠宰场

# 1. What is Mybatis

![图片描述](http://img1.sycdn.imooc.com/5eb2156e0001c93806450238.jpg)

提起 Mybatis 我们就会想到那只吉祥物—— 一只 Cosplay 忍者神龟的愤怒滴小鸟，想要了解一个技术最好的办法就是去它的官网看看，那么我们就先看一下官网是怎么向我们介绍 Mybatis 的。

> MyBatis is a first class persistence framework with support for custom SQL, stored procedures and advanced mappings. MyBatis eliminates almost all of the JDBC code and manual setting of parameters and retrieval of results. MyBatis can use simple XML or Annotations for configuration and map primitives, Map interfaces and Java POJOs (Plain Old Java Objects) to database records.

上面是 Mybatis 官网对于 Mybatis 的一个介绍，简单翻译一下：

MyBatis 是一个很牛逼的持久层框架，支持定制化 SQL、存储过程和高级映射。MyBatis 干掉了几乎所有的 JDBC 代码，不需要手动拼接参数和检索结果。MyBatis 可以使用简单的 XML 或注解来配置和映射原生类型、接口和 Java 的 POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。



# 2. 身世

MyBatis 的前世为 iBatis（ 该名称为 internet 和 abatis 的组合，寓意为互联网而生），iBatis 是由 Clinton Begin 在 2001 年发起的开源项目。

在 2004 年，iBatis 发布了 2.0 版本，随后 Clinton Begin 将 iBatis 献给 Apache 软件基金会（ Apache Software Foundation, ASF）。

在之后的 6 年中，iBatis 在方法论、源码管理、社交、开源基础建设等方面都取得了很大的进步。

2010 年 5 月 21 日，iBatis 项目迁移到 Google Code ，并更名为 MyBatis，正式投胎转世。版本从 3.0.1 一直更新到 3.2.3，稳定性得到很大提升。

2010 年 6 月 16 日， iBatis 项目被正式归入 Apache Attic， 属性变为“只读”， 这意味着该项目在 iBatis 时代正式结束。

2013 年 11 月 10 日，为了让更多的人参与到项目中，MyBatis 项目被迁移至 GitHub，而后一直发展至今，目前最新的稳定版本为 3.5.4 。



# 3. 特点

说 Mybatis 是目前国内 Java 持久层最为主流的技术，应该不会有什么人反对吧。它比 JPA（HIbernate）更加简单易用，学习门槛更低。遥想当年，在软件开发以企业管理系统（ERP、CRM 等）为主的年代，Hibernate 的模型化有助于系统分析与建模，顺应当时的需要，可谓叱咤风云，一时无两。然而世事无常，三十年河东三十年河西，如今已是移动互联网时代，业务重点从原来的模型、关系变成了大数据量、并发、高性能。这样一来，老牌 ORM 框架显得捉襟见肘了，新晋小生 Mybatis 走入我们的视野。

从 Mybatis 的前世 iBatis 的名字（ internet + abatis）来看，Mybatis 天生就具有互联网基因。互联网业务的特性就是快（更新迭代飞快）和灵活（各种花样各种玩法层出不穷）。既然我们说 Mybatis 天生具有互联网的基因，那么它必然也具备相应的特性，否则根本无法应对瞬息万变的互联网。

与其他的 ORM （对象关系映射，比如老大哥 Hibernate）框架不同，Mybatis 没有延续以往 ORM 框架将 Java 对象与数据库表关联起来的思路，而是另辟蹊径将 Java 方法与 SQL 语句进行关联。在 JDBC 和 JPA （Hibernate）之间找到了一个平衡点，即解决了 JDBC 的繁琐冗余与低效的开发速率，又解决了 JPA （Hibernate）的“笨重”与不灵活。Mybatis 允许用户充分的利用数据库的各种功能，如存储过程、视图、复杂查询以及某种数据库独有的特性，又对 JDBC 做了一定的封装，加上约定优于配置的设计理念，让开发效率也有了质的提升。

上面我们对 Mybatis 的特点进行了感性或者说是相对抽象的描述，那么下面我们换个角度用理性且具体的方式列出 Mybatis 的特点：

- 它消除了大量的 JDBC 冗余代码
- 它的学习门槛很低
- 它能很好地与传统数据库协同工作
- 它可以接受 SQL 语句
- 它提供了与 Spring 框架的集成支持
- 它提供了与第三方缓存类库的集成支持
- 它引入了更好的性能



# 4. 架构设计

接下来我们从宏观层面了解一下 Mybatis 的整体设计与架构，先来看看 Mybatis 内部都有哪些组件。



## 4.1 组件

![图片描述](http://img1.sycdn.imooc.com/5eb215b6000187a012260676.png)

MyBatis 通过 mybatis-3 的应用程序接口和 ibatis-spring 向用户提供 SQL 访问方法， 而 ibatis-spring 底层仍依赖 mybatis-3 和 spring-tx 来实现对 SQL Mapping 和事务的支持。 mybatis-3 实现了 SQL 映射的全部功能， 通过构建器构建配置环境和 JDBC 环境， 对应用程序提供接口并使用执行器执行 SQL，



## 4.2 功能架构

![图片描述](http://img1.sycdn.imooc.com/5eb215c400010c2109880547.png)

Mybatis 按照功能划分，可以分为三部分：

- **接口层**：提供给外部使用的接口，开发人员通过这些本地接口来操纵数据库。接口层一接收到调用请求就会调用数据处理层来完成具体的数据处理。
- **数据处理层**：负责具体的 SQL 查找、SQL 解析、SQL 执行和执行结果映射处理等。它主要的目的是根据调用的请求完成一次数据库操作。
- **基础支持层**：负责最基础的功能支持，包括连接管理、事务管理、配置加载和缓存处理，这些都是公用的东西，将他们抽取出来作为最基础的组件。为上层的数据处理层提供最基础的支持。

打个比方，接口层就好比饭店的菜单，数据处理层就是厨房，基础支持层就好比是水、电、燃气之类的。客户按菜单点菜（调用接口），厨房负责做菜（数据处理），基础设施提供最基本的水、电、燃气的支持（基础支持）。



## 4.3 包结构

```
org
 └─ apache
     └─ ibatis
        +─ annotations
        +─ binding
        +─ builder
        +─ cache
        +─ cursor
        +─ datasource
        +─ exceptions
        +─ executor
        +─ io
        +─ javassist
        +─ jdbc
        +─ logging
        +─ mapping
        +─ ognl
        +─ parsing
        +─ plugin
        +─ reflection
        +─ scripting
        +─ session
        +─ transaction
        +─ type
```

MyBatis主要的源码包及其作用如下。

- **annotations**：注解包，包含所有mapper 接口中用到的注解
- **binding**：负责将 mapper 接口与 SQL 语句进行绑定
- **builder**：包含 Configuration 对象所有构建器，主要包括 XML、注解两种方式配置解析
- **cache**：缓存功能实现、包含各种缓存装饰器
- **cursor**：实现游标的方式查询数据、游标非常适合处理百万级别的数据查询，通常情况下不适合一次性加载到内存中这种方式类似使用 SAX 解析 XML 文件
- **datasource**： 数据源包括 jndi 数据源、连接池功能
- **exceptions**：框架异常包
- **executor**：包含 SQL 语句执行器，核心功能包
- **io**：资源文件读取
- **javassist**：Java 功能增强，包含类加载、编译、代码生成等
- **jdbc**： 测试代码
- **lang**：Java 版本的注解代码。 这个包只有2个注解 @UsesJava7 @UsesJava8 使用这个两个注解标识哪些可以使用 JDK7 API 哪些可以使用 JDK8 API
- **logging**： 日志功能代码，实现多种日志框架的对接
- **mapping**：参数、结果集的映射（基本类型、结合、自定义 JavaBean）
- ognl：动态 SQL 中提供 ognl 表达式支持
- **parsing**：XML解析工具，用来解析 mapper.xml 文件
- **plugin**：拦截器功能实现，使用代理模式实现拦截
- **reflection**：类元数据、反射功能实现代码
- **scripting**： 动态 SQL 语言实现，配置文件中`<if> <where> <set> <foreach> <choose>`功能就是在这个包实现，借助 OGNL 表达式你也可以扩展自己的语言实现功能
- **session**：主要实现 SqlSession 功能，非常核心包
- **transaction**：事务功能实现，包装了数据库连接，处理数据库连接生命周期包括：连接创建，预编译，提交、回滚和关闭
- **type**：类型处理器，包括所有数据库类型对应 Java 类型的处理器，如果要实现自己类型处理器就需要实现包下的基础接口



# 5. 总结

OK，我们花了一个小节来认识 Mybatis，我们知道了 Mybatis 是一个简单灵活的 ORM 框架；了解到 Mybatis 是由 iBatis 进化而来；了解到它具有简单、易学、灵活等诸多特性；还知道了它由 ibatis-spring、mybatis-3、configuration 等组件构成；知道了它按从功能角度可以分为 接口层、数据处理层和基础支持层；最后又对其源码中的每个包的职责进行了学习。通过这一小节，我们对于 Mybatis 已经有了一个非常完整且清晰的宏观认识。你是不是迫不及待想要动手实践一下了？哈哈，别急，下一节我将会带着你用我们勤劳的双手一起撸代码，敲实例，我们下一节不见不散！

[12 数据库操作之简单到令人发指的JPA](http://www.imooc.com/read/75/article/1808)[14 为互联网而生的持久化框架-Mybatis（二）](http://www.imooc.com/read/75/article/1810)

精选留言 1

欢迎在这里发表留言，作者筛选后可公开显示

- [慕慕童鞋](http://www.imooc.com/u/8954842/articles)

  对于 MyBatis 有了更宏观的认识

   0

  回复

  2020-06-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕慕童鞋](http://www.imooc.com/u/8954842/articles)

    棒！

    回复

    2020-06-28 20:27:19

 

千学不如一看，千看不如一练

 