package com.bitguru.ora.sc.swing;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;


public class TableProperties {

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new TableProperties().startup() );
	} 

	public void startup() {
		Color[] someColors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
				Color.GREEN, Color.GREEN.darker(), Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
				Color.PINK, Color.RED, Color.WHITE, Color.YELLOW, Color.YELLOW.darker() };

		JTable table = new JTable(new ColorTableModel(someColors));

		table.getTableHeader().setReorderingAllowed(false);
		//table.getTableHeader().setResizingAllowed(false);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//table.getColumn("blue").setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.getColumnModel().getColumn(2).setMaxWidth(75);

		//table.setShowGrid(false);
		table.setGridColor(Color.PINK);
		table.setSelectionBackground(Color.YELLOW);

		//table.setRowSelectionAllowed(false);
		//table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);

		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		//table.setAutoCreateRowSorter(true);
		TableRowSorter<?> rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		rowSorter.setSortable(3, false);

		// Show only rows that contain 255 in at least one column, hide the rows that don't.
		rowSorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, 255));

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

		JFrame frame = new JFrame("table properties");
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
				fireTableRowsUpdated(row, row);
			}
		}
	}

}
