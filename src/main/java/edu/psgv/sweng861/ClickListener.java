package edu.psgv.sweng861;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;


public class ClickListener implements ActionListener {
	
	private double oHPressMax;
	private double deadliftMax;
	private double benchMax;
	private double squatMax;
	private ArrayList<Double> oHPressSet1;
	private WeightCalculator calculator;
	private JTextField overHeadPressField;
	private JFrame frame;
	
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD ="dbpassword";
	private static final String CONN = "jdbc:mysql://localhost/weightlifting531";
	

	public ClickListener(JTextField oHPressField, double deadliftMax, double benchMax, double squatMax, JFrame frame) {
		super();
		this.overHeadPressField = oHPressField;
		this.deadliftMax = deadliftMax;
		this.benchMax = benchMax;
		this.squatMax = squatMax;
		this.oHPressSet1 = new ArrayList<Double>();
		this.calculator = new WeightCalculator();
		this.frame = frame;
	}
	
	public ClickListener() {}
	
	



	@Override
	public void actionPerformed(ActionEvent e) {
		this.oHPressMax = Double.parseDouble(overHeadPressField.getText());
		this.oHPressSet1 = this.calculator.calcWeekOne(this.oHPressMax);
		
		this.frame.getContentPane().removeAll();
		frame.repaint();
		
		createComponents(this.frame.getContentPane());
		
		this.overHeadPressField.setText(oHPressSet1.get(1).toString());
		
		//trying to connect to Database here
		
		Connection con = null;
		
		try {
			
			con = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
			System.out.println("Connected to database! :)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Database connection failed");
			e1.printStackTrace();
		}
		finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	

	private void createComponents(Container container) {
		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(layout);
		
		 SwingTableExample newContentPane = new SwingTableExample();
	     newContentPane.setOpaque(true); //content panes must be opaque
	     frame.setContentPane(newContentPane);
	 
	     //Display the window.
	     frame.pack();
	     frame.setVisible(true);
		
//		JLabel instructionsLabel = new JLabel("This is your workout schedule for the month");
//		JLabel overHeadPressLabel = new JLabel("Overhead Press: ");
//		JLabel deadliftLabel = new JLabel("Deadlift: ");
//		JLabel benchLabel = new JLabel("Bench Press: ");
//		JLabel squatLabel = new JLabel("Squat: ");
//		
//		JTextField overHeadPressField = new JTextField();
//		JTextField deadliftField = new JTextField();
//		JTextField benchField = new JTextField();
//		JTextField squatField = new JTextField();
//		
//		JButton calculate = new JButton ("Calculate");
//		
//		
//		container.add(instructionsLabel);
//		container.add(overHeadPressLabel);
//		container.add(overHeadPressField);
//		container.add(deadliftLabel);
//		container.add(deadliftField);
//		container.add(benchLabel);
//		container.add(benchField);
//		container.add(squatLabel);
//		container.add(squatField);
//		container.add(calculate);
		

		
		
		
	}
	

}
 