package com.troi.balloon;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import jsyntaxpane.DefaultSyntaxKit;

public class Engine {
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test");
		frame.setContentPane(new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				Graphics2D render = (Graphics2D) g;
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
		DefaultSyntaxKit.initKit();
        final JEditorPane codeEditor = new JEditorPane();
        JScrollPane scrPane = new JScrollPane(codeEditor);
        scrPane.setPreferredSize(new Dimension(400,600));
        codeEditor.setContentType("text/java");
        codeEditor.setText("public class Test {\n\tpublic static void main(String[] args) {\n\t\t\n\t}\n}");
		frame.add(scrPane);
		frame.setVisible(true);
	}
}