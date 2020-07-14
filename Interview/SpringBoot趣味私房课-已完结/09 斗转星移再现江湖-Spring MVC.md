**09 斗转星移再现江湖-Spring MVC**



09 斗转星移再现江湖-Spring MVC

更新时间：2020-05-26 11:44:44

![img](http://img3.sycdn.imooc.com/5e9cffac0001839306400359.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

人只有献身于社会，才能找出那短暂而有风险的生命的意义。

——爱因斯坦



# 1. 思想与原理



## 1.1 简介

Spring MVC，对于熟悉它的人自然不必多说。但如果你对它不太了解，那么我为你简单介绍一下。Spring MVC 的名字由两部分组成，Spring 彰显了它的家族身份，而 MVC 则代表它的能力。那么 MVC 究竟是什么呢？

**MVC 模式** 是软件工程中的一种软件架构模式，把软件系统分为三个基本部分：模型（Model）、视图（View）和控制器（Controller）。

- **视图（View）** 在 JavaEE 应用程序中，视图（View）可以由 JSP（Java Server Page）担任。在现在前后端分离的模式下，View 已经由前端所取代。
- **控制器（Controller）** JavaEE 应用中，Controller 可能是一个 Servlet 。在 Spring MVC 中担任控制器角色的是 DispatcherServlet。
- **模型（Model）** Model 则是由一个实体 Bean 来实现，主要对应数据层。



## 1.2 原理

Spring MVC 最核心的思想在于 `DispatcherServlet` 。在现在的开发模式中，我们主要使用的也是 Spring MVC 的这一核心功能。那么 `DispatcherServlet` 究竟是何方神圣呢？

还记得大明湖畔，呸！还记得姑苏慕容吗？没错，就是那个以斗转星移闻名于世，致力于光复大燕的慕容家族。我们这里就拿 `斗转星移` 和 `DispatcherServlet` 做一个类比。它们两个都是从外部接收一个东西（内力/请求）然后经过一系列转换，最后返回给外部（内力/响应）。当年慕容龙城凭借其自创的 `斗转星移` 威震江湖，「天龙八部」中斗转星移连扫地僧口中天下第一的 `降龙十八掌` 都能化解，足见此种武功的精妙所在。不过后来遇到段誉的六脉神剑就不太灵光了，可能是当年慕容龙城设计 `斗转星移` 的时候，没有太多的考虑高并发的业务场景吧（六脉神剑）。哈哈，脑洞一下。

Spring MVC 内部处理流程如下：

![图片描述](http://img1.sycdn.imooc.com/5e9ac00c0001278911570606.png)

浏览器发起一个请求（如：http://localhost:8080/hello）， 会经历如下步骤：

1. DispatcherServlet 接收到请求
2. 通过 HandlerMapping 找到对应的 handler
3. 然后通过 HandlerAdapter 调用 Controller 进行后续业务逻辑处理（3-4）
4. 处理完业务逻辑后，Controller 将视图名返回给 HandlerAdapter
5. DispatcherServlet 选择合适的 ViewResolver 生成 View 对象
6. 最后 View 渲染并返回响应数据



## 1.3 深入核心

三个核心组件：

- Handler
- HandlerMapping
- HanderAdapter

Handler 是用来做具体事情的，对应的是 Controller 里面的方法，所有有 @RequestMapping 标注的方法都可以看做为一个 Handler。

HandlerMapping 是用来找到 Handler 的，是请求路径与 Handler 的映射关系。

HandlerAdapter 从名字看，可以知道它是一个适配器。它是用来跟具体的 Handler 配合使用的。可以简单理解为各种电子产品与电源适配器（充电器）的关系。

DispatcherServlet 最核心的方法就是 doDispatch ，doDispatch 主要做了四件事：

1. 根据 request 找到 Handler
2. 根据 Handler 找到对应的 HanderAdapter
3. 用 HanderAdapter 处理 Handler
4. 处理经过以上步骤的结果

精简后的源码如下：

```java
// 根据 request 找到 Handler
mappedHandler = getHandler(processedRequest);

// 根据 Handler 找到对应的 HanderAdapter
HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());

// 用 HanderAdapter 处理 Handler
mv = ha.handle(processedRequest, response, mappedHandler.getHandler());

// 处理经过以上步骤的结果
processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);
```

简单看一下查找 Handler 和 HandlerAdapter 的代码：

查找 Handler：

```java
protected HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
   if (this.handlerMappings != null) {
      for (HandlerMapping mapping : this.handlerMappings) {
         HandlerExecutionChain handler = mapping.getHandler(request);
         if (handler != null) {
            return handler;
         }
      }
   }
   return null;
}
```

如上代码所示，迭代 Mapping 集合，找到后返回，找不到返回 `null` ，如果找不到对应的 Mapping 一般情况下就会看到我们熟悉的 `404`了。

查找 HandlerAdapter：

```java
protected HandlerAdapter getHandlerAdapter(Object handler) throws ServletException {
   if (this.handlerAdapters != null) {
      for (HandlerAdapter adapter : this.handlerAdapters) {
         if (adapter.supports(handler)) {
            return adapter;
         }
      }
   }
   throw new ServletException("No adapter for handler [" + handler +
         "]: The DispatcherServlet configuration needs to include a HandlerAdapter that supports this handler");
}
```

和查找 Handler 稍有不同，如果找不到对应的 HandlerAdapter 直接抛出一个 `ServletException`。



## 1.4 小结

OK，又到了总结收获的时候了。在本节的第一部分，我们一起对 Spring MVC 的核心原理进行了深入的学习。了解了 Spring MVC 的核心思想，内部处理流程，三大核心组件，还一起学习了 Spring MVC 的部分源码。内容的深度比之前的小节要深一些，如果你觉得学起来有难度，那么你可以从本节的第二部分开始学，学完 Spring MVC 的具体使用，再回过头来学习它的原理。



# 2. 注解

在本节的第一部分我们一起学习了一下原理性的东西，还看了一下源码。原理就好比是内功心法，实践操作就像武功招式。学了内功心法，接下来我们要配合招式，让它们融会贯通才能发挥出最大威力。在第二部分我们将会实践以下内容：

- 常用注解
- 获取参数
- 数据校验



## 2.1 常用注解

在学习 Spring MVC 的常用注解之前，我们先看一下我们之前都用了哪些 Spring MVC 的注解，它们属不属于今天要说的常用注解呢？

我们前面写的代码不多，与 Spring MVC 相关的只有一个 `HelloController`：

```java
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name) {
        if (name != null && !"".equals(name)) {
            return "Hello " + name;
        }
        return "Hello Spring Boot";
    }
}
```

在这段代码中我们用到了下面三个注解：

- @RestController
- @GetMapping
- @RequestParam

下面表格是 Spring MVC 中常用注解：

| 注解            | 作用域  | 说明            |
| :-------------- | :------ | :-------------- |
| @Controller     | 类      | Controller标识  |
| @RequestMapping | 类/方法 | URL映射         |
| @ResponseBody   | 类/方法 | 以Json方式返回  |
| @RequestParam   | 参数    | 按名字接收参数  |
| @RequestBody    | 参数    | 接收Json参数    |
| @PathVariable   | 参数    | 接收URL中的参数 |

嗯？好像除了`@RequestParam` 以外，其他的都不是上面的所说的常用注解呀！难道我们之前用的都是比较小众的注解？哈哈，不是这样的，这里就引出另外一个概念了——组合注解。



## 2.2 组合注解

啥是组合注解呢？往下走，一看便知：

- @RestController = @Controller + @ResponseBody
- @GetMapping = @RequestMapping(method = RequestMethod.GET)
- @PostMapping = @RequestMapping(method = RequestMethod.POST)
- @PutMapping = @RequestMapping(method = RequestMethod.PUT)
- @PatchMapping = @RequestMapping(method = RequestMethod.PATCH)
- @DeleteMapping = @RequestMapping(method = RequestMethod.DELETE)

相信聪明的你已经发现了，组合注解就是具有多个功能的注解，由多个注解或者一个注解 + 一个特定的属性值组成的注解，相当于对注解的一种封装。

@RestController 不仅可以标识一个 Controller ，还能让被标识的 Controller 中的所有方法都返回 JSON 格式的数据；@GetMapping 不仅可以映射一个请求路径，还让该路径只响应 GET 方法。



## 2.3 接收参数

Spring MVC 的主要工作就是接收外部的请求，然后根据请求去调用相应的服务，最后将处理结果返回。外部发来的请求会以各种形式带着各式各样的参数，以达到不同的目的。那么接下来我们就一起看看 Spring MVC 都有哪些接收请求参数的本领吧！

Spring MVC 有四种接收参数的方式：

- 无注解方式
- @RequestParam 方式
- @PathVariable 方式
- @RequestBody 方式



### 2.3.1 准备

```java
@Data
public class User {
    private String name;
    private int age;
}
```

使用 `@Data` 注解需要添加以下依赖：

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>
```

然后需要在 IDEA 安装 Lombok 插件。



### 2.3.2 无注解

```java
@Api
@RestController
public class ParamController {

    @ApiOperation(value = "无注解方式")
    @GetMapping("/noannotation")
    public User noAnnotation( User user) {
        return user;
    }
  
}
```

![图片描述](http://img1.sycdn.imooc.com/5e9abff00001e28d15480756.png)

> http://localhost:8080/noannotation?name=无注解方式&age=1

![图片描述](http://img1.sycdn.imooc.com/5e9abf860001bc0c14660400.png)



### 2.3.3 @RequestParam方式

@RequestParam 注解有四个属性：

| 属性         | 类型    | 说明                                       |
| :----------- | :------ | :----------------------------------------- |
| name         | String  | 参数名称                                   |
| value        | String  | name 属性的别名                            |
| required     | boolean | 指定是否为必传参数（为 true 时不传会报错） |
| defaultValue | String  | 参数默认值                                 |

```java
@ApiOperation(value = "@RequestParam方式")
@GetMapping("/requestparam")
public User RequestParam(@RequestParam String name, @RequestParam int age) {
  User user = new User();
  user.setName(name);
  user.setAge(age);
  return user;
}
```

![图片描述](http://img1.sycdn.imooc.com/5e9abf6e0001d49515260790.png)

> http://localhost:8080/requestparam?name=@RequestParam方式&age=4

![图片描述](http://img1.sycdn.imooc.com/5e9abf5c000140d614780408.png)



### 2.3.4 @PathVariable方式

@PathVariable 注解有三个属性：

| 属性     | 类型    | 说明                                       |
| :------- | :------ | :----------------------------------------- |
| name     | String  | 参数名称                                   |
| value    | String  | name 属性的别名                            |
| required | boolean | 指定是否为必传参数（为 true 时不传会报错） |

```java
@ApiOperation(value = "@PathVariable方式")
@GetMapping("/pathvariable/{name}/{age}")
public User PathVariable(@PathVariable String name,@PathVariable int age) {
  User user = new User();
  user.setName(name);
  user.setAge(age);
  return user;
}
```

![图片描述](http://img1.sycdn.imooc.com/5e9abf370001810015340810.png)

> http://localhost:8080/pathvariable/@PathVariable方式/2

![图片描述](http://img1.sycdn.imooc.com/5e9abf2a000165f714800414.png)



### 2.3.5 @RequestBody方式

@RequestBody 只有一个属性：

| 属性     | 类型    | 说明                                       |
| :------- | :------ | :----------------------------------------- |
| required | boolean | 指定是否为必传参数（为 true 时不传会报错） |

```java
@ApiOperation(value = "@RequestBody方式")
@PostMapping("/requestbody")
public User RequestBody(@RequestBody User user) {
    return user;
}
```

![图片描述](http://img1.sycdn.imooc.com/5e9abf180001056515600900.png)

> http://localhost:8080/requestbody
>
> 以 POST 方式请求，将参数放到 body 里。

![图片描述](http://img1.sycdn.imooc.com/5e9abef80001908d14660400.png)



## 2.4 数据验证

说到传参，就抛不开参数的校验。在我们的实际开发中，需要根据需求对参数做各种各样的校验：是否为空、取值范围、是否为数字、Email 格式是否正确等等。在没有数据校验 API 之前，我们需要自己去实现这些校验的代码。在有了 JSR-303 之后，这些事情变得无比简单、方便，妈妈再也不用担心我不会做数据校验啦！

Spring MVC 对 JSR-303 有着良好的支持，在 Spring Boot 的加持下，更是如鱼得水，我们连额外的 Jar 包依赖都不需要手动添加，因为它已经包含在 `spring-boot-starter-web` 里了，真是棒极了！下面我们看一个简单的例子：

```java
@Data
public class User {
    @NotNull(message = "名字不能为空")
    private String name;

    @Range(min = 1,max = 120,message = "年龄要在1到120之间")
    private int age;

    @Email(message = "Email格式不正确")
    private String email;

    @Past(message = "生日必须为过去的时间")
    private LocalDate birthDay;
}
```

每个注解都有一个 `message` 属性，用来设置校验不通过时的提示信息。这里我不给出演示效果了，算是给你留一个小小的作业，自己实验一把，然后可以在评论里一起交流心得。

下面是我们比较常用的数据校验注解，完整的可以去 `javax.validation.constraints` 包中查找。

| **注解**                      | **说明**                                                 |
| :---------------------------- | :------------------------------------------------------- |
| `@Null`                       | 被注释的元素必须为 `null`                                |
| `@NotNull`                    | 被注释的元素必须不为 `null`                              |
| `@AssertTrue`                 | 被注释的元素必须为 `true`                                |
| `@AssertFalse`                | 被注释的元素必须为 `false`                               |
| `@Min(value)`                 | 被注释的元素必须是一个数字，其值必须大于等于指定的最小值 |
| `@Max(value)`                 | 被注释的元素必须是一个数字，其值必须小于等于指定的最大值 |
| `@DecimalMin(value)`          | 被注释的元素必须是一个数字，其值必须大于等于指定的最小值 |
| `@DecimalMax(value)`          | 被注释的元素必须是一个数字，其值必须小于等于指定的最大值 |
| `@Size(max, min)`             | 被注释的元素的大小必须在指定的范围内                     |
| `@Digits (integer, fraction)` | 被注释的元素必须是一个数字，其值必须在可接受的范围内     |
| `@Past`                       | 被注释的元素必须是一个过去的日期                         |
| `@Future`                     | 被注释的元素必须是一个将来的日期                         |
| `@Pattern(value)`             | 被注释的元素必须符合指定的正则表达式                     |
| `@Email`                      | 被注释的元素必须是电子邮箱地址                           |
| `@Length`                     | 被注释的字符串的大小必须在指定的范围内                   |
| `@NotEmpty`                   | 被注释的字符串的必须非空                                 |
| `@Range`                      | 被注释的元素必须在合适的范围内                           |



## 2.5 小结

OK，通过这一部分的学习，我们掌握了 Spring MVC 的常用注解、学会了各种接收参数的姿势、还 get 到了数据校验的技巧，可谓是收获满满。这部分的内容更加注重实践，所以，你可不要偷懒呦！Spring MVC 的这节内容比较多，如果你累了可以先休息一下，放松一下再来学习后面的内容。在接下来的部分，我们一起来学习一下 Spring MVC 的拦截器。



# 3. 拦截器



## 3.1 简介

书接上回，在这一趴我们一起来学习一下 Spring MVC 中的拦截器。拦截器在我们日常开发当中有着很重要的地位，很多重要的功能需要借助拦截器帮我们完成。我们通常会使用拦截器帮我们完成以下功能：

- 登录认证
- 权限验证
- 记录日志
- 性能监控
- …



## 3.2 自定义拦截器

接下来我们学习如何写一个拦截器。Spring MVC 中所有的拦截器都实现/继承自 `HandlerInterceptor` 接口。我们想要写一个自定义拦截器的话，需要实现/继承 `HandlerInterceptor` 或其子接口/实现类。下图是 Spring MVC 中拦截器的类图（还有几个类是 `HandlerInterceptorAdapter`的子类，这里没有列出）：

![图片描述](http://img1.sycdn.imooc.com/5e9abed20001b27620800520.png)

`HandlerInterceptor` 接口的源码如下：

```java
public interface HandlerInterceptor {

  	// 处理器执行前被调用
	default boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		return true;
	}
	
  	// 处理器执行后，视图渲染前被调用
	default void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}

  	// 视图渲染完成后背调用
	default void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}

}
```

> 该接口包含三个默认实现（ Java 8）的方法—— preHandle、postHandle 和 afterCompletion 。

下面我们自定义一个最简单、纯净的拦截器，也就是直接实现 `HandlerInterceptor` 接口。

新建一个类 `LogInterceptor` 并实现 `HandlerInterceptor` 接口：

```java
@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
    }
}
```

> 在三个方法中分别添加了一条日志打印的代码。

新建一个类 `WebConfigurer` 并实现 `WebMvcConfigurer` 接口，用于注册我们自定义的拦截器：

```java
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
    }
}
```

在 `HelloController` 的 `hello` 方法中添加一条日志打印代码：

```java
@Api
@Slf4j
@RestController
public class HelloController {
    @ApiOperation(value = "Hello Spring Boot 方法")
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) @ApiParam("名字") String name) {
        if (name == null || "".equals(name)) {
            name = "Spring Boot";
        }
        log.info("hello");
        return "Hello "+name;
    }
}
```

OK，接下来启动工程，并访问以下`hello` 方法，控制台会看到如下的输出：

```
com.imooc.springboot.LogInterceptor      : preHandle
com.imooc.springboot.HelloController     : hello
com.imooc.springboot.LogInterceptor      : postHandle
com.imooc.springboot.LogInterceptor      : afterCompletion
```

> 这代表我们的自定义拦截器成功了，恭喜！



## 3.3 拦截器执行流程

从控制台的日志输出，我们可以大概看出拦截器的执行流程。下面我们来更加深入的学习一下拦截器的整个执行流程：

![图片描述](http://img1.sycdn.imooc.com/5e9abea90001c57d07710426.png)

1. 执行 preHandle 方法，该方法会返回一个布尔值。如果为 false ，则结束本次请求：如果为 true 则继续。
2. 执行处理器逻辑，也就是我们的 Controller 。
3. 执行 postHandle 方法。
4. 执行视图解析和视图渲染 （我们直接返回了 JSON 对象，所以没有视图处理）。
5. 执行 afterCompletion 方法。

我们可以在 `DispatcherServlet` 的 `doDispatch` 方法的源码中进一步验证这个执行逻辑：

```java
protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
	try {
		try {
			
			// 返回 HandlerExecutionChain  其中包含了拦截器队列
			mappedHandler = getHandler(processedRequest);

			//调用拦截器 PreHandle 方法，若返回 false 将直接 return
			if (!mappedHandler.applyPreHandle(processedRequest, response)) {
				return;
			}

			// 处理 Controller
			mv = ha.handle(processedRequest, response, mappedHandler.getHandler());

			// 调用拦截器的 PostHandle 方法
			mappedHandler.applyPostHandle(processedRequest, response, mv);
		}

		// 调用拦截器的 afterCompletion 方法
		processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);
	}
}
```

> 以上是精简以后的 `doDispatch` 源码。



## 3.4 多个拦截器的执行顺序

我们再添加一个拦截器 `TimeInterceptor` 用来记录接口执行的时间：

```java
@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {

    private ThreadLocal<Long> threadLocalStart = new ThreadLocal<>();
    private ThreadLocal<Long> threadLocalEnd = new ThreadLocal<>();

  	// 记录开始时间
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTIme = System.currentTimeMillis();
        threadLocalStart.set(startTIme);
        log.info("开始时间：{}", startTIme);
        return true;
    }

  	// 记录结束时间
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTIme = System.currentTimeMillis();
        threadLocalEnd.set(endTIme);
        log.info("结束时间：{}", endTIme);
    }

  	// 计算接口执行时间
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = threadLocalStart.get();
        long endTime = threadLocalEnd.get();
        log.info("接口执行时间：{} 毫秒", endTime - startTime);
    }
}
```

控制台输出：

```
com.imooc.springboot.LogInterceptor      : preHandle
com.imooc.springboot.TimeInterceptor     : 开始时间：1561885760593
com.imooc.springboot.HelloController     : hello
com.imooc.springboot.TimeInterceptor     : 结束时间：1561885760627
com.imooc.springboot.LogInterceptor      : postHandle
com.imooc.springboot.TimeInterceptor     : 接口执行时间：34 毫秒
com.imooc.springboot.LogInterceptor      : afterCompletion
```

通过控制台的输出信息，我们可以看到多个拦截器的执行顺序有些类似数据结构中的栈——先进后出。

下面我们再通过一张图来更加形象的展示一下这个逻辑：

![图片描述](http://img1.sycdn.imooc.com/5e9abe8a00012b6806560706.png)



## 3.5 小结

OK，在这一趴中，我们学习了拦截器的基本使用，以及其内部的执行逻辑。还实践了两个应用场景——记录日志和监控接口执行时间，还知道了多个拦截器是先进后出的执行顺序。通过这一部分的学习，你已经掌握了拦截器的应用与原理了。



# 4. 结语

关于 Spring MVC 的这一节内容比较多，从原理到应用再到拦截器的使用，内容着实不少呢。需要你课后慢慢消化与实践。另外，想问问各位同学，你喜欢读这种长篇干货，还是短小精悍的文章呢？

[08 代码的护身符-单元测试](http://www.imooc.com/read/75/article/1804)[10 面向资源编程-RESTful风格](http://www.imooc.com/read/75/article/1806)

精选留言 10

欢迎在这里发表留言，作者筛选后可公开显示

- [Yellowone](http://www.imooc.com/u/5569456/articles)

  数据验证不生效额 = =

   0

  回复

  1天前

- [YUnHolding丶sand](http://www.imooc.com/u/2597858/articles)

  关于多个拦截器的执行顺序，可以看一下作者提供的源代码中WebConfigure类中，addInterceptors方法中，添加拦截器的顺序： @Override public void addInterceptors(InterceptorRegistry registry) { registry.addInterceptor(logInterceptor); registry.addInterceptor(timeInterceptor); } 先添加了logInterceptor，再添加timeInterceptor，所以先执行logInterceptor的preHandle方法，然后再执行timeInterceptor的preHandle方法。。。

   0

  回复

  5天前

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[YUnHolding丶sand](http://www.imooc.com/u/2597858/articles)

    是的。

    回复

    15小时前

- [乃好](http://www.imooc.com/u/7249708/articles)

  手动微笑，难道验证不要加@Validated吗？我说咋没用

   1

  回复

  2020-07-01

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[乃好](http://www.imooc.com/u/7249708/articles)

    需要的，在 Controller 方法参数前面加上 @Valid 注解。

    回复

    2020-07-02 18:52:47

- [qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

  为什么我的控制台无法出现我想看到的东西

   0

  回复

  2020-06-20

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    你看到了啥？

    回复

    2020-06-22 20:24:18

- [qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

  spring-boot-starter-parent 2.3.0 版本以后 starter-web 中就没有数据校验的依赖了，需要手动导入依赖 org.springframework.bootspring-boot-starter-validation 链接如下：https://blog.csdn.net/dongbeiou/article/details/106634573

   0

  回复

  2020-06-20

- [fenkapian](http://www.imooc.com/u/2143740/articles)

  栈好像是先进后出的吧，队列才是先进先出的。 另外请教下，多个拦截器的执行顺序，我知道是先执行各个拦截器的preHandle方法，但是先执行具体哪一个拦截器的preHandle呢？是什么规则确定的呢？

   0

  回复

  2020-06-11

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[fenkapian](http://www.imooc.com/u/2143740/articles)

    多个拦截器执行也是类似先进后出呀。执行顺序由注册拦截器的顺序决定，具体顺序查看 WebConfigurer 类中的 addInterceptors 方法。

    回复

    2020-06-12 20:59:06

- [穆女生](http://www.imooc.com/u/9047671/articles)

  多个拦截器，为啥最后的after顺序跟前面的不一样

   0

  回复

  2020-06-06

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[穆女生](http://www.imooc.com/u/9047671/articles)

    去 org.springframework.web.servlet.HandlerExecutionChain 中看下源码就明白了。org.springframework.web.servlet.HandlerExecutionChain#applyPreHandle 方法是正向迭代 interceptor 数组，而 org.springframework.web.servlet.HandlerExecutionChain#applyPostHandle 和 org.springframework.web.servlet.HandlerExecutionChain#triggerAfterCompletion 都是反向迭代 interceptor 数组。所以在 pre 中先执行的 interceptor 在 post 和 after 中反而会后执行。

    回复

    2020-06-08 22:19:22

- [MarchGoGo](http://www.imooc.com/u/9029620/articles)

  喜欢短小精悍的

   1

  回复

  2020-06-05

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[MarchGoGo](http://www.imooc.com/u/9029620/articles)

    其实原来这是三个小节，后来整合成了一个。嗯……

    回复

    2020-06-05 19:06:58

- [lihk](http://www.imooc.com/u/6488805/articles)

  安装了lombot插件,Enable annotation processing 也勾选了 @Data还是报错

   0

  回复

  2020-06-04

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[lihk](http://www.imooc.com/u/6488805/articles)

    报什么错误，可以加微信给你看下：liushuijinger

    回复

    2020-06-05 20:16:12

  - [lihk](http://www.imooc.com/u/6488805/articles)

    回复[lihk](http://www.imooc.com/u/6488805/articles)

    昨天重启了无数回都不行，过了一天自己好了?，谢谢！

    回复

    2020-06-05 20:49:08

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[lihk](http://www.imooc.com/u/6488805/articles)

    自己好了？难道这就是传说中的机器学习？电脑自己学会了新知识，然后把问题解决了。

    回复

    2020-06-12 20:49:07

  点击展开后面 1 条

- [qq_庞庞_0](http://www.imooc.com/u/6173405/articles)

  希望多讲一些原理性的东西，比如为什么要这样，很多时候都是知道要这样，却不知道为什么要这样。

   0

  回复

  2020-04-27

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_庞庞_0](http://www.imooc.com/u/6173405/articles)

    感谢支持！一大波原理在后面等着你呦

    回复

    2020-05-12 14:01:52

 

千学不如一看，千看不如一练

 