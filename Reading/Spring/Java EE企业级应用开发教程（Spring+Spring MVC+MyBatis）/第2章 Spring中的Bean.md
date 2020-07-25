# 第2章 Spring中的Bean

–请简述Spring框架的优点。

–请简述什么是Spring的IoC和DI 。

–Bean的实例化有哪几种方式？

–Bean的作用域是什么？

–Bean有几种装配方式？

–

学习目标

● 了解Bean的常用属性及其子元素

● 掌握实例化Bean的三种方式

● 熟悉Bean的作用域和生命周期

● 掌握Bean的三种装配方式

在第一章中，详细讲解了Spring的IoC思想及原理，并通过案例演示了Spring框架的基本使用。本章将在第一章节的基础上，针对Spring中Bean的相关知识进行详细的讲解。

# 1、Bean配置

简单记录-Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）

什么是Spring中的Bean？

Spring可以被看作是一个大型工厂，这个工厂的作用就是生产和管理Spring容器中的Bean。如果想要在项目中使用这个工厂，就需要开发者对Spring的配置文件进行配置，配置的时候要在配置文件中告诉它需要哪些Bean，以及需要使用何种方式将这些Bean装配到一起。

提示： Bean的本质就是Java中的类，而Spring中的Bean其实就是对实体类的引用，来生产Java类对象，从而实现生产和管理Bean 。

Spring容器支持XML和Properties两种格式的配置文件，在实际开发中，最常使用的就是XML格式的配置方式。这种配置方式通过XML文件来注册并管理Bean之间的依赖关系。

使用XML文件的形式对Bean的属性和定义进行详细的讲解。

在Spring中，XML配置文件的根元素是<beans>, <beans>中包含了多个<bean>子元素，每一个<bean>子元素定义了一个Bean，并描述了该Bean如何被装配到Spring容器中。<bean>元素中同样包含了多个属性以及子元素，其常用属性及子元素如表所示。

表<bean>元素的常用属性及其子元素

![image-20200214135853901](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\2-1-1.png)

表中只介绍了<bean>元素的一些常用属性和子元素，实际上<bean>元素还有很多属性和子元素，我们可以到网上查阅相关资料进行获取。

在Spring的配置文件中，通常一个普通的Bean只需要定义id（或name）和class两个属性即可，定义Bean的方式如下所示。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--将指定类配置给Spring，让Spring创建其对象的实例    -->
    <!-- 使用id 属性定义bean1，其对应的实现类为com.awen.instance.constructor.Bean1-->
    <bean id="bean1" class="com.awen.instance.constructor.Bean1"/>
    <!-- 使用name 属性定义bean1，其对应的实现类为com.awen.instance.static_factory.Bean2-->
    <bean name="bean2" class="com.awen.instance.static_factory.Bean2"
</beans>
```

在上述代码中，分别使用id属性和name属性定义了两个Bean，并使用class元素指定其对应的实现类

注意：如果在Bean中未指定id和name，则Spring会将class值当作id使用。



- 一般情况下，装配一个Bean时，通过指定一个id属性作为Bean的名称
-  id属性在IOC容器中必须是唯一的
-  如果Bean的名称中含有特殊字符，就需要使用name属性



实例

1、复杂类型

```java
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
```



2、真实测试对象

```java
public class Student {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbies;
    private Map<String,String> card;
    private Set<String> games;
    private String wife;
    private Properties info;
}
```

Address的对象address在Student类作为属性



3、beans.xml

完整注入

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="address" class="com.kuang.pojo.Address"/>

    <bean id="student" class="com.kuang.pojo.Student">
        <!--第一种，普通值注入，value-->
        <property name="name" value="憨批"/>
        <!--第二种，Bean注入，ref-->
        <property name="address" ref="address"/>
        <!--数组注入-->
        <property name="books">
            <array>
                <value>红楼梦</value>
                <value>西游记</value>
                <value>水浒传</value>
                <value>三国演义</value>
            </array>
        </property>
        <!--List注入-->
        <property name="hobbies">
            <list>
                <value>听歌</value>
                <value>敲代码</value>
                <value>看电影</value>
            </list>
        </property>
        <!--Map-->
        <property name="card">
            <map>
                <entry key="身份证" value="1555555555"/>
                <entry key="银行卡" value="5555555555"/>
            </map>
        </property>
        <!--Set-->
        <property name="games">
            <set>
                <value>lol</value>
                <value>wow</value>
            </set>
        </property>
        <!--null-->
        <property name="wife">
            <null/>
        </property>
        <!--Properties-->
        <property name="info">
            <props>
                <prop key="driver">com.mysql.jdbc.Driver</prop>
                <prop key="url">jdbc:mysql://localhost:3306/news</prop>
                <prop key="root">root</prop>
                <prop key="password">123456</prop>
            </props>
        </property>

    </bean>

</beans>
```

4、测试类

```java
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.getName());
    }
}
```



# Spring配置

别名

alias 设置别名 , 为bean设置别名 , 可以设置多个别名

```xml
<!--设置别名：在获取Bean的时候可以使用别名获取-->
<alias name="userT" alias="userNew"/>
```

Bean的配置

```xml
<!--bean就是java对象,由Spring创建和管理-->

<!--
    id 是bean的标识符,要唯一,如果没有配置id,name就是默认标识符
    如果配置id,又配置了name,那么name是别名
    name可以设置多个别名,可以用逗号,分号,空格隔开
    如果不配置id和name,可以根据applicationContext.getBean(.class)获取对象;

    class是bean的全限定名=包名+类名
-->
<bean id="hello" name="hello2 h2,h3;h4" class="com.awen.pojo.Hello">
    <property name="name" value="Spring"/>
</bean>
```

import

团队的合作通过import来实现 .

```xml
<import resource="{path}/beans.xml"/>
```

这个import，一般用于团队开发使用，他可以将多个配置文件，导入合并为一个。

假设，现在项目中有多个人开发，这三个人负责不同的类开发，不同的类需要注册在不同的bean中，我们可以利用import将所有人的beans.xml合并为一个总的！

- 张三

- 李四

- 王五

  applicationContext.xml

```xml
<import resource="beans.xml"/>
<import resource="beans2.xml"/>
<import resource="beans3.xml"/>
```

使用的时候，直接使用总的配置就可以了







。

# Bean的实例化

Bean的实例化有哪些方式？

​          在面向对象的程序中，想要使用某个对象，就需要先实例化这个对象。同样，在Spring中，要想使用容器中的Bean，也需要实例化Bean。实例化Bean有三种方式，

