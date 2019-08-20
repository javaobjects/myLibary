package com.tencent.myLibary.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tencent.myLibary.dao.ifac.RecordDaoIfac;
import com.tencent.myLibary.entity.Book;
import com.tencent.myLibary.entity.Record;
import com.tencent.myLibary.entity.User;
import com.tencent.myLibary.util.DBUtils;

public class RecordDaoImpl implements RecordDaoIfac {

	private static final String QUERY_ALL_RECORD_BY_SELF = "select r.record_id,r.user_id,r.book_id,r.lend_time,r.return_time,"
			+ "b.book_name "
			+ "from myLibary_record r,myLibary_book b where r.book_id=b.book_id and user_id=?";
	
	
	
	
	/* (non-Javadoc)  
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
			conn=DBUtils.getConnection();
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
			DBUtils.release(conn, stmt, rs);
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
	
	
}
