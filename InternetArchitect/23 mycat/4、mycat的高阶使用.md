# 4、mycat的高阶使用

### 1、mycat的高可用			

​		在之前的操作中，我们已经实现了mysql机器的高可用，可以动态切换master，那么如果mycat崩溃了呢？我们应该如何处理呢？所以此时就需要搭建mycat的高可用集群了。

​		在mycat的权威指南中，介绍了多种高可用的方案，在这里我们讲解一种使用最多的方案，使用HAProxy+Keepalived配合使用来实现myact的高可用。

​		HAproxy实现了mycat多借点的集群高可用和负载均衡，而HAProxy自身的高可用则可以通过Keepalived来实现。

![image-20200626204106407](F:\lian\mycat\image\mycat高可用.png)

​		好了，如果这个图大家看明白的话，下面我们开始规划集群并进行实操。

| 编号 | 角色               | IP地址         | 机器名 |
| ---- | ------------------ | -------------- | ------ |
| 1    | mycat1             | 192.168.85.111 | node01 |
| 2    | mycat2             | 192.168.85.112 | node02 |
| 3    | HAProxy(master)    | 192.168.85.113 | node03 |
| 4    | Keepalived(master) | 192.168.85.113 | node03 |
| 5    | HAProxy(backup)    | 192.168.85.114 | node04 |
| 6    | keepalived(backup) | 192.168.85.114 | node04 |

#### 1、安装配置HAProxy		

```
1、准备好HAProxy的安装包
2、解压到/usr/local目录
3、进入到解压后的目录，查看内核版本，进行编译
	cd cd /usr/local/haproxy-1.8.25/
	uname -r
	make TARGET=linux26
4、编译完成之后，开始进行安装
	make install PREFIX=/usr/local/haproxy
5、安装完成之后，创建目录，创建HAProxy配置文件
	mkdir -p /usr/data/haproxy
	vi /usr/local/haproxy/haproxy.conf
6、向配置文件中添加配置信息
	global
		log 127.0.0.1 local0
		#log 127.0.0.1 local1 notice
		#log loghost local0 info
		maxconn 4096
		chroot /usr/local/haproxy
		pidfile /usr/data/haproxy/haproxy.pid
		uid 99
		gid 99
		daemon
		#debug
		#quiet
defaults
		log global
		mode tcp
		option abortonclose
		option redispatch
		retries 3
		maxconn 2000
		timeout connect 5000
		timeout client 50000
		timeout server 50000
listen proxy_status
	bind :48066
		mode tcp
		balance roundrobin
		server mycat_1 192.168.85.111:8066 check inter 10s
		server mycat_2 192.168.85.112:8066 check inter 10s
frontend admin_stats
	bind :7777
		mode http
		stats enable
		option httplog
		maxconn 10
		stats refresh 30s
		stats uri /admin
		stats auth admin:123123
		stats hide-version
		stats admin if TRUE
7、启动haproxy服务
	/usr/local/haproxy/sbin/haproxy -f /usr/local/haproxy/conf/haproxy.conf
8、查看haproxy的进程，如果存在则说明没有问题
	ps -ef | grep haproxy
9、打开浏览器访问,用户名为admin，密码为123123
	http://192.168.85.113:7777/admin
```

#### 2、在node04上按照上述一样的步骤创建HAProxy

#### 3、安装配置Keepalived

```
1、准备好Keepalived安装包
2、解压到/usr/local目录
3、安装需要依赖的环境组件
	yum install gcc openssl-devel popt-devel -y
4、进入到解压目录，进行编译
	./configure --prefix=/usr/local/keepalived
5、编译完成之后，进行安装
	make && make install
6、将keepalived的服务注册为系统服务
	cp /usr/local/keepalived-1.4.5/keepalived/etc/init.d/keepalived /etc/init.d/
	mkdir /etc/keepalived
	cp /usr/local/keepalived/etc/keepalived/keepalived.conf /etc/keepalived/
	cp /usr/local/keepalived-1.4.5/keepalived/etc/sysconfig/keepalived /etc/sysconfig/
	cp /usr/local/keepalived/sbin/keepalived /usr/sbin/
7、修改配置文件
	cd /usr/local/keepalived/etc/keepalived/
	vi keepalived.conf
	
	! Configuration File for keepalived

global_defs {
   notification_email {
     acassen@firewall.loc
     failover@firewall.loc
     sysadmin@firewall.loc
   }
   notification_email_from Alexandre.Cassen@firewall.loc
   smtp_server 127.0.0.1
   smtp_connect_timeout 30
   router_id LVS_DEVEL
   vrrp_skip_check_adv_addr
   vrrp_garp_interval 0
   vrrp_gna_interval 0
}

vrrp_instance VI_1 {
    state MASTER
    interface eth0
    virtual_router_id 51
    priority 100
    advert_int 1
    authentication {
        auth_type PASS
        auth_pass 1111
    }
    virtual_ipaddress {
        192.168.85.100
    }
}

virtual_server 192.168.85.100 48066 {
    delay_loop 6
    lb_algo rr
    lb_kind NAT
    persistence_timeout 50
    protocol TCP

    real_server 192.168.85.113 48066 {
        weight 1
        TCP_CHECK {
            connect_timeout 3
            retry 3
            delay_before_retry 3
        }
    }
    real_server 192.168.85.114 48066 {
        weight 1
        TCP_CHECK {
            connect_timeout 3
            retry 3
            delay_before_retry 3
        }
    }
}
8、启动keepalived
	service keepalived start
9、登录验证
	mysql -uroot -p123456 -h 192.168.85.100 -P 48066
```

