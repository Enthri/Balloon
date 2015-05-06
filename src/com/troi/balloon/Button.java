package com.troi.balloon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import util.panelDimension;

public class Button {

	panelDimension dimension;
	Image imageButton;
	Panel panel;
	String state;
	public Button(panelDimension panelDimension){
		initImage();
	}
	
	public Button(panelDimension panelDimension, Panel p){
		panel = p;
		initImage();
	}
	
	public Button(panelDimension panelDimension, Panel p, String s, String size){
		panel = p;
		state = s;
		setSize(size);
		initImage();
	}
	
	public Button(Panel p,String size)
	{
		setSize(size);
		panel = p;
		initImage();
	}
	
	private void initImage() {
		try{
<<<<<<< HEAD
			imageButton = ImageIO.read(new File("resources/gray-fade.png")).getScaledInstance(dimension.getWidth(), dimension.getHeight(), Image.SCALE_FAST);
=======
		button = ImageIO.read(new File("resources/gray-fade.png"));
>>>>>>> origin/master
		}catch(IOException e){
			imageButton = null;
		}
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
		render.drawImage(imageButton, dimension.getX(), dimension.getY(), null);
		render.fillRect(10,10,10,10);
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