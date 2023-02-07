create table myLibary_book
(
  book_id number(6) primary key,
  book_name varchar2(40) not null,
  lend_count number(3) not null,
  status number(1) not null check(status in (0,1))---0表示借出，1表示在馆
);

create sequence seq_myLibary_book_id;---这个序列为book的id赋值，默认从1开始

select seq_myLibary_book_id.nextval from dual;
select seq_myLibary_book_id.currval from dual; 
-- drop sequence seq_myLibary_book_id;

insert into myLibary_book
values(seq_myLibary_book_id.currval,'Java基础',3,0);--1
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'JS高级',2,1);--2
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'PHP入门',5,1);--3
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'Oracle基础',1,0);--4
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'vue入门',3,1);--5
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'计算机基础',5,0);--6
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'网络基础',6,1);--7
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'xshell',2,1);--8
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'git入门',6,1);--9
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'webpack配置',9,1);--10
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'CSS探密',7,1);--11
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'HTML5入门',4,0);--12
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'react入门',5,1);--13
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'Angular入门',4,0);--14
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'nodeJs入门',6,1);--15
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'mySql精讲',10,0);--16
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'Mongodb精讲',9,1);--17
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'ES6精讲',14,0);--18
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'spring入门',22,1);--19
insert into myLibary_book
values(seq_myLibary_book_id.nextval,'mybaits入门',15,0);--20


--drop table myLibary_book;

select * from myLibary_book;

create table myLibary_user
(
  user_id number(6) primary key,
  user_name varchar2(40) not null unique,
  user_password varchar2(40) not null,
  user_type number(1) not null check(user_type in (1,2))
);

create sequence seq_myLibary_user_id;

select seq_myLibary_user_id.nextval from dual;
select seq_myLibary_user_id.currval from dual;

insert into myLibary_user
values(seq_myLibary_user_id.currval,'aaa',123456,1);--1
insert into myLibary_user
values(seq_myLibary_user_id.nextval,'bbb',123456,2);--2
insert into myLibary_user
values(seq_myLibary_user_id.nextval,'ccc',123456,1);--3
insert into myLibary_user
values(seq_myLibary_user_id.nextval,'ddd',123456,2);--4
insert into myLibary_user
values(seq_myLibary_user_id.nextval,'eee',123456,1);--5
insert into myLibary_user 
values(seq_myLibary_user_id.nextval,'fff',123456,2);--6

select * from myLibary_user;


create table myLibary_record
(
  record_id number(6) primary key,
  user_id number(6) not null,
  book_id number(6) not null,
  lend_time date not null,
  return_time date
);

-- drop table myLibary_record;

create sequence seq_myLibary_record_id;

alter table myLibary_record
  add constraint FK_MYLIBARY_USER_ID foreign key (user_id)
  references myLibary_user(user_id);

alter table myLibary_record
  add constraint FK_MYLIBARY_BOOK_ID foreign key (book_id)
  references myLibary_book(book_id);

select seq_myLibary_record_id.nextval from dual;
select seq_myLibary_record_id.currval from dual;



insert into myLibary_record
values(seq_myLibary_record_id.currval,1,1,to_date('2019-04-02','yyyy/mm/dd'),
to_date('2019-05-01','yyyy/mm/dd'));--1

insert into myLibary_record
values(seq_myLibary_record_id.nextval,1,2,to_date('2019-04-02','yyyy/mm/dd'),null);--2

insert into myLibary_record
values(seq_myLibary_record_id.nextval,1,3,to_date('2019-04-02','yyyy/mm/dd'),
to_date('2019-05-01','yyyy/mm/dd'));--3

insert into myLibary_record
values(seq_myLibary_record_id.nextval,1,4,to_date('2019-04-02','yyyy/mm/dd'),null);--4


insert into myLibary_record
values(seq_myLibary_record_id.nextval,1,5,to_date('2019-04-02','yyyy/mm/dd'),
to_date('2019-05-01','yyyy/mm/dd'));--5

insert into myLibary_record
values(seq_myLibary_record_id.nextval,1,6,to_date('2019-04-02','yyyy/mm/dd'),
to_date('2019-05-01','yyyy/mm/dd'));--6

