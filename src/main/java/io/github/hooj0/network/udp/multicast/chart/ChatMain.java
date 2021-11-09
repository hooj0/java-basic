package io.github.hooj0.network.udp.multicast.chart;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * 聊天主函数
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 14:55:46
 */
public class ChatMain {

    boolean packFrame = false;

    /**
     * Construct and show the application.
     *
     * @throws InterruptedException
     * @throws IOException
     */
    public ChatMain() throws IOException, InterruptedException {
        //LoginFrame frame = new LoginFrame(new LanChatFrame());
        LanChatFrame frame = new LanChatFrame();
        new LoginFrame(frame);
        // Validate frames that have preset sizes
        // Pack frames that have useful preferred size info, e.g. from their layout
        if (this.packFrame) {
            frame.pack();
        } else {
            frame.validate();
        }

        // Center the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                try {
                    new ChatMain();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}