package com.tencent.myLibary.entity;

import java.util.Date;

/**
 * 
* <p>Title: Record</p>  
* <p>
*	Description: 
*	实体类还可以命名为domain
*	借书记录实体类
* </p> 
* @author xianxian 
* @date 2019年8月19日
 */
public class Record {
	
	private Integer recordId;
	private User user;
	private Book book;
	private Date lendTime;
	private Date returnTime;
	
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getLendTime() {
		return lendTime;
	}
	public void setLendTime(Date lendTime) {
		this.lendTime = lendTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public Record(Integer recordId, User user, Book book, Date lendTime,
			Date returnTime) {
		super();
		this.recordId = recordId;
		this.user = user;
		this.book = book;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
	}
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Record [recordId=" + recordId + ", user=" + user + ", book="
				+ book + ", lendTime=" + lendTime + ", returnTime="
				+ returnTime + "]";
	}	
	
	
	
}
