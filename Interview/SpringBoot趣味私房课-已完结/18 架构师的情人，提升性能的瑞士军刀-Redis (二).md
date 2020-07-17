**18 架构师的情人，提升性能的瑞士军刀-Redis (二)**

# 18 架构师的情人，提升性能的瑞士军刀-Redis (二)

更新时间：2020-05-26 11:48:56

![img](http://img3.sycdn.imooc.com/5eba898c0001215506400359.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

读一本好书，就是和许多高尚的人谈话。

——歌德



# 1. 书接上回

上一小节我们一起学习了 Redis 的数据结构、各种特性以及 Redis 的各种应用场景。按照老规矩，这一节我们就要开始动手实战了。在实战之前，你需要在你的机器上按照好 Redis。



Redis的数据结构  

各种特性

Redis的各种应用场景 



## 安装 Redis

如果你用的是 Mac，那么你只需要通过下面的命令即可安装好 Redis：

```bash
brew install redis
```

如果你用的是 Windows，那么你可以去 [GitHub](https://github.com/microsoftarchive/redis) 上下载 Windows 版本的 Redis 进行安装（非官方版本）。或者安装虚拟机，在虚拟机中跑一个 Linux 然后按照 [Redis 官网](https://redis.io/download)上面的方法去安装。

最新版的 Windows 10 中集成了一个 Linux 子系统，据说可以在里面跑 Redis，有兴趣研究的可以戳[教程](https://redislabs.com/blog/redis-on-windows-10/)，自行折腾。

通过以下命令来启动并登录 Redis：

```bash
# 启动
redis-server

# 登录
redis-cli
```

然后，可以通过 PING 命令来测试一下：

```base
127.0.0.1:6379> ping
PONG
127.0.0.1:6379>
```

如上面所示返回一个 PONG，则说明 Redis 一切正常，可以使用了。



# 2. 动手

环境准备好以后，下面我们就开始动手实践了。首先我们需要将 Redis 集成到我们的工程之中，下面我们一起一步步操作吧。



## 2.1 集成

按照 Spring Boot 一贯的风格，添加一个新功能的时候，我们首先要做的就是引入对应的 Starter 依赖。



### 添加依赖

在 pom.xml 文件中添加如下依赖：

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-redis</artifactId>
  <exclusions>
    <exclusion>
      <groupId>io.lettuce</groupId>
      <artifactId>lettuce-core</artifactId>
    </exclusion>
  </exclusions>
</dependency>
<dependency>
  <groupId>redis.clients</groupId>
  <artifactId>jedis</artifactId>
</dependency>
```

> lettuce 是 Spring Boot 默认的 Redis 客户端，我们将它的依赖移除，换成我们最常用的 Jedis 依赖。



### 添加配置

添加完依赖以后，我们还需要添加一些 Redis 的相关配置，以便我们的工程可以找到我们刚刚安装的 Redis。具体配置如下：

```yaml
spring:
  ......
  redis:
    host: localhost
    port: 6379
    timeout: 1000
    jedis:
      pool:
        min-idle: 5
        max-active: 10
        max-idle: 10
        max-wait: 2000
```

配置很简单，理解起来没什么难度，就不一一讲解了。其实不写上面的配置，接下来的程序也可以正常执行，你知道为什么吗？



## 2.2 Hello Redis

经过上面的配置，Redis 已经准备就绪了。万事俱备，就差代码了，下面我们就搞一个 Redis 的 Hello World 来看看效果吧。

```java
// 配置 StringRedisTemplate
@Bean
public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
  StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory);
  return stringRedisTemplate;
}


@Autowired
private StringRedisTemplate stringRedisTemplate;

@GetMapping("/hello")
public String hello() {
	// 向 Redis 中添加一个 key 为 hello，Value 为 world 的记录
    stringRedisTemplate.opsForValue().set("hello","world");
    
    // 获取 Redis 中 key 为 hello 的值
    return stringRedisTemplate.opsForValue().get("hello");
}
```

启动我们的工程，访问 RedisController 中的 hello 接口，可以看到接口返回了字符串 world

然后我们再去 Redis 中验证一下，在命令行中通过 get 命令来看一看 key 为 hello 的值：

```bash
127.0.0.1:6379> get hello
"world"
127.0.0.1:6379>
```

OK，验证成功。



# 3. 详解

在上面的例子中，有两个东西，我们需要了解一下：StringRedisTemplate 和 ValueOperations（opsForValue() 方法返回的对象类型）。下面我们一起来看一下这两个家伙吧。



## 3.1 Template

Spring 将操作 Redis 的 API 封装成了 Template，我们使用最多的就是上面例子中的那个 StringRedisTemplate，还有一个是 RedisTemplate。StringRedisTemplate 用于 Key 和 Value 都是字符串的情况，这也是我们平时使用最多的场景。字符串的好处在于简单并且对人类比较友好（不需要任何转换就能看懂，不像二进制的数据那样，这一点在排查问题的时候尤为突出），而 RedisTemplate 则是一个相对通用的 API，不仅可以处理字符串的情况，还可以处理自定义对象等复杂类型。RedisTemplate 默认是采用 JDK 的序列化方式来转换对象的，当然我们还可以根据需要自定义序列化的方式。

> Redis 允许 Key 和 Value 是任意二进制形式，但最好还是使用字符串作为 Key-Value 的形式，这样容易通过 Redis 客户端查看和管理（便于排查问题）。JSON 方式也是一种不错的方式，可以将 Value 序列化成 JSON 字符串。

```java
public class StringRedisTemplate extends RedisTemplate<String, String> {

   public StringRedisTemplate() {
      setKeySerializer(RedisSerializer.string());
      setValueSerializer(RedisSerializer.string());
      setHashKeySerializer(RedisSerializer.string());
      setHashValueSerializer(RedisSerializer.string());
   }

   ......
}
```

通过查看 StringRedisTemplate 的源码可以知道，它继承了 RedisTemplate ，然后在构造方法中将序列化策略全部设置成了字符串类型。



### 3.2 opsFor

上面的例子中除了 StringRedisTemplate 类以外，还有一个 opsForValue() 方法，该方法返回一个 ValueOperations 对象。除了 opsForValue() 以外，还有另外五个方法：opsForHash()、opsForList()、opsForSet()、opsForZSet()、opsForGeo()，分别返回以下对象：ValueOperations、HashOperations、ListOperations、SetOperations、ZSetOperations、GeoOperations。

从名字就可以看出这些对象分别对应了 Redis 的几种数据结构，而它们的功能就是对这些不同的数据结构进行各种操作。

例如上面例子中的：

```
stringRedisTemplate.opsForValue().set("hello","world");
return stringRedisTemplate.opsForValue().get("hello");
```

其实就相当于在 Redis 进行如下操作：

```bash
127.0.0.1:6379> set hello world
127.0.0.1:6379> get hello
```



### 3.3 绑定 Key 操作

上面的例子中每进行一次操作，就需要传一次 key，在对同一个 key 进行较少操作的情况下，这样做没什么。但是如果需要对同一个 key 进行多次操作，这样就显得麻烦了。为了解决这个问题，Spring 为我们提供了 boundxxxOps() 方法，对应返回 BoundxxxOperations 类型的对象。

我们基于上面的例子使用 bound 的方式改进一下，看看效果：

```java
BoundValueOperations<String, String> boundValueOps = stringRedisTemplate.boundValueOps("hello");
boundValueOps.set("world");
boundValueOps.get();
```

很简单，其实就是对于同一个 key 多次操作的一种优化。让代码写起来更加简洁一些。跟 opsForxxx() 方法（xxxOperations 对象）一样，boundxxxOps() 方法（BoundxxxOperations 对象）也提供了对应 Redis 各种数据结构的方法（对象），具体见下表：

| 方法          | 对象                 | 描述                                           |
| :------------ | :------------------- | :--------------------------------------------- |
| boundValueOps | BoundValueOperations | Value 相关操作，如 set、get、append、incr 等   |
| boundHashOps  | BoundHashOperations  | Hash 相关操作，如 hset、hget、hkeys 等         |
| boundListOps  | BoundListOperations  | List 相关操作，如 lpush 、rpush、lpop、rpop 等 |
| boundSetOps   | BoundSetOperations   | Set 相关操作，如 sadd、spop 等                 |
| boundZSetOps  | BoundZSetOperations  | Sorted Set 相关操作，如 zadd、zcount 等        |
| boundGeoOps   | BoundGeoOperations   | Geo ，地理信息相关操作，如 geoadd、geopos 等   |



### 3.4 序列化策略

在讲 Template 的时候，我们提到了序列化策略，并且我们知道 RedisTemplate 默认使用的 JDK 的序列化方式。我们来看一下 RedisTemplate 的源码：

```java
public class RedisTemplate<K, V> extends RedisAccessor implements RedisOperations<K, V>, BeanClassLoaderAware {

	......

	@Override
	public void afterPropertiesSet() {

		super.afterPropertiesSet();

		boolean defaultUsed = false;

		if (defaultSerializer == null) {

			defaultSerializer = new JdkSerializationRedisSerializer(
					classLoader != null ? classLoader : this.getClass().getClassLoader());
		}

		if (enableDefaultSerializer) {

			if (keySerializer == null) {
				keySerializer = defaultSerializer;
				defaultUsed = true;
			}
			if (valueSerializer == null) {
				valueSerializer = defaultSerializer;
				defaultUsed = true;
			}
			if (hashKeySerializer == null) {
				hashKeySerializer = defaultSerializer;
				defaultUsed = true;
			}
			if (hashValueSerializer == null) {
				hashValueSerializer = defaultSerializer;
				defaultUsed = true;
			}
		}

	......

}
```

可以看到在 afterPropertiesSet() 方法中，如果没有指定序列化策略时，默认会把所有 key 和 value 的的序列化策略全部设置成 JDK 的方式。该方法会在容器启动时（Spring Boot 执行自动配置时）被调用。

所有的序列化策略都实现了 RedisSerializer 接口，我们再来看一下这个接口的源码：

```java
public interface RedisSerializer<T> {

	// 序列化
	@Nullable
	byte[] serialize(@Nullable T t) throws SerializationException;

	// 反序列化
	@Nullable
	T deserialize(@Nullable byte[] bytes) throws SerializationException;
  
  ......

}
```

这个接口定义了两个核心方法，一个是 serialize() 用来将对象转成字节数组（也就是序列化的过程）；另一个便是 deserialize() 用来将字节数组转成对象（也就是反序列化的过程）。

接下来我们看一下使用 JDK 的序列化策略以后，在 Redis 中 key 和 value 是什么样的，使用 RedisTemplate 向 Redis 中添加一个记录：

```java
redisTemplate.opsForValue().set("key","value");
```

然后我们在命令行执行 get key 来获取一下，看看什么效果：

```bash
127.0.0.1:6379> get key
(nil)
```

结果我们发现并没有 “key” 这个键，但是我们明明已经设置了，那么我们执行一下 keys 命令，看看现在 Redis 中有什么 key：

```bash
127.0.0.1:6379> keys *
1) "\xac\xed\x00\x05t\x00\x03key"
```

我们看到了一串好像乱码的东西，那么我们获取一下这个“乱码” key 的 value 看看会出现什么：

```bash
127.0.0.1:6379> get "\xac\xed\x00\x05t\x00\x03key"
"\xac\xed\x00\x05t\x00\x05value"
```

OK，获取到的 value 跟 key 长得差不多，这一“乱码”就是 JDK 化后的结果，内容包含两部分：

- 前面的“乱码”是对象的描述信息
- 后面可以看懂的内容是对象的实际内容



# 4. 总结

OK，这一小节中我们一起动手实战了 Spring Boot 中整合 Redis，并且一起做了几个小的实验。还一起看了一些关键类的源码。例子中我们只对简单的字符串进行了实验，希望你课下会继续探索其他类型，看看有哪些异同，还可以试试如何通过 RedisTemplate 删除 key，或者给 key 设置过期时间等等。有很多好玩的玩法在等着你，不要偷懒哦。



删除key  key设置过期时间  

[17 架构师的情人，提升性能的瑞士军刀-Redis (一)](http://www.imooc.com/read/75/article/1813)[19 架构师的情人，提升性能的瑞士军刀-Redis (三)](http://www.imooc.com/read/75/article/1815)

精选留言 3

欢迎在这里发表留言，作者筛选后可公开显示

- [qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

  老师，什么时候讲讲分布式缓存，特别期待

   0

  回复

  2020-06-21

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    可以单独给你讲呀。

    回复

    2020-06-22 20:27:06

  - [慕田峪4063386](http://www.imooc.com/u/6226285/articles)

    回复[qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    这么暖

    回复

    7天前

- [慕田峪4063386](http://www.imooc.com/u/6226285/articles)

  还有一个疑问，你说jedis 但是我怎么感觉是spring data redis 呢

   0

  回复

  2020-06-10

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕田峪4063386](http://www.imooc.com/u/6226285/articles)

    spring data 底层还是通过 jedis 与 redis 交互的。

    回复

    2020-06-10 23:22:41

  - [qq_Sophia_20](http://www.imooc.com/u/4429399/articles)

    回复[慕田峪4063386](http://www.imooc.com/u/6226285/articles)

    jedis 是操作redis的客户端，这个东西比较老了 现在不都是用lettuce 么

    回复

    2020-06-21 09:59:13

- [慕田峪4063386](http://www.imooc.com/u/6226285/articles)

  之前一直在用redis ，文章里的名词也都见过，看了您的文章，将这一切都梳理通了，给你大大的赞！

   0

  回复

  2020-06-10

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕田峪4063386](http://www.imooc.com/u/6226285/articles)

    感谢支持。

    回复

    2020-06-10 23:22:51

 

千学不如一看，千看不如一练