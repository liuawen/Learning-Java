# 3、mycat分库分表实战

​		之前我们已经讲解过了数据的切分，主要有两种方式，分别是垂直切分和水平切分，所谓的垂直切分就是将不同的表分布在不同的数据库实例中，而水平切分指的是将一张表的数据按照不同的切分规则切分在不同实例的相同名称的表中。

​		下面先来描述mycat的分库操作,在进行分库操作的时候需要注意一点：**有关联关系的表应该放在一个库里，相互没有关联关系的表可以分到不同的库中。**

​		数据文件

```sql
--客户表 
CREATE TABLE customer(
id INT AUTO_INCREMENT,
NAME VARCHAR(200),
PRIMARY KEY(id)
);
--订单表 
    CREATE TABLE orders(
    id INT AUTO_INCREMENT,
    order_type INT,
    customer_id INT,
    amount DECIMAL(10,2),
    PRIMARY KEY(id)
        );
--订单详细表 
CREATE TABLE orders_detail(
id INT AUTO_INCREMENT,
detail VARCHAR(2000),
order_id INT,
PRIMARY KEY(id)
);
--订单状态字典表 
CREATE TABLE dict_order_type(
id INT AUTO_INCREMENT,
order_type VARCHAR(200),
PRIMARY KEY(id)
);
```

### 1、分库实战

​		在上述的数据文件中，我们包含四个不同的表，现在将不同的表分布在不同的库中，但是访问的时候使用的是同一个mycat的终端，这些操作其实很简单，都是由mycat来完成的，我们需要做的事情就是修改几个简单的配置即可。

​		1、修改schema.xml文件

```xml
<?xml version="1.0"?>
<!DOCTYPE mycat:schema SYSTEM "schema.dtd">
<mycat:schema xmlns:mycat="http://io.mycat/">
	<schema name="TESTDB" checkSQLschema="false" sqlMaxLimit="100" dataNode="dn1">
		<table name = "customer" dataNode="dn2"></table>
	</schema>
	<dataNode name="dn1" dataHost="host1" database="orders" />
	<dataNode name="dn2" dataHost="host2" database="orders"/>
	<dataHost name="host1" maxCon="1000" minCon="10" balance="0"
			  writeType="0" dbType="mysql" dbDriver="native" switchType="1"  slaveThreshold="100">
		<heartbeat>select user()</heartbeat>
		<writeHost host="hostM1" url="192.168.85.111:3306" user="root"
				   password="123456">
		</writeHost>
	</dataHost>
	<dataHost name="host2" maxCon="1000" minCon="10" balance="0" writeType="0" dbType="mysql" dbDriver="native" switchType="1" sla
veThreshold="100">		<heartbeat>select user()</heartbeat>
		<writeHost host="hostM2" url="192.168.85.113:3306" user="root" password="123456"></writeHost>
	</dataHost>
</mycat:schema>
```

​		2、在两个数据节点上分别创建orders数据库

​		3、启动mycat的服务

```sql
mysql -uroot -p123456 -h 192.168.85.111 -P8066
```

​		4、插入sql语句

​		执行上述的建表语句，会发现，customer在node03上，而其他的表在node01上，此时完成了分库的功能。

​		在插入完成之后会发现，有的表名是大写的，有的表名是大写的，大家需要注意，这个是一个小问题，需要在mysql的配置文件中添加lower_case_table_names=1参数，来保证查询的时候能够进行正常的查询。

### 2、分表实战

​		相对于垂直拆分，水平拆分不是将表做分类，而是按照某个字段的某种规则来分散到多个库之中，每个表中 包含一部分数据。简单来说，我们可以将数据的水平切分理解为是按照数据行的切分，就是将表中的某些行切分 到一个数据库，而另外的某些行又切分到其他的数据库中 。

​		**1、拆分orders表，在进行拆分的时候必须要指定拆分规则，在此实例中，我们选择把customer_id按照取模运算进行数据拆分**

​		1、修改schema.xml文件

```xml
	<schema name="TESTDB" checkSQLschema="false" sqlMaxLimit="100
" dataNode="dn1">		<table name = "customer" dataNode="dn2"></table>
		<table name ="orders" dataNode="dn1,dn2" rule="mod_ru
le"></table>	</schema>
```

​		2、修改rule.xml文件

```xml
<tableRule name="mod_rule">
		<rule>
			<columns>customer_id</columns>
			<algorithm>mod-long</algorithm>
		</rule>
	</tableRule>
	<function name="mod-long" class="io.mycat.route.function.Part
itionByMod">		<!-- how many data nodes -->
		<property name="count">2</property>
	</function>
```

​		3、在node03上创建新的orders表

​		4、重启mycat

​		5、插入数据，实现分片

```sql
INSERT INTO orders(id,order_type,customer_id,amount) VALUES (1,101,100,100100);
INSERT INTO orders(id,order_type,customer_id,amount) VALUES(2,101,100,100300);
INSERT INTO orders(id,order_type,customer_id,amount) VALUES(3,101,101,120000);
INSERT INTO orders(id,order_type,customer_id,amount) VALUES(4,101,101,103000);
INSERT INTO orders(id,order_type,customer_id,amount) VALUES(5,102,101,100400);
INSERT INTO orders(id,order_type,customer_id,amount) VALUES(6,102,100,100020);
```

​		6、查看结果，分片成功。

### 		3、mycat ER表的分片

​		在mycat中，我们已经将orders进行了数据分片，但是orders表跟orders_detail发生关联，如果只把orders_detail放到一个分片上，那么跨库的join很麻烦，所以提出了ER关系的表分片。什么意思呢？就是通过关联关系，将子表与父表关联的记录放在同一个数据分片上。

​		1、修改schema.xml文件

```xml
		<table name ="orders" dataNode="dn1,dn2" rule="mod_rule">
			<childTable name="orders_detail" primaryKey="id" joinKey="order_id" parentKey="id" />		</table>
```

​		2、在node03上创建orders_detail表

​		3、重启mycat

​		4、插入数据

