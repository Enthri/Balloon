package com.troi.balloon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class GraphicsComponent extends JComponent{
	Graphics2D paint;
	public void paintComponent(Graphics g)
	{
		this.paint = (Graphics2D) g;
	}
	
	public Graphics2D getGraphics()
	{
		return paint;
	}
	public void test()
	{
		Rectangle2D.Double x = new Rectangle2D.Double(10,10,10,10);
		paint.fill(x);
	}

}
