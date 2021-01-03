package io.github.hooj0.network.udp.multicast.chart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JTextArea showArea = null;
	private JTextArea sendArea = null;
	private JButton send = null;
	private JScrollPane showScr = null;
	private JScrollPane sendScr = null;
	
	private UserInfo user = null;
	private ComUtils util = null;
	
	public ChatFrame(LanChatFrame lan, UserInfo user) {
		/*try {
			this.util = new ComUtils(lan);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.user = user;*/
		//this.setTitle("和"+ user.getUserName() + "局域网聊天中");
		this.setLayout(null);
		
		showArea = new JTextArea();
		showArea.setLineWrap(true);
		showArea.setEditable(false);
		showScr = new JScrollPane(showArea);
		showScr.setBounds(5, 5, 450, 260);
		this.add(showScr);
		
		sendArea = new JTextArea();
		sendArea.setLineWrap(true);
		sendScr = new JScrollPane(sendArea);
		
		sendScr.setBounds(5, 270, 360, 80);
		this.add(sendScr);
		
		send = new JButton("发送");
		send.setBounds(374, 270, 80, 80);
		send.addActionListener(new SendAction(this));
		this.add(send);
		
		this.setBounds(400, 200, 465, 385);
		this.setResizable(false);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setVisible(true);
	}
	
	public void addString(String msg) {
		showArea.setText(showArea.getText() + msg);
	}
	
	class SendAction implements ActionListener {
		ChatFrame frame = null;
		public SendAction(ChatFrame frame) {
			this.frame = frame;
		}
		public void actionPerformed(ActionEvent e) {
			if ("所有人".equals(user.getUserName())) {
				util.broadCastMsg(sendArea.getText());
			} else {
				String sendMsg = ConstomProtocol.PRESENCE + user.getIcon() + ConstomProtocol.SPLITTER + user.getUserName() + ConstomProtocol.PRESENCE;
				util.singleSendMsg(sendMsg, user.getAddress());
			}
		}
	}
	
	public static void main(String[] args) {
		UserInfo u = new UserInfo();
		u.setUserName("aaa");
		new ChatFrame(null, u);
	}
}
