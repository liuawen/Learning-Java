# 第4章 Spring的数据库开发

· Spring Jdbc

· Spring JdbcTemplate的常用方法

学习目标



● 了解Spring中JDBC模块的作用

● 熟悉Spring JDBC的配置

● 掌握JdbcTemplate类中几个常用方法的使用

通过前几章的学习，读者对Spring框架核心技术中的几个重要模块已经有了一定的了解，并且通过学习，相信读者也逐渐地体会到了使用Spring框架的好处。Spring框架降低了Java EE API的使用难度，其中就包括JDBC的使用难度。JDBC是Spring数据访问/集成中的重要模块，本章将对Spring中的JDBC知识进行详细讲解。

# 1、Spring JDBC

Spring JDBC模块有什么作用？

**Spring的JDBC模块负责数据库资源管理和错误处理，大大简化了开发人员对数据库的操作**，使得开发人员可以从烦琐的数据库操作中解脱出来，从而将更多的精力投入到编写业务逻辑中。

编写业务逻辑代码

Spring对JDBC的支持spring-jdbc是Spring对JDBC的理解和封装，spring-jdbc大致提供了以下三部分主要功能。

（1）统一的 JDBC 接口：JDBC 功能强大，但是有过于底层的接口定义，程序员在平时的工作中很容易失误并造成低级错误。spring-jdbc提供了更友好的数据访问方式和事务支持，便捷的模板方法有JDBCTemplate和JdbcDaoSupport。

（2）统一的异常处理：提供标准的数据访问异常，屏蔽了中间件、数据库厂商驱动的差异。

（3）丰富的扩展点



## Spring JdbcTemplate的解析

针对数据库的操作，Spring框架提供了JdbcTemplate类，该类是Spring框架数据抽象层的基础，其他更高层次的抽象类却是构建于JdbcTemplate类之上。可以说，JdbcTemplate类是Spring JDBC的核心类。JdbcTemplate类的继承关系十分简单。它继承自抽象类JdbcAccessor，同时实现了JdbcOperations接口，如图所示。

![image-20200214234725930](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-1-1.png)

JdbcTemplate继承extends抽象类JdbcAccessor，实现implements接口JdbcOperations

JdbcTemplate继承关系

从图可以看出，JdbcTemplate类的直接父类是JdbcAccessor，该类为子类提供了一些访问数据库时使用的公共属性，具体如下。

DataSource：

其主要功能是获取数据库连接，具体实现时还可以引入对数据库连接的缓冲池和分布式事务的支持，它可以作为访问数据库资源的标准接口。

SQLExceptionTranslator:org.springframework.jdbc.support.SQLExceptionTranslator接口负责对SQLException进行转译工作。通过必要的设置或者获取SQLExceptionTranslator中的方法，可以使JdbcTemplate在需要处理SQLException时，委托SQLExceptionTranslator的实现类来完成相关的转译工作。

JdbcOperations接口定义了在JdbcTemplate类中可以使用的操作集合，包括添加、修改、查询和删除等操作。

## Spring JDBC的配置

​       Spring JDBC模块主要由4个包组成，分别是core（核心包）、dataSource（数据源包）、object（对象包）和support（支持包）。关于这4个包的具体说明如表所示。

![image-20200214235153566](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-1-2.png)

  core（核心包）、dataSource（数据源包）、object（对象包）和support（支持包）。

​        从上表可以看出，Spring对数据库的操作都封装在了这几个包中，而想要使用Spring JDBC，就需要对其进行配置。

在Spring中，JDBC的配置是在配置文件applicationContext.xml中完成的，其配置模板下所示。