```sql
INSERT INTO orders_detail(id,detail,order_id) values(1,'detail1',1);
INSERT INTO orders_detail(id,detail,order_id) VALUES(2,'detail1',2);
INSERT INTO orders_detail(id,detail,order_id) VALUES(3,'detail1',3);
INSERT INTO orders_detail(id,detail,order_id) VALUES(4,'detail1',4);
INSERT INTO orders_detail(id,detail,order_id) VALUES(5,'detail1',5);
INSERT INTO orders_detail(id,detail,order_id) VALUES(6,'detail1',6);
```

​		5、执行join操作

```sql
select * from orders o join orders_detail od on o.id = od.order_id;
```

### 		4、全局表

​		在分片的情况下，当业务表因为规模而进行分片之后，业务表与这个字典表的之间关联会变得比较棘手，因此，在mycat中存在一种全局表，他具备以下特性：

​		1、全局表的插入、更新操作会实时的在所有节点上执行，保持各个分片的数据一致性

​		2、全局表的查询操作，只从一个节点获取

​		3、全局表可以跟任何一个表进行join操作

​		实际操作：

​		1、修改schema.xml文件

```xml
<table name="dict_order_type" dataNode="dn1,dn2" type="global"></table>
```

​		2、向node03，node01添加dict_order_type表

​		3、重启mycat

​		4、向表中插入数据

```sql
INSERT INTO dict_order_type(id,order_type) VALUES(101,'type1');
INSERT INTO dict_order_type(id,order_type) VALUES(102,'type2');
```

​		5、在各个节点进行数据查询，发现都能查询到对应的结果。

### 		5、常用分片规则

#### 		1、取模运算（之前演示过）

#### 		2、分片枚举

​			通过在配置文件中配置可能存在的值，配置分片。

​			1、修改schema.xml文件

```xml
<table name="orders_ware_info" dataNode="dn1,dn2" rule="sharding_by_intfile" ></table>
```

​			2、修改rule.xml文件

```xml
<tableRule name="sharding_by_intfile">
<rule>
<columns>areacode</columns>
<algorithm>hash-int</algorithm>
</rule>
</tableRule>
<!--
columns：分片字段， algorithm：分片函数
mapFile： 标识配置文件名称， type： 0为int型、 非0为String，
defaultNode： 默认节点:小于 0 表示不设置默认节点，大于等于 0 表示设置默认节点，
设置默认节点如果碰到不识别的枚举值，就让它路由到默认节点，如不设置不识别就报错
-->
<function name="hash-int"
class="io.mycat.route.function.PartitionByFileMap">
<property name="mapFile">partition-hash-int.txt</property>
<property name="type">1</property>
<property name="defaultNode">0</property>
</function>
```

​			3、修改partition-hash-int.txt文件

```te
110=0
120=1
```

​			4、重启mycat服务

​			5、创建mycat表

```sql
CREATE TABLE orders_ware_info
(
`id` INT AUTO_INCREMENT comment '编号',
`order_id` INT comment '订单编号',
`address` VARCHAR(200) comment '地址',
`areacode` VARCHAR(20) comment '区域编号',
PRIMARY KEY(id)
);

INSERT INTO orders_ware_info(id, order_id,address,areacode) VALUES (1,1,'北京','110');
INSERT INTO orders_ware_info(id, order_id,address,areacode) VALUES (2,2,'天津','120');
```

#### 		3、范围分片

​		根据分片字段，约定好属于哪一个范围

​		1、修改schema.xml文件

```xml
<table name="payment_info" dataNode="dn1,dn2" rule="auto_sharding_long" ></table>
```

​			2、修改rule.xml文件

```xml
<tableRule name="auto_sharding_long">
<rule>
<columns>order_id</columns>
<algorithm>rang-long</algorithm>
</rule>
</tableRule>
<!--
columns：分片字段， algorithm：分片函数
mapFile： 标识配置文件名称， type： 0为int型、 非0为String，
defaultNode： 默认节点:小于 0 表示不设置默认节点，大于等于 0 表示设置默认节点，
设置默认节点如果碰到不识别的枚举值，就让它路由到默认节点，如不设置不识别就报错
-->
<function name="rang-long"
class="io.mycat.route.function.AutoPartitionByLong">
<property name="mapFile">autopartition-long.txt</property>
<property name="defaultNode">0</property>
</function>
```

​			3、修改autopartition-long.txt文件

```te
0-102=0
103-200=1
```

​			4、重启mycat服务

​			5、创建mycat表

```sql
CREATE TABLE payment_info
(
`id` INT AUTO_INCREMENT comment '编号',
`order_id` INT comment '订单编号',
`payment_status` INT comment '支付状态',
PRIMARY KEY(id)
);

INSERT INTO payment_info (id,order_id,payment_status) VALUES (1,101,0);
INSERT INTO payment_info (id,order_id,payment_status) VALUES (2,102,1);
INSERT INTO payment_info (id,order_id ,payment_status) VALUES (3,103,0);
INSERT INTO payment_info (id,order_id,payment_status) VALUES (4,104,1);
```

#### 4、范围求模算法

​		该算法为先进行范围分片，计算出分片组，组内再求模，综合了范围分片和求模分片的优点。分片组内使用求模可以保证组内的数据分步比较均匀，分片组之间采用范围分片可以兼顾范围分片的特点。事先规定好分片的数量，数据扩容时按分片组扩容，则原有分片组的数据不需要迁移。由于分片组内的数据分步比较均匀，所以分片组内可以避免热点数据问题。

​		1、在node01,node03创建表person

```sql
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

​		2、修改schema.xml文件

```xml
<table name="person" primaryKey="id" dataNode="dn1,dn2" rule="auto-sharding-rang-mod"
></table>
```

​		3、修改rule.xml

```xml
	<tableRule name="auto-sharding-rang-mod">
		<rule>
			<columns>id</columns>
			<algorithm>rang-mod</algorithm>
		</rule>
	</tableRule>

	<function name="rang-mod" class="io.mycat.route.function.PartitionByRangeMod">
		<property name="mapFile">partition-range-mod.txt</property>
		<property name="defaultNode">0</property>
	</function>
