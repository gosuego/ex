--7�� PL/SQL
--���� 1

set serveroutput on;

begin
    dbms_output.put_line('Hello Word');
end;
/

begin
    dbms_output.put_line('�ȳ��ϼ���');
    dbms_output.put_line('����Ŭ�Դϴ�.');
end;
/
--����2
--���� ����
declare
    vempno number(4);
    vename varchar2(10);
begin
    vempno := 1001;
    vename :='����';
    dbms_output.put_line('��� �̸�');
    dbms_output.put_line('--------------------');
    dbms_output.put_line(' '||vempno||' '||vename);
end;
/
--����ó����
--if ~~ end if
-- ���� if
declare
v_condition number := 1;
begin
 if v_condition = 1 then
  dbms_output.put_line('����');
 end if;
end;
/
--if ~ else ~ end if
declare
v_condition number :=1;
begin
if v_condition > 1 then
 dbms_output.put_line('����');
 else
  dbms_output.put_line('�츮');
 end if;
end;
/

declare 
v_condition number :=2;
begin
 if v_condition < 1 then
  dbms_output.put_line('����');
 elsif v_condition = 1 then
  dbms_output.put_line('�α�');
 else
  dbms_output.put_line('����');
 end if;
end;
/
--�ݺ�ó����
--loop ~ end loop
declare 
 v_cnt number :=0;
 v_sum number :=0;
 begin
  loop 
   v_cnt := v_cnt +1;
   v_sum := v_sum + v_cnt;
   dbms_output.put_line(v_cnt|| '->' ||v_sum);
   exit when v_cnt = 10;
  end loop;
 end;
/
--for ~ end loop
declare 
 v_cnt number;
 v_sum number :=0;
 begin
  for v_cnt in 1..10 loop
   v_sum := v_sum + v_cnt;
   dbms_output.put_line(v_cnt||'->'||v_sum);
  end loop;
 end;
/
--while ~ end loop
declare
 v_cnt number :=0;
 v_sum number :=0;
 begin
  while v_cnt < 10 loop
  v_cnt := v_cnt +1;
  v_sum := v_sum + v_cnt;
  dbms_output.put_line(v_cnt||'->'||v_sum);
 end loop;
end;
/
--����
--Badic Loop�� (1���� 5���� ����ϱ�)
declare
 n number :=1;
 begin 
  loop
   dbms_output.put_line(n);
   n := n+1;
   if n>5 then
    exit;
   end if;
   end loop;
  end;
/
-- For Loop�� (1���� 5���� ����ϱ�)
declare
 n number :=1;
 begin
  for n in 1..5 loop
   dbms_output.put_line(n);
  end loop;
 end;
/
--While Loop�� (1���� 5���� ����ϱ�)
declare
 n number :=1;
 begin
  while n <6 loop
   dbms_output.put_line(n);
   n := n +1;
  end loop;
 end;
/
--����1 (������ 5�� ���ϱ�)
declare
 dan number := 5;
 i number := 1;
begin
loop
 dbms_output.put_line(dan || '*' || i||'='||(dan*i));
 i:=i+1;
 if i >9 then
  exit;
  end if;
 end loop;
end;
/
declare
 dan number := 5;
 i number := 1;
begin
 for i in 1..9 loop
 dbms_output.put_line(dan || '*' || i||'='||(dan*i));
 end loop;
end;
/
--����2
declare
 v_cnt number:=1;
 v_str varchar2(10) := null;
begin
 while v_cnt <= 5 loop
  v_str := v_str||'*';
  dbms_output.put_line(v_str);
  v_cnt := v_cnt +1;
 end loop;
end;
/
/*
set verify on/off : sql ����̳� pl/sql���� &�� �̿��� ġȯ�������� ����� �� ġȯ�Ǳ� �� ����
�ڼ��� ���� ���� ������ ���θ� �����Ѵ�. �⺻���� on�̴�.
*/

set verify off;

--����3(select empno from emp)
select & list
from & tab
where rownum<10;

--����4
create table pl_test2
( no number,
 name varchar2(10),
 addr varchar2(10)
);
--������ 3�� ����
declare
 v_no number := '&no';
 v_name varchar(10) := '&name';
 v_addr varchar(10) :='&addr';
