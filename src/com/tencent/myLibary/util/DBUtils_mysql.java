package com.tencent.myLibary.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
* <p>Title: DBUtils_mysql</p>  
* <p>
*	Description: 
*   连接mysql数据库的工具类，参数化配置
* </p> 
* @author xianxian 
* @date 2019年9月21日
 */
public class DBUtils_mysql {

	private static String driverName;
	private static String url;
	private static String username;
	private static String password;
	
	static
	{
		InputStream in = DBUtils.class.getClassLoader().
				getResourceAsStream("mysql_jdbc.properties");
		Properties prop = new Properties();
		
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driverName = prop.getProperty("jdbc_driver");
		url = prop.getProperty("jdbc_url");
		username = prop.getProperty("jdbc_username");
		password = prop.getProperty("jdbc_password");
	}
	
	
	/**
	 * 
	 * <p>Title: getConnection</p>  
	 * <p>
	 *	Description: 
	 *  获取连接对象的方法
	 * </p> 
	 * @return
	 */
	public static Connection getConnection()
	{
		Connection conn=null;
		try {
			Class.forName(driverName);
			conn=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 
	 * <p>Title: release</p>  
	 * <p>
	 *	Description: 
	 *  释放资源的方法
	 * </p> 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Connection conn = DBUtils.getConnection();
		System.out.println(conn);
	}
}
