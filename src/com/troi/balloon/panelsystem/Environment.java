package com.troi.balloon.panelsystem;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Environment extends JPanel {
	
	public Environment() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.paint((Graphics2D)g);
	}
	
	public void paint(Graphics2D render) {
		
	}
}