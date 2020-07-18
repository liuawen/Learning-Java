drop table if exists tbProduct;
drop table if exists tbProduct_Comment;

/*==============================================================*/
/* Table: tbProduct                                                */
/*==============================================================*/
create table tbProduct
(
   id                   int unsigned not null auto_increment comment '主键',
   name                 varchar(100) comment '产品名称',
   cover_image          varchar(100) comment '产品封面图片',
   price                int not null default 0 comment '产品价格(分)',
   primary key (id)
);

create table tbProduct_Comment
(
   id                   int unsigned not null auto_increment comment '主键',
   product_id           int unsigned comment '所属产品',
   author_id            int unsigned comment '作者Id',
   content              varchar(200) comment '评论内容',
   created              TIMESTAMP comment '创建时间',
   primary key (id)
);