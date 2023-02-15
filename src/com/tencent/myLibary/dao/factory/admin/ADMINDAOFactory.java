package com.tencent.myLibary.dao.factory.admin;

import com.tencent.myLibary.dao.ifac.admin.AdminUserDaoIfac;
import com.tencent.myLibary.dao.impl.admin.AdminUserDaoIpml;

public class ADMINDAOFactory {
	
	
	public static AdminUserDaoIfac getAdminUserDaoIfac() {
		return new AdminUserDaoIpml();
	}
	
	
}
