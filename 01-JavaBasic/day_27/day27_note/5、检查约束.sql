1、检查约束：check
但是mysql暂不支持
在oracle或sql server中使用

create table t_stu(
	sid int primary key,
	sname varchar(20),
	gender char check('男' or '女')
);

insert into t_stu values(1,'张三','男');

insert into t_stu values(2,'李四','妖');