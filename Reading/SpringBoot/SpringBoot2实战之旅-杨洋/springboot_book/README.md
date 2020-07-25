
#### 项目介绍

SpringBoot实战之旅---书籍配套源码

#### 书籍介绍

本书内容共分为14章，开发工具使用IntelliJ IDEA，Spring Boot版本为2.0.3，各章节内容说明如下：
* 第1章介绍Spring Boot框架的特点以及学习它的重要性，最后列出Spring Boot的历史版本，让读者对Spring Boot有一个大致的了解。
* 第2章介绍如何搭建Spring Boot的开发环境，通过使用IntelliJ IDEA构建Spring Boot项目，并且对Spring Boot项目的基础结构进行介绍。
* 第3章介绍如何使用Spring Boot开发Web应用，了解Spring MVC和Spring Web Flux的不同，最后学习Spring Boot的一些Web模板框架，让读者可以对Spring Boot开发Web应用游刃有余。
* 第4章和第5章都是基于Spring Boot对数据库的使用进行学习。其中，第4章从Spring Boot使用各种数据库的依赖和配置开始介绍，然后介绍当今Java语言流行的ORM框架的使用，最后学习Spring Boot使用Druid数据库连接池。第5章介绍Spring Boot常用缓存框架，最后对Redis和Memcached进行比较，让读者选择缓存时有一定的基础。
* 第6章介绍Spring Boot对几种常用日志框架的使用，最后介绍分布式情况下如何使用ELK进行日志收集。
* 第7章介绍当今比较常用的两种安全框架，并且使用详细的案例对二者进行运用。
* 第8章介绍Spring Boot如何进行监控，涉及当今Spring Boot框架常用的监控，使读者对Spring Boot的运行状态更加了解。
* 第9章介绍Spring Boot如何使用消息队列，分别从RabbitMQ、Kafka和RocketMQ的使用实例进行介绍，最后对三者进行比较，让读者在选择消息队列时有一定的借鉴。
* 第10章对Spring Boot的两大常用搜索框架进行详细的介绍，从普通增、删、改、查到复杂查询，让读者使用搜索框架时不再茫然。
* 第11章介绍使用Spring Boot时的一些小技巧，比如启动Banner、Lombok、邮件发送、事务、异常等。虽然知识略微零散，但是都是实用的技巧。
* 第12章介绍Spring Boot的多种部署方式，让读者可以根据实际情况部署自己的应用程序。
* 第13章和第14章分别使用博客系统和博客后台系统对Spring Boot的使用进行综合实战，这两个实战案例是对本书内容的总结。

封面图：

