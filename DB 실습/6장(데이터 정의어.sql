--6��(������ ���Ǿ�)
create table testk (u_id varchar2(10),u_date date);
create table t_student 
as select * from student where stu_dept='���';
desc t_student;
select * from t_student;
 
alter table t_student
add ( army char(1));
 
alter table t_student
modify(army number);
 
alter table t_student drop (army);

rename t_student to test_student;
desc test_student;

truncate table test_student;--������ �Բ� �� ����
delete table test_student;-- ������ ����� ������ ����
select*from test_student;
drop table test_student;--���̺� ����

--���̺� ����, ���� ����, ���� ����
--1. ��� ������ �����ϱ� ���� ���̺� ���� �� Ȯ��
create table emp01(
empno number(4),
ename varchar2(14),
sal number(7,3));

desc emp01;

--2. ������̺� ��¥ Ÿ���� ������ birth �÷� �߰��� �� Ȯ��(add)
alter table emp01
add (birth date);
 desc emp01;
--3. ��� �̸� �÷� ũ�� (30) ���� �� Ȯ��(modify)
alter table emp01
modify(ename varchar2(30));
 desc emp01;
--4. ������̺��� �̸� Į�� ������ �� Ȯ��
alter table emp01
drop(ename);
 desc emp01;
--5. UNUSED KEY
alter table emp01
set unused(empno);
 desc emp01;
 --unused ǥ��
 select*from DBA_UNUSED_COL_TABS;
--6. unused�� ǥ�õ� ��� �÷��� �����ϱ�
alter table emp01
drop unused columns;
--7. ���̺� �̸� ���� (emp02) �� Ȯ��
rename emp01 to emp02;
 desc emp02;
--8. ������̺� (emp02) �����ϱ� �� Ȯ��
truncate table emp02;
drop table emp02;

create table t_student
(stu_no char(9),
stu_name varchar2(12) constraint u_stu_name unique,
stu_dept varchar2(20) constraint n_stu_dept not null,
stu_grade number(1),
stu_class char(1),
stu_gender char(1) constraint c_stu_gender check (stu_gender in('M','F')),
stu_height number(5,2),
stu_weight number(5,2),
constraint p_stu_no primary key(stu_no)
);
commit;
create table t_enrol(
sub_no char(3),
stu_no char(9),
enr_grade number(3),
constraint enr_stu_no foreign key(stu_no) references t_student(stu_no),
constraint p_enol primary key(sub_no, stu_no)
);

--�������� ���������� Ȯ�� �Ҷ��� �빮��.
select*from user_constraints 
where table_name = 'T_STUDENT';
select*from user_constraints 
where table_name = 'T_ENROL';

desc t_student;

select constraint_name,table_name, column_name 
from user_cons_columns;
--���� ������ ����
alter table t_enrol drop constraints enr_stu_no cascade; 
select*from user_constraints  --Ȯ��
where table_name = 'T_ENROL';
--���������� Ȱ��ȭ, ��Ȱ��ȭ
select*from user_constraints 
where table_name = 'T_STUDENT';
alter table t_student 
disable constraint n_stu_dept;
alter table t_student 
enable constraint n_stu_dept;

create table emp01(
empno number(4),
ename varchar2(10),
job varchar2(9),
deptno number(2)
);
select*from emp01;

insert into emp01
values(null,null,'���',30);

select constraint_name, constraint_type, table_name
from user_constraints
where table_name = 'emp01';

create table emp02(
 empno number(4) not null,
 ename varchar2(10) not null,
 job varchar2(9),
 deptno number(2)
);

insert into emp02
values(null,null,'���',30);

select constraint_name, constraint_type, table_name
from user_constraints
where table_name = 'emp02';
insert into emp02
values(1000,'����','���',30);
select * from emp02;
insert into emp02
values (1000,'ȫ�浿','����',20);
commit;
create table emp03(
 empno number(4) unique, --�ߺ��� �ȵǰ� ���� �� �� �ִ�. �׷��ٸ� �����̸Ӹ�Ű��?
 ename varchar2(10) not null,
 job varchar2(9),
 deptno number(2)
);
select * from emp03;

insert into emp03
values(1000,'����','���',30);
insert into emp03
values (1000,'ȫ�浿','����',20);
insert into emp03
values (null,'���߱�','����',20);

create table emp04(
empno number(4) constraint emp04_empno_uk unique,
ename varchar2(10) constraint emp04_ename_nn not null,
job varchar2(9),
deptno number(2)
);

select constraint_name, constraint_type, table_name
from user_constraints
where table_name in('EMP04');

insert into emp04
values (1000,'����','���',30);

select *from emp04;
rollback;
insert into emp04
values (1000, 'ȫ�浿','����',20);

create table emp05(
empno number(4) constraint emp05_empno_pk primary key,
ename varchar2(10) constraint emp05_ename_nn not null,
job varchar2(9),
deptno number(2)
);

select constraint_name, constraint_type, table_name
from user_constraints
where table_name in('EMP05');
select * from emp05;
insert into emp05
values (1000 ,'����','���',30);
 --pk�� �⺻������ �ϳ��ۿ� �ȵ� �ߺ��� �Ǹ� �ɷ����� (uniqe)
insert into emp05
values(1000, 'ȫ�浿', '����',20); 
--pk�� �ΰ��� �ȉ�.
insert into emp05
values(null,'�̼���','����',10);
commit;

create table emp07(
 empno number(4)
    constraint emp07_empno_pk primary key,
 ename varchar2(10)
    constraint emp07_ename_nn not null,
 sal number(7,2)
    constraint emp07_sal_ck check(sal between 500 and 5000),
 gender varchar2(1)
    constraint emp07_gender_ck check(gender in('M','F'))
);

select constraint_name, constraint_type, table_name
from user_constraints
where table_name in('EMP07');

insert into emp07
values (1000,'����',600,'M');
select*from emp07;

create table dept01(
 deptno number(2) primary key,
 dname varchar2(14),
 loc varchar2(13) default'����'
);
select *from dept01;

insert into dept01
values (000,'�����','���');
insert into dept01(deptno, dname)
values (002,'�����');
drop table dept01;
delete table dept01;

create table emp08 (
 empno number(4) primary key,
 ename varchar2(10) not null,
 job varchar2(9) unique,
 deptno number(2) references dept(deptno)
);
select constraint_name, constraint_type, r_constraint_name, table_name
from user_constraints
where table_name in('EMP08');

create table emp09(
 empno number(4),
 ename varchar2(10) not null,
 job varchar2(9),
 deptno number(2),
 primary key(empno),
 unique(job),
 foreign key(deptno) references dept(deptno)
);

select constraint_name, constraint_type, r_constraint_name, table_name
from user_constraints
where table_name in('EMP09');

create table emp11(
empno number(4),
ename varchar2(10) constraint emp11_ename_nn not null,
job varchar2(9),
deptno number(2),
CONSTRAINT EMP11_EMPNO_PK primary key(EMPNO),
constraint EMP11_JOB_UK UNIQUE(JOB),
constraint EMP11_DEPTNO_FK foreign key(DEPTNO)
        references dept(deptno)
        );
select constraint_name, constraint_type, r_constraint_name, table_name
from user_constraints
where table_name in('EMP11');


--�⺻Ű�� 2���� �÷����� ������ ���
create table member01(
 name varchar2(10),
 address varchar2(30),
 hphone varchar2(16),
 constraint member01_combo_pk primary key (name,hphone)
 );
select constraint_name, constraint_type, r_constraint_name, table_name
from user_constraints
where table_name in('MEMBER01'); 

select constraint_name, table_name, column_name
from user_cons_columns
where table_name in('MEMBER01'); 

select constraint_name, constraint_type, r_constraint_name, table_name
from user_constraints
where table_name in('EMP01'); 

select * from emp01;

alter table emp01
add constraint emp01_empno_pk 
primary key(empno);

alter table emp01
add constraint emp01_deptno_fk
foreign key(deptno) references dept(deptno);
desc emp01;

alter table emp01
modify ename constraint emp01_ename_nn not null;

alter table emp01
drop primary key;

-- view ��
create or replace view v_student1 -- ���� ����ų� �籸�� �ϴ�. 
as 
select * from student where stu_dept = '��ǻ������';

select *from v_student1;

--����
--emp ���̺��� deptno�� 20�� �����͸� �����Ͽ� ������ ���̺�(v_emp1)�� ����ÿ�.
create or replace view v_emp1
as 
select *from emp where deptno=20;

select* from v_emp1;
--���κ�
create or replace view v_enrol1
as select sub_name, a.sub_no, stu_no, enr_grade
from enrol a, subject b
where a.sub_no = b.sub_no;

select * from v_enrol1;
--���κ� ����
create or replace view v_emp2
as 
select empno,ename,mgr,hiredate,sal,dept.dname
from emp, dept
where emp.deptno = dept.deptno;

select * from v_emp2;
--�ζ��κ�
select stu_no,stu_name,a.stu_dept,stu_height
from student a, (select stu_dept, avg(stu_height)
                as avg_height
                from student
                group by stu_dept)b
where a.stu_dept = b.stu_dept
and a.stu_height > b.avg_height;
--�ζ��κ� ����
--�μ��� ��� �� �޿��� ���� ���� �޴� ����� ������ �˻��Ͻÿ�.
select a.empno,a.ename,a.sal,c.dname
from emp a, (select deptno,max(sal) maxsal
            from emp 
            group by deptno)b,dept c
where a.deptno=b.deptno and a.sal=b.maxsal and a.deptno = c.deptno
order by a.deptno;
--top-n ���� 
select stu_no, stu_name, stu_height
from (select stu_no, stu_name, stu_height
        from student
        where stu_height is not null
        order by stu_height desc)
where rownum <=5;
--emp ���̺��� �޿��� ���� ���� �޴� 5���� �����ȣ, �̸�, �޿��� �˻��Ͻÿ�.
select empno,ename,sal
from (select empno,ename,sal
        from emp
        where sal is not null
        order by sal desc)
where rownum <= 5;

--�л��� �̸����� �ε��� ����
create index i_stu_name on student(stu_name);
--�л��� �й��� �̸��� ���ļ� �ε����� ����
create index i_stu_no_name on student(stu_no,stu_name);
--������ ������ �ε��� ����
create unique index i_stu_name on student(stu_name);
--�Լ��� ������ �̿��Ͽ� �ε��� ����
create index i_stu_weight on student(stu_weight-5);

select*from user_indexes
where table_name = 'STUDENT';

drop index i_stu_name;

--������ �Խ��� ���� �� ����� �� ����.
create sequence seq1
increment by 2
start with 1000
maxvalue 10000;

select seq1.nextval from dual;
select seq1.currval from dual;
run;

--�� ����

select *from emp
where deptno=30;
create or replace view v_emp30
as select empno, ename, sal, deptno
from emp 
where deptno =30;

select * from v_emp30;

--emp���̺��� deptno�� 10�� ����� empno,ename,job,sal�� �˻��ؼ� (v_emp10)�� �������̺��� ����ÿ�.
select * from emp where deptno=10;
create or replace view v_emp10
as select empno, ename,job,sal 
from emp 
where deptno=10;
select * from v_emp10;

drop view v_emp10;

create sequence seq2
increment by 1
start with 1
maxvalue 100;

select seq2.nextval from dual; --�ڵ� ���� ��
select seq2.currval from dual; --���� ���� ����

alter sequence seq2
increment by 2
;

drop sequence seq2;

create sequence emp_seq
start with 1
increment by 1
maxvalue 100000;

create table emp12(
empno number(4) primary key,
ename varchar(10),
hiredate date
);

select * from emp_seq;

select * from emp12;

select constraint_name, constraint_type, table_name
from user_constraints
where table_name in('EMP12');

insert into emp12
values(emp_seq.nextval,'������',SYSDATE);
insert into emp12
values(emp_seq.nextval,'�̼���',SYSDATE);
insert into emp12
values(emp_seq.nextval,'�����',SYSDATE);
insert into emp12
values(emp_seq.nextval,'������',SYSDATE);
insert into emp12
values(emp_seq.nextval,'�޷�',SYSDATE);

select sequence_name, min_value, max_value, increment_by
from user_sequences;

--��� rownum �÷����� top-n
create or replace view view_hire
as
select empno,ename,hiredate 
from emp
order by hiredate;

select rownum, empno, ename, hiredate
from view_hire;

select rownum,empno,ename,hiredate
from view_hire
where rownum <=10;

--�ζ��� ��� top-n ���ϱ�
select rownum,empno,ename,hiredate
from (select * from view_hire)
where rownum <=5;

select rownum,empno,ename,hiredate
from (select empno,ename, hiredate from emp order by hiredate)
where rownum <=5;

select empno,ename, hiredate from emp order by hiredate;

