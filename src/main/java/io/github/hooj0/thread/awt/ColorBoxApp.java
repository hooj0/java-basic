package io.github.hooj0.thread.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 颜色盒子
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 14:39:28
 */
@SuppressWarnings("ALL")
public class ColorBoxApp extends Frame {

    private static final long serialVersionUID = 1L;
    private final CBoxVector[] v;

    @SuppressWarnings("unchecked")
    public ColorBoxApp(int pause, int grid) {

        this.setTitle("Color Box App");
        this.setLayout(new GridLayout(grid, grid));
        this.v = new CBoxVector[grid];

        for (int i = 0; i < grid; i++) {
            this.v[i] = new CBoxVector(pause);
        }

        for (int i = 0; i < grid * grid; i++) {
            this.v[i % grid].addElement(new CBox());
            this.add((CBox) this.v[i % grid].lastElement());
        }

        for (int i = 0; i < grid; i++) {
            this.v[i].go();
        }

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        // Shorter default pause than ColorBoxApp:
        int pause = 5;
        int grid = 8;
        if (args.length > 0) {
            pause = Integer.parseInt(args[0]);
        }

        if (args.length > 1) {
            grid = Integer.parseInt(args[1]);
        }

        Frame f = new ColorBoxApp(pause, grid);
        f.setSize(500, 400);
        f.setVisible(true);
    }
}
