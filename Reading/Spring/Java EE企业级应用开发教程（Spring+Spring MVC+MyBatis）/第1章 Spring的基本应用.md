# Spring的基本应用



简单记录 - Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）

了解Spring的概念和优点

理解Spring中的IoC和DI思想

掌握ApplicationContext容器的使用

掌握属性setter方法注入的实现



Spring是当前主流的Java Web开发框架，它是为了解决企业应用开发的复杂性问题而产生的。

# 1、Spring概述

## 什么是Spring

什么是Spring

Spring是由Rod Johnson组织和开发的一个分层的Java SE/EEfull-stack（一站式）轻量级开源框架，它以IoC（Inversion ofControl，控制反转）和AOP（Aspect OrientedProgramming，面向切面编程）为内核，使用基本的JavaBean来完成以前只可能由EJB（Enterprise Java Beans, Java企业Bean）完成的工作，取代了EJB的臃肿、低效的开发模式。

​      在实际开发中，通常服务器端在采用三层体系架构，分别为表示层(Web)、业务逻辑层(Service)、持久层(Dao)， Spring对每一层都提供了技术支持。

Spring致力于Java EE应用各层的解决方案，

在表现层它提供了Spring MVC以及与Struts框架的整合功能；

在业务逻辑层可以管理事务、记录日志等；

在持久层可以整合MyBatis、Hibernate、JdbcTemplate等技术。

因此，可以说Spring是企业应用开发很好的“一站式”选择。虽然Spring贯穿于表现层、业务逻辑层和持久层，但它并不想取代那些已有的框架，而是以高度的开放性与它们进行无缝整合。

![image-20200213214633041](C:\Users\x1c\AppData\Roaming\Typora\typora-user-images\image-20200213214633041.png)





## Spring框架的优点

Spring具有简单、可测试和松耦合等特点，从这个角度出发，Spring不仅可以用于服务器端开发，也可以应用于任何Java应用的开发中。

Spring框架的7大优点

非侵入式设计

 方便解耦、简化开发

支持AOP

支持声明式事务处理

方便程序测试

方便集成各种优秀框架

降低Java EE API的使用难度

关于Spring框架优点的总结，具体如下。· 非侵入式设计Spring是一种非侵入式（non-invasive）框架，它可以使应用程序代码对框架的依赖最小化。· 方便解耦、简化开发Spring就是一个大工厂，可以将所有对象的创建和依赖关系的维护工作都交给Spring容器管理，大大地降低了组件之间的耦合性。· 支持AOPSpring提供了对AOP的支持，它允许将一些通用任务，如安全、事务、日志等进行集中式处理，从而提高了程序的复用性。· 支持声明式事务处理只需要通过配置就可以完成对事务的管理，而无须手动编程。· 方便程序的测试Spring提供了对Junit4的支持，可以通过注解方便地测试Spring程序。· 方便集成各种优秀框架Spring不排斥各种优秀的开源框架，其内部提供了对各种优秀框架（如Struts、Hibernate、MyBatis、Quartz等）的直接支持。· 降低Java EE API的使用难度Spring对Java EE开发中非常难用的一些API（如JDBC、JavaMail等），都提供了封装，使这些API应用难度大大降低。

## Spring的体系结构

Instrumentation



Spring框架采用的是分层架构，它一系列的功能要素被分成20个模块，这些模块大体分为Core Container、DataAccess/Integration、Web、AOP（Aspect OrientedProgramming)、Instrumentation、Messaging和Test，如图1-1所示。图1-1 Spring的体系结构

![image-20200213213053819](C:\Users\x1c\AppData\Roaming\Typora\typora-user-images\image-20200213213053819.png)

在图1-1中，包含了Spring框架的所有模块，其中，灰色背景模块为本书中所涉及的主要模块。接下来分别对体系结构中的模块作用进行简单介绍，具体如下。1.Core Container（核心容器）Spring的核心容器是其他模块建立的基础，它主要由Beans模块、Core模块、Context模块、Context-support模块和SpEL（Spring Expression Language, Spring表达式语言）模块组成，具体介绍如下。

· Beans模块：提供了BeanFactory，是工厂模式的经典实现，Spring将管理对象称为Bean。

