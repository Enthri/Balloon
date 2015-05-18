package com.troi.balloon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import DragAndDrop.ObjectManager;
import DragAndDrop.Tools;

@SuppressWarnings("serial")
public class GraphicsComponent extends JPanel {//inherits all of the methods + instance fields from JPanel obejct
	
	private ArrayList<Panel> panels = new ArrayList<Panel>();//constructeed a new ArrayLIst that is fed into a private arrayList variabel
	
	//Troi's
	private boolean requestedRepaint;
	
	public void requestRepaint() {//mustauro method
		requestedRepaint = true;
	}
	
	public boolean checkRepaint() {//returns boolean value
		if(requestedRepaint) {//checks for conditon is met
			requestedRepaint = false;
			return true;//return true also steps out of method to methodcall
		} else return false;//if none of the conditions above were met then run this code
	}
	
	public void update() {//mustator method
		if(panels == null) return;//error catch exit
		for (int x = 0; x < panels.size(); x++) {//for loop that runs for the amount of panels that lie inside of the panels arrayList
			if(panels.get(x) == null) continue;
			panels.get(x).update();
			if(panels.get(x).checkRepaint()) this.requestRepaint();
		}
		if(this.checkRepaint()) this.getParent().repaint();
	}
	//End Troi's
	
	@Override
	public void paintComponent(Graphics g) {//listed  method that is called whenerver panel is being repaineted
		Graphics2D paint = (Graphics2D) g;
		
		if(panels == null) return;
		for (int x = 0; x < panels.size(); x++) {
			paint.setColor(panels.get(x).getColor());
			panels.get(x).paint(paint);
		}
		
		for (int x = 0; x < panels.size(); x++) {
			panels.get(x).paintButtons(paint);
		}
	}

	public void addPanel(Panel panel) {
		if (panel instanceof Tools)
		{
			panels.set(1, panel);
			this.requestRepaint();

		}
		else if (panel instanceof ObjectManager)
		{
	
			if (panel.getType().equals("MainViewer"))
					{
						panels.set(2, panel);
					}
			else panels.set(0,panel);
			this.requestRepaint();
		}
	
	}
	
	public void setNewPanels(ArrayList<Panel> panels)
	{
		this.panels = panels;
	}
	
	public void initiate()
	{
		panels.add(null);
		panels.add(null);
		panels.add(null);
	}
}