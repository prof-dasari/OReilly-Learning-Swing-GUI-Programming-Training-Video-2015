package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class CompoundLayout {
	
	private String[] dimensionChoices = { "pixels", "points" };
	private String[] sizeChoices = { "inches", "cm", "mm" };
	private String[] resolutionChoices = { "pixels/inch", "pixels/cm" };
	private String[] resampleChoices = { "Bicubic (best for smooth gradients)", "Nearest Neighbor", "Bilinear" };

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new CompoundLayout().startup() );
	} 

	public void startup() {
		
		JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 0, 8));
		buttonPanel.add(new JButton("OK"));
		buttonPanel.add(new JButton("Cancel"));
		buttonPanel.add(new JButton("Auto..."));
		
		JPanel eastPanel = new JPanel(new BorderLayout(8, 8));
		eastPanel.add(buttonPanel, BorderLayout.NORTH);
		
		JPanel checkboxPanel = new JPanel(new GridLayout(0, 1, 0, 8));
		checkboxPanel.add(new JCheckBox("Scale Styles", true));
		checkboxPanel.add(new JCheckBox("Constrain Proportions", true));
		checkboxPanel.add(new JCheckBox("Resample Image:", true));
		
		JPanel innerSettingsPanel = new JPanel(new BorderLayout(8, 8));
		innerSettingsPanel.add(createDocumentPanel(), BorderLayout.NORTH);
		innerSettingsPanel.add(checkboxPanel, BorderLayout.CENTER);
		innerSettingsPanel.add(new JComboBox<String>(resampleChoices), BorderLayout.SOUTH);
		
		JPanel settingsPanel = new JPanel(new BorderLayout(8, 8));
		settingsPanel.add(createDimensionsPanel(), BorderLayout.NORTH);
		settingsPanel.add(innerSettingsPanel, BorderLayout.CENTER);
		
		JPanel outerPanel = new JPanel(new BorderLayout(20, 8));
		outerPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		outerPanel.add(eastPanel, BorderLayout.EAST);
		outerPanel.add(settingsPanel, BorderLayout.CENTER);
				
		JFrame frame = new JFrame("Compound");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(outerPanel);
		frame.setSize(425, 340); // or frame.pack()
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	private JPanel createDimensionsPanel() {
		
		JPanel westPanel = new JPanel(new GridLayout(0, 1, 0, 8));
		JPanel centerPanel = new JPanel(new GridLayout(0, 1, 0, 8));
		JPanel eastPanel = new JPanel(new GridLayout(0, 1, 0, 8));
		
		westPanel.add(new JLabel("Width:", JLabel.RIGHT));
		centerPanel.add(new JTextField("1440"));
		eastPanel.add(new JComboBox<String>(dimensionChoices));
		
		westPanel.add(new JLabel("Height:", JLabel.RIGHT));
		centerPanel.add(new JTextField("900"));
		eastPanel.add(new JComboBox<String>(dimensionChoices));
		
		JPanel mainPanel = new JPanel(new BorderLayout(8, 8));
		mainPanel.add(westPanel, BorderLayout.WEST);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		
		JPanel farEastPanel = new JPanel(); // defaults to FlowLayout
		JToggleButton toggle = new JToggleButton("]", true);
		toggle.setPreferredSize(new Dimension(40, 50));
		farEastPanel.add(toggle);
		
		JPanel panel = new JPanel(new BorderLayout(8, 8));
		panel.setBorder(BorderFactory.createTitledBorder("Pixel Dimensions"));
		panel.add(mainPanel, BorderLayout.CENTER);
		panel.add(farEastPanel, BorderLayout.EAST);
		return panel;
	}
	
	private JPanel createDocumentPanel() {
		
		JPanel westPanel = new JPanel(new GridLayout(0, 1, 0, 8));
		JPanel centerPanel = new JPanel(new GridLayout(0, 1, 0, 8));
		JPanel eastPanel = new JPanel(new GridLayout(0, 1, 0, 8));
		
		westPanel.add(new JLabel("Width:", JLabel.RIGHT));
		centerPanel.add(new JTextField("20.005"));
		eastPanel.add(new JComboBox<String>(sizeChoices));
		
		westPanel.add(new JLabel("Height:", JLabel.RIGHT));
		centerPanel.add(new JTextField("12.503"));
		eastPanel.add(new JComboBox<String>(sizeChoices));
		
		westPanel.add(new JLabel("Resolution:", JLabel.RIGHT));
		centerPanel.add(new JTextField("72"));
		eastPanel.add(new JComboBox<String>(resolutionChoices));
		
		JPanel mainPanel = new JPanel(new BorderLayout(8, 8));
		mainPanel.add(westPanel, BorderLayout.WEST);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		
		JPanel farEastPanel = new JPanel(); // defaults to FlowLayout
		JToggleButton toggle = new JToggleButton("]", true);
		toggle.setPreferredSize(new Dimension(40, 50));
		farEastPanel.add(toggle);
		
		JPanel panel = new JPanel(new BorderLayout(8, 8));
		panel.setBorder(BorderFactory.createTitledBorder("Pixel Dimensions"));
		panel.add(mainPanel, BorderLayout.CENTER);
		panel.add(farEastPanel, BorderLayout.EAST);
		return panel;
	}
}


