package io.github.hooj0.network.udp.multicast.chart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录框
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 14:58:44
 */
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

	    this.nameLabel = new JLabel("输入昵称");
	    this.iconLabel = new JLabel("选择图片");
	    this.nameField = new JTextField();
	    this.iconBox = new JComboBox();
        LoadIcon loadIco = new LoadIcon();
        File file = new File("F:\\Example Exercise\\JAVA\\JavaNetBase\\src\\icon");
        List<String> list = new ArrayList<>();
        loadIco.getFileNames(file, list);
        for (String name : list) {
            if (name.indexOf("all.gif") == -1) {
	            this.iconBox.addItem(name);
            }
        }
	    this.submit = new JButton("Login");
	    this.exit = new JButton("exit");

	    this.nameLabel.setBounds(25, 30, 60, 25);
	    this.iconLabel.setBounds(25, 80, 60, 25);
	    this.nameField.setBounds(80, 30, 200, 25);
	    this.iconBox.setBounds(80, 80, 200, 25);
	    this.submit.setBounds(70, 125, 80, 25);
	    this.exit.setBounds(170, 125, 80, 25);

	    this.exit.addMouseListener(new LoginListener());
	    this.submit.addActionListener(new LoginAction(this));

        this.add(this.submit);
        this.add(this.exit);
        this.add(this.nameLabel);
        this.add(this.iconLabel);
        this.add(this.nameField);
        this.add(this.iconBox);
        this.setBounds(400, 200, 330, 205);
        this.setResizable(false);
        this.setVisible(true);
    }

    public UserInfo setUser() {
        return new UserInfo(this.iconBox.getSelectedItem().toString(), this.nameField.getText(), null, 0);
    }

    public void showFrame() {
        this.lan.setVisible(true);
        this.setVisible(false);

        this.lan.addUser(this.setUser());
        System.out.println("共" + this.lan.getUserNum() + "人在线！");
    }

    class LoginAction implements ActionListener {
        LoginFrame frame = null;

        public LoginAction(LoginFrame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
	        this.frame.showFrame();
        }
    }

    class LoginListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.exit(0);
        }
    }
}
