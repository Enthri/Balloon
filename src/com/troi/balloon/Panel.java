package com.troi.balloon;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;

import javax.swing.JFrame;
public class Panel {
	protected boolean repaintValue = false;
	protected HashMap<K, V> map;
	public Panel(JFrame frame)
	{
		repaintValue = true;
		map.put("background", new Rectangle2D.Double(0,0,frame.getHeight(),(frame.getWidth() / 3)));
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
