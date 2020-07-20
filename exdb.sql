 
describe enrol;
describe subject;
describe salgrade;
describe emp;
describe dept;

select * from student;
select stu_no,stu_name from student;
select stu_dept from student;

select distinct stu_dept from student;
select distinct stu_grade, stu_class from student;

select stu_no, sub_no, enr_grade, enr_grade+10 from enrol;

select stu_no as ID, stu_name as name from student;
select stu_no as 학번, stu_name as 이름 from student;
select stu_no "학번", stu_name "이름" from student;

select stu_dept || stu_name as 학과성명 from student;
select ename || job as 성명직무 from emp;
select stu_dept || ',' || stu_name || '입니다.' as 학과성명 from student;

select ename as 이름, sal as 월급, sal*12 as 연봉 from emp;

select ename || '''s job is ' || job "NAME AND JOB" from emp;

select stu_name, stu_dept, stu_grade, stu_class from student where stu_dept='컴퓨터정보';
-- emp 필드에서 직무(job)가 'SALESMAN'인 사원의 ename, job, sal, deptno를 검색
select ename, job, sal, deptno from emp where job='SALESMAN';
select stu_name, stu_dept, stu_grade, stu_class from student where stu_dept = '컴퓨터정보' and stu_grade=2;

select * from student where stu_weight between 60 and 70;
-- emp 테이블에서 급여(sal)가 1000부터 1500 사이의 데이터를 검색
select * from emp where sal between 1000 and 1500;
select * from emp where sal >= 1000 and sal <= 1500;
select * from student where STU_NO between '20140001' and '20149999';

-- emp 테이블에서 부서번호(DEPTNO)가 10이고 직무(JOB)가 'MANAGER'인 데이터를 검색
select * from emp where DEPTNO=10 and JOB='MANAGER';

-- like
select stu_no, stu_name, stu_dept from student where stu_name like '김%';
-- emp 테이블에서 사원이름(ename)중 J자로 시작하는 사원의 정보(empno, ename, job)를 검색
select empno, ename, job from emp where ename like 'J%';
select stu_no, stu_name, stu_dept from student where stu_name like '_수%';
select * from student where stu_no like '2014%';
-- emp 테이블에서 사원이름(ename)의 두 번째 문자가 'L'인 사원의 empno, ename, job를 검색
select empno, ename, job from emp where ename like '_L%';

-- emp 테이블에서 부서번호(DEPTNO)가 10번 부서가 아닌 사원들을 검색
select * from emp where not DEPTNO=10;
select * from emp where deptno <> 10;

-- emp 테이블에서 급여(sal)가 900 미만이거나 4000초과인 사원을 검색
select * from emp where sal < 900 or sal > 4000;
-- student 테이블에서 키가 170 이상이고 몸무게가 80KG 이상인 데이터 검색
select * from student where stu_height >=170 and stu_weight >=80;

-- null값 처리
select stu_no, stu_name, stu_height from student;
select stu_name, stu_height/30.46 from student;
select stu_no, stu_name, stu_height from student where stu_height is null;
select stu_no, stu_name, stu_height from student where stu_height is not null;
-- emp 테이블에서 comm이 null인 사원의 empno, ename, comm을 검색
select empno, ename, comm from emp where comm is null;

-- in 연산자
select stu_no, stu_name from student where stu_dept in ('컴퓨터정보','기계');
select stu_no, stu_name from student where stu_dept = '컴퓨터정보' or stu_dept = '기계';
-- emp 테이블에서 부서번호가 10,30인 부서에 근무하는 사원의 번호(empno)와 부서번호(deptno)를 검색
select empno, deptno from emp where DEPTNO in (10,30);

-- 정렬
select stu_no, stu_name from student order by stu_no;
select stu_no, stu_name from student order by stu_no desc;
select * from emp order by HIREDATE desc;

select stu_no, stu_name, stu_dept, stu_weight-5 as target from student order by target;
select stu_no, stu_name, stu_dept, stu_weight-5 as target from student order by 4;
select stu_no, stu_name, stu_dept, stu_weight-5 as target from student order by stu_weight-5;

-- emp 테이블에서 연봉을 기준으로 오름차순으로 정렬
select empno, ename, deptno, sal*12 as annualsal from emp order by annualsal;
select empno, ename, deptno, sal*12 as annualsal from emp order by 4;
select empno, ename, deptno, sal*12 as annualsal from emp order by sal*12;

select stu_no, stu_name, stu_dept, stu_weight-5 as target from student order by stu_dept, target;
select stu_no, stu_name, stu_dept, stu_weight-5 as target from student order by stu_dept, stu_weight-5 desc;
select empno, ename, deptno, sal*12 as annualsal from emp order by deptno, annualsal;
select empno, ename, deptno, sal*12 as annualsal from emp order by deptno, annualsal desc;

select empno, ename, deptno, sal*12 as annualsal from emp order by hiredate;

-- 함수
select round(345.678), round(345.678,0), round(345.678,1), round(345.678,-1) from dual;
select trunc(997.654,2) "trunc1", trunc(997.654,0) "trunc2", trunc(997.654,-1) "trunc3" from dual;
select mod(10,3), abs(-100), floor(123.456), power(2,3) from dual;

select upper('korea') from dual;
select lower('KOREA') from dual;
select ename,initcap(ename) "initcap" from emp;
select ename,length(ename) from emp;
select stu_name, length(stu_name) from student;
select concat(ename,job) from emp where deptno=10;
select substr('abcde',3,2), substr('abcde',-4,2) from dual;
select ename,lpad(ename,10,'*') from emp;
select ename,rpad(ename,10,'*') from emp;

select ltrim('   abc   ') from dual;
select rtrim('   abc   ') from dual;
select trim('   abc   ') from dual;
select ltrim('   abc   '),rtrim('   abc   '),trim('   abc   ') from dual;
select ename,ltrim(ename,'C') from emp where deptno=10;
select ename,rtrim(ename,'R') from emp where deptno=10;

select ename, replace(ename, substr(ename,1,2),'**') "replace" from emp where deptno=10;

--날짜함수
select sysdate from dual;
select next_day(sysdate,'토') from dual;
select next_day(sysdate,7) from dual;

-- 월 차이
select months_between('14/09/30','14/08/30') from dual;
select months_between('14/10/30','14/08/30') from dual;
select months_between('14/08/31','14/09/30') from dual;

-- 월 더하기
select sysdate,add_months(sysdate,1) from dual;

-- 마지막 날 출력
select sysdate,last_day(sysdate) from dual;

-- round에서 하루의 반을 넘기면 다음 날짜로 출력, trunc는 무조건 당일로 표시
select sysdate,round(sysdate),trunc(sysdate) from dual;
select round(sysdate,'MON') from dual;

select 2+to_number('2') from dual;

--TO_CHAR : TO_CHAR 함수는 주로 출력에 형식을 지정하기 위해 사용되며, 날짜형, 숫자형 모든 데이터에 사용한다. 
select empno, ename, to_char(hiredate,'yyyy-mm')as 입사년월 from emp;          
select sysdate, to_char(sysdate,'yyyy'),to_char(sysdate,'yy') from dual;
select sysdate, to_char(sysdate,'mm'),to_char(sysdate,'month') from dual;
select sysdate, to_char(sysdate,'dd'),to_char(sysdate,'day') from dual;
select sysdate, to_char(sysdate,'YYYY-MM-DD:HH24:MI:SS'),to_char(sysdate,'month') from dual;

--예시(숫자를 문자로 표현)
select to_char(1234,'99999'), to_char(1234,'099999'), 
to_char(1234,'$9999'), to_char(1234,'9999.99'), to_char(12345,'99,999') from dual;

--TO_NUMBER 함수 TO_NUMBER 함수는 숫자 형태의 문자를 숫자로 변환할 때 사용한다.
select to_char(to_number(1234.5678), '9999.999') from dual;
select to_char(to_number(1234.5678),'999.999') from dual;

--TO_DATE 함수 : TO_DATE 함수는 날짜 형태의 문자를 날짜로 변환할 때 사용한다.
SELECT EMPNO, ENAME from emp where hiredate = to_date('1980-12-17','yy-mm-dd');

--NVL 함수 : 인수 1이 null이면 인수 2를 아니면 인수를 반환함
select * from student;
select nvl(stu_height, 0) from student; --null값을 0으로 바꿈
select ename,comm,nvl(comm,0),nvl(comm,100) from emp where deptno = 30;
select ename, comm from emp where deptno = 30;
select*from emp;

--NVL2함수 : 인수 1이 null이 아니면 인수 2. null이면 인수 3을 반환함
select ename,sal,comm,nvl2(comm,sal+comm,sal) from emp;
select ename,sal,comm from emp;

--nullif 함수 인수 1과 인수 2의 값을 비교하여 그 값이 같으면 null을 아니면 인수 1의 값을 변환함
select nvl(nullif('A','A'), '널 값')from dual; 

--coalesce 함수 인수의 1의 값이 널
select coalesce(null, null, 10, 100, null) from dual;

select coalesce('A','B','C'),cocalesce(null,'B','C'), coalesce(null,null,'C'),coalesce(null,null,null) from dual;

--case
select empno, ename, sal, 
case job when 'SALESMAN' then sal*1.1 
    when 'CLERK' then sal*1.15 
    when 'MANAGER' then sal*1.2 
    else sal
end as 급여인상
from emp;

--예시
select empno, ename, sal,
case when sal between 1 and 1000 then 'Level 1'
    when sal between 1001 and 2000 then 'Level 2'
    when sal between 2001 and 2000 then 'Level 3'
    when sal between 3001 and 2000 then 'Level 4'
    when sal > 4001 then 'Level 5'
end "Level"
from emp
order by sal desc;

--DECODE 함수
select empno, ename, job, sal, decode(job, 'SALESMAN',sal*1.1,
'CLEGK', sal*1.15,
'MANAGER',sal*1.2,
sal)as 인상된급여
from emp;

--MAX와 MIN함수
select max(enr_grade), min(enr_grade) from enrol;
select min(stu_weight), max(stu_weight) from student where stu_dept ='기계';

--count 함수
SELECT*FROM STUDENT;
select count(*),count(stu_height) from student;  --null 값 제외 수 세기
select count(stu_dept), count(distinct stu_dept) from student;  --중복제거

--sum과 avg함수
select sum(stu_weight), to_char(avg(stu_weight), '9999.00') from student where stu_dept = '컴퓨터정보';
select count(*)as 학생, sum(stu_height)as 신장합, 
count(stu_height) "해당학생수", avg(stu_height) "평균신장" 
from student;

--emp 테이블 집계합수(그룹함수)
select*from emp;
select count(*) from emp;
select sum(sal) from emp;
select to_char(avg(sal),'99999.99') from emp;
select min(sal) from emp;
select max(sal) from emp;

---emp테이블에서 job의 개수를 검색하시오.(단 중복제거)
select count(distinct job)as "업무수"from emp;

--오늘을 기준으로 100일 이전의 날짜
select sysdate-100 from dual;
--오늘을 기준으로 100일 이후의 날짜
select sysdate+100 from dual;

--가장 큰 값
select greatest(10,30,50,80) from dual;
--가장 작은 값
select least(10,30,50,80)from dual;

--rownum : 레코드의 순번
select rownum, empno,ename from emp;
select * from emp;
--메니저의 연봉의 합과 그 평균
select sum(sal), to_char(avg(sal),'9999,99')
from emp
where job = 'MANAGER';

--GROUP BY절
select stu_dept, count(*) from student
where stu_weight >= 50
group by stu_dept;
select*from student;

select*from emp;
select deptno, sum(sal) from emp 
group by deptno;
--다중열 Gorup by절
select stu_dept, stu_grade, count(*) from student group by stu_dept, stu_grade;;

--having절 사용
select stu_grade, avg(stu_height) from student where stu_dept ='기계' 
group by stu_grade having avg(stu_height)>=160;
select stu_dept, max(stu_height) from student group by stu_dept having max(stu_height)>=175;
select to_char(max(avg(stu_height)),'999.99')
from student 
group by stu_dept;
--emp 테이블에서 급여가 2000이상 사원들의 부서별 사원수를 출력하시오.
select deptno,count(*) from emp where sal >=2000 group by deptno;

select deptno,sum(sal) from emp where job <> 'SALESMAN' group by deptno having sum(sal) >= 6500;
--emp 테이블에서 직무가 세일즈맨이 아닌 사원에 대한 급여가 4000 이상인 부서의 번호와 급여의 합을 출력하시오.
select deptno,sum(sal) from emp where job <> 'SALESMAN' group by deptno having max(sal) >= 4000;

--1. emp 테이블의 구조를 검색하시오.
desc emp;
--2.부서의 부서코드(deptno)와  부서명(ename)을 검색하시오.
select deptno, dname from dept;
--3.부서의 부서명과 지역(loc)을 검색하시오.
select dname, loc from dept;
--4. 사원들의 급여와 커미션을 검색하시오.
select sal, comm from emp;
--5. 사원들의 입사일자의 중복을 제거하고 검색하시오.
select distinct hiredate from emp;