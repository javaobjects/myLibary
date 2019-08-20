package com.tencent.myLibary.view;

import com.tencent.myLibary.entity.User;

public class TestUserMainView {
	
	

	public static void main(String[] args) {
		User user = new User(2,"bbb","123456",2);
		new UserMainView(user);

	}

}
