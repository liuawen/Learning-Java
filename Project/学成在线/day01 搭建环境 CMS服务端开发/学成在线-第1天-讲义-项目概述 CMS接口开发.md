# 学成在线 第1天 讲义-项目概述 CMS接口开发

# 项目的功能架构

## 项目背景

受互联网+概念的催化，当今中国在线教育市场的发展可谓是百花齐放、如火如荼。 按照市场领域细分为：学前教
育、K12教育、高等教育、留学教育、职业教育、语言教育、兴趣教育以及综合平台，其中，职业教育和语言教育
的市场优势突出。 根据Analysys易观发布的数据显示，预计2019年中国互联网教育市场交易规模将达到3718亿元
人民币，未来三年互联网教育市场规模保持高速增长。

K12教育 中小学教育

学成在线借鉴了MOOC（大型开放式网络课程，即MOOC（massive open online courses））的设计思想，是一
个提供IT职业课程在线学习的平台，它为即将和已经加入IT领域的技术人才提供在线学习服务，用户通过在线学
习、在线练习、在线考试等学习内容，最终掌握所学的IT技能，并能在工作中熟练应用。

已经加入IT领域的技术人才 

即将加入

博学谷 

![image-20200803163938056](assets/image-20200803163938056.png)

功能模块

项目原型

项目的技术架构

技术架构

技术栈

前后端分离 服务器端渲染解决方案

## 功能模块

当前市场的在线教育模式多种多样，包括：B2C、C2C、B2B2C等业务模式，学成在线采用B2B2C业务模式，即向
企业或个人提供在线教育平台提供教学服务，老师和学生通过平台完成整个教学和学习的过程，市场上类似的平台
有：网易云课堂、腾讯课堂等，学成在线的特点是IT职业课程在线教学。

![image-20200803163955626](assets/image-20200803163955626.png)

企业或个人提供在线教育平台提供服务

老师和学生通过平台完成整个教学和学习的过程

网易云课堂 腾讯课堂 

IT职业课程在线教学

企业对个人

个人对个人

我是一个老师 



企业 个人 提供在线教育

B2B2C

平台 企业入驻

用户网上学习 

平台模式

学成在线包括门户、学习中心、教学管理中、社交系统、系统管理等功能模块。

门户 

首页 注册/登录 课程搜索 客户服务 职业规划 

专门学习的  

学习中心  

视频点播 我的课程

个人设置  我的订单

学习统计 我的笔记

教学管理中心

媒体 资源  视频 编码 在线播放 

课程管理  媒资管理

订单管理 考试管理

作业管理 统计分析 





社交系统

论坛 问答系统  信息系统 评论系统 ...

教学服务

论坛 问答系统  评论系统

设计系统 最重要的 

评论  质量 



系统管理中心

CMS  分类管理  数据字典  系统参数配置   ...

系统管理员来使用的 

设计 一些 基本的数据字典 

门户  学习中心 教学管理中心 社交系统 系统管理中心 



功能
模块
名称

功能说明

门户在首页、活动页、专题页等页面提供课程学习入口。
学习
中心
学生登录学习中心在线学习课程。
社交
系统
社交系统为老师和学生交流搭建沟通的平台，包括：问答系统、评论系统、论坛等，学生和老师
通过问答系统提问问题、回答问题，通过评论系统对老师授课进行评论。
教学
管理
中心
教师登录教学管理中心进行课程管理、资源管理、考试管理等教学活动。
系统
管理
中心
系统管理员登录系统管理中心进行分类管理、运维管理等功能。



功能说明

门户 在首页、活动页、专题页等页面提供课程学习入口

学习中心 学生登录学习中心在线学习课程

社交系统 社交系统为老师和学生交流搭建沟通的平台

问答系统 论坛系统 论坛等

学生和老师 通过问答系统 提问问题 回答问题

通过评论系统对老师授课进行评论

教学管理中心 教师登录教学管理中心 进程课程管理

资源管理 考试管理等教学活动

系统管理员登录管理中心进行分类管理、运维管理等功能。



![image-20200803202847941](assets/image-20200803202847941.png)



## 项目原型

项目原型 进一步了解项目的功能

客户首页

通过项目原型进一步了解项目的功能，包括：门户首页、课程搜索页、在线学习页面、个人中心等参考“项目原型”。



重点了解微服务技术栈：
学成在线服务端基于Spring Boot构建，采用Spring Cloud微服务框架。
持久层：MySQL、MongoDB、Redis、ElasticSearch
数据访问层：使用Spring Data JPA 、Mybatis、Spring Data Mongodb等
业务层：Spring IOC、Aop事务控制、Spring Task任务调度、Feign、Ribbon、Spring AMQP、Spring Data Redis
等。
控制层：Spring MVC、FastJSON、RestTemplate、Spring Security Oauth2+JWT等
微服务治理：Eureka、Zuul、Hystrix、Spring Cloud Config等

# 项目的技术架构

## 技术架构



 

前后端分离架构开发  用户层 UI层 微服务层 数据层  

PC APP  H5 客户端用户提供服务  

技术架构图

技术架构

学成在线采用当前流行的前后端分离架构开发，由用户层、UI层、微服务层、数据层等部分组成，为PC、App、
H5等客户端用户提供服务。下图是系统的技术架构图：

