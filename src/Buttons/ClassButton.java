package Buttons;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import util.panelDimension;

import com.troi.balloon.*;
//buttons list:
//	class button -- X
//	package button
//	method button
//	command button
//	tools button
public class ClassButton extends Button {
	panelDimension dimension;
	BufferedImage button;
	Panel panel;
	String state;
	Color c;
	String size;
	String title;
	int w;
	int h;
	public ClassButton(Panel p) {
		super(p);
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
	}
	public Color getColor(){
		return c;
	}
	public int getH(){
		return h;
	}
	public int getW(){
		return w;
	}
	public String getTitle(){
		return title;
	}
	public void setColor(Color color){
		c = color;
	}
	public void setSize(String s){
		if(s.equals("small")){
			size = s;
			w = 50;
			h = 25;
		}else if(s.equals("medium")){
			size = s;
			w = 200;
			h = 100;
		}else if(s.equals("big")){
			size = s;
			w = 500;
			h = 250;
		}
	}
	public void setTitle(String t){
		title = t;
	}
	
	
}
