/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.5.49 : Database - tensquare_base
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tensquare_base` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tensquare_base`;

/*Table structure for table `tb_city` */

DROP TABLE IF EXISTS `tb_city`;

CREATE TABLE `tb_city` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `name` varchar(20) DEFAULT NULL COMMENT '城市名称',
  `ishot` varchar(1) DEFAULT NULL COMMENT '是否热门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市';

/*Data for the table `tb_city` */

insert  into `tb_city`(`id`,`name`,`ishot`) values 
('1','北京','1'),
('2','上海','1'),
('3','广州','1'),
('4','深圳','1'),
('5','天津','0'),
('6','重庆','0'),
('7','西安','0');

/*Table structure for table `tb_label` */

DROP TABLE IF EXISTS `tb_label`;

CREATE TABLE `tb_label` (
  `id` varchar(20) NOT NULL COMMENT '标签ID',
  `labelname` varchar(100) DEFAULT NULL COMMENT '标签名称',
  `state` varchar(1) DEFAULT NULL COMMENT '状态',
  `count` bigint(20) DEFAULT NULL COMMENT '使用数量',
  `recommend` varchar(1) DEFAULT NULL COMMENT '是否推荐',
  `fans` bigint(20) DEFAULT NULL COMMENT '粉丝数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签';

/*Data for the table `tb_label` */

insert  into `tb_label`(`id`,`labelname`,`state`,`count`,`recommend`,`fans`) values 
('1','java','1',NULL,NULL,NULL),
('2','PHP','1',NULL,NULL,NULL),
('3','C++','1',NULL,NULL,NULL),
('4','python','1',NULL,NULL,NULL);

/*Table structure for table `tb_ul` */

DROP TABLE IF EXISTS `tb_ul`;

CREATE TABLE `tb_ul` (
  `userid` varchar(20) NOT NULL,
  `labelid` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`,`labelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_ul` */

insert  into `tb_ul`(`userid`,`labelid`) values 
('1','1'),
('1','2'),
('1','3');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
