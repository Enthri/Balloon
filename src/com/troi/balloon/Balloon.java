package com.troi.balloon;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Balloon implements Runnable {
	UiManager manager;
	private JFrame frame;
	
	public static void main(String[] args) {
		
		(new Thread(new Balloon())).start();
		
	}

	@Override
	public void run() {
		//JCompiler.init();
		frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		manager = new UiManager(frame);
		frame.add(new ButtonComponent(20, 20, 20, 20, Color.BLACK));
		frame.pack();
		frame.setVisible(true);
//		frame.pack();
//        final RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
//        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
//        textArea.setCodeFoldingEnabled(true);
//        textArea.setText("public class Test {\n}");
//        RTextScrollPane sp = new RTextScrollPane(textArea);
//        frame.add(sp);
//        System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_71");
//        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	}
}