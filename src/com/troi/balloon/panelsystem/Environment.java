package com.troi.balloon.panelsystem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Environment extends JPanel {
	
	private ArrayList<Panel> panelList;
	private boolean requestedRepaint;
	
	public Environment() {
		panelList = new ArrayList<Panel>();
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
		for(int i = 0; i < panelList.size(); i++) {
			Panel panel = panelList.get(i);
			if(panel.getDimension().getHeight() != this.getHeight()) {
				panel.getDimension().setSize(panel.getDimension().getWidth(), this.getHeight());
				panel.requestRepaint();
			}
			if(i == panelList.size() - 1 && panel.getDimension().getWidth() + (i * 100) != this.getWidth()) {
				panel.getDimension().setSize(this.getWidth() - (i * 100), panel.getDimension().getHeight());
				panel.requestRepaint();
			} else if(i < panelList.size() - 1 && panel.getDimension().getWidth() != 100) {
				panel.getDimension().setSize(100, panel.getDimension().getHeight());
				panel.requestRepaint();
			}
			panel.update();
			if(panel.checkRepaint()) this.repaint();
		}
		if(this.checkRepaint()) this.repaint();
	}
	
	public void add(Panel panel) {
		panelList.add(panel);
		this.requestRepaint();
	}
	
	public void requestRepaint() {
		requestedRepaint = true;
	}
	
	public boolean checkRepaint() {
		if(requestedRepaint) {
			requestedRepaint = false;
			return true;
		} else return false;
	}
}