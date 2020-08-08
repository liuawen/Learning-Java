### 1.Spring 的 AOP 简介

[TOC]

复习复习

Spring 的两大特性是什么？

 AOP（Aspect Oriented Programming，**面向切面编程**）与 IOC（Inverse of Control，**控制反转**）。





#### 1.1 什么是 AOP

AOP 为 Aspect Oriented Programming 的缩写，意思为面向切面编程，是通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术。

面向切面编程 预编译方式和运行期动态代理实现程序功能的统一维护

AOP 是 OOP 的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。

面向对象编程

面向切面编程 函数式编程

AOP  对业务逻辑的各个部分进行隔离   业务逻辑各部分之间的耦合度降低

提高程序的可重用性 提高了开发的效率  

Spring的IoC和AOP特性 

#### 1.2 AOP 的作用及其优势

作用：在程序运行期间，在不修改源码的情况下对方法进行功能增强

不改源码对方法进行功能增强 

优势：减少重复代码，提高开发效率，并且便于维护

耦合性降低  提高了可复用性  减少了重复代码 提高开发效率 便于维护

在程序运行期间 在不修改源码的情况下对方法进行功能增强。



改改改一片

功能抽取到外面 来引用  引用 

没法结合啦   

运行期间  结合起来 

松耦合  配置文件 结合

目标  功能增强  切面

减少重复代码 提高开发效率 并且便于维护

在程序运行期间 在不修改源码的情况下对方法进行功能增强

目标代码  功能增强  切面  

#### 1.3 AOP 的底层实现

实际上，AOP 的底层是通过 Spring 提供的的动态代理技术实现的。在运行期间，Spring通过动态代理技术动态的生成代理对象，代理对象方法执行时进行增强功能的介入，在去调用目标对象的方法，从而完成功能的增强。

AOP的底层是Spring提供的动态代理技术实现的

动态代理技术动态的生成代理对象 

代理对象方法执行时进行增强功能的介入 

在去调用目标对象的方法，从而完成功能的增强。

原理是什么呢？有哪些实现方法呢？

**Spring 的 AOP 的原理是什么？实现 AOP 有哪些方式？**

 Spring AOP 的底层使用的是动态代理，有两种实现方式：

 **JDK 动态代理**：利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用 InvokeHandler 来处理。

 **CGlib 动态代理**：以 CGLIB（Code Generation Library）的方式进行代理，它采用底层字节码技术，将代理对象类的 class 文件加载进来，通过修改其字节码生成子类来处理。

CGLIB 

 **区别**：JDK 代理只能对实现接口的类生成代理；CGLIB 是针对类实现代理，继承指定类并生成一个子类，因此不能代理 final 修饰的类。

 那么在 Spring 中，优先使用哪种 AOP 呢？

 （1）如果目标对象实现了接口，默认会采用 JDK 的动态代理，但也可以强制使用 CGLIB；

 （2）如果目标对象没有实现了接口，则必须采用 CGLIB 库。

 Spring 会自动在 JDK 动态代理和 CGLIB 之间转换。

#### 1.4 AOP 的动态代理技术

常用的动态代理技术

JDK 代理 : 基于接口的动态代理技术

cglib 代理：基于父类的动态代理技术

![](img\图片1.png)

JDK代理 基于接口的动态代理技术

cglib代理 基于父类的动态代理技术



 基于接口的动态代理技术   要有接口   基于接口生成

 目标对象 没有接口呢？ 没法完成JDK动态代理

cglib代理吧    基于父类的动态代理技术

有接口JDK代理

没有就第三方cglib代表呗



目标接口    

代理对象（运行期间动态生成的） 目标对象



目标对象  增强

增强 没接口呢  没办法依据接口来生成动态代理对象  

cglib  目标对象 动态的生成一个对象  这个对象基于它的   调用时调用代理对象 

介入



   

#### 1.5 JDK 的动态代理

①目标类接口

 ```java
public interface TargetInterface {
    public void method();
}
 ```

