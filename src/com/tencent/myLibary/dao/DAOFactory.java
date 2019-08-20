package com.tencent.myLibary.dao;

import com.tencent.myLibary.dao.ifac.UserDaoIfac;
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
}