分别为构造器实例化、静态工厂方式实例化和实例工厂方式实例化（其中最常用的是构造器实例化）。 

## 构造器实例化

构造器实例化是指**Spring容器通过Bean对应类中默认的无参构造方法来实例化Bean**。

下面通过一个案例来演示Spring容器是如何通过构造器来实例化Bean的。

（1）在Idea中，在JavaEE-enterprise-application-development-tutorial项目里，创建一个名为chapter02的Web项目module，

pom.xml

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.23.RELEASE</version>
</dependency>
```

会自动下载导入对应的依赖项。

（2）在chapter02模块的src/main/java目录下，创建一个com.awen.instance.constructor包，在该包中创建Bean1类， Bean1.java

```java
package com.awen.instance.constructor;
public class Bean1 {
}

```



（3）在在src/main/resources目录下，创建Spring的配置文件beans1.xml，在配置文件中定义一个id为bean1的Bean，并通过class属性指定其对应的实现类为Bean1，beans1.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 	http://www.springframework.org/schema/beans/spring-beans-4.3.xsd">
	<bean id="bean1" class="com.awen.instance.constructor.Bean1" />
</beans>

```

`<bean id="bean1" class="com.awen.instance.constructor.Bean1" />`

（4）在com.awen.instance.constructor包中，创建测试类InstanceTest1，来测试构造器是否能实例化Bean，

InstanceTest1.java

```java
package com.awen.instance.constructor;
import org.springframework.context.ApplicationContext;
import 
	org.springframework.context.support.ClassPathXmlApplicationContext;
public class InstanceTest1 {
	public static void main(String[] args) {
		
		// ApplicationContext在加载配置文件时，对Bean进行实例化
		ApplicationContext applicationContext = 
							new ClassPathXmlApplicationContext("beans1.xml");
		Bean1 bean = (Bean1) applicationContext.getBean("bean1");
         System.out.println(bean);
	}
}

```



Resource注解无法导入依赖使用javax.annotation的注解类

Maven导入

```xml
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>jsr250-api</artifactId>
    <version>1.0</version>
</dependency>
```



在InstanceTest1.java文件中，Spring容器ApplicationContext会加载配置文件。

在加载时，Spring容器会通过id为bean1的实现类Bean1中默认的无参构造方法对Bean进行实例化。执行程序后，控制台的输出结果如图所示。

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=13768:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter02\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\javax\annotation\jsr250-api\1.0\jsr250-api-1.0.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar com.awen.instance.constructor.InstanceTest1
com.awen.instance.constructor.Bean1@7eac9008

Process finished with exit code 0

```



从运行结果可以看出，Spring容器已经成功实例化了Bean1，并输出了结果。

com.awen.instance.constructor.InstanceTest1
com.awen.instance.constructor.Bean1@7eac9008

构造器实例化是指**Spring容器通过Bean对应类中默认的无参构造方法来实例化Bean**。

## 静态工厂方式实例化

使用静态工厂是实例化Bean的另一种方式。

该方式要求**开发者创建一个静态工厂的方法来创建Bean的实例**，其Bean配置中的class属性所指定的不再是Bean实例的实现类，而是静态工厂类，同时还需要使用factory-method属性来指定所创建的静态工厂方法。下面通过一个案例来演示如何使用静态工厂方式实例化Bean。

（1）在chapter02模块的src/main/java目录下，创建一个com.awen.instance.static_factory包，在该包中创建一个Bean2类，该类与Bean1一样，不需添加任何方法。

```java
package com.awen.instance.static_factory;
public class Bean2 {
}

```



（2）在com.awen.instance.static_factory包中，创建一个MyBean2Factory类，并在类中创建一个静态方法createBean()来返回Bean2实例，如文件所示。文件 MyBean2Factory.java

```java
package com.awen.instance.static_factory;
public class MyBean2Factory {	
	//使用自己的工厂创建Bean2实例
	public static Bean2 createBean(){
		return new Bean2();
	}
}

```



（3）在src/main/resources目录下，创建Spring配置文件beans2.xml，编辑后如文件所示。文件 beans2.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans-4.3.xsd">
    <bean id="bean2" 
            class="com.awen.instance.static_factory.MyBean2Factory"
		   factory-method="createBean" />
</beans>

```

` <bean id="bean2" 
            class="com.awen.instance.static_factory.MyBean2Factory"
		   factory-method="createBean" />`

在上述配置文件中，首先通过<bean>元素的id属性定义了一个名称为bean2的Bean，然后由于使用的是静态工厂方法，所以需要通过class属性指定其对应的工厂实现类为MyBean2Factory。由于这种方式配置Bean后，Spring容器不知道哪个是所需要的工厂方法，所以增加了factory-method属性来告诉Spring容器，其方法名称为createBean。

bean2是静态工厂类的工厂方法创建的

（4）在com.awen.instance.static_factory包中，创建一个测试类InstanceTest2，来测试使用静态工厂方式是否能实例化Bean，编辑后如文件所示。文件 InstanceTest2.java

```java
package com.awen.instance.static_factory;
import org.springframework.context.ApplicationContext;
import 
	org.springframework.context.support.ClassPathXmlApplicationContext;
public class InstanceTest2 {
	public static void main(String[] args) {
		// ApplicationContext在加载配置文件时，对Bean进行实例化

		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("beans2.xml");
		System.out.println(applicationContext.getBean("bean2"));
	}
}

```











执行程序后，控制台的输出结果如图所示。

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=13958:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter02\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\javax\annotation\jsr250-api\1.0\jsr250-api-1.0.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar com.awen.instance.static_factory.InstanceTest2
com.awen.instance.static_factory.Bean2@40005471

Process finished with exit code 0

```



从运行结果可以看到，使用自定义的静态工厂方法，已成功实例化了Bean2。

com.awen.instance.static_factory.InstanceTest2
com.awen.instance.static_factory.Bean2@40005471

静态工厂方法实例化Bean，要求**开发者创建一个静态工厂的方法来创建Bean的实例**，其Bean配置中的class属性所指定的不再是Bean实例的实现类，而是静态工厂类，同时还需要使用factory-method属性来指定所创建的静态工厂方法。

` <bean id="bean2" 
            class="com.awen.instance.static_factory.MyBean2Factory"
		   factory-method="createBean" />`



## 实例工厂方式实例化

还有一种实例化Bean的方式就是采用实例工厂。此种方式的工厂类中，不再使用静态方法创建Bean实例，而是**采用直接创建Bean实例的方式**。同时，在配置文件中，需要实例化的Bean也不是通过class属性直接指向的实例化类，而是通过factory-bean属性指向配置的实例工厂，然后使用factory-method属性确定使用工厂中的哪个方法。下面通过一个案例来演示实例工厂方式的使用。

（1）在chapter02模块的src/main/java目录下，创建一个com.awen.instance.factory包，在该包中创建一个Bean3类，该类与Bean1一样，不需添加任何方法。

```java
package com.awen.instance.factory;
public class Bean3 {
}

