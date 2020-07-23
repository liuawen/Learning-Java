/*
右连接：
（1）B
select 字段列表
from A right join B
on 关联条件
where 其他条件 等

（2）B -  A∩B

select 字段列表
from A right join B
on 关联条件
where 关联字段 is null and 其他条件 等

*/

#查询员工的编号，姓名，部门编号，部门名称
#包括那些没有分配部分的员工
SELECT eid,ename,t_employee.did,dname
FROM t_department RIGHT JOIN t_employee
ON t_employee.did = t_department.did;

#查询那些没有分配部门的员工
SELECT eid,ename,t_employee.did,dname
FROM t_department RIGHT JOIN t_employee
ON t_employee.did = t_department.did
WHERE t_employee.did IS NULL;
