package com.troi.balloon.panelsystem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Environment extends JPanel {
	
	private ArrayList<Panel> panelList;
	
	public Environment() {
		panelList = new ArrayList<Panel>();
		this.add(new Panel());
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.paint((Graphics2D)g);
	}
	
	private void paint(Graphics2D render) {
		AffineTransform oldTransform = render.getTransform();
		for(Panel panel : panelList) {
			panel.paint(render);
			render.translate(panel.getDimension().getWidth(), 0);
		}
		render.setTransform(oldTransform);
	}
	
	public void update() {
		for(Panel panel : panelList) {
			if(panel.getDimension().getHeight() != this.getHeight()) {
				panel.getDimension().setSize(panel.getDimension().getWidth(), this.getHeight());
				panel.requestRepaint();
			}
			panel.update();
			if(panel.needsRepaint()) this.repaint();
		}
	}
	
	public void add(Panel panel) {
		panelList.add(panel);
		this.repaint();
	}
}