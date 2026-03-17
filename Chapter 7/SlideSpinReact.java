package com.bitguru.ora.sc.swing;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.text.ParseException;

public class SlideSpinReact {

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new SlideSpinReact().startup() );
	} 

	public void startup() {

		JSlider slide = new JSlider(0, 25, 10);
		slide.setMajorTickSpacing(5);
		slide.setMinorTickSpacing(1);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);

		JSpinner spin = new JSpinner(new SpinnerNumberModel(10, 0, 25, 1));

		spin.addChangeListener( e -> slide.setValue((Integer)spin.getValue()) );

		slide.addChangeListener( e -> spin.setValue(slide.getValue()) );

//		slide.addChangeListener( e -> {
//			if (!slide.getValueIsAdjusting()) {
//				spin.setValue(slide.getValue());
//			}
//		});

		JButton button = new JButton("Print");
		button.addActionListener( e -> {
			System.out.println("slide is "+slide.getValue());
			int delta = slide.getValue() - getSpinnerValue(spin);
			System.out.println("spin is "+spin.getValue()+" ("+delta+" away)");
			
			Timer t = new Timer(2000, v -> System.out.println("now spin is "+getSpinnerValue(spin)) );
			t.setRepeats(false);
			t.start();
		});

		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(slide);
		mainPanel.add(spin);
		mainPanel.add(button);

		JFrame frame = new JFrame("Slide, Spin, React");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(350, 175);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public static int getSpinnerValue(JSpinner spin) {
		try {
			spin.commitEdit();
		} catch (ParseException e) {
			// revert invalid text to spinner's current value
			((ChangeListener)spin.getEditor()).stateChanged(new ChangeEvent(spin));
		}
		Number value = (Number)spin.getValue();
		return value.intValue();
	}

}