· Core核心模块：提供了Spring框架的基本组成部分，包括IoC和DI功能。· Context上下文模块：建立在Core和Beans模块的基础之上，它是访问定义和配置的任何对象的媒介。其中ApplicationContext接口是上下文模块的焦点。· Context-support模块：提供了对第三方库嵌入Spring应用的集成支持，比如缓存（EhCache、Guava、JCache）、邮件服务（JavaMail）、任务调度（CommonJ、Quartz）和模板引擎（FreeMarker、JasperReports、速率）。· SpEL模块：是Spring 3.0后新增的模块，它提供了SpringExpression Language支持，是运行时查询和操作对象图的强大的表达式语言。

2.Data Access/Integration（数据访问/集成）数据访问/集成层包括JDBC、ORM、OXM、JMS和Transactions模块，具体介绍如下。

· JDBC模块：提供了一个JDBC的抽象层，大幅度地减少了在开发过程中对数据库操作的编码。· ORM模块：对流行的对象关系映射API，包括JPA、JDO和Hibernate提供了集成层支持。· OXM模块：提供了一个支持对象/ XML映射的抽象层实现，如JAXB、Castor、XMLBeans、JiBX和XStream。· JMS模块：指Java消息传递服务，包含使用和产生信息的特性，自4.1版本后支持与Spring-message模块的集成。· Transactions事务模块：支持对实现特殊接口以及所有POJO类的编程和声明式的事务管理。3.WebSpring的Web层包括WebSocket、Servlet、Web和Portlet模块，具体介绍如下。· WebSocket模块：Spring 4.0以后新增的模块，它提供了WebSocket和SockJS的实现，以及对STOMP的支持。· Servlet模块：也称为Spring-webmvc模块，包含了Spring的模型—视图—控制器（MVC）和REST Web Services实现的Web应用程序。· Web模块：提供了基本的Web开发集成特性，例如：多文件上传功能、使用Servlet监听器来初始化IoC容器以及Web应用上下文。· Portlet模块：提供了在Portlet环境中使用MVC实现，类似Servlet模块的功能。4．其他模块Spring的其他模块还有AOP、Aspects、Instrumentation以及Test模块，具体介绍如下。· AOP模块：提供了面向切面编程实现，允许定义方法拦截器和切入点，将代码按照功能进行分离，以降低耦合性。

· Aspects模块：提供了与AspectJ的集成功能，AspectJ是一个功能强大且成熟的面向切面编程（AOP）框架。· Instrumentation模块：提供了类工具的支持和类加载器的实现，可以在特定的应用服务器中使用。· Messaging模块：Spring 4.0以后新增的模块，它提供了对消息传递体系结构和协议的支持。· Test模块：提供了对单元测试和集成测试的支持。

## Spring的下载及目录结构

Spring的第一个版本是在2004年发布的，经过10多年的发展，Spring的版本也在不断地升级优化中。本书编写时，Spring的最新版本为4.3.6，本书的代码都是基于该版本编写实现的，建议读者也下载该版本。Spring开发所需的JAR包分为两个部分，具体如下。1.Spring框架包Spring 4.3.6版本的框架压缩包，名称为spring-framework-4.3.6.RELEASE-dist.zip，此压缩包可以通过地址“http://repo.spring.io/simple/libs-release-local/org/springframework/spring/4.3.6.RELEASE/”下载。下载完成后，将压缩包解压到自定义的文件夹中，解压后的文件目录结构如图1-2所示。

在图1-2的目录中，docs文件夹中包含Spring的API文档和开发规范；libs文件夹中包含开发需要的JAR包和源码；schema文件夹中包含开发所需要的schema文件，这些文件中定义了Spring相关配置文件的约束。打开libs目录可以看到60个JAR文件，如图1-3所示。

从图1-3可以看出，libs目录中的JAR包分为三类，其中以RELEASE.jar结尾的是Spring框架class文件的JAR包；以RELEASE-javadoc.jar结尾的是Spring框架API文档的压缩包；以RELEASE-sources.jar结尾的是Spring框架源文件的压缩包。整个Spring框架由20个模块组成，该目录下Spring为每个模块都提供了这三类压缩包。在libs目录中，有四个Spring的基础包，它们分别对应Spring核心容器的四个模块，具体介绍如下。· spring-core-4.3.6.RELEASE.jar：包含Spring框架基本的核心工具类，Spring其他组件都要用到这个包里的类，是其他组件的基本核心。· spring-beans-4.3.6.RELEASE.jar：所有应用都要用到的JAR包，它包含访问配置文件、创建和管理Bean以及进行Inversionof Control(IoC)或者Dependency Injection(DI)操作相关的所有类。· spring-context-4.3.6.RELEASE.jar:Spring提供了在基础IoC功能上的扩展服务，还提供了许多企业级服务的支持，如邮件服务、任务调度、JNDI定位、EJB集成、远程访问、缓存以及各种视图层框架的封装等。· spring-expression-4.3.6.RELEASE.jar：定义了Spring的表达式语言。

