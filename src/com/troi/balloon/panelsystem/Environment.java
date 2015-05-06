package com.troi.balloon.panelsystem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Environment extends JPanel {
	
	protected ArrayList<Panel> panelList = new ArrayList<Panel>();
	
	public Environment() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.paint((Graphics2D)g);
	}
	
	private void paint(Graphics2D render) {
		for(Panel panel : panelList) {
			panel.paint(render);
		}
	}
}