```

​		4、修改partition-range-mod.txt文件

```tex
# range start-end ,data node group size
0-1M=1
1M1-2M=1
```

​		5、重启mycat服务

​		6、插入如下数据

```sql
insert into person(id,name) values(9999,'zhangsan1');
insert into person(id,name) values(10000,'zhangsan2');
insert into person(id,name) values(10001,'zhangsan3');
insert into person(id,name) values(20000,'zhangsan4');
```

​		7、当插入的数据范围超过我们给定的范围之后，会插入到默认节点中

```sql
insert into person(id,name) values(25000,'zhangsan0');
```

​		当使用这种分片规则的时候，还可以进行扩容操作，

​		1、在node02上创建新的数据库test

```sql
create database test;
```

​		2、创建person表

```sql
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

​		3、修改schema.xml文件

```xml
<?xml version="1.0"?>
<!DOCTYPE mycat:schema SYSTEM "schema.dtd">
<mycat:schema xmlns:mycat="http://io.mycat/">
	<schema name="TESTDB" checkSQLschema="false" sqlMaxLimit="100" dataNode="dn1">
		<table name = "customer" dataNode="dn2"></table>
		<table name ="orders" dataNode="dn1,dn2" rule="mod_rule">
			<childTable name="orders_detail" primaryKey="id" joinKey="order_id" parentKey
="id" />		</table>
		<table name="dict_order_type" dataNode="dn1,dn2" type="global"></table>
		<table name="person" primaryKey="id" dataNode="dn1,dn2,dn3" rule="auto-sharding-rang-
mod"></table>	</schema>
	<dataNode name="dn1" dataHost="host1" database="orders" />
	<dataNode name="dn2" dataHost="host2" database="orders"/>
	<dataNode name="dn3" dataHost="host3" database="test"/>
	<dataHost name="host1" maxCon="1000" minCon="10" balance="0"
			  writeType="0" dbType="mysql" dbDriver="native" switchType="1"  slaveThresho
ld="100">		<heartbeat>select user()</heartbeat>
		<writeHost host="hostM1" url="192.168.85.111:3306" user="root"
				   password="123456">
		</writeHost>
	</dataHost>
	<dataHost name="host2" maxCon="1000" minCon="10" balance="0" writeType="0" dbType="mysql" dbD
river="native" switchType="1" slaveThreshold="100">		<heartbeat>select user()</heartbeat>		<writeHost host="hostM2" url="192.168.85.113:3306" user="root" password="123456"></wr
iteHost>	</dataHost>
	<dataHost name="host3" maxCon="1000" minCon="10" balance="0" writeType="0" dbType="mysql" dbD
river="native" switchType="1" slaveThreshold="100">		<heartbeat>select user()</heartbeat>		<writeHost host="hostM3" url="192.168.85.112:3306" user="root" password="123456"></wr
iteHost>	</dataHost>
</mycat:schema>
```

​		4、修改partition-range-mod.txt文件

```tex
0-1M=2
1M1-2M=1
```

​		5、重启mycat服务

​		6、插入如下sql语句

```sql
insert into person(id,name) values(9999,'zhangsan1');
insert into person(id,name) values(10000,'zhangsan2');
insert into person(id,name) values(10001,'zhangsan3');
insert into person(id,name) values(20000,'zhangsan4');
```

​		可以看到9999和1000被分配到不同的节点上了。

#### 5、固定分片hash算法

​		类似于十进制的求模运算，但是为二进制的操作，取id的二进制低10位，即id二进制&1111111111.

​		此算法的优点在于如果按照十进制取模运算，则在连续插入1~10时，1~10会被分到1~10个分片，增大了插入事务的控制难度。而此算法根据二进制则可能会分到连续的分片，降低了插入事务的控制难度。

​		1、在node01,node02,node03创建表user

```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

​		2、修改schema.xml文件

```xml
<table name="user" primaryKey="id" dataNode="dn1,dn2,dn3" rule="rule1"></table>
```

​		3、修改rule.xml

```xml
<!--
columns标识将要分片的表字段
algorithm为分片函数
partitionCount为分片个数列表
partitionLength为分片范围列表，分区长度默认最大为1024，即最大支持1024个分区
约束如下：
	count,length 两个数组的长度必须是一致的。
1024 = sum((count[i]*length[i])). count 和 length 两个向量的点积恒等于 1024
-->
<tableRule name="rule1">
		<rule>
			<columns>id</columns>
			<algorithm>func1</algorithm>
		</rule>
	</tableRule>

	<function name="func1" class="io.mycat.route.function.PartitionByLong">
		<property name="partitionCount">2,1</property>
		<property name="partitionLength">256,512</property>
	</function>
```

​		4、重启mycat服务

​		5、插入如下数据

```sql
insert into user(id,name) values(1023,'zhangsan1');
insert into user(id,name) values(1024,'zhangsan2');
insert into user(id,name) values(266,'zhangsan3');
insert into user(id,name) values(255,'zhangsan4');
```

​		可以看到结果，1024,255在一个数据分片，266在一个数据分片，1023在一个数据分片。

#### 6、取模范围算法

​		取模运算与范围约束的结合主要是为后续的数据迁移做准备，即可以自主决定取模后数据的节点分布。

1、在node01,node02,node03创建表user2

```sql
CREATE TABLE `user2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

​		2、修改schema.xml文件

```xml
<table name="user2" primaryKey="id" dataNode="dn1,dn2,dn3" rule="sharding-by-pattern"
></table>
```

​		3、修改rule.xml

```xml
<!--
columns标识将要分片的表字段
algorithm为分片函数
mapFile：切分规则配置文件
patternValue：求模基数
defaultNode：默认节点，小于0表示不设置默认节点，大于等于0表示设置默认节点，如果超出配置的范围，则使用默认节点；
-->
<tableRule name="sharding-by-pattern">
		<rule>
			<columns>id</columns>
			<algorithm>sharding-by-pattern</algorithm>
		</rule>
	</tableRule>

	<function name="sharding-by-pattern" class="io.mycat.route.function.PartitionByPattern">
		<property name="mapFile">partition-pattern.txt</property>
		<property name="patternVAlue">256</property>
        <property name="defaultNode">0</property>
	</function>