②目标类

目标类   实现接口的方法

```java
public class Target implements TargetInterface {
    @Override
    public void method() {
        System.out.println("Target running....");
    }
}
```

③动态代理代码

```java
Target target = new Target(); //创建目标对象
//创建代理对象
TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(target.getClass()
.getClassLoader(),target.getClass().getInterfaces(),new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) 
            throws Throwable {
                System.out.println("前置增强代码...");
                Object invoke = method.invoke(target, args);
                System.out.println("后置增强代码...");
                return invoke;
            }
        }
);
```

④  调用代理对象的方法测试

```java
// 测试,当调用接口的任何方法时，代理对象的代码都无序修改
proxy.method();
```



![](img\图片2.png)

TargetInterface

```java
public interface TargetInterface {
    public void save();
}

```

Target

```java
public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running...");
    }
}

```

Advice

```java
public class Advice {
    public void before(){
        System.out.println("前置增强...");
    }
    public void afterReturning(){
        System.out.println("后置增强...");
    }
}

```

ProxyTest

```java
public class ProxyTest {
    public static void main(String[] args) {
        //目标对象
        final Target target = new Target();
        //增强对象
        final Advice advice = new Advice();

        //代理对象
        //三个参数
        //返回值 就是动态生成的代理对象
        TargetInterface proxy=(TargetInterface) Proxy.newProxyInstance(
                //目标对象类加载器
                target.getClass().getClassLoader(),
                //目标对象相同的接口字节码对象数组 目标对象可能不止一个接口
                target.getClass().getInterfaces(),
                //
                new InvocationHandler() {
                    //invoke 调用代理对象的任何方法实质执行的都是invoke方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();//前置增强
                        Object invoke = method.invoke(target,args);//执行目标方法                        //执行目标方法
                        advice.afterReturning();//后置增强
                        return invoke;
                    }
                }
        );

        //调用代理对象的方法
        proxy.save();
    }
}

```



```bash
前置增强...
save running...
后置增强...

Process finished with exit code 0
```





#### 1.6 cglib 的动态代理

第三方的

导 cglib  jar包

Spring  core   org.springframework.cglib 

集成了 现在已经集成了 不需要导包了 

①目标类

  ```java
public class Target {
    public void method() {
        System.out.println("Target running....");
    }
}
  ```

②动态代理代码

```java
Target target = new Target(); //创建目标对象
Enhancer enhancer = new Enhancer();   //创建增强器
enhancer.setSuperclass(Target.class); //设置父类
enhancer.setCallback(new MethodInterceptor() { //设置回调
    @Override
    public Object intercept(Object o, Method method, Object[] objects, 
    MethodProxy methodProxy) throws Throwable {
        System.out.println("前置代码增强....");
        Object invoke = method.invoke(target, objects);
        System.out.println("后置代码增强....");
        return invoke;
    }
});
Target proxy = (Target) enhancer.create(); //创建代理对象

```



Advice

```java

public class Advice {

    public void before(){
        System.out.println("前置增强....");
    }

    public void afterReturning(){
        System.out.println("后置增强....");
    }

}

```

ProxyTest

```java
public class ProxyTest {

    public static void main(String[] args) {

        //目标对象
        final Target target = new Target();

        //增强对象
        final Advice advice = new Advice();

        //返回值 就是动态生成的代理对象  基于cglib
        //1、创建增强器
        Enhancer enhancer = new Enhancer();
        //2、设置父类（目标）
        enhancer.setSuperclass(Target.class);
        //3、设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                advice.before(); //执行前置
                Object invoke = method.invoke(target, args);//执行目标
                advice.afterReturning(); //执行后置
                return invoke;
            }
        });
        //4、创建代理对象
        Target proxy = (Target) enhancer.create();


        proxy.save();


    }

}
```





③调用代理对象的方法测试

```java
//测试,当调用接口的任何方法时，代理对象的代码都无序修改
proxy.method();
```





