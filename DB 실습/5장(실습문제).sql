--5�� �ǽ�����

--�л����2

create table student1(
stu_no char(9),
stu_name varchar2(12),
stu_dept varchar2(20),
stu_year number(1),
stu_class char(1),
stu_gender char(1),
stu_height number(5,2),
stu_weight number(5,2),
constraint k_stu_no primary key(stu_no));

insert into student1 values('20093075', '���Ѻ�','���',1,'C','M',177,80);
insert into student1 values('20093088', '���¿�','���',1,'C','F',162,50);
insert into student1 values('20093054', '������','���',2,'C','F',154,47);
insert into student1 values('20072088', '���ο�','��������',1,'C','M',188,90);
insert into student1 values('20062021', '�ɼ���','��������',2,'A','F',168,45);
insert into student1 values('20061062', '������','��ǻ������',1,'B','M',166,67);
insert into student1 values('20061007', '������','��ǻ������',2,'C','M',174,64);

create table subject1(
sub_no char(3),
sub_name varchar2(30),
sub_prof varchar2(12),
sub_year number(1),
sub_dept varchar2(20),
constraint k_sub_no primary key(sub_no));

insert into subject1 values('111', '�����ͺ��̽�','���翵',2,'��ǻ������');
insert into subject1 values('110', '�ڵ�����','������',2,'��������');
insert into subject1 values('109', '�ڵ�ȭ����','�ڹο�',3,'���');
insert into subject1 values('101', '��ǻ�Ͱ���','������',3,'��ǻ������');
insert into subject1 values('102', '�����۹�','���¿�',1,'���');
insert into subject1 values('103', '�������ڽ���','������',1,'��������');
insert into subject1 values('104', '�ý��ۺм�����','������',3,'��ǻ������');
insert into subject1 values('105', '����Ҽ���','���',1,'���');
insert into subject1 values('106', '����ȸ�ν���','�ֿ���',3,'��������');
insert into subject1 values('107', 'CAD����ǽ�','������',2,'���');
insert into subject1 values('108', '����Ʈ�������','�ǹμ�',1,'��ǻ������');

create table enrol1(
sub_no char(3),
stu_no char(9),
enr_grade number(3),
constraint k_course primary key(sub_no,stu_no));

insert into enrol1 values('101','20071001',80);
insert into enrol1 values('104','20071001',56);
insert into enrol1 values('106','20052003',72);
insert into enrol1 values('103','20072088',45);
insert into enrol1 values('101','20071025',65);
insert into enrol1 values('104','20071025',65);
insert into enrol1 values('108','20061062',81);
insert into enrol1 values('107','20093054',41);
insert into enrol1 values('102','20093075',66);
insert into enrol1 values('105','20093075',56);
insert into enrol1 values('102','20093088',61);
insert into enrol1 values('105','20093088',78);

commit;
