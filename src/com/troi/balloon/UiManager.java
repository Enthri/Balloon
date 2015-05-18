
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.Timer;

import util.panelDimension;
import DragAndDrop.DragAndDrop;
import DragAndDrop.PackageManager;


public class UiManager{
	HashMap<String,panelDimension> Dimensions;//Faster than an ArrayList
	JFrame frame;
	Graphics2D paint;
	TextEditer textEditor;
	DragAndDrop guiEditor;
	GraphicsComponent gComponent;
	Button buttonInUse = null;
	boolean mouseInUse;
	
	public UiManager(JFrame frame)//CONSTRUCTOR
	{
		Dimensions = new HashMap<String,panelDimension>();//contructes a new HashMap then assignes it to the DImensions variable
		Dimensions.put("FileManager", new panelDimension(0,0,(frame.getWidth() / 5),frame.getHeight()));//invokes the put method withtin the HashMap, to the hashmap, then assigns a string and  an dew panelDimension
		Dimensions.put("ToolManager",new panelDimension(((panelDimension)Dimensions.get("FileManager")).getWidth(),0,(frame.getWidth() / 5),frame.getHeight()));
		Dimensions.put("MainManager", new panelDimension((((panelDimension)Dimensions.get("FileManager")).getWidth() * 2),0,(frame.getWidth() - (((panelDimension)Dimensions.get("FileManager")).getWidth() * 2)), frame.getHeight()));
		gComponent = new GraphicsComponent(); //constructs a new Object of the Graphics component the assigns to the variable
		textEditor = new TextEditer();
		guiEditor = new DragAndDrop(frame,this);//constructs a new DragAndDrop object feeds the value of fram and this object it les within
		gComponent.initiate();//invokes a mutator method withtin pointer refernce location
		frame.setContentPane(gComponent);
		ButtonsListener listener = new ButtonsListener();//new construction of the inner class buttonLIstener
		gComponent.addMouseListener(listener);//this is adding the listener to the graphics component
		gComponent.addMouseMotionListener(listener);//||
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(new JMenu("File"));
		menuBar.add(new JMenu("Edit"));
		menuBar.add(new JMenu("View"));
		frame.setResizable(false);
		frame.setJMenuBar(menuBar);
		Timer timerVar = new Timer(16, new ActionListener(){//lists the action of the new actionLIstener
			@Override
			public void actionPerformed(ActionEvent e) {//neede method!
				if(gComponent == null) return;
				gComponent.update();//invokes method withtin gComponent
			}
		});
		timerVar.start();//starts timer
		gComponent.setNewPanels(guiEditor.getCurrentPanels());//assigns currentPanels arraylist to the panel arrayList within the 
	}
	
	public void setCustomDimension(String key , panelDimension object)//amutator method that takes in a string and a panelDimension
	{
		Dimensions.put(key, object);
	}
	public void addPanels(DragAndDrop editer)
	{
		for (int x = 0; x <= editer.getCurrentPanels().size()-1; x++)//for loop taht runs for the size of the arrayLsit of currentPanels within guiEditor
		{
			gComponent.addPanel(editer.getCurrentPanels().get(x));
		} 
	}
	public panelDimension getFileDimension()//returns panelDImension
	{
		return (panelDimension) Dimensions.get("FileManager");//retrieves data from teh HashMap then returns it as it is casted to panelDimension
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
		if (buttonInUse.withIn(buttonInUse.getContainer()) == false)//checks if the conditional is met
		{
			for (int x = 2; x >= 0;x--)//foo loop runs starting at index 2 then substracting after every loop
			{
				
				if (button.withIn(guiEditor.getCurrentPanels().get(x)) == true)//checks to see if conditional is met
				{
					System.out.println(button.getContainer().getType());
					moveButtonPanel(guiEditor.getCurrentPanels().get(x), button);
					button.requestRepaint();
					System.out.println(button.getContainer().getPanels().size());
					System.out.println(button.getID());
					return;//method exit
				}
			}
		}
				
			
	}
	public void moveButtonPanel(Panel panel, Button button)//contians the method 
	{
		button.getContainer().removeButton(button);
		System.out.println("this has been removed from old panel");
		button.setContainer(panel);
		System.out.println("this has been added to new panel");
		panel.newPanel();
		button.setID(panel.getPanels().size()-1);
		panel.addButton(button);
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
			if (guiEditor.getCurrentPanels().get(0) instanceof PackageManager)
			{
				guiEditor.changeEditer(guiEditor.getCurrentPanels().get(0));
			}
			else {
				guiEditor.changeEditer(guiEditor.getCurrentPanels().get(0));
				gComponent.setNewPanels(guiEditor.getCurrentPanels());
				gComponent.requestRepaint();
			}
		}
	}
	
	public boolean checkButtonClicked(MouseEvent e)//explicit parameters require a Mouseevent generated from the buttonListener calss
	{

		if(e.getX() > getMainDimension().getX())
		{
			for(int x = 0;x <= guiEditor.getMainViewer().getButtonList().size()-1;x++)
			{
				if (checkButtonLocation(guiEditor.getMainViewer().getButtonList().get(x),e.getPoint()) == true)
				{
					//guiEditor.changeFileViewer(guiEditor.getMainViewer());
					guiEditor.changeEditer(guiEditor.getMainViewer().getPanels().get(guiEditor.getMainViewer().getButtonList().get(x).getID()));
					gComponent.setNewPanels(guiEditor.getCurrentPanels());
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
					guiEditor.changeEditer(guiEditor.getFileViewer().getPanels().get(guiEditor.getFileViewer().getButtonList().get(x).getID()));
					gComponent.requestRepaint();
					return true;
				}
			}
		}
		else return false;
		return false;
	}
	public class ButtonsListener implements MouseListener, MouseMotionListener//implemetns these two interfaces that require the listed methods below to be present
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
