00:24:42,164  INFO C3P0Registry:204 - Initializing c3p0-0.9.1.2 [built 21-May-2007 15:04:56; debug? true; trace: 10]
00:24:42,443  WARN XmlWebApplicationContext:558 - Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'userService' defined in class path resource [applicationContext.xml]: Error setting property values; nested exception is org.springframework.beans.NotWritablePropertyException: Invalid property 'roleDao' of bean class [cn.liuawen.service.impl.UserServiceImpl]: Bean property 'roleDao' is not writable or has an invalid setter method. Does the parameter type of the setter match the return type of the getter?
00:24:42,458 ERROR ContextLoader:316 - Context initialization failed
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'userService' defined in class path resource [applicationContext.xml]: Error setting property values; nested exception is org.springframework.beans.NotWritablePropertyException: Invalid property 'roleDao' of bean class [cn.liuawen.service.impl.UserServiceImpl]: Bean property 'roleDao' is not writable or has an invalid setter method. Does the parameter type of the setter match the return type of the getter?
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1642)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1357)





UserServiceImpl

加上 

```
private RoleDao roleDao;

 public void setRoleDao(RoleDao roleDao) {
     this.roleDao = roleDao;
 }
```



![image-20200614091700983](assets/image-20200614091700983.png)



去掉项目名   



事务的控制

声明式事务