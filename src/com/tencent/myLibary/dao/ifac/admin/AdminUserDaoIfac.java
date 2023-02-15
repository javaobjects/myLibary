package com.tencent.myLibary.dao.ifac.admin;

import java.util.List;

import com.tencent.myLibary.entity.User;

public interface AdminUserDaoIfac {
	
	/**
	 * <p>Title: queryAllUsers</p>
	 * <p>
	 *    Description:查询所有用户
	 * </p>
	 * <p>Copyright: Copyright (c) 2017</p>
	 * <p>Company: www.baidudu.com</p>
	 * @return
	 * @author xianxian
	 * @date 2023年2月15日下午3:07:34
	 * @version 1.0
	 */
	public abstract List<User> queryAllUsers();
}
