package com.tencent.myLibary.dao.factory.admin;

import com.tencent.myLibary.dao.ifac.admin.AdminBookDaoIfac;
import com.tencent.myLibary.dao.ifac.admin.AdminRecordDaoIfac;
import com.tencent.myLibary.dao.ifac.admin.AdminUserDaoIfac;
import com.tencent.myLibary.dao.impl.admin.AdminBookDaoImpl;
import com.tencent.myLibary.dao.impl.admin.AdminRecordDaoImpl;
import com.tencent.myLibary.dao.impl.admin.AdminUserDaoIpml;
/**
 * <p>Title: ADMINDAOFactory</p>
 * <p>
 *    Description:管理员工厂dao
 * </p>
 * @author xianxian
 * @date 2023年2月15日下午5:21:25
 */
public class ADMINDAOFactory {
	
	public static AdminUserDaoIfac getAdminUserDaoInstance() {
		return new AdminUserDaoIpml();
	}
	
	public static AdminBookDaoIfac getAdminBookDaoInstance() {
		return new AdminBookDaoImpl();
	}
	
	public static AdminRecordDaoIfac getAdminRecordDaoInstance() {
		return new AdminRecordDaoImpl();
	}
}
