drop table member cascade constraint;

create table member(
	id varchar2(10) primary key,
	password varchar2(10) not null,
	name varchar2(50) not null,
	email varchar2(50) not null,
	join_date char(8) not null
);


20150507 




select * from member