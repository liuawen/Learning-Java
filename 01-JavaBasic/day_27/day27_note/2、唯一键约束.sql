1、唯一键约束
特点：
（1）一个表可以有多个唯一键约束
（2）唯一键约束意味着，唯一，可以为NULL
（3）唯一键的约束名可以自己指定，也可以默认，
如果默认的话，一般如果单列唯一，默认就是列名，
如果是多列组合唯一，那么默认是该组合第1列的名称。
（4）创建唯一键约束，也会在对应列上建立索引。
而且删除唯一键约束的方式是通过删除对应索引来实现的。

2、唯一键约束也是分为两种
（1）单列的唯一键
（2）多列组合的唯一键

3、建表时如何指定唯一键
create table 【数据库名.】表名称(
	字段名1 数据类型  primary key,
	字段名2 数据类型 unique key， #只适用于单列的唯一键
	。。。。
);

create table 【数据库名.】表名称(
	字段名1 数据类型  primary key,
	字段名2 数据类型,
	。。。。,
	unique key(字段列) #既适用于单列，也适用于多列
);

create table books(
	bid int primary key,
	bname varchar(20) unique key,
	price double
);

insert into books values
(1,'《从入门到放弃》',100),
(2,'《从入门到放弃》',88);
ERROR 1062 (23000): Duplicate entry '《从入门到放弃》' for key 'bname' 

insert into books values
(1,'《从入门到放弃》',100),
(2,'《从入门到成功》',88);

4、建表后如何指定唯一键约束
alter table 【数据库名.】表名称 add unique key(字段列表);

create table books(
	bid int primary key,
	bname varchar(20) ,
	price double
);
alter table books add unique key(bname);

5、删除唯一键约束
alter table 【数据库名.】表名称 drop index 索引名;

alter table books drop index bname;

6、如何查看某个表格的索引名
show index from 【数据库名.】表名称;

show index from books;

