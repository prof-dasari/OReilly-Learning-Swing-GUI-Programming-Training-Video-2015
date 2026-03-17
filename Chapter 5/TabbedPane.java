package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class TabbedPane {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new TabbedPane().startup() );
	} 

	public static JPanel createRadioPanel(String... choices) {
		JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
		ButtonGroup buttonGroup = new ButtonGroup();
		for (String choice : choices) {
			JRadioButton b = new JRadioButton(choice);
			buttonPanel.add(b);
			buttonGroup.add(b);
		}
		JPanel outerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
		outerPanel.add(buttonPanel);
		return outerPanel;
	}
	
	public void startup() {
		JLabel topLabel = new JLabel("Choose your breakfast:", JLabel.LEFT);

		JPanel eggsPanel = createRadioPanel("scrambled", "over easy", "poached");
		JPanel breadPanel = createRadioPanel("pancakes", "waffle", "biscuit", "toast");
		JPanel meatPanel = createRadioPanel("bacon", "sausage", "hash", "veggie links");

		JButton meatButton = new JButton("meat!");
		eggsPanel.add(meatButton);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("eggs", eggsPanel);
		tabbedPane.addTab("bread", breadPanel);
		tabbedPane.addTab("meat", meatPanel);
		// tabbedPane.setEnabledAt(2, false);

		tabbedPane.addChangeListener( e -> topLabel.setText("tab index is "+tabbedPane.getSelectedIndex()) );
	
		// meatButton.addActionListener( e -> tabbedPane.setSelectedIndex(2) );
		meatButton.addActionListener( e -> tabbedPane.setSelectedComponent(meatPanel) );

		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 20, 20));
		
		mainPanel.add(topLabel, BorderLayout.NORTH);
		mainPanel.add(tabbedPane, BorderLayout.CENTER);

		JFrame frame = new JFrame("TabbedPane");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(300, 240);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}

