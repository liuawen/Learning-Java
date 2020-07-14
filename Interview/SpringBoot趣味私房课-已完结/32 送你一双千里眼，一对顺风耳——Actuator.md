**32 送你一双千里眼，一对顺风耳——Actuator**

32 送你一双千里眼，一对顺风耳——Actuator

更新时间：2020-06-02 09:25:55

![img](http://img1.sycdn.imooc.com/5ebe62ee0001af0106400426.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

青年是学习智慧的时期，中年是付诸实践的时期。

—— 卢梭



# 1 前言

上一节中，我们主要学习了 Spring Boot 应用的部署方式。那么当我们的应用部署到生产环境以后，我们如何能够随时掌握它的运行状态呢？这个时候就该 Actuator 出场了，有了它，我们就像长了顺风耳、千里眼。它可以将应用的一举一动顺着网线瞬间呈现给我们，让我们可以稳坐中军帐，决胜于千里之外。

哈哈，越说越玄乎了，下面我们一起来看看 Actuator 到底有什么本事吧。



# 2 简介

> Actuator 是一个制造术语，指的是移动或控制某物的机械装置。这种装置可以非常精准的展示每一个细微的变化。

这也是 Spring 对 Actuator 寄予的期望。Actuator 是 Spring Boot 的附加功能，可以帮助我们监控和管理我们的应用。支持使用 HTTP 端点或 JMX 来管理和监视应用程序。审计、健康状况和指标收集也可以自动应用到我们的应用程序中。

下面我们就看看 Actuator 具体可以做哪些事情。



## 2-1 通用端点

| ID                 | Description                                                  |
| :----------------- | :----------------------------------------------------------- |
| `auditevents`      | 当前应用中的审计事件信息。需要配置 `AuditEventRepository` bean. |
| `beans`            | 当前应用中所有被 Spring 管理的 bean。                        |
| `caches`           | 当前应用中所有可用的缓存。                                   |
| `conditions`       | 显示在配置和自动配置类上评估的条件，以及它们匹配或不匹配的原因。 |
| `configprops`      | 当前应用的属性配置信息列表（被 `@ConfigurationProperties` 注解修饰的配置） |
| `env`              | 当前应用的环境配置信息。                                     |
| `flyway`           | 已经被应用的 flyway 数据库迁移信息。需要配置 `Flyway` bean。 |
| `health`           | 应用当前的健康状况信息。                                     |
| `httptrace`        | 应用的 HTTP 请求追踪信息。需要配置 `HttpTraceRepository` bean。 |
| `info`             | 当前应用信息（用于自定义作者信息等）                         |
| `integrationgraph` | Spring 集成信息。需要依赖 `spring-integration-core` 包。     |
| `loggers`          | 当前应用的日志配置信息（支持修改）                           |
| `liquibase`        | 已经被应用的 liquibase 数据库迁移信息。 需要配置 `Liquibase` bean。 |
| `metrics`          | 当前应用的各项度量指标。                                     |
| `mappings`         | 当前应用的所有 `@RequestMapping` 路径。                      |
| `scheduledtasks`   | 当前应用中的定时任务信息。                                   |
| `sessions`         | 当前应用中允许检索和删除的用户会话（如果我们使用了 Spring Session）。 |
| `shutdown`         | 优雅的关闭当前应用。 默认关闭。                              |
| `threaddump`       | 执行一个线程 dump 操作（获取线程快照）。                     |

> 默认情况下，除了 shutdown 以外的所有端点都已启用。



## 2-2 附加端点

如果你的应用是一个 Web 工程 (Spring MVC, Spring WebFlux, or Jersey)， 你还可以使用以下附加端点：

| ID           | Description                                                  |
| :----------- | :----------------------------------------------------------- |
| `heapdump`   | 获得一个 JVM 堆的 dump 文件（可以使用 JVisualVM 查看）。     |
| `jolokia`    | 通过 HTTP 暴露 JMX bean（不支持 WebFlux)，需要依赖 `jolokia-core` 包。 |
| `logfile`    | 返回日志文件内容（如果配置了 `logging.file.name` 或 `logging.file.path` 属性）。可以使用 HTTP `Range` 头截取日志文件内容。 |
| `prometheus` | 为 Prometheus（一个强大的监控系统） 开放的抓取接口。需要依赖 `micrometer-registry-prometheus` 包。 |



