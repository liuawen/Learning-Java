#建立数据库：day03_test05_tour
CREATE DATABASE day03_test05_tour;

#使用数据库
USE day03_test05_tour;

CREATE TABLE agency(
	id INT PRIMARY KEY NOT NULL,
	NAME VARCHAR(20) NOT NULL,
	address VARCHAR(100) NOT NULL,
	areaid INT 
);

CREATE TABLE trval(
	tid INT PRIMARY KEY NOT NULL,
	TIME VARCHAR(50) NOT NULL,
	POSITION VARCHAR(100) NOT NULL,
	money FLOAT,
	aid INT NOT NULL,
	rcount INT,
	CONSTRAINT bk_aid FOREIGN KEY trval(aid) REFERENCES agency(id)
);

INSERT INTO agency(id,NAME,address) VALUES (101,'青年旅行社','北京海淀');
INSERT INTO agency(id,NAME,address) VALUES (102,'天天旅行社','天津海院');

INSERT INTO trval(tid,TIME,POSITION,money,aid,rcount) VALUES (1,'5天','八达岭',3000,101,10);
INSERT INTO trval(tid,TIME,POSITION,money,aid,rcount) VALUES (2,'7天','水长城',5000,101,14);
INSERT INTO trval(tid,TIME,POSITION,money,aid,rcount) VALUES (3,'8天','水长城',6000,102,11);

SELECT * FROM agency;
SELECT * FROM trval;

#4.查出旅行线路最多的旅社
SELECT * 
FROM agency INNER JOIN 
(SELECT t.aid,MAX(t.c) FROM (SELECT aid,COUNT(*) AS c FROM trval GROUP BY aid)  AS t)temp
ON agency.id = temp.aid

#5.查出最热门的旅行线路(也就是查询出报名人数最多的线路)
SELECT * FROM trval WHERE rcount=(SELECT MAX(rcount) FROM trval);

#6.查询花费少于5000的旅行线路
SELECT * FROM trval WHERE money<5000;


#7.找到一次旅行花费最昂贵的旅行社名
SELECT NAME FROM agency WHERE id =
(SELECT aid FROM trval WHERE money =(SELECT MAX(money) FROM trval ));

#8.查出青年旅社所有的旅行线路都玩一遍需要多少时间。
SELECT SUM(TIME) FROM trval WHERE aid=(SELECT id FROM agency WHERE NAME='青年旅行社');
