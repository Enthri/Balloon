package com.troi.balloon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;


public class ButtonComponent extends JComponent implements MouseListener, MouseMotionListener{
	int glo_x;
	int glo_y;
	int height;
	int width;
	int startX;
	int startY;
	boolean isMouseDown;
	Color glo_color;
	public ButtonComponent(int x, int y, int w, int h, Color color) {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		glo_x = x;
		glo_y = y;
		height = w;
		width = h;
		glo_color = color;
	}
	
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D button = new Rectangle2D.Double(glo_x, glo_y, width, height);
		g2.setColor(glo_color);
		g2.fill(button);
		g2.draw(button);
	}
	public void drawButton(Graphics2D g2){
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getX()> glo_x && e.getX() < glo_x + width && e.getY() > glo_y && e.getY() < glo_y + height){
			
			System.out.println("hi");
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX()> glo_x && e.getX() < glo_x + width && e.getY() > glo_y && e.getY() < glo_y + height){
			isMouseDown = true;
			startX = e.getX() - glo_x;
			startY = e.getY() - glo_y;
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		isMouseDown = false;
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		if(isMouseDown){
			glo_x = e.getX() - startX;
			glo_y = e.getY() - startY;
			repaint();
		}
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
