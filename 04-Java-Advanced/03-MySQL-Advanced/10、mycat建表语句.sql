#客户表 rows:20万
Create table customer(
   id int auto_increment,
   name varchar(200),
   primary key(id)
);

#订单表 rows:600万
create table orders(
   id int auto_increment,
   order_type int,
   customer_id int,
   amount decimal(10,2),
   PRIMARY KEY(id)
);

#订单详情表 rows：600万
create table orders_detail(
   id INT AUTO_INCREMENT,
   detail varchar(2000),
   order_id int,
   PRIMARY KEY(id)
);

#订单状态字典表 rows：20
create table dict_order_type(
   id INT AUTO_INCREMENT,
   order_type varchar(200),
   PRIMARY KEY(id)
);


TRUNCATE TABLE 
insert into customer values(100,'zhang3');
INSERT INTO customer VALUES(101,'li4');

insert into orders(id,order_type,customer_id,amount) values(1,101,100,100100);
INSERT INTO orders(id,order_type,customer_id,amount) VALUES(2,101,100,100300);
INSERT INTO orders(id,order_type,customer_id,amount) VALUES(3,101,101,120000);
INSERT INTO orders(id,order_type,customer_id,amount) VALUES(4,101,101,103000);
INSERT INTO orders(id,order_type,customer_id,amount) VALUES(5,102,101,100400);
INSERT INTO orders(id,order_type,customer_id,amount) VALUES(6,102,100,100020);


insert into dict_order_type values(101,'type1');
insert into dict_order_type values(101,'type1');

select * from orders o inner join customer c on  o.customer_id=c.id;
select * from orders o inner join dict_order_type ot on ot.id=o.order_type;

select * from orders

SELECT * FROM orders o INNER JOIN orders_detail od ON od.order_id=o.id;

insert into orders_detail(id,detail,order_id) values(1,'detail1',1);
INSERT INTO orders_detail(id,detail,order_id) VALUES(2,'detail1',2);
INSERT INTO orders_detail(id,detail,order_id) VALUES(3,'detail1',3);
INSERT INTO orders_detail(id,detail,order_id) VALUES(4,'detail1',4);
INSERT INTO orders_detail(id,detail,order_id) VALUES(5,'detail1',5);
INSERT INTO orders_detail(id,detail,order_id) VALUES(6,'detail1',6);

use TESTDB;
delete from dict_order_type;

insert into dict_order_type(id,order_type) values(101,'type1');
INSERT INTO dict_order_type(id,order_type) VALUES(102,'type2');


alter table orders change id id bigint;

insert into `orders`(id,amount,customer_id,order_type) values(next value for MYCATSEQ_GLOBAL,1000,103,101);

select * from orders;


select * from customer c inner join orders o 

federated

