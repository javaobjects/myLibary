package com.tencent.myLibary.dao.ifac.admin;

import java.util.List;

import com.tencent.myLibary.entity.Book;

/**
 * <p>Title: AdminBookDaoIfac</p>
 * <p>
 *    Description:管理员查询书籍接口
 * </p>
 * @author xianxian
 * @date 2023年2月15日下午5:21:52
 */
public interface AdminBookDaoIfac {

	/** 查询指定图书 */
	public abstract List<Book> queryAppointBookByBookName(String bookName);
	
	/** 添加图书 */
	public abstract Boolean addBookBybookName(String bookName);
}
