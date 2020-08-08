# 学成在线 第3天 讲义-CMS页面管理开发

# 1 自定义条件查询

## 1.1 需求分析

在页面输入查询条件，查询符合条件的页面信息。
查询条件如下：
站点Id：精确匹配
模板Id：精确匹配
页面别名：模糊匹配
...

Could not find artifact org.springframework.cloud:spring-cloud-starter-feign:pom:unknown in alimaven (http://maven.aliyun.com/nexus/content/groups/public/)

看了下 是没有去中央仓库（http://repo.maven.apache.org/maven2）下载jar包
几次reimport还是没有结果，看了别人的博客后进行了第一步设置

1.设置maven的setting

这一步做完我神清气爽啊。等几分钟后，问题解决了。如上图没有红线报错了。
希望下一次注意。

```
 <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-feign</artifactId>
        </dependency>
```

一般使用

```
<!-- SpringCloud 整合 Feign -->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-feign</artifactId>
</dependency>
```

换成因为版本的原因如果有父工程记得把父工程中的版本控制删除要不不能更新

```
 <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
```



## 1.2 服务端

1.2.1 Dao

