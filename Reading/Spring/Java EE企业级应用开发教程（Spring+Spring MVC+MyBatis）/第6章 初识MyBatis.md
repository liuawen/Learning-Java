

# 第6章 初识MyBatis

学习目标

● 了解MyBatis的基础知识

● 熟悉MyBatis的工作原理

● 掌握MyBatis入门程序的编写

MyBatis是当前主流的Java持久层框架之一，它与Hibernate一样，也**是一种ORM框架。因其性能优异，且具有高度的灵活性、可优化性和易于维护等特点**，所以受到了广大互联网企业的青睐，是目前大型互联网项目的首选框架。从本章开始，我们将对MyBatis框架的相关知识进行详细讲解。

# 

# 1、什么是MyBatis？

MyBatis简介



什么是MyBatis？

​        MyBatis（前身是iBatis）是一个支持普通SQL查询、存储过程以及高级映射的持久层框架。 

MyBatis是轻量级的Java持久层中间件，完全基于JDBC实现持久化的数据访问，支持以XML和注解的形式进行配置，能灵活、简单地进行SQL映射，也提供了比JDBC更丰富的结果集，应用程序可以从中选择对自己的数据更友好的结果集。

MyBatis采用面向对象编程的方式对数据库进行CRUD的操作，这是的应用程序中对关系数据库的操作更加方便简单。MyBatis支持使用XML描述符配置文件和注解两种方式执行SQL语句。“简单灵活”是MyBatis在对象关系映射工具上的最大优势。

最早的主流ORM（对象关系映射）框架Hibernate，对数据库结构提供了完整的封装，提供了从POJO到数据库表的全套映射机制。程序员往往只需定义POJO到数据库表的映射关系，即可通过Hibernate提供的方法完成持久层操作，不需要对SQL熟练掌握，Hibernate会根据指定的存储逻辑，自动生成对应的SQL并调用JDBC接口加以执行。这样的机制无往不利，但是，在一些特定的环境下，这种一站式的解决方案却捉襟见肘。比如下面这些的应用场景：

❑出于安全考虑，只提供特定的SQL（或存储过程）以获取所需数据，数据库具体的表结构不予公开。❑开发规范中要求，所有牵涉到业务逻辑部分的数据库操作，必须在数据库层由存储过程实现（例如，金融行业的软件有在开发规范中严格指定）。❑系统数据处理量巨大，对性能要求极为苛刻，需要高度优化SQL语句才能达到系统性能设计指标。

面对这样的需求，Hibernate的自动化SQL的方案不再适用。当然，你可以直接使用JDBC进行数据库操作，只是拖沓的数据库访问代码，乏味的字段读取操作令人厌烦。这个时候，你可能想自己封装JDBC。是的，MyBatis就是满足上面这些特定场景的已经封装好的“半自动化”ORM框架。相对Hibernate和ApacheOJB等“一站式”ORM解决方案而言，MyBatis是一种“半自动化”的ORM实现。这里的“半自动化”是相对于Hibernate等“全自动化”ORM实现而言的。“全自动化”ORM实现了POJO和数据库表之间的映射，以及SQL的自动生成和执行。而MyBatis只解决POJO与SQL之间的映射关系，并不会为程序员在运行期自动生成SQL执行。具体的SQL代码需要程序员编写，然后通过映射配置文件，将SQL所需的参数以及返回的结果字段映射到指定的POJO。

MyBatis的历史MyBatis的前身为iBatis（该名称为internet和abatis的组合）。

iBatis是由ClintonBegin在2001年发起的开源项目，在2002年被捐献给 Apache 软件基金会（Apache Software Foundation,ASF），在之后的6年中，iBatis在方法论、源码管理、社交、开源基础建设等方面都取得了很大的进步。（iBatis是一个基于Java的持久层框架，提供的持久层框架包括SQL Maps和Data AccessObjects（DAO）。）

2010年5月21日，iBatis项目组将iBatis更名为MyBatis，并搬到Google Code继续开发，版本从3.0.1一直更新到3.2.3，稳定性得到很大提升。2010年6月16日，MyBatis项目被正式归入Apache Attic，属性变为“只读”，这意味着该项目在iBatis时代正式结束。为了让更多的人参与到项目中，2013年11月10日，MyBatis项目被迁移至GitHub。

