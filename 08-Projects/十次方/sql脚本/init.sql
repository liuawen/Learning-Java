CREATE USER 'root'@'%' IDENTIFIED BY '123456';
GRANT All privileges ON *.* TO 'root'@'%';
CREATE USER 'root'@'localhost' IDENTIFIED BY '123456';
GRANT All privileges ON *.* TO 'root'@'localhost';