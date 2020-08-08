drop table if exists tbUser;

/*==============================================================*/
/* Table: tbUser                                                */
/*==============================================================*/
create table tbUser
(
   id                   int unsigned not null auto_increment comment '主键',
   nickname             varchar(50) comment '用户昵称',
   avatar               varchar(255) comment '用户头像',
   primary key (id)
);
