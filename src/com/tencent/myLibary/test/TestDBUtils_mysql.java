package com.tencent.myLibary.test;

import java.sql.Connection;

import com.tencent.myLibary.util.DBUtils_mysql;

public class TestDBUtils_mysql {

	public static void main(String[] args) {
		Connection conn = DBUtils_mysql.getConnection();
		System.out.println("mysql:" + conn);
	}
}