```

​		4、修改partition-pattern.txt文件

```tex
0-86=0
87-173=1
174-256=2
```

​		5、重启mycat服务

​		6、插入如下数据

```sql
insert into user2(id,name) values(85,'zhangsan1');
insert into user2(id,name) values(100,'zhangsan2');
insert into user2(id,name) values(200,'zhangsan3');
```

​		可以看到结果不同的记录被分散到不同的数据分片上。

#### 7、字符串hash求模范围算法

​		与取模范围算法类似，该算法支持数值、符号、字母取模，此方式就是将指定位数的字符的ascll码的和进行取模运算，配置如下：

​		1、在node01,node02,node03创建表user3

```sql
CREATE TABLE `user3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

​		2、修改schema.xml文件

```xml
<table name="user3" primaryKey="id" dataNode="dn1,dn2,dn3" rule="sharding-by-prefixpattern"
></table>
```

​		3、修改rule.xml

```xml
<!--
columns标识将要分片的表字段
algorithm为分片函数
mapFile：切分规则配置文件
patternValue：求模基数
prefixLength:ASCII 截取的位数
-->
<tableRule name="sharding-by-prefixpattern">
		<rule>
			<columns>name</columns>
			<algorithm>sharding-by-prefixpattern</algorithm>
		</rule>
	</tableRule>

	<function name="sharding-by-prefixpattern" class="io.mycat.route.function.PartitionByPrefixPattern">
		<property name="mapFile">partition-pattern.txt</property>
		<property name="patternVAlue">256</property>
        <property name="prefixLength">5</property>
	</function>
```

​		4、修改partition-pattern.txt文件

```tex
# ASCII
# 8-57=0-9 阿拉伯数字
# 64、 65-90=@、 A-Z
# 97-122=a-z  
0-86=0
87-173=1
174-256=2
```

​		5、重启mycat服务

​		6、插入如下数据

```sql
insert into user3(id,name) values(1,'zhangsan');
insert into user3(id,name) values(2,'lisi');
insert into user3(id,name) values(3,'wangwu');
insert into user3(id,name) values(4,'zzzzzzz');
insert into user3(id,name) values(5,'z99');
```

​		可以看到数据被分散了，但是因为ascll码值是需要计算的，所以结果可能不是很明显，大家需要自己的拼字符串来试验。

#### 8、应用指定的算法

​		在运行阶段由应用程序自主决定路由到哪个分片，配置如下：

​		1、在node01,node02,node03创建表user4

```sql
CREATE TABLE `user4` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

​		2、修改schema.xml文件

```xml
<table name="user4" primaryKey="id" dataNode="dn1,dn2,dn3" rule="sharding-by-substring"
></table>
```

​		3、修改rule.xml

```xml
<!--
columns标识将要分片的表字段
algorithm为分片函数
-->
<tableRule name="sharding-by-substring">
		<rule>
			<columns>name</columns>
			<algorithm>sharding-by-substring</algorithm>
		</rule>
	</tableRule>

	<function name="sharding-by-substring" class="io.mycat.route.function.PartitionDirectBySubString">
		<property name="startIndex">0</property>
		<property name="size">1</property>
        <property name="partitionCount">3</property>
        <property name="defaultPartition">0</property>
	</function>
```

​		4、重启mycat服务

​		5、插入如下数据

```sql
insert into user4(id,name) values(1,'0-zhangsan');
insert into user4(id,name) values(2,'1-lisi');
insert into user4(id,name) values(3,'2-wangwu');
```

​		可以看到数据被分片存储了。

#### 9、字符串hash解析算法

​		字符串hash解析分片，其实就是根据配置的hash预算位规则，将截取的字符串进行hash计算后，得到的int数值即为datanode index(分片节点索引，从0开始)。

​		1、在node01,node02,node03创建表user5

```sql
CREATE TABLE `user5` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

​		2、修改schema.xml文件

```xml
<table name="user5" primaryKey="id" dataNode="dn1,dn2,dn3" rule="sharding-by-stringhash"
></table>
```

​		3、修改rule.xml

```xml
<!--
columns标识将要分片的表字段
algorithm为分片函数
-->
<tableRule name="sharding-by-stringhash">
		<rule>
			<columns>id</columns>
			<algorithm>sharding-by-stringhash</algorithm>
		</rule>
	</tableRule>
<!--
partitionLength:求模基数
partitionCount:分片数量
hashslice： hash 预算位，即根据子字符串中 int 值 hash 运算
hashSlice ： 0 means str.length(), -1 means str.length()-1
/**
* “2” -> (0,2)
* “1:2” -> (1,2)
* “1:” -> (1,0)
* “-1:” -> (-1,0)
* “:-1” -> (0,-1)
* “:” -> (0,0)
*/
-->
	<function name="sharding-by-stringhash" class="io.mycat.route.function.PartitionByString">
		<property name="partitionLength">512</property>
		<property name="partitionCount">3</property>
        <property name="hashSlice">0:6</property>
	</function>
```

​		4、重启mycat服务

​		5、插入如下数据

```sql
insert into user5(id,name) values(1111111,database());
insert into user5(id,name) values(2222222,database());
insert into user5(id,name) values(3333333,database());
insert into user5(id,name) values(4444444,database());
insert into user5(id,name) values(8960000,database());	
```

#### 		10、按照日期范围分片		

​		按照某个指定的日期进行分片

​		1、修改schema.xml文件

```xml
<table name="login_info" dataNode="dn1,dn2" rule="sharding_by_date" ></table>
```

​		2、修改rule.xml文件

```xml
<tableRule name="sharding_by_date">
	<rule>
		<columns>login_date</columns>
		<algorithm>shardingByDate</algorithm>
	</rule>
</tableRule>
<!--
columns：分片字段， algorithm：分片函数
dateFormat ：日期格式
sBeginDate ：开始日期
sEndDate：结束日期,则代表数据达到了这个日期的分片后循环从开始分片插入
sPartionDay ：分区天数，即默认从开始日期算起，分隔 2 天一个分区
-->
<function name="shardingByDate" class="io.mycat.route.function.PartitionByDate">
	<property name="dateFormat">yyyy-MM-dd</property>
	<property name="sBeginDate">2020-06-01</property>
	<property name="sEndDate">2020-06-04</property>
    <property name="sPartionDay">2</property>
