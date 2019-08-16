package com.tencent.myLibary.view;

import javax.swing.JFrame;

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

	/**
	 * 初始化窗体的方法
	 */
	public void init()
	{
		this.setTitle("用户登录窗体");//设置窗体的标题
		this.setSize(400,400);//设置窗体的大小
		this.setLocationRelativeTo(null);//居中
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭窗体时结束进程
		this.setVisible(true);//让窗体可见
	}
	
	public UserLoginView() {
		init();
	}
}
