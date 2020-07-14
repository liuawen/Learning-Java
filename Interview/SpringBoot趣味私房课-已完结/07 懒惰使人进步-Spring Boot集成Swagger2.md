**07 懒惰使人进步-Spring Boot集成Swagger2**

07 懒惰使人进步-Spring Boot集成Swagger2

更新时间：2020-05-26 11:42:35

![img](http://img2.sycdn.imooc.com/5e9cff400001256306400359.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

学习这件事不在乎有没有人教你，最重要的是在于你自己有没有觉悟和恒心。

—— 法布尔



## 1. Swagger诞生

Java Web 从最开始的 JSP 到后来加入 Ajax 异步交互，再到现在的前后端分离，后端人员从一开始包揽 HTML、JS、Java 代码到现在更加聚焦于后端业务逻辑。随着开发模式的演变，前后端人员的分工越来越精细，联系也越来越松散，接口文档成了前后端配合的一道关键桥梁。最初，通常的做法是将接口文档写在公司内部的 WIKI 上（如 Confluence ）。但这种做法的致命缺点就是接口文档几乎永远都会落后于实际代码实现。这让我们的开发工作不能顺畅的进行下去，于是我们今天的主角 Swagger 应运而生。



接口文档  永远落后于实际代码实现 

## 2. Swagger是什么

Swagger 是一款用于生成、描述、调用和可视化 RESTful 风格的 Web 服务接口文档的框架。其最大的特点莫过于可以使接口文档与代码实时同步。

Swagger 

## 3. 整合

要使用 Swagger ，首先我们需要添加 Swagger 对应的依赖：

```xml
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger-ui</artifactId>
  <version>2.8.0</version>
</dependency>
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger2</artifactId>
  <version>2.8.0</version>
</dependency>
```

接下来需要添加 Swagger 的基础配置：

```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo()).select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot实战")
            .description("Spring Boot实战的RESTFul接口文档说明")
            .version("1.0").build();
    }
}
```

> 简单说一下第 8 行代码：apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) 。这行代码是告诉 Swagger 要扫描有 `@Api` 注解的类，可以将 `Api.class` 替换成 `ApiOperation.class` 扫描带有 `@ApiOperation` 注解的方法。当然还可以使用 `basePackage()` 方法配置 Swagger 需要扫描的包路径。

最后我们要完善一下之前的接口，加上一些 Swagger 的注解：

```java
@Api
@RestController
public class HelloController {

    @ApiOperation("Hello Spring Boot 方法")
    @GetMapping("/")
    public String hello(@RequestParam(required = false) @ApiParam("名字") String name) {
        if (name != null && !"".equals(name)) {
            return "Hello " + name;
        }
        return "Hello Spring Boot";
    }
}
```



## 4. 效果

经过以上三个步骤，我们的 Swagger 就已经集成到我们的工程里了，现在启动工程，然后访问：http://localhost:8080/swagger-ui.html。 如果看到如下效果，就说明我们的 Swagger 已经配置成功。

