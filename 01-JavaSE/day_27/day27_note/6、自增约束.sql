1、自增约束
特点：
（1）一个表只能有一个自增约束
因为一个表只有一个维护自增值的变量。
（2）自增约束的列只能是整数列
（3）自增约束的列必须是键列（主键，唯一键，外键），
实际中一般是主键自增最多

2、如何在建表时指定某个列自增
create table 【数据库名.】表名称(
	字段名1 xxInt  primary key auto_increment,
	字段名2 数据类型 【unique key】【not null】 default 默认值,
	字段名3 数据类型 default 默认值，
	。。。。
);

create table t_stu(
	sid int auto_increment, #错误 
	sname varchar(20)
);
ERROR 1075 (42000): Incorrect table definition; 
there can be only one auto column and it must be defined as a key

create table t_stu(
	sid int primary key auto_increment,
	sname varchar(20)
);

mysql> desc t_stu;
+-------+-------------+------+-----+---------+----------------+
| Field | Type        | Null | Key | Default | Extra          |
+-------+-------------+------+-----+---------+----------------+
| sid   | int(11)     | NO   | PRI | NULL    | auto_increment |
| sname | varchar(20) | YES  |     | NULL    |                |
+-------+-------------+------+-----+---------+----------------+
2 rows in set (0.01 sec)


3、如何给自增列添加数据呢
自增列，如果指定值，就按照指定的来，如果没有指定值就自增。
如果指定的值是0或null，就按照自增的来。


insert into t_stu values('张三');#错误的
ERROR 1136 (21S01): Column count doesn't match value count at row 1' 

insert into t_stu(sname) values('张三');  #sid=1
insert into t_stu(sname) values('李四');  #sid=2

insert into t_stu values(5,'王五');      #sid=5
insert into t_stu(sname) values('赵六');  #sid=6
insert into t_stu values(0,'钱七');     #sid=7
insert into t_stu values(null,'王八');   #sid = 8
insert into t_stu values(-1,'负数'); 	#sid=-1
insert into t_stu(sname) values('测试');	#sid=9
insert into t_stu values(3,'333');         #sid=3
insert into t_stu(sname) values('测试顶顶顶顶');#sid=10

建议：正常使用时，不要乱插

4、建表后增加自增
alter table 【数据库名.】表名称 modify 字段名 数据类型 auto_increment;

5、如何取消自增
alter table 【数据库名.】表名称 modify 字段名 数据类型;

