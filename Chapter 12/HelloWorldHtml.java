package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class HelloWorldHtml {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new HelloWorldHtml().startup() );
	}

	public void startup() {
		JLabel greeting = new JLabel(
				"<html>Hello, <span style='color:blue;font-size:18;font-style:italic'>big<br>blue</span> world!",
				JLabel.CENTER);

		JButton button = new JButton(
				"<html><p style='text-align:center'>Thanks<br><span style='color:red'>for</span><br>watching.</p>");

		JFrame frame = new JFrame("Important Message");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(greeting); // defaults to CENTER
		frame.getContentPane().add(button, BorderLayout.SOUTH);
		frame.setSize(240, 160);
		frame.setVisible(true);
	}
}