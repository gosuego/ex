
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
select stu_no as number, stu_name as name from student;
select stu_no "�й�", stu_name "�̸�" from student;

select stu_dept || stu_name as �а����� from student;
select ename || job as �������� from emp;
select stu_dept || ',' || stu_name || '�Դϴ�.' as �а����� from student;

select ename as �̸�, sal as ����, sal*12 as ���� from emp;

select ename || '''s job is ' || job "NAME AND JOB" from emp;

select stu_name, stu_dept, stu_grade, stu_class from student where stu_dept='��ǻ������';
-- emp �ʵ忡�� ����(job)�� 'SALESMAN'�� ����� ename, job, sal, deptno�� �˻�
select ename, job, sal, deptno from emp where job='SALESMAN';
select stu_name, stu_dept, stu_grade, stu_class from student where stu_dept = '��ǻ������' and stu_grade=2;

select * from student where stu_weight between 60 and 70;
-- emp ���̺����� �޿�(sal)�� 1000���� 1500 ������ �����͸� �˻�
select * from emp where sal between 1000 and 1500;
select * from emp where sal >= 1000 and sal <= 1500;
select * from student where STU_NO between '20140001' and '20149999';

-- emp ���̺����� �μ���ȣ(DEPTNO)�� 10�̰� ����(JOB)�� 'MANAGER'�� �����͸� �˻�
select * from emp where DEPTNO=10 and JOB='MANAGER';

-- like
select stu_no, stu_name, stu_dept from student where stu_name like '��%';
-- emp ���̺����� ����̸�(ename)�� J�ڷ� �����ϴ� ����� ����(empno, ename, job)�� �˻�
select empno, ename, job from emp where ename like 'J%';
select stu_no, stu_name, stu_dept from student where stu_name like '_��%';
select * from student where stu_no like '2014%';
-- emp ���̺����� ����̸�(ename)�� �� ��° ���ڰ� 'L'�� ����� empno, ename, job�� �˻�
select empno, ename, job from emp where ename like '_L%';

-- emp ���̺����� �μ���ȣ(DEPTNO)�� 10�� �μ��� �ƴ� ������� �˻�
select * from emp where not DEPTNO=10;
select * from emp where deptno <> 10;

-- emp ���̺����� �޿�(sal)�� 900 �̸��̰ų� 4000�ʰ��� ����� �˻�
select * from emp where sal < 900 or sal > 4000;
-- student ���̺����� Ű�� 170 �̻��̰� �����԰� 80KG �̻��� ������ �˻�
select * from student where stu_height >=170 and stu_weight >=80;

-- null�� ó��
select stu_no, stu_name, stu_height from student;
select stu_name, stu_height/30.46 from student;
select stu_no, stu_name, stu_height from student where stu_height is null;
select stu_no, stu_name, stu_height from student where stu_height is not null;
-- emp ���̺����� comm�� null�� ����� empno, ename, comm�� �˻�
select empno, ename, comm from emp where comm is null;

-- in ������
select stu_no, stu_name from student where stu_dept in ('��ǻ������','���');
select stu_no, stu_name from student where stu_dept = '��ǻ������' or stu_dept = '���';
-- emp ���̺����� �μ���ȣ�� 10,30�� �μ��� �ٹ��ϴ� ����� ��ȣ(empno)�� �μ���ȣ(deptno)�� �˻�
select empno, deptno from emp where DEPTNO in (10,30);

-- ����
select stu_no, stu_name from student order by stu_no;
select stu_no, stu_name from student order by stu_no desc;
select * from emp order by HIREDATE desc;

select stu_no, stu_name, stu_dept, stu_weight-5 as target from student order by target;
select stu_no, stu_name, stu_dept, stu_weight-5 as target from student order by 4;
select stu_no, stu_name, stu_dept, stu_weight-5 as target from student order by stu_weight-5;

-- emp ���̺����� ������ �������� ������������ ����
select empno, ename, deptno, sal*12 as annualsal from emp order by annualsal;
select empno, ename, deptno, sal*12 as annualsal from emp order by 4;
select empno, ename, deptno, sal*12 as annualsal from emp order by sal*12;

select stu_no, stu_name, stu_dept, stu_weight-5 as target from student order by stu_dept, target;
select stu_no, stu_name, stu_dept, stu_weight-5 as target from student order by stu_dept, stu_weight-5 desc;
select empno, ename, deptno, sal*12 as annualsal from emp order by deptno, annualsal;
select empno, ename, deptno, sal*12 as annualsal from emp order by deptno, annualsal desc;

select empno, ename, deptno, sal*12 as annualsal from emp order by hiredate;

-- �Լ�
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

--��¥�Լ�
select sysdate from dual;
select next_day(sysdate,'��') from dual;
select next_day(sysdate,7) from dual;

-- �� ����
select months_between('14/09/30','14/08/30') from dual;
select months_between('14/10/30','14/08/30') from dual;
select months_between('14/08/31','14/09/30') from dual;

-- �� ���ϱ�
select sysdate,add_months(sysdate,1) from dual;

-- ������ �� ���
select sysdate,last_day(sysdate) from dual;

-- round���� �Ϸ��� ���� �ѱ�� ���� ��¥�� ���, trunc�� ������ ���Ϸ� ǥ��
select sysdate,round(sysdate),trunc(sysdate) from dual;
select round(sysdate,'MON') from dual;

select 2+to_number('2') from dual;

--TO_CHAR : TO_CHAR �Լ��� �ַ� ��¿� ������ �����ϱ� ���� ���Ǹ�, ��¥��, ������ ��� �����Ϳ� ����Ѵ�. 
select empno, ename, to_char(hiredate,'yyyy-mm')as �Ի��� from emp;          
select sysdate, to_char(sysdate,'yyyy'),to_char(sysdate,'yy') from dual;
select sysdate, to_char(sysdate,'mm'),to_char(sysdate,'month') from dual;
select sysdate, to_char(sysdate,'dd'),to_char(sysdate,'day') from dual;
select sysdate, to_char(sysdate,'YYYY-MM-DD:HH24:MI:SS'),to_char(sysdate,'month') from dual;

--����(���ڸ� ���ڷ� ǥ��)
select to_char(1234,'99999'), to_char(1234,'099999'), 
to_char(1234,'$9999'), to_char(1234,'9999.99'), to_char(12345,'99,999') from dual;

--TO_NUMBER �Լ� TO_NUMBER �Լ��� ���� ������ ���ڸ� ���ڷ� ��ȯ�� �� ����Ѵ�.
select to_char(to_number(1234.5678), '9999.999') from dual;
select to_char(to_number(1234.5678),'999.999') from dual;

--TO_DATE �Լ� : TO_DATE �Լ��� ��¥ ������ ���ڸ� ��¥�� ��ȯ�� �� ����Ѵ�.
SELECT EMPNO, ENAME from emp where hiredate = to_date('1980-12-17','yy-mm-dd');

--NVL �Լ� : �μ� 1�� null�̸� �μ� 2�� �ƴϸ� �μ��� ��ȯ��
select * from student;
select nvl(stu_height, 0) from student; --null���� 0���� �ٲ�
select ename,comm,nvl(comm,0),nvl(comm,100) from emp where deptno = 30;
select ename, comm from emp where deptno = 30;
select*from emp;

--NVL2�Լ� : �μ� 1�� null�� �ƴϸ� �μ� 2. null�̸� �μ� 3�� ��ȯ��
select ename,sal,comm,nvl2(comm,sal+comm,sal) from emp;
select ename,sal,comm from emp;

--nullif �Լ� �μ� 1�� �μ� 2�� ���� ���Ͽ� �� ���� ������ null�� �ƴϸ� �μ� 1�� ���� ��ȯ��
select nvl(nullif('A','A'), '�� ��')from dual; 

--coalesce �Լ� �μ��� 1�� ���� ��
select coalesce(null, null, 10, 100, null) from dual;

select coalesce('A','B','C'),cocalesce(null,'B','C'), coalesce(null,null,'C'),coalesce(null,null,null) from dual;

--case
select empno, ename, sal, 
case job when 'SALESMAN' then sal*1.1 
    when 'CLERK' then sal*1.15 
    when 'MANAGER' then sal*1.2 
    else sal
end as �޿��λ�
from emp;

--����
select empno, ename, sal,
case when sal between 1 and 1000 then 'Level 1'
    when sal between 1001 and 2000 then 'Level 2'
    when sal between 2001 and 2000 then 'Level 3'
    when sal between 3001 and 2000 then 'Level 4'
    when sal > 4001 then 'Level 5'
end "Level"
from emp
order by sal desc;

--DECODE �Լ�
select empno, ename, job, sal, decode(job, 'SALESMAN',sal*1.1,
'CLEGK', sal*1.15,
'MANAGER',sal*1.2,
sal)as �λ�ȱ޿�
from emp;

--MAX�� MIN�Լ�
select max(enr_grade), min(enr_grade) from enrol;
select min(stu_weight), max(stu_weight) from student where stu_dept ='���';

--count �Լ�
SELECT*FROM STUDENT;
select count(*),count(stu_height) from student;  --null �� ���� �� ����
select count(stu_dept), count(distinct stu_dept) from student;  --�ߺ�����

--sum�� avg�Լ�
select sum(stu_weight), to_char(avg(stu_weight), '9999.00') from student where stu_dept = '��ǻ������';
select count(*)as �л�, sum(stu_height)as ������, 
count(stu_height) "�ش��л���", avg(stu_height) "��ս���" 
from student;

--emp ���̺� �����ռ�(�׷��Լ�)
select*from emp;
select count(*) from emp;
select sum(sal) from emp;
select to_char(avg(sal),'99999.99') from emp;
select min(sal) from emp;
select max(sal) from emp;

---emp���̺����� job�� ������ �˻��Ͻÿ�.(�� �ߺ�����)
select count(distinct job)as "������"from emp;

--������ �������� 100�� ������ ��¥
select sysdate-100 from dual;
--������ �������� 100�� ������ ��¥
select sysdate+100 from dual;

--���� ū ��
select greatest(10,30,50,80) from dual;
--���� ���� ��
select least(10,30,50,80)from dual;

--rownum : ���ڵ��� ����
select rownum, empno,ename from emp;
select * from emp;
--�޴����� ������ �հ� �� ���
select sum(sal), to_char(avg(sal),'9999,99')
from emp
where job = 'MANAGER';

--GROUP BY��
select stu_dept, count(*) from student
where stu_weight >= 50
group by stu_dept;
select*from student;

select*from emp;
select deptno, sum(sal) from emp 
group by deptno;
--���߿� Gorup by��
select stu_dept, stu_grade, count(*) from student group by stu_dept, stu_grade;;

--having�� ���
select stu_grade, avg(stu_height) from student where stu_dept ='���' 
group by stu_grade having avg(stu_height)>=160;
select stu_dept, max(stu_height) from student group by stu_dept having max(stu_height)>=175;
select to_char(max(avg(stu_height)),'999.99')
from student 
group by stu_dept;
--emp ���̺����� �޿��� 2000�̻� ������� �μ��� ������� ����Ͻÿ�.
select deptno,count(*) from emp where sal >=2000 group by deptno;

select deptno,sum(sal) from emp where job <> 'SALESMAN' group by deptno having sum(sal) >= 6500;
--emp ���̺����� ������ ��������� �ƴ� ����� ���� �޿��� 4000 �̻��� �μ��� ��ȣ�� �޿��� ���� ����Ͻÿ�.
select deptno,sum(sal) from emp where job <> 'SALESMAN' group by deptno having max(sal) >= 4000;

--1. emp ���̺��� ������ �˻��Ͻÿ�.
desc emp;
--2.�μ��� �μ��ڵ�(deptno)��  �μ���(ename)�� �˻��Ͻÿ�.
select deptno, dname from dept;
--3.�μ��� �μ����� ����(loc)�� �˻��Ͻÿ�.
select dname, loc from dept;
--4. ������� �޿��� Ŀ�̼��� �˻��Ͻÿ�.
select sal, comm from emp;
--5. ������� �Ի������� �ߺ��� �����ϰ� �˻��Ͻÿ�.
select distinct hiredate from emp;