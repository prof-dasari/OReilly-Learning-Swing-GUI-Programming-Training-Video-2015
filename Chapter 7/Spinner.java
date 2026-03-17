package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

public class Spinner {

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new Spinner().startup() );
	} 

	public void startup() {

		JSpinner spin0 = new JSpinner();
		spin0.setValue(4);

		JSpinner spin1 = new JSpinner(new SpinnerNumberModel(0.5, null, null, 0.1));
		// spin1.setEditor(new JSpinner.NumberEditor(spin1, "0.0;(0.0)"));

		JSpinner spin2 = new JSpinner(new SpinnerDateModel());
		spin2.setEditor(new JSpinner.DateEditor(spin2, "MMM d, yyyy"));
		LocalDateTime ldt = LocalDateTime.of(2015, 9, 8, 23, 35);
		Date date = Date.from(ldt.atZone(java.time.ZoneOffset.systemDefault()).toInstant());
		spin2.setValue(date);

		ArrayList<String> modes = new ArrayList<>();
		modes.add("plane");
		modes.add("train");
		modes.add("boat");
		modes.add("car");
		modes.add("bike");
		JSpinner spin3 = new JSpinner(new SpinnerListModel(modes));
		spin3.setValue("boat");

		ChronoUnit[] units = ChronoUnit.values();
		JSpinner spin4 = new JSpinner(new SpinnerListModel(units));
		spin4.setValue(ChronoUnit.HOURS);

		JPanel northPanel = new JPanel(new GridLayout(0, 1, 0, 10));
		northPanel.add(spin0);
		northPanel.add(spin1);
		northPanel.add(spin2);
		northPanel.add(spin3);
		northPanel.add(spin4);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(northPanel, BorderLayout.NORTH);

		JFrame frame = new JFrame("Spinner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(200, 250);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
