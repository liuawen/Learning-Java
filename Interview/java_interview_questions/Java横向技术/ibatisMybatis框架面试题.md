# ibatis/MyBatis面试题

## 问：介绍一下Mybatis和主要的工作过程？

**参考答案：**

每一个Mybatis的应用程序都以一个SqlSessionFactory对象的实例为核心。首先用字节流通过Resource将配置文件读入，然后通过SqlSessionFactoryBuilder().build方法创建SqlSessionFactory，然后再通过SqlSessionFactory.openSession()方法创建一个SqlSession为每一个数据库事务服务。

经历了Mybatis初始化 –>创建SqlSession –>运行SQL语句，返回结果三个过程。

##  

## 问：MyBatis编程步骤是什么样的？

**参考答案：**

1、创建SqlSessionFactory

2、通过SqlSessionFactory创建SqlSession

3、通过sqlsession执行数据库操作

4、调用session.commit()提交事务

5、调用session.close()关闭会话



## 问：什么是Mybatis的动态SQL？都有哪些标签？能简述一下动态sql的执行原理不？

**参考答案：**

Mybatis 动态 SQL ，可以让我们在 XML 映射文件内，以 XML 标签的形式编写动态 SQL ，完成逻辑判断和动态拼接 SQL 的功能。   

Mybatis 提供了 9 种动态 SQL 标签：if、choose 、when 、otherwise 、trim 、where 、set 、foreach、bind

执行原理为，使用OGNL从sql参数对象中计算表达式的值，**根据表达式的值动态拼接sql，以此来完成动态sql的功能**。

##  

## 问：MyBatis 的一级缓存和二级缓存的概念和实现原理？

**参考答案：**

MyBatis的缓存分为一级缓存和二级缓存，一级缓存放在session里面，默认就有；二级缓存放在它的命名空间里，默认是不打开的，使用二级缓存属性类需要实现Serializable序列化接口(可用来保存对象的状态)，可在它的映射文件中配置。

具体来说：

1、一级缓存是指SQLSession，一级缓存的作用域是SQlSession, Mabits默认开启一级缓存。 在同一个SqlSession中，执行相同的SQL查询时；第一次会去查询数据库，并写在缓存中，第二次会直接从缓存中取。 当执行SQL时候两次查询中间发生了增删改的操作，则SQLSession的缓存会被清空。 每次查询会先去缓存中找，如果找不到，再去数据库查询，然后把结果写到缓存中。 Mybatis的内部缓存使用一个HashMap，key为hashcode+statementId+sql语句。Value为查询出来的结果集映射成的java对象。 SqlSession执行insert、update、delete等操作commit后会清空该SQLSession缓存。**
**

2、二级缓存是mapper级别的，Mybatis默认是没有开启二级缓存的（**可通过配置文件****cacheEnabled=true开启）**。 第一次调用mapper下的SQL去查询用户的信息，查询到的信息会存放代该mapper对应的二级缓存区域。 第二次调用namespace下的mapper映射文件中，相同的sql去查询用户信息，会去对应的二级缓存内取结果。

二级缓存缺点：二级缓存是建立在同一个namespace下的，如果对表的操作查询可能有多个namespace，那么得到的数据就是错误的。

举个简单的例子:

订单和订单详情，orderMapper、orderDetailMapper。在查询订单详情时我们需要把订单信息也查询出来，那么这个订单详情的信息被二级缓存在orderDetailMapper的namespace中，这个时候有人要修改订单的基本信息，那就是在orderMapper的namespace下修改，他是不会影响到orderDetailMapper的缓存的，那么你再次查找订单详情时，拿到的是缓存的数据，这个数据其实已经是过时的。

当开启缓存后，数据的查询执行的流程就是 二级缓存 -> 一级缓存 -> 数据库。



## 问：Mybatis 是如何进行分页的？分页插件的原理是什么？

**参考答案：**

Mybatis 使用 RowBounds 对象进行分页，它是针对 ResultSet 结果集执行的内存分页，而非数据库分页。所以，实际场景下，不适合直接使用 MyBatis 原有的 RowBounds 对象进行分页。而是使用如下两种方案：

