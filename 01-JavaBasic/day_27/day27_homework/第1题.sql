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
SELECT note,SUM(num) FROM books 
GROUP BY note ORDER BY SUM(num) DESC LIMIT 0,1;

#查询书名达到10个字符的书，不包括里面的空格
SELECT * FROM books WHERE CHAR_LENGTH(REPLACE(b_name,' ',''))>=10;

/*
查询书名和类型，其中
​note值为novel显示小说，law显示法律，medicine显示医药，
cartoon显示卡通，joke显示笑话
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
num值超过30本的，显示滞销，大于0并低于10的，显示畅销，
为0的显示需要无货，其他的显示正常
*/
SELECT b_name,num,CASE 
  WHEN num>30 THEN '滞销'
  WHEN num>0 AND num<10 THEN '畅销'
  WHEN num=0 THEN '无货'
  ELSE '正常'
  END AS "库存状态"
FROM books;

#统计每一种note的库存量，并合计总量
SELECT IFNULL(note,'合计总库存量') AS note,SUM(num) 
FROM books GROUP BY note WITH ROLLUP;

#统计每一种note的数量，并合计总量
SELECT IFNULL(note,'合计总数') AS note,COUNT(*) 
FROM books GROUP BY note WITH ROLLUP;

#统计库存量前三名的图书
SELECT * FROM books ORDER BY num DESC LIMIT 0,3;

#找出最早出版的一本书
SELECT * FROM books ORDER BY pubdate ASC LIMIT 0,1;

#找出novel中最高的一本书
SELECT * FROM books WHERE note = 'novel' ORDER BY price DESC LIMIT 0,1;

#找出书名中字数最多的一本书
SELECT * FROM books 
ORDER BY CHAR_LENGTH(REPLACE(b_name,' ','')) DESC LIMIT 0,1;



