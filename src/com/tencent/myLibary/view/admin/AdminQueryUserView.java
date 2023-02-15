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

import com.tencent.myLibary.dao.factory.admin.ADMINDAOFactory;
import com.tencent.myLibary.dao.ifac.admin.AdminUserDaoIfac;
import com.tencent.myLibary.entity.Record;
import com.tencent.myLibary.entity.User;
import com.tencent.myLibary.util.StringUtils_self;

public class AdminQueryUserView extends JInternalFrame {

	//窗体中功能的实现依赖底层的dao，所以属性依赖
	private AdminUserDaoIfac adminUserDao = ADMINDAOFactory.getAdminUserDaoIfac();
	
	
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
	
	/** 查询指定用户 输入框*/
	private JTextField tx_appoint_userName;
	/** 查询类型下拉框 */
	private JComboBox<String> cb_query_type;
	
	/** 查询按钮 */
	private JButton btn_query;
	/** 退出按钮 */
	private JButton btn_exit;
	
	/** 定义全局变量*/
	/** record_id 待还书的记录编号 */
	private int record_id;
	/** book_id 待还书的书的编号*/
	private int book_id;
	/** user_id 用户id */
	private int user_id;
	
	/** 构造方法 */
	public AdminQueryUserView(User user) {
		this.user = user;
		init();
		registerListener();
		this.setTitle("查询用户窗体");
		this.setSize(670, 540);
		// 设置窗体可以关闭
		this.setClosable(true);
		// 设置默认的关闭操作，释放内存空间
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 窗体能否最小化
		this.setIconifiable(true);
		this.setVisible(true);
	}

	
	private void init() {
		lb_query_type = new JLabel();
		lb_query_type.setSize(10, 49);
		
		tx_appoint_userName = new JTextField();
		tx_appoint_userName.setText("请输入用户名");
		tx_appoint_userName.setForeground(new Color(204,204,204));
		tx_appoint_userName.setVisible(false);
		cb_query_type = new JComboBox<String>(new String[] { "所有用户", "指定用户"});
		
		btn_query = new JButton("查    询");
		btn_exit = new JButton("退     出");

		table = new JTable();
		panel_left = new JScrollPane(table);

		//设置行数与列数 以及水平竖直间距
		panel_right = new JPanel(new GridLayout(9, 1, 0, 10));
		panel_right.add(lb_query_type);
		
		panel_right.add(tx_appoint_userName);
		panel_right.add(cb_query_type);
		
		panel_right.add(btn_query);
		
		panel_right.add(new JLabel());
		panel_right.add(new JLabel());
		panel_right.add(new JLabel());
		panel_right.add(new JLabel());
		panel_right.add(btn_exit);

		panel_common = new JPanel(new BorderLayout());
		panel_common.add(panel_left, BorderLayout.CENTER);
		panel_common.add(panel_right, BorderLayout.EAST);

		this.add(panel_common);
	}

