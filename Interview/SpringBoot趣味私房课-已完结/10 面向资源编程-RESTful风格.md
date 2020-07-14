**10 面向资源编程-RESTful风格**

10 面向资源编程-RESTful风格

更新时间：2020-05-26 11:45:45

![img](http://img2.sycdn.imooc.com/5e9cffce00013f8a06400359.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

虚心使人进步，骄傲使人落后。

——毛泽东

![图片描述](http://img1.sycdn.imooc.com/5e9ac08c0001f28505790349.png)



# 1. 初探

经过上一小节的学习，对于 Spring MVC 我们掌握的已经差不多了，是时候来用它做点什么了。通过标题你应该已经知道了，我们接下来要学习一下使用 Spring MVC 来构建 RESTful 接口。



## 1.1 WHY？

在学一个东西之前，我们通常需要搞清楚我们为什么要学习它，因为这有助于我们把它学好。闲言碎语不要讲，只谈干货和理想。我们就看看学习 RESTful 的意义何在。不管你之前是前端、后端还是客户端，亦或是还没有过编程方面的工作经验。凡是跟着本课程一起学到现在的同学，肯定都想具备开发服务端接口的能力。那么基于这个大前提我们就可以更清晰的去讨论 RESTful 对于我们的意义了。

很久以前（暴露年龄的时候又来了）后端人员不仅 Java 功底要扎实，还需要熟练掌握 HTML、CSS、JS、JSTL、EL 表达式等前端技术。当年像什么 EasyUI、JQuery、dwz 用的也是相当的顺手呢。后来随着 Angular、React、Vue 等前端框架的崛起，还有移动互联网的迅猛发展，前后端分离的开发模式逐渐占据了主流。说了这么多，这些跟 RESTful 有啥关系呢？前后端分离，移动互联网的爆发，导致了后端服务不仅要为 Web 端提供支持，还要支持移动端（ Android、IOS 等），那么对于 API 的规范就需要有一定的要求了。这个时候 RESTful 的优势就体现出来了，它更简洁，更有层次，更易于实现缓存。



## 1.2 简介

> 表现层状态转换（英语：Representational State Transfer ，缩写：REST ）是 Roy Thomas Fielding 博士于 2000 年在他的博士论文中提出来的一种万维网软件架构风格，目的是便于不同软件/程序在网络（例如互联网）中互相传递信息。表现层状态转换是根基于超文本传输协议 ( HTTP ) 之上而确定的一组约束和属性，是一种设计提供万维网络服务的软件构建风格。
> ——维基百科

以上是维基百科中对于 REST 的解释，如果你通过以上的描述理解了 REST 是个什么东西，那你该干嘛干嘛去吧，我不喜欢跟天才做朋友。假如你没理解，那咱们继续愉快的玩耍吧。



## 1.3 资源

其实 `表现层状态转换` 说的比较抽象，而且省略了 `表现层` 的所属对象。这里的 `表现层` 可以理解为 `资源` 的表现层。那什么是资源呢？其实 `资源` 的范围比较宽泛，一个文件（图片、文档、音乐等）、一条数据（用户信息、订单等）都可以看做是资源（每个资源都有一个对应的 URI ）。我们在学习面向对象的时候有一句五字真言——万物皆对象。可以拿过来套用一下——万物皆资源。



## 1.4 表现层

Representational ，国内翻译成 `表现层`，其实我觉得叫 `表现形式` 会更容易理解。其实说白了就是资源以什么样的形式去展现自己——文本可以是 JSON 或 XML ，图片也可以是各种格式。所以我们现在将 REST 的中文翻译成 `资源表现形式的状态转换`，那么接下来我们再来理解一下这个状态转换。



## 1.5 状态转换

状态转换？好像又不是很好理解呢。上面我们对于 REST 的翻译进化到了 `资源表现形式的状态转换`，比起 `表现层状态转换` 好像清晰了一些，但总觉得哪里不太对。因为我们有一个地方没有明确，就是一个资源的表现形式通常情况下是确定的。

对 REST 的翻译我们可以再进化一步，现在变成了 `资源以某种表现形式进行状态转换`。这样一来又变得明朗了一些，转换其实就是发生了变化，就是改变的意思。而资源的状态发生了改变，其实就是说资源被修改了！握草？原来我随随便便在慕课网修改一下自己的用户信息就完成了一次 `表现层状态转换`？博士你不厚道呀，听到 REST 的时候膝盖都给你了，结果你就给我展示了一下数据操作的另一种叫法。其实不是的，REST 的核心不仅仅是对数据的操作，还有如何去操作，以什么样的规范去操作。



## 1.6 小结

OK，第一部分主要针对 REST 的概念进行了讨论，从 `表现层状态转换` 一路进化到了 `资源以某种表现形式进行状态转换`。其实说得再直白一些就是 `按照一定的规范去操作某种特定格式的数据`。那么到底是什么样的规范，又是如何操作的呢？我们第二部分见分晓。



# 2. 实战

相信通过上一趴的学习，你已经对 REST 的概念有了比较清楚的理解。那么接下来我们通过实践，来巩固一下。学完了内功心法，一定要配合武功招式才能发挥武功的真正威力。



## 2.1 书接上回

上一趴留下了两个疑问：

1. REST规范是什么
2. 通过什么手段进行状态的转换

这一节就从这两个遗留问题展开，一点点来讨论。



## 2.2 规范与手段

下面是 RESTful 风格的规范：

- 用 URI 定位资源（为啥不是URL？）
- URI 由名词组成
- 使用 HTTP 方法对应数据的操作



## 2.3 举个栗子

假如我们要获取一个 ID 为 1 的用户信息，使用 REST 风格是什么样子呢？看下面这个例子：

```
GET "http://localhost:8080/rest/user/1"
```

其中，`http://localhost:8080/rest/user/1` 就是用来定位 ID 为 1 的用户（资源）；`GET` 是 HTTP 的一个方法，用来表示获取、查询；并且请求 URI `/user/1` 也都是由名词组成。

后台代码实现大致如下：

```java
@RestController
@RequestMapping("/rest")
public class RestFulController {
  
  @GetMapping("/user/{id}")
  public User get(@PathVariable int id) {
    ...
  }
    
}
```

吃完上面这个小栗子，我们对于 REST 风格的接口有了更加形象的认识。上面演示了一个查询数据的操作，我们知道对于数据的基本操作有四种——中文是：增删改查；英文是：CRUD 。HTTP 中刚好也有四个方法（ GET - 查询、POST - 新增、PUT - 更新、DELETE - 删除）对应这四种操作：

| HTTP方法 | 安全性 | 幂等性 | 接口说明           |
| :------- | :----- | :----- | :----------------- |
| GET      | 安全   | 幂等   | 获取资源（Read）   |
| POST     | 不安全 | 非幂等 | 创建资源（Create） |
| PUT      | 不安全 | 幂等   | 更新资源（Update） |
| DELETE   | 不安全 | 幂等   | 删除资源（Delete） |

> 安全性和幂等性我们在下一节做详细说明。

创建用户：

```
POST "http://localhost:8080/rest/user"
Content-Type: application/json
```

上面的 `Content-Type` 就是我们上一节里提到的 `表现形式`。

POST 方法参数通常会放到请求体（ RequestBody ）中，以 `Content-Type` 中的格式（ JSON ）提交到服务端：

```json
{
  "age": 10,
  "birthDay": "2019-07-07",
  "email": "imooc@imooc.com",
  "name": "imooc"
}
```

使用 `@RequestBody` 注解接收前度传来的参数：

```java
@PostMapping("/user")
public boolean create(@RequestBody User user) {
  ...
}
```

PUT 与 POST 类似，DELETE 与 GET 类似，这里就不占用篇幅了，但你一定要自己去实践一下哦。



## 2.4 URL&URI

不知道你有没有注意到，上面描述 REST 规范的时候用的是 `URI` ，而不是我们更为熟悉的 `URL` 。它们两个有什么区别和联系呢？想要弄清楚它们之间的关系，需要引入第三者—— URN ，这里我们不过多介绍，只是为了说明 URI 和 URL 的关系。



## 2.5 名词解释

- **URI**：Universal Resource Identifier 统一资源标志符
- **URL**：Universal Resource Locator 统一资源定位符
- **URN**：Universal Resource Name 统一资源名称



### 2.5.1 关系

通过名字看不出它们三个有什么不同，我们先不管它们具体是什么，先来看看它们三个之间的关系：

![图片描述](http://img1.sycdn.imooc.com/5e9ac07300010e9108000482.png)
一图胜千言，通过上图我们很轻易就可以知道，URL 和 URN 都是 URI 的子集。也就是说如果一个东西是 URL 或者 URN ，那么它一定也是URI。[RFC3986](https://tools.ietf.org/html/rfc3986#section-1.1.3)中有一句话：A URI can be further classified as a locator, a name, or both. 这句话更明确的说明了它们的关系—— URI = URL + URN。



### 2.5.2 区别

URL 和 URI 的关系明确了，我们再来看如何分辨什么样的 URI 可以称为 URL 。其实它们两个的不同之处就在于 URN 。我们现在知道了 URI 有时候可以是 URL ，但当一个 URI 只符合 URN 规范的时候它就不能叫做 URL 了。看下面的例子：

```
1. https://www.imooc.com
2. mailto:imooc@imooc.com
```

1 是 URL ，它符合 URL 的定义（定位符），因为它可以定位到一个具体的位置（慕课网）；2 则不是 URL ，它是 URN ，它不能定位的任何数据。



## 2.6 小结

OK，在第二部分中做了几个 RESTful 接口，算是小试牛刀，一定要亲自实践一下。实践不仅能够加深印象，在实践的过程中可能会遇到各种情况，应对各种情况，解决各种问题则是你成长最快的方式之一。

后面我们又一起学习了 URI 和 URL 的关系与区别，很多人对于这两个家伙分的不是很清楚，我之前也是傻傻分不清楚。所以特意在这里把它们拿出来，一起学习一下。相信现在你已经可以轻松的理解 URI 和 URL 了，可喜可贺！



# 3. 总结

通过本节两部分内容的学习，我们对于 RESTful 风格已经有了较为全面的认识了。理论上已经非常完备了，实战方面也做了一个小例子。后面想要掌握的更加牢固与熟练，还需要进一步的去实战。

[09 斗转星移再现江湖-Spring MVC](http://www.imooc.com/read/75/article/1805)[11 每个程序员都应该懂点HTTP](http://www.imooc.com/read/75/article/1807)

精选留言 3

欢迎在这里发表留言，作者筛选后可公开显示

- [YUnHolding丶sand](http://www.imooc.com/u/2597858/articles)

  老师可以讲解一下使用REST风格的api，有什么好处吗？

   0

  回复

  5天前

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[YUnHolding丶sand](http://www.imooc.com/u/2597858/articles)

    REST 的好处就像 1.1 中所说的那样，在为多前端（WEB、移动端）提供服务的时候更加的简单明了，通用性更强一些。

    回复

    15小时前

  - [Jobs_Zhang](http://www.imooc.com/u/9104842/articles)

    回复[YUnHolding丶sand](http://www.imooc.com/u/2597858/articles)

    自己的一个见解：https://mindartisan.blog.csdn.net/article/details/105085019

    回复

    3小时前

- [fisherss](http://www.imooc.com/u/8203003/articles)

  老师，3-4 URL&URI标题目录这个地方笔误了，应该是2-4

   0

  回复

  2020-05-22

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[fisherss](http://www.imooc.com/u/8203003/articles)

    好哒，感谢细心的 fisherss 提醒呦。

    回复

    2020-05-22 21:25:36

- [qq_庞庞_0](http://www.imooc.com/u/6173405/articles)

  最近正在写接口，犹豫要不要用这种风格，貌似9各种风格就必须用路径传参数，也就是@pathvariable注解，但是这个注解会导致路由在应用启动是变得不确定，然后又准备在网关去做资源权限控制，这样的话用户输入的参数会动态变化，没办法去匹配这个路径，目前也没有好的解决的方法，希望老师能给一点建议

   0

  回复

  2020-04-28

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_庞庞_0](http://www.imooc.com/u/6173405/articles)

    如果是对外服务的接口（有其他系统会调用），那么强烈推荐使用rest。如果不是那用不用都可以（内部业务有时候很难完全rest化）。用的话可以参考GitHub的rest设计。

    回复

    2020-05-12 11:11:29

  - [缘莱有我陪](http://www.imooc.com/u/3580005/articles)

    回复

    [刘水镜](http://www.imooc.com/u/8840839/articles)

    所以，如果非要使用rest的话，是不是权限控制就没法做了？这两个好像互斥

    回复

    8天前

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[缘莱有我陪](http://www.imooc.com/u/3580005/articles)

    不冲突的，你可以了解一下 Spring Security。

    回复

    8天前

 

千学不如一看，千看不如一练

 