![image-20200213215453379](C:\Users\x1c\AppData\Roaming\Typora\typora-user-images\image-20200213215453379.png)

![image-20200213215508525](C:\Users\x1c\AppData\Roaming\Typora\typora-user-images\image-20200213215508525.png)



2．第三方依赖包在使用Spring开发时，除了要使用自带的JAR包外，Spring的核心容器还需要依赖commons.logging的JAR包。该JAR包可以通过网址“http://commons.apache.org/proper/commons-logging/download_logging.cgi”下载。下载完成后，会得到一个名为commons-logging-1.2-bin.zit的压缩包。将压缩包解压到自定义目录后，即可找到commons-logging-1.2.jar。初学者学习Spring框架时，只需将Spring的4个基础包以及commons-logging-1.2.jar复制到项目的lib目录，并发布到类路径中即可。

Apache Commons Logging 1.2



# 2、Spring的核心容器



简单记录 - Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）- Spring的基本应用

Spring是作为一个容器存在的，应用中的所有组件都处于Spring的管理之下，都被Spring以Bean的方式管理。

Spring负责创建Bean的实例，并管理其生命周期。

Spring框架的主要功能是通过其核心容器来实现的。

Spring有两个核心接口．分别为BeanFactory和ApplicationContext。

其中ApplicationContext是BeanFactory的子接口，它们都可代表Spring容器。也就是说Spring框架提供了两种核心容器，BeanFactory和ApplicationContext。

那容器是用来干什么的？Spring容器是生成Bean的工厂，所有的组件都被当成Bean处理，例如数据源、Hibernate的SessionFactory、事务管理器等。Bean是Spring容器的基本单位。	

Spring核心容器是由什么组成的？Spring的核心容器由Beans、Core、Context、SpEL等模块组成。所有Spring的其他模块都是建立在Core Container基础模块上的。该模块规定了创建和维护Bean的方式，提供了控制反转（IoC）和依赖注入（DI）等特性。

##  BeanFactory

Spring很少直接使用BeanFactory作为容器，因为在企业级的应用中大多数都会使用的是ApplicationContext，知道BeanFactory就行。

BeanFactory由org.springframework.beans.facytory.BeanFactory接口定义，是基础类型的IoC容器（IoC控制反转），它提供了完整的IoC服务支持。简单来说，BeanFactory就是一个管理Bean的工厂，它主要负责初始化各种Bean，并调用它们的生命周期方法。

BeanFactory接口提供了几个实现类，其中最常用的是org.springframework.beans. factory.xml.XmlBeanFactory，该类会根据XML配置文件中的定义来装配Bean。

创建BeanFactory实例时，需要提供Spring所管理容器的详细配置信息，这些信息通常采用XML文件形式来管理，其加载配置信息的语法如下。

```java
BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("D:/applicationContext.xml"));
```

D:/applicationContext.xml 是XML配置文件的位置

这种加载方式在实际开发中并不多用，知道就行。

## ApplicationContext

ApplicationContext是BeanFactory的子接口，也被称为应用上下文，是另一种常用的Spring核心容器。它由org.springframework.context. ApplicationContext接口定义，不仅包含了BeanFactory的所有功能，还添加了对国际化、资源访问、事件传播等方面的支持。

ApplicationContext和BeanFacotry两者都是用于加载Bean的，但是相比之下，Application Context提供了更多的扩展功能，简单一点说：ApplicationContext包含BeanFactory的所有功能。通常建议比BeanFactory优先，除非在一些限制的场合，比如字节长度对内存有很大的影响时（Applet）。绝大多数企业应用和系统，都是使用ApplicationContext的。

创建ApplicationContext接口实例，通常采用两种方法，具体如下。

### 1．通过ClassPathXmlApplicationContext创建

ClassPathXmlApplicationContext会从类路径classPath中寻找指定的XML配置文件，找到并装载完成ApplicationContext的实例化工作，其使用语法如下。

```java
//初始化spring容器，加载配置文件
		ApplicationContext applicationContext = 
             new ClassPathXmlApplicationContext(String configLocation);
```

```java
//初始化spring容器，加载配置文件
		ApplicationContext applicationContext = 
             new ClassPathXmlApplicationContext("applicationContext.xml");
```



