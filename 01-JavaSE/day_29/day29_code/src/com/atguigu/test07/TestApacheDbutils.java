package com.atguigu.test07;

/*
 * commons-dbutils 是 Apache 组织提供的一个开源 JDBC工具类库，它是对JDBC的简单封装，学习成本极低，
 * 并且使用dbutils能极大简化jdbc编码的工作量，同时也不会影响程序的性能。
 * 
 * 如何使用？
 * （1）加入jar并且添加build path中
 * （2）修改BasicDAOImpl类
 * 
 * 
 * QueryRunner该类封装了SQL的执行，是线程安全的。
（1）可以实现增、删、改、查、批处理、
（2）考虑了事务处理需要共用Connection。
（3）该类最主要的就是简单化了SQL查询，它与ResultSetHandler组合在一起使用可以完成大部分的数据库操作，能够大大减少编码量。

ResultSetHandler接口在查询时要用：
 * 该接口用于处理 java.sql.ResultSet，将数据按要求转换为另一种形式。
 * 该接口有如下实现类可以使用：
BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
ScalarHandler：查询单个值对象
MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
ColumnListHandler：将结果集中某一列的数据存放到List中。
KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里，再把这些map再存到一个map里，其key为指定的key。
ArrayHandler：把结果集中的第一行数据转成对象数组。
ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
 */
public class TestApacheDbutils {

}