# 3 使用

接下来，该动手实践啦！在 Spring Boot 中开启一个功能的步骤，我们已经再熟悉不过了，一般就是添加一下 Maven 依赖，然后就好了。遇到相对 “麻烦” 的情况，也就是再添加一些配置而已。

开整！

添加 Maven 依赖：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Actuator 就属于一步到位的那种，添加完 Maven 依赖，我们就可以用了（我们都知道是 Spring Boot 帮我们做了自动配置）。



## 3-1 默认配置

在默认配置下，我们访问 `http://localhost:8080/springboot/actuator`。会得到如下信息：

```json
{
    "_links": {
        "self": {
            "href": "http://localhost:8080/springboot/actuator",
            "templated": false
        },
        "health": {
            "href": "http://localhost:8080/springboot/actuator/health",
            "templated": false
        },
        "health-path": {
            "href": "http://localhost:8080/springboot/actuator/health/{*path}",
            "templated": true
        },
        "info": {
            "href": "http://localhost:8080/springboot/actuator/info",
            "templated": false
        }
    }
}
```

以上是 Actuator 默认暴露给我们的端点。

访问 `http://localhost:8080/springboot/actuator/health` 查看一些应用的健康状况，返回的信息也非常简单：

```json
{
    "status": "UP"
}
```

由于端点可能包含敏感信息，所以（HTTP 端点）默认情况下只暴露了 health 和 info。并且 health 也只显示了最简略的信息。我们可以通过修改配置来选择暴露哪些端点。



## 3-2 暴露端点

默认配置下只显示了最简要的信息，这对于我们来说，显然是不够的，我们需要更详尽的信息，才能全面的了解应用的运行情况。下面我们就通过添加一些配置，来获取更多的信息。

在 application.yml 文件中添加如下配置来暴露所有端点，并显示 health 详情：

```yaml
management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always
```

