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

	private panelDimension dimension; //the dimensions and position of the button
	private BufferedImage button; //the image of the butotn
	private Panel container; //the container of the buttin
	private Color customColor = new Color(255, 255, 255); //the color of the button, text color is the complementary color of this color
	private int ID; //the id of the button?
	private String text; //the text displayed inside of the button
	
	//Troi's
	private boolean requestedRepaint; //on my part, this is for efficiency sake -trs
	
	public void requestRepaint() { //request a repaint
		requestedRepaint = true;
	}
	
	public boolean checkRepaint() { //if it is checked, usually ONLY checked whenever it is updated by the timer
		if(requestedRepaint) {
			requestedRepaint = false;
			return true;
		} else return false;
		
	}
	
	public void update() { //called whenever the timer ticks
		
	}
	//End Troi's
	public Button(Panel p)
	{
		try{
			button = ImageIO.read(new File("resources/gray-fade.png")); //when the button is constructed, automatically import the resource and make it an object
		}catch(IOException e){
			button = null; //somehow if the resource is not found, just set it to null so the button is never displayed <3
		}
		container = p; //set the container of the button
		text = "Button"; //set the text displayed within the button
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
		return text; //return the text of the button
	}
	
	public void setText(String text) {
		this.text = text; //set the text of the butotn and request a repaint
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
		FontMetrics fm = render.getFontMetrics(); //get font metrics for measurements
		Composite oldComposite = render.getComposite(); //get the current composite
		dimension.setWidth(fm.stringWidth(text)); //set the width of the dimension to the current width of the text
		render.setColor(customColor); //set the current paint of the g2d object to the custom color
		render.fillRect(dimension.getX(), dimension.getY(), dimension.getWidth(), dimension.getHeight()); //fill a solid rectangle
		render.setComposite(AlphaComposite.DstIn); //set the composite for blending
		render.drawImage(button.getScaledInstance(dimension.getWidth(), dimension.getHeight(), Image.SCALE_FAST), dimension.getX(), dimension.getY(), null); //overlay the image on top of the color
		render.setComposite(oldComposite); //set the current composite to the oldcomposite
		render.setColor(new Color(255 - customColor.getRed(), 255 - customColor.getGreen(), 255 - customColor.getBlue())); //set the color to the opposite of the button's color
		render.drawString(text, dimension.getX(), (dimension.getY() + 10) + dimension.getHeight() / 2 - fm.getHeight() / 2); //display the text at the center of the button
	}
	
	public panelDimension getSize()
	{
		return dimension;
	}
	
	public void setDimension(panelDimension dimension)
	{
		this.dimension = dimension;
	}
	
	public boolean withIn(Panel panel) //if this button is within the given panel then return true
	{
		panelDimension pane = panel.getDimension();
		panelDimension button = this.getSize();
		return button.getX() + button.getWidth() < pane.getX() + pane.getWidth() && button.getX() > pane.getX() && button.getY() + button.getHeight() < pane.getY() + pane.getHeight() && button.getY() > pane.getY();
	}
	
	public void setColor(Color colorVar) {
		customColor = colorVar;
		this.requestRepaint(); //request a repaint......
	}
}