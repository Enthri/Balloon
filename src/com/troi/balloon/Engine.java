package com.troi.balloon;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Engine {
	
	private static JPanel panel0;
	private static JPanel panel1;
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		final JFrame frame = new JFrame("Test");
		panel0 = new JPanel() {
		};
		panel1 = new JPanel() {
		};
		frame.setContentPane(panel0);
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
				if(frame.getContentPane() == panel0) frame.setContentPane(panel1);
				else frame.setContentPane(panel0);
				frame.repaint();
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