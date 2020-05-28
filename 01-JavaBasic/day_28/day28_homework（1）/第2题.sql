#建立数据库day03_test02_student
CREATE DATABASE day03_test02_student;

#使用数据库
USE day03_test02_student;

#创建表格并添加记录
CREATE TABLE Classes(
	Pro_name VARCHAR(20) NOT NULL,
	Grade VARCHAR(10) NOT NULL,
	`name` VARCHAR(10) NOT NULL,
	sex VARCHAR(4) NOT NULL,
	seat INT(10) NOT NULL UNIQUE
);
CREATE TABLE Score(
	`name` VARCHAR(10) NOT NULL,
	En_score INT(10) NOT NULL,
	Ma_score INT(10) NOT NULL,
	Ch_score INT(10) NOT NULL
);
CREATE TABLE Records(
	`name` VARCHAR(10) NOT NULL,
	record VARCHAR(10)
);

-- 向classes中添加数据
INSERT INTO classes VALUES('计算机网络','1班','张三','男',8);
INSERT INTO classes VALUES('软件工程','2班','李四','男',12);
INSERT INTO classes VALUES('计算机维护','1班','王五','男',9);
INSERT INTO classes VALUES('计算机网络','2班','LILY','女',15);
INSERT INTO classes VALUES('软件工程','1班','小强','男',20);
INSERT INTO classes VALUES('计算机维护','1班','CoCo','女',18);

-- 向score中添加数据
INSERT INTO Score VALUES('张三',65,75,98);
INSERT INTO Score VALUES('李四',87,45,86);
INSERT INTO Score VALUES('王五',98,85,65);
INSERT INTO Score VALUES('LILY',75,86,87);
INSERT INTO Score VALUES('小强',85,60,58);
INSERT INTO Score VALUES('CoCo',96,87,70);

-- 向records中添加数据
INSERT INTO records VALUES('小强','迟到');
INSERT INTO records VALUES('小强','事假');
INSERT INTO records VALUES('李四','旷课');
INSERT INTO records VALUES('李四','旷课');
INSERT INTO records VALUES('李四','迟到');
INSERT INTO records VALUES('CoCo','病假');
INSERT INTO records VALUES('LILY','事假');

#要求3：写出将张三的语文成绩修改为88的SQL语句。
UPDATE score SET ch_score=88 WHERE `name`='张三';

#要求4：搜索出计算机维护1班各门课程的平均成绩。
SELECT AVG(en_score),AVG(ma_score),AVG(ch_score) FROM score 
WHERE `name` IN (SELECT `name` FROM classes WHERE Pro_name='计算机维护' AND grade='1班');

#要求5：搜索科目有不及格的人的名单。
SELECT `name` FROM score WHERE en_score<60 OR ma_score<60 OR ch_score<60;

#要求6：查询记录2次以上的学生的姓名和各科成绩。
SELECT * 
FROM score INNER JOIN 
(SELECT `name`,COUNT(*) FROM Records GROUP BY `name` HAVING COUNT(*)>2) temp
ON score.name = temp.name;