![图片描述](http://img1.sycdn.imooc.com/5e9abdb8000147b917661020.png)

> Swagger 的页面分为两部分，最上面是接口的基本信息，如上图所示，包含了项目名称、描述等信息 ：下面是每个接口的具体描述，如接口名字、参数名字、参数类型、是否必填等，还有返回的结果的示例。

将 `Hello Spring Boot` 方法展开可以看到该方法的详细描述：

![图片描述](http://img1.sycdn.imooc.com/5e9abd990001e66017200620.png)

我们可以看到，该方法有一个参数 `name` ，点击右上角的 `Try it out` 我们来测试一下：

![图片描述](http://img1.sycdn.imooc.com/5e9abd84000109d117280716.png)

在文本框内输入 `IMOOC` 点击下面的 `Execute` 按钮看一下调用结果：

![图片描述](http://img1.sycdn.imooc.com/5ea454e90001ee9c17260972.png)

我们看到接口返回状态码为 `200` ，Response body 中打印出我们刚刚输入的值，OK 接口测试成功！



## 5. 常用注解

| **注解**          | **作用域** | **说明**                             |
| :---------------- | :--------- | :----------------------------------- |
| @Api              | 类         | 标识类为Swagger资源（Controller）    |
| @ApiModel         | 类         | 描述接口实体类（通常为参数或返回值） |
| @ApiOperation     | 方法       | 用于描述接口方法                     |
| @ApiModelProperty | 属性/方法  | 描述接口实体属性                     |
| @ApiParam         | 参数       | 描述接口参数                         |

以上为我们最常用的五个注解。在上面的例子中，我们使用了 `@Api` `@ApiOperation` `@ApiParam` 三个注解，另外两个我们会在后面的学习中使用到。



## 6. 坑

在 Swagger 的使用过程中，你可能会遇到了一些 “坑”，在这里把出现频率比较高的坑分享出来，提前有个准备，免得到时候掉到坑里上不来。

坑 在Swagger的使用过程中 你可能

### 6.1 接口404

#### 现象

在 Swagger 页面调用接口（在 `Try it out` 中进行 `Execute`），返回 404，Request URL 中的地址中间莫名的多了一段路径：`/v2/api-docs` 例如：

```http
http://localhost:8080/v2/api-docs/springboot/hello
```

#### 原因

开始遇到这个问题的时候，百思不得其解，完全没有思路，网上寻找解决方案，根本找不到。升级版本、换浏览器、重启大法统统无效。最后，经过不懈努力与钻研（其实就是多看了浏览器地址栏一眼），发现原来是 Swagger 地址中端口号后面多了一个 `/` 。

#### 解决方案

检查 Swagger 地址栏中是否多了一个 `/` ，去掉即可。



### 6.2 Unable to infer base url

#### 现象

浏览器中打开 Swagger 的地址，弹出错误提示框，错误信息如下：

```
Unable to infer base url. This is common when using dynamic servlet registration or when the API is behind an API Gateway. The base url is the root of where all the swagger resources are served. For e.g. if the api is available at http://example.org/api/v2/api-docs then the base url is http://example.org/api/. Please enter the location manually:
```

#### 原因

项目中有使用 `@RestControllerAdvice` 注解进行全局异常处理，导致 Swagger 失效。

#### 解决方案

在全局异常处理类的 `@RestControllerAdvice` 注解中指定 Controller 的包名即可：

```java
@RestControllerAdvice(basePackages = "com.imooc.springboot.controller")
```



### 6.3 采坑总结

在 Swagger 的使用中，如果遇到问题，可以安以下思路去排查：

如果你的 Swagger 地址为：

```http
http://localhost:8080/swagger-ui.html
```

那么你先访问：

```http
http://localhost:8080/v2/api-docs
```

看返回的结果是否类似下面的结构：

```json
{
  "swagger": "2.0",
  "info": {
    "description": "Spring Boot实战的RESTFul接口文档说明",
    "version": "1.0",
    "title": "Spring Boot实战"
  },
  "host": "localhost:8080",
  "basePath": "/"
  ...
}
```

如果这个接口返回的数据格式不对，或者此接口无法访问，那么说明 Swagger 可能根本没有与 Spring Boot 集成到一起；如果是类似的结构，说明你的 Swagger 与 Spring Boot 已经成功集成，再去根据具体的错误提示去分析。

我们日常的工作学习中，会遇到各种各样、大大小小的坑。有些坑可以通过错误信息一步步找到原因并解决；而有些坑则无迹可循，只能凭着 “经验” 和运气摸着石头排错；有些坑更加复杂，一坑套一坑，可谓是大坑套小坑，小坑套老坑，坑中还有水，水中还有钉，下去就没影儿了。希望每个程序员在工作和学习中都能化坑为夷，一马平川。



## 7. 总结

OK，本小节我们一起了解 Swagger ，并学习了如何将 Swagger 与 Spring Boot 进行整合，还有一些常规的使用，最后介绍了一下 Swagger 的常用注解。学完本小节后，我们就具备了在日常开发中使用 Swagger 的能力。后续的章节中我们还会经常借助 Swagger 来完成对于 Spring Boot 的学习，让我们一起期待吧！

[06 就想买个电脑追剧，别扯什么四核独显-Starters](http://www.imooc.com/read/75/article/1802)[08 代码的护身符-单元测试](http://www.imooc.com/read/75/article/1804)

精选留言 5

欢迎在这里发表留言，作者筛选后可公开显示

- [慕尼黑4165573](http://www.imooc.com/u/6482665/articles)

  springboot需要配置 @Configuration public class WebMvcConfig extends WebMvcConfigurerAdapter { @Override public void addResourceHandlers(ResourceHandlerRegistry registry) { super.addResourceHandlers(registry); registry.addResourceHandler("swagger-ui.html") .addResourceLocations("classpath:/META-INF/resources/"); registry.addResourceHandler("/webjars/**") .addResourceLocations("classpath:/META-INF/resources/webjars/"); } } 否则就会404 另外，您说的配置类把Api.class可以换成ApiOpreation.class,我试了一下，不行，页面会报 No operations defined in spec! 不知道是我哪里没配对

   0

  回复

  2020-06-30

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕尼黑4165573](http://www.imooc.com/u/6482665/articles)

    你用的 Spring Boot 和 Swagger 是什么版本？可以加我微信，给你看下：liushuijinger

    回复

    2020-07-02 19:05:08

- [反物](http://www.imooc.com/u/2420210/articles)

  老师，swagger2的配置类是写在哪一层目录里的？springboot是怎么确定配置类所在的位置的呢？

   0

  回复

  2020-06-30

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[反物](http://www.imooc.com/u/2420210/articles)

    配置类的位置可以参考一下源码：https://github.com/liushuijinger/springboot Spring Boot 是通过 @Configuration 注解识别配置类的。

    回复

    2020-06-30 14:24:04

- [qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

  如何才能遇到这个坑，我怎们尝试也尝试不出这个坑的由来。我想深深的记住这个坑长什么样子 遇不到这个坑

   0

  回复

  2020-06-20

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    世界上本没有坑？那不过是你走得路还不够多罢了。

    回复

    2020-06-22 20:20:29

  - [慕斯卡13455675](http://www.imooc.com/u/9104099/articles)

    回复[qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    啊哈哈哈。。有个性的你

    回复

    2020-06-28 17:20:23

- [qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

  有些坑更加复杂，一坑套一坑，可谓是大坑套小坑，小坑套老坑，坑中还有水，水中还有钉，下去就没影儿了

   0

  回复

  2020-06-20

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    不断掉坑里，不断爬出来，就是胜利。

    回复

    2020-06-22 20:21:33

- [小熊二喵](http://www.imooc.com/u/7913832/articles)

  Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled. 2020-05-18 21:53:01.244 ERROR 17788 --- [ main] o.s.boot.SpringApplication : Application run failed org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'xmlModelPlugin': Lookup method resolution failed;

   1

  回复

  2020-05-18

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[小熊二喵](http://www.imooc.com/u/7913832/articles)

    辛苦把完整的错误信息帖一下呗，或者加我 VX（liushuijinger） 帮你看下。

    回复

    2020-05-19 21:32:23

 

千学不如一看，千看不如一练

 