drop database if exists atguigu;	## 如果原来的数据库存在，就删除

create database atguigu;			## 创建数据库

use atguigu;					## 切换到数据库


##创建表t_user
create table t_user(
	`id` int primary key auto_increment,
	`username` varchar(50) not null unique,
	`password` varchar(32) not null,
	`email` varchar(50) 
);

##插入初始数据
insert into t_user(username,`password`,email) values('admin','admin','admin@atguigu.com');

## 查询表
select * from t_user;




