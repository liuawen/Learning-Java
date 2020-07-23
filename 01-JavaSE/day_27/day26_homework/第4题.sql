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