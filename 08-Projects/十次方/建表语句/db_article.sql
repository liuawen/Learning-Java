/*
SQLyog v10.2 
MySQL - 5.5.49 : Database - tensquare_article
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tensquare_article` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tensquare_article`;

/*Table structure for table `tb_article` */

DROP TABLE IF EXISTS `tb_article`;

CREATE TABLE `tb_article` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `columnid` varchar(20) DEFAULT NULL COMMENT '专栏ID',
  `userid` varchar(20) DEFAULT NULL COMMENT '用户ID',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '文章正文',
  `image` varchar(100) DEFAULT NULL COMMENT '文章封面',
  `createtime` datetime DEFAULT NULL COMMENT '发表日期',
  `updatetime` datetime DEFAULT NULL COMMENT '修改日期',
  `ispublic` varchar(1) DEFAULT NULL COMMENT '是否公开',
  `istop` varchar(1) DEFAULT NULL COMMENT '是否置顶',
  `visits` int(20) DEFAULT NULL COMMENT '浏览量',
  `thumbup` int(20) DEFAULT NULL COMMENT '点赞数',
  `comment` int(20) DEFAULT NULL COMMENT '评论数',
  `state` varchar(1) DEFAULT NULL COMMENT '审核状态',
  `channelid` varchar(20) DEFAULT NULL COMMENT '所属频道',
  `url` varchar(100) DEFAULT NULL COMMENT 'URL',
  `type` varchar(1) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章';

/*Data for the table `tb_article` */


/*Table structure for table `tb_channel` */

DROP TABLE IF EXISTS `tb_channel`;

CREATE TABLE `tb_channel` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '频道名称',
  `state` varchar(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='频道';

/*Data for the table `tb_channel` */

/*Table structure for table `tb_column` */

DROP TABLE IF EXISTS `tb_column`;

CREATE TABLE `tb_column` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '专栏名称',
  `summary` varchar(1000) DEFAULT NULL COMMENT '专栏简介',
  `userid` varchar(20) DEFAULT NULL COMMENT '用户ID',
  `createtime` datetime DEFAULT NULL COMMENT '申请日期',
  `checktime` datetime DEFAULT NULL COMMENT '审核日期',
  `state` varchar(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专栏';

/*Data for the table `tb_column` */


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
