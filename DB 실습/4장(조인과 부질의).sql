
--4장 조인

select student.*,enrol.* 
from student cross join enrol;

select emp.*,dept.*
from emp cross join dept;

select student.stu_no,stu_name,stu_dept,enr_grade
from student, enrol
where student.stu_no = enrol.stu_no;

select empno, ename, job, emp.deptno,dname,dept.deptno 
from emp,dept
where emp.deptno = dept.deptno;

--natual 조인
select empno,ename,job,deptno,dname 
from emp natural join dept;

select empno, ename, job, deptno, dname 
from emp join dept using(deptno);

select empno,ename,job,emp.deptno,dname 
from emp join dept on emp.deptno = dept.deptno;

select student.stu_no, stu_name 
from student, enrol
where student.stu_no = enrol.stu_no and
    sub_no = 101;
    
--emp 테이블에서 부서지역이 'CHICAGO'인 사원들의 이름을 검색하시오.
select empno,ename
from emp, dept
where emp.deptno=dept.deptno
and dept.loc= 'CHICAGO';

select student.stu_no, stu_name
from student, enrol
where student.stu_no = enrol.stu_no and (sub_no = 101 or sub_no = 102);

select stu_no, stu_name 
from student natural join enrol
where sub_no = 101 or sub_no = 102;

select stu_no, stu_name 
from student join enrol using(stu_no)
where sub_no = 101 or sub_no = 102;

select student.stu_no, stu_name
from student join enrol on student.stu_no = enrol.stu_no
where sub_no = 101 or sub_no =102;


select student.stu_no, stu_name, sub_name
from student, enrol,subject
where student.stu_no = enrol.stu_no
and enrol.sub_no = subject.sub_no
and enrol.sub_no = 101;

--non-equi조인
--where절에서 사용하는 '='이 아닌 연산자를 사용

select empno, ename, sal, grade
from emp, salgrade
where sal between losal and hisal;

select a.empno as 사원번호, a.ename as 사원이름, 
b.empno as 상급자사원번호, b.ename as 상급자이름 
from emp a, emp b
where a.mgr = b.empno;

--SELF 조인
--같은 테이블 간의 조인, 테이블의 별칭을 사용함
select a.empno as 사원번호, a.ename as 사원이름, 
b.empno as 상급자사원번호, b.ename as 상급자이름 
from emp a join emp b
on a.mgr = b.empno;

--Outer 조인
--outer join은 조인 조건을 만족하지 않는 행들도 질의 결과에 포함함

select a.*,sub_name 
from enrol a, subject b 
where a.sub_no = b.sub_no
order by 1;

select a.*,sub_name 
from enrol a right outer join subject b
on a.sub_no = b.sub_no
order by 1;

select empno,ename,dept.deptno,dname,loc
from emp right outer join dept
on emp.deptno = dept.deptno;

--self 조인
select a.empno as 사원번호, a.ename as 사원이름,
b.empno as 상급자사원번호,b.ename as 상급자이름
from emp a left outer join emp b
on a.mgr = b.empno;

select a.empno as 사원번호, a.ename as 사원이름,
b.empno as 상급자사원번호, b.ename as 상급자이름
from emp a full outer join emp b
on a.mgr=b.empno;

select ename from emp order by ename;
select RANK('SMITH') within group (order by ename)"RANK"
from emp;

select empno,ename,sal,
RANK() OVER (ORDER BY sal) as RANK_ASC
from emp;

select empno, ename,sal,
RANK() OVER(ORDER BY sal DESC) as RANK_DESC
from emp;

select empno,ename,sal,
RANK() OVER (order by sal desc) "RANK"
from emp
where deptno = 10;

select empno,ename,job,sal,
RANK() over (order by sal desc) sal_dense_rank,
row_number() over(order by sal desc) sal_row_num
from emp;

--부질의 하나의 질문으로 처리함(한 번 더 물어본다.)

