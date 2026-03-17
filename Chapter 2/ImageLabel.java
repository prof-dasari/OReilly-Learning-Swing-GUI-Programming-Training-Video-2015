package com.bitguru.ora.sc.swing;

import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.UncheckedIOException;

public class ImageLabel {
	
	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new ImageLabel().startup() );
	}
	
	public void startup() {
		
		// Icon icon = new ImageIcon("c:/Temp/image.png");
		
		// Icon icon = new ImageIcon("/tmp/publicdomain_vanGogh.jpeg");
		
		// Icon icon = new ImageIcon(new URL("http://www.host.com/image.jpg")); // must catch exception
		
		// Icon icon = new ImageIcon(getGreensmiliesURL());
		
		// Icon icon = new ImageIcon(getClass().getResource("publicdomain_vonForster.jpeg"));

		// Icon icon = new ImageIcon(ClassLoader.getSystemResource("com/bitguru/ora/sc/swing/publicdomain_vonForster.jpeg"));
		
		Icon icon = new BallIcon(64, Color.YELLOW);

		JLabel greeting = new JLabel("Hello", icon, JLabel.CENTER);
		greeting.setFont(new Font("serif", Font.PLAIN, 24));
		greeting.setHorizontalTextPosition(JLabel.CENTER); // choices: LEFT (or LEADING), CENTER, RIGHT (or TRAILING)
		greeting.setVerticalTextPosition(JLabel.BOTTOM); // choices: TOP, CENTER, BOTTOM
		
		JFrame frame = new JFrame("Labels with Images");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(greeting);
		frame.setSize(540, 400);
		frame.setVisible(true);
	}





	/**
	 * Return a URL to an animated GIF served by www.greensmilies.com, because
	 * Michael Niedermayr (the greensmilies.com guy) kindly permits hot-linking.
	 * 
	 * @return a java.net.URL object
	 */
	public URL getGreensmiliesURL() {
		try {
			return new URL("http://www.greensmilies.com/smile/smiley_emoticons_dinosaurier03.gif");
		} catch (MalformedURLException mue) {
			// re-throw as a RuntimeException [Pre-java8? Then use IllegalArgumentException(mue) instead.]
			throw new UncheckedIOException(mue);
		}
	}
	
}