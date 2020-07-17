**19 架构师的情人，提升性能的瑞士军刀-Redis (三)**

# 19 架构师的情人，提升性能的瑞士军刀-Redis (三)

更新时间：2020-05-26 11:50:35

![img](http://img1.sycdn.imooc.com/5eba8a0a00019dbd06400360.jpg)

![img](http://www.imooc.com/static/img/column/bg-l.png)![img](http://www.imooc.com/static/img/column/bg-r.png)

书是人类进步的阶梯。

——高尔基

这个小节我们继续学习 Redis，在上个小节里我们学习了 Spring Boot 与 Redis 的整合以及简单的应用。在这一小节中我们将通过一个 Redis 在实际应用中的小案例来深入学习。这个案例就是在互联网业务场景中经常会用到的一个组件——分布式锁。



# 1. 什么是锁



## 1.1 锁的自我修养

作为一个演员要有演员的修养，同样，作为一把锁也要有锁的自我修养。那么下面我们来看一下，作为一把合格的锁，应该具备哪些性质：

1. **互斥**：锁具有独占性，一把锁在同一时刻最多只能有一个持有者；
2. **安全**：安全指的是解锁时的安全性，即只能解锁自己持有的锁；
3. **不死锁**：不能因为意外的发生，导致锁不能被正常释放。



## 1.2 传统锁的局限性

我们都知道 Java 为我们提供了锁相关的 API（synchronized、ReentrantLock 等）。但这些锁存在一定的局限性，在多线程（同一个 JVM）下可以从容应对，但是到了多进程（不同 JVM，甚至干脆不只有 JVM）的情况下，就有些力不从心了（感觉身体被掏空？）。

现在的业务场景早已经不是一个单体应用就能满足的时候了，随随便便就要整个集群搞个分布式啥的，再复杂一点的还会有异构平台的交互。既然传统的锁不能满足分布式应用的场景，于是聪明绝顶的程序员们就搞出来一个新的锁——分布式锁。



# 2. 分布式锁

要在分布式场景下实现锁的功能，那么这个锁就必须是独立于 JVM 之外的了。它必须是一个独立、客观、第三方的东西。那我们该用什么来实现分布式锁呢？往下看！



## 2.1 实现分布式锁的方式

目前市面上对于分布式锁的实现方式主要有以下 3 种方案：

- 数据库（这种方式很少被使用了）
- Redis
- Zookeeper（Chubby，来自谷歌）

> Chubby 是谷歌出品，是专门用来做分布式锁的，原理跟 Zookeeper 有些类似，暂且归为一类吧。据我了解目前国内使用的较少。

以上三种方案中，基于数据库的实现方案已经很少被应用在实际项目中了。原因很简单，性能是它最大的障碍。Redis 和 Zookeeper 这两种方案目前应用的最广泛。在这两者之间个人感觉（仅仅是个人感觉，没有任何证据）基于 Redis 的方案在国内应用更广，根据我胡乱的猜测（仅仅是猜测，依然没有证据）应该是因为用 Redis 实现起来比较简单。



## 2.2 实现原理

不管是哪种实现方案，其原理都差不多，只是所依赖的具体技术不同而已。三种方案都是基于对应技术的两个特性实现的分布式锁。
**基于的两个特性：**

1. 操作的原子性；
2. 资源的唯一性。

**实现的 3 种方案：**

1. **数据库方式：乐观锁/悲观锁 + 唯一约束**
2. **Redis 方式：setnx**
3. **Zookeeper 方式：临时顺序节点**

下面我们具体来看一下基于 Redis 的实现方案吧！



# 3. Redis 实现分布式锁

Redis 实现分布式锁，主要用到了它的一个命令—— SETNX。SETNX 是 **SET** if **N**ot e**X**ists 的缩写，即在指定的 key 不存在时，为 key 设置指定的值。并且当设置成功时返回 1 。 设置失败时返回 0 。因此，我们可以根据返回值来判断加锁是否成功。





## 3.1 第一版

根据上面我们分析 Redis 实现分布式锁的原理，我们先写出一个初始版本的 RedisLock：

```java
@Component
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean lock(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public void unLock(String key) {
        redisTemplate.delete(key);
    }
}
```

> RedisTemplate 中将 Redis 的 SETNX 命令封装成了 setIfAbsent() 方法，返回值也封装成了 Boolean。

下面在我们的业务代码中使用一下我们刚刚完成的 RedisLock：

```java
@RestController
@RequestMapping("/redislock")
public class RedisLockController {

    private final long TIME_OUT = 50 * 1000;

    private final String REDIS_LOCK = "REDIS_LOCK";

    @Autowired
    private RedisLock redisLock;

    @GetMapping("/lock")
    public void lock() {

        // 加锁
        long currentTime = System.currentTimeMillis();
        boolean isLock = redisLock.lock(REDIS_LOCK, String.valueOf(currentTime + TIME_OUT));
        if (!isLock) {
            throw new RuntimeException("资源已被抢占，换个姿势再试试吧！");
        }

        // do something

        // 解锁
        redisLock.unLock(REDIS_LOCK);

    }
}
```

嗯，看起来还不错。但仔细想想这样写会不会有什么问题？

我相信聪明的你已经发现了问题所在，当 lock() 成功以后，在 do something 的过程中出现意外导致后面的 unLock() 没有被执行，那么就会导致其他请求无法再获得锁，从而造成了死锁。所以，它不是一把好锁。



## 3.2 进化版

我们想一下，如何解决上面死锁的问题？

首先，上面代码导致死锁的原因是，一旦程序执行出现意外，就无法删除对应的 key 了，这就会导致 key 会一直存在，最终的结果就是其他线程再也无法获得锁了。那么要解决这个问题就需要在不能删除 key 的情况下，也能够让这个 key 消失。嗯，于是我们可以想到了给 key 加上过期时间。

```java
@Component
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean lockV2(String key, String value,Long timeOut) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, timeOut, TimeUnit.MILLISECONDS);
    }
}
```

> Redis 从 2.6.12 版本开始，让 SETNX 操作的同时可以设置一个过期时间。不过不是直接通过 SETNX 命令实现的，而是通过 SET 命令加上 NX 参数来实现的。

现在这个方案完美了吗？显然还没有。假如有两个线程 A 和 B，在 A 执行完 do something 之后，恰好 key 到了过期时间，又恰好这时 B 获得了锁，那么接下来会发生什么？接下来 A 执行 unLock() 会将 B 获得的锁删掉！防不胜防呀！



## 3.3 再改进

上面我们遇到了一个问题，一个线程删除了不属于它的锁。那么要解决这个问题，就需要在删除之前先判断一下，当前的锁是不是被自己持有，如果是那么删除，如果不是，说明锁已经过期了（此时可能有别的线程持有了锁，也可能没有任何线程持有锁），则不需要再删除了。

```java
@Component
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void unLockV2(String key, String value) {
        String oldValue = redisTemplate.opsForValue().get(key);
        if (Objects.nonNull(oldValue) && oldValue.equals(value)) {
            redisTemplate.delete(key);
        }
    }
}
```

OK，这次我们在删除之前对锁的持有者进行了判断，只有确定自己是锁的持有者才去释放锁。这次看起来没什么毛病了，但是很遗憾，判断持有者的逻辑和删除 key 的逻辑仍然不是一个原子的操作。虽然这两个操作之间的间隔非常短，但仍有可能在这两个操作之间被其他线程干扰。

虽然仍不完美，但相对于上面执行完业务代码后直接删除 key 的方式的可靠性已经提升了 N 个数量级了。因为一般的业务逻辑执行耗时都在几百毫秒上下，而判断所有者的逻辑与删除 key 的逻辑间隔在微秒级别，而时间越短，出错的概率就会越低。



# 4. Redis 分布式锁的其他实现方式

**Lua 脚本**

Redis 通过调用 Lua 脚本，可以实现更加强大与复杂的功能。而且在执行 Lua 脚本的时候操作具有原子性。这恰好可以用来实现分布式锁，上面例子中解锁时的逻辑漏洞可以通过调用 Lua 脚本来避免。

> 通过 RedisTemplate 的 execute() 方法来调用 Lua 脚本

**Redission**

Redission 是一个基于 Redis 的第三方组件，提供了很多强大的功能，也是 Redis 官方推荐的分布式锁解决方案。基于一种叫做 RedLock 的算法实现的分布式锁，比起我们自己实现分布式锁，Redission 更加的安全可靠，所以在生产环境中更加推荐使用 Redission 来作为分布式锁的解决方案。



# 5. 总结

OK，这一节我们一起学习了分布式锁，重点讲解了基于 Redis 的分布式锁实现方式。课下一定要自己动手练习鸭！后面又介绍了两种分布式锁的实现方式，一种是 Redis + Lua；另一种是 Redission。这两种方式作为扩展内容，如果你学有余力可以试着去研究一下，然后我们一起讨论！

[18 架构师的情人，提升性能的瑞士军刀-Redis (二)](http://www.imooc.com/read/75/article/1814)[20 一个数据库连接池的自我修养——Druid](http://www.imooc.com/read/75/article/1816)

精选留言 2

欢迎在这里发表留言，作者筛选后可公开显示

- [weixin_慕尼黑3461692](http://www.imooc.com/u/9118920/articles)

  老师，请教一下，如果do something 还没有完成，锁过期了怎么办

   0

  回复

  5天前

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[weixin_慕尼黑3461692](http://www.imooc.com/u/9118920/articles)

    那就有可能在 do somthing 的时候被其他线程获得锁，可以采用为锁续命的方式来避免这种情况，具体可以参考 Redisson 的实现。

    回复

    4天前

- [慕慕童鞋](http://www.imooc.com/u/8954842/articles)

  循序渐进，深入浅出，学到了。

   0

  回复

  2020-06-25

  - [刘水镜](http://www.imooc.com/u/8840839/articles)

    回复[慕慕童鞋](http://www.imooc.com/u/8954842/articles)

    太好了！

    回复

    2020-06-28 20:27:57

 

千学不如一看，千看不如一练