分层的

![image-20200803164049596](assets/image-20200803164049596.png)

用户 PC  APP   H5 微信公众号 

CDN 内容分发网络  媒资管理

外部系统接口

微信QQ微博　登录、分享

支付宝　微信　网银　支付　

短信　邮件　微信公众号　点播　　直播　OSS存储　CDN

　

UI层  前端

![image-20200803203326134](assets/image-20200803203326134.png)

前端系统  独立的  HTTP协议

UI层

微服务层

前后端分离   有什么好处？



针对XX 写一个小系统   具体的小系统 可以独立部署

好处  前端这一块  不同的用户 使用不同的    界面样式  不同的用户提供不同的用户界面

微服务层 统一一套 供应前端   统一对外 提供服务 

系统的业务扩展  

划分了很多小块  服务的颗粒性？？？  可扩展性

每一块都是独立部署    扩冲 

可维护性

微服务层

数据层 

业务流程举例：
1、用户可以通过pc、手机等客户端访问系统进行在线学习。
2、 系统应用CDN技术，对一些图片、CSS、视频等资源从CDN调度访问。
3、4、对于PC、H5等客户端请求，首先请求UI层，渲染用户界面。
5、客户端UI请求服务层获取进行具体的业务操作。
6、服务层将数据持久化到数据库。

各模块说明如下：

名称 功能描述

用户层  描述了本系统所支持的用户类型 包括 PC用户APP用户 H5用户

PC用户通过浏览器访问系统 

APP用户

H5用户

原来是因为微信集成了移动端阅读器，脱离微信，H5照样可以正常运行，仅仅因为人们习惯了经过朋友圈翻开H5来观看网页。所以，H5并不是微信网页，它是一个更大的概念， 仅仅因为微信巨大的用户群，让H5集中于微信，让人们觉得这个页面就是微信独有的，也让H5和微信朋友圈成为了代名词。

一切的惯例猜测和网上论题引导咱们都证明了，成果全部不建立! 当咱们从新把一切内容放在一同时，你会发现H5它包换了HTML5 的符号标准，运用到了例如 CSS、JS(Java)等多种计算机语言，可以完成多种动效和视听作用，会使用到后端和前端的多种功用，首要在手机端传播，可以跨渠道在PC、平板上阅读等等...

当咱们在这些一切包括的特性上寻觅共性时，咱们得到了一个意外的答案，H5不是 HTML5、不是微信网页、不是移动 PPT。相反，从某种含义上来说，它是这些东西的母级，H5所指的就是移动网页自身，它可以包括一切这些分支!



一切的惯例猜测和网上论题引导咱们都证明了，成果全部不建立! 当咱们从新把一切内容放在一同时，你会发现H5它包换了HTML5 的符号标准，运用到了例如 CSS、JS(Java)等多种计算机语言，可以完成多种动效和视听作用，会使用到后端和前端的多种功用，首要在手机端传播，可以跨渠道在PC、平板上阅读等等...

当咱们在这些一切包括的特性上寻觅共性时，咱们得到了一个意外的答案，H5不是 HTML5、不是微信网页、不是移动 PPT。相反，从某种含义上来说，它是这些东西的母级，H5所指的就是移动网页自身，它可以包括一切这些分支!



H5又是什么鬼？HyperText Mark-up Language 5.0  → HTML5 → H5当然，HTML5是英文规范简称，但H5就完全是国内特定人群的叫法。目前的事实是，H5已经成为微信HTML5网页的专有名词。以现在的定义，H5特指基于HTML5技术的交互网页应用，以商业用途为主。以下列举一些H5商业应用场景，供参考：1、微信H5目前HTML5应用最多的形式，因为移动端完全不支持Flash，而HTML5在动画展现和交互上基本可以满足企业需求，同时也因为微信的大力支持，HTML5网页作为一种营销的形式被广泛应用，营销圈简称H5。

2、交互视频

HTML5对于多媒体的支持，让丰富的视频应用成为可能。iH5的交互视频技术可以将视频、动画、多屏通信等有机结合，极大地丰富了内容的表达方式。

3、户外大屏交互解决方案

传统的户外大屏交互需要复杂的软件实施，不仅成本极高，并且灵活度低。基于HTML5技术，不需软件实施，内容更新方便快捷。iH5的智墙技术提供了户外大屏交互的解决方案，支持多屏拼接和多点触摸。

4、PC HTML5广告

即苹果浏览器不支持Flash之后，谷歌浏览器已在2015年9月不再支持Flash自动播放，在可预见的未来，HTML5将取代Flash作为网页动画广告的首选。

H5是一种用在微信上的PPT。

全世界缺货

对啊，就是幻灯片效果。然后各种浮夸的文字图片、音乐一起上了，不知道为啥能火成这样。难道是因为小而美？？？



不管这句话对不对，先赞一个解解气。每当有人用“你会h5吗？”来向我技术发难的时候，我都想反问一句：“你理解的h5是什么？？？？？？？”

怒赞！！！一听问这个我就想呵呵 我的日常工作极少极少用得上这个 我不明白为什么我必须要会这个东西



手机浏览器吗?



重点掌握 

微服务层  数据层

