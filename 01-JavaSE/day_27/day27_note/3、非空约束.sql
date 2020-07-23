1、非空约束
特点：
（1）一个表可以有很多的非空约束
（2）非空约束只能针对某一个字段来说
（3）非空约束意味着，该字段不能存入null值

2、如何在建表时指定非空约束呢
create table 【数据库名.】表名称(
	字段名1 数据类型  primary key,
	字段名2 数据类型 【unique key】 not null,
	字段名3 数据类型 not null，
	。。。。
);

例如：
create table test.t_stu(
	sid int primary key,
	sname varchar(20) not null,
	gender char
);
insert into t_stu values(1,'张三','男');

insert into t_stu values(2,null,'男');#错误的
ERROR 1048 (23000): Column 'sname' cannot be null

insert into t_stu values(2,'李四',null);

3、建表后如何指定某个字段非空呢？
alter table 【数据库名.】表名称 modify 字段名 数据类型 not null;

create table test.t_stu(
	sid int primary key,
	sname varchar(20),
	gender char
);
alter table t_stu modify sname varchar(20) not null;

4、建表后，取消某个字段的非空约束
alter table 【数据库名.】表名称 modify 字段名 数据类型;

alter table t_stu modify sname varchar(20);