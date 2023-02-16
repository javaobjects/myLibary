package com.tencent.myLibary.dao.ifac.admin;

import java.util.List;

import com.tencent.myLibary.entity.Record;

/**
 * <p>Title: AdminRecordDaoIfac</p>
 * <p>
 *    Description:管理员查询借阅记录接口
 * </p>
 * @author xianxian
 * @date 2023年2月15日下午5:22:49
 */
public interface AdminRecordDaoIfac {
	
	/**1. 查询 所有用户 借阅记录 */
	public abstract List<Record> queryAllUsersRecord();
	/**2. 查询 所有用户 未还记录 */
	public abstract List<Record> queryAllUsersNotReturnRecord();
	/**3. 查询 所有用户 已还记录 */
	public abstract List<Record> queryAllUsersAlreadyReturnRecord();
	/**4. 查询 当前用户 借阅记录 */
	public abstract List<Record> queryCurrentUsersRecord(Integer userId);
	/**5. 查询 当前用户 未还记录 */
	public abstract List<Record> queryCurrentUsersNotReturnRecord(Integer userId);
	/**6. 查询 当前用户 已还记录 */
	public abstract List<Record> queryCurrentUsersAlreadyReturnRecord(Integer userId);
	/**7. 查询 指定用户 借阅记录 */
	public abstract List<Record> queryAppointUsersRecord(Integer userId);
	/**8. 查询 指定用户 未还记录 */
	public abstract List<Record> queryAppointUsersNotReturnRecord(Integer userId);
	/**9. 查询 指定用户 已还记录 */
	public abstract List<Record> queryAppointUsersAlreadyReturnRecord(Integer userId);
}
