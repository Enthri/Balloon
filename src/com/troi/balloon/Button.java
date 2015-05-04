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
	public Button(panelDimension panelDimension){
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
	}
	
	public Button(panelDimension panelDimension, Panel p){
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
		panel = p;
	}
	
	public Button(panelDimension panelDimension, Panel p, String s, String size){
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
		panel = p;
		state = s;
		setSize(size);
		}
	
	public Button(Panel p,String size)
	{
		try{
		button = ImageIO.read(new File("src/resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
		setSize(size);
		panel = p;
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
	}
	
	public panelDimension getSize()
	{
		return dimension;
	}
	
	//check in use -- checks to see if the button currently being dragged
	
	//toggle draggable
	
	//
	
	public void setDimension(panelDimension dimension)
	{
		this.dimension = dimension;
	}
}