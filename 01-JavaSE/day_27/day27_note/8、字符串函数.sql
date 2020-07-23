/*
字符串函数
(1)length(xx)：求字节数，和字符集有关
(2)char_length(xx)：求字符数
(3)CONCAT(str1,str2,...)
(4)CONCAT_WS(分隔符,str1,str2,...)
(5)UPPER(xx)；转大写
(6)LOWER(xx)：转小写
(7)LEFT(s,n)：返回最左边的3个字符
   RIGHT(s,n)：返回最右边的3个字符
(8)LTRIM(s)：去掉左边的空格
   RTRIM(s)：去掉右边的空格
    TRIM(s)：去掉前后空白符
   TRIM(【BOTH 】s1 FROM s) ：从s中去掉前后的s1
   TRIM(【LEADING】s1 FROM s)：从s中去掉开头的s1
   TRIM(【TRAILING】s1 FROM s)：从s中去掉结尾的s1
(9)SUBSTRING(s,index,len)   
*/
#求字符串的长度
#例如：查询员工的姓名的字符的个数
SELECT ename AS "姓名", CHAR_LENGTH(ename) AS "姓名的字数" FROM t_employee;

#求字符串的拼接
SELECT 'hello' + 'world'; #在mysql中，+只表示求和，不表示拼接
SELECT CONCAT('hello','world','java');
SELECT CONCAT_WS('-','hello','world','java');

#转大小写
SELECT UPPER('hello'),LOWER('HELLO');

SELECT LEFT('hello',3);

SELECT CONCAT('[',LTRIM('    hello    world    '),']');

SELECT CONCAT('[',TRIM('    hello    world    '),']');

SELECT TRIM(BOTH '#' FROM '###hello  world###');
SELECT TRIM(LEADING '#' FROM '###hello  world###');
SELECT TRIM(TRAILING '#' FROM '###hello  world###');

SELECT SUBSTRING('hello',2);#从第二个字符，不是下标的概念



