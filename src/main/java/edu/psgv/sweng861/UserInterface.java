package edu.psgv.sweng861;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.*;

public class UserInterface implements Runnable {

	private JFrame frame;

	public UserInterface(JFrame frame2) {
		// TODO Auto-generated constructor stub
		this.frame = frame2;
	}


	public UserInterface() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void run() {
		if(this.frame != null) {
			this.frame.setTitle("5/3/1 Weight Lifting Calculator");
		}else {
			this.frame = new JFrame("5/3/1 Weight Lifting Calculator");
		}
		
		this.frame.setPreferredSize(new Dimension(280,500));
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createComponents(this.frame.getContentPane());
		
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
	
	private void createComponents(Container container) {
		//BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
		
		BorderLayout layout = new BorderLayout();
		
		//container.setLayout(layout);
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
		
		JPanel exercisePanel = new JPanel();
		BoxLayout exerciseLayout = new BoxLayout(exercisePanel, BoxLayout.Y_AXIS);
		exercisePanel.setLayout(exerciseLayout);
		
		exercisePanel.add(instructionsLabel);
		exercisePanel.add(overHeadPressLabel);
		exercisePanel.add(overHeadPressField);
		exercisePanel.add(deadliftLabel);
		exercisePanel.add(deadliftField);
		exercisePanel.add(benchLabel);
		exercisePanel.add(benchField);
		exercisePanel.add(squatLabel);
		exercisePanel.add(squatField);
		exercisePanel.add(calculate);
		
		container.add(exercisePanel, layout.CENTER);
		
		
		JPanel strengthStandardsSection = new JPanel();
		
		BoxLayout strengthStandardsLayout = new BoxLayout(strengthStandardsSection, BoxLayout.Y_AXIS);
		
		strengthStandardsSection.setLayout(strengthStandardsLayout);
		
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
		 strengthStandardsSection.add(userWeightField);
		 strengthStandardsSection.add(strengthStandardButton);
		 
		 container.add(strengthStandardsSection, layout.SOUTH);
		 
		 
		 //adding action listeners for the buttons
		strengthStandardButton.addActionListener(new StrengthListener(maleButton, userWeightField, this.frame)); 
		
		calculate.addActionListener(new ClickListener(overHeadPressField, deadliftField, 
				benchField, squatField, this.frame));
		
	}
	
}