1、在 SQL 内直接书写带有数据库分页的参数来完成数据库分页功能；

2、使用分页插件来完成数据库分页。

这两者都是基于数据库分页，差别在于前者是工程师手动编写分页条件，后者是插件自动添加分页条件。分页插件的基本原理是使用 Mybatis 提供的插件接口，实现自定义分页插件。在插件的拦截方法内，拦截待执行的 SQL ，然后重写 SQL ，根据dialect 方言，添加对应的物理分页语句和物理分页参数。比如说`select * from student，拦截sql后重写为：select t.* from （select * from student）t limit 0，10`

##  

## 问： 通常一个Xml映射文件，都会写一个Mapper接口与之对应，请问，这个Mapper接口的工作原理是什么？Mapper接口里的方法，参数不同时，方法能重载吗？

**参考答案：**

Mapper接口，接口的全限名，就是映射文件中的namespace的值，接口的方法名，就是映射文件中MappedStatement的id值，接口方法内的参数，就是传递给sql的参数。

Mapper接口是没有实现类的，当调用接口方法时，接口全限名+方法名拼接字符串作为key值，可唯一定位一个MappedStatement，Dao接口里的方法，是不能重载的，因为是全限名+方法名的保存和寻找策略。

Dao接口的工作原理是JDK动态代理，Mybatis运行时会使用JDK动态代理为Dao接口生成代理proxy对象，代理对象proxy会拦截接口方法，转而执行MappedStatement所代表的sql，然后将sql执行结果返回。

##  

## 问：Mybatis中的Dao接口和XML文件里的SQL是如何建立关系的？

**参考答案：**

1、解析XML： 初始化SqlSessionFactoryBean会将mapperLocations路径下所有的XML文件进行解析：

①、创建SqlSource： Mybatis会把每个SQL标签封装成SqlSource对象，可以为动态SQL和静态SQL

②、创建MappedStatement： XML文件中的每一个SQL标签就对应一个MappedStatement对象 ，并由 Configuration解析XML

2、Dao接口代理： Spring中的FactoryBean 和 JDK动态代理返回了可以注入的一个Dao接口的代理对象

3、执行： 通过statement全限定类型+方法名拿到MappedStatement 对象，然后通过执行器Executor去执行具体SQL并返回。





## 问：当实体类中的属性名和表中的字段名不一样 ，怎么办 ？

**参考答案：**

1、 通过在查询的sql语句中**定义字段名的别名，让字段名的别名和实体类的属性名一致**

```xml
<select id="selectorder" parametertype="int" resultetype="com.imooc.order"> 
       select order_id id, order_no orderno ,order_price price form orders where order_id=#{id}; 
    </select> 
```

2、 通过resultMap来映射字段名和实体类属性名的一一对应的关系

```xml
<select id="getOrder" parameterType="int" resultMap="orderresultmap">
        select * from orders where order_id=#{id}
    </select>
   <resultMap type="com.imooc.order" id="orderresultmap"> 
        <!–用id属性来映射主键字段–> 
        <id property="id" column="order_id"> 
        <!–用result属性来映射非主键字段，property为实体类属性名，column为数据表中的属性–> 
        <result property = "orderno" column ="order_no"/> 
        <result property="price" column="order_price" /> 
    </reslutMap>
```



## 问：JDBC编程有哪些不足之处，MyBatis是如何解决这些问题的？

**参考答案：**

数据库链接创建、释放频繁造成系统资源浪费从而影响系统性能，如果使用数据库链接池可解决此问题。 解决：在SqlMapConfig.xml中配置数据链接池，使用连接池管理数据库链接。

Sql语句写在代码中造成代码不易维护，实际应用sql变化的可能较大，sql变动需要改变java代码。 解决：将Sql语句配置在XXXXmapper.xml文件中与java代码分离。

向sql语句传参数麻烦，因为sql语句的where条件不一定，可能多也可能少，占位符需要和参数一一对应。 解决： Mybatis自动将java对象映射至sql语句。

