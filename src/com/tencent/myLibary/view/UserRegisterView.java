package com.tencent.myLibary.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tencent.myLibary.dao.factory.DAOFactory;
import com.tencent.myLibary.entity.User;
import com.tencent.myLibary.util.StringUtils_self;

/**
 * 用户注册窗体
 */
public class UserRegisterView extends JFrame {

	/** 大容器 */
	private JPanel panel_common;

	/** 子容器一 */
	private JPanel panel_top;

	/** 子容器二 */
	private JPanel panel_name;
	/** 子容器三 */
	private JPanel panel_password;
	/** 子容器四 */
	private JPanel panel_confirm_password;
	/** 子容器五 */
	private JPanel panel_btn;
	/** 名字标签 */
	private JLabel lbl_name;
	/** 名字输入框 */
	private JTextField txt_name;
	/** 密码锁标签 */
	private JLabel lbl_password;
	/** 密码输入框 */
	private JTextField txt_password;
	/** 确认密码标签 */
	private JLabel lbl_confirm_password;
	/** 确认密码输入框 */
	private JTextField txt_confirm_password;
	/** 退出按钮 */
	private JButton btn_exit;
	/** 确认提交按钮 */
	private JButton btn_confirm_submit;

	private void init() {
		//初始化
		panel_common = new JPanel(new GridLayout(5, 1,0,10));
		panel_top = new JPanel();
		panel_name = new JPanel(new GridLayout(1, 2));
		panel_password = new JPanel(new GridLayout(1, 2));
		panel_confirm_password = new JPanel(new GridLayout(1, 2));
		panel_btn = new JPanel(new GridLayout(1, 2));
		
		lbl_name=new JLabel("    用    户    姓     名：      ", JLabel.RIGHT);
		txt_name=new JTextField(20);
		lbl_password=new JLabel("密码：", JLabel.RIGHT);
		txt_password=new JTextField(20);
		lbl_confirm_password=new JLabel("确认密码：", JLabel.RIGHT);;
		txt_confirm_password=new JTextField(20);
		btn_exit=new JButton("退出");
		btn_confirm_submit=new JButton("确认提交");
		
		//拼装
		panel_top.add(new JLabel());//占位
		panel_name.add(lbl_name);
		panel_name.add(txt_name);
		
		panel_password.add(lbl_password);
		panel_password.add(txt_password);
		
		panel_confirm_password.add(lbl_confirm_password);
		panel_confirm_password.add(txt_confirm_password);
		
		panel_btn.add(btn_exit);
		panel_btn.add(btn_confirm_submit);
		
		panel_common.add(panel_top);
		panel_common.add(panel_name);
		panel_common.add(panel_password);
		panel_common.add(panel_confirm_password);
		panel_common.add(panel_btn);
		
		this.add(panel_common);
	}
	//type 为用户注册是 选择的 普通用户2 还是管理员用户1
	public UserRegisterView(int type) {
		init();
		registerListener(this,type);
		System.out.println("type: " + type);
		this.setTitle("注册窗体");// 设置窗体的标题

		this.setSize(400, 300);// 设置窗体的大小

		this.setResizable(false);// 设置窗体大小不变

		this.setLocationRelativeTo(null);// 设置窗体居中显示

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// 退出操作

		this.setVisible(true);// 设置窗体显示出来
	}
	private void registerListener(JFrame jf,Integer type) {
		btn_confirm_submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取值
				String userName = txt_name.getText(),
						passWord = txt_password.getText(),
						confirmPassWord = txt_confirm_password.getText();
				//1. 用户名 非空判断
				if(StringUtils_self.isNull(userName)) {
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					return;
				}
				//2. 用户名特殊符号判断 限定只能用字母或数字组合 或纯字母 
				if(StringUtils_self.isSpecialChar(userName)) {
					JOptionPane.showMessageDialog(null, "用户名不能包含特殊字符");
					return;
				}
				//3. 用户名不能包含汉字
				if(StringUtils_self.isChineseChar(userName)) {
					JOptionPane.showMessageDialog(null, "用户名不能包含汉字");
					return;
				}
				//4. 密码首位必须为字母
				if(!StringUtils_self.firstWordIsLetter(userName)) {
					JOptionPane.showMessageDialog(null, "用户名必须以字母开头");
					return;
				}
				//5. 用户名长度判断
				if(userName.length() > 8) {
					JOptionPane.showMessageDialog(null, "用户名长度不能超过8位");
					return;
				}
				//6. 密码不能为空
				if(StringUtils_self.isNull(passWord)) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
					return;
				}
				//7. 密码特殊字符判断
				if(StringUtils_self.isSpecialChar(passWord)) {
					JOptionPane.showMessageDialog(null, "密码不能包含特殊字符");
					return;
				}

				//8. 密码长度判断
				if(passWord.length() > 8 || passWord.length() < 6) {
					JOptionPane.showMessageDialog(null, "密码长度为6到8位");
					return;
				}
				//9. 两次密码是否一致判断
				if(!passWord.equals(confirmPassWord)) {
					JOptionPane.showMessageDialog(null, "两次密码不一致!");
					return;
				}
				//10、 以上若都通过则查询用户数据表 是否用户名复复 判断
				User user = DAOFactory.getUserDaoInstance().queryUserByName(userName);
				if(user != null) {
					JOptionPane.showMessageDialog(null, "用户名已存在");
					return;
				}
				//11. 以上若都通过则插入数据
				if(!DAOFactory.getUserDaoInstance().addUser(userName, passWord, type)) {
					JOptionPane.showMessageDialog(null, "注册失败，请稍后再试！");
					return;
				}else {
					JOptionPane.showMessageDialog(null, "注册成功，请退出登录!");
					return;
				}
			}
		});
		//点击退出按钮关闭当前页面回到注册登录页面
		btn_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				new UserLoginView();
			}
		});
	}
}
