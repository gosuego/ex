
--4�� ����

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

--natual ����
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
    
--emp ���̺��� �μ������� 'CHICAGO'�� ������� �̸��� �˻��Ͻÿ�.
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

--non-equi����
--where������ ����ϴ� '='�� �ƴ� �����ڸ� ���

select empno, ename, sal, grade
from emp, salgrade
where sal between losal and hisal;

select a.empno as �����ȣ, a.ename as ����̸�, 
b.empno as ����ڻ����ȣ, b.ename as ������̸� 
from emp a, emp b
where a.mgr = b.empno;

--SELF ����
--���� ���̺� ���� ����, ���̺��� ��Ī�� �����
select a.empno as �����ȣ, a.ename as ����̸�, 
b.empno as ����ڻ����ȣ, b.ename as ������̸� 
from emp a join emp b
on a.mgr = b.empno;

--Outer ����
--outer join�� ���� ������ �������� �ʴ� ��鵵 ���� ����� ������

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

--self ����
select a.empno as �����ȣ, a.ename as ����̸�,
b.empno as ����ڻ����ȣ,b.ename as ������̸�
from emp a left outer join emp b
on a.mgr = b.empno;

select a.empno as �����ȣ, a.ename as ����̸�,
b.empno as ����ڻ����ȣ, b.ename as ������̸�
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

--������ �ϳ��� �������� ó����(�� �� �� �����.)

select stu_height from student where stu_name = '������';
select stu_height from student where stu_height > 172;
--(�������� ���ǰ�(172))�� �׺��� ū�̶�� ������ ���յ�.
select stu_no, stu_name, stu_height from student 
where stu_height > (select stu_height from student where stu_name = '������');

--����ũ(2875)���� ū ���� �޴� ���� �������� �����ȣ ����̸� ������� ������ ������������
select empno,ename,sal from emp 
where sal > (select sal from emp where ename ='BLAKE') 
order by sal;

--self ������ �̿��Ͽ� ���ۼ���
select a.stu_no, a.stu_name, a.stu_height from student a, student b
where a.stu_height > b.stu_height
and b.stu_name = '������';

--����ũ���� ū ������ �޴� ���� �������� �����ȣ ����̸� ������� ������ ������������ self join �϶�.
select a.empno, a.ename, a.sal 
from emp a, emp b 
where a.sal>b.sal and b.ename='BLAKE' order by sal desc;

--�ܿ��� ������
--emp���̺��� 'FORD' ����� ���� �޿��� �ް� �ִ� ������� ������ �˻��Ͻÿ�.(��, 'FORD'�� ����)
select * from emp where sal = 
    (select sal 
    from emp 
    where ename ='FORD')
    and ename <> 'FORD';

    
 --���� �� �ߺ� ����.   
select * from student where stu_weight = 
    (select stu_weight 
    from student 
    where stu_name = '����ö') 
    and stu_name <> '����ö';

-- in�� �Ǵ�
--'��ǻ������' �� �л��� ���� ���� ���� �л��� ���� �˻� �׸��� �ߺ��� �����϶�.
select * from student 
where stu_class in 
(select distinct stu_class 
from student where stu_dept ='��ǻ������')
and stu_dept <> '��ǻ������';

--����
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
    
    
    --����  any�� ���� ���� ��
    select avg(sal) from emp where deptno=30;
    
select * from emp 
where sal> (select avg(sal) from emp where deptno=30);

select * from emp
where sal > any 
    (select avg(sal) 
    from emp 
    group by deptno);
--any�� min����
select * from emp where sal>
    (select min(avg(sal))
    from emp
    group by deptno);

--all�� ���� ū��
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
        where stu_dept ='��ǻ������');
        
select * from student 
    where stu_height > all 
    (select avg(stu_height) 
    from student
    where stu_dept ='��ǻ������');    
    
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
     where stu_dept = '��ǻ������');

select * 
from student 
where stu_no in
    (select stu_no 
    from enrol
    where sub_no = 101);
    
