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
