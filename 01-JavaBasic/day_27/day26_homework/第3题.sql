#创建数据库day01_test03_company
CREATE DATABASE day01_test03_company;

#指定使用哪个数据库，即下面的sql语句是针对哪个数据库的
USE day01_test03_company;

CREATE TABLE offices(
	officeCode INT,
	city VARCHAR(30),
	address VARCHAR(50),
	country VARCHAR(50) ,
	postalcode VARCHAR(25) 
);
CREATE TABLE employees(
	empNum INT(11),
	lastName VARCHAR(50),
	firstName VARCHAR(50),
	mobile VARCHAR(25),
	`code` INT ,
	jobtitle VARCHAR(50),
	birth DATE,
	note VARCHAR(255),
	sex VARCHAR(5)
);

#4、将表employees的mobile字段修改到code字段后面。
ALTER TABLE employees MODIFY mobile VARCHAR(25)AFTER CODE;


#5、将表employees的birth字段改名为birthday;
ALTER TABLE employees CHANGE birth birthday DATE NOT NULL;

#6、修改sex字段，数据类型为char（1）
ALTER TABLE employees MODIFY sex CHAR(1) ;

#7、删除字段note；
ALTER TABLE employees DROP note;


#8、增加字段名favoriate_activity,数据类型为varchar（100）；
ALTER TABLE employees ADD COLUMN favoriate_activity VARCHAR(100);


#要求9：将表employees的名称修改为 employees_info
ALTER TABLE employees RENAME employees_info;