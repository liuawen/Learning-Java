/*
SQLyog v10.2 
MySQL - 5.5.49 : Database - tensquare_gathering
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tensquare_gathering` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tensquare_gathering`;

/*Table structure for table `tb_gathering` */

DROP TABLE IF EXISTS `tb_gathering`;

CREATE TABLE `tb_gathering` (
  `id` varchar(20) NOT NULL COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '活动名称',
  `summary` text COMMENT '大会简介',
  `detail` text COMMENT '详细说明',
  `sponsor` varchar(100) DEFAULT NULL COMMENT '主办方',
  `image` varchar(100) DEFAULT NULL COMMENT '活动图片',
  `starttime` datetime DEFAULT NULL COMMENT '开始时间',
  `endtime` datetime DEFAULT NULL COMMENT '截止时间',
  `address` varchar(100) DEFAULT NULL COMMENT '举办地点',
  `enrolltime` datetime DEFAULT NULL COMMENT '报名截止',
  `state` varchar(1) DEFAULT NULL COMMENT '是否可见',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动';

/*Data for the table `tb_gathering` */

insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('1','测试活动','喝茶看电影，不亦乐乎','喝茶看电影，不亦乐乎','黑马程序员',NULL,'2017-12-14 15:39:32','2017-12-21 15:39:36',NULL,NULL,'1','1');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('94377594140','aaaa',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('943776146707845','aaaa',NULL,NULL,'ssss',NULL,NULL,NULL,'cccc',NULL,'1','1');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('943776663576121344','aaaa',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','2');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('943783521749700608','2342423',NULL,NULL,'23454534',NULL,NULL,NULL,'545435435',NULL,'1','2');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('944085821768732672','JAVAEE茶话会',NULL,NULL,'传智',NULL,NULL,NULL,'金燕龙',NULL,'1','2');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('944086086991351808','是',NULL,NULL,'11',NULL,NULL,NULL,'11',NULL,'1','3');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('944090372710207488','大讨论',NULL,NULL,'小马',NULL,NULL,NULL,'消息',NULL,'1','3');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('944105652622594048','测试测试',NULL,NULL,'测试者',NULL,NULL,NULL,'测试地址',NULL,'1','4');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('945227340642914304','111',NULL,NULL,'222',NULL,NULL,NULL,'333',NULL,'1','5');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('945227678527655936','111',NULL,NULL,'222',NULL,NULL,NULL,'333',NULL,'1','5');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('945235087564345344','啊啊',NULL,NULL,'1',NULL,NULL,NULL,'1',NULL,'1','1');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('945235534329024512','1',NULL,NULL,'1',NULL,NULL,NULL,'1',NULL,'1','2');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('945235859786043392','1',NULL,NULL,'1',NULL,NULL,NULL,'1',NULL,'1','3');
insert  into `tb_gathering`(`id`,`name`,`summary`,`detail`,`sponsor`,`image`,`starttime`,`endtime`,`address`,`enrolltime`,`state`,`city`) values ('951384896167874560','??',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `tb_usergath` */

DROP TABLE IF EXISTS `tb_usergath`;

CREATE TABLE `tb_usergath` (
  `userid` varchar(20) NOT NULL COMMENT '用户ID',
  `gathid` varchar(20) NOT NULL COMMENT '活动ID',
  `exetime` datetime DEFAULT NULL COMMENT '点击时间',
  PRIMARY KEY (`userid`,`gathid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关注活动';

/*Data for the table `tb_usergath` */

insert  into `tb_usergath`(`userid`,`gathid`,`exetime`) values ('1','200','2018-01-06 15:44:04');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
