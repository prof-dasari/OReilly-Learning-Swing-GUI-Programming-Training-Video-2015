package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class MenuPopup {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new MenuPopup().startup() );
	} 

	public void startup() {

		JMenu toastMenu = new JMenu("Toast");
		JMenuItem toastWheat = new JMenuItem("Wheat");
		JMenuItem toastWhite = new JMenuItem("White");
		toastWheat.addActionListener( e -> System.out.println("wheat toast") );
		toastWhite.addActionListener( e -> System.out.println("white toast") );
		toastMenu.add(toastWheat);
		toastMenu.add(toastWhite);

		JPopupMenu breadMenu = new JPopupMenu();
		JMenuItem pancakes = new JMenuItem("Pancakes");
		JMenuItem waffle = new JMenuItem("Waffle");
		JMenuItem biscuit = new JMenuItem("Biscuit");
		pancakes.addActionListener( e -> System.out.println("pancakes") );
		waffle.addActionListener( e -> System.out.println("waffle") );
		biscuit.addActionListener( e -> System.out.println("biscuit") );
		breadMenu.add(pancakes);
		breadMenu.add(waffle);
		breadMenu.add(biscuit);
		breadMenu.add(toastMenu); // hierarchical menu

		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		JLabel greeting = new JLabel("Welcome to Lindana's Cafe");
		mainPanel.add(greeting);
		JButton button = new JButton("Button");
		// button.setInheritsPopupMenu(true); // usually wouldn't do this
		mainPanel.add(button);

		mainPanel.setComponentPopupMenu(breadMenu); // right-click will pop up menu
	
		button.addActionListener( e -> breadMenu.show(button, 10, 20) );

		JFrame frame = new JFrame("Menu Popup");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(240, 240);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}



