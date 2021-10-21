package io.github.hooj0.network.udp.multicast.chat;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

public class LanChatFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private DefaultListModel listModel = new DefaultListModel();
	private JList friendsList = new JList(listModel);
	
	private DateFormat formatter = DateFormat.getDateTimeInstance();
	
	public LanChatFrame() throws IOException, InterruptedException {
		super("聊天系统");

		friendsList.setCellRenderer(new ImageCellReader());
		listModel.addElement(new UserInfo("all.gif", "所有人", null, -2000));
		friendsList.addMouseListener(new ChangeMouseListener());
		add(new JScrollPane(friendsList));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2, 2, 160, 600);
	}
	
	public void addUser(UserInfo user) {
		listModel.addElement(user);
	}
	
	public void removeUser(int pos) {
		listModel.removeElementAt(pos);
	}
	
	public int getUserNum() {
		return listModel.size();
	}
	
	public UserInfo getUserBySocketAddress(SocketAddress address) {
		for (int i = 0; i < getUserNum(); i++) {
			UserInfo user = getUser(i);
			if (user.getAddress() != null && user.getAddress().equals(address)) {
				return user;
			}
		}
		return null;
	}
	
	public UserInfo getUser(int pos) {
		return (UserInfo) listModel.elementAt(pos);
	}
	
	/***
	 * <b>function:</b>处理网络中的数据报，通过聊天信息得到聊天者，并将信息显示在对话画框中
	 * @author hoojo
	 * @createDate Sep 23, 2010 9:12:28 PM
	 * @param packet
	 * @param single
	 */
	public void proccessMsg(DatagramPacket packet, boolean single) {
		//获取该数据报中SocketAddress
		InetSocketAddress address = (InetSocketAddress) packet.getSocketAddress();
		//如果是私聊，则当前Packet中获取的DatagramSocket的地址、端口-1才是MulticastSocket的地址
		if (single) {
			address = new InetSocketAddress(address.getHostName(), address.getPort() - 1);
		}
		UserInfo user = getUserBySocketAddress(address);
		if (user != null) {
			UserInfo userInfo = single ? user : getUser(0);
			//如果窗口位null，就显示
			if (userInfo.getChatFrame() == null) {
				userInfo.setChatFrame(new ChatFrame(null, userInfo));
			}
			//提示信息
			String tip = single ? "对你说：" : "对大家说：";
			userInfo.getChatFrame().addString(user.getUserName() + tip + "###########" + formatter.format(new Date()) + "\n" + new String(packet.getData(), 0, packet.getLength()) + "\n");
			if (!userInfo.getChatFrame().isShowing()) {
				userInfo.getChatFrame().setVisible(true);
			}
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		LanChatFrame lcf = new LanChatFrame();
		new LoginFrame(lcf, "请输入昵称、选择个人聊天图片");
	}
	
	class ChangeMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() >= 2) {
				UserInfo userInfo = (UserInfo) friendsList.getSelectedValue(); 
				if (userInfo.getChatFrame() == null) {
					userInfo.setChatFrame(new ChatFrame(null, userInfo));
				}
				if (!userInfo.getChatFrame().isShowing()) {
					userInfo.getChatFrame().setVisible(true);
				}
			}
		}
	}
	
	class ImageCellReader extends JPanel implements ListCellRenderer{
		private static final long serialVersionUID = 1L;
		private ImageIcon icon;
		private String name;
		private Color background;
		//绘制单元格的前景色
		private Color foreground;
		
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHostFocus) {
			UserInfo userInfo = (UserInfo) value;
			icon = new ImageIcon("F:/Example Exercise/JAVA/JavaNetBase/src/icon/" + userInfo.getIcon());
			
			name = userInfo.getUserName();
			background = isSelected ? list.getSelectionBackground() : list.getBackground();
			foreground = isSelected ? list.getSelectionForeground() : list.getForeground();
			return this;
		}
		
		public void paintComponent(Graphics g) {
			int imageWidth = icon.getImage().getWidth(null);
			int imageHeight = icon.getImage().getHeight(null);
			g.setColor(background);
			
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(foreground);
			//绘制图片
			g.drawImage(icon.getImage(), this.getWidth() / 2 - imageWidth / 2, 5, null);
			g.setFont(new Font("SansSerif", Font.BOLD, 18));
			//绘制用户名
			g.drawString(name, this.getWidth() / 2 - name.length() * 10, imageHeight + 30);
		}
		
		public Dimension getPreferredSize() {
			return new Dimension(60, 115);
		}
	}
}
