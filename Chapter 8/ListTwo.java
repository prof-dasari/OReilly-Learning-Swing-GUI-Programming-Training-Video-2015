package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class ListTwo {
	
	private String[] states = { "Alabama", "Alaska", "Arizona", "Arkansas", "California",
			"Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida",
			"Georgia", "Guam", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
			"Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
			"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
			"New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina",
			"North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico",
			"Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
			"Utah", "Vermont", "Virgin Islands", "Virginia", "Washington", "West Virginia",
			"Wisconsin", "Wyoming" };

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new ListTwo().startup() );
	} 

	public void startup() {

		JList<String> jlist = new JList<>(states);
		jlist.setLayoutOrientation(JList.VERTICAL_WRAP);
		jlist.setVisibleRowCount(0);
		//jlist.setFixedCellWidth(150);
		//jlist.setFixedCellHeight(22);
		jlist.setPrototypeCellValue("District of Columbia  ");

		JButton button = new JButton("Button");
		button.addActionListener( e -> System.out.println("Selected values are "+jlist.getSelectedValuesList()) );

		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(button, BorderLayout.SOUTH);
		mainPanel.add(new JScrollPane(jlist), BorderLayout.CENTER);

		JFrame frame = new JFrame("JList 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(750, 302);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
