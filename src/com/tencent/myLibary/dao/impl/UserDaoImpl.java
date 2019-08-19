package com.tencent.myLibary.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tencent.myLibary.entity.User;
import com.tencent.myLibary.util.DBUtils;

/**
 * 
* <p>Title: UserDaoImpl</p>  
* <p>
*	Description: 
*	用户表的数据访问对象类
* </p> 
* @author xianxian 
* @date 2019年8月19日
 */
public class UserDaoImpl {
	/**根据用户名和密码查询用户的sql */
	private static final String QUERY_USER_BY_NAME_AND_PASSWORD = "select * from myLibary_user "
			+ "where user_name=? and user_password=? and user_type=?";

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
	public int addUser(User user)
	{
		int rows=0;
		
		return rows;
	}
	

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
	public User queryUserByNameAndPassword(String username,String password,Integer userType)
	{
		User user=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConnection();
			stmt=conn.prepareStatement(QUERY_USER_BY_NAME_AND_PASSWORD);
			//给占位符赋值
			stmt.setString(1,username);
			stmt.setString(2, password);
			stmt.setInt(3, userType);
			
			rs=stmt.executeQuery();
			
			if(rs.next())
			{
				user=new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserType(rs.getInt("user_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtils.release(conn, stmt, rs);
		}
		return user;
	}
}