```



（2）在com.awen.instance..factory包中，创建一个MyBean3Factory类，在类中使用默认无参构造方法输出“bean3工厂实例化中”语句，并使用createBean()方法创建Bean3对象，如文件所示。MyBean3Factory.java

```java
package com.awen.instance.factory;
public class MyBean3Factory {
	public MyBean3Factory() {
		System.out.println("bean3工厂实例化中");
	}
    //创建Bean3实例的方法
	public Bean3 createBean(){
		return new Bean3();
	}
}


```



（3）在src/main/resources目录下，创建Spring配置文件beans3.xml，编辑后如文件所示。文件 beans3.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans-4.3.xsd">
    <!-- 配置工厂 -->
    <bean id="myBean3Factory" 
            class="com.awen.instance.factory.MyBean3Factory" />
    <!-- 使用factory-bean属性指向配置的实例工厂，
          使用factory-method属性确定使用工厂中的哪个方法-->
	<bean id="bean3" factory-bean="myBean3Factory" 
		   factory-method="createBean" />
</beans>

```

` <!-- 配置工厂 -->
    <bean id="myBean3Factory" 
            class="com.awen.instance.factory.MyBean3Factory" />
    <!-- 使用factory-bean属性指向配置的实例工厂，
          使用factory-method属性确定使用工厂中的哪个方法-->
	<bean id="bean3" factory-bean="myBean3Factory" 
		   factory-method="createBean" />`

在上述配置文件中，首先配置了一个工厂Bean，然后配置了需要实例化的Bean。在id为bean3的Bean中，使用factory-bean属性指向配置的实例工厂，该属性值就是工厂Bean的id。使用factory-method属性来确定使用工厂中的createBean()方法。

实例化了实例工厂 

<bean id="bean3" factory-bean="myBean3Factory" 
		   factory-method="createBean" />

实例工厂工厂方法创建

（4）在com.awen.instance.factory的包中，创建测试类InstanceTest3，来测试实例工厂方式能否实例化Bean，编辑后如文件所示。文件 InstanceTest3.java

```java
package com.awen.instance.factory;
import org.springframework.context.ApplicationContext;
import 
	org.springframework.context.support.ClassPathXmlApplicationContext;
public class InstanceTest3 {
	public static void main(String[] args) {

		// ApplicationContext在加载配置文件时，对Bean进行实例化
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans3.xml");
		System.out.println(applicationContext.getBean("bean3"));
	}
} 

```

执行程序后，控制台的输出结果如图所示。

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=14114:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter02\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\javax\annotation\jsr250-api\1.0\jsr250-api-1.0.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar com.awen.instance.factory.InstanceTest3
bean3工厂实例化中
com.awen.instance.factory.Bean3@49438269

Process finished with exit code 0

```



从运行结果从可以看到，使用实例工厂的方式，同样成功实例化了Bean3

com.awen.instance.factory.InstanceTest3
bean3工厂实例化中
com.awen.instance.factory.Bean3@49438269



` <!-- 配置工厂 -->
    <bean id="myBean3Factory" 
            class="com.awen.instance.factory.MyBean3Factory" />
    <!-- 使用factory-bean属性指向配置的实例工厂，
          使用factory-method属性确定使用工厂中的哪个方法-->
	<bean id="bean3" factory-bean="myBean3Factory" 
		   factory-method="createBean" />`

在上述配置文件中，首先配置了一个工厂Bean，然后配置了需要实例化的Bean。在id为bean3的Bean中，使用factory-bean属性指向配置的实例工厂，该属性值就是工厂Bean的id。使用factory-method属性来确定使用工厂中的createBean()方法。

采用实例工厂方法实例化Bean。此种方式的工厂类中，不再使用静态方法创建Bean实例，而是**采用直接创建Bean实例的方式**。同时，在配置文件中，需要实例化的Bean也不是通过class属性直接指向的实例化类，而是通过factory-bean属性指向配置的实例工厂，然后使用factory-method属性确定使用工厂中的哪个方法。

静态不用创建工厂，实例工厂需要。

# 3、Bean的作用域

通过Spring容器创建一个Bean的实例时，不仅可以完成Bean的实例化，还可以为Bean指定特定的作用域。

那什么是Bean的作用域？Bena的作用域有什么用呢？

官网：https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-scopes

![image-20200214174635659](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\2-3-1.png)



1. 代理模式（Spring默认机制）：get到的都是同一个对象！

   ```xml
   <bean id="accountService" class="com.something.DefaultAccountService"/>
   
   <!-- the following is equivalent, though redundant (singleton scope is the default) -->
   <bean id="accountService" class="com.something.DefaultAccountService" scope="singleton"/>
   ```

2. 原型模式：每次从容器中get的时候，都会产生一个新的对象！

   ```xml
   <bean id="accountService" class="com.something.DefaultAccountService" scope="prototype"/>
   ```

3. 其余的request、session、application、这些个只能在web开发中使用。

## 作用域的种类

Spring 为Bean的实例定义了7种作用域，如下表所示：

![image-20200214165356259](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\2-3-2.png)

注意：在上表7种作用域中，singleton和prototype是最常用的两种作用域。



![image-20200115153935660](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\2-3-3.png)

这里只有六种哦 singleton、prototype、request、session、application和websocket

没了globalSession的

singleton单例作用域和prototype原型作用域。

## singleton单例作用域

​         **singleton是Spring容器默认的作用域**，**当Bean的作用域为singleton时，Spring容器就只会存在一个共享的Bean实例**。

singleton作用域对于无会话状态的Bean（如Dao 组件、Service组件）来说，是最理想的选择。  

在Spring配置文件中，Bean的作用域是通过<bean>元素的scope属性来指定的，该属性值可以设置为singleton、prototype、request、session、application和websocket七个值，分别表示Bean的七种作用域。

   在Spring中如何配置singleton作用域?    在Spring配置文件中，可以使用<bean>元素的scope属性，将Bean的作用域定义成singleton。

例如：

```xml
<bean id="scope" class="com.awen.scope.Scope" scope="singleton"/>

