package com.troi.balloon;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Balloon implements Runnable {
	
	private JFrame frame;
	
	public static void main(String[] args) {
		(new Thread(new Balloon())).start();
	}

	@Override
	public void run() {
		frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
		frame.setVisible(true);
	}
}