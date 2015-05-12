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
	String state;
	Button buttonType;
	public Button(Panel p){
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
		panel = p;
	}
	public Button(panelDimension panelDimension){
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
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
		if (panel.getDimension().getX() < this.getSize().getX() && (this.getSize().getWidth() +this.getSize().getX()) < (panel.getDimension().getX() + panel.getDimension().getWidth()))
		{
			return true;
		}
		else return false;
	}
}