/*
日期时间函数
(1)系统时间
NOW()和SYSDATE()

CURRENT_DATE()：只有日期
CURRENT_TIME()：只有时间
CURRENT_TIMESTAMP()：日期时间
(2)求出年等
year(x)
month(x)
day(x)
(3)DATEDIFF(x,y)：间隔天数
(4)格式化
DATE_FORMAT：把日期转字符串
STR_TO_DATE：把字符串转日期
*/
#系统时间
SELECT NOW()
SELECT SYSDATE()

SELECT CURRENT_DATE()
SELECT CURRENT_TIME()
SELECT CURRENT_TIMESTAMP()

SELECT ename,birthday,YEAR(birthday),MONTH(birthday),DAY(birthday) FROM t_employee
SELECT ename,YEAR(NOW()) - YEAR(birthday) AS "年龄" FROM t_employee;

SELECT ename, YEAR(NOW()) - YEAR(hiredate) + 1 AS "入职年数" FROM t_employee

SELECT ename,birthday, DAYOFWEEK(birthday) FROM t_employee;
SELECT DAYOFWEEK(NOW())

SELECT birthday,DATEDIFF(NOW(), birthday) FROM t_employee;

SELECT DATEDIFF(NOW(),'2019-05-13');

SELECT DATE_FORMAT(birthday,'%Y年%m月%d日') FROM t_employee;