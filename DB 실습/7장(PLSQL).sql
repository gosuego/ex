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