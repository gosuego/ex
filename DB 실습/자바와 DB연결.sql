--자바와 DB연결

Create Table EVENT(
Uname Varchar2(30),
Email Varchar2(50)
);
select *from event;

create table books(
Book_ID number not null primary key,
title varchar2(50),
publisher varchar2(30),
year varchar2(10),
price number
);

create sequence book_no_seq increment by 1 start with 1;
