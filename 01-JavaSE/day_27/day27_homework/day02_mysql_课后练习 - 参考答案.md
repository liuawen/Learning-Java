# day02_mysql_课后练习

## 第1题

案例：

1、创建数据库test02_library

2、创建表格books

| 字段名  | 字段说明 | 数据类型      |
| ------- | -------- | ------------- |
| b_id    | 书编号   | int(11)       |
| b_name  | 书名     | varchar（50） |
| authors | 作者     | varchar(100)  |
| price   | 价格     | float         |
| pubdate | 出版日期 | year          |
| note    | 说明     | varchar(100)  |
| num     | 库存     | int(11)       |

3、使用alter语句给books按如下要求增加相应的约束

| 字段名  | 字段说明 | 数据类型      | 主键 | 外键 | 非空 | 唯一 | 自增 |
| ------- | -------- | ------------- | ---- | ---- | ---- | ---- | ---- |
| b_id    | 书编号   | int(11)       | 是   | 否   | 是   | 是   | 是   |
| b_name  | 书名     | varchar（50） | 否   | 否   | 是   | 否   | 否   |
| authors | 作者     | varchar(100)  | 否   | 否   | 是   | 否   | 否   |
| price   | 价格     | float         | 否   | 否   | 是   | 否   | 否   |
| pubdate | 出版日期 | year          | 否   | 否   | 是   | 否   | 否   |
| note    | 说明     | varchar(100)  | 否   | 否   | 否   | 否   | 否   |
| num     | 库存     | int(11)       | 否   | 否   | 是   | 否   | 否   |

4、向books表中插入记录

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

5、统计书名中包含a字母的书

6、统计书名中包含a字母的书的数量和库存总量

7、找出“novel”类型的书，按照价格降序排列

8、查询图书信息，按照库存量降序排列，如果库存量相同的按照note升序排列

9、按照note分类统计书的数量

10、按照note分类统计书的库存量，显示库存量超过30本的

11、查询所有图书，每页显示5本，显示第二页

12、按照note分类统计书的库存量，现在库存量最多的

13、查询书名达到10个字符的书，不包括里面的空格

14、查询书名和类型，其中

​	note值为novel显示小说，law显示法律，medicine显示医药，cartoon显示卡通，joke显示笑话

15、查询书名、库存，其中

​	num值超过30本的，显示滞销，大于0并低于10的，显示畅销，为0的显示需要无货

16、统计每一种note的库存量，并合计总量

17、统计每一种note的数量，并合计总量

18、统计库存量前三名的图书

19、找出最早出版的一本书

20、找出novel中最高的一本书

21、找出书名中字数最多的一本书，不含空格

