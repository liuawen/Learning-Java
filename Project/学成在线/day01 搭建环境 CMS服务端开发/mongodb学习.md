# MongoDB学习

json

基础概念

# 基础概念

在mongodb 中通过数据库 集合 文档的方式来管理数据

数据库 集合 一个文档

在mongodb中是通过数据库、集合、文档的方式来管理数据，下边是mongodb与关系数据库的一些概念对比：

方式来管理数据库 

mongodb与关系数据库的一些概念对比 

SQL术语/概念MongoDB术语/概念解释/说明
database database 数据库
table collection 数据库表/集合
row document 数据记录行/文档
column field 数据字段/域
index index 索引
table joins 表连接（MongoDB不支持）
primary key primary key 主键,MongoDB自动在每个集合中添加_id的主键

field  column   数据  

![image-20200804214645414](assets/image-20200804214645414.png)

连接MongoDB

在Mongodb的使用方式 

![image-20200804224946450](assets/image-20200804224946450.png)

1、一个mongodb实例可以创建多个数据库
2、一个数据库可以创建多个集合
3、一个集合可以包括多个文档。

一个文档

```json
{
    "id":;
    "name":""
}
```





我们刚刚是本地连接  



```
show dbs
use test
db

```

删除数据库 

![image-20200804215719365](assets/image-20200804215719365.png)

没有集合 不显示

# 连接mongodb

使用方式是客户服务服务器模式

客户服务服务器模式

mongodb的使用方式是客户服务器模式，即使用一个客户端连接mongodb数据库（服务端）。
1、 命令格式

```
mongodb://[username:password@]host1[:port1][,host2[:port2],...[,hostN[:portN]]][/[database][?
options]]
```

mongodb:// 固定前缀
username：账号，可不填
password：密码，可不填
host：主机名或ip地址，只有host主机名为必填项。
port：端口，可不填，默认27017
/database：连接某一个数据库
?options：连接参数，key/value对

mongodb

username

password

host

port

/database

例子：

```
mongodb://localhost 连接本地数据库27017端口
mongodb://root:itcast@localhost 使用用户名root密码为itcast连接本地数据库27017端口
mongodb://localhost,localhost:27018,localhost:27019，连接三台主从服务器，端口为27017、27018、27019
```



客户端连接  工具  

命令窗口 



2、使用mongodb自带的javascript shell（mongo.exe）连接

mongo.exe

mongodb

javascript shell 

windows版本的mongodb安装成功，在安装目录下的bin目录有mongo.exe客户端程序
![image-20200804225716863](assets/image-20200804225716863.png)

cmd状态执行mongo.exe：

![image-20200804225730195](assets/image-20200804225730195.png)

此时就可以输入命令来操作mongodb数据库了，javascript shell可以运行javascript程序。

3、使用studio3T连接

4、使用java程序连接

详细参数：http://mongodb.github.io/mongo-java-driver/3.4/driver/tutorials/connect-to-mongodb/
添加依赖：

```
<dependency>
<groupId>org.mongodb</groupId>
<artifactId>mongo‐java‐driver</artifactId>
<version>3.4.3</version>
</dependency>
```

测试程序：

```
@Test
public void testConnection(){
//创建mongodb 客户端
MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//或者采用连接字符串
//MongoClientURI connectionString = new
MongoClientURI("mongodb://root:root@localhost:27017");
//MongoClient mongoClient = new MongoClient(connectionString);
//连接数据库
MongoDatabase database = mongoClient.getDatabase("test");
// 连接collection
MongoCollection<Document> collection = database.getCollection("student");
//查询第一个文档
Document myDoc = collection.find().first();
//得到文件内容 json串
String json = myDoc.toJson();
System.out.println(json);
}
```

# 数据库

1、查询数据库
show dbs 查询全部数据库
db 显示当前数据库

show dbs  查询全部数据库

db



查询数据库

show  dbs 查询全部数据库

db  显示当前数据库



use  test 

我不知道我选中了哪个数据库  

db

```
> db
test
> show dbs
admin  0.000GB
local  0.000GB
> use test
switched to db test
> db
test
>
```





2、创建数据库

创建数据库

命令格式：

```
use DATABASE_NAME  
```

user  DATABASE_NAME 

例子：
use test02
有test02数据库则切换到此数据库，没有则创建。

有test02数据库则切换到此数据库 没有则创建

use  test02

注意：
新创建的数据库不显示，需要至少包括一个集合。

新创建的数据库不显示 需要至少包括一个集合

新创建的数据库不显示  需要至少包括一个集合 

3、删除数据库（慎用！！！）

删除当前的数据库 

没有集合默认不显示  数据库

show dbs

创建集合 

命令格式：

```
db.dropDatabase()
```

例子：
删除test02数据库
先切换数据库：use test02
再执行删除：db.dropDatabase()

db.dropDatabase()

删除test02数据库

先切换数据库再删除

use   .dropDatabase()

集合

集合相当于关系数据库中的表，一个数据库可以创建多个集合，一个集合是将相同类型的文档管理起来。

1、创建集合

```
db.createCollection(name, options)
name: 新创建的集合名称
options: 创建参数
```

2、删除集合

```
db.collection.drop()
例子：
db.student.drop() 删除student集合
```



![image-20200806183631031](assets/image-20200806183631031.png)





创建集合 



# 文档

插入文档   

MySQL记录   JSON格式  



mongodb中文档的格式是json格式，下边就是一个文档，包括两个key：_id主键和name

