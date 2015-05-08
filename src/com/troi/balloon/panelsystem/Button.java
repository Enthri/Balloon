package com.troi.balloon.panelsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

public class Button {
	
	private boolean requestedRepaint = false;
	private Dimension bounds;
	
	public Button() {
		bounds = new Dimension(100, 50);
	}

	public void paint(Graphics2D render) {
		render.fillRect(0, 0, (int)bounds.getWidth(), (int)bounds.getHeight());
	}
	
	public void update() {
		
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