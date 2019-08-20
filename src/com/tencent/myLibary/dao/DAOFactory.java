package com.tencent.myLibary.dao;

import com.tencent.myLibary.dao.ifac.BookDaoIfac;
import com.tencent.myLibary.dao.ifac.RecordDaoIfac;
import com.tencent.myLibary.dao.ifac.UserDaoIfac;
import com.tencent.myLibary.dao.impl.BookDaoImpl;
import com.tencent.myLibary.dao.impl.RecordDaoImpl;
import com.tencent.myLibary.dao.impl.UserDaoImpl;

/**
 * 
* <p>Title: DAOFactory</p>  
* <p>
*	Description: 
*	dao的工厂，专门生产各类dao的实例
* </p> 
* @author xianxian 
* @date 2019年8月20日
 */
public class DAOFactory {

	/**
	 * 
	 * <p>Title: getUserDaoInstance</p>  
	 * <p>
	 *	Description: 
	 *	获取 UserDaoIfac接口实例的方法
	 * </p> 
	 * @return
	 */
	public static UserDaoIfac getUserDaoInstance() {
		return new UserDaoImpl();
	}

	public static BookDaoIfac getBookDaoInstance() {
		return new BookDaoImpl();
	}
	
	public static RecordDaoIfac getRecordDaoInstance() {
		return new RecordDaoImpl();
	}
}
