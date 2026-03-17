package com.bitguru.ora.sc.swing;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;


public class TextPane {

	/** this string's newline locations: 9, 30, 40, 55, 65, 130, 140, 156, 273 */
	public static final String beckett = "VLADIMIR:\n"
			+ "Suppose we repented.\n"
			+ "ESTRAGON:\n"
			+ "Repented what?\n"
			+ "VLADIMIR:\n"
			+ "Oh . . . (He reflects.) We wouldn't have to go into the details.\n"
			+ "ESTRAGON:\n"
			+ "Our being born?\n"
			+ "Vladimir breaks into a hearty laugh which he immediately stifles, "
			+ "his hand pressed to his pubis, his face contorted.\n";

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new TextPane().startup() );
	} 

	public void startup() {

		JTextPane textPane = new JTextPane();
		textPane.setText(beckett);

		SimpleAttributeSet attrs = new SimpleAttributeSet();
		StyleConstants.setItalic(attrs, true);
		StyleConstants.setFontFamily(attrs, "Serif");
		StyleConstants.setFontSize(attrs, 14);
		// apply the AttributeSet to the stage directions
		textPane.getStyledDocument().setCharacterAttributes(75, 14, attrs, false);
		textPane.getStyledDocument().setCharacterAttributes(157, 116, attrs, false);

		// textPane.select(31, 39);
		// textPane.setCaretPosition(139);
		// StyleConstants.setForeground(textPane.getInputAttributes(), Color.RED);
		// textPane.replaceSelection(" INSERTED");

		textPane.setCaretPosition(157);
		textPane.insertIcon(new BallIcon(10, Color.CYAN));
	
		textPane.setCaretPosition(textPane.getDocument().getLength());
		JButton button = new JButton("button");
		textPane.insertComponent(button);
	
		Style charHead = textPane.addStyle("charecter_header", null);
		StyleConstants.setSpaceAbove(charHead, 6);
		StyleConstants.setLeftIndent(charHead, 36);
		// Apply the Style to the character header paragraphs
		textPane.getStyledDocument().setLogicalStyle(0, charHead);
		textPane.getStyledDocument().setLogicalStyle(31, charHead);
		textPane.getStyledDocument().setLogicalStyle(56, charHead);
		textPane.getStyledDocument().setLogicalStyle(131, charHead);
		StyleConstants.setForeground(charHead, Color.ORANGE.darker());

		button.addActionListener( e -> StyleConstants.setBold(charHead, !StyleConstants.isBold(charHead)) );

		// Can use a Style as an AttributeSet, but it will not notice when the Style changes.
		textPane.getStyledDocument().setCharacterAttributes(180, 13, charHead, true);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(new JScrollPane(textPane), BorderLayout.CENTER);

		JFrame frame = new JFrame("text pane");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(420, 315);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}