> 想要了解更多属性，戳[全部属性](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#actuator-properties)

重启应用后，再次访问 `http://localhost:8080/springboot/actuator`，我们会看到如下结果：

```json
{
    "_links": {
        "self": {
            "href": "http://localhost:8080/springboot/actuator",
            "templated": false
        },
        "beans": {
            "href": "http://localhost:8080/springboot/actuator/beans",
            "templated": false
        },
        "caches-cache": {
            "href": "http://localhost:8080/springboot/actuator/caches/{cache}",
            "templated": true
        },
        "caches": {
            "href": "http://localhost:8080/springboot/actuator/caches",
            "templated": false
        },
        "health": {
            "href": "http://localhost:8080/springboot/actuator/health",
            "templated": false
        },
        "health-path": {
            "href": "http://localhost:8080/springboot/actuator/health/{*path}",
            "templated": true
        },
        "info": {
            "href": "http://localhost:8080/springboot/actuator/info",
            "templated": false
        },
        "conditions": {
            "href": "http://localhost:8080/springboot/actuator/conditions",
            "templated": false
        },
        "configprops": {
            "href": "http://localhost:8080/springboot/actuator/configprops",
            "templated": false
        },
        "env": {
            "href": "http://localhost:8080/springboot/actuator/env",
            "templated": false
        },
        "env-toMatch": {
            "href": "http://localhost:8080/springboot/actuator/env/{toMatch}",
            "templated": true
        },
        "loggers": {
            "href": "http://localhost:8080/springboot/actuator/loggers",
            "templated": false
        },
        "loggers-name": {
            "href": "http://localhost:8080/springboot/actuator/loggers/{name}",
            "templated": true
        },
        "heapdump": {
            "href": "http://localhost:8080/springboot/actuator/heapdump",
            "templated": false
        },
        "threaddump": {
            "href": "http://localhost:8080/springboot/actuator/threaddump",
            "templated": false
        },
        "metrics": {
            "href": "http://localhost:8080/springboot/actuator/metrics",
            "templated": false
        },
        "metrics-requiredMetricName": {
            "href": "http://localhost:8080/springboot/actuator/metrics/{requiredMetricName}",
            "templated": true
        },
        "scheduledtasks": {
            "href": "http://localhost:8080/springboot/actuator/scheduledtasks",
            "templated": false
        },
        "mappings": {
            "href": "http://localhost:8080/springboot/actuator/mappings",
            "templated": false
        }
    }
}
```

Nice！这次暴露的端点够多了（废话！都暴露出来了能不够吗？）。

接下来我们访问 `http://localhost:8080/springboot/actuator/health` ，看看有哪些变化：

```json
{
    "status": "UP",
    "components": {
        "diskSpace": {
            "status": "UP",
            "details": {
                "total": 127049043968,
                "free": 29705293824,
                "threshold": 10485760
            }
        },
        "ping": {
            "status": "UP"
        }
    }
}
```

可以看到，`health` 端点的信息也丰富了不少。`diskSpace` 和 `ping` 是两个内置的「健康指示器」，后面我们会详细说。



## 3-3 开启 / 关闭端点

端点的启停可以使用 management.endpoint..enabled 属性来进行控，true 开，false 关。

我们以 shutdown 端点为例，在 application.yml 文件中添加如下配置：

```yaml
management:
  endpoint:
    shutdown:
      enabled: true
```

然后重启应用，并使用 `POST` 方式（可以使用 PostMan）请求 `shutdown` 端点。会看到返回如下信息：

```json
{
    "message": "Shutting down, bye..."
}
```

这时候，你会发现你的服务被关闭了，说明 `shutdown` 已经被成功开启了。



# 4. 自定义

就像我们之前了解的那样，Spring Boot 总是在提供一些常用功能之外，还给你自定义的自由。这种设计思路无处不在，Actuator 也不例外。



## 4.1 自定义健康指示器

一些常用的内置健康指示器：

| Name                                                         | Description                   |
| :----------------------------------------------------------- | :---------------------------- |
| [`DiskSpaceHealthIndicator`](https://github.com/spring-projects/spring-boot/tree/v2.2.6.RELEASE/spring-boot-project/spring-boot-actuator/src/main/java/org/springframework/boot/actuate/system/DiskSpaceHealthIndicator.java) | 检查硬盘剩余空间是否足够      |
| [`DataSourceHealthIndicator`](https://github.com/spring-projects/spring-boot/tree/v2.2.6.RELEASE/spring-boot-project/spring-boot-actuator/src/main/java/org/springframework/boot/actuate/jdbc/DataSourceHealthIndicator.java) | 检查数据连接是否可用          |
| [`MailHealthIndicator`](https://github.com/spring-projects/spring-boot/tree/v2.2.6.RELEASE/spring-boot-project/spring-boot-actuator/src/main/java/org/springframework/boot/actuate/mail/MailHealthIndicator.java) | 检查邮件服务是否可用          |
| [`MongoHealthIndicator`](https://github.com/spring-projects/spring-boot/tree/v2.2.6.RELEASE/spring-boot-project/spring-boot-actuator/src/main/java/org/springframework/boot/actuate/mongo/MongoHealthIndicator.java) | 检查 MongoDB 是否可用         |
| [`PingHealthIndicator`](https://github.com/spring-projects/spring-boot/tree/v2.2.6.RELEASE/spring-boot-project/spring-boot-actuator/src/main/java/org/springframework/boot/actuate/health/PingHealthIndicator.java) | ping，只要应用还活着就返回 up |
| [`RabbitHealthIndicator`](https://github.com/spring-projects/spring-boot/tree/v2.2.6.RELEASE/spring-boot-project/spring-boot-actuator/src/main/java/org/springframework/boot/actuate/amqp/RabbitHealthIndicator.java) | 检查 Rabbit 服务是否可用      |
| [`RedisHealthIndicator`](https://github.com/spring-projects/spring-boot/tree/v2.2.6.RELEASE/spring-boot-project/spring-boot-actuator/src/main/java/org/springframework/boot/actuate/redis/RedisHealthIndicator.java) | 检查 Redis 服务是否可用       |
| [`SolrHealthIndicator`](https://github.com/spring-projects/spring-boot/tree/v2.2.6.RELEASE/spring-boot-project/spring-boot-actuator/src/main/java/org/springframework/boot/actuate/solr/SolrHealthIndicator.java) | 检查 Solr 服务是否可用        |

> 想要了解更多，戳[全部内置健康指示器](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/html/production-ready-features.html#auto-configured-healthindicators)

这些内置的健康指示器都是被 Spring Boot 自动配置的。比如你的应用配置了 MySQL，那么访问 `http://localhost:8080/springboot/actuator/health` 就会看到 MySQL 的状态。

下面我们来写一个自定义的健康指示器，我们需要实现 `HealthIndicator` 接口，然后实现 `health()` 方法：

```java
@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.down().withDetail("message","出错了").build();
    }

}
```

我们可以通过直接访问 `http://localhost:8080/springboot/actuator/health/custom`，来查看效果：

```json
{
    "status": "DOWN",
    "details": {
        "message": "出错了"
    }
}
```

我们可以根据需要定制我们需要检查的内容和逻辑。



## 4.2 自定义端点

除了自定义健康指示器，我们还可以自定义端点。自定义端点的意义在于，它不仅可以展示信息，还可以对应用进行修改（更新和删除）。自定义端点需要用到两个注解：`@Endpoint` 和 `@XxxOperation`（“xxx” 代表 Read、Write 和 Delete）。

```java
@Component
@Endpoint(id = "customEndPoint")
public class CustomEndPoint {

    @ReadOperation
    public Map<String,String> read() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "自定义端点");
        return map;
    }
    
    @WriteOperation
    public Map<String,String> write(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("message", name + " 已被修改");
        return map;
    }

    @DeleteOperation
    public Map<String,String> delete(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("message", name + " 已被删除");
        return map;
    }

}
```

Operation 注解与 HTTP 方法的对应关系：

| Operation 注解     | HTTP 方法 |
| :----------------- | :-------- |
| `@ReadOperation`   | `GET`     |
| `@WriteOperation`  | `POST`    |
| `@DeleteOperation` | `DELETE`  |

分别用 `GET`、`POST`、`DELETE` 方法请求 `http://localhost:8080/springboot/actuator/customEndPoint` 就可以得到下面的效果：

```json
# GET
{
    "name": "自定义端点"
}

# POST
{
    "message": "哈哈哈 已被修改"
}

# DELETE
{
    "message": "哈哈哈 已被删除"
}
```

> PS：不要忘记传参数哦



# 5. 总结

恭喜你喜提一双千里眼和一对顺风耳！

这一节基本上都是需要动手实践的内容。前面几小节讲的原理性的东西消化起来咋样？有没有感觉胃动力不足？

哈哈，没关系，其实不管是实践型的知识还是理论型的知识，要想掌握的牢靠都离不开「反复」二字。实践型的需要你反复动手练，理论型的需要你反复去揣摩思考。「拳不离手曲不离口」说的就是这个道理。

内容看完了，接下来就需要你操练起来啦。自己实践的时候把我没有列出来的配置试一试，看看它们都会对程序产生哪些影响。你会从中发现很多乐趣，同时也会收获很多感悟，对知识有更进一步的理解。加油！

[31 运行 Spring Boot 应用的几种方式](http://www.imooc.com/read/75/article/1827)[33 君子善假于物——IDEA值得用心假一假](http://www.imooc.com/read/75/article/1829)

精选留言 1

欢迎在这里发表留言，作者筛选后可公开显示

- [慕慕童鞋](http://www.imooc.com/u/8954842/articles)

  应用监控很有必要。

   0

  回复

  2020-06-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕慕童鞋](http://www.imooc.com/u/8954842/articles)

    必须的。

    回复

    2020-06-28 20:25:13

 

千学不如一看，千看不如一练