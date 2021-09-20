package io.github.hooj0.network.udp.multicast.chart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 聊天框
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 14:54:58
 */
public class ChatFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextArea showArea = null;
    private JTextArea sendArea = null;
    private JButton send = null;
    private JScrollPane showScr = null;
    private JScrollPane sendScr = null;

    private final UserInfo user = null;
    private final ComUtils util = null;

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

        this.showArea = new JTextArea();
        this.showArea.setLineWrap(true);
        this.showArea.setEditable(false);
        this.showScr = new JScrollPane(this.showArea);
        this.showScr.setBounds(5, 5, 450, 260);
        this.add(this.showScr);

        this.sendArea = new JTextArea();
        this.sendArea.setLineWrap(true);
        this.sendScr = new JScrollPane(this.sendArea);

        this.sendScr.setBounds(5, 270, 360, 80);
        this.add(this.sendScr);

        this.send = new JButton("发送");
        this.send.setBounds(374, 270, 80, 80);
        this.send.addActionListener(new SendAction(this));
        this.add(this.send);

        this.setBounds(400, 200, 465, 385);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setVisible(true);
    }

    public void addString(String msg) {
        this.showArea.setText(this.showArea.getText() + msg);
    }

    class SendAction implements ActionListener {
        ChatFrame frame = null;

        public SendAction(ChatFrame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("所有人".equals(ChatFrame.this.user.getUserName())) {
                ChatFrame.this.util.broadCastMsg(ChatFrame.this.sendArea.getText());
            } else {
                String sendMsg = CustomProtocol.PRESENCE + ChatFrame.this.user.getIcon() + CustomProtocol.SPLITTER + ChatFrame.this.user.getUserName() + CustomProtocol.PRESENCE;
                ChatFrame.this.util.singleSendMsg(sendMsg, ChatFrame.this.user.getAddress());
            }
        }
    }

    public static void main(String[] args) {
        UserInfo u = new UserInfo();
        u.setUserName("aaa");
        new ChatFrame(null, u);
    }
}
