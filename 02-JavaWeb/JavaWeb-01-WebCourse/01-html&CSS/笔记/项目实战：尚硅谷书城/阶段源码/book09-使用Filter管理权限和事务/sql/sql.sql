drop database if exists atguigu;	## 如果原来的数据库存在，就删除

create database atguigu;			## 创建数据库

use atguigu;					## 切换到数据库


##创建表t_user
create table t_user(
	`id` int primary key auto_increment,
	`username` varchar(50) not null unique,
	`password` varchar(32) not null,
	`email` varchar(50) 
);

##插入初始数据
insert into t_user(username,`password`,email) values('admin','admin','admin@atguigu.com');
insert into t_user(username,`password`,email) values('wzg168','wzg168','wzg168@atguigu.com');

## 查询表
select * from t_user;


##########################################################################
##########################################################################
##########################################################################
##########################################################################
##########################################################################
##########################################################################

##创建图书表
create table t_book(
	`id` int(11) primary key auto_increment, 	## 主键
	`name` varchar(50) not null,				## 书名 
	`author` varchar(50) not null,				## 作者
	`price` decimal(11,2) not null,				## 价格
	`sales` int(11) not null,					## 销量
	`stock` int(11) not null,					## 库存
	`img_path` varchar(200) not null			## 书的图片路径
);


## 插入初始化测试数据
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , 'java从入门到放弃' , '国哥' , 80 , 9999 , 9 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , '数据结构与算法' , '严敏君' , 78.5 , 6 , 13 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , '怎样拐跑别人的媳妇' , '龙伍' , 68, 99999 , 52 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , '木虚肉盖饭' , '小胖' , 16, 1000 , 50 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , 'C++编程思想' , '刚哥' , 45.5 , 14 , 95 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , '蛋炒饭' , '周星星' , 9.9, 12 , 53 , 'static/img/default.jpg');
 
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , '赌神' , '龙伍' , 66.5, 125 , 535 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , 'Java编程思想' , '阳哥' , 99.5 , 47 , 36 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , 'JavaScript从入门到精通' , '婷姐' , 9.9 , 85 , 95 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , 'cocos2d-x游戏编程入门' , '国哥' , 49, 52 , 62 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , 'C语言程序设计' , '谭浩强' , 28 , 52 , 74 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , 'Lua语言程序设计' , '雷丰阳' , 51.5 , 48 , 82 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , '西游记' , '罗贯中' , 12, 19 , 9999 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , '水浒传' , '华仔' , 33.05 , 22 , 88 , 'static/img/default.jpg');
 
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , '操作系统原理' , '刘优' , 133.05 , 122 , 188 , 'static/img/default.jpg');
 
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , '数据结构 java版' , '封大神' , 173.15 , 21 , 81 , 'static/img/default.jpg');
 
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , 'UNIX高级环境编程' , '乐天' , 99.15 , 210 , 810 , 'static/img/default.jpg');
 
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , 'javaScript高级编程' , '国哥' , 69.15 , 210 , 810 , 'static/img/default.jpg');
 
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , '大话设计模式' , '国哥' , 89.15 , 20 , 10 , 'static/img/default.jpg');
 
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) 
values(null , '人月神话' , '刚哥' , 88.15 , 20 , 80 , 'static/img/default.jpg');
 


## 查看表内容
select id,name,author,price,sales,stock,img_path from t_book;



##########################################################################
##########################################################################
##########################################################################
##########################################################################
##########################################################################
##########################################################################

## 订单表
create table t_order(
	`order_id` varchar(50) primary key,  	##订单号
	`create_time` datetime not null,	##订单时间
	`total_money` decimal(11,2) not null,	##总金额 
	`status` int not null default 0, 	##物流状态：0-未发货、1-等待用户签收、2-用户已签收
	`user_id` int not null,			##用户编号
	foreign key (`user_id`) references t_user(`id`)
);


## 订单项
create table t_order_item(
	`id` int primary key auto_increment, 
	`name` varchar(30) not null,		##商品名
	`price` decimal(11,2),			##商品单价
	`total_money` decimal(11,2),		##商品总金额
	`count` int not null,			##商品数量
	`order_id` varchar(50) not null,	##订单号
	foreign key (`order_id`) references t_order(`order_id`)
);