上述代码中，configLocation参数用于指定Spring配置文件的名称和位置。如果其值为“applicationContext.xml”，则Spring会去类路径中查找名称为applicationContext.xml的配置文件。

   就是 ClassPathXmlApplicationContext会从类路径classPath中寻找指定的XML配置文件，找到并装载完成ApplicationContext的实例化工作。

### 2．通过FileSystemXmlApplicationContext创建

FileSystemXmlApplicationContext会从指定的文件系统路径（绝对路径）中寻找指定的XML配置文件，找到并装载完成ApplicationContext的实例化工作，其使用语法如下。

```java
初始化spring容器，加载配置文件
		ApplicationContext applicationContext = 
             new FileSystemXmlApplicationContext(String configLocation);
```



```java
初始化spring容器，加载配置文件
		ApplicationContext applicationContext = 
             new FileSystemXmlApplicationContext("applicationContext.xml");
```



与ClassPathXmlApplicationContext有所不同的是，在读取Spring的配置文件时，FileSystemXmlApplicationContext不再从类路径中读取配置文件，而是通过参数指定配置文件的位置,例如“D:/workspaces/applicationContext.xml”。如果在参数中写的不是绝对路径，那么方法调用的时候，会默认用绝对路径来找。

就是    FileSystemXmlApplicationContext会从指定的文件系统路径（绝对路径）中寻找指定的XML配置文件，找到并装载完成ApplicationContext的实例化工作。

这种采用绝对路径的方式，会导致程序的灵活性变差，所以这个方法一般不推荐使用。

在使用Spring框架时，可以通过实例化其中任何一个类来创建ApplicationContext容器。

通常在Java项目中，会采用通过ClassPathXmlApplicationContext类来实例化ApplicationContext容器的方式，而在Web项目中，ApplicationContext容器的实例化工作会交由Web服务器来完成。Web服务器实例化ApplicationContext容器时，通常会使用基于ContextLoaderListener实现的方式，此种方式只需要在web.xml中添加如下代码。

```xml
       <context-param>
               <param-name>contextConfigLocation</param-name> 
               <param-value>
                          classpath:spring/applicationContext.xml
               </param-value>
       </context-param> 
       <listener>
               <listener-class>
                         org.springframework.web.context.ContextLoaderListener
               </listener-class>
       </listener>

```



![image-20200213220946998](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-2-1.png)

三大框架整合以及项目时，将采用基于ContextLoaderListener的方式由Web服务器实例化ApplicationContext容器。

创建Spring容器后，就可以获取Spring容器中的Bean。Spring获取Bean的实例通常采用以下两种方法。

* Object getBean(String name)：

  根据容器中Bean的id或name来获取指定的Bean，获取之后需要进行强制类型转换。

* <T> T getBean(Class<T> requiredType)：

  根据类的类型来获取Bean的实例。由于此方法为泛型方法，因此在获取Bean之后不需要进行强制类型转换。

提示：BeanFactory和ApplicationContext两种容器都是通过XML配置文件加载Bean的。二者的主要区别在于，如果Bean的某一个属性没有注入，使用BeanFacotry加载后，在第一次调用getBean()方法时会抛出异常，而ApplicationContext则在初始化时自检，这样有利于检查所依赖属性是否注入。因此，在实际开发中，通常都优先选择使用ApplicationContext，而只有在系统资源较少时，才考虑使用BeanFactory。

# 3、创建一个Spring的入门程序

简单记录 -  Spring5企业级开发实战 周冠亚，黄文毅著

Spring使用场景

（1）管理依赖的资源在企业开发中，经常需要管理各种配置文件，如JDBC连接配置文件，ORM配置文件等。可以通过Spring管理这些文件。如加载JDBC的配置文件jdbc.properties就可以使用如下代码方式配置Spring，这样Spring启动时会在此路径下自动搜索名称为jdbc.properties的配置文件，并将其加载到内存中：

```
<context:property-placeholder location="classpath*:jdbc.properties"/>
```



（2）Bean管理一个企业项目中，会有很多Bean，每次都手动创建和管理这些Bean的对象是很低效的。Spring提供了管理Bean的IoC容器，并在需要用到相关Bean的时候，提供依赖注入（DI）将相关的Bean注入。

（3）事务管理Spring提供的事务管理，使开发人员在做数据库操作时，无须再手动执行对数据库的提交或回滚操作，并且Spring还提供了对事务传播的支持，可以实现更加复杂的事务嵌套的逻辑，对数据一致性提供了更好的支持。等等