</function>
```

​			3、重启mycat服务

​			4、创建mycat表

```sql
CREATE TABLE login_info
(
`id` INT AUTO_INCREMENT comment '编号',
`user_id` INT comment '用户编号',
`login_date` date comment '登录日期',
PRIMARY KEY(id)
);

INSERT INTO login_info(id,user_id,login_date) VALUES (1,101,'2020-06-01');
INSERT INTO login_info(id,user_id,login_date) VALUES (2,102,'2020-06-02');
INSERT INTO login_info(id,user_id,login_date) VALUES (3,103,'2020-06-03');
INSERT INTO login_info(id,user_id,login_date) VALUES (4,104,'2020-06-04');
INSERT INTO login_info(id,user_id,login_date) VALUES (5,103,'2020-06-05');
INSERT INTO login_info(id,user_id,login_date) VALUES (6,104,'2020-06-06');
```

#### 	11、按单月小时分片	

​		此规则是单月内按照小时拆分，最小粒度是小时，可以一天最多24个分片，最少一个分片，一个月完成后下个月开始循环，每个月月尾，需要手工清理数据。

​		1、修改schema.xml文件

```xml
<table name="user6" dataNode="dn1,dn2,dn3" rule="sharding-by-hour"></table>
```

​		2、修改rule.xml文件

```xml
<tableRule name="sharding-by-hour">
<rule>
<columns>create_time</columns>
<algorithm>sharding-by-hour</algorithm>
</rule>
</tableRule>
<!--
columns： 拆分字段，字符串类型（yyyymmddHH）
splitOneDay ： 一天切分的分片数
-->
<function name="sharding-by-hour" class="io.mycat.route.function.LatestMonthPartion">
<property name="splitOneDay">3</property>
</function>
```

​			3、重启mycat服务

​			4、创建mycat表

```sql
create table user6(
id int not null,
name varchar(64),
create_time varchar(10)
);

insert into user6(id,name,create_time) values(1,'steven','2020060100');
insert into user6(id,name,create_time) values(1,'steven','2020060101');
insert into user6(id,name,create_time) values(1,'steven','2020060102');
insert into user6(id,name,create_time) values(1,'steven','2020060103');
insert into user6(id,name,create_time) values(1,'steven','2020060104');
insert into user6(id,name,create_time) values(1,'steven','2020060105');
insert into user6(id,name,create_time) values(1,'steven','2020060106');
insert into user6(id,name,create_time) values(1,'steven','2020060107');
insert into user6(id,name,create_time) values(1,'steven','2020060108');
insert into user6(id,name,create_time) values(1,'steven','2020060109');
insert into user6(id,name,create_time) values(1,'steven','2020060110');
insert into user6(id,name,create_time) values(1,'steven','2020060111');
insert into user6(id,name,create_time) values(1,'steven','2020060112');
insert into user6(id,name,create_time) values(1,'steven','2020060113');
insert into user6(id,name,create_time) values(1,'steven','2020060114');
insert into user6(id,name,create_time) values(1,'steven','2020060115');
insert into user6(id,name,create_time) values(1,'steven','2020060116');
insert into user6(id,name,create_time) values(1,'steven','2020060117');
insert into user6(id,name,create_time) values(1,'steven','2020060118');
insert into user6(id,name,create_time) values(1,'steven','2020060119');
insert into user6(id,name,create_time) values(1,'steven','2020060120');
insert into user6(id,name,create_time) values(1,'steven','2020060121');
insert into user6(id,name,create_time) values(1,'steven','2020060122');
insert into user6(id,name,create_time) values(1,'steven','2020060123');
insert into user6(id,name,create_time) values(1,'steven','2020060200');
insert into user6(id,name,create_time) values(1,'steven','2020060201');
insert into user6(id,name,create_time) values(1,'steven','2020060202');
insert into user6(id,name,create_time) values(1,'steven','2020060203');
insert into user6(id,name,create_time) values(1,'steven','2020060204');
insert into user6(id,name,create_time) values(1,'steven','2020060205');
insert into user6(id,name,create_time) values(1,'steven','2020060206');
insert into user6(id,name,create_time) values(1,'steven','2020060207');
insert into user6(id,name,create_time) values(1,'steven','2020060208');
insert into user6(id,name,create_time) values(1,'steven','2020060209');
insert into user6(id,name,create_time) values(1,'steven','2020060210');
insert into user6(id,name,create_time) values(1,'steven','2020060211');
```

​		当运行完成之后会发现，第一天的数据能够正常的插入成功，均匀的分散到3个分片上，但是第二天的数据就无法成功分散了，原因就在于我们的数据分片不够，所以这种方式几乎没有人使用。

#### 12、日期范围hash分片

​		思想与范围求模一致，当由于日期在取模会有数据集中问题，所以改成了hash方法。先根据时间hash使得短期内数据分布的更均匀，有点可以避免扩容时的数据迁移，又可以一定程度上避免范围分片的热点问题，要求日期格式尽量精确，不然达不到局部均匀的目的。

​		1、修改schema.xml文件

```xml
<table name="user7" dataNode="dn1,dn2,dn3" rule="rangeDateHash"></table>
```

​		2、修改rule.xml文件

```xml
<tableRule name="rangeDateHash">
<rule>
<columns>create_time</columns>
<algorithm>range-date-hash</algorithm>
</rule>
</tableRule>
<!--
columns： 拆分字段，字符串类型（yyyymmddHH）
algorithm:分片函数
sBeginDate:指定开始的日期，与dateFormat格式一致
sPartionDay:代表多少天一组
dateFormat:指定的日期格式，符合java标准

-->
<function name="range-date-hash"
class="io.mycat.route.function.PartitionByRangeDateHash">
<property name="sBeginDate">2020-06-01 00:00:00</property>
<property name="sPartionDay">3</property>
<property name="dateFormat">yyyy-MM-dd HH:mm:ss</property>
<property name="groupPartionSize">1</property>
</function>
```

​			3、重启mycat服务

​			4、创建mycat表

```sql
create table user7(
id int not null,
name varchar(64),
create_time varchar(20)
);