select stu_height from student where stu_name = '옥성우';
select stu_height from student where stu_height > 172;
--(옥성우라는 조건값(172))에 그보다 큰이라는 조건이 병합됨.
select stu_no, stu_name, stu_height from student 
where stu_height > (select stu_height from student where stu_name = '옥성우');

--블레이크(2875)보다 큰 연봉 받는 것을 기준으로 사원번호 사원이름 월급출력 월급을 오름차순으로
select empno,ename,sal from emp 
where sal > (select sal from emp where ename ='BLAKE') 
order by sal;

--self 조인을 이용하여 재작성함
select a.stu_no, a.stu_name, a.stu_height from student a, student b
where a.stu_height > b.stu_height
and b.stu_name = '옥성우';

--블레이크보다 큰 연봉을 받는 것을 기준으로 사원번호 사원이름 월급출력 월급을 내림차순으로 self join 하라.
select a.empno, a.ename, a.sal 
from emp a, emp b 
where a.sal>b.sal and b.ename='BLAKE' order by sal desc;

--단열일 부질의
--emp테이블에서 'FORD' 사원과 같은 급여를 받고 있는 사원들의 정보를 검색하시오.(단, 'FORD'는 제거)
select * from emp where sal = 
    (select sal 
    from emp 
    where ename ='FORD')
    and ename <> 'FORD';

    
 --같은 값 중복 제거.   
select * from student where stu_weight = 
    (select stu_weight 
    from student 
    where stu_name = '박희철') 
    and stu_name <> '박희철';

-- in은 또는
--'컴퓨터정보' 과 학생과 같은 반을 가진 학생의 정보 검색 그리고 중복을 제거하라.
select * from student 
where stu_class in 
(select distinct stu_class 
from student where stu_dept ='컴퓨터정보')
and stu_dept <> '컴퓨터정보';

--예시
select job from emp where deptno = 10;

select * from emp where job in
(select job from emp where deptno=10);

select * from emp where job in
(select job from emp where deptno=10)
and deptno<>10;

select * 
from student 
where stu_height >all 
    (select avg(stu_height) 
    from student 
    group by stu_dept);
    
    
    --예시  any는 제일 작은 값
    select avg(sal) from emp where deptno=30;
    
select * from emp 
where sal> (select avg(sal) from emp where deptno=30);

select * from emp
where sal > any 
    (select avg(sal) 
    from emp 
    group by deptno);
--any를 min으로
select * from emp where sal>
    (select min(avg(sal))
    from emp
    group by deptno);

--all은 제일 큰것
select * from emp
where sal > all
    (select avg(sal)
    from emp
    group by deptno);

select stu_dept, min(stu_height) 
    from student 
    group by stu_dept having min(stu_height) >
        (select min(stu_height)
        from student 
        where stu_dept ='컴퓨터정보');
        
select * from student 
    where stu_height > all 
    (select avg(stu_height) 
    from student
    where stu_dept ='컴퓨터정보');    
    
select stu_dept,stu_no,stu_name,stu_height
from student;

select stu_dept, min(stu_height)
from student
group by stu_dept;

select stu_dept, min (stu_height)
from student 
group by stu_dept having min(stu_height) > 
     (select min(stu_height)
     from student
     where stu_dept = '컴퓨터정보');

select * 
from student 
where stu_no in
    (select stu_no 
    from enrol
    where sub_no = 101);
    
select * 
from student a, enrol b
where a.stu_no = b.stu_no and b.sub_no = 101;

--101번 과목을 수강한 학생들의 학번, 이름, 점수를 검색 (조인 한것과 같음)
select a.stu_no, a.stu_name, b.enr_grade 
from student a, enrol b
where a.stu_no = b.stu_no and b.sub_no = 101;
--(위와 같은 값 조인으로 만듦)
select student.stu_no, stu_name, enr_grade
from student, enrol
where student.stu_no = enrol.stu_no and sub_no = 101;

-- 실습을 위한 사원(emp) 테이블과 구조가 같은 test1테이블 생성
--creat table 집을 만들고 insert 공백에다가 값을 집어넣는다.
create table test1(empno, ename, sal, comm, deptno)
as
    select empno, ename, sal, comm, deptno
    from emp
    where deptno =1;
    
