package com.troi.balloon.panelsystem;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Panel {
	
	private ArrayList<Button> buttonList;
	private boolean requestedRepaint;
	private Rectangle bounds;
	
	public Panel() {
		buttonList = new ArrayList<Button>();
		requestedRepaint = false;
		bounds = new Rectangle(0, 0, 20, 20);
	}
	
	public void paint(Graphics2D render) {
		render.fill(bounds);
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
}