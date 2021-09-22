package io.github.hooj0.network.udp.multicast.chart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private LanChatFrame lan = null;
	
	private JLabel nameLabel = null;
	private JLabel iconLabel = null;
	private JTextField nameField = null;
	private JComboBox iconBox = null;
	private JButton submit = null;
	private JButton exit = null;
	
	public LoginFrame(LanChatFrame lan) {
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
		
		nameLabel.setBounds(25, 30, 60, 25);
		iconLabel.setBounds(25, 80, 60, 25);
		nameField.setBounds(80, 30, 200, 25);
		iconBox.setBounds(80, 80, 200, 25);
		submit.setBounds(70, 125, 80, 25);
		exit.setBounds(170, 125, 80, 25);
		
		exit.addMouseListener(new LoginListener());
		submit.addActionListener(new LoginAction(this));
		
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
	
	public UserInfo setUser() {
		return new UserInfo(iconBox.getSelectedItem().toString(), nameField.getText(), null, 0);
	}
	
	public void showFrame() {
		this.lan.setVisible(true);
		this.setVisible(false);
		
		this.lan.addUser(setUser());
		System.out.println("共" + this.lan.getUserNum() + "人在线！");
	}
	
	class LoginAction implements ActionListener {
		LoginFrame frame = null;
		public LoginAction(LoginFrame frame) {
			this.frame = frame;
		}
		public void actionPerformed(ActionEvent e) {
			frame.showFrame();
		}
	}
	
	class LoginListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			System.exit(0);
		}
	}
}