select * 
from student a, enrol b
where a.stu_no = b.stu_no and b.sub_no = 101;

--101�� ������ ������ �л����� �й�, �̸�, ������ �˻� (���� �ѰͰ� ����)
select a.stu_no, a.stu_name, b.enr_grade 
from student a, enrol b
where a.stu_no = b.stu_no and b.sub_no = 101;
--(���� ���� �� �������� ����)
select student.stu_no, stu_name, enr_grade
from student, enrol
where student.stu_no = enrol.stu_no and sub_no = 101;

-- �ǽ��� ���� ���(emp) ���̺�� ������ ���� test1���̺� ����
--creat table ���� ����� insert ���鿡�ٰ� ���� ����ִ´�.
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

--��� ���ڰ� ����鸸 �̾Ƽ� ����
create table a_student
as select *
    from student
    where stu_dept in ('���','��������');

select *from a_student;
--����*, ��ǻ��* �� ����鸸 �̾Ƽ� ����
create table b_student
as select*
    from student
    where stu_dept in ('��������','��ǻ������');

select *from b_student;

commit;

--���� UNION
select * from a_student union select* from b_student;
--�ߺ����� ���� ��ģ ��UNION ALL
select * from a_student union all select * from b_student;

--INTERSECT �����ո�
select*from a_student intersect select * from b_student;

-- MINUS ������ a_student - b_student 
select * from a_student 
minus select *from b_student;

--�λ���� ����
create table tmpa_emp(empno,ename,hirdate,sal,deptno)
as 
select empno, ename, hiredate, sal, deptno
from emp
where deptno in (10,20);

select*from tmpa_emp;

--����
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

--4�� �ǽ�����

--1. �л� ���̺�� ���� ���̺��� ��� �����͸� �˻��Ͻÿ�(natural join)
select *
from student natural join enrol;

--2. �й�, �̸�, �����, ������ �˻��Ͻÿ�(equi join)
select a.stu_no, a.stu_name, c.sub_name, b.enr_grade
from student a, enrol b, subject c
where a.stu_no = b.stu_no
and b.sub_no = c.sub_no;

--3. ������ �й�, ������ �˻��Ͻÿ�(natural join)
select sub_name, stu_no, enr_grade
from subject natural join enrol;

--4. ������ �й�, ������ �˻��Ͻÿ�(join ~using)
select sub_name, stu_no, enr_grade
from subject join enrol using(sub_no);

--5. ������ 70�� �̻��� �л� �̸��� �˻��Ͻÿ�(equi join)
select stu_name, enr_grade
from student a, enrol b
where a.stu_no = b.stu_no 
and enr_grade>=70;

--6. ������ 60�� �̻��� �л� �̸��� �˻��Ͻÿ�(join ~using)
select stu_name, enr_grade
from student join enrol 
using(stu_no)
where enr_grade>=60;

--7. ������ 70�� ������ �л��� �̸��� �˻��Ͻÿ�(natural join)
select stu_name, enr_grade
from student natural join enrol
where enr_grade<=70;

--8. ������ �л��� �����ϴ� ������ ���� ������ �˻��Ͻÿ�(equi join)
select sub_name, sub_prof 
from student a, enrol b, subject c
where a.stu_no = b.stu_no and b.sub_no = c.sub_no
and stu_name='������';

--9. ������ �л��� �����ϴ� ������ ���� ������ �˻��Ͻÿ�(natural join)
select sub_name, sub_prof 
from student natural join enrol
natural join subject
where stu_name='������';

--10. ������ �л��� �����ϴ� ������ ���� ������ �˻��Ͻÿ�(join ~using)
select sub_name, sub_prof
from student join enrol using(stu_no)
join subject using(sub_no)  
where stu_name='������';

--11. ������ ������ �����ϴ� ������ �����ϴ� �л��� �̸��� �˻��Ͻÿ�

--(1) equi join
select sub_prof, sub_name, stu_name
from student a, enrol b, subject c 
where a.stu_no = b.stu_no
and b.sub_no = c.sub_no
and sub_prof='������';

