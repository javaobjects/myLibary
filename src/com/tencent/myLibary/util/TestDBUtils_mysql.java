package com.tencent.myLibary.util;

import java.sql.Connection;

public class TestDBUtils_mysql {

	public static void main(String[] args) {
		Connection conn = DBUtils_mysql.getConnection();
		System.out.println(conn);
	}
}
