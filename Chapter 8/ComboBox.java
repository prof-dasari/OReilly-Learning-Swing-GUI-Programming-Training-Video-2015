package com.bitguru.ora.sc.swing;

import javax.swing.*;

import java.awt.*;
import java.util.Vector;

public class ComboBox {

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new ComboBox().startup() );
	} 

	public void startup() {

		Integer[] possibleScoops = new Integer[] { 1, 2, 3 };
		JComboBox<Integer> scoopsCombo = new JComboBox<>(possibleScoops);
		scoopsCombo.setPrototypeDisplayValue(100);

		scoopsCombo.addActionListener( e -> System.out.println("scoops selected "+scoopsCombo.getSelectedItem()) );

		Vector<String> possibleFlavors = new Vector<>();
		possibleFlavors.add("chocolate");
		possibleFlavors.add("vanilla");
		possibleFlavors.add("strawberry");
		JComboBox<String> flavorCombo = new JComboBox<>(possibleFlavors);
		flavorCombo.setSelectedIndex(1);
		flavorCombo.setEditable(true);

		flavorCombo.addActionListener( e -> {
			if (flavorCombo.getSelectedIndex() < 0) {
				// append the new flavor typed by the user to the ComboBox's pull-down list
				String theFlavor = (String)flavorCombo.getSelectedItem();
				possibleFlavors.add(theFlavor); // dangerous (if not for the next line)
				flavorCombo.setModel(new DefaultComboBoxModel<String>(possibleFlavors));
				flavorCombo.setSelectedIndex(possibleFlavors.size()-1);
			}
		} );

		JButton button = new JButton("Place Order");
		button.addActionListener( e -> System.out.println(
				"order: "+scoopsCombo.getSelectedItem()+" scoop(s) of "+flavorCombo.getSelectedItem()) );

		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 20));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(scoopsCombo);
		mainPanel.add(new JLabel("scoops of"));
		mainPanel.add(flavorCombo);
		mainPanel.add(button);

		JFrame frame = new JFrame("ComboBox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(320, 160);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
