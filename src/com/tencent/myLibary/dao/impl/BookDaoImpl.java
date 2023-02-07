package com.tencent.myLibary.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tencent.myLibary.dao.ifac.BookDaoIfac;
import com.tencent.myLibary.entity.Book;
import com.tencent.myLibary.util.DBUtils_mysql;

/**
 * <p>Title: BookDaoImpl</p>
 * <p>
 *    Description:图书表的数据访问对象类
 * </p>
 * @author xianxian
 * @date 2019年8月19日
 */
public class BookDaoImpl implements BookDaoIfac {
	/** 查询所有图书的sql语句 */
	private static final String QUERY_ALL_BOOKS="select book_id,book_name,lend_count,status from myLibary_book";
	/** 查看热门图书信息 */
	private static final String QUERY_HOT_BOOKS="select b.* "
			+ "from (select book_id,book_name,lend_count,status from myLibary_book order by lend_count desc) b"
			+ " where rownum<=5";
	/** 查询可借图书 */
	private static final String QUERY_CAN_LEND_BOOKS = "select book_id,book_name,lend_count,status from myLibary_book"
			+ " where status=1";
	/** 查询不可借图书*/
	private static final String QUERY_NOT_LEND_BOOKS = "select book_id,book_name,lend_count,status from myLibary_book"
			+ " where status=0";
	
	/**
	 * 5.添加图书
	 */
	/**
	 * 6.删除图书
	 */
	/**
	 * 7.修改图书
	 */
	@SuppressWarnings("resource")
	public Boolean lendBook(Integer book_id,Integer user_id)
	{
		Boolean result=false;
		//思路：先设置事务手动提交，查询书的状态，如果可借继续，如果不可借返回；如果可借那么插入一条借书记录，同时修改书的状态为0
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils_mysql.getConnection();
			conn.setAutoCommit(false);
			
			stmt=conn.prepareStatement("select status from myLibary_book where book_id=?");
			stmt.setInt(1,book_id);
			rs = stmt.executeQuery();
			int status = 0;
			if(rs.next())
			{
				status=rs.getInt("status");
			}
			//如果不可借返回
			if(status==0)
			{
				return result;
			}else
			{
			//如果可借继续
				//1.插入一条借书记录
				stmt = conn.prepareStatement("insert into myLibary_record (record_id,book_id,user_id,lend_time) "
						+ "values(seq_myLibary_record_id.nextval,?,?,sysdate)");
				stmt.setInt(1,book_id);
				stmt.setInt(2,user_id);
				int rows_insert=stmt.executeUpdate();
				
				//2.修改书的状态为0
				stmt = conn.prepareStatement("update myLibary_book set status=0,lend_count = lend_count + 1 where book_id=?");
				stmt.setInt(1,book_id);
				int rows_update=stmt.executeUpdate();
				
				if(rows_insert>0 && rows_update>0)
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
	 * 3.查看所有图书信息
	 */
	public List<Book> queryAllBooks()
	{
		List<Book> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtils_mysql.getConnection();
			stmt=conn.prepareStatement(QUERY_ALL_BOOKS);
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setLendCount(rs.getInt("lend_count"));
				book.setStatus(rs.getInt("status"));
				
				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtils_mysql.release(conn, stmt, rs);
		}
		return list;
	}
	
	/**
	 * 4.查看热门图书信息
	 */
	public List<Book> queryHotBooks()
	{
		List<Book> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtils_mysql.getConnection();
			stmt=conn.prepareStatement(QUERY_HOT_BOOKS);
			
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setLendCount(rs.getInt("lend_count"));
				book.setStatus(rs.getInt("status"));
				
				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtils_mysql.release(conn, stmt, rs);
		}
		return list;
	}
	/**
	 * 5.查看可借图书信息
	 */
	public List<Book> queryCanLendBooks()
	{
		List<Book> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtils_mysql.getConnection();
			stmt=conn.prepareStatement(QUERY_CAN_LEND_BOOKS);
			
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setLendCount(rs.getInt("lend_count"));
				book.setStatus(rs.getInt("status"));
				
				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtils_mysql.release(conn, stmt, rs);
		}
		return list;
	}
	
	/**
	 * 6.查看图书馆被借走的图书信息
	 */
	public List<Book> queryCanNotLendBooks()
	{
		List<Book> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtils_mysql.getConnection();
			stmt=conn.prepareStatement(QUERY_NOT_LEND_BOOKS);
			
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setLendCount(rs.getInt("lend_count"));
				book.setStatus(rs.getInt("status"));
				
				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtils_mysql.release(conn, stmt, rs);
		}
		return list;
	}
	
	/**
	 * 查看指定书名的图书信息
	 */
	public List<Book> queryBookByName(String bookName)
	{//需要模糊查询
		List<Book> list=new ArrayList<>();
		
		return list;
	}

	
	/**
	 * 查看指定编号的图书信息
	 */
	public Book queryBookByBookId(Integer bookId)
	{
		Book book=null;
		
		return book;
	}

//	@Override
//	public Boolean lendBook(Integer book_id, Integer user_id) {
//		return null;
//	}
}
