# Spring框架面试题

## 问：说说你理解的Spring？

**参考答案：**

​	Spring是一个开源框架，它由Rod Johnson创建，是为解决企业应用开发的复杂性而创建的。Spring使用基本的JavaBean来完成以前只可能由EJB完成的事情。然而，Spring的用途不仅限于服务器端的开发。从简单性、可测试性和松耦合的角度而言，任何Java应用都可以从Spring中受益。

**（1）、 目的**：解决企业应用开发的复杂性；

**（2）、功能**：使用基本的JavaBean代替EJB，并提供了更多的企业应用功能；

**（3）、范围**：任何Java应用；

（4）、简单来说，Spring是一个轻量级的控制反转(IoC)和面向切面(AOP)的容器框架；

**（5）、轻量：** 从大小与开销两方面而言Spring都是轻量的。完整的Spring框架可以在一个大小只有1MB多的JAR文件里发布。并且Spring所需的处理开销也是微不足道的。此外，Spring是非侵入式的：典型地，Spring应用中的对象不依赖于Spring的特定类。

（**6）、控制反转：** Spring通过一种称作控制反转（IoC）的技术促进了松耦合。当应用了IoC，一个对象依赖的其它对象会通过被动的方式传递进来，而不是这个对象自己创建或者查找依赖对象。你可以认为IoC与JNDI相反——不是对象从容器中查找依赖，而是容器在对象初始化时不等对象请求就主动将依赖传递给它。

**（7）、面向切面：** Spring提供了面向切面编程的丰富支持，允许通过分离应用的业务逻辑与系统级服务（例如审计（auditing）和事务（）管理）进行内聚性的开发。应用对象只实现它们应该做的——完成业务逻辑——仅此而已。它们并不负责（甚至是意识）其它的系统级关注点，例如日志或事务支持。

**（8）、容器：** Spring包含并管理应用对象的配置和生命周期，在这个意义上它是一种容器，你可以配置你的每个bean如何被创建——基于一个可配置原型（prototype），你的bean可以创建一个单独的实例或者每次需要时都生成一个新的实例——以及它们是如何相互关联的。然而，Spring不应该被混同于传统的重量级的EJB容器，它们经常是庞大与笨重的，难以使用。

**（9）、框架：** Spring可以将简单的组件配置、组合成为复杂的应用。在Spring中，应用对象被声明式地组合，典型地是在一个XML文件里。Spring也提供了很多基础功能（事务管理、持久化框架集成等等），将应用逻辑的开发留给了你。

所有Spring的这些特征使你能够编写更干净、更可管理、并且更易于测试的代码。它们也为Spring中的各种模块提供了基础支持。



## 问：**选择使用Spring框架的原因（Spring框架为企业级开发带来的好处有哪些）？**

**参考答案：**

​	可以从以下几个方面作答：

**（1）、非侵入式**：支持基于POJO的编程模式，不强制性的要求实现Spring框架中的接口或继承Spring框架中的类。

**（2）、** **IoC容器**：IoC容器帮助应用程序管理对象以及对象之间的依赖关系，对象之间的依赖关系如果发生了改变只需要修改配置文件而不是修改代码，因为代码的修改可能意味着项目的重新构建和完整的回归测试。有了IoC容器，程序员再也不需要自己编写工厂、单例，这一点特别符合Spring的精神"不要重复的发明轮子"。

**（3）、AOP（面向切面编程）**：将所有的横切关注功能封装到切面（aspect）中，通过配置的方式将横切关注功能动态添加到目标代码上，进一步实现了业务逻辑和系统服务之间的分离。另一方面，有了AOP程序员可以省去很多自己写代理类的工作。

**（4）、 MVC**：Spring的MVC框架是非常优秀的，为Web表示层提供了更好的解决方案；

**（5）、事务管理**：Spring以宽广的胸怀接纳多种持久层技术，并且为其提供了声明式的事务管理，在不需要任何一行代码的情况下就能够完成事务管理。

