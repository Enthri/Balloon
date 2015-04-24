package com.troi.balloon;

import java.awt.Graphics2D;

import javax.swing.JFrame;

public class EnviromentSystem {
	protected boolean textEditer;
	protected JFrame frame;
	protected Graphics2D paint;
	public EnviromentSystem(JFrame frame, Graphics2D paint)
	{
		this.frame = frame;
		this.paint = paint;
		
	}
	
	public void resetEnviroment()
	{
		
	}
	
	public void setCurrentEnviroment(Object panel)
	{
		if (panel instanceof TextEditer)
		{
			textEditer = true;
		}
		else if (panel instanceof DragAndDrop)
		{
			textEditer = false;
		}
	}

}
