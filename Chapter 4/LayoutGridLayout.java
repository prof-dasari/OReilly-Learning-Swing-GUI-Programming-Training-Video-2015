package com.bitguru.ora.sc.swing;

import javax.swing.*;

import java.awt.*;

public class LayoutGridLayout {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new LayoutGridLayout().startup() );
	} 

	public void startup() {

		JPanel mainPanel = new JPanel(new GridLayout(3, 0, 8, 8));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		mainPanel.add(new JButton("One"));
		mainPanel.add(new JButton("Two"));
		mainPanel.add(new JButton("Three"));
		mainPanel.add(new JButton("Four"));
		mainPanel.add(new JButton("Five"));
		mainPanel.add(new JButton("Six"));

		JFrame frame = new JFrame("GridLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(400, 200);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}




