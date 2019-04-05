package edu.psgv.sweng861;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TimeZone;

import javax.swing.table.AbstractTableModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StrengthTableModel extends AbstractTableModel {
	
	 private boolean sex;
	 private Double userWeight;
	 private ArrayList<Integer> overHeadPressStandard;
	 private ArrayList<Integer> deadliftStandard;
	 private ArrayList<Integer> squatStandard;
	 private ArrayList<Integer> benchStandard;
	 private ArrayList<Integer> chartMaxs;
	 
	 public StrengthTableModel(boolean sex, Double userWeight) {
			this.sex = sex;
			this.userWeight = userWeight;
			this.overHeadPressStandard = new ArrayList<Integer>();
			this.deadliftStandard = new ArrayList<Integer>();
			this.benchStandard = new ArrayList<Integer>();
			this.squatStandard = new ArrayList<Integer>();
			this.chartMaxs = new ArrayList<Integer>();
			
			this.overHeadPressStandard = scrapeExercise("shoulder-press");
			this.deadliftStandard = scrapeExercise("deadlift");
			this.benchStandard = scrapeExercise("bench-press");
			this.squatStandard = scrapeExercise("squat");
			
			fillInTable(0, this.overHeadPressStandard);
			fillInTable(2, this.deadliftStandard);
			fillInTable(4, this.benchStandard);
			fillInTable(6, this.squatStandard);
			
	 };
	 
	String[] columnNames = {"Exercise", 
							"Bodyweight", 
							"Beginner", 
							"Novice", 
							"Intermediate",
							"Advanced",
							"Elite"};
	
	Object[][] data = {
			{"OverHead Press", "1", "2", "3", "4", "5", "6"},
			{" ", " ", " ", " ", " ", " ", " "},
			{"Deadlift", "1", "2", "3", "4", "5", "6"},
			{" ", " ", " ", " ", " ", " ", " "},
			{"Bench", "1", "2", "3", "4", "5", "6"},
			{" ", " ", " ", " ", " ", " ", " "},
			{"Squat ","1", "2", "3", "4", "5", "6"},
			
		};
	
public ArrayList<Integer> scrapeExercise(String url) {
		this.chartMaxs.clear();
		ArrayList<Integer> tempHolder = new ArrayList<Integer>();
		Document doc;
		try {
			doc = Jsoup.connect("https://strengthlevel.com/strength-standards/" + url).get();
			//System.out.print(doc);
			
			
			int weight = 0;
			weight = (int)(Math.rint((double) this.userWeight/10)* 10);

			//need to ask for male or female to use correct chart
			//this grabs male chart currently
			Elements content = doc.getElementsByClass("standards__table");
			//System.out.println("");
			//System.out.println(content.get(0));
			
			Element chart1;
			if(this.sex) {
				chart1 = content.get(0);
			}else {
				chart1 = content.get(1);
			}
			
			Elements tableRows = chart1.select("tr");
			
			Element rowWithWeightLimits = new Element("blah");
			
			ArrayList<Element> rowsArrayList = tableRows;
			//removing 1 row that has ALL in td that breaks program
			rowsArrayList.remove(rowsArrayList.size()-1);
			
			for (Element row : rowsArrayList) {
				//System.out.println("Line 43 row: " + row);
				if(row.selectFirst("td") != null) {
					String rowWeight = row.selectFirst("td").text();
					if(Integer.parseInt(rowWeight) == weight) {
						rowWithWeightLimits = row;
						System.out.println("Found match in weight");
					}
				}
			}
			
			Elements strengthLevels = rowWithWeightLimits.select("td");
			
			for (Element td : rowWithWeightLimits.getElementsByTag("td")) {
				String tdWeight = td.ownText();
				chartMaxs.add(Integer.parseInt(tdWeight));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int number : this.chartMaxs) {
			tempHolder.add(number);
		}
		
		
		
		return tempHolder;
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
