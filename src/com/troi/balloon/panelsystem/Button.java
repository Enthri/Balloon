package com.troi.balloon.panelsystem;

import java.awt.Graphics2D;

public class Button {
	
	private boolean requestedRepaint = false;
	
	public void update() {
		
	}

	public void paint(Graphics2D render) {
		
	}
	
	public void requestRepaint() {
		requestedRepaint = true;
	}
	
	public boolean needsRepaint() {
		return requestedRepaint;
	}
}