MyBatis子项目目前在 GitHub上，除了 mybatis-3核心项目，还有34个子项目，其中比较活跃的子项目如下（这里将这些子项目分为三大类）。（1）集成工具类◎ spring：支持MyBatis与Spring集成。◎ spring-boot-starter：支持MyBatis与Spring Boot集成。◎ cdi：支持MyBatis与JDK的CDI（Contexts and Dependency Injection，上下文依赖注入）集成。◎ guice：支持MyBatis与Google Guice集成。（2）缓存扩展类◎ ignite-cache：将缓存扩展到 Apache Ignite（内存组织框架）中。◎ redis-cache：将缓存扩展到 Redis缓存中。◎ memcached-cache：将缓存扩展到Memcached中。◎ caffeine-cache：将缓存扩展到Caffeine中。◎ oscache-cache：将缓存扩展到OSCache中。◎ hazelcast-cache：将缓存扩展到Hazelcast中。◎ ehcache-cache：将缓存扩展到EhCache中。◎ couchbase-cache：将缓存扩展到Couchbase中。（3）其他工具类◎ generator:MyBatis和iBatis的代码生成器。◎ mybatis-dynamic-sql：类型安全的动态SQL支持。◎ scala:Scala版本的MyBatis。◎ typeHandlers-jsr310:JSR310支持。

##  MyBatis的自身定位

MyBatis 从创建到现在，一直秉持着小而精的聚焦理念，这使其做到定位准确、轻量化、运行稳定和便于集成，并因此得到广泛应用。

## JPA持久化框架

JPA（Java Persistence API,Java持久层API）是JCP（Java CommunityProcess）组织对Java持久化数据访问的统一定义，是Java EE的标准之一，最早在JSR-220中被定义，后来作为独立的JSR规范被上升为Java SE标准。JPA提供了一套object/relational映射机制，Java开发者只需对JPA编程，再选择一种第三方的 JPA实现包集成到应用中，便能够通过 JPA 管理 Java 应用的关系型数据。所有JPA的实现都需要包含以下元素。◎ 一套持久化API：一套便捷的API能实现关系型对象的持久化。◎ 一套查询语句：不对SQL语句编程，完全面向对象编程。◎ ORM元数据管理：提供XML和Annotation形式的元数据配置。典型的JPA实现有Hibernate、Toplink、OpenJPA、Spring Data JPA等。

## MyBatis的功能

开发者可以使用MyBatis灵活多样的配置功能将应用程序中的SQL在执行前配置好。所有SQL都被放到统一的位置，这样既方便查找，又增强了可维护性。MyBatis也向开发者提供了统一的SQL执行方法，并且支持丰富的扩展定制来满足开发者的个性化需求。尽管大部分公司都会通过某种模板方法来简化JDBC访问，但事实证明MyBatis在这方面做得更好。

## MyBatis与JPA的异同

MyBatis与JPA的异同

MyBatis 从 SQL 角度切入来解释对关系型数据库的使用，重点解决 Java 数据访问与关系型数据库的SQL不一致的问题。JPA更偏向实体与关系，旨在解决Java面向对象与关系型数据库实体关系理念一致但访问接口不一致的问题。二者虽然都向应用程序提供了相似的访问方法，但出发点有所差异，我们在使用过程中会深刻体会到二者在设计理念上的不同。



​         MyBatis框架也被称之为ORM（Object/Relation Mapping，即对象关系映射）框架。所谓的ORM就是一种为了解决面向对象与关系型数据库中数据类型不匹配的技术，它通过描述Java对象与数据库表之间的映射关系，自动将Java应用程序中的对象持久化到关系型数据库的表中。

![image-20200215202910420](C:\Users\x1c\AppData\Roaming\Typora\typora-user-images\image-20200215202910420.png)

ORM框架的工作原理

MyBatis是如何工作的？

MyBatis 简介
（1）MyBatis是一个半自动映射框架，它需要用户手工匹配提供POJO、SQL和映射关系，并熟练地掌握SQL语言的编写，而不像Hibernate那种全表映射能自动地生成对应的SQL语句。

（2）MyBatis可以通过配置动态SQL并优化SQL语句来优化数据库操作性能，它还支持存储过程，而Hibernate无法做到这些。

（3）MyBatis以第三方包的形式提供，不像Hibernate本身是集成在Java EE开发的MyEclipse环境中的，故只能以.jar包的形式引入项目来使用。


加载MyBatis包
（1）访问MyBatis官网，网址为:https://github.com/mybatis/mybatis-3/releases ，

（2）下载得到文件mybatis-3.5.3.zip，解压，得到目录如图所示。


在该目录下首先看到的是MyBatis的核心包：

mybatis-3.5.3.jar

进一步点击进入lib子目录，可看到MyBatis框架的一些依赖包：

ant-1.9.6.jar
ant-launcher-1.9.6.jar
asm-5.2.jar
cglib-3.2.5.jar
commons-logging-1.2.jar
javassist-3.22.0-CR2.jar
log4j-1.2.17.jar
log4j-api-2.3.jar
log4j-core-2.3.jar
ognl-3.1.15.jar
slf4j-api-1.7.25.jar
slf4j-log4j12-1.7.25.jar


13
作为一个持久层框架，MyBatis最终还是要操作底层数据库的，故使用MyBatis的项目必然离不开数据库驱动包
————————————————

# MyBatis的下载和使用

# MyBatis的工作原理

# MyBatis入门程序