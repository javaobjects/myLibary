package com.tencent.myLibary.test;

import com.tencent.myLibary.entity.User;
import com.tencent.myLibary.view.user.UserMainView;

public class TestUserMainView {
	
	public static void main(String[] args) {
		User user = new User(2,"bbb","123456",2);
		new UserMainView(user);
	}
}
