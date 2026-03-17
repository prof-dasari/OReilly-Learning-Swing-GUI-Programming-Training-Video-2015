package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class HelloWorld {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new HelloWorld().startup() );
	}
	
	public void startup() {
		JLabel greeting = new JLabel("Hello, world!", JLabel.CENTER);
		greeting.setFont(new Font("serif", Font.PLAIN, 32));
		greeting.setForeground(Color.RED);
		
		JFrame frame = new JFrame("Important Message");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(greeting);
		frame.setSize(240, 160);
		frame.setVisible(true);
	}
}