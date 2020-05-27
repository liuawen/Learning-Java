/*
流程控制函数
（1）if(value,x,y)：如果value为true,返回x,否则y
（2）ifnull(value,x)：如果value是null值，就用x代替，否则用value自己的值
在mysql中null值是非常特殊
①判断null值用：<=>或is null ,is not null，不能用=和!=
②计算null值，所有运算符，遇到null，运算结果都是null
（3）case 字段/表达式 
	when 常量值  then 值/表达式
	when 常量值  then 值/表达式
	when 常量值  then 值/表达式
	else 值/表达式
    end
    
    类似于Java的switch...case
（4）case 
     when 条件1  then  值/表达式
     when 条件2  then  值/表达式
     when 条件3  then  值/表达式
     else 值/表达式
     end
    类似于Java的if..else if...
*/
SELECT IF(FALSE,1,2)

#求员工的姓名和实发工资
#实发工资 = 薪资 + 奖金 = 薪资 + 薪资 * 奖金比例
SELECT ename,salary + salary * commission_pct FROM t_employee;

SELECT ename,salary + salary * IFNULL(commission_pct,0) FROM t_employee;

SELECT ename,job_id, CASE job_id
  WHEN 1 THEN '教学总监'
  WHEN 2 THEN '讲师'
  WHEN 3 THEN '助教'
  ELSE '其他'
  END AS "职位说明"
FROM t_employee;

SELECT ename, salary, CASE 
	WHEN salary >= 20000 THEN '高富帅'
	WHEN salary >= 15000 THEN '潜力股'
	WHEN salary >=  8000 THEN '屌丝'
	ELSE '土鳖'
	END AS "情况"
FROM t_employee;