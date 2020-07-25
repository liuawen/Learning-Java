# 第5章 Spring的事务管理



学习目标

● 熟悉Spring事务管理的3个核心接口

● 了解Spring事务管理的两种方式

● 掌握基于XML和Annotation的声明式事务的使用

通过上一章的学习，读者已经掌握了如何使用Spring来操作数据库，但是在实际开发中，操作数据库时还会涉及事务管理问题，为此Spring提供了专门用于事务处理的API。Spring的事务管理简化了传统的事务管理流程，并且在一定程度上减少了开发者的工作量。本章将针对Spring的事务管理功能进行详细讲解。

事务管理

Spring提供的事务管理，使开发人员在做数据库操作时，无须再手动执行对数据库的提交或回滚操作，并且Spring还提供了对事务传播的支持，可以实现更加复杂的事务嵌套的逻辑，对数据一致性提供了更好的支持。

　Spring事务管理

数据库事务（Database Transaction）是指将一系列数据库操作当作一个逻辑处理单元的操作，这个单元中的数据库操作要么完全执行，要么完全不执行。通过将一组相关操作组合为一个逻辑处理单元，可以简化错误恢复，并使应用程序更加可靠。



# Spring事务管理概述

Spring 3.0就这么简单作者：称雄华,林开雄

Spring虽然提供了灵活方便的事务管理功能，但这些功能都是基于底层数据库本身的事务处理机制工作的。

要想深入了解Spring的事务管理和配置，就非常有必要先学习数据库事务的基础知识。

## 数据库事务

那什么是数据库事务呢？

先了解下事务思想吧。

事务的思想：

很多复杂的事物要分步进行（复杂的东西经常拆分），但它们组成一个整体，要么整体生效，要么整体失效。这种思想反映到数据库上，就是多个SQL语句，要么所有执行成功，要么所有执行失败。

数据库事务：

数据库事务（Database Transaction）是指将一系列数据库操作当作一个逻辑处理单元的操作，**这个单元中的数据库操作要么完全执行，要么完全不执行。**通过将一组相关操作组合为一个逻辑处理单元，可以简化 错误恢复，并使应用程序更加可靠。

一个逻辑处理单元要成为事务，必须满足ACID属性。（原子性Atomic、一致性Consistency、隔离性Isolation和持久性Durabiliy），所谓的ACID含义如下。

* 原子性（Atomicity）：表示组成一个事务的多个数据库操作是一个不可分割的原子单元，只有所有的操作执行成功，整个事务才提交，事务中任何一个数据库操作失败，已经执行的任何操作都必须撤销，让数据库返回到初始状态。也就是一个事务内的操作，要么全部执行成功，要么全部执行不成功。
* 一致性（Consistency）：事务执行后，数据库所处的状态和它的业务规则是一致的，即数据不会被破坏。如转账业务，无论事务执行成功与否，参与转账的两个账号余额之和应该是不变的（两人的钱总额是不变的。）。
* 　隔离性（Isolation）：在并发数据操作时，不同的事务拥有各自的数据空间，它们的操作不会对对方产生干扰。准确地说，并非要求做到完全无干扰，数据库规定了多种事务隔离级别，不同隔离级别对应不同的干扰程度，**隔离级别越高，数据一致性越好，但并发性越弱。**每个事务独立运行。在并发环境中，并发的事务是互相隔离的，互不影响。
* 持久性（Durability）：一旦事务提交成功后，事务中所有的数据操作都必须被持久化到数据库中，即使提交事务后，数据库马上崩溃，在数据库重启时，也必须保证能够通过某种机制恢复数据。也就是事务一旦提交后，数据库中的数据必须被永久地保存下来。

在这些事务特性中，数据“一致性”是最终目标，其他的特性都是达到这个目标的措施、要求或手段。

数据库管理系统一般采用重执行日志保证原子性、一致性和持久性，重执行日志记录了数据库变化的每一个动作，数据库在一个事务中执行一部分操作后发生错误退出，数据库即可以根据重执行日志撤销已经执行的操作。此外，对于已经提交的事务，即使数据库崩溃，在重启数据库时也能够根据日志对尚未持久化的数据进行相应的重执行操作。

