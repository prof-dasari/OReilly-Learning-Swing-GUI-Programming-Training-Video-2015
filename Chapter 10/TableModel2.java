package com.bitguru.ora.sc.swing;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;


public class TableModel2 {

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new TableModel2().startup() );
	} 

	public void startup() {

		Color[] someColors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
				Color.GREEN, Color.GREEN.darker(), Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
				Color.PINK, Color.RED, Color.WHITE, Color.YELLOW, Color.YELLOW.darker() };

		JTable table = new JTable(new ColorTableModel(someColors));

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

		JFrame frame = new JFrame("editable table models");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(500, 400);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}


	private static class ColorTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private final Color[] rows;
		
		public ColorTableModel(Color[] colors) {
			rows = colors;
		}

		@Override
		public int getRowCount() {
			return rows.length;
		}

		@Override
		public int getColumnCount() {
			return 5;
		}

		@Override
		public String getColumnName(int col) {
			switch (col) {
			case 0: return "red";
			case 1: return "green";
			case 2: return "blue";
			case 3: return "shaded ball";
			case 4: return "achromatic";
			default: return null;
			}
		}

		@Override
		public Class<?> getColumnClass(int col) {
			switch (col) {
			case 0: return Integer.class;
			case 1: return Integer.class;
			case 2: return Integer.class;
			case 3: return Icon.class;
			case 4: return Boolean.class;
			default: return Object.class;
			}
		}

		@Override
		public Object getValueAt(int row, int col) {
			switch (col) {
			case 0: return rows[row].getRed();
			case 1: return rows[row].getGreen();
			case 2: return rows[row].getBlue();
			case 3: return new BallIcon(13, rows[row]);
			case 4: return rows[row].getRed()==rows[row].getGreen() && rows[row].getRed()==rows[row].getBlue();
			default: return null;
			}
		}

		@Override
		public boolean isCellEditable(int row, int col) {
			return ( col < 3 );
		}

		@Override
		public void setValueAt(Object value, int row, int col) {
			int n = ((Number)value).intValue();
			Color old = rows[row];
			Color newc = new Color( (col==0)?n:old.getRed(), (col==1)?n:old.getGreen(), (col==2)?n:old.getBlue() );
			if ( ! newc.equals(old) ) {
				rows[row] = newc;
				//fireTableCellUpdated(row, col);
				//fireTableCellUpdated(row, 3);
				//fireTableCellUpdated(row, 4);
				fireTableRowsUpdated(row, row);
			}
		}

	}

}
