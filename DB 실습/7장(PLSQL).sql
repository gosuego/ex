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
/*
set verify on/off : sql 명령이나 pl/sql에서 &를 이용한 치환변수들을 사용할 때 치환되기 전 후의
자세한 값을 보일 건지의 여부를 결정한다. 기본값은 on이다.
*/

set verify off;

--예시3(select empno from emp)
select & list
from & tab
where rownum<10;

--예시4
create table pl_test2
( no number,
 name varchar2(10),
 addr varchar2(10)
);
--데이터 3개 삽입
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

--pl_test2 테이블에서 no=2 인 이름('홍길동')과 주소('왕십리')을 변경하시오.

begin
 update pl_test2
 set name='홍길동', addr ='왕십리'
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

execute test1('컴퓨터구조','강주봉',2,'컴퓨터정보');
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
 
--test3 : 학번을 입력으로 학생의 이름을 검색
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

--test4 :학생의 점수를 임의 점수만큼 올려주는 프로시저
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
--test 5: 과목 추가, 과목번호는 과목이 입력되는 순서대로 부여

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
exec test5('앱','홍길동',3,'컴퓨터정보');
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