```

小案例来理解一下singleton作用域吧。

在项目chapter02中，创建一个com.awen.scope包，在包中创建Scope类，该类不需要写任何方法。

```java
package com.awen.scope;
public class Scope  {

}

```



在src/main/resources目录下,创建一个配置文件beans4.xml，将上述示例代码写入配置文件中。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 	       http://www.springframework.org/schema/beans/spring-beans.xsd">
	 <bean id="scope" class="com.awen.scope.Scope" scope="singleton"/> 
<!--	<bean id="scope" class="com.awen.scope.Scope" scope="prototype" />-->
</beans>
```



最后在com.awen.scope包中创建测试类ScopeTest，来测试singleton作用域，编辑后如文件所示。文件ScopeTest.java

```java
package com.awen.scope;
import org.springframework.context.ApplicationContext;
import 
	org.springframework.context.support.ClassPathXmlApplicationContext;
public class ScopeTest {
	public static void main(String[] args) {
		
		// 加载配置文件

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans4.xml");
		// 输出获得实例
		System.out.println(applicationContext.getBean("scope"));
		System.out.println(applicationContext.getBean("scope"));
		System.out.println(applicationContext.getBean("scope") == applicationContext.getBean("scope")  );

		Scope scope = (Scope)applicationContext.getBean("scope");
		Scope scope2= (Scope) applicationContext.getBean("scope");
		System.out.println(scope == scope2);
	}
}

```



执行程序后，控制台的输出结果如下所示。

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=1119:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter02\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\javax\annotation\jsr250-api\1.0\jsr250-api-1.0.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar com.awen.scope.ScopeTest
com.awen.scope.Scope@74e52ef6
com.awen.scope.Scope@74e52ef6
true
true

Process finished with exit code 0

```

com.awen.scope.Scope@74e52ef6
com.awen.scope.Scope@74e52ef6

两次输出的结果相同，这说明Spring容器只创建了一个Scope类的实例。需要注意的是，如果不设置scope="singleton"，其输出结果也是一个实例，因为Spring容器默认的作用域就是singleton。



## prototype原型作用域

​    对需要保持会话状态的Bean（如Struts 2的Action类）应该使用prototype作用域。

**在使用prototype作用域时，Spring容器会为每个对该Bean的请求都创建一个新的实例。**

 在Spring中如何配置prototype作用域?在Spring配置文件中，同样使用<bean>元素的scope属性，将Bean的作用域定义成prototype 。

例如

```xml
<bean id="scope" class="com.itheima.scope.Scope" scope=" prototype "/>

```

原型作用域  

beans4.xml  改下

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 	       http://www.springframework.org/schema/beans/spring-beans.xsd">
<!--	 <bean id="scope" class="com.awen.scope.Scope" scope="singleton"/>-->
	<bean id="scope" class="com.awen.scope.Scope" scope="prototype" />
</beans>
```



运行结果

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=1185:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter02\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\javax\annotation\jsr250-api\1.0\jsr250-api-1.0.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar com.awen.scope.ScopeTest
com.awen.scope.Scope@6f03482
com.awen.scope.Scope@9d5509a
false
false

Process finished with exit code 0

