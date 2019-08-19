package com.tencent.myLibary.util;

import java.sql.Connection;

public class TestDBUtils {

	public static void main(String[] args) {
//		new DBUtils();
//		System.out.println(DBUtils.getConnection());
		
		Connection conn = DBUtils.getConnection();
		System.out.println(conn);
	}
}
