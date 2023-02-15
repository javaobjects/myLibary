package com.tencent.myLibary.dao.ifac.user;

import com.tencent.myLibary.entity.User;

public interface UserUserDaoIfac {

	/**
	 * <p>Title: addUser</p>  
	 * <p>
	 *	Description: 
	 *	添加用户的方法：
	 *	用户注册功能会调用该方法
	 * </p> 
	 * @param user
	 * @return
	 */
	public abstract int addUser(User user);
	
	/**
	 * <p>Title: addUser</p>
	 * <p>
	 *    Description:注册用户调用方法
	 * </p>
	 * <p>Copyright: Copyright (c) 2017</p>
	 * <p>Company: www.baidudu.com</p>
	 * @param userName
	 * @param passWord
	 * @param userType
	 * @return
	 * @author xianxian
	 * @date 2023年2月13日下午5:45:57
	 * @version 1.0
	 */
	public abstract Boolean addUser(String userName,String passWord,Integer userType);

	/**
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
	public abstract User queryUserByNameAndPassword(String username, String password, Integer userType);
	
	/**
	 * <p>Title: queryUserByName</p>
	 * <p>
	 *    Description:根据用户名查询用户是否存在的方法
	 *    注册时会用到 查询结果可判断 用户 是否存在
	 * </p>
	 * <p>Copyright: Copyright (c) 2017</p>
	 * <p>Company: www.baidudu.com</p>
	 * @param username
	 * @return
	 * @author xianxian
	 * @date 2023年2月13日下午4:00:56
	 * @version 1.0
	 */
	public abstract User queryUserByName(String username);
}