```

运行结果可以看到，

com.awen.scope.ScopeTest
com.awen.scope.Scope@6f03482
com.awen.scope.Scope@9d5509a

两次输出的Bean实例并不相同，这说明在prototype作用域下，创建了两个不同的Scope实例。

### bean的作用域



在SpringIOC容器中仅存在一个Bean实例，Bean以单实例的方式存在 

每次调用getBean()时都会返回一个新的实例

每次HTTP请求都会创建一个新的Bean，该作用域仅适用于WebApplicationContext环境

同一个HTTP session共享一个Bean，不同的HTTP session使用不同的Bean。该作用域仅适用于WebApplicationContext环境 

###### ![image-20200102200419210](C:/Users/x1c/Desktop/MarkDown/Spring/note/image-20200102200419210.png)

1. 代理模式（Spring默认机制）：get到的都是同一个对象！

   ```xml
   <bean id="accountService" class="com.something.DefaultAccountService"/>
   
   <!-- the following is equivalent, though redundant (singleton scope is the default) -->
   <bean id="accountService" class="com.something.DefaultAccountService" scope="singleton"/>
   ```

2. 原型模式：每次从容器中get的时候，都会产生一个新的对象！

   ```xml
   <bean id="accountService" class="com.something.DefaultAccountService" scope="prototype"/>
   ```

3. 其余的request、session、application、这些个只能在web开发中使用。

# 4、Bean的生命周期





了解Spring中Bean的生命周期有何意义？

了解Spring中Bean的生命周期的意义就在于，可以利用Bean在其存活期间的特定时刻完成一些相关操作。这种时刻可能有很多，但一般情况下，常会在Bean的postinitiation(初始化后)和predestruction（销毁前）执行一些相关操作。



Spring容器可以管理Bean部分作用域的生命周期。

Bean的生命周期管理

singleton作用域

* Spring容器可以管理singleton作用域的Bean的生命周期，在此作用域下，Spring能够精确的知道该Bean何时被创建，何时初始化完成，以及何时被销毁。
* 

prototype作用域

* prototype作用域的Bean，Spring只负责创建，当容器创建了Bean实例后，Bean的实例就交给客户端代码来管理，Spring容器将不再跟踪其生命周期。

Spring容器可以管理singleton作用域的Bean的生命周期，在此作用域下，Spring能够精确地知道该Bean何时被创建，何时初始化完成以及何时被销毁。

对于prototype作用域的Bean, Spring只负责创建，当容器创建了Bean实例后，Bean的实例就交给客户端代码来管理，Spring容器将不再跟踪其生命周期。每次客户端请求prototype作用域的Bean时，Spring容器都会创建一个新的实例，并且不会管那些被配置成prototype作用域的Bean的生命周期。

在Spring中，Bean生命周期的执行是一个很复杂的过程，我们可以**利用Spring提供的方法来定制Bean的创建过程**。** **，而**Spring容器在保证一个Bean能够使用之前，会做很多工作**。Spring容器中，Bean的生命周期流程如图所示。



![image-20200214175916091](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\2-4-1.png)



这个图，Bean的生命周期的整个执行过程描述如下。

（1）根据配置情况调用Bean构造方法或工厂方法实例化Bean。

​	实例化Bean

（2）利用依赖注入完成Bean中所有属性值的配置注入。

​	设置属性值

（3）如果Bean实现了BeanNameAware接口，则Spring调用Bean的setBeanName()方法传入当前Bean的id值。

​	调用BeanNameAware的setBeanName()方法

（4）如果Bean实现了BeanFactoryAware接口，则Spring调用setBeanFactory()方法传入当前工厂实例的引用。	调用BeanFactoryAware的setBeanFactory()方法

（5）如果Bean实现了ApplicationContextAware接口，则Spring调用setApplicationContext()方法传入当前ApplicationContext实例的引用。

​	调用ApplicationContextAware的setApplicationContext()方法

（6）如果BeanPostProcessor和Bean关联，则Spring将调用该接口的预初始化方法postProcessBeforeInitialzation()对Bean进行加工操作，这个非常重要，Spring的AOP就是用它实现的。

​	调用BeanPostProcessor的预初始化方法

（7）如果Bean实现了InitializingBean接口，则Spring将调用afterPropertiesSet()方法。

​	调用InitializingBean的afterPropertiesSet()方法

（8）如果在配置文件中通过init-method属性指定了初始化方法，则调用该初始化方法。

​	调用定制的初始化方法

（9）如果有BeanPostProcessor和Bean关联，则Spring将调用该接口的初始化方法post ProcessAfterInitialization()。此时，Bean已经可以被应用系统使用了。

​	调用BeanPsotProcessor的初始化方法

（10）如果在<bean> 中指定了该Bean的作用范围为scope="singleton"，则将该Bean放入Spring IoC的缓存池中，将触发Spring对该Bean的生命周期管理；如果在<bean>中指定了该Bean的作用范围为scope="prototype"，则将该Bean交给调用者，调用者管理该Bean的生命周期，Spring不再管理该Bean。

​     [singleton] Spring缓冲池中准备就绪的Bean

​	[prototype] 将准备就绪的Bean交给调用者

（11）如果Bean实现了DisposableBean接口，则Spring会调用destory()方法将Spring中的Bean销毁；如果在配置文件中通过destory-method属性指定了Bean的销毁方法，则Spring将调用该方法进行销毁。Spring为Bean提供了细致全面的生命周期过程，通过实现特定的接口或通过<bean>的属性设置，都可以对Bean的生命周期过程产生影响。我们可以随意地配置<bean>的属性，但是在这里建议不要过多地使用Bean实现接口，因为这样会使代码和Spring聚合比较紧密。

​	[Spring中Bean的销毁]

​	调用Disposable的destory()方法

​	调用destory-method属性配置的销毁方法

# 5、Bean的装配方式

**IoC是Spring框架的核心内容**，使用多种方式完美的实现了IoC，可以使用XML配置，也可以使用注解，新版本的Spring也可以零配置实现IoC。

**控制反转(IoC)是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方法是依赖注入（Dependency Injection,DI）。**

依赖注入

什么是Bean的装配？

​       Bean的装配方式是将Bean装配注入到Spring IoC容器中 ，Bean的装配可以理解为依赖关系注入，Bean的装配方式即Bean依赖注入的方式。Spring容器支持多种形式的Bean的装配方式，如基于XML的装配、基于注解（Annotation）的装配和自动装配（其中最常用的是基于注解的装配）。基于注解的装配方式尤其重要，它是当前的主流装配方式。

采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。

## 基于XML的装配

Spring提供了两种基于XML的装配方式：设值注入（Setter Injection）和构造注入（Constructor Injection）。下面就讲解下如何在XML配置文件中使用这两种注入方式来实现基于XML的装配。



在Spring实例化Bean的过程中，Spring首先会调用Bean的默认构造方法来实例化Bean对象，然后通过反射的方式调用setter方法来注入属性值。因此，设值注入要求一个Bean必须满足以下两点要求。

*  Bean类必须提供一个默认的无参构造方法。
*  Bean类必须为需要注入的属性提供对应的setter方法。

使用设值注入时，在Spring配置文件中，需要使用<bean>元素的子元素<property>来为每个属性注入值；

而使用构造注入时，在配置文件里，需要使用<bean>元素的子元素<constructor-arg>来定义构造方法的参数，可以使用其value属性（或子元素）来设置该参数的值。

![image-20200214190510679](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\2-5-1.png)



下面通过一个案例来演示基于XML方式的Bean的装配。

 基于XML的装配，使用方式如下：

创建Java类，提供有参、无参构造以及属性setter方法；

（1）在chapter02模块的src/main/java目录下，创建一个com.awen.assemble包，在该包中创建User类，并在类中定义username、password和list集合三个属性及其对应的setter方法，如文件所示。文件 User.java

    ```java
package com.awen.assemble;
import java.util.List;
public class User {
	private String username;
	private Integer password;
	private List<String> list;
	/**
	 * 1.使用构造注入 
	 * 1.1提供带所有参数的有参构造方法。
	 */
	public User(String username, Integer password, List<String> list) {
		super();
		this.username = username;
		this.password = password;
		this.list = list;
	}
	/**
	 * 2.使用设值注入 
	 * 2.1提供默认空参构造方法 ;
	 * 2.2为所有属性提供setter方法。
	 */
	public User() {
		super();
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password +
				", list=" + list + "]";
	}
}

    ```

在文件User.java中，由于要使用构造注入，所以需要其有参和无参的构造方法。同时，为了输出时能够看到结果，还重写了其属性的toString()方法。

（2）在src/main/resources目录下，创建Spring配置文件beans5.xm，创建配置文件beans5.xml，在配置文件中通过构造注入和设值注入的方式装配User类的实例，如文件所示。文件 beans5.xml



```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 	http://www.springframework.org/schema/beans/spring-beans.xsd">
	<!--1.使用构造注入方式装配User实例 -->
	<bean id="user1" class="com.awen.assemble.User">
		<constructor-arg index="0" value="柳小子" />
		<constructor-arg index="1" value="123456" />
		<constructor-arg index="2">
			<list>
				<value>"constructorvalue1"</value>
				<value>"constructorvalue2"</value>
			</list>
		</constructor-arg>
	</bean>
	<!--2.使用设值注入方式装配User实例 -->
	<bean id="user2" class="com.awen.assemble.User">
		<property name="username" value="子小柳"></property>
		<property name="password" value="654321"></property>
		<!-- 注入list集合 -->
		<property name="list">
			<list>
				<value>"setlistvalue1"</value>
				<value>"setlistvalue2"</value>
			</list>
		</property>
	</bean>