和Java程序采用对象锁机制进行线程同步类似，数据库管理系统采用数据库锁机制保证事务的隔离性。**当多个事务试图对相同的数据进行操作时，只有持有锁的事务才能操作数据，直到前一个事务完成后，后面的事务才有机会对数据进行操作**。Oracle数据库还使用了数据版本的机制，在回滚段为数据的每个变化都保存一个版本，使数据的更改不影响数据的读取。

## 什么是Spring的事务管理？

那什么是Spring的事务管理？

​    在实际开发中，操作数据库时都会涉及到事务管理问题，为此Spring提供了专门用于事务处理的API。Spring的事务管理简化了传统的事务管理流程，并且在一定程度上减少了开发者的工作量。具体来说就是Spring提供的事务管理，使开发人员在做数据库操作时，无须再手动执行对数据库的提交或回滚操作，并且Spring还提供了对事务传播的支持，可以实现更加复杂的事务嵌套的逻辑，对数据一致性提供了更好的支持。

Spring事务管理

## Spring对事务管理的支持

Spring对事务管理的支持

Spring为事务管理提供了一致的编程模板，在高层次建立了统一的事务抽象。也就是说，不管选择Spring JDBC、Hibernate、JPA，还是MyBatis，**Spring都让用户可以用统一的编程模型进行事务管理**。

像Spring DAO为不同的持久化实现提供了模板类一样，Spring事务管理继承了这一风格，也提供了**事务模板类TransactionTemplate**。通过事务模板类TransactionTemplate并配合使用事务回调TransactionCallback指定具体的持久化操作就可以通过编程方式实现事务管理，而无须关注资源获取、复用、释放、事务同步和异常处理的操作。

Spring事务管理的亮点在于声明式事务管理。Spring允许通过声明方式，在IoC配置中指定事务的边界和事务属性，Spring自动在指定的事务边界上应用事务属性。声明式事务是EJB赫一时的技术，Spring让这种技术平民化，甚至可以说，Spring的声明事务比EJB的更为强大。

EJB事务建立在JTA的基础上，而JTA又必须通过JNDI获取，这意味着，不管用户的应用是跨数据源的应用，还是单数据源的应用，EJB都要求使用全局事务的方式加以处理，这意味着基于EJB的应用无法脱离应用服务器所提供的容器环境。这种不加区分一概而论的做法无异于杀鸡杀牛都用一把宰牛刀。

Spring深刻地认识到：大部分应用都基于单数据源，只有为数不多的应用需要使用到多数据源的JTA事务。因此，**在单数据源的情况下，Spring直接使用底层的数据源管理事务**。在面对多数据源的应用时，Spring才寻求Java EE应用服务器的支持，通过引用应用服务器中的JNDI资源完成JTA事务。**Spring让人印象深刻的地方在于不管用户使用何种持久化实现技术，也不管用户是否使用了JTA事务，都可以采用相同事务管理模型。**

这种统一的处理方式所带来的好处是不可估量的：**用户完全可以抛开事务管理的问题编写程序，并在Spring中通过配置完成事务的管理工作。**

## Spring事务管理的核心接口

在Spring的所有JAR包中，包含一个名为spring-tx-5.2.3.RELEASE的JAR包，该包就是Spring提供的用于事务管理的依赖包。在该JAR包的org.springframework.transaction包中，有3个接口文件PlatformTransactionManager、TransactionDefinition和TransactionStatus

![image-20200215141847921](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\5-1-1.png)

Spring事务管理的三个核心接口

1.PlatformTransactionManager

2.TransactionDefinition

3.TransactionStatus

TransactionDefinition用于描述事务的隔离级别、超时时间、是否为只读事务和事务传播规则等控制事务具体行为的事务属性，这些事务属性可以通过XML配置或注解描述提供，也可以通过手工编程的方式设置。PlatformTransactionManager根据TransactionDefinition提供的事务属性配置信息，创建事务，并用TransactionStatus描述这个激活事务的状态。下面分别介绍这些SPI（Service Provider Interface）接口内部的组成。