Spring与Spring MVC的关系Spring和Spring MVC两者名字类似，但是两者却有着本质的不同。Spring是一个巨大的容器，可以集成各种技术。Spring MVC是一个Web技术，Spring MVC可以集成到Spring中。用数学上集合的概念来解释，Spring MVC是Spring的一个子集。



创建一个空白maven项目来实现Spring的入门程序

![image-20200214114452904](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-3-1.png)

![image-20200214114717119](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-3-2.png)

在这个项目中，创建一个名为chapter01的Web项目Module

![image-20200214114912515](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-3-3.png)



![image-20200214115014652](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-3-4.png)



![image-20200214115045897](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-3-5.png)



手动导入Jar包(注 : spring 需要导入commons-logging进行日志记录 . )

但我们可以利用maven , 他会自动下载对应的依赖项 .

pom.xml

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.23.RELEASE</version>
</dependency>
```

https://repo.spring.io/release/org/springframework/spring/



![image-20200214115542713](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-3-6.png)



chapter01目录结构

![image-20200214123120033](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-3-7.png)



（2）在src/main/java目录下，创建一个com.awen.ioc包，并在包中创建接口UserDao，然后在接口中定义一个say()方法，代码如下所示。

```java
package com.awen.ioc;

/**
 * @author Liu Awen 
 */
public interface UserDao {
    public void say();
}

```

（3）在com.awen.ioc包下，创建UserDao接口的实现类UserDaoImpl，该类需要实现接口中的say()方法，并在方法中编写一条输出语句，代码如下所示。

```java
package com.awen.ioc;

/**
 * @author Liu Awen
 */
public class UserDaoImpl implements  UserDao{
    public void say(){
        System.out.println("userDao say hello World!");
    }
}

```



（4）在src/main/resources目录下，创建Spring的配置文件applicationContext.xml，并在配置文件中创建一个id为userDao的bean，如文件所示。文件 applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--将指定类配置给Spring，让Spring创建其对象的实例    -->
    <bean id="userDao" class="com.awen.ioc.UserDaoImpl"></bean>
</beans>
```



在文件 applicationContext.xml中，前面几行代码是Spring的约束配置。该配置信息不需要手写，我们可以去Spring官网找

https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-basics

![image-20200214124805974](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-3-8.png)



也可以在Spring的帮助文档中找到。

快速获取配置文件的约束信息在Spring的配置文件中，包含了很多约束信息，如果自己动手去编写，不但浪费时间，还容易出错。其实，在Spring的帮助文档中，就可以找到这些约束信息，具体的获取方法如下。打开Spring解压文件夹中的docs目录，在spring-framework-reference文件夹下打开html文件夹，并找到index.html文件，如图所示。

![image-20200214124039642](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-3-9.png)

图Spring的参考文件目录

使用浏览器打开index.html后，点击Core

![image-20200214125002679](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-3-10.png)



在浏览器页面的下的1.2.1. 小节Configuration Metadata中，即可找到配置文件的约束信息，如图所示。

![image-20200214125254273](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-3-11.png)

配置文件的约束信息在图中，标记处的配置信息就是Spring配置文件的约束信息。我们只需将标注处的信息复制到项目的配置文件中使用即可。



第7行代码表示在Spring容器中创建一个id为userDao的Bean实例，其中class属性用于指定需要实例化Bean的类。



（5）在src/test/java下，创建测试类TestIoC，并在类中编写main()方法。在main()方法中，需要初始化Spring容器，并加载配置文件，然后通过Spring容器获取userDao实例（即Java对象），最后调用实例中的say()方法，如文件所示。文件 TestIoC.java

```java
import com.awen.ioc.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Liu Awen 
 */
public class TestIoC {
    public static void main(String[] args) {
        // 1. 初始化Spring容器，加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 通过容器获取userDao实例
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        // 3.调用实例中的say()方法
        userDao.say();
    }
}

```



执行程序后，控制台的输出结果如图所示。

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=8142:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter01\target\test-classes;D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter01\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\junit\junit\4.11\junit-4.11.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar TestIoC
userDao say hello World!

Process finished with exit code 0

```



从运行结果可以看出，控制台已成功输出了UserDaoImpl类中的输出语句。userDao say hello World!

在TestIoc的main()方法中，并没有通过new关键字来创建UserDao接口的实现类对象，而是通过Spring容器来获取的实现类对象，这就是Spring IoC容器的工作机制。

Spring容器来完成。

问题：

```bash
Exception in thread "main" java.lang.ClassCastException: class com.awen.ioc.UserDaoImpl cannot be cast to class com.awen.ioc.UserDao (com.awen.ioc.UserDaoImpl and com.awen.ioc.UserDao are in unnamed module of loader 'app')
	at com.awen.ioc.TestIoC.main(TestIoC.java:13)
