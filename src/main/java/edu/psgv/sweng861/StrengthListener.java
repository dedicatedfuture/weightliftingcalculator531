package edu.psgv.sweng861;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StrengthListener implements ActionListener {
	
	//male = true, female = false
	private boolean sex;
	private Double userWeight;
	private JTextField userWeightField;
	private JRadioButton sexButton;
	
	JFrame frame;
	
	

	public StrengthListener(JRadioButton sex, JTextField userWeight, JFrame frame) {
		super();
		this.sexButton = sex;
		this.userWeightField = userWeight;
		this.frame = frame;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(this.sexButton.isSelected()) {
			this.sex = true;
		}else {
			this.sex = false;
		}
		
		this.userWeight = Double.parseDouble(this.userWeightField.getText());
		
		this.frame.getContentPane().removeAll();
		frame.repaint();
		
		createComponents(this.frame.getContentPane());

	}
	
	private void createComponents(Container container) {
		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(layout);
		
		 frame.setPreferredSize(new Dimension(700,250));
		
		 StrengthStandardTable newContentPane = new StrengthStandardTable(this.sex, this.userWeight, this.frame);
	     newContentPane.setOpaque(true); //content panes must be opaque
	     frame.setContentPane(newContentPane);
	 
	     //Display the window.
	     frame.pack();
	     frame.setVisible(true);
	}
	
	

}