https://docs.spring.io/spring/docs/current/javadoc-api/

### Platform TransactionManager

​         PlatformTransactionManager接口是Spring提供的平台事务管理器，主要用于管理事务。该接口中提供了三个事务操作的方法，具体如下：

TransactionStatus getTransaction(TransactionDefinition definition);

该方法根据事务定义信息从事务环境中返回一个已存在的事务，或者创建一个新的事务，并用TransactionStatus描述这个事务的状态。（用于获取事务状态信息）

void commit(TransactionStatus status);

根据事务的状态提交事务，如果事务状态已经被标识为rollback-only，该方法将执行一个回滚事务的操作。（用于提交事务）

void rollback(TransactionStatus status);将事务回滚。当commit()方法抛出异常时，rollback()会被隐式调用。（用于回滚事务）

在上面的3个方法中，getTransaction（TransactionDefinition definition）方法会根据TransactionDefinition参数返回一个TransactionStatus对象，TransactionStatus对象就表示一个事务，它被关联在当前执行的线程上。



​     PlatformTransactionManager接口只是代表事务管理的接口，并不知道底层是如何管理事务的，具体如何管理事务则由它的实现类来完成。该接口常见的几个实现类如下：

常用接口实现类

org.springframework.jdbc.datasource.DataSourceTransactionManager

用于配置JDBC数据源的事务管理器

org.springframework.orm.hibernate4.HibernateTransactionManager

用于配置Hibernate的事务管理器

org.springframework.transaction.jta.JtaTransactionManager

用于配置全局事务管理器

**提示**：当底层采用不同的持久层技术时，系统只需使用不同的PlatformTransactionManager实现类即可。

### TransactionDefinition



​     TransactionDefinition接口是事务定义（描述）的对象，该对象中定义了事务规则，并提供了获取事务相关信息的方法，具体如下：

String getName( );           获取事务对象名称

int getIsolationLevel( );       获取事务的隔离级别

int getPropagationBehavior( );  获取事务的传播行为

int getTimeout( );            获取事务的超时时间

boolean isReadOnly( );       获取事务是否只读

​    上述方法中，事务的传播行为是指在同一个方法中，不同操作前后所使用的事务。传播行为有很多种，具体如下表所示：

![image-20200215142642058](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\5-1-2.png)



​    在事务管理过程中，传播行为可以控制是否需要创建事务以及如何创建事务，通常情况下，数据的查询不会影响原数据的改变，所以不需要进行事务管理，而对于数据的插入、更新和删除操作，必须进行事务管理。如果没有指定事务的传播行为，Spring默认传播行为是REQUIRED。

### TransactionStatus

TransactionStatus接口是事务的状态，它描述了某一时间点上事务的状态信息。事务管理器通过该接口获取事务运行期的状态信息，也可以通过该接口间接地回滚事务，它相比于在抛出异常时回滚事务的方式更具可控性。该接口继承于SavepointManager接口，SavepointManager接口基于JDBC 3.0保存点的分段事务控制能力提供了嵌套事务的机制。

该接口中包含6个方法，具体如下。

void flush();              刷新事务

boolean hasSavepoint();     获取是否存在保存点

boolean isCompleted();      获取事务是否完成

boolean isNewTransaction(); 获取是否为新事务，如果返回false，表示当前事务是一个已经存在的事务，或者当前操作未运行在事务环境中。

boolean isRollbackOnly();   获取事务是否回滚

void setRollbackOnly();     设置事务回滚，将当前的事务设置为rollback-only。通过该标识通知事务管理器只能将事务回滚，事务管理器将通过显式调用回滚命令或抛出异常的方式回滚事务。

事务管理的方式

# 声明式事务管理



数据访问的技术很多，如JDBC、JPA、Hibernate、分布式事务等。面对众多的数据访问技术，Spring在不同的事务管理API上定义了一个抽象层PlatformTransaction-Manager，应用程序开发人员不必了解底层的事务管理API就可以使用Spring的事务管理机制。Spring并不直接管理事务，而是提供了许多内置事务管理器实现，常用的有DataSourceTransactionManager、JdoTransactionManager、JpaTransactionManager以及HibernateTransactionManager等。