**（6）、其他**：选择Spring框架的原因还远不止于此，Spring为Java企业级开发提供了一站式选择，你可以在需要的时候使用它的部分和全部，更重要的是，你甚至可以在感觉不到Spring存在的情况下，在你的项目中使用Spring提供的各种优秀的功能。



## 问：为什么使用Spring？

**参考答案：**

**（1）、方便解耦，简化开发**

​		通过Spring提供的IoC容器，我们可以将对象之间的依赖关系交由Spring进行控制，避免硬编码所造成的过度程序耦合。有了Spring，用户不必再为单实例模式类、属性文件解析等这些很底层的需求编写代码，可以更专注于上层的应用。

**（2）、AOP编程的支持**

​		通过Spring提供的AOP功能，方便进行面向切面的编程，许多不容易用传统OOP实现的功能可以通过AOP轻松应付。

**（3）、声明事物的支持**

​		在Spring中，我们可以从单调烦闷的事务管理代码中解脱出来，通过声明式方式灵活地进行事务的管理，提高开发效率和质量。

**（4）、方便程序的测试**

​		可以用非容器依赖的编程方式进行几乎所有的测试工作，在Spring里，测试不再是昂贵的操作，而是随手可做的事情。例如：Spring对Junit4支持，可以通过注解方便的测试Spring程序。

**（5）、方便集成各种优秀框架**

​		Spring不排斥各种优秀的开源框架，相反，Spring可以降低各种框架的使用难度，Spring提供了对各种优秀框架（如Struts,Hibernate、Hessian、Quartz）等的直接支持。

**（6）、降低Java EE API的使用难度**

​		Spring对很多难用的Java EE API（如JDBC，JavaMail，远程调用等）提供了一个薄薄的封装层，通过Spring的简易封装，这些Java EE API的使用难度大为降低。

**（7）、Java 源码是经典学习范例**

​		Spring的源码设计精妙、结构清晰、匠心独用，处处体现着大师对Java设计模式灵活运用以及对Java技术的高深造诣。Spring框架源码无疑是Java技术的最佳实践范例。如果想在短时间内迅速提高自己的Java技术水平和应用开发水平，学习和研究Spring源码将会使你收到意想不到的效果。



## 问：Spring能做什么？

**参考答案：**

**（1）、Spring提供许多功能,在此我将快速地依次展示其各个主要方面。**

​		首先,让我们明确Spring范围。尽管Spring覆盖了许多方面，但我们已经有清楚的概念，它什么应该涉及和什么不应该涉及。

**（2）、Spring的主要目的是使J2EE易用和促进好编程习惯。**

​		Spring不重新开发已有的东西。因此，在Spring中你将发现没有日志记录的包,没有连接池,没有分布事务调度。这些 均有开源项目提供(例如Commons Logging 用来做所有的日志输出，或Commons DBCP用来作数据连接池),或由你的应用程序服务器提供。因为同样的的原因，我们没有提供O/R mapping层，对此，已有有好的解决办法如Hibernate和JDO。

**（3）、Spring的目标是使已存在的技术更加易用。**

​		例如,尽管我们没有底层事务协调处理，但我们提供了一个抽象层覆盖了JTA或任何其他的事务策略。

​		Spring没有直接和其他的开源项目竞争，除非我们感到我们能提供新的一些东西。例如，象许多开发人员，我们从来没有为Struts高兴过，并且感到在MVC web framework中还有改进的余地。在某些领域，例如轻量级的IoC容器和AOP框架，Spring有直接的竞争，但是在这些领域还没有已经较为流行的解决方案。(Spring在这些区域是开路先锋。)

**（4）、Spring也得益于内在的一致性。**

​		所有的开发者都在唱同样的的赞歌,基础想法依然是Expert One-on-One J2EE设计与开发的那些。并且我们已经能够使用一些主要的概念,例如倒置控制，来处理多个领域。

