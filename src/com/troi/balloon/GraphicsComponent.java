package com.troi.balloon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphicsComponent extends JPanel {

	public ArrayList<Panel> panels = new ArrayList<Panel>();
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D paint = (Graphics2D) g;
		for (int x = 0; x < 3; x++)
		{
			
			if (panels.get(x).checkRepaint() == true)
			{
			
				paint.setColor(panels.get(x).getColor());
				panels.get(x).paintPanel(paint);
			}
		}
		
	}
	
	public Graphics2D getGraphics2D() {
		return (Graphics2D) this.getGraphics();
	}

	public void paintPanel(Panel panel) {
		panels.add(panel);
		this.repaint();
	}
	
	public void paintButton(Panel panel)
	{
		
	}

}