```xml
   <?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 	http://www.springframework.org/schema/beans/spring-beans.xsd">
	<!-- 1配置数据源 -->
	<bean id="dataSource" class=
     "org.springframework.jdbc.datasource.DriverManagerDataSource">
		<!--数据库驱动 -->
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<!--连接数据库的url -->
		<property name="url" value="jdbc:mysql://localhost:3306/spring" />
		<!--连接数据库的用户名 -->
		<property name="username" value="root" />
		<!--连接数据库的密码 -->
		<property name="password" value="root" />
	</bean>
	<!-- 2配置JDBC模板 -->
	<bean id="jdbcTemplate" 
		   class="org.springframework.jdbc.core.JdbcTemplate">
		<!-- 默认必须使用数据源 -->
		<property name="dataSource" ref="dataSource" />
	</bean>
	
	<!--定义id为accountDao的Bean-->
	<bean id="accountDao" class="com.itheima.jdbc.AccountDaoImpl">
		<!-- 将jdbcTemplate注入到accountDao实例中 -->
		<property name="jdbcTemplate" ref="jdbcTemplate" />
	</bean>
	
</beans>

```

在上述代码中，定义了3个Bean，分别是dataSource、jdbcTemplate和需要注入类的Bean。

其中dataSource对应的org.springframework.jdbc.datasource.DriverManagerDataSource类用于对数据源进行配置，

jdbcTemplate对应的org.springframework.jdbc.core.JdbcTemplate类中定义了JdbcTemplate的相关配置。上述代码中dataSource的配置就是JDBC连接数据库时所需的4个属性。关于上述示例dataSource配置中的4个属性说明，如下表所示：

![image-20200214235318211](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-1-3.png)



注意**：上表中的属性值在实际配置时，需要根据数据库类型和设置进行相应配置**。

表中的4个属性，需要根据数据库类型或者机器配置的不同设置相应的属性值。例如，如果数据库类型不同，需要更改驱动名称；如果数据库不在本地，则需要将地址中的localhost替换成相应的主机IP；如果修改过MySQL数据库的端口号（默认为3306），则需要加上修改后的端口号，如果未修改，则端口号可以省略；同时连接数据库的用户名和密码需要与数据库创建时设置的用户名和密码保持一致，

![image-20200215000127274](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-1-4.png)



配置数据源

```xml
<!-- 1配置数据源 -->
	<bean id="dataSource" class=
     "org.springframework.jdbc.datasource.DriverManagerDataSource">
		<!--数据库驱动 -->
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<!--连接数据库的url -->
		<property name="url" value="jdbc:mysql://localhost:3306/spring" />
		<!--连接数据库的用户名 -->
		<property name="username" value="root" />
		<!--连接数据库的密码 -->
		<property name="password" value="root" />
	</bean>
```



配置JDBC模板

注入数据源

```xml
<!-- 2配置JDBC模板 -->
	<bean id="jdbcTemplate" 
		   class="org.springframework.jdbc.core.JdbcTemplate">
		<!-- 默认必须使用数据源 -->
		<property name="dataSource" ref="dataSource" />
	</bean>
```



配置需要实例化的Bean

注入JDBC模板

```xml
<!--定义id为accountDao的Bean-->
	<bean id="accountDao" class="com.itheima.jdbc.AccountDaoImpl">
		<!-- 将jdbcTemplate注入到accountDao实例中 -->
		<property name="jdbcTemplate" ref="jdbcTemplate" />
	</bean>
```





配置JDBC模板时需要将dataSource注入到jdbcTemplate，而在数据访问层（Dao类）需要使用jdbcTemplate时也需要将jdbcTemplate注入到对应的Bean中



这里的Spring数据库的用户名和密码都是root。定义jdbcTemplate时，需要将dataSource注入到jdbcTemplate中，而其他需要使用jdbcTemplate的Bean，也需要将jdbcTemplate注入到该Bean中（通常注入到Dao类中，在Dao类中进行与数据库的相关操作）。

问题

Error:(4, 17) java: 程序包org.junit不存在

```xml
<dependency>           
 	<groupId>junit</groupId>
 	<artifactId>junit</artifactId>
	 <version>4.12</version>
 	<scope>test</scope>
</dependency>
```

