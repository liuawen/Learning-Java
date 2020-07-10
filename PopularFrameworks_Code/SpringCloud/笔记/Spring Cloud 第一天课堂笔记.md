# SpringCloud

[TOC]



## 1. 系统架构演变概述

**目标**：了解项目架构的演变历程

随着互联网的发展，网站应用的规模不断扩大。需求的激增，带来的是技术上的压力。系统架构也因此也不断的演
进、升级、迭代。从单一应用，到垂直拆分，到分布式服务，到SOA，以及现在火热的微服务架构，还有在Google
带领下来势汹涌的Service Mesh。我们到底是该乘坐微服务的船只驶向远方，还是偏安逸得过且过？
其实生活不止眼前的苟且，还有诗和远方。所以我们今天就回顾历史，看一看系统架构演变的历程；把握现在，学习
现在最火的技术架构；展望未来，争取成为一名优秀的Java工程师。

### 集中式架构

当网站流量很小时，只需一个应用，将所有功能都部署在一起，以减少部署节点和成本。

![image-20200710101145909](assets/image-20200710101145909.png)

集中架构

用户

商品管理 订单管理

用户管理 购物车管理

权限管理 内容管理

数据库

优点：
系统开发速度快
维护成本低
适用于并发要求较低的系统
缺点：
代码耦合度高，后期维护困难
无法针对不同模块进行针对性优化
无法水平扩展
单点容错率低，并发能力差

垂直拆分

### 垂直拆分

垂直拆分
当访问量逐渐增大，单一应用无法满足需求，此时为了应对更高的并发和业务需求，我们根据业务功能对系统进行拆
分：

![image-20200710113113141](assets/image-20200710113113141.png)



优点：
系统拆分实现了流量分担，解决了并发问题
可以针对不同模块进行优化
方便水平扩展，负载均衡，容错率提高
缺点：
系统间相互独立，会有很多重复开发工作，影响开发效率



独立的子系统 



分布式服务架构

### 分布式服务

当垂直应用越来越多，应用之间交互不可避免，将核心业务抽取出来，作为独立的服务，逐渐形成稳定的服务中心，
使前端应用能更快速的响应多变的市场需求。

![image-20200710113307351](assets/image-20200710113307351.png)

你用的 我用的  抽象出来  一个服务  服务多 调用关系  耦合度  

优点：
将基础服务进行了抽取，系统间相互调用，提高了代码复用和开发效率
缺点：
系统间耦合度变高，调用关系错综复杂，难以维护

### SOA面向服务架构

SOA（Service Oriented Architecture）面向服务的架构：它是一种设计方法，其中包含多个服务， 服务之间通过相
互依赖最终提供一系列的功能。一个服务 通常以独立的形式存在与操作系统进程中。各个服务之间 通过网络调用。
SOA结构图：

![image-20200710113329251](assets/image-20200710113329251.png)

服务独立  



ESB（企业服务总线），简单 来说 ESB 就是一根管道，用来连接各个服务节点。为了集 成不同系统，不同协
议的服务，ESB 做了消息的转化解释和路由工作，让不同的服务互联互通。
SOA缺点：每个供应商提供的ESB产品有偏差，自身实现较为复杂；应用服务粒度较大，ESB集成整合所有服务和协
议、数据转换使得运维、测试部署困难。所有服务都通过一个通路通信，直接降低了通信速度。



### 微服务架构

微服务架构是使用一套小服务来开发单个应用的方式或途径，每个服务基于单一业务能力构建，运行在自己的进程
中，并使用轻量级机制通信，通常是HTTP API，并能够通过自动化部署机制来独立部署。这些服务可以使用不同的
编程语言实现，以及不同数据存储技术，并保持最低限度的集中式管理。
微服务结构图：

![image-20200710113348580](assets/image-20200710113348580.png)



API Gateway网关是一个服务器，是系统的唯一入口。为每个客户端提供一个定制的API。API网关核心是，所
有的客户端和消费端都通过统一的网关接入微服务，在网关层处理所有的非业务功能。如它还可以具有其它职
责，如身份验证、监控、负载均衡、缓存、请求分片与管理、静态响应处理。通常，网关提供RESTful/HTTP的
方式访问服务。而服务端通过服务注册中心进行服务注册和管理。



