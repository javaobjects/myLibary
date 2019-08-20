package com.tencent.myLibary.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tencent.myLibary.dao.ifac.BookDaoIfac;
import com.tencent.myLibary.entity.Book;
import com.tencent.myLibary.util.DBUtils;

/**
 * 
* <p>Title: BookDaoImpl</p>  
* <p>
*	Description: 
*	图书表的数据访问对象类
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
			conn=DBUtils.getConnection();
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
			DBUtils.release(conn, stmt, rs);
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
			conn=DBUtils.getConnection();
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
			DBUtils.release(conn, stmt, rs);
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
			conn=DBUtils.getConnection();
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
			DBUtils.release(conn, stmt, rs);
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
			conn=DBUtils.getConnection();
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
			DBUtils.release(conn, stmt, rs);
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

	@Override
	public Boolean lendBook(Integer book_id, Integer user_id) {
		return null;
	}
}
