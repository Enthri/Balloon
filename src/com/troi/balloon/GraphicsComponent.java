package com.troi.balloon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class GraphicsComponent extends JComponent{
	Graphics2D paint;
	ArrayList<Panel> panels = new ArrayList<Panel>();
	public void paintComponent(Graphics g)
	{
		this.paint = (Graphics2D) g;
		for (int x = 0; x > panels.size()-1; x++)
		{
			if (panels.get(x).getRepaintValue() == true)
			{
				panels.get(x).repaint(paint);
			}
		}
		
	}
	public void addButton(Button button, Panel panel)
	{
		for (int x = 0; x > panels.size()-1; x++)
		{
			if (panels.get(x) == panel)
			{
				panels.get(x).addButton(button);
			}
		}
	}
	public Graphics2D getGraphics()
	{
		return paint;
	}
	public void newPanel(Panel panel)
	{
		panels.add(panel);
	}
	
	public void test()
	{
		Rectangle2D.Double x = new Rectangle2D.Double(10,10,10,10);
		paint.fill(x);
	}

}
