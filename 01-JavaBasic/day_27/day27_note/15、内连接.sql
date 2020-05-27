/*
内连接：A∩B
1、官方写法
两张表内连接关联查询
	select 字段列表
	from A表名 inner join B表名
	on 1个关联条件
	where 其他条件等

三张表内连接关联查询
	select 字段列表
	from A表名 inner join B表名 inner join C表名
	on 2个关联条件
	where 其他条件等

关联条件的个数 = 表数 - 1
如果少了关联条件，就会笛卡尔积的

2、另一种写法

两张表内连接关联查询
	select 字段列表
	from A表名 , B表名
	where 1个关联条件  and 其他条件等
*/

#查询所有员工的编号，姓名，部门编号和他所在部门的名称
/*
select eid,ename, did,dname 
from t_employee inner join t_department;

错误
错误代码： 1052
Column 'did' in field list is ambiguous
*/
/*
select eid,ename,t_employee.did,dname 
from t_employee inner join t_department;

出现了笛卡尔积  A表的数量 * B表的数量
*/
SELECT eid,ename,t_employee.did,dname 
FROM t_employee INNER JOIN t_department
ON t_employee.did = t_department.did;

#给表名取别名
SELECT eid,ename,emp.did,dname 
FROM t_employee AS emp INNER JOIN t_department AS dept
ON emp.did = dept.did;

SELECT eid,ename,emp.did,dname 
FROM t_employee AS emp , t_department AS dept
WHERE emp.did = dept.did;

#查询员工编号，员工姓名，员工的职位编号，职位名称，部门编号，部门名称
SELECT eid,ename,t_employee.`job_id`,job_name,t_employee.`did`,dname
FROM t_employee INNER JOIN t_job INNER JOIN t_department
ON t_employee.`did` = t_department.did AND t_employee.`job_id` = t_job.`job_id`;

#查询薪资高于15000的男员工编号，员工姓名，员工的职位编号，职位名称，部门编号，部门名称
SELECT eid,ename,t_employee.`job_id`,job_name,t_employee.`did`,dname
FROM t_employee INNER JOIN t_job INNER JOIN t_department
ON t_employee.`did` = t_department.did AND t_employee.`job_id` = t_job.`job_id`
WHERE salary > 15000 AND gender = '男'