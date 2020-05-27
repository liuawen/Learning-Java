#创建数据库day01_test01_library
CREATE DATABASE day01_test01_library;

#指定使用哪个数据库
USE day01_test01_library;

#创建表格books
CREATE TABLE books(
	b_id INT,
	b_name VARCHAR(50),
	`authors` VARCHAR(100),
	price FLOAT,
	pubdate YEAR,
	note VARCHAR(100),
	num INT
);

#指定所有字段名称插入第一条记录
INSERT INTO books (b_id,b_name,`authors`,price,pubdate,note,num)
VALUES(1,'Tal of AAA','Dickes',23,1995,'novel',11);

#不指定字段名称插入第二记录
INSERT INTO books 
VALUE(2,'EmmaT','Jane lura',35,1993,'Joke',22);

#同时插入多条记录（剩下的所有记录）。
INSERT INTO books VALUES
(3,'Story of Jane','Jane Tim',40,2001,'novel',0),
(4,'Lovey Day','George Byron',20,2005,'novel',30),
(5,'Old land','Honore Blade',30,2010,'Law',0),
(6,'The Battle','Upton Sara',30,1999,'medicine',40),
(7,'Rose Hood','Richard haggard',28,2008,'cartoon',28);

#将小说类型(novel)的书的价格都增加5。
UPDATE books SET price=price+5 WHERE note = 'novel';

#将名称为EmmaT的书的价格改为40。
UPDATE books SET price=40 WHERE b_name='EmmaT';

#删除库存为0的记录
DELETE FROM books WHERE num=0;