	private void registerListener() {
		//面板监听
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
			}
		});
		
		
		tx_appoint_userName.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// 当点击输入框时，里面的内容为提示信息时，清空内容，将其字体颜色设置为正常黑色。
				if (tx_appoint_userName.getText().equals("请输入用户名")) {
					tx_appoint_userName.setText("");
					tx_appoint_userName.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				// 当失去焦点时，判断是否为空，若为空时，直接显示提示信息，设置颜色
				if (tx_appoint_userName.getText().length() < 1) {
					tx_appoint_userName.setText("请输入用户名");
					tx_appoint_userName.setForeground(new Color(204, 204, 204));
				}
			}
		});
		
		//监听状态输入框
		cb_query_type.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cb_query_type.getSelectedIndex() == 1) {
					//tx_appoint_userName 显示
					tx_appoint_userName.setVisible(true);
				}else {
					//tx_appoint_userName 隐藏
					tx_appoint_userName.setVisible(false);
				}
			}
		});
		//查询按钮监听事件
		btn_query.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int typeValue = cb_query_type.getSelectedIndex();
				if(typeValue == 1) {//指定用户
					//若用户不存在给出提示 若用户存在显示结果集
					String txAppointUserName = tx_appoint_userName.getText();
					// 先进行非空判断
					if(StringUtils_self.isNull(txAppointUserName) || txAppointUserName.equals("请输入用户名")) {
						JOptionPane.showMessageDialog(null, "用户名不能为空");
						return;
					}
					List<User> users =  adminUserDao.queryAppointUserByUserName(txAppointUserName);
					if(users.size() == 0) {
						// 弹出提示 无此用户
						JOptionPane.showMessageDialog(null, "没有用户名为： " + txAppointUserName + " 的用户");
					}else {
						//想要把数据显示在面板上的表格控件中，那么一行代码就搞定了。
						AdminUserTableModel dataModel=new AdminUserTableModel(users);
						table.setModel(dataModel);
					}
				}else {//所有用户
					// 直接查询用户表 将用户所有信息都展示出来
					List<User> users =  adminUserDao.queryAllUsers();
					//想要把数据显示在面板上的表格控件中，那么一行代码就搞定了。
					AdminUserTableModel dataModel=new AdminUserTableModel(users);
					table.setModel(dataModel);
				}
			}
		});
		
		btn_exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminQueryUserView.this.dispose();

			}
		});
	}
	
	/**
	 * <p>Title: RecordModel</p>
	 * <p>
	 *    Description:设置列为列的数量设置列的名字为列赋值
	 * </p>
	 * @author xianxian
	 * @date 2023年2月11日下午3:10:13
	 */
	private class AdminUserTableModel implements TableModel
	{
		//模型获取数据
		private List<User> users;
		
		public AdminUserTableModel(List<User> users)
		{
			this.users = users;
		}

		@Override
		public int getRowCount() {
			return users.size();
		}

		/**
		 * (non-Javadoc)
		 * <p>Title: getColumnCount</p>
		 * <p>
		 *    Description:设置列的数量
		 * </p>
		 * <p>Copyright: Copyright (c) 2017</p>
		 * <p>Company: www.baidudu.com</p>
		 * @return
		 * @see javax.swing.table.TableModel#getColumnCount()
		 * @author xianxian
		 * @date 2023年2月11日下午3:18:12
		 * @version 1.0
		 */
		@Override
		public int getColumnCount() {
			return 4;
		}

		/**
		 * (non-Javadoc)
		 * <p>Title: getColumnName</p>
		 * <p>
		 *    Description:设置列名
		 * </p>
		 * <p>Copyright: Copyright (c) 2017</p>
		 * <p>Company: www.baidudu.com</p>
		 * @param columnIndex
		 * @return
		 * @see javax.swing.table.TableModel#getColumnName(int)
		 * @author xianxian
		 * @date 2023年2月15日下午4:13:45
		 * @version 1.0
		 */
		@Override
		public String getColumnName(int columnIndex) {
			if(columnIndex==0)
			{
				return "用户id";
			}else if(columnIndex==1)
			{
				return "用户名称";
			}else if(columnIndex==2)
			{
				return "用户密码";
			}else
			{
				return "是否为管理员";
			}
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			//调用隐藏列方法
			return String.class;//每一列的数据类型
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		/**
		 * (non-Javadoc)
		 * <p>Title: getValueAt</p>
		 * <p>
		 *    Description:
		 *    为列赋值
		 * </p>
		 * <p>Copyright: Copyright (c) 2017</p>
		 * <p>Company: www.baidudu.com</p>
		 * @param rowIndex
		 * @param columnIndex
		 * @return
		 * @see javax.swing.table.TableModel#getValueAt(int, int)
		 * @author xianxian
		 * @date 2023年2月11日下午3:17:19
		 * @version 1.0
		 */
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			//1.首先获取当前行的数据：record
			User user = users.get(rowIndex);// rowIndex从0开始，相当于集合中的元素索引
			if(columnIndex==0)
			{
				return user.getUserId();
			}else if(columnIndex==1)
			{
				return user.getUserName();
			}else if(columnIndex==2)
			{
				return user.getUserPassword();
			}else
			{
				return user.getUserType() == 1 ? "管理员" : "普通用户";
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
