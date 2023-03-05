package com.tencent.myLibary.dao.impl.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tencent.myLibary.dao.ifac.user.UserUserDaoIfac;
import com.tencent.myLibary.entity.User;
import com.tencent.myLibary.util.DBUtils_mysql;

/**
 * <p>Title: UserDaoImpl</p>
 * <p>
 *    Description:用户表的数据访问对象类
 * </p>
 * @author xianxian
 * @date 2019年8月19日
 */
public class UserUserDaoImpl implements UserUserDaoIfac {
	/**根据用户名和密码查询用户的sql */
	private static final String QUERY_USER_BY_NAME_AND_PASSWORD = "SELECT * FROM myLibary_user "
			+ "WHERE user_name =? AND user_password =? AND user_type =?";
	/**根据用户名查询用户是否存在的sql*/
	private static final String QUERY_USER_BY_NAME = "SELECT * FROM mylibary_user WHERE USER_NAME = ?";
	/**注册新用户 sql语句**/
	private static final String ADD_NEW_USER = "INSERT INTO mylibary_user (USER_ID,USER_NAME,USER_PASSWORD,USER_TYPE)\r\n"
			+ "VALUES\r\n"
			+ "	(null,? ,?,?)";
	
	
	/**
	 * (non-Javadoc)  
	 * <p>Title: addUser</p>  
	 * <p>
	 *	Description: 
	 * </p> 
	 * @param user
	 * @return  
	 * @see com.tencent.myLibary.dao.ifac.user.UserUserDaoIfac#addUser(com.tencent.myLibary.entity.User)  
	 */
	@Override
	public int addUser(User user)
	{
		int rows=0;
		
		return rows;
	}
	
	/**
	 * (non-Javadoc)
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
	 * @see com.tencent.myLibary.dao.ifac.user.UserUserDaoIfac#addUser(java.lang.String, java.lang.String, java.lang.Integer)
	 * @author xianxian
	 * @date 2023年2月13日下午5:46:43
	 * @version 1.0
	 */
	@Override
	public Boolean addUser(String userName, String passWord, Integer userType) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Boolean insertResult = false;
		
		try {
			conn=DBUtils_mysql.getConnection();
			conn.setAutoCommit(false);//更改为手动提交 若无这代码则将报错  Can't call commit when autocommit=true
			stmt=conn.prepareStatement(ADD_NEW_USER);
			//给占位符赋值
			stmt.setString(1,userName);
			stmt.setString(2, passWord);
			stmt.setInt(3, userType);
			
			int inset_rs = stmt.executeUpdate();
			System.out.println("inset_rs," + inset_rs);
			if(inset_rs > 0)
			{
				conn.commit();//事务提交
				insertResult = true;
			}else
			{
				conn.rollback();//事务回滚
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtils_mysql.release(conn, stmt, rs);
		}
		return insertResult;
	}
	
	
	
	/**
	 * (non-Javadoc)  
	 * <p>Title: queryUserByNameAndPassword</p>  
	 * <p>
	 *	Description: 用户登录
	 * </p> 
	 * @param username
	 * @param password
	 * @param userType
	 * @return  
	 * @see com.tencent.myLibary.dao.ifac.user.UserUserDaoIfac#queryUserByNameAndPassword(java.lang.String, java.lang.String, java.lang.Integer)  
	 */
	@Override
	public User queryUserByNameAndPassword(String username,String password,Integer userType)
	{
		User user = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtils_mysql.getConnection();
			stmt = conn.prepareStatement(QUERY_USER_BY_NAME_AND_PASSWORD);
			// 给占位符赋值
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setInt(3, userType);

			rs = stmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserType(rs.getInt("user_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils_mysql.release(conn, stmt, rs);
		}
		return user;
	}
	
	/**
	 * (non-Javadoc)
	 * <p>Title: queryUserByName</p>
	 * <p>
	 *    Description:根据用户名查询用户是否存在
	 * </p>
	 * <p>Copyright: Copyright (c) 2017</p>
	 * <p>Company: www.baidudu.com</p>
	 * @param username
	 * @return
	 * @see com.tencent.myLibary.dao.ifac.user.UserUserDaoIfac#queryUserByName(java.lang.String)
	 * @author xianxian
	 * @date 2023年2月13日下午4:05:48
	 * @version 1.0
	 */
	@Override
	public User queryUserByName(String username) {
		User user = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils_mysql.getConnection();
			stmt = conn.prepareStatement(QUERY_USER_BY_NAME);
			// 给占位符赋值
			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserType(rs.getInt("user_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils_mysql.release(conn, stmt, rs);
		}
		return user;
	}
	
}