insert into test1 values(11, 'apple', 1000, null, 30);
insert into test1 values(12, 'banana', 2000, 100, 30);
insert into test1 values(13, 'cheese', 1000, 0, 10);
insert into test1 values(14, 'dog', 2000, null, 20);
insert into test1 values(15, 'egg', 1000, 100, 20);

select * from test1;

select* from test1 where (sal, nvl(comm, -1))=
(select sal, nvl(comm, -1)
from test1
where empno = 11);

select * from test1
where (sal,nvl(comm, -1)) 
in (select sal, nvl(comm, -1) from test1
where deptno = 30);

--기계 전자과 사람들만 뽑아서 복사
create table a_student
as select *
    from student
    where stu_dept in ('기계','전기전자');

select *from a_student;
--전기*, 컴퓨터* 과 사람들만 뽑아서 복사
create table b_student
as select*
    from student
    where stu_dept in ('전기전자','컴퓨터정보');

select *from b_student;

commit;

--집합 UNION
select * from a_student union select* from b_student;
--중복제거 없이 합친 것UNION ALL
select * from a_student union all select * from b_student;

--INTERSECT 교집합만
select*from a_student intersect select * from b_student;

-- MINUS 차집합 a_student - b_student 
select * from a_student 
minus select *from b_student;

--인사관리 예시
create table tmpa_emp(empno,ename,hirdate,sal,deptno)
as 
select empno, ename, hiredate, sal, deptno
from emp
where deptno in (10,20);

select*from tmpa_emp;

--예제
create table tmpb_emp(empno,ename,hirdate,sal,deptno)
as 
select empno, ename, hiredate, sal, deptno
from emp
where deptno in (20,30);

select * from tmpb_emp;

commit;

select * from tmpa_emp
union
select*from tmpb_emp;

select * from tmpa_emp
union all
select * from tmpb_emp;

select * from tmpa_emp
intersect
select * from tmpb_emp;

select * from tmpa_emp
minus
select * from tmpb_emp;

--4장 실습문제

--1. 학생 테이블과 수강 테이블의 모든 데이터를 검색하시오(natural join)
select *
from student natural join enrol;

--2. 학번, 이름, 과목명, 점수를 검색하시오(equi join)
select a.stu_no, a.stu_name, c.sub_name, b.enr_grade
from student a, enrol b, subject c
where a.stu_no = b.stu_no
and b.sub_no = c.sub_no;

--3. 과목명과 학번, 점수를 검색하시오(natural join)
select sub_name, stu_no, enr_grade
from subject natural join enrol;

--4. 과목명과 학번, 점수를 검색하시오(join ~using)
select sub_name, stu_no, enr_grade
from subject join enrol using(sub_no);

--5. 점수가 70점 이상인 학생 이름을 검색하시오(equi join)
select stu_name, enr_grade
from student a, enrol b
where a.stu_no = b.stu_no 
and enr_grade>=70;

--6. 점수가 60점 이상인 학생 이름을 검색하시오(join ~using)
select stu_name, enr_grade
from student join enrol 
using(stu_no)
where enr_grade>=60;

--7. 점수가 70점 이하인 학생의 이름을 검색하시오(natural join)
select stu_name, enr_grade
from student natural join enrol
where enr_grade<=70;

--8. 김인중 학생이 수강하는 과목명과 강의 교수를 검색하시오(equi join)
select sub_name, sub_prof 
from student a, enrol b, subject c
where a.stu_no = b.stu_no and b.sub_no = c.sub_no
and stu_name='김인중';

--9. 김인중 학생이 수강하는 과목명과 강의 교수를 검색하시오(natural join)
select sub_name, sub_prof 
from student natural join enrol
natural join subject
where stu_name='김인중';

--10. 김인중 학생이 수강하는 과목명과 강의 교수를 검색하시오(join ~using)
select sub_name, sub_prof
from student join enrol using(stu_no)
join subject using(sub_no)  
where stu_name='김인중';

