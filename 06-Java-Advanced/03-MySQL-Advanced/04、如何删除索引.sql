CREATE X

DROP INDEX idx_xxx ON emp


1 查出该表有哪些索引，索引名-->集合

SHOW INDEX FROM t_emp
元数据：meta DATA  描述数据的数据

SELECT index_name  FROM information_schema.STATISTICS WHERE table_name='t_emp' AND table_schema='mydb'
 AND index_name <>'PRIMARY' AND seq_in_index = 1

2 如何循环集合
 CURSOR 游标
 FETCH xxx INTO xxx


3 如何让mysql执行一个字符串
PREPARE 预编译 XXX

EXECUTE


CALL proc_drop_index ('mydb','t_emp');
