drop table if exists tbProduct;
drop table if exists tbProduct_Comment;
drop table if exists tbUser;

-- 商品表
create table tbProduct
(
   id                   int unsigned not null auto_increment comment '主键',
   name                 varchar(100) comment '商品名称',
   cover_image          varchar(100) comment '商品封面图片',
   price                int not null default 0 comment '商品价格(分)',
   primary key (id)
);
-- 商品评论表
create table tbProduct_Comment
(
   id                   int unsigned not null auto_increment comment '主键',
   product_id           int unsigned comment '所属商品',
   author_id            int unsigned comment '作者Id',
   content              varchar(200) comment '评论内容',
   created              TIMESTAMP comment '创建时间',
   primary key (id)
);
-- 用户表
create table tbUser
(
   id                   int unsigned not null auto_increment comment '主键',
   nickname             varchar(50) comment '用户昵称',
   avatar               varchar(255) comment '用户头像',
   primary key (id)
);
