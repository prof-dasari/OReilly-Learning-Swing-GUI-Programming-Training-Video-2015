package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuAction {

	private JLabel greeting = new JLabel("Welcome to Lindana's Cafe", JLabel.CENTER);
	private Action redAction = new RedAction();
	private Action blueAction = new BlueAction();

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new MenuAction().startup() );
	} 

	public void startup() {

		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		mainPanel.add(greeting);
		mainPanel.add(new JButton(redAction));
		mainPanel.add(new JButton(blueAction));

		JMenu colorMenu = new JMenu("Color");
		colorMenu.add(new JMenuItem(redAction));
		colorMenu.add(new JMenuItem(blueAction));

		JMenuBar menubar = new JMenuBar();
		menubar.add(colorMenu);

		JFrame frame = new JFrame("Menu Action");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setJMenuBar(menubar);
		frame.setSize(240, 240);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	class RedAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public RedAction() {
			putValue(NAME, "Red");
			putValue(SMALL_ICON, new BallIcon(10, Color.RED));
			putValue(LARGE_ICON_KEY, new BallIcon(14, Color.RED));
			putValue(ACCELERATOR_KEY, 
					KeyStroke.getKeyStroke(KeyEvent.VK_R, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		}

		public void actionPerformed(ActionEvent e) {
			greeting.setForeground(Color.RED);
		}
	}

	class BlueAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public BlueAction() {
			putValue(NAME, "Blue");
			putValue(SMALL_ICON, new BallIcon(10, Color.BLUE));
			putValue(LARGE_ICON_KEY, new BallIcon(14, Color.BLUE));
			putValue(ACCELERATOR_KEY, 
					KeyStroke.getKeyStroke(KeyEvent.VK_B, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		}

		public void actionPerformed(ActionEvent e) {
			greeting.setForeground(Color.BLUE);
			// redAction.setEnabled(false);
		}
	}

}
