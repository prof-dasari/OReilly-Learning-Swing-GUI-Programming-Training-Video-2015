package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TextArea {

	public static final String announcement = "This is a test of the Emergency Broadcast "
			+ "System. The broadcasters of your area, in voluntary cooperation with "
			+ "federal, state, and local authorities, have developed this system to "
			+ "keep you informed in the event of an emergency. This is only a test.\n"
			+ "If this had been an actual emergency, the attention signal you just heard "
			+ "would have been followed by official information, news, or instructions.\n"
			+ "This concludes this test of the Emergency Broadcast System.";

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new TextArea().startup() );
	} 

	public void startup() {

		JTextArea textarea = new JTextArea(announcement);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true); // does nothing without previous line

		JButton saveButton = new JButton("Save to file");
		JButton readButton = new JButton("Read from file");

		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
		southPanel.add(saveButton);
		southPanel.add(readButton);

		File temporaryFile;
		try {
			temporaryFile = File.createTempFile("JTextArea", ".txt");
		} catch (IOException ioe) {
			throw new UncheckedIOException(ioe);
		}

		saveButton.addActionListener( e -> {
			try ( Writer out = new BufferedWriter(new FileWriter(temporaryFile)) ) {
				textarea.write(out);
			} catch (IOException ioe) {
				throw new UncheckedIOException(ioe);
			}
		} );

		readButton.addActionListener( e -> {
			try ( Reader inn = new BufferedReader(new FileReader(temporaryFile)) ) {
				textarea.read(inn, null);
			} catch (IOException ioe) {
				throw new UncheckedIOException(ioe);
			}
		} );

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
		mainPanel.add(new JScrollPane(textarea), BorderLayout.CENTER);
		mainPanel.add(southPanel, BorderLayout.SOUTH);

		JFrame frame = new JFrame("text area");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(445, 265);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
