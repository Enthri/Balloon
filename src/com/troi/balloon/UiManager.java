
package com.troi.balloon;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import DragAndDrop.DragAndDrop;
import util.panelDimension;


public class UiManager{
	HashMap Dimensions;
	JFrame frame;
	Graphics2D paint;
	TextEditer textEditor;
	DragAndDrop guiEditor;
	GraphicsComponent gComponent;
	boolean textInUse;
	
	public UiManager(JFrame frame)
	{
		Dimensions = new HashMap();
		Dimensions.put("FileManager", new panelDimension(0,0,(frame.getWidth() / 5),frame.getHeight()));
		Dimensions.put("ToolManager",new panelDimension(((panelDimension)Dimensions.get("FileManager")).getWidth(),0,(frame.getWidth() / 5),frame.getHeight()));
		Dimensions.put("MainManager", new panelDimension((((panelDimension)Dimensions.get("FileManager")).getWidth() * 2),1000,(frame.getWidth() - (((panelDimension)Dimensions.get("FileManager")).getWidth() * 2)), frame.getHeight()));
		gComponent = new GraphicsComponent(); 
		textEditor = new TextEditer();
		guiEditor = new DragAndDrop(frame,this);
		frame.setContentPane(gComponent);
		Panel panel = new Panel((panelDimension) Dimensions.get("MainManager"));
		gComponent.newPanel(panel);
	}
	public void resetEnviroment()
	{
		
	}
	
	public void setCurrentEnviroment(Object panel)
	{
		if (panel instanceof TextEditer)
		{
			textInUse = true;
		}
		else if (panel instanceof DragAndDrop)
		{
			textInUse = false;
		}
		
	}
	
	public panelDimension getFileDimension()
	{
		return (panelDimension) Dimensions.get("FileManager");
	}
	
	public panelDimension getToolDimension()
	{
		return (panelDimension) Dimensions.get("ToolManager");
	}
	
	public panelDimension getMainDimension()
	{
		return (panelDimension) Dimensions.get("MainManager");
	}
	
	public panelDimension getCustomDimension(String name)
	{
		return (panelDimension) Dimensions.get(name);
	}

}