改为：

```xml
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
</dependency>
```

# 2、Spring JdbcTemplate的常用方法

在JdbcTemplate类中，提供了大量的更新和查询数据库的方法，我们就是使用这些方法来操作数据库的。

## execute()

execute()
execute(String sql)方法可用于执行sql语句

下面就以创建数据表的SQL语言为例，来说明。

（1）在MySQL中，创建一个名为spring的数据库，创建方式如图所示

![image-20200215111742172](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-2-1.png)



在图中，首先使用SQL语句创建了数据库spring（`create database spring;`），然后选择使用spring数据库(`use spring;`)。

然后再查看数据库中的表，其结果显示为空。(`show tables;`)



（2）在Idea中，在JavaEE-enterprise-application-development-tutorial项目里，创建一个名为chapter04的Maven项目module

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.awen</groupId>
    <artifactId>JavaEE-enterprise-application-development-tutorial</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>chapter01</module>
        <module>chapter02</module>
        <module>chapter04</module>
    </modules>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>
    <dependencies>

        <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>1.2</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>

             <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>5.1.47</version>
            </dependency>
    </dependencies>
</project>
```



会自动下载导入对应的依赖项。

（3）在在src/main/resources目录下，创建Spring的配置文件applicationContext.xml，在该文件中配置id为dataSource的数据源Bean和id为jdbcTemplate的JDBC模板Bean，并将数据源注入到JDBC模板中，如文件所示。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 	http://www.springframework.org/schema/beans/spring-beans-4.3.xsd">
	<!-- 1配置数据源 -->
	<bean id="dataSource" class=
     "org.springframework.jdbc.datasource.DriverManagerDataSource">
		<!--数据库驱动 -->
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<!--连接数据库的url -->
		<property name="url" value="jdbc:mysql://localhost:3306/spring?useSSL=false" />
		<!--连接数据库的用户名 -->
		<property name="username" value="root" />
		<!--连接数据库的密码 -->
		<property name="password" value="123456" />
	</bean>
	<!-- 2配置JDBC模板 -->
	<bean id="jdbcTemplate" 
		   class="org.springframework.jdbc.core.JdbcTemplate">
		<!-- 默认必须使用数据源 -->
		<property name="dataSource" ref="dataSource" />
	</bean>
	
	
	
</beans>

```

（4）在chapter04模块的src/main/java目录下，创建一个com.awen.jdbc包，在该包中创建测试类JdbcTemplateTest。在该类的main()方法中通过Spring容器获取在配置文件中定义的JdbcTemplate实例，然后使用该实例的execute(String sql)方法执行创建数据表的SQL语句，如文件所示。JdbcTemplateTest.java

```java
package com.awen.jdbc;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
public class JdbcTemplateTest {
	/**
	 * 使用execute()方法建表
	 */
	public static void main(String[] args) {
		// 加载配置文件
		ApplicationContext applicationContext = 
		   new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取JdbcTemplate实例
		JdbcTemplate jdTemplate = 
			   (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		// 使用execute()方法执行SQL语句，创建用户账户管理表account
		jdTemplate.execute("create table account(" + 
					         "id int primary key auto_increment," +
					         "username varchar(50)," + 
					         "balance double)");
		System.out.println("账户表account创建成功！");
	}
	
}	

```

成功运行程序后，

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=9076:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter04\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jdbc\5.2.3.RELEASE\spring-jdbc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-tx\5.2.3.RELEASE\spring-tx-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;D:\Environments\apache-maven-3.6.2\maven-repo\junit\junit\4.12\junit-4.12.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\Environments\apache-maven-3.6.2\maven-repo\mysql\mysql-connector-java\5.1.47\mysql-connector-java-5.1.47.jar com.awen.jdbc.JdbcTemplateTest
账户表account创建成功！

Process finished with exit code 0

