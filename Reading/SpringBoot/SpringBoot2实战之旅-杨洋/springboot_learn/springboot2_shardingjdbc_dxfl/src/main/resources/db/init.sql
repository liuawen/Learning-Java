CREATE DATABASE database0;
USE database0;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	id bigint(64) not null,
	city varchar(20) not null,
	name varchar(20) not null,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE DATABASE database1;
USE database1;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	id bigint(64) not null,
	city varchar(20) not null,
	name varchar(20) not null,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `database1`.`user`(`id`, `city`, `name`) VALUES (101, 'beijing', 'dalaoyang1');

CREATE DATABASE database2;
USE database2;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	id bigint(64) not null,
	city varchar(20) not null,
	name varchar(20) not null,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `database2`.`user`(`id`, `city`, `name`) VALUES (102, 'beijing', 'dalaoyang2');