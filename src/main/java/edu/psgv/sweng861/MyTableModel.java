package edu.psgv.sweng861;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {
	 private ArrayList<Double> oHPressSet1;
	 private ArrayList<Double> oHPressSet2;
	 private ArrayList<Double> oHPressSet3;
	 private ArrayList<Double> oHPressSet4;
	 
	 private ArrayList<Double> deadliftSet1;
	 private ArrayList<Double> deadliftSet2;
	 private ArrayList<Double> deadliftSet3;
	 private ArrayList<Double> deadliftSet4;
	 
	 private ArrayList<Double> benchSet1;
	 private ArrayList<Double> benchSet2;
	 private ArrayList<Double> benchSet3;
	 private ArrayList<Double> benchSet4;
	 
	 private ArrayList<Double> squatSet1;
	 private ArrayList<Double> squatSet2;
	 private ArrayList<Double> squatSet3;
	 private ArrayList<Double> squatSet4;
	 
	 
	 private double oHPressMax;
     private double deadliftMax;
	 private double benchMax;
	 private double squatMax;
	 private WeightCalculator calculator;
	 
	 public MyTableModel(double oHPressMax, double deadliftMax, double benchMax, double squatMax) {
			
		 	this.calculator = new WeightCalculator();
		 	
		 	this.oHPressMax = oHPressMax;
		 	this.deadliftMax = deadliftMax;
		 	this.benchMax = benchMax;
		 	this.squatMax = squatMax;
		 
		 	this.oHPressSet1 = this.calculator.calcWeekOne(this.oHPressMax);
		 	this.oHPressSet2 = this.calculator.calcWeekTwo(this.oHPressMax);
		 	this.oHPressSet3 = this.calculator.calcWeekThree(this.oHPressMax);
		 	this.oHPressSet4 = this.calculator.calcWeekFour(this.oHPressMax);
		 	
		 	this.deadliftSet1 = this.calculator.calcWeekOne(this.deadliftMax);
		 	this.deadliftSet2 = this.calculator.calcWeekTwo(this.deadliftMax);
		 	this.deadliftSet3 = this.calculator.calcWeekThree(this.deadliftMax);
		 	this.deadliftSet4 = this.calculator.calcWeekFour(this.deadliftMax);
		 	
		 	this.benchSet1 = this.calculator.calcWeekOne(this.benchMax);
		 	this.benchSet2 = this.calculator.calcWeekTwo(this.benchMax);
		 	this.benchSet3 = this.calculator.calcWeekThree(this.benchMax);
		 	this.benchSet4 = this.calculator.calcWeekFour(this.benchMax);
		 	
		 	this.squatSet1 = this.calculator.calcWeekOne(this.squatMax);
		 	this.squatSet2 = this.calculator.calcWeekTwo(this.squatMax);
		 	this.squatSet3 = this.calculator.calcWeekThree(this.squatMax);
		 	this.squatSet4 = this.calculator.calcWeekFour(this.squatMax);
		 	
			fillInTable(1, oHPressSet1);
			fillInTable(2, oHPressSet2);
			fillInTable(3, oHPressSet3);
			fillInTable(4, oHPressSet4);
			
			fillInTable(7, deadliftSet1);
			fillInTable(8, deadliftSet2);
			fillInTable(9, deadliftSet3);
			fillInTable(10, deadliftSet4);
			
			fillInTable(13, benchSet1);
			fillInTable(14, benchSet2);
			fillInTable(15, benchSet3);
			fillInTable(16, benchSet4);
			
			fillInTable(19, squatSet1);
			fillInTable(20, squatSet2);
			fillInTable(21, squatSet3);
			fillInTable(22, squatSet4);
			
		}
	
	String[] columnNames = {"Exercise", 
							"Set 1", 
							"Set 2", 
							"Set 3"};
	
	Object[][] data = {
			{"OverHead Press", " ", " ", " "},
			{"Week 1(3x5)",1 , 2 ,3},
			{"Week 2(3x3)", 95, 110, 125},
			{"Week 3(531)", 105, 115, 130},
			{"Week 4(3x5)", 55, 70, 85},
			{" ", " ", " ", " "},
			{"Deadlift", " ", " ", " "},
			{"Week 1(3x5)",1 , 2 ,3},
			{"Week 2(3x3)", 95, 110, 125},
			{"Week 3(531)", 105, 115, 130},
			{"Week 4(3x5)", 55, 70, 85}, 
			{" ", " ", " ", " "},
			{"Bench", " ", " ", " "},
			{"Week 1(3x5)",1 , 2 ,3},
			{"Week 2(3x3)", 95, 110, 125},
			{"Week 3(531)", 105, 115, 130},
			{"Week 4(3x5)", 55, 70, 85}, 
			{" ", " ", " ", " "},
			{"Squat ", " ", " ", " "},
			{"Week 1(3x5)",1 , 2 ,3},
			{"Week 2(3x3)", 95, 110, 125},
			{"Week 3(531)", 105, 115, 130},
			{"Week 4(3x5)", 55, 70, 85}, 
	};
	
	
	
	
	public void fillInTable(int row, ArrayList<Double> setList) {
		
		for(int i = 1; i<= setList.size(); i++) {
			setValueAt(setList.get(i - 1), row, i);
		}
	}
	

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