#### 4、在node04上执行相同的操作安装keepalived

​		注意，需要修改状态为BACKUP

#### 5、验证高可用

​		先进行登录访问，随便找一台机器执行

​		mysql -uroot -p123456 -P48066 -h192.168.85.100

​		然后观察访问的是哪一台mycat，关闭掉mycat，在进行查询即可。

### 2、mycat的安全管理

#### 1、权限配置

​		1、user标签权限控制

​		目前mycat对于中间件的连接控制并没有做太复杂的控制，目前只做了中间件逻辑库级别的读写控制权限，可以通过user标签进行配置。

​		标签说明：

| 标签属性 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| name     | 应用链接中间件逻辑库的用户名                                 |
| password | 该用户对应的密码                                             |
| schemas  | 应用当前连接的逻辑库中所对应的逻辑表，schemas中可以配置一个或者多个 |
| readonly | 应用连接中间件逻辑库所具有的权限。true为只读，false为读写都有，默认是false |

​		添加配置：

```xml
	<user name="root" defaultAccount="true">
		<property name="password">123456</property>
		<property name="schemas">TESTDB</property>
	</user>
	<user name="mycat">
		<property name="password">mycat</property>
		<property name="schemas">TESTDB</property>
		<property name="readOnly">true</property>
	</user>
```

​		尝试通过不同的用户名称进行登录，会发现root用户具有所有的权限，但是mycat用户只是具备了查询的权限，无法完成更新和插入的操作。

​		2、privileges标签权限控制

​		在user标签下的privileges标签可以对逻辑库，表进行更加细致的DML权限控制。

​		privileges标签下的check属性，如果值为true则表示开启权限检查，false则表示不开启权限检查

​		由于mycat一个用户的schemas属性可以配置多个逻辑库，所以privileges的下级节点schema节点同样可配置多个，对多库多表进行细粒度的DML权限控制

​		配置权限：

| DML权限 | 增加 | 更新 | 查询 | 删除 |
| ------- | ---- | ---- | ---- | ---- |
| 0001    | 禁止 | 禁止 | 禁止 | 允许 |
| 0010    | 禁止 | 禁止 | 允许 | 禁止 |
| 0100    | 禁止 | 允许 | 禁止 | 禁止 |
| 1000    | 允许 | 禁止 | 禁止 | 禁止 |

​		修改server.xml文件

```xml
<user name="mycat">
		<property name="password">mycat</property>
		<property name="schemas">TESTDB</property>
		<privileges check="true">
			<schema name="TESTDB" dml="1111">
				<table name="orders" dml="0000"></table>
			</schema>
		</privileges>
	</user>
```

​		大家可以进行相关的测试，当使用mycat用户进行登录的时候会发现其他的表都可以做增删改查操作，但是orders表什么操作都做不了，这就是对权限作了控制。

#### 2、SQL拦截

​		firewall标签用来定义防火墙，firewall下whitehost标签用来定义IP白名单，blacklist用来定义SQL黑名单。

​		1、白名单

​		可以通过设置白名单，实现某主机某用户可以访问mycat，而其他主机用户禁止访问。

```xml
	<firewall>
		<whitehost>
			<host host="192.168.85.111" user="mycat"></host>
		</whitehost>
	</firewall>
```

​		此时发现，用户可以在node01上使用mycat用户进行登录访问，其他用户都不可以，其他主机也不可以。

​		2、黑名单

​		用户还可以通过设置黑名单，实现mycat对具体sql操作的拦截，如增删改查等操作的拦截

```xml
<blacklist check="true">
	<property name="deleteAllow">false</property>
</blacklist>
```

​		此时用户登录之后发现无法删除表中的数据，这就是黑名单的作用。

​		黑名单SQL拦截功能列表：

| 配置项            | 默认值 | 功能                             |
| ----------------- | ------ | -------------------------------- |
| selectAllow       | true   | 是否允许执行select语句           |
| selectColumnAllow | true   | 是否允许执行select *操作         |
| selectIntoAllow   | true   | 是否允许select语句中包含into子句 |
| deleteAllow       | true   | 是否允许执行delete语句           |
| updateAllow       | true   | 是否允许执行update语句           |
| insertAllow       | true   | 是否允许执行insert语句           |
| replaceAllow      | true   | 是否允许执行replace语句          |
| createTableAllow  | true   | 是否允许创建表                   |
| setAllow          | true   | 是否允许使用set语法              |
| truncateAllow     | true   | 是否允许执行truncate语句         |
| alterTableAllow   | true   | 是否允许执行alter table语句      |
| dropTableAllow    | true   | 是否允许修改表                   |
| commitAllow       | true   | 是否允许执行commit操作           |
| rollbackAllow     | true   | 是否允许执行rollback操作         |
| useAllow          | true   | 是否允许执行use语句              |
| describeAllow     | true   | 是否允许执行describe操作         |
| showAllow         | true   | 是否允许执行show语句             |