```
{
"_id" : ObjectId("5b2cc4bfa6a44812707739b5"),
"name" : "黑马程序员"
}
```

插入命令：

```
db.COLLECTION_NAME.insert(document)
```

每个文档默认以_id作为主键，主键默认类型为ObjectId（对象类型），mongodb会自动生成主键值。
例子：

```
db.student.insert({"name":"黑马程序员","age":10})
```

注意：同一个集合中的文档的key可以不相同！但是建议设置为相同的。

更新文档

命令格式：

```json
db.collection.update(
<query>,
<update>,
<options>
)
query:查询条件，相当于sql语句的where
update：更新文档内容
options：选项
```

1、替换文档
将符合条件 "name":"北京黑马程序"的第一个文档替换为{"name":"北京黑马程序员","age":10}。

```
db.student.update({"name":"黑马程序员"},{"name":"北京黑马程序员","age":10})
```

先删除再插入  



2、$set修改器
使用$set修改器指定要更新的key，key不存在则创建，存在则更新。

你更新那个字段 就更新什么  

完全特换 



将符合条件 "name":"北京黑马程序"的所有文档更新name和age的值。

```
db.student.update({"name":"黑马程序员"},{$set:{"name":"北京黑马程序员","age":10}},{multi:true})
```

multi：false表示更新第一个匹配的文档，true表示更新所有匹配的文档。

multi：false表示更新第一个匹配的文档，true表示更新所有匹配的文档。

set修改器 来更新 

删除文档

命令格式：

```
db.student.remove(<query>)
query：删除条件，相当于sql语句中的where
```

1、删除所有文档
db.student.remove({})

删除所有文档 db.student.remove({})



2、删除符合条件的文档
db.student.remove({"name":"黑马程序员"})

查询文档

命令格式：

```json
db.collection.find(query, projection)
query：查询条件，可不填
projection：投影查询key，可不填
```



每一个文档  可以不一样  灵活

集合 建议  相同类型的问题存一块  就是想要    域保持一致

3、投影查询
只显示name和age两个key，_id主键不显示。

```
db.student.find({"name":"黑马程序员"},{name:1,age:1,_id:0})
```



![image-20200806184747215](assets/image-20200806184747215.png)





![image-20200806184801342](assets/image-20200806184801342.png)



格式灵活



![image-20200806184826539](assets/image-20200806184826539.png)





![image-20200806185533278](assets/image-20200806185533278.png)





![image-20200806185545377](assets/image-20200806185545377.png)





![image-20200806185615011](assets/image-20200806185615011.png)



查询 



# 用户

创建用户

```
mongo>db.createUser(
{ user: "<name>",
pwd: "<cleartext password>",
customData: { <any information> },
roles: [
{ role: "<role>", db: "<database>" } | "<role>",
...
]}
)
```

账号 密码  角色  必须的 

![image-20200806185905636](assets/image-20200806185905636.png)



![image-20200806185913300](assets/image-20200806185913300.png)



![image-20200806190057996](assets/image-20200806190057996.png)

认证成功 



![image-20200806190116191](assets/image-20200806190116191.png)





![image-20200806190207188](assets/image-20200806190207188.png)





![image-20200806190259885](assets/image-20200806190259885.png)





![image-20200806190310846](assets/image-20200806190310846.png)





例子：
创建root用户，角色为root

```json
use admin
db.createUser(
{
user:"root",
pwd:"123",
roles:[{role:"root",db:"admin"}]
}
)
```

内置角色如下：
1. 数据库用户角色：read、readWrite;
2. 数据库管理角色：dbAdmin、dbOwner、userAdmin；

3. 集群管理角色：clusterAdmin、clusterManager、clusterMonitor、hostManager；
4. 备份恢复角色：backup、restore；
5. 所有数据库角色：readAnyDatabase、readWriteAnyDatabase、userAdminAnyDatabase、
dbAdminAnyDatabase
6. 超级用户角色：root

# 认证登录

为了安全需要，Mongodb要打开认证开关，即用户连接Mongodb要进行认证，其中就可以通过账号密码方式进行
认证。
1、在mono.conf中设置 auth=true
2、重启Mongodb
3、使用账号和密码连接数据库
1）mongo.exe连接

```
mongo.exe ‐u root ‐p 123 ‐‐authenticationDatabase admin
```

2）Studio 3T连接

![image-20200806185258085](assets/image-20200806185258085.png)

查询用户

查询当前库下的所有用户：
show users

![image-20200806190610419](assets/image-20200806190610419.png)



删除用户
语法格式：

db.dropUser("用户名")
例子：
删除test1用户
db.dropUser("test1")

修改用户
语法格式：

```json
db.updateUser(
"<username>",
{
customData : { <any information> },
roles : [
{ role: "<role>", db: "<database>" } | "<role>",
...
],
pwd: "<cleartext password>"
},
writeConcern: { <write concern> })
```

例子：
先创建test1用户：

```json
db.createUser(
{
user:"test1",
pwd:"test1",
roles:[{role:"root",db:"admin"}]
}
)
```

修改test1用户的角色为readWriteAnyDatabase

```
use admin
db.updateUser("test1",{roles:[{role:"readWriteAnyDatabase",db:"admin"}]})
```

修改密码
语法格式：
db.changeUserPassword("username","newPasswd")
例子：

修改test1用户的密码为123
use admin
db.changeUserPassword("test1","123")
