package edu.psgv.sweng861;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.*;

public class UserInterface implements Runnable {

	private JFrame frame;
	private WeightCalculator calculator;
	private double oHPressMax;
	private double deadliftMax;
	private double benchMax;
	private double squatMax;


	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.frame = new JFrame("5/3/1 Weight Lifting Calculator");
		this.frame.setPreferredSize(new Dimension(1000,500));
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createComponents(this.frame.getContentPane());
		
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
	
	private void createComponents(Container container) {
		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(layout);
		
		JLabel instructionsLabel = new JLabel("Enter your 1 rep max for each exercise.");
		JLabel overHeadPressLabel = new JLabel("Overhead Press: ");
		JLabel deadliftLabel = new JLabel("Deadlift: ");
		JLabel benchLabel = new JLabel("Bench Press: ");
		JLabel squatLabel = new JLabel("Squat: ");
		
		JTextField overHeadPressField = new JTextField();
		JTextField deadliftField = new JTextField();
		JTextField benchField = new JTextField();
		JTextField squatField = new JTextField();
		
		JButton calculate = new JButton ("Calculate");
		
		JPanel overHeadPressPanel = new JPanel();
		
				
		//creating interface for scraping feature
		container.add(instructionsLabel);
		container.add(overHeadPressLabel);
		container.add(overHeadPressField);
		
		container.add(overHeadPressPanel);
		container.add(deadliftLabel);
		container.add(deadliftField);
		container.add(benchLabel);
		container.add(benchField);
		container.add(squatLabel);
		container.add(squatField);
		container.add(calculate);
		
		JPanel strengthStandardsSection = new JPanel();
		
		JRadioButton maleButton = new JRadioButton("Male");
		JRadioButton femaleButton = new JRadioButton("Female");
		femaleButton.setSelected(true);
		
		 ButtonGroup sexButtons = new ButtonGroup();
		 sexButtons.add(maleButton);
		 sexButtons.add(femaleButton);
		 
		 JLabel userWeightLabel = new JLabel("Enter your weight: ");
		 JTextField userWeightField = new JTextField();
		 
		 JButton strengthStandardButton = new JButton("Find your Strength Standard");
		 
		 strengthStandardsSection.add(maleButton);
		 strengthStandardsSection.add(femaleButton);
		 strengthStandardsSection.add(userWeightLabel);
		 //strengthStandardsSection.add(userWeightField);
		 strengthStandardsSection.add(strengthStandardButton);
		 
		
		 container.add(userWeightLabel);
		 container.add(userWeightField);
		 container.add(strengthStandardsSection);
		
		
		
//		this.oHPressMax = Double.parseDouble(overHeadPressField.getText());
//		this.deadliftMax = Double.parseDouble(deadliftField.getText());
//		this.benchMax = Double.parseDouble(benchField.getText());
//		this.squatMax = Double.parseDouble(squatField.getText());  
		 
		
		 
		strengthStandardButton.addActionListener(new StrengthListener(maleButton, userWeightField, this.frame)); 
		
		calculate.addActionListener(new ClickListener(overHeadPressField, deadliftField, 
				benchField, squatField, this.frame));
		
	}
	
}


