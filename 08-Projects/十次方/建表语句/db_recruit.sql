/*
SQLyog v10.2 
MySQL - 5.5.49 : Database - tensquare_recruit
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tensquare_recruit` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tensquare_recruit`;

/*Table structure for table `tb_enterprise` */

DROP TABLE IF EXISTS `tb_enterprise`;

CREATE TABLE `tb_enterprise` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '企业名称',
  `summary` varchar(1000) DEFAULT NULL COMMENT '企业简介',
  `address` varchar(100) DEFAULT NULL COMMENT '企业地址',
  `labels` varchar(100) DEFAULT NULL COMMENT '标签列表',
  `coordinate` varchar(100) DEFAULT NULL COMMENT '坐标',
  `ishot` varchar(1) DEFAULT NULL COMMENT '是否热门',
  `logo` varchar(100) DEFAULT NULL COMMENT 'LOGO',
  `jobcount` int DEFAULT NULL COMMENT '职位数',
  `url` varchar(100) DEFAULT NULL COMMENT 'URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业';

/*Data for the table `tb_enterprise` */

insert  into `tb_enterprise`(`id`,`name`,`summary`,`address`,`labels`,`coordinate`,`ishot`) values ('','传智播客','国内著名IT教育机构','金燕龙办公楼','IT 培训','1019,2223','1');
insert  into `tb_enterprise`(`id`,`name`,`summary`,`address`,`labels`,`coordinate`,`ishot`) values ('2','小米','手机厂商','中关村软件园','手机','0211,3333','0');

/*Table structure for table `tb_recruit` */

DROP TABLE IF EXISTS `tb_recruit`;

CREATE TABLE `tb_recruit` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `jobname` varchar(100) DEFAULT NULL COMMENT '职位名称',
  `salary` varchar(100) DEFAULT NULL COMMENT '薪资范围',
  `condition` varchar(100) DEFAULT NULL COMMENT '经验要求',
  `education` varchar(100) DEFAULT NULL COMMENT '学历要求',
  `type` varchar(1) DEFAULT NULL COMMENT '任职方式',
  `address` varchar(100) DEFAULT NULL COMMENT '办公地址',
  `eid` varchar(20) DEFAULT NULL COMMENT '企业ID',
  `createtime` datetime DEFAULT NULL COMMENT '创建日期',
  `state` varchar(1) DEFAULT NULL COMMENT '状态',
  `url` varchar(100) DEFAULT NULL COMMENT '网址',
  `label` varchar(100) DEFAULT NULL COMMENT '标签',
  `content1` varchar(100) DEFAULT NULL COMMENT '职位描述',
  `content2` varchar(100) DEFAULT NULL COMMENT '职位要求',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位';

/*Data for the table `tb_recruit` */

insert  into `tb_recruit`(`id`,`jobname`,`salary`,`condition`,`education`,`type`,`address`,`eid`,`createtime`,`state`,`url`) values ('','大数据工程师','20000-30000','八年以上开发经验','本科','1','国贸','1','2018-01-06 16:21:12','1',NULL);
insert  into `tb_recruit`(`id`,`jobname`,`salary`,`condition`,`education`,`type`,`address`,`eid`,`createtime`,`state`,`url`) values ('1','java开发工程师','15000-20000','五年以上开发经验','本科','1','中关村软件园','1','2018-01-05 15:38:05','1','http://www.baidu.com');
insert  into `tb_recruit`(`id`,`jobname`,`salary`,`condition`,`education`,`type`,`address`,`eid`,`createtime`,`state`,`url`) values ('2','php开发工程师','4000-6000','一年以上开发经验','专科','1','王府街宏福创业园','1','2018-01-07 16:10:20','1','http://www.baidu.com');
insert  into `tb_recruit`(`id`,`jobname`,`salary`,`condition`,`education`,`type`,`address`,`eid`,`createtime`,`state`,`url`) values ('3','.net开发工程师','2000-3000','一年以上开发经验','专科','1','大望路','1','2018-01-06 16:20:27','2',NULL);
insert  into `tb_recruit`(`id`,`jobname`,`salary`,`condition`,`education`,`type`,`address`,`eid`,`createtime`,`state`,`url`) values ('5','前端开发工程师','8000-12000','三年以上开发经验','本科','1','上地','1','2018-01-18 16:22:11','2',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
