# day01_mysql_课后练习

## 第1题

案例：

1、创建数据库day01_test01_library

2、创建表格books

| 字段名  | 字段说明 | 数据类型      | 允许为空 | 唯一 |
| ------- | -------- | ------------- | -------- | ---- |
| b_id    | 书编号   | int(11)       | 否       | 是   |
| b_name  | 书名     | varchar（50） | 否       | 否   |
| authors | 作者     | varchar(100)  | 否       | 否   |
| price   | 价格     | float         | 否       | 否   |
| pubdate | 出版日期 | year          | 否       | 否   |
| note    | 说明     | varchar(100)  | 是       | 否   |
| num     | 库存     | int(11)       | 否       | 否   |

3、向books表中插入记录

1） 指定所有字段名称插入第一条记录

2）不指定字段名称插入第二记录

3）同时插入多条记录（剩下的所有记录）

| b_id | b_name        | authors         | price | pubdate | note     | num  |
| ---- | ------------- | --------------- | ----- | ------- | -------- | ---- |
| 1    | Tal of AAA    | Dickes          | 23    | 1995    | novel    | 11   |
| 2    | EmmaT         | Jane lura       | 35    | 1993    | joke     | 22   |
| 3    | Story of Jane | Jane Tim        | 40    | 2001    | novel    | 0    |
| 4    | Lovey Day     | George Byron    | 20    | 2005    | novel    | 30   |
| 5    | Old land      | Honore Blade    | 30    | 2010    | law      | 0    |
| 6    | The Battle    | Upton Sara      | 30    | 1999    | medicine | 40   |
| 7    | Rose Hood     | Richard haggard | 28    | 2008    | cartoon  | 28   |

4、将小说类型(novel)的书的价格都增加5。

5、将名称为EmmaT的书的价格改为40。

6、删除库存为0的记录

```sql
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
```



## 第2题

1、创建数据库day01_test02_market

2、创建表格customers

| 字段名    | 数据类型    |
| --------- | ----------- |
| c_num     | int（11）   |
| c_name    | varchar(50) |
| c_contact | varchar(50) |
| c_city    | varchar(50) |
| c_birth   | date        |

**要求3：**将c_contact字段移动到c_birth字段后面

**要求4：**将c_name字段数据类型改为 varchar(70)

**要求5：**将c_contact字段改名为c_phone

**要求6：**增加c_gender字段到c_name后面，数据类型为char(1)

**要求7：**将表名改为customers_info

**要求8：**删除字段c_city

```sql
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
```



## 第3题

1、创建数据库day01_test03_company

2、创建表格offices

| 字段名     | 数据类型    |
| ---------- | ----------- |
| officeCode | int         |
| city       | varchar(30) |
| address    | varchar(50) |
| country    | varchar(50) |
| postalCode | varchar(25) |

3、创建表格employees