```mysql
#创建数据库test02_library
CREATE DATABASE test02_library;

#使用test02_library
USE test02_library;

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

#给b_id增加主键约束
ALTER TABLE books ADD PRIMARY KEY(b_id);

#给b_id字段增加自增约束
ALTER TABLE books MODIFY b_id INT AUTO_INCREMENT;

#给b_name等字段增加非空约束
ALTER TABLE books b_name VARCHAR(50) NOT NULL;
ALTER TABLE books `authors` VARCHAR(100) NOT NULL;
ALTER TABLE books price FLOAT NOT NULL;
ALTER TABLE books pubdate DATE NOT NULL;
ALTER TABLE books num INT NOT NULL;

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

#查询书名中包含a字母的书
SELECT * FROM books WHERE b_name LIKE '%a%';

#统计书名中包含a字母的书的数量和库存总量
SELECT COUNT(*),SUM(num) FROM books WHERE b_name LIKE '%a%';

#找出“novel”类型的书，按照价格降序排列
SELECT * FROM books WHERE note = 'novel' ORDER BY price DESC;

#查询图书信息，按照库存量降序排列，如果库存量相同的按照note升序排列
SELECT * FROM books ORDER BY num DESC,note ASC;

#按照note分类统计书的数量
SELECT note,COUNT(*) FROM books GROUP BY note;

#按照note分类统计书的库存量，显示库存量超过30本的
SELECT note,SUM(num) FROM books GROUP BY note HAVING SUM(num)>30;

#查询所有图书，每页显示5本，显示第二页
SELECT * FROM books LIMIT 5,5;

#按照note分类统计书的库存量，现在库存量最多的
SELECT note,SUM(num) FROM books GROUP BY note ORDER BY SUM(num) DESC LIMIT 0,1;

#查询书名达到10个字符的书，不包括里面的空格
SELECT * FROM books WHERE CHAR_LENGTH(REPLACE(b_name,' ',''))>=10;

/*
查询书名和类型，其中
​note值为novel显示小说，law显示法律，medicine显示医药，cartoon显示卡通，joke显示笑话
*/
SELECT b_name AS "书名" ,note, CASE note 
 WHEN 'novel' THEN '小说'
 WHEN 'law' THEN '法律'
 WHEN 'medicine' THEN '医药'
 WHEN 'cartoon' THEN '卡通'
 WHEN 'joke' THEN '笑话'
 END AS "类型"
FROM books;

/*
查询书名、库存，其中
num值超过30本的，显示滞销，大于0并低于10的，显示畅销，为0的显示需要无货，其他的显示正常
*/
SELECT b_name,num,CASE 
  WHEN num>30 THEN '滞销'
  WHEN num>0 AND num<10 THEN '畅销'
  WHEN num=0 THEN '无货'
  ELSE '正常'
  END AS "库存状态"
FROM books;

#统计每一种note的库存量，并合计总量
SELECT IFNULL(note,'合计总库存量') AS note,SUM(num) FROM books GROUP BY note WITH ROLLUP;

#统计每一种note的数量，并合计总量
SELECT IFNULL(note,'合计总数') AS note,COUNT(*) FROM books GROUP BY note WITH ROLLUP;

#统计库存量前三名的图书
SELECT * FROM books ORDER BY num DESC LIMIT 0,3;

#找出最早出版的一本书
SELECT * FROM books ORDER BY pubdate ASC LIMIT 0,1;

#找出novel中最高的一本书
SELECT * FROM books WHERE note = 'novel' ORDER BY price DESC LIMIT 0,1;

#找出书名中字数最多的一本书
SELECT * FROM books ORDER BY CHAR_LENGTH(REPLACE(b_name,' ','')) DESC LIMIT 0,1;
```



## 第2题

案例：

1、创建数据库：day02_test02_company

2、在此数据库下创建如下3表，数据类型，宽度，是否为空根据实际情况自己定义。

A． 部门表（department）：部门编号（depid），部门名称（depname），部门简介（deinfo）；其中部门编号为主键。

B． 雇员表（emoloyee）：雇员编号（empid），姓名（name），性别（sex），职称（title），出生日期（birthday），所在部门编号（depid）；其中

* ​	雇员编号为主键；
* ​	部门编号为外键，外键约束等级为（on update cascade 和on delete set null）；
* ​	性别默认为男；

C． 工资表（salary）：雇员编号（empid），基本工资（basesalary），职务工资（titlesalary），扣除（deduction）。其中雇员编号为主键。

3、给工资表（salary）的雇员编号（empid）增加外键约束，外键约束等级为（on update cascade 和on delete cascade）

4、添加数据如下：

部门表：

| 部门编号 | 部门名称 | 部门简介     |
| -------- | -------- | ------------ |
| 111      | 生产部   | Null         |
| 222      | 销售部   | Null         |
| 333      | 人事部   | 人力资源管理 |

 雇员表：

