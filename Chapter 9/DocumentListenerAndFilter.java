package com.bitguru.ora.sc.swing;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class DocumentListenerAndFilter {

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new DocumentListenerAndFilter().startup() );
	} 

	public void startup() {

		JTextField plainField = new JTextField();
		JTextField numericField = new JTextField();
		JLabel statusLabel = new JLabel();

		plainField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				react();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				react();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				react();
			}
			private void react() {
				statusLabel.setText(plainField.getText());
			}
		});

		((AbstractDocument)numericField.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void insertString(FilterBypass bypass, int offset, String text, AttributeSet attributes)
					throws BadLocationException {
				if (text != null) text = String.join("", text.split("\\D+"));
				bypass.insertString(offset, text, attributes);
			}
			// @Override
			//  public void remove(FilterBypass bypass, int offset, int length) throws BadLocationException {
			// 	bypass.remove(offset, length);
			// }
			@Override
			public void replace(FilterBypass bypass, int offset, int length, String text, AttributeSet attributes)
					throws BadLocationException {
				if (text != null) text = String.join("", text.split("\\D+"));
				bypass.replace(offset, length, text, attributes);
			}
		});

		JPanel labelsPanel = new JPanel(new GridLayout(0, 1, 0, 5));
		JPanel fieldsPanel = new JPanel(new GridLayout(0, 1, 0, 5));
		JPanel formPanel = new JPanel(new BorderLayout(5, 5));
		formPanel.add(labelsPanel, BorderLayout.WEST);
		formPanel.add(fieldsPanel, BorderLayout.CENTER);

		labelsPanel.add(new JLabel("plain", JLabel.RIGHT));
		fieldsPanel.add(plainField);

		labelsPanel.add(new JLabel("filtered", JLabel.RIGHT));
		fieldsPanel.add(numericField);

		labelsPanel.add(new JLabel(""));
		fieldsPanel.add(statusLabel);

		JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(formPanel, BorderLayout.NORTH);

		JFrame frame = new JFrame("document listener and filter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(320, 180);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
