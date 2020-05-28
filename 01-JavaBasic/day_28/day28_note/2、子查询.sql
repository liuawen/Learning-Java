/*
查询的学习的顺序：
1、简单查询
2、联合查询
3、select的6个子句
4、子查询

子查询：
   在一个查询中嵌套了另一个查询，那么这个嵌套在里面的查询称为子查询。
   子查询的结果作为外部查询的条件或者数据的筛选范围来使用。

子查询分为三类：
1、where型
	子查询的结果是作为外部查询的条件使用的
2、from型
	子查询的结果是作为外部查询的筛选范围来使用
3、exists型 
	子查询的结果是作为外部查询的条件使用的
*/

/*
where型：
（1）子查询结果是：单值结果
比较运算符 后面可以跟单值的结果
（2）子查询结果是：一列多行的多值结果
in(),比较运算符 all()，比较运算符 any()
*/
#例1：查询运营部的所有员工的信息

#使用联合查询
SELECT * 
FROM t_employee INNER JOIN t_department
ON t_employee.did = t_department.did
WHERE t_department.dname = '运营部'

#使用子查询
/*
select * 
from t_employee
where did = 运营部的did
*/
SELECT * 
FROM t_employee
WHERE did = (SELECT did FROM t_department WHERE dname = '运营部');

#例2：查询全公司薪资最高的员工的信息
#使用order by和limit
SELECT * 
FROM t_employee
ORDER BY salary DESC
LIMIT 0,1

#使用子查询
/*
select *
from t_employee
where salary = (最高工资值)
*/
SELECT *
FROM t_employee
WHERE salary = (SELECT MAX(salary) FROM t_employee);

#例3：查询比孙红雷的工资低的男员工
#子查询
/*
select * 
from t_employee
where salary < (孙红雷的薪资) and gender = '男';
*/
SELECT * 
FROM t_employee
WHERE salary < (SELECT salary FROM t_employee WHERE ename = '孙红雷') AND gender = '男';

#例4：查询运营部、财务部，后勤部的三个部门的女员工
#子查询
/*
select * 
from t_employee
where gender = '女' and did in (运营部、财务部，后勤部部门的编号);
*/
SELECT * 
FROM t_employee
WHERE gender = '女' AND did IN (SELECT did FROM t_department WHERE dname IN ('运营部','财务部','后勤部'));

#例5：查询比孙红雷、范冰冰、李晨三个人的薪资都高的员工
/*
select * 
from t_employee
where salary  > all(孙红雷、范冰冰、李晨三个人的薪资)
*/
SELECT * 
FROM t_employee
WHERE salary  > ALL(SELECT salary FROM t_employee WHERE ename IN('孙红雷','范冰冰','李晨'))

#例6：查询，要么和孙红雷，要么和范冰冰，要么和李晨的薪资一样的员工
/*
select * 
from t_employee
where salary  = any(孙红雷、范冰冰、李晨三个人的薪资)
*/

SELECT * 
FROM t_employee
WHERE salary  = ANY(SELECT salary FROM t_employee WHERE ename IN('孙红雷','范冰冰','李晨'))

/*
from型
*/
#例：查询每个部门的编号，部门名称，部门的人数
#每个部门的编号，部门名称  在部门表中
#每个部门的编号，部门的人数，在员工表中统计出来的


#每个部门的编号，部门的人数
SELECT did,COUNT(*) FROM t_employee GROUP BY did;  #把它看成一张临时表，取别名叫做 temp
/*
select 部门表.did, 部门表的.dname, temp.部门的人数
from 部门表 inner join 临时表temp
on 部门表.did = 临时表temp.did
*/
SELECT t_department.did, t_department.dname, temp.countOfDep
FROM t_department INNER JOIN (SELECT did,COUNT(*) AS countOfDep FROM t_employee GROUP BY did) temp
ON t_department.did = temp.did
/*
对子查询的多行多列的二维表结构的临时表取别名
给用分组函数统计的结果列取别名
*/

/*
exists型
*/
#查询部门信息，要求这些部门必须有员工
SELECT * FROM t_department
WHERE EXISTS (SELECT * FROM t_employee WHERE t_department.did = t_employee.did)
/*
运行的规则，将SELECT * FROM t_department的每一条记录，代入子查询去匹配，
如果能够查询出记录，就说明要保留这样，否则就去掉
例如：测试部门的信息 代入 子查询中，是查不出结果，那么就不保留 测试部门的信息
*/