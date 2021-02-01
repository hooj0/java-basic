package io.github.hooj0.thread;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

public class CBox2 extends Canvas {
	private static final long serialVersionUID = 1L;
	private static final Color[] colors = { 
		Color.black, Color.blue,
		Color.cyan, Color.darkGray, Color.gray, Color.green,
		Color.lightGray, Color.magenta, Color.orange, Color.pink,
		Color.red, Color.white, Color.yellow 
	};
	private Color cColor = newColor();

	private static final Color newColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	void nextColor() {
		cColor = newColor();
		repaint();
	}

	public void paint(Graphics g) {
		g.setColor(cColor);
		Dimension s = getSize();
		g.fillRect(0, 0, s.width, s.height);
	}
}

@SuppressWarnings("unchecked")
class CBoxVector extends Vector implements Runnable {
	private static final long serialVersionUID = 1L;
	private Thread t;
	private int pause;

	public CBoxVector(int pause) {
		this.pause = pause;
		t = new Thread(this);
	}

	public void go() {
		t.start();
	}

	public void run() {
		while (true) {
			int i = (int) (Math.random() * size());
			((CBox2) elementAt(i)).nextColor();
			try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {
			}
		}
	}
}