微服务的特点：
单一职责：微服务中每一个服务都对应唯一的业务能力，做到单一职责
微：微服务的服务拆分粒度很小，例如一个用户管理就可以作为一个服务。每个服务虽小，但“五脏俱全”。
面向服务：面向服务是说每个服务都要对外暴露Rest风格服务接口API。并不关心服务的技术实现，做到与平台
和语言无关，也不限定用什么技术实现，只要提供Rest的接口即可。
自治：自治是说服务间互相独立，互不干扰
团队独立：每个服务都是一个独立的开发团队，人数不能过多。
技术独立：因为是面向服务，提供Rest接口，使用什么技术没有别人干涉
前后端分离：采用前后端分离开发，提供统一Rest接口，后端不用再为PC、移动端开发不同接口
数据库分离：每个服务都使用自己的数据源
部署独立，服务间虽然有调用，但要做到服务重启不影响其它服务。有利于持续集成和持续交付。每个服
务都是独立的组件，可复用，可替换，降低耦合，易维护
微服务架构与SOA都是对系统进行拆分；微服务架构基于SOA思想，可以把微服务当做去除了ESB的SOA。ESB是
SOA架构中的中心总线，设计图形应该是星形的，而微服务是去中心化的分布式软件架构。两者比较类似，但其实也
有一些差别：



功能SOA 微服务
组件大小大块业务逻辑单独任务或小块业务逻辑
耦合通常松耦合总是松耦合
管理着重中央管理着重分散管理
目标确保应用能够交互操作易维护、易扩展、更轻量级的交互

![image-20200710113433906](assets/image-20200710113433906.png)





**小结**：

```mermaid
graph LR;
1[集中式架构] --> 2[垂直拆分]
2 --> 3[分布式服务]
3 --> 4[SOA面向服务架构]
4 --> 5[微服务架构]
```



mermaid



项目架构的演变历程

集中式架构



垂直拆分

分布式服务

SOA面向服务架构

微服务架构



## 2. 微服务架构说明

**目标**：了解SOA与微服务架构的区别以及说出微服务架构的特点

**分析**：

SOA使用了ESB组件的面向服务架构：ESB自身实现复杂；应用服务粒度较大，所有服务之间的通信都经过ESB会降低通信速度；部署、测试ESB比较麻烦。

面向服务架构  ESB组件   应用服务粒度较大

观察 问题 猜测 检验 对话 特殊 一般 

![image-20200710102515092](assets/image-20200710102515092.png)



**小结**：

**微服务架构**：是一套使用小服务或者单一业务来开发单个应用的方式或途径。

微服务架构特点：

- 单一职责
- 服务粒度小
- 面向服务（对外暴露REST api）
- 服务之间相互独立

与使用ESB的SOA架构的区别：微服务架构没有使用ESB，有服务治理注册中心；业务粒度小。



有服务治理

注册中心

业务粒度小



## 3. 服务调用方式说明

**目标**：能够说出服务调用方式种类

**小结**：

- RPC：基于socket，速度快，效率高；webservice、dubbo
- HTTP：基于TCP，封装比较臃肿；对服务和调用方没有任何技术、语言的限定，自由灵活；RESTful，Spring Cloud

服务调用方式种类

RPC

HTTP

调用方式如何  

服务间的远程调用



## 4. Spring RestTemplate示例工程导入



**目标**：了解Spring RestTemplate的应用

**分析**：

一般情况下有如下三种http客户端工具类包都可以方便的进行http服务调用：

- httpClient
- okHttp
- JDK原生URLConnection

spring 提供了RestTemplate的工具类对上述的3种http客户端工具类进行了封装，可在spring项目中使用RestTemplate进行服务调用。

**小结**：

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test(){
        String url = "http://localhost/user/8";
        //restTemplate可以对json格式字符串进行反序列化
        User user = restTemplate.getForObject(url, User.class);
        System.out.println(user);
    }
}

```



## 5. Spring Cloud概述

**目标**：Spring Cloud整合的组件和版本特征

**小结**：

- 整合的组件可以有很多组件；常见的组件有：eureka注册中心，Gateway网关，Ribbon负载均衡，Feign服务调用，Hystrix熔断器。在有需要的时候项目添加对于的启动器依赖即可。
- 版本特征：以英文单词命名（伦敦地铁站名）

## 6. 创建微服务工程

**目标**：创建微服务父工程heima-springcloud、用户服务工程user-service、服务消费工程consumer-demo

**分析**：

需求：查询数据库中的用户数据并输出到浏览器

- 父工程heima-springcloud：添加spring boot父坐标和管理其它组件的依赖
- 用户服务工程user-service：整合mybatis查询数据库中用户数据；提供查询用户服务
- 服务消费工程consumer-demo：利用查询用户服务获取用户数据并输出到浏览器

**小结**：

```xml
            <!-- springCloud -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

