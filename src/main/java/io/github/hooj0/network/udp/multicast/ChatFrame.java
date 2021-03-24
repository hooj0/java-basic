package io.github.hooj0.network.udp.multicast;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

/**
 * 聊天框
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 14:53:59
 */
public class ChatFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextArea showArea = null;
    private JTextArea sendArea = null;
    private JButton send = null;
    private JScrollPane showScr = null;
    private JScrollPane sendScr = null;

    private final DatagramPacket outPacket;
    private final MulticastSocket socket;

    public ChatFrame(DatagramPacket outPacket, MulticastSocket socket) {
        this.outPacket = outPacket;
        this.socket = socket;
        this.setTitle("局域网聊天中");
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void addString(String msg) {
        this.showArea.setText(this.showArea.getText() + msg);
    }

    public void sendMsg() throws IOException {
        byte[] readBf = this.sendArea.getText().getBytes();
        //设置发送数据数组
        this.outPacket.setData(readBf);
        //发送数据
        this.socket.send(this.outPacket);
    }

    class SendAction implements ActionListener {
        ChatFrame frame = null;

        public SendAction(ChatFrame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ChatFrame.this.sendMsg();
                ChatFrame.this.sendArea.setText("");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
