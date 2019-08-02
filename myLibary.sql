create table tab_book
(
  book_id number(6) primary key,
  book_name varchar2(40) not null,
  lend_count number(3) not null,
  status number(1) not null check(status in (0,1))---0表示借出，1表示在馆
);

create sequence seq_book_id;---这个序列为book的id赋值，默认从1开始



create table tab_user
(
  user_id number(6) primary key,
  user_name varchar2(40) not null unique,
  user_password varchar2(40) not null,
  user_type number(1) not null check(user_type in (1,2))
);

create sequence seq_user_id;


create table tab_record
(
	record_id number(6) primary key,
	user_id number(6) not null,
	book_id number(6) not null,
	lend_time date not null,
	return_time date
);

create sequence seq_record_id;
alter table tab_record
  add constraint FK_USER_ID foreign key (user_id)
  references tab_user(user_id);

alter table tab_record
  add constraint FK_BOOK_ID foreign key (book_id)
  references tab_book(book_id);
