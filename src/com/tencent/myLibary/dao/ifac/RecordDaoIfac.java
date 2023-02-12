package com.tencent.myLibary.dao.ifac;

import java.util.List;

import com.tencent.myLibary.entity.Record;
import com.tencent.myLibary.entity.User;

public interface RecordDaoIfac {
	
	/**
	 * <p>Title: returnBook</p>
	 * <p>
	 *    Description:
	 * </p>
	 * <p>Copyright: Copyright (c) 2017</p>
	 * <p>Company: www.baidudu.com</p>
	 * @param record_id
	 * @param book_id
	 * @param user_id
	 * @return
	 * @author xianxian
	 * @date 2023年2月12日下午3:41:33
	 * @version 1.0
	 */
	public abstract boolean returnBook(int record_id, int book_id, int user_id);
	
	/**
	 * (non-Javadoc)
	 * <p>Title: returnBook</p>
	 * <p>
	 *    Description:不需要传用户id的还书功能
	 * </p>
	 * <p>Copyright: Copyright (c) 2017</p>
	 * <p>Company: www.baidudu.com</p>
	 * @param record_id
	 * @param book_id
	 * @return
	 * @see com.tencent.myLibary.dao.ifac.RecordDaoIfac#returnBook(int, int)
	 * @author xianxian
	 * @date 2023年2月10日上午10:07:36
	 * @version 1.0
	 */
	public abstract boolean returnBook(int record_id, int book_id);
	
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