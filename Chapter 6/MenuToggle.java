package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuToggle {

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new MenuToggle().startup() );
	} 

	public void startup() {

		JMenuItem coffee = new JMenuItem("Coffee");
		coffee.addActionListener( e -> System.out.println("coffee"));	

		JCheckBoxMenuItem bacon = new JCheckBoxMenuItem("Bacon");
		bacon.addActionListener( e -> System.out.println("bacon set to "+bacon.isSelected()));

		JRadioButtonMenuItem scrambled = new JRadioButtonMenuItem("Scrambled", true);
		JRadioButtonMenuItem overeasy = new JRadioButtonMenuItem("Over Easy");
		JRadioButtonMenuItem poached = new JRadioButtonMenuItem("Poached");
		scrambled.setActionCommand("scrambled eggs");
		overeasy.setActionCommand("eggs over easy");
		poached.setActionCommand("poached eggs");
		ButtonGroup eggGroup = new ButtonGroup();
		eggGroup.add(scrambled);
		eggGroup.add(overeasy);
		eggGroup.add(poached);

		Action loyaltyAction = new ToggleAction();

		JMenu orderMenu = new JMenu("Order");
		orderMenu.add(coffee);
		orderMenu.add(bacon);
		orderMenu.addSeparator();
		orderMenu.add(scrambled);
		orderMenu.add(overeasy);
		orderMenu.add(poached);
		orderMenu.addSeparator();
		orderMenu.add(new JCheckBoxMenuItem(loyaltyAction));

		JMenuBar menubar = new JMenuBar();
		menubar.add(orderMenu);

		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		mainPanel.add(new JLabel("Welcome to Lindana's Cafe", JLabel.CENTER));

		JButton b = new JButton("Eggs?");
		// b.addActionListener( e -> System.out.println(scrambled.isSelected() + " " + overeasy.isSelected()
		//		+ " " + poached.isSelected()) );
		b.addActionListener( e -> System.out.println(eggGroup.getSelection().getActionCommand()) );
		mainPanel.add(b);

		mainPanel.add(new JToggleButton(loyaltyAction));
		mainPanel.add(new JCheckBox(loyaltyAction));

		JFrame frame = new JFrame("Menu Toggle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setJMenuBar(menubar);
		frame.setSize(240, 240);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	class ToggleAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public ToggleAction() {
			putValue(NAME, "Loyalty");
			putValue(SHORT_DESCRIPTION, "Use loyalty card?");
			putValue(SMALL_ICON, new BallIcon(10, Color.ORANGE));
			putValue(ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
			putValue(SELECTED_KEY, Boolean.FALSE);
		}

		public void actionPerformed(ActionEvent e) {
			if (Boolean.TRUE.equals(getValue(SELECTED_KEY))) {
				System.out.println("Thanks for using your loyalty card.");
			} else {
				System.out.println("Sign up for a loyalty card today.");
			}
		}
	}

}
