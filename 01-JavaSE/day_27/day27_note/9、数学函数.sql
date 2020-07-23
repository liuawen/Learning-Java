/*
数学函数：
*/
SELECT CEIL(2.3),FLOOR(2.3),ROUND(2.3)
SELECT CEIL(2.6),FLOOR(2.6),ROUND(2.6)

SELECT RAND() #[0,1)的随机值

#ROUND(x,y)，保留小数点后y位，看第y+1位，决定四舍五入
#TRUNCATE(x,y)，保留小数点后y位，y位后直接截掉
SELECT ROUND(2.12345,4),TRUNCATE(2.12345,4)

SELECT ename,salary FROM t_employee;
SELECT ename, ROUND(salary,0) FROM t_employee;



