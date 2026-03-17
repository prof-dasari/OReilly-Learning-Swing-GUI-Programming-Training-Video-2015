package com.bitguru.ora.sc.swing;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;


public class TableEditor {

	public static void main(String[] argv) {
		SwingUtilities.invokeLater( () -> new TableEditor().startup() );
	} 

	public void startup() {

		PersonTableModel personTableModel = new PersonTableModel(Person.somePeople());
		JTable table = new JTable(personTableModel);
		table.setRowHeight(20);
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.setAutoCreateRowSorter(true);

		// invoke cell editor on single click instead of double click
		TableCellEditor existingEditor = table.getDefaultEditor(Object.class);
		((DefaultCellEditor)existingEditor).setClickCountToStart(1);
		// beyond Object.class, could do the same for Number.class, Double.class, Float.class, Date.class

		JComboBox<String> editorBox = new JComboBox<>(new String[] {"Mrs.", "Ms.", "Miss", "Mr.", "Col.", "Capt."});
		//editorBox.setEditable(true);
		TableCellEditor comboEditor = new DefaultCellEditor(editorBox);
		//table.getColumnModel().getColumn(0).setCellEditor(comboEditor);
		table.setDefaultEditor(Person.class, comboEditor);


		JButton addRow = new JButton("Add Row");
		addRow.addActionListener( e -> personTableModel.addRow(new Person(null, null, null)) );

		JButton delRow = new JButton("Delete Selected Row");
		delRow.addActionListener( e -> {
			int viewIndex = table.getSelectedRow();
			if (viewIndex >= 0) {
				personTableModel.deleteRow(table.convertRowIndexToModel(viewIndex));
			}
		} );

		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		southPanel.add(addRow);
		southPanel.add(delRow);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 5, 20));
		mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		mainPanel.add(southPanel, BorderLayout.SOUTH);

		JFrame frame = new JFrame("table editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mainPanel);
		frame.setSize(400, 320);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public static class Person {
		private String title, forename, surname;

		public Person(String title, String forename, String surname) {
			this.title = title;
			this.forename = forename;
			this.surname = surname;
		}
		public static Person[] somePeople() {
			return new Person[] {
					new Person("Col.", "Harland", "Sanders"),
					new Person("Mrs.", "Joy", "Butterworth"),
					new Person("Ms.", "Wendy", "Thomas"),
					new Person("Capt.", "Horatio", "Crunch"),
					new Person("Mr.", "George", "Whipple"),
					new Person("Mr.", "Chester", "Cheetah"),
					new Person("Miss", "Chiquita", "Banana"),
					new Person("Mr.", "Alfred", "Neuman"),
					new Person("Mr.", "Juan", "Valdez") };
		}
	}

	private static class PersonTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private final ArrayList<Person> people;

		public PersonTableModel(Person[] persons) {
			people = new ArrayList<>(persons.length);
			for (Person person : persons) people.add(person);
		}

		@Override
		public int getRowCount() {
			return people.size();
		}

		public void addRow(Person person) {
			int newRowIndex = people.size();
			people.add(person);
			fireTableRowsInserted(newRowIndex, newRowIndex);
		}

		public void deleteRow(int row) {
			if (row >= 0 && row < people.size()) {
				people.remove(row);
				fireTableRowsDeleted(row, row);
			}
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public String getColumnName(int col) {
			switch (col) {
				case 0: return "Title";
				case 1: return "Forename";
				case 2: return "Surname";
				default: return null;
			}
		}

		@Override
		public Class<?> getColumnClass(int col) {
			switch (col) {
				case 0: return Person.class; // a lie, since it's actually a String
				case 1: return String.class;
				case 2: return String.class;
				default: return Object.class;
			}
		}

		@Override
		public Object getValueAt(int row, int col) {
			switch (col) {
				case 0: return people.get(row).title;
				case 1: return people.get(row).forename;
				case 2: return people.get(row).surname;
				default: return null;
			}
		}

		@Override
		public boolean isCellEditable(int row, int col) {
			return true;
		}

		@Override
		public void setValueAt(Object value, int row, int col) {
			if (value instanceof String) {
				switch (col) {
					case 0: people.get(row).title = (String)value;
						    break;
					case 1:	people.get(row).forename = (String)value;
						    break;
					case 2: people.get(row).surname = (String)value;
						    break;
				}
				fireTableCellUpdated(row, col);
			}
		}
	}

}
