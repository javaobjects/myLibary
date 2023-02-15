package com.tencent.myLibary.test;

import com.tencent.myLibary.dao.impl.user.UserUserDaoImpl;

public class TestUserUserDaoImpl {

	public static void main(String[] args) {
		System.out.println(new UserUserDaoImpl().queryUserByNameAndPassword("aaa", "123456",1));
	}
}
