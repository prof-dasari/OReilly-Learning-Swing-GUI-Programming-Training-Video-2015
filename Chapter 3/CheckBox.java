package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class CheckBox {

	JCheckBox option1 = new JCheckBox("Articulated C#/G#");
	JCheckBox option2 = new JCheckBox("Left Hand Ab/Eb Key");
	JCheckBox option3 = new JCheckBox("Range to Low Eb");
	JCheckBox option4 = new JCheckBox("Plateau Keywork");
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new CheckBox().startup() );
	} 

	public void startup() {
		
		// option3.setModel(option1.getModel()); // set 1 and 3 to share a ButtonModel

		// option4.setIcon(new BallIcon(15, Color.LIGHT_GRAY));
		// option4.setSelectedIcon(new BallIcon(15, Color.GREEN));

		JLabel header = new JLabel("Clarinet Options");
		
		JButton goButton = new JButton("Place Order");
		goButton.addActionListener( e -> placeOrder() );

		JFrame frame = new JFrame("Check Boxes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.getContentPane().add(header);
		frame.getContentPane().add(option1);
		frame.getContentPane().add(option2);
		frame.getContentPane().add(option3);
		frame.getContentPane().add(option4);
		frame.getContentPane().add(goButton);
		frame.setSize(200, 200);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	private void placeOrder() {
		StringBuilder sb = new StringBuilder();
		if (option1.isSelected()) {
			sb.append("Articulated C#/G#");
		}
		if (option2.isSelected()) {
			if (sb.length() > 0) sb.append(", ");
			sb.append("LH Ab/Eb");
		}
		if (option3.isSelected()) {
			if (sb.length() > 0) sb.append(", ");
			sb.append("Low Eb");
		}
		if (option4.isSelected()) {
			if (sb.length() > 0) sb.append(", ");
			sb.append("Plateau");
		}
		if (sb.length() == 0) {
			sb.append("none");
		}
		System.out.println("order options: "+sb);
	}
}