声明式事务管理

Spring作为企业级应用程序框架，在不同的事务管理API上定义了一个抽象层，使应用程序开发人员不必了解底层的事务管理API，就可以使用Spring的事务管理机制。

Spring事务管理分两种方式，一种是传统的编程式事务管理（也称编码式事务），另一种是声明式事务管理。

编程式事务管理

通过编写代码实现的事务管理，包括定义事务的开始、正常执行后的事务提交和异常时的事务回滚。编程式事务管理是将事务管理代码嵌入业务方法中来控制事务的提交和回滚。在编程式事务中，必须在每个业务操作中包含额外的事务管理代码。

声明式事务管理

声明式事务管理是指将事务管理代码从业务方法中分离出来，以声明的方式来实现事务管理。在大多数情况下，声明式事务管理比编程式事务管理更好用。Spring是通过AOP框架技术支持实现的事务管理，主要思想是将事务作为一个“切面”代码单独编写，然后通过AOP技术将事务管理的“切面”植入到业务目标类中。

Spring的声明式事务管理底层是建立在AOP基础上的，其本质是对方法前后进行拦截，然后在目标方法开始之前创建或加入一个事务，在执行完毕之后根据执行情况提交或回滚事务。

Spring事务管理的亮点在于声明式事务管理。Spring允许通过声明方式，在IoC配置中指定事务的边界和事务属性，Spring自动在指定的事务边界上应用事务属性。

 	声明式事务管理最大的优点在于开发者无需通过编程的方式来管理事务，**只需在配置文件中进行相关的事务规则声明，就可以将事务应用到业务逻辑中**。这使得开发人员可以更加专注于核心业务逻辑代码的编写，在一定程度上减少了工作量，提高了开发效率，所以在实际开发中，通常都推荐使用声明式事务管理。



如何实现Spring的声明式事务管理？

​           Spring的声明式事务管理可以通过两种方式来实现，一种是基于XML的方式，另一种是基于Annotation的方式。

## 基于XML方式的声明式事务

​    基于XML方式的声明式事务是在配置文件中通过`<tx:advice>`元素配置事务规则来实现的。当配置了事务的增强处理后，就可以通过编写的AOP配置，让Spring自动对目标生成代理。

配置`<tx:advice>`元素时，通常需要指定id和transaction-manager属性，其中id属性是配置文件中的唯一标识，transaction-manager属性用于指定事务管理器。除此之外，还需要配置一个<tx:attributes>子元素，该子元素可通过配置多个<tx:method>子元素来配置执行事务的细节

<tx:advice>元素及其子元素如下图所示：

![image-20200215161605873](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\5-2-1.png)

​    配置<tx:advice>元素的重点是配置<tx:method>子元素，上图中使用灰色标注的几个属性是<tx:method>元素中的常用属性。其属性描述具体如下：

![image-20200215161615759](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\5-2-2.png)

name 指定对哪些方法起作用

propagation指定事务的传播行为

isolation指定事务的隔离级别

read-only指定事务是否只读

了解了如何在XML文件中配置事务后，接下来通过一个案例来演示如何通过XML方式来实现Spring的声明式事务管理。这里是按照Spring的数据库开发，chapter04的项目代码和数据表为基础（代码在Spring的数据库开发的博客里），编写的一个模拟银行转账的程序，要求在转账时通过Spring对事务进行控制，其具体实现步骤如下。**案例代码**

（1）在Idea中，在JavaEE-enterprise-application-development-tutorial项目里，创建一个名为chapter05的Maven项目module，导入AOP的依赖



（2）将Spring的数据库开发chapter04项目中的代码和配置文件复制到chapter05项目的java和resources目录下，并在AccountDao接口中，创建一个转账方法transfer()，其代码如下所示。

```java
// 转账
	public void transfer(String outUser, String inUser, Double money);
```

（3）在其实现类AccountDaoImpl中实现transfer()方法，编辑后的代码如下所示。

