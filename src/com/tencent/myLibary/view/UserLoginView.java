package com.tencent.myLibary.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tencent.myLibary.dao.DAOFactory;
import com.tencent.myLibary.dao.ifac.UserDaoIfac;
import com.tencent.myLibary.entity.User;

/**
 * 
* <p>Title: UserLoginView</p>  
* <p>
*	Description: 
*	用户登录窗体
* </p> 
* @author xianxian 
* @date 2019年8月16日
 */
public class UserLoginView extends JFrame{
	//大到窗体中的窗口，小到各个组件如标签等，都定义成窗体的属性
	private JPanel panel_common;//最底层的公共窗口
	private JPanel panel_left;//存放图片的面板
	private JPanel panel_right;//右面板

	private JLabel lab_image;//存放图片的标签
	private JLabel lab_username;//用户姓名标签
	private JLabel lab_password;//密码标签
	private JLabel lab_type;//用户类型标签
	
	private JTextField txt_username;//用户姓名文本框
	private JTextField txt_password;//密码文本框
	private JComboBox<String> cb_type;//类型选择下拉框
	
	private JButton btn_login;//登录按钮
	private JButton btn_register;//注册按钮
	
	/**
	 * 窗口属性依赖UserDaoIfac接口
	 */
	private UserDaoIfac userDao = DAOFactory.getUserDaoInstance();//声明依赖并初始化，避免空指针异常
	
	/**
	 * 给所有按钮注册侦听器的方法
	 */
	private void registetActionListener()
	{
		btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("你点击了登录按钮");
				/*
				 * 点击登录按钮的目的：登录，来到主窗体
				 */
				//1.获取用户名和密码，还有用户类型
				String username=txt_username.getText();
				String password=txt_password.getText();
				//String type=(String)cb_type.getSelectedItem();
				//System.out.println("username:"+username);
				//System.out.println("password:"+password);
				int type=cb_type.getSelectedIndex();
				int user_type=(type==0)?1:2;//1 是管理员   2是普通用户
				
				//2.对数据进行非空判断
				if(username==null||"".equals(username.trim())||password==null||"".equals(password.trim()))
				{
					JOptionPane.showMessageDialog(null, "用户名或者密码为空，请重新输入");
					return;
				}
				
				//3.判断用户是否存在,下面的代码是把两行代码合成一行，这样执行效率高，拿的工资高
				User user=userDao.queryUserByNameAndPassword(username, password,user_type);
//				UserDaoIfac dao=new UserDaoImpl();
//				User user=dao.queryUserByNameAndPassword(username, password, user_type);
				
				if(user==null)
				{
					JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重新输入");
					return;
				}
				
				//4.判断用户类型：如果是普通用户则弹出用户主窗体，如果是管理员，则弹出管理员主窗体
				if(user.getUserType()==1)
				{
					System.out.println("弹出管理员主窗体");
					
					//new AdminMainView();
					
				}else
				{
					System.out.println("弹出用户主窗体");
					
					new UserMainView(user);
					UserLoginView.this.dispose();//释放窗体占用的内存资源
				}
				
				
				System.out.println("9999999999999999");
			}
		});
		btn_register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("你点击了注册按钮");
			}
		});
	}

	
	
	/**
	 * 初始化窗体的方法
	 */
	public void init()
	{
		//1.把组件全部都实例化
		panel_common = new JPanel();//实例化最底层的公共容器
		panel_left = new JPanel();//实例化存放图片的面板
		panel_right = new JPanel(new GridLayout(4,2));//实例化右边的面板 并传参 4行2列
		
		Icon image = new ImageIcon("config\\images\\login.png");//实例化一个图片 里面参数为图片的路径
		lab_image = new JLabel(image);//图片块
		lab_username = new JLabel("用户姓名");//用户模块
		lab_password = new JLabel("密       码");//密码块
		lab_type = new JLabel("类       型");//类型块
		
		txt_password = new JTextField();//用户名输入文本框
		txt_username = new JTextField();//密码文本输入框
		cb_type = new JComboBox<String>(new String[] {"管理员","普通用户"});//下拉框
		
		btn_login = new JButton("登录");//登录按钮
		btn_register = new JButton("注册");//注册按钮
		//2.把组件拼装起来
		panel_left.add(lab_image);//存入图片
		panel_common.add(panel_left);//将左存放
		
		panel_right.add(lab_username);//先添加用户文字
		panel_right.add(txt_username);//再添加用户输入框
		panel_right.add(lab_password);//添加密码文字
		panel_right.add(txt_password);//再添加密码输入框
		panel_right.add(lab_type);//添加类型文字
		panel_right.add(cb_type);//再添加类型输入框
		panel_right.add(btn_login);//添加登陆按钮
		panel_right.add(btn_register);//添加注册按钮
		
		panel_common.add(panel_right);//将右侧的容器全部存入进总 容器
		panel_right.setSize(180, 210);
		//3.把所有组件放入窗体中
		this.add(panel_common);//将总容器全部存入进容器JFrame
		
		
		this.setTitle("用户登录窗体");//设置窗体的标题
		this.setSize(380,210);//设置窗体的大小
		this.setResizable(false);//不能收缩
		this.setLocationRelativeTo(null);//居中
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭窗体时结束进程
		this.setVisible(true);//让窗体可见
	}
	
	public UserLoginView() {
		init();
		registetActionListener();
	}
}
