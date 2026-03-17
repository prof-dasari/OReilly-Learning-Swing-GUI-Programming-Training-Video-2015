package com.bitguru.ora.sc.swing;

import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class PasswordField {

	private JTextField nameField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JPasswordField verifyField = new JPasswordField();

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new PasswordField().startup() );
	} 

	public void startup() {

		JPanel labelsPanel = new JPanel(new GridLayout(0, 1, 0, 5));
		JPanel fieldsPanel = new JPanel(new GridLayout(0, 1, 0, 5));
		JPanel formPanel = new JPanel(new BorderLayout(5, 5));
		formPanel.add(labelsPanel, BorderLayout.WEST);
		formPanel.add(fieldsPanel, BorderLayout.CENTER);

		labelsPanel.add(new JLabel("login name", JLabel.RIGHT));
		fieldsPanel.add(nameField);

		labelsPanel.add(new JLabel("password", JLabel.RIGHT));
		fieldsPanel.add(passwordField);

		labelsPanel.add(new JLabel("verify", JLabel.RIGHT));
		fieldsPanel.add(verifyField);

		JButton button = new JButton("button");

		button.addActionListener( e -> login() );
		nameField.addActionListener( e -> login() );
		passwordField.addActionListener( e -> login() );
		verifyField.addActionListener( e -> login() );

		JPanel p = new JPanel(new BorderLayout());
		p.add(new JTextField(12));
		p.setBorder(BorderFactory.createTitledBorder("Titled Border"));

		JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(formPanel, BorderLayout.NORTH);
		mainPanel.add(button, BorderLayout.SOUTH);

		JFrame frame = new JFrame("password field");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(240, 180);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	private void login() {
		String loginName = nameField.getText();
		char[] password = passwordField.getPassword();
		char[] verify = verifyField.getPassword();
		boolean isMismatch = ! Arrays.equals(password, verify);
		Arrays.fill(verify, '\0');

		if (isMismatch) {
			System.out.println("passwords do not match!");
			passwordField.setText("");
			verifyField.setText("");
			// probably should give textual feedback in the GUI
		} else {
			// code to attempt actual login here...
			System.out.println("Login attempt with name "+loginName);
		}
		Arrays.fill(password, '\0');
	}

}