begin
 insert into pl_test2
 values(v_no,v_name,v_addr);
end;
/
select *from pl_test2;

begin
 update pl_test2
 set name='K'
 where no = 1;
end;
/

begin
 delete from pl_test2
 where no =3;
end;
/
select *from pl_test2;

--pl_test2 ���̺��� no=2 �� �̸�('ȫ�浿')�� �ּ�('�սʸ�')�� �����Ͻÿ�.

begin
 update pl_test2
 set name='ȫ�浿', addr ='�սʸ�'
 where no =2;
end;
/ 
select *from subject;
create procedure test1
(v_sub_name in subject.sub_name%type,
v_sub_prof in subject.sub_prof%type,
v_sub_grade in subject.sub_grade%type,
v_sub_dept in subject.sub_dept%type)
is
v_sub_no subject.sub_no%type;
begin
select max(sub_no)
 into v_sub_no
 from subject;
v_sub_no := to_number(v_sub_no)+1;
insert
 into subject
 values(v_sub_no,v_sub_name,v_sub_prof,v_sub_grade,
v_sub_dept);
commit;
end test1;
/

execute test1('��ǻ�ͱ���','���ֺ�',2,'��ǻ������');
select *from subject;

create or replace procedure test2
 (v_stu_no in student.stu_no%type,
 v_stu_grade in student.stu_grade%type)
is
begin
update student
set stu_grade = v_stu_grade
where stu_no = v_stu_no;
end test2;
/
select * 
 from student 
 where stu_no = 20153075; 

 
exec test2(20153075,2); 

select * 
 from student 
 where stu_no = 20153075;
 
--test3 : �й��� �Է����� �л��� �̸��� �˻�
create or replace procedure test3
(v_stu_no in student.stu_no%type,
v_stu_name out student.stu_name%type)
is
begin
select stu_name
into v_stu_name
from student
where stu_no = v_stu_no;
 end test3;
/
variable d_stu_name varchar2(12); 
 exec test3(20153075,:d_stu_name);
 
print d_stu_name;

--test4 :�л��� ������ ���� ������ŭ �÷��ִ� ���ν���
create or replace procedure test4
(v_sub_no in enrol.sub_no%type,
 v_stu_no in enrol.stu_no%type,
v_enr_grade in out enrol.enr_grade%type)
 is
begin
 update enrol
 set enr_grade = enr_grade + v_enr_grade
 where stu_no = v_stu_no
 and sub_no = v_sub_no;
 select enr_grade
into v_enr_grade
from enrol
where stu_no = v_stu_no
 and sub_no = v_sub_no;
 end test4;
/
select * from enrol where stu_no = 20131001 and sub_no=101;

variable d_enr_grade number
begin
  :d_enr_grade:=10;
end;
/
print d_enr_grade;
--test 5: ���� �߰�, �����ȣ�� ������ �ԷµǴ� ������� �ο�

create sequence seq1
increment by 1
start with 201
maxvalue 999;

create procedure test5
(v_sub_name in subject.sub_name%type,
 v_sub_prof in subject.sub_prof%type,
 v_sub_grade in subject.sub_grade%type,
 v_sub_dept in subject.sub_dept%type)
is
begin
insert
into subject
values(seq1.nextval, v_sub_name,v_sub_prof, v_sub_grade, v_sub_dept);
commit;
end test5;
/

select *from subject order by 1;
exec test5('��','ȫ�浿',3,'��ǻ������');
select *from subject order by 1;

--test6
create or replace function test6
 (v_enr_grade in number)
 return char
is
 enr_score char;
begin
 if v_enr_grade >= 90 then enr_score := 'A';
 elsif v_enr_grade >= 80 then enr_score :='B';
 elsif v_enr_grade >= 70 then enr_score := 'C';
 elsif v_enr_grade >= 60 then enr_score := 'D';
 end if;
 return (enr_score);
end test6;
/
variable d_score char;
execute :d_score := test6(95);
print d_score;

select enr_grade, test6(enr_grade) as score
  from enrol 
  where stu_no = 20131001;