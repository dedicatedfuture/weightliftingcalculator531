package edu.psgv.sweng861;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import java.sql.Connection;

public class ClickListener implements ActionListener {
	
	private double oHPressMax;
	private double deadliftMax;
	private double benchMax;
	private double squatMax;
	private JTextField overHeadPressField;
	private JTextField deadliftField;
	private JTextField benchField;
	private JTextField squatField;
	private JFrame frame;

	public ClickListener(JTextField oHPressField, JTextField deadliftField, JTextField benchField, 
			JTextField squatField, JFrame frame) {
		super();
		this.overHeadPressField = oHPressField;
		this.deadliftField = deadliftField;
		this.benchField = benchField;
		this.squatField = squatField;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.oHPressMax = Double.parseDouble(overHeadPressField.getText());
		this.deadliftMax = Double.parseDouble(deadliftField.getText());
		this.benchMax = Double.parseDouble(benchField.getText());
		this.squatMax = Double.parseDouble(squatField.getText());
		
		this.frame.setPreferredSize(new Dimension(600,455));
		this.frame.getContentPane().removeAll();
		frame.repaint();
		
		createComponents(this.frame.getContentPane());
	}

	private void createComponents(Container container) {
		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(layout);
		
		 SwingTableExample newContentPane = new SwingTableExample(this.oHPressMax, this.deadliftMax, this.benchMax, this.squatMax, this.frame);
	     newContentPane.setOpaque(true); //content panes must be opaque
	     frame.setContentPane(newContentPane);
	 
	     //Display the window.
	     frame.pack();
	     frame.setVisible(true);
	}
}
 