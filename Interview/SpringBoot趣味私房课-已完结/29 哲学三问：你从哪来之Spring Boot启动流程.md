**29 哲学三问：你从哪来之Spring Boot启动流程**

29 哲学三问：你从哪来之Spring Boot启动流程

更新时间：2020-05-28 09:25:01

![img](http://img3.sycdn.imooc.com/5ebe629500011ed706400426.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

智慧，不是死的默念，而是生的沉思。

——斯宾诺莎



# 1. 前言

在拥有 Spring Boot 以前，我们要运行一个 Java Web 应用，首先需要有一个 Web 容器（例如 Tomcat 或 Jetty），然后将我们的 Web 应用打包后放到容器的相应目录下，最后再启动容器。

在 IDE 中也需要对 Web 容器进行一些配置，才能够运行或者 Debug。而使用 Spring Boot 我们只需要像运行普通 JavaSE 程序一样，run 一下 main () 方法就可以启动一个 Web 应用了。这是怎么做到的呢？今天我们就一探究竟，分析一下 Spring Boot 的启动流程。



# 2. 追本溯源

回看《万事开头难？Spring Boot 表示不服！》这一小节的代码，我们发现，只需要下面几行代码我们就可以跑起一个 Web 服务器：

```java
@SpringBootApplication
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
```

去掉类的声明和方法定义这些样板代码，核心代码就只有一个 @SpringBootApplication 注解和 SpringApplication.run (SpringbootApplication.class, args) 方法。而我们知道注解相当于是一种配置，那么这个 run () 方法必然就是 Spring Boot 的启动入口了。



# 3. 容器启动流程

接下来，我们沿着 run () 方法来顺藤摸瓜。进入 SpringApplication 类，来看看 run () 方法的具体实现：

```java
public class SpringApplication {
	......
	public ConfigurableApplicationContext run(String... args) {
		// 1 应用启动计时开始
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// 2 声明上下文
		ConfigurableApplicationContext context = null;
		
		// 3 初始化异常报告集合
		Collection<SpringBootExceptionReporter> exceptionReporters = new ArrayList<>();
		
		// 4 设置 java.awt.headless 属性
		configureHeadlessProperty();
		
		// 5 启动监听器
		SpringApplicationRunListeners listeners = getRunListeners(args);
		listeners.starting();
		
		try {
			// 6 初始化默认应用参数
			ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
			
			// 7 准备应用环境
			ConfigurableEnvironment environment = prepareEnvironment(listeners, applicationArguments);
			configureIgnoreBeanInfo(environment);
			
			// 8 打印 Banner（Spring Boot 的 LOGO）
			Banner printedBanner = printBanner(environment);
			
			// 9 通过反射创建上下文实例
			context = createApplicationContext();
			
			// 10 构建异常报告
			exceptionReporters = getSpringFactoriesInstances(SpringBootExceptionReporter.class,
					new Class[] { ConfigurableApplicationContext.class }, context);
					
			// 11 构建上下文
			prepareContext(context, environment, listeners, applicationArguments, printedBanner);
			
			// 12 刷新上下文
			refreshContext(context);
			
			// 13 刷新上下文后处理
			afterRefresh(context, applicationArguments);
			
			// 14 应用启动计时结束
			stopWatch.stop();
			
			if (this.logStartupInfo) {
				// 15 打印启动时间日志
				new StartupInfoLogger(this.mainApplicationClass).logStarted(getApplicationLog(), stopWatch);
			}
			
			// 16 发布上下文启动完成事件
			listeners.started(context);
			
			// 17 调用 runners
			callRunners(context, applicationArguments);
		}
		catch (Throwable ex) {
			// 18 应用启动发生异常后的处理
			handleRunFailure(context, ex, exceptionReporters, listeners);
			throw new IllegalStateException(ex);
		}

		try {
			// 19 发布上下文就绪事件
			listeners.running(context);
		}
		catch (Throwable ex) {
			handleRunFailure(context, ex, exceptionReporters, null);
			throw new IllegalStateException(ex);
		}
		return context;
	}
	......
}
```

Spring Boot 启动时做的所有操作都这这个方法里面，当然在调用上面这个 run () 方法之前，还创建了一个 SpringApplication 的实例对象。因为上面这个 run () 方法并不是一个静态方法，所以需要一个对象实例才能被调用。

可以看到，方法的返回值类型为 ConfigurableApplicationContext，这是一个接口，我们真正得到的是 AnnotationConfigServletWebServerApplicationContext 的实例。通过类名我们可以知道，这是一个基于注解的 Servlet Web 应用上下文（我们知道上下文（context）是 Spring 中的核心概念）。

上面对于 run () 方法中的每一个步骤都做了简单的注释，接下来我们选择几个比较有代表性的来详细分析。



## 3.1 应用启动计时

在 Spring Boot 应用启动完成时，我们经常会看到类似下面内容的一条日志：

```
Started SpringbootApplication in 4.9 seconds (JVM running for 5.553)
```

应用启动后，会将本次启动所花费的时间打印出来，让我们对于启动的速度有一个大致的了解，也方便我们对其进行优化。记录启动时间的工作是 run () 方法做的第一件事，在编号 1 的位置由 stopWatch.start () 开启时间统计，具体代码如下：

```java
public void start(String taskName) throws IllegalStateException {
    if (this.currentTaskName != null) {
        throw new IllegalStateException("Can't start StopWatch: it's already running");
    }
    
    // 记录启动时间
    this.currentTaskName = taskName;
    this.startTimeNanos = System.nanoTime();
}
```

然后到了 run () 方法的基本任务完成的时候，由 stopWatch.stop ()（编号 14 的位置）对启动时间做了一个计算，源码也很简单：

```java
public void stop() throws IllegalStateException {
    if (this.currentTaskName == null) {
       throw new IllegalStateException("Can't stop StopWatch: it's not running");
    }
    
    // 计算启动时间
    long lastTime = System.nanoTime() - this.startTimeNanos;
	this.totalTimeNanos += lastTime;
    ......
}
```

最后，在 run () 中的编号 15 的位置将启动时间打印出来：

```java
if (this.logStartupInfo) {
    // 打印启动时间
   new StartupInfoLogger(this.mainApplicationClass).logStarted(getApplicationLog(), stopWatch);
}
```



## 3.2 打印 Banner

Spring Boot 每次启动是还会打印一个自己的 LOGO，就像下面这样：

![图片描述](http://img1.sycdn.imooc.com/5ecdc1830001ed1904460207.png)

这种做法很常见，像 Redis、Docker 等都会在启动的时候将自己的 LOGO 打印出来。Spring Boot 默认情况下会打印那个标志性的 “树叶” 和 “Spring” 的字样，下面带着当前的版本。

在 run () 中编号 8 的位置调用打印 Banner 的逻辑，最终由 SpringBootBanner 类的 printBanner () 完成。这个图案定义在一个常量数组中，代码如下：

```java
class SpringBootBanner implements Banner {

    private static final String[] BANNER = {
            "", 
            "  .   ____          _            __ _ _",
            " /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\", 
            "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\",
            " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )", 
            "  '  |____| .__|_| |_|_| |_\\__, | / / / /",
            " =========|_|==============|___/=/_/_/_/" 
    };
    ......
        
	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
		for (String line : BANNER) {
			printStream.println(line);
		}
		......
	}

}
```

手工格式化了一下 BANNER 的字符串，轮廓已经清晰可见了。真正打印的逻辑就是 printBanner () 方法里面的那个 for 循环。

记录启动时间和打印 Banner 代码都非常的简单，而且都有很明显的视觉反馈，可以清晰的看到结果。拿出来咱们做个热身，配合断点去 Debug 会有更加直观的感受，尤其是打印 Banner 的时候，可以看到整个内容被一行一行打印出来，让我想起了早些年用那些配置极低的电脑（还是 CRT 显示器）运行着 Win98，经常会看到屏幕内容一行一行加载显示。



## 3.3 创建上下文实例

下面我们来到 run () 方法中编号 9 的位置，这里调用了一个 createApplicationContext () 方法，点进去我们会看到它的代码如下：

```java
public static final String DEFAULT_SERVLET_WEB_CONTEXT_CLASS = "org.springframework.boot."
			+ "web.servlet.context.AnnotationConfigServletWebServerApplicationContext";

protected ConfigurableApplicationContext createApplicationContext() {
    Class<?> contextClass = this.applicationContextClass;
    if (contextClass == null) {
        try {
            switch (this.webApplicationType) {
                case SERVLET:
                    contextClass = Class.forName(DEFAULT_SERVLET_WEB_CONTEXT_CLASS);
                    break;
                case REACTIVE:
                    contextClass = Class.forName(DEFAULT_REACTIVE_WEB_CONTEXT_CLASS);
                    break;
                default:
                    contextClass = Class.forName(DEFAULT_CONTEXT_CLASS);
            }
        }
        catch (ClassNotFoundException ex) {
            throw new IllegalStateException(
                "Unable create a default ApplicationContext, please specify an ApplicationContextClass", ex);
        }
    }
    return (ConfigurableApplicationContext) BeanUtils.instantiateClass(contextClass);
}
```

这个方法就是根据 SpringBootApplication 的 webApplicationType 属性的值，利用反射来创建不同类型的应用上下文（context）。而属性 webApplicationType 的值是在前面执行构造方法的时候由 WebApplicationType.deduceFromClasspath () 获得的。通过方法名很容易看出来，就是根据 classpath 中的类来推断当前的应用类型。

我们这里是一个普通的 Web 应用，所以最终返回的类型为 SERVLET。所以会通过反射加载 DEFAULT_SERVLET_WEB_CONTEXT_CLASS，最后返回一个 AnnotationConfigServletWebServerApplicationContext 实例（就像我们上文所说的那样）。



## 3.4 构建容器上下文

接着我们来到 run () 方法编号 11 的 prepareContext () 方法。通过方法名，我们也能猜到它是为 context 做上台前的准备工作的。

```java
private void prepareContext(ConfigurableApplicationContext context, ConfigurableEnvironment environment,
			SpringApplicationRunListeners listeners, ApplicationArguments applicationArguments, Banner printedBanner) {
    ......
    // 加载资源
    load(context, sources.toArray(new Object[0]));
    listeners.contextLoaded(context);
}
```

在这个方法中，会做一些准备工作，包括初始化容器上下文、设置环境、加载资源等。



### 加载资源

上面的代码中，又调用了一个很关键的方法 ——load ()。这个 load () 方法真正的作用是去调用 BeanDefinitionLoader 类的 load () 方法。源码如下：

```java
class BeanDefinitionLoader {
    ......
	int load() {
		int count = 0;
		for (Object source : this.sources) {
			count += load(source);
		}
		return count;
	}

	private int load(Object source) {
		Assert.notNull(source, "Source must not be null");
		if (source instanceof Class<?>) {
			return load((Class<?>) source);
		}
		if (source instanceof Resource) {
			return load((Resource) source);
		}
		if (source instanceof Package) {
			return load((Package) source);
		}
		if (source instanceof CharSequence) {
			return load((CharSequence) source);
		}
		throw new IllegalArgumentException("Invalid source type " + source.getClass());
	}
    ......
}
```

可以看到，load () 方法在加载 Spring 中各种资源。其中我们最熟悉的就是 load ((Class<?>) source) 和 load ((Package) source) 了。一个用来加载类，一个用来加载扫描的包。

load ((Class<?>) source) 中会通过调用 isComponent () 方法来判断资源是否为 Spring 容器管理的组件。 isComponent () 方法通过资源是否包含 @Component 注解（@Controller、@Service、@Repository 等都包含在内）来区分是否为 Spring 容器管理的组件。

而 load ((Package) source) 方法则是用来加载 @ComponentScan 注解定义的包路径。



## 3.5 小结

我们知道，Spring 是一个容器，我们喜欢它的一个重要原因就是它帮我们把 Bean 进行了统一的管理。Bean 的创建与销毁都由 Spring 来完成，而我们只需要关注使用，这也是 Spring IoC 的核心工作内容。

到此，Spring 真正开始开展 Bean 管理的工作了，prepareContext () 方法把所有需要管理的 Bean 统计出来，在后面的 refreshContext () 方法中会进行更进一步的操作。由于 refreshContext () 方法和自动配置关系紧密，所以我们放的下一节和自动配置一起来讲。



# 4. 总结

OK，这一节我们一起分析了 Spring Boot 的启动流程，了解了 Spring Boot 在启动的过程中都做了哪些事。然后选了几个比较有代表性的部分进行了更详细的分析。

源码分析的内容，需要多多动手 Debug。只有多扒几遍代码才能把你看到的内容转化成真正属于你的知识，希望你不要偷懒，多扒一扒 Spring Boot 启动的这段逻辑。下节继续带你扒自动配置的源码，不见不散！

[28 带你解锁AOP的各种姿势](http://www.imooc.com/read/75/article/1824)[30 掰开揉碎刨铣自动配置的原理](http://www.imooc.com/read/75/article/1826)

精选留言 2

欢迎在这里发表留言，作者筛选后可公开显示

- [慕慕童鞋](http://www.imooc.com/u/8954842/articles)

  想起了范伟老师：我不想知道我是怎么来的，我就想知道我是怎么没的，哈哈哈

   0

  回复

  2020-06-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕慕童鞋](http://www.imooc.com/u/8954842/articles)

    想象力爆棚。

    回复

    2020-06-28 20:24:18

- [慕慕童鞋](http://www.imooc.com/u/8954842/articles)

  原来 Spring Boot 启动的时候干了这么多事！

   0

  回复

  2020-06-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕慕童鞋](http://www.imooc.com/u/8954842/articles)

    是的，把脏活累活全替我们干了。

    回复

    2020-06-28 20:24:06

 

千学不如一看，千看不如一练