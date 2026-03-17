package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class TextField {

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new TextField().startup() );
	} 

	public void startup() {

		JTextField textfield = new JTextField(12);

		textfield.addActionListener( e -> System.out.println("(action from field) "+textfield.getText()) );

		JButton button = new JButton("button");
		button.addActionListener( e -> System.out.println("(action from button) "+textfield.getText()) );

		JPanel p = new JPanel(new BorderLayout());
		p.add(new JTextField(12));
		p.setBorder(BorderFactory.createTitledBorder("Titled Border"));

		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(textfield);
		mainPanel.add(button);
		mainPanel.add(p);

		JFrame frame = new JFrame("text field");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(320, 240);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
