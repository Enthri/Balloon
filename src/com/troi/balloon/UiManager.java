package com.troi.balloon;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class UiManager{
	JFrame frame;
	Graphics2D paint;
	TextEditer textEditer;
	DragAndDrop guiEditer;
	GraphicsComponent gComponent;
	boolean textInUse;
	public UiManager(JFrame frame)
	{
		gComponent = new GraphicsComponent(); 
		textEditer = new TextEditer();
		guiEditer = new DragAndDrop();
		setCurrentEnviroment(textEditer);
	}
	
	public void resetEnviroment()
	{
		
	}
	
	public void setCurrentEnviroment(Object panel)
	{
		if (panel instanceof TextEditer)
		{
			textInUse = true;
			gComponent.test();
		}
		else if (panel instanceof DragAndDrop)
		{
			textInUse = false;
		}
	}

}
