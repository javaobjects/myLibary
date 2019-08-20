package com.tencent.myLibary.view;

import javax.swing.JInternalFrame;

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
	
	private User user;


	/** 构造方法 */
	public UserQueryBookView(User user) {
		this.user = user;
//		init();
//		registerListener();
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

}
