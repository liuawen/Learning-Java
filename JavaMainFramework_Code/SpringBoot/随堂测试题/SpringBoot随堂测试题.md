# SpringBoot随堂测试题

#### 1、关于SpringBoot的描述，错误的是（ D ）

A、SpringBoot是基于约定优于配置的原则的

B、SpringBoot通过起步依赖和自动配置简化简化开发

C、SpringBoot可以对Spring的配置进行简化

D、SpringBoot不能集成其他技术

#### 2、以下注解描述错误的是（ C ）

A、@ComponentScan指定了要扫描指定基本包下的类

B、@SpringBootConfiguration与@Configuration功能类似，标注该类是Spring的一个配置类

C、@SpringBootApplication要配置在控制类Controller上

D、@EnableAutoConfiguration是SpringBoot自动配置功能开启的注解

#### 3、关于SpringBoot的配置文件，描述正确的是（ ABCD ）

A、SpringBoot是基于约定的，所以很多配置都有默认值，但如果想使用自己的配置替换默认配置的话，就可以使用application.properties或者application.yml（application.yaml）进行配置

B、SpringBoot默认会从Resources目录下加载application.properties或application.yml（application.yaml）文件

C、application.properties文件是键值对类型的文件

D、YML文件格式是YAML (YAML Aint Markup Language)编写的文件格式，YAML是一种直观的能够被电脑识别的的数据数据序列化格式，并且容易被人类阅读，容易和脚本语言交互的，可以被支持YAML库的不同的编程语言程序导入

#### 4、使用yml配置信息，格式错误的是（ D ）

A、配置Person对象的姓名，如下

```yaml
name: haohao
```

B、配置Person对象的姓名，年龄，地址信息，如下

```yaml
person:
  name: haohao
  age: 31
  addr: beijing

#或者

person: {name: haohao,age: 31,addr: beijing}
```

C、配置数组（List、Set）数据，如下

```yaml
city:
  - beijing
  - tianjin
  - shanghai
  - chongqing
  
#或者

city: [beijing,tianjin,shanghai,chongqing]
```

D、配置对象集合，List<Student>，如下

```yaml
student:
  - name: zhangsan
  - age: 18
  - score: 100
  - name: lisi
  - age: 28
  - score: 88
  - name: wangwu
  - age: 38
  - score: 90
```

#### 5、关于SpringBoot整合其他技术，正确的是（ ABC ）

A、整合Mybatis时，可以在application.properties中配置mybatis.mapper-locations指定要加载的映射文件

B、整合Junit时，需要在测试类上添加@RunWith(SpringRunner.class)

C、整合SpringData JPA时，需要添加SpringData JPA的起步依赖spring-boot-starter-data-jpa

D、以上说法都不正确