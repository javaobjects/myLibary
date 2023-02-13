package com.tencent.myLibary.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	public UserRegisterView() {
		init();
		registerListener(this);
		this.setTitle("注册窗体");// 设置窗体的标题

		this.setSize(400, 300);// 设置窗体的大小

		this.setResizable(false);// 设置窗体大小不变

		this.setLocationRelativeTo(null);// 设置窗体居中显示

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// 退出操作

		this.setVisible(true);// 设置窗体显示出来
	}
	private void registerListener(JFrame jf) {
		btn_confirm_submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("you click submit ");
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