**（5）、Spring在应用服务器之间是可移植的。**   

​		当然保证可移植性总是一次挑战，但是我们避免任何特定平台或非标准化,并且支持在WebLogic，Tomcat，Resin，JBoss，WebSphere和其他的应用服务器上的用户。



## 问：Spring有哪些常用的 Context？

**参考答案：**

​		最常被使用的 ApplicationContext 接口实现：

​		（1）、FileSystemXmlApplicationContext：该容器从 XML 文件中加载已被定义的 bean。在这里，你需要提供给构造器 XML 文件的完整路径；

​		（2）、ClassPathXmlApplicationContext：该容器从 XML 文件中加载已被定义的 bean。在这里，你不需要提供 XML 文件的完整路径，只需正确配置 CLASSPATH 环境变量即可，因为，容器会从 CLASSPATH 中搜索 bean 配置文件。

​		（3）、WebXmlApplicationContext：该容器会在一个 web 应用程序的范围内加载在 XML 文件中已被定义的bean。



## 问：**Spring中自动装配的方式有哪些？**

**参考答案：**

（1）no：不进行自动装配，手动设置Bean的依赖关系；

（2）byName：根据Bean的名字进行自动装配。

（3）byType：根据Bean的类型进行自动装配。

（4）constructor：类似于byType，不过是应用于构造器的参数，如果正好有一个Bean与构造器的参数类型相同则可以自动装配，否则会导致错误。

（5）autodetect：如果有默认的构造器，则通过constructor的方式进行自动装配，否则使用byType的方式进行自动装配。

> **说明：** 自动装配没有自定义装配方式那么精确，而且不能自动装配简单属性（基本类型、字符串等），在使用时应注意。



## 问：**Spring中如何使用注解来配置Bean？有哪些相关的注解？**

**参考答案：** 首先需要在Spring配置文件中增加如下配置：

```xml
<context:component-scan base-package="org.example"/>
```

然后可以用@Component、@Controller、@Service、@Repository注解来标注需要由Spring IoC容器进行对象托管的类。这几个注解没有本质区别，只不过@Controller通常用于控制器，@Service通常用于业务逻辑类，@Repository通常用于仓储类（例如我们的DAO实现类），普通的类用@Component来标注。

## 问：Spring的事务底层原理？

**参考答案：**

