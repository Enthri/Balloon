package com.troi.balloon;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import util.panelDimension;


public class UiManager{
	panelDimension mainDimension, sideDimension, toolDimension;
	ArrayList<Panel> panels = new ArrayList<Panel>();
	JFrame frame;
	Graphics2D paint;
	TextEditer textEditor;
	DragAndDrop guiEditor;
	GraphicsComponent gComponent;
	boolean textInUse;
	
	public UiManager(JFrame frame)
	{
		sideDimension = new panelDimension(0,0,(frame.getWidth() / 5),frame.getHeight());
		toolDimension = new panelDimension(sideDimension.getWidth(),0,(frame.getWidth() / 5),frame.getHeight());
		mainDimension = new panelDimension((sideDimension.getWidth() * 2),0,(frame.getWidth() - (sideDimension.getWidth() * 2)), frame.getHeight());
		gComponent = new GraphicsComponent(); 
		textEditor = new TextEditer();
		guiEditor = new DragAndDrop();
		frame.add(gComponent);
	}
	
	public void addPanel(Panel panel)
	{
		
			panels.add(panel);
			if (panel.getType().equals("main"))
			{
				panel.setSize();
			}
			if (panel.getType.equal("tools"))
			{
				
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