```java
/**
	 *  转账
	 *  inUser：收款人
	 *  outUser：汇款人
	 *  money：收款金额
	*/
	public void transfer(String outUser, String inUser, Double money) {
	    // 收款时，收款用户的余额=现有余额+所汇金额
	    this.jdbcTemplate.update("update account set balance = balance +? "
	            + "where username = ?",money, inUser);
	    // 模拟系统运行时的突发性问题
	    int i = 1/0;
	    // 汇款时，汇款用户的余额=现有余额-所汇金额
	    this.jdbcTemplate.update("update account set balance = balance-? "
	            + "where username = ?",money, outUser);
	}
```

在上述代码中，使用了两个update()方法对account表中的数据执行收款和汇款的更新操作。在两个操作之间，添加了一行代码“int i = 1/0; ”来模拟系统运行时的突发性问题。如果没有事务控制，那么在转账操作执行后，收款用户的余额会增加，而汇款用户的余额会因为系统出现问题而不变，这显然是有问题的；如果增加了事务控制，那么在转账操作执行后，收款用户的余额和汇款用户的余额在问题出现前后都应该保持不变。

（4）修改配置文件applicationContext.xml，添加命名空间并编写事务管理的相关配置代码，如文件所示。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:tx="http://www.springframework.org/schema/tx" 
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/tx 
    http://www.springframework.org/schema/tx/spring-tx-4.3.xsd
    http://www.springframework.org/schema/context 
    http://www.springframework.org/schema/context/spring-context-4.3.xsd
    http://www.springframework.org/schema/aop 
    http://www.springframework.org/schema/aop/spring-aop-4.3.xsd">
    <!-- 1.配置数据源 -->
    <bean id="dataSource" 
    class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<!--数据库驱动 -->
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<!--连接数据库的url -->
		<property name="url" value="jdbc:mysql://localhost/spring?useSSL=false" />
		<!--连接数据库的用户名 -->
		<property name="username" value="root" />
		<!--连接数据库的密码 -->
		<property name="password" value="123456" />
   </bean>
   <!-- 2.配置JDBC模板 -->
   <bean id="jdbcTemplate" 
          class="org.springframework.jdbc.core.JdbcTemplate">
		 <!-- 默认必须使用数据源 -->
		 <property name="dataSource" ref="dataSource" />
   </bean>
   <!--3.定义id为accountDao的Bean -->
   <bean id="accountDao" class="com.awen.jdbc.AccountDaoImpl">
		 <!-- 将jdbcTemplate注入到AccountDao实例中 -->
		 <property name="jdbcTemplate" ref="jdbcTemplate" />
   </bean>	
   <!-- 4.事务管理器，依赖于数据源 -->
   <bean id="transactionManager" class=
   "org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" />
   </bean>	
   <!-- 5.编写通知：对事务进行增强(通知),需要编写对切入点和具体执行事务细节 -->
   <tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<!-- name：*表示任意方法名称 -->
			<tx:method name="*" propagation="REQUIRED" 
                           isolation="DEFAULT" read-only="false" />
		</tx:attributes>
	</tx:advice>
	<!-- 6.编写aop，让spring自动对目标生成代理，需要使用AspectJ的表达式 -->
	<aop:config>
		<!-- 切入点 -->
		<aop:pointcut expression="execution(* com.itheima.jdbc.*.*(..))"
			id="txPointCut" />
		<!-- 切面：将切入点与通知整合 -->
		<aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut" />
	</aop:config>
</beans>

```

在文件applicationContext.xml中，首先启用了Spring配置文件的aop、tx和context 3个命名空间（从配置数据源到声明事务管理器的部分都没有变化），然后定义了id为transactionManager的事务管理器，接下来通过编写的通知来声明事务，最后通过声明AOP的方式让Spring自动生成代理。

（5）在com.awen.jdbc包中，创建测试类TransactionTest，并在类中编写测试方法xmlTest()，如文件所示。文件TransactionTest.java

```java
package com.awen.jdbc;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import 
org.springframework.context.support.ClassPathXmlApplicationContext;
//测试类
public class TransactionTest {
	@Test
	public void xmlTest(){
		ApplicationContext applicationContext = 
		   new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取AccountDao实例
		AccountDao accountDao = 
            (AccountDao)applicationContext.getBean("accountDao");
		// 调用实例中的转账方法
		accountDao.transfer("柳小子", "柳狗柱", 5000.0);
	    // 输出提示信息
	    System.out.println("转账成功！");
	}
	
	

}

