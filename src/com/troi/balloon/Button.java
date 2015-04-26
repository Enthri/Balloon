package com.troi.balloon;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.w3c.dom.events.MouseEvent;

public class Button {
	int startX;
	int startY;
	int glo_x;
	int glo_y;
	int width;
	int height;
	BufferedImage button;
	public Button(int x, int y, int w, int h){
		glo_x = x;
		glo_y = y;
		w = width;
		h = height;
		try{
			button = ImageIO.read(new File("resources/gray-button-template"));
		}catch(IOException e){
			button = null;
		}
	}
	public void paint(Graphics2D render) {
		render.drawImage(button.getScaledInstance(width, height, Image.SCALE_FAST), glo_x, glo_y, null);
	}
	public void move(){
		
	}
	public void MouseDragged(MouseEvent e){
		
	}
	
	public void resize(){
		
	}
}