insert into user7(id,name,create_time) values(1,'steven','2020-06-01 00:00:00');
insert into user7(id,name,create_time) values(1,'steven','2020-06-02 00:00:00');
insert into user7(id,name,create_time) values(1,'steven','2020-06-03 00:00:00');
insert into user7(id,name,create_time) values(1,'steven','2020-06-04 00:00:00');
insert into user7(id,name,create_time) values(1,'steven','2020-06-05 00:00:00');
insert into user7(id,name,create_time) values(1,'steven','2020-06-06 00:00:00');
insert into user7(id,name,create_time) values(1,'steven','2020-06-07 00:00:00');
insert into user7(id,name,create_time) values(1,'steven','2020-06-08 00:00:00');
insert into user7(id,name,create_time) values(1,'steven','2020-06-09 00:00:00');
insert into user7(id,name,create_time) values(1,'steven','2020-06-10 00:00:00');
insert into user7(id,name,create_time) values(1,'steven','2020-06-11 00:00:00');
```

​		通过结果也可以看出，每三天一个分片，那么我们只有三个数据节点，所以到10号的数据的时候，没有办法进行数据的插入了，原因就在于没有足够多的数据节点。

#### 13、冷热数据分片

​		根据日期查询冷热数据分布，最近n个月的到实时交易库查询，其他的到其他库中

​		1、修改schema.xml文件

```xml
<table name="user8" dataNode="dn1,dn2,dn3" rule="sharding-by-hotdate" />
```

​		2、修改rule.xml文件

```xml
<tableRule name="sharding-by-hotdate">
<rule>
<columns>create_time</columns>
<algorithm>sharding-by-hotdate</algorithm>
</rule>
</tableRule>
<!--
dataFormat：时间格式化
sLastDay:热数据的天数
sPartionDay:冷数据的分片天数（按照天数分片）
-->
<function name="sharding-by-hotdate" class="io.mycat.route.function.PartitionByHotDate">
<property name="dateFormat">yyyy-MM-dd</property>
<property name="sLastDay">10</property>
<property name="sPartionDay">30</property>
</function>
```

​			3、重启mycat服务

​			4、创建mycat表

```sql

CREATE TABLE  user8(create_time   timestamp NULL ON UPDATE CURRENT_TIMESTAMP  ,`db_nm`  varchar(20) NULL);
INSERT INTO user8 (create_time,db_nm) VALUES ('2020-06-01', database());
INSERT INTO user8 (create_time,db_nm) VALUES ('2020-06-10', database());
INSERT INTO user8 (create_time,db_nm) VALUES ('2020-06-11', database());
INSERT INTO user8 (create_time,db_nm) VALUES ('2020-06-21', database());
INSERT INTO user8 (create_time,db_nm) VALUES ('2020-06-30', database());
INSERT INTO user8 (create_time,db_nm) VALUES ('2020-07-30', database());

```

#### 14、自然月分片		

​		1、修改schema.xml文件

```xml
<table name="user9" dataNode="dn1,dn2,dn3" rule="sharding-by-month" />
```

​		2、修改rule.xml文件

```xml
<tableRule name="sharding-by-month">
<rule>
<columns>create_time</columns>
<algorithm>sharding-by-month</algorithm>
</rule>
</tableRule>
<!--
columns： 分片字段，字符串类型
dateFormat ： 日期字符串格式
sBeginDate ： 开始日期
-->
<function name="sharding-by-month" class="io.mycat.route.function.PartitionByMonth">
<property name="dateFormat">yyyy-MM-dd</property>
<property name="sBeginDate">2019-01-01</property>
</function>
```

​			3、重启mycat服务

​			4、创建mycat表

```sql
CREATE TABLE  user9(id int,name varchar(10),create_time varchar(20));
insert into user9(id,name,create_time) values(111,'zhangsan','2019-01-01');
insert into user9(id,name,create_time) values(111,'zhangsan','2019-03-01');
insert into user9(id,name,create_time) values(111,'zhangsan','2019-05-01');
insert into user9(id,name,create_time) values(111,'zhangsan','2019-07-01');
insert into user9(id,name,create_time) values(111,'zhangsan','2019-09-01');
insert into user9(id,name,create_time) values(111,'zhangsan','2019-11-01');
```

#### 15、一致性hash分片

​		实现方式：一致性hash分片，利用一个分片节点对应一个或者多个虚拟hash桶的思想，，尽可能减少分片扩展时的数据迁移。
​		优点：有效解决了分布式数据库的扩容问题。
​		缺点：在横向扩展的时候，需要迁移部分数据；由于虚拟桶倍数与分片节点数都必须是正整数，而且要服从"虚拟桶倍数×分片节点数=设计极限"，因此在横向扩容的过程中，增加分片节点并不是一台一台地加上去的，而是以一种因式分解的方式增加，因此有浪费物理计算力的可能性。

​		1、修改schema.xml文件

```xml
 <table name="user10" dataNode="dn1,dn2,dn3" primaryKey="id" rule="sharding-by-murmur" />
```

​		2、修改rule.xml文件

```xml
<tableRule name="sharding-by-murmur">
<rule>
<columns>id</columns>
<algorithm>murmur</algorithm>
</rule>
</tableRule>
<function name="murmur" class="io.mycat.route.function.PartitionByMurmurHash">
<property name="seed">0</property><!-- 默认是 0-->
<property name="count">2</property><!-- 要分片的数据库节点数量，必须指定，否则没法分片-->
<property name="virtualBucketTimes">160</property>
<!-- 一个实际的数据库节点被映射为这么多虚拟节点，默认是 160 倍，也就是虚拟节点数是物理节点数的 160 倍-->
<!--<property name="weightMapFile">weightMapFile</property>
节点的权重，没有指定权重的节点默认是 1。以 properties 文件的格式填写，以从 0 开始到 count-1 的整数值也就是节点索引为 key，以节点权重值为值。所有权重值必须是正整数，否则以 1 代替 -->
<property name="bucketMapPath">/etc/mycat/bucketMapPath</property>
<!--用于测试时观察各物理节点与虚拟节点的分布情况，如果指定了这个属性，会把虚拟节点的 murmur hash 值与物理节点的映射按行输出到这个文件，没有默认值，如果不指定，就不会输出任何东西 -->
</function>
```

​			3、重启mycat服务

​			4、创建mycat表

```sql
create table user10(id bigint not null primary key,name varchar(20));

