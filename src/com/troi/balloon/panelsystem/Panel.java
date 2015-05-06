package com.troi.balloon.panelsystem;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Panel {
	
	private ArrayList<Button> buttonList = new ArrayList<Button>();
	private boolean requestedRepaint = false;
	
	public void paint(Graphics2D render) {
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