```

在文件TransactionTest.java中，获取了AccountDao实例后，调用了实例中的转账方法，由柳小子向柳狗柱的账户中转入100元。如果在配置文件中所声明的事务代码能够起作用，那么在整个转账方法执行完毕后，柳小子和柳狗柱的账户余额应该都是原来的数值。在执行转账操作前，先查看account表中的数据，如图所示。

![image-20200215175040916](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\5-2-3.png)

 account表从图可以看出，此时柳小子的账户余额是10000，而柳狗柱的账户余额是500。执行完文件TransactionTest.java中的测试方法后，Junit的控制台的显示结果如图所示

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=3594:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit5-rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit-rt.jar;D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter05\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jdbc\5.2.3.RELEASE\spring-jdbc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-tx\5.2.3.RELEASE\spring-tx-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;D:\Environments\apache-maven-3.6.2\maven-repo\junit\junit\4.12\junit-4.12.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\Environments\apache-maven-3.6.2\maven-repo\mysql\mysql-connector-java\5.1.47\mysql-connector-java-5.1.47.jar com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 com.awen.jdbc.TransactionTest,xmlTest
2月 15, 2020 5:51:57 下午 org.springframework.context.support.AbstractApplicationContext refresh
警告: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dataSource' defined in class path resource [applicationContext.xml]: BeanPostProcessor before instantiation of bean failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor#0': Cannot resolve reference to bean 'txPointCut' while setting bean property 'pointcut'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'txPointCut': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.aop.aspectj.AspectJExpressionPointcut]: No default constructor found; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dataSource' defined in class path resource [applicationContext.xml]: BeanPostProcessor before instantiation of bean failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor#0': Cannot resolve reference to bean 'txPointCut' while setting bean property 'pointcut'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'txPointCut': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.aop.aspectj.AspectJExpressionPointcut]: No default constructor found; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException

	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:512)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:323)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:321)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:879)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:878)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:550)
	at org.springframework.context.support.ClassPathXmlApplicationContext.<init>(ClassPathXmlApplicationContext.java:144)
	at org.springframework.context.support.ClassPathXmlApplicationContext.<init>(ClassPathXmlApplicationContext.java:85)
	at com.awen.jdbc.TransactionTest.xmlTest(TransactionTest.java:10)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor#0': Cannot resolve reference to bean 'txPointCut' while setting bean property 'pointcut'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'txPointCut': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.aop.aspectj.AspectJExpressionPointcut]: No default constructor found; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException
	at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveReference(BeanDefinitionValueResolver.java:342)
	at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveValueIfNecessary(BeanDefinitionValueResolver.java:113)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1699)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1444)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:594)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:517)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:323)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:321)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:207)
	at org.springframework.aop.framework.autoproxy.BeanFactoryAdvisorRetrievalHelper.findAdvisorBeans(BeanFactoryAdvisorRetrievalHelper.java:91)
	at org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator.findCandidateAdvisors(AbstractAdvisorAutoProxyCreator.java:109)
	at org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator.shouldSkip(AspectJAwareAdvisorAutoProxyCreator.java:101)
	at org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.postProcessBeforeInstantiation(AbstractAutoProxyCreator.java:251)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInstantiation(AbstractAutowireCapableBeanFactory.java:1141)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.resolveBeforeInstantiation(AbstractAutowireCapableBeanFactory.java:1114)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:506)
	... 32 more
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'txPointCut': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.aop.aspectj.AspectJExpressionPointcut]: No default constructor found; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1320)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1214)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:557)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:517)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:341)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
	at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveReference(BeanDefinitionValueResolver.java:330)
	... 48 more
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.aop.aspectj.AspectJExpressionPointcut]: No default constructor found; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:83)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1312)
	... 54 more
Caused by: java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException
	at java.base/java.lang.Class.getDeclaredConstructors0(Native Method)
	at java.base/java.lang.Class.privateGetDeclaredConstructors(Class.java:3138)
	at java.base/java.lang.Class.getConstructor0(Class.java:3343)
	at java.base/java.lang.Class.getDeclaredConstructor(Class.java:2554)
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:78)
	... 55 more
Caused by: java.lang.ClassNotFoundException: org.aspectj.weaver.reflect.ReflectionWorld$ReflectionWorldException
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:583)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
	... 60 more


Process finished with exit code -1

```

