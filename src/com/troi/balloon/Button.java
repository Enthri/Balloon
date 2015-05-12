package com.troi.balloon;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import util.panelDimension;

public class Button {

	panelDimension dimension;
	BufferedImage button;
	Panel panel;
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
		render.drawImage(button.getScaledInstance(dimension.getWidth(), dimension.getHeight(), Image.SCALE_FAST), dimension.getX(), dimension.getY(), null);
	}
	
	public panelDimension getSize()
	{
		return dimension;
	}
	
	//check in use -- checks to see if the button currently being dragged
	
	//toggle dragsable
	
	//
	
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
	
	@Override
	public Object clone() {
		return new Button(dimension, panel);
	}
}