package com.tencent.myLibary.test;

import com.tencent.myLibary.dao.impl.UserDaoImpl;

public class TestUserDaoImpl {

	public static void main(String[] args) {
		System.out.println(new UserDaoImpl().queryUserByNameAndPassword("aaa", "123456",1));
	}
}
