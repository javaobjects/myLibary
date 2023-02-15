package com.tencent.myLibary.dao.ifac.user;

import java.util.List;
import com.tencent.myLibary.entity.Book;

public interface UserBookDaoIfac {
	/**
	 * 借书的方法
	 * @param book_id
	 * @param user_id
	 * @return
	 */
	public abstract Boolean lendBook(Integer book_id,Integer user_id);

	/**
	 * 3.查看所有图书信息
	 */
	public abstract List<Book> queryAllBooks();

	/**
	 * 4.查看热门图书信息
	 */
	public abstract List<Book> queryHotBooks();

	/**
	 * 5.查看可借图书信息
	 */
	public abstract List<Book> queryCanLendBooks();

	/**
	 * 6.查看图书馆被借走的图书信息
	 */
	public abstract List<Book> queryCanNotLendBooks();

	/**
	 * 查看指定书名的图书信息
	 */
	public abstract List<Book> queryBookByName(String bookName);

	/**
	 * 查看指定编号的图书信息
	 */
	public abstract Book queryBookByBookId(Integer bookId);

}