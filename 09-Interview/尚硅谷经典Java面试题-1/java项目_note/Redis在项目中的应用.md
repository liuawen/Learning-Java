Redis在项目中的使用场景

# String

  比如说 ，我想知道什么时候封锁一个IP地址。Incrby命令  

封锁一个IP地址 Incrby  记录数据

# Hash



Hash

存储用户信息【id，name，age】

Hset(key,field,value)

user  field 

Hset(userKey,id,101)

Hset(userKey,name,admin)

Hset(userKey,age,23)

----修改案例----

Hget(userKey,id)

Hset(userKey,id,102)

为什么不使用String 类型来存储

String   key  value  

Set(userKey,用信息的字符串)

Get(userKey)

全部进行反序列化   我只要修改name

IO操作    IO次数  序列化 反序列化  

Hash

不建议使用String 类型



# List

实现最新消息的排行，还可以利用List的push命令，将任务存在list集合中，同时使用另一个命令，将任务从集合中取出[pop]。

Redis—list数据类型来模拟消息队列。【电商中的秒杀就可以采用这种方式来完成一个秒杀活动】

栈   

push   pop



# Set

特殊之处：可以自动排重。比如说微博中将每个人的好友存在集合(Set)中，

这样求两个人的共通好友的操作。我们只需要求交集即可。

特殊之处  可以自动排重



交集  ∩  

出现一次   

排重



我微博中很多好友  

求都有的好友  交集的命令

set  自动排重  



# Zset

以某一个条件为权重，进行排序。

京东：商品详情的时候，都会有一个综合排名，还可以按照价格进行排名。

sorted  set

可以排序 

以某一个条件为权重  进行排序

京东 商品详情的时候 都会有一个综合排名

可以按照价格进行排名 

