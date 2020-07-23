-- 创建一个数据库：day03_test03_xuankedb
CREATE DATABASE day03_test03_xuankedb;

-- 使用数据库
USE day03_test03_xuankedb;

-- 创建学生表
CREATE TABLE student(
	sno INT(10) PRIMARY KEY,
	sname VARCHAR(10),
	ssex VARCHAR(10),
	sage INT(10),
	sdept VARCHAR(40)
);

-- 创建课程表
CREATE TABLE course(
	cno INT(10) PRIMARY KEY,
	cname VARCHAR(20),
	cpno VARCHAR(40),
	ccredit INT(20)
);

-- 创建成绩表
CREATE TABLE sg(
	sno INT(10),
	cno INT(10),
	grade INT(3),
	PRIMARY KEY(sno,cno),
	CONSTRAINT stu_s_sno_fk FOREIGN KEY (sno) REFERENCES student(sno),
	CONSTRAINT cou_s_sno_fk FOREIGN KEY (cno) REFERENCES course(cno)
);

#3.向Student表增加“入学时间(Scome)”列，其数据类型为日期型。
ALTER TABLE student ADD COLUMN scome DATE;

#4.查询选修了3号课程的学生的学号及其成绩，查询结果按分数的降序排列。
SELECT sno,grade FROM sg WHERE cno=3 ORDER BY grade DESC;

#5.查询学习1号课程的学生最高分数、平均成绩。
SELECT MAX(grade),AVG(grade) FROM sg WHERE cno=1;

#6.查询与“李洋”在同一个系学习的学生。
SELECT * FROM student WHERE sdept=(SELECT sdept FROM student WHERE sname='李洋');

#7.将计算机系全体学生的成绩置零。
UPDATE sg SET grade=0 WHERE sno IN (SELECT sno FROM student WHERE sdept='计算机系')

#8.删除学生表中学号为05019的学生记录。
DELETE FROM student WHERE sno=05019;

#9.删除计算机系所有学生的成绩记录。
DELETE FROM sg WHERE sno IN (SELECT sno FROM student WHERE sdept='计算机系');