--(2) join ~using
select sub_prof, sub_name, stu_name
from student join enrol using(stu_no) 
join subject using(sub_no)
where sub_prof='������';

--(3) natural join 
select sub_prof, sub_name, stu_name
from student natural join enrol
enrol natural join subject 
where sub_prof='������';

--12. ��ǻ�Ͱ����� �����ϴ� �л����� �й��� �̸��� �˻��Ͻÿ�.
--(1) equi join
select a.stu_no, stu_name
from student a, enrol b, subject c 
where a.stu_no = b.stu_no
and b.sub_no = c.sub_no 
and sub_name='��ǻ�Ͱ���';
--(2) join ~ using
select stu_no, stu_name 
from student join enrol using(stu_no) join subject using(sub_no)
where sub_name='��ǻ�Ͱ���';
--(3) natural join
select stu_no, stu_name 
from student natural join subject 
natural join enrol
where sub_name='��ǻ�Ͱ���';

--13. �м����質 ����Ʈ���� ������ �����ϴ� �л����� �й�, �̸�, ������ ���������� �˻��Ͻÿ�.

--(1) equi join 
-- and or ������ ���θ� ��� �Ѵ�. or ���� ó���� �� and�� ��� �Ѵ�.  
select a.stu_no, stu_name, enr_grade
from student a, enrol b, subject c 
where (a.stu_no = b.stu_no
and b.sub_no = c.sub_no 
and (sub_name='�ý��ۺм�����' or sub_name='����Ʈ�������')) order by enr_grade desc;
--(2) join ~ using
select stu_no, stu_name, enr_grade
from student join enrol using(stu_no) 
join subject using(sub_no)
where sub_name='�ý��ۺм�����' or sub_name='����Ʈ�������' 
order by 3 desc;
--(3) natural join
select stu_no, stu_name, enr_grade
from student natural join subject 
natural join enrol
where sub_name='�ý��ۺм�����' or sub_name='����Ʈ�������' 
order by enr_grade desc;

--14. ������ 1�г� �����̰ų� ��ǻ������ ���� ������ ������ ��� �� ������� �����ϴ� �л����� �й��� �̸��� �˻��Ͻÿ�.(equi join)
select a.stu_no, stu_name
from student a, enrol b, subject c 
where a.stu_no = b.stu_no
and b.sub_no = c.sub_no 
and (sub_grade=1 or sub_dept='��ǻ������');


--'������������'�̳� '�����۹�'�� �����ϴ� �л����� �й�, �̸�, ������ ���������� �˻��Ͻÿ�.
select stu_no, stu_name, enr_grade
from student natural join subject 
natural join enrol
where sub_name='������������' or sub_name='�����۹�' 
order by enr_grade desc;

--16. ���¿� ������ ������ ������ �����ϴ� ������ �����ϴ� �л��� �й��� �˻��Ͻÿ�.(join ~using)
select stu_no from
student join enrol using(stu_no) 
join subject using(sub_no)
where sub_prof = '���¿�' or sub_prof = '������';

--17. �л��� �̸��� ������ �˻��Ͻÿ�

--��ť����
select distinct a.stu_name, b.enr_grade
from student a, enrol b
where a.stu_no=b.stu_no;
-- ������¡
select distinct stu_name, enr_grade
from student join enrol using(stu_no);

--���� ����
select distinct stu_name, enr_grade
from student natural join enrol;

--18. �̸��� '���Ѻ�'�� �л��� �����ϴ� ������� �˻��Ͻÿ�(equi join)
select a.sub_name from subject a, student b, enrol c
where a.sub_no= c.sub_no 
and b.stu_no=c.stu_no and stu_name ='���Ѻ�';

--19.���л��� �������� ������ ������� ��� �˻��Ͻÿ�.(natural join)
select distinct sub_name from student natural join enrol natural join subject
where stu_gender = 'F';

