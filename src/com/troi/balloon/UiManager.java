
package com.troi.balloon;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.JFrame;

import util.panelDimension;
import DragAndDrop.DragAndDrop;


public class UiManager{
	HashMap<String,panelDimension> Dimensions;
	JFrame frame;
	Graphics2D paint;
	TextEditer textEditor;
	DragAndDrop guiEditor;
	GraphicsComponent gComponent;
	Button buttonInUse = null;
	boolean mouseInUse;
	
	public UiManager(JFrame frame)
	{
		Dimensions = new HashMap<String,panelDimension>();
		Dimensions.put("FileManager", new panelDimension(0,0,(frame.getWidth() / 5),frame.getHeight()));
		Dimensions.put("ToolManager",new panelDimension(((panelDimension)Dimensions.get("FileManager")).getWidth(),0,(frame.getWidth() / 5),frame.getHeight()));
		Dimensions.put("MainManager", new panelDimension((((panelDimension)Dimensions.get("FileManager")).getWidth() * 2),1000,(frame.getWidth() - (((panelDimension)Dimensions.get("FileManager")).getWidth() * 2)), frame.getHeight()));
		gComponent = new GraphicsComponent(); 
		textEditor = new TextEditer();
		guiEditor = new DragAndDrop(frame,this);
		gComponent.initiate();
		frame.setContentPane(gComponent);
		frame.addMouseListener(new ButtonsListener());
		//Panel panel = new Panel((panelDimension) Dimensions.get("MainManager"));
		//guiEditer = new DragAndDrop(frame,this);
		paintPanels(guiEditor);
	}
	public void resetEnviroment()
	{
		
	}
	
//	public void setCurrentEnviroment(Object panel)
//	{
//		if (panel instanceof TextEditer)
//		{
//			textInUse = true;
//		}
//		else if (panel instanceof DragAndDrop)
//		{
//			textInUse = false;
//		}
//		
//	}
	
	public void setCustomDimension(String key , panelDimension object)
	{
		Dimensions.put(key, object);
	}
	public void paintPanels(DragAndDrop editer)
	{
		for (int x = 0; x <= editer.currentPanels.size()-1; x++)
		{
			gComponent.paintPanel(editer.currentPanels.get(x));
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
	public boolean checkButtonLocation(Button button, Point point)
	{
		if (button.getSize().getX() < point.getX() && button.getSize().getY() < point.getY() && (button.getSize().getX() + button.getSize().getWidth()) > point.getX() && (button.getSize().getY() + button.getSize().getHeight()) > point.getY())
		{
			return true;
		}
		
		
		else return false;
	}
	public void checkButtonInUse(MouseEvent e)
	{
		if(e.getPoint().getX() > getMainDimension().getX())
		{
			for(int x = 0;x <= guiEditor.getMainViewer().getButtonList().size()-1;x++)
				
				if (checkButtonLocation(guiEditor.getMainViewer().getButtonList().get(x),e.getPoint()) == true)
				{
					buttonInUse = guiEditor.getMainViewer().getButtonList().get(x);
				}
		}
		else if(e.getPoint().getX() > getToolDimension().getX())
		{
			for(int x = 0;x <= guiEditor.getToolViewer().getButtonList().size()-1;x++)
				
				if (checkButtonLocation(guiEditor.getToolViewer().getButtonList().get(x),e.getPoint()) == true)
				{
					buttonInUse = guiEditor.getToolViewer().getButtonList().get(x);
				}
		}
		else if (e.getPoint().getX() > getFileDimension().getX())
		{
			for(int x = 0;x <= guiEditor.getFileViewer().getButtonList().size()-1;x++)
				
				if (checkButtonLocation(guiEditor.getFileViewer().getButtonList().get(x),e.getPoint()) == true)
				{
					buttonInUse = guiEditor.getFileViewer().getButtonList().get(x);
				}
		}
		
	}
	public class ButtonsListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			mouseInUse = true;
			checkButtonInUse(e);
			/*if (buttonInUse == null)
			{
				checkButtonInUse(e);
			}
			else 
			{
				buttonInUse.getContainer().paintPanel(gComponent.getGraphics2D());
			}*/
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			mouseInUse = false;
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