insert into myLibary_record
values(seq_myLibary_record_id.nextval,1,7,to_date('2019-04-02','yyyy/mm/dd'),
to_date('2019-05-01','yyyy/mm/dd'));--7

insert into myLibary_record
values(seq_myLibary_record_id.nextval,1,8,to_date('2019-04-02','yyyy/mm/dd'),
to_date('2019-05-01','yyyy/mm/dd'));--8

insert into myLibary_record
values(seq_myLibary_record_id.nextval,2,9,to_date('2019-01-01','yyyy/mm/dd'),
to_date('2019-01-05','yyyy/mm/dd'));--9


insert into myLibary_record
values(seq_myLibary_record_id.nextval,2,10,to_date('2019-01-01','yyyy/mm/dd'),
to_date('2019-01-05','yyyy/mm/dd'));--10

insert into myLibary_record
values(seq_myLibary_record_id.nextval,2,11,to_date('2019-01-01','yyyy/mm/dd'),
to_date('2019-01-05','yyyy/mm/dd'));--11

insert into myLibary_record
values(seq_myLibary_record_id.nextval,2,12,to_date('2019-01-01','yyyy/mm/dd'),
to_date('2019-01-05','yyyy/mm/dd'));--12

insert into myLibary_record
values(seq_myLibary_record_id.nextval,2,13,to_date('2019-01-01','yyyy/mm/dd'),
to_date('2019-01-05','yyyy/mm/dd'));--13

insert into myLibary_record
values(seq_myLibary_record_id.nextval,2,14,to_date('2019-01-01','yyyy/mm/dd'),
to_date('2019-01-05','yyyy/mm/dd'));--14

insert into myLibary_record
values(seq_myLibary_record_id.nextval,2,15,to_date('2019-01-01','yyyy/mm/dd'),
to_date('2019-01-05','yyyy/mm/dd'));--15

insert into myLibary_record
values(seq_myLibary_record_id.nextval,2,16,to_date('2019-01-01','yyyy/mm/dd'),
to_date('2019-01-05','yyyy/mm/dd'));--16

insert into myLibary_record
values(seq_myLibary_record_id.nextval,3,17,to_date('2019-03-03','yyyy/mm/dd'),
to_date('2019-03-05','yyyy/mm/dd'));--17

insert into myLibary_record
values(seq_myLibary_record_id.nextval,3,18,to_date('2019-03-03','yyyy/mm/dd'),
to_date('2019-03-05','yyyy/mm/dd'));--18

insert into myLibary_record
values(seq_myLibary_record_id.nextval,3,19,to_date('2019-03-03','yyyy/mm/dd'),
to_date('2019-03-05','yyyy/mm/dd'));--19

insert into myLibary_record
values(seq_myLibary_record_id.nextval,3,20,to_date('2019-03-03','yyyy/mm/dd'),
to_date('2019-03-05','yyyy/mm/dd'));--20

insert into myLibary_record
values(seq_myLibary_record_id.nextval,3,1,to_date('2019-03-03','yyyy/mm/dd'),
to_date('2019-03-05','yyyy/mm/dd'));--21

insert into myLibary_record
values(seq_myLibary_record_id.nextval,3,2,to_date('2019-03-03','yyyy/mm/dd'),
to_date('2019-03-05','yyyy/mm/dd'));--22

insert into myLibary_record
values(seq_myLibary_record_id.nextval,3,3,to_date('2019-03-03','yyyy/mm/dd'),
to_date('2019-03-05','yyyy/mm/dd'));--23

insert into myLibary_record
values(seq_myLibary_record_id.nextval,4,7,to_date('2019-07-07','yyyy/mm/dd'),
to_date('2019-07-24','yyyy/mm/dd'));--24

insert into myLibary_record
values(seq_myLibary_record_id.nextval,5,10,to_date('2019-07-07','yyyy/mm/dd'),
to_date('2019-07-24','yyyy/mm/dd'));--25

insert into myLibary_record
values(seq_myLibary_record_id.nextval,6,12,to_date('2019-07-07','yyyy/mm/dd'),
to_date('2019-07-24','yyyy/mm/dd'));--25

select * from Mylibary_User;
select * from Mylibary_Book;
select * from myLibary_record;
