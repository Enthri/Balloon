package com.troi.balloon.panelsystem;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Panel {
	
	private ArrayList<Button> buttonList;
	private boolean requestedRepaint;
	private Dimension bounds;
	
	public Panel() {
		buttonList = new ArrayList<Button>();
		requestedRepaint = false;
		bounds = new Dimension(100, 100);
	}
	
	public void paint(Graphics2D render) {
		render.fillRect(0, 0, (int)bounds.getWidth(), (int)bounds.getHeight());
		render.setColor(render.getColor().darker());
		AffineTransform oldTransform = render.getTransform();
		for(Button button : buttonList) {
			button.paint(render);
			render.translate(0, button.getDimension().getHeight());
		}
		render.setTransform(oldTransform);
	}
	
	public void update() {
		for(Button button : buttonList) {
			if(button.getDimension().getWidth() != getDimension().getWidth()) {
				button.getDimension().setSize(getDimension().getWidth(), button.getDimension().getHeight());
				button.requestRepaint();
			}
			button.update();
			if(button.checkRepaint()) this.requestRepaint();
		}
	}
	
	public void add(Button button) {
		buttonList.add(button);
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
	
	public Dimension getDimension() {
		return bounds;
	}
}