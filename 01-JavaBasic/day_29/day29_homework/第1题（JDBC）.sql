#创建数据库
CREATE DATABASE `day04_test01_bookstore` CHARACTER SET utf8;

USE `day04_test01_bookstore`;

#创建表
CREATE TABLE `books` (
  `id` INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `author` VARCHAR(100) NOT NULL,
  `price` DOUBLE(11,2) NOT NULL,
  `sales` INT(11) NOT NULL,
  `stock` INT(11) NOT NULL,
  `img_path` VARCHAR(100) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `books` */
INSERT  INTO `books`(`id`,`title`,`author`,`price`,`sales`,`stock`,`img_path`) VALUES 
(1,'解忧杂货店','东野圭吾',27.20,102,98,'upload/books/解忧杂货店.jpg'),
(2,'边城','沈从文',23.00,102,98,'upload/books/边城.jpg'),
(3,'中国哲学史','冯友兰',44.50,101,99,'upload/books/中国哲学史.jpg'),
(4,'忽然七日',' 劳伦',19.33,101,99,'upload/books/忽然七日.jpg'),
(5,'苏东坡传','林语堂',19.30,100,100,'upload/books/苏东坡传.jpg'),
(6,'百年孤独','马尔克斯',29.50,100,100,'upload/books/百年孤独.jpg'),
(7,'扶桑','严歌苓',19.80,100,100,'upload/books/扶桑.jpg'),
(8,'给孩子的诗','北岛',22.20,100,100,'upload/books/给孩子的诗.jpg'),
(9,'为奴十二年','所罗门',16.50,100,100,'upload/books/为奴十二年.jpg'),
(10,'平凡的世界','路遥',55.00,100,100,'upload/books/平凡的世界.jpg'),
(11,'悟空传','今何在',14.00,100,100,'upload/books/悟空传.jpg'),
(12,'硬派健身','斌卡',31.20,100,100,'upload/books/硬派健身.jpg'),
(13,'从晚清到民国','唐德刚',39.90,100,100,'upload/books/从晚清到民国.jpg'),
(14,'三体','刘慈欣',56.50,100,100,'upload/books/三体.jpg'),
(15,'看见','柴静',19.50,100,100,'upload/books/看见.jpg'),
(16,'活着','余华',11.00,100,100,'upload/books/活着.jpg'),
(17,'小王子','安托万',19.20,100,100,'upload/books/小王子.jpg'),
(18,'我们仨','杨绛',11.30,100,100,'upload/books/我们仨.jpg'),
(19,'生命不息,折腾不止','罗永浩',25.20,100,100,'upload/books/生命不息.jpg'),
(20,'皮囊','蔡崇达',23.90,100,100,'upload/books/皮囊.jpg'),
(21,'恰到好处的幸福','毕淑敏',16.40,100,100,'upload/books/恰到好处的幸福.jpg'),
(22,'大数据预测','埃里克',37.20,100,100,'upload/books/大数据预测.jpg'),
(23,'人月神话','布鲁克斯',55.90,100,100,'upload/books/人月神话.jpg'),
(24,'C语言入门经典','霍尔顿',45.00,100,100,'upload/books/C语言入门经典.jpg'),
(25,'数学之美','吴军',29.90,100,100,'upload/books/数学之美.jpg'),
(26,'Java编程思想','埃史尔',70.50,100,100,'upload/books/Java编程思想.jpg'),
(27,'设计模式之禅','秦小波',20.20,100,100,'upload/books/设计模式之禅.jpg'),
(28,'图解机器学习','杉山将',33.80,100,100,'upload/books/图解机器学习.jpg'),
(29,'艾伦图灵传','安德鲁',47.20,100,100,'upload/books/艾伦图灵传.jpg'),
(30,'教父','马里奥普佐',29.00,100,100,'upload/books/教父.jpg');

CREATE TABLE `users` (
  `id` INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) UNIQUE KEY NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) DEFAULT NULL
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `users` */
INSERT  INTO `users`(`id`,`username`,`password`,`email`) VALUES
 (1,'admin',PASSWORD('123456'),'admin@atguigu.com'),
 (2,'admin2',PASSWORD('123456'),'admin2@atguigu.com'),
 (3,'admin3',PASSWORD('123456'),'admin3@atguigu.com'),
 (4,'chai',PASSWORD('123'),'chai@atguigu.com');

CREATE TABLE `orders` (
  `id` VARCHAR(100) PRIMARY KEY NOT NULL,
  `order_time` DATETIME NOT NULL,
  `total_count` INT(11) NOT NULL,
  `total_amount` DOUBLE(11,2) NOT NULL,
  `state` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  CONSTRAINT `orders_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */
INSERT  INTO `orders`(`id`,`order_time`,`total_count`,`total_amount`,`state`,`user_id`) VALUES 
('15275760194821','2018-05-29 14:40:19',4,114.03,2,1),
('15294258455691','2018-06-20 00:30:45',2,50.20,0,1);


CREATE TABLE `order_items` (
  `id` INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `count` INT(11) NOT NULL,
  `amount` DOUBLE(11,2) NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `author` VARCHAR(100) NOT NULL,
  `price` DOUBLE(11,2) NOT NULL,
  `img_path` VARCHAR(100) NOT NULL,
  `order_id` VARCHAR(100) NOT NULL,
  CONSTRAINT `order_items_orders_id_fk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `order_items` */
INSERT  INTO `order_items`
(`id`,`count`,`amount`,`title`,`author`,`price`,`img_path`,`order_id`) VALUES 
(1,1,27.20,'解忧杂货店','东野圭吾',27.20,'static/img/default.jpg','15275760194821'),
(2,1,23.00,'边城','沈从文',23.00,'static/img/default.jpg','15275760194821'),
(3,1,44.50,'中国哲学史','冯友兰',44.50,'static/img/default.jpg','15275760194821'),
(4,1,19.33,'忽然七日',' 劳伦',19.33,'static/img/default.jpg','15275760194821'),
(5,1,27.20,'解忧杂货店','东野圭吾',27.20,'static/img/default.jpg','15294258455691'),
(6,1,23.00,'边城','沈从文',23.00,'static/img/default.jpg','15294258455691');

