package com.troi.balloon;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class UiManager{
	JFrame frame;
	Graphics2D paint;
	TextEditer textEditor;
	DragAndDrop guiEditor;
	GraphicsComponent gComponent;
	boolean textInUse;
	
	public UiManager(JFrame frame)
	{
		gComponent = new GraphicsComponent(); 
		textEditor = new TextEditer();
		guiEditor = new DragAndDrop();
		frame.add(gComponent);
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