```



再次查询spring数据库，其结果如图所示。

![image-20200215115000716](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-2-2.png)





从图可以看出，程序使用execute（String sql）方法执行的SQL语句已成功创建了数据表account。

删除MySQL数据表的通用语法：
DROP TABLE table_name ;

再删除掉`DROP TABLE account;`

![image-20200215115628907](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-2-3.png)

问题：

我安装MySQL 版本5.7.28

Connector/J version

```xml
 <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>5.1.47</version>
            </dependency>
```

```bash
** BEGIN NESTED EXCEPTION ** 

javax.net.ssl.SSLException
MESSAGE: closing inbound before receiving peer's close_notify

STACKTRACE:

javax.net.ssl.SSLException: closing inbound before receiving peer's close_notify
	at java.base/sun.security.ssl.Alert.createSSLException(Alert.java:129)
	at java.base/sun.security.ssl.Alert.createSSLException(Alert.java:117)
	at java.base/sun.security.ssl.TransportContext.fatal(TransportContext.java:308)
	at java.base/sun.security.ssl.TransportContext.fatal(TransportContext.java:264)
	at java.base/sun.security.ssl.TransportContext.fatal(TransportContext.java:255)
	at java.base/sun.security.ssl.SSLSocketImpl.shutdownInput(SSLSocketImpl.java:645)
	at java.base/sun.security.ssl.SSLSocketImpl.shutdownInput(SSLSocketImpl.java:624)
	at com.mysql.jdbc.MysqlIO.quit(MysqlIO.java:2249)
	at com.mysql.jdbc.ConnectionImpl.realClose(ConnectionImpl.java:4232)
	at com.mysql.jdbc.ConnectionImpl.close(ConnectionImpl.java:1472)
	at org.springframework.jdbc.datasource.DataSourceUtils.doCloseConnection(DataSourceUtils.java:402)
	at org.springframework.jdbc.datasource.DataSourceUtils.doReleaseConnection(DataSourceUtils.java:389)
	at org.springframework.jdbc.datasource.DataSourceUtils.releaseConnection(DataSourceUtils.java:356)
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:392)
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:418)
	at com.awen.jdbc.JdbcTemplateTest.main(JdbcTemplateTest.java:20)


** END NESTED EXCEPTION **


账户表account创建成功！

Process finished with exit code 0
```



javax.net.ssl.SSLException
MESSAGE: closing inbound before receiving peer's close_notify

```xml
<!--连接数据库的url -->
		<property name="url" value="jdbc:mysql://localhost:3306/spring?useSSL=false" />
```

配置url加上 useSSL=false 解决



使用JUnit单元测试

​         在软件开发过程中，需要有相应的测试工作。依据测试目的不同，可以将软件测试分为单元测试、集成测试、确认测试和系统测试等。其中单元测试在软件开发阶段是最底层的测试，它易于及时发现并解决问题。JUnit就是一个进行单元测试的开源框架，下面以上个示例，来学习单元测试框架JUnit4的使用。

将文件JdbcTemplateTest.java中的main()方法，修改成名称为mainTest()的普通方法，并在方法上添加单元测试的注解@Test，其代码如下所示。

```java
@Test
	public void mainTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取JdbcTemplate实例
	    JdbcTemplate jdTemplate = 
	            (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
	    // 使用execute()方法执行SQL语句，创建用户账户管理表account
	    jdTemplate.execute("create table account(" + 
	                           "id int primary key auto_increment," +
	                           "username varchar(50)," + 
	                           "balance double)");
	    System.out.println("账户表account创建成功！");
	}

```

@Test就是Junit4用于测试的注解，要测试哪个方法，只需要在相应测试的方法上添加此注解即可。

当在需要测试的方法上添加@Test注解后，idea会在所添加的@Test处报出Test cannot be resolved to a type的错误。

```xml
 <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
