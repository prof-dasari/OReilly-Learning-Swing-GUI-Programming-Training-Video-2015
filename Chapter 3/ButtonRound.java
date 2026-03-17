package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class ButtonRound {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new ButtonRound().startup() );
	}

	public void startup() {
		JButton stockButton = new JButton("Stock");

		JButton roundButton = new JButton("Round", new BallIcon(60, Color.PINK));
		roundButton.setHorizontalTextPosition(JButton.CENTER);
		roundButton.setVerticalTextPosition(JButton.CENTER);
		roundButton.setBorderPainted(false);
		roundButton.setFocusPainted(false);
		roundButton.setContentAreaFilled(false);
		//roundButton.setEnabled(false);

		roundButton.setRolloverIcon(new BallIcon(60, Color.ORANGE));
		roundButton.setPressedIcon(new BallIcon(60, Color.YELLOW));
		roundButton.setDisabledIcon(new BallIcon(60, Color.LIGHT_GRAY));
		// these next three pointless for non-toggle buttons
		roundButton.setSelectedIcon(new BallIcon(60, Color.GREEN));
		roundButton.setRolloverSelectedIcon(new BallIcon(60, Color.CYAN));
		roundButton.setDisabledSelectedIcon(new BallIcon(60, Color.GRAY));

		JFrame frame = new JFrame("Custom Appearance");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(stockButton);
		frame.getContentPane().add(roundButton);
		frame.setSize(240, 120);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
}