```

通过 `scope` 的import可以继承 `spring-cloud-dependencies` 工程中的依赖

## 7. 搭建配置user-service工程

**目标**：配置user-service工程并能够根据用户id查询数据库中用户

**分析**：

需求：可以访问http://localhost:9091/user/8输出用户数据

实现步骤：

1. 添加启动器依赖（web、通用Mapper）；
2. 创建启动引导类和配置文件；
3. 修改配置文件中的参数；
4. 编写测试代码（UserMapper，UserService，UserController）；
5. 测试

**小结**：

- 添加启动器依赖

```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- 通用Mapper启动器 -->
        <dependency>
            <groupId>tk.mybatis</groupId>
            <artifactId>mapper-spring-boot-starter</artifactId>
        </dependency>
        <!-- mysql驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

    </dependencies>

```



- 编写配置文件

```yml
server:
  port: 9091
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/springcloud
    username: root
    password: root

mybatis:
  type-aliases-package: com.itheima.user.pojo

```



## 8. 搭建配置consumer-demo工程

**目标**：编写测试类使用restTemplate访问user-service的路径根据id查询用户

**分析**：

需求：访问http://localhost:8080/consumer/8 使用RestTemplate获取http://localhost:9091/user/8的数据

实现步骤：

1. 添加启动器依赖；
2. 创建启动引导类（注册RestTemplate）和配置文件；
3. 编写测试代码（ConsumerController中使用restTemplate访问服务获取数据）
4. 测试

**小结**：

- 服务管理
  如何自动注册和发现
  如何实现状态监管
  如何实现动态路由
- 服务如何实现负载均衡
- 服务如何解决容灾问题
- 服务如何实现统一配置

上述的问题都可以通过Spring Cloud的各种组件解决。

## 9. Eureka注册中心说明

**目标**：说出Eureka的主要功能

**小结**：

Eureka的主要功能是进行服务管理，定期检查服务状态，返回服务地址列表。

![1560439174201](assets/1560439174201.png)

## 10. 搭建eureka-server工程

**目标**：添加eureka对应依赖和编写引导类搭建eureka服务并可访问eureka服务界面

**分析**：

Eureka是服务注册中心，只做服务注册；自身并不提供服务也不消费服务。可以搭建web工程使用Eureka，可以使用Spring Boot方式搭建。

搭建步骤：

1. 创建工程；
2. 添加启动器依赖；
3. 编写启动引导类（添加Eureka的服务注解）和配置文件；
4. 修改配置文件（端口，应用名称...）；
5. 启动测试

**小结**：

- 启动器依赖

```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
```



- 配置文件

```yml
server:
  port: 10086
spring:
  application:
    name: eureka-server
eureka:
  client:
    service-url:
      # eureka 服务地址，如果是集群的话；需要指定其它集群eureka地址
      defaultZone: http://127.0.0.1:10086/eureka
    # 不注册自己
    register-with-eureka: false
    # 不拉取服务
    fetch-registry: false
```



## 11. 服务注册与发现

**目标**：将user-service的服务注册到eureka并在consumer-demo中可以根据服务名称调用

**分析**：

- 服务注册：在服务提供工程user-service上添加Eureka客户端依赖；自动将服务注册到EurekaServer服务地址列表。
  - 添加依赖；
  - 改造启动引导类；添加开启Eureka客户端发现的注解；
  - 修改配置文件；设置Eureka 服务地址
- 服务发现：在服务消费工程consumer-demo上添加Eureka客户端依赖；可以使用工具类根据服务名称获取对应的服务地址列表。
  - 添加依赖；
  - 改造启动引导类；添加开启Eureka客户端发现的注解；
  - 修改配置文件；设置Eureka 服务地址；
  - 改造处理器类ConsumerController，可以使用工具类DiscoveryClient根据服务名称获取对应服务地址列表。

**小结**：

- 添加Eureka客户端依赖；

```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>

```

- 添加启动引导类注解；

  ![1560519608668](assets/1560519608668.png)

- 修改配置

```yml
spring:
  application:
    name: consumer-demo
eureka:
  client:
    service-url:
      defaultZone: http://127.0.0.1:10086/eureka
