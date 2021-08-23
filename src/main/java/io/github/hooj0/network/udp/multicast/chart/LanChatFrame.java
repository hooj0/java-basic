package io.github.hooj0.network.udp.multicast.chart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.text.DateFormat;
import java.util.Date;

/**
 * 局域网聊天框
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 14:57:47
 */
public class LanChatFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private final DefaultListModel listModel = new DefaultListModel();
    private final JList friendsList = new JList(this.listModel);

    private final DateFormat formatter = DateFormat.getDateTimeInstance();

    private final ComUtils util = null;

    public LanChatFrame() throws IOException, InterruptedException {
        super("聊天系统");

        //util = new ComUtils(this);
	    this.friendsList.setCellRenderer(new ImageCellReader());
	    this.listModel.addElement(new UserInfo("all.gif", "所有人", null, -2000));
	    this.friendsList.addMouseListener(new ChangeMouseListener(this));
	    this.add(new JScrollPane(this.friendsList));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setBounds(2, 2, 160, 600);
    }

    public void addUser(UserInfo user) {
	    this.listModel.addElement(user);
    }

    public void removeUser(int pos) {
	    this.listModel.removeElementAt(pos);
    }

    public int getUserNum() {
        return this.listModel.size();
    }

    public UserInfo getUserBySocketAddress(SocketAddress address) {
        for (int i = 0; i < this.getUserNum(); i++) {
            UserInfo user = this.getUser(i);
            if (user.getAddress() != null && user.getAddress().equals(address)) {
                return user;
            }
        }
        return null;
    }

    public UserInfo getUser(int pos) {
        return (UserInfo) this.listModel.elementAt(pos);
    }

    /***
     * 处理网络中的数据报，通过聊天信息得到聊天者，并将信息显示在对话画框中
     * @author hoojo
     * @createDate Sep 23, 2010 9:12:28 PM
     * @param packet
     * @param single
     */
    public void processMsg(DatagramPacket packet, boolean single) {
        //获取该数据报中SocketAddress
        InetSocketAddress address = (InetSocketAddress) packet.getSocketAddress();
        //如果是私聊，则当前Packet中获取的DatagramSocket的地址、端口-1才是MulticastSocket的地址
        if (single) {
            address = new InetSocketAddress(address.getHostName(), address.getPort() - 1);
        }
        UserInfo user = this.getUserBySocketAddress(address);
        if (user != null) {
            UserInfo userInfo = single ? user : this.getUser(0);
            //如果窗口位null，就显示
            if (userInfo.getChatFrame() == null) {
                userInfo.setChatFrame(new ChatFrame(this, userInfo));
            }
            //提示信息
            String tip = single ? "对你说：" : "对大家说：";
            userInfo.getChatFrame().addString(user.getUserName() + tip + "###########" + this.formatter.format(new Date()) + "\n" + new String(packet.getData(), 0, packet.getLength()) + "\n");
            if (!userInfo.getChatFrame().isShowing()) {
                userInfo.getChatFrame().setVisible(true);
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        LanChatFrame lcf = new LanChatFrame();
        new LoginFrame(lcf);
    }

    class ChangeMouseListener extends MouseAdapter {
        private LanChatFrame frame = null;

        public ChangeMouseListener(LanChatFrame frame) {
            this.frame = frame;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() >= 2) {
                UserInfo userInfo = (UserInfo) LanChatFrame.this.friendsList.getSelectedValue();
                if (userInfo.getChatFrame() == null) {
                    userInfo.setChatFrame(new ChatFrame(this.frame, userInfo));
                }
                if (!userInfo.getChatFrame().isShowing()) {
                    userInfo.getChatFrame().setVisible(true);
                }
            }
        }
    }

    class ImageCellReader extends JPanel implements ListCellRenderer {
        private static final long serialVersionUID = 1L;
        private ImageIcon icon;
        private String name;
        private Color background;
        //绘制单元格的前景色
        private Color foreground;

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected, boolean cellHostFocus) {
            UserInfo userInfo = (UserInfo) value;
	        this.icon = new ImageIcon("F:/Example Exercise/JAVA/JavaNetBase/src/icon/" + userInfo.getIcon());

	        this.name = userInfo.getUserName();
	        this.background = isSelected ? list.getSelectionBackground() : list.getBackground();
	        this.foreground = isSelected ? list.getSelectionForeground() : list.getForeground();
            return this;
        }

        @Override
        public void paintComponent(Graphics g) {
            int imageWidth = this.icon.getImage().getWidth(null);
            int imageHeight = this.icon.getImage().getHeight(null);
            g.setColor(this.background);

            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(this.foreground);
            //绘制图片
            g.drawImage(this.icon.getImage(), this.getWidth() / 2 - imageWidth / 2, 5, null);
            g.setFont(new Font("SansSerif", Font.BOLD, 18));
            //绘制用户名
            g.drawString(this.name, this.getWidth() / 2 - this.name.length() * 10, imageHeight + 30);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(60, 115);
        }
    }
}