</beans>


```

在上述配置文件中，<constructor-arg >元素用于定义构造方法的参数，其属性index表示其索引（从0开始）, value属性用于设置注入的值，其子元素<list>来为User类中对应的list集合属性注入值。然后又使用了设值注入方式装配User类的实例，其中<property>元素用于调用Bean实例中的setter方法完成属性赋值，从而完成依赖注入，而其子元素<list>同样是为User类中对应的list集合属性注入值。

（3）在com.awen.assemble包中，创建测试类XmlBeanAssembleTest，在类中分别获取并输出配置文件中的user1和user2实例，如文件所示。文件 XmlBeanAssembleTest.java

```java
package com.awen.assemble;
import org.springframework.context.ApplicationContext;
import 
	org.springframework.context.support.ClassPathXmlApplicationContext;
public class XmlBeanAssembleTest {
	public static void main(String[] args) {

		// 加载配置文件
		ApplicationContext applicationContext = 
						new ClassPathXmlApplicationContext("beans5.xml");
		// 构造方式输出结果
		System.out.println(applicationContext.getBean("user1"));
		// 设值方式输出结果
		System.out.println(applicationContext.getBean("user2"));
	}
}

```



执行程序后，控制台的输出结果如下所示，

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=3035:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter02\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\javax\annotation\jsr250-api\1.0\jsr250-api-1.0.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar com.awen.assemble.XmlBeanAssembleTest
User [username=柳小子, password=123456, list=["constructorvalue1", "constructorvalue2"]]
User [username=子小柳, password=654321, list=["setlistvalue1", "setlistvalue2"]]

Process finished with exit code 0

```



从运行结果可以看出，已经成功地使用基于XML装配的构造注入和设值注入两种方式装配了User实例。



OK , 到了现在 , 我们彻底不用再去程序中去改动了 , 要实现不同的操作 , 只需要在xml配置文件中进行修改 , 所谓的IoC,一句话搞定 : 对象由Spring 来创建 , 管理 , 装配 !

思考

user 对象是谁创建的 ?

【 user 对象是由Spring创建的 】

user 对象的属性是怎么设置的 ?

【user 对象的属性是由Spring容器设置的 】

这个过程就叫控制反转(IoC) :

控制 : 谁来控制对象的创建 , 传统应用程序的对象是由程序本身控制创建的 , 使用Spring后 , 对象是由Spring来创建的
反转 : 程序本身不创建对象 , 而变成被动的接收对象 .
依赖注入 : 就是利用set方法来进行注入的.

IOC是一种编程思想，由主动的编程变成被动的接收

可以通过newClassPathXmlApplicationContext去浏览一下底层源码 .

## 基于注解（Annotation）的装配

除了通过设值注入（Setter Injection）和构造注入（Constructor Injection）实现IoC，还可以通过Spring提供的注解方法实现IoC，这也是企业开发过程中最常用的一种IoC实现方式。

在Spring中，尽管使用XML配置文件可以实现Bean的装配工作，但如果应用中有很多Bean时，会导致XML配置文件过于臃肿，给后续的维护和升级工作带来一定的困难。为此，Spring提供了对Annotation（注解）技术的全面支持。

Spring中定义了一系列的注解，常用的注解如下所示。

* @Component：可以使用此注解描述Spring中的Bean，但它是一个泛化的概念，仅仅表示一个组件（Bean），并且可以作用在任何层次。使用时只需将该注解标注在相应类上即可。
* @Repository：用于将数据访问层（DAO层）的类标识为Spring中的Bean，其功能与@Component相同。
*  @Service：通常作用在业务层（Service层），用于将业务层的类标识为Spring中的Bean，其功能与@Component相同。
* @Controller：通常作用在控制层（如Spring MVC的Controller），用于将控制层的类标识为Spring中的Bean，其功能与@Component相同。
* @Autowired：用于对Bean的属性变量、属性的setter方法及构造方法进行标注，配合对应的注解处理器完成Bean的自动配置工作。默认按照Bean的类型进行装配。
* @Resource：其作用与Autowired一样。其区别在于@Autowired默认按照Bean类型装配，而@Resource默认按照Bean实例名称进行装配。@Resource中有两个重要属性：name和type。Spring将name属性解析为Bean实例名称，type属性解析为Bean实例类型。如果指定name属性，则按实例名称进行装配；如果指定type属性，则按Bean类型进行装配；如果都不指定，则先按Bean实例名称装配，如果不能匹配，再按照Bean类型进行装配；如果都无法匹配，则抛出NoSuchBeanDefinitionException异常。
* @Qualifier：与@Autowired注解配合使用，会将默认的按Bean类型装配修改为按Bean的实例名称装配，Bean的实例名称由@Qualifier注解的参数指定。在上面几个注解中，虽然@Repository、@Service与@Controller功能与@Component注解的功能相同，但为了使标注类本身用途更加清晰，建议在实际开发中使用@Repository、@Service与@Controller分别对实现类进行标注

下面，通过一个案例来演示如何通过这些注解来装配Bean。

（1）在chapter02模块的src/main/java目录下，创建一个com.awen.annotation包，在该包中创建接口UserDao，并在接口中定义一个save()方法，如文件所示。文件 UserDao.java	

```java
package com.awen.annotation;
public interface UserDao {
    public void save();
}

```





（2）在com.awen.annotation包中，创建UserDao接口的实现类UserDaoImpl，该类需要实现接口中的save()方法，如文件所示。文件 UserDaoImpl.java

```java
package com.awen.annotation;
import org.springframework.stereotype.Repository;
@Repository("userDao") 
public class UserDaoImpl implements UserDao{
   public void save(){
	  System.out.println("userdao...save...");
   }
}

```

在文件UserDaoImpl.java中，首先使用@Repository注解将UserDaoImpl类标识为Spring中的Bean，其写法相当于配置文件中`<bean id="userDao" class="com.awen.annotation.UserDaoImpl"/>`的编写。然后在save()方法中输出打印一句话，用于验证是否成功调用了该方法。



（3）在com.awen.annotation包中，创建接口UserService，在接口中同样定义一个save()方法，如文件所示。文件UserService.java

```java
package com.awen.annotation;
public interface UserService {
	public void save();
}

```

