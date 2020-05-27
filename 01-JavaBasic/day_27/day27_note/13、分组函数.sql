/*
分组函数
(1)count(*)：统计记录数
count(*)和count(常量)结果是一样的
count(字段名)统计非null值
(2)sum(x)：总和
(3)max(x)：最大值
   min(x)：最小值
(4)avg(x)：平均值   
*/
#查询员工总数
SELECT COUNT(*) FROM t_employee;
SELECT COUNT(1) FROM t_employee;
SELECT COUNT(100) FROM t_employee;
SELECT COUNT(commission_pct)  FROM t_employee;

#查询男员工数量
SELECT COUNT(*) FROM t_employee WHERE gender = '男';

#查询薪资大于20000的女员工的数量
SELECT COUNT(*) FROM t_employee WHERE gender ='女' AND salary > 20000;

#查询每个月看要给所有员工发的实发工资的总和是多少
#select sum(实发工资) from t_employee;
SELECT SUM(salary + salary*IFNULL(commission_pct,0)) FROM t_employee;
#保留到分，后面四舍五入
SELECT ROUND(SUM(salary + salary*IFNULL(commission_pct,0)),2) FROM t_employee;

#查询最高工资和最低工资
SELECT MAX(salary),MIN(salary) FROM t_employee;

#查询年龄最大的员工的年龄
SELECT MAX(YEAR(NOW()) - YEAR(birthday)) FROM t_employee;

#查询入职最早的一个员工的入职日期
SELECT MIN(hiredate) FROM t_employee;

#查询平均薪资
SELECT AVG(salary) FROM t_employee;

#查询员工的平均年龄
SELECT ROUND(AVG(YEAR(NOW()) - YEAR(birthday)),0) FROM t_employee;