--11. 강종영 교수가 강의하는 과목을 수강하는 학생의 이름을 검색하시오

--(1) equi join
select sub_prof, sub_name, stu_name
from student a, enrol b, subject c 
where a.stu_no = b.stu_no
and b.sub_no = c.sub_no
and sub_prof='강종영';

--(2) join ~using
select sub_prof, sub_name, stu_name
from student join enrol using(stu_no) 
join subject using(sub_no)
where sub_prof='강종영';

--(3) natural join 
select sub_prof, sub_name, stu_name
from student natural join enrol
enrol natural join subject 
where sub_prof='강종영';

--12. 컴퓨터개론을 수강하는 학생들의 학번과 이름을 검색하시오.
--(1) equi join
select a.stu_no, stu_name
from student a, enrol b, subject c 
where a.stu_no = b.stu_no
and b.sub_no = c.sub_no 
and sub_name='컴퓨터개론';
--(2) join ~ using
select stu_no, stu_name 
from student join enrol using(stu_no) join subject using(sub_no)
where sub_name='컴퓨터개론';
--(3) natural join
select stu_no, stu_name 
from student natural join subject 
natural join enrol
where sub_name='컴퓨터개론';

--13. 분석설계나 소프트웨어 공학을 수강하는 학생들의 학번, 이름, 점수를 성적순으로 검색하시오.

--(1) equi join 
-- and or 쓸때는 가로를 써야 한다. or 부터 처리한 후 and를 써야 한다.  
select a.stu_no, stu_name, enr_grade
from student a, enrol b, subject c 
where (a.stu_no = b.stu_no
and b.sub_no = c.sub_no 
and (sub_name='시스템분석설계' or sub_name='소프트웨어공학')) order by enr_grade desc;
--(2) join ~ using
select stu_no, stu_name, enr_grade
from student join enrol using(stu_no) 
join subject using(sub_no)
where sub_name='시스템분석설계' or sub_name='소프트웨어공학' 
order by 3 desc;
--(3) natural join
select stu_no, stu_name, enr_grade
from student natural join subject 
natural join enrol
where sub_name='시스템분석설계' or sub_name='소프트웨어공학' 
order by enr_grade desc;

--14. 과목이 1학년 과목이거나 컴퓨터정보 과에 개설된 과목일 경우 그 과목들을 수강하는 학생들의 학번과 이름을 검색하시오.(equi join)
select a.stu_no, stu_name
from student a, enrol b, subject c 
where a.stu_no = b.stu_no
and b.sub_no = c.sub_no 
and (sub_grade=1 or sub_dept='컴퓨터정보');


--'기초전과실험'이나 '기계공작법'을 수강하는 학생들의 학번, 이름, 점수를 성적순으로 검색하시오.
select stu_no, stu_name, enr_grade
from student natural join subject 
natural join enrol
where sub_name='기초전과실험' or sub_name='기계공작법' 
order by enr_grade desc;

--16. 김태영 교슈나 김유석 교수가 강의하는 과목을 수강하는 학생의 학번을 검색하시오.(join ~using)
select stu_no from
student join enrol using(stu_no) 
join subject using(sub_no)
where sub_prof = '김태영' or sub_prof = '김유석';

--17. 학생의 이름과 점수를 검색하시오

--이큐조인
select distinct a.stu_name, b.enr_grade
from student a, enrol b
where a.stu_no=b.stu_no;
-- 조인유징
select distinct stu_name, enr_grade
from student join enrol using(stu_no);

--네츄럴 조인
select distinct stu_name, enr_grade
from student natural join enrol;

--18. 이름이 '옥한빛'인 학생이 수강하는 과목명을 검색하시오(equi join)
select a.sub_name from subject a, student b, enrol c
where a.sub_no= c.sub_no 
and b.stu_no=c.stu_no and stu_name ='옥한빛';

--19.여학생이 수강중인 과목의 과목명을 모두 검색하시오.(natural join)
select distinct sub_name from student natural join enrol natural join subject
where stu_gender = 'F';

