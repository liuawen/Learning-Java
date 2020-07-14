# 14 为互联网而生的持久化框架-Mybatis（二）

更新时间：2020-06-28 20:31:49

![img](http://img1.sycdn.imooc.com/5e9d00640001af9a06400359.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

知识犹如人体的血液一样宝贵。

——高士其

经过上一节对于 MyBatis 宏观层面的学习，我们对于 MyBatis 已经有了相当全面的认识。想必已经迫不及待的想要动手实践了。那咱们就闲话少说，直接开干！



# 1. 动手



## 1.1 整合 MyBatis

我们想要使用 MyBatis 首先需要添加对 MyBatis 的依赖。Spring Boot 向来以简单快速的特点行走江湖，在整合 MyBatis 的时候也依然遵循着这一原则，只需引入 MyBatis 相关的 starter 即可，具体如下：



### 添加依赖

```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.48</version>
</dependency>
```

当然，我们本套课程使用的数据库为 MySQL ，我们也需要引入 MySQL 的相关依赖（在 JPA 那一小节就已经接触过了）。



### 数据库配置

接下来，我们需要配置一下数据库的相关信息。在 application.yml 文件中添加如下配置：

```yaml
#数据源配置
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/springboot?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.jdbc.Driver
    username: root
    password: 123456
```

配置项：

- **url**：连接数据库的地址
- **driver-class-name**：连接数据库的驱动
- **username**：数据库的用户名
- **password**：数据库的密码

简单介绍一下 url 中的几个参数：

- **characterEncoding**：字符集，指的是程序与 MySQL 交互时所使用的字符集，我们使用 utf8
- **useSSL**：用来指定是否启用 SSL ，我们这里设置为不启用
- **serverTimezone**：时区，如果不指定，在使用 6.x 以后版本的驱动时会出现一些问题，我们设置为 Asia/Shanghai



### 交给国家（Spring）

我们知道，MyBatis 是用 Mapper 接口将我们的程序与一系列持久化操作串联起来的。对 Spring 有了解的同学都知道，如果想要把工作交给 Spring 来进行统一管理，那么就需要让 Spring 知道它的存在，也就是让 Spring 扫描到它。因此，我们需要在我们的项目的主类中加上一个注解 —— @MapperScan ，用来扫描 MyBatis 的 Mapper。括号中填入 Mapper 所在的包路径，具体如下：

```java
....
    
@MapperScan("com.imooc.springboot.mybatis.mapper")
public class SpringbootApplication {

    ....

}
```

> PS：如果我们不使用 @MapperScan 这个注解，那么就需要在每个 Mapper 接口上加上 @Mapper，这样显然比较麻烦。



## 1.2 使用 MyBatis

在学习 JPA 的那一节中我们了解到 JPA 是以 Java Entity 为原点，通过实体类来映射表之间的关系（可以通过 Java 实体类来生成对应的表结构和表关系）；而 MyBatis 则是以数据库（表）为原点，它跟 JPA 是一种互逆的关系，这样看来 MyBatis 应该具备通过数据库（表）生成实体类的能力。没错，MyBatis 为我们提供了一个很好用的工具 —— MyBatis Generator，简称 MBG（总觉得这个缩写怪怪的）。



### 创建表结构

我们可以通过下面的建表语句来创建我们的 User 表，当然你也可以直接将 JPA 那一节根据实体类生成的 User 表直接拿来用。

```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `birth_day` timestamp NULL DEFAULT NULL COMMENT '生日',
  `email` varchar(255) DEFAULT NULL COMMENT '邮件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';
```



### 配置 MBG

有了表，我们还需要对 MBG 进行一下简单的配置。MBG 有多种使用方式 —— 命令行、Ant、Java、Eclipse plugin 和 Maven plugin。我们选择 Maven plugin 的方式，因为简单且直观。

首先我们在 pom.xml 文件中添加对于 MBG 的依赖，将如下代码放到 标签下即可。

```xml
<plugin>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.3.7</version>
    <configuration>
        <configurationFile>
            ${basedir}/src/main/resources/generatorConfig.xml
        </configurationFile>
        <overwrite>true</overwrite>
        <verbose>true</verbose>
    </configuration>
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.48</version>
        </dependency>
    </dependencies>
</plugin>
```

然后，我们在 `src/main/resources` 目录下创建一个名为 `generatorConfig.xml` 的配置文件，在该文件中填写相应的配置即可（代码就不帖出来了，可以到源码中去看，里面有详细的注释）。

到此，MBG 就配置完成了，接下来我们就可以根据我们刚刚创建的 User 表来生成我们的实体以及 dao 层的方法了。

在 IDEA 的右侧有一个 `Maven Projects` 的选项卡（如果没有，可以在菜单中的 view ==》Tool Windows 中找到），点击会弹出如下视图：

![图片描述](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC)

找到 mybatis-generator 展开后，双击 mybatis-generator:generate 运行即可。看到类似如下信息，则代表成功生成了我们的实体以及 dao 。

```
[INFO] --- mybatis-generator-maven-plugin:1.3.7:generate (default-cli) @ mybatis ---
[INFO] Connecting to the Database
[INFO] Introspecting table user
[INFO] Generating Example class for table user
[INFO] Generating Record class for table user
[INFO] Generating Mapper Interface for table user
[INFO] Generating SQL Map for table user
[INFO] Saving file UserMapper.xml
[INFO] Saving file UserExample.java
[INFO] Saving file User.java
[INFO] Saving file UserMapper.java
```

运行完成以后，可以在 Project 视图下看到生成的文件 ——UserMapper、User、UserExample 和 UserMapper.xml
![图片描述](http://img1.sycdn.imooc.com/5eb36f7100010e7f07090455.png)

打开 UserMapper 接口，可以看到 MBG 帮我们生成了我们常用的增删改查以及统计接口：

![图片描述](http://img1.sycdn.imooc.com/5eb36f8500016b9711110637.png)

接口对应的实现在 UserMapper.xml 中，代码就不贴了，可以去源码中查看。

下面我们就可以试一试 MBG 帮我们生成的这些代码好不好用了，我们直接在 Controller 层调用 Mapper 接口（实际开发时需要借助 Service），实现一下基本的 CRUD 方法：

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @PostMapping
    public int create(@RequestBody User user) {
        return userMapper.insert(user);
    }

    @PutMapping
    public int update(@RequestBody User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

}
```

写完代码，我们启动工程，然后可以去 Swagger 上面测试一下。



# 2. 动态 SQL

有时候，静态的 SQL 语句并不能满足应用程序的需求。我们可以根据一些条件，来动态地构建 SQL 语句。例如，在 Web 应用程序中， 比如有一些查询功能，需要根据一个或多个条件查询数据，然后根据具体传来的查询参数动态生成查询的 SQL 去数据库取数据。在实现这种类型的查询功能时，静态 SQL 就无法满足了。我们需要根据参数来构建动态的 SQL 语句，将用户提供的参数添加到 SQL 语句的 WHERE 子句中。

动态 SQL 是 MyBatis 的强大特性之一。如果你使用过 JDBC ，那么你很可能已经体会过拼接 SQL 所带来的痛苦了。经常会遇到少了空格，或者多了逗号之类的语法错误。MyBatis 的动态 SQL 将为我们彻底解决这类问题。

MyBatis 采用功能强大的基于 OGNL 的表达式来实现动态 SQL。下面介绍几个我们日常开发中经常会用到的标签：

- if
- choose (when, otherwise)
- where (trim, set)
- foreach



## 2.1 if

if 标签很简单，用法跟 Java 中的 if 一样，条件为 true 则执行，为 false 则跳过，看一个小例子：

```xml
<select id="findUser" resultType="User">
  SELECT * FROM USER
  WHERE 1=1
  <if test="name != null">
    AND name like #{name}
  </if>
  <if test="email != null">
    AND email = #{email}
  </if>
</select>
```



## 2.2 choose

choose 标签类似 Java 中的 switch…case…default 语法，if 是二选一，而 choose 则是多选一，如果条件都不符合则选择最后 otherwise。具体见下面的代码：

```xml
<select id="findUserByIdOrName" resultType="User">
  SELECT * FROM USER WHERE 1=1
  <choose>
    <when test="id != null">
      AND id = #{id}
    </when>
    <when test="name != null">
      AND name like #{name}
    </when>
    <otherwise>
      AND 0 = 1
    </otherwise>
  </choose>
</select>
```



## 2.3 where

细心的你可能已经发现了，在上面的例子中，where 后面都有一个 1=1 的条件，这种写法在以前我们手动拼接 SQL 的时候经常用（其实是一种无奈之举），MyBatis 中的 where 标签替我们消除了这一问题。只有当 where 中至少有一个条件符合时，MyBatis 才会为我们拼接 where 子句，并且会帮我们妥善的处理开头和结尾，如下面的例子，如果第一个条件不成立，拼接后的结果为：SELECT * FROM USER WHERE email= ?。

```xml
<select id="findUser" resultType="User">
  SELECT * FROM USER
  <where>
      <if test="name != null">
        name like #{name}
      </if>
      <if test="email != null">
        AND email = #{email}
      </if>
  </where>
</select>
```



## 2.4 foreach

看到 foreach 这个标签，我想聪明的你不用我说也想到了，它就相当于 Java 中的 for。一点没错！下面通过一个根据 id 集合查询的例子吧：

```xml
<select id="findUser" resultType="User">
  SELECT * FROM USER
  <where>
      id in
    <foreach open="(" separator="," close=")" collection="list" item="id">
    	#{id}
    </foreach>
  </where>
</select>
```



# 3. 小结

OK，本小节我们一起学习了 MyBatis 的使用。包括与 Spring Boot 整合，代码生成插件 MBG 的配置及使用，还通过几个实例学习了 MyBatis 的一个强大功能 —— 动态 SQL。MyBatis 动态 SQL 的使用是非常重要的，日常开发中，我们经常会用到。



# 4. 总结

我们用三个小节学习了 Spring Data JPA 和 Mybatis。MyBatis 从 SQL 角度切入来解释对关系型数据库的使用， 重点解决 Java 数据访问与关系型数据库的 SQL 不一致的问题。JPA 更偏向实体与关系， 旨在解决 Java 面向对象与关系型数据库实体关系理念一致但访问接口不一致的问题。二者不同中蕴含着相同，相同中又各自带有各自的特点。结合起来学习，非常有意思。

不管是 MyBatis 与 JPA ，还是动态 SQL 和 Java 的语法（部分），通过对比学习，我们发现了不同事物之间的相同或相似之处。其实这种相似性在我们的生活、学习、工作中无处不在，洞察事物底层的相似、相同性的能力就是一个人的学习能力。而这种能力主要与两方面有关：1，你的知识量；2，你的刻意训练。知识量越多越容易发现知识之间的规律，越刻意的训练自己的联想能力，联想能力就会越强，强到变成一种本能。那些可以把知识融会贯通的人，无非是不断的积累和刻意的训练罢了。简单的道理常常会被忽视，但如果长期践行，在未来你将获得难以置信的回报。

[13 为互联网而生的持久化框架-Mybatis（一）](http://www.imooc.com/read/75/article/1809)[15 事务是个狠人儿，因为它一不做二不休（一）](http://www.imooc.com/read/75/article/1811)

精选留言 8

欢迎在这里发表留言，作者筛选后可公开显示

- [慕UI5387184](http://www.imooc.com/u/9109661/articles)

  感觉MBG有点复杂，一大堆配置，用得多吗?

   0

  回复

  6天前

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕UI5387184](http://www.imooc.com/u/9109661/articles)

    可以使用 MyBatis Plus。

    回复

    4天前

- [慕UI5387184](http://www.imooc.com/u/9109661/articles)

  org.mybatis.spring.bootmybatis-spring-boot-starter 没有版本号会报错

   0

  回复

  2020-07-07

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕UI5387184](http://www.imooc.com/u/9109661/articles)

    可以用 2.1.0

    回复

    6天前

- [qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

  “where”标签会知道如果它包含的标签中有返回值的话，它就插入一个‘where’。 此外，如果标签返回的内容是以AND 或OR 开头的，则它会剔除掉。

   0

  回复

  2020-06-27

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    高手。

    回复

    2020-06-28 20:33:55

- [qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

  如果我们不使用 @MapperScan 这个注解，那么就需要在每个 Mapper 接口上加上 @Repository，这样显然比较麻烦。 不需要加 @Repository 吧，在dao 层的接口层添加@Mapper 注解

   0

  回复

  2020-06-27

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    是的。

    回复

    2020-06-28 20:32:31

- [hwl_01](http://www.imooc.com/u/2198631/articles)

  源码在哪儿啊？谢谢！

   0

  回复

  2020-06-09

  - [MarchGoGo](http://www.imooc.com/u/9029620/articles)

    回复[hwl_01](http://www.imooc.com/u/2198631/articles)

    第一章

    回复

    2020-06-10 10:13:04

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[hwl_01](http://www.imooc.com/u/2198631/articles)

    源码在此：https://github.com/liushuijinger/springboot

    回复

    2020-06-10 23:54:46

- [慕田峪4063386](http://www.imooc.com/u/6226285/articles)

  如果数据库的中字段变化很多的话，那么代码生成器就会显得非常麻烦了，此时通用mapper出现

   0

  回复

  2020-06-08

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕田峪4063386](http://www.imooc.com/u/6226285/articles)

    可以使用 MyBatis Plus。

    回复

    2020-06-09 23:29:01

- [st2020](http://www.imooc.com/u/2985186/articles)

  听说老外都喜欢 jpa 不用 mybtis？

   0

  回复

  2020-06-08

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[st2020](http://www.imooc.com/u/2985186/articles)

    国外确实 JPA 用得多一些。

    回复

    2020-06-08 22:05:11

- [东明先森](http://www.imooc.com/u/4852618/articles)

  老师讲的很直白很好理解

   0

  回复

  2020-05-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[东明先森](http://www.imooc.com/u/4852618/articles)

    感谢支持！

    回复

    2020-05-25 20:41:45

 

千学不如一看，千看不如一练