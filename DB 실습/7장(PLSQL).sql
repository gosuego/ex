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
