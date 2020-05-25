#注释
#1、查看当前mysql数据库管理软件中都有什么数据库
show databases;

#使用一个数据库
use test;

#如果test不存在，可以创建一个新的数据库
create database test;

#查看当前数据库中都有什么表格
show tables;

#查看某个表的数据
select * from 表名称;
select * from t_employee;

#查询所有人的薪资
select salary from t_employee;
select salary+1000 from t_employee;

#修改所有人的薪资，涨1000元
update t_employee set salary = salary + 1000;

#查询薪资加完1000元后，超过20000
select * from t_employee where salary+1000 > 20000;