</dependency>
```

pom.xml加入依赖后，在测试类中会自动导入org.junit.Test包，此时测试类中的代码将不再报错。在执行程序时，只需使用鼠标右键，在弹出的快捷菜单中选择Run mainTest()选项来运行测试方法即可，

单击JUnit Test选项后，Unit视图窗口的进度条为绿色表明运行结果正确，如果进度条为红色则表示有错误，并且会在窗口中显示所报的错误信息。需要注意的是，在运行此方法时，需要先将数据库中已创建好的account表删除，否则执行此方法时会报出account表已经存在的错误。测试执行通过后，Console控制台的输出结果如图所示。

![image-20200215121216968](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-2-4.png)

 运行结果可以看出，mainTest()方法已经执行成功，这就是单元测试的使用。



## update()

update()
update()用于执行插入、更新和删除操作

update()方法可以完成插入、更新和删除数据的操作。在JdbcTemplate类中，提供了一系列的update()方法，其常用方法如表所示。

![image-20200215121310270](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-2-10.png)

int update(String sql) 该方法是最简单的update方法重载形式，它直接执行传入的SQL语句，并返回受影响的行数。

接下来，通过一个用户账户管理的案例来演示update()方法的使用。

小案例

在chapter04项目的com.itheima.jdbc包中,创建Account类，在该类中定义id、username和balance属性，以及其对应的getter/setter方法，如文件所示。

Account.java

```java
package com.awen.jdbc;
public class Account {
	private Integer id;       // 账户id
	private String username; // 用户名
	private Double balance;  // 账户余额
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String toString() {
		return "Account [id=" + id + ", "
				+ "username=" + username + 
				", balance=" + balance + "]";
	}
}

```

（2）在com.awen.jdbc包中，创建接口AccountDao，并在接口中定义添加、更新和删除账户的方法，如文件所示。AccountDao.java

```java
package com.awen.jdbc;

import java.util.List;

public interface AccountDao {
	// 添加
	public int addAccount(Account account);
	// 更新
	public int updateAccount(Account account);
	// 删除
	public int deleteAccount(int id);
	
	// 通过id查询
	public Account findAccountById(int id);
	// 查询所有账户
	public List<Account> findAllAccount();
}

```

（3）在com.awen.jdbc包中，创建AccountDao接口的实现类AccountDaoImpl，并在类中实现添加、更新和删除账户的方法，编辑后如文件所示。

AccountDaoImpl.java

```java
package com.awen.jdbc;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
public class AccountDaoImpl implements AccountDao {
	// 声明JdbcTemplate属性及其setter方法
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    // 添加账户
	public int addAccount(Account account) {
		// 定义SQL
		String sql = "insert into account(username,balance) value(?,?)";
		// 定义数组来存放SQL语句中的参数
		Object[] obj = new Object[] { 
                           account.getUsername(), 
                           account.getBalance() 
         };
		// 执行添加操作，返回的是受SQL语句影响的记录条数
		int num = this.jdbcTemplate.update(sql, obj);
		return num;
	}
	// 更新账户
	public int updateAccount(Account account) {
		// 定义SQL
		String sql = "update account set username=?,balance=? where id = ?";
		// 定义数组来存放SQL语句中的参数
		Object[] params = new Object[] { 
                               account.getUsername(), 
                               account.getBalance(), 
                               account.getId() 
          };
		// 执行添加操作，返回的是受SQL语句影响的记录条数
		int num = this.jdbcTemplate.update(sql, params);
		return num;
	}
	// 删除账户
	public int deleteAccount(int id) {
		// 定义SQL
		String sql = "delete  from account where id = ? ";
		// 执行添加操作，返回的是受SQL语句影响的记录条数
		int num = this.jdbcTemplate.update(sql, id);
		return num;
	}
	
	

}

```

从上述三种操作的代码可以看出，添加、更新和删除操作的实现步骤类似，只是定义的SQL语句有所不同。

SQL语句不同  添加 更新 删除  

```sql
insert into account(username,balance) value(?,?)
update account set username=?,balance=? where id = ?
delete  from account where id = ? 

