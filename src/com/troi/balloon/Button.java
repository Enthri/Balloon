package com.troi.balloon;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import util.panelDimension;

public class Button {

	private panelDimension dimension;
	private BufferedImage button;
	private Panel container;
	private Color customColor = new Color(255, 255, 255);
	private int ID;
	private String text;
	
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
	public Button(Panel p)
	{
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
		container = p;
		text = "Button";
	}
	
	public Button(Panel p, String text)
	{
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
		container = p;
		this.text = text;
	}
	
	public Button(panelDimension panelDimension, Panel p){
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
		dimension = panelDimension;
		container = p;
		text = "Button";
	}
	
	public Button(panelDimension panelDimension, Panel p, String text){
		try{
			button = ImageIO.read(new File("resources/gray-fade.png"));
		}catch(IOException e){
			button = null;
		}
		dimension = panelDimension;
		container = p;
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
		this.requestRepaint();
	}

	public Panel getContainer(){
		return container;
	}
	public int getID()
	{
		return ID;
	}
	
	public void setID(int num)
	{
		ID = num;
	}
	public void setContainer(Panel panel)
	{
		this.container = panel;
	}
	
	public void paint(Graphics2D render) {
		FontMetrics fm = render.getFontMetrics();
		Composite oldComposite = render.getComposite();
		dimension.setWidth(fm.stringWidth(text));
		render.setColor(customColor);
		render.fillRect(dimension.getX(), dimension.getY(), dimension.getWidth(), dimension.getHeight());
		render.setComposite(AlphaComposite.DstIn);
		render.drawImage(button.getScaledInstance(dimension.getWidth(), dimension.getHeight(), Image.SCALE_FAST), dimension.getX(), dimension.getY(), null);
		render.setComposite(oldComposite);
		render.setColor(new Color(255 - customColor.getRed(), 255 - customColor.getGreen(), 255 - customColor.getBlue()));
		render.drawString(text, dimension.getX(), (dimension.getY() + 10) + dimension.getHeight() / 2 - fm.getHeight() / 2);
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
	
	public void setColor(Color colorVar) {
		customColor = colorVar;
		this.requestRepaint();
	}
}