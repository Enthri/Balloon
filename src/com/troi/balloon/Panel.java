package com.troi.balloon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import util.panelDimension;
import DragAndDrop.ObjectManager;
import DragAndDrop.Tools;
public class Panel {
	protected boolean repaintValue = false,buttonInUse = false;
	protected ArrayList<Button> buttons;
	protected panelDimension dimension;
	protected panelDimension test;
	protected Rectangle background;
	protected String type;
	protected Color color;
	protected Button redrawButton;
	
	/*public Panel()
	{
		System.out.println("ERROR: NO GIVEN DIMENSION");
	}*/
	
	public Panel(panelDimension dimension,String state)
	{
		type = state;
		if (this instanceof Tools)
		{
			color = new Color(41,50,20);
			background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
			buttons = new ArrayList<Button>();
			this.dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
			setDefualtRepaintValue(true);
		}
		else if (this instanceof ObjectManager)
		{
			color = new Color(50,90,200);
				background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
				buttons = new ArrayList<Button>();
				this.dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());

			setDefualtRepaintValue(true);
		}
		
	}
	public void addNewButton(Button button)
	{
		
		buttons.add(button);
		button.setDimension(new panelDimension((this.getDimension().getX() + this.getDimension().getWidth()/4), (30 * (this.getButtonList().size())),50 ,20));
		
		
	}
	public void addButton(Button button)
	{
		buttons.add(button);
	}
	public void setDefualtRepaintValue(boolean setValue)
	{
		this.repaintValue = setValue;
	}
	public boolean checkRepaint()
	{
		return repaintValue;
	}
	public void paintPanel(Graphics2D paint)
	{
		paint.fill(background);
		
	}
	public void setSize(panelDimension size)
	{
		background.setFrame(size.getX(), size.getY(), size.getWidth(), background.getHeight());
	}
//	public void repaintButton(Button button)
//	{
//		((Button) buttons.get(buttons)).paint(paint);
//	}
	
	public ArrayList<Button> getButtonList()
	{
		return buttons;
	}
	public void repaintButton(Graphics2D paint)
	{
		for (Button button: buttons)
		{
			button.paint(paint);
		}
	}
	public void moveButtonPanel(Panel panel, Button button)
	{
		panel.addButton(button);
		this.removeButton(button);
	}
	public String getType()
	{
		return type;
	}
	public void removeButton(Button button)
	{
		buttons.remove(button);
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

}
