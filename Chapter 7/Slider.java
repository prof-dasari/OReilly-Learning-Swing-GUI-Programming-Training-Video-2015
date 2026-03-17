package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Slider {

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new Slider().startup() );
	} 

	public void startup() {

		JSlider s0 = new JSlider(JSlider.HORIZONTAL, 0, 100, 75);
		s0.setMajorTickSpacing(25);
		s0.setMinorTickSpacing(5);
		s0.setPaintTicks(true);
		s0.setPaintLabels(true);

		JSlider s1 = new JSlider(JSlider.VERTICAL, 0, 10, 5);
		s1.setMajorTickSpacing(2);
		s1.setMinorTickSpacing(1);
		s1.setPaintTicks(true);
		s1.setPaintLabels(true);

		JSlider s2 = new JSlider(JSlider.VERTICAL, 0, 8, 3);
		s2.setMinorTickSpacing(1);
		s2.setPaintTicks(true);
		Hashtable<Integer, JLabel> labels2 = new Hashtable<>();
		labels2.put(0, new JLabel("mute"));
		labels2.put(1, new JLabel("soft"));
		labels2.put(8, new JLabel("loud"));
		s2.setLabelTable(labels2);
		s2.setPaintLabels(true);

		JSlider s3 = new JSlider(JSlider.VERTICAL, 0, 1000, 0);
		s3.setMajorTickSpacing(250);
		s3.setMinorTickSpacing(50);
		s3.setPaintTicks(true);
		Hashtable<Integer, JLabel> labels3 = new Hashtable<>();
		labels3.put(0, new JLabel("0.00"));
		labels3.put(250, new JLabel("0.25"));
		labels3.put(500, new JLabel("0.50"));
		labels3.put(750, new JLabel("0.75"));
		labels3.put(1000, new JLabel("1.00"));
		s3.setLabelTable(labels3);
		s3.setPaintLabels(true);
		s3.setInverted(true);

		JLabel messageLabel = new JLabel("message");
		JButton button = new JButton("Update");
		button.addActionListener( e -> messageLabel.setText("s3 is set to "+s3.getValue()/1000.0) );		

		JPanel northPanel = new JPanel(new BorderLayout(20, 20));
		northPanel.add(button, BorderLayout.WEST);
		northPanel.add(messageLabel, BorderLayout.CENTER);
		northPanel.add(s0, BorderLayout.SOUTH);

		JPanel gridPanel = new JPanel(new GridLayout(1, 0, 10, 0));
		gridPanel.add(s1);
		gridPanel.add(s2);
		gridPanel.add(s3);

		JPanel mainPanel = new JPanel(new BorderLayout(20, 40));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(gridPanel, BorderLayout.CENTER);

		JFrame frame = new JFrame("Slider");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(400, 400);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
