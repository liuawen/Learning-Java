/*
自连接：一种特殊的联合查询
因为现在联合查询的两种表本质上是一张表
通过给表取别名的方式，把一张表虚拟成两张表，通过别名来代表不同的意义。

*/

#查询员工的编号，员工的姓名，他的领导的编号和领导的姓名
#这些信息都在t_employee表中
/*
select 员工的eid,员工的ename,员工的`mid`,领导的ename
from t_employee
where 员工的mid = 领导的eid
*/

SELECT emp.eid, emp.ename, emp.mid, mgr.ename
FROM t_employee emp INNER JOIN t_employee mgr
#emp代表员工表角色
#mgr代表领导表角色
ON emp.mid = mgr.eid;
