package com.troi.balloon;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.troi.balloon.panelsystem.Environment;

public class Balloon implements Runnable {
	
	private JFrame frame;
	private Environment currentEnvironment;
	
	public static void main(String[] args) {
		
		(new Thread(new Balloon())).start();
		
	}

	@Override
	public void run() {
		frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
		frame.setVisible(true);
		Timer timer = new Timer(20, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				currentEnvironment.update();
			}
		});
		this.setCurrentEnvironment(new Environment());
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