应该是没导入AOP的依赖包

导入

```xml
<!-- AOP begin -->
<dependency>
<groupId>org.aspectj</groupId>
<artifactId>aspectjrt</artifactId>
<version>1.7.4</version>
</dependency>
<dependency>
<groupId>org.aspectj</groupId>
<artifactId>aspectjweaver</artifactId>
<version>1.7.4</version>
</dependency>
<dependency>
<groupId>cglib</groupId>
<artifactId>cglib</artifactId>
<version>3.1</version>
</dependency>
<!-- AOP end -->
```

不是这个错了

运行结果

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=3730:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit5-rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit-rt.jar;D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter05\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jdbc\5.2.3.RELEASE\spring-jdbc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-tx\5.2.3.RELEASE\spring-tx-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;D:\Environments\apache-maven-3.6.2\maven-repo\junit\junit\4.12\junit-4.12.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\Environments\apache-maven-3.6.2\maven-repo\mysql\mysql-connector-java\5.1.47\mysql-connector-java-5.1.47.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\aspectj\aspectjrt\1.7.4\aspectjrt-1.7.4.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\aspectj\aspectjweaver\1.7.4\aspectjweaver-1.7.4.jar;D:\Environments\apache-maven-3.6.2\maven-repo\cglib\cglib\3.1\cglib-3.1.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\ow2\asm\asm\4.2\asm-4.2.jar com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 com.awen.jdbc.TransactionTest,xmlTest

java.lang.ArithmeticException: / by zero

	at com.awen.jdbc.AccountDaoImpl.transfer(AccountDaoImpl.java:82)
	at com.awen.jdbc.TransactionTest.xmlTest(TransactionTest.java:16)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)


Process finished with exit code -1

```



从所得结果可以看到，`java.lang.ArithmeticException: / by zero`![image-20200215175841097](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\5-2-4.png)

Junit控制台中报出了“/by zero”的算术异常信息。此时如果再次查询数据表account，

会发现表中柳小子和柳狗柱的账户余额并没有发生任何变化（与刚开始的中的显示结果一样），这说明Spring中的事务管理配置已经生效。

我这变化了   不是汉字的问题  我注解的方法输入了英文名成功了

钱没有变化

![image-20200215180126427](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\5-2-5.png)

柳狗柱增加

柳小子不变的



## 基于Annotation方式的声明式事务

1、在Spring容器中注册事务注解驱动；

`<tx:annotation-driven transaction-manager="transactionManager"/>`

```xml
<!-- 5.注册事务管理器驱动 -->
	<tx:annotation-driven transaction-manager="transactionManager"/>
