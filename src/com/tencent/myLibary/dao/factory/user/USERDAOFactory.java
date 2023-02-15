package com.tencent.myLibary.dao.factory.user;

import com.tencent.myLibary.dao.ifac.user.UserBookDaoIfac;
import com.tencent.myLibary.dao.ifac.user.UserRecordDaoIfac;
import com.tencent.myLibary.dao.ifac.user.UserUserDaoIfac;
import com.tencent.myLibary.dao.impl.user.UserBookDaoImpl;
import com.tencent.myLibary.dao.impl.user.UserRecordDaoImpl;
import com.tencent.myLibary.dao.impl.user.UserUserDaoImpl;

/**
 * <p>Title: DAOFactory</p>
 * <p>
 *    Description:
 *    dao的工厂，专门生产各类dao的实例
 * </p>
 * @author xianxian
 * @date 2019年8月20日
 */
public class USERDAOFactory {
	/**
	 * <p>Title: getUserDaoInstance</p>  
	 * <p>
	 *	Description: 
	 *	获取 UserDaoIfac接口实例的方法
	 * </p> 
	 * @return
	 */
	public static UserUserDaoIfac getUserUserDaoInstance() {
		return new UserUserDaoImpl();
	}

	public static UserBookDaoIfac getUserBookDaoInstance() {
		return new UserBookDaoImpl();
	}
	
	public static UserRecordDaoIfac getUserRecordDaoInstance() {
		return new UserRecordDaoImpl();
	}
}