```



（4）在applicationContext.xml中，定义一个id为accountDao的Bean，该Bean用于将jdbcTemplate注入到accountDao实例中，其代码如下所示。

```xml
<!--定义id为accountDao的Bean-->
	<bean id="accountDao" class="com.awen.jdbc.AccountDaoImpl">
		<!-- 将jdbcTemplate注入到accountDao实例中 -->
		<property name="jdbcTemplate" ref="jdbcTemplate" />
	</bean>
```



（5）在测试类JdbcTemplateTest中，添加一个测试方法addAccountTest()，该方法主要用于添加用户账户信息，其代码如下所示。

```java
@Test
	public void addAccountTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext =
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao =
	            (AccountDao) applicationContext.getBean("accountDao");
	    // 创建Account对象，并向Account对象中添加数据
	    Account account = new Account();
	    account.setUsername("tom");
	    account.setBalance(1000.00);
	    // 执行addAccount()方法，并获取返回结果
	    int num = accountDao.addAccount(account);
	    if (num > 0) {
	        System.out.println("成功插入了" + num + "条数据！");
	    } else {
	        System.out.println("插入操作执行失败！");
	    }
	}
```



在上述代码中，获取了AccountDao的实例后，又创建了Account对象，并向Account对象中添加了属性值。然后调用了AccountDao对象的addAccount()方法向数据表中添加一条数据。最后，通过返回的受影响的行数来判断数据是否插入成功。使用Junit4测试运行后，控制台的输出结果如下所示。

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=10289:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit5-rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit-rt.jar;D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter04\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jdbc\5.2.3.RELEASE\spring-jdbc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-tx\5.2.3.RELEASE\spring-tx-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;D:\Environments\apache-maven-3.6.2\maven-repo\junit\junit\4.12\junit-4.12.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\Environments\apache-maven-3.6.2\maven-repo\mysql\mysql-connector-java\5.1.47\mysql-connector-java-5.1.47.jar com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 com.awen.jdbc.JdbcTemplateTest,addAccountTest
成功插入了1条数据！

Process finished with exit code 0

```



此时再次查询数据库中的account表，其结果如图所示。

![image-20200215131113192](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-2-5.png)

 account表从图可以看出，使用JdbcTemplate的update()方法已成功地向数据表中插入了一条数据。

（6）执行完插入操作后，接下来使用JdbcTemplate类的update()方法执行更新操作。在测试类JdbcTemplateTest中，添加一个测试方法updateAccountTest()，其代码如下所示。

```java
@Test
	public void updateAccountTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext =
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao =
	            (AccountDao) applicationContext.getBean("accountDao");
	    // 创建Account对象，并向Account对象中添加数据
	    Account account = new Account();
	    account.setId(1);
	    account.setUsername("tom");
	    account.setBalance(2000.00);
	    // 执行updateAccount()方法，并获取返回结果
	    int num = accountDao.updateAccount(account);
	    if (num > 0) {
	        System.out.println("成功修改了" + num + "条数据！");
	    } else {
	        System.out.println("修改操作执行失败！");
	    }
	}
```



与addAccountTest()方法相比，更新操作的代码增加了id属性值的设置，并将余额修改为2000后，调用了AccountDao对象中的updateAccount()方法执行对数据表的更新操作。

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=10374:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit5-rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit-rt.jar;D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter04\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jdbc\5.2.3.RELEASE\spring-jdbc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-tx\5.2.3.RELEASE\spring-tx-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;D:\Environments\apache-maven-3.6.2\maven-repo\junit\junit\4.12\junit-4.12.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\Environments\apache-maven-3.6.2\maven-repo\mysql\mysql-connector-java\5.1.47\mysql-connector-java-5.1.47.jar com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 com.awen.jdbc.JdbcTemplateTest,updateAccountTest
成功修改了1条数据！

Process finished with exit code 0

