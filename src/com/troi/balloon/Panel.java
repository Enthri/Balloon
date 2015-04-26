package com.troi.balloon;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;

import javax.swing.JFrame;

import util.panelDimension;
public class Panel {
	protected boolean repaintValue = false;
	protected HashMap map, buttons;
	protected int sizeOfMap,x,y,width,hieght;
	protected Graphics2D paint;
	protected panelDimension dimension;
	protected Rectangle2D.Double background;
	protected String type;
	public Panel(JFrame frame, String type)
	{
		this.type = type;
		background = new Rectangle2D.Double(0,0,frame.getHeight(),(frame.getWidth() / 3)); s
		repaintValue = true;
		map = new HashMap();
		buttons = new HashMap();
		map.put("background", background);
		map.put("buttons",buttons);
		dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
		
	}
	
	public void paintPanel(Graphics2D paint)
	{
		sizeOfMap = buttons.size();
		paint.fill((Rectangle2D.Double)map.get("background"));
		for(int x = 0; x < sizeOfMap;x++)
		{
			map.get(buttons.get(x).paint());
		}
	}
	public void setSize(int x, int y, int width)
	{
		background.setFrame(x, y, width, background.getHeight());
	}
	public void repaintButton(Button button)
	{
		map.get(this.buttons.get(button).paint());
	}

	public void moveButtonPanel(Panel panel, Button button)
	{
		panel.addButton(button);
		this.removeButton(button);
	}
	public string getType()
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
		buttons.put(sizeOfMap, button);
	}
	

}
