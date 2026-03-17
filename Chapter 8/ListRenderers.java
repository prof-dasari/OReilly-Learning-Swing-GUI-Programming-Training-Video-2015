package com.bitguru.ora.sc.swing;

import java.awt.*;
import java.io.Serializable;

import javax.swing.*;
import javax.swing.border.Border;

public class ListRenderers {

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new ListRenderers().startup() );
	} 

	public void startup() {

		Integer[] possibleValues = new Integer[] { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };

		JComboBox<Integer> combo = new JComboBox<>(possibleValues);
		combo.setPrototypeDisplayValue(1000);
		LabelRenderer customRenderer = new LabelRenderer();
		combo.setRenderer(customRenderer);

		JList<Integer> jlist = new JList<>(possibleValues);
		//jlist.setPrototypeCellValue(1000);
		jlist.setCellRenderer(new SliderRenderer(20));
		jlist.setFixedCellWidth(120);

		JPanel mainPanel = new JPanel(); // FlowLayout
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(combo);
		mainPanel.add(new JScrollPane(jlist));

		JFrame frame = new JFrame("List Renderers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(320, 320);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}


	public static class LabelRenderer extends DefaultListCellRenderer {
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<?> jlist,
				Object value, int index, boolean isSelected, boolean cellHasFocus) {
			// Next line set the Label's border, icon, text, font, fg color, bg color, and enabled status.			
			JLabel lab = (JLabel)super.getListCellRendererComponent(jlist, value, index, isSelected, cellHasFocus);
			// do further configuration
			if (isSelected) {
				lab.setHorizontalAlignment(JLabel.RIGHT);
			} else {
				lab.setHorizontalAlignment(JLabel.LEFT);
			}
			// set icon (note: could restructure this to not instantiate a new BallIcon on every call)
			if (value instanceof Number) {
				int scaled = 12 * ((Number)value).intValue();
				int rgb = Math.max(0, Math.min(scaled, 255));
				lab.setIcon(new BallIcon(15, new Color(0, rgb, 255-rgb)));
			}
			return lab;
		}		
	}


	public static class SliderRenderer implements ListCellRenderer<Integer>, Serializable {
		private static final long serialVersionUID = 1L;

		private final JSlider slider;
		private final Border normalBorder = BorderFactory.createEmptyBorder(1, 1, 1, 1);
		private final Border focusBorder = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);

		public SliderRenderer(int max) {
			slider = new JSlider(JSlider.HORIZONTAL, 0, max, 0);
			// note: could override certain methods in JSlider to make it more efficient as a renderer
			slider.setMinorTickSpacing(5);
			slider.setPaintTicks(true);
		}

		@Override
		public Component getListCellRendererComponent(JList<? extends Integer> jlist,
				Integer value, int index, boolean isSelected, boolean cellHasFocus) {

			slider.setValue(value);
			slider.setBackground( isSelected ? jlist.getSelectionBackground() : jlist.getBackground() );
			slider.setBorder( cellHasFocus ? focusBorder : normalBorder );
			return slider;
		}		
	}

}
