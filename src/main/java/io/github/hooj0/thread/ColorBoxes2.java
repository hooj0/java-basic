package io.github.hooj0.thread;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ColorBoxes2 extends Frame {
	private static final long serialVersionUID = 1L;
	private CBoxVector[] v;

	@SuppressWarnings("unchecked")
	public ColorBoxes2(int pause, int grid) {
		setTitle("ColorBoxes2");
		setLayout(new GridLayout(grid, grid));
		v = new CBoxVector[grid];
		for (int i = 0; i < grid; i++)
			v[i] = new CBoxVector(pause);
		for (int i = 0; i < grid * grid; i++) {
			v[i % grid].addElement(new CBox2());
			add((CBox2) v[i % grid].lastElement());
		}
		for (int i = 0; i < grid; i++)
			v[i].go();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		// Shorter default pause than ColorBoxes:
		int pause = 5;
		int grid = 8;
		if (args.length > 0)
			pause = Integer.parseInt(args[0]);
		if (args.length > 1)
			grid = Integer.parseInt(args[1]);
		Frame f = new ColorBoxes2(pause, grid);
		f.setSize(500, 400);
		f.setVisible(true);
	}
}
