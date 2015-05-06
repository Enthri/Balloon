package com.troi.balloon.panelsystem;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Panel {
	
	private ArrayList<Button> buttonList;
	private boolean requestedRepaint;
	private Dimension bounds;
	
	public Panel() {
		buttonList = new ArrayList<Button>();
		requestedRepaint = false;
		bounds = new Dimension(100, 500);
	}
	
	public void paint(Graphics2D render) {
		render.fillRect(0, 0, (int)bounds.getWidth(), (int)bounds.getHeight());
		for(Button button : buttonList) {
			button.paint(render);
		}
	}
	
	public void update() {
		for(Button button : buttonList) {
			if(button.needsRepaint()) this.requestRepaint();
		}
	}
	
	public void add(Button button) {
		buttonList.add(button);
		this.requestRepaint();
	}
	
	public void requestRepaint() {
		requestedRepaint = true;
	}
	
	public boolean needsRepaint() {
		return requestedRepaint;
	}
	
	public Dimension getDimension() {
		return bounds;
	}
}