# 第21讲：Redis读取请求数据后，如何进行协议解析和处理?

2019/10/29 陈波

 

4.08M

00:00/02:13

 

 

看视频

你好，我是你的缓存课老师陈波，欢迎进入第 21 课时“Redis 协议解析及处理”的学习。上一课时，我们学习了 Redis 事件驱动模型，接下来，看一下 Redis 是如何进行协议解析及处理的。

# Redis 协议解析及处理

## 

###### 协议解析

上一课时讲到，请求命令进入，触发 IO 读事件后。client 会从连接文件描述符读取请求，并存入 client 的 query buffer 中。client 的读缓冲默认是 16KB，读取命令时，如果发现请求超过 1GB，则直接报异常，关闭连接。

![img](http://s0.lgstatic.com/i/image2/M01/A1/20/CgoB5l236leAQe3lAACYuua9lLs344.png)

client 读取完请求命令后，则根据 query buff 进行协议解析。协议解析时，首先查看协议的首字符。如果是 *，则解析为字符块数组类型，即 MULTIBULK。否则请求解析为 INLINE 类型。

 

INLINE 类型是以 CRLF 结尾的单行字符串，协议命令及参数以空格分隔。解析过程参考之前课程里分析的对应协议格式。协议解析完毕后，将请求参数个数存入 client 的 argc 中，将请求的具体参数存入 client 的 argv 中。

## 

###### 协议执行

请求命令解析完毕，则进入到协议执行部分。协议执行中，对于 quit 指令，直接返回 OK，设置 flag 为回复后关闭连接。

![img](http://s0.lgstatic.com/i/image2/M01/A1/40/CgotOV236liAP-kPAAC0HQZ_GbA559.png)

对于非 quit 指令，以 client 中 argv[0] 作为命令，从 server 中的命令表中找到对应的 redisCommand。如果没有找到 redisCommand，则返回未知 cmd 异常。如果找到 cmd，则开始执行 redisCommand 中的 proc 函数，进行具体命令的执行。在命令执行完毕后，将响应写入 client 的写缓冲。并按配置和部署，将写指令分发给 aof 和 slaves。同时更新相关的统计数值。

 

00:00

 300分钟吃透分布式缓存

 

精选留言

![img](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADgAAAA4CAMAAACfWMssAAAAQlBMVEVHcEz////////////////////////////////////////////////////////////////////////////////////1bZCPAAAAFXRSTlMABXr6G42y5qbwMrwNPSfInFVoR9iQpPcJAAAB90lEQVRIx51W27pGIBBNpYMQxfu/6m7K9hOdrKs+TLPmtAZCLxgtFppLQiTXAtsRVYFivUfQmBbNBra/gg1VZpJhs07zPK0GM1k0pewgNnXXx910kGcJwpb7t9Pbu8nfye3bO5znE6LAzwooCM3mEmAhWBXVpoP7dCHpFEJlt/jR4h71XbFYvftsiR/0Nd0RfbjGF6UB1NYzMa4OAlVCuKqMP/98rDUELwfZmVy8l+HiIrM/uQoy1ABXOeUdnjdUAhjOIcImh94lRMmbIjyi5K55XYuObYaja9oBhuJXQyo4FzR/DrXE0ArmtPPDLmnuDDDQaBrc/m4CiNzZz6abJMjNGSIPH/Dc2QcJZ8eiazXsHG9EdoJaqXqjq8fa5HiP277T1nJQoH3Nai18Vq91rIWvo6lWjZsKGHDL0ZdehezYL9MB8yg+zeNnBYALmlyqQ3MgPfv0ReVuGtuiq74Va8nCWvt5WWt3ThiU9b6EcO22wvFeXYr7sXvsx7DJWWEjz34jvwS986wyr/K5yf9pZFI0ASeCUzeS1B+H8mqV6BPqmvAtJbbfglglu0Qehlap3thhHuyKe0UOjcsoTDAM0UYQ2QHyhsMWGxFlCoUCjcXATJtebVxKvqkl+pdMGepk0guGDluzzgbDil+6B3jqX7YELJdqJfgD9AsxxdatANkAAAAASUVORK5CYII=)写留言

学习知识要善于思考，思考，在思考。—爱因斯坦