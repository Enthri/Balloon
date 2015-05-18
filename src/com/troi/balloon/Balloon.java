package com.troi.balloon;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.troi.balloon.panelsystem.Environment;

public class Balloon implements Runnable {
	UiManager manager;
	private JFrame frame;
	
	private Environment currentEnvironment; //used for troi mode
	
	private final boolean troiMode = false; //for troi mode, don't enable unless you are troi..
	
	public static void main(String[] args) {
		
		(new Thread(new Balloon())).start(); //start a thread of this class
		
	}

	@Override
	public void run() {
		//JCompiler.init();
		if(!troiMode) { //if not troi mode
			frame = new JFrame("Test"); //initialize a new jframe
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill java.exe plz
			frame.setPreferredSize(new Dimension(800, 600)); //set the window's default size
			frame.pack(); //actually make it the size
			manager = new UiManager(frame); //initialize a uimanager?
			frame.setVisible(true); //display the window 
		} else { //ignore further below, THX! -troi
			frame = new JFrame("Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setPreferredSize(new Dimension(800, 600));
			frame.pack();
			frame.setVisible(true);
			Timer timer = new Timer(50, new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					currentEnvironment.update();
				}
			});
			timer.start();
			this.setCurrentEnvironment(new Environment());
			com.troi.balloon.panelsystem.Panel panel = new com.troi.balloon.panelsystem.Panel();
			panel.add(new com.troi.balloon.panelsystem.Button());
			currentEnvironment.add(panel);
			currentEnvironment.add(new com.troi.balloon.panelsystem.Panel());
			currentEnvironment.add(new com.troi.balloon.panelsystem.Panel());
			currentEnvironment.add(new com.troi.balloon.panelsystem.Panel());
			currentEnvironment.add(new com.troi.balloon.panelsystem.Panel());
		}
//		frame.pack();
//        final RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
//        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
//        textArea.setCodeFoldingEnabled(true);
//        textArea.setText("public class Test {\n}");
//        RTextScrollPane sp = new RTextScrollPane(textArea);
//        frame.add(sp);
//        System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_71");
//        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//hello
	}
	
	public void setCurrentEnvironment(Environment environment) {
		currentEnvironment = environment;
		frame.setContentPane(currentEnvironment);
	}
	
	public Environment getCurrentEnvironment() {
		return currentEnvironment;
	}
}

//package com.troi.balloon;
//
//import java.awt.Dimension;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JFrame;
//import javax.swing.Timer;
//
//import com.troi.balloon.panelsystem.Environment;
//
//public class Balloon implements Runnable {
//	
//	private JFrame frame;
//	private Environment currentEnvironment;
//	
//	public static void main(String[] args) {
//		
//		(new Thread(new Balloon())).start();
//		
//	}
//
//	@Override
//	public void run() {
//		frame = new JFrame("Test");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setPreferredSize(new Dimension(800, 600));
//		frame.pack();
//		frame.setVisible(true);
//		Timer timer = new Timer(50, new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				currentEnvironment.update();
//			}
//		});
//		timer.start();
//		this.setCurrentEnvironment(new Environment());
//		com.troi.balloon.panelsystem.Panel panel = new com.troi.balloon.panelsystem.Panel();
//		panel.add(new com.troi.balloon.panelsystem.Button());
//		currentEnvironment.add(panel);
//		currentEnvironment.add(new com.troi.balloon.panelsystem.Panel());
//		currentEnvironment.add(new com.troi.balloon.panelsystem.Panel());
//		currentEnvironment.add(new com.troi.balloon.panelsystem.Panel());
//		currentEnvironment.add(new com.troi.balloon.panelsystem.Panel());
////		frame.pack();
////        final RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
////        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
////        textArea.setCodeFoldingEnabled(true);
////        textArea.setText("public class Test {\n}");
////        RTextScrollPane sp = new RTextScrollPane(textArea);
////        frame.add(sp);
////        System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_71");
////        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//		//hello
//	}
//	
//	public void setCurrentEnvironment(Environment environment) {
//		currentEnvironment = environment;
//		frame.setContentPane(currentEnvironment);
//	}
//	
//	public Environment getCurrentEnvironment() {
//		return currentEnvironment;
//	}
//}