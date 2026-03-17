package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToggleButton {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new ToggleButton().startup() );
	} 

	public void startup() {

		JToggleButton toggleButton = new JToggleButton("Mute", true);
		toggleButton.setIcon(new BallIcon(15, Color.LIGHT_GRAY));
		toggleButton.setSelectedIcon(new BallIcon(15, Color.GREEN));
		toggleButton.addItemListener( e -> handleToggle(e) );
		
		JButton stockButton = new JButton("Stock");
		stockButton.addActionListener( e -> System.out.println("muted state is "+toggleButton.isSelected()) );

		JFrame frame = new JFrame("ToggleButton");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(toggleButton);
		frame.getContentPane().add(stockButton);
		frame.setSize(240, 120);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public void handleToggle(ItemEvent e) {
		if ( e.getStateChange() == ItemEvent.SELECTED ) {
			System.out.println("mute is on");
		} else {
			System.out.println("mute is off");
		}
	}

}


