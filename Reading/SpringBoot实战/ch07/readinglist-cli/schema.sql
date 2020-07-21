create table Book (
	id identity,
	reader varchar(20) not null,
	isbn varchar(10) not null,
	title varchar(50) not null,
	author varchar(50) not null,
	description varchar(2000) not null
);