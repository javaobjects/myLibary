package com.tencent.myLibary.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.tencent.myLibary.dao.factory.DAOFactory;
import com.tencent.myLibary.dao.ifac.BookDaoIfac;
import com.tencent.myLibary.entity.Book;
import com.tencent.myLibary.entity.User;

public class AdminQueryBookView extends JInternalFrame {
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
		
		/** 添加图书 输入框*/
		private JTextField tx_add_bookName;
		
		/** 查询类型下拉框 */
		private JComboBox<String> cb_query_type;
		/** 查询按钮 */
		private JButton btn_query;
		/** 借书按钮 */
		private JButton btn_lend;
		
		/** 添加图按钮 */
		private JButton btn_add;
		/** 删除按钮 */
		private JButton btn_del;
		/** 修改按钮 */
		private JButton btn_upda;
		
		/** 退出按钮 */
		private JButton btn_exit;
		/** 存放选定图书的id的属性 */
		private Integer book_id=0;
		
		/** 构造方法 */
		public AdminQueryBookView(User user) {
			this.user = user;
			init();
			registerListener();
			this.setTitle("查询图书窗体");
			this.setSize(670, 540);
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
			lb_query_type = new JLabel();
			lb_query_type.setSize(10, 49);
			
			
			//此处还应该添加一个输入框
			tx_add_bookName = new JTextField();
			tx_add_bookName.setText("请输入图书名");
			tx_add_bookName.setForeground(new Color(204,204,204));
			tx_add_bookName.setVisible(false);
			
			cb_query_type = new JComboBox<String>(new String[] { "所有图书", "热门图书",
					"可借图书", "不可借图书","指定图书","添加图书" });
			btn_query = new JButton("查    询");
			btn_lend = new JButton("借    书");
			
			btn_add = new JButton("添    加");
			btn_add.setVisible(false);//默认隐藏
			btn_del = new JButton("删    除");
			btn_upda = new JButton("修    改");
			btn_upda.setVisible(false);
			btn_exit = new JButton("退     出");

			table = new JTable();
			panel_left = new JScrollPane(table);

			//设置行数与列数 以及水平竖直间距
			panel_right = new JPanel(new GridLayout(11, 1, 0, 10));
//			panel_right.setBorder(BorderFactory.createTitledBorder(
//					BorderFactory.createRaisedBevelBorder(), "查询条件"));
			panel_right.add(lb_query_type);
			panel_right.add(tx_add_bookName);
			panel_right.add(cb_query_type);
			panel_right.add(btn_query);
			panel_right.add(btn_lend);
			
			panel_right.add(btn_add);
			panel_right.add(btn_del);
			panel_right.add(btn_upda);
			
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
			
			tx_add_bookName.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					// 当点击输入框时，里面的内容为提示信息时，清空内容，将其字体颜色设置为正常黑色。
					if (tx_add_bookName.getText().equals("请输入图书名")) {
						tx_add_bookName.setText("");
						tx_add_bookName.setForeground(Color.BLACK);
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					// 当失去焦点时，判断是否为空，若为空时，直接显示提示信息，设置颜色
					if (tx_add_bookName.getText().length() < 1) {
						tx_add_bookName.setText("请输入图书名");
						tx_add_bookName.setForeground(new Color(204, 204, 204));
					}
				}
			});
			
			
			cb_query_type.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int cb_q_type = cb_query_type.getSelectedIndex();
					if(cb_q_type == 4 || cb_q_type == 5) {
						//添加图书输入框 显示
						tx_add_bookName.setVisible(true);
						if(cb_q_type == 4) {
							//将添加按钮隐藏
							btn_add.setVisible(false);
						}else {
							//将添加按钮显示
							btn_add.setVisible(true);
						}
					}else {
						//否则隐藏
						tx_add_bookName.setVisible(false);
					}
				}
			});
			
			btn_query.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 1.获取查询类型
					int result = cb_query_type.getSelectedIndex();
					System.out.println(result);
					//2.根据查询类型，去数据库查询，返回图书集合
					List<Book> books=null;
					
					if(result == 4) {
						//添加图书被点击时 显示输入框 执行对应的sql语句
						
					}else {
						//否则隐藏输入框
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
					System.out.println("book_id:" + book_id);
					if (book_id == 0) {
						JOptionPane.showMessageDialog(null, "请先选定图书");
						return;
					}
					boolean result = bookDao.lendBook(book_id, user.getUserId());
					if (result) {
						JOptionPane.showMessageDialog(null, "借书成功");
					} else {
						JOptionPane.showMessageDialog(null, "借书失败");
					}
				}
			});
			
			
			btn_add.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("btn_add");
					
					//添加自己思考一下应该如何去完成
					
				}
			});
			
			btn_del.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("btn_del");
					if (book_id == 0) {
						JOptionPane.showMessageDialog(null, "请先选定图书");
						return;
					}
					//删除的sql语句
					
				}
			});
			
			btn_upda.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("btn_upda");
					if(book_id==0)
					{
						JOptionPane.showMessageDialog(null, "请先选定图书");
						return;
					}
					//更新的sql语句
				}
			});
			
			
			
			btn_exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("333");
					AdminQueryBookView.this.dispose();
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
