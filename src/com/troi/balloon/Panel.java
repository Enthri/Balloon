package com.troi.balloon;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;

import util.panelDimension;
import DragAndDrop.ObjectManager;
import DragAndDrop.Tools;
public class Panel {
	protected boolean repaintValue = false;
	protected ArrayList<Button> buttons;
	protected int sizeOfMap,x,y,width,hieght;
	protected panelDimension dimension;
	protected Rectangle background;
	protected String type;
	
	/*public Panel()
	{
		System.out.println("ERROR: NO GIVEN DIMESION");
	}*/
	
	public Panel(panelDimension dimension)

	{
		type = "panel";
		if (this instanceof Tools)
		{
			background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
			buttons = new ArrayList<Button>();
			dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
			setRepaintValue(true);
		}
		else
		{
			background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
			buttons = new ArrayList<Button>();
			dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
			setRepaintValue(true);
		}
	}
	public Panel(panelDimension dimension,String state)
	{
		type = state;
		if (this instanceof ObjectManager)
		{

				background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
				buttons = new ArrayList<Button>();
			dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
			setRepaintValue(true);
		}
		
	}
	public void addButton(Button button, panelDimension dimension)
	{
		buttons.add(button);
		buttons.get(buttons.size()-1).resize();;
	}
	public void setRepaintValue(boolean setValue)
	{
		this.repaintValue = setValue;
	}
	public boolean checkRepaint()
	{
		return repaintValue;
	}
	public void paintPanel(Graphics2D paint)
	{
		sizeOfMap = buttons.size();
		paint.fill(background);
		for(int x = 0; x < sizeOfMap;x++)
		{
			((Button) buttons.get(x)).paint(paint);
		}
	}
	public void setSize(panelDimension size)
	{
		background.setFrame(size.getX(), size.getY(), size.getWidth(), background.getHeight());
	}
//	public void repaintButton(Button button)
//	{
//		((Button) buttons.get(buttons)).paint(paint);
//	}
	public void repaintButton(Button button,Graphics2D paint)
	{
		((Button) buttons.get(x)).paint(paint);
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
	public panelDimension returnDimension()
	{
		dimension = new panelDimension(x,y,width,hieght);
		return dimension;
	}
	public void addButton(Button button)
	{
		sizeOfMap += 1;
		button.setID(sizeOfMap);
		buttons.add(button);
	}
	
	public panelDimension getDimension()
	{
		return dimension;
	}
	

}