insert into user10(id,name) values(1111111,database());
insert into user10(id,name) values(2222222,database());
insert into user10(id,name) values(3333333,database());
insert into user10(id,name) values(4444444,database());
insert into user10(id,name) values(8960000,database());
```

### 6、mycat的分片join

​		Join绝对是关系型数据库中最常用的一个特性，然而在分布式环境中，跨分配的join却是最复杂的，最难解决的一个问题。

​		性能建议：

​		1、尽量避免使用left join或right join，而用inner join

​		2、在使用left join或right join时，on会优先执行，where条件在最后执行，所以再使用过程中，条件尽可能的在on语句中判断，减少where的执行

​		3、少使用子查询，而用join

​		mycat目前版本支持跨分配的join，主要有四种实现方式

​		1、全局表

​		2、ER分片

​		3、catletT(人工智能)

​		4、ShareJoin

​		全局表和ER分片在之前的操作中已经讲过了，此处不再赘述，下面详细讲解下另外两种方式。

#### 		Share join

​		ShareJoin是一个简单的跨分片join,基于HBT的方式实现。目前支持2个表的join，原理是解析SQL语句，拆分成单表的SQL语句执行，然后把各个节点的数据汇集。

​		配置方式如下：

​		A,B的dataNode相同

```xml
<table name="A" dataNode="dn1,dn2,dn3" rule="auto-sharding-long" />
<table name="B" dataNode="dn1,dn2,dn3" rule="auto-sharding-long" />
```

​		A，B的dataNode不同

```xml
<table name="A" dataNode="dn1,dn2 " rule="auto-sharding-long" />
<table name="B" dataNode="dn1,dn2,dn3" rule="auto-sharding-long" />
------------
<table name="A" dataNode="dn1 " rule="auto-sharding-long" />
<table name="B" dataNode=" dn2,dn3" rule="auto-sharding-long" />
```

​		修改schema.xml

```xml
<table name="company" primaryKey="id" dataNode="dn1,dn2,dn3" rule="mod-long" />
<table name="customers" primaryKey="id" dataNode="dn1,dn2" rule="sharding-by-intfile"/>
```

​		修改rule.xml

```xml
        <tableRule name="mod-long">
                <rule>
                        <columns>id</columns>
                        <algorithm>mod-long</algorithm>
                </rule>
        </tableRule>
        <function name="mod-long" class="io.mycat.route.function.PartitionByMod">
                <!-- how many data nodes -->
                <property name="count">3</property>
        </function>
        <tableRule name="sharding-by-intfile">
                <rule>
                        <columns>sharding_id</columns>
                        <algorithm>hash-int</algorithm>
                </rule>
        </tableRule>
        <function name="hash-int"
                          class="io.mycat.route.function.PartitionByFileMap">
                <property name="mapFile">partition-hash-int.txt</property>
        </function>
```

​		修改partition-hash-int.txt文件

```tex
10000=0
10010=1
```

​		sql语句：

```sql
create table company(id int primary key,name varchar(10)) engine=innodb;
insert company (id,name) values(1,'mycat');
insert company (id,name) values(2,'ibm');
insert company (id,name) values(3,'hp');

