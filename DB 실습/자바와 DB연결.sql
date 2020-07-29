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

insert into books (book_id,title,publisher,year,price)
values(book_no_seq.nextval,'Operating System Concepts','Wiley','2003',30700);
insert into books (book_id,title,publisher,year,price)
values(book_no_seq.nextval,'Head First PHP and MYSQL','Oreilly','2009',58000);
insert into books (book_id,title,publisher,year,price)
values(book_no_seq.nextval,'C Programming Language','Prentice-Hall','1989',35000);
insert into books (book_id,title,publisher,year,price)
values(book_no_seq.nextval,'Head First SQL','Oreilly','2007',43000);

select * from books;
commit;

select * from student;

create table scores(
name varchar2(10),
score varchar2(10)
);

create table product(
prcode number(11,0) not null primary key,
prname varchar2(45) not null,
price number(11,0) not null,
manufacture varchar2(20) not null
);

create sequence prcode_seq increment by 1 start with 1;

commit;