--20.체중이 60 이상인 학생이 수강하는 과목의 과목명을 모두 검색하시오(join ~ using)
select distinct sub_name from student join enrol using (stu_no) join subject using (sub_no)
where stu_weight>=60;

--21. 컴퓨터정보과에 개설된 과목을 수강하는 모든 학생의 학번과 이름을 검색하시오(natural join)
select distinct stu_no, stu_name from student natural join enrol natural join subject
where sub_dept = '컴퓨터정보';

--22. 여학생이면서 구봉규 교수의 과목을 수강하는 학생의 이름을 검색하시오(equi join)
select a.stu_name 
from student a, enrol b, subject c
where a.stu_no= b.stu_no and b.sub_no=c.sub_no 
and sub_prof ='구봉규' and stu_gender='F'; 

--23. 김종헌 학생의 평균 점수보다 높은 점수를 가진 학생의 학번과 이름을 검색하시오.(equi join)
select a.stu_no, stu_name
from student a, enrol b, subject c
where a.stu_no = b.stu_no and b.sub_no = c.sub_no
and enr_grade >=
    (select avg(enr_grade) from student a, enrol b, subject c
    where a.stu_no = b.stu_no and b.sub_no = c.sub_no 
    and stu_name ='김종헌')
and stu_name <> '김종헌';

select avg(enr_grade) from student a, enrol b, subject c
where a.stu_no = b.stu_no and b.sub_no = c.sub_no 
and stu_name ='김종헌';

--join using
select stu_no, stu_name 
from student join enrol using(stu_no) join subject using(sub_no)
where enr_grade>=
    (select avg(enr_grade) 
    from student join enrol using(stu_no) join subject using(sub_no)
    where stu_name = '김종헌')
and stu_name <>'김종헌';

select avg(enr_grade) from student join enrol using(stu_no) join subject using(sub_no)
where stu_name = '김종헌';

--natural join
select stu_no, stu_name 
from student natural join enrol natural join subject
where enr_grade>= 
    (select avg(enr_grade) 
    from student natural join enrol natural join subject
    where stu_name='김종헌')
and stu_name <> '김종헌';

-- 24. 김인중 학생의 편균점수 보다 낮은 점수를 가진 학생의 학번과 이름, 과목명을 검색하시오. 네츄럴 조인
select stu_no, stu_name, sub_name 
from student natural join enrol natural join subject
where enr_grade <=
    (select avg(enr_grade) 
    from student natural join enrol
    where stu_name = '김인중')
and stu_name <> '김인중';

-- 25. 전체 학생의 평균 점수보다 점수가 노ㅍ은 학생의 학번, 이름, 과목명, 점수를 검색하시오(join ~ using)
select distinct stu_no, stu_name, sub_name, enr_grade 
from student join enrol using (stu_no) join subject using (sub_no)
where enr_grade >= 
    (select avg(enr_grade) 
    from enrol) order by 4 desc;

--26. 기계과 최고 점수 학생보다 최고 점수가 높은 학과의 학과명과 점수를 검색하시오. 조인유징
select stu_dept, max(enr_grade) 
from student join enrol using (stu_no) join subject using (sub_no)
group by stu_dept having max(enr_grade)>
    (select max(enr_grade) from 
    student join enrol using (stu_no) join subject using (sub_no) 
    where sub_dept ='기계');
    
    
--27. 전기전자과의 최저 점수보다 최저 점수가 높은 학과의 학과명과 점수를 검색하시오 조인 유징
select stu_dept, min(enr_grade)  
from student join enrol using (stu_no) join subject using (sub_no)
group by stu_dept having min(enr_grade)>
    (select min(enr_grade) from 
    student join enrol using (stu_no) join subject using (sub_no) 
    where sub_dept ='전기전자');
    
--28. 과목별 수강 인원을 과목번호, 과목명과 함께 과목번호순으로 검색하시오.(natural join)
select sub_no, sub_name, count(*)
from student natural join enrol natural join subject
group by sub_no,sub_name
order by sub_no;