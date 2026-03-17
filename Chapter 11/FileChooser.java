package com.bitguru.ora.sc.swing;

import java.awt.*;
import javax.swing.*;
import java.io.*;


public class FileChooser {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new FileChooser().startup() );
	}

	public void startup() {
		
		JFrame frame = new JFrame("file chooser");

		JTextArea textarea = new JTextArea("Your Ad Here!\n");
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);

		JButton saveButton = new JButton("Save...");
		JButton readButton = new JButton("Read...");

		// java.awt.FileDialog vs. javax.swing.JFileChooser

		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
		southPanel.add(saveButton);
		southPanel.add(readButton);

		// use FileDialog for save button
		saveButton.addActionListener( e -> {
			FileDialog fd = new FileDialog(frame, "Please choose where to save", FileDialog.SAVE);
			// fd.setDirectory("/tmp"); // usually better not to set this
			fd.setMultipleMode(true);

			fd.setVisible(true);

			File[] files = fd.getFiles();
			// System.out.println("all of the files: "+java.util.Arrays.toString(files));

			if (fd.getFile() == null) {
				System.out.println("user canceled");
			} else {
				File file = new File(fd.getDirectory(), fd.getFile());
				System.out.println("user chose "+file);

				try (Writer writer = new BufferedWriter(new FileWriter(file))) {
					textarea.write(writer);
				} catch (IOException ioe) {
					throw new UncheckedIOException(ioe);
				}
			}
		} );

		// use JFileChooser for read button (even though FileDialog would usually be better)
		readButton.addActionListener( e -> {
			JFileChooser fc = new JFileChooser(new File("/tmp"));
			// fc.setMultiSelectionEnabled(true);
			
			// fc.setFileView(...); // can change the small icon beside each listed file, among other things
			
			// create an optional accessory panel for the JFileChooser
			JPanel accessoryPanel = new JPanel(new BorderLayout());
			JSlider slider = new JSlider(JSlider.VERTICAL, 0, 10, 2);
			slider.setMajorTickSpacing(1);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			accessoryPanel.add(slider, BorderLayout.EAST);
			accessoryPanel.add(new JCheckBox("Prop", true), BorderLayout.SOUTH);
			accessoryPanel.setBorder(BorderFactory.createEtchedBorder());
			fc.setAccessory(accessoryPanel);
			//fc.addPropertyChangeListener(...); // if need to update the accessoryPanel on user clicks

			int result = fc.showOpenDialog(textarea);
			// int result = fc.showDialog(textarea, "Insert"); // custom button text

			if (result != JFileChooser.APPROVE_OPTION) {
				System.out.println("user canceled (or error)");
			} else {
				File file = fc.getSelectedFile();
				System.out.println("user chose "+file);
				// File[] files = fc.getSelectedFiles(); // empty array without multiSelectionEnabled

				try (Reader reader = new BufferedReader(new FileReader(file))) {
					textarea.read(reader, file.getPath());
				} catch (IOException ioe) {
					throw new UncheckedIOException(ioe);
				}
			}
		} );
		

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
		mainPanel.add(new JScrollPane(textarea), BorderLayout.CENTER);
		mainPanel.add(southPanel, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(445, 265);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
