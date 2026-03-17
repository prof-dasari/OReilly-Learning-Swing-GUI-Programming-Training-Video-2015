package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;
import java.time.Month;
import java.util.Arrays;
import java.util.Vector;

public class ListOne {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new ListOne().startup() );
	} 

	public void startup() {

//		Vector<String> flavors = new Vector<>();
//		flavors.add("chocolate");
//		flavors.add("vanilla");
//		flavors.add("strawberry");
//		JList<String> jlist = new JList<>(flavors);
//		jlist.setSelectedIndex(1);

		Month[] months = Month.values();
		JList<Month> jlist = new JList<>(months);
		// jlist.setVisibleRowCount(4);
		jlist.setSelectionBackground(Color.ORANGE);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton button = new JButton("Button");
		button.addActionListener( e -> {
			//System.out.println("Selected values are "+jlist.getSelectedValuesList());
			//System.out.println("Selected indices are "+Arrays.toString(jlist.getSelectedIndices()));
			System.out.println("Selected value is "+jlist.getSelectedValue());
			System.out.println("Selected index is "+jlist.getSelectedIndex());
		});

		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(button, BorderLayout.SOUTH);
		mainPanel.add(new JScrollPane(jlist), BorderLayout.CENTER);

		JFrame frame = new JFrame("JList 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(150, 240);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
