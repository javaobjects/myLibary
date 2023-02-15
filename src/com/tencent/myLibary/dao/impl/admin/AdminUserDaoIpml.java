package com.tencent.myLibary.dao.impl.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tencent.myLibary.dao.ifac.admin.AdminUserDaoIfac;
import com.tencent.myLibary.entity.User;
import com.tencent.myLibary.util.DBUtils_mysql;

public class AdminUserDaoIpml implements AdminUserDaoIfac {

	//查询所有 用户 sql 语句
	private static final String QUERY_ALL_USER = "SELECT USER_ID,USER_NAME,USER_PASSWORD,USER_TYPE FROM mylibary_user";
	
	//查询指定用户 sql 语句
	private static final String QUERY_APPOINT_USER_BY_USERNAME = "SELECT USER_ID,USER_NAME,USER_PASSWORD,USER_TYPE FROM mylibary_user WHERE USER_NAME = ?";
	
	
	
	/**
	 * (non-Javadoc)
	 * <p>Title: queryAllUsers</p>
	 * <p>
	 *    Description:查询所有用户
	 * </p>
	 * <p>Copyright: Copyright (c) 2017</p>
	 * <p>Company: www.baidudu.com</p>
	 * @return
	 * @see com.tencent.myLibary.dao.ifac.admin.AdminUserDaoIfac#queryAllUsers()
	 * @author xianxian
	 * @date 2023年2月15日下午3:28:01
	 * @version 1.0
	 */
	@Override
	public List<User> queryAllUsers() {
		List<User> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils_mysql.getConnection();
			stmt = conn.prepareStatement(QUERY_ALL_USER);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				User user=new User();
				user.setUserId(rs.getInt("USER_ID"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setUserPassword(rs.getString("USER_PASSWORD"));
				user.setUserType(rs.getInt("USER_TYPE"));
				list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtils_mysql.release(conn, stmt, rs);
		}
		return list;
	}


	@Override
	public List<User> queryAppointUserByUserName(String userName) {
		List<User> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils_mysql.getConnection();
			stmt = conn.prepareStatement(QUERY_APPOINT_USER_BY_USERNAME);
			stmt.setString(1, userName);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				User user=new User();
				user.setUserId(rs.getInt("USER_ID"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setUserPassword(rs.getString("USER_PASSWORD"));
				user.setUserType(rs.getInt("USER_TYPE"));
				list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtils_mysql.release(conn, stmt, rs);
		}
		return list;
	}
}
