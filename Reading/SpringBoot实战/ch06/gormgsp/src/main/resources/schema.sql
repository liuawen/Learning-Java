create table Reader (
	id identity,
	username varchar(20),
	password varchar(20),
	fullname varchar(100),
	version int
);

create table Book (
	id identity,
	isbn varchar(15),
	title varchar(200),
	author varchar(20),
	description varchar(2000),
	version int
);