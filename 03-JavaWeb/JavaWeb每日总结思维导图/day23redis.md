每日总结

redis

概述

非关系型数据库

* 数据之间没有联系

* 数据保存在内存中

关系型数据库

* 数据间有关系

* 数据保存在硬盘

键值对的方式存储在内存中

下载安装官网：[https://redis.io](https://redis.io)

中文网  [https://redis.cn](https://redis.io)

redis.windows.conf 配置文件

redis-server.exe redis服务器端

redis-cli.exe redis的客户端



redis数据结构和持久化

数据结构 

字符串类型String

* set  key value 
* get key 
* del key

LinkedList双向链表 ArrayList数组



哈希类型hash

* hset key field value 
* hget key field
* hgetall key
* hdel key field

列表类型 list

有序有重复

* lpush key value
* rpush key value
* lrange ket start end

集合类型 set

* sadd key value
* 获取set集合中所有的元素 smembers key
* 删除set集合中某个元素 srem key value

有序集合类型 sortedset

不允许重复元素，且元素有顺序

每个元素都会关联一个double类型的分数，通过分数来排序

* zadd ket score value 
* zrange key start end [withscores]
* zrem key value

通用命令

* 查询所有的键 keys *
* 获取键对应的value的类型 type key
* 删除指定的key value del key 

持久化

概念 redis是一个内存数据库 一旦计算机重启

