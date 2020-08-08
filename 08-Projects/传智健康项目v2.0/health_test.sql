/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/28 20:55:41                           */
/*==============================================================*/


drop table if exists t_checkgroup;

drop table if exists t_checkgroup_checkitem;

drop table if exists t_checkitem;

drop table if exists t_member;

drop table if exists t_menu;

drop table if exists t_order;

drop table if exists t_ordersetting;

drop table if exists t_permission;

drop table if exists t_role;

drop table if exists t_role_menu;

drop table if exists t_role_permission;

drop table if exists t_setmeal;

drop table if exists t_setmeal_checkgroup;

drop table if exists t_user;

drop table if exists t_user_role;

/*==============================================================*/
/* Table: t_checkgroup                                          */
/*==============================================================*/
create table t_checkgroup
(
   id                   int(11) not null auto_increment,
   code                 varchar(32) default NULL,
   name                 varchar(32) default NULL,
   helpCode             varchar(32) default NULL,
   sex                  char(1) default NULL,
   remark               varchar(128) default NULL,
   attention            varchar(128) default NULL,
   primary key (id)
);

alter table t_checkgroup comment '体检检查组';

/*==============================================================*/
/* Table: t_checkgroup_checkitem                                */
/*==============================================================*/
create table t_checkgroup_checkitem
(
   checkgroup_id        int(11) not null default 0,
   checkitem_id         int(11) not null default 0,
   primary key (checkgroup_id, checkitem_id)
);

/*==============================================================*/
/* Table: t_checkitem                                           */
/*==============================================================*/
create table t_checkitem
(
   id                   int(11) not null auto_increment,
   code                 varchar(16) default NULL,
   name                 varchar(32) default NULL,
   sex                  char(1) default NULL,
   age                  varchar(32) default NULL,
   price                float default NULL,
   type                 char(1) default NULL comment '查检项类型,分为检查和检验两种',
   attention            varchar(128) default NULL,
   remark               varchar(128) default NULL,
   primary key (id)
);

alter table t_checkitem comment '体检检查项';

/*==============================================================*/
/* Table: t_member                                              */
/*==============================================================*/
create table t_member
(
   id                   int(11) not null auto_increment,
   fileNumber           varchar(32) default NULL,
   name                 varchar(32) default NULL,
   sex                  varchar(8) default NULL,
   idCard               varchar(18) default NULL,
   phoneNumber          varchar(11) default NULL,
   regTime              date default NULL,
   password             varchar(32) default NULL,
   email                varchar(32) default NULL,
   birthday             date default NULL,
   remark               varchar(128) default NULL,
   primary key (id)
);

/*==============================================================*/
/* Table: t_menu                                                */
/*==============================================================*/
create table t_menu
(
   id                   int not null auto_increment,
   name                 varchar(128),
   linkUrl              varchar(128),
   path                 varchar(128),
   priority             int,
   description          varchar(128),
   parentMenuId         int,
   icon                 varchar(64),
   level                int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_order                                               */
/*==============================================================*/
create table t_order
(
   id                   int(11) not null auto_increment,
   member_id            int(11) default NULL comment '员会id',
   orderDate            date default NULL comment '约预日期',
   orderType            varchar(8) default NULL comment '约预类型 电话预约/微信预约',
   orderStatus          varchar(8) default NULL comment '预约状态（是否到诊）',
   setmeal_id           int(11) default NULL comment '餐套id',
   primary key (id)
);

/*==============================================================*/
/* Table: t_ordersetting                                        */
/*==============================================================*/
create table t_ordersetting
(
   id                   int(11) not null auto_increment,
   orderDate            date default NULL comment '约预日期',
   number               int(11) default NULL comment '可预约人数',
   reservations         int(11) default NULL comment '已预约人数',
   primary key (id)
);

alter table t_ordersetting comment '预约设置';

/*==============================================================*/
/* Table: t_permission                                          */
/*==============================================================*/
create table t_permission
(
   id                   int not null auto_increment,
   name                 varchar(32),
   keyword              varchar(64),
   description          varchar(128),
   primary key (id)
);

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   id                   int not null auto_increment,
   name                 varchar(32),
   keyword              varchar(64),
   description          varchar(128),
   primary key (id)
);

/*==============================================================*/
/* Table: t_role_menu                                           */
/*==============================================================*/
create table t_role_menu
(
   role_id              int not null,
   menu_id              int not null,
   primary key (role_id, menu_id)
);

/*==============================================================*/
/* Table: t_role_permission                                     */
/*==============================================================*/
create table t_role_permission
(
   role_id              int not null,
   permission_id        int not null,
   primary key (role_id, permission_id)
);

/*==============================================================*/
/* Table: t_setmeal                                             */
/*==============================================================*/
create table t_setmeal
(
   id                   int(11) not null auto_increment,
   name                 varchar(128) default NULL,
   code                 varchar(8) default NULL,
   helpCode             varchar(16) default NULL,
   sex                  char(1) default NULL,
   age                  varchar(32) default NULL,
   price                float default NULL,
   remark               varchar(128) default NULL,
   attention            varchar(128) default NULL,
   img                  varchar(128) default NULL,
   primary key (id)
);

alter table t_setmeal comment '体检套餐';

/*==============================================================*/
/* Table: t_setmeal_checkgroup                                  */
/*==============================================================*/
create table t_setmeal_checkgroup
(
   setmeal_id           int(11) not null default 0,
   checkgroup_id        int(11) not null default 0,
   primary key (setmeal_id, checkgroup_id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int not null auto_increment,
   birthday             date,
   gender               varchar(1),
   username             varchar(32),
   password             varchar(36),
   remark               varchar(32),
   station              varchar(1),
   telephone            varchar(11),
   primary key (id)
);

/*==============================================================*/
/* Table: t_user_role                                           */
/*==============================================================*/
create table t_user_role
(
   user_id              int not null,
   role_id              int not null,
   primary key (user_id, role_id)
);

alter table t_checkgroup_checkitem add constraint FK_Reference_5 foreign key (checkitem_id)
      references t_checkitem (id) on delete restrict on update restrict;

alter table t_checkgroup_checkitem add constraint group_id foreign key (checkgroup_id)
      references t_checkgroup (id);

alter table t_menu add constraint FK_Reference_13 foreign key (parentMenuId)
      references t_menu (id) on delete restrict on update restrict;

alter table t_order add constraint FK_Reference_6 foreign key (setmeal_id)
      references t_setmeal (id) on delete restrict on update restrict;

alter table t_order add constraint key_member_id foreign key (member_id)
      references t_member (id);

alter table t_role_menu add constraint FK_Reference_10 foreign key (menu_id)
      references t_menu (id) on delete restrict on update restrict;

alter table t_role_menu add constraint FK_Reference_9 foreign key (role_id)
      references t_role (id) on delete restrict on update restrict;

alter table t_role_permission add constraint FK_Reference_11 foreign key (role_id)
      references t_role (id) on delete restrict on update restrict;

alter table t_role_permission add constraint FK_Reference_12 foreign key (permission_id)
      references t_permission (id) on delete restrict on update restrict;

alter table t_setmeal_checkgroup add constraint checkgroup_key foreign key (checkgroup_id)
      references t_checkgroup (id);

alter table t_setmeal_checkgroup add constraint setmeal_key foreign key (setmeal_id)
      references t_setmeal (id);

alter table t_user_role add constraint FK_Reference_7 foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_user_role add constraint FK_Reference_8 foreign key (role_id)
      references t_role (id) on delete restrict on update restrict;