| 字段名    | 数据类型                 |
| ------------- | ---------------------------- |
| empNum    | int(11)                  |
| lastName  | varchar（50）                |
| firstName | varchar(50)             |
| mobile    | varchar(25)              |
| code      | int                    |
| jobTitle  | varchar(50)              |
| birth     | date                     |
| Note      | varchar(255）                |
| Sex       | varchar（5） |

**要求4：**将表employees的mobile字段修改到code字段后面。

**要求5：**将表employees的birth字段改名为birthday;

**要求6：**修改sex字段，数据类型为char（1）。

**要求7：**删除字段note；

**要求8：**增加字段名favoriate_activity，数据类型为varchar（100）；

**要求9：**将表employees的名称修改为 employees_info



## 第4题

1、创建数据库day01_test04db

2、创建表格employee，并添加记录

| **id** | **name** | **sex** | **tel**      | **addr** | **salary** |
| ------ | -------- | ------- | ------------ | -------- | ---------- |
| 10001  | 张一一   | 男      | 13456789000  | 广东韶关 | 1001.58    |
| 10002  | 刘小红   | 女      | 13454319000  | 广东江门 | 1201.21    |
| 10003  | 李四     | 男      | 0751-1234567 | 广东佛山 | 1004.11    |
| 10004  | 刘小强   | 男      | 0755-5555555 | 广东深圳 | 1501.23    |
| 10005  | 王艳     | 女      | 020-1232133  | 广东广州 | 1405.16    |

**要求3：**查询出薪资在1200~1300之间的员工信息。

**要求4：**查询出姓“刘”的员工的工号，姓名，家庭住址。

**要求5：**将“李四”的家庭住址改为“广东韶关”

**要求6：**查询出名字中带“小”的员工

```sql
-- 创建数据库day01_test04db
CREATE DATABASE day01_test04db;

-- 使用day01_test04db数据库
USE day01_test04db;

#创建employee表
CREATE TABLE employee(
	id INT,
	`name` VARCHAR(20),
	sex VARCHAR(20),
	tel VARCHAR(20),
	addr VARCHAR(50),
	salary FLOAT
);

#添加信息
INSERT INTO employee(id,`name`,sex,tel,addr,salary)VALUES
(10001,'张一一','男','13456789000','广东韶关',1001.58),
(10002,'刘小红','女','13454319000','广东江门',1201.21),
(10003,'李四','男','0751-1234567','广东佛山',1004.11),
(10004,'刘小强','男','0755-5555555','广东深圳',1501.23),
(10005,'王艳','男','020-1232133','广东广州',1405.16);


#要求3：查询出薪资在1200~1300之间信息。
SELECT * FROM employee WHERE salary BETWEEN 1200 AND 1300;

#要求4：查询出姓“刘”的员工的工号，姓名，家庭住址。
SELECT id,addr FROM employee WHERE `name` LIKE '刘%';

#要求5：将“李四”的家庭住址改为“广东韶关”
UPDATE employee SET addr='广东韶关' WHERE `name`='李四';

#要求6：查询出名字中带“小”的员工。
SELECT * FROM employee WHERE `name` LIKE '%小%';
```



## 第5题

1、创建数据库day01_test05db

2、创建表格pet

| 字段名  | 字段说明 | 数据类型    |
| ------- | -------- | ----------- |
| name    | 宠物名称 | varchar(20) |
| owner   | 宠物主人 | varchar(20) |
| species | 种类     | varchar(20) |
| sex     | 性别     | char(1)     |
| birth   | 出生日期 | year        |
| death   | 死亡日期 | year        |

3、添加记录

| name   | owner  | species | sex  | birth | death |
| ------ | ------ | ------- | ---- | ----- | ----- |
| Fluffy | harold | Cat     | f    | 2003  | 2010  |
| Claws  | gwen   | Cat     | m    | 2004  |       |
| Buffy  |        | Dog     | f    | 2009  |       |
| Fang   | benny  | Dog     | m    | 2000  |       |
| bowser | diane  | Dog     | m    | 2003  | 2009  |
| Chirpy |        | Bird    | f    | 2008  |       |

4、 添加字段主人的生日owner_birth。

5、 将名称为Claws的猫的主人改为kevin

6、 将没有死的狗的主人改为duck

7、 查询没有主人的宠物的名字；

8、 查询已经死了的cat的姓名，主人，以及去世时间；

9、 删除已经死亡的狗

10、查询所有宠物信息

```sql
-- 创建数据库day01_test05db
CREATE DATABASE day01_test05db;

-- 指定使用哪个数据库
USE day01_test05db;

-- 在market中创建数据表customers，
CREATE TABLE pet(
	`name` VARCHAR(20),
	`owner` VARCHAR(20),
	species VARCHAR(20),
	sex CHAR(1),
	birth	YEAR,
	death YEAR
);
-- 3、添加数据
INSERT INTO pet VALUES('Fluffy','harold','Cat','f','2013','2010'); 				
INSERT INTO pet(`name`,`owner`,species,sex,Birth) VALUES('Claws','gwen','Cat','m','2014'); 
INSERT INTO pet(`name`,species,sex,Birth) VALUES('Buffy','Dog','f','2009');
INSERT INTO pet(`name`,`owner`,species,sex,Birth) VALUES('Fang','benny','Dog','m','2000');
INSERT INTO pet VALUES('bowser','diane','Dog','m','2003','2009');
INSERT INTO pet(`name`,species,sex,birth) VALUES('Chirpy','Bird','f','2008');

#4、添加字段主人的生日owner_birth。
ALTER TABLE pet ADD COLUMN owner_birth DATE;

#5、将名称为Claws的猫的主人改为kevin
UPDATE pet SET `owner`='kevin' WHERE `name`='Claws' AND species='Cat';

#6、将没有死的狗的主人改为duck
UPDATE pet SET `owner`='duck' WHERE species='Dog' AND death IS NULL;

#7、查询没有主人的宠物的名字；
SELECT `name` FROM pet WHERE `owner` IS NULL;

#8、查询已经死了的cat的姓名，主人，以及去世时间；
SELECT `name`,`owner`,death FROM pet WHERE death IS NOT NULL;

#9、删除已经死亡的狗
DELETE FROM pet WHERE death IS NOT NULL;

#10、查询所有宠物信息
SELECT * FROM pet;

```

