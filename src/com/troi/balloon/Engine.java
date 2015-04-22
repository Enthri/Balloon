package com.troi.balloon;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Engine {
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test");
		frame.setContentPane(new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				Graphics2D render = (Graphics2D) g;
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
		JTextArea area = new JTextArea(50, 50);
		frame.add(area);
		frame.setVisible(true);
	}
}