（4）在com.awen.annotation包中，创建UserService接口的实现类UserServiceImpl，该类需要实现接口中的save()方法，如文件所示。文件 UserServiceImpl.java

```java
package com.awen.annotation;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
@Service("userService") 
public class UserServiceImpl implements UserService{
	@Resource(name="userDao") 
	private UserDao userDao;
	public void save() {
         //调用userDao中的save方法
		this.userDao.save();
		System.out.println("userservice....save...");
	}
	
	
}

```

在文件 UserServiceImpl.java中，首先使用@Service注解将UserServiceImpl类标识为Spring中的Bean，这相当于配置文件中`<bean id="userService" class="com.itheima.annotation.UserServiceImpl"/>`的编写；然后使用@Resource注解标注在属性userDao上，这相当于配置文件中`<property name="userDao" ref="userDao"/>`的写法；最后在该类的save()方法中调用userDao中的save()方法，并输出一句话。



（5）在com.awen.annotation包中，创建控制器类UserController，编辑后如文件所示。文件UserController.java

```java
package com.awen.annotation;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
@Controller("userController")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	public void save(){
		this.userService.save();
		System.out.println("userController...save...");
	}
	
	
}

```



在文件UserController.java中，首先使用@Controller注解标注了UserController类，这相当于在配置文件中编写`<bean id="userController" class="com.itheima.annotation.UserController"/>`；然后使用了@Resource注解标注在userService属性上，这相当于在配置文件中编写`<property name="userService" ref="userService" />`；最后在其save()方法中调用了userService中的save()方法，并输出一句话。

（6）在src/main/resources目录下，创建配置文件beans6.xml，在配置文件中编写基于Annotation装配的代码，如文件所示。文件 beans6.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/beans 
      http://www.springframework.org/schema/beans/spring-beans.xsd
      http://www.springframework.org/schema/context 
  http://www.springframework.org/schema/context/spring-context.xsd">
	 <!-- 使用 context 命名空间 ,在配置文件中开启相应的注解处理器 -->
	 <context:annotation-config />
	 <!--分别定义3个Bean实例  -->
     <bean id="userDao" class="com.awen.annotation.UserDaoImpl" />
      <bean id="userService" 
		  class="com.awen.annotation.UserServiceImpl" />
      <bean id="userController" 
		  class="com.awen.annotation.UserController" />
	
</beans>

```

从上述代码可以看出，文件beans6.xml与之前的配置文件有很大不同。首先，在<beans>元素中，增加了第4行，第7行和第8行中包含有context的约束信息；然后通过配置<context:annotation-config />来开启注解处理器；最后分别定义了3个Bean对应所编写的3个实例。与XML装备方式有所不同的是，这里不再需要配置子元素`<property>`。

上述Spring配置文件中的注解方式虽然较大程度简化了XML文件中Bean的配置，但仍需要在Spring配置文件中一一配置相应的Bean，为此Spring注解提供了另外一种高效的注解配置方式（对包路径下的所有Bean文件进行扫描），其配置方式如下。

`  <context:component-scan base-package="Bean所在的包路径" /> `

所以可以将上述文件文件 beans6.xml中第9～16行代码进行如下替换（推荐）。

```xml
<!--使用 context 命名空间 ,通知Spring扫描指定包下所有Bean类，进行注解解析-->   
  <context:component-scan base-package="com.awen.annotation" /> 
```

（7）在com.awen.annotation包中，创建测试类AnnotationAssembleTest，在类中编写测试方法并定义配置文件的路径，然后通过Spring容器加载配置文件并获取UserController实例，最后调用实例中的save()方法，如文件所示。文件 AnnotationAssembleTest.java

```java
package com.awen.annotation;
import org.springframework.context.ApplicationContext;
import 
   org.springframework.context.support.ClassPathXmlApplicationContext;
public class AnnotationAssembleTest {
	public static void main(String[] args) {
		// 定义配置文件路径
		String xmlPath = "com/awen/annotation/beans6.xml";
		// 加载配置文件
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(xmlPath);
		// 获取UserController实例
		UserController userController = 
		  (UserController) applicationContext.getBean("userController");
		// 调用UserController中的save()方法
		userController.save();
	}
}  

```



总是出错 一叶障目

执行程序后，控制台的输出结果如图所示。

```bash
userdao...save...
userservice....save...
userController...save...
```



从运行结果可以看到，Spring容器已成功获取了UserController的实例，并通过调用实例中的方法执行了各层中的输出语句，这说明已成功实现了基于Annotation装配Bean

小提示上述案例中如果使用@Autowired注解替换@Resource注解，也可以达到同样的效果。

![image-20200214190533160](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\2-5-2.png)







**提示：** 除了可以像示例中通过<bean>元素来配置Bean外，还可以通过包扫描的形式来配置一个包下的所有Bean：

<context:component-scan base-package="com.awen.annotation" />

## 自动装配

虽然使用注解的方式装配Bean，在一定程度上减少了配置文件中的代码量，但是也有企业项目中，是没有使用注解方式开发的，那么有没有什么办法既可以减少代码量，又能够实现Bean的装配呢？答案是肯定的，Spring的<bean>元素中包含一个autowire属性，我们可以通过设置autowire的属性值来自动装配Bean。所谓自动装配，就是将一个Bean自动地注入到其他Bean的Property中。autowire属性有5个值，其值及说明如表所示。表<bean>元素的autowire属性值及说明

   

![image-20200214190600649](C:\Users\x1c\Desktop\Learning_Java\Reading\Java EE企业级应用开发教程（Spring+Spring MVC+MyBatis）\img\2-5-3.png)

​    自动装配，使用方式如下：

修改上一节UserServiceImple和UserController，分别增加类属性的setter方法；

修改Spring配置文件beans6.xml，将配置文件修改成自动装配形式，也就是使用autowire属性配置Bean；

重新测试程序。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/beans 
      http://www.springframework.org/schema/beans/spring-beans.xsd
      http://www.springframework.org/schema/context 
      http://www.springframework.org/schema/context/spring-context.xsd">
	 <!-- 使用 context 命名空间 ,在配置文件中开启相应的注解处理器 -->
<!--	  <context:annotation-config />-->
<!--	 &lt;!&ndash;分别定义3个Bean实例  &ndash;&gt;-->
<!--      <bean id="userDao" class="com.awen.annotation.UserDaoImpl" />-->
<!--      <bean id="userService"-->
<!--		  class="com.awen.annotation.UserServiceImpl" />-->
<!--      <bean id="userController"-->
<!--		  class="com.awen.annotation.UserController" />-->
	
	<!--使用 context 命名空间 ,通知Spring扫描指定包下所有Bean类，进行注解解析-->   
<!--     <context:component-scan base-package="com.awen.annotation" />-->
    
    <!-- 使用bean元素的autowire属性完成自动装配 -->
	<bean id="userDao"
		class="com.awen.annotation.UserDaoImpl" />
	<bean id="userService"
	  class="com.awen.annotation.UserServiceImpl" autowire="byName" />
	<bean id="userController"
	  class="com.awen.annotation.UserController" autowire="byName"/>
</beans>

```

   上述配置文件中，用于配置userService和userController的<bean>元素中除了id和class属性外，还增加了autowire属性，并将其属性值设置为byName。在默认情况下，配置文件中需要通过ref来装配Bean，但设置了autowire="byName"后，Spring会自动寻找userService Bean中的属性，并将其属性名称与配置文件中定义的Bean做匹配。由于UserServiceImpl中定义了userDao属性及其setter方法，这与配置文件中id为userDao的Bean相匹配，所以Spring会自动地将id为userDao的Bean装配到id为userService的Bean中。执行程序后，控制台的输出结果如下所示。 从运行结果可以看出，使用自动装配同样完成了依赖注入