--20.ü���� 60 �̻��� �л��� �����ϴ� ������ ������� ��� �˻��Ͻÿ�(join ~ using)
select distinct sub_name from student join enrol using (stu_no) join subject using (sub_no)
where stu_weight>=60;

--21. ��ǻ���������� ������ ������ �����ϴ� ��� �л��� �й��� �̸��� �˻��Ͻÿ�(natural join)
select distinct stu_no, stu_name from student natural join enrol natural join subject
where sub_dept = '��ǻ������';

--22. ���л��̸鼭 ������ ������ ������ �����ϴ� �л��� �̸��� �˻��Ͻÿ�(equi join)
select a.stu_name 
from student a, enrol b, subject c
where a.stu_no= b.stu_no and b.sub_no=c.sub_no 
and sub_prof ='������' and stu_gender='F'; 

--23. ������ �л��� ��� �������� ���� ������ ���� �л��� �й��� �̸��� �˻��Ͻÿ�.(equi join)
select a.stu_no, stu_name
from student a, enrol b, subject c
where a.stu_no = b.stu_no and b.sub_no = c.sub_no
and enr_grade >=
    (select avg(enr_grade) from student a, enrol b, subject c
    where a.stu_no = b.stu_no and b.sub_no = c.sub_no 
    and stu_name ='������')
and stu_name <> '������';

select avg(enr_grade) from student a, enrol b, subject c
where a.stu_no = b.stu_no and b.sub_no = c.sub_no 
and stu_name ='������';

--join using
select stu_no, stu_name 
from student join enrol using(stu_no) join subject using(sub_no)
where enr_grade>=
    (select avg(enr_grade) 
    from student join enrol using(stu_no) join subject using(sub_no)
    where stu_name = '������')
and stu_name <>'������';

select avg(enr_grade) from student join enrol using(stu_no) join subject using(sub_no)
where stu_name = '������';

--natural join
select stu_no, stu_name 
from student natural join enrol natural join subject
where enr_grade>= 
    (select avg(enr_grade) 
    from student natural join enrol natural join subject
    where stu_name='������')
and stu_name <> '������';

-- 24. ������ �л��� ������� ���� ���� ������ ���� �л��� �й��� �̸�, ������� �˻��Ͻÿ�. ���� ����
select stu_no, stu_name, sub_name 
from student natural join enrol natural join subject
where enr_grade <=
    (select avg(enr_grade) 
    from student natural join enrol
    where stu_name = '������')
and stu_name <> '������';

-- 25. ��ü �л��� ��� �������� ������ �뤽�� �л��� �й�, �̸�, �����, ������ �˻��Ͻÿ�(join ~ using)
select distinct stu_no, stu_name, sub_name, enr_grade 
from student join enrol using (stu_no) join subject using (sub_no)
where enr_grade >= 
    (select avg(enr_grade) 
    from enrol) order by 4 desc;

--26. ���� �ְ� ���� �л����� �ְ� ������ ���� �а��� �а���� ������ �˻��Ͻÿ�. ������¡
select stu_dept, max(enr_grade) 
from student join enrol using (stu_no) join subject using (sub_no)
group by stu_dept having max(enr_grade)>
    (select max(enr_grade) from 
    student join enrol using (stu_no) join subject using (sub_no) 
    where sub_dept ='���');
    
    
--27. �������ڰ��� ���� �������� ���� ������ ���� �а��� �а���� ������ �˻��Ͻÿ� ���� ��¡
select stu_dept, min(enr_grade)  
from student join enrol using (stu_no) join subject using (sub_no)
group by stu_dept having min(enr_grade)>
    (select min(enr_grade) from 
    student join enrol using (stu_no) join subject using (sub_no) 
    where sub_dept ='��������');
    
--28. ���� ���� �ο��� �����ȣ, ������ �Բ� �����ȣ������ �˻��Ͻÿ�.(natural join)
select sub_no, sub_name, count(*)
from student natural join enrol natural join subject
group by sub_no,sub_name
order by sub_no;