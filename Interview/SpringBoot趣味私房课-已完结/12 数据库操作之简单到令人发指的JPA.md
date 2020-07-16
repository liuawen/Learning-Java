**12 数据库操作之简单到令人发指的JPA**

# 12 数据库操作之简单到令人发指的JPA

更新时间：2020-05-26 11:47:03

![img](http://img2.sycdn.imooc.com/5e9d00320001c72306400359.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

知识是一种快乐，而好奇则是知识的萌芽。

——培根

硬盘有价，数据无价。数据对于一个企业的重要性不言而喻。试想一下，如果腾讯的用户数据丢失会出现什么后果？可能你跟很多人就此就断了联系。再也看不到女神在朋友圈的各种动态了。这可能对于你的影响不算太大，那么再试想一下，如果支付宝或者银行的数据丢失会怎样？想到这里直冒冷汗，真担心我那两位数的存款会不翼而飞呀！

数据是基础，一切的应用因为有了数据才变得有意义。从社交工具到金融产品，再到 A.I. （人工智能）无一不是因为有了数据才变得有价值。说到数据通常会涉及到两个方面——数据安全和数据处理（操作）。数据安全跟我们大多数的开发人员关系没有那么紧密，我们的精力通常会放在数据操作上。在这一小节中，我们一起来学习一下 Spring Boot 为我们提供的数据操作组件—— Spring Data JPA。



数据  数据安全 和 数据处理 操作





腾讯的用户数据丢失 很多人就此断了联系

支付宝 银行的数据丢失  diushi



# 1. 历史发展

持久化操作（对数据库的操作）一直都是 Java 的核心内容，在 Java 的发展历史中，数据库持久化层面的框架也在不断地发展与更新。

持久化操作 对数据库的操作  一直都是Java的核心内容

数据库持久化层面的框架也在不断地发展与更新



Java中访问数据库的规范  



JDBC（ Java DataBase Connectivity ）是 Java 中访问数据库的规范，由 SUN 公司制定（目前 SUN 已经被 Oracle 收购）。原生的 JDBC 代码臃肿、冗余，非常难用。这一度使得 Java EE 在当时备受质疑。所以 SUN 公司推出了大名鼎鼎的 EJB，现在已经很少人有提及 EJB 了，当年曾经大名鼎鼎也是因为是 SUN 公司的产品（连技术圈也开始拼爹了）。但由于 EJB 太重量级，太难用，很快就被当时的新晋小生 Hibernate 所取代（事实再一次告诉我们，爹再牛逼也只能帮你一时，关键还得看自己）。

看自己  给力不 

HIbernate



Hibernate 凭借自身强大的功能迅速走红，与 Struts 和 Spring 组成了当时风靡一时的 SSH 三人组。后来 SUN 公司借鉴了 Hibernate 的设计思路，制定了 JPA（ Java Persistence API ）规范。在 Hibernate 后来的版本中，也实现了对于 JPA 的完全支持。这也使 HIbernate 在当时进一步巩固了自己在持久层框架的霸主地位。

JPA

随着互联网的发展，尤其是移动互联网的飞速扩展，HIbernate 对于性能和灵活性的需求显得捉襟见肘，已经无法满足日新月异的互联网业务场景了。这个时候，又一个年轻人站了出来，它就是 Mybatis。Mybatis 凭借着其简单、高效、灵活等特点迅速成为了新时代的宠儿。

性能 灵活性 



日新月异的互联网业务场景了 



这个时候   又一个年轻人站了出来

它就是Mybatis

它 简单 高效  灵活 

新时代的宠儿 cho

我要和别人讲  说   

我好好看看  



# 2. 两种思路

数据库持久层框架通常可以分为两种类型，两者的关注对象不同。其中一种关注的重心是数据库（表），对 JDBC 做一定的封装，将 JDBC 冗余的样板代码 “隐藏” 起来，使其变得方便和快捷，此中的代表就是 Mybatis；另一种的关注重心则是 Java Entity。通过实体类来映射表之间的关系，HIbernate 就是这一分类中的翘楚（ Spring Data JPA 就是基于 HIbernate 实现的）。

Spring Data JPA 对 JPA（ Java Persistence API ）进行了进一步的封装，使得对数据库的常用操作变得异常简单。到底能有多简单呢？简单到令人无法相信，不信？那我们走着瞧！





数据库 表

JDBC做一定的封装



JDBC冗余的样板代码 隐藏起来

变得方便和快捷  Mybatis



Java Entity  

实体类来映射表之间的关系 

Spring Data JPA就是基于HIbernate实现的 

Spring Data JPA对JPA进行了进一步的封装

使得对数据库的常用操作变得异常简单



# 3. 动手



## 3.1 准备

在使用 Spring Data JPA 之前，我们需要做一些准备工作。因为 Spring Data JPA 是持久层的组件，那么我们肯定会就要用到数据库了。所以，我们需要先安装数据库，不用说你也想到了，我们使用的数据库是 MySQL（如何安装 MySQL 就不用我多说了吧）。MySQL 安装完成后，我们需要创建一个数据库，在本专栏里，数据库的名字叫做 springboot，当然你也可以选择你喜欢的名字。



在使用Spring Data JPA



我的数据库就叫SB  SpringBoot



## 3.2 添加依赖

要使用 Spring Data JPA 我们需要在 pom 文件中添加如下依赖：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```



坐标  

## 3.3 添加配置

添加完依赖，我们需要增加一些配置，才能让我们的工程访问到数据库。我们需要在 application.yml 文件中添加如下配置：

```yaml
#数据源配置
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/springboot?characterEncoding=utf8&useSSL=false
    driver-class-name: com.mysql.jdbc.Driver
    username: root
    password: 123456
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
```

配置介绍：

- **url** 数据库地址与参数
- **driver-class-name** 连接数据库的驱动
- **username** 数据库用户名
- **password** 数据库密码

上面四项配置比较简单，稍微有点编程经验的一看就能明白是什么，这里就不过多介绍了。我们简单说一下 jpa 下面的几项配置：

**show-sql** 很简单，设为 true 代表打印 sql，false 则为不打印；

**database-platform** 也不难，用来指定使用哪种 MySQL 的存储引擎，我们这里使用的是 InnoDB。

```
ddl-auto: update
```

**ddl-auto** 这个配置简单说一下，它有四个值可选，具体含义如下：

- create 每次启动重新创建表（启动过程中原来的数据会被清除）
- create-drop 每次启动重新创建表，并在程序结束是删除表，如果表不存在会报错
- update 每次启动如表结构不一致，则更新表结构，原数居会保留（一般使用该项）
- validate 每次启动验证表结构，如果不一致则报错



使用update

## 3.4 创建实体

我们可以在之前创建的 User 类中加入如下注解，使其变成我们的实体类：

```java
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
  
    private String name;
  
  .......

}
```

注解介绍：

在 User 类中，我们是用了三个新注解——@Entity、@Id 和 @GeneratedValue。@Entity 用来声明 User 是一个实体类，将会与数据库里的 user 表对应起来；@Id 和 @GeneratedValue 则标识 user 的 id 属性为 user 表的自增 Id。

如果想要自定义表名，比如想要让与 User 类对应的表叫做 t_user 的话，那么只需要使用 @Table(name = “t_user”) 即可。同样想要自定义列名也非常简单，比如想要将 name 与表里的 user_name 对应，只需要在 name 属性上加上 @Column(name = “user_name”) 即可。



## 3.5 生成表结构

接下来我们可以让 Spring Data JPA 根据实体类来生成表结构了，启动程序，会在控制台看到如下日志：

```sql
Hibernate: 
create table user 
(id integer not null, age integer not null, birth_day date, 
email varchar(255), name varchar(255) not null, primary key (id)) 
engine=InnoDB
```

看到上面的日志输出，说明 user 表被创建了，我们可以登录 MySQL 去验证一下：

![图片描述](http://img1.sycdn.imooc.com/5e9ac1840001fc8605220362.png)

我们看到，user 表已经被成功创建。我们再检查一下 user 表的结构是否符合我们的预期，使用 desc user 命令查看，结果如下：

![图片描述](http://img1.sycdn.imooc.com/5e9ac17a00019eea12240492.png)

OK，user 表的结构跟我们的 User 实体类一致。



desc user;



## 3.6 完善剩余代码

创建 User 类的持久化接口 UserRepository：

```java
public interface UserRepository extends JpaRepository<User,Integer> {
    
}
```

UserRepository 中不需要写任何代码，但依然可以帮我们完成增删改查的操作，下面我们继续。

创建 UserController 并实现增删改查四个方法：

```java
@Api
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return userRepository.findById(id).get();
    }

    @ApiOperation(value = "创建用户")
    @PostMapping("")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("")
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}
```



## 3.7 效果

接下来我们启动程序，打开 Swagger 去验证一下这些接口是否好用。首先，我们调用 create 方法来创建一个 user。

参数如下：

```json
{
  "age": 18,
  "birthDay": "2011-01-01",
  "email": "xiaoming@imooc.com",
  "name": "小明"
}
```

执行完成后，登录 MySQL 查看，结果如下：

![图片描述](http://img1.sycdn.imooc.com/5e9ac1690001f25011840314.png)

我们通过 Controller 中的 create 方法 调用了 UserRepository 中的 save 方法成功插入了一条用户信息。其他方法的效果就不在这里一一演示了，留给你自己去把玩吧。



去把玩吧



# 4. 扩展



## 4.1 基于方法名查询

假如我想要个性化查询怎么办呢？比如我想按照年龄来查询用户，其实也非常简单，只需要按照 Spring Data JPA 的规范在 UserRepository 中定义相应的接口即可。没错，就是只定义个接口，不需要写实现！

```java
public interface UserRepository extends JpaRepository<User,Integer> {
    public List<User> findByAge(Integer age);
}
```

定义相应的接口即可

没错

只定义个接口  不需要写实现 

在 UserRepository 中加入上面一句代码就完成了根据年龄查询用户的功能。当然，我们需要在 Controller 里面调用一下：

```java
@ApiOperation(value = "根据年龄查询用户")
@GetMapping("/age/{age}")
public List<User> getByAge(@PathVariable Integer age) {
    return userRepository.findByAge(age);
}
```

OK，这样就搞定了，可以去 Swagger 上测试一下了，效果就不在这里展示了。



**更多关键字规则对照表：**

| 关键字            | 例子                                                    | JPQL 片段                                                    |
| :---------------- | :------------------------------------------------------ | :----------------------------------------------------------- |
| And               | findByLastnameAndFirstname                              | … where x.lastname = ?1 and x.firstname = ?2                 |
| Or                | findByLastnameOrFirstname                               | … where x.lastname = ?1 or x.firstname = ?2                  |
| Is,Equals         | findByFirstname,findByFirstnameIs,findByFirstnameEquals | … where x.firstname = ?1                                     |
| Between           | findByStartDateBetween                                  | … where x.startDate between ?1 and ?2                        |
| LessThan          | findByAgeLessThan                                       | … where x.age < ?1                                           |
| LessThanEqual     | findByAgeLessThanEqual                                  | … where x.age <= ?1                                          |
| GreaterThan       | findByAgeGreaterThan                                    | … where x.age > ?1                                           |
| GreaterThanEqual  | findByAgeGreaterThanEqual                               | … where x.age >= ?1                                          |
| After             | findByStartDateAfter                                    | … where x.startDate > ?1                                     |
| Before            | findByStartDateBefore                                   | … where x.startDate < ?1                                     |
| IsNull            | findByAgeIsNull                                         | … where x.age is null                                        |
| IsNotNull,NotNull | findByAge(Is)NotNull                                    | … where x.age not null                                       |
| Like              | findByFirstnameLike                                     | … where x.firstname like ?1                                  |
| NotLike           | findByFirstnameNotLike                                  | … where x.firstname not like ?1                              |
| StartingWith      | findByFirstnameStartingWith                             | … where x.firstname like ?1 (parameter bound with appended %) |
| EndingWith        | findByFirstnameEndingWith                               | … where x.firstname like ?1 (parameter bound with prepended %) |
| Containing        | findByFirstnameContaining                               | … where x.firstname like ?1 (parameter bound wrapped in %)   |
| OrderBy           | findByAgeOrderByLastnameDesc                            | … where x.age = ?1 order by x.lastname desc                  |
| Not               | findByLastnameNot                                       | … where x.lastname <> ?1                                     |
| In                | findByAgeIn(Collection ages)                            | … where x.age in ?1                                          |
| NotIn             | findByAgeNotIn(Collection ages)                         | … where x.age not in ?1                                      |
| True              | findByActiveTrue()                                      | … where x.active = true                                      |
| False             | findByActiveFalse()                                     | … where x.active = false                                     |
| IgnoreCase        | findByFirstnameIgnoreCase                               | … where UPPER(x.firstame) = UPPER(?1)                        |



## 4.2 分页、排序

那么想要分页、排序该怎么办呢？支持吗？方便吗？必须的！而且比上面的还简单，UserRepository 中不需要添加任何内容，直接在 Controller 里调用即可：

```java
@ApiOperation(value = "分页获取用户列表")
@GetMapping("")
public Page<User> list(String property, String direction, Integer page, Integer size) {

    Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(direction),property);

    return userRepository.findAll(pageable);
}
```

> PS：页码从 0 开始哦

打完收工！就是如此简单，两行代码解决战斗！

嗯，这操作很 Spring Boot！这种感觉就像在《万事开头难？Spring Boot表示不服！》小节讲的一样，Spring Boot 就是想让你只专注于你想专注的事情，其他脏活累活它来帮你完成。其实这些都是基于一个理念——约定由于配置。

约定优于配置

# 5. 总结

这一小节我们学习了 Spring Data JPA 的相关内容，对其特点与用法有了比较全面的认识。并且通过几个小例子进一步巩固了对它的理解。这里只是对 Spring Data JPA 进行了一些初步的学习，其实它还有很多很强大的功能，比如我们可以使用 JPQL 来执行自定义操作，还可以使用原生 SQL 去开发我们想要的功能。这些功能可以通过 @Query 注解来实现，另外还可以像 Mybatis 那样基于 Example 进行查询，或者使用 JPA Query 等高级特性。更多有意思的功能等待你去发现。

[11 每个程序员都应该懂点HTTP](http://www.imooc.com/read/75/article/1807)[13 为互联网而生的持久化框架-Mybatis（一）](http://www.imooc.com/read/75/article/1809)

精选留言 8

欢迎在这里发表留言，作者筛选后可公开显示

- [jaydenwang](http://www.imooc.com/u/2466013/articles)

  问下JPA的方法名必须是表的实体类的属性名拼接而成的么？例如查询只能是findByUser()，user是属性名

   1

  回复

  2020-07-02

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[jaydenwang](http://www.imooc.com/u/2466013/articles)

    是的，必须是属性名，约定由于配置原则。

    回复

    2020-07-02 18:54:03

- [qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

  实体类里面导入依赖出现了问题，两个小时才解决了,真的心塞，我想问老师平时是如何解决问题的呢？有时候不过太诡异了，定位的问题完全不同。 因为实体类里面关于 @Id @GeneratedValue private Integer id; id 是主键，但是关于id的包有两个分别是 import org.springframework.data.annotation.Id; import javax.persistence.*; 选的是第一个，导致各种诡异bug，最终重新敲项目，一步步来，才定位到是包导入错了。 关于问题解决，博主能否给出更多的建议呢？

   1

  回复

  2020-06-27

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    1，犯罪现场会告诉你凶手是谁，同样报错信息也会告诉你问题在哪； 2，你遇到的问题别的网友早就遇到过了，所以善于使用搜索引擎。

    回复

    2020-06-28 20:22:36

  - [高旭大大](http://www.imooc.com/u/5138275/articles)

    回复

    [刘水镜](http://www.imooc.com/u/8840839/articles)

    有问题找百度，![😃](http://www.imooc.com/static/moco/v1.0/images/face/36x36/1f603.png)

    回复

    16小时前

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[高旭大大](http://www.imooc.com/u/5138275/articles)

    哈哈，有时候也需要找谷歌

    回复

    15小时前

  点击展开后面 1 条

- [fenkapian](http://www.imooc.com/u/2143740/articles)

  弱弱的问一下 spring支持spring data jpa吗 还是说spring boot才支持？

   0

  回复

  2020-06-11

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[fenkapian](http://www.imooc.com/u/2143740/articles)

    支持。

    回复

    2020-06-12 20:47:41

- [穆女生](http://www.imooc.com/u/9047671/articles)

  我想问下jpa怎么分页查询的同时进行模糊查询

   0

  回复

  2020-06-11

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[穆女生](http://www.imooc.com/u/9047671/articles)

    可以在 UserRepository 中添加接口，例如：Page findByNameContaining(String name, Pageable pageable); 就可以根据 name 来模糊查询了。

    回复

    2020-06-12 20:46:48

- [江海豪](http://www.imooc.com/u/5637918/articles)

  已经改好了 ,在配置里面 ,我瞎了 .

   0

  回复

  2020-06-01

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[江海豪](http://www.imooc.com/u/5637918/articles)

    棒！

    回复

    2020-06-03 21:29:58

- [江海豪](http://www.imooc.com/u/5637918/articles)

  http://localhost:8080/springboot/rest/user/1 又可以 http://localhost:8080/springboot/hello 又不可以 . springboot能去掉吗??

   0

  回复

  2020-06-01

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[江海豪](http://www.imooc.com/u/5637918/articles)

    项目的 context-path 是 /springboot

    回复

    2020-06-12 20:22:05

- [江海豪](http://www.imooc.com/u/5637918/articles)

  单独下载了 第12章节, 浏览器请求http://localhost:8080/hello 就报 HTTP Status 404 – Not Found

   0

  回复

  2020-06-01

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[江海豪](http://www.imooc.com/u/5637918/articles)

    试试 http://localhost:8080/springboot/hello

    回复

    2020-06-12 20:09:36

- [wmhello](http://www.imooc.com/u/1034002/articles)

  很好 很方便 等待老师更新

   0

  回复

  2020-05-05

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[wmhello](http://www.imooc.com/u/1034002/articles)

    感谢支持，每周一到周五准时更新呦

    回复

    2020-05-12 14:04:20

 

千学不如一看，千看不如一练