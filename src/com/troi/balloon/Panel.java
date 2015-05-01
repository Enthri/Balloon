package com.troi.balloon;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;

import javax.swing.JFrame;

import DragAndDrop.ObjectManager;
import DragAndDrop.Tools;
import util.panelDimension;
public class Panel {
	protected boolean repaintValue = false;
	protected HashMap buttons;
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
			buttons = new HashMap();
			dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
		}
		else
		{
			background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
			buttons = new HashMap();
			dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
		}
	}
	public Panel(panelDimension dimension,String state)
	{
		type = state;
		if (this instanceof ObjectManager)
		{

				background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
			buttons = new HashMap();
			dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());

		}
		
	}
	
	public void paintPanel(Graphics2D paint)
	{
		sizeOfMap = buttons.size();
		paint.fill(background);
		for(int x = 0; x < sizeOfMap;x++)
		{
			//((Button) buttons.get(x)).paint(paint);
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
		((Button)buttons.get(button)).paint(paint);
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
		buttons.put(sizeOfMap, button);
	}
	

}
