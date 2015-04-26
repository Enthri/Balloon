package com.troi.balloon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphicsComponent extends JPanel {

	ArrayList<Panel> panels = new ArrayList<Panel>();
	
	public void paintComponent(Graphics g) {
		Graphics2D paint = (Graphics2D) g;
		
		for (int x = 0; x > panels.size()-1; x++)
		{
			panels.get(x).paintPanel(paint);
		}
		
	}
	
	public void addButton(Button button, Panel panel) {
		for (int x = 0; x > panels.size()-1; x++)
		{
			if (panels.get(x) == panel)
			{
				panels.get(x).addButton(button);
			}
		}
	}
	
	public Graphics2D getGraphics2D() {
		return (Graphics2D) this.getGraphics();
	}

	public void newPanel(Panel panel) {
		panels.add(panel);
	}
	
	public void test() {
		Rectangle2D.Double x = new Rectangle2D.Double(10,10,10,10);
		getGraphics2D().fill(x);
	}

}