1 用户层
用户层描述了本系统所支持的用户类型包括：pc用户、app用户、h5用户。pc用户通过
浏览器访问系统、app用户通过android、ios手机访问系统，H5用户通过h5页面访问系
统。
2 CDN
CDN全称Content Delivery Network，即内容分发网络，本系统所有静态资源全部通过
CDN加速来提高访问速度。系统静态资源包括：html页面、js文件、css文件、image图
片、pdf和ppt及doc教学文档、video视频等。

CDN 内容分发网络 

静态资源 通过CDN加速来提高访问速度 系统静态资源 包括 html页面 js文件 css文件

image图片 pdf和ppt及 doc教学文档 video视频

3
负载均
衡
系统的CDN层、UI层、服务层及数据层均设置了负载均衡服务，上图仅在UI层前边标注
了负载均衡。 每一层的负载均衡会根据系统的需求来确定负载均衡器的类型，系统支持
4层负载均衡+7层负载均衡结合的方式，4层负载均衡是指在网络传输层进行流程转发，
根据IP和端口进行转发，7层负载均衡完成HTTP协议负载均衡及反向代理的功能，根据
url进行请求转发。

4层负载均衡 网络传输层进行流程转发  IP和端口进行转发

7层负载均衡  完成HTTP协议负载均衡及后向代理的功能 根据url进行请求转发 

4 UI层
UI层描述了系统向pc用户、app用户、h5用户提供的产品界面。根据系统功能模块特点
确定了UI层包括如下产品界面类型： 1）面向pc用户的门户系统、学习中心系统、教学
管理系统、系统管理中心。 2）面向h5用户的门户系统、学习中心系统。 3）面向app
用户的门户系统、学习中心系统未在上图标注，在app项目中有详细说明。
5
微服务
层
微服务层将系统服务分类三类：前端服务、后端服务及系统服务。 前端服务：主要为学
习用户提供学习服务。 后端服务：主要为管理用户提供教学管理服务。 系统服务：公
共服务，为系统的所有微服务提供公共服务功能。 服务网关：提供服务路由、负载均
衡、认证授权等服务。

前端 后端 系统  服务 

主要为学习用户提供学习服务  后端服务 主要为管理用户提供教学管理服务

系统服务  公共服务 

为系统的所有微服务 提供公共服务功能

服务网关  服务路由 负载均衡 认证授权 

6 数据层
数据层描述了系统的数据存储的内容类型，持久化的业务数据使用MySQL和MongoDB
保存，其中MongoDB中主要保存系统日志信息。 消息队列：存储系统服务间通信的消
息，本身提供消息存取服务，与微服务层的系统服务连接。 索引库：存储课程信息的索
引信息，本身提供索引维护及搜索的服务，与微服务层的系统服务连接。 缓存：作为系
统的缓存服务，存储课程信息、分类信息、用户信息等，与微服务层的所有服务连接。
文件存储：提供系统静态资源文件的分布式存储服务，文件存储服务器作为CDN服务器
的数据来源，CDN上的静态资源将最终在文件存储服务器上保存多份。 流媒体服务：
作为流媒体服务器，存储所有的流媒体文件。

数据层 描述了系统的数据存储的内容类型 

MongoDB  主要保存系统日志信息  

消息队列 存储系统服务间通信的消息 消息存取服务 

缓存 系统的缓存服务  存储课消息 分类信息 用户信息 

文件存储服务器 CDN服务器

流媒体服务器 存储所有的流媒体文件  

7
外部系
统接口
1）微信、QQ、微博登录接口，本系统和微信、QQ、微博系统对接，用户输入微信、
QQ、微博的账号和密码即可登录本系统。 2）微信、QQ、微博分享接口，本系统和微
信、QQ、微博系统对接，可直接将本系统的课程资源信息分享到微信、QQ、微博。
3）支付宝、微信、网银支付接口，本系统提供支付宝、微信、网银三种支付接口。
4）短信接口，本系统与第三方平台对接短信发送接口。 5）邮件接口，本系统需要连
接第三方的smpt邮件服务器对外发送电子邮件。 6）微信公众号，本系统与微信公众号
平台接口，用户通过微信公众号访问H5页面。 7）点播、直播，前期视频点播与直播采
用第三方服务方式，本系统与第三方点、直播服务对接，对外提供视频点播与直播服
务。 8）OSS存储 ，前期静态资源文件的存储采用第三方服务方式，本系统与第三方提
供的OSS存储服务对接，将系统的静态资源文件存储到第三方提供的OSS存储服务器
上。 9）CDN，本系统与第三方CDN服务对接，使用CDN加速服务来提高本系统的访问
速度。

序
号
名称功能描述
8 DevOps
DevOps（英文Development和Operations的组合）是一组过程、方法与系统的统称，
用于促进开发（应用程序/软件工程）、技术运营和质量保障（QA）部门之间的沟通、
协作与整合。本项目供了许多开发、运营、维护支撑的系统，包括： Eureka服务治理
中心：提供服务治理服务，包括：服务注册、服务获取等。 Spring Cloud Config服务
配置管理中心：提供服务配置管理服务，包括：配置文件更新、配置文件下发等。
Hystrix Dashboard服务熔断监控：监控熔断的请求响应时间、成功率等 。 Zipkin服务
追踪监控：监控服务调用链路健康情况。 Jenkins持续集成服务：提供系统持续集成服
务。 Git/GitLab代码管理服务:提供git代码管理服务。 ELK日志分析服务:提供elk日志分
析服务，包括系统运行日志分析、告警服务。 Docker容器化部署服务：将本系统所有
服务采用容器化部署方式。 Maven项目管理工具：提供管理项目所有的Java包依赖、项
目工程打包服务。