| 雇员编号 | 姓名 | 性别 | 职称       | 出生日期   | 所在部门编号 |
| -------- | ---- | ---- | ---------- | ---------- | ------------ |
| 1001     | 张三 | 男   | 高级工程师 | 1975-1-1   | 111          |
| 1002     | 李四 | 女   | 助工       | 1985-1-1   | 111          |
| 1003     | 王五 | 男   | 工程师     | 1978-11-11 | 222          |
| 1004     | 张六 | 男   | 工程师     | 1999-1-1   | 222          |

 工资表：

| 雇员编号 | 基本工资 | 职务工资 | 扣除 |
| -------- | -------- | -------- | ---- |
| 1001     | 2200     | 1100     | 200  |
| 1002     | 1200     | 200      | NULL |
| 1003     | 2900     | 700      | 200  |
| 1004     | 1950     | 700      | 150  |

5、查询出每个雇员的雇员编号，姓名，职称，所在部门名称，应发工资（基本工资+职务工资），实发工资（基本工资+职务工资-扣除）。

6、查询销售部门的雇员姓名及其基本工资

7、查询姓“张”且年龄小于40的员工的全部信息和年龄

8、查询所有男员工的基本工资和职务工资

9、查询基本工资低于2000的员工姓名和职称、所在部门名称

10、查询员工总数

11、查询部门总数

12、查询应发工资的平均工资和最高工资、最低工资

13、按照部门统计应发工资的平均工资

14、找出部门基本工资的平均工资低于2000的

15、按照员工编号、姓名、基本工资、职务工资、扣除，并按照职务升序排列，如果职务工资相同，再按照基本工资升序排列

16、查询员工编号、姓名，出生日期，及年龄段，其中

​	如果80年之前出生的，定为”老年“；80后定为”中年“，90后定为”青壮年“

17、查询所有的员工信息，和他所在的部门名称

18、查询所有部门信息，和该部门的员工信息

19、查询所有职位中含“工程师”的男员工的人数

20、查询每个部门的男生和女生的人数和平均基本工资

