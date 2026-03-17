package com.bitguru.ora.sc.swing;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Menu {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new Menu().startup() );
	} 

	public void startup() {

		JMenuItem toastWheat = new JMenuItem("Wheat");
		toastWheat.setMnemonic(KeyEvent.VK_W);
		toastWheat.setAccelerator(KeyStroke.getKeyStroke('W', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		toastWheat.addActionListener( e -> System.out.println("wheat toast") );

		JMenuItem toastWhite = new JMenuItem("White");
		toastWhite.setMnemonic(KeyEvent.VK_I);
		toastWhite.setAccelerator(KeyStroke.getKeyStroke('T', InputEvent.SHIFT_DOWN_MASK|InputEvent.CTRL_DOWN_MASK));
		toastWhite.addActionListener( e -> System.out.println("white toast") );

		JMenu toastMenu = new JMenu("Toast");
		toastMenu.setMnemonic(KeyEvent.VK_T);
		toastMenu.add(toastWheat);
		toastMenu.add(toastWhite);

		JMenuItem pancakes = new JMenuItem("Pancakes");
		JMenuItem waffle = new JMenuItem("Waffle");
		JMenuItem biscuit = new JMenuItem("Biscuit");

		JMenu breadMenu = new JMenu("Bread");
		breadMenu.add(pancakes);
		breadMenu.add(waffle);
		breadMenu.addSeparator();
		breadMenu.add(biscuit);
		breadMenu.add(toastMenu);

		JMenuBar menubar = new JMenuBar();
		// menubar.add(toastMenu);
		menubar.add(breadMenu);

		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		mainPanel.add(new JLabel("Welcome to Lindana's Cafe"));

		JFrame frame = new JFrame("Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setJMenuBar(menubar);
		frame.setSize(240, 240);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}



