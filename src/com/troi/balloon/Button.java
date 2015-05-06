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
		dimension = new panelDimension((p.returnDimension().getX()+panel.width/2), (p.getDimension().getHeight()/3),20 ,20);
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
	
	public void setSize(String size) {
		// TODO Auto-generated method stub
		if(size.equals("Small")){
			setDimension(new panelDimension(100, 10, 10, 10));
		}
	}

	public Panel getContainer(){
		return panel;
	}
	
	public void paint(Graphics2D render) {
		render.drawImage(button.getScaledInstance(dimension.getWidth(), dimension.getHeight(), Image.SCALE_FAST), dimension.getX(), dimension.getY(), null);
		render.fillRect(10,10,10,10);
	}
	
	public String getSize()
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
}