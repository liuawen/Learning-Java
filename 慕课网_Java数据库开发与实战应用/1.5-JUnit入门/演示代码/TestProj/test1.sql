CREATE DATABASE IF NOT EXISTS `test1`  DEFAULT CHARACTER SET utf8;
USE `test1`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

