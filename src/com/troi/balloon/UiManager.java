package com.troi.balloon;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;


public class UiManager{
	ArrayList<Panel> panels = new ArrayList<Panel>();
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
	
	public void addPanel(Object panel)
	{
		if (panel instanceof Panel)
		{
			panels.add(panel);
			if (panel.getType.equals("main"))
			{
				movePanelsAround(panel);
			}
			if (panel.getType.equal("tools"))
			{
				
			}
		}
		
	}
	
	public void movePanelsAround(Panel panel)
	{
		
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