(1）、划分处理单元——IOC

​		由于spring解决的问题是对单个数据库进行局部事务处理的，具体的实现首相用spring中的IOC划分了事务处理单元。并且将对事务的各种配置放到了IOC容器中（设置事务管理器，设置事务的传播特性及隔离机制）。

(2）、AOP拦截需要进行事务处理的类

​		Spring事务处理模块是通过AOP功能来实现声明式事务处理的，具体操作（比如事务实行的配置和读取，事务对象的抽象），用TransactionProxyFactoryBean接口来使用AOP功能，生成proxy代理对象，通过TransactionInterceptor完成对代理方法的拦截，将事务处理的功能编织到拦截的方法中。读取ioc容器事务配置属性，转化为spring事务处理需要的内部数据结构（TransactionAttributeSourceAdvisor），转化为TransactionAttribute表示的数据对象。

(3）、对事物处理实现（事务的生成、提交、回滚、挂起）

​		spring委托给具体的事务处理器实现。实现了一个抽象和适配。适配的具体事务处理器：DataSource数据源支持、hibernate数据源事务处理支持、JDO数据源事务处理支持，JPA、JTA数据源事务处理支持。这些支持都是通过设计PlatformTransactionManager、AbstractPlatforTransaction一系列事务处理的支持。 为常用数据源支持提供了一系列的TransactionManager。

(4）、结合

​		PlatformTransactionManager实现了TransactionInterception接口，让其与TransactionProxyFactoryBean结合起来，形成一个Spring声明式事务处理的设计体系。



## 问： Spring 中的事务传播行为了解吗?TransactionDefinition 接口中哪五个表示隔离级别的常量?

**参考答案：**

​		事务传播行为（为了解决业务层方法之间互相调用的事务问题）： 当事务方法被另一个事务方法调用时，必须指定事务应该如何传播。例如：方法可能继续在现有事务中运行，也可能开启一个新事务，并在自己的事务中运行。在TransactionDefinition定义中包括了如下几个表示传播行为的常量：

**支持当前事务的情况：**

- TransactionDefinition.PROPAGATION_REQUIRED： 如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
- TransactionDefinition.PROPAGATION_SUPPORTS： 如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
- TransactionDefinition.PROPAGATION_MANDATORY： 如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。（mandatory：强制性）

**不支持当前事务的情况：**

- TransactionDefinition.PROPAGATION_REQUIRES_NEW： 创建一个新的事务，如果当前存在事务，则把当前事务挂起（新事务回滚不会影响当前事务）。
- TransactionDefinition.PROPAGATION_NOT_SUPPORTED： 以非事务方式运行，如果当前存在事务，则把当前事务挂起。
- TransactionDefinition.PROPAGATION_NEVER： 以非事务方式运行，如果当前存在事务，则抛出异常。

**其他情况：**

- TransactionDefinition.PROPAGATION_NESTED： 如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED（创建一个新事务）。

#### 隔离级别

TransactionDefinition 接口中定义了五个表示隔离级别的常量：

- **TransactionDefinition.ISOLATION_DEFAULT:** 使用后端数据库默认的隔离级别，Mysql 默认采用的 REPEATABLE_READ隔离级别 Oracle 默认采用的 READ_COMMITTED隔离级别.
- **TransactionDefinition.ISOLATION_READ_UNCOMMITTED:** 最低的隔离级别，允许读取尚未提交的数据变更，可能会导致脏读、幻读或不可重复读
- **TransactionDefinition.ISOLATION_READ_COMMITTED:** 允许读取并发事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生
- **TransactionDefinition.ISOLATION_REPEATABLE_READ:** 对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，但幻读仍有可能发生。
- **TransactionDefinition.ISOLATION_SERIALIZABLE:** 最高的隔离级别，完全服从ACID的隔离级别。所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。但是这将严重影响程序的性能。通常情况下也不会用到该级别。



## 问：@Transactional 失效？

**参考答案：**

​		@Transactional 注解应该只被应用到 public 方法上，这是由 Spring AOP 的本质决定的。如果你在 protected、private 或者默认可见性的方法上使用 @Transactional 注解，这将被忽略，也不会抛出任何异常。

​		默认情况下，只有来自外部的方法调用才会被AOP代理捕获，也就是，类内部方法调用本类内部的其他方法并不会引起事务行为，即使被调用方法使用@Transactional注解进行修饰。



## 问：Spring MVC的工作原理是怎样的？/请简介下SpringMVC处理一个请求的流程？

**参考答案：**

​		Spring MVC的工作原理如下图所示：

![Spring的MVC处理过程.jpg](https://i.loli.net/2020/04/30/U5NYHrxeRlVcqhy.png)

   （1）、客户端的所有请求都交给前端控制器DispatcherServlet来处理，它会负责调用系统的其他模块来真正处理用户的请求。

  (2）、DispatcherServlet收到请求后，将根据请求的信息（包括URL、HTTP协议方法、请求头、请求参数、Cookie等）以及HandlerMapping的配置找到处理该请求的Handler（任何一个对象都可以作为请求的Handler）。

（3）、在这个地方Spring会通过HandlerAdapter对该处理器进行封装。

（4）、HandlerAdapter是一个适配器，它用统一的接口对各种Handler中的方法进行调用。

（5）、Handler完成对用户请求的处理后，会返回一个ModelAndView对象给DispatcherServlet，ModelAndView顾名思义，包含了数据模型以及相应的视图的信息。

（6）、ModelAndView的视图是逻辑视图，DispatcherServlet还要借助ViewResolver完成从逻辑视图到真实视图对象的解析工作。

（7）、 当得到真正的视图对象后，DispatcherServlet会利用视图对象对模型数据进行渲染。

（8）、客户端得到响应，可能是一个普通的HTML页面，也可以是XML或JSON字符串，还可以是一张图片或者一个PDF文件。



## 问：Spring框架由哪些模块组成？

**参考答案：**

- Core module
- Bean module
- Context module
- Expression Language module
- JDBC module
- ORM module
- OXM module
- beJava Messaging Service(JMS) module
- Transaction module
- Web module
- Web-Servlet module
- Web-Struts module
- Web-Portlet module



## 问： Spring支持的几种bean的作用域？

**参考答案：**

（1）、singleton : bean在每个Spring ioc 容器中只有一个实例。默认的缺省。

（2）、prototype：一个bean的定义可以有多个实例。

（3）、request：每次http请求都会创建一个bean，该作用域仅在基于web的Spring ApplicationContext情形下有效。

（4）、session：在一个HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring

（5）、global-session：在一个全局的HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring ApplicationContext情形下有效。

默认的Spring bean 的作用域是Singleton.



## 问：Spring框架中的单例bean是线程安全的吗?

**参考答案：**

不，Spring框架中的单例bean不是线程安全的。



## 问：**Spring IoC容器配置Bean的方式？**

**参考答案：**

（1）、基于XML文件进行配置；

（2）、基于注解进行配置；

（3）、基于Java程序进行配置（Spring 3+）



## 问： Spring IoC的实现原理？

**参考答案：**

工厂模式+反射机制

（1）、 加载配置文件，解析成 BeanDefinition 放在 Map 里；

（2）、调用 getBean 的时候，从 BeanDefinition 所属的 Map 里，拿出 Class 对象进行实例化，同时，如果有依赖关系，将递归调用 getBean 方法 —— 完成依赖注入。



## 问： BeanFactory 和 ApplicationContext 有什么区别？

**参考答案：**

 BeanFactory和ApplicationContext是Spring的两大核心接口，都可以当做Spring的容器。其中ApplicationContext是BeanFactory的子接口。

（1）BeanFactory：是Spring里面最底层的接口，包含了各种Bean的定义，读取bean配置文档，管理bean的加载、实例化，控制bean的生命周期，维护bean之间的依赖关系。ApplicationContext接口作为BeanFactory的派生，除了提供BeanFactory所具有的功能外，还提供了更完整的框架功能：
   ①继承MessageSource，因此支持国际化。
   
   ②统一的资源文件访问方式。
   
   ③提供在监听器中注册bean的事件。
   
   ④同时加载多个配置文件。
   
   ⑤载入多个（有继承关系）上下文 ，使得每一个上下文都专注于一个特定的层次，比如应用的web层。

（2）创建Bean的时机不一样：

   ①BeanFactroy采用的是延迟加载形式来注入Bean的，即只有在使用到某个Bean时(调用getBean())，才对该Bean进行加载实例化。这样，我们就不能发现一些存在的Spring的配置问题。如果Bean的某一个属性没有注入，BeanFacotry加载后，直至第一次使用调用getBean方法才会抛出异常。
   
   ②ApplicationContext，它是在容器启动时，一次性创建了所有的Bean。这样，在容器启动时，我们就可以发现Spring中存在的配置错误，这样有利于检查所依赖属性是否注入。 ApplicationContext启动后预载入所有的单实例Bean，通过预载入单实例bean ,确保当你需要的时候，你就不用等待，因为它们已经创建好了。
   
   ③相对于基本的BeanFactory，ApplicationContext 唯一的不足是占用内存空间。当应用程序配置Bean较多时，程序启动较慢。

（3）BeanFactory通常以编程的方式被创建，ApplicationContext还能以声明的方式创建，如使用ContextLoader。

（4）BeanFactory和ApplicationContext都支持BeanPostProcessor、BeanFactoryPostProcessor的使用，但两者之间的区别是：BeanFactory需要手动注册，而ApplicationContext则是自动注册。



## 问：你如何理解AOP中的连接点（Joinpoint）、切入点（Pointcut）、增强（Advice）、引介（Introduction）、织入（Weaving）、切面（Aspect）、目标对象（Target）、代理对象（Proxy）这些概念？

**参考答案：**

​		**连接点（Joinpoint）**：就是程序在运行过程中能够插入切面的地点。例如，方法调用、异常抛出或字段修改等，但Spring只支持方法级的连接点。

​		**切入点（Pointcut）**：如果连接点相当于数据中的记录，那么切入点相当于查询条件，一个切入点可以匹配多个连接点。Spring AOP的规则解析引擎负责解析切点所设定的查询条件，找到对应的连接点。

​		**增强（Advice）**：是切面的具体实现。以目标方法为参照点，根据放置的地方不同，可分为前置增加（Before）、后置增加（After Returning）、异常增加（After Throwing）、最终增加（After）与环绕增加（Around）5种。在实际应用中通常是切面类中的一个方法，具体属于哪类增加，同样是在配置中指定的。

> **说明：** Advice在国内的很多书面资料中都被翻译成"通知"，但是很显然这个翻译无法表达其本质，有少量的读物上将这个词翻译为"增强"，这个翻译是对Advice较为准确的诠释，我们通过AOP将横切关注功能加到原有的业务逻辑上，这就是对原有业务逻辑的一种增强。

​		**引介（Introduction）**：引介是一种特殊的**增强**，它为类添加一些属性和方法。这样，即使一个业务类原本没有实现某个接口，通过引介功能，可以动态的未该业务类添加接口的实现逻辑，让业务类成为这个接口的实现类。

​	   **织入（Weaving）**：织入是将**增强**添加到**目标类**具体**连接点上**的过程，AOP有三种织入方式：①编译期织入：需要特殊的Java编译期（例如AspectJ的ajc）；②装载期织入：要求使用特殊的类加载器，在装载类的时候对类进行增强；③运行时织入：在运行时为目标类生成代理实现增强。Spring采用了动态代理的方式实现了运行时织入，而AspectJ采用了编译期织入和装载期织入的方式。

​		**切面（Aspect）**：其实就是共有功能的实现。如日志切面、权限切面、事务切面等。在实际应用中通常是一个存放共有功能实现的普通Java类，之所以能被AOP容器识别成切面，是在配置中指定的。

​		**目标对象（Target）**：就是那些即将切入切面的对象，也就是那些被通知的对象。这些对象中已经只剩下干干净净的核心业务逻辑代码了，所有的共有功能代码等待AOP容器的切入。

​		**代理对象（Proxy）**：将通知应用到目标对象之后被动态创建的对象。可以简单地理解为，代理对象的功能等于目标对象的核心业务逻辑功能加上共有功能。代理对象对于使用者而言是透明的，是程序运行过程中的产物。



## 问：将一个请求url指向一个类的方法的注解是？

**参考答案：**

@RequestMapping



## 问：将前台的form中input控件的name属性绑定到控制器类中的方法参数的注解是？

**参考答案：**

​	@RequestParam



## 问：SpringMVC的控制器是单例的吗?为什么？

**参考答案：**

​		**默认是单例。** 主要原因是为了提高程序的性能和以后程序的维护只针对业务的维护就行（也不需要多例，因为一般不会在控制器中定义成员变量，如果非要定义一个非静态成员变量时候，则通过注解@Scope(“prototype”)，将其设置为多例模式）

​		参考：https://www.javazhiyin.com/59594.html



- 其他常见的Spring面试题还可以参见：http://ifeve.com/spring-interview-questions-and-answers/

####  

####  

#### 
