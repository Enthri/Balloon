<<<<<<< HEAD
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
=======
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
		guiEditor = new DragAndDrop(frame,this);
		frame.setContentPane(gComponent);
		Panel panel = new Panel(frame,"main");
		Panel panel2 = new Panel(frame,"main");
		gComponent.newPanel(panel);
		gComponent.newPanel(panel2);
	}
	
	public void addPanel(Panel panel)
	{
		
			panels.add(panel);
//			if (panel.getType().equals("main"))
//			{
//				panel.setSize();
//			}
//			if (panel.getType.equal("tools"))
//			{
//				
//			}
//		
		
	}
	
	public void movePanelsAround(Panel panel)
	{
		panel.setSize(new panelDimension(0, 0, 0, 0));
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

}
>>>>>>> origin/master
