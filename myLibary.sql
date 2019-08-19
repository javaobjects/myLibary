﻿create table myLibary_book
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