```



2、在需要事务管理的类或方法上使用@Transactional注解。

​     如果将注解添加在Bean类上，则表示事务的设置对整个Bean类的所有方法都起作用；如果将注解添加在Bean类中的某个方法上，则表示事务的设置只对该方法有效。

​    使用@Transactional注解时，可以通过参数配置事务详情：

![image-20200215161924450](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\5-2-7.png)

从表可以看出，@Transactional注解与<tx:method>元素中的事务属性基本是对应的，并且其含义也基本相似。

学习案例

接下来，就对前面模拟银行转账的案例进行改进，来演示基于Annotation方式的声明式事务管理的使用，请查看教材5.2.2小节。

**案例代码**



（1）在在src/main/resources目录下，创建Spring的配置文件applicationContext-annotation.xml，在该文件中声明事务管理器等配置信息，如文件所示。文件 applicationContext-annotation.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:tx="http://www.springframework.org/schema/tx" 
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
    http://www.springframework.org/schema/tx 
    http://www.springframework.org/schema/tx/spring-tx-4.3.xsd
    http://www.springframework.org/schema/context 
    http://www.springframework.org/schema/context/spring-context-4.3.xsd
    http://www.springframework.org/schema/aop 
    http://www.springframework.org/schema/aop/spring-aop-4.3.xsd">
    <!-- 1.配置数据源 -->
    <bean id="dataSource" 
    class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<!--数据库驱动 -->
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<!--连接数据库的url -->
		<property name="url" value="jdbc:mysql://localhost/spring?useSSL=false" />
		<!--连接数据库的用户名 -->
		<property name="username" value="root" />
		<!--连接数据库的密码 -->
		<property name="password" value="123456" />
	</bean>
	<!-- 2.配置JDBC模板 -->
	<bean id="jdbcTemplate" 
            class="org.springframework.jdbc.core.JdbcTemplate">
		<!-- 默认必须使用数据源 -->
		<property name="dataSource" ref="dataSource" />
	</bean>
	<!--3.定义id为accountDao的Bean -->
	<bean id="accountDao" class="com.awen.jdbc.AccountDaoImpl">
		<!-- 将jdbcTemplate注入到AccountDao实例中 -->
		<property name="jdbcTemplate" ref="jdbcTemplate" />
	</bean>
	<!-- 4.事务管理器，依赖于数据源 -->
	<bean id="transactionManager" class=
     "org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" />
	</bean>	
    <!-- 5.注册事务管理器驱动 -->
	<tx:annotation-driven transaction-manager="transactionManager"/>
</beans>

```

与基于XML方式的配置文件相比，文件applicationContext-annotation.xml通过注册事务管理器驱动，替换了文件applicationContext.xml中的第5步编写通知和第6步编写aop，这样大大减少了配置文件中的代码量。需要注意的是，如果案例中使用了注解式开发，则需要在配置文件中开启注解处理器，指定扫描哪些包下的注解。这里没有开启注解处理器是因为在配置文件中已经配置了AccountDaoImpl类的Bean，而@Transactional注解就配置在该Bean类中，所以可以直接生效。

（2）在AccountDaoImpl类的transfer()方法上添加事务注解，添加后的代码如下所示。

```java
	@Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT, readOnly = false)
	public void transfer(String outUser, String inUser, Double money) {
	    // 收款时，收款用户的余额=现有余额+所汇金额
	    this.jdbcTemplate.update("update account set balance = balance +? "
	            + "where username = ?",money, inUser);
	    // 模拟系统运行时的突发性问题
	    int i = 1/0;
	    // 汇款时，汇款用户的余额=现有余额-所汇金额
	    this.jdbcTemplate.update("update account set balance = balance-? "
	            + "where username = ?",money, outUser);
	}
```

上述方法已经添加了@Transactional注解，并且使用注解的参数配置了事务详情，各个参数之间要用英文逗号“, ”进行分隔。

提示在实际开发中，事务的配置信息通常是在Spring的配置文件中完成的，而在业务层类上只需使用@Transactional注解即可，不需要配置@Transactional注解的属性。



（3）在TransactionTest类中，创建测试方法annotationTest()，编辑后的代码如下所示。

```java
@Test
	public void annotationTest(){
	    ApplicationContext applicationContext = 
	new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao = 
	(AccountDao)applicationContext.getBean("accountDao");
	    // 调用实例中的转账方法
	    accountDao.transfer("Jack", "Rose", 100.0);
	    // 输出提示信息
	    System.out.println("转账成功！");
	}

```

从上述代码可以看出，与XML方式的测试方法相比，该方法只是对配置文件的名称进行了修改。

java.lang.ArithmeticException: / by zero



![image-20200215195559848](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\5-2-8.png)

注解的是有用的  😂

满足了事务的一致性  





​    本章主要对Spring中的事务管理进行了详细讲解。首先讲解了Spring事务管理所涉及的3个核心接口，然后对Spring中事务管理的两种方式进行了介绍，最后通过案例分别对基于XML方式和基于Annotation方式的声明式事务处理的使用进行了详细讲解。

​    通过本章的学习，读者可以对Spring的事务管理知识有一定的了解，并能够掌握Spring声明式事务管理的使用。