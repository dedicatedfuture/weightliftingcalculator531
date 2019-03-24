package edu.psgv.sweng861;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	
	
	
	String[] columnNames = {"Exercise", 
							"Set 1", 
							"Set 2", 
							"Set 3"};
	
	Object[][] data = {
			{"OverHead Press \n Week 1(3x5)", 90,105,115},
			{"Week 2(3x3)", 95, 110, 125},
			{"Week 3(531)", 105, 115, 130},
			{"Week 4(3x5)", 55, 70, 85}		
	};

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
	
	 public String getColumnName(int col) {
         return columnNames[col];
     }
	
	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}

}
