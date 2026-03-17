package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class MenuBar {
	
	public static void main(String[] argv) {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		SwingUtilities.invokeLater( () -> new MenuBar().startup() );
	} 

	public void startup() {

		JMenuItem toastWheat = new JMenuItem("Wheat");
		JMenuItem toastWhite = new JMenuItem("White");

		JMenu toastMenu = new JMenu("Toast");
		toastMenu.add(toastWheat);
		toastMenu.add(toastWhite);

		JMenuItem pancakes = new JMenuItem("Pancakes");
		JMenuItem waffle = new JMenuItem("Waffle");
		JMenuItem biscuit = new JMenuItem("Biscuit");

		JMenu breadMenu = new JMenu("Bread");
		breadMenu.add(pancakes);
		breadMenu.add(waffle);
		breadMenu.add(biscuit);

		JMenuBar menubar = new JMenuBar();
		menubar.add(toastMenu);
		menubar.add(breadMenu);
		
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		mainPanel.add(new JLabel("Welcome to Lindana's Cafe"));

		JFrame frame = new JFrame("MenuBar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setJMenuBar(menubar);
		frame.setSize(240, 240);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		// JFrame frame2 = new JFrame("MenuBar2");
		// frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame2.setSize(240, 240);
		// frame2.setLocation(250, 0);
		// frame2.setVisible(true);
	}

}



