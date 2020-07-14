**28 带你解锁AOP的各种姿势**

28 带你解锁AOP的各种姿势

更新时间：2020-05-27 16:02:41

![img](http://img2.sycdn.imooc.com/5ebe6287000112bf06400427.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

世界上最快乐的事，莫过于为理想而奋斗。

——苏格拉底



# 1. 前情提要

上一节中，我们介绍了什么是 AOP 和 AOP 中的一些核心概念，以及我们为什么要用 AOP。那么这一节，我们一起看看 AOP 可以用在哪里，以及如何使用。



# 2. 用在哪

想要知道 AOP 可以用在哪些场景，需要回顾一下我们上一节讲的一个概念—— Advice（通知）。我们简单回顾一下：

- **Before**：在目标方法调用前调用 Advice
- **After[finally]**：在目标方法执行完成后调用 Advice
- **After-returning**：在目标方法成功执行后调用 Advice
- **After-throwing**：在目标方法抛出异常后调用 Advice
- **Around**：一般解释为环绕/包裹目标方法调用 Advice，但个人觉得理解成可定制化调用 Advice

Before 可以在目标方法执行前做一些我们需要的事情，比如解析请求参数、进行权限检查等；After 可以在目标方法调用后记录一些日志；After-returning 可以与 Before 配合计算目标方法执行时间；After-throwing 可以在目标方法抛出异常后做一些处理；而 Around 基本上可以做以上所有的事情。

因此我们知道 AOP 可以帮我们做以下事情：

- 参数检查
- 日志记录
- 异常处理
- 性能统计

除了上面这些基础功能，还可以利用 AOP 做一些更加复杂的通用处理：

- 事务控制
- 缓存处理
- 权限控制
- …



# 3. 怎么用

了解完 AOP 的应用场景以后，就到我们动手实践的时候了。我们先从我们最熟悉的记录日志开始下手吧。我们先引入 AOP 的依赖：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

然后创建 AspectController：

```java
@Slf4j
@RestController
@RequestMapping("/aspect")
public class AspectController {

}
```

最后创建一个切面类 WebAspect：

```java
@Slf4j
@Aspect
@Component
public class WebAspect {

}
```

类上加上 @Aspect 注解，用来标识该类为一个 AOP 的切面。



## 3.1 日志记录

先在 AspectController 中添加如下接口：

```java
@GetMapping
public Result aspect(String message) {
    log.info("aspect controller");
    return Result.sucess(message);
}
```

然后在 WebAspect 类中添加如下代码：

```java
@Pointcut("execution(public * com.imooc.springboot.aop.*.*(..))")
public void pointCut() {
}

@Before(value = "pointCut()")
public void before(JoinPoint joinPoint) {

    String methodName = joinPoint.getSignature().getName();
    String className = joinPoint.getTarget().getClass().getName();
    Object[] args = joinPoint.getArgs();
    String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();

    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    Map<String, Object> paramMap = new HashMap<>();
    for (int i = 0; i < parameterNames.length; i++) {
        paramMap.put(parameterNames[i], args[i]);
    }

    log.info("path：{}",request.getServletPath());
    log.info("class name：{}",className);
    log.info("method name：{}",methodName);
    log.info("args：{}",paramMap.toString());
}

@After(value = "pointCut()")
public void after(JoinPoint joinPoint) {
    log.info("{} after", joinPoint.getSignature().getName());
}

@AfterReturning(value = "pointCut()", returning = "returnVal")
public void afterReturning(JoinPoint  joinPoint, Object returnVal) {
    log.info("{} after return, returnVal: {}", joinPoint.getSignature().getName(), returnVal);
}
```

在 before 中我们获取了请求路径（path）、完整类路径、目标方法名、参数信息。after 方法中打印了目标方法名字。afterReturning 方法中将目标方法的返回值打印了出来。

> @Pointcut 用来定义切点；execution 是用来匹配连接点的执行方法；public 代表要匹配访问权限为 public 的方法；第一个 * 代表返回值为任意类型；com.imooc.springboot.aop 为包路径；第二个 * 代表前面包路径下的任意类；第三个 * 代表任意方法；(…) 代表任意参数。三个 * 可以换成具体的类或者方法。

下面我们看一下日志的输出内容：

```
WebAspect         : before path：/aspect
WebAspect         : before class name：com.imooc.springboot.aop.AspectController
WebAspect         : before method name：aspect
WebAspect         : before args：{message=hi}
AspectController  : aspect controller
WebAspect         : aspect after
WebAspect         : aspect after return, returnVal: Result(code=200, message=操作成功, data=hi)
```

可以看到，前四行是 before 方法中打印的日志内容。第五行是目标方法打印的内容（“aspect controller”）。接下来是 after 中打印的内容。最后一行是 afterReturning 方法中的日志内容，可以看到目标方法的返回值也被打印了出来。

通过上面的日志也可以看出 after 和 afterReturning 的关系或者说区别。after 是在目标方法被调用之后执行（不关心目标方法是否执行成功），而 afterReturning 是在目标方法执行 return 之后才执行的（是在目标方法正常退出后）。



## 3.2 异常处理

接下来我们用 afterThrowing 做异常之后的善后处理。这里的异常处理跟咱们之前说的全局异常处理不太一样，因为 afterThrowing 并不能捕获目标方法的异常，只是在目标方法抛出异常后，做一些后续处理。比如记录日志、报警通知等。

先在 AspectController 中添加如下接口：

```java
@GetMapping("/exception")
public Result exception() {
    throw new RuntimeException("runtime exception");
}
```

接下来在 WebAspect 类中添加如下代码：

```java
@AfterThrowing(value = "pointCut()", throwing = "e")
public void afterThrowing(JoinPoint  joinPoint, Exception e) {
    log.info("{} after throwing, message: {}", joinPoint.getSignature().getName(), e.getMessage());
}
```

我们会看到如下日志：

```
WebAspect       : before path：/aspect/exception
WebAspect       : before class name：com.imooc.springboot.aop.AspectController
WebAspect       : before method name：exception
WebAspect       : before args：{}
WebAspect       : exception after
WebAspect       : exception after throwing, message: runtime exception
```

before 方法就不多说了，我们看到 after 执行了，但是 afterReturning 没有执行，取而代之的是 afterThrowing。这进一步解释了 after 和 afterReturning 的区别，after 不关心方法是否成功，而 afterReturning 必须在目标方法成功 return 之后才会执行，afterThrowing 则是在目标方法抛出异常后执行。



## 3.3 性能统计

前面我们说过，around 可以囊括以上能力，是 advice（通知）中的全能选手。下面我们通过一个性能统计的例子，来演示一下 around 的用法。

先在 AspectController 中添加如下接口：

```java
@GetMapping("/sleep/{time}")
public Result sleep(@PathVariable("time") long time) {
    log.info("sleep");
    try {
        Thread.sleep(time);
    } catch (InterruptedException e) {
        log.error("error",e);
    }
    if (time == 1000) {
        throw new RuntimeException("runtime exception");
    }
    log.info("wake up");
    return Result.sucess("wake up");
}
```

然后在 WebAspect 中添加一个方法，用来计算目标方法所执行的时间：

```java
@Around("pointCut()")
public Object around(ProceedingJoinPoint joinPoint) {
    long startTime = System.currentTimeMillis();
    Object result = null;
    try {
        result = joinPoint.proceed();
    } catch (Throwable e) {
        log.error("around error",e);
    }
    long endTime = System.currentTimeMillis();
    log.info("execute time：{} ms",endTime - startTime);
    return result;
}
```

代码很简单，joinPoint.proceed() 是对目标方法的调用。记录开始时间和结束时间，最后输出方法执行的时间。

我们来看效果：

```
WebAspect         : around start
AspectController  : sleep
WebAspect         : execute time：2004 ms
WebAspect         : returnVal: Result(code=200, message=操作成功, data=wake up)
WebAspect         : around end
```

通过输出日志我们可以看到，在目标方法执行之前有 around start；执行之后有 execute time：2004 ms；成功返回之后有 returnVal: Result(code=200, message=操作成功, data=wake up) 和 around end。很好，不过好像还差一个目标方法抛出异常的情况。别急，这个 sleep 方法中有一个判断分支，当睡眠时间为 1000 ms 时则会抛出一个 RuntimeException，下面我们用 1000 作为请求参数值再看下效果。

```
WebAspect         : around start
AspectController  : sleep
WebAspect         : around error
```

OK，我们看到在目标方法抛出异常后，被 around 捕获到了，并且输出了一行日志 around error。这还没有结束，我们再看接口的返回值，你会发现接口的返回值也对错误信息进行了统一包装，就像我们之前讲全局异常处理的效果一样：

```json
{
    code: 500,
    message: "around error",
    data: null
}
```



## 3.4 小结

所有的 advice（通知）类型我们都玩过一遍了，也了解了各自的特点，有一点需要注意的是，虽然 around 可以涵盖所有功能，但在实际应用的时候，还是需要根据需要选择合适的类型。就像我们做数据库设计时不能将所有字段都设置成 varchar 类型是一个道理，合适很重要。



# 4. 执行顺序

了解完 AOP 的使用以后，我们来聊聊多个 AOP 操作的执行顺序。执行顺序可以细分为两种情况：1，同一切面内的不同通知之间的顺；2，不同切面间的执行顺序。



## 4.1 同一切面

从前面的实践的结果我们大致可以推断出先 before 再 after 然后 afterRetuning 的顺序来，我们要讨论的关键点就是 around 和它们之间的先后关系了。我们通过代码来验证一下，创建一个切面 AspectOne 代码如下：

```java
@Slf4j
@Aspect
@Component
public class AspectOne {

    @Pointcut("execution(public * com.imooc.springboot.aop.*.*(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before() {
        log.info("before one");
    }

    @After(value = "pointCut()")
    public void after() {
        log.info("after one");
    }

    @AfterReturning(value = "pointCut()")
    public void afterReturning() {
        log.info("afterReturning one");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        log.info("around one start");
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("around error",e);
        }
        log.info("around one end");
        return result;
    }
}
```

看下执行效果：

```
AspectOne         : around one start
AspectOne         : before one
AspectController  : aspect controller
AspectOne         : around one end
AspectOne         : after one
AspectOne         : afterReturning one
```

我们可以看到 around 早于 before 开始，并且早于 after 结束。它跟另外三个并不是完全包含（around 最先开始最后结束），也不是完全被包含（around 最后开始最先结束），而是与有一个交叉。



## 4.2 多个切面

接下来我们看看多个切面之间的执行顺序。将 AspectOne 复制两份分别命名为 AspectTwo 和 AspectThree，修改一下对应的日志信息。

我们来看下运行效果：

```
AspectOne         : before one
AspectThree       : before three
AspectTwo         : before two
AspectController  : aspect controller
AspectTwo         : after two
AspectThree       : after three
AspectOne         : after one
```

执行顺序为：one -> three -> two，并没有按照 one -> two-> three 的顺序执行哈。那它是按照什么顺序呢？是随机的吗？如果你多试几次你会发现并不是随机，执行顺序很稳定。Spring 中默认的执行顺序其实就是 Bean 初始化的顺序，在容器启动时可以看到如下日志：

```
DefaultListableBeanFactory     : Creating shared instance of singleton bean 'aspectOne'
DefaultListableBeanFactory     : Creating shared instance of singleton bean 'aspectThree'
DefaultListableBeanFactory     : Creating shared instance of singleton bean 'aspectTwo'
```

这个顺序刚好是切面执行的顺序，而 Spring 中的加载顺序是根据类名升序排序的，很明显 Three 按字母排序会排在 Two 前面。那么我们想要按照我们制定的顺序执行怎么办呢？其实非常简单，只需要一个注解就可以搞定——@Order。

我们分别为 AspectOne、AspectTwo 和 AspectThree 加上 @Order(1)、@Order(2) 和 @Order(3)，然后再执行一遍看效果：

```
AspectOne         : before one
AspectTwo         : before two
AspectThree       : before three
AspectController  : aspect controller
AspectThree       : after three
AspectTwo         : after two
AspectOne         : after one
```

OK，这次如我们所愿，顺序变成了 one -> two-> three 。而且我们还发现多个切面的执行跟栈很像——先进后出。通过下面这张图更加直观的感受一下多切面的执行顺序：

![图片描述](http://img1.sycdn.imooc.com/5ecdc0ba0001ff6910560608.png)



# 5. 原理简析

我们知道 Spring 的 AOP 是用代理的方式实现的。每个切面都是 Spring 容器中的一个 Bean，在目标方法被调用时，Spring 把切面应用到目标对象，为目标对象动态创建代理，这个过程叫 Weaving（织入）。切面在指定（符合切点条件）的连接点织入到目标对象中。

![图片描述](http://img1.sycdn.imooc.com/5ecdc0ad000135f208990440.png)
如上图所示，当调用者调用目标对象时，调用请求会被代理类拦截，在目标对象真正被调用之前，会先织入切面逻辑。当应用需要目标对象时，Spring 才会去创建代理对象，因为 Spring 采用的是运行期织入的实现方式。

> 除运行期织入以外，还有两种织入方式：编译器织入和类加载期织入两种方式，了解一下即可。



# 6. 总结

OK，这一小节的内容很丰富，有理论也有实践。我们先学习了 AOP 的应用场景，紧接着 AOP 实践了日志记录、异常处理和性能统计。后面又分析了切面内部的执行顺序和多切面之间的执行顺序。最后简单分析了一下 Spring AOP 的基本原理。

希望通过这两节关于 AOP 的学习，你不仅可以掌握 AOP 的各种使用方式，还能更进一步的体会 AOP 的设计思想，这些经典的编程思想对于提升我们的能力是至关重要的。

[27 程序世界的无人超市——AOP](http://www.imooc.com/read/75/article/1823)[29 哲学三问：你从哪来之Spring Boot启动流程](http://www.imooc.com/read/75/article/1825)

精选留言 1

欢迎在这里发表留言，作者筛选后可公开显示

- [慕慕童鞋](http://www.imooc.com/u/8954842/articles)

  知其然也知其所以然，老师讲得很清楚。

   0

  回复

  2020-06-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕慕童鞋](http://www.imooc.com/u/8954842/articles)

    感谢支持。

    回复

    2020-06-28 20:24:36

 

千学不如一看，千看不如一练