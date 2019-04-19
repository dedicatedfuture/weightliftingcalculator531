package edu.psgv.sweng861;

import javax.swing.table.AbstractTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TimeZone;

public class MyTableModel extends AbstractTableModel {
	 private ArrayList<Integer> oHPressSet1;
	 private ArrayList<Integer> oHPressSet2;
	 private ArrayList<Integer> oHPressSet3;
	 private ArrayList<Integer> oHPressSet4;
	 
	 private ArrayList<Integer> deadliftSet1;
	 private ArrayList<Integer> deadliftSet2;
	 private ArrayList<Integer> deadliftSet3;
	 private ArrayList<Integer> deadliftSet4;
	 
	 private ArrayList<Integer> benchSet1;
	 private ArrayList<Integer> benchSet2;
	 private ArrayList<Integer> benchSet3;
	 private ArrayList<Integer> benchSet4;
	 
	 private ArrayList<Integer> squatSet1;
	 private ArrayList<Integer> squatSet2;
	 private ArrayList<Integer> squatSet3;
	 private ArrayList<Integer> squatSet4;
	 
	 
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
			
			try {
				updateDatabase();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
	
	
	//establishing connection to database now, may need to move database communication to 
	//another class later
	public void updateDatabase() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		Connection connection = null;
		String databaseName = "weightlifting531";
		String url = "jdbc:mysql://localhost:3306/" + databaseName+"?serverTimezone=" + TimeZone.getDefault().getID();
		String username = "root";
		String password = "password";
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			Statement stmt = connection.createStatement();
		
			//PreparedStatement ps = connection.prepareStatement("INSERT INTO user (name, password) VALUES ('bill', 'password');");																
//			PreparedStatement ps = connection.prepareStatement("INSERT INTO exercise (name, monthID, userID) "
//					+ "VALUES ('Overhead Press', '1', '1');");

			//OverHead Press Database Update
			String overHeadPressSQL = String.format("INSERT INTO totalmonth(exercise, week1set1, week1set2, week1set3, "
					+ "week2set1, week2set2, week2set3, week3set1, week3set2, week3set3,"
					+ "week4set1, week4set2, week4set3) VALUES('Overhead Press', %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d);", 
				oHPressSet1.get(0), oHPressSet1.get(1), oHPressSet1.get(2), 
					oHPressSet2.get(0), oHPressSet2.get(1), oHPressSet2.get(2), 
					oHPressSet3.get(0), oHPressSet3.get(1), oHPressSet3.get(2), 
					oHPressSet4.get(0), oHPressSet4.get(1), oHPressSet4.get(2));
		
			PreparedStatement psOverhead= connection.prepareStatement(overHeadPressSQL);
			psOverhead.executeUpdate();
			
			//Deadlift Database Update
			String deadliftSQL = String.format("INSERT INTO totalmonth(exercise, week1set1, week1set2, week1set3, "
					+ "week2set1, week2set2, week2set3, week3set1, week3set2, week3set3,"
					+ "week4set1, week4set2, week4set3) VALUES('Deadlift', %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d);", 
				deadliftSet1.get(0), deadliftSet1.get(1), deadliftSet1.get(2), 
				deadliftSet2.get(0), deadliftSet2.get(1), deadliftSet2.get(2), 
				deadliftSet3.get(0), deadliftSet3.get(1), deadliftSet3.get(2), 
				deadliftSet4.get(0), deadliftSet4.get(1), deadliftSet4.get(2));

			PreparedStatement psDeadlift= connection.prepareStatement(deadliftSQL);
			psDeadlift.executeUpdate();
			
			//Bench Database Update
			String benchSQL = String.format("INSERT INTO totalmonth(exercise, week1set1, week1set2, week1set3, "
					+ "week2set1, week2set2, week2set3, week3set1, week3set2, week3set3,"
					+ "week4set1, week4set2, week4set3) VALUES('Deadlift', %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d);", 
				benchSet1.get(0), benchSet1.get(1), benchSet1.get(2), 
				benchSet2.get(0), benchSet2.get(1), benchSet2.get(2), 
				benchSet3.get(0), benchSet3.get(1), benchSet3.get(2), 
				benchSet4.get(0), benchSet4.get(1), benchSet4.get(2));

			PreparedStatement psBench= connection.prepareStatement(benchSQL);
			psBench.executeUpdate();
			
			//Squat Database Update
			String squatSQL = String.format("INSERT INTO totalmonth(exercise, week1set1, week1set2, week1set3, "
					+ "week2set1, week2set2, week2set3, week3set1, week3set2, week3set3,"
					+ "week4set1, week4set2, week4set3) VALUES('Deadlift', %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d);", 
				squatSet1.get(0), squatSet1.get(1), squatSet1.get(2), 
				squatSet2.get(0), squatSet2.get(1), squatSet2.get(2), 
				squatSet3.get(0), squatSet3.get(1), squatSet3.get(2), 
				squatSet4.get(0), squatSet4.get(1), squatSet4.get(2));

			PreparedStatement psSquat= connection.prepareStatement(squatSQL);
			psSquat.executeUpdate();
			


			
			//int status = ps.executeUpdate();
			
			//add to database
			
			 String strSelect = "SELECT * FROM totalmonth;";
	         System.out.println("The SQL statement is: " + strSelect + "\n");  // Echo for debugging
	         ResultSet rset = stmt.executeQuery(strSelect);
	         while(rset.next()) {   // Move the cursor to the next row
	            System.out.println(rset.getInt("idtotalmonth") + ", "
	                    + rset.getString("exercise") + ", "
	                    + rset.getString("week1set1") + ", "
	                    + rset.getString("week1set2") + ", "
	                    + rset.getString("week1set3") + ", "
	                    + rset.getString("week2set1") + ", "
	    	            + rset.getString("week2set2") + ", "
	    	            + rset.getString("week2set3") + ", "
	    	            + rset.getString("week3set1") + ", "
	    	            + rset.getString("week3set2") + ", "
	    	            + rset.getString("week3set3") + ", "
	    	            + rset.getString("week4set1") + ", "
	    	            + rset.getString("week4set2") + ", "
	    	            + rset.getString("week4set3")
	                    );
	         }
			
		
			
//			 String strSelect = "SELECT * FROM user;";
//	         System.out.println("The SQL statement is: " + strSelect + "\n");  // Echo for debugging
//	         ResultSet rset = stmt.executeQuery(strSelect);
//	         while(rset.next()) {   // Move the cursor to the next row
//	            System.out.println(rset.getInt("userID") + ", "
//	                    + rset.getString("name") + ", "
//	                    + rset.getString("password")
//	                    );
//	         }
			
			
//			if(status != 0) {
//				System.out.println("Database was connected");
//				System.out.println("record was inserted");
//				
//			}
			
			if(connection !=null) {
				System.out.println("connected successfully!!!!!");
			}
		}catch(SQLException e) {
			System.out.println("database not connecting");
			System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		}finally {
			if(connection !=null) {
				try {
				connection.close();
				}catch(SQLException e) {
					System.out.println(e);
				}
			}
		}
	}
	
	public void fillInTable(int row, ArrayList<Integer> setList) {		
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
