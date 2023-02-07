# 图书管理系统

此项目是一个[cms(内容管理系统)](https://baike.baidu.com/item/CMS/315935?fr=aladdin)JAVASE项目;

#### 使用语言：Java

#### 配置环境：Jdk 1.8

#### 开发工具：Eclipse

#### 数据库设计：

##### mylibary_user表

|  列名	 |  数据类型  |  可否为空  |  说明  |
| ------ | -------- | --------- | ------ |
|user_id |	int|	not null|	用户编号，自增长|
|user_name|	varchar|	not null|	用户名，唯一|
|user_password|	varchar	|not null|	用户密码|
|user_type	|int|	not null|	用户类型，1，普通用户，2，管理员|
|user_status  |int|not null | 用户状态, 0,未激活，1，已激活 |

##### myLibary_book表

|  列名	  |  数据类型	|  可否为空	 |  说明  |
| ------  | ---------- | --------- | ------ |
|book_id	|int	|not null	|书籍编号，自增长|
|book_name	|varchar	|not null	|书籍名称|
|book_count	|int	|not null	|借出次数|
|boot_status|int	|not null	|书籍状态（0，已借出，1，可借）|

##### myLibary_record表

|  列名	|  数据类型  |  可否为空  |	 说明  |
| -----  | --------- | --------- | ------ |
| record_id	| int | not null	| 记录编号，自增长|
| user_id	| int | not null	| 借书人的编号，外键|
| book_id	| int  | not null	| 书籍编号，外键|
| lend_time	| date | not null	| 借出时间|
| return_time | date || 归还时间 |







