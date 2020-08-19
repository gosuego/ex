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

create table t_enrol(
sub_no char(3),
stu_no char(9),
enr_grade number(3),
constraint enr_stu_no foreign key(stu_no) references t_student(stu_no),
constraint p_enol primary key(sub_no, stu_no)
);


--제약조건 제약조건을 확인 할때는 대문자.
select*from user_constraints 
where table_name = 'T_STUDENT';
select*from user_constraints 
where table_name = 'T_ENROL';

desc t_student;

select constraint_name,table_name, column_name 
from user_cons_columns;
--제약 조건의 삭제
alter table t_enrol drop constraints enr_stu_no cascade; 
select*from user_constraints  --확인
where table_name = 'T_ENROL';
--제약조건의 활성화, 비활성화
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
values(null,null,'사원',30);

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
values(null,null,'사원',30);

select constraint_name, constraint_type, table_name
from user_constraints
where table_name = 'emp02';
insert into emp02
values(1000,'허준','사원',30);
select * from emp02;
insert into emp02
values (1000,'홍길동','과장',20);
commit;
create table emp03(
 empno number(4) unique, --중복이 안되고 널은 들어갈 수 있다. 그렇다면 프라이머리키는?
 ename varchar2(10) not null,
 job varchar2(9),
 deptno number(2)
);
select * from emp03;

insert into emp03
values(1000,'허준','사원',30);
insert into emp03
values (1000,'홍길동','과장',20);
insert into emp03
values (null,'안중근','과장',20);

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
values (1000,'허준','사원',30);

select *from emp04;
rollback;
insert into emp04
values (1000, '홍길동','과장',20);

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
values (1000 ,'허준','사원',30);
 --pk는 기본적으로 하나밖에 안됨 중복이 되면 걸려버림 (uniqe)
insert into emp05
values(1000, '홍길동', '과장',20); 
--pk는 널값이 안됌.
insert into emp05
values(null,'이순신','부장',10);
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
values (1000,'허준',600,'M');
select*from emp07;

create table dept01(
 deptno number(2) primary key,
 dname varchar2(14),
 loc varchar2(13) default'서울'
);
select *from dept01;

insert into dept01
values (000,'고수현','울산');
insert into dept01(deptno, dname)
values (002,'고수현');
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


--기본키가 2개의 컬럼으로 구성된 경우
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

-- view 뷰
create or replace view v_student1 -- 새로 만들거나 재구성 하다. 
as 
select * from student where stu_dept = '컴퓨터정보';

select *from v_student1;

--예시
--emp 테이블에서 deptno가 20인 데이터를 수집하여 가상의 테이블(v_emp1)를 만드시오.
create or replace view v_emp1
as 
select *from emp where deptno=20;

select* from v_emp1;
--조인뷰
create or replace view v_enrol1
as select sub_name, a.sub_no, stu_no, enr_grade
from enrol a, subject b
where a.sub_no = b.sub_no;

select * from v_enrol1;
--조인뷰 예시
create or replace view v_emp2
as 
select empno,ename,mgr,hiredate,sal,dept.dname
from emp, dept
where emp.deptno = dept.deptno;

select * from v_emp2;
--인라인뷰
select stu_no,stu_name,a.stu_dept,stu_height
from student a, (select stu_dept, avg(stu_height)
                as avg_height
                from student
                group by stu_dept)b
where a.stu_dept = b.stu_dept
and a.stu_height > b.avg_height;
--인라인뷰 예시
--부서별 사원 중 급여를 가장 많이 받는 사원의 정보를 검색하시오.
select a.empno,a.ename,a.sal,c.dname
from emp a, (select deptno,max(sal) maxsal
            from emp 
            group by deptno)b,dept c
where a.deptno=b.deptno and a.sal=b.maxsal and a.deptno = c.deptno
order by a.deptno;
--top-n 질의 
select stu_no, stu_name, stu_height
from (select stu_no, stu_name, stu_height
        from student
        where stu_height is not null
        order by stu_height desc)
where rownum <=5;
--emp 테이블에서 급여를 가장 많이 받는 5명의 사원번호, 이름, 급여를 검색하시오.
select empno,ename,sal
from (select empno,ename,sal
        from emp
        where sal is not null
        order by sal desc)
where rownum <= 5;