![](img\图片3.png)



Target

```java
public class Target {
    public void save() {
        System.out.println("save running.....");
    }
}

```



```java
public class Advice {
    public void before(){
        System.out.println("前置增强...");
    }
    public void afterReturning(){
        System.out.println("后置增强...");
    }
}

```



```java
public class ProxyTest {

    public static void main(String[] args) {

        //目标对象
        final Target target = new Target();

        //增强对象
        final Advice advice = new Advice();

        //返回值 就是动态生成的代理对象  基于cglib
        //1、创建增强器
        Enhancer enhancer = new Enhancer();
        //2、设置父类（目标）
        enhancer.setSuperclass(Target.class);
        //3、设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                advice.before(); //执行前置
                Object invoke = method.invoke(target, args);//执行目标
                advice.afterReturning(); //执行后置
                return invoke;
            }
        });
        //4、创建代理对象
        Target proxy = (Target) enhancer.create();


        proxy.save();


    }

}

```

返回值 就是动态生成的代理对象 基于cglib

创建增强器

设置父类（目标）

设置回调

创建代理对象



```bash
前置增强...
save running...
后置增强...

Process finished with exit code 0

```



掌握 

能看懂    目标增强  这些代码   Spring封装了 

实现一个AOP  配置即可

#### 1.7 AOP 相关概念

Spring 的 AOP 实现底层就是对上面的动态代理的代码进行了封装，封装后我们只需要对需要关注的部分进行代码编写，并通过配置的方式完成指定目标的方法增强。

Spring的AOP实现底层就是对上面的动态代理的代码进行了封装  

只需要关注的部分进行代码编写 通过配置的方式完成指定目标的方法增强

配置的方式  完成 指定目标的方法    增强  

在正式讲解 AOP 的操作之前，我们必须理解 AOP 的相关术语，常用的术语如下：

- Target（目标对象）：代理的目标对象    要被增强的对象  方法 

- Proxy （代理）：一个类被 AOP 织入增强后，就产生一个结果代理类  代理对象

- Joinpoint（连接点）：所谓连接点是指那些被拦截到的点。在spring中,这些点指的是方法，因为spring只支持方法类型的连接点

  连接点  那些被拦截的点  拦截到的方法  增强  连接点   joinpoint  在Spring中 这些点 就是可以被增强的方法  连接点 

- Pointcut（切入点）：所谓切入点是指我们要对哪些 Joinpoint 进行拦截的定义

  连接点 可以被增强的方法 Joinpoint  什么是切点呢  连接点 配置   增强了 切入点了  

  

- Advice（通知/ 增强）：所谓通知是指拦截到 Joinpoint 之后所要做的事情就是通知

  通知   对目标方法增强的那个方法 增强   截到了之后被增强那段代码   增强逻辑 放到一个方法中  通知  

- Aspect（切面）：是切入点和通知（引介）的结合

  切面  目标方法 + 增强  术语 切点+通知   是切入点和通知（引介）的结合 

- Weaving（织入）：是指把增强应用到目标对象来创建新的代理对象的过程。spring采用动态代理织入，而AspectJ采用编译期织入和类装载期织入

  织入  切点 增强 通知 结合到一起的过程  配置  

切点   通知   切面    配置的过程  织入  

1.8 AOP 开发明确的事项

#### 1.8 AOP 开发明确的事项

##### 1)需要编写的内容

- 编写核心业务代码（目标类的目标方法）
- 编写切面类，切面类中有通知(增强功能方法)
- 在配置文件中，配置织入关系，即将哪些通知与哪些连接点进行结合

编写核心业务代码  目标类的目标方法

编写切面类 切面类中有通知 增强功能方法 

在配置文件中 配置织入关系 即将哪些通知与哪些连接点进行结合

##### 2）AOP 技术实现的内容

