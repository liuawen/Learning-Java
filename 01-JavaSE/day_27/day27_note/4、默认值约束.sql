1、默认值约束
特点：
（1）一个表可以有很多的默认值约束
（2）默认值约束只能针对某一个字段来说
（3）默认值约束意味着，该字段如果没有手动赋值，会按默认值处理

2、如何在建表时指定默认值约束？
create table 【数据库名.】表名称(
	字段名1 数据类型  primary key,
	字段名2 数据类型 【unique key】【not null】 default 默认值,
	字段名3 数据类型 default 默认值，
	。。。。
);

例如：
create table test.t_stu(
	sid int primary key,
	sname varchar(20) not null,
	gender char default '男'
);

insert into t_stu values(1,'张三');
ERROR 1136 (21S01): Column count doesn't match value count at row 1 ' 列数与值数量不匹配

insert into t_stu values(1,'张三',default);
insert into t_stu(sid,sname) values(2,'李四');

3、建表后如何指定某个字段有默认值呢？
alter table 【数据库名.】表名称 modify 字段名 数据类型 default 默认值;

create table test.t_stu(
	sid int primary key,
	sname varchar(20) not null,
	gender char 
);
alter table t_stu modify gender char default '男';

提醒：如果某个字段既要非空，又要默认值，那么alter 语句后面两个都要写。
create table test.t_stu(
	sid int primary key,
	sname varchar(20) not null,
	gender char not null
);
增加gender还有默认值
alter table t_stu modify gender char default '男' not null;

4、如何取消某个字段的默认值约束
alter table 【数据库名.】表名称 modify 字段名 数据类型 【not null】; #不写默认值约束

insert into t_stu values (1,'张三','女');
update t_stu set gender = default where sid = 1;
