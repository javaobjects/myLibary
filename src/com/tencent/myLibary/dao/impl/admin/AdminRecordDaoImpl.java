package com.tencent.myLibary.dao.impl.admin;

import java.util.List;

import com.tencent.myLibary.dao.ifac.admin.AdminRecordDaoIfac;
import com.tencent.myLibary.entity.Record;

public class AdminRecordDaoImpl implements AdminRecordDaoIfac {

	/**1. 查询 所有用户 借阅记录 sql语句 */
	private static final String QUERY_ALL_USER_RECORD = "";
	                             
	/**2. 查询 所有用户 未还记录 sql语句 */
	private static final String QUERY_ALL_USER_NO_RETURN_RECORD = "";
	                             
	/**3. 查询 所有用户 已还记录 sql语句 */
	private static final String QUERY_ALL_USER_ALREADY_RETURN_RECORD = "";
	                             
	/**4. 查询 当前用户 借阅记录 sql语句 */
	private static final String QUERY_CURRENT_USER_RECORD = "";
	                             
	/**5. 查询 当前用户 未还记录 sql语句 */
	private static final String QUERY_CURRENT_USER_NO_RETURN_RECORD = "";
	                             
	/**6. 查询 当前用户 已还记录 sql语句 */
	private static final String QUERY_CURRENT_USER_ALREADY_RETURN_RECORD = "";
	                             
	/**7. 查询 指定用户 借阅记录 sql语句 */
	private static final String QUERY_APPOINT_USER_RECORD = "";
	                             
	/**8. 查询 指定用户 未还记录 sql语句 */
	private static final String QUERY_APPOINT_USER_NO_RETURN_RECORD = "";
	                             
	/**9. 查询 指定用户 已还记录 sql语句 */
	private static final String QUERY_APPOINT_USER_ALREADY_RETURN_RECORD = "";

	@Override
	public List<Record> queryAllUsersRecord() {
		return null;
	}

	@Override
	public List<Record> queryAllUsersNotReturnRecord() {
		return null;
	}

	@Override
	public List<Record> queryAllUsersAlreadyReturnRecord() {
		return null;
	}

	@Override
	public List<Record> queryCurrentUsersRecord(String userId) {
		return null;
	}

	@Override
	public List<Record> queryCurrentUsersNotReturnRecord(String userId) {
		return null;
	}

	@Override
	public List<Record> queryCurrentUsersAlreadyReturnRecord(String userId) {
		return null;
	}

	@Override
	public List<Record> queryAppointUsersRecord(String userId) {
		return null;
	}

	@Override
	public List<Record> queryAppointUsersNotReturnRecord(String userId) {
		return null;
	}

	@Override
	public List<Record> queryAppointUsersAlreadyReturnRecord(String userId) {
		return null;
	}

	
}
