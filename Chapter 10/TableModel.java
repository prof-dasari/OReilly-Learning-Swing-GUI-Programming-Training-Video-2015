package com.bitguru.ora.sc.swing;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;


public class TableModel {

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new TableModel().startup() );
	} 

	public void startup() {

		JTable table = new JTable(new IntegerTableModel());

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

		JFrame frame = new JFrame("table models");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(500, 400);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	private static class IntegerTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;

		@Override
		public int getRowCount() {
			return 2_000_000;
		}

		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public String getColumnName(int col) {
			switch (col) {
			case 0: return "Integer";
			case 1: return "Parity";
			default: return null;
			}
		}

		@Override
		public Class<?> getColumnClass(int col) {
			switch (col) {
			case 0: return Integer.class;
			case 1: return String.class;
			default: return Object.class;
			}
		}

		@Override
		public Object getValueAt(int row, int col) {
			switch (col) {
			case 0: return row; // Integer.valueOf(row)
			case 1: return (row%2==0) ? "even" : "odd";
			default: return null;
			}
		}
	}

}
