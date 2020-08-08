DROP DATABASE mldn ;
CREATE DATABASE mldn CHARACTER SET UTF8 ;
USE mldn ;
CREATE TABLE dept (
   deptno         bigint          AUTO_INCREMENT ,
   dname         varchar(50),
   loc     varchar(50) ,
   CONSTRAINT pk_deptno primary key (deptno)
) engine='innodb';
INSERT INTO dept (dname,loc) VALUES ('管理部','北京') ;
INSERT INTO dept (dname,loc) VALUES ('人事部','济南') ;
INSERT INTO dept (dname,loc) VALUES ('财务部','上海') ;
INSERT INTO dept (dname,loc) VALUES ('市场部','广州') ;
INSERT INTO dept (dname,loc) VALUES ('开发部','天津') ;
INSERT INTO dept (dname,loc) VALUES ('营销部','深圳') ;
INSERT INTO dept (dname,loc) VALUES ('后勤部','杭州') ;
INSERT INTO dept (dname,loc) VALUES ('仓储部','沧州') ;


CREATE TABLE member(
	mid		     VARCHAR(50) ,
	name	     VARCHAR(50) ,
	password      VARCHAR(32) ,
	locked	     INT ,
	CONSTRAINT pk_mid PRIMARY KEY(mid)
) ;
CREATE TABLE role (
	rid         VARCHAR(50)  ,
	title	     VARCHAR(50) ,
	CONSTRAINT pk_rid PRIMARY KEY(rid)
) ;
CREATE TABLE action (
	actid	      VARCHAR(50)	,
	title      VARCHAR(50) ,
	rid	     VARCHAR(50) ,
	CONSTRAINT pk_actid PRIMARY KEY(actid) 
) ;
CREATE TABLE member_role (
	mid	        VARCHAR(50) ,
	rid	     VARCHAR(50) 
) ;
INSERT INTO member(mid,name,password,locked) VALUES ('mldnjava','mldn','EAB62A7769F0313F8D69CEBA32F4347E',0) ;
INSERT INTO member(mid,name,password,locked) VALUES ('admin','admin','EAB62A7769F0313F8D69CEBA32F4347E',0) ;
INSERT INTO role(rid,title) VALUES ('emp','雇员管理') ;
INSERT INTO role(rid,title) VALUES ('dept','部门管理') ;
INSERT INTO action(actid,title,rid) VALUES ('emp:add','雇员入职','emp') ;
INSERT INTO action(actid,title,rid) VALUES ('emp:remove','雇员离职','emp') ;
INSERT INTO action(actid,title,rid) VALUES ('emp:list','雇员列表','emp') ;
INSERT INTO action(actid,title,rid) VALUES ('emp:edit','雇员编辑','emp') ;
INSERT INTO action(actid,title,rid) VALUES ('dept:list','部门列表','dept') ;
INSERT INTO action(actid,title,rid) VALUES ('dept:edit','部门编辑','dept') ;
INSERT INTO member_role(mid,rid) VALUES ('mldnjava','emp') ;
INSERT INTO member_role(mid,rid) VALUES ('admin','emp') ;
INSERT INTO member_role(mid,rid) VALUES ('admin','dept') ;