/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.11-log : Database - tensquare_notice
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tensquare_notice` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tensquare_notice`;

/*Table structure for table `tb_notice` */

DROP TABLE IF EXISTS `tb_notice`;

CREATE TABLE `tb_notice` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `receiverId` varchar(20) DEFAULT NULL COMMENT '接收消息用户的ID',
  `operatorId` varchar(20) DEFAULT NULL COMMENT '进行操作用户的ID',
  `action` varchar(255) DEFAULT NULL COMMENT '操作类型（评论，点赞等）',
  `targetType` varchar(255) DEFAULT NULL COMMENT '被操作的对象，例如文章，评论等',
  `targetId` varchar(20) DEFAULT NULL COMMENT '被操作对象的id，例如文章的id，评论的id',
  `createtime` datetime DEFAULT NULL COMMENT '发表日期',
  `type` varchar(20) DEFAULT NULL COMMENT '通知类型',
  `state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章';

/*Data for the table `tb_notice` */

INSERT INTO `tb_notice` VALUES ('1', '2', '1', 'publish', 'article', '1', '2019-05-05 17:14:52', 'sys', '0');
INSERT INTO `tb_notice` VALUES ('2', '2', '1', 'publish', 'article', '2', '2019-05-05 17:14:52', 'sys', '0');
INSERT INTO `tb_notice` VALUES ('3', '3', '2', 'publish', 'article', '3', '2019-05-05 17:15:13', 'sys', '0');
INSERT INTO `tb_notice` VALUES ('4', '3', '1', 'publish', 'problem', '4', '2019-05-05 17:15:13', 'sys', '0');
INSERT INTO `tb_notice` VALUES ('5', '2', '1', 'publish', 'problem', '5', '2019-05-05 17:15:23', 'sys', '0');
INSERT INTO `tb_notice` VALUES ('6', '3', '1', 'publish', 'problem', '6', '2019-05-05 17:15:23', 'sys', '0');

/*Table structure for table `tb_notice_fresh` */

DROP TABLE IF EXISTS `tb_notice_fresh`;

CREATE TABLE `tb_notice_fresh` (
  `userId` varchar(20) DEFAULT NULL COMMENT '用户id',
  `noticeId` varchar(20) DEFAULT NULL COMMENT '通知id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_notice_fresh` */

INSERT INTO `tb_notice_fresh` VALUES ('2', '1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
