package com.tencent.myLibary.entity;

/**
 * <p>Title: Book</p>
 * <p>
 *	Description: 
 *	实体类还可以命名为domain
 *	书的实体类
 * </p>
 * @author xianxian
 * @date 2019年8月19日
 */
public class Book {

	/**图书的编号 */
	private Integer bookId;
	/**图书名称*/
	private String bookName;
	/**借阅次数*/
	private Integer lendCount;
	/** 是否在馆 0:不在馆   1：在馆 */
	private Integer status;

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", lendCount=" + lendCount + ", status=" + status + "]\n";
	}

	public Book() {
		super();
	}

	public Book(Integer bookId, String bookName, Integer lendCount,
			Integer status) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.lendCount = lendCount;
		this.status = status;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getLendCount() {
		return lendCount;
	}

	public void setLendCount(Integer lendCount) {
		this.lendCount = lendCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
