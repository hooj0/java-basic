package io.github.hooj0.network.udp.multicast.yk;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
//登陆用的对话框
public class LoginFrame extends JDialog
{
	private static final long serialVersionUID = 1L;
	public JLabel tip;
	public JTextField userField = new JTextField("李刚" , 20);
	public JComboBox iconList = new JComboBox(
		new Integer[]{1, 2, 3, 4, 5 , 6, 7, 8 ,9 ,10});
	private JButton loginBn = new JButton("登陆");
	//聊天的主界面
	private LanChat chatFrame;	
	//聊天通信的工具实例
	public static ComUtil comUtil;
	//构造器，用于初始化的登陆对话框
	public LoginFrame(LanChat parent , String msg)
	{
		super(parent , "输入名字后登陆" , true);
		this.chatFrame = parent;
		setLayout(new GridLayout(5, 1));
		JPanel jp = new JPanel();
		tip = new JLabel(msg);
		tip.setFont(new Font("Serif" , Font.BOLD , 16));
		jp.add(tip); 
		add(jp);
		add(getPanel("用户名" , userField));
		iconList.setPreferredSize(new Dimension(224, 20));
		add(getPanel("图    标" , iconList));
		JPanel bp = new JPanel();
		loginBn.addActionListener(new MyActionListener(this));
		bp.add(loginBn); 
		add(bp);
		pack();
		setVisible(true);
	}
	//工具方法，该方法将一个字符串和组件组合成JPanel对象
	private JPanel getPanel(String name , JComponent jf)
	{
		JPanel jp = new JPanel();
		jp.add(new JLabel(name + "："));
		jp.add(jf);
		return jp;
	}
	//该方法用于改变登陆窗口最上面的提示信息
	public void setTipMsg(String tip)
	{
		this.tip.setText(tip);
	}
	//定义一个事件监听器
	class MyActionListener implements ActionListener
	{
		private LoginFrame loginFrame;
		public MyActionListener(LoginFrame loginFrame)
		{
			this.loginFrame = loginFrame;
		}
		//当鼠标单击事件发生时
		public void actionPerformed(ActionEvent evt)
		{
			try
			{
				//初始化聊天通信类
				comUtil = new ComUtil(chatFrame);
				final String loginMsg = YeekuProtocol.PRESENCE + userField.getText() 
					+ YeekuProtocol.SPLITTER + iconList.getSelectedObjects()[0]
					+ YeekuProtocol.PRESENCE;
				comUtil.broadCast(loginMsg);
				//启动定时器每20秒广播一次在线信息
				javax.swing.Timer timer = new javax.swing.Timer(1000 * 10, 
					new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						comUtil.broadCast(loginMsg);
					}
				});
				timer.start();
				loginFrame.setVisible(false);
				chatFrame.setVisible(true);
			}
			catch (Exception ex)
			{
				loginFrame.setTipMsg("确认30001端口空闲，且网络正常！");
			}
		}
	}
}