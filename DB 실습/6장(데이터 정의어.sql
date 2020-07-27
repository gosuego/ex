--6장(데이터 정의어)
create table testk (u_id varchar2(10),u_date date);
create table t_student 
as select * from student where stu_dept='기계';
desc t_student;
select * from t_student;
 
alter table t_student
add ( army char(1));
 
alter table t_student
modify(army number);
 
alter table t_student drop (army);

rename t_student to test_student;
desc test_student;

truncate table test_student;--구조도 함께 다 삭제
delete table test_student;-- 구조는 남기고 데이터 삭제
select*from test_student;
drop table test_student;--테이블 삭제

--테이블 생성, 구조 변경, 삭제 문제
--1. 사원 정보를 저장하기 위한 테이블 생성 후 확인
create table emp01(
empno number(4),
ename varchar2(14),
sal number(7,3));

desc emp01;

--2. 사원테이블에 날짜 타입을 가지는 birth 컬럼 추가한 후 확인(add)
alter table emp01
add (birth date);
 desc emp01;
--3. 사원 이름 컬럼 크기 (30) 변경 후 확인(modify)
alter table emp01
modify(ename varchar2(30));
 desc emp01;
--4. 사원테이블에서 이름 칼럼 제거한 후 확인
alter table emp01
drop(ename);
 desc emp01;
--5. UNUSED KEY
alter table emp01
set unused(empno);
 desc emp01;
 --unused 표시
 select*from DBA_UNUSED_COL_TABS;
--6. unused로 표시된 모든 컬럼을 제거하기
alter table emp01
drop unused columns;
--7. 테이블 이름 변경 (emp02) 후 확인
rename emp01 to emp02;
 desc emp02;
--8. 사원테이블 (emp02) 제거하기 후 확인
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