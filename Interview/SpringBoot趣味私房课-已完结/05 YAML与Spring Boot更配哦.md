**05 YAML与Spring Boot更配哦~**

# 05 YAML与Spring Boot更配哦~

更新时间：2020-05-26 11:41:35

![img](http://img3.sycdn.imooc.com/5e9cff1e00017dc806400359.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

不想当将军的士兵，不是好士兵。

——拿破仑



## 1. YAML简介

> YAML（/ˈjæməl/，尾音类似 camel 骆驼）是一个可读性高，用来表达数据序列化的格式。YAML 参考了其他多种语言，包括：C 语言、Python、Perl，并从 XML、电子邮件的数据格式（RFC 2822）中获得灵感。Clark Evans 在 2001 年首次发表了这种语言，另外 Ingy döt Net 与 Oren Ben-Kiki 也是这语言的共同设计者。当前已经有数种编程语言或脚本语言支持（或者说解析）这种语言。

camel YAML 

支持这种语言了 

——维基百科

Spring（以及其他主流 Java 框架）的配置文件从最开始的 XML 到后来的 Properties ，再到现在比较流行的 YAML 。一路的演变越来越关注数据本身，这一点从 YAML 的名字就可见一斑。

> YAML: YAML Ain’t Markup Language



Spring 以及其他主流Java框架 的配置文件从最开始的XML 到后来的Properties 再到现在比较流行的YAML

一路的演变越来越关注数据本身

Yet Another Markup Language

你们



## 2. YAML与Properties

`YAML 不是一种标记语言` 作者通过 YAML 的名字也正是想传达这种语言以数据做为中心，而不是以标记语言为重点，下面我们来看看 YAML 跟 Properties 有哪些不同吧（示例来自 [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-yaml)）。

Properties：

```yaml
environments.dev.url=https://dev.example.com
environments.dev.name=Developer Setup
environments.prod.url=https://another.example.com
environments.prod.name=My Cool App
```

YAML：

```yaml
environments:
	dev:
		url: https://dev.example.com
		name: Developer Setup
	prod:
		url: https://another.example.com
		name: My Cool App
```

比起 XML 来，不管是 Properties 还是 YAML 都已经非常简洁了，都很好的体现了以数据为中心的理念。不过从结构上看 YAML 更加具有整体性和层次感，一眼看上去更容易体现上述配置是对一个对象的各个属性的赋值，而 Properties 在这一点上稍微弱了一点，它的内容一眼看上去更像是四条配置项，至于它们之间是什么关系并不是很明确。而且 YAML 的写法更加简洁一些（用缩进代替了重复的前缀）。



以数据为中心的理念

YAML 更加具有整体性 和 层次感  

一眼看上去更容易体现上述配置是对一个对象的各种属性的赋值

properties  

写法简洁  缩进代替了重复的前缀 

## 3. YAML语法



### 3.1 基本规则

- 大小写敏感
- 使用空格缩进表示层级关系
- 缩进的空格数目没有要求，同级元素左侧对齐即可
- 使用 # 注释，只有行注释，没有块注释
- key 与 value 用 `:` 加上空格来分割



基本规则

大小写敏感

使用空格缩进表示层级关系

左侧对齐即可

``# `注释

key  value    :  加上空格来分割

   

### 3.2 基本组件

YAML 基本组件主要就两种：

- 对象（映射/字典）
- 数组（列表）

对象：

```yaml
person:
  name: John Smith
  age: 33
```

数组：

```yaml
- apple
- banana
```

基本组件

对象  映射   字典

数组 列表  

### 3.3 数据类型

- 字符串
- 布尔值
- 数值（整型、浮点）
- Null
- 日期时间（Date、Time）

示例：

```yaml
number: 123
boolean: true
string: hello
null: ~
date: 2019-06-09
```

OK，有了以上这些知识，应对我们接下来的实战内容已经足够了，YAML 还有一些高级用法，如果感兴趣可以自己去探索一下。



## 4. Spring Boot常用配置项

常用配置项：

```yaml
spring:
  # 数据源配置
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    url: jdbc:mysql://127.0.0.1:3306/spring_boot
    username: root
    password: 123456
    driver-class-name: com.mysql.jdbc.Driver
    name: druid
  druid:
    # 初始化大小，最小，最大
    initialSize: 5
    minIdle: 5
    maxActive: 20
    # 配置获取连接等待超时的时间
    maxWait: 60000
    # 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    timeBetweenEvictionRunsMillis: 60000
    # 配置一个连接在池中最小生存的时间，单位是毫秒
    minEvictableIdleTimeMillis: 300000
  
  # http请求
  http:
  	#json序列化框架
    converters:
      preferred-json-mapper: fastjson
    #上传文件、请求最大限制
    multipart:
      max-file-size: 50MB
      max-request-size: 50MB

  # Spring MVC配置
  mvc:
    dispatch-options-request: true
    static-path-pattern: /**

  # 激活环境配置
  profiles:
    active: local

  # Redis配置
  redis:
    host: 127.0.0.1
    port: 6379

  # 应用名
  application:
    name: springboot

# Redis客户端
jedis:
  pool:
    host: 127.0.0.1
    port: 6379

# 线程池的配置文件
threads:
  pool:
    queueCapacity: 50
    corePoolSize: 20
    maxPoolSize: 50
    keepAliveSeconds: 600

# 日志级别
logging:
  level: info

# Web服务器
server:
  # 超时时间
  session:
    timeout: 60
  # 端口
  port: 8080
  # 根路径
  context-path: /springboot
```

以上是 Spring Boot 比较常用的一些配置项，不需要刻意去记，这些配置都是在应用中慢慢熟悉的。



## 5. 总结

这一节我们一起学习了一种不是标记语言的标记语言—— YAML 。了解了它的基本构成，语法和用法，还和 Properties 做了一些对比，突出了 YAML 的特性。后面我们还对 Spring Boot 的常用配置项做了一个初步的了解，后面还会经常的使用。最后，希望你也会喜欢 YAML 这个不甘心做一个标记语言的标记语言，我们下一小节见！

[04 从Spring Boot的工程结构体会其设计哲学](http://www.imooc.com/read/75/article/1800)[06 就想买个电脑追剧，别扯什么四核独显-Starters](http://www.imooc.com/read/75/article/1802)

精选留言 4

欢迎在这里发表留言，作者筛选后可公开显示

- [weixin_慕运维0427676](http://www.imooc.com/u/2940273/articles)

  白嫖了

   0

  回复

  2020-07-06

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[weixin_慕运维0427676](http://www.imooc.com/u/2940273/articles)

    哈哈，可以分享给更多人哦

    回复

    6天前

- [weixin_慕桂英9205550](http://www.imooc.com/u/7367450/articles)

  YAML:yet another markup language

   0

  回复

  2020-07-03

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[weixin_慕桂英9205550](http://www.imooc.com/u/7367450/articles)

    是的

    回复

    6天前

- [qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

  YAML 不是一种标记语言

   0

  回复

  2020-06-20

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    哈哈。

    回复

    2020-06-22 20:29:48

- [一只程序猿儿](http://www.imooc.com/u/2793308/articles)

  学习了

   0

  回复

  2020-05-26

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[一只程序猿儿](http://www.imooc.com/u/2793308/articles)

    感谢支持！

    回复

    2020-05-27 21:11:08

 

千学不如一看，千看不如一练