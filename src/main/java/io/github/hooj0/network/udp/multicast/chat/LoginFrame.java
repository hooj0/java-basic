package io.github.hooj0.network.udp.multicast.chat;

import io.github.hooj0.network.udp.multicast.yk.YeekuProtocol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private LanChatFrame lan = null;
	
	private JLabel nameLabel = null;
	private JLabel iconLabel = null;
	private JTextField nameField = null;
	private JComboBox iconBox = null;
	private JButton submit = null;
	private JButton exit = null;
	private JLabel tip = null;
	
	public static ComUtils comUtil = null;
	
	public LoginFrame(LanChatFrame lan, String msg) {
		this.setLayout(null);
		this.setTitle("欢迎聊天");
		
		this.lan = lan;
		
		nameLabel = new JLabel("输入昵称");
		iconLabel = new JLabel("选择图片");
		nameField = new JTextField();
		iconBox = new JComboBox();
		LoadIcon loadIco = new LoadIcon();
		File file = new File("F:\\Example Exercise\\JAVA\\JavaNetBase\\src\\icon");
		List<String> list = new ArrayList<String>();
		loadIco.getFileNames(file, list);
		for (String name : list) {
			if (name.indexOf("all.gif") == -1) {
				iconBox.addItem(name);
			}
		}
		submit = new JButton("Login");
		exit = new JButton("exit");
		
		tip = new JLabel(msg);
		tip.setFont(new Font("Serif" , Font.BOLD , 14));
		
		
		tip.setBounds(45, 10, 250, 25);
		nameLabel.setBounds(25, 40, 60, 25);
		iconLabel.setBounds(25, 90, 60, 25);
		nameField.setBounds(80, 40, 200, 25);
		iconBox.setBounds(80, 90, 200, 25);
		submit.setBounds(70, 135, 80, 25);
		exit.setBounds(170, 135, 80, 25);
		
		exit.addMouseListener(new LoginListener());
		submit.addActionListener(new LoginAction(this));
		
		this.add(tip);
		this.add(submit);
		this.add(exit);
		this.add(nameLabel);
		this.add(iconLabel);
		this.add(nameField);
		this.add(iconBox);
		this.setBounds(400, 200, 330, 205);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	//该方法用于改变登陆窗口最上面的提示信息
	public void setTipMsg(String tip) {
		this.tip.setText(tip);
	}
	
	public UserInfo setUser() {
		return new UserInfo(iconBox.getSelectedItem().toString(), nameField.getText(), null, 0);
	}
	
	public void showFrame() {
		try
		{
			//初始化聊天通信类
			comUtil = new ComUtils(lan);
			final String loginMsg = YeekuProtocol.PRESENCE + nameField.getText()
				+ YeekuProtocol.SPLITTER + iconBox.getSelectedObjects()[0]
				+ YeekuProtocol.PRESENCE;
			comUtil.broadCastMsg(loginMsg);
			//启动定时器每20秒广播一次在线信息
			javax.swing.Timer timer = new javax.swing.Timer(1000 * 10, 
				new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					comUtil.broadCastMsg(loginMsg);
				}
			});
			timer.start();
			this.setVisible(false);
			lan.setVisible(true);
		}
		catch (Exception ex)
		{
			this.setTipMsg("确认30001端口空闲，且网络正常！");
		}
	}
	
	class LoginAction implements ActionListener {
		LoginFrame frame = null;
		public LoginAction(LoginFrame frame) {
			this.frame = frame;
		}
		public void actionPerformed(ActionEvent e) {
			//frame.showFrame();
			try
			{
				//初始化聊天通信类
				comUtil = new ComUtils(lan);
				final String loginMsg = ConstomProtocol.PRESENCE + nameField.getText() 
					+ ConstomProtocol.SPLITTER + iconBox.getSelectedItem()
					+ ConstomProtocol.PRESENCE;
				comUtil.broadCastMsg(loginMsg);
				//启动定时器每20秒广播一次在线信息
				javax.swing.Timer timer = new javax.swing.Timer(1000 * 10, 
					new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						comUtil.broadCastMsg(loginMsg);
					}
				});
				timer.start();
				frame.setVisible(false);
				lan.setVisible(true);
			}
			catch (Exception ex)
			{
				frame.setTipMsg("确认30001端口空闲，且网络正常！");
			}
		}
	}
	
	class LoginListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			System.exit(0);
		}
	}
}
