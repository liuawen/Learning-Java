#一、DDL
#（一）操作database的SQL
#1、查看当前mysql数据库管理软件中的所有数据库
show databases;

#2、使用某个数据库
use 数据库名;

#例如：use test;

#3、创建一个数据库
create database 数据库名;

#例如：
create database library;

#4、删除一个数据库
drop database 数据库名;

#例如：
drop database  0513db;

#（二）操作表结构的SQL
1、查看某个数据库下的所有表格
show tables;

mysql> show tables;
ERROR 1046 (3D000): No database selected
解决方案有两种：
（1）先use，再操作表格
use 数据库名;
show tables;
（2）show tables from 数据名;

2、创建某个表格
create table 【数据库名.】表名称(字段名1 数据类型,字段名2 数据类型,字段名3 数据类型);
create table 【数据库名.】表名称(
	字段名1 数据类型,
	字段名2 数据类型,
	字段名3 数据类型
);
说明：如果前面有use语句，那么【数据库名.】可以省略

例如：
create table test.t_stu(
	sid int,
	sname varchar(20),
	gender char,
	birthday date,
	score double
);

3、查看表结构
desc 表名称;

mysql> desc t_stu;
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| sid      | int(11)     | YES  |     | NULL    |       |
| sname    | varchar(20) | YES  |     | NULL    |       |
| gender   | char(1)     | YES  |     | NULL    |       |
| birthday | date        | YES  |     | NULL    |       |
| score    | double      | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
类似于通过Class对象看类的信息。

4、修改表名称
rename table 旧表名 to 新表名;
alter table 旧表名 rename 新表名;
例如：
rename table t_stu to student;
alter table student rename t_stu;

5、修改表结构
（1）增加一列，增加一个字段
alter table 表名称 add 【column】 字段名 数据类型; #默认添加到最后
alter table 表名称 add 【column】 字段名 数据类型 first;
alter table 表名称 add 【column】 字段名 数据类型 after 另一个字段;

例如：增加一列，存储电话号码
alter table t_stu add  tel char(11);

增加一列，存储地址，添加到第一列的位置
alter table t_stu add  address varchar(50) first;

增加一列，年龄，添加到sname的后面
alter table t_stu add  age int after sname;

（2）修改，字段的数据类型或位置
alter table 表名称 modify  【column】 字段名 新的数据类型;
alter table 表名称 modify  【column】 字段名 数据类型 first;
alter table 表名称 modify  【column】 字段名 数据类型 after 另一个字段;

例如：修改gender的数据类型为char(2)
alter table t_stu modify   gender char(2);
例如：修改address的位置到最后一列
alter table t_stu modify   address varchar(50) after tel;

（3）修改，列的名称
alter table 表名称 change  【column】 旧字段名  新的字段名 数据类型;
例如：修改列的名称tel为phone
alter table t_stu change tel phone char(11); 

（4）删除一列
alter table 表名称 drop 【column】 字段名;

例如：删除地址列
alter table t_stu drop address;

6、删除整张表
drop table 表名称;

例如：drop table t_stu;