```



使用Junit4运行方法后，再次查询数据库中的account表，其结果如图所示。

![image-20200215131415464](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-2-6.png)

图 account表从图可以看出，使用update()方法已成功更新了account表中id为1的账户余额信息。

（7）在测试类JdbcTemplateTest中，添加一个测试方法deleteAccountTest()，来执行删除操作，其代码如下所示。

```java
@Test
	public void deleteAccountTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext =
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao =
	            (AccountDao) applicationContext.getBean("accountDao");
	    // 执行deleteAccount()方法，并获取返回结果
	    int num = accountDao.deleteAccount(1);
	    if (num > 0) {
	        System.out.println("成功删除了" + num + "条数据！");
	    } else {
	        System.out.println("删除操作执行失败！");
	    }
	}
```



在上述代码中，获取了AccountDao的实例后，执行了实例中的deleteAccount()方法来删除id为1的数据。

使用Junit4测试运行方法后，

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=10410:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit5-rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit-rt.jar;D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter04\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jdbc\5.2.3.RELEASE\spring-jdbc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-tx\5.2.3.RELEASE\spring-tx-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;D:\Environments\apache-maven-3.6.2\maven-repo\junit\junit\4.12\junit-4.12.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\Environments\apache-maven-3.6.2\maven-repo\mysql\mysql-connector-java\5.1.47\mysql-connector-java-5.1.47.jar com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 com.awen.jdbc.JdbcTemplateTest,deleteAccountTest
成功删除了1条数据！

Process finished with exit code 0

```



查询account表中数据，其结果如图所示。

![image-20200215131658879](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-2-7.png)

account表从图可以看出，已成功通过delete()方法删除了id为1的数据。由于account表中只有一条数据，所以删除后表中数据为空。

## query()

query()

query()用于执行数据查询操作

​        JdbcTemplate类中还提供了大量的query()方法来处理各种对数据库表的查询操作。其中，常用的几个query()方法如下表所示：



JdbcTemplate中常用的query()方法

![image-20200215121453588](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-2-8.png)

了解了几个常用的query()方法后，接下来通过一个具体的案例来演示query()方法的使用，其实现步骤如下。

（1）向数据表account中插入几条数据可以利用上面添加也可以写SQL语句直接在MySQL里面执行（也可以使用数据库图形化工具手动向表中插入数据），插入后account表中的数据如图所示。

![image-20200215132207912](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\4-2-9.png)

​    本章对Spring框架中，使用JDBC进行数据操作的知识进行了详细讲解。首先讲解了Spring JDBC中的核心类以及如何在Spring中配置JDBC，然后通过案例讲解了Spring JDBC核心类JdbcTemplate中常用方法的使用。

（2）在AccountDao中，分别创建一个通过id查询单个账户和查询所有账户的方法，其代码如下所示。

```java
// 通过id查询
	public Account findAccountById(int id);
	// 查询所有账户
	public List<Account> findAllAccount();
```



（3）在AccountDao接口的实现类AccountDaoImpl中，实现接口中的方法，并使用query()方法分别进行查询，其代码如下所示。

```java
// 通过id查询账户数据信息
	public Account findAccountById(int id) {
	    //定义SQL语句
	    String sql = "select * from account where id = ?";
	    // 创建一个新的BeanPropertyRowMapper对象
	    RowMapper<Account> rowMapper = 
	new BeanPropertyRowMapper<Account>(Account.class);
	    // 将id绑定到SQL语句中，并通过RowMapper返回一个Object类型的单行记录
	    return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
	// 查询所有账户信息
	public List<Account> findAllAccount() {
	    // 定义SQL语句
	    String sql = "select * from account";
	    // 创建一个新的BeanPropertyRowMapper对象
	    RowMapper<Account> rowMapper = 
	new BeanPropertyRowMapper<Account>(Account.class);
	    // 执行静态的SQL查询，并通过RowMapper返回结果
	    return this.jdbcTemplate.query(sql, rowMapper);
	}
```

