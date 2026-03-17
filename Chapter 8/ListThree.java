package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListThree {
	
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
		SwingUtilities.invokeLater( () -> new ListThree().startup() );
	} 

	public void startup() {

		JList<String> jlist = new JList<>(states);
		jlist.setLayoutOrientation(JList.VERTICAL_WRAP);
		jlist.setVisibleRowCount(0);
		jlist.setPrototypeCellValue("District of Columbia  ");

		jlist.getSelectionModel().addListSelectionListener( e -> {
			if (!e.getValueIsAdjusting()) {
				System.out.println("selection change: "+jlist.getSelectedValuesList());
			}
		} );

		jlist.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int clickIndex = jlist.locationToIndex(e.getPoint());
					String clickItem = jlist.getModel().getElementAt(clickIndex);
					boolean inBounds = jlist.getCellBounds(clickIndex, clickIndex).contains(e.getPoint());
					if (inBounds) {
						System.out.println("handle double-click: "+clickItem);
					}
				}
			}
		});
 
		JButton button = new JButton("Button");
		button.addActionListener( e -> System.out.println("Selected values are "+jlist.getSelectedValuesList()) );

		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(button, BorderLayout.SOUTH);
		mainPanel.add(new JScrollPane(jlist), BorderLayout.CENTER);

		JFrame frame = new JFrame("JList 3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(750, 302);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
