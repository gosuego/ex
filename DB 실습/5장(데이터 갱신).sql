--5�� ������ ���Ű� Ʈ������ ����

create table a_enrol
as select*
    from enrol
    where stu_no < 20150000;

commit;

desc a_enrol;
select*from a_enrol;

insert into a_enrol(sub_no, stu_no, enr_grade)
values (108,20151062,92);
insert into a_enrol values(109,20152088,85);

insert into a_enrol(sub_no, stu_no)
values (110, 20152088);

insert into a_enrol
values(111, 20153078, null);

insert into a_enrol
select * from enrol
where stu_no like '2015%';


select * from a_enrol;

--���� ����
update a_enrol
set enr_grade = enr_grade +5;

update a_enrol
set enr_grade = enr_grade +10
where sub_no = 104;

update a_enrol 
set enr_grade = enr_grade +10
where sub_no = (select sub_no from subject 
                where sub_name = '�ý��ۺм�����');
                
                select sub_no from subject 
                where sub_name = '�ý��ۺм�����';
                
delete from a_enrol
where stu_no = 20131001;

delete from a_enrol;

drop table a_enrol;

delete from b_student;

select * from b_student;

rollback;

create table c_student
(stu_no number,
stu_name char(10));

select*from a_student;

desc tmpa_emp;
select*from tmpa_emp;

insert into tmpa_emp(empno,ename,hirdate,sal,deptno)
values(1,'kim',to_date('2013-01-01'),700,40);

insert into tmpa_emp(empno,ename,hirdate,sal,deptno)
values(2,'kang',to_date('2013-01-01'),800,40);

insert into tmpa_emp(empno,ename,hirdate)
values(3,'kho',to_date('2013-01-01'));

insert into tmpa_emp(empno,ename)
values(4,'lee');

select user,sysdate
from dual;

insert into tmpa_emp(empno,ename,hirdate,sal,deptno)
values(5,'park',sysdate,850,20);

select * from dual;

select * from tmpa_emp;
select * from tmpb_emp;

insert into tmpb_emp
select*from tmpa_emp
where empno<10;

delete from tmpa_emp
where deptno=10;

delete tmpb_emp
where deptno = (select deptno
                from dept
                where loc = 'DALLAS');
select deptno from dept where loc = 'DALLAS';

delete from tmpa_emp;
rollback;
commit;

update tmpb_emp
set sal =sal  +500
where deptno = (select deptno from dept
                where dname = 'SALES');
select deptno from dept where dname = 'SALES';
commit;

--����

create table t_readonly(
no number, 
name varchar2(10));

insert into t_readonly values(1,'AAA');
select * from t_readonly;
commit;

--�б� �������� �����Ѵ�.

alter table t_readonly read only;
alter table t_readonly read write;
insert into t_readonly values(2,'BBB');
delete from t_readonly;--������ ����
drop table t_readonly;--���̺� ����

--5�� �ǽ�����

--1.�й� 20101059,�̸� ������, �а� ��ǻ������,�г� 1, �� B,Ű 164, ������ 70�� ���л��� �߰��Ͻÿ�
insert into student1 values('20101059','������','��ǻ������',1,'B','M',164,70);
select * from student1;
--2.�й� 20102038,�̸�
insert into student1(stu_no,stu_name,stu_dept,stu_year,stu_class,stu_gender) 
values('20102038','������','��������',1,'C','F');
--3.
insert into student1 (stu_no,stu_name,stu_dept,stu_year,stu_class,stu_gender) 
values('20103009','�ڼҽ�','���',
(select stu_year from student1 where stu_no = '20093075'),
(select stu_class from student1 where stu_no = '20093075'),'M');
--4.student1 ���̺� student������ �� 3�г� ����ֱ�.
insert into student1 
(select * from student where stu_grade=3);
--5.�й� ã�Ƽ� �� �����ϱ�
select*from student1 where stu_no = 20072088;
update student1 set stu_class='B' where stu_no=20072088;
--6.�л��� Ű�� �ڶ��� update
select *from student1 where stu_name='������';
update student1 
set stu_height=stu_height+2 
where stu_no=20061062;
--7. ���г��� �Ǿ� �г��� �÷��־��.
select*from student1;
update student1
set stu_year=stu_year+1;
--8. �а��� �й� �ٲٱ�
update student1 
set stu_dept='��ǻ������', stu_no=20061021
where stu_no=20062021;
--9.�����۹� ������ ������ 10�� ���ϱ�
select *from enrol1
where SUB_NO = (select sub_no from subject1 
where sub_name='�����۹�');
update enrol1  
set enr_grade =enr_grade-10
where SUB_NO = (select sub_no from subject1 
where sub_name='�����۹�');
--10.������ �л��� ������ 0������ó���Ͻÿ�
select * from enrol1 
where stu_no =(select stu_no from student1 where stu_name='������')
and sub_no = (select sub_no from subject1 where sub_name = '����Ʈ�������');
update enrol1
set enr_grade=0
where stu_no= 20061062 
and sub_no = (select sub_no from subject1 where sub_name = '����Ʈ�������');
commit;
-- 11. 20093088�� �����ߴ�.
delete from student1
where stu_no= 20093088;
--12. �����ȣ 112,����� �ڵ�ȭ�ý���, ������ ������, �г� 3, �а� ��踦 �߰��Ͻÿ�(subject1 ���̺� �߰�)
select*from subject1;
insert into subject1 values('112','�ڵ�ȭ�ý���','������',3,'���');
--�����ȣ�� 110���� 501�� �����Ͻÿ�.
select*from subject1;
update subject1
set sub_no = 501
where sub_no = 110;
--14.�����ȣ 101�� ������ ó���Ͻÿ�.
delete from subject1
where sub_no = 101;
rollback;
--15. enrol1 ���̺��� subject1 ���̺� ���� �����ȣ�� 999�� �����Ͻÿ�.
select*from enrol1;
update enrol1
set sub_no=999
where sub_no not in(select sub_no from subject1); --not in ���Ե��� ����
--16. enrol1 ���̺��� �����ȣ 999�� �����մϴ�.
select*from enrol1;
delete from enrol1
where sub_no=999;
--17. subject1���̺���enrol1 ���̺� ���� ������ �����Ͻÿ�.
delete from subject1
where sub_no not in 
(select distinct sub_no from enrol1);
select *from subject1;
--18. enrol1��ü�����͸� �����Ͻÿ�
delete from enrol1;
rollback;
drop table enrol1;
--Merger ����
create table charge_01
(u_date varchar2(6),
cust_no number,
u_time number,
charger number);
create table charge_02
(u_date varchar2(6),
cust_no number,
u_time number,
charger number);

insert into charge_01 values('141001',1000,2,1000);
insert into charge_01 values('141001',1001,2,1000);
insert into charge_01 values('141001',1002,1,500);
insert into charge_02 values('141002',1000,3,1500);
insert into charge_02 values('141002',1001,4,2000);
insert into charge_02 values('141002',1003,1,500);

create table ch_total
(u_date varchar2(6),
cust_no number,
u_time number,
charger number);

merge into ch_total total
using charge_01 ch01
on(total.u_date = ch01.u_date)
when matched then
update set total.cust_no = ch01.cust_no
when not matched then
insert values(ch01.u_date,ch01.cust_no,ch01.u_time,ch01.charger);

merge into ch_total total
using charge_02 ch02
on(total.u_date = ch02.u_date)
when matched then
update set total.cust_no = ch02.cust_no
when not matched then
insert values(ch02.u_date,ch02.cust_no,ch02.u_time,ch02.charger);

select*from ch_total;