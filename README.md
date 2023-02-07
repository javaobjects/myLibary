# 图书管理系统

此项目是一个[cms(内容管理系统)](https://baike.baidu.com/item/CMS/315935?fr=aladdin)JAVASE项目;

### 使用语言：java

### 配置环境：jdk 1.8

### 开发工具：eclipse

### 模块划分

#### 用户前台模块部分：
```
1. 注册信息
2. 用户登陆
3. 查看所有图书信息
4. 查看热门图书信息
5. 查看可借图书信息
6. 查看已借图书信息(不可借)
7. 查看本人所有借书记录
8. 查看本人未归还图书记录
9. 查看本人已归还图书记录(已还借书记录)
10. 借书
11. 还书
```
#### 管理员后台模块部分：
```
1. 用户登陆
2. 查看所有图书信息
3. 查看指定编号的图书信息----未完成 样式完成
4. 查看指定书名的图书信息----未完成 样式完成
5. 添加图书----未完成 样式完成
6. 删除图书----未完成 样式完成
7. 修改图书----未完成 样式完成
8. 查看指定用户的借书历史记录----未完成 样式完成
9. 查看指定图书的借出历史记录----未完成  样式完成
```
![系统结构图](config/images/systemStructure.png)

### 总体架构：

MVC设计模式：
1. **M(Model) 模型:** 应⽤程序的核⼼功能，管理这个模块中⽤的数据和值（bean,dao） 数据访问层：Dao
2. **V(View )视图:** 视图提供模型的展示，管理模型如何显示给⽤户，它是应⽤程序的外观；（jsp/html）
3. **C(Controller)控制器:** 对⽤户的输⼊做出反应，管理⽤户和视图的交互，是连接模型和视图的枢纽。（servlet/service）
> 在此项目中用的工厂模式 其实 ifac 包就相当于service
4. entity文件夹 实体类属于公共层 不属于mvc任何层,也可存放于domain文件夹

| 包              | 作用                          |
| :-------------- | ----------------------------- |
| config.images   | 存放图片                      |
| config.dbconfig | 存放数据库配置文件            |
| lib             | 存放程序驱动                  |
| entity          | 实体类                        |
| util            | 公共类                        |
| view            | 视力类                        |
| factory         | 工厂类，专门生产各类dao的实例 |
| ifac            | 接口类                        |
| impl            | 接口实现类                    |
| test            | 测试类                        |

### 技术选型：
```
数据库：Oralce11G
JDBC工具：DBUtils
层与层之间解耦合：工厂设计模式
数据展示控件：JTable
访问数据库的查询方法封装使用技术：泛型，反射机制
```
### 数据库设计

#### myLibary_book表

| 列名       | 数据类型 | 可否为空 | 说明                           |
| :--------- | -------- | -------- | ------------------------------ |
| book_id    | int      | not null | 书籍编号，自增长               |
| book_name  | varchar  | not null | 书籍名称                       |
| book_count | int      | not null | 借出次数                       |
| status     | int      | not null | 书籍状态（0，已借出，1，可借） |



#### myLibary_user表
|  列名	 |  数据类型  |  可否为空  |  说明  |
| :----- | -------- | --------- | ------ |
|user_id |	int|	not null|	用户编号，自增长|
|user_name|	varchar|	not null|	用户名，唯一|
|user_password|	varchar	|not null|	用户密码|
|user_type	|int|	not null|	用户类型，1，普通用户，2，管理员|

### myLibary_record表

|  列名	|  数据类型  |  可否为空  |	 说明  |
| :----  | --------- | --------- | ------ |
| record_id	| int | not null	| 记录编号，自增长|
| user_id	| int | not null	| 借书人的编号，外键|
| book_id	| int  | not null	| 书籍编号，外键|
| lend_time	| date | not null	| 借出时间|
| return_time | date || 归还时间 |

#### sql语句

```
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
```

### 项目coding bug总结：

1. 数据库列名与代码中列名不一致 报标识符无效

![](https://upload-images.jianshu.io/upload_images/5227364-12d82ff45bfffbef.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

2. switch 里少写一种条件 无法得到数据

![](https://upload-images.jianshu.io/upload_images/5227364-53d4f26ba55d14c5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

3. insert into myLibary_record(record_id,book_id,user_id,lend_time) values(seq_myLibary_record_id.nextval,?,?,sysdate)语句少最后一个“）”号

![](https://upload-images.jianshu.io/upload_images/5227364-5d2e464b4e9e97d0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

4. select seq_record_id.nextval from dual; 值被占用。。
解决方法 在pl/sql工具中多执行几次直到大于当前表的索引值

![](https://upload-images.jianshu.io/upload_images/5227364-2f263389b8e4cd55.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

5. JInternalFrame窗体无法关闭 原因：this.setDefaultCloseOperation()里参数DISPOSE_ON_CLOSE/EXIT_ON_CLOSE混淆 正确值应该是 DISPOSE_ON_CLOSE

![](https://upload-images.jianshu.io/upload_images/5227364-1bfde1ded786ca91.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

6. sql语句后面多写分号 例："insert into myLibary_user(user_id,user_name,user_password,user_type)"
			+ " values((select max(user_id) from myLibary_user)+1,?,?,?);" 正确写法应该是:"insert into myLibary_user(user_id,user_name,user_password,user_type)"
			+ " values((select max(user_id) from myLibary_user)+1,?,?,?)"
			

![](https://upload-images.jianshu.io/upload_images/5227364-b97e60aa43f069d5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


#### 参考博客

1. [JavaWeb中的MVC模式（有案例）](https://blog.csdn.net/weixin_45819587/article/details/120564732)





