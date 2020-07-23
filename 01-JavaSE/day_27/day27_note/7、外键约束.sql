1、外键约束
特点：
（1）一个表可以有很多个外键约束
（2）外键约束是需要一个表的两个字段或两个表的两个字段之间建立外键约束
（3）外键约束一定是在从表/子表中建立的
（4）在从表中外键约束的列，与在主表中外键约束参考的列，这两个列的名称可以不同，
但是意义、数据类型必须一致。
（5）外键约束是同时约束双方的行为的
对于主表来说：修改和删除就受约束了
对于从表来说：添加和修改就受约束了
（6）主表被参考的字段/列必须是键列

建表时，先建主表，再建从表。
删表时，先删从表，再删主表。

从表、子表：参考别人的，依赖别人的
主表、父表：被参考的，被依赖的
举例：
（1）部门表和员工表
	员工表中有一个字段，表示该员工所在的部门
	部门表是主表
	员工表是从表，说员工选择进入哪个部门
	这样的话，外键建立在员工表
	
	部门表中表示部门编号，用did表示,int类型
	员工表中表示该员工所在的部门，我用编号表示，可以使用did，也可以使用deptid int类型
	
（2）学生表，课程表，选课表
	主表：学生表和课程表
	从表：选课表，这个表有两个外键，一个参考学生表，一个参考课程表
	

2、约束的等级（5个）
（1）Cascade方式：级联
	主动权在主表上。
	如果主表被依赖字段修改了，从表对应的外键字段跟着修改
	如果主表被依赖字段的记录删除了，从表对应的外键字段的记录也会删除
（2）Set null方式
	主动权在主表上。
	如果主表被依赖字段修改了，从表对应的外键字段设置为null
	如果主表被依赖字段的记录删除了，从表对应的外键字段的值设置为null
	这里要求，外键字段必须不能有非空约束。
（3）No action方式：不作为
（4）Restrict方式：严格
  （3）（4），如果主表的被依赖字段的值被引用了，那么主表对该字段的修改和删除就被完全限制了。就不能和删除。
  （3）（4）主表没有主动权。必须先处理从表对应的值，然后才能修改和删除。
（5）Set default方式：mysql的Innodb引擎不支持。  
  
3、如何在建表时指定外键
create table 【数据库名.】从表名称(
	字段名1 xxInt  primary key auto_increment,
	字段名2 数据类型 【unique key】【not null】 default 默认值,
	字段名3 数据类型 default 默认值，
	。。。。,
	foreign key(从表的某字段) references 主表名(被参考字段) 【on update 等级】【on delete 等级】 
);
  
例如：
create database 0513db;
use 0513db;

#主表
create table dept(
	did int ,
	dname varchar(20)
);	

#从表
create table emp(
	eid int primary key,
	ename varchar(20),
	did int,
	foreign key(did) references dept(did) on update cascade on delete set null
);
insert into emp values(1,'张三',1);#错误的，因为主表还没有对应记录
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`test`.`emp`, CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`did`) REFERENCES `dept` (`did`) ON DELETE SET NULL ON UPDATE CASCADE)


insert into dept values(1,'咨询部'),(2,'教学部')
insert into emp values(1,'张三',1);
mysql> insert into emp values(2,'李四',4);
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`test`.`emp`, CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`did`) REFERENCES `dept` (`did`) ON DELETE SET NULL ON UPDATE CASCADE)

delete from dept where did = 1;
update dept set did = 5 where did = 2;

4、建表后如何指定外键
alter table 【数据库名.】从表名称 add foreign key(从表的某字段) references 主表名(主表被引用字段) 【on update 等级】【on delete 等级】 ;

5、如何删除外键
alter table 【数据库名.】从表名称 drop foreign key 约束名;

alter table emp drop foreign key emp_ibfk_1;

6、如何查看某个表的外键约束名
SELECT * FROM information_schema.table_constraints WHERE table_name = '表名称';
	
	
SELECT * FROM information_schema.table_constraints WHERE table_name = 'emp';	