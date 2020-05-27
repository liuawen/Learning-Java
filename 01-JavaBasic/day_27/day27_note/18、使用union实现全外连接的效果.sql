/*
使用UNION来实现全外连接的查询结果：
（1）A ∪ B
（2）A ∪ B - A ∩ B
迂回成
（1）A UNION B
（2）A - A ∩ B UNION B - A ∩ B
*/

#查询所有员工和所有部门的信息，包括那些没有分配部门的员工和没有安排员工的部门
SELECT * 
FROM t_employee LEFT JOIN t_department
ON t_employee.did = t_department.`did`

UNION

SELECT * 
FROM t_employee RIGHT JOIN t_department
ON t_employee.did = t_department.`did`

#查询那些没有分配部门的员工和没有安排员工的部门
SELECT * 
FROM t_employee LEFT JOIN t_department
ON t_employee.did = t_department.`did`
WHERE t_employee.did IS NULL

UNION

SELECT * 
FROM t_employee RIGHT JOIN t_department
ON t_employee.did = t_department.`did`
WHERE t_employee.did IS NULL