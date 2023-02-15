package com.tencent.myLibary.dao.ifac.admin;

import java.util.List;

import com.tencent.myLibary.entity.User;

/**
 * <p>Title: AdminUserDaoIfac</p>
 * <p>
 *    Description:管理员查询用户接口
 * </p>
 * @author xianxian
 * @date 2023年2月15日下午5:22:17
 */
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
	
	/**
	 * <p>Title: queryAppointUserByUserName</p>
	 * <p>
	 *    Description:根据指定用户名查询用户
	 * </p>
	 * <p>Copyright: Copyright (c) 2017</p>
	 * <p>Company: www.baidudu.com</p>
	 * @param userName
	 * @return
	 * @author xianxian
	 * @date 2023年2月15日下午4:52:33
	 * @version 1.0
	 */
	public abstract List<User> queryAppointUserByUserName(String userName);
}
