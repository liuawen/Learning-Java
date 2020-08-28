/*
SQLyog v10.2 
MySQL - 5.5.49 : Database - tensquare_qa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tensquare_qa` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tensquare_qa`;

/*Table structure for table `tb_pl` */

DROP TABLE IF EXISTS `tb_pl`;

CREATE TABLE `tb_pl` (
  `problemid` varchar(20) NOT NULL COMMENT '问题ID',
  `labelid` varchar(20) NOT NULL COMMENT '标签ID',
  PRIMARY KEY (`problemid`,`labelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_pl` */

insert  into `tb_pl`(`problemid`,`labelid`) values ('1','1');

/*Table structure for table `tb_problem` */

DROP TABLE IF EXISTS `tb_problem`;

CREATE TABLE `tb_problem` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建日期',
  `updatetime` datetime DEFAULT NULL COMMENT '修改日期',
  `userid` varchar(20) DEFAULT NULL COMMENT '用户ID',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `visits` bigint(20) DEFAULT NULL COMMENT '浏览量',
  `thumbup` bigint(20) DEFAULT NULL COMMENT '点赞数',
  `reply` bigint(20) DEFAULT NULL COMMENT '回复数',
  `solve` varchar(1) DEFAULT NULL COMMENT '是否解决',
  `replyname` varchar(100) DEFAULT NULL COMMENT '回复人昵称',
  `replytime` datetime DEFAULT NULL COMMENT '回复日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题';

/*Data for the table `tb_problem` */

insert  into `tb_problem`(`id`,`title`,`content`,`createtime`,`updatetime`,`userid`,`nickname`,`visits`,`thumbup`,`reply`,`solve`) values ('1','这是个问题','代码调试不通咋办？','2018-01-08 11:50:50','2018-01-09 11:50:54','2',NULL,101,NULL,NULL,NULL);

/*Table structure for table `tb_reply` */

DROP TABLE IF EXISTS `tb_reply`;

CREATE TABLE `tb_reply` (
  `id` varchar(20) NOT NULL COMMENT '编号',
  `problemid` varchar(20) DEFAULT NULL COMMENT '问题ID',
  `content` text COMMENT '回答内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建日期',
  `updatetime` datetime DEFAULT NULL COMMENT '更新日期',
  `userid` varchar(20) DEFAULT NULL COMMENT '回答人ID',
  `nickname` varchar(100) DEFAULT NULL COMMENT '回答人昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回答';

/*Data for the table `tb_reply` */

insert  into `tb_reply`(`id`,`problemid`,`content`,`createtime`,`updatetime`,`userid`,`nickname`) values ('','1',NULL,NULL,NULL,NULL,NULL);
insert  into `tb_reply`(`id`,`problemid`,`content`,`createtime`,`updatetime`,`userid`,`nickname`) values ('2','1','问老师呗','2018-01-10 14:14:06',NULL,'1',NULL);
insert  into `tb_reply`(`id`,`problemid`,`content`,`createtime`,`updatetime`,`userid`,`nickname`) values ('3','2','明天再调','2018-01-07 14:14:13',NULL,'1',NULL);

/*Table structure for table `tb_ul` */

DROP TABLE IF EXISTS `tb_ul`;

CREATE TABLE `tb_ul` (
  `uid` varchar(20) NOT NULL COMMENT '用户ID',
  `lid` varchar(20) NOT NULL COMMENT '标签ID',
  PRIMARY KEY (`uid`,`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_ul` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
