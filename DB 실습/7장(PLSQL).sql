--7장 PL/SQL
--예시 1

set serveroutput on;

begin
    dbms_output.put_line('Hello Word');
end;
/

begin
    dbms_output.put_line('안녕하세요');
    dbms_output.put_line('오라클입니다.');
end;
/
--예시2
--변수 선언
declare
    vempno number(4);
    vename varchar2(10);
begin
    vempno := 1001;
    vename :='김사랑';
    dbms_output.put_line('사번 이름');
    dbms_output.put_line('--------------------');
    dbms_output.put_line(' '||vempno||' '||vename);
end;
/
--선택처리문
--if ~~ end if
-- 변수 if
declare
v_condition number := 1;
begin
 if v_condition = 1 then
  dbms_output.put_line('대한');
 end if;
end;
/
--if ~ else ~ end if
declare
v_condition number :=1;
begin
if v_condition > 1 then
 dbms_output.put_line('대한');
 else
  dbms_output.put_line('우리');
 end if;
end;
/

declare 
v_condition number :=2;
begin
 if v_condition < 1 then
  dbms_output.put_line('대한');
 elsif v_condition = 1 then
  dbms_output.put_line('민국');
 else
  dbms_output.put_line('만세');
 end if;
end;
/
--반복처리문
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
--예시
--Badic Loop문 (1부터 5까지 출력하기)
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
-- For Loop문 (1부터 5까지 출력하기)
declare
 n number :=1;
 begin
  for n in 1..5 loop
   dbms_output.put_line(n);
  end loop;
 end;
/
--While Loop문 (1부터 5까지 출력하기)
declare
 n number :=1;
 begin
  while n <6 loop
   dbms_output.put_line(n);
   n := n +1;
  end loop;
 end;
/
--예시1 (구구단 5단 구하기)
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
--예시2
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