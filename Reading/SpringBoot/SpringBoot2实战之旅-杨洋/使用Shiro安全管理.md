# 使用Shiro安全管理

安全是每一个应用都必须面对的问题 

一个应用没有设置好安全框架  那么很容易被别人利用 做一些非法的事情

Java安全框架  Apache Shiro 使用SpringBoot结合二者进行简单的权限控制使用 

简单实用Shiro进行认证和授权

Spring Boot如何使用Shiro进行身份认证和权限认证。

Apache Shiro（官网地址：http://shiro.apache.org/）是一个功能强大且易于使用的Java安全框架，可以利用它进行身份验证、授权、加密和会话管理。通过使用Shiro易于理解的API文档，可以轻松地构建任何应用程序。

```
Apache Shiro™ is a powerful and easy-to-use Java security framework that performs authentication, authorization, cryptography, and session management. With Shiro’s easy-to-understand API, you can quickly and easily secure any application – from the smallest mobile applications to the largest web and enterprise applications.
```

Apache Shiro易于使用和理解  尽可能掩盖复杂性，并提供简洁直观的API，以简化开发人员的工作，并确保其应用程序安全地工作。

Apache经常做的一些事情：

身份验证、授权、加密和会话管理

* 验证用户身份
* 为用户执行访问控制 ，例如确定是否为用户分配了某个安全角色或确定是否允许用户执行某些操作。
* 在任何环境中使用Session API，即使没有Web容器或EJB容器也是如此。
* 在身份验证、访问控制或会话生命周期内对事件做出反应。
* 聚合用户安全数据的一个或多个数据源，并将其全部显示为单个复合用户“视图”。
* 启用单点登录（SSO）功能。•　无须登录即可为用户关联启用“记住我”服务。

验证用户身份 访问控制  使用Session API 

单点登录  单点登录的英文名叫做：Single Sign On（简称**SSO**）。

单系统 所有的功能都在同一个系统上

单系统 拆分  多个子系统 

**在多个系统中，用户只需一次登录，各个系统即可感知该用户已经登录。**



“应用程序安全的4大基石”——身份验证、授权、会话管理和加密。

身份认证：其实身份认证可以理解为“登录”。

授权：授权是指一些权限的认证，比如管理员可以访问所有页面，但是普通用户只能访问部分页面。

会话管理：可以理解为Shiro为我们管理用户的会话（如Session）。

加密：使用加密算法来保证数据的安全

还提供了其他功能

Web支持：Shiro的Web支持API可帮助用户轻松保护Web应用程序。

缓存：Shiro提供了缓存，可以确保安全操作保持快速高效。

并发：Apache Shiro支持具有并发功能的多线程应用程序。

测试：存在测试支持以帮助用户编写单元和集成测试，并确保代码按预期受到保护。•运行方式：允许用户假定其他用户的身份（如果允许）的功能，有时在管理方案中很有用。

使用Shiro做权限控制



记住我：记住用户在会话中的身份，这样他们只需要在强制要求时登录。

```java
/**
* @author law
* @version 1.0
*/
```



小结：

Shiro是由Apache开源的一款强大的安全框架 

[https://shiro.apache.org/](https://shiro.apache.org/)

身份验证、授权、加密和会话管理







