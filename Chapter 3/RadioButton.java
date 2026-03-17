package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class RadioButton {
	
	private ButtonGroup extButtonGroup = new ButtonGroup();
	private ButtonGroup intButtonGroup = new ButtonGroup();

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new RadioButton().startup() );
	} 

	public void startup() {
		
		JLabel extHeader = new JLabel("Exterior Choices:");
		JLabel intHeader = new JLabel("Interior Choices:");
		
		JRadioButton ext1 = new JRadioButton("Silver Ice");
		ext1.setActionCommand("silver");
		JRadioButton ext2 = new JRadioButton("Crystal Red");
		ext2.setActionCommand("red");
		JRadioButton ext3 = new JRadioButton("White Diamond");
		ext3.setActionCommand("white");
		JRadioButton ext4 = new JRadioButton("Cyber Gray");
		ext4.setActionCommand("gray");
		JRadioButton ext5 = new JRadioButton("Viridian Joule");
		ext5.setActionCommand("veridian");
		JRadioButton int1 = new JRadioButton("Black Cloth");
		int1.setActionCommand("cloth");
		JRadioButton int2 = new JRadioButton("Black Leather");
		int2.setActionCommand("black");
		JRadioButton int3 = new JRadioButton("Natural Leather");
		int3.setActionCommand("natural");
		
		extButtonGroup.add(ext1);
		extButtonGroup.add(ext2);
		extButtonGroup.add(ext3);
		extButtonGroup.add(ext4);
		extButtonGroup.add(ext5);

		intButtonGroup.add(int1);
		intButtonGroup.add(int2);
		intButtonGroup.add(int3);

		JButton goButton = new JButton("Place Order");
		goButton.addActionListener( e -> placeOrder() );

		JFrame frame = new JFrame("Check Boxes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.getContentPane().add(extHeader);
		frame.getContentPane().add(ext1);
		frame.getContentPane().add(ext2);
		frame.getContentPane().add(ext3);
		frame.getContentPane().add(ext4);
		frame.getContentPane().add(ext5);
		frame.getContentPane().add(intHeader);
		frame.getContentPane().add(int1);
		frame.getContentPane().add(int2);
		frame.getContentPane().add(int3);
		frame.getContentPane().add(goButton);
		frame.setSize(175, 350);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	private void placeOrder() {
		ButtonModel selectedExteriorButtonModel = extButtonGroup.getSelection();
		if (selectedExteriorButtonModel == null) {
			System.out.println("no exterior selection");
		} else {
			System.out.println("exterior: "+selectedExteriorButtonModel.getActionCommand());
		}
		ButtonModel selectedInteriorButtonModel = intButtonGroup.getSelection();
		if (selectedInteriorButtonModel == null) {
			System.out.println("no interior selection");
		} else {
			System.out.println("interior: "+selectedInteriorButtonModel.getActionCommand());
		}
	}

}


