package io.github.hooj0.network.udp.multicast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

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
	
	private DatagramPacket outPacket;
	private MulticastSocket socket;
	public ChatFrame(DatagramPacket outPacket, MulticastSocket socket) {
		this.outPacket = outPacket;
		this.socket = socket;
		this.setTitle("局域网聊天中");
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void addString(String msg) {
		showArea.setText(showArea.getText() + msg);
	}
	
	public void sendMsg() throws IOException {
		byte[] readBf = sendArea.getText().getBytes();
		//设置发送数据数组
		outPacket.setData(readBf);
		//发送数据
		socket.send(outPacket);
	}
	
	class SendAction implements ActionListener {
		ChatFrame frame = null;
		public SendAction(ChatFrame frame) {
			this.frame = frame;
		}
		public void actionPerformed(ActionEvent e) {
			try {
				sendMsg();
				sendArea.setText("");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