```mysql
#创建数据库：day02_test02_company
CREATE DATABASE day02_test02_company;

#使用数据库day02_test02_company
USE day02_test02_company;

#创建部门表（department）
CREATE TABLE department(
	depid INT PRIMARY KEY,
	depname VARCHAR(20) NOT NULL,
	deinfo VARCHAR(50)
);

#创建雇员表（emoloyee）
CREATE TABLE employee(
	empid INT PRIMARY KEY,
	`name` VARCHAR(20) NOT NULL,
	sex CHAR NOT NULL DEFAULT '男',
	title VARCHAR(20) NOT NULL,
	birthday DATE,
	depid INT,
	FOREIGN KEY(depid) REFERENCES department(depid) ON UPDATE CASCADE ON DELETE SET NULL
);

#创建工资表（salary）
CREATE TABLE salary(
	empid INT PRIMARY KEY,
	basesalary DOUBLE,
	titlesalary DOUBLE,
	deduction DOUBLE
);

#给工资表（salary）的雇员编号（empid）增加外键约束，外键约束等级为（on update cascade 和on delete cascade）
ALTER TABLE salary ADD FOREIGN KEY empid REFERENCES employee(empid) ON UPDATE CASCADE ON DELETE CASCADE;

#添加部门表数据
INSERT INTO department VALUES
(111,'生产部',NULL),
(222,'销售部',NULL),
(333,'人事部','人力资源管理');

#添加雇员表
INSERT INTO employee VALUES
(1001,'张三',DEFAULT,'高级工程师','1975-1-1',111),
(1002,'李四','女','助工','1985-1-1',111),
(1003,'王五','男','工程师','1978-11-11',222),
(1004,'张六',DEFAULT,'工程师','1999-1-1',222);

#添加工资表
INSERT INTO salary VALUES
(1001,2200,1100,200),
(1002,1200,200,NULL),
(1003,2900,700,200),
(1004,1950,700,150);


/*
查询出每个雇员的雇员编号，姓名，职称，所在部门名称，
应发工资（基本工资+职务工资），
实发工资（基本工资+职务工资-扣除）。
*/
SELECT employee.empid,`name`,title,depname,
basesalary+titlesalary AS "应发工资",
basesalary+titlesalary-IFNULL(deduction,0) AS "实发工资"
FROM department INNER JOIN employee INNER JOIN salary
ON department.depid = employee.depid AND employee.empid = salary.empid;

#查询销售部门的雇员姓名及其基本工资
SELECT `name`,basesalary
FROM department INNER JOIN employee INNER JOIN salary
ON department.depid = employee.depid AND employee.empid = salary.empid
WHERE department.depname = '销售部';

#查询姓“张”且年龄小于40的员工的全部信息和年龄
SELECT *,YEAR(CURRENT_DATE())-YEAR(birthday) AS "年龄" 
FROM employee 
WHERE `name` LIKE '张%' AND YEAR(CURRENT_DATE())-YEAR(birthday)<40;

#查询所有男员工的基本工资和职务工资
SELECT basesalary,titlesalary 
FROM employee INNER JOIN salary
ON employee.empid = salary.empid
WHERE employee.sex = '男';

#查询基本工资低于2000的员工姓名和职称、所在部门名称
SELECT `name`,title,depname
FROM department INNER JOIN employee INNER JOIN salary
ON department.depid = employee.depid AND employee.empid = salary.empid
WHERE basesalary < 2000;

#查询员工总数
SELECT COUNT(*) FROM employee;

#查询部门总数
SELECT COUNT(*) FROM department;

#查询应发工资的平均工资和最高应发工资、最低应发工资
SELECT AVG(basesalary+titlesalary) AS "平均应发工资",
	MAX(basesalary+titlesalary) AS "最高应发工资",
	MIN(basesalary+titlesalary) AS "最低应发工资"
FROM salary;

#按照部门统计应发工资的平均工资
SELECT depid,AVG(basesalary+titlesalary)
FROM employee INNER JOIN salary
ON employee.`empid` = salary.`empid`
GROUP BY employee.`depid`;

#找出部门基本工资的平均工资低于2000的
SELECT depid,AVG(basesalary)
FROM employee INNER JOIN salary
ON employee.`empid` = salary.`empid`
GROUP BY employee.`depid`
HAVING AVG(basesalary)<2000;


#按照员工编号、姓名、基本工资、职务工资、扣除，
#并按照职务升序排列，如果职务工资相同，再按照基本工资升序排列
SELECT emp.empid,`name`,basesalary,titlesalary,deduction
FROM employee emp INNER JOIN salary
ON emp.`empid` = salary.`empid`
ORDER BY emp.`title` ASC , basesalary ASC;

#查询员工编号、姓名，出生日期，及年龄段，其中
​#如果80年之前出生的，定为”老年“；80后定为”中年“，90后定为”青壮年“
SELECT empid,`name`,birthday,
 CASE WHEN YEAR(birthday)<1980 THEN '老年'
      WHEN YEAR(birthday)<1990 THEN '中年'
 ELSE '青壮年' END "年龄段"
FROM employee;
 
#查询所有的员工信息，和他所在的部门名称
SELECT emp.*,depname
FROM employee emp LEFT JOIN department dep
ON emp.`depid` = dep.`depid`;

#查询所有部门信息，和该部门的员工信息
SELECT dep.*,emp.*
FROM employee emp RIGHT JOIN department dep
ON emp.`depid` = dep.`depid`;


#查询所有职位中含“工程师”的男员工的人数
SELECT COUNT(*) FROM employee WHERE sex='男' AND title LIKE '%工程师%';

#查询每个部门的男生和女生的人数和平均基本工资
SELECT dep.depid,sex,COUNT(*),AVG(basesalary)
FROM department dep INNER JOIN employee INNER JOIN salary
ON dep.depid = employee.depid AND employee.empid = salary.empid
GROUP BY dep.depid,sex;
```

