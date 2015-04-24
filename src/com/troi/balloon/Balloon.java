package com.troi.balloon;

import javax.swing.JFrame;

public class Balloon implements Runnable {
	
	private JFrame frame;
	
	public static void main(String[] args) {
		(new Thread(new Balloon())).start();
	}

	@Override
	public void run() {
		
	}
}