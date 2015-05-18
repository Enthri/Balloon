package com.troi.balloon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import util.panelDimension;
import DragAndDrop.ObjectManager;
import DragAndDrop.Tools;
public class Panel {
	
	protected ArrayList<Button> buttons;//ArrayLIst, listed as protected for inheritance
	protected ArrayList<Panel> panels;
	protected panelDimension dimension;
	protected Rectangle background;
	protected String type;
	protected Color color;
	protected Panel container;
	

	private boolean requestedRepaint;//variable set as private
	
	public void requestRepaint() {//mutator method
		requestedRepaint = true;//assigned requiestedREpaint to true;
	}
	
	public boolean checkRepaint() {//returns a boolean value
		if(requestedRepaint) {//if statement checks if value is true
			requestedRepaint = true;
			return true;//this returns true and steps out of this method
		} else return false;//if the conditional before is not met this code will exacute
	}
	
	public void update() {
		if(buttons == null) return;//checks to see if the buttons object points to nothing
		for (int x = 0; x < buttons.size(); x++) {//for loop that runs for as many buttons that are contained in a arrayList
			buttons.get(x).update();//calls a mutator method that lies within a button Object inside of a Button arrayList
			if(buttons.get(x).checkRepaint()) this.requestRepaint();
		}
	}
	public Panel(Panel container ,panelDimension dimension,String state)//CONTRUCTER
	{
		type = state;//assisnges vaiable valur from object
		if (this instanceof Tools)//checks if this object is of type Tools
		{
			color = new Color(57,57,57);//contructs new Color object and feeds to the color varibale
			background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());//construction of a new Object REctangle then feeds intovairbale rectagle
			buttons = new ArrayList<Button>();// Constructed ArrayLIst that can only contain Button object then feeds the memory location to vaiable
			this.dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());//new panelDimension contructed with proper explicit parameters then is fed into vaiabel that is of type panelDimension
		}
		else if (this instanceof ObjectManager)
		{
			color = new Color(80,80,80);
				background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
				buttons = new ArrayList<Button>();
				this.dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
				this.container = container;
				panels = new ArrayList<Panel>();
		}
		
	}
	
	public Panel(panelDimension dimension,String state)//CONTRUCTER
	{
		type = state;
		if (this instanceof Tools)
		{
			color = new Color(57,57,57);
			background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
			buttons = new ArrayList<Button>();
			this.dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
		}
		else if (this instanceof ObjectManager)
		{
			color = new Color(80,80,80);
				background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
				buttons = new ArrayList<Button>();
				this.dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
				panels = new ArrayList<Panel>();
		}
		
	}
	
	public void addNewButton(Button button)//mutator that explicit parameters take in a object Button
	{
		buttons.add(button);//Feeds button into the ArrayList as a new Object
		button.setDimension(new panelDimension((this.getDimension().getX() + this.getDimension().getWidth()/4), (30 * (this.getButtonList().size())),50 ,20));//invokes method apon button, then feeds in a contructed version of panel
	}
	
	public void addButton(Button button)
	{
		buttons.add(button);

	}
	public void Container(Panel panel)
	{
		container = panel;
	}
	public Panel stepUp()//returns Panel that is contained within a vairbale listed above
	{
		if (container == null)
		{
			return null;//error catching
		}
		else return container;
		
	}
	public void paint(Graphics2D paint)
	{
		paint.fill(background);//method invoked apon background fills the rectangle
		paint.setColor(Color.RED);
		paint.drawString(this.getType(), dimension.getX(), dimension.getY() + 10);
	}
	
	public void paintButtons(Graphics2D paint)
	{
		for (Button button : buttons)//generalized for loop that assins the objec to a vairbale as loops through the arrayLIst
		{
			button.paint(paint);
		}
	}
	
	public void setSize(panelDimension size)
	{
		dimension = size;
		background.setFrame(size.getX(), size.getY(), size.getWidth(), background.getHeight());
	}
	
	public ArrayList<Button> getButtonList()
	{
		return buttons;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void removeButton(Button button)
	{
		for (int x = 0; x <= buttons.size()-1;x++)
			if (buttons.get(x)== button)
			{
				buttons.remove(x);
			}
		
	}
	public ArrayList<Panel> getPanels()
	{
		return panels;
	}
	public void newPanel()
	{
		panels.add(new Panel(null,null));
	}
	
	public void setType(String string)
	{
		type = string;
	}
	
	public panelDimension getDimension()
	{
		return dimension;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void SetColor(Color color)
	{
		this.color = color;
	}
	
	public void resetButtonLocation()
	{
		for (int x = 0; x < buttons.size()-1;x++)
		{
			buttons.get(x).setDimension(new panelDimension((this.getDimension().getX() + this.getDimension().getWidth()/4), (30 * x),50 ,20));
		}
	}

}
