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
<<<<<<< HEAD
	protected HashMap buttons;
=======
	protected HashMap map, buttons; //huh
>>>>>>> origin/master
	protected int sizeOfMap,x,y,width,hieght;
	protected Graphics2D paint;
	protected panelDimension dimension;
	protected Rectangle2D.Double background;
	protected String type;
	public Panel(JFrame frame, String type,Graphics2D paint)
	{
		this.type = type;
		background = new Rectangle2D.Double(0,0,frame.getHeight(),(frame.getWidth() / 3));
		repaintValue = true;
		buttons = new HashMap();
		dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
		this.paint = paint;
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
	public void repaintButton(Button button)
	{
		((Button) buttons.get(button)).paint(paint);
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
		buttons.put(sizeOfMap, button);
	}
	

}
