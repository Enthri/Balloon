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
	public Button(Panel p){
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
	//	System.out.println("")
		dimension = new panelDimension((p.returnDimension().getX() + p.returnDimension().getWidth()/2), (p.getDimension().getHeight()/10 * (p.getButtonList().size()+1)),100 ,(p.getDimension().getWidth()/2 + 5));
	}
	public Button(panelDimension panelDimension, Panel p, String type){
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
		panel = p;
		state = type;
	}

	public Panel getContainer(){
		return panel;
	}
	
	public void paint(Graphics2D render) {
		render.drawImage(button.getScaledInstance(dimension.getWidth(), dimension.getHeight(), Image.SCALE_FAST), dimension.getX(), dimension.getY(), null);
	//	render.fillRect(10,10,10,10);
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
		if (panel.getDimension().getX() < this.getSize().getX() && panel.getDimension().getY() < this.getSize().getY() && (this.getSize().getWidth() +this.getSize().getX()) < (panel.getDimension().getX() + panel.getDimension().getX()))
		{
			return true;
		}
		else return false;
	}
}