在上面两个方法代码中，BeanPropertyRowMapper是RowMapper接口的实现类，它可以自动地将数据表中的数据映射到用户自定义的类中（前提是用户自定义类中的字段要与数据表中的字段相对应）。创建完BeanPropertyRowMapper对象后，在findAccountById()方法中通过queryForObject()方法返回了一个Object类型的单行记录，而在findAllAccount()方法中通过query()方法返回了一个结果集合。

（4）在测试类JdbcTemplateTest中，添加一个测试方法findAccountByIdTest()来测试条件查询，其代码如下所示。

```java
@Test
	public void findAccountByIdTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext =
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao =
	            (AccountDao) applicationContext.getBean("accountDao");
	    // 执行findAccountById()方法
	    Account account = accountDao.findAccountById(2);
	    System.out.println(account);
	}
```

上述代码通过执行findAccountById()方法获取了id为2的对象信息，并通过输出语句输出。使用JUnit4测试运行后，控制台的输出结果。 运行结果

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=10600:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit5-rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit-rt.jar;D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter04\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jdbc\5.2.3.RELEASE\spring-jdbc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-tx\5.2.3.RELEASE\spring-tx-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;D:\Environments\apache-maven-3.6.2\maven-repo\junit\junit\4.12\junit-4.12.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\Environments\apache-maven-3.6.2\maven-repo\mysql\mysql-connector-java\5.1.47\mysql-connector-java-5.1.47.jar com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 com.awen.jdbc.JdbcTemplateTest,findAccountByIdTest
Account [id=2, username=柳小子, balance=10000.0]

Process finished with exit code 0

```

com.awen.jdbc.JdbcTemplateTest,findAccountByIdTest
Account [id=2, username=柳小子, balance=10000.0]

5）测试完条件查询单个数据的方法后，接下来测试查询所有用户账户信息的方法。在测试类JdbcTemplateTest中，添加一个测试方法findAllAccountTest()，其代码如下所示。

```java
@Test
	public void findAllAccountTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext =
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao =
	            (AccountDao) applicationContext.getBean("accountDao");
	    // 执行findAllAccount()方法,获取Account对象的集合
	    List<Account> account = accountDao.findAllAccount();
	    // 循环输出集合中的对象
	    for (Account act : account) {
	        System.out.println(act);
	    }
	}
```

在上述代码中，调用了AccountDao对象的findAllAccount()方法查询所有用户账户信息集合，并通过for循环输出查询结果。使用JUnit4成功运行findAllUserTest()方法后，控制台的显示信息如下所示。 

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=10628:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit5-rt.jar;D:\Java\ideaIU-2019.2.win\plugins\junit\lib\junit-rt.jar;D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter04\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jdbc\5.2.3.RELEASE\spring-jdbc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-tx\5.2.3.RELEASE\spring-tx-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;D:\Environments\apache-maven-3.6.2\maven-repo\junit\junit\4.12\junit-4.12.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\Environments\apache-maven-3.6.2\maven-repo\mysql\mysql-connector-java\5.1.47\mysql-connector-java-5.1.47.jar com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 com.awen.jdbc.JdbcTemplateTest,findAllAccountTest
Account [id=2, username=柳小子, balance=10000.0]
Account [id=3, username=小柳子, balance=10.0]
Account [id=4, username=柳铁蛋, balance=20.0]
Account [id=5, username=柳狗柱, balance=20.0]

Process finished with exit code 0

```



从运行结果从可以看出，数据表account中的4条记录都已经被查询出来。

学会如何使用Spring框架进行数据库开发，深切的体会到Spring框架的强大。



**✎** **本章作业** 

请简述Spring JDBC是如何进行配置的。

请简述Spring JdbcTemplate类中几个常用方法的作用。

**✎** **预习作业**

Spring事务管理的核心接口有哪些？

Spring事务管理的方式？