对结果集解析麻烦，sql变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成pojo对象解析比较方便。 解决：Mybatis自动将sql执行结果映射至java对象。

## 



## 问：使用MyBatis的mapper接口调用时有哪些要求？

**参考答案：**

1、Mapper接口方法名和mapper.xml中定义的每个sql的id相同

2、Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql 的parameterType的类型相同

3、Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同

4、Mapper.xml文件中的namespace即是mapper接口的类路径。



## 问：SqlMapConfig.xml中配置有哪些内容？

**参考答案：**

properties（属性） settings（配置） typeAliases（类型别名） typeHandlers（类型处理器） objectFactory（对象工厂） plugins（插件） environments（环境集合属性对象） environment（环境子属性对象） transactionManager（事务管理） dataSource（数据源） mappers（映射器）



## 问：Mapper编写有哪几种方式？

**参考答案：**

1、接口实现类继承SqlSessionDaoSupport 使用此种方法需要编写mapper接口，mapper接口实现类、mapper.xml文件

①、在sqlMapConfig.xml中配置mapper.xml的位置

```xml
<mappers>
    <mapper resource="mapper.xml文件的地址" />
    <mapper resource="mapper.xml文件的地址" />
</mappers>
```

② 、定义mapper接口

③ 、实现类集成SqlSessionDaoSupport。mapper方法中可以this.getSqlSession()进行数据增删改查。

④、spring 配置

```xml
<bean id=" " class="mapper接口的实现">
    <property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
</bean>
```

2、使用org.mybatis.spring.mapper.MapperFactoryBean

①、在sqlMapConfig.xml中配置mapper.xml的位置。如果mapper.xml和mappre接口的名称相同且在同一个目录，这里可以不用配置

```xml
<mappers>
    <mapper resource="mapper.xml文件的地址" />
    <mapper resource="mapper.xml文件的地址" />
</mappers>
```

②、定义mapper接口

注意

(1)、mapper.xml中的namespace为mapper接口的地址

(2)、mapper接口中的方法名和mapper.xml中的定义的statement的id保持一致

(3)、 Spring中定义

```xml
<bean id="" class="org.mybatis.spring.mapper.MapperFactoryBean">
    <property name="mapperInterface"   value="mapper接口地址" /> 
    <property name="sqlSessionFactory" ref="sqlSessionFactory" /> 
</bean>
```

3、使用mapper扫描器

①、mapper.xml文件编写

> 注意： mapper.xml中的namespace为mapper接口的地址 mapper接口中的方法名和mapper.xml中的定义的statement的id保持一致 如果将mapper.xml和mapper接口的名称保持一致则不用在sqlMapConfig.xml中进行配置

②、定义mapper接口

> 注意mapper.xml的文件名和mapper的接口名称保持一致，且放在同一个目录

③、配置mapper扫描器

```xml
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="mapper接口包地址"></property>
    <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/> 
</bean>
```

④、使用扫描器后从spring容器中获取mapper的实现对象扫描器将接口通过代理方法生成实现对象，要spring容器中自动注册，名称为mapper 接口的名称。



## 问：在mapper中如何传递多个参数?

**参考答案：**

**1、使用占位符的思想**

① 在映射文件中使用#{0},#{1}代表传递进来的第几个参数

```xml
//对应的xml,#{0}代表接收的是dao层中的第一个参数，#{1}代表dao层中第二参数，更多参数一致往后加即可。
<select id="selectUser"resultMap="BaseResultMap">  
    select *  fromuser_user_t   whereuser_name = #{0} anduser_area=#{1}  
</select>  
复制代码
```

② 使用@param注解:来命名参数 

```xml
public interface usermapper { 
         user selectuser(@param(“username”) string username, 
         @param(“hashedpassword”) string hashedpassword); 
        }
复制代码
<select id=”selectuser” resulttype=”user”> 
         select id, username, hashedpassword 
         from some_table 
         where username = #{username} 
         and hashedpassword = #{hashedpassword} 
    </select>
复制代码
```

**第二种：使用Map集合作为参数来装载**

