--5장 데이터 갱신과 트레젝션 제어

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

--원본 수정
update a_enrol
set enr_grade = enr_grade +5;

update a_enrol
set enr_grade = enr_grade +10
where sub_no = 104;

update a_enrol 
set enr_grade = enr_grade +10
where sub_no = (select sub_no from subject 
                where sub_name = '시스템분석설계');
                
                select sub_no from subject 
                where sub_name = '시스템분석설계';
                
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

--예시

create table t_readonly(
no number, 
name varchar2(10));

insert into t_readonly values(1,'AAA');
select * from t_readonly;
commit;

--읽기 전형으로 변경한다.

alter table t_readonly read only;
alter table t_readonly read write;
insert into t_readonly values(2,'BBB');
delete from t_readonly;--데이터 삭제
drop table t_readonly;--테이블 삭제

--5장 실습문제

--1.학번 20101059,이름 조병준, 학과 컴퓨터정보,학년 1, 반 B,키 164, 몸무게 70인 남학생을 추가하시오
insert into student1 values('20101059','조병준','컴퓨터정보',1,'B','M',164,70);
select * from student1;
--2.학번 20102038,이름
insert into student1(stu_no,stu_name,stu_dept,stu_year,stu_class,stu_gender) 
values('20102038','남지선','전기전자',1,'C','F');
--3.
insert into student1 (stu_no,stu_name,stu_dept,stu_year,stu_class,stu_gender) 
values('20103009','박소신','기계',
(select stu_year from student1 where stu_no = '20093075'),
(select stu_class from student1 where stu_no = '20093075'),'M');
--4.student1 테이블에 student데이터 중 3학년 집어넣기.
insert into student1 
(select * from student where stu_grade=3);
--5.학번 찾아서 반 수정하기
select*from student1 where stu_no = 20072088;
update student1 set stu_class='B' where stu_no=20072088;
--6.학생의 키가 자란걸 update
select *from student1 where stu_name='김인중';
update student1 
set stu_height=stu_height+2 
where stu_no=20061062;
--7. 신학년이 되어 학년을 올려주어라.
select*from student1;
update student1
set stu_year=stu_year+1;
--8. 학과와 학번 바꾸기
update student1 
set stu_dept='컴퓨터정보', stu_no=20061021
where stu_no=20062021;
--9.기계공작법 과목의 점수를 10점 감하기
select *from enrol1
where SUB_NO = (select sub_no from subject1 
where sub_name='기계공작법');
update enrol1  
set enr_grade =enr_grade-10
where SUB_NO = (select sub_no from subject1 
where sub_name='기계공작법');
--10.김인중 학생의 성적을 0점으로처리하시오
select * from enrol1 
where stu_no =(select stu_no from student1 where stu_name='김인중')
and sub_no = (select sub_no from subject1 where sub_name = '소프트웨어공학');
update enrol1
set enr_grade=0
where stu_no= 20061062 
and sub_no = (select sub_no from subject1 where sub_name = '소프트웨어공학');
commit;
-- 11. 20093088이 자퇴했다.
delete from student1
where stu_no= 20093088;
--12. 과목번호 112,과목명 자동화시스템, 교수면 고종민, 학년 3, 학과 기계를 추가하시오(subject1 테이블에 추가)
select*from subject1;
insert into subject1 values('112','자동화시스템','고종민',3,'기계');
--과목번호를 110에서 501로 변경하시오.
select*from subject1;
update subject1
set sub_no = 501
where sub_no = 110;
--14.과목번호 101을 폐강으로 처리하시오.
delete from subject1
where sub_no = 101;
rollback;
--15. enrol1 테이블에서 subject1 테이블에 없는 과목번호를 999로 변경하시오.
select*from enrol1;
update enrol1
set sub_no=999
where sub_no not in(select sub_no from subject1); --not in 포함되지 않은
--16. enrol1 테이블에서 과목번호 999를 삭제합니다.
select*from enrol1;
delete from enrol1
where sub_no=999;
--17. subject1테이블에서enrol1 테이블에 없는 과목을 삭제하시오.
delete from subject1
where sub_no not in 
(select distinct sub_no from enrol1);
select *from subject1;
--18. enrol1전체데이터를 삭제하시오
delete from enrol1;
rollback;
drop table enrol1;
--Merger 예시
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