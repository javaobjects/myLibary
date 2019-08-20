package com.tencent.myLibary.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.tencent.myLibary.dao.DAOFactory;
import com.tencent.myLibary.dao.ifac.BookDaoIfac;
import com.tencent.myLibary.entity.Book;
import com.tencent.myLibary.entity.User;

/**
 * 
* <p>Title: UserQueryBookView</p>  
* <p>
*	Description: 
*	图书查询窗体是一个嵌入式窗体，所以父亲是JInternalFrame
* </p> 
* @author xianxian 
* @date 2019年8月20日
 */
public class UserQueryBookView extends JInternalFrame {
	
	//窗体中功能的实现依赖底层的dao，所以属性依赖
	private BookDaoIfac bookDao = DAOFactory.getBookDaoInstance();
	
	private User user;

	/** 窗体中的最外层的面板 */
	private JPanel panel_common;
	/** 左面板 */
	private JScrollPane panel_left;
	/** 右面板 */
	private JPanel panel_right;
	/** 存放数据的表格控件 */
	private JTable table;
	/** 查询类型标签 */
	private JLabel lb_query_type;
	/** 查询类型下拉框 */
	private JComboBox<String> cb_query_type;
	/** 查询按钮 */
	private JButton btn_query;
	/** 借书按钮 */
	private JButton btn_lend;
	/** 退出按钮 */
	private JButton btn_exit;
	/** 存放选定图书的id的属性 */
	private Integer book_id=0;
	
	/** 构造方法 */
	public UserQueryBookView(User user) {
		this.user = user;
		init();
		registerListener();
		this.setTitle("用户查询图书窗体");
		this.setSize(600, 500);
		// 设置窗体可以关闭
		this.setClosable(true);
		// 设置默认的关闭操作，释放内存空间
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 窗体能否最小化
		this.setIconifiable(true);
		this.setVisible(true);

	}
	/** 初始化组件装配组件的方法 */
	private void init() {
		lb_query_type = new JLabel("查询类型：");
		cb_query_type = new JComboBox<String>(new String[] { "所有图书", "热门图书",
				"可借图书", "不可借图书" });
		btn_query = new JButton("查    询");
		btn_lend = new JButton("借    书");
		btn_exit = new JButton("退     出");

		table = new JTable();
		panel_left = new JScrollPane(table);

		panel_right = new JPanel(new GridLayout(7, 1, 0, 20));
		panel_right.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createRaisedBevelBorder(), "查询条件"));
		panel_right.add(lb_query_type);
		panel_right.add(cb_query_type);
		panel_right.add(btn_query);
		panel_right.add(btn_lend);
		panel_right.add(new JLabel());
		panel_right.add(new JLabel());
		panel_right.add(btn_exit);

		panel_common = new JPanel(new BorderLayout());
		panel_common.add(panel_left, BorderLayout.CENTER);
		panel_common.add(panel_right, BorderLayout.EAST);

		this.add(panel_common);
	}
	
	private void registerListener() {
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("鼠标点击了行");
				int selectedRowIndex=table.getSelectedRow();
				book_id=(Integer)table.getValueAt(selectedRowIndex, 0);
				System.out.println(book_id);
			}
		});
		btn_query.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("111");
				// 1.获取查询类型
				int result = cb_query_type.getSelectedIndex();
				//2.根据查询类型，去数据库查询，返回图书集合
				List<Book> books=null;
				switch (result) {
				case 0:
					books=bookDao.queryAllBooks();
					break;
				case 1:
					books=bookDao.queryHotBooks();
					break;
				case 2:
					books=bookDao.queryCanLendBooks();
					break;
				case 3:
					books=bookDao.queryCanNotLendBooks();
					break;

				default:
					break;
				}
				
				System.out.println(books.toString());
				//想要把数据显示在面板上的表格控件中，那么一行代码就搞定了。
				BookTableModel dataModel=new BookTableModel(books);
				table.setModel(dataModel);
				//重新查询数据后将以前选定的图书id设为0
				book_id=0;
			}
		});
		btn_lend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("222");
				/*
				 * 完成借书功能：思路：
				 * 1.获取选定的图书
				 *    要有判断，非空判断，不可借图书的选定判断(因为书的状态一直在变，所以不在这里判断)
				 * 2.调用底层dao完成借书
				 * 	  注意：添加一条借书记录   同时修改图书状态为不在馆  两个更新确保在同一个事务当中
				 * 3.根据返回结果提示用户借书成功或者失败
				 *   JOptionPane技术
				 */
				System.out.println("book_id:"+book_id);
				if(book_id==0)
				{
					JOptionPane.showMessageDialog(null, "请先选定图书");
					return;
				}
				boolean result=bookDao.lendBook(book_id,user.getUserId());
				if(result)
				{
					JOptionPane.showMessageDialog(null, "借书成功");
				}else
				{
					JOptionPane.showMessageDialog(null, "借书失败");
				}
			}
		});
		btn_exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("333");
			}
		});
	}
	
	//定义显示图书数据的表格模型，也是一个内部类
	private class BookTableModel implements TableModel
	{
		private List<Book> books;
		
		public BookTableModel(List<Book> books)
		{
			this.books=books;
		}

		@Override//1
		public int getRowCount() {
			return books.size();
		}

		@Override//2
		public int getColumnCount() {
			return 4;//可以写死
		}

		@Override//3
		public String getColumnName(int columnIndex) {
			if(columnIndex==0)
			{
				return "图书编号";
			}else if(columnIndex==1)
			{
				return "图书名称";
			}else if(columnIndex==2)
			{
				return "借阅次数";
			}else 
			{
				return "是否可借";
			}
			
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return String.class;
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		@Override//4
		public Object getValueAt(int rowIndex, int columnIndex) {
			//首先获取该行对应的图书信息
			Book book=books.get(rowIndex);
			if(columnIndex==0)
			{
				return book.getBookId();
			}else if(columnIndex==1)
			{
				return book.getBookName();
			}else if(columnIndex==2)
			{
				return book.getLendCount();
			}else
			{
				return book.getStatus()==0?"不可借":"可借";
			}
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			
		}

		@Override
		public void addTableModelListener(TableModelListener l) {
			
		}

		@Override
		public void removeTableModelListener(TableModelListener l) {
			
		}
		
	}
	
}
