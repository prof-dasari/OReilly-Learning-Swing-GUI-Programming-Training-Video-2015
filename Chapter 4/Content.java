package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;

public class Content {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new Content().startup() );
	} 

	public void startup() {

		JLabel contents = new JLabel("honey, chocolate liquor, oil of peppermint", JLabel.CENTER);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.PINK, 20));
		mainPanel.add(contents);

		JFrame frame = new JFrame("Contents");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setContentPane(mainPanel);

		frame.setSize(400, 200);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}


