package com.tencent.myLibary.test;

import java.sql.Connection;

import com.tencent.myLibary.util.DBUtils_oracle;

public class TestDBUtils_oracle {

	public static void main(String[] args) {
//		new DBUtils();
//		System.out.println(DBUtils.getConnection());
		
		Connection conn = DBUtils_oracle.getConnection();
		System.out.println(conn);
	}
}
