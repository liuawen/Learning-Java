# **20 一个数据库连接池的自我修养——Druid**

20 一个数据库连接池的自我修养——Druid

更新时间：2020-05-26 11:25:26

![img](http://img2.sycdn.imooc.com/5ebcb3f7000186d806400359.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

加紧学习，抓住中心，宁精勿杂，宁专勿多。

—— 周恩来



# 1. 前言

最近几节的内容基本上都是与数据层相关的东西，从 JPA 到 Mybatis，再到事务和 Redis。用了很多笔墨在讨论数据层相关的东西，为啥嘞？因为它重要呗！数据是一个系统的基石，想象一下我们日常使用的 App 如果没有数据的加持会变成什么样子？你还会用吗？打开淘宝发现一件商品也没有，打开新浪微博一条微博也没有，更不要说看热搜吃瓜了。



数据层  重要 

数据是一个系统的基石

没有数据的加持 

还会用  打开淘宝发现一件商品也没有  打开新浪微博一条微博也没有 更不要说看热搜吃瓜了



数据不仅是一个系统的基石，更是一个企业安身立命赖以生存的宝贵资源。在信息时代，在互联网时代，在数据时代，挖掘数据价值的能力是一个企业必备技能。不同的业务对于数据的处理方式各有不同，系统中数据层的设计也各具特色，但不管业务怎么变，数据模型怎么建，任何系统对于数据层都有两个共同的要求 ——1，快速；2，稳定。

数据   宝贵资源

消息时代 互联网时代 数据时代

挖掘数据价值的能力 必备技能 不同的业务对于数据的处理方式各有不同 

系统中数据层的设计



意思是天下武功，什bai么都可以打败，只有速度快du，是zhi没有办法的。



火云邪神说过：天下武功无坚不破，唯快不破。如何让数据以更快的速度到达用户面前，一直是我们不懈的追求。不管是硬件方面的升级还是软件架构（各种缓存、CDN）上的进化，无一不想追求一个 “快” 字。系统越快越好，但作为一个男人一定不能太快，因为据我观察女生更喜欢成熟稳重的男生。而这个 “稳” 字正是我们另外一个不懈追求的目标。我们做分布式、集群、做备份机都是为了让系统更加 “稳”。

基于关系型数据库（MySQL、Oracle、SQLServer 等）的应用最终的性能瓶颈都会落到数据库上。为啥？你去看看讲 Redis 的第一小节就知道了。不过好在先天的不足可以通过后天的努力来改善，为了改善这个问题数据库连接池应运而生。



数据更快的速度到达用户面前



一直是我们不懈的追求



块

不懈的追求



硬件方面的升级 还是软件架构  各种缓存 CDN上的进化

快  稳    成熟稳重 

分布式  集群 备份机  



先天不足  关系性数据库  

后天的努力来改善 



数据库连接池 

# 2. 连接池



## 2.1 基本原理

在系统初始化的时候，会根据配置信息预先创建一些数据库连接对象，并存放于内存中。当需要访问数据库的时候，直接去连接池里 “借” 一个连接过来用。当完成数据库操作以后，再将这个连接 “还” 给连接池。从而实现了资源共享重复利用的目的，近几年很火的共享经济（共享单车、共享汽车、共享充电宝等）不就是这种思路吗？原来这些看起来新鲜的玩法都是跟程序员学来的。

连接池技术避免了频繁创建与销毁连接的情况，并且线程池还可以根据当前的使用情况去动态增减数据库连接数，做到一定程度上的按需 “备货”，使得数据库资源的利用变得更加合理，不但速度上有了很大的提升，稳定性也得到了改善。



## 2.2 如何选择连接池

市面上有很多 Java 的数据库连接池组件，该如何选择呢？不废话，先看下面这张表：

| 功能类别 | 功能                | Druid        | HikariCP    | DBCP | Tomcat-jdbc     | C3P0 |
| :------- | :------------------ | :----------- | :---------- | :--- | :-------------- | :--- |
| 性能     | PSCache             | 是           | 否          | 是   | 是              | 是   |
|          | LRU                 | 是           | 否          | 是   | 是              | 是   |
|          | SLB 负载均衡支持    | 是           | 否          | 否   | 否              | 否   |
| 稳定性   | ExceptionSorter     | 是           | 否          | 否   | 否              | 否   |
| 扩展     | 扩展                | Filter       |             |      | JdbcIntercepter |      |
| 监控     | 监控方式            | jmx/log/http | jmx/metrics | jmx  | jmx             | jmx  |
|          | 支持 SQL 级监控     | 是           | 否          | 否   | 否              | 否   |
|          | Spring/Web 关联监控 | 是           | 否          | 否   | 否              | 否   |
| 诊断     | 诊断支持            | LogFilter    | 否          | 否   | 否              | 否   |
|          | 连接泄露诊断        | logAbandoned | 否          | 否   | 否              | 否   |
| 安全     | SQL 防注入          | 是           | 无          | 无   | 无              | 无   |
|          | 支持配置加密        | 是           | 否          | 否   | 否              | 否   |

> 这张表来自于 Druid GitHub 中的一篇介绍文章，更多内容查看 [Druid 连接池介绍](https://github.com/alibaba/druid/wiki/Druid连接池介绍)。

Druid 是阿里巴巴出品的一款非常优秀的数据库连接池组件，拥有强大的监控功能，同时又保证了非常好的性能，并且其稳定性经过了阿里内部成千上万系统的验证，还经受过历年双十一的考验，足以说明 Druid 是一款兼具性能与稳定性的优秀数据库连接池组件了，因此我们可以放心的拿来使用。



# 3. 配置

因为我们用的是 Spring Boot，所以配置起来依然非常简单。



## 3.1 添加 pom 依赖：

添加 Druid 的 starter 的引用：

```xml
<dependency>
  <groupId>com.alibaba</groupId>
  <artifactId>druid-spring-boot-starter</artifactId>
  <version>1.1.21</version>
</dependency>
```



## 3.2 配置属性：

```yaml
#数据源配置
spring:
  datasource:
    # 这一项不需要显式指定
    type: com.alibaba.druid.pool.DruidDataSource
    druid:
      driver-class-name: com.mysql.jdbc.Driver
      url: jdbc:mysql://127.0.0.1:3306/springboot?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai
      username: root
      password: 123456
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
      validationQuery: SELECT 1
      testWhileIdle: true
      # 申请连接时执行validationQuery检测连接是否有效
      testOnBorrow: false
      # 归还连接时执行validationQuery检测连接是否有效
      testOnReturn: false
      # 打开PSCache，并且指定每个连接上PSCache的大小
      # poolPreparedStatements: true
      # maxPoolPreparedStatementPerConnectionSize: 20

......
```

> 更加详细的配置项说明，请查看：[DruidDataSource 配置属性列表](https://github.com/alibaba/druid/wiki/DruidDataSource配置属性列表)

OK，只需两步就配置好了，比把大象放冰箱还简单。接下来启动程序，控制台输出 `Init DruidDataSource` 的字样，说明 Druid 配置成功。



# 4. 监控



## 4.1 监控配置

前面我们提到 Druid 具有强大的监控功能，而这也是它的主打功能。处于安全考虑 Druid 默认是关闭监控功能的，我们可以通过在之前的配置基础上追加以下配置来开启监控：

```yaml
#数据源配置
spring:
  datasource:
    # 这一项不需要显式指定
    type: com.alibaba.druid.pool.DruidDataSource
    druid:
			......
			
	  # 开启监控，配置信息
      stat-view-servlet:
      	# 开启监控页面
      	enabled: true
      	# 监控系统用户名
        login-username: druid
        # 监控系统密码
        login-password: 123456
        # 是否允许清空监控数据
        reset-enable: false
        # 监控系统路径
        url-pattern: "/druid/*"		
        # 可访问监控系统的 IP 列表（白名单）
        # allow: 127.0.0.1
        # 禁止访问监控系统的 IP 列表（黑名单）
        # deny:
      # 配置扩展插件，常用的插件有：监控统计用的 stat，日志用的 slf4j，防御 sql 注入的 wall
      filters: stat,wall,slf4j
      # 用来打开 SQL 参数化合并监控和慢 SQL 记录
      connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
      # 合并多个 DruidDataSource 的监控数据
      useGlobalDataSourceStat: true
      # 开启 web 监控（Web应用、URI监控、Session监控）
      web-stat-filter:
      	# 开启 Web 监控
        enabled: true
        # 需要监控的路径
        url-pattern: /*
        # 不监控静态文件和监控系统自己的请求
        exclusions: "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*"
        # 统计请求调用链
        profile-enable: true
      # 开启 Spring 监控
      aop-patterns: com.imooc.springboot.databasecp.controller.*,com.imooc.springboot.databasecp.service.*,com.imooc.springboot.databasecp.mapper.*
      # 日志配置
      filter:
        slf4j:
          enabled: true
          statement-executable-sql-log-enable: true

# 日志输出级别
logging:
  level:
    # 输出 SQL
    druid.sql.Statement: debug
    # 输出查询结果
    druid.sql.ResultSet: debug
    
......
```

> 为了系统安全，开启监控后配置好白名单和黑名单。

配置好以后，重启应用就可以通过这个地址访问监控系统了：http://localhost:8080/springboot/druid/index.html



## 4.2 监控系统

进来以后需要输入我们配置的用户名和密码：

![图片描述](http://img1.sycdn.imooc.com/5ebcb39e00018d7407180510.png)

首页展示的是应用的详细软件信息：

![图片描述](http://img1.sycdn.imooc.com/5ebcb3920001056f22921022.png)

SQL 监控视图可以查看 SQL 的执行情况：

![图片描述](http://img1.sycdn.imooc.com/5ebcb38600011f5c28400340.png)

URL 视图可以看到你每次的请求：

![图片描述](http://img1.sycdn.imooc.com/5ebcb3780001d0da28600322.png)

Spring 视图可以展示你配置的切点执行情况：

![图片描述](http://img1.sycdn.imooc.com/5ebcb36d0001116928400472.png)

> 你也可以先去 Druid 提供的监控 Demo 上体验一下：[监控 Demo](http://120.26.192.168/druid/index.html)



## 4.3 打印可执行 SQL 与执行结果

还有一个非常实用的功能，就是输出可执行 SQL 与 SQL 的执行结果，Mybatis 打印的 SQL 语句都是带参数占位符的，例如：

```sql
select 
		id, name, age, birth_day, email
    from user
    where id = ?
```

这种形式的 SQL 我们在排查问题的时候用起来很不方便，简单 SQL 还好，但是参数如果很多，想拿过来用是根本不可能的，还不如自己手写来得快。如果打印出来的 SQL 把参数都设置好了那该多好，我们再偷点懒，如果能将执行结果一起打印出来那就完美了。Druid 就很贴心，为我们提供了这样的功能。具体配置参考 [监控配置](## 4-1 监控配置) 中关于日志的配置项。

我们来看看效果如何：

```
2019-11-10 12:31:58.996 DEBUG 92303 --- [nio-8080-exec-1] druid.sql.Statement                      : {conn-10005, pstmt-20000} executed. select id, name, age, birth_day, email
from user
where id = 1

......

2019-11-10 12:31:59.006 DEBUG 92303 --- [nio-8080-exec-1] druid.sql.ResultSet                      : {conn-10005, pstmt-20000, rs-50000} Header: [id, name, age, birth_day, email]
2019-11-10 12:31:59.012 DEBUG 92303 --- [nio-8080-exec-1] druid.sql.ResultSet                      : {conn-10005, pstmt-20000, rs-50000} Result: [1, user, 18, 2019-11-10, user@imooc.com]
```

可以看到，此时 id 被设置成了 1 ，最后一行还将我们查询到的数据也打印出来了，好用，赞一个！



## 4.4 买一送一

除了上面通过 application.yml 文件的配置方式，还可以通过 Java 的方式配置 Druid，本着买一赠一交朋友的原则，我也为你提供了 Java 配置版，具体代码就不贴出来占篇幅了，可以下载源码去 config 包下的 DruidConfig 中查看。

![图片描述](http://img1.sycdn.imooc.com/5ebcb35d00011fb502670113.png)



# 5. 总结

OK，今天我们了解了数据库连接池的基本原理和思想，还通过实践掌握了 Druid 的基本配置以及监控系统的使用。可以将这项技术引入到我们实际的应用中了。Druid 为我们提供了非常强大的监控功能，剩下的就需要我们不断提升自己对于数据的分析以及问题的排查能力了，一起加油吧！

Druid 作为一个数据库连接池，在保证性能的情况下还兼具强大的监控功能，能防 SQL 注入，内置 Loging 能诊断 Hack 应用行为等诸多特性。同时又经过了阿里巴巴以及众多企业在生产环境中的长时间检验。真的是非常非常的优秀了。不知道在全方位的了解了 Druid 以后，你心里是如何评价它的呢？欢迎留言一起交流哦！

[19 架构师的情人，提升性能的瑞士军刀-Redis (三)](http://www.imooc.com/read/75/article/1815)[21 软件系统的“黑匣子”——日志（一）](http://www.imooc.com/read/75/article/1817)

精选留言 0

欢迎在这里发表留言，作者筛选后可公开显示



目前暂无任何讨论

 

千学不如一看，千看不如一练