DevOps

过程 方法 系统 

促进开发 技术运营  质量保障 QA 沟通 协作 整合 

Eureka服务治理中心：提供服务治理服务，包括：服务注册、服务获取等。

Spring Cloud Config服务配置管理中心：提供服务配置管理服务，包括：配置文件更新、配置文件下发等。
Hystrix Dashboard服务熔断监控：监控熔断的请求响应时间、成功率等 。

 Zipkin服务追踪监控：监控服务调用链路健康情况。 

Jenkins持续集成服务：提供系统持续集成服务。 

Git/GitLab代码管理服务:提供git代码管理服务。 

ELK日志分析服务:提供elk日志分析服务，包括系统运行日志分析、告警服务。 

Docker容器化部署服务：将本系统所有服务采用容器化部署方式。

Maven项目管理工具：提供管理项目所有的Java包依赖、项目工程打包服务。

## 技术栈

![image-20200803175035503](assets/image-20200803175035503.png)

重点了解微服务技术栈：
学成在线服务端基于Spring Boot构建，采用Spring Cloud微服务框架。
持久层：MySQL、MongoDB、Redis、ElasticSearch
数据访问层：使用Spring Data JPA 、Mybatis、Spring Data Mongodb等
业务层：Spring IOC、Aop事务控制、Spring Task任务调度、Feign、Ribbon、Spring AMQP、Spring Data Redis
等。
控制层：Spring MVC、FastJSON、RestTemplate、Spring Security Oauth2+JWT等
微服务治理：Eureka、Zuul、Hystrix、Spring Cloud Config等

微服务技术栈

学成在线服务端基于Spring Boot构建 采用SpringCloud微服务框架

持久层  MySQL MongoDB Redis  ElasticSearch



fastDFS

流媒体 

技术栈 

重点  微服务这  基于SpringBoot这部开的  

Spring全家桶

非常方便开发



## 开发步骤

项目是基于前后端分离的架构进行开发，前后端分离架构总体上包括前端和服务端，通常是多人协作并行开发，开
发步骤如下：
1、需求分析
梳理用户的需求，分析业务流程
2、接口定义
根据需求分析定义接口
3、服务端和前端并行开发
依据接口进行服务端接口开发。
前端开发用户操作界面，并请求服务端接口完成业务处理。
4、前后端集成测试
最终前端调用服务端接口完成业务。

1、需求分析 2、接口定义  3、服务端和前端并行开发 4、前后端集成测试

单元测试  服务端  开发一个微服务  基于这个接口 

集成测试

定义接口

项目是基于前后端分离的架构进行开发 

前端 服务端

多人协作并行开发 



接口开发

集成测试



# CMS需求分析

## 什么是CMS

1、CMS是什么 ？
CMS （Content Management System）即内容管理系统，不同的项目对CMS的定位不同，比如：一个在线教育网
站，有些公司认为CMS系统是对所有的课程资源进行管理，而在早期网站刚开始盛行时很多公司的业务是网站制
作，当时对CMS的定位是创建网站，即对网站的页面、图片等静态资源进行管理。

什么是CMS  内容管理系统 

不同的项目对CMS的定位不同 比如  一个在线教育网站  有些公司认为CMS系统 

2、CMS有哪些类型？
上边也谈到每个公司对每个项目的CMS定位不同，CMS基本上分为：针对后台数据内容的管理、针对前端页面的
管理、针对样式风格的管理等 。比如：一个给企业做网站的公司，其CMS系统主要是网站页面管理及样式风格的
管理。

CMS 内容管理系统 

不同的类型  

后台数据内容的管理 

CMS 内容管理系统 前端页面的管理   样式风格的管理

一个给企业做网站的公司 



网站页面管理 及 样式风格管理 



运营的需要

轮播图 换一下 改一下  轮播图 广告    更改图片

网站的页面管理   包括很多页面  很多很多 小的页面 管理起来

CMS 更改  自动发布  门户 

页面改动需求多  

3、本项目CMS的定位是什么？
本项目作为一个大型的在线教育平台，对CMS系统的定位是对各各网站（子站点）页面的管理，主要管理由于运营
需要而经常变动的页面，从而实现根据运营需要快速进行页面开发、上线的需求。

大型的在线教育平台   对各各网站 子站点  页面的管理   

运营需要而经常变动的页面  

实现根本运营需要快速进行页面开发 上线的需求 



![image-20200803205144723](assets/image-20200803205144723.png)

换一下  轮播图    直接换就不行了  

运营的需求 改图片   页面的风格  

CMS解决  

对各网站的页面来管理   HTML   很多小页面

页面来管理出来   页面修改 自动发布   不需要前端来改页面

各个网站 很多网站

门户  小站点   

