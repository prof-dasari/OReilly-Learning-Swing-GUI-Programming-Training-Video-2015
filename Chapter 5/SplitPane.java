package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class SplitPane {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new SplitPane().startup() );
	} 

	public void startup() {
		
		JPanel firstPanel = new JPanel(); // FlowLayout
		//firstPanel.setMinimumSize(new Dimension(4, 4));
		JButton button1 = new JButton("first");
		firstPanel.add(button1);
		
		JPanel secondPanel = new JPanel(); // FlowLayout
		//secondPanel.setMinimumSize(new Dimension(4, 4));
		JButton button2 = new JButton("second");
		secondPanel.add(button2);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, firstPanel, secondPanel);
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);
		splitPane.setDividerLocation(165);
		
		button1.addActionListener( e -> splitPane.setDividerLocation(75) );
		button2.addActionListener( e -> splitPane.setDividerLocation(0.75) );

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		mainPanel.add(splitPane, BorderLayout.CENTER);

		JFrame frame = new JFrame("SplitPane");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(300, 300);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}