![](https://images.gitee.com/uploads/images/2019/0809/134254_94b02730_1332114.png)

以下是一些实物图：

![](https://images.gitee.com/uploads/images/2019/0809/134254_9926e4d4_1332114.jpeg)

![](https://images.gitee.com/uploads/images/2019/0809/134254_d59dda77_1332114.jpeg)

![](https://images.gitee.com/uploads/images/2019/0809/134254_e875aebd_1332114.jpeg)

![](https://images.gitee.com/uploads/images/2019/0809/134254_cdcbeb88_1332114.jpeg)

![](https://images.gitee.com/uploads/images/2019/0809/134254_07f34f79_1332114.jpeg)

>其中，实物图1-4使用的当当网图片，5为家中所拍。

#### 书籍目录

第1章  Spring Boot概述   
1.1  SpringBoot简介   
1.2  SpringBoot特点   
1.2.1  快速构建项目   
1.2.2  嵌入式Web容器   
1.2.3  易于构建任何应用   
1.2.4  自动化配置    
1.2.5  开发者工具   
1.2.6  强大的应用监控   
1.2.7  默认提供测试框架   
1.2.8  可执行Jar部署   
1.2.9  IDE多样性   
1.3  为什么要学习Spring Boot   
1.3.1  简化工作   
1.3.2  微服务时代   
1.3.3  社区背景强大   
1.3.4  市场需求    
1.4  Spring Boot发展历史   
1.4.1  发布里程碑（2013.8.6）   
1.4.2  SpringBoot 1.0（2014.4）   
1.4.3  SpringBoot 1.1（2014.6）   
1.4.4  SpringBoot 1.2（2015.3）    
1.4.5  Spring Boot 1.3（2016.12）   
1.4.6  Spring Boot 1.4（2017.1）    
1.4.7  Spring Boot 1.5（2017.2）   
1.4.8  Spring Boot 2.0（2018.3）   
1.5  小结   
第2章  走进Spring Boot   
2.1  环境搭建   
2.1.1  JDK安装   
2.1.2  IntelliJ IDEA安装   
2.1.3  Maven安装   
2.1.4  IntelliJ IDEA内配置JDK和Maven   
2.2  新建SpringBoot项目   
2.2.1  开始创建项目   
2.2.2  配置JDK版本和Initializr Service URL   
2.2.3  配置Project Metadata信息   
2.2.4  配置SpringBoot版本、默认引入组件   
2.2.5  配置项目名称和项目位置   
2.3  项目工程介绍   
2.3.1  Java类文件    
2.3.2  资源文件     
2.3.3  测试类文件   
2.3.4  pom文件   
2.4  运行项目   
2.5  小结   
第3章  Spring Boot的Web之旅    
3.1  Spring Boot的第一个Web项目   
3.1.1  加入Web依赖   
3.1.2  创建Controller   
3.1.3  测试运行   
3.2  WebFlux使用   
3.2.1  添加WebFlux依赖      
3.2.2  创建一个处理方法类      
3.2.3  创建一个Router类      
3.2.4  测试运行      
3.3  使用热部署      
3.4  配置文件学习      
3.4.1  配置文件类型      
3.4.2  自定义属性      
3.4.3  使用随机数      
3.4.4  多环境配置      
3.4.5  自定义配置文件      
3.5.1  使用Thymeleaf      
3.5.2  使用FreeMarker      
3.5.3  使用传统JSP      
3.6  使用WebJars      
3.7  国际化使用      
3.8  文件上传下载      
3.9  小结      
第4章  Spring Boot的数据库之旅      
4.1  使用数据库      
4.1.1  使用MySQL数据库      
4.1.2  使用SQL Server数据库      
4.1.3  使用Oracle数据库      
4.1.4  使用MongoDB数据库      
4.1.5  使用Neo4j数据库      
4.1.6  使用Redis数据库      
4.1.7  使用Memcached数据库      
4.2  使用JDBC操作数据库      
4.2.1  JDBC依赖配置      
4.2.2  配置数据库信息      
4.2.3  创建实体类      
4.2.4  使用Controller进行测试      
4.3  使用JPA操作数据库      
4.3.1  JPA介绍      
4.3.2  JPA依赖配置      
4.3.3  配置文件      
4.3.4  创建实体对象      
4.3.5  创建数据操作层      
4.3.6  简单测试运行      
4.3.7  JPA扩展学习      
4.3.8  基于WebFlux使用      
4.4  使用MyBatis操作数据库      
4.4.1  MyBatis简介      
4.4.2  MyBaties依赖配置      
4.4.3  配置文件      
4.4.4  基于XML使用      
4.4.5  基于注解使用      
4.4.6  测试运行      
4.4.7  Mybatis-Generator插件学习      
4.4.8  PageHelper插件学习      
4.4.9  Mybatis-Plus插件学习      
4.5  配置多数据源      
4.5.1  多数据源情况分析      
4.5.2  配置多数据源      
4.5.3  基于JPA使用多数据      
4.5.4  基于MyBatis使用多数据      
4.6  使用Druid数据库连接池      
4.6.1  Druid简介      
4.6.2  配置Druid      
4.6.3  操作数据库      
4.6.4  Druid监控页面介绍      
4.7  小结      
第5章  Spring Boot的缓存之旅      
5.1  使用SpringCache      
5.1.1  SpringCache简介      
5.1.2  配置SpringCache依赖      
5.1.3  测试运行      
5.1.4  验证缓存      
5.2  使用Redis      
5.2.1  Redis简介      
5.2.2  项目配置      
5.2.4  使用Redis缓存      
5.3  使用Memcached      
5.3.1  Memcached简介      
5.3.2  配置Memcached依赖      
5.3.3  使用Memcached缓存      
5.3.4  Redis与Memcached的区别      
5.4  小结      
第6章  Spring Boot的日志之旅      
6.1  Logback日志      
6.1.1  Logback简介      
6.1.2  日志格式      
6.1.3  控制台输出      
6.1.4  日志文件输出      
6.1.5  日志级别      
6.1.6  日志配置      
6.1.7  基于xml配置日志      
6.2  log4j日志      
6.2.1  log4j简介      
6.2.2  SpringBoot使用log4j      
6.2.3  控制台输出      
6.2.4  日志文件输出      
6.3  log4j2日志      
6.3.1  log4j2简介      
6.3.2  SpringBoot使用log4j2      
6.3.3  控制台输出      
6.3.4  日志文件输出      
6.3.5  异步日志      
6.4  ELK日志收集      
6.4.1  ELK日志收集流程介绍      
6.4.2  ELK安装      
6.4.3  ELK配置      
6.4.3  使用Kibana查看日志      
6.4.4  SpringBoot直接输出到Logstash      
6.4.5  ELK日志收集优化方案及建议      
6.5  小结      
第7章  Spring.Boot的安全之旅      
7.1  使用shiro安全管理      
7.1.1  什么是shiro      
7.1.2  使用shiro做权限控制      
7.2  使用SpringSecurity      
7.2.1  SpringSecurity简介      
7.2.2  使用SpringSecurity做权限控制      
7.3  小结      
第8章  Spring Boot的监控之旅      
8.1  使用Actuator监控      
8.1.1  Actuator是什么？      
8.1.2  如何使用Actuator      
8.1.3  Actuator监控介绍      
8.1.4  保护HTTP端点      
8.1.5  健康信息      
8.1.6  自定义应用程序信息      
8.1.7  自定义管理端点路径      
8.2  使用Admin监控      
8.2.1  什么是SpringBoot Admin？      
8.2.2  设置SpringBoot Admin Server      
8.2.3  SpringCloud Eureka      
8.2.4  Spring Boot Admin Client使用      
8.2.5  安全验证      
8.2.6  JMX-bean管理      
8.2.7  通知      
8.3  Prometheus+Grafana监控      
8.3.1  Prometheus安装      
8.3.2  Grafana安装      
8.3.3  Spring Boot项目使用Prometheus      
8.3.4  Prometheus配置      
8.3.5  启动Grafana      
8.4  小结      
第9章  Spring Boot的消息之旅      
9.1  RabbitMQ消息队列      
9.1.1  RabbitMQ介绍      
9.1.2  RabbitMQ的几种角色      
9.1.3  RabbitMQ的几种模式      
9.1.2  Spring Boot使用RabbitMQ      
9.2  Kafka消息队列      
9.2.1  Kafka介绍      
9.2.2  Spring Boot使用Kafka      
9.3  RocketMQ消息队列      
9.3.1  RocketMQ介绍      
9.3.2  Spring Boot使用RocketMQ      
9.4  消息队列对比篇      
9.5  小结      
第10章  Spring Boot的搜索之旅      
10.1  使用Solr      
10.1.1  Solr简介      
10.1.2  Spring Boot使用Solr      
10.2  使用ElasticSearch      
10.2.1  ElasticSearch简介      
10.2.2  Spring Boot使用ElasticSearch      
10.2.3  使用ElasticsearchRepository进行操作      
10.2.4  使用ElasticsearchTemplate进行操作      
10.2.5  非聚合查询      
10.2.6  聚合查询      
10.2.7  复杂查询练习      
10.3  搜索引擎对比篇      
10.3.1  技术背景      
10.3.2  热度比较      
10.3.3  集群部署      
10.3.4  数据格式      
10.3.5  效率      
10.4  小结      
第11章  Spring Boot的小彩蛋      
11.1  修改启动Banner      
11.1.1  启动Banner介绍      
11.1.2  启动Banner修改      
11.2  使用LomBok让编程更简单      
11.2.1  什么是LomBok？      
11.2.2  IntelliJ IDEA安装Lombok插件      
11.2.3  如何使用LomBok？      
11.3  邮件发送      
11.3.1  Spring Boot使用邮件发送      
11.3.2  基础配置信息      
11.3.3  文本邮件发送      
11.3.4  网页邮件发送      
11.3.5  附件邮件发送      
11.3.6  嵌入静态资源邮件发送      
11.4  三“器”使用      
11.4.1  过滤器      
11.4.2  拦截器      
11.4.3  监听器      
11.4.4  Spring Boot引用三“器”      
11.4.5  测试      
11.5  事务使用      
11.5.1  事务介绍      
11.5.2  项目中使用事务      
11.5.3  Spring事务拓展介绍      
11.6  统一处理异常      
11.6.1  异常介绍      
11.6.2  Java异常分类      
11.6.3  Spring Boot中统一处理异常      
11.7  使用AOP      
11.7.1  AOP介绍      
11.7.2  Spring Boot使用AOP      
11.8  使用validator后台校验      
11.9  使用Swagger构建接口文档      
11.9.1  什么是Swagger      
11.9.2  Swagger2注解介绍      
11.9.3  SpringBoot使用Swagger      
11.10  使用ApiDoc构建接口文档      
11.10.1  如何使用ApiDoc接口文档      
11.10.2  ApiDoc常用注解      
11.10.3  SpringBoot使用ApiDoc      
11.11  小结      
第12章  Spring Boot打包部署      
12.1  使用IDE启动      
12.1.1  运行Spring Boot应用程序      
12.1.2  IntelliJ IDEA启动多实例      
12.2  使用Maven启动      
12.3  Jar形式启动      
12.3.1  命令形式将Spring Boot应用程序打成Jar      
12.3.2  IntelliJ IDEA打Jar包      
12.4  War形式启动      
12.4.1  创建项目      
12.4.2  打War包部署到Tomcat      
12.5  使用Docker构建Spring Boot项目      
12.5.1  Docker简介      
12.5.2  安装Docker      
12.5.3  Dockerfile      
12.5.5  运行Docker镜像      
12.6  使用Jenkins自动化部署Spring Boot应用      
12.6.1  Jenkins简介      
12.6.2  SpringBoot应用使用Jenkins      
12.7  小结      
第13章  Spring Boot实战之博客系统      
13.1  博客的制作思路      
13.1.1  博客布局介绍      
13.1.2  博客功能介绍      
13.2  博客模板制作      
13.3  效果展示      
13.4  依赖配置      
13.5  配置文件      
13.6  后台实体      
13.6.1  文章表      
13.6.2  标签表      
13.6.3  链接表      
13.6.4  消息表      
13.6.5  博客访问记录表      
13.6.6  博客配置表      
13.7  主功能      
13.7.1  博客页      
13.7.2  搜索页      
13.7.3  文章详情页      
13.7.4  联系页      
13.8  辅助功能      
13.8.1  拦截器      
13.8.2  定时器      
13.8.3  初始化      
13.9  小结      
第14章  Spring Boot实战之博客后台系统      
14.1  博客后台的制作思路      
14.1.1  博客后台布局介绍      
14.1.2  博客功能介绍      
14.2  博客后台模板制作      
14.3  效果展示      
14.4  依赖配置      
14.5  配置文件      
14.6  后台实体      
14.6.1  用户表      
14.6.2  角色表      
14.7  主功能      
14.7.1  首页      
14.7.2  文章管理      
14.8  辅助功能      
14.8.1  拦截器      
14.8.2  定时器   
14.8.3  认证和授权      
14.8.4  工具类   
14.8.5  初始化方法   
14.9  小结   


#### 项目目录

chapter是章节，chapter3-5-1表示书籍目录3.5.1  使用Thymeleaf对应示例代码，
（其中blogmodel项目为第十三章基础代码，blogmgrmodel项目为第十四章基础代码）：


```
├── blogmgrmodel
├── blogmodel
├── chapter10-1
├── chapter10-2
├── chapter11-1
├── chapter11-10
├── chapter11-2
├── chapter11-3
├── chapter11-4
├── chapter11-5
├── chapter11-6
├── chapter11-7
├── chapter11-8
├── chapter11-9
├── chapter12-4
├── chapter13
├── chapter14
├── chapter3-1
├── chapter3-2
├── chapter3-3
├── chapter3-4
├── chapter3-5-1
├── chapter3-5-2
├── chapter3-5-3
├── chapter3-6
├── chapter3-7
├── chapter3-8
├── chapter4-2
├── chapter4-3-8
├── chapter4-3
├── chapter4-4-7
├── chapter4-4-8
├── chapter4-4-9
├── chapter4-4
├── chapter4-5-1
├── chapter4-5-2
├── chapter4-6
├── chapter5-1
├── chapter5-2
├── chapter5-3
├── chapter6-1
├── chapter6-2
├── chapter6-3
├── chapter6-4
├── chapter7-1
├── chapter7-2
├── chapter8-1
├── chapter8-2
├── chapter8-3
├── chapter8-4
├── chapter8-5
├── chapter8-6
├── chapter9-1
├── chapter9-2
├── chapter9-3
```

#### 专家推荐

 **大老杨这本书，是我花了3天时间审校的。全书没有废话，一切从代码案例出发，记录了各种坑的解决方法，是Sprimg Boot初学者及核心技术巩固的最佳实践。
——泥瓦匠** 

 **知易行难，最难的是深入浅出把自己的经验分享给大家，因为你不但要客观的讲述技术本身，还要公正的加入自己的理解，需要编者较高的眼界和大局观。在我认识的人中，有丰富的项目经验又愿意花时间在教学实践上，最终能把各种知识理论体系化的人聊聊无几，杨洋老师恰好这几点都具备。快速翻完整本书，句里行间没有华丽的辞藻，字字出自于实践，让我受益匪浅。
——知乎读者 谢悦** 

 **一次偶然的机会认识了大老杨，他一直致力于把自己的实践经验分享给更多热爱技术的人，Spring Boot虽然简化了配置，但是可能造成错误的无法捕捉，一个小坑可能让你寸步难行，这本书包含了开发中经常遇到的细节问题，无疑是开发者手里的Spring Boot良师益友。相信你通过大老杨这本书的学习，会让自己的架构路上一路小平坡。   
——李明（诸葛阿明），公众号：编程坑太多** 

 **如今微服务如日中天，Spring Boot作为构建Spring Cloud全家桶的基础框架，Java 开发者必须要做到对Spring Boot运用自如。本书非常全面地对Spring Boot进行了深度剖析，从背景介绍到详细使用再到项目实战，环环相扣,是一本不可多得的好书。
——尹吉欢，《Spring Cloud 微服务：全栈技术与案例解析》一书作者，公众号“猿天地”运营者。** 

 **本书全面介绍了使用 Spring Boot 2.x 技术，并且带来了从零到1的实战之旅。本书可以帮助读者快速入门并掌握Spring Boot这门技术，阅读本书，对读者必有裨益。
——梁桂钊(公众号「服务端思维」、《高可用可伸缩微服务架构: 基于 Dubbo、Spring Cloud和Service Mesh》联合作者)** 


#### 书籍购买地址

现在各大电商网站都已经上架了本书，而且都是现货发售，至于去哪个途径购买，读者可以自行选择，如以下自营渠道：

* [京东购买地址](https://item.jd.com/12663734.html?dist=jd)
* [当当购买地址](http://product.dangdang.com/27909273.html)
* [天猫购买地址](https://detail.tmall.com/item.htm?spm=a1z10.3-b-s.w4011-18452336119.72.6d3d2226I0ietb&id=598917648188&rn=306813c7a66bac5440b3eaad198c1853&abbucket=2)



