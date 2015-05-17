
package com.troi.balloon;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.Timer;

import util.panelDimension;
import DragAndDrop.DragAndDrop;
import DragAndDrop.PackageManager;


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
		ButtonsListener listener = new ButtonsListener();
		gComponent.addMouseListener(listener);
		gComponent.addMouseMotionListener(listener);
		Timer timerVar = new Timer(16, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(gComponent == null) return;
				gComponent.update();
			}
		});
		timerVar.start();
		//Panel panel = new Panel((panelDimension) Dimensions.get("MainManager"));
		//guiEditer = new DragAndDrop(frame,this);
		gComponent.setNewPanels(guiEditor.getCurrentPanels());
	}
	
	public void setCustomDimension(String key , panelDimension object)
	{
		Dimensions.put(key, object);
	}
	public void addPanels(DragAndDrop editer)
	{
		for (int x = 0; x <= editer.getCurrentPanels().size()-1; x++)
		{
			gComponent.addPanel(editer.getCurrentPanels().get(x));
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
	
	public void updateButtonLocation(Button button)
	{
		if (buttonInUse.withIn(buttonInUse.getContainer()) == false)
		{
			for (int x = 2; x >= 0;x--)
			{
				
				if (button.withIn(guiEditor.getCurrentPanels().get(x)) == true)
				{
					button.getContainer().moveButtonPanel(guiEditor.getCurrentPanels().get(x), button);
					button.requestRepaint();
					return;
				}
			}
		}
				
			
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
		if(e.getX() > getMainDimension().getX())
		{
			for(int x = 0;x <= guiEditor.getMainViewer().getButtonList().size()-1;x++)
			{
				if (checkButtonLocation(guiEditor.getMainViewer().getButtonList().get(x),e.getPoint()) == true)
				{
					buttonInUse = guiEditor.getMainViewer().getButtonList().get(x);
					break;
				}
			}
		}
		else if(e.getX() > getToolDimension().getX())
		{
			for(int x = 0;x <= guiEditor.getToolViewer().getButtonList().size()-1;x++)
			{
				if (checkButtonLocation(guiEditor.getToolViewer().getButtonList().get(x),e.getPoint())== true)
				{
					buttonInUse = guiEditor.getToolViewer().getButtonList().get(x);
					break;
				}
			}
		}
		else if (e.getX() > getFileDimension().getX())
		{
			for(int x = 0;x <= guiEditor.getFileViewer().getButtonList().size()-1;x++)
			{
				if (checkButtonLocation(guiEditor.getFileViewer().getButtonList().get(x),e.getPoint()) == true)
				{
					buttonInUse = guiEditor.getFileViewer().getButtonList().get(x);
					break;
				}
			}
		}
		else System.out.println("something is wrong");
		
	}


	public void checkButtonInstance(Button button)
	{
		
	}
	
	public void checkSwitchState(MouseEvent e)
	{

		if (e.getX() > guiEditor.getCurrentPanels().get(0).getDimension().getX() && e.getX() < (guiEditor.getCurrentPanels().get(0).getDimension().getX() +guiEditor.getCurrentPanels().get(0).getDimension().getWidth())) 
		{
			guiEditor.changeEditer(guiEditor.getCurrentPanels().get(0).getReference().getContainer());
			if (guiEditor.getCurrentPanels().get(0).getReference().getContainer() instanceof PackageManager)
			{
				gComponent.setNewPanels(guiEditor.getCurrentPanels());
				gComponent.requestRepaint();
			}
			else {
				guiEditor.getCurrentPanels().get(0).getReference().getContainer().getReference().getContainer();
				gComponent.setNewPanels(guiEditor.getCurrentPanels());
				gComponent.requestRepaint();
			}
		}
	}
	
	public boolean checkButtonClicked(MouseEvent e)
	{

		if(e.getX() > getMainDimension().getX())
		{
			for(int x = 0;x <= guiEditor.getMainViewer().getButtonList().size()-1;x++)
			{
				if (checkButtonLocation(guiEditor.getMainViewer().getButtonList().get(x),e.getPoint()) == true)
				{
					guiEditor.changeFileViewer(guiEditor.getMainViewer());
					guiEditor.changeEditer(guiEditor.getMainViewer().getButtonList().get(x).getValue());
					gComponent.requestRepaint();
					return true;
				}
			}
		}
		else if(e.getX() > getToolDimension().getX())
		{
			return false;
		}
		else if (e.getX() > getFileDimension().getX())
		{
			for(int x = 0;x <= guiEditor.getFileViewer().getButtonList().size()-1;x++)
			{
				if (checkButtonLocation(guiEditor.getFileViewer().getButtonList().get(x),e.getPoint()) == true)
				{
					guiEditor.changeEditer(guiEditor.getMainViewer().getButtonList().get(x).getValue());
					gComponent.requestRepaint();
					return true;
				}
			}
		}
		else return false;
		return false;
	}
	public class ButtonsListener implements MouseListener, MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent e) {
			if(buttonInUse == null) return;
			buttonInUse.setDimension(new panelDimension(e.getX(),e.getY(), buttonInUse.getSize().getWidth(), buttonInUse.getSize().getHeight()));
			gComponent.requestRepaint();
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			 checkButtonInUse(e);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(buttonInUse == null) return;
			updateButtonLocation(buttonInUse);
			gComponent.requestRepaint();
			buttonInUse = null;
		}
		
		//Useless, for now <3

		@Override
		public void mouseMoved(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			if (checkButtonClicked(e) == false)
			{
			checkSwitchState(e);
			gComponent.requestRepaint();
			}
			gComponent.requestRepaint();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
}
