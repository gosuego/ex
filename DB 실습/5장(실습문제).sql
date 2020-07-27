--5장 실습문제

--학사관리2

create table student1(
stu_no char(9),
stu_name varchar2(12),
stu_dept varchar2(20),
stu_year number(1),
stu_class char(1),
stu_gender char(1),
stu_height number(5,2),
stu_weight number(5,2),
constraint k_stu_no primary key(stu_no));

insert into student1 values('20093075', '옥한빛','기계',1,'C','M',177,80);
insert into student1 values('20093088', '이태연','기계',1,'C','F',162,50);
insert into student1 values('20093054', '유가인','기계',2,'C','F',154,47);
insert into student1 values('20072088', '조민우','전기전자',1,'C','M',188,90);
insert into student1 values('20062021', '심수정','전기전자',2,'A','F',168,45);
insert into student1 values('20061062', '김인중','컴퓨터정보',1,'B','M',166,67);
insert into student1 values('20061007', '진현무','컴퓨터정보',2,'C','M',174,64);

create table subject1(
sub_no char(3),
sub_name varchar2(30),
sub_prof varchar2(12),
sub_year number(1),
sub_dept varchar2(20),
constraint k_sub_no primary key(sub_no));

insert into subject1 values('111', '데이터베이스','이재영',2,'컴퓨터정보');
insert into subject1 values('110', '자동제어','정순정',2,'전기전자');
insert into subject1 values('109', '자동화설계','박민영',3,'기계');
insert into subject1 values('101', '컴퓨터개론','강종영',3,'컴퓨터정보');
insert into subject1 values('102', '기계공작법','김태영',1,'기계');
insert into subject1 values('103', '기초전자실험','김유석',1,'전기전자');
insert into subject1 values('104', '시스템분석설계','강석현',3,'컴퓨터정보');
insert into subject1 values('105', '기계요소설계','김명성',1,'기계');
insert into subject1 values('106', '전자회로실험','최영민',3,'전기전자');
insert into subject1 values('107', 'CAD응용실습','구봉규',2,'기계');
insert into subject1 values('108', '소프트웨어공학','권민성',1,'컴퓨터정보');

create table enrol1(
sub_no char(3),
stu_no char(9),
enr_grade number(3),
constraint k_course primary key(sub_no,stu_no));

insert into enrol1 values('101','20071001',80);
insert into enrol1 values('104','20071001',56);
insert into enrol1 values('106','20052003',72);
insert into enrol1 values('103','20072088',45);
insert into enrol1 values('101','20071025',65);
insert into enrol1 values('104','20071025',65);
insert into enrol1 values('108','20061062',81);
insert into enrol1 values('107','20093054',41);
insert into enrol1 values('102','20093075',66);
insert into enrol1 values('105','20093075',56);
insert into enrol1 values('102','20093088',61);
insert into enrol1 values('105','20093088',78);

commit;