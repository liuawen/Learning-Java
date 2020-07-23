#二、DML：增删改查    对应程序员来说，DML的重要性要比你掌握DDL还要重要。
1、添加数据，往表中插入数据
（1）insert into 【数据库名.】表名称 values(值列表);
		要求为所有列赋值，(值列表)的类型、数量与表结构中列的类型、数量一致
（2）insert into 【数据库名.】表名称(字段列表) values(值列表);
		为(字段列表)指定的列赋值，(值列表)的数量与(字段列表)的类型、数量对应
（3）insert into 【数据库名.】表名称 values(值列表1),(值列表2)。。。;
（4）insert into 【数据库名.】表名称(字段列表) values(值列表1),(值列表2)。。。;

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
5 rows in set (0.01 sec)
例如：
insert into t_stu values(1,'张三','男','1995-05-09',89.5);

mysql> insert into t_stu values(2,'李四',60);
ERROR 1136 (21S01): Column count doesn't match value count at row 1'

insert into t_stu(sid,sname,score) values(2,'李四',60);

insert into t_stu values
(3,'王五','男','1993-05-09',80.5),
(4,'赵六','女','1992-05-09',82.5),
(5,'钱七','男','1991-05-09',82.5);

insert into t_stu(sid,sname,score) values
(6,'李六',60),
(7,'李七',70);

2、修改
update 【数据库名.】表名称 
set 字段名1 = 新值,
	字段名2 = 新值,
	字段名3 = 新值
	。。。
【where 条件】;

说明：如果没有where条件，说明修改所有行的这几个字段的值
	
例如：修改所有人的成绩为80分
update t_stu set score = 80;

例如：修改李四的成绩为40分
update t_stu set score = 40 where sname = '李四';

例如：把没有填写性别的学生的性别都设置为'男'
update t_stu set gender = '男' where gender <=> null;
update t_stu set gender = '男' where gender is null;

例如：修改所有人的成绩都加10分
update t_stu set score = score + 10;

3、删除数据
delete from 表名称 【where 条件】;

例如：删除所有数据，表结构还在
delete from t_stu;

例如：删除成绩是82.5的学生
delete from t_stu where score = 82.5;

4、查询数据
（1）select * from 表名称;
（2）select * from 表名称 【where 条件】;
（3）select 字段列表 from 表名称 【where 条件】;

例如：查询全部
select * from t_stu;

例如：查询哪些学生没有填写性别
select * from t_stu where gender is null;

例如：查询没有填写性别的学生的姓名
select sname from t_stu where gender is null;

例如：查询没有填写性别的学生的姓名和成绩
select sname,score from t_stu where gender is null;

5、查询时给字段取别名
字段名 as "别名"
其中：
(1)如果""中的别名没有空格，可以省略""
(2)这个as可以省略

例如：查询没有填写性别的学生的姓名和成绩，查询结果sname显示姓名，score显示成绩
select sname as "姓名",score as "成绩" from t_stu where gender is null;

select sname 姓名,score 成绩 from t_stu where gender is null;

