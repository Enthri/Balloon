package com.troi.balloon;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;
public class Panel {
	protected boolean repaintValue = false;
	protected ArrayList<Object> objects = new ArrayList<Object>();
	public Panel()
	{
		repaintValue = true;
	}
	public boolean getRepaintValue()
	{
		return repaintValue;
	}
	public void repaint(Graphics2D paint)
	{
		for (int x = 0; x < objects.size()-1; x++)
		{
			if (objects.get(x) instanceof Rectangle2D.Double)
			{
				paint.fill((Rectangle2D.Double)objects.get(x));
			}
			else if (objects.get(x) instanceof Image)
			{
				
			}
			else if (objects.get(x) instanceof Button)
			{
				
			}
		}
	}
	
	public void addButton(Button button)
	{
		objects.add(button);
	}
	

}