### 3、mycat监控工具

​		mycat-web是mycat可视化运维管理和监控平台，弥补了mycat在监控上的空白。帮mycat分担统计任务和配置管理任务。mycat-web引入了zookeeper作为配置中心，可以管理多个节点。mycat-web主要管理和监控mycat的流量、连接、活动现成和内存等，具备IP白名单、邮件告警等模块，还可以统计SQL并分析慢SQL和高频SQL等，为SQL的优化提供了依据。

#### 		1、安装zookeeper

```
1、下载zookeeper安装包
2、安装拷贝到/usr/local目录，并解压
3、进入到zookeeper解压后的目录conf,复制配置文件并改名
	cp zoo_sample.cfg zoo.cfg
4、进入到zookeeper的bin目录，运行启动命令
	./zkServer.sh start
5、执行如下命令，看zookeeper是否正常启动
	netstat -nlpt | grep 2181
```

#### 		2、安装mycat-web

```
1、下载mycat-web安装包
2、解压安装包到/usr/local目录
3、进入mycat-web的目录运行启动命令
	./start.sh &
4、mycat-web的服务端口是8082，查看服务是否启动
	netstat -nlpt | grep 8082
5、通过地址访问服务
	192.168.85.111:8082/mycat/
```

#### 		3、mycat-web配置

```
1、配置zookeeper
	进入到mycat-web的/usr/local/mycat-web/mycat-web/WEB-INF/classes，修改mycat.properties文件，可以修改zookeeper的地址
2、添加mycat实例
	在页面的mycat配置--》mycat服务管理中添加mycat实例，需要填写相关的参数
```

#### 		4、mycat配置使用

​		在mycat的web监控系统中，很多参数及监控可以自己来完善，大家尽情去试就好了。

### 4、mycat原理

​		学到这里同学们其实应该有感受了，mycat的操作使用并不是很难，我们只需要配置和修改server.xml.rule.xml.schema.xml三个文件即可，但是如果想在生产环境中使用的话，还是需要下一番功夫的，在准备这套课程的时候我也想过找一些生产环境中的案例给大家做一个演示，但是发现没有特别合适的案例，这块的实操我们会放到P8课程中给大家进行讲解，下面我们来简单说一下mycat的原理。

​		mycat在逻辑上由几个模块组成：通信协议、路由解析、结果集处理、数据库连接、监控等模块

![image-20200703190120509](F:\lian\mycat\mycat各模块交互.png)

​		1、通信协议模块

​		通信协议模块承担底层的收发数据、现成回调处理工作，主要采用Reactor、Proactor模式来提高效率。目前。mycat通信模块默认采用Reactor模式，在协议层采用mysql协议。 

​		2、路由解析模块

​		路由解析模块负责对传入的SQL语句进行语法解析，解析从MYSQL协议中解析出来并进入该模块的SQL语句的条件、语句类型、携带的关键字等，对符合要求的SQL语句进行相关优化，最后根据这些路由计算单元进行路由计算。

​		3、结果集处理模块

​		结果集处理模块负责对跨分片的结果进行汇聚、排序、截取等。由于数据存储在不同的数据库中，所以对跨分片的数据需要进行汇聚。

​		4、数据库连接模块

​		数据库连接模块复制创建、管理、维护后端的连接池。为了减少每次建立数据库连接的开销，数据库使用连接池机制对连接生命周期进行管理。

​		5、监控管理模块

​		监控管理模块负责对Mycat中的连接、内存等资源进行等监控和管理。监控主要是通过管理命令实时地展现一些监控数据，例如连接数、缓存命中数等；管理则主要通过轮训事件来检测和释放不适用的资源。

​		6、SQL执行模块

​		SQL执行模块负责从连接池中获取相应的目标连接，对目标连接进行信息同步后，再根据路由解析的结果，把SQL语句分发到相应的节点执行。

​		总体执行流程如下：

​		由通信协议模块的读写事件通知发起。读写事件通知具体的回调代码进行这次读写事件的处理。管理模块的执行流程由定时器事件进行资源检查和资源释放时发起。

​		由客户端发送过来的数据通过协议解析、路由解析等流程进入执行组件，通过执行组件把数据发送到通信协议模块，最终数据被写入目标数据库。

​		后端数据库返回数据，通过协议解析后发送至回调模块。如果是涉及多节点的数据，则执行流程将会先进入结果集汇聚、排序等模块中，然后将处理后的数据通过通信协议模块返回到客户端。

![image-20200705150407895](F:\lian\mycat\image\mycat流程.png)

​		通过上述图片大家发现了，在mycat的执行流程中，AIO、NIO、多线程、内存管理等各个方面都用到了，大家如果想看mycat的源码的话，最好能具备以上的基础，在咱们这套课程中就不在讲解源码了，mycat的源码在面试过程中也几乎不会用到，如果大家有兴趣的话，可以自行学习。

#### 

​		