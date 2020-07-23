/*
其他函数
*/

#加密函数
INSERT INTO t_user VALUES('chailinyan','123456');
INSERT INTO t_user VALUES('admin',PASSWORD('123456'));
INSERT INTO t_user VALUES('yanghongqiang',MD5('123456'));

SELECT * FROM t_user WHERE username = 'chailinyan' AND `password` = '123456';
SELECT * FROM t_user WHERE username = 'admin' AND `password` = PASSWORD('123456');
SELECT * FROM t_user WHERE username = 'yanghongqiang' AND `password` = MD5('123456');