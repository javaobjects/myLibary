package com.tencent.myLibary.dao.impl.admin;

import java.util.List;

import com.tencent.myLibary.dao.ifac.admin.AdminBookDaoIfac;
import com.tencent.myLibary.entity.Book;

public class AdminBookDaoImpl implements AdminBookDaoIfac {

	// 查询 指定图书的 sql 语句
	private static final String QUERY_APPOINT_BOOK_BY_BOOKNAME = "";
	// 通过 图书名 添加 图书 sql 语句
	private static final String ADD_BOOK_BY_BOOKNAME = "";
	
	
	@Override
	public List<Book> queryAppointBookByBookName(String bookName) {
		return null;
	}

	@Override
	public Boolean addBookBybookName(String bookName) {
		return null;
	}
	
}
