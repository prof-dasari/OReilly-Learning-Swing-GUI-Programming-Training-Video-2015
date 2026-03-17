package com.bitguru.ora.sc.swing;

import java.awt.*;
import javax.swing.*;


public class OptionPane {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new OptionPane().startup() );
	}

	public void startup() {

		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

		JButton b1 = new JButton("sleepy");
		mainPanel.add(b1);
		b1.addActionListener( e -> {
			String m = "You are getting very sleepy...";

			// JOptionPane.showMessageDialog(mainPanel, m);
			//   message types: PLAIN_MESSAGE, INFORMATION_MESSAGE, QUESTION_MESSAGE, WARNING_MESSAGE, ERROR_MESSAGE
			JOptionPane.showMessageDialog(mainPanel, m, "Notice", JOptionPane.WARNING_MESSAGE);
			// JOptionPane.showMessageDialog(mainPanel, m, "Notice", JOptionPane.WARNING_MESSAGE, new ImageIcon(...));
		} );
		
		
		JButton b2 = new JButton("clue");
		mainPanel.add(b2);
		b2.addActionListener( e -> {
			JTextField who = new JTextField();
			JTextField where = new JTextField();
			JTextField what = new JTextField();
			JSlider certainty = new JSlider(0, 10, 5);
			certainty.setMinorTickSpacing(1);
			certainty.setMajorTickSpacing(5);
			certainty.setPaintTicks(true);
			certainty.setPaintLabels(true);

			Object[] m = { "I accuse", who, "in the", where, "with the", what, "with certainty", certainty };

			JOptionPane.showMessageDialog(mainPanel, m, "Accusation", JOptionPane.QUESTION_MESSAGE);

			System.out.println("accusation: " + who.getText() + " in the " + where.getText()
					+ " with the " + what.getText() + " with certainty " + certainty.getValue());
		} );


		JButton b3 = new JButton("hungry");
		mainPanel.add(b3);
		b3.addActionListener( e -> {
			String m = "Are you hungry?";

			// int result = JOptionPane.showConfirmDialog(mainPanel, m);
			//  option types: OK_CANCEL_OPTION, YES_NO_OPTION, YES_NO_CANCEL_OPTION
			int result = JOptionPane.showConfirmDialog(mainPanel, m, "Satiety", JOptionPane.YES_NO_OPTION);
			// int result = JOptionPane.showConfirmDialog(mainPanel, m, "Satiety", JOptionPane.YES_NO_OPTION, new ImageIcon(...));

			if (result == JOptionPane.YES_OPTION) System.out.println("user chose: YES"); // or OK_OPTION
			else if (result == JOptionPane.NO_OPTION) System.out.println("user chose: NO");
			else if (result == JOptionPane.CANCEL_OPTION) System.out.println("user chose: CANCEL");
			else if (result == JOptionPane.CLOSED_OPTION) System.out.println("user dismissed without choosing");
		} );


		JButton b4 = new JButton("name");
		mainPanel.add(b4);
		b4.addActionListener( e -> {
			String m = "What is your name?";

			// String result = JOptionPane.showInputDialog(mainPanel, m);
			// String result = JOptionPane.showInputDialog(mainPanel, m, "Abe");
			// String result = JOptionPane.showInputDialog(mainPanel, m, "Moniker", JOptionPane.ERROR_MESSAGE);
			Object result = JOptionPane.showInputDialog(mainPanel, m, "Moniker", JOptionPane.QUESTION_MESSAGE,
					null, new String[] { "Abe", "Barb", "Carl", "Dan" }, "Carl");

			System.out.println("name is: "+result);
		} );


		JFrame frame = new JFrame("option pane");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(500, 200);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
