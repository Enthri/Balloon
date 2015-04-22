package com.troi.balloon;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Engine {
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		final JFrame frame = new JFrame("Test");
		frame.setContentPane(new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				Graphics2D render = (Graphics2D) g;
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
        final RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        textArea.setText("public class Test {\n}");
        RTextScrollPane sp = new RTextScrollPane(textArea);
        frame.add(sp);
        System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_71");
        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		frame.setVisible(true);
		final JFileChooser chooser = new JFileChooser();
		frame.addMouseListener(new MouseListener(){


			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
					PrintWriter writer;
					try {
						writer = new PrintWriter(chooser.getSelectedFile().toString(), "UTF-8");
						for(String a : textArea.getText().split("\n")) writer.println(a);
						writer.close();
					} catch (FileNotFoundException | UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					compiler.run(null, null, null, chooser.getSelectedFile().toString());
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}
}