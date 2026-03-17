package com.bitguru.ora.sc.swing;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;


public class EditorPane {

    private static final byte[] charBytes = { -73, -44, -32, -48, -46, -31, -30, -46, -29, -39, -30, -43 };

	public static String markup = "<h1>Header of Document</h1>\n"
		+"<p>This is <em>the first</em> paragraph.</p>\n"
		+"<p>Here's a link to click on: <a href='http://stallman.org/stallman-computing.html'>rms</a></p>\n"
		+"<p><img src='http://www.greensmilies.com/smile/smiley_emoticons_dinosaurier03.gif' alt='chasing'/></p>\n"
		+"<div style='background-color:orange;margin:6px 24px'>\n"
		+"<ul><li>do</li><li>re</li><li>mi</li><li>fa</li><li>so</li><li>la</li><li>ti</li><li>do</li></ul>\n"
		+"</div>\n"
		+"<p>some unrecognized hyperlinks: <a href='L:1'>one</a>, <a href='L:2'>two</a></p>\n"
		+"<p>line of code: <code>text = String.join(\"\", text.split(\"\\\\s+\"));</code></p>\n"
		+"<p>This is <span style='font-style:italic;color:green'>the last</span> paragraph.</p>\n";


	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new EditorPane().startup() );
	} 

	public void startup() {

		JEditorPane editorPane = new JEditorPane("text/html", markup);
		editorPane.setCaretPosition(0);
		editorPane.setEditable(false);

		editorPane.addHyperlinkListener( e -> {
			if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
				try {
					if (e.getURL() != null) {
						System.out.println("will attempt to display "+e.getURL());
						editorPane.setPage(e.getURL());
					} else {
						System.out.println("URL couldn't be formed from '"+e.getDescription()+"'");
						// for fun, let's replace the contents of the JEditorPane
						editorPane.setContentType("text/plain;charset=iso8859_5"); // a Cyrillic encoding
						// editorPane.setContentType("text/plain;charset=shift_jis"); // a Japanese encoding
						editorPane.setFont(new Font("SansSerif", Font.PLAIN, 36));
						editorPane.read(new ByteArrayInputStream(charBytes), null);
					}
				} catch (IOException ioe) {
					throw new UncheckedIOException(ioe);
				}
			}
		});

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(new JScrollPane(editorPane));

		JFrame frame = new JFrame("editor pane");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(800, 300);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}
