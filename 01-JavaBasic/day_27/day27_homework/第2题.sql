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