```



## 12. Eureka Server高可用配置

**目标**：可以启动两台eureka-server实例；在eureka管理界面看到两个实例

**分析**：

Eureka Server是一个web应用，可以启动多个实例（配置不同端口）保证Eureka Server的高可用。

**小结**：

**高可用配置**：将Eureka Server作为一个服务注册到其它Eureka Server，这样多个Eureka Server之间就能够互相发现对方，同步服务，实现Eureka Server集群。

## 13. Eureka客户端与服务端配置

**目标**：配置eureka客户端user-service的注册、续约等配置项，配置eureka客户端consumer-demo的获取服务间隔时间；了解失效剔除和自我保护

**分析**：

- Eureka客户端工程
  - user-service 服务提供
    - 服务地址使用ip方式
    - 续约
  - consumer-demo 服务消费
    - 获取服务地址的频率
- Eureka服务端工程 eureka-server
  - 失效剔除
  - 自我保护

**小结**：

- user-service 

```yml
eureka:
  client:
    service-url:
      defaultZone: http://127.0.0.1:10086/eureka
  instance:
    # 更倾向使用ip地址，而不是host名
    prefer-ip-address: true
    # ip地址
    ip-address: 127.0.0.1
    # 续约间隔，默认30秒
    lease-renewal-interval-in-seconds: 5
    # 服务失效时间，默认90秒
    lease-expiration-duration-in-seconds: 5
```



- consumer-demo 

```yml
eureka:
  client:
    service-url:
      defaultZone: http://127.0.0.1:10086/eureka
    # 获取服务地址列表间隔时间，默认30秒
    registry-fetch-interval-seconds: 10
```



- eureka-server

```yml
eureka:
  server:
    # 服务失效剔除时间间隔，默认60秒
    eviction-interval-timer-in-ms: 60000
    # 关闭自我保护模式（默认是打开的）
    enable-self-preservation: false
```



## 14. 负载均衡Ribbon简介

**目标**：描述负载均衡和ribbon的作用

**分析**：

负载均衡是一个算法，可以通过该算法实现从地址列表中获取一个地址进行服务调用。

在Spring Cloud中提供了负载均衡器：Ribbon



**小结**：

Ribbon提供了轮询、随机两种负载均衡算法（默认是轮询）可以实现从地址列表中使用负载均衡算法获取地址进行服务调用。

## 15. Ribbon负载均衡应用

**目标**：配置启动两个用户服务，在consumer-demo中使用服务名实现根据用户id获取用户

**分析**：

需求：可以使用RestTemplate访问http://user-service/user/8获取服务数据。

可以使用Ribbon负载均衡：在执行RestTemplate发送服务地址请求的时候，使用负载均衡拦截器拦截，根据服务名获取服务地址列表，使用Ribbon负载均衡算法从服务地址列表中选择一个服务地址，访问该地址获取服务数据。

实现步骤：

1. 启动多个user-service实例（9091,9092）；
2. 修改RestTemplate实例化方法，添加负载均衡注解；
3. 修改ConsumerController；
4. 测试

**小结**：

在实例化RestTemplate的时候使用@LoadBalanced，服务地址直接可以使用服务名。

## 16. 熔断器Hystrix简介

**目标**：了解熔断器Hystrix的作用

**小结**：

Hystrix是一个延迟和容错库，用于隔离访问远程服务，防止出现级联失败。

## 17. 线程隔离&服务降级

**目标**：了解什么是线程隔离和服务降级

**分析**：

Hystrix解决雪崩效应：

- 线程隔离：用户请求不直接访问服务，而是使用线程池中空闲的线程访问服务，加速失败判断时间。
- 服务降级：及时返回服务调用失败的结果，让线程不因为等待服务而阻塞。

**小结**：

- 添加依赖

```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>
```

- 开启熔断

  ![1560662674993](assets/1560662674993.png) 

- 降级逻辑

```java
@RestController
@RequestMapping("/consumer")
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    //@HystrixCommand(fallbackMethod = "queryByIdFallback")
    @HystrixCommand
    public String queryById(@PathVariable Long id){
        /*String url = "http://localhost:9091/user/"+id;
        
        //获取eureka中注册的user-service的实例
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("user-service");
        ServiceInstance serviceInstance = serviceInstances.get(0);

        url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;*/
        String url = "http://user-service/user/" + id;
        return restTemplate.getForObject(url, String.class);
    }

    public String queryByIdFallback(Long id){
        log.error("查询用户信息失败。id：{}", id);
        return "对不起，网络太拥挤了！";
    }

    public String defaultFallback(){
        return "默认提示：对不起，网络太拥挤了！";
    }
}

```



- 修改超时配置

```yml
hystrix:
  command:
    default:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 2000
```



## 18. 服务熔断演示

**目标**：了解熔断器工作原理

**小结**：

![1560682028169](assets/1560682028169.png)

可以通过配置服务熔断参数修改默认：

```yml
hystrix:
  command:
    default:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 2000
      circuitBreaker:
        errorThresholdPercentage: 50 # 触发熔断错误比例阈值，默认值50%
        sleepWindowInMilliseconds: 10000 # 熔断后休眠时长，默认值5秒
        requestVolumeThreshold: 10 # 熔断触发最小请求次数，默认值是20
```

