package com.tencent.myLibary.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tencent.myLibary.dao.ifac.UserDaoIfac;
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
public class UserDaoImpl implements UserDaoIfac {
	/**根据用户名和密码查询用户的sql */
	private static final String QUERY_USER_BY_NAME_AND_PASSWORD = "select * from myLibary_user "
			+ "where user_name=? and user_password=? and user_type=?";

	/* (non-Javadoc)  
	 * <p>Title: addUser</p>  
	 * <p>
	 *	Description: 
	 * </p> 
	 * @param user
	 * @return  
	 * @see com.tencent.myLibary.dao.impl.UserDaoIfac#addUser(com.tencent.myLibary.entity.User)  
	 */
	@Override
	public int addUser(User user)
	{
		int rows=0;
		
		return rows;
	}
	

	/* (non-Javadoc)  
	 * <p>Title: queryUserByNameAndPassword</p>  
	 * <p>
	 *	Description: 
	 * </p> 
	 * @param username
	 * @param password
	 * @param userType
	 * @return  
	 * @see com.tencent.myLibary.dao.impl.UserDaoIfac#queryUserByNameAndPassword(java.lang.String, java.lang.String, java.lang.Integer)  
	 */
	@Override
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
