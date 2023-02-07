package com.tencent.myLibary.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tencent.myLibary.dao.ifac.RecordDaoIfac;
import com.tencent.myLibary.entity.Book;
import com.tencent.myLibary.entity.Record;
import com.tencent.myLibary.entity.User;
import com.tencent.myLibary.util.DBUtils_mysql;

public class RecordDaoImpl implements RecordDaoIfac {

	private static final String QUERY_ALL_RECORD_BY_SELF = "select r.record_id,r.user_id,r.book_id,r.lend_time,r.return_time,"
			+ "b.book_name "
			+ "from myLibary_record r,myLibary_book b where r.book_id=b.book_id and user_id=?";
	
	
	/**
	 * <p>Title: returnBook</p>  
	 * <p>
	 *	Description: 
	 *	还书功能
	 * </p> 
	 * @param record_id
	 * @param book_id
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings("resource")
	public boolean returnBook(int record_id,int book_id,int user_id) {
		Boolean result=false;
		//思路：先设置事务手动提交，查询书的状态，如果可还继续，如果不可还返回；如果可还那么修改借书记录的归还时间，同时修改书的状态为1
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils_mysql.getConnection();
			conn.setAutoCommit(false);
			
			stmt=conn.prepareStatement("select status from myLibary_book where book_id=?");
			stmt.setInt(1,book_id);
			rs=stmt.executeQuery();
			int status=0;
			if(rs.next())
			{
				status=rs.getInt("status");
			}
			//如果不可还返回
			if(status==1)
			{
				return result;
			}else
			{
			//如果可还继续
				//1.修改借书记录的归还时间
				stmt=conn.prepareStatement("update myLibary_record set return_time = sysdate where record_id=?");
				stmt.setInt(1,record_id);
				int rows1=stmt.executeUpdate();
				
				//2.修改书的状态为1
				stmt=conn.prepareStatement("update myLibary_book set status = 1 where book_id=?");
				stmt.setInt(1,book_id);
				int rows2=stmt.executeUpdate();
				
				if(rows1>0 && rows2>0)
				{
					conn.commit();//事务提交
					result=true;//借书成功
				}else
				{
					conn.rollback();//事务回滚
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally
		{
			DBUtils_mysql.release(conn, stmt, rs);
		}
		return result;
	}
	
	/**
	 * (non-Javadoc)  
	 * <p>Title: queryAllRecord</p>  
	 * <p>
	 *	Description: 
	 * </p> 
	 * @param user
	 * @return  
	 * @see com.tencent.myLibary.dao.impl.RecordDaoIfac#queryAllRecord(com.tencent.myLibary.entity.User)  
	 */
	@Override
	public List<Record> queryAllRecord(User user)
	{
		List<Record> records=new ArrayList<>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtils_mysql.getConnection();
			stmt=conn.prepareStatement(QUERY_ALL_RECORD_BY_SELF);
			stmt.setInt(1,user.getUserId());
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				Record record=new Record();
				
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				record.setBook(book);
				User users=new User();
				users.setUserId(rs.getInt("user_id"));
				record.setUser(users);
				record.setLendTime(rs.getDate("lend_time"));
				record.setReturnTime(rs.getDate("return_time"));
				record.setRecordId(rs.getInt("record_id"));
				
				records.add(record);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtils_mysql.release(conn, stmt, rs);
		}
		return records;
	}




	@Override
	public List<Record> queryAllNotReturnRecord(User user) {
		return null;
	}




	@Override
	public List<Record> queryAllReturnRecord(User user) {
		return null;
	}

	@Override
	public boolean returnBook(int record_id, int book_id) {
		return false;
	}
	
	
}
