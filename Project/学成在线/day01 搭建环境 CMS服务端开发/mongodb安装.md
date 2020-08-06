# Mongodb安装

Mongodb

# mongodb介绍

# 下载mongodb

MongoDB 提供了可用于 32 位和 64 位系统的预编译二进制包，你可以从MongoDB官网下载安装。
官方地址：https://www.mongodb.com/
本教程下载3.4版本：http://downloads.mongodb.org/win32/mongodb-win32-x86_64-2008plus-ssl-v3.4-
latest-signed.msi

# 安装mongodb

在win7系统安装mongodb需要vc++运行库，如果没有则会提示“无法启动此程序，因为计算机中丢失
VCRUNTIME140.dll”。
去网上下载或使用360安装：

![image-20200804204243239](assets/image-20200804204243239.png)

运行 mongodb-win32-x86_64-2008plus-ssl-v3.4-latest-signed.msi



![image-20200804204257854](assets/image-20200804204257854.png)



![image-20200804204302282](assets/image-20200804204302282.png)



![image-20200804204309119](assets/image-20200804204309119.png)



![image-20200804204321762](assets/image-20200804204321762.png)



启动mongodb



创建几个文件夹具体如下：数据库路径（data目录）、日志路径（logs目录）和日志文件（mongo.log文件）
北

![image-20200804204341671](assets/image-20200804204341671.png)

创建配置文件mongo.conf，文件内容如下：

```
#数据库路径
dbpath=d:\MongoDB\Server\3.4\data
#日志输出文件路径
logpath=d:\MongoDB\Server\3.4\logs\mongo.log
#错误日志采用追加模式
logappend=true
#启用日志文件，默认启用
journal=true
#这个选项可以过滤掉一些无用的日志信息，若需要调试使用请设置为false
quiet=true
#端口号 默认为27017
port=27017
```

安装 MongoDB服务
通过执行bin/mongod.exe，使用--install选项来安装服务，使用--config选项来指定之前创建的配置文件。 cmd进
入d:\MongoDB\Server\3.4\bin

mongod.exe ‐‐config "d:\MongoDB\Server\3.4\mongo.conf" ‐‐install

启动MongoDB服务

```
net start MongoDB
```

关闭MongoDB服务

```
net stop MongoDB
```

移除MongoDB服务

```
" d:\MongoDB\Server\3.4\bin\mongod.exe" ‐‐remove
```

启动mongodb服务，
命令执行后，浏览器中输入http://127.0.0.1:27017看到如下界面即说明启动成功

![image-20200804204530492](assets/image-20200804204530492.png)



出现下图说明安装成功

![image-20200804204544865](assets/image-20200804204544865.png)

也可以通过bin目录下的mongo.exe连接mongodb

![image-20200804204601962](assets/image-20200804204601962.png)



