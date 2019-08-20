package com.tencent.myLibary.dao.ifac;

import com.tencent.myLibary.entity.User;

public interface UserDaoIfac {

	/**
	 * 
	 * <p>Title: addUser</p>  
	 * <p>
	 *	Description: 
	 *	添加用户的方法：
	 *	用户注册功能会调用该方法
	 * </p> 
	 * @param user
	 * @return
	 */
	int addUser(User user);

	/**
	 * 
	 * <p>Title: queryUserByNameAndPassword</p>  
	 * <p>
	 *	Description: 
	 *	根据用户名和密码查询用户的方法
	 *	用户登录时会调用该方法
	 * </p> 
	 * @param username
	 * @param password
	 * @param userType
	 * @return
	 */
	User queryUserByNameAndPassword(String username, String password, Integer userType);

}