```bash
D:\Environments\jdk-11.0.2\bin\java.exe -javaagent:D:\Java\ideaIU-2019.2.win\lib\idea_rt.jar=5574:D:\Java\ideaIU-2019.2.win\bin -Dfile.encoding=UTF-8 -classpath D:\IdeaProjects\JavaEE-enterprise-application-development-tutorial\chapter02\target\classes;D:\Environments\apache-maven-3.6.2\maven-repo\javax\annotation\jsr250-api\1.0\jsr250-api-1.0.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\Environments\apache-maven-3.6.2\maven-repo\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar com.awen.annotation.AnnotationAssembleTest
userdao...save...
userservice....save...
userController...save...

Process finished with exit code 0

```



手动装配 

自动装配  

- 自动装配是Spring满足bean依赖的一种方式！
- Spring会在上下文中自动寻找，并自动给bean装配属性！



在Spring中有三种装配的方式：

1. 在xml中显式配置；
2. 在java中显式配置；
3. 隐式的自动装配bean 重要 

Autowired  自动装配  

ByName自动装配

ByType自动装配

小结：

- byName的时候，需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致！
- byType的时候，需要保证所有bean的class唯一，并且这个bean需要和自动注入的属性的类型一致！

使用注解实现自动装配

jdk1.5支持注解，Spring2.5开始支持注解。

要使用注解须知：

1. 导入约束：context约束。

2. 配置注解的支持：<context:annot-config/>

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           https://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           https://www.springframework.org/schema/context/spring-context.xsd">
   
       <context:annotation-config/>
   
   </beans>
   ```

**@Autowired**

直接在属性上使用即可！也可以在set方式上使用！

使用Autowired我们可以不用编写Set方法了，前提是你这个自动装配的属性在IoC（Spring）容器中存在，且符合名字byName！

科普：

```java
@Nullable	字段标记了这个注解，说明这个字段可以为null
    public People(@Nullable String name){
    this.name = name;
}
```

```java
public @interface Autowired {
    boolean required() default true;
}
```

如果@Autowired自动装配的环境比较复杂，自动装配无法通过一个注解@Autowired完成的时候，我们可以使用@Qualifier(value="xxx")去配置@Autowired的使用，指定一个唯一的bean对象注入！



**@Resource注解**

小结：

@Resource和@Autowired的区别：

- 都是用来自动装配的，都可以放在属性字段上；
- @Autowired通过byType的方式实现，而且必须要求这个对象存在！【常用】
- @Resource默认通过byName的方式实现，如果找不到名字，则通过byType实现！如果两个都找不到的情况下，就报错！
- 执行顺序不同：@Autowired通过byType的方式实现，@Resource默认通过byName的方式实现。



在spring4之后，要使用注解开发，必须要保证aop的包导入了。

使用注解需要导入context约束，增加注解的支持！

```xml
<!--指定要扫描的包，这个包下的注解会生效-->
<context:component-scan base-package="com.kuang.pojo"/>
```

1. bean

2. 属性如何注入

   ```java
   //等价于<bean id="user" class="com.kuang.pojo.User"/>
   //@Component 组件
   @Component
   public class User {
       //相当于<property name="name" value="小憨批"/>
       public String name;
       @Value("小憨批")
       public void setName(String name){
           this.name = name;
       }
   }
   ```

3. 衍生的注解

   @Component有几个衍生注解，我们在web开发中，会按照mvc三层架构分层！

   - dao【@Repository】
   - service【@Service】
   - controller【@Controller】

   这四个注解功能都是一样的，都是代表将某个类注册到Spring中，装配Bean！

4. 自动装配

   ```
   -@Autowired:自动装配通过类型，名字
   	如果Autowired不能唯一自动装配上属性，则需要通过@Qualifier(value="xxx")
   -@Nullable:字段标记了这个注解，说明这个字段可以为null
   -@Resource:自动装配通过名字，类型
   ```

5. 作用域

   ```java
   @Scope("singleton")
   public class User {
       //相当于<property name="name" value="小憨批"/>
       public String name;
       @Value("小憨批")
       public void setName(String name){
           this.name = name;
       }
   }
   ```

6. 小结

   xml与注解：

   - xml更加万能，适用于任何场合！维护简单方便。
   - 注解，不是自己的类使用不了，维护相对复杂！

   xml与注解最佳实践：

   - xml用来管理bean；
   - 注解只负责完成属性的注入；
   - 我们在使用的过程中，只需要注意一个问题：必须让注解生效，就需要开启注解的支持。

   ```xml
    <!--指定要扫描的包，这个包下的注解会生效-->
   <context:component-scan base-package="com.awen"/>
   <context:annotation-config/>
   ```



 本章对Spring的Bean进行了详细讲解，首先介绍了Bean的配置，然后通过案例讲解了Bean实例化的三种方式，接下来介绍了Bean的作用域和生命周期，最后讲解了Bean的三种装配方式。

​    通过本章的学习，要求读者了解Bean的装配过程，并能使用Bean的装配进行开发。

作业&预习

✎ 本章作业 
请简述Bean的生命周期。
请简述Bean的几种装配方式的基本用法。
✎ 预习作业
什么是AOP ？
Spring有哪些通知类型？