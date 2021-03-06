package com.tencent.myLibary.dao.ifac;

import java.util.List;

import com.tencent.myLibary.entity.Record;
import com.tencent.myLibary.entity.User;

public interface RecordDaoIfac {

	/**
	 * 
	 * <p>Title: returnBook</p>  
	 * <p>
	 *	Description: 
	 *	还书功能
	 * </p> 
	 * @param record_id
	 * @param book_id
	 * @return
	 */
	public boolean returnBook(int record_id,int book_id);
	
	/**
	 * 
	 * <p>Title: queryAllRecord</p>  
	 * <p>
	 *	Description: 
	 *	查询本人的所有借阅记录
	 * </p> 
	 * @param user
	 * @return
	 */
	List<Record> queryAllRecord(User user);

	/**
	 * 
	 * <p>Title: queryAllNotReturnRecord</p>  
	 * <p>
	 *	Description: 
	 *	查询本人的所有未归还借阅记录
	 * </p> 
	 * @param user
	 * @return
	 */
	public abstract List<Record> queryAllNotReturnRecord(User user);

	/**
	 * 
	 * <p>Title: queryAllReturnRecord</p>  
	 * <p>
	 *	Description: 
	 *	查询本人的所有已归还借阅记录
	 * </p> 
	 * @param user
	 * @return
	 */
	public abstract List<Record> queryAllReturnRecord(User user);
}