Spring 框架监控切入点方法的执行。一旦监控到切入点方法被运行，使用代理机制，动态创建目标对象的代理对象，根据通知类别，在代理对象的对应位置，将通知对应的功能织入，完成完整的代码逻辑运行。

AOP技术实现的内容



##### 3）AOP 底层使用哪种代理方式

在 spring 中，框架会根据目标类是否实现了接口来决定采用哪种动态代理的方式。

#### 1.9 知识要点

- aop：面向切面编程

- aop底层实现：基于JDK的动态代理 和 基于Cglib的动态代理

- aop的重点概念：

        Pointcut（切入点）：被增强的方法
    
        Advice（通知/ 增强）：封装增强业务逻辑的方法
    
        Aspect（切面）：切点+通知
    
        Weaving（织入）：将切点与通知结合的过程

- 开发明确事项：

        谁是切点（切点表达式配置）
    
        谁是通知（切面类中的增强方法）
    
        将切点和通知进行织入配置

### 2. 基于 XML 的 AOP 开发

#### 2.1 快速入门

①导入 AOP 相关坐标

②创建目标接口和目标类（内部有切点）

③创建切面类（内部有增强方法）

④将目标类和切面类的对象创建权交给 spring

⑤在 applicationContext.xml 中配置织入关系

⑥测试代码





①导入 AOP 相关坐标

```xml
<!--导入spring的context坐标，context依赖aop-->
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>5.0.5.RELEASE</version>
</dependency>
<!-- aspectj的织入 -->
<dependency>
  <groupId>org.aspectj</groupId>
  <artifactId>aspectjweaver</artifactId>
  <version>1.8.13</version>
</dependency>
```

②创建目标接口和目标类（内部有切点）

```java
public interface TargetInterface {
    public void method();
}

public class Target implements TargetInterface {
    @Override
    public void method() {
        System.out.println("Target running....");
    }
}
```

③创建切面类（内部有增强方法）

```java
public class MyAspect {
    //前置增强方法
    public void before(){
        System.out.println("前置代码增强.....");
    }
}
```

④将目标类和切面类的对象创建权交给 spring

```xml
<!--配置目标类-->
<bean id="target" class="cn.liuawen.aop.Target"></bean>
<!--配置切面类-->
<bean id="myAspect" class="cn.liuawen.aop.MyAspect"></bean>

```

⑤在 applicationContext.xml 中配置织入关系

导入aop命名空间

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

```

⑤在 applicationContext.xml 中配置织入关系

配置切点表达式和前置增强的织入关系

```xml
<aop:config>
    <!--引用myAspect的Bean为切面对象-->
    <aop:aspect ref="myAspect">
        <!--配置Target的method方法执行时要进行myAspect的before方法前置增强-->
        <aop:before method="before" pointcut="execution(public void cn.liuawen.aop.Target.method())"></aop:before>
    </aop:aspect>
</aop:config>
```

⑥测试代码

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {
    @Autowired
    private TargetInterface target;
    @Test
    public void test1(){
        target.method();
    }
}
```

⑦测试结果

![](img\图片4.png)

#### 2.2 XML 配置 AOP 详解

##### 1) 切点表达式的写法

表达式语法：

```java
execution([修饰符] 返回值类型 包名.类名.方法名(参数))
```

- 访问修饰符可以省略

- 返回值类型、包名、类名、方法名可以使用星号*  代表任意

- 包名与类名之间一个点 . 代表当前包下的类，两个点 .. 表示当前包及其子包下的类

- 参数列表可以使用两个点 .. 表示任意个数，任意类型的参数列表

例如：

```xml
execution(public void cn.liuawen.aop.Target.method())	
execution(void cn.liuawen.aop.Target.*(..))
execution(* cn.liuawen.aop.*.*(..))
execution(* cn.liuawen.aop..*.*(..))
execution(* *..*.*(..))
```

##### 2) 通知的类型

通知的配置语法：

```xml
<aop:通知类型 method=“切面类中方法名” pointcut=“切点表达式"></aop:通知类型>
```

