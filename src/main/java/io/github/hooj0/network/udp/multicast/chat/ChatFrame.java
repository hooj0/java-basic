package io.github.hooj0.network.udp.multicast.chat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetSocketAddress;


/**
 * 聊天框
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 15:00:46
 */
public class ChatFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextArea showArea = null;
    private JTextArea sendArea = null;
    private JButton send = null;
    private JScrollPane showScr = null;
    private JScrollPane sendScr = null;

    private UserInfo user = null;

    public ChatFrame(LanChatFrame lan, UserInfo user) {
        this.user = user;
        this.setTitle("和" + user.getUserName() + "局域网聊天中");
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
        this.showArea.setText(msg);
    }

    class SendAction implements ActionListener {
        ChatFrame frame = null;

        public SendAction(ChatFrame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            InetSocketAddress dest = (InetSocketAddress) ChatFrame.this.user.getAddress();
            /*在聊友列表中，所有人项的SocketAddress是null*/
            //这表明是向所有人发送消息
            if (dest == null) {
                LoginFrame.comUtil.broadCastMsg(ChatFrame.this.sendArea.getText());
                ChatFrame.this.showArea.setText("您对大家说："
                                                        + ChatFrame.this.sendArea.getText() + "\n" + ChatFrame.this.showArea.getText());
            }
            //向私人发送信息
            else {
                //获取发送消息的目的
                dest = new InetSocketAddress(
                        dest.getHostName(),
                        dest.getPort() + 1);
                LoginFrame.comUtil.singleSendMsg(ChatFrame.this.sendArea.getText(), dest);
                ChatFrame.this.showArea.setText("您对" + ChatFrame.this.user.getUserName() + "说："
                                                        + ChatFrame.this.sendArea.getText() + "\n" + ChatFrame.this.showArea.getText());

            }
            ChatFrame.this.sendArea.setText("");
        }
    }

    public static void main(String[] args) {
        UserInfo u = new UserInfo();
        u.setUserName("aaa");
        new ChatFrame(null, u);
    }
}