![image-20200803205342692](assets/image-20200803205342692.png)

很多很多  站点组成  网站

变动的页面   及时变化



各个子网站   页面的需求 改变很多 

门户



页面管理 采用什么需求变化  

 

## 静态门户工程搭建

本项目CMS是对页面进行管理，对页面如何进行管理呢？我们首先搭建学成网的静态门户工程，根据门户的页面结
构来分析页面的管理方案。
门户，是一个网站的入口，一般网站都有一个对外的门户，学成在线门户效果图如下：

![image-20200803200906068](assets/image-20200803200906068.png)



导入门户工程



1、安装WebStorm
参考“WebStorm安装手册.md”安装WebStorm-2018.2.3.exe
2、安装Nginx
下载nginx：http://nginx.org/en/download.html
本教程下载nginx-1.14.0.zip(http://nginx.org/download/nginx-1.14.0.zip)
解压nginx-1.14.0.zip到自己的计算机，双击nginx.exe即可运行。
访问 ：http://localhost

安装Nginx

![image-20200803205849419](assets/image-20200803205849419.png)

Nginx启动  

![image-20200803200935714](assets/image-20200803200935714.png)

![image-20200803210934668](assets/image-20200803210934668.png)



3、导入门户工程
将课程资料中的门户工程拷贝到代码目录。
使用WebStorm打开门户工程目录，目录的结构如下，后期会根据开发的推进进行扩充。

![image-20200803200944463](assets/image-20200803200944463.png)

配置虚拟主机

在nginx中配置虚拟主机：

```nginx
server{
listen 80;
server_name www.xuecheng.com;
ssi on;
ssi_silent_errors on;
location / {
alias F:/teach/xcEdu/xcEduUI/xc‐ui‐pc‐static‐portal/;
index index.html;
}
}
```

F:/teach/xcEdu/xcEduUI/xc-ui-pc-static-portal/ 本目录即为门户的主目录。

```nginx
   server {
        listen       80;
        #server_name  localhost;
		#server_name www.liuawen.cn;
        #charset koi8-r;
		server_name www.xuecheng.com;	
        #access_log  logs/host.access.log  main;
		ssi on;
		ssi_silent_errors on;

        location / {
            #root   html;
			alias D:/Projects/xcEdu/xcEduUI01/xc-ui-pc-static-portal/;
            index  index.html index.htm;
        }
}
```

一直404出不来也页面  原来是 nginx.exe  太多了 没有删除

![image-20200803215414167](assets/image-20200803215414167.png)

nginx home 



![image-20200803215441070](assets/image-20200803215441070.png)

![image-20200803215509114](assets/image-20200803215509114.png)

http://127.0.0.1/

![image-20200803215642115](assets/image-20200803215642115.png)



![image-20200803215801515](assets/image-20200803215801515.png)

nginx: [error] OpenEvent("Global\ngx_reload_26132") failed (2: The system cannot find the file specified)

![image-20200803211931268](assets/image-20200803211931268.png)





![image-20200803211752849](assets/image-20200803211752849.png)

先这里  本地  再去解析的  

127.0.0.1 www.xuecheng.com

```
127.0.0.1 localhost
127.0.0.1 www.xuecheng.com
```



C:\Windows\System32\drivers\etc

ect hosts

![image-20200803210945671](assets/image-20200803210945671.png)

域名来访问 我想

D:\Projects\xcEdu\xcEduUI01\xc-ui-pc-static-portal

反斜杠 

```xml
 server {
        listen       80;
        #server_name  localhost;
	#server_name www.liuawen.cn;
        #charset koi8-r;

        #access_log  logs/host.access.log  main;

        location / {
            root   html;
	    alias D:/Projects/xcEdu/xcEduUI01/xc-ui-pc-static-portal;
            index  index.html index.htm;
        }
}
```



5、配置hosts文件
本教程的开发环境使用Windows 7，修改C:\Windows\System32\drivers\etc\hosts文件

```
127.0.0.1 www.xuecheng.com
```

进入浏览器，输入http://www.xuecheng.com

门户跑起来

![image-20200803220728802](assets/image-20200803220728802.png)

## SSI服务端包含技术

IIS  Tomcat

![image-20200804122826518](assets/image-20200804122826518.png)

页面  大页面 

小页面  我要更改页面的一小部分

本节分析首页的管理方案。

首页的管理方案 

1、页面内容多如何管理？
将页面拆分成一个一个的小页面，通过cms去管理这些小页面，当要更改部分页面内容时只需要更改具体某个小页
面即可。

拆分一个一个的小页面  cms去管理这些小页面  更改部分页面内容时只需要更改具体某个小页面即可 

小页面  大页面怎么浏览

拼



页面所属于网站

2、页面拆出来怎么样通过web服务浏览呢？
使用web服务(例如nginx)的SSI技术，将多个子页面合并渲染输出。

页面拆出来   web服务浏览

Nginx SSI技术  多个子页面合并渲染输出 



3、SSI是什么？![image-20200803201129281](assets/image-20200803201129281.png)

SSI Server SIde Include是一种类似于服务器的网页制作技术

在服务器端  拼接  

SSI

WEB服务器 

讲内容发送到浏览器之前  可以使用服务器端 包含SSI 指令 文本  图形  应用 网页中

重复出现的文本 图形

使用包含文件是一种简便的方法  将内容存入一个包含文件中即可

服务端  拼装  大页面 

不必将内容输入所有文件

简单的语句 调用包含文件

使用了包含文件  只需在一个地方就能完成 

ssi包含类似于jsp页面中的incluce指令，ssi是在web服务端将include指定 的页面包含在网页中，渲染html网页响
应给客户端 。nginx、apache等多数web容器都支持SSI指令。
ssi指令如下：

```
<!‐‐#include virtual="/../....html"‐‐>
```

index virtual   html



![image-20200804133336768](assets/image-20200804133336768.png)



整个大页面 拆分小页面  

一个个小页面   SSI   服务端包含技术  来搞

Nginx Apache 服务端来处理

遇到include  就来  渲染

JSP

服务端  渲染   CMS对这些小页面管理

页面  换头部Logo

轮播图换掉   我只需要更改轮播图

一个大页面  

4、将首页拆分成

首页主体内容

头部区域

页尾

index

header

index_banner

index_category

footer

轮播图

左侧列表导航

```
index.html：首页主体内容
include/header.html：头部区域
include/index_banner.html：轮播图
include/index_category.html：左侧列表导航
include/footer.html：页尾
```

5、在nginx虚拟主机中开通SSI

打开 

```
server{
listen 80;
server_name www.xuecheng.com;
ssi on;
ssi_silent_errors on;
......
```

ssi的配置参数如下： 

ssi on： 开启ssi支持 

ssi_silent_errors on：默认为off，设置为on则在处理SSI文件出错时不输出错误信息

找不到文件 

ssi_types：默认为 ssi_types text/html，如果需要支持shtml（服务器执行脚本，类似于jsp）则需要设置为ssi_types text/shtml
6、测试
去掉某个#include查看页面效果。



管理小页面 为什么呢   发布提交小页面

无需改小的   SSI

目的是什么呢？页面管理  

## CMS页面管理需求

当我们需要改动某个页面   改小页面 

为什么小页面  html    改HTML  

小的   大的 怎么浏览    SSI  拼  服务端

拆分  通过更改小页面   来修改 

技术方案可行   

页面怎么 被管理呢    很多信息  

页头 页尾   



页面属于某一个网站 

门户  轮播图   一个页面信息 

创建站点

创建模板

创建页面

  

页面所属于网站

创建  

1、这些页面的管理流程是什么？
1）创建站点：
一个网站有很多子站点，比如：学成在线有主门户、学习中心、问答系统等子站点。具体的哪个页面是归属于具体
的站点，所以要管理页面，先要管理页面所属的站点。

管理流程是什么

创建站点

一个网站有很多子站点

学成在线有主门户 学习中心 问答系统等子站点 

具体的哪个页面是归属于具体的站点  要管理页面 要管理页面所属的站点 

创建站点

2）创建模板：
页面如何创建呢？比如电商网站的商品详情页面，每个页面的内容布局、板式是相同的，不同的只是内容，这个页
面的布局、板式就是页面模板，模板+数据就组成一个完整的页面，最终要创建一个页面文件需要先定义此页面的
模板，最终拿到页面的数据再结合模板就拼装成一个完整的页面。

创建模板

页面如何创建呢 



3）创建页面：
创建页面是指填写页面的基本信息，如：页面的名称、页面的url地址等。
4）页面预览：
页面预览是页面发布前的一项工作，页面预览使用静态化技术根据页面模板和数据生成页面内容，并通过浏览器预
览页面。页面发布前进行页面预览的目是为了保证页面发布后的正确性。
5）页面发布：
使用计算机技术将页面发送到页面所在站点的服务器，页面发布成功就可以通过浏览器来访问了。
2、本项目要实现什么样的功能？

1）页面管理
管理员在后台添加、修改、删除页面信息
2）页面预览
管理员通过页面预览功能预览页面发布后的效果。
3）页面发布
管理员通过页面发布功能将页面发布到远程门户服务器。
页面发布成功，用户即可在浏览器浏览到最新发布的页面，整个页面添加、发布的过程由于软件自动执行，无需人
工登录服务器操作。

# CMS服务端工程搭建

## 开发工具配置

取个名字好难呀 

在线教育

服务端工程使用IntellijIDEA开发。
1、创建工程代码目录 XcEduCode（本教程创建XcEduCode01目录），并且IDEA打开。
2、配置maven环境
拷贝老师提供的maven仓库，setting.xml文件中配置maven仓库，maven仓库的目录位置不要去使用中文。
	![image-20200804135604537](assets/image-20200804135604537.png)

3、配置编码

![image-20200804135616267](assets/image-20200804135616267.png)

![image-20200804140058968](assets/image-20200804140058968.png)

4、配置JDK1.8
安装JDK1.8，并设置环境变量
在IDEA配置JDK1.8

![image-20200804135639116](assets/image-20200804135639116.png)





这里也应该选择JDK1.8的

5、配置快捷键
IDEA可以集成Eclipse的快捷键

![image-20200804135703962](assets/image-20200804135703962.png)

如需自定义则点击“copy”复制一份进行修改

6、自动导入包 快捷方式：
idea可以自动优化导入包，但是有多个同名的类调用不同的包，必须自己手动Alt+Enter设置

alter + enter 提示 



设置idea导入包

![image-20200804135722000](assets/image-20200804135722000.png)



![image-20200804140353732](assets/image-20200804140353732.png)





7、代码模板
自定义自己的代码模板
![image-20200804135733045](assets/image-20200804135733045.png)



![image-20200804140501953](assets/image-20200804140501953.png)



8、提示忽略大小写
默认IDEA的提示是区分大小写的，这里设置为提示忽略大小写

![image-20200804135743732](assets/image-20200804135743732.png)

![image-20200804140653630](assets/image-20200804140653630.png)



9、配置虚拟机内存
修改idea64.exe.vmoptions（64位电脑选择此文件）

一个例子，电脑内存8G，设置如下：
-Xms1024m -Xmx4096m -XX:MaxPermSize=1024m -XX:ReservedCodeCacheSize=1024m

## 导入基础工程

![image-20200804183921072](assets/image-20200804183921072.png)

导入  

工程结构

工程结构 CMS及其他服务端工程基于Maven进行构建  首先需要创建如下基础工程



CMS及其它服务端工程基于maven进行构建，首先需要创建如下基础工程：
parent工程：父工程，提供依赖管理。
common工程：通用工程，提供各层封装
model工程：模型工程，提供统一的模型类管理
utils工程：工具类工程，提供本项目所使用的工具类
Api工程：接口工程，统一管理本项目的服务接口。

工程结果如下：

父工程  提供依赖管理  

![image-20200804135835707](assets/image-20200804135835707.png)

基础工程代码及pom.xml配置参考课程资料“基础工程”。

导入父工程

1、将课程资料中的parent工程拷贝到代码目录
2、点击Import Model，选择parent工程目录

![image-20200804135858264](assets/image-20200804135858264.png)

选择Maven，下一步。

![image-20200804135908863](assets/image-20200804135908863.png)

3、导入成功

![image-20200804135923965](assets/image-20200804135923965.png)

导入其它工程

依次导入utils、model、common、api工程，方法同parent工和的导入。

![image-20200804141357580](assets/image-20200804141357580.png)

model  实体类

common 

## MongoDB入门



安装MongoDB

CMS采用MongoDB数据库存储CMS页面信息，CMS选用Mongodb的原因如下：
1、Mongodb是非关系型数据库，存储Json格式数据 ,数据格式灵活。
2、相比课程管理等核心数据CMS数据不重要，且没有事务管理要求。
参考“mongodb安装.md”安装Mongodb Server及 Studio 3T客户端软件。

数据存储灵活 

项目的核心数据   MySQL



为什么CMS 选用Mongodb原因 

非关系型数据库 存储JSON格式数据 数据格式灵活

核心数据  CMS数据不重要  没用事务管理要求 



MongoDB入门

参考“mongodb安装及入门”文档进行学习。



我去安装MongoDB

```
#数据库路径
dbpath=d:\databases\MongoDB\Server\3.4\data
#日志输出文件路径
logpath=d:\databases\MongoDB\Server\3.4\logs\mongo.log
#错误日志采用追加模式
logappend=true
#启用日志文件，默认启用
journal=true
#这个选项可以过滤掉一些无用的日志信息，若需要调试使用请设置为false
quiet=true
#端口号 默认为27017
port=27017
```



```
2020-08-04T19:53:54.617+0800 I CONTROL  [main] ***** SERVER RESTARTED *****
2020-08-04T19:53:55.260+0800 I CONTROL  [main] Trying to install Windows service 'MongoDB'
2020-08-04T19:53:55.261+0800 I CONTROL  [main] Error connecting to the Service Control Manager: 拒绝访问。 (5)
2020-08-04T19:56:18.884+0800 I CONTROL  [main] ***** SERVER RESTARTED *****
2020-08-04T19:56:19.519+0800 I CONTROL  [main] Trying to install Windows service 'MongoDB'
2020-08-04T19:56:19.519+0800 I CONTROL  [main] Error connecting to the Service Control Manager: 拒绝访问。 (5)
2020-08-04T20:00:15.295+0800 I CONTROL  [main] ***** SERVER RESTARTED *****
2020-08-04T20:00:15.932+0800 I CONTROL  [main] Trying to install Windows service 'MongoDB'
2020-08-04T20:00:15.933+0800 I CONTROL  [main] Error connecting to the Service Control Manager: 拒绝访问。 (5)
2020-08-04T20:11:01.434+0800 I CONTROL  [main] ***** SERVER RESTARTED *****
2020-08-04T20:11:02.026+0800 I CONTROL  [main] Trying to install Windows service 'MongoDB'
2020-08-04T20:11:02.029+0800 I CONTROL  [main] Service 'MongoDB' (MongoDB) installed with command line 'D:\databases\MongoDB\Server\3.4\bin\mongod.exe --config d:\databases\MongoDB\Server\3.4\mongo.conf --service'
2020-08-04T20:11:02.029+0800 I CONTROL  [main] Service can be started from the command line with 'net start MongoDB'

```



```
D:\databases\MongoDB\Server\3.4\bin>mongod.exe --config "d:\databases\MongoDB\Server\3.4\mongo.conf" --install

D:\databases\MongoDB\Server\3.4\bin>
```



拒绝访问

要有权限 

![image-20200804202715770](assets/image-20200804202715770.png)

![image-20200804201008543](assets/image-20200804201008543.png)



![image-20200804202951291](assets/image-20200804202951291.png)



![image-20200804203006723](assets/image-20200804203006723.png)









导入CMS数据库

导入cms数据库：
使用Studio 3T软件导入cms数据库
1、创建xc_cms数据库

![image-20200804141509358](assets/image-20200804141509358.png)

2、导入 cms数据库
右键数据库，点击导入数据库

![image-20200804141521339](assets/image-20200804141521339.png)

打开窗口，选择第一个 json。
下一步，选择要导入的数据文件（json文件）

![image-20200804141533910](assets/image-20200804141533910.png)



下一步操作即可完成。
导入成功：
![image-20200804141547196](assets/image-20200804141547196.png)

# 页面查询接口定义

## 定义模型

### 需求分析

查询接口定义 定义模型 需求分析 

在梳理完用户需求后就要去定义前后端的接口，接口定义后前端和后端就可以依据接口去开发功能了。

根据接口去开发功能了 



本次定义页面查询接口，本接口供前端请求查询页面列表，支持分页及自定义条件查询方式。

查询页面列表  支持分页及自定义条件查询方式



具体需求如下：
1、分页查询CmsPage 集合下的数据
2、根据站点Id、模板Id、页面别名查询页面信息
3、接口基于Http Get请求，响应Json数据

模型类介绍

接口的定义离不开数据模型，根据前边对需求的分析，整个页面管理模块的数据模型如下：

![image-20200804141640864](assets/image-20200804141640864.png)



CmsSite：站点模型
CmsTemplate：页面模板
CmsPage：页面信息
页面信息如下：

```
@Data
@ToString
@Document(collection = "cms_page")
public class CmsPage {
/**
* 页面名称、别名、访问地址、类型（静态/动态）、页面模版、状态
*/
//站点ID
private String siteId;
//页面ID
@Id
private String pageId;
//页面名称
private String pageName;
//别名
private String pageAliase;
//访问地址
private String pageWebPath;
//参数
private String pageParameter;
//物理路径
private String pagePhysicalPath;
//类型（静态/动态）
private String pageType;
//页面模版
private String pageTemplate;
//页面静态化内容
private String pageHtml;
//状态
private String pageStatus;
//创建时间
private Date pageCreateTime;
//模版id
private String templateId;
//参数列表，暂不用
private List<CmsPageParam> pageParams;
//模版文件Id
// private String templateFileId;
//静态文件Id
private String htmlFileId;
//数据Url
private String dataUrl;
}
```

属性说明：
1、定义一个页面需要指定页面所属站点
一个站点包括多个页面，比如：学成在线的门户站点（网站）包括了多个页面。
2、定义一个页面需要指定页面使用的模板
多个页面可以使用相同的模板，比如：商品信息模板，每个商品就是一个页面，所有商品使用同一个商品信息模板
注解说明：
@Data、@ToString、@Document注解表示什么意思？
@Data、@ToString：是Lombok提供的注解，下边会介绍。
@Document：是Spring Data mongodb提供的注解，最终CMS的开发会使用Mongodb数据库。

Lombok

上边的Data注解表示什么意思呢？Data注解，ToString注解都是Lombok提供的注解。
Lombok是一个实用的java工具，使用它可以消除java代码的臃肿，Lombok提供一系列的注解，使用这些注解可
以不用定义getter/setter、equals、构造方法等，它会在编译时在字节码文件自动生成这些通用的方法，简化开发
人员的工作。
项目官方地址：https://www.projectlombok.org/
比如上节创建的UserTest模型，@Data注解可以自动生成getter/setter方法，@ToString生成tostring方法。
使用方法：
1、在项目中添加Lombok的依赖
作用：项目在编译时根据Lombok注解生成通用方法。

```
<dependency>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
</dependency>

```

2、在IDEA开发工具中添加Lombok插件
作用：使用IDEA开发时根据Lombok注解生成通用方法，不报错。

![image-20200804141758055](assets/image-20200804141758055.png)



![image-20200804141806761](assets/image-20200804141806761.png)



## 定义接口

定义请求及响应类型

1、定义请求模型QueryPageRequest，此模型作为查询条件类型
为后期扩展需求，请求类型统一继承RequestData类型。

```
package com.xuecheng.framework.domain.cms.request;
import com.xuecheng.framework.model.request.RequestData;
import lombok.Data;
@Data
public class QueryPageRequest extends RequestData {
//站点id
private String siteId;
//页面ID
private String pageId;
//页面名称
private String pageName;
//别名
private String pageAliase;
//模版id
private String templateId;
}
```

2、响应结果类型，分页查询统一使用QueryResponseResult

定义接口

在Api接口工程专门定义接口，在Api工程单独定义接口的原因如下：
1、接口集中管理
2、Api工程的接口将作为各微服务远程调用使用。
页面查询接口定义如下：

```
public interface CmsPageControllerApi {
public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) ;
}
```

此接口编写后会在CMS服务工程编写Controller类实现此接口。

# 页面查询服务端开发