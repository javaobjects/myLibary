package com.tencent.myLibary.test;

import com.tencent.myLibary.dao.impl.user.UserBookDaoImpl;

public class TestUserBookDaoImpl {

	public static void main(String[] args) {
		// 测试查询所有图书的方法
		System.out.println(new UserBookDaoImpl().queryAllBooks().toString());

	}

}
