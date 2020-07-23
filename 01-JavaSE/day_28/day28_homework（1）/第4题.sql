-- 建立数据库：day03_test04_library
CREATE DATABASE day03_test04_library;

-- 使用数据库
USE day03_test04_library;

-- 创建出版社表
CREATE TABLE press(
	pressid INT(10) PRIMARY KEY,
	pressname VARCHAR(30),
	address VARCHAR(50)
);

-- 创建一个种类表
CREATE TABLE sort(
	sortno INT(10) PRIMARY KEY,
	scount INT(10)
);

-- 创建图书表
CREATE TABLE book(
	bid INT(10) PRIMARY KEY,
	bname VARCHAR(40),
	bsortno INT(10),
	pressid INT(10),
	CONSTRAINT p_b_pid_fk FOREIGN KEY (pressid) REFERENCES press(pressid),
	CONSTRAINT s_b_sno_fk FOREIGN KEY (bsortno) REFERENCES sort(sortno)
);

-- 添加一列属性
ALTER TABLE sort ADD COLUMN describes VARCHAR(30);

-- 添加数据
INSERT INTO press VALUES(100,'外研社','上海');
INSERT INTO press VALUES(101,'北大出版社','北京');
INSERT INTO press VALUES(102,'教育出版社','北京');

-- 添加数据
INSERT INTO sort(sortno,scount,describes)VALUES(11,50,'小说');
INSERT INTO sort(sortno,scount,describes)VALUES(12,300,'科幻');
INSERT INTO sort(sortno,scount,describes)VALUES(13,100,'神话');

-- 添加数据
INSERT INTO book VALUES(1,'红与黑',11,100);
INSERT INTO book VALUES(2,'幻城',12,102);
INSERT INTO book VALUES(3,'希腊神话',13,102);
INSERT INTO book VALUES(4,'一千零一夜',13,102);

#5.查询出版社id为100的书的全部信息
SELECT * FROM book WHERE pressid=100;

#6.查询出版社为外研社的书的全部信息
SELECT * FROM book WHERE pressid=(SELECT pressid FROM press WHERE pressname='外研社');

#7.查询图书数量（scount）大于100的种类
SELECT * FROM sort WHERE scount>100;

#8.查询图书种类最多的出版社信息
SELECT * FROM press WHERE pressid=(
	SELECT temp.pressid FROM 
 (SELECT pressid,MAX(t.c) FROM (SELECT pressid,COUNT(*) AS c FROM book GROUP BY pressid ORDER BY c DESC ) AS t) AS temp);


SELECT * FROM press WHERE pressid=(
SELECT pressid
FROM (SELECT pressid,bsortno FROM book GROUP BY pressid,bsortno) temp
GROUP BY pressid
ORDER BY COUNT(*) DESC
LIMIT 0,1)




