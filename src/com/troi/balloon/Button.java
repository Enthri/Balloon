package com.troi.balloon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import util.panelDimension;

public class Button {

	private panelDimension dimension;
	private BufferedImage button;
	private Panel panel;
	private Color customColor = new Color(10, 15, 55, 150);
	//Troi's
	private boolean requestedRepaint;
	
	public void requestRepaint() {
		requestedRepaint = true;
	}
	
	public boolean checkRepaint() {
		if(requestedRepaint) {
			requestedRepaint = false;
			return true;
		} else return false;
	}
	
	public void update() {
		
	}
	//End Troi's
	
	public Button(Panel p){
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
		panel = p;
	}
	
	public Button(panelDimension panelDimension, Panel p){
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
		dimension = panelDimension;
		panel = p;
	}

	public Panel getContainer(){
		return panel;
	}
	
	public void changeContainer(Panel panel)
	{
		this.panel = panel;
	}
	
	public void paint(Graphics2D render) {
		//button.setRGB(dimension.getX(), startY, w, h, rgbArray, offset, scansize);
		render.setColor(customColor);
		render.drawImage(button.getScaledInstance(dimension.getWidth(), dimension.getHeight(), Image.SCALE_FAST), dimension.getX(), dimension.getY(), null);
		render.setColor(Color.WHITE);
		render.drawString(panel.getType(), dimension.getX(), dimension.getY() + 10);
	}
	
	public panelDimension getSize()
	{
		return dimension;
	}
	
	public void setDimension(panelDimension dimension)
	{
		this.dimension = dimension;
	}
	
	public boolean withIn(Panel panel)
	{
		panelDimension pane = panel.getDimension();
		panelDimension button = this.getSize();
		return button.getX() + button.getWidth() < pane.getX() + pane.getWidth() && button.getX() > pane.getX() && button.getY() + button.getHeight() < pane.getY() + pane.getHeight() && button.getY() > pane.getY();
	}
}