```xml
try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            /**
             * 由于我们的参数超过了两个，而方法中只有一个Object参数收集
             * 因此我们使用Map集合来装载我们的参数
             */
            Map<String, Object> map = new HashMap();
            map.put("start", start);
            map.put("end", end);
            return sqlSession.selectList("StudentID.pagination", map);
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
复制代码
<!--分页查询-->
    <select id="pagination" parameterType="map" resultMap="studentMap">
        /*根据key自动找到对应Map集合的value*/
        select * from students limit #{start},#{end};
    </select>
复制代码
```

##  



## 问：Mybatis的Xml映射文件中，不同的Xml映射文件，id是否可以重复？

**参考答案：**

如果配置了namespace那么当然是可以重复的，因为我们的Statement实际上就是namespace+id

如果没有配置namespace的话，那么相同的id就会导致覆盖了。

##  



## 问：Mybatis比IBatis比较大的几个改进是什么

**参考答案：**

1、有接口绑定,包括注解绑定sql和xml绑定Sql ；

2、动态sql由原来的节点配置变成OGNL表达式；

3、在一对一,一对多的时候引进了association,在一对多的时候引入了collection节点,不过都是在resultMap里面配置。

##  

## 问：接口绑定有几种实现方式,分别是怎么实现的?

**参考答案：**

两种实现方式：

1、通过注解绑定,就是在接口的方法上面加上@Select@Update等注解里面包含Sql语句来绑定；

2、通过xml里面写SQL来绑定,在这种情况下,要指定xml映射文件里面的namespace必须为接口的全路径名.





## 问：简述Mybatis的插件运行原理，以及如何编写一个插件

**参考答案：**

Mybatis仅可以编写针对ParameterHandler、ResultSetHandler、StatementHandler、Executor这4种接口的插件，Mybatis使用JDK的动态代理，为需要拦截的接口生成代理对象以实现接口方法拦截功能，每当执行这4种接口对象的方法时，就会进入拦截方法，具体就是InvocationHandler的invoke()方法，当然，只会拦截那些你指定需要拦截的方法。

实现Mybatis的Interceptor接口并复写intercept()方法，然后在给插件编写注解，指定要拦截哪一个接口的哪些方法即可，记住，别忘了在配置文件中配置你编写的插件。

##  

## 问：Mybatis是否支持延迟加载？如果支持，它的实现原理是什么？

**参考答案：**

Mybatis仅支持association关联对象和collection关联集合对象的延迟加载，association指的就是一对一，collection指的就是一对多查询。在Mybatis配置文件中，**可以配置是否启用延迟加载**    

```
lazyLoadingEnabled=true|false。
```

它的原理是，**使用CGLIB创建目标对象的代理对象**，当调用目标方法时，**进入拦截器方法**，比如调用a.getB().getName()，拦截器invoke()方法发现a.getB()是null值，那么就会单独发送事先保存好的查询关联B对象的sql，把B查询上来，然后调用a.setB(b)，于是a的对象b属性就有值了，接着完成a.getB().getName()方法的调用。这就是延迟加载的基本原理。

当然了，不光是Mybatis，几乎所有的包括Hibernate，支持延迟加载的原理都是一样的。





## 问：Mybatis都有哪些Executor执行器？它们之间的区别是什么？

**参考答案：**

Mybatis有三种基本的Executor执行器，SimpleExecutor、ReuseExecutor、BatchExecutor。

1、SimpleExecutor：每执行一次update或select，就开启一个Statement对象，用完立刻关闭Statement对象。

2、ReuseExecutor：执行update或select，以sql作为key查找Statement对象，存在就使用，不存在就创建，用完后，不关闭Statement对象，而是放置于Map<String, Statement>内，供下一次使用。简言之，就是重复使用Statement对象。

3、BatchExecutor：执行update（没有select，JDBC批处理不支持select），将所有sql都添加到批处理中（addBatch()），等待统一执行（executeBatch()），它缓存了多个Statement对象，每个Statement对象都是addBatch()完毕后，等待逐一执行executeBatch()批处理。与JDBC批处理相同。

   Executor的这些特点，都严格限制在SqlSession生命周期范围内。

## 
