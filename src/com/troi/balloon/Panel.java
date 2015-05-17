package com.troi.balloon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import util.panelDimension;
import DragAndDrop.ObjectManager;
import DragAndDrop.Tools;
public class Panel {
	
	protected ArrayList<Button> buttons;
	protected ArrayList<Panel> panels;
	protected panelDimension dimension;
	protected Rectangle background;
	protected String type;
	protected Color color;
	protected Panel container;
	
	//Troi's
	private boolean requestedRepaint;
	
	public void requestRepaint() {
		requestedRepaint = true;
	}
	
	public boolean checkRepaint() {
		if(requestedRepaint) {
			requestedRepaint = true;
			return true;
		} else return false;
	}
	
	public void update() {
		if(buttons == null) return;
		for (int x = 0; x < buttons.size(); x++) {
			buttons.get(x).update();
			if(buttons.get(x).checkRepaint()) this.requestRepaint();
		}
	}
	//End Troi's
	public Panel(Panel container ,panelDimension dimension,String state)
	{
		type = state;
		if (this instanceof Tools)
		{
			color = new Color(57,57,57);
			background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
			buttons = new ArrayList<Button>();
			this.dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
		}
		else if (this instanceof ObjectManager)
		{
			color = new Color(80,80,80);
				background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
				buttons = new ArrayList<Button>();
				this.dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
				this.container = container;
				panels = new ArrayList<Panel>();
		}
		
	}
	
	public Panel(panelDimension dimension,String state)
	{
		type = state;
		if (this instanceof Tools)
		{
			color = new Color(57,57,57);
			background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
			buttons = new ArrayList<Button>();
			this.dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
		}
		else if (this instanceof ObjectManager)
		{
			color = new Color(80,80,80);
				background = new Rectangle(dimension.getX(),0,(dimension.getWidth()),dimension.getHeight());
				buttons = new ArrayList<Button>();
				this.dimension = new panelDimension((int)background.getX(), (int)background.getY(), (int) background.getWidth(), (int) background.getHeight());
				panels = new ArrayList<Panel>();
		}
		
	}
	
	public void addNewButton(Button button)
	{
		buttons.add(button);
		button.setDimension(new panelDimension((this.getDimension().getX() + this.getDimension().getWidth()/4), (30 * (this.getButtonList().size())),50 ,20));
	}
	
	public void addButton(Button button)
	{
		buttons.add(button);

	}
	public void Container(Panel panel)
	{
		container = panel;
	}
	public Panel stepUp()
	{
		if (container == null)
		{
			return null;
		}
		else return container;
		
	}
	public void paint(Graphics2D paint)
	{
		paint.fill(background);
		paint.setColor(Color.RED);
		paint.drawString(this.getType(), dimension.getX(), dimension.getY() + 10);
	}
	
	public void paintButtons(Graphics2D paint)
	{
		for (Button button : buttons)
		{
			button.paint(paint);
		}
	}
	
	public void setSize(panelDimension size)
	{
		background.setFrame(size.getX(), size.getY(), size.getWidth(), background.getHeight());
	}
	
	public ArrayList<Button> getButtonList()
	{
		return buttons;
	}
	
	public void moveButtonPanel(Panel panel, Button button)
	{
		button.setContainer(panel);
		System.out.println("this is being added to new panel");
		this.removeButton(button);
		System.out.println("this is being removed from old panel");
		panel.newPanel();
		button.setID(panel.getPanels().size()-1);
		panel.addButton(button);
	}
	
	public String getType()
	{
		return type;
	}
	
	public void removeButton(Button button)
	{
		for (int x = 0; x <= buttons.size()-1;x++)
			if (buttons.get(x)== button)
			{
				buttons.remove(x);
			}
		
	}
	public ArrayList<Panel> getPanels()
	{
		return panels;
	}
	public void newPanel()
	{
		panels.add(new Panel(null,null));
	}
	
	public void setType(String string)
	{
		type = string;
	}
	
	public panelDimension getDimension()
	{
		return dimension;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void SetColor(Color color)
	{
		this.color = color;
	}
	
	public void resetButtonLocation()
	{
		for (int x = 0; x < buttons.size()-1;x++)
		{
			buttons.get(x).setDimension(new panelDimension((this.getDimension().getX() + this.getDimension().getWidth()/4), (30 * x),50 ,20));
		}
	}

}
