package com.tencent.myLibary.test;

import com.tencent.myLibary.entity.User;
import com.tencent.myLibary.view.admin.AdminMainView;

public class TestAdminrMainView {
	public static void main(String[] args) {
		User user = new User(1,"aaa","123456",1);
		new AdminMainView(user);
	}
}