```

```java
public class UserDaoImpl {
    public void say(){
        System.out.println("userDao say hello World!");
    }
}
```



解决原来是我写UserDaoImpl没有implements UserDao接口 ， 那就加上吧。

```java
public class UserDaoImpl implements  UserDao{
    public void say(){
        System.out.println("userDao say hello World!");
    }
}
```

# 4、依赖注入

当某个Java对象（调用者）需要调用另一个Java对象（被调用者，即被依赖对象）时，在传统模式下，调用者通常会采用“new被调用者”的代码方式来创建对象，如图1-8所示。这种方式会导致调用者与被调用者之间的耦合性增加，不利于后期项目的升级和维护。

图1-8 调用者创建被调用者对象

![image-20200214131549927](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-4-1.png)

在使用Spring框架之后，对象的实例不再由调用者来创建，而是由Spring容器来创建，Spring容器会负责控制程序之间的关系，而不是由调用者的程序代码直接控制。这样，**控制权由应用代码转移到了Spring容器**，控制权发生了反转，这就是Spring的控制反转。

从Spring容器的角度来看，Spring容器负责将被依赖对象赋值给调用者的成员变量，这相当于为调用者注入了它依赖的实例，这就是Spring的依赖注入，如图1-9所示。

图1-9 将被调用者对象注入调用者对象

![image-20200214131708607](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\1-4-2.png)

1.4.2 依赖注入的实现方式依赖注入的作用就是在使用Spring框架创建对象时，动态地将其所依赖的对象注入Bean组件中，其实现方式通常有两种，一种是属性setter方法注入，另一种是构造方法注入，具体介绍如下。· 属性setter方法注入：指IoC容器使用setter方法注入被依赖的实例。通过调用无参构造器或无参静态工厂方法实例化Bean后，调用该Bean的setter方法，即可实现基于setter方法的依赖注入。· 构造方法注入：指IoC容器使用构造方法注入被依赖的实例。基于构造方法的依赖注入通过调用带参数的构造方法来实现，每个参数代表着一个依赖。了解了两种注入方式后，下面以属性setter方法注入的方式为例，讲解一下Spring容器在应用中是如何实现依赖注入的。（1）在com.itheima.ioc包中，创建接口UserService，在接口中编写一个say()方法，如文件1-5所示。

文件1-5 UserService.java

2）在com.itheima.ioc包中，创建UserService接口的实现类UserServiceImpl，在类中声明userDao属性，并添加属性的setter方法，如文件1-6所示。文件1-6 UserServiceImpl.java

（3）在配置文件applicationContext.xml中，创建一个id为userService的Bean，该Bean用于实例化UserServiceImpl类的信息，并将userDao的实例注入到userService中，其代码如下所示。

在上述代码中，<property>是<bean>元素的子元素，它用于调用Bean实例中的setUserDao()方法完成属性赋值，从而实现依赖注入。其name属性表示Bean实例中的相应属性名，ref属性用于指定其属性值。（4）在com.itheima.ioc包中，创建测试类TestDI，来对程序进行测试，编辑后如文件1-7所示。

（4）在com.itheima.ioc包中，创建测试类TestDI，来对程序进行测试，编辑后如文件1-7所示。文件1-7 TestDI.java

（5）执行程序后，控制台的输出结果如图1-10所示。[插图]图1-10 运行结果从图1-10可以看出，使用Spring容器通过UserService实现类中的say()方法，调用了UserDao实现类中的say()方法，并输出了结果。这就是Spring容器属性setter注入的方式，也是实际开发中最为常用的一种方式。

# 5、本章小结

本章主要讲解了Spring框架入门的一些基础知识。首先讲解了Spring框架的概念、作用、优点、体系结构以及如何下载和下载后的目录结构，然后介绍了Spring的两种核心容器。接下来通过一个入门程序来讲解如何使用Spring框架。最后详细讲解了依赖注入和控制反转的概念，并演示了依赖注入中setter方法注入的实现。通过本章的学习，读者可以对Spring框架及其体系结构有一个初步的了解，能够初步地掌握Spring框架的使用，并能够理Spring框架中IoC和DI的思想，掌握属性setter方法注入的实现。【思考题】1．请简述Spring框架的优点。2．请简述什么是Spring的IoC和DI。

