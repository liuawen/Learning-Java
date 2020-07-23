#1、创建数据库Market，进入进行操作
CREATE DATABASE day01_test02_market;

#指定对哪个数据库进行操作
USE day01_test02_market;

#2、创建数据表 customers，
CREATE TABLE customers(
	c_num INT ,
	c_name VARCHAR(50),
	c_contact VARCHAR(50),
	c_city VARCHAR(50),
	c_birth DATE
);

#3、将c_contact字段插入到c_birth字段后面
ALTER TABLE customers MODIFY c_contact VARCHAR(50) AFTER c_birth;


#4、将c_name字段数据类型改为 varchar(70).
ALTER TABLE customers MODIFY c_name VARCHAR(70);

#5、将c_contact字段改名为c_phone.
ALTER TABLE customers CHANGE c_contact c_phone VARCHAR(50);


#6、增加c_gender字段，数据类型为char(1)
ALTER TABLE customers ADD c_gender CHAR(1) AFTER c_name;
#默认在最后一列
#加first,加在第一列
#如果要指定在哪列后面,加after 那列的名称


#7、将表名改为customers_info
ALTER TABLE customers RENAME customers_info;


#8、删除字段c_city
ALTER TABLE customers_info DROP c_city ;