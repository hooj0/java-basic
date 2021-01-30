package io.github.hooj0.thread.awt;

import java.awt.*;
import java.util.Vector;

/**
 * cbox
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 14:39:09
 */
@SuppressWarnings("ALL")
public class CBox extends Canvas {

    private static final long serialVersionUID = 1L;

    private static final Color[] colors = {
            Color.black, Color.blue,
            Color.cyan, Color.darkGray, Color.gray, Color.green,
            Color.lightGray, Color.magenta, Color.orange, Color.pink,
            Color.red, Color.white, Color.yellow
    };

    private Color cColor = newColor();

    private static Color newColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    void nextColor() {
        this.cColor = newColor();
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(this.cColor);
        Dimension s = this.getSize();
        g.fillRect(0, 0, s.width, s.height);
    }
}

/**
 * cbox向量
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 14:38:52
 */
@SuppressWarnings("ALL")
class CBoxVector extends Vector implements Runnable {

    private static final long serialVersionUID = 1L;
    private final Thread t;
    private final int pause;

    public CBoxVector(int pause) {
        this.pause = pause;
        this.t = new Thread(this);
    }

    public void go() {
        this.t.start();
    }

    @Override
    public void run() {

        while (true) {
            int i = (int) (Math.random() * this.size());
            ((CBox) this.elementAt(i)).nextColor();
            try {
                Thread.sleep(this.pause);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