create table customers(id int not null primary key,name varchar(100),company_id int not null,sharding_id int not null);
insert into customers(id,name,company_id,sharding_id)values(1,'wang',1,10000),(2,'xue',2,10010),(3,'feng',3,10000);
```

​		验证：

```sql
-- 可以看到有时可以查出对应的结果，有时则查询不到
select a.*,b.ID,b.NAME as tit from customers a,company b where a.COMPANY_ID=b.ID;
--可以看到每次都可以直接查询到结果
/*!mycat:catlet=io.mycat.catlets.ShareJoin */select a.*,b.ID,b.NAME as tit from customers a,company b where a.COMPANY_ID=b.ID;
--其他写法
/*!mycat:catlet=io.mycat.catlets.ShareJoin */select a.*,b.ID,b.NAME as tit from customers a join company b on a.COMPANY_ID=b.ID;
/*!mycat:catlet=io.mycat.catlets.ShareJoin */select a.*,b.ID,b.NAME as tit from customers a join company b where a.COMPANY_ID=b.ID;
```

### 7、全局序列号

​		在实现分库分表的情况下，数据库自增主键已经无法保证自增主键的全局唯一，为此，mycat提供了全局sequence，并且提供了包含本地配置和数据库配置等多种实现方式。

#### 		1、本地文件方式

​		使用此方式的时候，mycat讲sequence配置到文件中，当使用到sequence中的配置，mycat会更新sequence_conf.properties文件中sequence当前的值。

​		**配置方式：**

​		在 sequence_conf.properties 文件中做如下配置：

```properties
GLOBAL_SEQ.HISIDS=
GLOBAL_SEQ.MINID=10001
GLOBAL_SEQ.MAXID=20000
GLOBAL_SEQ.CURID=10000
```

​		其中 HISIDS 表示使用过的历史分段(一般无特殊需要可不配置)， MINID 表示最小 ID 值， MAXID 表示最大
ID 值， CURID 表示当前 ID 值。
​		server.xml 中配置：

```xml
<system><property name="sequnceHandlerType">0</property></system>
```

​		注： sequnceHandlerType 需要配置为 0，表示使用本地文件方式。  

​		案例使用：

```sql
create table tab1(id int primary key,name varchar(10));
insert into tab1(id,name) values(next value for mycatseq_global,'test1');
insert into tab1(id,name) values(next value for mycatseq_global,'test2');
insert into tab1(id,name) values(next value for mycatseq_global,'test3');
```

​		缺点：当mycat重新发布后，配置文件中的sequence会恢复到初始值

​		优点：本地加载，读取速度较快

#### 		2、数据库方式

​		在数据库中建立一张表，存放sequence名称（name）,sequence当前值(current_value),步长（increment int类型，每次读取多少个sequence，假设为K）等信息；

​		**获取数据步骤**：

​		1、当初次使用该sequence时，根据传入的sequence名称，从数据库这张表中读取current_value和increment到mycat中，并将数据库中的current_value设置为原current_value值+increment值。

​		2、mycat将读取到current_value+increment作为本次要使用的sequence值，下次使用时，自动加1，当使用increment次后，执行步骤1中的操作

​		3、mycat负责维护这张表，用到哪些sequence，只需要在这张表中插入一条记录即可，若某次读取的sequence没有用完，系统就停掉了，则这次读取的sequence剩余值不会再使用

​		**配置方式：**

​		1、修改server.xml文件

```xml
<system><property name="sequnceHandlerType">1</property></system>
```

​		2、修改schema.xml文件		

```xml
<table name="test" primaryKey="id" autoIncrement="true" dataNode="dn1,dn2,dn3" rule="mod-long"/>
<table name="mycat_sequence" primaryKey="name" dataNode="dn2"/>
```

​		3、修改mycat配置文件sequence_db_conf.properties，添加属性值

```properties
#sequence stored in datanode
GLOBAL=dn1
COMPANY=dn1
CUSTOMER=dn1
ORDERS=dn1
MYCAT=dn2
```

​		4、在dn2上添加mycat_sequence表

```sql
DROP TABLE IF EXISTS mycat_sequence;
CREATE TABLE mycat_sequence (name VARCHAR(50) NOT NULL,current_value INT NOT NULL,increment INT NOT NULL DEFAULT 100, PRIMARY KEY(name)) ENGINE=InnoDB;
```

​		5、在dn2上的mycat_sequence表中插入初始记录

```sql
INSERT INTO mycat_sequence(name,current_value,increment) VALUES ('mycat', -99, 100);
```

​		6、在dn2上创建函数

```sql
--创建函数
DROP FUNCTION IF EXISTS mycat_seq_currval;
DELIMITER $
CREATE FUNCTION mycat_seq_currval(seq_name VARCHAR(50)) RETURNS varchar(64)     CHARSET utf8
DETERMINISTIC
BEGIN
DECLARE retval VARCHAR(64);
SET retval="-999999999,null";
SELECT concat(CAST(current_value AS CHAR),",",CAST(increment AS CHAR)) INTO retval FROM mycat_sequence WHERE name = seq_name;
RETURN retval;
END $
DELIMITER ;
--设置sequence值
DROP FUNCTION IF EXISTS mycat_seq_setval;
DELIMITER $
CREATE FUNCTION mycat_seq_setval(seq_name VARCHAR(50),value INTEGER) RETURNS     varchar(64) CHARSET utf8
DETERMINISTIC
BEGIN
UPDATE mycat_sequence
SET current_value = value
WHERE name = seq_name;
RETURN mycat_seq_currval(seq_name);
END $
DELIMITER ;
--获取下一个sequence值
DROP FUNCTION IF EXISTS mycat_seq_nextval;
DELIMITER $
CREATE FUNCTION mycat_seq_nextval(seq_name VARCHAR(50)) RETURNS varchar(64)     CHARSET utf8
DETERMINISTIC
BEGIN
UPDATE mycat_sequence
SET current_value = current_value + increment WHERE name = seq_name;
RETURN mycat_seq_currval(seq_name);
END $
DELIMITER ;
```

​		**数据测试：**

​		1、插入数据表

```sql
create table test(id int,name varchar(10));
```

​		2、查询对应的序列数据表

```sql
SELECT * FROM mycat_sequence;
```

​		3、向表中插入数据，可以多执行几次

```sql
insert into test(id,name) values(next value for MYCATSEQ_MYCAT,(select database()));
```

​		4、查询添加的数据

```sql
SELECT * FROM test order by id asc;
```

​		5、重新启动mycat，重新添加数据，查看结果，重启之后从101开始

```sql
SELECT * FROM mycat_sequence;
```

​		6、重新查询数据表test

```sql
SELECT * FROM test order by id asc;
```

​		大家在使用的时候会发现报错的情况，这个错误的原因不是因为我们的配置，是因为我们的版本问题，简单替换下版本即可。

```
mysql> insert into test(id,name) values(next value for MYCATSEQ_MYCAT,(select database()));
ERROR 1003 (HY000): mycat sequnce err.java.lang.NumberFormatException: null
```

#### 		3、本地时间戳方式

​		ID= 64 位二进制 (42(毫秒)+5(机器 ID)+5(业务编码)+12(重复累加)。

​		换算成十进制为 18 位数的 long 类型，每毫秒可以并发 12 位二进制的累加。  

​		**使用方式：**

​		1、配置server.xml文件

```xml
<property name="sequnceHandlerType">2</property>
```

​		2、修改sequence_time_conf.properties

```properties
WORKID=06 #任意整数
DATAACENTERID=06  #任意整数
```

​		3、修改schema.xml文件

```xml
<table name="test2" dataNode="dn1,dn2,dn3" primaryKey="id" autoIncrement="true" rule="mod-long" />
```

​		4、启动mycat，并且创建表进行测试

```sql
create table test2(id bigint auto_increment primary key,xm varchar(32));
insert into test2(id,xm) values(next value for MYCATSEQ_GLOBAL，'lisi') ; 
```

​		此方式的优点是配置简单，但是缺点也很明显就是18位的id太长，需要耗费多余的存储空间。

#### 		4、自定义全局序列

​		用户还可以在程序中自定义全局序列，通过java代码来实现，这种方式一般比较麻烦，因此在能使用mycat提供的方式满足需求的前提下一般不需要自己通过java代码来实现。

#### 		5、分布式ZK ID生成器

​		如果在搭建的时候使用了zookeeper，也可以使用zk来生成对应的id，此方式需要zk的配合，此处不再展示，有兴趣的同学下去自己演示即可。