![](img\图片5.png)

##### 3) 切点表达式的抽取

当多个增强的切点表达式相同时，可以将切点表达式进行抽取，在增强中使用 pointcut-ref 属性代替 pointcut 属性来引用抽取后的切点表达式。

```xml
<aop:config>
    <!--引用myAspect的Bean为切面对象-->
    <aop:aspect ref="myAspect">
        <aop:pointcut id="myPointcut" expression="execution(* cn.liuawen.aop.*.*(..))"/>
        <aop:before method="before" pointcut-ref="myPointcut"></aop:before>
    </aop:aspect>
</aop:config>
```

#### 2.3 知识要点

- aop织入的配置

```xml
<aop:config>
    <aop:aspect ref=“切面类”>
        <aop:before method=“通知方法名称” pointcut=“切点表达式"></aop:before>
    </aop:aspect>
</aop:config>
```

- 通知的类型：前置通知、后置通知、环绕通知、异常抛出通知、最终通知
- 切点表达式的写法：

```xml
execution([修饰符] 返回值类型 包名.类名.方法名(参数))
```

### 3.基于注解的 AOP 开发

#### 3.1 快速入门

基于注解的aop开发步骤：

①创建目标接口和目标类（内部有切点）

②创建切面类（内部有增强方法）

③将目标类和切面类的对象创建权交给 spring

④在切面类中使用注解配置织入关系

⑤在配置文件中开启组件扫描和 AOP 的自动代理

⑥测试



①创建目标接口和目标类（内部有切点）

```java
public interface TargetInterface {
    public void method();
}

public class Target implements TargetInterface {
    @Override
    public void method() {
        System.out.println("Target running....");
    }
}
```

②创建切面类（内部有增强方法)

```java
public class MyAspect {
    //前置增强方法
    public void before(){
        System.out.println("前置代码增强.....");
    }
}
```

③将目标类和切面类的对象创建权交给 spring

```java
@Component("target")
public class Target implements TargetInterface {
    @Override
    public void method() {
        System.out.println("Target running....");
    }
}
@Component("myAspect")
public class MyAspect {
    public void before(){
        System.out.println("前置代码增强.....");
    }
}
```

④在切面类中使用注解配置织入关系

```java
@Component("myAspect")
@Aspect
public class MyAspect {
    @Before("execution(* cn.liuawen.aop.*.*(..))")
    public void before(){
        System.out.println("前置代码增强.....");
    }
}
```

⑤在配置文件中开启组件扫描和 AOP 的自动代理

```xml
<!--组件扫描-->
<context:component-scan base-package="cn.liuawen.aop"/>

<!--aop的自动代理-->
<aop:aspectj-autoproxy></aop:aspectj-autoproxy>

```

⑥测试代码

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {
    @Autowired
    private TargetInterface target;
    @Test
    public void test1(){
        target.method();
    }
}
```

⑦测试结果

![](img\图片6.png)

#### 3.2 注解配置 AOP 详解

##### 1) 注解通知的类型

通知的配置语法：@通知注解(“切点表达式")

![](img\图片7.png)

##### 2) 切点表达式的抽取

同 xml配置
aop 一样，我们可以将切点表达式抽取。抽取方式是在切面内定义方法，在该方法上使用@Pointcut注解定义切点表达式，然后在在增强注解中进行引用。具体如下：

```java
@@Component("myAspect")
@Aspect
public class MyAspect {
    @Before("MyAspect.myPoint()")
    public void before(){
        System.out.println("前置代码增强.....");
    }
    @Pointcut("execution(* cn.liuawen.aop.*.*(..))")
    public void myPoint(){}
}
```

#### 3.3 知识要点

- 注解aop开发步骤

①使用@Aspect标注切面类

②使用@通知注解标注通知方法

③在配置文件中配置aop自动代理<aop:aspectj-autoproxy/>



- 通知注解类型

![](img\图片8.png)



​    

















   



 