--학생의 이름으로 인덱스 생성
create index i_stu_name on student(stu_name);
--학생의 학번과 이름을 합쳐서 인덱스를 생성
create index i_stu_no_name on student(stu_no,stu_name);
--유일한 값으로 인덱스 생성
create unique index i_stu_name on student(stu_name);
--함수나 수식을 이용하여 인덱스 생성
create index i_stu_weight on student(stu_weight-5);

select*from user_indexes
where table_name = 'STUDENT';

drop index i_stu_name;

--시퀸스 게시판 만들 때 써먹을 수 있음.
create sequence seq1
increment by 2
start with 1000
maxvalue 10000;

select seq1.nextval from dual;
select seq1.currval from dual;
run;

--뷰 예제

select *from emp
where deptno=30;
create or replace view v_emp30
as select empno, ename, sal, deptno
from emp 
where deptno =30;

select * from v_emp30;

--emp테이블에서 deptno가 10번 사원의 empno,ename,job,sal를 검색해서 (v_emp10)의 가상테이블을 만드시오.
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

select seq2.nextval from dual; --자동 증가 값
select seq2.currval from dual; --현재 나의 숫자

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
values(emp_seq.nextval,'강감찬',SYSDATE);
insert into emp12
values(emp_seq.nextval,'이순신',SYSDATE);
insert into emp12
values(emp_seq.nextval,'종대왕',SYSDATE);
insert into emp12
values(emp_seq.nextval,'윤봉길',SYSDATE);
insert into emp12
values(emp_seq.nextval,'메롱',SYSDATE);

select sequence_name, min_value, max_value, increment_by
from user_sequences;

--뷰와 rownum 컬럼으로 top-n
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

--인라인 뷰로 top-n 구하기
select rownum,empno,ename,hiredate
from (select * from view_hire)
where rownum <=5;

select rownum,empno,ename,hiredate
from (select empno,ename, hiredate from emp order by hiredate)
where rownum <=5;

select empno,ename, hiredate from emp order by hiredate;

--6장 실습문제
--1. 상품(product) 테이블을 생성하시오.
create table product 
(p_code char(3) not null,
p_name varchar2(30),
p_cost number,
p_group varchar2(30),
constraint p_code_pk primary key(p_code));

--2. 상품 테이블의 구조를 검색하시오
desc product;

--3. 상품 테이블에 다음과 같은 상품 정보를 삽입하시오.
insert into product values('101','19인치 모니터',150000,'모니터');
insert into product values('102','22인치 모니터',200000,'모니터');
insert into product values('103','25인치 모니터',260000,'모니터');
insert into product values('201','유선 마우스',7000,'마우스');
insert into product values('202','무선 마우스',18000,'마우스');
insert into product values('301','유선 키보드',8000,'키보드');
insert into product values('302','무선 키보드',22000,'키보드');
insert into product values('401','2채널 스피커',10000,'스피커');
insert into product values('402','5.1채널 스피커',120000,'스피커');
--4 상품 테이블 모든 데이터 검색
select * from product;

--5 상품 테이블에 비고(bigo) 열을 삽입하시오
alter table product
add bigo varchar2 (10);

--6 bigo 컬럼이 테이블에 삽입되었는지 확인
desc product;
--7 상품 테이블의 bigo 열 구조를 20자로 변경
alter table product
modify bigo varchar2 (20);
--8 상품 테이블의 변경된 bigo 열 구조 검색
desc product;
commit;
--9 BIGO 열 삭제
alter table product
drop (bigo);
--10 삭제되었는지 확인
desc product;
--11 상품 테이블명을 product1 로 변경
rename product to product1;
--12 변경되었는지 확인
desc product1;
--13 product1 테이블 내의 모든 데이터 삭제 (truncate 사용)
truncate table product1;
--14 확인을 위해 테이블 내용 검색
select * from product1;
--15 product1 테이블 삭제
drop table product1;
--16.emp 테이블과 dept 테이블을 조회하여 사원의 이름과 부서 이름을 출력하는 view를 생성하시오.(뷰이름.v_emp)
create or replace view v_emp
as 
  select e.ename, d.dname 
  from emp e,dept d
  where e.deptno=d.deptno;

select *from v_emp;

--17. emp 테이블과 dept 테이블을 조회하여 부서 번호와 부서별 최대 급여 및 부서명을 출력하시오.
select e.deptno, d.dname, e.sal
from (select deptno, MAX(sal) sal
        from emp
        group by deptno) e, dept d
where e.deptno = d.deptno;

