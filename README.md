# 图书管理系统

此项目是一个[cms(内容管理系统)](https://baike.baidu.com/item/CMS/315935?fr=aladdin)JAVASE项目;

### 使用语言：java

### 配置环境：jdk 1.8

### 开发工具：Eclipse

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
3. 查看热门图书信息
4. 查看可借图书信息
5. 查看已借图书信息(不可借)
6. 查看指定 图书名 的图书信息
7. 添加图书
8. 查看 所有用户的借阅记录
9. 查看 所有用户的未还记录
10. 查看 所用用户的已还记录
11. 查看 当前用户的借阅记录
12. 查看 当前用户的未还记录
13. 查看 当前用户的已还记录
14. 查看 指定用户的借阅记录
15. 查看 指定用户的未还记录
16. 查看 指定用户的已还记录
17. 查询所有用户
18. 查询指定用户
```
![系统结构图](config/Images/systemStructure.png)

### 总体架构：

MVC设计模式：
1. **M(Model) 模型:** 应⽤程序的核⼼功能，管理这个模块中⽤的数据和值（bean,dao） 数据访问层：Dao
2. **V(View )视图:** 视图提供模型的展示，管理模型如何显示给⽤户，它是应⽤程序的外观；（jsp/html）
3. **C(Controller)控制器:** 对⽤户的输⼊做出反应，管理⽤户和视图的交互，是连接模型和视图的枢纽。（servlet/service）
> 在此项目中用的工厂模式 其实 ifac 包就相当于service
4. entity文件夹 实体类属于公共层 不属于mvc任何层,也可存放于domain文件夹
4. 本项目中view层调用dao层，dao层调用数据库，其中 dao层中 ifac为接口 impl为接口的实现 通过factory解耦合 并实现连接


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

### 主要功能

1. 普通用户注册，主要功能为图书查询和借阅记录查询两大模块。

+ 1. 查询所有图书
  2. 借书
  3. 还书
  4. 查询自己的所有借书记录
  5. 查询自己所有未还的图书
  6. 查询自己的已还的借书记录

2. 管理员用户注释，主要功能也是图书查询和借阅记录查询两大模块。
   + 1. 查询所有的图书
     2. 借书
     3. 还书
     4. 查询所有用户或指定用户的借书记录
     5. 查询所有用户或指定用户的所有未还的图书
     6. 查询所有用户或指定用户的已还的借书记录
     7. 添加图书
     8. 删除图书
     9. 修改图书

#### 项目说明

> 此项目为1.0版本的练手项目，预计2.0版本将会加入 如下几个功能

1. 书籍的数量
2. 管理员的修改删除功能
3. 用户登录时忘记密码功能


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
|user_type	|int| 1not null |	用户类型，1，普通用户，2，管理员|

### myLibary_record表

> 存放所有的借阅记录的表

|  列名	|  数据类型  |  可否为空  |	 说明  |
| :----  | --------- | --------- | ------ |
| record_id	| int | not null	| 记录编号，自增长|
| user_id	| int | not null	| 借书人的编号，外键|
| book_id	| int  | not null	| 书籍编号，外键|
| lend_time	| date | not null	| 借出时间|
| return_time | date || 归还时间 |

### 业务功能简介

1. 用户登录

![](config/Images/1.png)

![](config/Images/2.png)

2. 用户注册

![](config/Images/3.png)

3. 所有图书查询功能

![](config/Images/4.png)

4. 热门图书查询

![](config/Images/5.png)

5. 可借图书查询

![](config/Images/6.png)

6. 不可借图书查询

![](config/Images/7.png)

7. 指定图书查询

![](config/Images/8.png)

8. 添加图书

![](config/Images/9.png)

9. 借阅记录查询 当前用户指定用户所有用户

![](config/Images/10.png)

10. 指定用户查询所有用户查询

![](config/Images/11.png)

### 项目说明

+ 此项目唯一的目的是在于巩固基础知识

### 项目运行

1. 保证已安装jdk1.8的环境
2. Eclipse与jdk要配置好
3. navicat导入mylibary_all.sql运行生成对应的数据表前提是你安装好对应的mysql以及navicat
4. 利用Eclipse打开测试类运行此项目


### 参考博客

1. [JavaWeb中的MVC模式（有案例）](https://blog.csdn.net/weixin_45819587/article/details/120564732)
1. [Java语言使用JDBC连接Mysql数据库的详细步骤，以及详细解释（一）](https://blog.csdn.net/weixin_44912627/article/details/109464979)
1. [各个数据库中，查询前n条记录的方法](https://blog.csdn.net/Schaffer_W/article/details/117062045)
1. [MySQL序列的使用](https://www.yiibai.com/mysql/mysql-using-sequences.html)
1. [如何在MySQL中创建和使用序列？](https://www.nhooo.com/note/qa06il.html)
1. [mysql与oracle的区别_MySQL](https://www.php.cn/mysql-tutorials-68362.html)
1. [**Oracle与MySQL的几点区别**](https://blog.51cto.com/u_15067234/4183964)
1. [[MySQL与Oracle之间的区别](https://www.cnblogs.com/KYKY22/p/5755105.html)]
1. [mysql与oracle区别](https://blog.csdn.net/qq_37480021/article/details/80703081)
1. [Oracle转MySQL日记（三） ---关于Oracle序列(Sequence)的转化](https://blog.csdn.net/zjfhhc/article/details/105935131)
1. [Navicat设置自动递增的基本步骤](https://www.jianshu.com/p/6ede8ff21e4c)
1. [Java Swing 隐藏JTable的某一列](https://blog.csdn.net/weixin_42089228/article/details/107901907)
1. [Java Swing 只关闭当前窗体](https://zhuanlan.zhihu.com/p/150829207)
1. [Java代码中如何判断一个字符串中是否包含特殊字符呢？](https://www.cnblogs.com/javalove2022/p/16689963.html)
1. [如何给combobox设定一个默认值？](https://blog.csdn.net/weixin_34124651/article/details/85488261)
1. [JTextField显示提示信息](https://blog.csdn.net/qq_43319748/article/details/108636961)
1. [**Eclipse 快捷键返回值Alt+shift+L和Ctrl+1**](https://blog.51cto.com/u_14879850/5867019)
1. [gitee的markdown文件图片显示不出来](https://www.cnblogs.com/hi3254014978/p/14150052.html)



