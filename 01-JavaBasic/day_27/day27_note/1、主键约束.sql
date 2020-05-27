1、主键约束
特点：
（1）一个表有且只能有一个主键约束
（2）主键约束意味着，唯一并且非空
（3）主键约束名PRIMARY
（4）创建主键会自动创建对应的索引，同样删除主键对应的索引也会删除

2、在建表的时候如何指定主键约束
create table 【数据库名.】表名称(
	字段名1 数据类型  primary key,
	字段名2 数据类型，
	。。。。
);

例如：
create table test.t_stu(
	sid int primary key,
	sname varchar(20),
	gender char
);

mysql> desc t_stu;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| sid    | int(11)     | NO   | PRI | NULL    |       |
| sname  | varchar(20) | YES  |     | NULL    |       |
| gender | char(1)     | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

insert into t_stu values(1,'张三','男'),(1,'李四','女');#错误的

mysql> insert into t_stu values(1,'张三','男'),(1,'李四','女');
ERROR 1062 (23000): Duplicate entry '1' for key 'PRIMARY'  违反了主键约束

insert into t_stu values(1,'张三','男'),(2,'李四','女');

3、建表后如何指定主键约束
alter table 【数据库名.】表名称 add primary key(字段列表);

create table test.t_stu(
	sid int,
	sname varchar(20),
	gender char
);
alter table test.t_stu add primary key(sid);

4、主键约束分为两种：
（1）单列主键约束
（2）复合主键约束
建表时如何指定复合主键约束：
create table 【数据库名.】表名称(
	字段名1 数据类型,
	字段名2 数据类型，
	。。。。,
	primary key(字段列表)
);
建表后如何指定复合主键约束：
alter table 【数据库名.】表名称 add primary key(字段列表);

create table t_course(
	cid int primary key,
	cname varchar(20)
);

#现在要求sid和cid的组合是主键，是唯一的
create table xuanke(
	sid int,
	cid int,
	score int,
	primary key(sid,cid)
);

5、删除主键约束
alter table 【数据库名.】表名称 drop primary key;

