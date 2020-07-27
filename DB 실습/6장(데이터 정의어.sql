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