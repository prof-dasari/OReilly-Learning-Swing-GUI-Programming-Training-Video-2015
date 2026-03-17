package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class Borders {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new Borders().startup() );
	} 

	public void startup() {
		
		JComponent comp0 = new JLabel("compound", JLabel.CENTER);
		comp0.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createCompoundBorder(
						BorderFactory.createEmptyBorder(5, 5, 5, 5),
						BorderFactory.createLineBorder(Color.ORANGE) )));
		
		JLabel lab1 = new JLabel("etched", JLabel.CENTER);
		lab1.setBorder(BorderFactory.createEtchedBorder());
		//lab1.setBackground(Color.RED);
		
		JLabel lab2 = new JLabel("raised bevel", JLabel.CENTER);
		lab2.setBorder(BorderFactory.createRaisedBevelBorder());
		//lab2.setBackground(Color.GREEN);
		
		JLabel lab3 = new JLabel("lowered bevel", JLabel.CENTER);
		lab3.setBorder(BorderFactory.createLoweredBevelBorder());
		//lab3.setBackground(Color.MAGENTA);
		
		JLabel lab4 = new JLabel("titled", JLabel.CENTER);
		lab4.setBorder(BorderFactory.createTitledBorder("This is a Title"));
		
		JLabel lab5 = new JLabel("line", JLabel.CENTER);
		lab5.setBorder(BorderFactory.createLineBorder(Color.PINK, 15));
		
		JLabel lab6 = new JLabel("matte", JLabel.CENTER);
		lab6.setBorder(BorderFactory.createMatteBorder(5, 10, 15, 20, Color.CYAN));
		
		JLabel lab7 = new JLabel("matte (tiled icon)", JLabel.CENTER);
		lab7.setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, new BallIcon(15, Color.GREEN)));

		JPanel mainPanel = new JPanel(new GridLayout(0, 1, 0, 20));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(comp0);
		mainPanel.add(lab1);
		mainPanel.add(lab2);
		mainPanel.add(lab3);
		mainPanel.add(lab4);
		mainPanel.add(lab5);
		mainPanel.add(lab6);
		mainPanel.add(lab7);

		JFrame frame = new JFrame("Borders");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(325, 675);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}




